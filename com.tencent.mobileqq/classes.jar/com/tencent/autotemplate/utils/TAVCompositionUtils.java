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
  public static int TEXT_SIZE = 50;
  public static int WIDTH = 4000;
  private static String lastColor;
  
  public static CMTime calculateTotalTime(TAVComposition paramTAVComposition)
  {
    paramTAVComposition = paramTAVComposition.getVideoChannels();
    Object localObject1 = CMTime.CMTimeZero;
    Iterator localIterator = paramTAVComposition.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (List)localIterator.next();
      paramTAVComposition = CMTime.CMTimeZero;
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramTAVComposition = paramTAVComposition.add(((TAVClip)((Iterator)localObject2).next()).getResource().getScaledDuration());
      }
      if (paramTAVComposition.bigThan((CMTime)localObject1)) {
        localObject1 = paramTAVComposition;
      }
    }
    return localObject1;
  }
  
  private static Bitmap draw(TAVComposition paramTAVComposition, long paramLong)
  {
    int i = WIDTH;
    int j = (int)(i * 0.9F);
    int k = (i - j) / 2;
    Object localObject1 = paramTAVComposition.getVideoChannels();
    int i1 = ((List)localObject1).size();
    List localList = getStickers(paramTAVComposition);
    if ((localList != null) && (!localList.isEmpty())) {
      i = localList.size();
    } else {
      i = 0;
    }
    int m = (int)((i1 + i + 2) * 150 * 1.5F);
    paramTAVComposition = Bitmap.createBitmap(WIDTH, m, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTAVComposition);
    Paint localPaint1 = new Paint();
    Paint localPaint2 = new Paint();
    localPaint2.setAntiAlias(true);
    localPaint2.setColor(-16777216);
    localPaint2.setTextSize(TEXT_SIZE);
    localPaint2.setTextAlign(Paint.Align.CENTER);
    int n = 0;
    m = i;
    i = i1;
    Object localObject2;
    long l1;
    long l2;
    float f2;
    float f1;
    float f3;
    int i2;
    int i3;
    int i4;
    while (n < ((List)localObject1).size())
    {
      localObject2 = (List)((List)localObject1).get(n);
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        i1 = 0;
        l1 = 0L;
        while (i1 < ((List)localObject2).size())
        {
          Object localObject3 = (TAVClip)((List)localObject2).get(i1);
          l2 = ((TAVClip)localObject3).getResource().getScaledDuration().getTimeUs() / 1000L;
          f2 = (float)l1;
          f1 = (float)paramLong;
          f2 /= f1;
          f3 = j;
          i2 = (int)(f2 * f3) + k;
          i3 = n * 150;
          i4 = (int)((float)l2 / f1 * f3);
          localPaint1.setColor(getRandomColor());
          localCanvas.drawRect(new Rect(i2, i3, i2 + i4, i3 + 100), localPaint1);
          if ((((TAVClip)localObject3).getResource() instanceof TAVEmptyResource))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("E");
            ((StringBuilder)localObject3).append(l2);
            localCanvas.drawText(((StringBuilder)localObject3).toString(), i2 + i4 / 2, i3 + 50, localPaint2);
          }
          else
          {
            localCanvas.drawText(String.valueOf(l2), i2 + i4 / 2, i3 + 50, localPaint2);
          }
          l1 += l2;
          i1 += 1;
        }
        i1 = k;
        i2 = j;
        k = i;
        j = i1;
        i = i2;
      }
      else
      {
        i1 = i;
        i = j;
        j = k;
        k = i1;
      }
      n += 1;
      i1 = m;
      m = k;
      k = j;
      j = i;
      i = m;
      m = i1;
    }
    if (m > 0)
    {
      localPaint1.setColor(getRandomColor());
      n = i * 150;
      localCanvas.drawRect(new Rect(0, n, WIDTH, n + 10), localPaint1);
      n = 0;
      while (n < m)
      {
        localObject1 = (TAVSticker)localList.get(n);
        localObject2 = ((TAVSticker)localObject1).getTimeRange();
        l1 = ((CMTimeRange)localObject2).getStart().getTimeUs() / 1000L;
        l2 = ((CMTimeRange)localObject2).getDuration().getTimeUs() / 1000L;
        f2 = (float)l1;
        f1 = (float)paramLong;
        f2 /= f1;
        f3 = j;
        i1 = (int)(f2 * f3) + k;
        i2 = (i + 1 + n) * 150;
        i3 = (int)((float)l2 / f1 * f3);
        localPaint1.setColor(getRandomColor());
        i4 = i1 + i3;
        localCanvas.drawRect(new Rect(i1, i2, i4, i2 + 100), localPaint1);
        localPaint1.setColor(getRandomColor());
        localCanvas.drawRect(new Rect(i1 - 2, 0, i1, i2), localPaint1);
        localPaint1.setColor(getRandomColor());
        localCanvas.drawRect(new Rect(i4, 0, i4 + 2, i2), localPaint1);
        localObject1 = getStickerName(((TAVSticker)localObject1).getFilePath());
        if (localObject1 == null) {
          localObject1 = String.valueOf(n);
        }
        localCanvas.drawText((String)localObject1, i1 + i3 / 2, i2 + 50, localPaint2);
        n += 1;
      }
    }
    return paramTAVComposition;
  }
  
  private static int getRandomColor()
  {
    Object localObject = COLORS;
    int i = localObject.length;
    for (localObject = localObject[RandomUtil.RandomInt(0, i)]; lastColor == localObject; localObject = COLORS[RandomUtil.RandomInt(0, i)]) {}
    lastColor = (String)localObject;
    return Color.parseColor((String)localObject);
  }
  
  private static String getStickerName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.lastIndexOf(File.separator) + 1;
    if (i < paramString.length()) {
      return paramString.substring(i);
    }
    return null;
  }
  
  private static List<TAVSticker> getStickers(TAVComposition paramTAVComposition)
  {
    paramTAVComposition = paramTAVComposition.getVideoMixEffect();
    if ((paramTAVComposition instanceof TAVOneClickFilmStickerEffect))
    {
      paramTAVComposition = ((TAVOneClickFilmStickerEffect)paramTAVComposition).getStickerContext().getStickers();
      if (paramTAVComposition.isEmpty()) {
        return null;
      }
      return paramTAVComposition;
    }
    return null;
  }
  
  public static Bitmap showProfile(TAVComposition paramTAVComposition)
  {
    if (paramTAVComposition == null) {
      return null;
    }
    if (paramTAVComposition.getVideoChannels().isEmpty()) {
      return null;
    }
    return draw(paramTAVComposition, calculateTotalTime(paramTAVComposition).getTimeUs() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.utils.TAVCompositionUtils
 * JD-Core Version:    0.7.0.1
 */