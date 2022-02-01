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
import com.tencent.mobileqq.pb.PBStringField;
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
  public boolean b;
  @Nullable
  public String c = "";
  @Nullable
  public String d = "";
  @Nullable
  public StoryVideoItem e = null;
  public long f;
  public int g;
  public String h;
  public String i;
  public int j;
  public String k;
  public String l;
  
  public static MsgTabNodeVideoInfo a(List<MsgTabNodeVideoInfo> paramList, long paramLong)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramList.next();
        if (paramLong == localMsgTabNodeVideoInfo.a) {
          return localMsgTabNodeVideoInfo;
        }
      }
    }
    return null;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("videoIndex", this.a);
      localJSONObject.put("didRead", this.b);
      localJSONObject.put("vid", this.c);
      localJSONObject.put("feedId", this.d);
      localJSONObject.put("recommandId", this.f);
      localJSONObject.put("showBottom", this.g);
      if (!TextUtils.isEmpty(this.h)) {
        localJSONObject.put("bottomWording", this.h);
      }
      if (!TextUtils.isEmpty(this.i)) {
        localJSONObject.put("bottomLink", this.i);
      }
      localJSONObject.put("showText", this.j);
      if (!TextUtils.isEmpty(this.k)) {
        localJSONObject.put("textWording", this.k);
      }
      if (!TextUtils.isEmpty(this.l)) {
        localJSONObject.put("textLink", this.l);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public void a(qqstory_service.MsgTabNodeVideoInfo paramMsgTabNodeVideoInfo, ArrayDeque<String> paramArrayDeque)
  {
    this.a = paramMsgTabNodeVideoInfo.uint64_video_index.get();
    boolean bool;
    if (paramMsgTabNodeVideoInfo.uint32_did_read.get() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
    if (paramMsgTabNodeVideoInfo.vid.has()) {
      this.c = paramMsgTabNodeVideoInfo.vid.get().toStringUtf8();
    }
    if (paramMsgTabNodeVideoInfo.feed_id.has())
    {
      this.d = paramMsgTabNodeVideoInfo.feed_id.get().toStringUtf8();
      if (!TextUtils.equals(this.d, (CharSequence)paramArrayDeque.peek())) {
        paramArrayDeque.push(this.d);
      }
    }
    else
    {
      paramArrayDeque = (String)paramArrayDeque.peek();
      if (paramArrayDeque != null) {
        this.d = paramArrayDeque;
      }
    }
    if (paramMsgTabNodeVideoInfo.video_info.has())
    {
      this.e = new StoryVideoItem();
      this.e.convertFrom(paramMsgTabNodeVideoInfo.video_info);
    }
    if (paramMsgTabNodeVideoInfo.recommand_id.has()) {
      this.f = paramMsgTabNodeVideoInfo.recommand_id.get();
    }
    if (paramMsgTabNodeVideoInfo.show_bottom.has()) {
      this.g = paramMsgTabNodeVideoInfo.show_bottom.get();
    }
    if (paramMsgTabNodeVideoInfo.bottom_wording.has()) {
      this.h = paramMsgTabNodeVideoInfo.bottom_wording.get();
    }
    if (paramMsgTabNodeVideoInfo.bottom_link.has()) {
      this.i = paramMsgTabNodeVideoInfo.bottom_link.get();
    }
    if (paramMsgTabNodeVideoInfo.show_text.has()) {
      this.j = paramMsgTabNodeVideoInfo.show_text.get();
    }
    if (paramMsgTabNodeVideoInfo.text_wording.has()) {
      this.k = paramMsgTabNodeVideoInfo.text_wording.get();
    }
    if (paramMsgTabNodeVideoInfo.text_link.has()) {
      this.l = paramMsgTabNodeVideoInfo.text_link.get();
    }
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getLong("videoIndex");
      this.b = paramJSONObject.getBoolean("didRead");
      this.c = paramJSONObject.optString("vid", "");
      this.d = paramJSONObject.optString("feedId", "");
      this.f = paramJSONObject.optLong("recommandId");
      this.g = paramJSONObject.optInt("showBottom");
      this.h = paramJSONObject.optString("bottomWording", "");
      this.i = paramJSONObject.optString("bottomLink", "");
      this.j = paramJSONObject.optInt("showText");
      this.k = paramJSONObject.optString("textWording", "");
      this.l = paramJSONObject.optString("textLink", "");
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    if (!TextUtils.isEmpty(this.c)) {
      this.e = ((StoryManager)SuperManager.a(5)).a(this.c);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MsgTabNodeVideoInfo)) {
      return false;
    }
    paramObject = (MsgTabNodeVideoInfo)paramObject;
    return this.a == paramObject.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabNodeVideoInfo{videoIndex=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", didRead=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", storyItem=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", recommandId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", showBottom=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", bottomWording=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", bottomLink=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", showText=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", textWording=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", textLink=");
    localStringBuilder.append(this.l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo
 * JD-Core Version:    0.7.0.1
 */