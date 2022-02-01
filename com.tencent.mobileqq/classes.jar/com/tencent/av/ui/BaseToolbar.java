package com.tencent.av.ui;

import afur;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import bgtn;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.utils.AVColorStateList;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import ley;
import maf;
import mbk;
import mbl;
import mgm;
import mtr;

public abstract class BaseToolbar
{
  public final String TAG = "EffectSettingUi." + getClass().getSimpleName();
  public WeakReference<AVActivity> mActivity;
  public VideoAppInterface mApp;
  protected Button mEffectBtn;
  RedTouch mEffectBtnRedTouch = null;
  private boolean mIsCreated;
  protected View toolbarView;
  
  public BaseToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    this.mApp = paramVideoAppInterface;
    this.mActivity = new WeakReference(paramAVActivity);
  }
  
  private static Button CreateImageButton(LinearLayout paramLinearLayout, int paramInt, mbl parammbl)
  {
    if ((paramLinearLayout == null) || (parammbl == null)) {
      return null;
    }
    Button localButton = new Button(paramLinearLayout.getContext());
    Object localObject = paramLinearLayout.getResources();
    int i = (int)((Resources)localObject).getDimension(2131297634);
    localButton.setId(paramInt);
    localButton.setGravity(17);
    localButton.setSingleLine();
    localButton.setContentDescription(parammbl.jdField_a_of_type_JavaLangString);
    localButton.setBackgroundDrawable(null);
    localButton.setCompoundDrawablePadding(afur.a(5.0F, (Resources)localObject));
    localButton.setText(parammbl.jdField_a_of_type_JavaLangString);
    localButton.setTextSize(bgtn.e(afur.a(12.0F, (Resources)localObject)));
    parammbl = parammbl.jdField_a_of_type_JavaLangString;
    localObject = localButton.getPaint();
    if ((localObject != null) && (!TextUtils.isEmpty(parammbl)))
    {
      paramInt = (int)(((TextPaint)localObject).measureText(parammbl) + 0.5F);
      if (QLog.isColorLevel()) {
        QLog.i("", 2, "CreateImageButton textWidth[" + paramInt + "], btn_width[" + i + "]");
      }
      if (i >= paramInt) {}
    }
    for (;;)
    {
      parammbl = new LinearLayout.LayoutParams(paramInt, -2);
      parammbl.weight = 1.0F;
      localButton.setLayoutParams(parammbl);
      paramLinearLayout.addView(localButton);
      return localButton;
      paramInt = i;
    }
  }
  
  private void changImageButtonStyle(Button paramButton, int paramInt1, int paramInt2)
  {
    if (paramButton == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "changButtonStyle button is null");
      }
    }
    while (paramInt1 == 0) {
      return;
    }
    Object localObject = paramButton.getResources();
    int i = (int)((Resources)localObject).getDimension(2131297630);
    if (paramInt2 > 0) {}
    for (localObject = mtr.a((Resources)localObject, paramInt1, paramInt2);; localObject = ((Resources)localObject).getDrawable(paramInt1))
    {
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramButton.setCompoundDrawables(null, (Drawable)localObject, null, null);
      return;
    }
  }
  
  public static BaseToolbar createToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, Class<? extends BaseToolbar> paramClass)
  {
    try
    {
      paramVideoAppInterface = (BaseToolbar)paramClass.getConstructor(new Class[] { VideoAppInterface.class, AVActivity.class }).newInstance(new Object[] { paramVideoAppInterface, paramAVActivity });
      return paramVideoAppInterface;
    }
    catch (Exception localException)
    {
      QLog.d(paramClass.getSimpleName(), 1, "createToolbar crash", localException);
      paramAVActivity = null;
      paramVideoAppInterface = paramAVActivity;
      if (localException != null)
      {
        paramVideoAppInterface = paramAVActivity;
        if (localException.getClass() != null) {
          paramVideoAppInterface = localException.getClass().getName();
        }
      }
      throw new IllegalArgumentException("create Toolbar fail, Illegal value[" + paramClass.getName() + "], srcException[" + paramVideoAppInterface + "]");
    }
  }
  
  public static void setSelectedListViewItemAndShow(HorizontalListView paramHorizontalListView, mgm parammgm, int paramInt)
  {
    if ((!parammgm.a(paramInt)) || ((paramInt >= paramHorizontalListView.getFirstVisiblePosition()) && (paramInt <= paramHorizontalListView.getLastVisiblePosition()))) {
      return;
    }
    int j = 0;
    int i = j;
    if (paramInt > 0)
    {
      i = j;
      if (paramInt > parammgm.a()) {
        i = mgm.jdField_a_of_type_Int * (paramInt - 1);
      }
    }
    paramHorizontalListView.resetCurrentX(i);
  }
  
  private final void show(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (this.mIsCreated)
    {
      this.toolbarView.setVisibility(0);
      onShow(paramLong, paramInt, paramBoolean);
    }
  }
  
  public boolean canShowToolbar()
  {
    return isEffectBtnEnable();
  }
  
  public final void create(long paramLong, RelativeLayout paramRelativeLayout)
  {
    if (getUIInfo().f == 0) {
      throw new IllegalArgumentException("create Toolbar fail, Illegal toolbarLayout id。" + this.TAG + "_" + paramLong);
    }
    if (this.mIsCreated) {
      return;
    }
    this.mIsCreated = true;
    this.toolbarView = LayoutInflater.from((Context)this.mActivity.get()).inflate(getUIInfo().f, null);
    paramRelativeLayout.addView(this.toolbarView, new ViewGroup.LayoutParams(-1, -2));
    onCreate(paramLong, (AVActivity)this.mActivity.get());
  }
  
  public final void destroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    if (!this.mIsCreated) {
      return;
    }
    onDestroy(paramLong, paramVideoAppInterface);
    this.toolbarView = null;
    this.mEffectBtnRedTouch = null;
    this.mEffectBtn = null;
    this.mIsCreated = false;
  }
  
  public AVActivity getAVActivity()
  {
    if (this.mActivity == null) {}
    while (this.mActivity.get() == null) {
      return null;
    }
    return (AVActivity)this.mActivity.get();
  }
  
  int getEffectBtnId()
  {
    return getUIInfo().d;
  }
  
  protected abstract mbl getUIInfo();
  
  public String getUnableInfo()
  {
    return "";
  }
  
  public final void hideToolbar(long paramLong)
  {
    if (this.mIsCreated)
    {
      this.toolbarView.setVisibility(8);
      onHide(paramLong);
      setSelected(false);
    }
  }
  
  public void initBtn(LinearLayout paramLinearLayout, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramLinearLayout == null) {
      return;
    }
    this.mEffectBtn = CreateImageButton(paramLinearLayout, getEffectBtnId(), getUIInfo());
    this.mEffectBtn.setOnClickListener(paramOnClickListener);
    if (AudioHelper.a(0) == 1)
    {
      paramLinearLayout = this.mEffectBtn;
      if (getEffectBtnId() % 2 != 0) {
        break label76;
      }
    }
    label76:
    for (int i = -16777216;; i = -256)
    {
      paramLinearLayout.setBackgroundColor(i);
      if (paramBoolean) {
        break;
      }
      this.mEffectBtn.setVisibility(8);
      return;
    }
  }
  
  public boolean isAvailable()
  {
    return (this.mEffectBtn != null) && (this.mEffectBtn.getVisibility() == 0) && (canShowToolbar());
  }
  
  public boolean isCreated()
  {
    return this.mIsCreated;
  }
  
  public boolean isEffectBtnEnable()
  {
    return true;
  }
  
  public void onButtonClick(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    showEffectBtnAnimation(paramInt, paramBoolean1, paramBoolean2);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity) {}
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface) {}
  
  protected void onHide(long paramLong) {}
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean) {}
  
  final void performClick()
  {
    if (this.mEffectBtn != null)
    {
      this.mEffectBtn.setTag(2131378244, Boolean.valueOf(true));
      this.mEffectBtn.performClick();
      this.mEffectBtn.setTag(2131378244, null);
    }
  }
  
  public void setBtnSelected(boolean paramBoolean)
  {
    if (this.mEffectBtn != null) {
      this.mEffectBtn.setSelected(paramBoolean);
    }
  }
  
  void setEffectBtnVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      if (this.mEffectBtn != null) {
        this.mEffectBtn.setVisibility(i);
      }
      if (this.mEffectBtnRedTouch != null) {
        this.mEffectBtnRedTouch.setVisibility(i);
      }
      return;
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (!this.mIsCreated) {}
    do
    {
      return;
      if (this.mEffectBtn != null) {
        this.mEffectBtn.setSelected(paramBoolean);
      }
    } while (getUIInfo().c == 0);
    updateBtnStatus();
  }
  
  protected void showEffectBtnAnimation(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showEffectBtnAnimation lastEffectBtnID: " + paramInt + ", showToolbar: " + paramBoolean2 + "， bFromPerformClick = " + paramBoolean1 + ", getEffectBtnId = " + getEffectBtnId());
    }
    Object localObject = (EffectOperateManager)this.mApp.a(8);
    if ((localObject == null) || (!((EffectOperateManager)localObject).a())) {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "showEffectBtnAnimation is not show effect button animation!");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "showEffectBtnAnimation getEffectType = " + ((EffectOperateManager)localObject).a());
      }
    } while (((EffectOperateManager)localObject).a() != getEffectBtnId());
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).addListener(new mbk(this));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mEffectBtn, "scaleX", new float[] { 1.0F, 1.56F, 1.0F });
    localObjectAnimator1.setDuration(400L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mEffectBtn, "scaleY", new float[] { 1.0F, 1.56F, 1.0F });
    localObjectAnimator2.setDuration(400L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.mEffectBtn, "scaleX", new float[] { 1.0F, 1.18F, 1.0F });
    localObjectAnimator3.setDuration(400L);
    localObjectAnimator3.setStartDelay(400L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.mEffectBtn, "scaleY", new float[] { 1.0F, 1.18F, 1.0F });
    localObjectAnimator4.setDuration(400L);
    localObjectAnimator4.setStartDelay(400L);
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4);
    ((AnimatorSet)localObject).setStartDelay(200L);
    ((AnimatorSet)localObject).start();
  }
  
  public final boolean tryShowToolbar(long paramLong, RelativeLayout paramRelativeLayout, int paramInt, boolean paramBoolean)
  {
    if (!canShowToolbar())
    {
      paramRelativeLayout = getUnableInfo();
      if (!TextUtils.isEmpty(paramRelativeLayout)) {
        maf.a(this.mApp, 1010, paramRelativeLayout);
      }
      QLog.w(this.TAG, 1, "tryShowToolbar, 失败[" + paramRelativeLayout + "], seq[" + paramLong + "]");
      return false;
    }
    create(paramLong, paramRelativeLayout);
    show(paramLong, paramInt, paramBoolean);
    setSelected(true);
    return true;
  }
  
  public void update(Object[] paramArrayOfObject) {}
  
  void updateBtnStatus()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "updateBtnStatus, EffectBtnId[" + getEffectBtnId() + "]");
    }
    if (this.mEffectBtn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "updateBtnStatus, mEffectBtn为空");
      }
      return;
    }
    if ((EffectSettingUi.a(this.mApp, true)) && (!this.mApp.a().a().l()) && (getEffectBtnId() != 1)) {}
    for (boolean bool = false;; bool = true)
    {
      this.mEffectBtn.setEnabled(bool);
      Object localObject = getUIInfo();
      if (localObject == null) {
        break;
      }
      int j = ((mbl)localObject).e;
      int k = ((mbl)localObject).b;
      if ((bool) && (isEffectBtnEnable())) {
        if ((((mbl)localObject).c == 0) || (!this.mEffectBtn.isSelected())) {
          break label270;
        }
      }
      label270:
      for (int i = ((mbl)localObject).c;; i = j)
      {
        k = ((mbl)localObject).jdField_a_of_type_Int;
        if (this.mEffectBtnRedTouch != null)
        {
          this.mEffectBtnRedTouch.setHostEnable(true);
          int m = 2131165944;
          j = i;
          i = m;
        }
        for (;;)
        {
          changImageButtonStyle(this.mEffectBtn, j, k);
          localObject = AVColorStateList.a(this.mEffectBtn.getResources(), i);
          this.mEffectBtn.setTextColor((ColorStateList)localObject);
          return;
          if (this.mEffectBtnRedTouch != null) {
            this.mEffectBtnRedTouch.setHostEnable(false);
          }
          i = ((mbl)localObject).b;
          continue;
          j = i;
          i = 2131165944;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.BaseToolbar
 * JD-Core Version:    0.7.0.1
 */