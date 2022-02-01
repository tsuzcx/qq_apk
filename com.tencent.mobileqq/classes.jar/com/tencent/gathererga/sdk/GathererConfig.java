package com.tencent.gathererga.sdk;

import android.content.Context;
import com.tencent.gathererga.core.internal.GathererConfigInternal;

public class GathererConfig
  extends GathererConfigInternal
{
  private GathererConfig(GathererConfig.Builder paramBuilder)
  {
    this.jdField_a_of_type_AndroidContentContext = GathererConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_JavaLangString = GathererConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_JavaUtilMap = GathererConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_Int = GathererConfig.Builder.a(paramBuilder);
    this.b = GathererConfig.Builder.b(paramBuilder);
    this.c = GathererConfig.Builder.c(paramBuilder);
    this.jdField_a_of_type_ComTencentGatherergaCoreInternalComponentGathererHTTP = GathererConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_Boolean = GathererConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentGatherergaCoreIExecutor = GathererConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentGatherergaCoreInternalComponentCacheProviderResultCache = GathererConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentGatherergaCoreILog = GathererConfig.Builder.a(paramBuilder);
  }
  
  public static GathererConfig.Builder a(Context paramContext, int paramInt)
  {
    return new GathererConfig.Builder(paramContext, paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.sdk.GathererConfig
 * JD-Core Version:    0.7.0.1
 */