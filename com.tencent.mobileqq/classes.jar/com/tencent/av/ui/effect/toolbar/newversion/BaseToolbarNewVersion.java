package com.tencent.av.ui.effect.toolbar.newversion;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.utils.AVColorStateList;
import com.tencent.av.utils.VideoUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseToolbarNewVersion
  extends BaseToolbar
{
  public BaseToolbarNewVersion(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  protected Button createEffectButton(ViewGroup paramViewGroup, int paramInt, BaseToolbar.UIInfo paramUIInfo)
  {
    if (paramViewGroup != null)
    {
      if (paramUIInfo == null) {
        return null;
      }
      DownLineButton localDownLineButton = new DownLineButton(paramViewGroup.getContext());
      Resources localResources = paramViewGroup.getResources();
      localDownLineButton.setId(paramInt);
      localDownLineButton.setGravity(17);
      localDownLineButton.setContentDescription(paramUIInfo.g);
      localDownLineButton.setBackgroundDrawable(null);
      localDownLineButton.setPadding(AIOUtils.b(14.0F, localResources), 0, AIOUtils.b(14.0F, localResources), 0);
      localDownLineButton.setText(paramUIInfo.g);
      localDownLineButton.setGravity(17);
      localDownLineButton.setTextSize(ViewUtils.pxTosp(AIOUtils.b(16.0F, localResources)));
      localDownLineButton.setTextColor(localResources.getColor(2131166738));
      localDownLineButton.setMinWidth(0);
      localDownLineButton.setMinimumWidth(0);
      localDownLineButton.setMinimumHeight(0);
      localDownLineButton.setMinHeight(0);
      paramUIInfo = new LinearLayout.LayoutParams(-2, AIOUtils.b(49.0F, localResources));
      paramUIInfo.gravity = 1;
      localDownLineButton.setLayoutParams(paramUIInfo);
      paramUIInfo = new LinearLayout(paramViewGroup.getContext());
      paramUIInfo.setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      localLayoutParams.gravity = 16;
      localLayoutParams.rightMargin = AIOUtils.b(2.0F, localResources);
      paramUIInfo.setLayoutParams(localLayoutParams);
      paramUIInfo.addView(localDownLineButton);
      paramViewGroup.addView(paramUIInfo);
      return localDownLineButton;
    }
    return null;
  }
  
  public boolean isShowRedDot(int paramInt)
  {
    VideoController localVideoController = this.mApp.b();
    int i;
    if ((localVideoController != null) && (localVideoController.k() != null)) {
      i = localVideoController.k().g;
    } else {
      i = 0;
    }
    return AVRedTouchUtil.a(this.mApp, paramInt, i);
  }
  
  public void setEffectBtnVisibility(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    if (this.mEffectBtn != null)
    {
      this.mEffectBtn.setVisibility(i);
      ((ViewGroup)this.mEffectBtn.getParent()).setVisibility(i);
    }
    if (this.mEffectBtnRedTouch != null) {
      this.mEffectBtnRedTouch.setVisibility(i);
    }
  }
  
  public void updateEffectBtnStatus()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEffectBtnStatus, EffectBtnId[");
      localStringBuilder.append(getEffectBtnId());
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.mEffectBtn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "updateEffectBtnStatus, mEffectBtn为空");
      }
      return;
    }
    int i;
    if ((VideoUtil.a(this.mApp, true)) && (!this.mApp.b().k().j()) && (getEffectBtnId() != 1)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject = this.mEffectBtn;
    boolean bool;
    if ((i != 0) && (isEffectBtnEnable())) {
      bool = true;
    } else {
      bool = false;
    }
    ((Button)localObject).setEnabled(bool);
    this.mEffectBtn.setClickable(true);
    if (getUIInfo() == null) {
      return;
    }
    int j = 2131166709;
    if ((i != 0) && (isEffectBtnNormal()))
    {
      i = j;
      if (this.mEffectBtnRedTouch != null)
      {
        this.mEffectBtnRedTouch.setHostEnable(true);
        i = j;
      }
    }
    else
    {
      if (this.mEffectBtnRedTouch != null) {
        this.mEffectBtnRedTouch.setHostEnable(false);
      }
      i = 2131168508;
    }
    localObject = AVColorStateList.a(this.mEffectBtn.getResources(), i);
    this.mEffectBtn.setTextColor((ColorStateList)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.BaseToolbarNewVersion
 * JD-Core Version:    0.7.0.1
 */