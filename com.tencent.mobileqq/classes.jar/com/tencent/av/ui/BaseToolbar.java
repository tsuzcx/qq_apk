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
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import kvq;
import lqb;
import lrf;
import lrg;
import lwf;

public abstract class BaseToolbar
{
  public final String TAG = "EffectSettingUi." + getClass().getSimpleName();
  public WeakReference<AVActivity> mActivity;
  public VideoAppInterface mApp;
  protected ImageButton mEffectBtn;
  RedTouch mEffectBtnRedTouch = null;
  private boolean mIsCreated;
  protected View toolbarView;
  
  public BaseToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    this.mApp = paramVideoAppInterface;
    this.mActivity = new WeakReference(paramAVActivity);
  }
  
  private static ImageButton CreateImageButton(LinearLayout paramLinearLayout, int paramInt1, String paramString, int paramInt2)
  {
    ImageButton localImageButton = new ImageButton(paramLinearLayout.getContext());
    int i = (int)paramLinearLayout.getResources().getDimension(2131166445);
    int j = (int)paramLinearLayout.getResources().getDimension(2131166444);
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
  
  public static boolean setSelectedListViewItemAndShow(HorizontalListView paramHorizontalListView, lwf paramlwf, int paramInt)
  {
    int j = 0;
    boolean bool = false;
    if (paramlwf.a(paramInt)) {
      if ((paramInt < paramHorizontalListView.getFirstVisiblePosition()) || (paramInt > paramHorizontalListView.getLastVisiblePosition())) {
        break label36;
      }
    }
    for (;;)
    {
      bool = true;
      return bool;
      label36:
      int i = j;
      if (paramInt > 0)
      {
        i = j;
        if (paramInt > lwf.a(paramlwf.jdField_a_of_type_AndroidContentContext)) {
          i = lwf.b + lwf.jdField_a_of_type_Int * (paramInt - 1);
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
  
  protected abstract lrg getUIInfo();
  
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
    if (this.mEffectBtn != null) {
      return;
    }
    this.mEffectBtn = CreateImageButton(paramLinearLayout, getEffectBtnId(), getUIInfo().jdField_a_of_type_JavaLangString, getUIInfo().e);
    this.mEffectBtn.setOnClickListener(paramOnClickListener);
    if (AudioHelper.a(0) == 1)
    {
      paramLinearLayout = this.mEffectBtn;
      if (getEffectBtnId() % 2 != 0) {
        break label89;
      }
    }
    label89:
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
      this.mEffectBtn.setTag(2131311036, Boolean.valueOf(true));
      this.mEffectBtn.performClick();
      this.mEffectBtn.setTag(2131311036, null);
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
      this.mEffectBtn.setSelected(paramBoolean);
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
    ((AnimatorSet)localObject).addListener(new lrf(this));
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
        lqb.a(this.mApp, 1010, paramRelativeLayout);
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
    if ((EffectSettingUi.a(this.mApp, true)) && (!this.mApp.a().a().j()) && (getEffectBtnId() != 1)) {}
    for (boolean bool = false;; bool = true)
    {
      this.mEffectBtn.setEnabled(bool);
      int j = getUIInfo().e;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.BaseToolbar
 * JD-Core Version:    0.7.0.1
 */