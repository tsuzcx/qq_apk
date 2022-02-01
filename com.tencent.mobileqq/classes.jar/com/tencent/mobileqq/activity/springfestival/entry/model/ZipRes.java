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
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
      localStringBuilder.append("shua2021_ZipRes");
      localObject = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label50:
      break label50;
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (ZipRes)paramObject;
      return this.url.equals(paramObject.url);
    }
    return false;
  }
  
  public boolean isRecentlyCheckOk()
  {
    boolean bool1 = TextUtils.isEmpty(this.url);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    String str = MD5.toMD5(this.url);
    long l = SystemClock.uptimeMillis();
    SharedPreferences localSharedPreferences = getSP();
    bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (l - localSharedPreferences.getLong(str, 0L) < 1800000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void markRecentlyCheckOk()
  {
    if (TextUtils.isEmpty(this.url)) {
      return;
    }
    String str = MD5.toMD5(this.url);
    long l = SystemClock.uptimeMillis();
    SharedPreferences localSharedPreferences = getSP();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong(str, l).apply();
    }
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.id = paramJSONObject.optString("Id", this.id);
    this.url = paramJSONObject.optString("Url", this.url);
    this.md5 = paramJSONObject.optString("Md5", this.md5);
    boolean bool = false;
    if (paramJSONObject.optInt("IsNecessary", 0) == 1) {
      bool = true;
    }
    this.isNecessary = bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZipRes{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isNecessary=");
    localStringBuilder.append(this.isNecessary);
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.ZipRes
 * JD-Core Version:    0.7.0.1
 */