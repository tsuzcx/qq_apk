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
    if (this.a == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str);
      if (this.b != null) {
        break label54;
      }
    }
    label54:
    for (String str = "";; str = this.b)
    {
      return str.hashCode();
      str = this.a;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.GroupLogItem
 * JD-Core Version:    0.7.0.1
 */