package com.tencent.aelight.camera.aioeditor.capture.data;

import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DoodleMusicCategoryItem
  implements Cloneable
{
  public int a;
  public boolean b;
  public String c;
  public List<MusicItemInfo> d;
  public boolean e = true;
  
  public DoodleMusicCategoryItem() {}
  
  public DoodleMusicCategoryItem(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("categoryName")) {
      this.c = paramJSONObject.getString("categoryName");
    }
    if (paramJSONObject.has("tagid")) {
      this.a = paramJSONObject.getInt("tagid");
    }
    if (paramJSONObject.has("enabled")) {
      this.e = paramJSONObject.getBoolean("enabled");
    }
    this.b = "1".equals(paramJSONObject.optString("random_position"));
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        MusicItemInfo localMusicItemInfo = new MusicItemInfo(paramJSONObject.optString(i));
        localMusicItemInfo.mTagName = this.c;
        localMusicItemInfo.isWsBanner();
        localArrayList.add(localMusicItemInfo);
        i += 1;
      }
      this.d = localArrayList;
    }
  }
  
  public DoodleMusicCategoryItem a()
  {
    try
    {
      DoodleMusicCategoryItem localDoodleMusicCategoryItem = (DoodleMusicCategoryItem)super.clone();
      return localDoodleMusicCategoryItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public MusicItemInfo a(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MusicItemInfo localMusicItemInfo = (MusicItemInfo)((Iterator)localObject).next();
        if (localMusicItemInfo.mItemId == paramInt) {
          return localMusicItemInfo;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.DoodleMusicCategoryItem
 * JD-Core Version:    0.7.0.1
 */