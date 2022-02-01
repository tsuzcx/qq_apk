package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;

class SubProcessPromotionMgr$1
  extends BroadcastReceiver
{
  SubProcessPromotionMgr$1(SubProcessPromotionMgr paramSubProcessPromotionMgr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      if (!"tencent.businessnotify.qq.to.subprocess".equals(paramIntent.getAction())) {
        return;
      }
      if (paramIntent.getIntExtra("bussinessType", 0) != 2) {
        return;
      }
      int i = paramIntent.getIntExtra("event", 0);
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramContext = paramIntent.getStringExtra("config_Content");
        this.a.b(paramContext);
        if (this.a.a != null) {
          this.a.a.b();
        }
      }
      else
      {
        paramContext = paramIntent.getStringExtra("bussinessSubName");
        i = paramIntent.getIntExtra("download_Index", 0);
        int j = paramIntent.getIntExtra("download_Progress", 0);
        if (QQAudioHelper.c())
        {
          paramIntent = this.a.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("receive notify, index[");
          localStringBuilder.append(i);
          localStringBuilder.append("], progress[");
          localStringBuilder.append(j);
          localStringBuilder.append("]");
          QLog.w(paramIntent, 1, localStringBuilder.toString());
        }
        if (this.a.a != null) {
          this.a.a.b(paramContext, i, j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.SubProcessPromotionMgr.1
 * JD-Core Version:    0.7.0.1
 */