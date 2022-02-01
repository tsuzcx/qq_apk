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
  public byte[] b;
  public qqstory_service.RspMsgTabNodeVideoList e;
  public List<MsgTabNodeVideoInfo> f = new ArrayList();
  
  public MsgTabNodeVidListRequest$MsgTabNodeVidListResponse(MsgTabNodeInfo paramMsgTabNodeInfo, qqstory_service.RspMsgTabNodeVideoList paramRspMsgTabNodeVideoList, byte[] paramArrayOfByte)
  {
    super(paramRspMsgTabNodeVideoList.result);
    this.a = paramMsgTabNodeInfo;
    this.e = paramRspMsgTabNodeVideoList;
    this.b = paramArrayOfByte;
    if (paramRspMsgTabNodeVideoList.video_list != null)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int i;
      Object localObject4;
      if (paramMsgTabNodeInfo.b == 12)
      {
        SLog.a("Q.qqstory:ReqMsgTabNodeVideoList", "new video list receive cookie:%s nodeInfo old size=%d, rsp.video_list size=%d", paramRspMsgTabNodeVideoList.cookie.get(), Integer.valueOf(paramMsgTabNodeInfo.e.size()), Integer.valueOf(paramRspMsgTabNodeVideoList.video_list.size()));
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
            MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = MsgTabNodeVideoInfo.a(paramMsgTabNodeInfo.e, ((Long)localObject4).longValue());
            if ((localMsgTabNodeVideoInfo != null) && (!paramArrayOfByte.contains(localObject4)))
            {
              localMsgTabNodeVideoInfo.d = ((String)localObject2);
              localMsgTabNodeVideoInfo.c = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
              if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
                localMsgTabNodeVideoInfo.f = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
              }
            }
            else
            {
              localMsgTabNodeVideoInfo = new MsgTabNodeVideoInfo();
              localMsgTabNodeVideoInfo.d = ((String)localObject2);
              localMsgTabNodeVideoInfo.c = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
              localMsgTabNodeVideoInfo.a = paramMsgTabNodeInfo.e.size();
              localMsgTabNodeVideoInfo.b = false;
              if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
                localMsgTabNodeVideoInfo.f = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
              }
              paramMsgTabNodeInfo.e.add(localMsgTabNodeVideoInfo);
              this.f.add(localMsgTabNodeVideoInfo);
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
          localObject4 = MsgTabNodeVideoInfo.a(paramMsgTabNodeInfo.e, ((Long)localObject3).longValue());
          if (localObject4 == null)
          {
            SLog.e("Q.qqstory:ReqMsgTabNodeVideoList", "find index %d return null!, videoList is = %s", new Object[] { localObject3, paramMsgTabNodeInfo.e });
          }
          else
          {
            ((MsgTabNodeVideoInfo)localObject4).d = ((String)localObject1);
            ((MsgTabNodeVideoInfo)localObject4).c = ((ByteStringMicro)paramArrayOfByte.vid_list.get(i)).toStringUtf8();
            if (paramArrayOfByte.recommand_id_list.has()) {
              ((MsgTabNodeVideoInfo)localObject4).f = ((Integer)paramArrayOfByte.recommand_id_list.get(i)).intValue();
            }
          }
          i += 1;
        }
      }
      this.f = paramMsgTabNodeInfo.e;
      if (!paramMsgTabNodeInfo.d()) {
        SLog.d("Q.qqstory:ReqMsgTabNodeVideoList", "node info is not ok, %s", new Object[] { paramMsgTabNodeInfo.e });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse
 * JD-Core Version:    0.7.0.1
 */