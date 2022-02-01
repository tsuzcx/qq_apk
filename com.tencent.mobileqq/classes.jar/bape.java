import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.QCircleChatMsgListFragment;
import com.tencent.qphone.base.util.QLog;

public class bape
  extends anyu
{
  public bape(QCircleChatMsgListFragment paramQCircleChatMsgListFragment) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a(paramString))) {
      this.a.a();
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCircleChatMsgListFragment", 2, "onUpdateFriendInfo uin =" + paramString);
      }
      int i = 0;
      if (this.a.a(paramString)) {
        i = 1;
      }
      if (i != 0) {
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bape
 * JD-Core Version:    0.7.0.1
 */