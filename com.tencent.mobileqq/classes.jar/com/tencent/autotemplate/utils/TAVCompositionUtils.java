package com.tencent.autotemplate.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavsticker.model.TAVSticker;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class TAVCompositionUtils
{
  private static final String[] COLORS = { "#7A46FF", "#FF00B7", "#FF4273", "#FE9526", "#FFDC00", "#2FA0FF", "#00DADC" };
  public static int TEXT_SIZE;
  public static int WIDTH = 4000;
  private static String lastColor;
  
  static
  {
    TEXT_SIZE = 50;
  }
  
  public static CMTime calculateTotalTime(TAVComposition paramTAVComposition)
  {
    Object localObject1 = paramTAVComposition.getVideoChannels();
    paramTAVComposition = CMTime.CMTimeZero;
    Iterator localIterator = ((List)localObject1).iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (List)localIterator.next();
      localObject1 = CMTime.CMTimeZero;
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localObject1 = ((CMTime)localObject1).add(((TAVClip)((Iterator)localObject2).next()).getResource().getScaledDuration());
      }
      if (!((CMTime)localObject1).bigThan(paramTAVComposition)) {
        break label96;
      }
      paramTAVComposition = (TAVComposition)localObject1;
    }
    label96:
    for (;;)
    {
      break;
      return paramTAVComposition;
    }
  }
  
  private static Bitmap draw(TAVComposition paramTAVComposition, long paramLong)
  {
    int m = (int)(WIDTH * 0.9F);
    int n = (WIDTH - m) / 2;
    Object localObject1 = paramTAVComposition.getVideoChannels();
    int i1 = ((List)localObject1).size();
    paramTAVComposition = getStickers(paramTAVComposition);
    if ((paramTAVComposition != null) && (!paramTAVComposition.isEmpty())) {}
    for (int i = paramTAVComposition.size();; i = 0)
    {
      int j = (int)((i1 + i + 2) * 150 * 1.5F);
      Bitmap localBitmap = Bitmap.createBitmap(WIDTH, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint1 = new Paint();
      Paint localPaint2 = new Paint();
      localPaint2.setAntiAlias(true);
      localPaint2.setColor(-16777216);
      localPaint2.setTextSize(TEXT_SIZE);
      localPaint2.setTextAlign(Paint.Align.CENTER);
      j = 0;
      Object localObject2;
      long l1;
      int k;
      long l2;
      int i2;
      int i3;
      while (j < ((List)localObject1).size())
      {
        localObject2 = (List)((List)localObject1).get(j);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          l1 = 0L;
          k = 0;
          if (k < ((List)localObject2).size())
          {
            TAVClip localTAVClip = (TAVClip)((List)localObject2).get(k);
            l2 = localTAVClip.getResource().getScaledDuration().getTimeUs() / 1000L;
            i2 = (int)((float)l1 / (float)paramLong * m) + n;
            i3 = j * 150;
            int i4 = (int)((float)l2 / (float)paramLong * m);
            localPaint1.setColor(getRandomColor());
            localCanvas.drawRect(new Rect(i2, i3, i2 + i4, i3 + 100), localPaint1);
            if ((localTAVClip.getResource() instanceof TAVEmptyResource)) {
              localCanvas.drawText("E" + l2, i2 + i4 / 2, i3 + 50, localPaint2);
            }
            for (;;)
            {
              l1 += l2;
              k += 1;
              break;
              localCanvas.drawText(String.valueOf(l2), i2 + i4 / 2, i3 + 50, localPaint2);
            }
          }
        }
        j += 1;
      }
      if (i > 0)
      {
        localPaint1.setColor(getRandomColor());
        localCanvas.drawRect(new Rect(0, i1 * 150, WIDTH, i1 * 150 + 10), localPaint1);
        j = 0;
        while (j < i)
        {
          localObject1 = (TAVSticker)paramTAVComposition.get(j);
          localObject2 = ((TAVSticker)localObject1).getTimeRange();
          l1 = ((CMTimeRange)localObject2).getStart().getTimeUs() / 1000L;
          l2 = ((CMTimeRange)localObject2).getDuration().getTimeUs() / 1000L;
          k = (int)((float)l1 / (float)paramLong * m) + n;
          i2 = (i1 + 1 + j) * 150;
          i3 = (int)((float)l2 / (float)paramLong * m);
          localPaint1.setColor(getRandomColor());
          localCanvas.drawRect(new Rect(k, i2, k + i3, i2 + 100), localPaint1);
          localPaint1.setColor(getRandomColor());
          localCanvas.drawRect(new Rect(k - 2, 0, k, i2), localPaint1);
          localPaint1.setColor(getRandomColor());
          localCanvas.drawRect(new Rect(k + i3, 0, k + i3 + 2, i2), localPaint1);
          localCanvas.drawText(getStickerName(((TAVSticker)localObject1).getFilePath()), k + i3 / 2, i2 + 50, localPaint2);
          j += 1;
        }
      }
      return localBitmap;
    }
  }
  
  private static int getRandomColor()
  {
    int i = COLORS.length;
    for (String str = COLORS[RandomUtil.RandomInt(0, i)]; lastColor == str; str = COLORS[RandomUtil.RandomInt(0, i)]) {}
    lastColor = str;
    return Color.parseColor(str);
  }
  
  private static String getStickerName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf(File.separator);
    } while (i + 1 >= paramString.length());
    return paramString.substring(i + 1);
  }
  
  private static List<TAVSticker> getStickers(TAVComposition paramTAVComposition)
  {
    paramTAVComposition = paramTAVComposition.getVideoMixEffect();
    if ((paramTAVComposition instanceof TAVOneClickFilmStickerEffect))
    {
      List localList = ((TAVOneClickFilmStickerEffect)paramTAVComposition).getStickerContext().getStickers();
      paramTAVComposition = localList;
      if (localList.isEmpty()) {
        paramTAVComposition = null;
      }
      return paramTAVComposition;
    }
    return null;
  }
  
  public static Bitmap showProfile(TAVComposition paramTAVComposition)
  {
    if (paramTAVComposition == null) {}
    while (paramTAVComposition.getVideoChannels().isEmpty()) {
      return null;
    }
    return draw(paramTAVComposition, calculateTotalTime(paramTAVComposition).getTimeUs() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.utils.TAVCompositionUtils
 * JD-Core Version:    0.7.0.1
 */