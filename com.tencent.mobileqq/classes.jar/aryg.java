import android.os.Bundle;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.dating.MsgBoxListActivity.7.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aryg
  implements axxd
{
  public aryg(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgBoxListActivity", 2, "follow onReceive errorCode = [" + paramInt + "]");
    }
    this.a.b.post(new MsgBoxListActivity.7.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryg
 * JD-Core Version:    0.7.0.1
 */