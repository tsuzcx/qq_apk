package com.tencent.mobileqq.activity.aio.qwallet.elem;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class ThemeRedPkgElem
  extends BaseRedPkgElem
{
  public Bitmap a;
  public AnimationView.AnimationInfo a;
  
  public ThemeRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramRedPacketInfo.background;
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = paramRedPacketInfo.animInfo;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.elem.ThemeRedPkgElem
 * JD-Core Version:    0.7.0.1
 */