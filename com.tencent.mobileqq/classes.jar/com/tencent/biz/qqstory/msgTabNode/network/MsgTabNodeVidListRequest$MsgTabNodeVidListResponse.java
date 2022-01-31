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
import java.util.Iterator;
import java.util.List;

public class MsgTabNodeVidListRequest$MsgTabNodeVidListResponse
  extends BaseResponse
{
  public MsgTabNodeInfo a;
  public qqstory_service.RspMsgTabNodeVideoList a;
  public byte[] a;
  
  public MsgTabNodeVidListRequest$MsgTabNodeVidListResponse(MsgTabNodeInfo paramMsgTabNodeInfo, qqstory_service.RspMsgTabNodeVideoList paramRspMsgTabNodeVideoList, byte[] paramArrayOfByte)
  {
    super(paramRspMsgTabNodeVideoList.result);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = paramMsgTabNodeInfo;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    if (paramRspMsgTabNodeVideoList.video_list != null)
    {
      paramRspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList.video_list.get().iterator();
      if (paramRspMsgTabNodeVideoList.hasNext())
      {
        paramArrayOfByte = (qqstory_service.MsgTabNodeVidInfo)paramRspMsgTabNodeVideoList.next();
        String str = paramArrayOfByte.feed_id.get().toStringUtf8();
        Iterator localIterator = paramArrayOfByte.video_index_list.get().iterator();
        int i = 0;
        label91:
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo;
        if (localIterator.hasNext())
        {
          Long localLong = (Long)localIterator.next();
          localMsgTabNodeVideoInfo = MsgTabNodeVideoInfo.a(paramMsgTabNodeInfo.a, localLong.longValue());
          if (localMsgTabNodeVideoInfo != null) {
            break label164;
          }
          SLog.e("Q.qqstory:ReqMsgTabNodeVideoList", "find index %d return null!, videoList is = %s", new Object[] { localLong, paramMsgTabNodeInfo.a });
        }
        for (;;)
        {
          i += 1;
          break label91;
          break;
          label164:
          localMsgTabNodeVideoInfo.b = str;
          localMsgTabNodeVideoInfo.a = ((ByteStringMicro)paramArrayOfByte.vid_list.get(i)).toStringUtf8();
        }
      }
      if (!paramMsgTabNodeInfo.a()) {
        SLog.d("Q.qqstory:ReqMsgTabNodeVideoList", "node info is not ok, %s", new Object[] { paramMsgTabNodeInfo.a });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse
 * JD-Core Version:    0.7.0.1
 */