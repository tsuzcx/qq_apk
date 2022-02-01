import android.content.res.Resources;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aofc
  extends acvk
{
  public aofc(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, acwe paramacwe)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramacwe);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.a.getCurrentAccountUin().equals(paramString1)) {
      return this.a.getApp().getResources().getString(2131693477);
    }
    return bglf.c(this.a, paramString2, paramString1);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, acvi paramacvi)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:" + paramMessageRecord);
    }
    Map localMap = paramacvi.jdField_a_of_type_JavaUtilMap;
    Object localObject = paramacvi.jdField_a_of_type_Aong;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = bbyp.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    int k = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    RecentUser localRecentUser = (RecentUser)((aong)localObject).findRecentUserByUin(str1, paramMessageRecord.istroop);
    localObject = null;
    awne localawne = paramacvi.jdField_a_of_type_Awne;
    String str2;
    bepr localbepr;
    if (localawne != null)
    {
      str2 = str1 + "&" + 3000;
      localbepr = localawne.a(str2);
      if (localbepr == null) {
        break label647;
      }
      if (localbepr.b() == paramMessageRecord.shmsgseq) {
        break label590;
      }
      localbepr = null;
      localObject = localbepr;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:not the same msg:" + str2);
        localObject = localbepr;
      }
    }
    if ((localObject != null) && (((bepr)localObject).a()))
    {
      i = ((bepr)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord, bizType" + i + "|ru.msgType:" + localRecentUser.msgType);
      }
      if (bepr.a(i, localRecentUser.msgType))
      {
        localRecentUser.msgType = i;
        localRecentUser.msg = bfiu.a(this.a, str1, (bepr)localObject, localRecentUser.msg, paramMessageRecord, false);
        localMap.put(acwh.a(str1, k), localRecentUser);
      }
    }
    localObject = localRecentUser;
    if (localMap.containsKey(acwh.a(localRecentUser.uin, localRecentUser.getType()))) {
      localObject = (RecentUser)localMap.get(acwh.a(localRecentUser.uin, localRecentUser.getType()));
    }
    if (!acwh.h(paramMessageRecord.msgtype)) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (paramMessageRecord.isLongMsg())
      {
        j = i;
        if (this.a.a().a(paramMessageRecord))
        {
          i = 0;
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
            j = i;
          }
        }
      }
      if (j != 0)
      {
        ((RecentUser)localObject).uin = str1;
        ((RecentUser)localObject).setType(k);
        boolean bool = true;
        if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
          bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
        }
        if ((l > ((RecentUser)localObject).lastmsgtime) && (bool))
        {
          ((RecentUser)localObject).lastmsgtime = l;
          localMap.put(acwh.a(str1, k), localObject);
        }
      }
      super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramacvi);
      paramEntityManager = bdjh.a(this.a);
      paramEntityManager.a(paramMessageRecord);
      paramEntityManager.a();
      return;
      label590:
      localObject = localbepr;
      if (!paramMessageRecord.isread) {
        break;
      }
      localawne.b(str2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:readed msg been removed:" + str2);
      }
      localObject = null;
      break;
      label647:
      localObject = localbepr;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:msgInfo == null " + str2);
      localObject = localbepr;
      break;
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    super.a(paramString, paramInt, paramLong);
    c(paramString, paramInt, paramLong);
  }
  
  protected String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt);
    }
    super.b(paramString, paramInt);
    ProxyManager localProxyManager = this.a.a();
    paramString = (RecentUser)localProxyManager.a().findRecentUserByUin(paramString, paramInt);
    if (paramString.shouldShowInRecentList(this.a))
    {
      paramString.cleanMsgAndMsgData(paramString.msgType);
      localProxyManager.a().saveRecentUser(paramString);
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    if (this.a.a().a(paramString, paramInt) > 0) {
      c(paramString, paramInt, paramLong);
    }
    super.b(paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofc
 * JD-Core Version:    0.7.0.1
 */