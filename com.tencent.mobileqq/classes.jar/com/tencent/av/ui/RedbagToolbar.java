package com.tencent.av.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import bhmi;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lff;
import lpm;
import ltx;
import mbb;
import mch;
import mjh;
import mji;
import mpu;
import mpv;
import mqg;
import mqq;
import mqr;

public class RedbagToolbar
  extends BaseToolbar
{
  private static final String TAG = "RedbagToolbar";
  int mDisableType = 0;
  String mTips = null;
  mch mUIInfo = null;
  
  public RedbagToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  public static boolean getRedBagBtnStatus(VideoAppInterface paramVideoAppInterface, mji parammji)
  {
    boolean bool1 = false;
    Object localObject1 = null;
    mpv localmpv = mqr.a(paramVideoAppInterface);
    Object localObject2 = localmpv.a();
    int n = localmpv.a();
    int i;
    int k;
    int m;
    boolean bool2;
    if ((localObject2 != null) && (((mpu)localObject2).c))
    {
      i = 1;
      k = paramVideoAppInterface.a().a().F;
      m = paramVideoAppInterface.a().a().j;
      bool2 = lpm.g();
      if (i != 0) {
        break label615;
      }
      if (!TextUtils.isEmpty(null)) {
        break label610;
      }
      localObject1 = paramVideoAppInterface.getApp().getString(2131695186);
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
          localObject2 = paramVideoAppInterface.getApp().getString(2131695183);
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
          localObject1 = paramVideoAppInterface.getApp().getString(2131695184);
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
            localObject2 = paramVideoAppInterface.getApp().getString(2131695181);
            j = i;
          }
        }
        if (j == 0) {
          bool1 = true;
        }
        bool2 = localmpv.c();
        bool3 = localmpv.a();
        i = j;
        localObject1 = localObject2;
        if (bool2)
        {
          localmpv.e();
          j |= 0x40;
          i = j;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = paramVideoAppInterface.getApp().getString(2131695187);
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
            localObject2 = paramVideoAppInterface.getApp().getString(2131695179);
            j = i;
          }
        }
        localObject1 = new StringBuilder().append("isEnable, relationType[").append(k).append("], uinType[").append(m).append("], loadPTuSoStatus[").append(paramVideoAppInterface.a().k()).append("], soloadedPTV[").append(GraphicRenderMgr.soloadedPTV).append("], ptuSoVersion[").append(GraphicRenderMgr.ptuSoVersion).append("], tips[").append((String)localObject2).append("], diableType[");
        if (parammji == null) {}
        break;
      }
      for (paramVideoAppInterface = Integer.valueOf(parammji.jdField_a_of_type_Int);; paramVideoAppInterface = "null")
      {
        QLog.d("RedbagToolbar", 1, paramVideoAppInterface + "->" + j + "], bLight[" + bool1 + "], peerInSendMode[" + bool2 + "], selfInGameMode[" + bool3 + "]");
        if (parammji != null)
        {
          parammji.jdField_a_of_type_Int = j;
          parammji.jdField_a_of_type_JavaLangString = ((String)localObject2);
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
        localObject1 = paramVideoAppInterface.getApp().getString(2131695180);
        i = j;
        break label204;
        j |= 0x8;
        i = j;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label204;
        }
        localObject1 = paramVideoAppInterface.getApp().getString(2131695182);
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
  
  public void exitCurrentToolbar()
  {
    this.mApp.a(new Object[] { Integer.valueOf(8003), Integer.valueOf(getEffectBtnId()) });
  }
  
  protected mch getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mch();
      this.mUIInfo.d = 7;
      this.mUIInfo.f = 2131559785;
      this.mUIInfo.e = 2130842263;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131695313);
      this.mUIInfo.c = 2130842264;
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
    mji localmji = new mji();
    localmji.jdField_a_of_type_Int = this.mDisableType;
    boolean bool = getRedBagBtnStatus(this.mApp, localmji);
    this.mTips = localmji.jdField_a_of_type_JavaLangString;
    this.mDisableType = localmji.jdField_a_of_type_Int;
    return bool;
  }
  
  public void onButtonClick(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    super.onButtonClick(paramInt, paramBoolean1, paramBoolean2);
    if (paramInt == getEffectBtnId()) {
      return;
    }
    mpv localmpv = mqr.a(this.mApp);
    if (localmpv != null) {
      localmpv.d();
    }
    if (this.mDisableType == 0)
    {
      paramBoolean1 = true;
      label47:
      ltx.b(paramBoolean1, String.valueOf(this.mDisableType));
      if (this.mDisableType != 0) {
        break label93;
      }
    }
    label93:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      mqq.a(paramBoolean1, this.mDisableType);
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
      mpv localmpv;
      do
      {
        return;
        localmpv = mqr.a(this.mApp);
      } while ((localmpv == null) || ((AVActivity)this.mActivity.get() == null));
      if (this.mDisableType == 0)
      {
        String str = mqr.b();
        paramBoolean = bhmi.b(str);
        if ((paramBoolean) && (mqg.a(this.mApp)))
        {
          localmpv.a(true);
          new mqg(localmpv).a(new mjh(this, localmpv));
          return;
        }
        QLog.w("RedbagToolbar", 1, "startActivity_SendRedBag, guide_mp4[" + str + "], fileExistsAndNotEmpty[" + paramBoolean + "], seq[" + paramLong + "]");
        startActivity_SendRedBag(false);
        return;
      }
    } while (TextUtils.isEmpty(this.mTips));
    mbb.a(this.mApp, 1042, this.mTips);
  }
  
  public boolean startActivity_SendRedBag(boolean paramBoolean)
  {
    mpv localmpv = mqr.a(this.mApp);
    if (localmpv == null) {}
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
      if (!localmpv.a(localAVActivity, 1)) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (this.mDisableType != 0) {
        mbb.a(this.mApp, 1042, this.mTips);
      }
      return paramBoolean;
      this.mTips = localAVActivity.getResources().getString(2131695185);
      this.mDisableType = 67108864;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.RedbagToolbar
 * JD-Core Version:    0.7.0.1
 */