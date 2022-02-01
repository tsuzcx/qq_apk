package com.tencent.mobileqq.activity.aio;

import NS_GROUP_COUNT.mobile_batch_get_profile_count_rsp;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

public class AIOTroopQzoneRedDotManager
  implements Manager, BusinessObserver
{
  private WeakReference<QQAppInterface> a;
  
  public AIOTroopQzoneRedDotManager(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public QQAppInterface a()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null) {
      return (QQAppInterface)localWeakReference.get();
    }
    return null;
  }
  
  public void a(QzoneTroopReddotRequest paramQzoneTroopReddotRequest, int paramInt)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(localQQAppInterface.getApplication(), QZoneCommonServlet.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("request_uinlist_size", paramInt);
    localQzoneCommonIntent.setRequest(paramQzoneTroopReddotRequest);
    localQzoneCommonIntent.putExtras(localBundle);
    localQzoneCommonIntent.setObserver(this);
    localQQAppInterface.startServlet(localQzoneCommonIntent);
  }
  
  public void onDestroy() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      QZLog.e("AIOTroopQzoneRedDotManager", "onReceive isSuccess == false");
      return;
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QZLog.e("AIOTroopQzoneRedDotManager", "onReceive app == null");
      return;
    }
    JceStruct localJceStruct = (JceStruct)paramBundle.getSerializable("key_response");
    int i = paramBundle.getInt("key_response_code");
    String str = paramBundle.getString("key_response_msg");
    int j = paramBundle.getInt("request_uinlist_size");
    if ((i == 0) && (paramInt == 0) && ((localJceStruct instanceof mobile_batch_get_profile_count_rsp)))
    {
      if (((mobile_batch_get_profile_count_rsp)localJceStruct).profileCountItems.size() == j)
      {
        localQQAppInterface.notifyObservers(AIOTroopQcircleRedDotManager.class, paramInt, true, paramBundle);
        return;
      }
      QZLog.e("AIOTroopQzoneRedDotManager", "onReceive is failed, reqUinList.size() != rspUinList.size()");
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onReceive is failed, msg == ");
    paramBundle.append(str);
    QZLog.e("AIOTroopQzoneRedDotManager", paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQzoneRedDotManager
 * JD-Core Version:    0.7.0.1
 */