package com.tencent.aelight.camera.aeeditor.module.params;

public class ParamFactory
{
  public static ImageParamStrategy a()
  {
    return new DefaultImageParamStrategy();
  }
  
  public static VideoParamStrategy a()
  {
    return new DefaultVideoParamStrategy();
  }
  
  public static VideoParamStrategy b()
  {
    return new CoverParamsStrategy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.params.ParamFactory
 * JD-Core Version:    0.7.0.1
 */