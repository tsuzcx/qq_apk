package com.tencent.map.tools.net;

import android.content.Context;
import com.tencent.map.tools.net.http.HttpCanceler;
import java.util.HashMap;

public abstract interface NetAdapter
{
  public static final String KEY_HALLEY_APP_ID = "halley_app_id";
  public static final String KEY_HALLEY_APP_NAME = "halley_app_name";
  public static final String KEY_HALLEY_APP_VERSION = "halley_app_version";
  
  public abstract boolean cancel();
  
  public abstract NetResponse doGet(String paramString);
  
  public abstract NetResponse doGet(String paramString, int paramInt, HttpCanceler paramHttpCanceler);
  
  public abstract NetResponse doGet(String paramString1, String paramString2);
  
  public abstract NetResponse doGet(String paramString1, String paramString2, int paramInt);
  
  public abstract NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler);
  
  public abstract NetResponse doGet(String paramString1, String paramString2, int paramInt, HttpCanceler paramHttpCanceler);
  
  public abstract NetResponse doGet(String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler);
  
  public abstract NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  public abstract NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt);
  
  public abstract NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler);
  
  public abstract NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HttpCanceler paramHttpCanceler);
  
  public abstract NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler);
  
  public abstract NetResponse doPost(String paramString, byte[] paramArrayOfByte);
  
  public abstract NetResponse doPost(String paramString, byte[] paramArrayOfByte, int paramInt, HttpCanceler paramHttpCanceler);
  
  public abstract NetResponse doPostNoBuffer(String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  public abstract void doRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler);
  
  public abstract void initNet(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.tools.net.NetAdapter
 * JD-Core Version:    0.7.0.1
 */