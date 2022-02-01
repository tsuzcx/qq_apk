package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class RIJProteusMethod
  implements CustomMethodsRegister.CustomMethodInterface
{
  private Map<String, CustomMethodsRegister.CustomMethodInterface> a = new HashMap();
  
  public RIJProteusMethod()
  {
    a();
  }
  
  private void a()
  {
    a("decodeEmotion", new RIJProteusMethod.MethodDecodeEmotion(null));
    a("HyperLinkClick", new RIJProteusMethod.MethodHyperLink(null));
  }
  
  public void a(String paramString, CustomMethodsRegister.CustomMethodInterface paramCustomMethodInterface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramCustomMethodInterface == null)) {
      return;
    }
    this.a.put(paramString, paramCustomMethodInterface);
  }
  
  public Object invoke(String paramString, Object... paramVarArgs)
  {
    QLog.d("RIJProteusMethod", 1, "invoke,s=" + paramString);
    if (this.a.containsKey(paramString)) {
      return ((CustomMethodsRegister.CustomMethodInterface)this.a.get(paramString)).invoke(paramString, paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.RIJProteusMethod
 * JD-Core Version:    0.7.0.1
 */