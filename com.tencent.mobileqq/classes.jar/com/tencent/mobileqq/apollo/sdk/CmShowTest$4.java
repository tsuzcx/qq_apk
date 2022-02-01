package com.tencent.mobileqq.apollo.sdk;

import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;

final class CmShowTest$4
  implements Runnable
{
  CmShowTest$4(CmShowRenderView paramCmShowRenderView) {}
  
  public void run()
  {
    PlayActionConfig localPlayActionConfig = new PlayActionConfig();
    localPlayActionConfig.jdField_a_of_type_Int = 300272;
    int i = RenderViewController.jdField_a_of_type_Int + 1;
    RenderViewController.jdField_a_of_type_Int = i;
    localPlayActionConfig.jdField_b_of_type_Int = i;
    localPlayActionConfig.jdField_b_of_type_Boolean = true;
    localPlayActionConfig.c = 2;
    localPlayActionConfig.jdField_a_of_type_Boolean = true;
    localPlayActionConfig.jdField_a_of_type_JavaLangString = "1174992642";
    this.a.a(localPlayActionConfig);
    this.a.postDelayed(new CmShowTest.4.1(this), 4000L);
    this.a.a("1669140032", "测试空间气泡", 1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowTest.4
 * JD-Core Version:    0.7.0.1
 */