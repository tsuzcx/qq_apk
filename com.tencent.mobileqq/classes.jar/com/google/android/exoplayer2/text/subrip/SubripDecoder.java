package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SubripDecoder
  extends SimpleSubtitleDecoder
{
  private static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+),(\\d+)";
  private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
  private static final String TAG = "SubripDecoder";
  private final StringBuilder textBuilder = new StringBuilder();
  
  public SubripDecoder()
  {
    super("SubripDecoder");
  }
  
  private static long parseTimecode(Matcher paramMatcher, int paramInt)
  {
    return (Long.parseLong(paramMatcher.group(paramInt + 1)) * 60L * 60L * 1000L + Long.parseLong(paramMatcher.group(paramInt + 2)) * 60L * 1000L + Long.parseLong(paramMatcher.group(paramInt + 3)) * 1000L + Long.parseLong(paramMatcher.group(paramInt + 4))) * 1000L;
  }
  
  protected SubripSubtitle decode(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    LongArray localLongArray = new LongArray();
    paramArrayOfByte = new ParsableByteArray(paramArrayOfByte, paramInt);
    for (;;)
    {
      String str = paramArrayOfByte.readLine();
      if ((str == null) || (str.length() != 0)) {}
      try
      {
        Integer.parseInt(str);
        str = paramArrayOfByte.readLine();
        if (str == null)
        {
          Log.w("SubripDecoder", "Unexpected end");
          break;
        }
        localObject = SUBRIP_TIMING_LINE.matcher(str);
        if (((Matcher)localObject).matches())
        {
          paramInt = 1;
          localLongArray.add(parseTimecode((Matcher)localObject, 1));
          if (!TextUtils.isEmpty(((Matcher)localObject).group(6))) {
            localLongArray.add(parseTimecode((Matcher)localObject, 6));
          } else {
            paramInt = 0;
          }
          this.textBuilder.setLength(0);
          for (;;)
          {
            str = paramArrayOfByte.readLine();
            if (TextUtils.isEmpty(str)) {
              break;
            }
            if (this.textBuilder.length() > 0) {
              this.textBuilder.append("<br>");
            }
            this.textBuilder.append(str.trim());
          }
          localArrayList.add(new Cue(Html.fromHtml(this.textBuilder.toString())));
          if (paramInt == 0) {
            continue;
          }
          localArrayList.add(null);
          continue;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Skipping invalid timing: ");
        ((StringBuilder)localObject).append(str);
        Log.w("SubripDecoder", ((StringBuilder)localObject).toString());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject;
        label273:
        break label273;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Skipping invalid index: ");
      ((StringBuilder)localObject).append(str);
      Log.w("SubripDecoder", ((StringBuilder)localObject).toString());
    }
    paramArrayOfByte = new Cue[localArrayList.size()];
    localArrayList.toArray(paramArrayOfByte);
    return new SubripSubtitle(paramArrayOfByte, localLongArray.toArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.subrip.SubripDecoder
 * JD-Core Version:    0.7.0.1
 */