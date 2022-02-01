package com.tencent.mobileqq.apollo.statistics.trace.sdk;

import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceMapping;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceNetwork;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceStorage;

public class TraceConfig
{
  private int jdField_a_of_type_Int;
  private ITraceMapping jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceMapping;
  private ITraceNetwork jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceNetwork;
  private ITraceStorage jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceStorage;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  private TraceConfig(int paramInt1, String paramString, int paramInt2, ITraceStorage paramITraceStorage, ITraceNetwork paramITraceNetwork, ITraceMapping paramITraceMapping)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceStorage = paramITraceStorage;
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceNetwork = paramITraceNetwork;
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceMapping = paramITraceMapping;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ITraceMapping a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceMapping;
  }
  
  public ITraceNetwork a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceNetwork;
  }
  
  public ITraceStorage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceStorage;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceMapping.a(paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceMapping.a(paramInt);
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceMapping.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceConfig
 * JD-Core Version:    0.7.0.1
 */