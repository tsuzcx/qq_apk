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
  double jdField_a_of_type_Double;
  DiyPendantFetcher jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher = DiyPendantFetcher.a();
  String jdField_a_of_type_JavaLangString;
  List<DiyPendantDrawable.Sticker> jdField_a_of_type_JavaUtilList;
  Paint b = new Paint();
  int c;
  int d;
  
  public DiyPendantDrawable(Resources paramResources)
  {
    super(paramResources);
  }
  
  public List<DiyPendantDrawable.Sticker> a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localList = this.jdField_a_of_type_JavaUtilList;
        return localList;
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.a(this);
      if ((localList != null) && (!localList.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        int i = 0;
        while (i < localList.size())
        {
          DiyPendantSticker localDiyPendantSticker = (DiyPendantSticker)localList.get(i);
          int j;
          try
          {
            j = Color.parseColor(localDiyPendantSticker.fontColor);
          }
          catch (Exception localException)
          {
            QLog.e("DiyPendantDrawable", 1, new Object[] { "parse sticker text color failed.", localException.getMessage() });
            j = -16777216;
          }
          this.jdField_a_of_type_JavaUtilList.add(new DiyPendantDrawable.DiyAddonSticker(this, i, localDiyPendantSticker.angle, localDiyPendantSticker.text, localDiyPendantSticker.fontId, localDiyPendantSticker.fontType, j));
          i += 1;
        }
        localList = this.jdField_a_of_type_JavaUtilList;
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
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Object localObject = a();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DiyPendantDrawable.Sticker)((Iterator)localObject).next()).a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int i = paramRect.width();
    this.c = Math.abs(paramRect.height() - i);
    double d1 = i;
    Double.isNaN(d1);
    this.jdField_a_of_type_Double = (d1 / 250.0D);
    this.d = ((int)(this.jdField_a_of_type_Double * 100.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantDrawable
 * JD-Core Version:    0.7.0.1
 */