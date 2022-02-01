package com.tencent.gathererga.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gathererga.core.IExecutor;
import com.tencent.gathererga.core.ILog;
import com.tencent.gathererga.core.internal.component.GathererHTTP;
import com.tencent.gathererga.core.internal.component.cache.ProviderResultCache;
import java.util.HashMap;
import java.util.Map;

public final class GathererConfig$Builder
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private IExecutor jdField_a_of_type_ComTencentGatherergaCoreIExecutor;
  private ILog jdField_a_of_type_ComTencentGatherergaCoreILog;
  private GathererHTTP jdField_a_of_type_ComTencentGatherergaCoreInternalComponentGathererHTTP;
  private ProviderResultCache jdField_a_of_type_ComTencentGatherergaCoreInternalComponentCacheProviderResultCache;
  private String jdField_a_of_type_JavaLangString = "";
  private Map<Integer, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private String b;
  private String c = "Gatherer";
  
  private GathererConfig$Builder(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final Builder a(IExecutor paramIExecutor)
  {
    this.jdField_a_of_type_ComTencentGatherergaCoreIExecutor = paramIExecutor;
    return this;
  }
  
  public final Builder a(ILog paramILog)
  {
    this.jdField_a_of_type_ComTencentGatherergaCoreILog = paramILog;
    return this;
  }
  
  public final Builder a(GathererHTTP paramGathererHTTP)
  {
    this.jdField_a_of_type_ComTencentGatherergaCoreInternalComponentGathererHTTP = paramGathererHTTP;
    return this;
  }
  
  public final Builder a(ProviderResultCache paramProviderResultCache)
  {
    this.jdField_a_of_type_ComTencentGatherergaCoreInternalComponentCacheProviderResultCache = paramProviderResultCache;
    return this;
  }
  
  public final Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public final Builder a(Map<Integer, Boolean> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    return this;
  }
  
  public final Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public final GathererConfig a()
  {
    return new GathererConfig(this, null);
  }
  
  public final Builder b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public final Builder c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.c = paramString;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.sdk.GathererConfig.Builder
 * JD-Core Version:    0.7.0.1
 */