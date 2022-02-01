package com.tencent.biz.pubaccount.readinjoy.automator;

import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseStep
{
  private long jdField_a_of_type_Long;
  @NotNull
  private final Automator jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorAutomator;
  @Nullable
  private StepGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorStepGroup;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  
  public BaseStep(@NotNull Automator paramAutomator, boolean paramBoolean, @Nullable String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorAutomator = paramAutomator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    }
  }
  
  @NotNull
  public final Automator a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorAutomator;
  }
  
  @Nullable
  public final StepGroup a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorStepGroup;
  }
  
  public void a()
  {
    a("onStop");
  }
  
  public final void a(@Nullable StepGroup paramStepGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorStepGroup = paramStepGroup;
  }
  
  protected final void a(@NotNull String paramString)
  {
    ILog localILog = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorAutomator.a();
    if (localILog != null)
    {
      localILog.a("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
      return;
    }
    Log.d("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a("onStart");
    return true;
  }
  
  public abstract boolean b();
  
  public void c()
  {
    a("onEnd, time = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
  }
  
  public final boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorAutomator.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.automator.BaseStep
 * JD-Core Version:    0.7.0.1
 */