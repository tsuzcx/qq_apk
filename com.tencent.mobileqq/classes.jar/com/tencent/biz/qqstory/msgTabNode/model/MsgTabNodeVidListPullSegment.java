package com.tencent.biz.qqstory.msgTabNode.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgTabNodeVidListPullSegment
  extends JobSegment<MsgTabNodeInfo, List<MsgTabVideoData>>
{
  public MsgTabPlayPageLoader.MsgTabGroupId a;
  public String a;
  public boolean a;
  public String b = "";
  public String c;
  
  public MsgTabNodeVidListPullSegment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.c = paramString;
  }
  
  public MsgTabNodeVidListPullSegment(String paramString1, String paramString2, String paramString3, MsgTabPlayPageLoader.MsgTabGroupId paramMsgTabGroupId)
  {
    this(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayPageLoader$MsgTabGroupId = paramMsgTabGroupId;
  }
  
  public static List<MsgTabVideoData> a(List<MsgTabNodeVideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramList.next();
      if ((!TextUtils.isEmpty(localMsgTabNodeVideoInfo.b)) && (!TextUtils.isEmpty(localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString)))
      {
        MsgTabVideoData localMsgTabVideoData = new MsgTabVideoData();
        localMsgTabVideoData.jdField_a_of_type_JavaLangString = localMsgTabNodeVideoInfo.b;
        localMsgTabVideoData.b = localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString;
        localMsgTabVideoData.jdField_a_of_type_Long = localMsgTabNodeVideoInfo.jdField_a_of_type_Long;
        localMsgTabVideoData.jdField_a_of_type_Boolean = localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean;
        localArrayList.add(localMsgTabVideoData);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo == null)
    {
      SLog.d("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      AssertUtils.fail("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    SLog.b("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.c, paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayPageLoader$MsgTabGroupId, Integer.valueOf(paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size()), paramMsgTabNodeInfo.k });
    if (TextUtils.isEmpty(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size() == 0) && (paramMsgTabNodeInfo.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramMsgTabNodeInfo });
      }
      if (paramMsgTabNodeInfo.jdField_a_of_type_Int == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((paramMsgTabNodeInfo.a()) && (paramMsgTabNodeInfo.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", paramMsgTabNodeInfo });
      }
      notifyResult(a(paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList));
      return;
    }
    paramJobContext = null;
    if (paramMsgTabNodeInfo.jdField_a_of_type_Int != 12) {
      paramJobContext = MsgTabStoryManager.a(paramMsgTabNodeInfo);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get succeed from db, info=");
        localStringBuilder.append(paramMsgTabNodeInfo);
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, localStringBuilder.toString());
      }
      SLog.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = MsgTabNodeVidListRequest.a(paramMsgTabNodeInfo, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = a(paramJobContext.a.jdField_a_of_type_JavaUtilList);
        notifyResult(paramJobContext);
        SLog.a("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      SLog.b("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    paramJobContext = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayPageLoader$MsgTabGroupId;
    if ((paramJobContext != null) && (paramJobContext.jdField_a_of_type_Boolean))
    {
      SLog.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    SLog.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new MsgTabNodeVidListRequest(paramMsgTabNodeInfo, this.jdField_a_of_type_JavaLangString, this.b);
    SLog.a("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((paramMsgTabNodeInfo.jdField_a_of_type_Int == 12) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      SLog.b("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.clear();
    }
    CmdTaskManger.a().a(paramJobContext, new MsgTabNodeVidListPullSegment.1(this, paramMsgTabNodeInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment
 * JD-Core Version:    0.7.0.1
 */