package com.tencent.av.ui;

import android.animation.Animator;
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
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AVColorStateList;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;

public abstract class BaseToolbar
{
  public final String TAG;
  protected WeakReference<AVActivity> mActivity;
  protected VideoAppInterface mApp;
  protected Button mEffectBtn;
  RedTouch mEffectBtnRedTouch;
  private boolean mIsCreated;
  protected View toolbarView;
  
  public BaseToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EffectSettingUi.");
    localStringBuilder.append(getClass().getSimpleName());
    this.TAG = localStringBuilder.toString();
    this.mEffectBtn = null;
    this.mActivity = null;
    this.mEffectBtnRedTouch = null;
    this.mIsCreated = false;
    this.mApp = paramVideoAppInterface;
    this.mActivity = new WeakReference(paramAVActivity);
  }
  
  private static Button CreateImageButton(LinearLayout paramLinearLayout, int paramInt, BaseToolbar.UIInfo paramUIInfo)
  {
    if (paramLinearLayout != null)
    {
      if (paramUIInfo == null) {
        return null;
      }
      Button localButton = new Button(paramLinearLayout.getContext());
      Object localObject = paramLinearLayout.getResources();
      int i = (int)((Resources)localObject).getDimension(2131297760);
      localButton.setId(paramInt);
      localButton.setGravity(17);
      localButton.setSingleLine();
      localButton.setContentDescription(paramUIInfo.jdField_a_of_type_JavaLangString);
      localButton.setBackgroundDrawable(null);
      localButton.setCompoundDrawablePadding(AIOUtils.b(5.0F, (Resources)localObject));
      localButton.setText(paramUIInfo.jdField_a_of_type_JavaLangString);
      localButton.setTextSize(ViewUtils.e(AIOUtils.b(12.0F, (Resources)localObject)));
      paramUIInfo = paramUIInfo.jdField_a_of_type_JavaLangString;
      localObject = localButton.getPaint();
      if ((localObject != null) && (!TextUtils.isEmpty(paramUIInfo)))
      {
        paramInt = (int)(((TextPaint)localObject).measureText(paramUIInfo) + 0.5F);
        if (QLog.isColorLevel())
        {
          paramUIInfo = new StringBuilder();
          paramUIInfo.append("CreateImageButton textWidth[");
          paramUIInfo.append(paramInt);
          paramUIInfo.append("], btn_width[");
          paramUIInfo.append(i);
          paramUIInfo.append("]");
          QLog.i("", 2, paramUIInfo.toString());
        }
        if (i < paramInt) {}
      }
      else
      {
        paramInt = i;
      }
      paramUIInfo = new LinearLayout.LayoutParams(paramInt, -2);
      paramUIInfo.weight = 1.0F;
      localButton.setLayoutParams(paramUIInfo);
      paramLinearLayout.addView(localButton);
      return localButton;
    }
    return null;
  }
  
  private void changImageButtonStyle(Button paramButton, int paramInt1, int paramInt2)
  {
    if (paramButton == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "changButtonStyle button is null");
      }
      return;
    }
    if (paramInt1 != 0)
    {
      Object localObject = paramButton.getResources();
      int i = (int)((Resources)localObject).getDimension(2131297756);
      if (paramInt2 > 0) {
        localObject = TintStateDrawable.a((Resources)localObject, paramInt1, paramInt2);
      } else {
        localObject = ((Resources)localObject).getDrawable(paramInt1);
      }
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramButton.setCompoundDrawables(null, (Drawable)localObject, null, null);
    }
  }
  
  public static BaseToolbar createToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, Class<? extends BaseToolbar> paramClass)
  {
    try
    {
      paramVideoAppInterface = (BaseToolbar)paramClass.getConstructor(new Class[] { VideoAppInterface.class, AVActivity.class }).newInstance(new Object[] { paramVideoAppInterface, paramAVActivity });
      return paramVideoAppInterface;
    }
    catch (Exception paramAVActivity)
    {
      QLog.d(paramClass.getSimpleName(), 1, "createToolbar crash", paramAVActivity);
      paramVideoAppInterface = null;
      if (paramAVActivity.getClass() != null) {
        paramVideoAppInterface = paramAVActivity.getClass().getName();
      }
      paramAVActivity = new StringBuilder();
      paramAVActivity.append("create Toolbar fail, Illegal value[");
      paramAVActivity.append(paramClass.getName());
      paramAVActivity.append("], srcException[");
      paramAVActivity.append(paramVideoAppInterface);
      paramAVActivity.append("]");
      throw new IllegalArgumentException(paramAVActivity.toString());
    }
  }
  
  public static void setSelectedListViewItemAndShow(HorizontalListView paramHorizontalListView, QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter, int paramInt)
  {
    if (paramQAVPtvTemplateAdapter.a(paramInt))
    {
      if ((paramInt >= paramHorizontalListView.getFirstVisiblePosition()) && (paramInt <= paramHorizontalListView.getLastVisiblePosition())) {
        return;
      }
      int j = 0;
      int i = j;
      if (paramInt > 0)
      {
        i = j;
        if (paramInt > paramQAVPtvTemplateAdapter.a()) {
          i = QAVPtvTemplateAdapter.jdField_a_of_type_Int * (paramInt - 1);
        }
      }
      paramHorizontalListView.resetCurrentX(i);
    }
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
    if (getUIInfo().g != 0)
    {
      if (this.mIsCreated) {
        return;
      }
      this.mIsCreated = true;
      this.toolbarView = LayoutInflater.from((Context)this.mActivity.get()).inflate(getUIInfo().g, null);
      paramRelativeLayout.addView(this.toolbarView, new ViewGroup.LayoutParams(-1, -2));
      onCreate(paramLong, (AVActivity)this.mActivity.get());
      return;
    }
    paramRelativeLayout = new StringBuilder();
    paramRelativeLayout.append("create Toolbar fail, Illegal toolbarLayout id。");
    paramRelativeLayout.append(this.TAG);
    paramRelativeLayout.append("_");
    paramRelativeLayout.append(paramLong);
    throw new IllegalArgumentException(paramRelativeLayout.toString());
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
    WeakReference localWeakReference = this.mActivity;
    if (localWeakReference == null) {
      return null;
    }
    if (localWeakReference.get() == null) {
      return null;
    }
    return (AVActivity)this.mActivity.get();
  }
  
  int getEffectBtnId()
  {
    return getUIInfo().d;
  }
  
  protected abstract BaseToolbar.UIInfo getUIInfo();
  
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
      int i;
      if (getEffectBtnId() % 2 == 0) {
        i = -16777216;
      } else {
        i = -256;
      }
      paramLinearLayout.setBackgroundColor(i);
    }
    if (!paramBoolean) {
      this.mEffectBtn.setVisibility(8);
    }
  }
  
  public boolean isAvailable()
  {
    Button localButton = this.mEffectBtn;
    return (localButton != null) && (localButton.getVisibility() == 0) && (canShowToolbar());
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
    Button localButton = this.mEffectBtn;
    if (localButton != null)
    {
      localButton.setTag(2131378276, Boolean.valueOf(true));
      this.mEffectBtn.performClick();
      this.mEffectBtn.setTag(2131378276, null);
    }
  }
  
  public void setBtnSelected(boolean paramBoolean)
  {
    Button localButton = this.mEffectBtn;
    if (localButton != null) {
      localButton.setSelected(paramBoolean);
    }
  }
  
  void setEffectBtnVisibility(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    Object localObject = this.mEffectBtn;
    if (localObject != null) {
      ((Button)localObject).setVisibility(i);
    }
    localObject = this.mEffectBtnRedTouch;
    if (localObject != null) {
      ((RedTouch)localObject).setVisibility(i);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (!this.mIsCreated) {
      return;
    }
    Button localButton = this.mEffectBtn;
    if (localButton != null) {
      localButton.setSelected(paramBoolean);
    }
    if (getUIInfo().c != 0) {
      updateBtnStatus();
    }
  }
  
  protected void showEffectBtnAnimation(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showEffectBtnAnimation lastEffectBtnID: ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", showToolbar: ");
      ((StringBuilder)localObject2).append(paramBoolean2);
      ((StringBuilder)localObject2).append("， bFromPerformClick = ");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append(", getEffectBtnId = ");
      ((StringBuilder)localObject2).append(getEffectBtnId());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = (EffectOperateManager)this.mApp.a(8);
    if ((localObject1 != null) && (((EffectOperateManager)localObject1).a()))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = this.TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("showEffectBtnAnimation getEffectType = ");
        ((StringBuilder)localObject3).append(((EffectOperateManager)localObject1).a());
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if (((EffectOperateManager)localObject1).a() != getEffectBtnId()) {
        return;
      }
      localObject1 = new AnimatorSet();
      ((AnimatorSet)localObject1).addListener(new BaseToolbar.1(this));
      localObject2 = ObjectAnimator.ofFloat(this.mEffectBtn, "scaleX", new float[] { 1.0F, 1.56F, 1.0F });
      ((ObjectAnimator)localObject2).setDuration(400L);
      Object localObject3 = ObjectAnimator.ofFloat(this.mEffectBtn, "scaleY", new float[] { 1.0F, 1.56F, 1.0F });
      ((ObjectAnimator)localObject3).setDuration(400L);
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mEffectBtn, "scaleX", new float[] { 1.0F, 1.18F, 1.0F });
      localObjectAnimator1.setDuration(400L);
      localObjectAnimator1.setStartDelay(400L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mEffectBtn, "scaleY", new float[] { 1.0F, 1.18F, 1.0F });
      localObjectAnimator2.setDuration(400L);
      localObjectAnimator2.setStartDelay(400L);
      ((AnimatorSet)localObject1).play((Animator)localObject2).with((Animator)localObject3).with(localObjectAnimator1).with(localObjectAnimator2);
      ((AnimatorSet)localObject1).setStartDelay(200L);
      ((AnimatorSet)localObject1).start();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.TAG, 2, "showEffectBtnAnimation is not show effect button animation!");
    }
  }
  
  public final boolean tryShowToolbar(long paramLong, RelativeLayout paramRelativeLayout, int paramInt, boolean paramBoolean)
  {
    if (!canShowToolbar())
    {
      paramRelativeLayout = getUnableInfo();
      if (!TextUtils.isEmpty(paramRelativeLayout)) {
        TipsUtil.a(this.mApp, 1010, paramRelativeLayout);
      }
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryShowToolbar, 失败[");
      localStringBuilder.append(paramRelativeLayout);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
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
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateBtnStatus, EffectBtnId[");
      ((StringBuilder)localObject2).append(getEffectBtnId());
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.mEffectBtn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "updateBtnStatus, mEffectBtn为空");
      }
      return;
    }
    boolean bool;
    if ((EffectSettingUi.a(this.mApp, true)) && (!this.mApp.a().a().j()) && (getEffectBtnId() != 1)) {
      bool = false;
    } else {
      bool = true;
    }
    this.mEffectBtn.setEnabled(bool);
    Object localObject1 = getUIInfo();
    if (localObject1 == null) {
      return;
    }
    int k = ((BaseToolbar.UIInfo)localObject1).f;
    int m = ((BaseToolbar.UIInfo)localObject1).b;
    int n = 2131165987;
    int j;
    if ((bool) && (isEffectBtnEnable()))
    {
      int i = k;
      if (((BaseToolbar.UIInfo)localObject1).c != 0)
      {
        i = k;
        if (this.mEffectBtn.isSelected()) {
          i = ((BaseToolbar.UIInfo)localObject1).c;
        }
      }
      int i1 = ((BaseToolbar.UIInfo)localObject1).jdField_a_of_type_Int;
      localObject1 = this.mEffectBtnRedTouch;
      k = i;
      m = i1;
      j = n;
      if (localObject1 != null)
      {
        ((RedTouch)localObject1).setHostEnable(true);
        k = i;
        m = i1;
        j = n;
      }
    }
    else
    {
      localObject2 = this.mEffectBtnRedTouch;
      if (localObject2 != null) {
        ((RedTouch)localObject2).setHostEnable(false);
      }
      j = ((BaseToolbar.UIInfo)localObject1).b;
    }
    changImageButtonStyle(this.mEffectBtn, k, m);
    localObject1 = AVColorStateList.a(this.mEffectBtn.getResources(), j);
    this.mEffectBtn.setTextColor((ColorStateList)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.BaseToolbar
 * JD-Core Version:    0.7.0.1
 */