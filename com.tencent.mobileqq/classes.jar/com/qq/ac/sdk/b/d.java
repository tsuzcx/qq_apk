package com.qq.ac.sdk.b;

import com.qq.ac.sdk.bean.AcPicture;
import com.qq.ac.sdk.bean.AcPictureListResponse;
import com.qq.ac.sdk.g.b;
import com.qq.ac.sdk.listener.AcPictureListListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends a<AcPictureListResponse>
{
  private AcPictureListListener b;
  
  public d(AcPictureListListener paramAcPictureListListener)
  {
    this.b = paramAcPictureListListener;
  }
  
  private static AcPictureListResponse a(String paramString)
  {
    AcPictureListResponse localAcPictureListResponse = new AcPictureListResponse();
    ArrayList localArrayList = new ArrayList();
    localAcPictureListResponse.setData(localArrayList);
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str2 = paramString.getString("img_host");
        int j = paramString.getInt("img_url_type");
        JSONArray localJSONArray = paramString.getJSONArray("data");
        if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
          continue;
        }
        i = 0;
        if (i < localJSONArray.length())
        {
          AcPicture localAcPicture = new AcPicture();
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          String str1 = localJSONObject.getString("img_url");
          paramString = str1;
          if (j == 1) {
            paramString = str2 + str1;
          }
          localAcPicture.setImgUrl(paramString);
          localAcPicture.setWidth(localJSONObject.getInt("width"));
          localAcPicture.setHeight(localJSONObject.getInt("height"));
          localAcPicture.setSeqNo(localJSONObject.getInt("seq_no"));
          localAcPicture.setImgId(localJSONObject.optInt("img_id"));
          localArrayList.add(localAcPicture);
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
      localAcPictureListResponse.setStatusCode(i);
      b.a(a, "onConver time = " + (System.currentTimeMillis() - Long.valueOf(l).longValue()));
      return localAcPictureListResponse;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.ac.sdk.b.d
 * JD-Core Version:    0.7.0.1
 */