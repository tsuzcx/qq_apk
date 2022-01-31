package com.tencent.biz.authorize;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import klp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonConfig
  extends AbstractConfig
{
  public final Handler a;
  public final ConcurrentHashMap a;
  
  public JsonConfig(SharedPreferences paramSharedPreferences, AbstractConfig paramAbstractConfig)
  {
    super(paramSharedPreferences, paramAbstractConfig);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
    this.jdField_a_of_type_AndroidOsHandler = new klp(this, Looper.getMainLooper());
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("cmdConfig", null);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null) {
          break label123;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("AuthorizeConfig", 2, "now read cmdConfig {\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\", \"deviceapp.*\"]}");
          }
          JSONObject localJSONObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\", \"deviceapp.*\"]}");
          localObject1 = localJSONObject;
          if (localObject1 != null) {
            break label126;
          }
          QLog.e("AuthorizeConfig", 1, "cmdJsonObject is null!");
          return;
        }
        catch (JSONException localJSONException2)
        {
          if (!QLog.isColorLevel()) {
            break label123;
          }
          QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
        }
        localJSONException1 = localJSONException1;
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
        }
        localObject2 = null;
        continue;
      }
      QLog.e("AuthorizeConfig", 2, "now error! old mPref have no value for cmdConfig!");
      Object localObject2 = null;
      continue;
      label123:
      continue;
      label126:
      JSONArray localJSONArray1 = localObject2.names();
      if ((localJSONArray1 == null) || (localJSONArray1.length() == 0))
      {
        QLog.e("AuthorizeConfig", 1, "domain Name are all empty!");
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      int i = 0;
      while (i < localJSONArray1.length())
      {
        HashSet localHashSet = new HashSet(20);
        String str = localJSONArray1.optString(i);
        JSONArray localJSONArray2 = localObject2.optJSONArray(str);
        if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
        {
          int j = 0;
          while (j < localJSONArray2.length())
          {
            localHashSet.add(localJSONArray2.optString(j));
            j += 1;
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localHashSet);
        }
        i += 1;
      }
    }
  }
  
  private void d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("cmd_config_new", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      Object localObject3;
      int j;
      String str;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          break label221;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        int m = ((JSONArray)localObject1).length();
        i = 0;
        if (i >= m) {
          break label220;
        }
        localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        JSONArray localJSONArray1 = ((JSONObject)localObject3).optJSONArray("api");
        JSONArray localJSONArray2 = ((JSONObject)localObject3).optJSONArray("match");
        int n = localJSONArray2.length();
        j = 0;
        if (j >= n) {
          break label249;
        }
        str = localJSONArray2.optString(j);
        Set localSet = (Set)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        localObject3 = localSet;
        if (localSet == null) {
          localObject3 = new HashSet(20);
        }
        int i1 = localJSONArray1.length();
        int k = 0;
        if (k >= i1) {
          break label230;
        }
        ((Set)localObject3).add(localJSONArray1.optString(k));
        k += 1;
        continue;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "Js Api Config JSONArray error!", localException);
        }
        Object localObject2 = null;
        continue;
      }
      QLog.e("AuthorizeConfig", 1, "get Js Api Config From Pref is empty!");
      label220:
      return;
      label221:
      QLog.e("AuthorizeConfig", 1, "Js Api Config JSONArray From Pref is empty");
      return;
      label230:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject3);
      j += 1;
      continue;
      label249:
      i += 1;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a())
    {
      int i = this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.a(paramString1, paramString2);
      if ((a(i)) || (!b(i))) {
        return i;
      }
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)
    {
      d();
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
        c();
      }
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)
    {
      QLog.e("AuthorizeConfig", 1, "can not find any JS API, so return!");
      return a(false, true);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet();
    if (((Set)localObject).size() == 0) {
      return a(false, true);
    }
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {
      str = paramString1.toLowerCase();
    }
    do
    {
      paramString1 = ((Set)localObject).iterator();
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            if (!paramString1.hasNext()) {
              break;
            }
            localObject = (String)paramString1.next();
          } while (!AuthorizeConfig.b((String)localObject, str));
          localObject = (Set)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        } while ((localObject == null) || (((Set)localObject).size() == 0));
        localObject = ((Set)localObject).iterator();
      }
    } while (!AuthorizeConfig.b((String)((Iterator)localObject).next(), paramString2));
    return a(true, false);
    return a(false, false);
  }
  
  public String a()
  {
    if (!a()) {
      return this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.a();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("offlineHtml", null);
  }
  
  public String a(SharedPreferences.Editor paramEditor, String paramString)
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    Object localObject1 = "";
    for (;;)
    {
      int i;
      try
      {
        localJSONArray1 = localJSONObject.getJSONArray("allow");
        localObject2 = new ConcurrentHashMap(50);
        if ((localJSONArray1 == null) || (localJSONArray1.length() <= 0)) {
          continue;
        }
        paramEditor.putString("cmd_config_new", localJSONArray1.toString());
        paramEditor.putString("cmdConfig", "");
        m = localJSONArray1.length();
        i = 0;
        if (i >= m) {
          continue;
        }
        paramString = localJSONArray1.optJSONObject(i);
        localObject3 = paramString.optJSONArray("api");
        JSONArray localJSONArray2 = paramString.optJSONArray("match");
        int n = localJSONArray2.length();
        j = 0;
        if (j >= n) {
          break label857;
        }
        str3 = localJSONArray2.getString(j);
        paramString = (Set)((ConcurrentHashMap)localObject2).get(str3);
        if (paramString != null) {
          continue;
        }
        paramString = new HashSet(20);
      }
      catch (Exception localJSONException4)
      {
        try
        {
          String str3;
          int i1;
          paramEditor.putString("sid", localJSONObject.getJSONArray("sid").toString());
        }
        catch (JSONException localJSONException4)
        {
          try
          {
            paramEditor.putString("offlineHtml", localJSONObject.getJSONObject("offline").toString());
          }
          catch (JSONException localJSONException4)
          {
            try
            {
              paramEditor.putString("extra", localJSONObject.getJSONObject("ext").toString());
            }
            catch (JSONException localJSONException4)
            {
              try
              {
                paramEditor.putString("jump", localJSONObject.getJSONObject("jump").toString());
              }
              catch (JSONException localJSONException4)
              {
                try
                {
                  int m;
                  localObject1 = new JSONObject();
                  localObject2 = localJSONObject.getJSONArray("schemes");
                  int k = ((JSONArray)localObject2).length();
                  i = 0;
                  if (i < k)
                  {
                    localObject3 = ((JSONArray)localObject2).getJSONObject(i);
                    localJSONArray1 = ((JSONObject)localObject3).getJSONArray("scheme");
                    localObject3 = ((JSONObject)localObject3).getJSONArray("match");
                    j = 0;
                    m = ((JSONArray)localObject3).length();
                    if (j < m)
                    {
                      ((JSONObject)localObject1).put(((JSONArray)localObject3).getString(j), localJSONArray1);
                      j += 1;
                      continue;
                      paramString = paramString;
                      paramString = "" + paramString.getMessage();
                      continue;
                      localJSONException1 = localJSONException1;
                      paramString = paramString + "|" + localJSONException1.getMessage();
                      continue;
                      localJSONException2 = localJSONException2;
                      paramString = paramString + "|" + localJSONException2.getMessage();
                      continue;
                      localJSONException3 = localJSONException3;
                      paramString = paramString + "|" + localJSONException3.getMessage();
                      continue;
                      localJSONException4 = localJSONException4;
                      paramString = paramString + "|" + localJSONException4.getMessage();
                      continue;
                    }
                    i += 1;
                    continue;
                  }
                  paramEditor.putString("schemes", localJSONException4.toString());
                }
                catch (Exception localException1)
                {
                  try
                  {
                    JSONArray localJSONArray1;
                    Object localObject3;
                    paramEditor.putLong("publishSeq", localJSONObject.getLong("publishSeq"));
                    Object localObject2 = AuthorizeConfig.a;
                    int j = localObject2.length;
                    i = 0;
                    if (i < j)
                    {
                      localJSONArray1 = localObject2[i];
                      try
                      {
                        localObject3 = localJSONObject.getJSONArray(localJSONArray1);
                        paramEditor.putString(localJSONArray1, ((JSONArray)localObject3).toString());
                        str1 = paramString;
                        if (QLog.isColorLevel())
                        {
                          QLog.d("AuthorizeConfig", 2, "Server " + localJSONArray1 + " config= " + localObject3);
                          str1 = paramString;
                        }
                      }
                      catch (JSONException localJSONException5)
                      {
                        String str1;
                        String str2 = paramString + "|" + localJSONException5.getMessage();
                        continue;
                      }
                      i += 1;
                      paramString = str1;
                      continue;
                      localException1 = localException1;
                      paramString = paramString + "|" + localException1.getMessage();
                      continue;
                    }
                  }
                  catch (Exception localException2)
                  {
                    QLog.e("AuthorizeConfig", 1, "parse publishSeq error:" + localException2.getMessage());
                    continue;
                  }
                }
              }
            }
          }
        }
        return paramString;
      }
      k = 0;
      i1 = ((JSONArray)localObject3).length();
      if (k < i1)
      {
        paramString.add(((JSONArray)localObject3).getString(k));
        k += 1;
        continue;
        QLog.e("AuthorizeConfig", 1, "update allow JSAPI are all empty!");
        return null;
      }
      else
      {
        ((ConcurrentHashMap)localObject2).put(str3, paramString);
        j += 1;
        continue;
        paramString = Message.obtain();
        paramString.what = 1;
        paramString.obj = localObject2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        paramString = (String)localObject1;
        label857:
        i += 1;
      }
    }
  }
  
  public JSONArray a(String paramString)
  {
    Object localObject1;
    if (!a()) {
      localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.a(paramString);
    }
    do
    {
      for (;;)
      {
        return localObject1;
        localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
        if (localObject1 == null) {
          break label128;
        }
        try
        {
          localJSONArray = new JSONArray((String)localObject1);
          localObject1 = localJSONArray;
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.e("AuthorizeConfig", 2, "Load server config for " + paramString);
              return localJSONArray;
            }
          }
          catch (JSONException localJSONException1) {}
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            Object localObject2;
            JSONArray localJSONArray = null;
          }
        }
      }
      localObject2 = localJSONArray;
    } while (!QLog.isColorLevel());
    QLog.w("AuthorizeConfig", 2, "Decode " + paramString + " Config error");
    return localJSONArray;
    label128:
    return null;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = null;
    if (!a()) {
      localJSONObject = this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.a();
    }
    String str;
    do
    {
      return localJSONObject;
      str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("schemes", null);
    } while (str == null);
    return new JSONObject(str);
  }
  
  public void a()
  {
    b();
  }
  
  public boolean a()
  {
    ((FlatBuffersConfig)this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig).b();
    return !this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.a();
  }
  
  public String b()
  {
    if (!a()) {
      return this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.b();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("extra", null);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public String c()
  {
    if (!a()) {
      return this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.c();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("jump", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.authorize.JsonConfig
 * JD-Core Version:    0.7.0.1
 */