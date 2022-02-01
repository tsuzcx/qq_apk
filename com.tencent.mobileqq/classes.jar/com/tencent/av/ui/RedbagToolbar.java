package com.tencent.av.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.redpacket.AVRedPacketDataCollector;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.redbag.AVRedBagConfig.Info;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.GuideTip2;
import com.tencent.av.ui.redbag.RedBagReport;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

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
    boolean bool1 = false;
    Object localObject1 = null;
    AVRedBagMgr localAVRedBagMgr = RedBagUtil.a(paramVideoAppInterface);
    Object localObject2 = localAVRedBagMgr.a();
    int n = localAVRedBagMgr.a();
    int i;
    int k;
    int m;
    boolean bool2;
    if ((localObject2 != null) && (((AVRedBagConfig.Info)localObject2).c))
    {
      i = 1;
      k = paramVideoAppInterface.a().a().F;
      m = paramVideoAppInterface.a().a().j;
      bool2 = EffectsRenderController.g();
      if (i != 0) {
        break label615;
      }
      if (!TextUtils.isEmpty(null)) {
        break label610;
      }
      localObject1 = paramVideoAppInterface.getApp().getString(2131695783);
      i = 1;
    }
    for (;;)
    {
      int j = i;
      localObject2 = localObject1;
      if (!bool2)
      {
        i |= 0x2;
        j = i;
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = paramVideoAppInterface.getApp().getString(2131695780);
          j = i;
        }
      }
      i = j;
      localObject1 = localObject2;
      label204:
      boolean bool3;
      switch (n)
      {
      default: 
        j |= 0x10;
        i = j;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = paramVideoAppInterface.getApp().getString(2131695781);
          i = j;
        }
      case 1: 
        j = i;
        localObject2 = localObject1;
        if (m != 0)
        {
          i |= 0x20;
          j = i;
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = paramVideoAppInterface.getApp().getString(2131695778);
            j = i;
          }
        }
        if (j == 0) {
          bool1 = true;
        }
        bool2 = localAVRedBagMgr.c();
        bool3 = localAVRedBagMgr.a();
        i = j;
        localObject1 = localObject2;
        if (bool2)
        {
          localAVRedBagMgr.e();
          j |= 0x40;
          i = j;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = paramVideoAppInterface.getApp().getString(2131695784);
            i = j;
          }
        }
        j = i;
        localObject2 = localObject1;
        if (bool3)
        {
          i |= 0x80;
          j = i;
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = paramVideoAppInterface.getApp().getString(2131695776);
            j = i;
          }
        }
        localObject1 = new StringBuilder().append("isEnable, relationType[").append(k).append("], uinType[").append(m).append("], loadPTuSoStatus[").append(paramVideoAppInterface.a().j()).append("], soloadedPTV[").append(GraphicRenderMgr.soloadedPTV).append("], ptuSoVersion[").append(GraphicRenderMgr.ptuSoVersion).append("], tips[").append((String)localObject2).append("], diableType[");
        if (paramRedBagBtnStatus == null) {}
        break;
      }
      for (paramVideoAppInterface = Integer.valueOf(paramRedBagBtnStatus.jdField_a_of_type_Int);; paramVideoAppInterface = "null")
      {
        QLog.d("RedbagToolbar", 1, paramVideoAppInterface + "->" + j + "], bLight[" + bool1 + "], peerInSendMode[" + bool2 + "], selfInGameMode[" + bool3 + "]");
        if (paramRedBagBtnStatus != null)
        {
          paramRedBagBtnStatus.jdField_a_of_type_Int = j;
          paramRedBagBtnStatus.jdField_a_of_type_JavaLangString = ((String)localObject2);
        }
        return bool1;
        i = 0;
        break;
        j |= 0x4;
        i = j;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label204;
        }
        localObject1 = paramVideoAppInterface.getApp().getString(2131695777);
        i = j;
        break label204;
        j |= 0x8;
        i = j;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label204;
        }
        localObject1 = paramVideoAppInterface.getApp().getString(2131695779);
        i = j;
        break label204;
      }
      label610:
      i = 1;
      continue;
      label615:
      i = 0;
    }
  }
  
  public boolean canShowToolbar()
  {
    isEffectBtnEnable();
    return this.mDisableType == 0;
  }
  
  void exitCurrentToolbar()
  {
    this.mApp.a(new Object[] { Integer.valueOf(8003), Integer.valueOf(getEffectBtnId()) });
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      this.mUIInfo.d = 7;
      this.mUIInfo.g = 2131559900;
      this.mUIInfo.f = 2130842462;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131695912);
      this.mUIInfo.c = 2130842463;
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
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (paramInt == getEffectBtnId()) {}
    do
    {
      AVRedBagMgr localAVRedBagMgr;
      do
      {
        return;
        localAVRedBagMgr = RedBagUtil.a(this.mApp);
      } while ((localAVRedBagMgr == null) || ((AVActivity)this.mActivity.get() == null));
      if (this.mDisableType == 0)
      {
        String str = RedBagUtil.b();
        paramBoolean = FileUtils.b(str);
        if ((paramBoolean) && (GuideTip2.a(this.mApp)))
        {
          localAVRedBagMgr.a(true);
          new GuideTip2(localAVRedBagMgr).a(new RedbagToolbar.1(this, localAVRedBagMgr));
          return;
        }
        QLog.w("RedbagToolbar", 1, "startActivity_SendRedBag, guide_mp4[" + str + "], fileExistsAndNotEmpty[" + paramBoolean + "], seq[" + paramLong + "]");
        startActivity_SendRedBag(false);
        return;
      }
    } while (TextUtils.isEmpty(this.mTips));
    TipsUtil.a(this.mApp, 1042, this.mTips);
  }
  
  boolean startActivity_SendRedBag(boolean paramBoolean)
  {
    AVRedBagMgr localAVRedBagMgr = RedBagUtil.a(this.mApp);
    if (localAVRedBagMgr == null) {}
    AVActivity localAVActivity;
    do
    {
      return false;
      localAVActivity = (AVActivity)this.mActivity.get();
    } while (localAVActivity == null);
    if (paramBoolean) {
      isEffectBtnEnable();
    }
    if (this.mDisableType == 0) {
      if (!localAVRedBagMgr.a(localAVActivity, 1)) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (this.mDisableType != 0) {
        TipsUtil.a(this.mApp, 1042, this.mTips);
      }
      return paramBoolean;
      this.mTips = localAVActivity.getResources().getString(2131695782);
      this.mDisableType = 67108864;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.RedbagToolbar
 * JD-Core Version:    0.7.0.1
 */