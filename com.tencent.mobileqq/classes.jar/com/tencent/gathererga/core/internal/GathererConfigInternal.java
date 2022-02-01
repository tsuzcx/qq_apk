package com.tencent.gathererga.core.internal;

import android.content.Context;
import com.tencent.gathererga.core.IExecutor;
import com.tencent.gathererga.core.ILog;
import com.tencent.gathererga.core.internal.component.GathererHTTP;
import com.tencent.gathererga.core.internal.component.cache.ProviderResultCache;
import com.tencent.gathererga.core.internal.component.cache.ProviderResultCacheImpl;
import java.util.Map;

public class GathererConfigInternal
{
  protected int a;
  protected Context a;
  protected IExecutor a;
  protected ILog a;
  protected GathererHTTP a;
  protected ProviderResultCache a;
  protected String a;
  protected Map<Integer, Boolean> a;
  protected boolean a;
  protected String b;
  protected String c;
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public IExecutor a()
  {
    return this.jdField_a_of_type_ComTencentGatherergaCoreIExecutor;
  }
  
  public ILog a()
  {
    return this.jdField_a_of_type_ComTencentGatherergaCoreILog;
  }
  
  public ProviderResultCache a()
  {
    ProviderResultCache localProviderResultCache = this.jdField_a_of_type_ComTencentGatherergaCoreInternalComponentCacheProviderResultCache;
    Object localObject = localProviderResultCache;
    if (localProviderResultCache == null) {
      localObject = new ProviderResultCacheImpl();
    }
    return localObject;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public Map<Integer, Boolean> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.GathererConfigInternal
 * JD-Core Version:    0.7.0.1
 */