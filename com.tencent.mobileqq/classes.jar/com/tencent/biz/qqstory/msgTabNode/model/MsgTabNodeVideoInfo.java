package com.tencent.biz.qqstory.msgTabNode.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgTabNodeVideoInfo
{
  public long a;
  @Nullable
  public StoryVideoItem a;
  @Nullable
  public String a;
  public boolean a;
  @Nullable
  public String b = "";
  
  public MsgTabNodeVideoInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static MsgTabNodeVideoInfo a(List paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramList.next();
      if (paramLong == localMsgTabNodeVideoInfo.jdField_a_of_type_Long) {
        return localMsgTabNodeVideoInfo;
      }
    }
    return null;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("videoIndex", this.jdField_a_of_type_Long);
      localJSONObject.put("didRead", this.jdField_a_of_type_Boolean);
      localJSONObject.put("vid", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("feedId", this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public void a(qqstory_service.MsgTabNodeVideoInfo paramMsgTabNodeVideoInfo, ArrayDeque paramArrayDeque)
  {
    this.jdField_a_of_type_Long = paramMsgTabNodeVideoInfo.uint64_video_index.get();
    boolean bool;
    if (paramMsgTabNodeVideoInfo.uint32_did_read.get() != 0)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (paramMsgTabNodeVideoInfo.vid.has()) {
        this.jdField_a_of_type_JavaLangString = paramMsgTabNodeVideoInfo.vid.get().toStringUtf8();
      }
      if (!paramMsgTabNodeVideoInfo.feed_id.has()) {
        break label139;
      }
      this.b = paramMsgTabNodeVideoInfo.feed_id.get().toStringUtf8();
      if (!TextUtils.equals(this.b, (CharSequence)paramArrayDeque.peek())) {
        paramArrayDeque.push(this.b);
      }
    }
    for (;;)
    {
      if (paramMsgTabNodeVideoInfo.video_info.has())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = new StoryVideoItem();
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.convertFrom(paramMsgTabNodeVideoInfo.video_info);
      }
      return;
      bool = false;
      break;
      label139:
      paramArrayDeque = (String)paramArrayDeque.peek();
      if (paramArrayDeque != null) {
        this.b = paramArrayDeque;
      }
    }
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Long = paramJSONObject.getLong("videoIndex");
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("didRead");
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("vid", "");
      this.b = paramJSONObject.optString("feedId", "");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof MsgTabNodeVideoInfo)) {
        return false;
      }
      paramObject = (MsgTabNodeVideoInfo)paramObject;
    } while (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long);
    return false;
  }
  
  public String toString()
  {
    return "MsgTabNodeVideoInfo{videoIndex=" + this.jdField_a_of_type_Long + ", didRead=" + this.jdField_a_of_type_Boolean + ", vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", feedId='" + this.b + '\'' + ", storyItem=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo
 * JD-Core Version:    0.7.0.1
 */