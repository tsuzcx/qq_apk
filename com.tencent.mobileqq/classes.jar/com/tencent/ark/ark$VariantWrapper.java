package com.tencent.ark;

import java.util.Map;

public class ark$VariantWrapper
  extends ark.NativeObject
{
  public native VariantWrapper Copy();
  
  public native VariantWrapper Create();
  
  public native boolean CreateObject(String paramString, ark.RuntimeClassCallbackWrapper paramRuntimeClassCallbackWrapper);
  
  public native boolean GetBool();
  
  public native double GetDouble();
  
  public native int GetInt();
  
  public native String GetString();
  
  public native String GetTableAsJsonString();
  
  public native int GetType();
  
  public native long GetView();
  
  public native boolean Invoke(String paramString, VariantWrapper[] paramArrayOfVariantWrapper, VariantWrapper paramVariantWrapper);
  
  public native boolean InvokeDefault(VariantWrapper[] paramArrayOfVariantWrapper, VariantWrapper paramVariantWrapper);
  
  public native boolean IsArray();
  
  public native boolean IsFunction();
  
  public native boolean IsString();
  
  public native boolean IsTable();
  
  public native boolean IsUserObject();
  
  public native boolean IsView();
  
  public native void Reset();
  
  public native boolean SetBool(boolean paramBoolean);
  
  public native boolean SetDouble(double paramDouble);
  
  public native boolean SetInt(int paramInt);
  
  public native boolean SetMap(Map<String, String> paramMap);
  
  public native boolean SetNull();
  
  public native boolean SetString(String paramString);
  
  public native boolean SetTableAsJsonString(String paramString);
  
  public native boolean SetView(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ark.VariantWrapper
 * JD-Core Version:    0.7.0.1
 */