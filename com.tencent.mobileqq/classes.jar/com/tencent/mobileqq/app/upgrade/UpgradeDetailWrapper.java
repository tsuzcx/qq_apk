package com.tencent.mobileqq.app.upgrade;

import altj;
import amlt;
import amlu;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Xml;
import avxz;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import org.xmlpull.v1.XmlPullParser;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeDetailWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<UpgradeDetailWrapper> CREATOR = new amlt();
  static String a;
  public int a;
  public amlu a;
  public ApkUpdateDetail a;
  public NewUpgradeConfig a;
  public UpgradeInfo a;
  public boolean a;
  public int b;
  public String b;
  public UpgradeInfo b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UpgradeDetailWrapper";
  }
  
  public UpgradeDetailWrapper(UpgradeInfo paramUpgradeInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramApkUpdateDetail;
  }
  
  public void a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "parsed wrapper info:\nmTempUpgradeInfo.iUpgradeSdkId=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId + "\nmTempUpgradeInfo.iUpgradeType=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType + "\nmTempUpgradeInfo.strUrl=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl + "\nmTempUpgradeInfo.strUpgradePageUrl=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradePageUrl + "\nmTempUpgradeInfo.strNewUpgradeDescURL=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL + "\nmTempUpgradeInfo.iActionType=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iActionType + "\nmTempUpgradeInfo.bNewSwitch=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch + "\nmTempUpgradeInfo.iIncrementUpgrade=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade + "\nmTempUpgradeInfo.iTipsType=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType + "\nmTempUpgradeInfo.strProgressName=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName + "\nmTempUpgradeInfo.strNewSoftwareURL=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL + "\nmTempUpgradeInfo.strNewSoftwareMD5=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareMD5 + "\nmTempUpgradeInfo.bGray=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bGray + "\nmTempUpgradeInfo.strButtonDesc=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc + "\nmTempUpgradeInfo.strCancelButtonDesc=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc + "\nmTempUpgradeInfo.strTitle=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strTitle + "\nmTempUpgradeInfo.strUpgradeDesc=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc + "\nmNewUpgradeConfig.dialog.id=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Int + "\nmNewUpgradeConfig.dialog.name=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.time=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Long + "\nmNewUpgradeConfig.dialog.showTime=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_Long + "\nmNewUpgradeConfig.dialog.title=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.content=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_c_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.desc=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_d_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.installFail=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_e_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.info=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_f_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.rate=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_Int + "\nmNewUpgradeConfig.dialog.barContent=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.g + "\nmNewUpgradeConfig.dialog.barContent2=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.h + "\nmNewUpgradeConfig.dialog.lBtnText=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.i + "\nmNewUpgradeConfig.dialog.rBtnText=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.j + "\nmNewUpgradeConfig.dialog.downloadDialogMaxTimes=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_c_of_type_Int + "\nmNewUpgradeConfig.dialog.downloadDialogDayRate=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_d_of_type_Int + "\nmNewUpgradeConfig.dialog.installDialogMaxTimes=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_e_of_type_Int + "\nmNewUpgradeConfig.dialog.installDialogDayRate=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_f_of_type_Int + "\npreloadSwitchConfigValue=" + this.jdField_a_of_type_Int + "\njumpMarketSupportPhone=" + this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo == null) {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo = new UpgradeInfo();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig = NewUpgradeConfig.getInstance();
      this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.prepareDialog();
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    try
    {
      localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      int i = localXmlPullParser.getEventType();
      if (i != 1)
      {
        if (i == 2)
        {
          paramString = localXmlPullParser.getName();
          if (!paramString.equalsIgnoreCase("configId")) {
            break label129;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        }
        for (;;)
        {
          i = localXmlPullParser.next();
          break;
          label129:
          if (!paramString.equalsIgnoreCase("taskName")) {
            break label212;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_JavaLangString = localXmlPullParser.nextText();
        }
        a();
      }
    }
    catch (Exception paramString)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog = null;
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "updateDialogParseFail : " + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
    for (;;)
    {
      return;
      label212:
      if (paramString.equalsIgnoreCase("taskTime"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Long = avxz.a(localXmlPullParser.nextText());
        break;
      }
      if (paramString.equalsIgnoreCase("showTime"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_Long = avxz.a(localXmlPullParser.nextText());
        break;
      }
      if (paramString.equalsIgnoreCase("title"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString = localXmlPullParser.nextText();
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strTitle = this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString;
        break;
      }
      if (paramString.equalsIgnoreCase("content"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_c_of_type_JavaLangString = localXmlPullParser.nextText();
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc = this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_c_of_type_JavaLangString;
        break;
      }
      if (paramString.equalsIgnoreCase("desc"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_d_of_type_JavaLangString = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("installFail"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_e_of_type_JavaLangString = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("info"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_f_of_type_JavaLangString = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("yellowBar"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("barContent"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.g = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("barContent2"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.h = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("lBtnText"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.i = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("rBtnText"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.j = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("downloadDialogMaxTimes"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_c_of_type_Int = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("downloadDialogDayRate"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_d_of_type_Int = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("installDialogMaxTimes"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_e_of_type_Int = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("installDialogDayRate"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_f_of_type_Int = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("status"))
      {
        paramString = localXmlPullParser.nextText();
        if ("on".equalsIgnoreCase(paramString))
        {
          this.jdField_a_of_type_Int = 1;
          break;
        }
        if (!"off".equalsIgnoreCase(paramString)) {
          break;
        }
        this.jdField_a_of_type_Int = 2;
        break;
      }
      if (paramString.equalsIgnoreCase("jumpMarketSupportPhone"))
      {
        this.jdField_b_of_type_JavaLangString = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("preDownloadYYB"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Boolean = localXmlPullParser.nextText().equals("1");
        break;
      }
      if (paramString.equalsIgnoreCase("iUpgradeSdkId"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("iUpgradeType"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("iDownloadPageUrl"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl = localXmlPullParser.nextText();
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradePageUrl = this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl;
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL = this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl;
        break;
      }
      if (paramString.equalsIgnoreCase("iActionType"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iActionType = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("bNewSwitch"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch = Byte.valueOf(localXmlPullParser.nextText()).byteValue();
        break;
      }
      if (paramString.equalsIgnoreCase("iIncrementUpgrade"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("iTipsType"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("strProgressName"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("strNewSoftwareURL"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("strNewSoftwareMD5"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareMD5 = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("bGray"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bGray = Byte.valueOf(localXmlPullParser.nextText()).byteValue();
        break;
      }
      if (paramString.equalsIgnoreCase("strButtonDesc"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("strCancelButtonDesc"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("iNewTimeStamp"))
      {
        this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (!paramString.equalsIgnoreCase("strNewTipsDescURL")) {
        break;
      }
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewTipsDescURL = localXmlPullParser.nextText();
      break;
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iAppid = AppSetting.a();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid);
      paramParcel.writeByte(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bAppType);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUrl);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iActionType);
      paramParcel.writeByte(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradePageUrl);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strBannerPicUrl);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iDisplayDay);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsWaitDay);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewTipsDescURL);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    }
    while (this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.fileMd5);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.newapksize);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.packageName);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.patchsize);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.sigMd5);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.versioncode);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.versionname);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper
 * JD-Core Version:    0.7.0.1
 */