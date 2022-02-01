package com.qq.ac.sdk.b;

import com.qq.ac.sdk.bean.AcMultiPictureListResponse;
import com.qq.ac.sdk.bean.AcPicture;
import com.qq.ac.sdk.bean.BaseResponse;
import com.qq.ac.sdk.g.b;
import com.qq.ac.sdk.listener.AcMultiPictureListListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends a<AcMultiPictureListResponse>
{
  private AcMultiPictureListListener b;
  
  public c(AcMultiPictureListListener paramAcMultiPictureListListener)
  {
    this.b = paramAcMultiPictureListListener;
  }
  
  private static AcMultiPictureListResponse a(String paramString)
  {
    AcMultiPictureListResponse localAcMultiPictureListResponse = new AcMultiPictureListResponse();
    HashMap localHashMap = new HashMap();
    localAcMultiPictureListResponse.setMapData(localHashMap);
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(paramString);
        if (localJSONArray1.length() <= 0) {
          continue;
        }
        i = 0;
        if (i < localJSONArray1.length())
        {
          ArrayList localArrayList = new ArrayList();
          paramString = (JSONObject)localJSONArray1.get(i);
          String str2 = paramString.optString("img_host");
          int k = paramString.optInt("img_url_type");
          String str3 = paramString.optString("chapter_id");
          JSONArray localJSONArray2 = paramString.getJSONArray("data");
          int j = 0;
          if (j < localJSONArray2.length())
          {
            AcPicture localAcPicture = new AcPicture();
            JSONObject localJSONObject = (JSONObject)localJSONArray2.get(j);
            String str1 = localJSONObject.getString("img_url");
            paramString = str1;
            if (k == 1) {
              paramString = str2 + str1;
            }
            localAcPicture.setImgUrl(paramString);
            localAcPicture.setWidth(localJSONObject.getInt("width"));
            localAcPicture.setHeight(localJSONObject.getInt("height"));
            localAcPicture.setSeqNo(localJSONObject.getInt("seq_no"));
            localAcPicture.setImgId(localJSONObject.optInt("img_id"));
            localArrayList.add(localAcPicture);
            j += 1;
            continue;
          }
          localHashMap.put(str3, localArrayList);
          i += 1;
          continue;
        }
        i = 2;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        int i = -60005;
        continue;
      }
      localAcMultiPictureListResponse.setStatusCode(i);
      b.a(a, "onConver time = " + (System.currentTimeMillis() - Long.valueOf(l).longValue()));
      return localAcMultiPictureListResponse;
      i = -60004;
    }
  }
  
  public final void onFailure(int paramInt)
  {
    if (this.b != null) {
      this.b.onFailure(paramInt);
    }
  }
  
  public final void onResponse(String paramString)
  {
    if (this.b != null) {
      this.b.onResponse(a(paramString));
    }
  }
  
  public final BaseResponse onSyncResponse(String paramString)
  {
    return a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.ac.sdk.b.c
 * JD-Core Version:    0.7.0.1
 */