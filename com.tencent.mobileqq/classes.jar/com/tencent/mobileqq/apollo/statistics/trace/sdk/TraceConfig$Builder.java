package com.tencent.mobileqq.apollo.statistics.trace.sdk;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.statistics.trace.TraceMappingIml;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.DefaultTraceNetwork;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.DefaultTraceStorage;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceMapping;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceNetwork;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceStorage;

public class TraceConfig$Builder
{
  int jdField_a_of_type_Int;
  private ITraceMapping jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceMapping;
  private ITraceNetwork jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceNetwork;
  private ITraceStorage jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceStorage;
  String jdField_a_of_type_JavaLangString;
  int b = 30000;
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public TraceConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceStorage == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceStorage = new DefaultTraceStorage();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceNetwork == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceNetwork = new DefaultTraceNetwork();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceMapping == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceMapping = new TraceMappingIml();
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return new TraceConfig(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceStorage, this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceNetwork, this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkComponentITraceMapping, null);
      }
      throw new IllegalArgumentException("current account uid is required.");
    }
    throw new IllegalArgumentException("appId required.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceConfig.Builder
 * JD-Core Version:    0.7.0.1
 */