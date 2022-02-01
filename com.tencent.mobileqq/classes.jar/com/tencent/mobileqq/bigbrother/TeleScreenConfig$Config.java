package com.tencent.mobileqq.bigbrother;

import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TeleScreenConfig$Config
{
  public int a = 10000;
  public int b = 5000;
  public boolean c = false;
  public ArraySet<String> d = new ArraySet();
  private ArraySet<String> e = new ArraySet();
  private ArraySet<String> f = new ArraySet();
  
  private void b(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("telescreen config: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TeleScreenConfig", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.a = 0;
      this.b = 0;
      this.c = false;
      this.d.clear();
      this.e.clear();
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        this.a = ((int)(paramString.optDouble("download_timeout") * 1000.0D));
        if (this.a <= 0) {
          i = 10000;
        } else {
          i = this.a;
        }
        this.a = i;
        this.b = ((int)(paramString.optDouble("jump_timeout") * 1000.0D));
        if (this.b <= 0) {
          i = 5000;
        } else {
          i = this.b;
        }
        this.b = i;
        if (paramString.optInt("use_block_mode", 1) == 0)
        {
          bool = true;
          this.c = bool;
          localObject = paramString.optJSONArray("check_white_list");
          this.d.clear();
          if (localObject != null)
          {
            i = ((JSONArray)localObject).length() - 1;
            if (i >= 0)
            {
              if (TextUtils.isEmpty(((JSONArray)localObject).getString(i))) {
                break label396;
              }
              this.d.add(((JSONArray)localObject).getString(i));
              break label396;
            }
          }
          localObject = paramString.optJSONArray("scheme_white_list");
          this.e.clear();
          if (localObject != null)
          {
            i = ((JSONArray)localObject).length() - 1;
            if (i >= 0)
            {
              if (TextUtils.isEmpty(((JSONArray)localObject).getString(i))) {
                break label403;
              }
              this.e.add(((JSONArray)localObject).getString(i));
              break label403;
            }
          }
          paramString = paramString.optJSONArray("md5");
          this.f.clear();
          if (paramString != null)
          {
            i = paramString.length() - 1;
            if (i >= 0)
            {
              if (!TextUtils.isEmpty(paramString.getString(i))) {
                this.f.add(new String(Base64.decode(paramString.getString(i), 0)));
              }
              i -= 1;
              continue;
            }
          }
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("TeleScreenConfig", 1, paramString, new Object[0]);
      }
      boolean bool = false;
      continue;
      label396:
      i -= 1;
      continue;
      label403:
      i -= 1;
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.d.contains(paramString1)) {
      return true;
    }
    if (paramString2 != null)
    {
      paramString1 = this.e.iterator();
      while (paramString1.hasNext()) {
        if (paramString2.startsWith((String)paramString1.next())) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.TeleScreenConfig.Config
 * JD-Core Version:    0.7.0.1
 */