package com.tencent.mobileqq.app.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Xml;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.NewUpgradeConfig.Dialog;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import org.xmlpull.v1.XmlPullParser;
import protocol.KQQConfig.UpgradeInfo;
import zwo;

public class UpgradeDetailWrapper
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new zwo();
  static String a;
  public int a;
  public ApkUpdateDetail a;
  public NewUpgradeConfig a;
  public UpgradeDetailWrapper.NewApkInfo a;
  public UpgradeInfo a;
  public boolean a;
  public int b;
  public UpgradeInfo b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UpgradeDetailWrapper";
  }
  
  public UpgradeDetailWrapper(UpgradeInfo paramUpgradeInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramApkUpdateDetail;
  }
  
  public void a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "parsed wrapper info:\nmTempUpgradeInfo.iUpgradeSdkId=" + this.b.iUpgradeSdkId + "\nmTempUpgradeInfo.iUpgradeType=" + this.b.iUpgradeType + "\nmTempUpgradeInfo.strUrl=" + this.b.strUrl + "\nmTempUpgradeInfo.strUpgradePageUrl=" + this.b.strUpgradePageUrl + "\nmTempUpgradeInfo.strNewUpgradeDescURL=" + this.b.strNewUpgradeDescURL + "\nmTempUpgradeInfo.iActionType=" + this.b.iActionType + "\nmTempUpgradeInfo.bNewSwitch=" + this.b.bNewSwitch + "\nmTempUpgradeInfo.iIncrementUpgrade=" + this.b.iIncrementUpgrade + "\nmTempUpgradeInfo.iTipsType=" + this.b.iTipsType + "\nmTempUpgradeInfo.strProgressName=" + this.b.strProgressName + "\nmTempUpgradeInfo.strNewSoftwareURL=" + this.b.strNewSoftwareURL + "\nmTempUpgradeInfo.strNewSoftwareMD5=" + this.b.strNewSoftwareMD5 + "\nmTempUpgradeInfo.bGray=" + this.b.bGray + "\nmTempUpgradeInfo.strButtonDesc=" + this.b.strButtonDesc + "\nmTempUpgradeInfo.strCancelButtonDesc=" + this.b.strCancelButtonDesc + "\nmTempUpgradeInfo.strTitle=" + this.b.strTitle + "\nmTempUpgradeInfo.strUpgradeDesc=" + this.b.strUpgradeDesc + "\nmNewUpgradeConfig.dialog.id=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Int + "\nmNewUpgradeConfig.dialog.name=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.time=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Long + "\nmNewUpgradeConfig.dialog.showTime=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_Long + "\nmNewUpgradeConfig.dialog.title=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.content=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.c + "\nmNewUpgradeConfig.dialog.desc=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.d + "\nmNewUpgradeConfig.dialog.installFail=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.e + "\nmNewUpgradeConfig.dialog.info=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.f + "\nmNewUpgradeConfig.dialog.rate=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_Int + "\nmNewUpgradeConfig.dialog.barContent=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.g + "\nmNewUpgradeConfig.dialog.barContent2=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.h + "\nmNewUpgradeConfig.dialog.lBtnText=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.i + "\nmNewUpgradeConfig.dialog.rBtnText=" + this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.j + "\npreloadSwitchConfigValue=" + this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString)
  {
    if (this.b == null) {
      this.b = new UpgradeInfo();
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
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Long = OlympicUtil.a(localXmlPullParser.nextText());
        break;
      }
      if (paramString.equalsIgnoreCase("showTime"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_Long = OlympicUtil.a(localXmlPullParser.nextText());
        break;
      }
      if (paramString.equalsIgnoreCase("title"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString = localXmlPullParser.nextText();
        this.b.strTitle = this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString;
        break;
      }
      if (paramString.equalsIgnoreCase("content"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.c = localXmlPullParser.nextText();
        this.b.strUpgradeDesc = this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.c;
        break;
      }
      if (paramString.equalsIgnoreCase("desc"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.d = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("installFail"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.e = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("info"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.f = localXmlPullParser.nextText();
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
      if (paramString.equalsIgnoreCase("preDownloadYYB"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Boolean = localXmlPullParser.nextText().equals("1");
        break;
      }
      if (paramString.equalsIgnoreCase("iUpgradeSdkId"))
      {
        this.b.iUpgradeSdkId = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("iUpgradeType"))
      {
        this.b.iUpgradeType = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("iDownloadPageUrl"))
      {
        this.b.strUrl = localXmlPullParser.nextText();
        this.b.strUpgradePageUrl = this.b.strUrl;
        this.b.strNewUpgradeDescURL = this.b.strUrl;
        break;
      }
      if (paramString.equalsIgnoreCase("iActionType"))
      {
        this.b.iActionType = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("bNewSwitch"))
      {
        this.b.bNewSwitch = Byte.valueOf(localXmlPullParser.nextText()).byteValue();
        break;
      }
      if (paramString.equalsIgnoreCase("iIncrementUpgrade"))
      {
        this.b.iIncrementUpgrade = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("iTipsType"))
      {
        this.b.iTipsType = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (paramString.equalsIgnoreCase("strProgressName"))
      {
        this.b.strProgressName = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("strNewSoftwareURL"))
      {
        this.b.strNewSoftwareURL = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("strNewSoftwareMD5"))
      {
        this.b.strNewSoftwareMD5 = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("bGray"))
      {
        this.b.bGray = Byte.valueOf(localXmlPullParser.nextText()).byteValue();
        break;
      }
      if (paramString.equalsIgnoreCase("strButtonDesc"))
      {
        this.b.strButtonDesc = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("strCancelButtonDesc"))
      {
        this.b.strCancelButtonDesc = localXmlPullParser.nextText();
        break;
      }
      if (paramString.equalsIgnoreCase("iNewTimeStamp"))
      {
        this.b.iNewTimeStamp = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        break;
      }
      if (!paramString.equalsIgnoreCase("strNewTipsDescURL")) {
        break;
      }
      this.b.strNewTipsDescURL = localXmlPullParser.nextText();
      break;
      this.b.iAppid = AppSetting.jdField_a_of_type_Int;
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