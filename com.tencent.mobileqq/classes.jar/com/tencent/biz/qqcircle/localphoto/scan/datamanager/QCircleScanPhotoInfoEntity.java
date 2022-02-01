package com.tencent.biz.qqcircle.localphoto.scan.datamanager;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo.ImageTag;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QCircleScanPhotoInfoEntity
  extends Entity
{
  public boolean hasUpload;
  public int height;
  public String imageTags;
  public float latitude;
  public float longitude;
  public String mineType;
  public long modifyTime;
  public int orientation;
  public String path;
  @unique
  public int photoId;
  public long time;
  public int width;
  
  public static String imageTagToString(List<LocalPhotoInfo.ImageTag> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LocalPhotoInfo.ImageTag localImageTag = (LocalPhotoInfo.ImageTag)paramList.next();
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("classifyType", localImageTag.a);
          localJSONObject.put("classifyName", localImageTag.b);
          localJSONObject.put("classifyConfidence", String.valueOf(localImageTag.c));
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static List<LocalPhotoInfo.ImageTag> stringToImagtags(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          LocalPhotoInfo.ImageTag localImageTag = new LocalPhotoInfo.ImageTag();
          localImageTag.a = localJSONObject.getString("classifyType");
          localImageTag.b = localJSONObject.getString("classifyName");
          localImageTag.c = Float.parseFloat(localJSONObject.getString("classifyConfidence"));
          localArrayList.add(localImageTag);
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.datamanager.QCircleScanPhotoInfoEntity
 * JD-Core Version:    0.7.0.1
 */