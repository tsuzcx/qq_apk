package com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/plugin/jsMethodAction/JsMethodModel;", "", "retCode", "", "msg", "", "data", "Lorg/json/JSONObject;", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getRetCode", "()I", "setRetCode", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toJson", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class JsMethodModel
{
  public static final JsMethodModel.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginJsMethodActionJsMethodModel$Companion = new JsMethodModel.Companion(null);
  }
  
  public JsMethodModel(int paramInt, @NotNull String paramString, @Nullable JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
  }
  
  @NotNull
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", this.jdField_a_of_type_Int);
      localJSONObject.put("msg", this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        localJSONObject.put("data", this.jdField_a_of_type_OrgJsonJSONObject);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof JsMethodModel))
      {
        paramObject = (JsMethodModel)paramObject;
        if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_a_of_type_OrgJsonJSONObject, paramObject.jdField_a_of_type_OrgJsonJSONObject))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.jdField_a_of_type_Int;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return (i + k * 31) * 31 + j;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "JsMethodModel(retCode=" + this.jdField_a_of_type_Int + ", msg=" + this.jdField_a_of_type_JavaLangString + ", data=" + this.jdField_a_of_type_OrgJsonJSONObject + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.JsMethodModel
 * JD-Core Version:    0.7.0.1
 */