import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.qphone.base.util.QLog;

public class bdev
{
  public static CardProfile a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    boolean bool = true;
    CardProfile localCardProfile = null;
    awgf localawgf = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface = localCardProfile;
    if (localawgf != null)
    {
      localCardProfile = (CardProfile)localawgf.a(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(paramInt) });
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
      paramQQAppInterface = (CardProfile)((awgf)localObject).a(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(2) });
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.bAvailableCnt -= paramInt;
        paramQQAppInterface.bTodayVotedCnt += paramInt;
        if (paramQQAppInterface.getStatus() != 1000) {
          break label238;
        }
        ((awgf)localObject).b(paramQQAppInterface);
      }
      localCardProfile = (CardProfile)((awgf)localObject).a(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(3) });
      if (localCardProfile != null)
      {
        localCardProfile.bAvailableCnt -= paramInt;
        localCardProfile.bTodayVotedCnt += paramInt;
        localCardProfile.bVoteCnt = ((short)(int)localCardProfile.bTodayVotedCnt);
        if (localCardProfile.getStatus() != 1000) {
          break label248;
        }
        ((awgf)localObject).b(localCardProfile);
      }
      label180:
      ((awgf)localObject).a();
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
      ((awgf)localObject).a(paramQQAppInterface);
      break;
      label248:
      ((awgf)localObject).a(localCardProfile);
      break label180;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdev
 * JD-Core Version:    0.7.0.1
 */