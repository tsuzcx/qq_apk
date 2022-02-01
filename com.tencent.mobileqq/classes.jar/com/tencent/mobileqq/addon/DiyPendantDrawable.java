package com.tencent.mobileqq.addon;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiyPendantDrawable
  extends VipPendantDrawable
  implements DiyPendantFetcher.Invalidatable
{
  String h;
  int i;
  int j;
  double k;
  DiyPendantFetcher l = DiyPendantFetcher.a();
  List<DiyPendantDrawable.Sticker> m;
  Paint n = new Paint();
  
  public DiyPendantDrawable(Resources paramResources)
  {
    super(paramResources);
  }
  
  public List<DiyPendantDrawable.Sticker> b()
  {
    try
    {
      if (this.m != null)
      {
        localList = this.m;
        return localList;
      }
      List localList = this.l.a(this);
      if ((localList != null) && (!localList.isEmpty()))
      {
        this.m = new ArrayList();
        int i1 = 0;
        while (i1 < localList.size())
        {
          DiyPendantSticker localDiyPendantSticker = (DiyPendantSticker)localList.get(i1);
          int i2;
          try
          {
            i2 = Color.parseColor(localDiyPendantSticker.fontColor);
          }
          catch (Exception localException)
          {
            QLog.e("DiyPendantDrawable", 1, new Object[] { "parse sticker text color failed.", localException.getMessage() });
            i2 = -16777216;
          }
          this.m.add(new DiyPendantDrawable.DiyAddonSticker(this, i1, localDiyPendantSticker.angle, localDiyPendantSticker.text, localDiyPendantSticker.fontId, localDiyPendantSticker.fontType, i2));
          i1 += 1;
        }
        localList = this.m;
        return localList;
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Object localObject = b();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DiyPendantDrawable.Sticker)((Iterator)localObject).next()).a(paramCanvas, this.c);
      }
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int i1 = paramRect.width();
    this.i = Math.abs(paramRect.height() - i1);
    double d = i1;
    Double.isNaN(d);
    this.k = (d / 250.0D);
    this.j = ((int)(this.k * 100.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantDrawable
 * JD-Core Version:    0.7.0.1
 */