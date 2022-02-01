package com.tencent.biz.pubaccount.readinjoy.viola.so;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.LoadLibCallback;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/so/ViolaSoLoaderManager;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/so/IViolaSoLoader;", "()V", "soLoader", "useViolaJSCLoader", "", "isEngineReady", "loadLibrary", "", "from", "", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine$LoadLibCallback;", "preLoadViola", "useLegacyLoader", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ViolaSoLoaderManager
  implements IViolaSoLoader
{
  public static final ViolaSoLoaderManager.Companion a;
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)ViolaSoLoaderManager.Companion.instance.2.INSTANCE);
  private IViolaSoLoader jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoIViolaSoLoader;
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoViolaSoLoaderManager$Companion = new ViolaSoLoaderManager.Companion(null);
  }
  
  public ViolaSoLoaderManager()
  {
    if (Aladdin.getConfig(432).getIntegerFromString("viola_so_loader", 0) == 1)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label56;
      }
    }
    label56:
    for (IViolaSoLoader localIViolaSoLoader = (IViolaSoLoader)new ViolaSoLoader();; localIViolaSoLoader = (IViolaSoLoader)new ViolaSoLegacyLoader())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoIViolaSoLoader = localIViolaSoLoader;
      return;
      bool = false;
      break;
    }
  }
  
  public void a()
  {
    IViolaSoLoader localIViolaSoLoader = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoIViolaSoLoader;
    if (localIViolaSoLoader != null) {
      localIViolaSoLoader.a();
    }
  }
  
  public void a(@Nullable String paramString, @Nullable ReadInJoyWebRenderEngine.LoadLibCallback paramLoadLibCallback)
  {
    IViolaSoLoader localIViolaSoLoader = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoIViolaSoLoader;
    if (localIViolaSoLoader != null) {
      localIViolaSoLoader.a(paramString, paramLoadLibCallback);
    }
  }
  
  public boolean a()
  {
    IViolaSoLoader localIViolaSoLoader = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoIViolaSoLoader;
    if (localIViolaSoLoader != null) {
      return localIViolaSoLoader.a();
    }
    return false;
  }
  
  public final boolean b()
  {
    return !this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager
 * JD-Core Version:    0.7.0.1
 */