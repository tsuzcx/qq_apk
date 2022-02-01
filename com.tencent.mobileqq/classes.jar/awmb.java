import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class awmb
  extends anyu
{
  public awmb(ListenTogetherManager paramListenTogetherManager) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("ListenTogether.Manager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if (paramBoolean)
    {
      String str = awml.a(2, String.valueOf(paramObject));
      if (ListenTogetherManager.a(this.a).equals(str))
      {
        ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).g = 3;
        ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).h = 3;
        awlo.b(ListenTogetherManager.a(this.a), String.valueOf(paramObject), false);
        this.a.a(true, (ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a)), 1007);
        this.a.a(2, String.valueOf(paramObject), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmb
 * JD-Core Version:    0.7.0.1
 */