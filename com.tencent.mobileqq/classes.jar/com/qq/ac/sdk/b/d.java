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
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("img_host");
      int j = paramString.getInt("img_url_type");
      JSONArray localJSONArray = paramString.getJSONArray("data");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          AcPicture localAcPicture = new AcPicture();
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          localObject = localJSONObject.getString("img_url");
          paramString = (String)localObject;
          if (j == 1)
          {
            paramString = new StringBuilder();
            paramString.append(str);
            paramString.append((String)localObject);
            paramString = paramString.toString();
          }
          localAcPicture.setImgUrl(paramString);
          localAcPicture.setWidth(localJSONObject.getInt("width"));
          localAcPicture.setHeight(localJSONObject.getInt("height"));
          localAcPicture.setSeqNo(localJSONObject.getInt("seq_no"));
          localAcPicture.setImgId(localJSONObject.optInt("img_id"));
          localArrayList.add(localAcPicture);
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
    localAcPictureListResponse.setStatusCode(i);
    paramString = a;
    Object localObject = new StringBuilder("onConver time = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - Long.valueOf(l).longValue());
    b.a(paramString, ((StringBuilder)localObject).toString());
    return localAcPictureListResponse;
  }
  
  public final void onFailure(int paramInt)
  {
    AcPictureListListener localAcPictureListListener = this.b;
    if (localAcPictureListListener != null) {
      localAcPictureListListener.onFailure(paramInt);
    }
  }
  
  public final void onResponse(String paramString)
  {
    AcPictureListListener localAcPictureListListener = this.b;
    if (localAcPictureListListener != null) {
      localAcPictureListListener.onResponse(a(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.ac.sdk.b.d
 * JD-Core Version:    0.7.0.1
 */