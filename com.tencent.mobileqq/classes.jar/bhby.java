import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class bhby
{
  public static CardProfile a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    boolean bool = true;
    CardProfile localCardProfile = null;
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface = localCardProfile;
    if (localEntityManager != null)
    {
      localCardProfile = (CardProfile)localEntityManager.find(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(paramInt) });
      paramQQAppInterface = localCardProfile;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder().append("readFromDb. uin:").append(paramLong).append(" find:");
        if (localCardProfile == null) {
          break label111;
        }
      }
    }
    for (;;)
    {
      QLog.i("VoteUtil", 2, bool);
      paramQQAppInterface = localCardProfile;
      return paramQQAppInterface;
      label111:
      bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    Object localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    CardProfile localCardProfile;
    if (localObject != null)
    {
      paramQQAppInterface = (CardProfile)((EntityManager)localObject).find(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(2) });
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.bAvailableCnt -= paramInt;
        paramQQAppInterface.bTodayVotedCnt += paramInt;
        if (paramQQAppInterface.getStatus() != 1000) {
          break label238;
        }
        ((EntityManager)localObject).persistOrReplace(paramQQAppInterface);
      }
      localCardProfile = (CardProfile)((EntityManager)localObject).find(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(3) });
      if (localCardProfile != null)
      {
        localCardProfile.bAvailableCnt -= paramInt;
        localCardProfile.bTodayVotedCnt += paramInt;
        localCardProfile.bVoteCnt = ((short)(int)localCardProfile.bTodayVotedCnt);
        if (localCardProfile.getStatus() != 1000) {
          break label248;
        }
        ((EntityManager)localObject).persistOrReplace(localCardProfile);
      }
      label180:
      ((EntityManager)localObject).close();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("updateProfileCardVote. uin:").append(paramLong).append(" find:");
        if (paramQQAppInterface == null) {
          break label259;
        }
      }
    }
    label259:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VoteUtil", 2, bool);
      return;
      label238:
      ((EntityManager)localObject).update(paramQQAppInterface);
      break;
      label248:
      ((EntityManager)localObject).update(localCardProfile);
      break label180;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhby
 * JD-Core Version:    0.7.0.1
 */