package com.tencent.mobileqq.activity.aio.qwallet.elem;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;

public class VipRedPkgElem
  extends BaseRedPkgElem
{
  public Bitmap a;
  public CustomizeStrategyFactory.AnimConfig a;
  public boolean a;
  public Drawable[] a;
  
  public VipRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap;
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramRedPacketInfo.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig = paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig;
      this.jdField_a_of_type_Boolean = paramRedPacketInfo.b;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) || (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.elem.VipRedPkgElem
 * JD-Core Version:    0.7.0.1
 */