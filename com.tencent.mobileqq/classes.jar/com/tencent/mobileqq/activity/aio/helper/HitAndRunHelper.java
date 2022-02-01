package com.tencent.mobileqq.activity.aio.helper;

import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PttConstants;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.popanim.IPopOutEmoticonAnim;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class HitAndRunHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  
  HitAndRunHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    ((ISttManagerApi)QRoute.api(ISttManagerApi.class)).initAutoToTextSwitch(this.a.d);
    Object localObject = this.a.d.getApp().getSharedPreferences("check_update_sp_key", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessinfo_ptt_slice_to_text_");
    localStringBuilder.append(this.a.d.getCurrentAccountUin());
    PttConstants.l = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
    localObject = (PttAutoChangeBean)QConfigManager.b().b(442);
    try
    {
      if (!PttConstants.h)
      {
        if ((int)(Long.valueOf(this.a.d.getCurrentAccountUin()).longValue() / 1000L % 1000L) > ((PttAutoChangeBean)localObject).b())
        {
          PttConstants.j = true;
          return;
        }
        PttConstants.j = false;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("error=");
        localStringBuilder.append(localException.toString());
        QLog.d("PttAutoChange", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void b() {}
  
  public String getTag()
  {
    return "HitAndRunHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 11, 8 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 8)
    {
      if (paramInt != 11)
      {
        if (paramInt != 15) {
          return;
        }
        ShortVideoItemBuilder.j();
        ShortVideoRealItemBuilder.j();
        return;
      }
      ((AvatarPendantManager)this.a.d.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).c();
      StickerBubbleAnimationHelper.a(this.a.ba);
      ((IPopOutEmoticonAnim)QRoute.api(IPopOutEmoticonAnim.class)).stopAndCleanPopOutAnim();
      return;
    }
    a();
    ThreadManager.post(new HitAndRunHelper.1(this), 5, null, true);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pttAutoChangeTxt =");
      localStringBuilder.append(PttConstants.f);
      localStringBuilder.append(" hasAddGrayTip =");
      localStringBuilder.append(PttConstants.h);
      localStringBuilder.append(" grayTipPerThousandStatus=");
      localStringBuilder.append(PttConstants.j);
      QLog.d("PttAutoChange", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Test.a());
    localStringBuilder.append(new Test().c());
    QLog.d("HitAndRunHelper", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HitAndRunHelper
 * JD-Core Version:    0.7.0.1
 */