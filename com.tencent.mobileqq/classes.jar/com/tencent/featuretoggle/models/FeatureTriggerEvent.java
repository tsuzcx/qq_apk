package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.utils.Utils;

public final class FeatureTriggerEvent
  extends JceStruct
  implements Cloneable
{
  public String abTestId = "-1";
  public String datasetID = "";
  public long eventCount = 0L;
  public String featureName = "";
  public String featureValue = "";
  public String featureVersionId = "";
  public String qimei = "";
  public String sn = "";
  public String userId = "";
  public String versionID = "";
  
  public FeatureTriggerEvent()
  {
    this.sn = Utils.a();
    this.userId = ToggleSetting.i();
    this.qimei = ToggleSetting.a();
  }
  
  public FeatureTriggerEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8, String paramString9)
  {
    this.sn = paramString1;
    this.featureVersionId = paramString2;
    this.featureName = paramString3;
    this.featureValue = paramString4;
    this.abTestId = paramString5;
    this.userId = paramString6;
    this.eventCount = paramLong;
    this.qimei = paramString7;
    this.datasetID = paramString8;
    this.versionID = paramString9;
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
    paramStringBuilder.display(this.sn, "sn");
    paramStringBuilder.display(this.featureVersionId, "featureVersionId");
    paramStringBuilder.display(this.featureName, "featureName");
    paramStringBuilder.display(this.featureValue, "featureValue");
    paramStringBuilder.display(this.abTestId, "abTestId");
    paramStringBuilder.display(this.userId, "userId");
    paramStringBuilder.display(this.eventCount, "eventCount");
    paramStringBuilder.display(this.qimei, "qimei");
    paramStringBuilder.display(this.datasetID, "datasetID");
    paramStringBuilder.display(this.versionID, "versionID");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.sn, true);
    paramStringBuilder.displaySimple(this.featureVersionId, true);
    paramStringBuilder.displaySimple(this.featureName, true);
    paramStringBuilder.displaySimple(this.featureValue, true);
    paramStringBuilder.displaySimple(this.abTestId, true);
    paramStringBuilder.displaySimple(this.userId, true);
    paramStringBuilder.displaySimple(this.eventCount, true);
    paramStringBuilder.displaySimple(this.qimei, true);
    paramStringBuilder.displaySimple(this.datasetID, true);
    paramStringBuilder.displaySimple(this.versionID, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (FeatureTriggerEvent)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.sn, paramObject.sn))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.featureVersionId, paramObject.featureVersionId))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.featureName, paramObject.featureName))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.featureValue, paramObject.featureValue))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.abTestId, paramObject.abTestId))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.userId, paramObject.userId))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.eventCount, paramObject.eventCount))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.qimei, paramObject.qimei))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.datasetID, paramObject.datasetID))
                    {
                      bool1 = bool2;
                      if (JceUtil.equals(this.versionID, paramObject.versionID)) {
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
    return bool1;
  }
  
  public String getAbTestId()
  {
    return this.abTestId;
  }
  
  public String getDatasetID()
  {
    return this.datasetID;
  }
  
  public long getEventCount()
  {
    return this.eventCount;
  }
  
  public String getFeatureName()
  {
    return this.featureName;
  }
  
  public String getFeatureValue()
  {
    return this.featureValue;
  }
  
  public String getFeatureVersionId()
  {
    return this.featureVersionId;
  }
  
  public String getQimei()
  {
    return this.qimei;
  }
  
  public String getSn()
  {
    return this.sn;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public String getVersionID()
  {
    return this.versionID;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sn = paramJceInputStream.readString(0, true);
    this.featureVersionId = paramJceInputStream.readString(1, true);
    this.featureName = paramJceInputStream.readString(2, true);
    this.featureValue = paramJceInputStream.readString(3, true);
    this.abTestId = paramJceInputStream.readString(4, true);
    this.userId = paramJceInputStream.readString(5, true);
    this.eventCount = paramJceInputStream.read(this.eventCount, 6, true);
    this.qimei = paramJceInputStream.readString(7, false);
    this.datasetID = paramJceInputStream.readString(8, false);
    this.versionID = paramJceInputStream.readString(9, false);
  }
  
  public void setAbTestId(String paramString)
  {
    this.abTestId = paramString;
  }
  
  public void setDatasetID(String paramString)
  {
    this.datasetID = paramString;
  }
  
  public void setEventCount(long paramLong)
  {
    this.eventCount = paramLong;
  }
  
  public void setFeatureName(String paramString)
  {
    this.featureName = paramString;
  }
  
  public void setFeatureValue(String paramString)
  {
    this.featureValue = paramString;
  }
  
  public void setFeatureVersionId(String paramString)
  {
    this.featureVersionId = paramString;
  }
  
  public void setQimei(String paramString)
  {
    this.qimei = paramString;
  }
  
  public void setSn(String paramString)
  {
    this.sn = paramString;
  }
  
  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
  
  public void setVersionID(String paramString)
  {
    this.versionID = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sn, 0);
    paramJceOutputStream.write(this.featureVersionId, 1);
    paramJceOutputStream.write(this.featureName, 2);
    paramJceOutputStream.write(this.featureValue, 3);
    paramJceOutputStream.write(this.abTestId, 4);
    paramJceOutputStream.write(this.userId, 5);
    paramJceOutputStream.write(this.eventCount, 6);
    String str = this.qimei;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.datasetID;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.versionID;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.models.FeatureTriggerEvent
 * JD-Core Version:    0.7.0.1
 */