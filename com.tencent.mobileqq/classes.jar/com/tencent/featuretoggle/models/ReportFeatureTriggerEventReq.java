package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.utils.AppUtils;
import com.tencent.featuretoggle.utils.DeviceUtils;
import com.tencent.featuretoggle.utils.TimeUtil;
import java.util.ArrayList;

public final class ReportFeatureTriggerEventReq
  extends JceStruct
  implements Cloneable
{
  static ArrayList<FeatureTriggerEvent> cache_events = new ArrayList();
  public String bundleId = "";
  public String channel = "";
  public String deviceId = "";
  public ArrayList<FeatureTriggerEvent> events = null;
  public String moduleId = "";
  public String moduleVersion = "";
  public String os = "";
  public String osVersion = "";
  public String productId = "";
  public String qua = "";
  public String sdkType = "";
  public String sdkVersion = "";
  public String startTime = "";
  public String stopTime = "";
  public String uploadIp = "";
  
  static
  {
    FeatureTriggerEvent localFeatureTriggerEvent = new FeatureTriggerEvent();
    cache_events.add(localFeatureTriggerEvent);
  }
  
  public ReportFeatureTriggerEventReq() {}
  
  public ReportFeatureTriggerEventReq(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, ArrayList<FeatureTriggerEvent> paramArrayList, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    this.sdkType = paramString1;
    this.sdkVersion = paramString2;
    this.startTime = paramString3;
    this.stopTime = paramString4;
    this.productId = paramString5;
    this.moduleId = paramString6;
    this.moduleVersion = paramString7;
    this.events = paramArrayList;
    this.bundleId = paramString8;
    this.qua = paramString9;
    this.channel = paramString10;
    this.os = paramString11;
    this.osVersion = paramString12;
    this.deviceId = paramString13;
    this.uploadIp = paramString14;
  }
  
  public ReportFeatureTriggerEventReq(ArrayList<FeatureTriggerEvent> paramArrayList)
  {
    this.events = paramArrayList;
    this.sdkType = ToggleSetting.j();
    this.sdkVersion = ToggleSetting.g();
    this.startTime = TimeUtil.a();
    this.stopTime = TimeUtil.a();
    this.productId = ToggleSetting.b();
    this.moduleId = ToggleSetting.d();
    this.moduleVersion = ToggleSetting.f();
    this.bundleId = AppUtils.b(ToggleSetting.a());
    this.qua = ToggleSetting.l();
    this.channel = ToggleSetting.e();
    this.os = ToggleSetting.j();
    this.osVersion = DeviceUtils.e();
    this.deviceId = DeviceUtils.a();
    this.uploadIp = AppUtils.c(ToggleSetting.a());
  }
  
  public String className()
  {
    return "dto.ReportFeatureTriggerEventReq";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.sdkType, "sdkType");
    paramStringBuilder.display(this.sdkVersion, "sdkVersion");
    paramStringBuilder.display(this.startTime, "startTime");
    paramStringBuilder.display(this.stopTime, "stopTime");
    paramStringBuilder.display(this.productId, "productId");
    paramStringBuilder.display(this.moduleId, "moduleId");
    paramStringBuilder.display(this.moduleVersion, "moduleVersion");
    paramStringBuilder.display(this.events, "events");
    paramStringBuilder.display(this.bundleId, "bundleId");
    paramStringBuilder.display(this.qua, "qua");
    paramStringBuilder.display(this.channel, "channel");
    paramStringBuilder.display(this.os, "os");
    paramStringBuilder.display(this.osVersion, "osVersion");
    paramStringBuilder.display(this.deviceId, "deviceId");
    paramStringBuilder.display(this.uploadIp, "uploadIp");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.sdkType, true);
    paramStringBuilder.displaySimple(this.sdkVersion, true);
    paramStringBuilder.displaySimple(this.startTime, true);
    paramStringBuilder.displaySimple(this.stopTime, true);
    paramStringBuilder.displaySimple(this.productId, true);
    paramStringBuilder.displaySimple(this.moduleId, true);
    paramStringBuilder.displaySimple(this.moduleVersion, true);
    paramStringBuilder.displaySimple(this.events, true);
    paramStringBuilder.displaySimple(this.bundleId, true);
    paramStringBuilder.displaySimple(this.qua, true);
    paramStringBuilder.displaySimple(this.channel, true);
    paramStringBuilder.displaySimple(this.os, true);
    paramStringBuilder.displaySimple(this.osVersion, true);
    paramStringBuilder.displaySimple(this.deviceId, true);
    paramStringBuilder.displaySimple(this.uploadIp, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ReportFeatureTriggerEventReq)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.sdkType, paramObject.sdkType))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.sdkVersion, paramObject.sdkVersion))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.startTime, paramObject.startTime))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.stopTime, paramObject.stopTime))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.productId, paramObject.productId))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.moduleId, paramObject.moduleId))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.moduleVersion, paramObject.moduleVersion))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.events, paramObject.events))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.bundleId, paramObject.bundleId))
                    {
                      bool1 = bool2;
                      if (JceUtil.equals(this.qua, paramObject.qua))
                      {
                        bool1 = bool2;
                        if (JceUtil.equals(this.channel, paramObject.channel))
                        {
                          bool1 = bool2;
                          if (JceUtil.equals(this.os, paramObject.os))
                          {
                            bool1 = bool2;
                            if (JceUtil.equals(this.osVersion, paramObject.osVersion))
                            {
                              bool1 = bool2;
                              if (JceUtil.equals(this.deviceId, paramObject.deviceId))
                              {
                                bool1 = bool2;
                                if (JceUtil.equals(this.uploadIp, paramObject.uploadIp)) {
                                  bool1 = true;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "com.tencent.featuretoggle.models.dto.ReportFeatureTriggerEventReq";
  }
  
  public String getBundleId()
  {
    return this.bundleId;
  }
  
  public String getChannel()
  {
    return this.channel;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public ArrayList<FeatureTriggerEvent> getEvents()
  {
    return this.events;
  }
  
  public String getModuleId()
  {
    return this.moduleId;
  }
  
  public String getModuleVersion()
  {
    return this.moduleVersion;
  }
  
  public String getOs()
  {
    return this.os;
  }
  
  public String getOsVersion()
  {
    return this.osVersion;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public String getQua()
  {
    return this.qua;
  }
  
  public String getSdkType()
  {
    return this.sdkType;
  }
  
  public String getSdkVersion()
  {
    return this.sdkVersion;
  }
  
  public String getStartTime()
  {
    return this.startTime;
  }
  
  public String getStopTime()
  {
    return this.stopTime;
  }
  
  public String getUploadIp()
  {
    return this.uploadIp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sdkType = paramJceInputStream.readString(0, true);
    this.sdkVersion = paramJceInputStream.readString(1, true);
    this.startTime = paramJceInputStream.readString(2, true);
    this.stopTime = paramJceInputStream.readString(3, true);
    this.productId = paramJceInputStream.readString(4, true);
    this.moduleId = paramJceInputStream.readString(5, true);
    this.moduleVersion = paramJceInputStream.readString(6, true);
    this.events = ((ArrayList)paramJceInputStream.read(cache_events, 7, true));
    this.bundleId = paramJceInputStream.readString(8, false);
    this.qua = paramJceInputStream.readString(9, false);
    this.channel = paramJceInputStream.readString(10, false);
    this.os = paramJceInputStream.readString(11, false);
    this.osVersion = paramJceInputStream.readString(12, false);
    this.deviceId = paramJceInputStream.readString(13, false);
    this.uploadIp = paramJceInputStream.readString(14, false);
  }
  
  public void setBundleId(String paramString)
  {
    this.bundleId = paramString;
  }
  
  public void setChannel(String paramString)
  {
    this.channel = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setEvents(ArrayList<FeatureTriggerEvent> paramArrayList)
  {
    this.events = paramArrayList;
  }
  
  public void setModuleId(String paramString)
  {
    this.moduleId = paramString;
  }
  
  public void setModuleVersion(String paramString)
  {
    this.moduleVersion = paramString;
  }
  
  public void setOs(String paramString)
  {
    this.os = paramString;
  }
  
  public void setOsVersion(String paramString)
  {
    this.osVersion = paramString;
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
  
  public void setQua(String paramString)
  {
    this.qua = paramString;
  }
  
  public void setSdkType(String paramString)
  {
    this.sdkType = paramString;
  }
  
  public void setSdkVersion(String paramString)
  {
    this.sdkVersion = paramString;
  }
  
  public void setStartTime(String paramString)
  {
    this.startTime = paramString;
  }
  
  public void setStopTime(String paramString)
  {
    this.stopTime = paramString;
  }
  
  public void setUploadIp(String paramString)
  {
    this.uploadIp = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sdkType, 0);
    paramJceOutputStream.write(this.sdkVersion, 1);
    paramJceOutputStream.write(this.startTime, 2);
    paramJceOutputStream.write(this.stopTime, 3);
    paramJceOutputStream.write(this.productId, 4);
    paramJceOutputStream.write(this.moduleId, 5);
    paramJceOutputStream.write(this.moduleVersion, 6);
    paramJceOutputStream.write(this.events, 7);
    String str = this.bundleId;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.qua;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.channel;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.os;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.osVersion;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    str = this.deviceId;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    str = this.uploadIp;
    if (str != null) {
      paramJceOutputStream.write(str, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.models.ReportFeatureTriggerEventReq
 * JD-Core Version:    0.7.0.1
 */