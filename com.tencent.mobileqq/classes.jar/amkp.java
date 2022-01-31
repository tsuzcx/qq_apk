import android.content.res.Resources;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class amkp
  extends absl
{
  public amkp(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, abtf paramabtf)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramabtf);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.a.getCurrentAccountUin().equals(paramString1)) {
      return this.a.getApp().getResources().getString(2131694218);
    }
    return bdgc.c(this.a, paramString2, paramString1);
  }
  
  public void a(MessageRecord paramMessageRecord, awgf paramawgf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, absj paramabsj)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:" + paramMessageRecord);
    }
    Map localMap = paramabsj.jdField_a_of_type_JavaUtilMap;
    Object localObject = paramabsj.jdField_a_of_type_Amnz;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = ayzl.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    int k = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    RecentUser localRecentUser = ((amnz)localObject).a(str1, paramMessageRecord.istroop);
    localObject = null;
    auga localauga = paramabsj.jdField_a_of_type_Auga;
    String str2;
    bbpd localbbpd;
    if (localauga != null)
    {
      str2 = str1 + "&" + 3000;
      localbbpd = localauga.a(str2);
      if (localbbpd == null) {
        break label640;
      }
      if (localbbpd.a() == paramMessageRecord.shmsgseq) {
        break label583;
      }
      localbbpd = null;
      localObject = localbbpd;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:not the same msg:" + str2);
        localObject = localbbpd;
      }
    }
    int i;
    if ((localObject != null) && (((bbpd)localObject).a()))
    {
      i = ((bbpd)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord, bizType" + i + "|ru.msgType:" + localRecentUser.msgType);
      }
      if (bbpd.a(i, localRecentUser.msgType))
      {
        localRecentUser.msgType = i;
        localRecentUser.msg = bbpd.a(this.a, str1, (bbpd)localObject, localRecentUser.msg, paramMessageRecord, false);
        localMap.put(abti.a(str1, k), localRecentUser);
      }
    }
    if (localMap.containsKey(abti.a(localRecentUser.uin, localRecentUser.getType()))) {}
    for (localObject = (RecentUser)localMap.get(abti.a(localRecentUser.uin, localRecentUser.getType()));; localObject = localRecentUser)
    {
      if (!abti.h(paramMessageRecord.msgtype)) {}
      for (i = 1;; i = 0)
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
            localMap.put(abti.a(str1, k), localObject);
          }
        }
        super.a(paramMessageRecord, paramawgf, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramabsj);
        paramawgf = baid.a(this.a);
        paramawgf.a(paramMessageRecord);
        paramawgf.a();
        return;
        label583:
        localObject = localbbpd;
        if (!paramMessageRecord.isread) {
          break;
        }
        localauga.b(str2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:readed msg been removed:" + str2);
        }
        localObject = null;
        break;
        label640:
        localObject = localbbpd;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:msgInfo == null " + str2);
        localObject = localbbpd;
        break;
      }
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
  
  public void c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt);
    }
    super.c(paramString, paramInt);
    ProxyManager localProxyManager = this.a.a();
    paramString = localProxyManager.a().a(paramString, paramInt);
    if (paramString.shouldShowInRecentList())
    {
      paramString.cleanMsgAndMsgData(paramString.msgType);
      localProxyManager.a().a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amkp
 * JD-Core Version:    0.7.0.1
 */