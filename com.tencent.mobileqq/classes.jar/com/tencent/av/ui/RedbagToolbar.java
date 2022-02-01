package com.tencent.av.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lfe;
import lph;
import lts;
import mbf;
import mcl;
import mjm;
import mjn;
import mqa;
import mqb;
import mqm;
import mqw;
import mqx;

public class RedbagToolbar
  extends BaseToolbar
{
  private static final String TAG = "RedbagToolbar";
  int mDisableType = 0;
  String mTips = null;
  mcl mUIInfo = null;
  
  public RedbagToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  public static boolean getRedBagBtnStatus(VideoAppInterface paramVideoAppInterface, mjn parammjn)
  {
    boolean bool1 = false;
    Object localObject1 = null;
    mqb localmqb = mqx.a(paramVideoAppInterface);
    Object localObject2 = localmqb.a();
    int n = localmqb.a();
    int i;
    int k;
    int m;
    boolean bool2;
    if ((localObject2 != null) && (((mqa)localObject2).c))
    {
      i = 1;
      k = paramVideoAppInterface.a().a().F;
      m = paramVideoAppInterface.a().a().j;
      bool2 = lph.g();
      if (i != 0) {
        break label615;
      }
      if (!TextUtils.isEmpty(null)) {
        break label610;
      }
      localObject1 = paramVideoAppInterface.getApp().getString(2131695542);
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
          localObject2 = paramVideoAppInterface.getApp().getString(2131695539);
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
          localObject1 = paramVideoAppInterface.getApp().getString(2131695540);
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
            localObject2 = paramVideoAppInterface.getApp().getString(2131695537);
            j = i;
          }
        }
        if (j == 0) {
          bool1 = true;
        }
        bool2 = localmqb.c();
        bool3 = localmqb.a();
        i = j;
        localObject1 = localObject2;
        if (bool2)
        {
          localmqb.e();
          j |= 0x40;
          i = j;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = paramVideoAppInterface.getApp().getString(2131695543);
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
            localObject2 = paramVideoAppInterface.getApp().getString(2131695535);
            j = i;
          }
        }
        localObject1 = new StringBuilder().append("isEnable, relationType[").append(k).append("], uinType[").append(m).append("], loadPTuSoStatus[").append(paramVideoAppInterface.a().k()).append("], soloadedPTV[").append(GraphicRenderMgr.soloadedPTV).append("], ptuSoVersion[").append(GraphicRenderMgr.ptuSoVersion).append("], tips[").append((String)localObject2).append("], diableType[");
        if (parammjn == null) {}
        break;
      }
      for (paramVideoAppInterface = Integer.valueOf(parammjn.jdField_a_of_type_Int);; paramVideoAppInterface = "null")
      {
        QLog.d("RedbagToolbar", 1, paramVideoAppInterface + "->" + j + "], bLight[" + bool1 + "], peerInSendMode[" + bool2 + "], selfInGameMode[" + bool3 + "]");
        if (parammjn != null)
        {
          parammjn.jdField_a_of_type_Int = j;
          parammjn.jdField_a_of_type_JavaLangString = ((String)localObject2);
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
        localObject1 = paramVideoAppInterface.getApp().getString(2131695536);
        i = j;
        break label204;
        j |= 0x8;
        i = j;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label204;
        }
        localObject1 = paramVideoAppInterface.getApp().getString(2131695538);
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
  
  protected mcl getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mcl();
      this.mUIInfo.d = 7;
      this.mUIInfo.f = 2131559824;
      this.mUIInfo.e = 2130842319;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131695669);
      this.mUIInfo.c = 2130842320;
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
    mjn localmjn = new mjn();
    localmjn.jdField_a_of_type_Int = this.mDisableType;
    boolean bool = getRedBagBtnStatus(this.mApp, localmjn);
    this.mTips = localmjn.jdField_a_of_type_JavaLangString;
    this.mDisableType = localmjn.jdField_a_of_type_Int;
    return bool;
  }
  
  public void onButtonClick(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    super.onButtonClick(paramInt, paramBoolean1, paramBoolean2);
    if (paramInt == getEffectBtnId()) {
      return;
    }
    mqb localmqb = mqx.a(this.mApp);
    if (localmqb != null) {
      localmqb.d();
    }
    if (this.mDisableType == 0)
    {
      paramBoolean1 = true;
      label47:
      lts.b(paramBoolean1, String.valueOf(this.mDisableType));
      if (this.mDisableType != 0) {
        break label93;
      }
    }
    label93:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      mqw.a(paramBoolean1, this.mDisableType);
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
      mqb localmqb;
      do
      {
        return;
        localmqb = mqx.a(this.mApp);
      } while ((localmqb == null) || ((AVActivity)this.mActivity.get() == null));
      if (this.mDisableType == 0)
      {
        String str = mqx.b();
        paramBoolean = FileUtils.fileExistsAndNotEmpty(str);
        if ((paramBoolean) && (mqm.a(this.mApp)))
        {
          localmqb.a(true);
          new mqm(localmqb).a(new mjm(this, localmqb));
          return;
        }
        QLog.w("RedbagToolbar", 1, "startActivity_SendRedBag, guide_mp4[" + str + "], fileExistsAndNotEmpty[" + paramBoolean + "], seq[" + paramLong + "]");
        startActivity_SendRedBag(false);
        return;
      }
    } while (TextUtils.isEmpty(this.mTips));
    mbf.a(this.mApp, 1042, this.mTips);
  }
  
  public boolean startActivity_SendRedBag(boolean paramBoolean)
  {
    mqb localmqb = mqx.a(this.mApp);
    if (localmqb == null) {}
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
      if (!localmqb.a(localAVActivity, 1)) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (this.mDisableType != 0) {
        mbf.a(this.mApp, 1042, this.mTips);
      }
      return paramBoolean;
      this.mTips = localAVActivity.getResources().getString(2131695541);
      this.mDisableType = 67108864;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.RedbagToolbar
 * JD-Core Version:    0.7.0.1
 */