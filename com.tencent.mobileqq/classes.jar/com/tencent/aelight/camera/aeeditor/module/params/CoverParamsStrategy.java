package com.tencent.aelight.camera.aeeditor.module.params;

import com.tencent.tavcut.bean.Size;

class CoverParamsStrategy
  implements VideoParamStrategy
{
  public int a()
  {
    return 240;
  }
  
  public Size a(Size paramSize)
  {
    int i = ((Integer)ParamsUtil.a(Integer.valueOf(960), Integer.valueOf(1280), Integer.valueOf(1920))).intValue();
    Size localSize = new Size(0, 0);
    double d1 = paramSize.getWidth();
    double d2 = paramSize.getHeight();
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    if (paramSize.getWidth() > paramSize.getHeight())
    {
      localSize.setWidth(Math.min(paramSize.getWidth(), i));
      d2 = localSize.getWidth();
      Double.isNaN(d2);
      localSize.setHeight(ParamsUtil.a(d2 / d1));
      return localSize;
    }
    localSize.setHeight(Math.min(paramSize.getHeight(), i));
    d2 = localSize.getHeight();
    Double.isNaN(d2);
    localSize.setWidth(ParamsUtil.a(d2 * d1));
    return localSize;
  }
  
  public int b()
  {
    return ((Integer)ParamsUtil.a(Integer.valueOf(3145728), Integer.valueOf(4194304), Integer.valueOf(5242880))).intValue();
  }
  
  public int c()
  {
    return 30;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.params.CoverParamsStrategy
 * JD-Core Version:    0.7.0.1
 */