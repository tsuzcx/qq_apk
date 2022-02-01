package com.tencent.biz.qqstory.database;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_group.NewlyLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wiq;
import yuk;

public class LikeEntry
  extends Entity
  implements Comparable<LikeEntry>, wiq
{
  public static final int ROLE_NORMAL = 0;
  public static final int ROLE_VIP = 2;
  public static final String TAG = "Q.qqstory:LikeEntry";
  public static final int TYPE_FEED_LIKE = 3;
  public static final int TYPE_FEED_OPEN_LIKE = 4;
  public String feedId;
  public long likeTime;
  public long role;
  public int type = 3;
  public String uin;
  public String unionId;
  public String vid;
  
  public static LikeEntry convertFrom(qqstory_group.NewlyLikeInfo paramNewlyLikeInfo)
  {
    if (paramNewlyLikeInfo == null) {
      return null;
    }
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.unionId = paramNewlyLikeInfo.union_id.get().toStringUtf8();
    localLikeEntry.uin = String.valueOf(paramNewlyLikeInfo.uin.get());
    localLikeEntry.likeTime = (paramNewlyLikeInfo.time.get() * 1000L);
    return localLikeEntry;
  }
  
  public static LikeEntry convertFrom(qqstory_struct.StoryVideoLikeInfo paramStoryVideoLikeInfo)
  {
    if (paramStoryVideoLikeInfo == null) {
      return null;
    }
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.uin = String.valueOf(paramStoryVideoLikeInfo.uid.get());
    localLikeEntry.likeTime = paramStoryVideoLikeInfo.like_time.get();
    localLikeEntry.role = paramStoryVideoLikeInfo.role.get();
    localLikeEntry.unionId = paramStoryVideoLikeInfo.union_id.get();
    return localLikeEntry;
  }
  
  public static String convertFromItem(List<LikeEntry> paramList)
  {
    if (paramList == null) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LikeEntry localLikeEntry = (LikeEntry)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("uin", localLikeEntry.uin);
        localJSONObject.put("likeTime", localLikeEntry.likeTime);
        localJSONObject.put("role", localLikeEntry.role);
        localJSONObject.put("unionId", localLikeEntry.unionId);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONArray.toString();
  }
  
  public static List<LikeEntry> convertFromJson(String paramString)
  {
    localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          LikeEntry localLikeEntry = new LikeEntry();
          localLikeEntry.uin = localJSONObject.optString("uin");
          localLikeEntry.likeTime = localJSONObject.optLong("likeTime");
          localLikeEntry.role = localJSONObject.optLong("role");
          localLikeEntry.unionId = localJSONObject.optString("unionId");
          localArrayList.add(localLikeEntry);
          i += 1;
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        yuk.e("Q.qqstory:LikeEntry", String.format("Parse json error , %s", new Object[] { paramString.getMessage() }));
      }
    }
  }
  
  public int compareTo(@NonNull LikeEntry paramLikeEntry)
  {
    if (this.likeTime > paramLikeEntry.likeTime) {
      return -1;
    }
    if (this.likeTime < paramLikeEntry.likeTime) {
      return 1;
    }
    return 0;
  }
  
  public void copy(Object paramObject)
  {
    paramObject = (LikeEntry)paramObject;
    this.uin = paramObject.uin;
    this.likeTime = paramObject.likeTime;
    this.role = paramObject.role;
    this.unionId = paramObject.unionId;
    this.vid = paramObject.vid;
    this.feedId = paramObject.feedId;
    this.type = paramObject.type;
  }
  
  public String toString()
  {
    return "LikeEntry{ uin=" + this.uin + ", likeTime=" + this.likeTime + ", vid=" + this.vid + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.LikeEntry
 * JD-Core Version:    0.7.0.1
 */