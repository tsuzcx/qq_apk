package com.tencent.luggage.wxa.ah;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.luggage.wxa.ao.h;
import com.tencent.luggage.wxa.ao.m;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.luggage.wxa.ad.b
{
  private static final Pattern a = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
  private final StringBuilder b = new StringBuilder();
  
  public a()
  {
    super("SubripDecoder");
  }
  
  private static long a(Matcher paramMatcher, int paramInt)
  {
    return (Long.parseLong(paramMatcher.group(paramInt + 1)) * 60L * 60L * 1000L + Long.parseLong(paramMatcher.group(paramInt + 2)) * 60L * 1000L + Long.parseLong(paramMatcher.group(paramInt + 3)) * 1000L + Long.parseLong(paramMatcher.group(paramInt + 4))) * 1000L;
  }
  
  protected b b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    h localh = new h();
    paramArrayOfByte = new m(paramArrayOfByte, paramInt);
    for (;;)
    {
      String str = paramArrayOfByte.y();
      if ((str == null) || (str.length() != 0)) {}
      try
      {
        Integer.parseInt(str);
        str = paramArrayOfByte.y();
        if (str == null)
        {
          Log.w("SubripDecoder", "Unexpected end");
          break;
        }
        localObject = a.matcher(str);
        if (((Matcher)localObject).matches())
        {
          paramInt = 1;
          localh.a(a((Matcher)localObject, 1));
          if (!TextUtils.isEmpty(((Matcher)localObject).group(6))) {
            localh.a(a((Matcher)localObject, 6));
          } else {
            paramInt = 0;
          }
          this.b.setLength(0);
          for (;;)
          {
            str = paramArrayOfByte.y();
            if (TextUtils.isEmpty(str)) {
              break;
            }
            if (this.b.length() > 0) {
              this.b.append("<br>");
            }
            this.b.append(str.trim());
          }
          localArrayList.add(new com.tencent.luggage.wxa.ad.a(Html.fromHtml(this.b.toString())));
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
    paramArrayOfByte = new com.tencent.luggage.wxa.ad.a[localArrayList.size()];
    localArrayList.toArray(paramArrayOfByte);
    return new b(paramArrayOfByte, localh.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ah.a
 * JD-Core Version:    0.7.0.1
 */