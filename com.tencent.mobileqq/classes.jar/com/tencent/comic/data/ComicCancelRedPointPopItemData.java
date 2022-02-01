package com.tencent.comic.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ComicCancelRedPointPopItemData
  implements Parcelable, Serializable
{
  public static final int BEHAVIOR_COLLECT = 2;
  public static final int BEHAVIOR_NONE = 0;
  public static final int BEHAVIOR_PRISE = 3;
  public static final int BEHAVIOR_READ = 1;
  public static final Parcelable.Creator<ComicCancelRedPointPopItemData> CREATOR = new ComicCancelRedPointPopItemData.1();
  public static final String JSON_KEY_BEHAVIOR = "behavior";
  public static final String JSON_KEY_COMIC_ID = "comicId";
  public static final String JSON_KEY_COVER_IMG = "coverImg";
  public static final String JSON_KEY_FRIEND_NUM = "friendNum";
  public static final String JSON_KEY_TAGS = "tags";
  public static final String JSON_KEY_TEXT = "text";
  public static final String JSON_KEY_TITLE = "title";
  public int behavior = 0;
  public String comicId = null;
  public String coverImg = null;
  public long friendNum = 0L;
  public List<String> tags = new ArrayList();
  public String text = null;
  public String title = null;
  
  public ComicCancelRedPointPopItemData() {}
  
  protected ComicCancelRedPointPopItemData(Parcel paramParcel)
  {
    this.coverImg = paramParcel.readString();
    this.title = paramParcel.readString();
    this.comicId = paramParcel.readString();
    this.text = paramParcel.readString();
    this.friendNum = paramParcel.readLong();
    this.behavior = paramParcel.readInt();
    this.tags = paramParcel.createStringArrayList();
  }
  
  public static ArrayList<ComicCancelRedPointPopItemData> getOrderedList(List<ComicCancelRedPointPopItemData> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ComicCancelRedPointPopItemData localComicCancelRedPointPopItemData = (ComicCancelRedPointPopItemData)paramList.next();
        int i = 0;
        while ((i < localArrayList.size()) && (localComicCancelRedPointPopItemData.friendNum < ((ComicCancelRedPointPopItemData)localArrayList.get(i)).friendNum)) {
          i += 1;
        }
        localArrayList.add(i, localComicCancelRedPointPopItemData);
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public static List<ComicCancelRedPointPopItemData> parseFromJsonArray(JSONArray paramJSONArray, boolean paramBoolean)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramJSONArray.length();
      int i = 0;
      while (i < k)
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        ComicCancelRedPointPopItemData localComicCancelRedPointPopItemData = new ComicCancelRedPointPopItemData();
        localComicCancelRedPointPopItemData.coverImg = ((JSONObject)localObject).optString("coverImg");
        localComicCancelRedPointPopItemData.title = ((JSONObject)localObject).optString("title");
        localComicCancelRedPointPopItemData.comicId = ((JSONObject)localObject).optString("comicId");
        localComicCancelRedPointPopItemData.text = ((JSONObject)localObject).optString("text");
        localComicCancelRedPointPopItemData.friendNum = ((JSONObject)localObject).optInt("friendNum");
        localComicCancelRedPointPopItemData.behavior = ((JSONObject)localObject).optInt("behavior");
        localObject = ((JSONObject)localObject).optJSONArray("tags");
        if (localObject != null)
        {
          int m = ((JSONArray)localObject).length();
          int j = 0;
          while (j < m)
          {
            localComicCancelRedPointPopItemData.tags.add(((JSONArray)localObject).optString(j));
            j += 1;
          }
        }
        localArrayList.add(localComicCancelRedPointPopItemData);
        i += 1;
      }
      paramJSONArray = localArrayList;
      if (paramBoolean) {
        paramJSONArray = getOrderedList(localArrayList);
      }
      return paramJSONArray;
    }
    catch (Throwable paramJSONArray)
    {
      label195:
      break label195;
    }
    return new ArrayList();
  }
  
  public static JSONArray transformToJsonArray(List<ComicCancelRedPointPopItemData> paramList)
  {
    try
    {
      JSONArray localJSONArray1 = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (ComicCancelRedPointPopItemData)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("coverImg", ((ComicCancelRedPointPopItemData)localObject).coverImg);
        localJSONObject.put("title", ((ComicCancelRedPointPopItemData)localObject).title);
        localJSONObject.put("comicId", ((ComicCancelRedPointPopItemData)localObject).comicId);
        localJSONObject.put("text", ((ComicCancelRedPointPopItemData)localObject).text);
        localJSONObject.put("friendNum", ((ComicCancelRedPointPopItemData)localObject).friendNum);
        localJSONObject.put("behavior", ((ComicCancelRedPointPopItemData)localObject).behavior);
        if (((ComicCancelRedPointPopItemData)localObject).tags != null)
        {
          JSONArray localJSONArray2 = new JSONArray();
          localObject = ((ComicCancelRedPointPopItemData)localObject).tags.iterator();
          while (((Iterator)localObject).hasNext()) {
            localJSONArray2.put((String)((Iterator)localObject).next());
          }
          localJSONObject.put("tags", localJSONArray2);
        }
        localJSONArray1.put(localJSONObject);
      }
      return localJSONArray1;
    }
    catch (Throwable paramList)
    {
      label190:
      break label190;
    }
    return new JSONArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CancelRedPointPopItemData:");
    localStringBuilder.append("\n");
    localStringBuilder.append("coverImg:");
    localStringBuilder.append(this.coverImg);
    localStringBuilder.append("\n");
    localStringBuilder.append("title:");
    localStringBuilder.append(this.title);
    localStringBuilder.append("\n");
    localStringBuilder.append("friendNum:");
    localStringBuilder.append(this.friendNum);
    localStringBuilder.append("\n");
    localStringBuilder.append("behavior:");
    localStringBuilder.append(this.behavior);
    localStringBuilder.append("\n");
    localStringBuilder.append("text:");
    localStringBuilder.append(this.text);
    localStringBuilder.append("\n");
    localStringBuilder.append("comicId:");
    localStringBuilder.append(this.comicId);
    localStringBuilder.append("\n");
    Object localObject = this.tags;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localStringBuilder.append("tag:");
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.coverImg);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.comicId);
    paramParcel.writeString(this.text);
    paramParcel.writeLong(this.friendNum);
    paramParcel.writeInt(this.behavior);
    paramParcel.writeStringList(this.tags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.data.ComicCancelRedPointPopItemData
 * JD-Core Version:    0.7.0.1
 */