package com.tencent.mobileqq.apollo.statistics.product;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/ApolloDtReportUtil$DtReportParamsBuilder;", "", "()V", "<set-?>", "", "entry", "getEntry", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "", "ex1", "getEx1", "()Ljava/lang/String;", "ex2", "getEx2", "ex3", "getEx3", "ex4", "getEx4", "ex5", "getEx5", "exMore", "getExMore", "guest", "getGuest", "keyText", "getKeyText", "mode", "getMode", "ownerStatus", "getOwnerStatus", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "peerStatus", "getPeerStatus", "peerUin", "getPeerUin", "personNum", "getPersonNum", "type", "getType", "vip", "getVip", "build", "setEntry", "setExtend1", "ex", "setExtend2", "setExtend3", "setExtend4", "setExtend5", "setExtendMore", "setGuest", "setKeyText", "setMode", "setOwnerStatus", "setPeerStatus", "(Ljava/lang/Integer;)Lcom/tencent/mobileqq/apollo/statistics/product/ApolloDtReportUtil$DtReportParamsBuilder;", "setPeerUin", "setPersonNum", "setType", "setVip", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloDtReportUtil$DtReportParamsBuilder
{
  @Nullable
  private Integer jdField_a_of_type_JavaLangInteger;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  @Nullable
  private Integer jdField_b_of_type_JavaLangInteger;
  @Nullable
  private String jdField_b_of_type_JavaLangString;
  @Nullable
  private Integer jdField_c_of_type_JavaLangInteger;
  @Nullable
  private String jdField_c_of_type_JavaLangString;
  @Nullable
  private Integer jdField_d_of_type_JavaLangInteger;
  @Nullable
  private String jdField_d_of_type_JavaLangString;
  @Nullable
  private Integer jdField_e_of_type_JavaLangInteger;
  @Nullable
  private String jdField_e_of_type_JavaLangString;
  @Nullable
  private Integer jdField_f_of_type_JavaLangInteger;
  @Nullable
  private String jdField_f_of_type_JavaLangString;
  @Nullable
  private Integer jdField_g_of_type_JavaLangInteger;
  @Nullable
  private String jdField_g_of_type_JavaLangString;
  @Nullable
  private Integer jdField_h_of_type_JavaLangInteger;
  @Nullable
  private String jdField_h_of_type_JavaLangString;
  
  @NotNull
  public final DtReportParamsBuilder a(int paramInt)
  {
    ((DtReportParamsBuilder)this).jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder a(@Nullable Integer paramInteger)
  {
    ((DtReportParamsBuilder)this).jdField_g_of_type_JavaLangInteger = paramInteger;
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "keyText");
    ((DtReportParamsBuilder)this).jdField_a_of_type_JavaLangString = paramString;
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final HashMap<String, String> a()
  {
    if (this.jdField_a_of_type_JavaLangInteger != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("mode", String.valueOf(this.jdField_a_of_type_JavaLangInteger));
    }
    if (this.jdField_b_of_type_JavaLangInteger != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("entry", String.valueOf(this.jdField_b_of_type_JavaLangInteger));
    }
    if (this.jdField_c_of_type_JavaLangInteger != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("type", String.valueOf(this.jdField_c_of_type_JavaLangInteger));
    }
    if (this.jdField_d_of_type_JavaLangInteger != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("guest", String.valueOf(this.jdField_d_of_type_JavaLangInteger));
    }
    if (this.jdField_e_of_type_JavaLangInteger != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("personNum", String.valueOf(this.jdField_e_of_type_JavaLangInteger));
    }
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("keyText", String.valueOf(this.jdField_a_of_type_JavaLangString));
    }
    if (this.jdField_f_of_type_JavaLangInteger != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ownerStatus", String.valueOf(this.jdField_f_of_type_JavaLangInteger));
    }
    if (this.jdField_g_of_type_JavaLangInteger != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("peerStatus", String.valueOf(this.jdField_g_of_type_JavaLangInteger));
    }
    if (this.jdField_b_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("peerUin", String.valueOf(this.jdField_b_of_type_JavaLangString));
    }
    if (this.jdField_c_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ex1", String.valueOf(this.jdField_c_of_type_JavaLangString));
    }
    if (this.jdField_d_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ex2", String.valueOf(this.jdField_d_of_type_JavaLangString));
    }
    if (this.jdField_e_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ex3", String.valueOf(this.jdField_e_of_type_JavaLangString));
    }
    if (this.jdField_f_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ex4", String.valueOf(this.jdField_f_of_type_JavaLangString));
    }
    if (this.jdField_g_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ex5", String.valueOf(this.jdField_g_of_type_JavaLangString));
    }
    if (this.jdField_h_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("exMore", String.valueOf(this.jdField_h_of_type_JavaLangString));
    }
    if (this.jdField_h_of_type_JavaLangInteger != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("vip", String.valueOf(this.jdField_h_of_type_JavaLangInteger));
    }
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  @NotNull
  public final DtReportParamsBuilder b(int paramInt)
  {
    ((DtReportParamsBuilder)this).jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder b(@Nullable String paramString)
  {
    ((DtReportParamsBuilder)this).jdField_b_of_type_JavaLangString = paramString;
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder c(int paramInt)
  {
    ((DtReportParamsBuilder)this).jdField_c_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder c(@Nullable String paramString)
  {
    ((DtReportParamsBuilder)this).jdField_c_of_type_JavaLangString = paramString;
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder d(int paramInt)
  {
    ((DtReportParamsBuilder)this).jdField_d_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder d(@Nullable String paramString)
  {
    ((DtReportParamsBuilder)this).jdField_d_of_type_JavaLangString = paramString;
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder e(int paramInt)
  {
    ((DtReportParamsBuilder)this).jdField_e_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder e(@Nullable String paramString)
  {
    ((DtReportParamsBuilder)this).jdField_e_of_type_JavaLangString = paramString;
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder f(int paramInt)
  {
    ((DtReportParamsBuilder)this).jdField_f_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder f(@Nullable String paramString)
  {
    ((DtReportParamsBuilder)this).jdField_f_of_type_JavaLangString = paramString;
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder g(int paramInt)
  {
    ((DtReportParamsBuilder)this).jdField_h_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder g(@Nullable String paramString)
  {
    ((DtReportParamsBuilder)this).jdField_g_of_type_JavaLangString = paramString;
    return (DtReportParamsBuilder)this;
  }
  
  @NotNull
  public final DtReportParamsBuilder h(@Nullable String paramString)
  {
    ((DtReportParamsBuilder)this).jdField_h_of_type_JavaLangString = paramString;
    return (DtReportParamsBuilder)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder
 * JD-Core Version:    0.7.0.1
 */