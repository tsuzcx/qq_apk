import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.relationx.friendclue.FriendClueCommonGroupHelper.2.1;
import com.tencent.qphone.base.util.QLog;

public class bbct
  extends auzh
{
  bbct(bbcs parambbcs) {}
  
  protected void a(boolean paramBoolean, String paramString, IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetIntimateInfo");
    }
    bbcs.a(this.a).removeObserver(this.a.a);
    bbcs.a(this.a).removeMessages(1);
    if (paramBoolean)
    {
      bbcs.a(this.a, paramIntimateInfo);
      this.a.a();
      return;
    }
    bbcs.a(this.a).post(new FriendClueCommonGroupHelper.2.1(this));
    QLog.e("FriendClueCommonGroupHelper", 1, "get intimateInfo failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbct
 * JD-Core Version:    0.7.0.1
 */