import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallDetailActivity.1.1;
import com.tencent.mobileqq.qcall.QCallDetailActivity.1.2;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.Map;

public class azvw
  extends anmu
{
  public azvw(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, QCallDetailActivity.a(this.a))))
    {
      QCallDetailActivity.a(this.a);
      this.a.runOnUiThread(new QCallDetailActivity.1.1(this));
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead isSuccess | " + paramBoolean + ", uin | " + paramString);
    }
    Object localObject;
    if ((paramBoolean) && (QCallDetailActivity.a(this.a) == 3000) && (!bgjw.a(paramString, this.a.app.getCurrentAccountUin())))
    {
      localObject = (ankw)this.a.app.getManager(53);
      if (localObject != null) {
        break label109;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead dm is null  ====");
      }
    }
    label109:
    do
    {
      do
      {
        return;
        if (((ankw)localObject).a(QCallDetailActivity.a(this.a)) != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead info is null ====");
      return;
      if (TextUtils.isEmpty(paramString))
      {
        QLog.i("QCallDetailActivity", 1, " === onUpdateCustomHead uin is null ====");
        return;
      }
      localObject = ((ankw)localObject).a(QCallDetailActivity.a(this.a));
    } while ((localObject == null) || (((Map)localObject).size() <= 0) || (!((Map)localObject).containsKey(paramString)));
    this.a.a(QCallDetailActivity.a(this.a));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramBoolean) && (QCallDetailActivity.a(this.a) == 3000))
    {
      localObject = (ankw)this.a.app.getManager(53);
      if (localObject != null) {
        break label52;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QCallDetailActivity", 2, " === onUpdateFriendInfo dm is null  ====");
      }
    }
    label52:
    do
    {
      DiscussionInfo localDiscussionInfo;
      do
      {
        return;
        localDiscussionInfo = ((ankw)localObject).a(QCallDetailActivity.a(this.a));
        if (localDiscussionInfo == null)
        {
          QLog.i("QCallDetailActivity", 1, " ===onUpdateFriendInfo info is null ====");
          return;
        }
        if (TextUtils.isEmpty(paramString))
        {
          QLog.i("QCallDetailActivity", 1, " === onUpdateFriendInfo uin is null ====");
          return;
        }
      } while (localDiscussionInfo.hasRenamed());
      localObject = ((ankw)localObject).a(QCallDetailActivity.a(this.a));
    } while ((localObject == null) || (((Map)localObject).size() <= 0) || (!((Map)localObject).containsKey(paramString)));
    this.a.a(QCallDetailActivity.a(this.a));
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    QCallDetailActivity.a(this.a);
    this.a.runOnUiThread(new QCallDetailActivity.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvw
 * JD-Core Version:    0.7.0.1
 */