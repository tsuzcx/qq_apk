package com.tencent.mobileqq.apollo.utils;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;

public class CmShowCECapabilitiesChecker
{
  private static SimpleGLThread jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread;
  private static String jdField_a_of_type_JavaLangString;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean;
  
  public static void a()
  {
    try
    {
      if ((!jdField_a_of_type_Boolean) && (jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread == null))
      {
        jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread = new SimpleGLThread((EGLContext)null, "CmShowCECapabilitiesChecker");
        jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread.postJob(new CmShowCECapabilitiesChecker.1());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a()
  {
    f();
    return jdField_b_of_type_Boolean;
  }
  
  private static void d()
  {
    Object localObject = GLES20.glGetString(7937);
    String str = GLES20.glGetString(7936);
    jdField_b_of_type_JavaLangString = GLES20.glGetString(7938);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; ");
    localStringBuilder.append(str);
    localStringBuilder.append("; ");
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gpuInfo=");
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
    QLog.i("[cmshow]CmShowCECapabilitiesChecker [CrossEngine]", 1, ((StringBuilder)localObject).toString());
  }
  
  private static void e()
  {
    String str = GLES20.glGetString(7939);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GL_EXTENSIONS=");
    ((StringBuilder)localObject).append(str);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool2 = true;
    QLog.i("[cmshow]CmShowCECapabilitiesChecker [CrossEngine]", 1, (String)localObject);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    boolean bool1 = bool2;
    if (!str.contains("GL_KHR_texture_compression_astc_ldr"))
    {
      bool1 = bool2;
      if (!str.contains("GL_KHR_texture_compression_astc_hdr")) {
        if (str.contains("GL_OES_texture_compression_astc")) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    jdField_b_of_type_Boolean = bool1;
  }
  
  private static void f()
  {
    if (!jdField_a_of_type_Boolean)
    {
      SimpleGLThread localSimpleGLThread = jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread;
      if (localSimpleGLThread != null)
      {
        localSimpleGLThread.waitDone(200);
        if (!jdField_a_of_type_Boolean) {
          g();
        }
      }
      else
      {
        g();
      }
    }
  }
  
  private static void g()
  {
    QLog.e("[cmshow]CmShowCECapabilitiesChecker [CrossEngine]", 1, "useInWrongTime", new IllegalStateException("must call init method first"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.CmShowCECapabilitiesChecker
 * JD-Core Version:    0.7.0.1
 */