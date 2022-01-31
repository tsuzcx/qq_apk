import android.content.Intent;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.qphone.base.util.QLog;

public class anly
  implements bcrn
{
  public anly(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "BaseMsgBoxActivity, onTabSelected: old=" + paramInt1 + ", cur=" + paramInt2 + ", msgTabIdx=" + this.a.b + ", unReadMsgNum=" + this.a.c);
    }
    Intent localIntent;
    if ((paramInt1 == this.a.b) && (paramInt2 != this.a.b))
    {
      localIntent = new Intent();
      localIntent.putExtra("curIndex", paramInt2);
      if (!this.a.e) {
        break label176;
      }
    }
    label176:
    for (paramInt1 = this.a.c;; paramInt1 = 0)
    {
      localIntent.putExtra("unReadMsgNum", paramInt1);
      this.a.setResult(-1, localIntent);
      this.a.finish();
      this.a.overridePendingTransition(2130772211, 2130772211);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "finish");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anly
 * JD-Core Version:    0.7.0.1
 */