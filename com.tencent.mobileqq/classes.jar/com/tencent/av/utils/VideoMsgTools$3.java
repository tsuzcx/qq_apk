package com.tencent.av.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class VideoMsgTools$3
  implements Runnable
{
  VideoMsgTools$3(int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    int i = this.a;
    if ((i == 12) || (i == 25) || (i == 42) || (i == 43) || (i == 56)) {
      VipFunCallUtil.a(this.b, 0);
    }
    ((ISVIPHandler)this.b.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).j();
    StringBuilder localStringBuilder;
    if (!this.c)
    {
      i = this.a;
      if (((i == 0) || (i == 2) || (i == 24)) && (this.d != null) && (LightalkBlueTipsBar.d()))
      {
        localObject = this.b.getPreferences();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("lightalk_tip_");
        localStringBuilder.append(this.e);
        if (!((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LightalkBlueTipsBar", 2, "addBubbleVideoMsg() : TYPE_ON_SHOW =====>");
          }
          localObject = ((SharedPreferences)localObject).edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("lightalk_tip_");
          localStringBuilder.append(this.e);
          ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), true);
          ((SharedPreferences.Editor)localObject).putString("Lightalk_tips_frdUin", this.f);
          ((SharedPreferences.Editor)localObject).commit();
          i = 1;
          break label247;
        }
      }
    }
    i = 0;
    label247:
    int j = VipFunCallUtil.a(this.b);
    Object localObject = this.b;
    int k = VipFunCallUtil.a((AppRuntime)localObject, ((QQAppInterface)localObject).getAccount(), 6, true, null);
    if ((j != 0) && (j != k))
    {
      localObject = this.b;
      VipFunCallUtil.a((AppRuntime)localObject, this.f, ((QQAppInterface)localObject).getAccount());
      if ((!this.c) && (i == 0))
      {
        localObject = this.b.getPreferences();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("funcall_tip_");
        localStringBuilder.append(this.f);
        i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
        if (i < 3)
        {
          localObject = ((SharedPreferences)localObject).edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("funcall_tip_");
          localStringBuilder.append(this.f);
          ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i + 1);
          ((SharedPreferences.Editor)localObject).commit();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.3
 * JD-Core Version:    0.7.0.1
 */