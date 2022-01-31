package com.tencent.biz.qqstory.msgTabNode.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ncp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgTabNodeInfo
  implements Parcelable, Copyable
{
  public static final Parcelable.Creator CREATOR = new ncp();
  public int a;
  public long a;
  public String a;
  public List a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public List b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  
  public MsgTabNodeInfo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public MsgTabNodeInfo(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public MsgTabNodeInfo(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return 1;
    }
    if (this.jdField_c_of_type_Int > 0) {
      return 2;
    }
    return 0;
  }
  
  public MsgTabNodeEntity a()
  {
    MsgTabNodeEntity localMsgTabNodeEntity = new MsgTabNodeEntity();
    localMsgTabNodeEntity.nodeType = this.jdField_a_of_type_Int;
    localMsgTabNodeEntity.uid = this.jdField_b_of_type_Long;
    localMsgTabNodeEntity.unionId = this.jdField_a_of_type_JavaLangString;
    localMsgTabNodeEntity.nodeVid = this.jdField_e_of_type_JavaLangString;
    localMsgTabNodeEntity.title = this.jdField_c_of_type_JavaLangString;
    localMsgTabNodeEntity.headUrl = this.jdField_b_of_type_JavaLangString;
    localMsgTabNodeEntity.recommendId = this.jdField_e_of_type_Long;
    localMsgTabNodeEntity.jumpUrl = this.jdField_d_of_type_JavaLangString;
    localMsgTabNodeEntity.nodeVid = this.jdField_e_of_type_JavaLangString;
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((MsgTabNodeVideoInfo)localIterator.next()).a());
    }
    localMsgTabNodeEntity.videoInfoList = localJSONArray.toString();
    localMsgTabNodeEntity.reqTimeStamp = this.jdField_c_of_type_Long;
    localMsgTabNodeEntity.nodeInfoTimeStamp = this.jdField_d_of_type_Long;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localJSONArray = new JSONArray();
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((MsgTabVideoData)localIterator.next()).a());
      }
      localMsgTabNodeEntity.localSuccessVideoList = localJSONArray.toString();
    }
    return localMsgTabNodeEntity;
  }
  
  public String a()
  {
    return toString() + "\n videoInfoList=" + this.jdField_a_of_type_JavaUtilList.toString();
  }
  
  public void a(Parcel paramParcel)
  {
    boolean bool = true;
    int i = 0;
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_Long = paramParcel.readLong();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      int j = paramParcel.readInt();
      while (i < j)
      {
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = new MsgTabNodeVideoInfo();
        localMsgTabNodeVideoInfo.b(paramParcel);
        this.jdField_a_of_type_JavaUtilList.add(localMsgTabNodeVideoInfo);
        i += 1;
      }
      bool = false;
    }
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    int j = 0;
    this.jdField_a_of_type_Int = paramMsgTabNodeEntity.nodeType;
    this.jdField_b_of_type_Long = paramMsgTabNodeEntity.uid;
    this.jdField_a_of_type_JavaLangString = paramMsgTabNodeEntity.unionId;
    this.jdField_c_of_type_JavaLangString = paramMsgTabNodeEntity.title;
    this.jdField_b_of_type_JavaLangString = paramMsgTabNodeEntity.headUrl;
    this.jdField_e_of_type_Long = paramMsgTabNodeEntity.recommendId;
    this.jdField_d_of_type_JavaLangString = paramMsgTabNodeEntity.jumpUrl;
    this.jdField_e_of_type_JavaLangString = paramMsgTabNodeEntity.nodeVid;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    try
    {
      JSONArray localJSONArray = new JSONArray(paramMsgTabNodeEntity.videoInfoList);
      int k = localJSONArray.length();
      i = 0;
      Object localObject;
      while (i < k)
      {
        localObject = localJSONArray.getJSONObject(i);
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = new MsgTabNodeVideoInfo();
        localMsgTabNodeVideoInfo.a((JSONObject)localObject);
        this.jdField_a_of_type_JavaUtilList.add(localMsgTabNodeVideoInfo);
        if (!localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_Int += 1;
        }
        i += 1;
      }
      JSONObject localJSONObject;
      if (this.jdField_a_of_type_Int != 11) {
        break label332;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      this.jdField_c_of_type_Long = paramMsgTabNodeEntity.reqTimeStamp;
      this.jdField_d_of_type_Long = paramMsgTabNodeEntity.nodeInfoTimeStamp;
      if ((!TextUtils.isEmpty(paramMsgTabNodeEntity.localSuccessVideoList)) && (!paramMsgTabNodeEntity.localSuccessVideoList.equals("null"))) {
        try
        {
          paramMsgTabNodeEntity = new JSONArray(paramMsgTabNodeEntity.localSuccessVideoList);
          this.jdField_b_of_type_JavaUtilList = new ArrayList();
          k = paramMsgTabNodeEntity.length();
          i = 0;
          while (i < k)
          {
            localJSONObject = paramMsgTabNodeEntity.getJSONObject(i);
            localObject = new MsgTabVideoData();
            ((MsgTabVideoData)localObject).a(localJSONObject);
            this.jdField_b_of_type_JavaUtilList.add(localObject);
            i += 1;
          }
          if (this.jdField_a_of_type_Int == 10) {}
        }
        catch (JSONException paramMsgTabNodeEntity)
        {
          paramMsgTabNodeEntity.printStackTrace();
        }
      }
    }
    if (MsgTabStoryManager.b(this)) {}
    for (int i = j;; i = 1)
    {
      this.jdField_b_of_type_Int = i;
      label332:
      return;
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.jdField_c_of_type_Int = paramMsgTabNodeInfo.jdField_c_of_type_Int;
    this.jdField_b_of_type_Boolean = paramMsgTabNodeInfo.jdField_b_of_type_Boolean;
  }
  
  public void a(qqstory_service.MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.jdField_a_of_type_Int = paramMsgTabNodeInfo.uint32_node_type.get();
    this.jdField_b_of_type_Long = paramMsgTabNodeInfo.uint64_uid.get();
    this.jdField_a_of_type_JavaLangString = paramMsgTabNodeInfo.bytes_union_id.get().toStringUtf8();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramMsgTabNodeInfo.rpt_msg_video_info_list.size());
    this.jdField_b_of_type_Int = 0;
    Iterator localIterator = paramMsgTabNodeInfo.rpt_msg_video_info_list.get().iterator();
    while (localIterator.hasNext())
    {
      qqstory_service.MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (qqstory_service.MsgTabNodeVideoInfo)localIterator.next();
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo1 = new MsgTabNodeVideoInfo();
      localMsgTabNodeVideoInfo1.a(localMsgTabNodeVideoInfo);
      this.jdField_a_of_type_JavaUtilList.add(localMsgTabNodeVideoInfo1);
      if (!localMsgTabNodeVideoInfo1.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Int += 1;
      }
    }
    this.jdField_c_of_type_Long = paramMsgTabNodeInfo.uint64_req_time_stamp.get();
    this.jdField_d_of_type_Long = paramMsgTabNodeInfo.uint64_node_info_time_stamp.get();
    this.jdField_e_of_type_Long = paramMsgTabNodeInfo.recommend_id.get();
    if (paramMsgTabNodeInfo.bytes_title.has()) {
      this.jdField_c_of_type_JavaLangString = paramMsgTabNodeInfo.bytes_title.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.bytes_icon_url.has()) {
      this.jdField_b_of_type_JavaLangString = paramMsgTabNodeInfo.bytes_icon_url.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.link_url.has()) {
      this.jdField_d_of_type_JavaLangString = paramMsgTabNodeInfo.link_url.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.node_vid.has()) {
      this.jdField_e_of_type_JavaLangString = paramMsgTabNodeInfo.node_vid.get().toStringUtf8();
    }
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11)) {
      if (!MsgTabStoryManager.b(this)) {
        break label303;
      }
    }
    label303:
    for (int i = 0;; i = 1)
    {
      this.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof MsgTabNodeInfo))
    {
      paramObject = (MsgTabNodeInfo)paramObject;
      this.jdField_a_of_type_Int = paramObject.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramObject.jdField_b_of_type_Long;
      this.jdField_a_of_type_JavaLangString = paramObject.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramObject.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Boolean = paramObject.jdField_a_of_type_Boolean;
      this.jdField_c_of_type_Long = paramObject.jdField_c_of_type_Long;
      this.jdField_d_of_type_Long = paramObject.jdField_d_of_type_Long;
      this.jdField_b_of_type_Int = paramObject.jdField_b_of_type_Int;
      this.jdField_e_of_type_Long = paramObject.jdField_e_of_type_Long;
      this.jdField_b_of_type_JavaLangString = paramObject.jdField_b_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramObject.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = paramObject.jdField_d_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = paramObject.jdField_e_of_type_JavaLangString;
      this.jdField_c_of_type_Int = paramObject.jdField_c_of_type_Int;
      this.jdField_b_of_type_Boolean = paramObject.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_JavaUtilList = paramObject.jdField_b_of_type_JavaUtilList;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof MsgTabNodeInfo)) {
        return false;
      }
      paramObject = (MsgTabNodeInfo)paramObject;
      if (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) {
        return false;
      }
      if (this.jdField_a_of_type_JavaLangString != null) {
        return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
      }
    } while (paramObject.jdField_a_of_type_JavaLangString == null);
    return false;
  }
  
  public int hashCode()
  {
    int j = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (int i = this.jdField_a_of_type_JavaLangString.hashCode();; i = 0) {
      return i + j * 31;
    }
  }
  
  public String toString()
  {
    return "MsgTabNodeInfo{nodeType=" + this.jdField_a_of_type_Int + ", uid=" + this.jdField_b_of_type_Long + ", unionId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", unreadCount=" + this.jdField_b_of_type_Int + ", videoInfoList.size=" + this.jdField_a_of_type_JavaUtilList.size() + ", nodeInfoTimeStamp=" + this.jdField_d_of_type_Long + ", unUploadVideoCount=" + this.jdField_c_of_type_Int + ", isUploading=" + this.jdField_b_of_type_Boolean + ", reqTimeStamp=" + this.jdField_c_of_type_Long + ", id=" + this.jdField_a_of_type_Long + ", recommendId=" + this.jdField_e_of_type_Long + ", headerUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", title='" + this.jdField_c_of_type_JavaLangString + '\'' + ", jumpUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", nodeVid='" + this.jdField_e_of_type_JavaLangString + '\'' + ", videoInfoList=" + this.jdField_a_of_type_JavaUtilList.toString() + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_a_of_type_JavaUtilList.size());
      paramInt = i;
      while (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((MsgTabNodeVideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(paramParcel);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo
 * JD-Core Version:    0.7.0.1
 */