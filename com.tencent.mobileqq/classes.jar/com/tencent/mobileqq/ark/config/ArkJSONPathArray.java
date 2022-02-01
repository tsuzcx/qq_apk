package com.tencent.mobileqq.ark.config;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ArkJSONPathArray
  extends ArkJSONPathElement
{
  private int a;
  
  public ArkJSONPathArray(int paramInt)
  {
    this.a = paramInt;
  }
  
  public Object a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    paramObject = (ArrayList)paramObject;
    if (!(paramObject instanceof ArrayList))
    {
      QLog.e("ArkMsgReplyConfigMgr", 1, "getElement instance wrong");
      return null;
    }
    int i = this.a;
    if (i >= 0)
    {
      if (i >= paramObject.size()) {
        return null;
      }
      return paramObject.get(this.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.ArkJSONPathArray
 * JD-Core Version:    0.7.0.1
 */