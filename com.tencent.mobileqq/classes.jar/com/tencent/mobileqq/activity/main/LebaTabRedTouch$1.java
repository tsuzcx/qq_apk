package com.tencent.mobileqq.activity.main;

import akgw;
import akgz;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import nlb;
import nql;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class LebaTabRedTouch$1
  implements Runnable
{
  public LebaTabRedTouch$1(akgw paramakgw, akgz paramakgz) {}
  
  public void run()
  {
    label257:
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
        break label257;
      }
      this.a.a();
    }
    localObject1 = (nlb)this.this$0.a.app.getManager(70);
    localRedDotInfo = ((nlb)localObject1).a();
    i = -1;
    if (localRedDotInfo != null) {
      i = localRedDotInfo.uint32_appid.get();
    }
    if ((!this.this$0.a.app.a().a) && (i == 11))
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
      localObject1 = akgw.a(this.this$0, (nlb)localObject1, null, localRedDotInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.LebaTabRedTouch.1
 * JD-Core Version:    0.7.0.1
 */