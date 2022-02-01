package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.util.Log;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.lottie.LottieAnimationViewInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;

class LottieView$5$1
  implements Runnable
{
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a.setComposition(this.jdField_a_of_type_ComTencentFalcoBaseLibapiLottieLottieCompositionInterface);
      if (!this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a.isShown())
      {
        LogInterface localLogInterface = LottieView.access$400(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a).getLogger();
        String str = LottieView.access$200(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("play LottieView.this.isShown() ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a.isShown());
        localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
        localLogInterface = LottieView.access$400(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a).getLogger();
        str = LottieView.access$200(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play LottieView.this.getParent() ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a.getParent());
        localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
        this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a.setVisibility(0);
        localLogInterface = LottieView.access$400(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a).getLogger();
        str = LottieView.access$200(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play after visible LottieView.this.isShown() ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a.isShown());
        localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
        localLogInterface = LottieView.access$400(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a).getLogger();
        str = LottieView.access$200(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play LottieView.this.getParent() ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a.getParent());
        localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
      }
      LottieView.access$900(this.jdField_a_of_type_ComTencentIliveUicomponentLuxurygiftcomponentDatastructShowviewLottieView$5.a).playAnimation();
      return;
    }
    catch (Exception localException)
    {
      Log.getStackTraceString(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.LottieView.5.1
 * JD-Core Version:    0.7.0.1
 */