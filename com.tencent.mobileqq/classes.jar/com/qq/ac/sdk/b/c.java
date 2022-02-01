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
    int i;
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramString);
      if (localJSONArray1.length() > 0)
      {
        i = 0;
        while (i < localJSONArray1.length())
        {
          ArrayList localArrayList = new ArrayList();
          paramString = (JSONObject)localJSONArray1.get(i);
          String str1 = paramString.optString("img_host");
          int k = paramString.optInt("img_url_type");
          String str2 = paramString.optString("chapter_id");
          JSONArray localJSONArray2 = paramString.getJSONArray("data");
          int j = 0;
          while (j < localJSONArray2.length())
          {
            AcPicture localAcPicture = new AcPicture();
            JSONObject localJSONObject = (JSONObject)localJSONArray2.get(j);
            localObject = localJSONObject.getString("img_url");
            paramString = (String)localObject;
            if (k == 1)
            {
              paramString = new StringBuilder();
              paramString.append(str1);
              paramString.append((String)localObject);
              paramString = paramString.toString();
            }
            localAcPicture.setImgUrl(paramString);
            localAcPicture.setWidth(localJSONObject.getInt("width"));
            localAcPicture.setHeight(localJSONObject.getInt("height"));
            localAcPicture.setSeqNo(localJSONObject.getInt("seq_no"));
            localAcPicture.setImgId(localJSONObject.optInt("img_id"));
            localArrayList.add(localAcPicture);
            j += 1;
          }
          localHashMap.put(str2, localArrayList);
          i += 1;
        }
        i = 2;
      }
      else
      {
        i = -60004;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      i = -60005;
    }
    localAcMultiPictureListResponse.setStatusCode(i);
    paramString = a;
    Object localObject = new StringBuilder("onConver time = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - Long.valueOf(l).longValue());
    b.a(paramString, ((StringBuilder)localObject).toString());
    return localAcMultiPictureListResponse;
  }
  
  public final void onFailure(int paramInt)
  {
    AcMultiPictureListListener localAcMultiPictureListListener = this.b;
    if (localAcMultiPictureListListener != null) {
      localAcMultiPictureListListener.onFailure(paramInt);
    }
  }
  
  public final void onResponse(String paramString)
  {
    AcMultiPictureListListener localAcMultiPictureListListener = this.b;
    if (localAcMultiPictureListListener != null) {
      localAcMultiPictureListListener.onResponse(a(paramString));
    }
  }
  
  public final BaseResponse onSyncResponse(String paramString)
  {
    return a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.ac.sdk.b.c
 * JD-Core Version:    0.7.0.1
 */