package com.tencent.mobileqq.apollo.makeup;

public class CmShowErrorCode
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case -5030: 
      return "装扮资源下载失败，请稍后再试。";
    case -5031: 
      return "角色资源下载失败，请稍后再试。";
    case -5033: 
    case -5032: 
      return "3D引擎加载失败，请稍后再试。";
    }
    return "3D引擎初始化失败，请稍后再试。";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowErrorCode
 * JD-Core Version:    0.7.0.1
 */