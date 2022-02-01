package com.tencent.mobileqq.apollo.sdk;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.CmShowStatUtil;
import com.tencent.qphone.base.util.QLog;

class CmShowSpriteAioScript$1
  extends IApolloRunnableTask
{
  CmShowSpriteAioScript$1(CmShowSpriteAioScript paramCmShowSpriteAioScript, String paramString, IApolloRenderView paramIApolloRenderView, int paramInt, boolean paramBoolean) {}
  
  public int a()
  {
    if (this.jdField_a_of_type_Int != 0) {
      return this.jdField_a_of_type_Int;
    }
    return super.a();
  }
  
  public String a()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.length() > 10)) {
      return "execScriptInRenderThread " + this.jdField_a_of_type_JavaLangString.substring(0, 10);
    }
    return "execScriptInRenderThread " + this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CmShow_SpriteAioScript", 1, "TraceReport exe Js:" + this.jdField_a_of_type_JavaLangString.length());
    }
    if (this.jdField_a_of_type_JavaLangString.startsWith("initSprite")) {
      TraceReportUtil.a(this.this$0.a.a(), 350, 0, new Object[] { "enter exeInitSprite" });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloIApolloRenderView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloIApolloRenderView.getWorker() != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloIApolloRenderView.getWorker().a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloIApolloRenderView.getWorker().a.a(this.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isColorLevel())
    {
      if (!this.jdField_a_of_type_JavaLangString.contains("CMShowDefActionName")) {
        break label152;
      }
      CmShowStatUtil.b("exeCmshow0");
    }
    label152:
    while (!this.jdField_a_of_type_JavaLangString.contains("commonInit")) {
      return;
    }
    CmShowStatUtil.b("exeCommon");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteAioScript.1
 * JD-Core Version:    0.7.0.1
 */