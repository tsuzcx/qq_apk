package com.tencent.mobileqq.activity.richmedia;

import android.os.Handler;
import com.qq.im.poi.LbsPackObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class LBSDetetor$LBSDetectorObserver
  extends LbsPackObserver
{
  private LBSDetetor$LBSDetectorObserver(LBSDetetor paramLBSDetetor) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetLBSTemplateIds:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" req:");
      localStringBuilder.append(paramInt);
      QLog.d("LBSDetetor", 2, localStringBuilder.toString());
    }
    if ((LBSDetetor.a(this.a) != null) && (LBSDetetor.a(this.a).hasMessages(paramInt))) {
      LBSDetetor.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.LBSDetetor.LBSDetectorObserver
 * JD-Core Version:    0.7.0.1
 */