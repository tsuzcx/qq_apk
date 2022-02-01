package com.tencent.gathererga.tangram;

import com.tencent.gathererga.core.IExecutor;
import com.tencent.gathererga.core.ILog;
import com.tencent.gathererga.core.internal.component.GathererHTTP;
import java.util.HashMap;

public final class TangramGlobalSetting$Builder
{
  private IExecutor jdField_a_of_type_ComTencentGatherergaCoreIExecutor;
  private ILog jdField_a_of_type_ComTencentGatherergaCoreILog;
  private GathererHTTP jdField_a_of_type_ComTencentGatherergaCoreInternalComponentGathererHTTP;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Integer, TangramIDSetting> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = true;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String c = "Gatherer";
  
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
  
  public final Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public final Builder a(HashMap<Integer, TangramIDSetting> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  public final Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public final TangramGlobalSetting a()
  {
    return new TangramGlobalSetting(this, null);
  }
  
  public final Builder b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.tangram.TangramGlobalSetting.Builder
 * JD-Core Version:    0.7.0.1
 */