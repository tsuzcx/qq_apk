package com.tencent.gathererga.core.internal.component;

import android.content.Context;
import com.tencent.gathererga.core.internal.BaseContext;
import com.tencent.gathererga.core.internal.GathererConfigInternal;
import com.tencent.gathererga.core.internal.IBase;
import com.tencent.gathererga.core.internal.component.cache.CloudConfigDB;
import com.tencent.gathererga.core.internal.component.cache.CouldConfigDBImpl;
import com.tencent.gathererga.core.internal.component.cache.ProviderResultCache;
import com.tencent.gathererga.core.internal.util.GLog;
import java.lang.ref.WeakReference;

public class GathererCompContext
  extends BaseContext
{
  public static final GathererCompContext a;
  private ProviderResultCache jdField_a_of_type_ComTencentGatherergaCoreInternalComponentCacheProviderResultCache;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  static
  {
    jdField_a_of_type_ComTencentGatherergaCoreInternalComponentGathererCompContext = new GathererCompContext();
  }
  
  public static <T> void a(Class<T> paramClass, Class<?> paramClass1)
  {
    jdField_a_of_type_ComTencentGatherergaCoreInternalComponentGathererCompContext.b(paramClass, paramClass1);
  }
  
  public ProviderResultCache a()
  {
    return this.jdField_a_of_type_ComTencentGatherergaCoreInternalComponentCacheProviderResultCache;
  }
  
  protected Object a(Class<?> paramClass, Object paramObject)
  {
    paramClass = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((paramClass != null) && (paramClass.get() != null))
    {
      ((IBase)paramObject).a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      return paramObject;
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(GathererConfigInternal paramGathererConfigInternal)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGathererConfigInternal.a());
    this.jdField_a_of_type_JavaLangString = paramGathererConfigInternal.a();
    GLog.a(paramGathererConfigInternal.a());
    this.jdField_a_of_type_ComTencentGatherergaCoreInternalComponentCacheProviderResultCache = paramGathererConfigInternal.a();
    this.jdField_a_of_type_ComTencentGatherergaCoreInternalComponentCacheProviderResultCache.a(paramGathererConfigInternal.a());
    a(CloudConfigDB.class, CouldConfigDBImpl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.component.GathererCompContext
 * JD-Core Version:    0.7.0.1
 */