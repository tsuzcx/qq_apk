package com.mojitox.mxflutter.framework.ffi;

import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.js.BaseJsEngine;
import com.mojitox.mxflutter.framework.js.BaseJsExecutor;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import com.mojitox.mxflutter.framework.utils.MxLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

class MxFlutterFfi$1
  implements Runnable
{
  MxFlutterFfi$1(MxFlutterFfi paramMxFlutterFfi, String paramString, Object[] paramArrayOfObject, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("method", "syncPropsCallback");
    ((Map)localObject).put("arguments", this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call js syncPropsCallback argument:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    MxLog.a("MxFlutterFfi", localStringBuilder.toString());
    this.jdField_a_of_type_ArrayOfJavaLangObject[0] = JsEngineLoader.a().a().b().a(JsObjectType.CURRENT_APP_OBJECT, "nativeCall", localObject);
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("call js syncPropsCallback result:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
    MxLog.a("MxFlutterFfi", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.ffi.MxFlutterFfi.1
 * JD-Core Version:    0.7.0.1
 */