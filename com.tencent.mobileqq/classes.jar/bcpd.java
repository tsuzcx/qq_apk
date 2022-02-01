import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.troop.studyroom.self_study_room_troop.StudyRoomMenberInfoRsp;

class bcpd
  extends bcpg
{
  bcpd(bcpa parambcpa) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.w("studyroom.proto.StudyRoomObserver", 2, "onGetStudyRoomMemberCount error. troop:" + paramString1 + " rsp:" + paramInt + " msg:" + paramString2);
  }
  
  public void a(String paramString, self_study_room_troop.StudyRoomMenberInfoRsp paramStudyRoomMenberInfoRsp)
  {
    int i = Math.max(paramStudyRoomMenberInfoRsp.member_count.get(), 0);
    bcpa.a(this.a, paramString, i);
    QLog.d("studyroom.proto.StudyRoomObserver", 2, "onGetStudyRoomMemberCountSucc troop:" + paramString + " member_count:" + paramStudyRoomMenberInfoRsp.member_count.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpd
 * JD-Core Version:    0.7.0.1
 */