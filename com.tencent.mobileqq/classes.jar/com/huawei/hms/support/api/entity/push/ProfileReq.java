package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class ProfileReq
  implements IMessageEntity
{
  @Packed
  public int operation;
  @Packed
  public String pkgName;
  @Packed
  public String profileId;
  @Packed
  public String subjectId;
  @Packed
  public int type;
  
  public int getOperation()
  {
    return this.operation;
  }
  
  public String getPkgName()
  {
    return this.pkgName;
  }
  
  public String getProfileId()
  {
    return this.profileId;
  }
  
  public String getSubjectId()
  {
    return this.subjectId;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setOperation(int paramInt)
  {
    this.operation = paramInt;
  }
  
  public void setPkgName(String paramString)
  {
    this.pkgName = paramString;
  }
  
  public void setProfileId(String paramString)
  {
    this.profileId = paramString;
  }
  
  public void setSubjectId(String paramString)
  {
    this.subjectId = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ProfileReq.class.getName());
    localStringBuilder.append("{ pkgName: ");
    localStringBuilder.append(this.pkgName);
    localStringBuilder.append(",subjectId: ");
    localStringBuilder.append(this.subjectId);
    localStringBuilder.append(",operation: ");
    localStringBuilder.append(this.operation);
    localStringBuilder.append(" type: ");
    localStringBuilder.append(this.type);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.push.ProfileReq
 * JD-Core Version:    0.7.0.1
 */