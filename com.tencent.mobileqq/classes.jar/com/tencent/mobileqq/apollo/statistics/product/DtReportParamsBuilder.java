package com.tencent.mobileqq.apollo.statistics.product;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;", "", "()V", "<set-?>", "", "entry", "getEntry", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "", "ex1", "getEx1", "()Ljava/lang/String;", "ex2", "getEx2", "ex3", "getEx3", "ex4", "getEx4", "ex5", "getEx5", "exMore", "getExMore", "fromEntrance", "getFromEntrance", "guest", "getGuest", "keyText", "getKeyText", "mode", "getMode", "ownerStatus", "getOwnerStatus", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "peerStatus", "getPeerStatus", "peerUin", "getPeerUin", "personNum", "getPersonNum", "type", "getType", "vip", "getVip", "build", "setEntry", "setExtend1", "ex", "setExtend2", "setExtend3", "setExtend4", "setExtend5", "setExtendMore", "setFromEntrance", "from", "setGuest", "setKeyText", "setMode", "setOwnerStatus", "setPeerStatus", "(Ljava/lang/Integer;)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;", "setPeerUin", "setPersonNum", "setType", "setVip", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public final class DtReportParamsBuilder
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
  @Nullable
  private String i;
  
  @NotNull
  public final DtReportParamsBuilder a(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder a(@Nullable Integer paramInteger)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_g_of_type_JavaLangInteger = paramInteger;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "keyText");
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_a_of_type_JavaLangString = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final HashMap<String, String> a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangInteger;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("mode", String.valueOf(localObject));
    }
    localObject = this.jdField_b_of_type_JavaLangInteger;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("entry", String.valueOf(localObject));
    }
    localObject = this.jdField_c_of_type_JavaLangInteger;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("type", String.valueOf(localObject));
    }
    localObject = this.jdField_d_of_type_JavaLangInteger;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("guest", String.valueOf(localObject));
    }
    localObject = this.jdField_e_of_type_JavaLangInteger;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("personNum", String.valueOf(localObject));
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("keyText", String.valueOf(localObject));
    }
    localObject = this.jdField_f_of_type_JavaLangInteger;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ownerStatus", String.valueOf(localObject));
    }
    localObject = this.jdField_g_of_type_JavaLangInteger;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("peerStatus", String.valueOf(localObject));
    }
    localObject = this.jdField_b_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("peerUin", String.valueOf(localObject));
    }
    localObject = this.jdField_c_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ex1", String.valueOf(localObject));
    }
    localObject = this.jdField_d_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ex2", String.valueOf(localObject));
    }
    localObject = this.jdField_e_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ex3", String.valueOf(localObject));
    }
    localObject = this.jdField_f_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ex4", String.valueOf(localObject));
    }
    localObject = this.jdField_g_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("ex5", String.valueOf(localObject));
    }
    localObject = this.jdField_h_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("from_entrance", String.valueOf(localObject));
    }
    localObject = this.i;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("exMore", String.valueOf(localObject));
    }
    localObject = this.jdField_h_of_type_JavaLangInteger;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("vip", String.valueOf(localObject));
    }
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  @NotNull
  public final DtReportParamsBuilder b(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder b(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_b_of_type_JavaLangString = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder c(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_c_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder c(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_c_of_type_JavaLangString = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder d(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_d_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder d(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_d_of_type_JavaLangString = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder e(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_e_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder e(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_e_of_type_JavaLangString = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder f(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_f_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder f(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_f_of_type_JavaLangString = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder g(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_h_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder g(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_g_of_type_JavaLangString = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder h(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.jdField_h_of_type_JavaLangString = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder i(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.i = paramString;
    return localDtReportParamsBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder
 * JD-Core Version:    0.7.0.1
 */