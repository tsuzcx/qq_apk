package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class LocationPlugin$1$1
  extends LbsManagerServiceOnLocationChangeListener
{
  LocationPlugin$1$1(LocationPlugin.1 param1, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationFinish errCode = ");
      localStringBuilder.append(paramInt);
      QLog.e("LocationPlugin", 2, localStringBuilder.toString());
    }
    LocationPlugin.a(this.a.jdField_a_of_type_ComTencentBizWebviewpluginLocationPlugin, paramSosoLbsInfo, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.LocationPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */