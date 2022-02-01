package com.tencent.device.qfind;

class QFindBLEScanMgr$GroupLogItem
{
  String a;
  String b;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof GroupLogItem))) {
      return paramObject.hashCode() == hashCode();
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = this.a;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localStringBuilder.append(str1);
    str2 = this.b;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localStringBuilder.append(str1);
    return localStringBuilder.toString().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.GroupLogItem
 * JD-Core Version:    0.7.0.1
 */