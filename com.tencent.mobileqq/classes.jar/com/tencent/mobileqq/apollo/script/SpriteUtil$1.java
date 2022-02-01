package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.statistics.CmShowStatUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.qphone.base.util.QLog;

final class SpriteUtil$1
  extends IApolloRunnableTask
{
  SpriteUtil$1(String paramString, ApolloEngine paramApolloEngine, int paramInt) {}
  
  public int a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      return i;
    }
    return super.a();
  }
  
  public void run()
  {
    ApolloEngine localApolloEngine = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine;
    if (localApolloEngine != null) {
      localApolloEngine.execScriptString(this.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_JavaLangString.contains("CMShowDefActionName"))
      {
        CmShowStatUtil.b("exeCmshow0");
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.contains("commonInit")) {
        CmShowStatUtil.b("exeCommon");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUtil.1
 * JD-Core Version:    0.7.0.1
 */