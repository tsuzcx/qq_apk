package com.tencent.mobileqq.activity.aio.helper;

import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PttSlideStateHelper;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
import com.tencent.mobileqq.utils.PttUtils;
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
    PttUtils.a(this.a.a);
    PttSlideStateHelper.h = this.a.a.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.a.getCurrentAccountUin(), false);
    PttAutoChangeBean localPttAutoChangeBean = (PttAutoChangeBean)QConfigManager.a().a(442);
    try
    {
      if (!PttSlideStateHelper.d)
      {
        if ((int)(Long.valueOf(this.a.a.getCurrentAccountUin()).longValue() / 1000L % 1000L) > localPttAutoChangeBean.a())
        {
          PttSlideStateHelper.f = true;
          return;
        }
        PttSlideStateHelper.f = false;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChange", 2, "error=" + localException.toString());
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
    return new int[] { 10, 7 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 10: 
    case 7: 
      do
      {
        return;
        ((AvatarPendantManager)this.a.a.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).c();
        StickerBubbleAnimationHelper.a(this.a.d);
        return;
        a();
        ThreadManager.post(new HitAndRunHelper.1(this), 5, null, true);
      } while (!QLog.isColorLevel());
      QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + PttSlideStateHelper.c + " hasAddGrayTip =" + PttSlideStateHelper.d + " grayTipPerThousandStatus=" + PttSlideStateHelper.f);
      return;
    }
    ShortVideoItemBuilder.g();
    ShortVideoRealItemBuilder.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HitAndRunHelper
 * JD-Core Version:    0.7.0.1
 */