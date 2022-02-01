import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class amqd
  extends anmu
{
  amqd(amqc paramamqc) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qwe", 2, "onUpdateFriendInfo:" + paramString);
    }
    if ((amqc.a(this.a) != null) && (amqc.a(this.a).get(paramString + "nick") != null))
    {
      int i = ((Integer)amqc.a(this.a).remove(paramString + "nick")).intValue();
      this.a.a(i, paramString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqd
 * JD-Core Version:    0.7.0.1
 */