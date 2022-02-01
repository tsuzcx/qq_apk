import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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

public class bflc
  implements Manager
{
  protected aoep a;
  protected aofu a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public ArrayList<bflb> a;
  public HashMap<Long, HashMap<bfkz, bfla>> a;
  public HashMap<Long, ArrayList<bfli>> b = new HashMap();
  
  public bflc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Aofu = new bfld(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_Aoep = ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
  }
  
  private BaseChatPie a(long paramLong)
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Object localObject = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject != null) && ((localObject instanceof afzn)) && (((BaseChatPie)localObject).getCurrentAIOState() >= 2))
        {
          String str = ((BaseChatPie)localObject).getCurFriendUin();
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
      localBaseChatPie.refresh(131072);
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
      str = BaseApplicationImpl.getContext().getResources().getString(2131719543);
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
  
  private void a(bflb parambflb)
  {
    if ((parambflb == null) || (parambflb.a == null)) {
      return;
    }
    a(parambflb.a.troopUin, new bflf(this, parambflb));
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
  
  private boolean a(bflb parambflb)
  {
    if ((parambflb == null) || (parambflb.a == null)) {
      return false;
    }
    Object localObject = new bfkz(parambflb.a.troopUin, parambflb.a.msgSeq, parambflb.a.msgRandom);
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((bfkz)localObject).jdField_a_of_type_Long));
    if (localHashMap != null)
    {
      localObject = (bfla)localHashMap.get(localObject);
      return (localObject == null) || (((bfla)localObject).jdField_a_of_type_Long < parambflb.a.opTime);
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
  
  private void b(bflb parambflb)
  {
    if ((parambflb == null) || (parambflb.a == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        parambflb = new bfkz(parambflb.a.troopUin, parambflb.a.msgSeq, parambflb.a.msgRandom);
        localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(parambflb.jdField_a_of_type_Long));
      } while (localObject == null);
      localObject = (bfla)((HashMap)localObject).get(parambflb);
    } while ((localObject == null) || (((bfla)localObject).b == 0L));
    a(parambflb.jdField_a_of_type_Long, ((bfla)localObject).b);
  }
  
  private void b(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    a(paramTroopEssenceMsgItem.troopUin, new bflg(this, paramTroopEssenceMsgItem));
  }
  
  private void b(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg, boolean paramBoolean)
  {
    paramQQGroupDigestMsg = bflj.a(paramQQGroupDigestMsg);
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
    a(paramTroopEssenceMsgItem.troopUin, new bflh(this, paramTroopEssenceMsgItem));
  }
  
  public bfla a(bfkz parambfkz)
  {
    if (parambfkz == null) {
      return null;
    }
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(parambfkz.jdField_a_of_type_Long));
    if (localHashMap == null) {
      return null;
    }
    return (bfla)localHashMap.get(parambfkz);
  }
  
  public HashMap<bfkz, bfla> a(long paramLong)
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
          localHashMap.put(new bfkz(localTroopEssenceMsgItem.troopUin, localTroopEssenceMsgItem.msgSeq, localTroopEssenceMsgItem.msgRandom), new bfla(localTroopEssenceMsgItem.opType, localTroopEssenceMsgItem.msgSenderUin, localTroopEssenceMsgItem.opUin, localTroopEssenceMsgItem.opTime, localTroopEssenceMsgItem.graytipuniseq));
        }
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      QLog.e("TroopEssenceMsgManager", 1, "readEntity exception + " + localException.getMessage(), localException);
    }
  }
  
  public void a(long paramLong, bfli parambfli)
  {
    if (parambfli == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      parambfli.a(paramLong, (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)));
      return;
    }
    if (!this.b.containsKey(Long.valueOf(paramLong)))
    {
      this.b.put(Long.valueOf(paramLong), new ArrayList(Arrays.asList(new bfli[] { parambfli })));
      ThreadManager.excute(new TroopEssenceMsgManager.9(this, paramLong), 32, null, true);
      return;
    }
    ((ArrayList)this.b.get(Long.valueOf(paramLong))).add(parambfli);
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
    this.jdField_a_of_type_Aoep.a(paramTroopEssenceMsgItem);
    QLog.i("TroopEssenceMsgManager", 1, "reqSetTroopEssenceMsg:" + paramTroopEssenceMsgItem.toString());
  }
  
  public void a(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg, boolean paramBoolean)
  {
    if (paramQQGroupDigestMsg == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.3(this, paramQQGroupDigestMsg, paramBoolean));
  }
  
  public boolean a(bfkz parambfkz)
  {
    if (parambfkz == null) {}
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return false;
        } while (b(parambfkz));
        localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(parambfkz.jdField_a_of_type_Long));
      } while (localHashMap == null);
      parambfkz = (bfla)localHashMap.get(parambfkz);
    } while (parambfkz == null);
    if (parambfkz.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b(bfkz parambfkz)
  {
    if ((HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(parambfkz.jdField_a_of_type_Long)) == null)
    {
      a(parambfkz.jdField_a_of_type_Long, new bfle(this, parambfkz));
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.b.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflc
 * JD-Core Version:    0.7.0.1
 */