package com.tencent.mobileqq.apollo.script;

import akra;
import alas;
import alba;
import alhp;
import alku;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.qphone.base.util.QLog;

public class SpriteAioScript$1
  extends IApolloRunnableTask
{
  public SpriteAioScript$1(alas paramalas, String paramString, akra paramakra, int paramInt, boolean paramBoolean) {}
  
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
      QLog.i("cmshow_scripted_SpriteAioScript", 1, "TraceReport exe Js:" + this.jdField_a_of_type_JavaLangString.length());
    }
    if ((this.jdField_a_of_type_JavaLangString.startsWith("initDrawerInfoSprite")) || (this.jdField_a_of_type_JavaLangString.startsWith("initSprite"))) {
      alhp.a(this.this$0.a.a(), 350, 0, new Object[] { "enter exeInitSprite" });
    }
    if ((this.jdField_a_of_type_Akra != null) && (this.jdField_a_of_type_Akra.getWorker() != null) && (this.jdField_a_of_type_Akra.getWorker().a != null)) {
      this.jdField_a_of_type_Akra.getWorker().a.a(this.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isColorLevel())
    {
      if (!this.jdField_a_of_type_JavaLangString.contains("CMShowDefActionName")) {
        break label164;
      }
      alku.b("exeCmshow0");
    }
    label164:
    while (!this.jdField_a_of_type_JavaLangString.contains("commonInit")) {
      return;
    }
    alku.b("exeCommon");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteAioScript.1
 * JD-Core Version:    0.7.0.1
 */