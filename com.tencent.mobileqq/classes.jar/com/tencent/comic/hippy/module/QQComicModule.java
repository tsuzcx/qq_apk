package com.tencent.comic.hippy.module;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.qq.ac.sdk.api.AcChapterList;
import com.qq.ac.sdk.api.AcMultiPictureList;
import com.qq.ac.sdk.bean.AcChapterListResponse;
import com.qq.ac.sdk.bean.AcMultiPictureListResponse;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QQComicModule
  extends ComicModule
{
  private void doPromiseCallback(Promise paramPromise, JSONObject paramJSONObject)
  {
    if ((paramPromise != null) && (paramPromise.isCallback()))
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushJSONObject(paramJSONObject);
      paramPromise.resolve(localHippyMap);
    }
  }
  
  public void destroy() {}
  
  public void getChapterList(@NonNull String paramString, Promise paramPromise)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramString = new AcChapterList().syncGetChapterList(paramString);
      if (paramString != null)
      {
        paramString = paramString.getData();
        if (paramString != null)
        {
          paramString = new Gson().toJson(paramString);
          break label51;
        }
      }
      paramString = "";
      label51:
      localJSONObject.put("data", paramString);
    }
    catch (Exception paramString)
    {
      QLog.e("ComicModule", 1, "ComicModule getChapterList:", paramString);
      try
      {
        localJSONObject.put("error_code", paramString.getMessage());
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    doPromiseCallback(paramPromise, localJSONObject);
  }
  
  public void getPictureList(@NonNull String paramString1, String paramString2, Promise paramPromise)
  {
    JSONObject localJSONObject = new JSONObject();
    AcMultiPictureList localAcMultiPictureList = new AcMultiPictureList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    try
    {
      paramString1 = localAcMultiPictureList.syncGetMultiPictureList(paramString1, localArrayList);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getData();
        if ((paramString1 != null) && (paramString1.containsKey(paramString2)))
        {
          paramString1 = (List)paramString1.get(paramString2);
          if (paramString1 != null)
          {
            paramString1 = new Gson().toJson(paramString1);
            break label101;
          }
        }
      }
      paramString1 = "";
      label101:
      localJSONObject.put("data", paramString1);
    }
    catch (Exception paramString1)
    {
      QLog.e("ComicModule", 1, "ComicModule getPictureList:", paramString1);
      try
      {
        localJSONObject.put("error_code", paramString1.getMessage());
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    doPromiseCallback(paramPromise, localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.hippy.module.QQComicModule
 * JD-Core Version:    0.7.0.1
 */