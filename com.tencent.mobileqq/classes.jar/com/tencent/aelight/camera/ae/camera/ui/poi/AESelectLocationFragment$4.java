package com.tencent.aelight.camera.ae.camera.ui.poi;

import LBS_V2_PROTOCOL.GPS_V2;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.mobileqq.qzone.api.impl.util.Soso;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

class AESelectLocationFragment$4
  extends LbsManagerServiceOnLocationChangeListener
{
  AESelectLocationFragment$4(AESelectLocationFragment paramAESelectLocationFragment, String paramString1, boolean paramBoolean, String paramString2)
  {
    super(paramString1, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo == null) {
      return;
    }
    GPS_V2 localGPS_V2 = Soso.a(paramSosoLbsInfo.mLocation);
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    paramSosoLbsInfo = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramSosoLbsInfo = LbsManager.POIListRequestSession.a();
      paramSosoLbsInfo.a(this.jdField_a_of_type_JavaLangString);
    }
    localLbsManager.a(new BasicLocation(localGPS_V2.iLat, localGPS_V2.iLon, localGPS_V2.eType), paramSosoLbsInfo, new AESelectLocationFragment.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment.4
 * JD-Core Version:    0.7.0.1
 */