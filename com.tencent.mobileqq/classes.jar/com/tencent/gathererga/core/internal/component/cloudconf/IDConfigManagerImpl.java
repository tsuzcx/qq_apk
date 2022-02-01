package com.tencent.gathererga.core.internal.component.cloudconf;

import com.tencent.gathererga.core.internal.GathererConfigInternal;
import java.util.HashMap;
import java.util.Map;

public class IDConfigManagerImpl
  implements IDConfigManager
{
  public static final IDConfigManager a;
  private GathererConfigInternal jdField_a_of_type_ComTencentGatherergaCoreInternalGathererConfigInternal;
  private Map<Integer, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentGatherergaCoreInternalComponentCloudconfIDConfigManager = new IDConfigManagerImpl();
  }
  
  public static IDConfigManager a()
  {
    return jdField_a_of_type_ComTencentGatherergaCoreInternalComponentCloudconfIDConfigManager;
  }
  
  public void a(GathererConfigInternal paramGathererConfigInternal)
  {
    this.jdField_a_of_type_ComTencentGatherergaCoreInternalGathererConfigInternal = paramGathererConfigInternal;
    this.jdField_a_of_type_JavaUtilMap.putAll(this.jdField_a_of_type_ComTencentGatherergaCoreInternalGathererConfigInternal.a());
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject == null) {
      return true;
    }
    localObject = (Boolean)((Map)localObject).get(Integer.valueOf(paramInt));
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManagerImpl
 * JD-Core Version:    0.7.0.1
 */