package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;

class RIJProteusMethod$MethodDecodeEmotion
  implements CustomMethodsRegister.CustomMethodInterface
{
  public Object invoke(String paramString, Object... paramVarArgs)
  {
    String str = "";
    paramString = str;
    if (paramVarArgs != null)
    {
      paramString = str;
      if (paramVarArgs.length >= 1) {
        paramString = EmotionCodecUtils.b(String.valueOf(paramVarArgs[0]));
      }
    }
    return new QQText(paramString, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.RIJProteusMethod.MethodDecodeEmotion
 * JD-Core Version:    0.7.0.1
 */