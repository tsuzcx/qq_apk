import com.tencent.jungle.videohub.proto.CommProtocolProto.commRequest;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import tencent.im.troop.studyroom.self_study_room_troop.StudyRoomMemberInfoReq;
import tencent.im.troop.studyroom.self_study_room_troop.StudyRoomMenberInfoRsp;

public class bdvp
  implements anui
{
  public void a(String paramString1, int paramInt, String paramString2) {}
  
  public void a(String paramString, self_study_room_troop.StudyRoomMenberInfoRsp paramStudyRoomMenberInfoRsp) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramObject = (Object[])paramObject;
    Object localObject = (CommProtocolProto.commRequest)paramObject[0];
    paramObject = (FromServiceMsg)paramObject[1];
    self_study_room_troop.StudyRoomMemberInfoReq localStudyRoomMemberInfoReq = new self_study_room_troop.StudyRoomMemberInfoReq();
    try
    {
      localStudyRoomMemberInfoReq.mergeFrom(((CommProtocolProto.commRequest)localObject).body.get().toByteArray());
      if ((paramObject.isSuccess()) && (paramObject.getWupBuffer() != null))
      {
        localObject = new CommProtocolProto.commResponse();
        ((CommProtocolProto.commResponse)localObject).mergeFrom(paramObject.getWupBuffer());
        self_study_room_troop.StudyRoomMenberInfoRsp localStudyRoomMenberInfoRsp = new self_study_room_troop.StudyRoomMenberInfoRsp();
        localStudyRoomMenberInfoRsp.mergeFrom(((CommProtocolProto.commResponse)localObject).body.get().toByteArray());
        a(localStudyRoomMemberInfoReq.troop_uin.get(), localStudyRoomMenberInfoRsp);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
      a(localStudyRoomMemberInfoReq.troop_uin.get(), paramObject.getResultCode(), paramObject.getBusinessFailMsg());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvp
 * JD-Core Version:    0.7.0.1
 */