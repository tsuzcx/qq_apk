package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.qq.ac.sdk.api.AcChapterList;
import com.qq.ac.sdk.api.AcMultiPictureList;
import com.qq.ac.sdk.bean.AcChapterListResponse;
import com.qq.ac.sdk.bean.AcMultiPictureListResponse;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ComicModule
  extends BaseModule
  implements Destroyable
{
  public static final String MODULE_NAME = "comic";
  public static final String TAG = "ComicModule";
  
  public void destroy() {}
  
  @JSMethod(uiThread=false)
  public void getChapterList(@NonNull String paramString1, String paramString2)
  {
    localJSONObject = new JSONObject();
    String str = "";
    try
    {
      Object localObject = new AcChapterList().syncGetChapterList(paramString1);
      paramString1 = str;
      if (localObject != null)
      {
        localObject = ((AcChapterListResponse)localObject).getData();
        paramString1 = str;
        if (localObject != null) {
          paramString1 = new Gson().toJson(localObject);
        }
      }
      localJSONObject.put("data", paramString1);
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("ComicModule", 1, "ComicModule getChapterList:", paramString1);
        try
        {
          localJSONObject.put("error_code", paramString1.getMessage());
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
        }
      }
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "comic", "callback", paramString2, localJSONObject, true);
    }
  }
  
  @JSMethod(uiThread=false)
  public void getPictureList(@NonNull String paramString1, String paramString2, String paramString3)
  {
    localJSONObject = new JSONObject();
    AcMultiPictureList localAcMultiPictureList = new AcMultiPictureList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    try
    {
      paramString1 = localAcMultiPictureList.syncGetMultiPictureList(paramString1, localArrayList);
      if (paramString1 == null) {
        break label166;
      }
      paramString1 = paramString1.getData();
      if ((paramString1 == null) || (!paramString1.containsKey(paramString2))) {
        break label166;
      }
      paramString1 = (List)paramString1.get(paramString2);
      if (paramString1 == null) {
        break label166;
      }
      paramString1 = new Gson().toJson(paramString1);
    }
    catch (Exception paramString1)
    {
      for (;;)
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
        continue;
        paramString1 = "";
      }
    }
    localJSONObject.put("data", paramString1);
    if (!TextUtils.isEmpty(paramString3)) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "comic", "callback", paramString3, localJSONObject, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.ComicModule
 * JD-Core Version:    0.7.0.1
 */