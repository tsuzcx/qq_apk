package com.tencent.av.ui.effect.toolbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;

public abstract class BaseToolbar
{
  public final String TAG = getClass().getSimpleName();
  protected WeakReference<AVActivity> mActivity = null;
  protected VideoAppInterface mApp;
  public Button mEffectBtn = null;
  public RedTouch mEffectBtnRedTouch = null;
  private boolean mIsCreated = false;
  protected View toolbarView;
  
  public BaseToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    this.mApp = paramVideoAppInterface;
    this.mActivity = new WeakReference(paramAVActivity);
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
  
  public static void keepInToolbar(VideoAppInterface paramVideoAppInterface, long paramLong)
  {
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.a(new Object[] { Integer.valueOf(125), Long.valueOf(paramLong) });
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
          i = QAVPtvTemplateAdapter.c * (paramInt - 1);
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
    return isEffectBtnNormal();
  }
  
  public final void create(long paramLong, ViewGroup paramViewGroup)
  {
    if (getUIInfo().h != 0)
    {
      if (this.mIsCreated) {
        return;
      }
      this.mIsCreated = true;
      this.toolbarView = LayoutInflater.from((Context)this.mActivity.get()).inflate(getUIInfo().h, null);
      paramViewGroup.addView(this.toolbarView, new ViewGroup.LayoutParams(-1, -2));
      onCreate(paramLong, (AVActivity)this.mActivity.get());
      return;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("create Toolbar fail, Illegal toolbarLayout id。");
    paramViewGroup.append(this.TAG);
    paramViewGroup.append("_");
    paramViewGroup.append(paramLong);
    throw new IllegalArgumentException(paramViewGroup.toString());
  }
  
  protected abstract Button createEffectButton(ViewGroup paramViewGroup, int paramInt, BaseToolbar.UIInfo paramUIInfo);
  
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
  
  public int getEffectBtnId()
  {
    return getUIInfo().d;
  }
  
  protected abstract BaseToolbar.UIInfo getUIInfo();
  
  public String getUnableInfo()
  {
    return "";
  }
  
  public boolean hasCameraPermission()
  {
    AVActivity localAVActivity = getAVActivity();
    boolean bool = false;
    if (localAVActivity == null) {
      return false;
    }
    if (localAVActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
      bool = true;
    }
    return bool;
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
  
  public void initBtn(ViewGroup paramViewGroup, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramViewGroup == null) {
      return;
    }
    this.mEffectBtn = createEffectButton(paramViewGroup, getEffectBtnId(), getUIInfo());
    this.mEffectBtn.setOnClickListener(paramOnClickListener);
    if (AudioHelper.a(0) == 1)
    {
      paramViewGroup = this.mEffectBtn;
      int i;
      if (getEffectBtnId() % 2 == 0) {
        i = -16777216;
      } else {
        i = -256;
      }
      paramViewGroup.setBackgroundColor(i);
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
  
  public boolean isEffectBtnNormal()
  {
    return true;
  }
  
  protected boolean isOpenAvatar2D(boolean paramBoolean)
  {
    SessionInfo localSessionInfo = this.mApp.b().k();
    if ((QLog.isColorLevel()) && (localSessionInfo != null))
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isOpenAvatar2D isLocalAvatar2DInUsing = ");
      localStringBuilder.append(localSessionInfo.cv);
      localStringBuilder.append(" isRemoteAvatar2DInUsing = ");
      localStringBuilder.append(localSessionInfo.cw);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    boolean bool = true;
    if (paramBoolean)
    {
      if (localSessionInfo != null)
      {
        paramBoolean = bool;
        if (localSessionInfo.cv) {
          break label115;
        }
        if (localSessionInfo.cw) {
          return true;
        }
      }
      paramBoolean = false;
      label115:
      return paramBoolean;
    }
    return (localSessionInfo != null) && (localSessionInfo.cv);
  }
  
  public void onButtonClick(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    showEffectBtnAnimation(paramInt, paramBoolean1, paramBoolean2);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity) {}
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface) {}
  
  protected void onHide(long paramLong) {}
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean) {}
  
  public final void performClick()
  {
    Button localButton = this.mEffectBtn;
    if (localButton != null)
    {
      localButton.setTag(2131446795, Boolean.valueOf(true));
      this.mEffectBtn.performClick();
      this.mEffectBtn.setTag(2131446795, null);
    }
  }
  
  protected void setAvatar2DFirstTipsState()
  {
    SharedPreferences.Editor localEditor = SharedPreUtils.K(getAVActivity(), this.mApp.getCurrentAccountUin()).edit();
    localEditor.putBoolean("is_first_open_avatar2d_tips", false);
    localEditor.commit();
  }
  
  public void setEffectBtnClickable(boolean paramBoolean)
  {
    Button localButton = this.mEffectBtn;
    if (localButton == null) {
      return;
    }
    localButton.setClickable(paramBoolean);
  }
  
  public void setEffectBtnVisibility(boolean paramBoolean)
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
      updateEffectBtnStatus();
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
    Object localObject1 = (EffectOperateManager)this.mApp.c(8);
    if ((localObject1 != null) && (((EffectOperateManager)localObject1).h()))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = this.TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("showEffectBtnAnimation getEffectType = ");
        ((StringBuilder)localObject3).append(((EffectOperateManager)localObject1).b());
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if (((EffectOperateManager)localObject1).b() != getEffectBtnId()) {
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
  
  public final boolean tryShowToolbar(long paramLong, ViewGroup paramViewGroup, int paramInt, boolean paramBoolean)
  {
    if (!canShowToolbar())
    {
      paramViewGroup = getUnableInfo();
      if (!TextUtils.isEmpty(paramViewGroup)) {
        TipsUtil.a(this.mApp, 1010, paramViewGroup);
      }
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryShowToolbar, 失败[");
      localStringBuilder.append(paramViewGroup);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      return false;
    }
    create(paramLong, paramViewGroup);
    show(paramLong, paramInt, paramBoolean);
    setSelected(true);
    return true;
  }
  
  public void update(Object[] paramArrayOfObject) {}
  
  public abstract void updateEffectBtnStatus();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.BaseToolbar
 * JD-Core Version:    0.7.0.1
 */