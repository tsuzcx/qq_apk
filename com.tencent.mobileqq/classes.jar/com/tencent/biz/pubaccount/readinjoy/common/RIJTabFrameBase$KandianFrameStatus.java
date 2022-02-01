package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.app.Frame;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase$KandianFrameStatus;", "", "()V", "currenFrmeClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/Frame;", "getCurrenFrmeClass", "()Ljava/lang/Class;", "setCurrenFrmeClass", "(Ljava/lang/Class;)V", "isShowKandianTab", "", "()Z", "setShowKandianTab", "(Z)V", "isXTabMode", "setXTabMode", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJTabFrameBase$KandianFrameStatus
{
  @Nullable
  private Class<? extends Frame> jdField_a_of_type_JavaLangClass;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  @Nullable
  public final Class<? extends Frame> a()
  {
    return this.jdField_a_of_type_JavaLangClass;
  }
  
  public final void a(@Nullable Class<? extends Frame> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  @NotNull
  public String toString()
  {
    return "KandianFrameStatus(isShowKandianTab=" + this.jdField_a_of_type_Boolean + ", isXTabMode=" + this.b + ", currenFrmeClass=" + this.jdField_a_of_type_JavaLangClass + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.KandianFrameStatus
 * JD-Core Version:    0.7.0.1
 */