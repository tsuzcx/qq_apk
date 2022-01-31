package com.tencent.av.ui;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import jsp;

public abstract class BaseToolbar
{
  final String TAG = "EffectSettingUi." + getClass().getSimpleName();
  public WeakReference mActivity;
  public VideoAppInterface mApp;
  protected ImageButton mEffectBtn;
  RedTouch mEffectBtnRedTouch = null;
  private boolean mIsCreated;
  public View toolbarView;
  
  public BaseToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    this.mApp = paramVideoAppInterface;
    this.mActivity = new WeakReference(paramAVActivity);
  }
  
  private static ImageButton CreateImageButton(LinearLayout paramLinearLayout, int paramInt1, String paramString, int paramInt2)
  {
    ImageButton localImageButton = new ImageButton(paramLinearLayout.getContext());
    int i = (int)paramLinearLayout.getResources().getDimension(2131560057);
    int j = (int)paramLinearLayout.getResources().getDimension(2131560061);
    localImageButton.setLayoutParams(new FrameLayout.LayoutParams(i, i));
    localImageButton.setId(paramInt1);
    localImageButton.setContentDescription(paramString);
    localImageButton.setBackgroundDrawable(null);
    localImageButton.setImageResource(paramInt2);
    localImageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageButton.setPadding(j, j, j, j);
    paramLinearLayout.addView(localImageButton);
    return localImageButton;
  }
  
  public static BaseToolbar createToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, Class paramClass)
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
  
  private void setSelected(boolean paramBoolean)
  {
    if (!this.mIsCreated) {}
    do
    {
      return;
      this.mEffectBtn.setSelected(paramBoolean);
    } while (getUIInfo().c == 0);
    updateBtnStatus();
  }
  
  private final void show(int paramInt, boolean paramBoolean)
  {
    if (this.mIsCreated)
    {
      this.toolbarView.setVisibility(0);
      onShow(paramInt, paramBoolean);
    }
  }
  
  public boolean canShowToolbar()
  {
    return isEffectBtnEnable();
  }
  
  void clearRedDot()
  {
    if (getRedTouchUIAppid() != 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "clearRedDot, UIAppid[" + getRedTouchUIAppid() + "]");
      }
      this.mApp.f(getRedTouchUIAppid() + "");
      if (this.mEffectBtnRedTouch != null) {
        this.mEffectBtnRedTouch.b();
      }
    }
  }
  
  public final void create(RelativeLayout paramRelativeLayout)
  {
    if (getUIInfo().g == 0) {
      throw new IllegalArgumentException("create Toolbar fail, Illegal toolbarLayout id.");
    }
    if (this.mIsCreated) {
      return;
    }
    this.mIsCreated = true;
    this.toolbarView = LayoutInflater.from((Context)this.mActivity.get()).inflate(getUIInfo().g, null);
    paramRelativeLayout.addView(this.toolbarView, new ViewGroup.LayoutParams(-1, -1));
    onCreate((AVActivity)this.mActivity.get());
    updateRedDot();
  }
  
  public final void destroy(VideoAppInterface paramVideoAppInterface)
  {
    if (!this.mIsCreated) {
      return;
    }
    onDestroy(paramVideoAppInterface);
    this.toolbarView = null;
    this.mEffectBtnRedTouch = null;
    this.mEffectBtn = null;
    this.mIsCreated = false;
  }
  
  int getEffectBtnId()
  {
    return getUIInfo().d;
  }
  
  int getRedTouchUIAppid()
  {
    return getUIInfo().e;
  }
  
  public abstract BaseToolbar.UIInfo getUIInfo();
  
  public String getUnableInfo()
  {
    return "";
  }
  
  public final void hideToolbar()
  {
    if (this.mIsCreated)
    {
      this.toolbarView.setVisibility(8);
      onHide();
      setSelected(false);
    }
  }
  
  public void initBtn(LinearLayout paramLinearLayout, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (this.mEffectBtn != null) {}
    label89:
    do
    {
      return;
      this.mEffectBtn = CreateImageButton(paramLinearLayout, getEffectBtnId(), getUIInfo().jdField_a_of_type_JavaLangString, getUIInfo().f);
      this.mEffectBtn.setOnClickListener(paramOnClickListener);
      if (AudioHelper.a(0) == 1)
      {
        paramLinearLayout = this.mEffectBtn;
        if (getEffectBtnId() % 2 != 0) {
          break label89;
        }
      }
      for (int i = -16777216;; i = -256)
      {
        paramLinearLayout.setBackgroundColor(i);
        if (paramBoolean) {
          break;
        }
        this.mEffectBtn.setVisibility(8);
        return;
      }
    } while (getRedTouchUIAppid() == 0);
    this.mEffectBtnRedTouch = new RedTouch(this.mApp.getApplication(), this.mEffectBtn).a(53).d(7).c(8).a();
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
  
  public void onCreate(AVActivity paramAVActivity) {}
  
  public void onDestroy(VideoAppInterface paramVideoAppInterface) {}
  
  public void onHide() {}
  
  public void onShow(int paramInt, boolean paramBoolean) {}
  
  final void performClick()
  {
    if (this.mEffectBtn != null)
    {
      this.mEffectBtn.setTag(2131362549, Boolean.valueOf(true));
      this.mEffectBtn.performClick();
      this.mEffectBtn.setTag(2131362549, null);
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
  
  protected void showEffectBtnAnimation(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showEffectBtnAnimation lastEffectBtnID: " + paramInt + ", showToolbar: " + paramBoolean2 + "， bFromPerformClick = " + paramBoolean1 + ", getEffectBtnId = " + getEffectBtnId());
    }
    Object localObject = (EffectOperateManager)this.mApp.a(8);
    if ((localObject == null) || (!((EffectOperateManager)localObject).b())) {
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
    ((AnimatorSet)localObject).addListener(new jsp(this));
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
  
  public final boolean tryShowToolbar(RelativeLayout paramRelativeLayout, int paramInt, boolean paramBoolean)
  {
    if (!canShowToolbar())
    {
      paramRelativeLayout = getUnableInfo();
      if (!TextUtils.isEmpty(paramRelativeLayout)) {
        ((AVActivity)this.mActivity.get()).a(79, paramRelativeLayout, 3000L, 1);
      }
      QLog.w(this.TAG, 1, "tryShowToolbar, 失败[" + paramRelativeLayout + "]");
      return false;
    }
    create(paramRelativeLayout);
    show(paramInt, paramBoolean);
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
    if ((EffectSettingUi.a(this.mApp, true)) && (!this.mApp.a().a().f()) && (getEffectBtnId() != 1)) {}
    for (boolean bool = false;; bool = true)
    {
      this.mEffectBtn.setEnabled(bool);
      int j = getUIInfo().f;
      int i = getUIInfo().b;
      if ((bool) && (isEffectBtnEnable())) {
        if ((getUIInfo().c == 0) || (!this.mEffectBtn.isSelected())) {
          break label249;
        }
      }
      label249:
      for (i = getUIInfo().c;; i = j)
      {
        j = getUIInfo().jdField_a_of_type_Int;
        int k;
        if (this.mEffectBtnRedTouch != null)
        {
          this.mEffectBtnRedTouch.setHostEnable(true);
          k = j;
          j = i;
          i = k;
        }
        for (;;)
        {
          if (i > 0)
          {
            AudioHelper.a(this.mEffectBtn, j, i);
            return;
            if (this.mEffectBtnRedTouch != null) {
              this.mEffectBtnRedTouch.setHostEnable(false);
            }
          }
          else
          {
            this.mEffectBtn.setImageResource(j);
            return;
            k = i;
            i = j;
            j = k;
          }
        }
      }
    }
  }
  
  void updateRedDot()
  {
    if (this.mEffectBtnRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = this.mApp.a(getRedTouchUIAppid() + "");
      if (localAppInfo != null)
      {
        this.mEffectBtnRedTouch.a(localAppInfo);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "updateRedDot, UIAppid[" + getRedTouchUIAppid() + "], flag[" + localAppInfo.iNewFlag.get() + "]");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.BaseToolbar
 * JD-Core Version:    0.7.0.1
 */