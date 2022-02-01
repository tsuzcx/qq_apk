package com.tencent.mobileqq.activity.springfestival.entry.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.MD5;
import java.io.Serializable;
import org.json.JSONObject;

public class ZipRes
  implements Serializable
{
  public static final String MD5_FILENAME = "list.txt";
  public static final String REF_SCHEME = "ref";
  public static final String SP_FILE = "shua2021_ZipRes";
  public String id = "";
  public boolean isNecessary = false;
  public String md5 = "";
  public String url = "";
  
  public static SharedPreferences getSP()
  {
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences(((QQAppInterface)localObject).getCurrentAccountUin() + "shua2021_ZipRes", 0);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (ZipRes)paramObject;
    return this.url.equals(paramObject.url);
  }
  
  public boolean isRecentlyCheckOk()
  {
    if (TextUtils.isEmpty(this.url)) {}
    String str;
    long l;
    SharedPreferences localSharedPreferences;
    do
    {
      return false;
      str = MD5.toMD5(this.url);
      l = SystemClock.uptimeMillis();
      localSharedPreferences = getSP();
    } while ((localSharedPreferences == null) || (l - localSharedPreferences.getLong(str, 0L) >= 1800000L));
    return true;
  }
  
  public void markRecentlyCheckOk()
  {
    if (TextUtils.isEmpty(this.url)) {}
    String str;
    long l;
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      str = MD5.toMD5(this.url);
      l = SystemClock.uptimeMillis();
      localSharedPreferences = getSP();
    } while (localSharedPreferences == null);
    localSharedPreferences.edit().putLong(str, l).apply();
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {
      return;
    }
    this.id = paramJSONObject.optString("Id", this.id);
    this.url = paramJSONObject.optString("Url", this.url);
    this.md5 = paramJSONObject.optString("Md5", this.md5);
    if (paramJSONObject.optInt("IsNecessary", 0) == 1) {}
    for (;;)
    {
      this.isNecessary = bool;
      return;
      bool = false;
    }
  }
  
  public String toString()
  {
    return "ZipRes{id='" + this.id + '\'' + ", isNecessary=" + this.isNecessary + ", md5='" + this.md5 + '\'' + ", url='" + this.url + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.ZipRes
 * JD-Core Version:    0.7.0.1
 */