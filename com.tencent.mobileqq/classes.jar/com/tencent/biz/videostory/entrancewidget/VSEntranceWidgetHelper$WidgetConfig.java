package com.tencent.biz.videostory.entrancewidget;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class VSEntranceWidgetHelper$WidgetConfig
{
  public String a;
  private boolean jdField_a_of_type_Boolean;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public VSEntranceWidgetHelper$WidgetConfig(VSEntranceWidgetHelper paramVSEntranceWidgetHelper, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void a(String paramString)
  {
    Object localObject1 = new File(paramString);
    if (((File)localObject1).exists())
    {
      this.jdField_a_of_type_Boolean = true;
      localObject1 = Arrays.asList(((File)localObject1).list());
      Object localObject2;
      if (((List)localObject1).contains("bg@2x.png"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append("bg@2x.png");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (new File((String)localObject2).exists()) {
          this.c = ((String)localObject2);
        } else {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      if (((List)localObject1).contains("camera@2x.png"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append("camera@2x.png");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (new File((String)localObject2).exists()) {
          this.d = ((String)localObject2);
        } else {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      if (((List)localObject1).contains("point@2x.png"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append("point@2x.png");
        paramString = ((StringBuilder)localObject1).toString();
        if (new File(paramString).exists())
        {
          this.e = paramString;
          return;
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isResourceReady:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, localStringBuilder.toString());
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetHelper.WidgetConfig
 * JD-Core Version:    0.7.0.1
 */