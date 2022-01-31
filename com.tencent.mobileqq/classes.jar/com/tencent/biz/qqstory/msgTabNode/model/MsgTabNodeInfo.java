package com.tencent.biz.qqstory.msgTabNode.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgTabNodeInfo
  implements Copyable
{
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
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public String f;
  public String g = "";
  
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
  
  public MsgTabHaloEntity a()
  {
    MsgTabHaloEntity localMsgTabHaloEntity = new MsgTabHaloEntity();
    localMsgTabHaloEntity.nodeType = this.jdField_a_of_type_Int;
    localMsgTabHaloEntity.uid = this.jdField_b_of_type_Long;
    localMsgTabHaloEntity.unionId = this.jdField_a_of_type_JavaLangString;
    localMsgTabHaloEntity.nodeVid = this.jdField_e_of_type_JavaLangString;
    localMsgTabHaloEntity.title = this.jdField_c_of_type_JavaLangString;
    localMsgTabHaloEntity.headUrl = this.jdField_b_of_type_JavaLangString;
    localMsgTabHaloEntity.recommendId = this.jdField_e_of_type_Long;
    localMsgTabHaloEntity.jumpUrl = this.jdField_d_of_type_JavaLangString;
    localMsgTabHaloEntity.nodeVid = this.jdField_e_of_type_JavaLangString;
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((MsgTabNodeVideoInfo)localIterator.next()).a());
    }
    localMsgTabHaloEntity.videoInfoList = localJSONArray.toString();
    localMsgTabHaloEntity.reqTimeStamp = this.jdField_c_of_type_Long;
    localMsgTabHaloEntity.nodeInfoTimeStamp = this.jdField_d_of_type_Long;
    localMsgTabHaloEntity.videoCover = this.f;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localJSONArray = new JSONArray();
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((MsgTabVideoData)localIterator.next()).a());
      }
      localMsgTabHaloEntity.localSuccessVideoList = localJSONArray.toString();
    }
    localMsgTabHaloEntity.noUpdate = this.jdField_d_of_type_Int;
    return localMsgTabHaloEntity;
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
    localMsgTabNodeEntity.videoCover = this.f;
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
  
  public void a(MsgTabHaloEntity paramMsgTabHaloEntity)
  {
    int j = 0;
    this.jdField_a_of_type_Int = paramMsgTabHaloEntity.nodeType;
    this.jdField_b_of_type_Long = paramMsgTabHaloEntity.uid;
    this.jdField_a_of_type_JavaLangString = paramMsgTabHaloEntity.unionId;
    this.jdField_c_of_type_JavaLangString = paramMsgTabHaloEntity.title;
    this.jdField_b_of_type_JavaLangString = paramMsgTabHaloEntity.headUrl;
    this.jdField_e_of_type_Long = paramMsgTabHaloEntity.recommendId;
    this.jdField_d_of_type_JavaLangString = paramMsgTabHaloEntity.jumpUrl;
    this.jdField_e_of_type_JavaLangString = paramMsgTabHaloEntity.nodeVid;
    this.f = paramMsgTabHaloEntity.videoCover;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramMsgTabHaloEntity.videoInfoList);
      int k = localJSONArray1.length();
      i = 0;
      JSONObject localJSONObject;
      Object localObject;
      while (i < k)
      {
        localJSONObject = localJSONArray1.getJSONObject(i);
        localObject = new MsgTabNodeVideoInfo();
        ((MsgTabNodeVideoInfo)localObject).a(localJSONObject);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        if (!((MsgTabNodeVideoInfo)localObject).jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_Int += 1;
        }
        i += 1;
      }
      JSONArray localJSONArray2;
      if (this.jdField_a_of_type_Int == 11) {
        break label339;
      }
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
      this.jdField_c_of_type_Long = paramMsgTabHaloEntity.reqTimeStamp;
      this.jdField_d_of_type_Long = paramMsgTabHaloEntity.nodeInfoTimeStamp;
      if ((!TextUtils.isEmpty(paramMsgTabHaloEntity.localSuccessVideoList)) && (!paramMsgTabHaloEntity.localSuccessVideoList.equals("null"))) {
        try
        {
          localJSONArray2 = new JSONArray(paramMsgTabHaloEntity.localSuccessVideoList);
          this.jdField_b_of_type_JavaUtilList = new ArrayList();
          k = localJSONArray2.length();
          i = 0;
          while (i < k)
          {
            localJSONObject = localJSONArray2.getJSONObject(i);
            localObject = new MsgTabVideoData();
            ((MsgTabVideoData)localObject).a(localJSONObject);
            this.jdField_b_of_type_JavaUtilList.add(localObject);
            i += 1;
          }
          if (this.jdField_a_of_type_Int == 10) {
            break label339;
          }
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    if (this.jdField_a_of_type_Int == 3) {
      label339:
      if (!MsgTabStoryManager.b(this)) {
        break label367;
      }
    }
    label367:
    for (int i = j;; i = 1)
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_d_of_type_Int = paramMsgTabHaloEntity.noUpdate;
      this.jdField_e_of_type_Int = 1;
      return;
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
    this.f = paramMsgTabNodeEntity.videoCover;
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
        break label344;
      }
    }
    catch (JSONException localJSONException)
    {
      SLog.c("Q.qqstory.msgTab.nodeList.MsgTabNodeInfo", "convertFrom(entity) errors", localJSONException);
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
      label344:
      return;
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.jdField_c_of_type_Int = paramMsgTabNodeInfo.jdField_c_of_type_Int;
    this.jdField_b_of_type_Boolean = paramMsgTabNodeInfo.jdField_b_of_type_Boolean;
    this.g = paramMsgTabNodeInfo.g;
  }
  
  public void a(qqstory_service.MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.jdField_a_of_type_Int = paramMsgTabNodeInfo.uint32_node_type.get();
    this.jdField_b_of_type_Long = paramMsgTabNodeInfo.uint64_uid.get();
    this.jdField_a_of_type_JavaLangString = paramMsgTabNodeInfo.bytes_union_id.get().toStringUtf8();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramMsgTabNodeInfo.rpt_msg_video_info_list.size());
    this.jdField_b_of_type_Int = 0;
    ArrayDeque localArrayDeque = new ArrayDeque(3);
    Iterator localIterator = paramMsgTabNodeInfo.rpt_msg_video_info_list.get().iterator();
    while (localIterator.hasNext())
    {
      qqstory_service.MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (qqstory_service.MsgTabNodeVideoInfo)localIterator.next();
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo1 = new MsgTabNodeVideoInfo();
      localMsgTabNodeVideoInfo1.a(localMsgTabNodeVideoInfo, localArrayDeque);
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
    if (paramMsgTabNodeInfo.video_cover.has()) {
      this.f = paramMsgTabNodeInfo.video_cover.get().toStringUtf8();
    }
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11)) {
      if (!MsgTabStoryManager.b(this)) {
        break label351;
      }
    }
    label351:
    for (int i = 0;; i = 1)
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_d_of_type_Int = paramMsgTabNodeInfo.no_update.get();
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
      this.g = paramObject.g;
      this.jdField_d_of_type_Int = paramObject.jdField_d_of_type_Int;
    }
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
    return "MsgTabNodeInfo{nodeType=" + this.jdField_a_of_type_Int + ", uid=" + this.jdField_b_of_type_Long + ", unionId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", unreadCount=" + this.jdField_b_of_type_Int + ", videoInfoList.size=" + this.jdField_a_of_type_JavaUtilList.size() + ", uploadingCover=" + this.g + ", nodeInfoTimeStamp=" + this.jdField_d_of_type_Long + ", unUploadVideoCount=" + this.jdField_c_of_type_Int + ", isUploading=" + this.jdField_b_of_type_Boolean + ", reqTimeStamp=" + this.jdField_c_of_type_Long + ", id=" + this.jdField_a_of_type_Long + ", recommendId=" + this.jdField_e_of_type_Long + ", headerUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", title='" + this.jdField_c_of_type_JavaLangString + '\'' + ", jumpUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", nodeVid='" + this.jdField_e_of_type_JavaLangString + '\'' + ", videoCover='" + this.f + '\'' + ", videoInfoList=" + this.jdField_a_of_type_JavaUtilList.toString() + '\'' + ", noUpdate=" + this.jdField_d_of_type_Int + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo
 * JD-Core Version:    0.7.0.1
 */