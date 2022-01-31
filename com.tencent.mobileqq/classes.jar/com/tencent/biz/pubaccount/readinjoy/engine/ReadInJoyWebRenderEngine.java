package com.tencent.biz.pubaccount.readinjoy.engine;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.HtmlOffline.MyWebResourceResponse;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import lmi;
import lmj;

public class ReadInJoyWebRenderEngine
{
  private static ReadInJoyWebRenderEngine jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderEngine;
  private static final LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static final LRULinkedHashMap jdField_b_of_type_ComTencentUtilLRULinkedHashMap;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int a;
  public final ReadInJoyWebRenderStateMachineScheduler a;
  private String jdField_a_of_type_JavaLangString;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String d;
  private String e;
  private String f;
  private String g;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(4);
    jdField_b_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(4);
    a("classLoad");
  }
  
  public ReadInJoyWebRenderEngine()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderStateMachineScheduler = new ReadInJoyWebRenderStateMachineScheduler(new lmi(this));
  }
  
  public static ReadInJoyWebRenderEngine.RenderHtmlData a(String paramString)
  {
    if ((AppSetting.e) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("viola.ReadInJoyWebRenderEngine", 2, "native_render  getRenderHtmlData url : " + paramString);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localRenderHtmlData = (ReadInJoyWebRenderEngine.RenderHtmlData)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
      if (localRenderHtmlData != null)
      {
        paramString = localRenderHtmlData;
        if (localRenderHtmlData.a()) {
          paramString = null;
        }
        return paramString;
      }
    }
    ReadInJoyWebRenderEngine.RenderHtmlData localRenderHtmlData = (ReadInJoyWebRenderEngine.RenderHtmlData)jdField_b_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
    if (localRenderHtmlData != null)
    {
      paramString = localRenderHtmlData;
      if (localRenderHtmlData.a()) {}
    }
    for (;;)
    {
      return paramString;
      paramString = null;
    }
  }
  
  public static ReadInJoyWebRenderEngine a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderEngine == null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderEngine = new ReadInJoyWebRenderEngine();
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderEngine;
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str2 = b(paramString);
      int i = str2.lastIndexOf(".");
      String str1 = str2;
      if (i > 0) {
        str1 = str2.substring(0, i);
      }
      return HtmlOffline.a(paramString.replaceFirst(str1, str1 + "_nativeRender").replace("_bid", "_pbid"), "_prenr=1");
    }
    return "";
  }
  
  public static void a()
  {
    if (!ReadInJoyHelper.l(ReadInJoyUtils.a())) {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [getWebRenderConfig], is:", Boolean.valueOf(false) });
      }
    }
    do
    {
      return;
      if (!jdField_a_of_type_Boolean)
      {
        a("preload");
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [sLoadEngineLibDone], is:", Boolean.valueOf(true) });
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "[notifyLibLoad], ret:", Integer.valueOf(paramInt) });
    }
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 155	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	()Lmqq/app/AppRuntime;
    //   6: invokestatic 161	cooperation/readinjoy/ReadInJoyHelper:l	(Lmqq/app/AppRuntime;)Z
    //   9: ifne +35 -> 44
    //   12: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +25 -> 40
    //   18: ldc 83
    //   20: iconst_2
    //   21: iconst_2
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: ldc 189
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: iconst_0
    //   33: invokestatic 169	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   36: aastore
    //   37: invokestatic 172	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   40: ldc 2
    //   42: monitorexit
    //   43: return
    //   44: getstatic 174	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine:jdField_a_of_type_Boolean	Z
    //   47: ifne -7 -> 40
    //   50: getstatic 29	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   53: iconst_1
    //   54: invokevirtual 193	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   57: ifne -17 -> 40
    //   60: invokestatic 199	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   63: new 201	lmk
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 203	lmk:<init>	(Ljava/lang/String;)V
    //   71: invokevirtual 209	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   74: pop
    //   75: goto -35 -> 40
    //   78: astore_0
    //   79: ldc 2
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	40	78	finally
    //   44	75	78	finally
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.g = paramString2;
      this.jdField_b_of_type_JavaLangString = Uri.parse(paramString1).getQueryParameter("_pbid");
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, "native_render onStart timestamp = " + System.currentTimeMillis() + " ; url = " + paramString1 + ";data = " + paramString2);
      }
      ThreadManager.post(new lmj(this), 8, null, true);
      ReadInJoyUtils.a(ReadInJoyUtils.a(), true, 1);
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    if (!ReadInJoyHelper.l(ReadInJoyUtils.a())) {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render isEngineReady [getWebRenderConfig], ret:", Boolean.valueOf(false) });
      }
    }
    do
    {
      return false;
      if (jdField_a_of_type_Boolean) {
        break;
      }
      ReadInJoyUtils.a(ReadInJoyUtils.a(), true, 2);
      a("other ");
    } while (!QLog.isColorLevel());
    QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render [isEngineReady], ret:", Boolean.valueOf(false) });
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render [isEngineReady], ret:", Boolean.valueOf(true) });
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf('#');
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(0, i);
      }
      i = str.lastIndexOf('?');
      paramString = str;
      if (i > 0) {
        paramString = str.substring(0, i);
      }
      i = paramString.lastIndexOf('/');
      str = paramString;
      if (i >= 0) {
        str = paramString.substring(i + 1);
      }
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return "";
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.f = "";
    this.g = "";
    this.e = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public int a(Bundle paramBundle)
  {
    ReadInJoyUtils.a(ReadInJoyUtils.a(), true, 9);
    this.jdField_a_of_type_Int = 1024;
    return -1;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!ReadInJoyHelper.l(ReadInJoyUtils.a())) {
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean2;
    a(paramString1, paramString2, paramBoolean1);
  }
  
  public int b(Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("_prenr"))) && (a()) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.g)))
    {
      if ((!this.jdField_c_of_type_Boolean) && (a(this.jdField_a_of_type_JavaLangString) != null))
      {
        this.jdField_a_of_type_Int = 512;
        if (QLog.isColorLevel()) {
          QLog.e("viola.ReadInJoyWebRenderEngine", 1, "native_render doCreateLoopStep_Check has url cache");
        }
      }
      for (;;)
      {
        return 0;
        this.jdField_a_of_type_Int = 8;
      }
    }
    return a(paramBundle);
  }
  
  public int c(Bundle paramBundle)
  {
    return 0;
  }
  
  public int d(Bundle paramBundle)
  {
    String str3 = OfflineEnvHelper.a(this.jdField_b_of_type_JavaLangString);
    String str2 = b(this.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str2))) {
      return a(paramBundle);
    }
    int i = str2.lastIndexOf(".");
    String str1 = str2;
    if (i > 0) {
      str1 = str2.substring(0, i);
    }
    str2 = str3 + this.jdField_b_of_type_JavaLangString;
    str3 = HtmlOffline.d(this.jdField_a_of_type_JavaLangString);
    i = str3.lastIndexOf("/");
    if ((i > 0) && (!TextUtils.isEmpty(str3)))
    {
      str1 = str2 + "/" + str3.substring(0, i) + "/" + str1;
      this.d = (str1 + "_nativeRenderTpl.html");
      this.jdField_c_of_type_JavaLangString = (str1 + ".js");
      if (!new File(this.jdField_c_of_type_JavaLangString).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.e("viola.ReadInJoyWebRenderEngine", 2, "native_render doCreateLoopStep_GetJsPath jsPath is empty");
        }
        ReadInJoyUtils.a(ReadInJoyUtils.a(), true, 4);
        return a(paramBundle);
      }
      this.jdField_a_of_type_Int = 32;
      return 0;
    }
    return a(paramBundle);
  }
  
  public int e(Bundle paramBundle)
  {
    return 0;
  }
  
  public int f(Bundle paramBundle)
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return a(paramBundle);
    }
    Object localObject = this.g.getBytes();
    localObject = nativeRender(this.jdField_c_of_type_JavaLangString, (byte[])localObject, localObject.length);
    if (localObject != null)
    {
      localObject = new String((byte[])localObject);
      if ("null".equals(localObject))
      {
        ReadInJoyUtils.a(ReadInJoyUtils.a(), true, 6);
        if (QLog.isColorLevel()) {
          QLog.e("viola.ReadInJoyWebRenderEngine", 2, "native_render doCreateLoopStep_RenderTpl result is null string");
        }
        return a(paramBundle);
      }
      this.e = ((String)localObject);
      this.jdField_a_of_type_Int = 64;
      return 0;
    }
    ReadInJoyUtils.a(ReadInJoyUtils.a(), true, 5);
    if (QLog.isColorLevel()) {
      QLog.e("viola.ReadInJoyWebRenderEngine", 2, "native_render doCreateLoopStep_RenderTpl result is null ");
    }
    return a(paramBundle);
  }
  
  public int g(Bundle paramBundle)
  {
    Object localObject;
    if (SwiftOfflineDataUtils.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = SwiftOfflineDataUtils.a(this.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (!TextUtils.isEmpty(((SwiftOfflineDataUtils.OfflineData)localObject).jdField_b_of_type_JavaLangString))) {
        this.f = ((SwiftOfflineDataUtils.OfflineData)localObject).jdField_b_of_type_JavaLangString;
      }
    }
    while (TextUtils.isEmpty(this.f))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, "native_render doCreateLoopStep_GetHtml mHtmlOffline is empty");
      }
      ReadInJoyUtils.a(ReadInJoyUtils.a(), true, 7);
      return a(paramBundle);
      localObject = HtmlOffline.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        try
        {
          int i = ((HtmlOffline.MyWebResourceResponse)localObject).a.available();
          if (i != 0)
          {
            byte[] arrayOfByte = new byte[i];
            if (i == ((HtmlOffline.MyWebResourceResponse)localObject).a.read(arrayOfByte)) {
              this.f = new String(arrayOfByte, "utf-8");
            }
          }
        }
        catch (IOException localIOException)
        {
          return a(paramBundle);
        }
      }
    }
    this.jdField_a_of_type_Int = 128;
    return 0;
  }
  
  public int h(Bundle paramBundle)
  {
    this.f = this.f.replaceFirst("<!--native-render-->", this.e);
    this.f = this.f.replaceFirst("<!--native-data-render-->", "var renderData = " + this.g + ";");
    this.jdField_a_of_type_Int = 256;
    return 0;
  }
  
  public int i(Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(this.f))
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label65;
      }
      jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(this.jdField_a_of_type_JavaLangString, new ReadInJoyWebRenderEngine.RenderHtmlData(this.f, "utf-8", 1800000L));
    }
    for (;;)
    {
      ReadInJoyUtils.a(ReadInJoyUtils.a(), true, 8);
      b();
      this.jdField_a_of_type_Int = 1;
      return -1;
      label65:
      jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(this.jdField_a_of_type_JavaLangString, new ReadInJoyWebRenderEngine.RenderHtmlData(this.f, "utf-8"));
    }
  }
  
  public int j(Bundle paramBundle)
  {
    ReadInJoyUtils.a(ReadInJoyUtils.a(), true, 3);
    b();
    this.jdField_a_of_type_Int = 1;
    return -1;
  }
  
  public int k(Bundle paramBundle)
  {
    b();
    this.jdField_a_of_type_Int = 1;
    return -1;
  }
  
  public native byte[] nativeRender(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public native void releaseRender();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine
 * JD-Core Version:    0.7.0.1
 */