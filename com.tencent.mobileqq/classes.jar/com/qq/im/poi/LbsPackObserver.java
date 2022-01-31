package com.qq.im.poi;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

public class LbsPackObserver
  implements BusinessObserver
{
  public static final int NOTIFY_CHANGE_ARMAP_ANGLE = 6;
  public static final int NOTIFY_GET_LBS_DATA = 5;
  public static final int NOTIFY_GET_LBS_PACK_ID = 1;
  public static final int NOTIFY_GET_LBS_TEMPLATE = 7;
  public static final int NOTIFY_GET_RED_PACK_PAGE = 4;
  public static final int NOTIFY_GET_SENDER_NICK = 2;
  public static final int NOTIFY_GET_SEND_POI_LIST = 0;
  public static final int NOTIFY_REPORT_OPEN_PACK_RESULT = 3;
  static final String TAG = "LbsPack";
  
  public void changeMapViewAngle(double paramDouble1, double paramDouble2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "handleChangeMapViewAngle= " + paramDouble1 + "|" + paramDouble2);
    }
  }
  
  public void onGetLBSPoiList(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onGetLBSPoiList, isSuccess  = " + paramBoolean);
    }
  }
  
  public void onGetLBSTemplateIds(int paramInt, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void onGetLbsPid(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onGetRedPackPage(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onGetRedPackPage, isSuccess  = " + paramBoolean);
    }
  }
  
  public void onGetSendPOIList(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onGetSenderNick(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, new Object[] { "onUpdata, type=", Integer.valueOf(paramInt), ", isSuccess=", Boolean.valueOf(paramBoolean) });
    }
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      do
      {
        return;
        onGetSendPOIList(paramBoolean, paramBundle);
        return;
        onGetLbsPid(paramBoolean, paramBundle);
        return;
        onGetSenderNick(paramBoolean, paramBundle);
        return;
        onReportOpenLbsPack(paramBoolean, paramBundle);
        return;
        onGetRedPackPage(paramBoolean, paramBundle);
        return;
        onGetLBSPoiList(paramBoolean, paramBundle);
        return;
      } while (paramBundle == null);
      changeMapViewAngle(paramBundle.getDouble("latitude"), paramBundle.getDouble("longitude"));
      return;
    }
    ArrayList localArrayList = null;
    paramInt = i;
    if (paramBundle != null)
    {
      localArrayList = paramBundle.getStringArrayList("key_lbs_template_ids");
      paramInt = paramBundle.getInt("key_lbs_template_cookie", -1);
    }
    onGetLBSTemplateIds(paramInt, paramBoolean, localArrayList);
  }
  
  public void onReportOpenLbsPack(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackObserver
 * JD-Core Version:    0.7.0.1
 */