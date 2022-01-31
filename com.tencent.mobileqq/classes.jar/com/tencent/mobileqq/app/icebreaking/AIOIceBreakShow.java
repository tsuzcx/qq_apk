package com.tencent.mobileqq.app.icebreaking;

import aekt;
import aeqa;
import agnp;
import agtk;
import akwk;
import amfc;
import amfd;
import amfg;
import amfi;
import amfl;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import azmj;
import bhoe;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;

public class AIOIceBreakShow
  implements amfg, Handler.Callback
{
  private static int jdField_a_of_type_Int;
  private aeqa jdField_a_of_type_Aeqa;
  private amfi jdField_a_of_type_Amfi;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new amfd(this);
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new amfc(this);
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bhoe jdField_a_of_type_Bhoe;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private String jdField_a_of_type_JavaLangString;
  private List<agtk> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private bhoe jdField_b_of_type_Bhoe;
  private boolean jdField_b_of_type_Boolean;
  private int c = -1;
  
  public AIOIceBreakShow(BaseChatPie paramBaseChatPie, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Amfi = ((amfi)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285));
    this.jdField_a_of_type_Bhoe = new bhoe(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getLooper(), this);
    this.jdField_b_of_type_Bhoe = new bhoe(ThreadManager.getSubThreadLooper(), this);
    jdField_a_of_type_Int = aekt.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Aeqa = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aeqa;
  }
  
  private void a(int paramInt, String paramString)
  {
    this.jdField_b_of_type_Bhoe.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Bhoe.postDelayed(new AIOIceBreakShow.RemoveRunnable(this, paramInt, paramString), this.jdField_a_of_type_Amfi.jdField_a_of_type_Int * 1000L);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label43;
      }
    }
    label43:
    for (Object localObject = (ViewGroup)localObject;; localObject = null) {
      return ((ViewGroup)localObject).getId() == 2131362334;
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new AIOIceBreakShow.1(this, paramInt, paramString));
  }
  
  private void b(boolean paramBoolean)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("show needAnim: %s, mState: %s, mIceBreakType: %s, mIsAIOPanelOpen: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != -1)) {}
    while (this.c == -1) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        QLog.d("AIOIceBreakShow", 1, "rec mRecEmotionList is empty!");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOIceBreakShow", 2, "bind data pic urls: " + this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new AIOIceBreakView(this.jdField_a_of_type_AndroidContentContext);
      ((AIOIceBreakView)this.jdField_a_of_type_AndroidWidgetLinearLayout).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131362281, Integer.valueOf(this.c));
      ((AIOIceBreakView)this.jdField_a_of_type_AndroidWidgetLinearLayout).setOnIceImageClickListener(this);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = 1;
      return;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidAnimationValueAnimator != null))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      e();
    }
    akwk.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ice_break", true);
    c();
    this.jdField_b_of_type_Int = 0;
    Object localObject;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      }
      localObject = PropertyValuesHolder.ofInt("height", new int[] { 0, jdField_a_of_type_Int });
      PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 100 });
      this.jdField_a_of_type_Aeqa.a(3, 0);
      this.jdField_a_of_type_Aeqa.a(0, false, "icebreak_showFooter", 0);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder });
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      if (QLog.isColorLevel()) {
        QLog.d("AIOIceBreakShow", 2, "real show duration = " + this.jdField_a_of_type_Amfi.jdField_a_of_type_Int);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.c != 0) {
        break label606;
      }
    }
    for (;;)
    {
      azmj.b((QQAppInterface)localObject, "dc00898", "", "", "0X8009B95", "0X8009B95", i, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_Aeqa.a(3, jdField_a_of_type_Int);
      this.jdField_a_of_type_Aeqa.a(jdField_a_of_type_Int, false, "icebreak_showFooter", 0);
      break;
      label606:
      i = 2;
    }
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if ((localObject1 == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return;
    }
    localObject1 = ((ListView)localObject1).getChildAt(((ListView)localObject1).getLastVisiblePosition() - ((ListView)localObject1).getFirstVisiblePosition());
    int j = 0;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = new Rect();
      ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
      i = ((Rect)localObject2).bottom;
      if (((View)localObject1).getId() == 2131362334) {
        i = ((Rect)localObject2).top;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().findViewById(2131368333);
      localObject2 = new Rect();
      ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
      if (((Rect)localObject2).top - i > jdField_a_of_type_Int) {
        break label305;
      }
      i = 1;
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aeqa;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() != null)
      {
        if (!(a() ^ i))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AIOIceBreakShow", 2, "don't need to relocate");
          return;
          i = j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AIOIceBreakShow", 2, "locate itemView == null");
          i = j;
          continue;
        }
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject2).gravity = 81;
      if (i != 0)
      {
        ((aeqa)localObject1).a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (FrameLayout.LayoutParams)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(196608);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AIOIceBreakShow", 2, "locate to ListView");
        return;
      }
      ((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().findViewById(2131372225)).addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOIceBreakShow", 2, "locate to ContentView");
      return;
      label305:
      i = 0;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("hide needAnim: %s, mState: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    if (this.jdField_b_of_type_Int != 0) {
      return;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidAnimationValueAnimator != null))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      e();
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      }
      PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofInt("height", new int[] { jdField_a_of_type_Int, 0 });
      PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofInt("alpha", new int[] { 100, 0 });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2 });
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() != null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Aeqa.a(3, 0);
      this.jdField_a_of_type_Aeqa.a(0, false, "icebreak_showFooter", 0);
      if (a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(196608);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    this.jdField_b_of_type_Int = 1;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("remove mState: %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    if ((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 1)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() != null))
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_Aeqa.a(3, 0);
      this.jdField_a_of_type_Aeqa.a();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    this.jdField_b_of_type_Int = 2;
    akwk.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ice_break", false);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, "restore");
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.scrollTo(0, 0);
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_Int == 0) && (!this.jdField_b_of_type_Boolean)) {
      c();
    }
  }
  
  public void a(View paramView)
  {
    if (amfl.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove matchChat Ice show");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agnp)) {
        ((agnp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bs();
      }
      ThreadManager.getSubThreadHandler().post(new AIOIceBreakShow.4(this));
    }
  }
  
  public void a(List<agtk> paramList)
  {
    int i = this.jdField_a_of_type_Amfi.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("updateShow, newType = %s, oldType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.c) }));
    }
    if (i == this.c) {
      return;
    }
    if (i != -1)
    {
      if ((paramList == null) || (paramList.isEmpty()))
      {
        QLog.d("AIOIceBreakShow", 1, "update show but hotPicList is empty!");
        return;
      }
      this.c = i;
      this.jdField_a_of_type_JavaUtilList = paramList;
      paramList = this.jdField_a_of_type_Bhoe.obtainMessage(0, 1, 0);
      this.jdField_a_of_type_Bhoe.sendMessage(paramList);
      return;
    }
    this.c = i;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bhoe.sendEmptyMessage(2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOIceBreakShow", 2, String.format("onAIOPanelChanged isShow = %s, mIsAIOPanelOpen = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if ((this.jdField_a_of_type_Boolean ^ paramBoolean))
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!this.jdField_a_of_type_Boolean) {
        break label111;
      }
      if ((this.jdField_b_of_type_Int == 0) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Bhoe.removeMessages(0);
        this.jdField_a_of_type_Bhoe.removeMessages(1);
        localMessage = this.jdField_a_of_type_Bhoe.obtainMessage(1, 0, 0);
        this.jdField_a_of_type_Bhoe.sendMessage(localMessage);
      }
    }
    label111:
    while ((this.jdField_b_of_type_Int != 1) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Bhoe.removeMessages(0);
    this.jdField_a_of_type_Bhoe.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_Bhoe.obtainMessage(0, 0, 0);
    this.jdField_a_of_type_Bhoe.sendMessage(localMessage);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    d();
    this.jdField_a_of_type_Bhoe.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Bhoe.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, "show sprite (normal) onDestroy.");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      if (paramMessage.arg1 == 1)
      {
        b(true);
        return false;
      }
      b(false);
      return false;
    case 1: 
      if (paramMessage.arg1 == 1)
      {
        c(true);
        return false;
      }
      c(false);
      return false;
    }
    d();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.icebreaking.AIOIceBreakShow
 * JD-Core Version:    0.7.0.1
 */