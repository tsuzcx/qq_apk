package com.tencent.biz.qqstory.msgTabNode.model;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVideoInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgTabNodeVideoInfo
{
  public long a;
  public boolean a;
  
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
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public void a(Parcel paramParcel)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
  
  public void a(qqstory_service.MsgTabNodeVideoInfo paramMsgTabNodeVideoInfo)
  {
    this.jdField_a_of_type_Long = paramMsgTabNodeVideoInfo.uint64_video_index.get();
    if (paramMsgTabNodeVideoInfo.uint32_did_read.get() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Long = paramJSONObject.getLong("videoIndex");
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("didRead");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void b(Parcel paramParcel)
  {
    boolean bool = true;
    this.jdField_a_of_type_Long = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
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
    return "MsgTabNodeVideoInfo{didRead=" + this.jdField_a_of_type_Boolean + ", videoIndex=" + this.jdField_a_of_type_Long + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo
 * JD-Core Version:    0.7.0.1
 */