package com.tencent.av.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketDataCollector;
import com.tencent.av.ui.redbag.AVRedBagConfig.Info;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.GuideTip2;
import com.tencent.av.ui.redbag.RedBagReport;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kcf;

public class RedbagToolbar
  extends BaseToolbar
{
  private static final String TAG = "RedbagToolbar";
  int mDisableType = 0;
  String mTips = null;
  BaseToolbar.UIInfo mUIInfo = null;
  
  public RedbagToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  public static boolean getRedBagBtnStatus(VideoAppInterface paramVideoAppInterface, RedbagToolbar.RedBagBtnStatus paramRedBagBtnStatus)
  {
    boolean bool3 = false;
    Object localObject1 = null;
    AVRedBagMgr localAVRedBagMgr = RedBagUtil.a(paramVideoAppInterface);
    Object localObject2 = localAVRedBagMgr.a();
    int i1 = localAVRedBagMgr.a();
    int i;
    int m;
    int n;
    int j;
    boolean bool2;
    boolean bool1;
    if ((localObject2 != null) && (((AVRedBagConfig.Info)localObject2).c))
    {
      i = 1;
      m = paramVideoAppInterface.a().a().F;
      n = paramVideoAppInterface.a().a().i;
      j = paramVideoAppInterface.a().j();
      if (j != VideoController.u) {
        break label632;
      }
      bool2 = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
      bool1 = PtvFilterSoLoad.a();
    }
    for (;;)
    {
      int k = j;
      if (j == VideoController.u)
      {
        k = j;
        if (bool2)
        {
          k = j;
          if (bool1) {
            k = VideoController.v;
          }
        }
      }
      if (i == 0) {
        if (TextUtils.isEmpty(null))
        {
          localObject1 = "正在下载资源，请稍后再试。";
          i = 1;
        }
      }
      for (;;)
      {
        j = i;
        localObject2 = localObject1;
        if (k == VideoController.w)
        {
          i |= 0x2;
          j = i;
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = "正在下载游戏引擎，请稍后再试。";
            j = i;
          }
        }
        i = j;
        localObject1 = localObject2;
        if (i1 != 1)
        {
          i = j;
          localObject1 = localObject2;
        }
        label253:
        boolean bool4;
        boolean bool5;
        switch (i1)
        {
        default: 
          j |= 0x10;
          i = j;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = "对方QQ版本不支持抢红包。";
            i = j;
          }
        case 1: 
          j = i;
          localObject2 = localObject1;
          if (n != 0)
          {
            i |= 0x20;
            j = i;
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = "请先添加对方好友，才能玩视频电话红包。";
              j = i;
            }
          }
          if (j == 0) {
            bool3 = true;
          }
          bool4 = localAVRedBagMgr.c();
          bool5 = localAVRedBagMgr.a();
          i = j;
          localObject1 = localObject2;
          if (bool4)
          {
            localAVRedBagMgr.e();
            j |= 0x40;
            i = j;
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = "对方正在包红包，请稍后再发。";
              i = j;
            }
          }
          j = i;
          localObject2 = localObject1;
          if (bool5)
          {
            i |= 0x80;
            j = i;
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = "正在游戏中，请稍后再发红包。";
              j = i;
            }
          }
          localObject1 = new StringBuilder().append("isEnable, relationType[").append(m).append("], uinType[").append(n).append("], loadPTuSoStatus[").append(paramVideoAppInterface.a().j()).append("], ptuSo[").append(bool2).append("], ptuSoVersion[").append(bool1).append("], tips[").append((String)localObject2).append("], diableType[");
          if (paramRedBagBtnStatus == null) {}
          break;
        }
        for (paramVideoAppInterface = Integer.valueOf(paramRedBagBtnStatus.jdField_a_of_type_Int);; paramVideoAppInterface = "null")
        {
          QLog.d("RedbagToolbar", 1, paramVideoAppInterface + "->" + j + "], bLight[" + bool3 + "], peerInSendMode[" + bool4 + "], selfInGameMode[" + bool5 + "]");
          if (paramRedBagBtnStatus != null)
          {
            paramRedBagBtnStatus.jdField_a_of_type_Int = j;
            paramRedBagBtnStatus.jdField_a_of_type_JavaLangString = ((String)localObject2);
          }
          return bool3;
          i = 0;
          break;
          j |= 0x4;
          i = j;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label253;
          }
          localObject1 = "对方的设备型号不支持抢红包。";
          i = j;
          break label253;
          j |= 0x8;
          i = j;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label253;
          }
          localObject1 = "对方资源未下载完成，无法抢红包。";
          i = j;
          break label253;
        }
        i = 1;
        continue;
        i = 0;
      }
      label632:
      bool1 = false;
      bool2 = false;
    }
  }
  
  public boolean canShowToolbar()
  {
    isEffectBtnEnable();
    return this.mDisableType == 0;
  }
  
  public void exitCurrentToolbar()
  {
    this.mApp.a(new Object[] { Integer.valueOf(8003), Integer.valueOf(getEffectBtnId()) });
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      this.mUIInfo.d = 7;
      this.mUIInfo.g = 2130969361;
      this.mUIInfo.e = 103418;
      this.mUIInfo.f = 2130840359;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getResources().getString(2131428747);
      this.mUIInfo.c = 2130840360;
      this.mUIInfo.jdField_a_of_type_Int = 0;
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    return this.mTips;
  }
  
  public boolean isEffectBtnEnable()
  {
    if (this.mApp == null) {
      return false;
    }
    RedbagToolbar.RedBagBtnStatus localRedBagBtnStatus = new RedbagToolbar.RedBagBtnStatus();
    localRedBagBtnStatus.jdField_a_of_type_Int = this.mDisableType;
    boolean bool = getRedBagBtnStatus(this.mApp, localRedBagBtnStatus);
    this.mTips = localRedBagBtnStatus.jdField_a_of_type_JavaLangString;
    this.mDisableType = localRedBagBtnStatus.jdField_a_of_type_Int;
    return bool;
  }
  
  public void onButtonClick(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    super.onButtonClick(paramInt, paramBoolean1, paramBoolean2);
    if (paramInt == getEffectBtnId()) {
      return;
    }
    AVRedBagMgr localAVRedBagMgr = RedBagUtil.a(this.mApp);
    if (localAVRedBagMgr != null) {
      localAVRedBagMgr.d();
    }
    if (this.mDisableType == 0)
    {
      paramBoolean1 = true;
      label47:
      AVRedPacketDataCollector.b(paramBoolean1, String.valueOf(this.mDisableType));
      if (this.mDisableType != 0) {
        break label93;
      }
    }
    label93:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      RedBagReport.a(paramBoolean1, this.mDisableType);
      if (this.mDisableType == 0) {
        break;
      }
      exitCurrentToolbar();
      return;
      paramBoolean1 = false;
      break label47;
    }
  }
  
  protected void onCreate(AVActivity paramAVActivity) {}
  
  protected void onDestroy(VideoAppInterface paramVideoAppInterface) {}
  
  protected void onHide() {}
  
  protected void onShow(int paramInt, boolean paramBoolean)
  {
    if (paramInt == getEffectBtnId()) {}
    AVActivity localAVActivity;
    do
    {
      AVRedBagMgr localAVRedBagMgr;
      do
      {
        do
        {
          return;
          localAVRedBagMgr = RedBagUtil.a(this.mApp);
        } while (localAVRedBagMgr == null);
        localAVActivity = (AVActivity)this.mActivity.get();
      } while (localAVActivity == null);
      if (this.mDisableType == 0)
      {
        if (GuideTip2.a(this.mApp))
        {
          localAVRedBagMgr.a(true);
          new GuideTip2(localAVRedBagMgr).a(new kcf(this, localAVRedBagMgr));
          return;
        }
        startActivity_SendRedBag(false);
        return;
      }
    } while (TextUtils.isEmpty(this.mTips));
    localAVActivity.a(80, this.mTips, 3000L, 1);
  }
  
  public boolean startActivity_SendRedBag(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AVRedBagMgr localAVRedBagMgr = RedBagUtil.a(this.mApp);
    if (localAVRedBagMgr == null) {}
    AVActivity localAVActivity;
    do
    {
      return bool1;
      localAVActivity = (AVActivity)this.mActivity.get();
    } while (localAVActivity == null);
    if (paramBoolean) {
      isEffectBtnEnable();
    }
    paramBoolean = bool2;
    if (this.mDisableType == 0) {
      if (!localAVRedBagMgr.a(localAVActivity, 1)) {
        break label94;
      }
    }
    for (paramBoolean = true;; paramBoolean = bool2)
    {
      bool1 = paramBoolean;
      if (this.mDisableType == 0) {
        break;
      }
      localAVActivity.a(80, this.mTips, 3000L, 1);
      return paramBoolean;
      label94:
      this.mTips = "操作失败。";
      this.mDisableType = 67108864;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.RedbagToolbar
 * JD-Core Version:    0.7.0.1
 */