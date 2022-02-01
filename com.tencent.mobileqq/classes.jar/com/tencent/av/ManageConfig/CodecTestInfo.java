package com.tencent.av.ManageConfig;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import java.util.List;

public class CodecTestInfo
{
  @Alias(a="testInfos")
  public List<CodecTestInfo.TestInfos> a;
  
  public static CodecTestInfo a(String paramString)
  {
    return (CodecTestInfo)JSONConverter.a(paramString, CodecTestInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ManageConfig.CodecTestInfo
 * JD-Core Version:    0.7.0.1
 */