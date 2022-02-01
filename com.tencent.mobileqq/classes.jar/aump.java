import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.qphone.base.util.QLog;

class aump
  implements aurg
{
  aump(aumo paramaumo) {}
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    QLog.i("GroupVideoManager|Communicate", 2, "receive startWatchTogether: " + paramNewTogetherRoomMessageData.toString());
    aumo.a(this.a, paramNewTogetherRoomMessageData, 1);
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    QLog.i("GroupVideoManager|Communicate", 2, "receive switchWatchTogether: " + paramNewTogetherRoomMessageData.toString());
    aumo.a(this.a, paramNewTogetherRoomMessageData, 3);
  }
  
  public void c(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    QLog.i("GroupVideoManager|Communicate", 2, "receive closeWatchTogether: " + paramNewTogetherRoomMessageData.toString());
    aumo.a(this.a, paramNewTogetherRoomMessageData, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aump
 * JD-Core Version:    0.7.0.1
 */