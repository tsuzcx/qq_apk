package com.tencent.biz.qqstory.msgTabNode.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.database.MsgTabNodeEntity;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
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
  public String A;
  public boolean B;
  public int C;
  public boolean D = true;
  public long a;
  public int b;
  public long c;
  public String d;
  public List<MsgTabNodeVideoInfo> e = new ArrayList();
  public boolean f = false;
  public long g;
  public long h;
  public int i = 0;
  public long j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public int q = 0;
  public int r = 0;
  public boolean s = false;
  public String t = "";
  public List<MsgTabVideoData> u;
  public int v;
  public int w = 0;
  public String x = "";
  public String y;
  public long z;
  
  public MsgTabNodeInfo() {}
  
  public MsgTabNodeInfo(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.d = paramString;
  }
  
  public long a(String paramString)
  {
    Object localObject;
    try
    {
      Object[] arrayOfObject = this.e.toArray();
    }
    catch (Exception localException)
    {
      SLog.c("Q.qqstory.msgTab.nodeList.MsgTabNodeInfo", "getRecommendIdByVid:%s", localException);
      localObject = null;
    }
    if (localObject != null)
    {
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)localObject[i1];
        if (TextUtils.equals(paramString, localMsgTabNodeVideoInfo.c)) {
          return localMsgTabNodeVideoInfo.f;
        }
        i1 += 1;
      }
    }
    return 0L;
  }
  
  public MsgTabNodeEntity a()
  {
    MsgTabNodeEntity localMsgTabNodeEntity = new MsgTabNodeEntity();
    localMsgTabNodeEntity.nodeType = this.b;
    localMsgTabNodeEntity.uid = this.c;
    localMsgTabNodeEntity.unionId = this.d;
    localMsgTabNodeEntity.nodeVid = this.n;
    localMsgTabNodeEntity.nodeFeedId = this.o;
    localMsgTabNodeEntity.title = this.l;
    localMsgTabNodeEntity.headUrl = this.k;
    localMsgTabNodeEntity.recommendId = this.j;
    localMsgTabNodeEntity.jumpUrl = this.m;
    localMsgTabNodeEntity.nodePosition = this.q;
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((MsgTabNodeVideoInfo)localIterator.next()).a());
    }
    localMsgTabNodeEntity.videoInfoList = localJSONArray.toString();
    localMsgTabNodeEntity.reqTimeStamp = this.g;
    localMsgTabNodeEntity.nodeInfoTimeStamp = this.h;
    localMsgTabNodeEntity.videoCover = this.p;
    if (this.u != null)
    {
      localJSONArray = new JSONArray();
      localIterator = this.u.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((MsgTabVideoData)localIterator.next()).a());
      }
      localMsgTabNodeEntity.localSuccessVideoList = localJSONArray.toString();
    }
    localMsgTabNodeEntity.recommandNameIconUrl = this.y;
    localMsgTabNodeEntity.cacheSeq = this.z;
    localMsgTabNodeEntity.passthrough = this.A;
    localMsgTabNodeEntity.redPoint = this.B;
    return localMsgTabNodeEntity;
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    this.b = paramMsgTabNodeEntity.nodeType;
    this.c = paramMsgTabNodeEntity.uid;
    this.d = paramMsgTabNodeEntity.unionId;
    this.l = paramMsgTabNodeEntity.title;
    this.k = paramMsgTabNodeEntity.headUrl;
    this.j = paramMsgTabNodeEntity.recommendId;
    this.m = paramMsgTabNodeEntity.jumpUrl;
    this.n = paramMsgTabNodeEntity.nodeVid;
    this.o = paramMsgTabNodeEntity.nodeFeedId;
    this.p = paramMsgTabNodeEntity.videoCover;
    this.q = paramMsgTabNodeEntity.nodePosition;
    this.e = new ArrayList();
    int i2 = 0;
    this.i = 0;
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramMsgTabNodeEntity.videoInfoList);
      int i3 = localJSONArray1.length();
      int i1 = 0;
      JSONObject localJSONObject;
      Object localObject;
      while (i1 < i3)
      {
        localJSONObject = localJSONArray1.getJSONObject(i1);
        localObject = new MsgTabNodeVideoInfo();
        ((MsgTabNodeVideoInfo)localObject).a(localJSONObject);
        this.e.add(localObject);
        if (!((MsgTabNodeVideoInfo)localObject).b) {
          this.i += 1;
        }
        i1 += 1;
      }
      JSONArray localJSONArray2;
      return;
    }
    catch (JSONException localJSONException1)
    {
      SLog.c("Q.qqstory.msgTab.nodeList.MsgTabNodeInfo", "convertFrom(entity) errors", localJSONException1);
      this.g = paramMsgTabNodeEntity.reqTimeStamp;
      this.h = paramMsgTabNodeEntity.nodeInfoTimeStamp;
      if ((!TextUtils.isEmpty(paramMsgTabNodeEntity.localSuccessVideoList)) && (!paramMsgTabNodeEntity.localSuccessVideoList.equals("null"))) {
        try
        {
          localJSONArray2 = new JSONArray(paramMsgTabNodeEntity.localSuccessVideoList);
          this.u = new ArrayList();
          i3 = localJSONArray2.length();
          i1 = i2;
          while (i1 < i3)
          {
            localJSONObject = localJSONArray2.getJSONObject(i1);
            localObject = new MsgTabVideoData();
            ((MsgTabVideoData)localObject).a(localJSONObject);
            this.u.add(localObject);
            i1 += 1;
          }
          i1 = this.b;
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
      if ((i1 == 10) || (i1 == 11) || (i1 == 3)) {
        this.i = (MsgTabStoryManager.f(this) ^ true);
      }
      this.y = paramMsgTabNodeEntity.recommandNameIconUrl;
      this.z = paramMsgTabNodeEntity.cacheSeq;
      this.A = paramMsgTabNodeEntity.passthrough;
      this.B = paramMsgTabNodeEntity.redPoint;
      this.C = paramMsgTabNodeEntity.videoCoverType;
      this.D = paramMsgTabNodeEntity.firstExp;
    }
  }
  
  public void a(MsgTabHaloEntity paramMsgTabHaloEntity)
  {
    this.b = paramMsgTabHaloEntity.nodeType;
    this.c = paramMsgTabHaloEntity.uid;
    this.d = paramMsgTabHaloEntity.unionId;
    this.l = paramMsgTabHaloEntity.title;
    this.k = paramMsgTabHaloEntity.headUrl;
    this.j = paramMsgTabHaloEntity.recommendId;
    this.m = paramMsgTabHaloEntity.jumpUrl;
    this.n = paramMsgTabHaloEntity.nodeVid;
    this.p = paramMsgTabHaloEntity.videoCover;
    this.e = new ArrayList();
    int i2 = 0;
    this.i = 0;
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramMsgTabHaloEntity.videoInfoList);
      int i3 = localJSONArray1.length();
      int i1 = 0;
      JSONObject localJSONObject;
      Object localObject;
      while (i1 < i3)
      {
        localJSONObject = localJSONArray1.getJSONObject(i1);
        localObject = new MsgTabNodeVideoInfo();
        ((MsgTabNodeVideoInfo)localObject).a(localJSONObject);
        this.e.add(localObject);
        if (!((MsgTabNodeVideoInfo)localObject).b) {
          this.i += 1;
        }
        i1 += 1;
      }
      JSONArray localJSONArray2;
      return;
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
      this.g = paramMsgTabHaloEntity.reqTimeStamp;
      this.h = paramMsgTabHaloEntity.nodeInfoTimeStamp;
      if ((!TextUtils.isEmpty(paramMsgTabHaloEntity.localSuccessVideoList)) && (!paramMsgTabHaloEntity.localSuccessVideoList.equals("null"))) {
        try
        {
          localJSONArray2 = new JSONArray(paramMsgTabHaloEntity.localSuccessVideoList);
          this.u = new ArrayList();
          i3 = localJSONArray2.length();
          i1 = i2;
          while (i1 < i3)
          {
            localJSONObject = localJSONArray2.getJSONObject(i1);
            localObject = new MsgTabVideoData();
            ((MsgTabVideoData)localObject).a(localJSONObject);
            this.u.add(localObject);
            i1 += 1;
          }
          i1 = this.b;
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
      if ((i1 == 10) || (i1 == 11) || (i1 == 3)) {
        this.i = (MsgTabStoryManager.f(this) ^ true);
      }
      this.v = paramMsgTabHaloEntity.noUpdate;
      this.w = 1;
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.r = paramMsgTabNodeInfo.r;
    this.s = paramMsgTabNodeInfo.s;
    this.t = paramMsgTabNodeInfo.t;
  }
  
  public void a(qqstory_service.MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.b = paramMsgTabNodeInfo.uint32_node_type.get();
    this.c = paramMsgTabNodeInfo.uint64_uid.get();
    this.d = paramMsgTabNodeInfo.bytes_union_id.get().toStringUtf8();
    this.e = new ArrayList(paramMsgTabNodeInfo.rpt_msg_video_info_list.size());
    this.i = 0;
    ArrayDeque localArrayDeque = new ArrayDeque(3);
    Iterator localIterator = paramMsgTabNodeInfo.rpt_msg_video_info_list.get().iterator();
    while (localIterator.hasNext())
    {
      qqstory_service.MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (qqstory_service.MsgTabNodeVideoInfo)localIterator.next();
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo1 = new MsgTabNodeVideoInfo();
      localMsgTabNodeVideoInfo1.a(localMsgTabNodeVideoInfo, localArrayDeque);
      this.e.add(localMsgTabNodeVideoInfo1);
      if (!localMsgTabNodeVideoInfo1.b) {
        this.i += 1;
      }
    }
    this.g = paramMsgTabNodeInfo.uint64_req_time_stamp.get();
    this.h = paramMsgTabNodeInfo.uint64_node_info_time_stamp.get();
    this.j = paramMsgTabNodeInfo.recommend_id.get();
    if (paramMsgTabNodeInfo.bytes_title.has()) {
      this.l = paramMsgTabNodeInfo.bytes_title.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.bytes_icon_url.has()) {
      this.k = paramMsgTabNodeInfo.bytes_icon_url.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.link_url.has()) {
      this.m = paramMsgTabNodeInfo.link_url.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.node_vid.has()) {
      this.n = paramMsgTabNodeInfo.node_vid.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.video_cover.has()) {
      this.p = paramMsgTabNodeInfo.video_cover.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.node_position.has()) {
      this.q = paramMsgTabNodeInfo.node_position.get();
    }
    int i1 = this.b;
    if ((i1 == 10) || (i1 == 11) || (i1 == 3)) {
      this.i = (MsgTabStoryManager.f(this) ^ true);
    }
    if ((this.b == 12) && (paramMsgTabNodeInfo.rpt_msg_video_info_list.size() > 0))
    {
      this.n = ((qqstory_service.MsgTabNodeVideoInfo)paramMsgTabNodeInfo.rpt_msg_video_info_list.get(0)).vid.get().toStringUtf8();
      this.o = ((qqstory_service.MsgTabNodeVideoInfo)paramMsgTabNodeInfo.rpt_msg_video_info_list.get(0)).feed_id.get().toStringUtf8();
    }
    this.v = paramMsgTabNodeInfo.no_update.get();
    if (paramMsgTabNodeInfo.recommend_name_icon.has()) {
      this.y = paramMsgTabNodeInfo.recommend_name_icon.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.uint64_cache_seq.has()) {
      this.z = paramMsgTabNodeInfo.uint64_cache_seq.get();
    }
    if (paramMsgTabNodeInfo.passthrough.has()) {
      this.A = paramMsgTabNodeInfo.passthrough.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.redpoint.has())
    {
      this.B = paramMsgTabNodeInfo.redpoint.get();
      SLog.a("Q.qqstory.msgTab.nodeList.MsgTabNodeInfo", "MsgTabNodeInfo convertFrom, unionId:%s, uid:%s, redPoint:%s", this.d, Long.valueOf(this.c), Boolean.valueOf(this.B));
    }
    if (paramMsgTabNodeInfo.video_cover_type.has()) {
      this.C = paramMsgTabNodeInfo.video_cover_type.get();
    }
    if (this.b == 13) {
      MsgTabStoryManager.a(QQStoryContext.j()).e(this);
    }
  }
  
  public MsgTabHaloEntity b()
  {
    MsgTabHaloEntity localMsgTabHaloEntity = new MsgTabHaloEntity();
    localMsgTabHaloEntity.nodeType = this.b;
    localMsgTabHaloEntity.uid = this.c;
    localMsgTabHaloEntity.unionId = this.d;
    localMsgTabHaloEntity.nodeVid = this.n;
    localMsgTabHaloEntity.title = this.l;
    localMsgTabHaloEntity.headUrl = this.k;
    localMsgTabHaloEntity.recommendId = this.j;
    localMsgTabHaloEntity.jumpUrl = this.m;
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((MsgTabNodeVideoInfo)localIterator.next()).a());
    }
    localMsgTabHaloEntity.videoInfoList = localJSONArray.toString();
    localMsgTabHaloEntity.reqTimeStamp = this.g;
    localMsgTabHaloEntity.nodeInfoTimeStamp = this.h;
    localMsgTabHaloEntity.videoCover = this.p;
    if (this.u != null)
    {
      localJSONArray = new JSONArray();
      localIterator = this.u.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((MsgTabVideoData)localIterator.next()).a());
      }
      localMsgTabHaloEntity.localSuccessVideoList = localJSONArray.toString();
    }
    localMsgTabHaloEntity.noUpdate = this.v;
    return localMsgTabHaloEntity;
  }
  
  public int c()
  {
    if (this.s) {
      return 1;
    }
    if (this.r > 0) {
      return 2;
    }
    return 0;
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof MsgTabNodeInfo))
    {
      paramObject = (MsgTabNodeInfo)paramObject;
      this.b = paramObject.b;
      this.c = paramObject.c;
      this.d = paramObject.d;
      this.e = new ArrayList(paramObject.e);
      this.f = paramObject.f;
      this.g = paramObject.g;
      this.h = paramObject.h;
      this.i = paramObject.i;
      this.j = paramObject.j;
      this.k = paramObject.k;
      this.l = paramObject.l;
      this.m = paramObject.m;
      this.n = paramObject.n;
      this.o = paramObject.o;
      this.r = paramObject.r;
      this.s = paramObject.s;
      this.u = paramObject.u;
      this.t = paramObject.t;
      this.q = paramObject.q;
      this.v = paramObject.v;
      this.x = paramObject.x;
      this.y = paramObject.y;
      this.z = paramObject.z;
      this.A = paramObject.A;
      this.B = paramObject.B;
      this.C = paramObject.C;
      this.D = paramObject.D;
    }
  }
  
  public boolean d()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)localIterator.next();
      if ((TextUtils.isEmpty(localMsgTabNodeVideoInfo.c)) || (TextUtils.isEmpty(localMsgTabNodeVideoInfo.d))) {
        return false;
      }
    }
    return this.e.isEmpty() ^ true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MsgTabNodeInfo)) {
      return false;
    }
    paramObject = (MsgTabNodeInfo)paramObject;
    if (this.b != paramObject.b) {
      return false;
    }
    String str = this.d;
    if (str != null) {
      return str.equals(paramObject.d);
    }
    return paramObject.d == null;
  }
  
  public int hashCode()
  {
    int i2 = this.b;
    String str = this.d;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    return (629 + i2) * 37 + i1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabNodeInfo{nodeType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", unreadCount=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", nodePosition=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", videoInfoList.size=");
    localStringBuilder.append(this.e.size());
    localStringBuilder.append(", nodeVid='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nodeFeedId='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reqTimeStamp=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", nodeInfoTimeStamp=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", unUploadVideoCount=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", noUpdate=");
    localStringBuilder.append(this.v);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recommendId=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", isUploading=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", headerUrl='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoCover='");
    localStringBuilder.append(this.p);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadingCover=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", recommandNameIconUrl=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", cacheSeq='");
    localStringBuilder.append(this.z);
    localStringBuilder.append('\'');
    localStringBuilder.append(", passthrough=");
    localStringBuilder.append(this.A);
    localStringBuilder.append(", redPoint=");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", videoCoverType=");
    localStringBuilder.append(this.C);
    localStringBuilder.append(", firstExp=");
    localStringBuilder.append(this.D);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo
 * JD-Core Version:    0.7.0.1
 */