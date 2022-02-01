package com.tencent.av.abtest;

import com.tencent.mobileqq.utils.abtest.IOnlineExpProvider;
import java.util.Arrays;
import java.util.List;

public class QavOnlineExpProviderImpl
  implements IOnlineExpProvider
{
  public List<String> getRegisterExpNameList()
  {
    return Arrays.asList(QavABTestConstants.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.abtest.QavOnlineExpProviderImpl
 * JD-Core Version:    0.7.0.1
 */