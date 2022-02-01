package com.tencent.gathererga.tangram;

import com.tencent.gathererga.core.IExecutor;
import com.tencent.gathererga.core.ILog;
import com.tencent.gathererga.core.internal.component.GathererHTTP;
import java.util.HashMap;

public class TangramGlobalSetting
{
  private IExecutor jdField_a_of_type_ComTencentGatherergaCoreIExecutor;
  private ILog jdField_a_of_type_ComTencentGatherergaCoreILog;
  private GathererHTTP jdField_a_of_type_ComTencentGatherergaCoreInternalComponentGathererHTTP;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Integer, TangramIDSetting> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  private TangramGlobalSetting(TangramGlobalSetting.Builder paramBuilder)
  {
    this.jdField_a_of_type_JavaLangString = TangramGlobalSetting.Builder.a(paramBuilder);
    this.jdField_b_of_type_JavaLangString = TangramGlobalSetting.Builder.b(paramBuilder);
    this.jdField_a_of_type_JavaUtilHashMap = TangramGlobalSetting.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentGatherergaCoreIExecutor = TangramGlobalSetting.Builder.a(paramBuilder);
    this.c = TangramGlobalSetting.Builder.c(paramBuilder);
    this.jdField_a_of_type_Boolean = TangramGlobalSetting.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentGatherergaCoreILog = TangramGlobalSetting.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentGatherergaCoreInternalComponentGathererHTTP = TangramGlobalSetting.Builder.a(paramBuilder);
    this.jdField_b_of_type_Boolean = TangramGlobalSetting.Builder.b(paramBuilder);
  }
  
  public IExecutor a()
  {
    return this.jdField_a_of_type_ComTencentGatherergaCoreIExecutor;
  }
  
  public ILog a()
  {
    return this.jdField_a_of_type_ComTencentGatherergaCoreILog;
  }
  
  public GathererHTTP a()
  {
    return this.jdField_a_of_type_ComTencentGatherergaCoreInternalComponentGathererHTTP;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public HashMap<Integer, TangramIDSetting> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.tangram.TangramGlobalSetting
 * JD-Core Version:    0.7.0.1
 */