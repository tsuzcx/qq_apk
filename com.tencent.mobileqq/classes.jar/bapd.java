import com.tencent.mobileqq.qcircle.QCircleChatMsgListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bapd
  extends asvt
{
  public bapd(QCircleChatMsgListFragment paramQCircleChatMsgListFragment) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleChatMsgListFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleChatMsgListFragment", 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    QCircleChatMsgListFragment.a(this.a, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapd
 * JD-Core Version:    0.7.0.1
 */