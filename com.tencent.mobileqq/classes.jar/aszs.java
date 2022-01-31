import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.qphone.base.util.QLog;

class aszs
  implements atff
{
  aszs(aszr paramaszr) {}
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    QLog.i("GroupVideoManager|Communicate", 2, "receive startWatchTogether: " + paramNewTogetherRoomMessageData.toString());
    aszr.a(this.a, paramNewTogetherRoomMessageData, 1);
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    QLog.i("GroupVideoManager|Communicate", 2, "receive switchWatchTogether: " + paramNewTogetherRoomMessageData.toString());
    aszr.a(this.a, paramNewTogetherRoomMessageData, 3);
  }
  
  public void c(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    QLog.i("GroupVideoManager|Communicate", 2, "receive closeWatchTogether: " + paramNewTogetherRoomMessageData.toString());
    aszr.a(this.a, paramNewTogetherRoomMessageData, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszs
 * JD-Core Version:    0.7.0.1
 */