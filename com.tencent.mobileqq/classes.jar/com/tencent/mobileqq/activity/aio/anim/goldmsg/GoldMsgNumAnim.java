package com.tencent.mobileqq.activity.aio.anim.goldmsg;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.GoldMsgPttItemBuilder.GoldMsgPttHolder;
import com.tencent.mobileqq.activity.aio.item.GoldMsgTextItemBuilder.GoldMsgTextHolder;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim.AnimListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import upa;
import upb;
import upc;
import upd;
import upe;

public class GoldMsgNumAnim
  extends BaseGoldMsgAnimator
{
  long jdField_a_of_type_Long;
  View jdField_a_of_type_AndroidViewView;
  AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  GoldAnimationView jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldAnimationView;
  NumAnim.AnimListener jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetNumAnim$AnimListener = new upe(this);
  NumAnim jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetNumAnim;
  public Runnable a;
  public List a;
  public int b;
  long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  public TextView b;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  public int c;
  boolean c;
  public int d;
  public int e = 500;
  public int f = 500;
  private int g = 250;
  private int h = this.g * 6;
  private int i = 5000;
  
  public GoldMsgNumAnim(int paramInt, GoldMsgAnimatorCtr paramGoldMsgAnimatorCtr, RelativeLayout paramRelativeLayout)
  {
    super(paramInt, paramGoldMsgAnimatorCtr, paramRelativeLayout);
    this.jdField_c_of_type_Int = 4;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidViewView = paramRelativeLayout.findViewById(2131372514);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldAnimationView = ((GoldAnimationView)paramRelativeLayout.findViewById(2131372513));
    this.jdField_b_of_type_AndroidViewView = paramRelativeLayout.findViewById(2131372510);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramRelativeLayout.findViewById(2131372512));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramRelativeLayout.findViewById(2131372515));
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(false);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(new ScaleAnimation(1.0F, 1.4F, 1.0F, 1.4F, 1, 0.5F, 1, 0.5F));
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.0F));
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(this.g);
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    paramInt = (int)(f1 * 23.0F + 0.5F);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetNumAnim = new NumAnim(this.jdField_a_of_type_AndroidWidgetTextView, paramInt, paramInt, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetNumAnim.setRuler(new upa(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetNumAnim.setAnimListener(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetNumAnim$AnimListener);
    this.d = ((int)(f1 * 23.0F + 0.5F));
    this.jdField_b_of_type_Int = ((int)(f1 * 3.0F + 0.5F));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldAnimationView.a(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.d, this.e, 180.0F);
    this.jdField_a_of_type_JavaLangRunnable = new upb(this);
    this.jdField_b_of_type_JavaLangRunnable = new upc(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.jdField_a_of_type_Long <= 3L) {}
    for (long l = this.g * this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.jdField_a_of_type_Long;; l = this.h)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetNumAnim.start(this.jdField_a_of_type_Long / 100.0D, this.jdField_b_of_type_Long / 100.0D, l);
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldAnimationView.a();
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
      }
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("GoldMsgNumAnim", 4, "end...");
    }
    super.a();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      if (localPair.first != null)
      {
        ((ImageView)localPair.first).clearAnimation();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localPair.first);
      }
      if (localPair.second != null)
      {
        ((AnimatorSet)localPair.second).removeAllListeners();
        ((AnimatorSet)localPair.second).cancel();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldAnimationView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldAnimationView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldAnimationView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetNumAnim != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetNumAnim.stop();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("animType", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.a(1, (Bundle)localObject);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle == null)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.i);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.jdField_b_of_type_Long > this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.jdField_b_of_type_Long;
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.jdField_b_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.jdField_a_of_type_Long);
    }
    long l = paramBundle.getLong("messageId", -1L);
    if (QLog.isDevelopLevel()) {
      QLog.d("GoldMsgNumAnim", 4, "start msgUniseq=" + l + ",bShowTips=" + this.jdField_c_of_type_Boolean + ",args=" + paramBundle);
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.a(l);
    Object localObject2 = new int[2];
    Object localObject1;
    int i2;
    int i1;
    int n;
    int m;
    int k;
    int j;
    float f2;
    float f1;
    if (paramBundle != null) {
      if ((paramBundle instanceof GoldMsgTextItemBuilder.GoldMsgTextHolder))
      {
        paramBundle = (GoldMsgTextItemBuilder.GoldMsgTextHolder)paramBundle;
        localObject1 = paramBundle.jdField_a_of_type_AndroidWidgetLinearLayout;
        paramBundle = paramBundle.jdField_a_of_type_AndroidWidgetTextView;
        if ((localObject1 == null) || (paramBundle == null)) {
          break label629;
        }
        ((View)localObject1).getLocationOnScreen((int[])localObject2);
        i2 = localObject2[0];
        i1 = localObject2[1];
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocationOnScreen((int[])localObject2);
        n = localObject2[0];
        m = localObject2[1];
        k = paramBundle.getLeft();
        j = paramBundle.getTop();
        f2 = i2 - n + k;
        f1 = i1 - m + j;
      }
    }
    for (;;)
    {
      QLog.d("GoldMsgNumAnim", 2, "start startX=" + f2 + ",startY=" + f1 + ",barX=" + i2 + ",barY=" + i1 + ",rootX=" + n + ",rootY=" + m + ",goldMsgViewLeft=" + k + ",goldMsgViewTop=" + j);
      if ((f2 != -1.0F) && (f1 != -1.0F))
      {
        paramBundle = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramBundle.setImageResource(2130844104);
        localObject1 = new RelativeLayout.LayoutParams(GoldMsgChatHelper.a, GoldMsgChatHelper.a);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
        localObject2 = ObjectAnimator.ofFloat(paramBundle, "translationX", new float[] { f2, this.jdField_a_of_type_AndroidViewView.getX() });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramBundle, "translationY", new float[] { f1, this.jdField_a_of_type_AndroidViewView.getY() });
        localObject1 = new AnimatorSet();
        ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObjectAnimator });
        ((AnimatorSet)localObject1).setDuration(this.f);
        paramBundle = new Pair(paramBundle, localObject1);
        this.jdField_a_of_type_JavaUtilList.add(paramBundle);
        ((AnimatorSet)localObject1).addListener(new upd(this, paramBundle));
        ((AnimatorSet)localObject1).start();
        return;
        if ((paramBundle instanceof GoldMsgPttItemBuilder.GoldMsgPttHolder))
        {
          paramBundle = (GoldMsgPttItemBuilder.GoldMsgPttHolder)paramBundle;
          localObject1 = paramBundle.b;
          paramBundle = paramBundle.jdField_a_of_type_AndroidWidgetTextView;
          break;
        }
        localObject1 = paramBundle.a.findViewById(2131362400);
        paramBundle = (TextView)paramBundle.a.findViewById(2131362397);
        break;
      }
      c();
      return;
      label629:
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      f1 = -1.0F;
      f2 = -1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgNumAnim
 * JD-Core Version:    0.7.0.1
 */