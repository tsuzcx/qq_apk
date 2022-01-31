import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class bals
  implements Manager
{
  public static int a;
  public static int b = 1920;
  QQAppInterface a;
  
  static
  {
    jdField_a_of_type_Int = 1080;
  }
  
  public bals(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private MessageForTroopReward a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3)
  {
    MessageForTroopReward localMessageForTroopReward = new MessageForTroopReward();
    localMessageForTroopReward.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForTroopReward.frienduin = paramString1;
    localMessageForTroopReward.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForTroopReward.msgUid = axas.a(paramInt1);
    localMessageForTroopReward.msg = bbet.a(null);
    localMessageForTroopReward.msgtype = -2048;
    localMessageForTroopReward.isread = true;
    localMessageForTroopReward.issend = 1;
    localMessageForTroopReward.istroop = 1;
    localMessageForTroopReward.time = awzw.a();
    localMessageForTroopReward.rewardCreateTime = ((int)(System.currentTimeMillis() / 1000L));
    localMessageForTroopReward.rewardMoney = paramInt2;
    localMessageForTroopReward.rewardContent = paramString2;
    localMessageForTroopReward.rewardType = paramInt3;
    localMessageForTroopReward.mediaPath = paramString3;
    localMessageForTroopReward.rewardStatus = 10000;
    localMessageForTroopReward.rewardSeq = localMessageForTroopReward.uniseq;
    localMessageForTroopReward.prewrite();
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "buildTroopRewardMgr success");
    }
    return localMessageForTroopReward;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean)
  {
    paramQQAppInterface = "http://qun.qq.com/qunpay/reward/index.html?_wv=1039&_bid=2313&gc=" + paramString;
    paramString = new Intent(paramContext, QQBrowserActivity.class);
    paramString.putExtra("url", paramQQAppInterface);
    if (paramBoolean) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "openNewReward:" + paramQQAppInterface);
    }
  }
  
  public MessageForTroopReward a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1) == null) {
      return null;
    }
    Object localObject1 = a(paramString1, 1);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
      } while ((!(localObject2 instanceof MessageForTroopReward)) || (!paramString2.equals(((MessageForTroopReward)localObject2).rewardId)));
    }
    for (localObject1 = (MessageForTroopReward)localObject2;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 1, new int[] { -2048 }).iterator();
        while (paramString1.hasNext())
        {
          localObject2 = (MessageRecord)paramString1.next();
          if ((localObject2 instanceof MessageForTroopReward))
          {
            localObject2 = (MessageForTroopReward)localObject2;
            ((MessageForTroopReward)localObject2).parse();
            if (paramString2.equals(((MessageForTroopReward)localObject2).rewardId)) {
              return localObject2;
            }
          }
        }
      }
      return localObject1;
    }
  }
  
  protected String a(String paramString, int paramInt)
  {
    return akpy.a(paramString, paramInt);
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt)
  {
    synchronized (akpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      paramString = (List)akpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt));
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
  }
  
  public void a(MessageForTroopReward paramMessageForTroopReward)
  {
    if (paramMessageForTroopReward != null)
    {
      paramMessageForTroopReward.prewrite();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForTroopReward.frienduin, 1, paramMessageForTroopReward.uniseq, paramMessageForTroopReward.msgData);
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.troop_reward", 2, "insertAIOMsg troop uin empty");
      }
      return;
    }
    paramString1 = a(paramString1, Math.abs(new Random().nextInt()), paramInt1, paramString2, paramString3, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bals
 * JD-Core Version:    0.7.0.1
 */