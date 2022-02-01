package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVidInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MsgTabNodeVidListRequest$MsgTabNodeVidListResponse
  extends BaseResponse
{
  public MsgTabNodeInfo a;
  public qqstory_service.RspMsgTabNodeVideoList a;
  public List<MsgTabNodeVideoInfo> a;
  public byte[] a;
  
  public MsgTabNodeVidListRequest$MsgTabNodeVidListResponse(MsgTabNodeInfo paramMsgTabNodeInfo, qqstory_service.RspMsgTabNodeVideoList paramRspMsgTabNodeVideoList, byte[] paramArrayOfByte)
  {
    super(paramRspMsgTabNodeVideoList.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = paramMsgTabNodeInfo;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    if (paramRspMsgTabNodeVideoList.video_list != null)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int i;
      Object localObject4;
      if (paramMsgTabNodeInfo.jdField_a_of_type_Int == 12)
      {
        SLog.a("Q.qqstory:ReqMsgTabNodeVideoList", "new video list receive cookie:%s nodeInfo old size=%d, rsp.video_list size=%d", paramRspMsgTabNodeVideoList.cookie.get(), Integer.valueOf(paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramRspMsgTabNodeVideoList.video_list.size()));
        paramArrayOfByte = new HashSet();
        paramRspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList.video_list.get().iterator();
        while (paramRspMsgTabNodeVideoList.hasNext())
        {
          localObject1 = (qqstory_service.MsgTabNodeVidInfo)paramRspMsgTabNodeVideoList.next();
          localObject2 = ((qqstory_service.MsgTabNodeVidInfo)localObject1).feed_id.get().toStringUtf8();
          localObject3 = ((qqstory_service.MsgTabNodeVidInfo)localObject1).video_index_list.get().iterator();
          i = 0;
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Long)((Iterator)localObject3).next();
            MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = MsgTabNodeVideoInfo.a(paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList, ((Long)localObject4).longValue());
            if ((localMsgTabNodeVideoInfo != null) && (!paramArrayOfByte.contains(localObject4)))
            {
              localMsgTabNodeVideoInfo.jdField_b_of_type_JavaLangString = ((String)localObject2);
              localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
              if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
                localMsgTabNodeVideoInfo.jdField_b_of_type_Long = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
              }
            }
            else
            {
              localMsgTabNodeVideoInfo = new MsgTabNodeVideoInfo();
              localMsgTabNodeVideoInfo.jdField_b_of_type_JavaLangString = ((String)localObject2);
              localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
              localMsgTabNodeVideoInfo.jdField_a_of_type_Long = paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size();
              localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean = false;
              if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
                localMsgTabNodeVideoInfo.jdField_b_of_type_Long = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
              }
              paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.add(localMsgTabNodeVideoInfo);
              this.jdField_a_of_type_JavaUtilList.add(localMsgTabNodeVideoInfo);
              paramArrayOfByte.add(localObject4);
            }
            i += 1;
          }
        }
      }
      paramRspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList.video_list.get().iterator();
      while (paramRspMsgTabNodeVideoList.hasNext())
      {
        paramArrayOfByte = (qqstory_service.MsgTabNodeVidInfo)paramRspMsgTabNodeVideoList.next();
        localObject1 = paramArrayOfByte.feed_id.get().toStringUtf8();
        localObject2 = paramArrayOfByte.video_index_list.get().iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          localObject4 = MsgTabNodeVideoInfo.a(paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList, ((Long)localObject3).longValue());
          if (localObject4 == null)
          {
            SLog.e("Q.qqstory:ReqMsgTabNodeVideoList", "find index %d return null!, videoList is = %s", new Object[] { localObject3, paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList });
          }
          else
          {
            ((MsgTabNodeVideoInfo)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject1);
            ((MsgTabNodeVideoInfo)localObject4).jdField_a_of_type_JavaLangString = ((ByteStringMicro)paramArrayOfByte.vid_list.get(i)).toStringUtf8();
            if (paramArrayOfByte.recommand_id_list.has()) {
              ((MsgTabNodeVideoInfo)localObject4).jdField_b_of_type_Long = ((Integer)paramArrayOfByte.recommand_id_list.get(i)).intValue();
            }
          }
          i += 1;
        }
      }
      this.jdField_a_of_type_JavaUtilList = paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList;
      if (!paramMsgTabNodeInfo.a()) {
        SLog.d("Q.qqstory:ReqMsgTabNodeVideoList", "node info is not ok, %s", new Object[] { paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse
 * JD-Core Version:    0.7.0.1
 */