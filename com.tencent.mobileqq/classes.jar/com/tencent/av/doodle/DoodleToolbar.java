package com.tencent.av.doodle;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.ui.effect.toolbar.oldversion.BaseToolbarOldVersion;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class DoodleToolbar
  extends BaseToolbarOldVersion
{
  private DoodleLogic mDoodleLogic = null;
  BaseToolbar.UIInfo mUIInfo = null;
  
  public DoodleToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 3;
      localUIInfo.h = 2131625809;
      localUIInfo.f = 2130843006;
      localUIInfo.g = this.mApp.getApp().getString(2131893687);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    return DoodleController.a((Context)this.mActivity.get());
  }
  
  public boolean isEffectBtnEnable()
  {
    return true ^ isOpenAvatar2D(true);
  }
  
  public boolean isEffectBtnNormal()
  {
    return (!isOpenAvatar2D(true)) && (DoodleController.a());
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    onHide(paramLong);
  }
  
  protected void onHide(long paramLong)
  {
    DoodleController.b(paramLong, (AVActivity)this.mActivity.get());
    ((AVActivity)this.mActivity.get()).K.I(paramLong);
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    DoodleController.a(paramLong, (AVActivity)this.mActivity.get());
    ((AVActivity)this.mActivity.get()).K.ai();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleToolbar
 * JD-Core Version:    0.7.0.1
 */