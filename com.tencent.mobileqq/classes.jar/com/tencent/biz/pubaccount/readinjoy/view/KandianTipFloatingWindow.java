package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mgo;
import mqq.os.MqqHandler;

public class KandianTipFloatingWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private View jdField_a_of_type_AndroidViewView;
  protected Animation a;
  private KandianTipFloatingWindow.TipFloatingWindowInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public int a()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo.jdField_a_of_type_Int == 1)) {}
    switch (paramInt)
    {
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("KandianTipFloatingWindow", 2, "close tip window , type : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo.jdField_a_of_type_Int + ", uin : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo = null;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo != null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    a(2);
    KandianTipFloatingWindow.TipFloatingWindowInfo localTipFloatingWindowInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow$TipFloatingWindowInfo;
    if ((localTipFloatingWindowInfo != null) && (localTipFloatingWindowInfo.jdField_a_of_type_AndroidViewView$OnClickListener != null)) {
      ThreadManager.getUIHandler().postDelayed(new mgo(this, localTipFloatingWindowInfo, paramView), 250L);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KandianTipFloatingWindow
 * JD-Core Version:    0.7.0.1
 */