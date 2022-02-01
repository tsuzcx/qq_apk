package com.tencent.mobileqq.ark.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

class ArkJSONPathObject
  extends ArkJSONPathElement
{
  private String a;
  
  public ArkJSONPathObject(String paramString)
  {
    this.a = paramString;
  }
  
  public Object a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    paramObject = (LinkedHashMap)paramObject;
    if (!(paramObject instanceof LinkedHashMap))
    {
      QLog.e("ArkMsgReplyConfigMgr", 1, "getElement instance wrong");
      return null;
    }
    if (TextUtils.isEmpty(this.a)) {
      return null;
    }
    return paramObject.get(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.ArkJSONPathObject
 * JD-Core Version:    0.7.0.1
 */