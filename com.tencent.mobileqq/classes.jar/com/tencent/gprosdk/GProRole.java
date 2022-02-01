package com.tencent.gprosdk;

public final class GProRole
{
  final boolean mIsBind;
  final String mRoleDescribe;
  final String mRoleId;
  final String mRoleName;
  
  public GProRole(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.mRoleId = paramString1;
    this.mRoleName = paramString2;
    this.mRoleDescribe = paramString3;
    this.mIsBind = paramBoolean;
  }
  
  public boolean getIsBind()
  {
    return this.mIsBind;
  }
  
  public String getRoleDescribe()
  {
    return this.mRoleDescribe;
  }
  
  public String getRoleId()
  {
    return this.mRoleId;
  }
  
  public String getRoleName()
  {
    return this.mRoleName;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProRole{mRoleId=");
    localStringBuilder.append(this.mRoleId);
    localStringBuilder.append(",mRoleName=");
    localStringBuilder.append(this.mRoleName);
    localStringBuilder.append(",mRoleDescribe=");
    localStringBuilder.append(this.mRoleDescribe);
    localStringBuilder.append(",mIsBind=");
    localStringBuilder.append(this.mIsBind);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProRole
 * JD-Core Version:    0.7.0.1
 */