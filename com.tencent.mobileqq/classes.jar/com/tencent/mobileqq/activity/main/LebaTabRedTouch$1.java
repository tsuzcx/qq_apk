package com.tencent.mobileqq.activity.main;

import akai;
import akal;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import ntq;
import nyv;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class LebaTabRedTouch$1
  implements Runnable
{
  public LebaTabRedTouch$1(akai paramakai, akal paramakal) {}
  
  public void run()
  {
    label258:
    try
    {
      if (this.this$0.a != null)
      {
        localObject1 = this.this$0.a.app;
        if (localObject1 != null) {}
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      oidb_0x791.RedDotInfo localRedDotInfo;
      int i;
      QLog.e("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify Exception was thrown when update red point.", localException);
      return;
    }
    finally
    {
      if (this.a == null) {
        break label258;
      }
      this.a.a();
    }
    localObject1 = (ntq)this.this$0.a.app.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    localRedDotInfo = ((ntq)localObject1).a();
    i = -1;
    if (localRedDotInfo != null) {
      i = localRedDotInfo.uint32_appid.get();
    }
    if ((!this.this$0.a.app.getNowLiveManager().a) && (i == 11))
    {
      localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(4);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8());
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000', 'av':1}");
      QLog.i("Q.qqstory.redPointMainAssistObserver", 1, "story文字、图片红点,storyAppid:" + i);
    }
    for (;;)
    {
      this.a.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
      if (this.a == null) {
        break;
      }
      this.a.a();
      return;
      localObject1 = akai.a(this.this$0, (ntq)localObject1, null, localRedDotInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.LebaTabRedTouch.1
 * JD-Core Version:    0.7.0.1
 */