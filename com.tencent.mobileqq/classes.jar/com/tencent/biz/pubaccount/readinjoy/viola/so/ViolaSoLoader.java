package com.tencent.biz.pubaccount.readinjoy.viola.so;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.LoadLibCallback;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.mobileqq.soload.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/so/ViolaSoLoader;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/so/IViolaSoLoader;", "()V", "enablePreloadViolaEngine", "", "loadSuccess", "retryCount", "", "isEngineReady", "loadLibrary", "", "from", "", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine$LoadLibCallback;", "preLoadViola", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ViolaSoLoader
  implements IViolaSoLoader
{
  public static final ViolaSoLoader.Companion a;
  @NotNull
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "viola_jsc", "viola" };
  private volatile int jdField_a_of_type_Int;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoViolaSoLoader$Companion = new ViolaSoLoader.Companion(null);
  }
  
  public ViolaSoLoader()
  {
    if (Aladdin.getConfig(433).getIntegerFromString("enable_viola_preload", 0) == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
      a("preloadEngine");
    }
    if (ViolaAccessHelper.a()) {
      ViolaAccessHelper.a();
    }
  }
  
  public void a(@Nullable String paramString)
  {
    a(paramString, null);
  }
  
  public void a(@Nullable String paramString, @Nullable ReadInJoyWebRenderEngine.LoadLibCallback paramLoadLibCallback)
  {
    if (this.b)
    {
      if (paramLoadLibCallback != null) {
        paramLoadLibCallback.onFinish(ReadInJoyWebRenderEngine.g);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaSoLoader", 2, "viola loadLibrary from: " + paramString);
    }
    SoLoadManager.a().a(jdField_a_of_type_ArrayOfJavaLangString, (OnLoadListener)new ViolaSoLoader.loadLibrary.1(this, paramLoadLibCallback, paramString));
  }
  
  public boolean a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoader
 * JD-Core Version:    0.7.0.1
 */