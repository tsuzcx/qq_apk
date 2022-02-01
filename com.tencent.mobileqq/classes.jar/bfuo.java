import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.10;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.3;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.4;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.6;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.9;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsg;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.RspBody;

public class bfuo
  implements Manager
{
  protected aoip a;
  protected aojs a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public ArrayList<bfun> a;
  public HashMap<Long, HashMap<bful, bfum>> a;
  public HashMap<Long, ArrayList<bfuu>> b = new HashMap();
  
  public bfuo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_Aojs = new bfup(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_Aoip = ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
  }
  
  private BaseChatPie a(long paramLong)
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Object localObject = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject != null) && ((localObject instanceof aihd)) && (((BaseChatPie)localObject).h() >= 2))
        {
          String str = ((BaseChatPie)localObject).a();
          if ((!TextUtils.isEmpty(str)) && (str.equals(String.valueOf(paramLong)))) {
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  private void a(long paramLong)
  {
    BaseChatPie localBaseChatPie = a(paramLong);
    if (localBaseChatPie != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopEssenceMsgManager", 2, "refreshAio");
      }
      localBaseChatPie.f(131072);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void a(long paramLong, int paramInt, String paramString)
  {
    if (a(paramLong) == null) {}
    while (paramInt == 0) {
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = BaseApplicationImpl.getContext().getResources().getString(2131718879);
    }
    if ((paramInt == 11002) || (paramInt == 11007))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), str, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, str, 0).a();
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    QLog.i("TroopEssenceMsgManager", 2, "delEssenceMsgGrayTip troopUin:" + paramLong1 + " graytipuniseq:" + paramLong2);
    ThreadManager.excute(new TroopEssenceMsgManager.6(this, paramLong1, paramLong2), 32, null, true);
  }
  
  private void a(bfun parambfun)
  {
    if ((parambfun == null) || (parambfun.a == null)) {
      return;
    }
    a(parambfun.a.troopUin, new bfur(this, parambfun));
  }
  
  private void a(boolean paramBoolean, Object paramObject1, Object paramObject2, int paramInt)
  {
    if ((paramObject1 == null) || (paramObject2 == null) || (!(paramObject2 instanceof oidb_0xeac.RspBody)) || (!(paramObject1 instanceof TroopEssenceMsgItem))) {}
    do
    {
      return;
      paramObject2 = (oidb_0xeac.RspBody)paramObject2;
      paramObject1 = (TroopEssenceMsgItem)paramObject1;
      int i = paramObject2.error_code.get();
      String str = paramObject2.wording.get();
      QLog.i("TroopEssenceMsgManager", 1, "handlerSetTroopEssenceMsg isSuccess:" + paramBoolean + " oidbErrCode:" + paramInt + " errCode:" + i + " wording:" + str);
      paramInt = i;
      if (i == 0)
      {
        paramInt = i;
        if (!paramBoolean) {
          paramInt = -1;
        }
      }
      a(paramObject1.troopUin, paramInt, str);
    } while ((paramInt != 0) && (paramInt != 11002) && (paramInt != 11007));
    paramObject1.opTime = 0L;
    if ((paramInt == 11002) || (paramInt == 11007))
    {
      if (paramObject2.digest_uin.has()) {
        paramObject1.opUin = String.valueOf(paramObject2.digest_uin.get());
      }
      if (paramObject2.digest_time.has()) {
        paramObject1.opTime = paramObject2.digest_time.get();
      }
    }
    c(paramObject1);
  }
  
  private boolean a(bfun parambfun)
  {
    if ((parambfun == null) || (parambfun.a == null)) {
      return false;
    }
    Object localObject = new bful(parambfun.a.troopUin, parambfun.a.msgSeq, parambfun.a.msgRandom);
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((bful)localObject).jdField_a_of_type_Long));
    if (localHashMap != null)
    {
      localObject = (bfum)localHashMap.get(localObject);
      return (localObject == null) || (((bfum)localObject).jdField_a_of_type_Long < parambfun.a.opTime);
    }
    return false;
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())
    {
      if (paramEntity.getStatus() != 1000) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
  }
  
  private void b(bfun parambfun)
  {
    if ((parambfun == null) || (parambfun.a == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        parambfun = new bful(parambfun.a.troopUin, parambfun.a.msgSeq, parambfun.a.msgRandom);
        localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(parambfun.jdField_a_of_type_Long));
      } while (localObject == null);
      localObject = (bfum)((HashMap)localObject).get(parambfun);
    } while ((localObject == null) || (((bfum)localObject).b == 0L));
    a(parambfun.jdField_a_of_type_Long, ((bfum)localObject).b);
  }
  
  private void b(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    a(paramTroopEssenceMsgItem.troopUin, new bfus(this, paramTroopEssenceMsgItem));
  }
  
  private void b(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg, boolean paramBoolean)
  {
    paramQQGroupDigestMsg = bfuv.a(paramQQGroupDigestMsg);
    if (paramBoolean)
    {
      QLog.i("TroopEssenceMsgManager", 1, "handleEssenceMsgGroupPushMain holdMsg:" + paramQQGroupDigestMsg.toString());
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramQQGroupDigestMsg);
        ThreadManager.getUIHandler().postDelayed(new TroopEssenceMsgManager.4(this), 5000L);
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQQGroupDigestMsg);
      return;
    }
    QLog.i("TroopEssenceMsgManager", 1, "handleEssenceMsgGroupPushMain msgItem:" + paramQQGroupDigestMsg.toString());
    a(paramQQGroupDigestMsg);
  }
  
  private void c(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    a(paramTroopEssenceMsgItem.troopUin, new bfut(this, paramTroopEssenceMsgItem));
  }
  
  public bfum a(bful parambful)
  {
    if (parambful == null) {
      return null;
    }
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(parambful.jdField_a_of_type_Long));
    if (localHashMap == null) {
      return null;
    }
    return (bfum)localHashMap.get(parambful);
  }
  
  public HashMap<bful, bfum> a(long paramLong)
  {
    localHashMap = new HashMap();
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopEssenceMsgItem.class, false, "troopUin=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TroopEssenceMsgItem localTroopEssenceMsgItem = (TroopEssenceMsgItem)((Iterator)localObject).next();
          localHashMap.put(new bful(localTroopEssenceMsgItem.troopUin, localTroopEssenceMsgItem.msgSeq, localTroopEssenceMsgItem.msgRandom), new bfum(localTroopEssenceMsgItem.opType, localTroopEssenceMsgItem.msgSenderUin, localTroopEssenceMsgItem.opUin, localTroopEssenceMsgItem.opTime, localTroopEssenceMsgItem.graytipuniseq));
        }
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      QLog.e("TroopEssenceMsgManager", 1, "readEntity exception + " + localException.getMessage(), localException);
    }
  }
  
  public void a(long paramLong, bfuu parambfuu)
  {
    if (parambfuu == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      parambfuu.a(paramLong, (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)));
      return;
    }
    if (!this.b.containsKey(Long.valueOf(paramLong)))
    {
      this.b.put(Long.valueOf(paramLong), new ArrayList(Arrays.asList(new bfuu[] { parambfuu })));
      ThreadManager.excute(new TroopEssenceMsgManager.9(this, paramLong), 32, null, true);
      return;
    }
    ((ArrayList)this.b.get(Long.valueOf(paramLong))).add(parambfuu);
  }
  
  protected void a(Entity paramEntity)
  {
    ThreadManager.excute(new TroopEssenceMsgManager.10(this, paramEntity), 32, null, true);
  }
  
  public void a(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    if (paramTroopEssenceMsgItem == null) {
      return;
    }
    this.jdField_a_of_type_Aoip.a(paramTroopEssenceMsgItem);
    QLog.i("TroopEssenceMsgManager", 1, "reqSetTroopEssenceMsg:" + paramTroopEssenceMsgItem.toString());
  }
  
  public void a(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg, boolean paramBoolean)
  {
    if (paramQQGroupDigestMsg == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.3(this, paramQQGroupDigestMsg, paramBoolean));
  }
  
  public boolean a(bful parambful)
  {
    if (parambful == null) {}
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return false;
        } while (b(parambful));
        localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(parambful.jdField_a_of_type_Long));
      } while (localHashMap == null);
      parambful = (bfum)localHashMap.get(parambful);
    } while (parambful == null);
    if (parambful.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b(bful parambful)
  {
    if ((HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(parambful.jdField_a_of_type_Long)) == null)
    {
      a(parambful.jdField_a_of_type_Long, new bfuq(this, parambful));
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.b.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfuo
 * JD-Core Version:    0.7.0.1
 */