import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem.MsgInfo;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.6;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.8;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg;

public class bfle
  extends Observable
  implements Manager
{
  private bfkt jdField_a_of_type_Bfkt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private HashMap<Long, ImportantMsgItem> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ConcurrentHashMap<Long, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bfle(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_Bfkt = new bflf(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bfkt);
  }
  
  private void a(long paramLong)
  {
    ImportantMsgItem localImportantMsgItem = (ImportantMsgItem)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localImportantMsgItem != null)
    {
      setChanged();
      notifyObservers(localImportantMsgItem);
    }
  }
  
  private void a(long paramLong, ArrayList<Long> paramArrayList)
  {
    a(paramLong, paramArrayList, 2);
  }
  
  private void a(long paramLong, ArrayList<ImportantMsgItem.MsgInfo> paramArrayList, List<Long> paramList)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      QLog.i("ImportantMsgManager", 1, "handlerRspImportantMsg mImportantDataMap notcontains troopUin:" + paramLong);
      return;
    }
    paramList = (ImportantMsgItem)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      paramList.addMsgInfos(paramArrayList);
    }
    paramList.updateMaxMsgSeq();
    QLog.i("ImportantMsgManager", 1, "handlerRspImportantMsg reciveMaxSeq:" + paramList.maxImportantMsgSeq + " registerProxy lastSeq:" + a(paramLong));
    a(paramList.clone());
    a(paramLong);
  }
  
  private void a(long paramLong, boolean paramBoolean, List<oidb_0xea3.BackMsg> paramList, List<Long> paramList1)
  {
    if (!paramBoolean) {
      return;
    }
    a(paramLong, paramList, paramList1);
  }
  
  private void a(HashMap<Long, Integer> paramHashMap)
  {
    setChanged();
    notifyObservers(paramHashMap);
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
  
  private void b(long paramLong, ArrayList<ImportantMsgItem.MsgInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    a(paramLong, new bflh(this, paramArrayList));
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).intValue();
    }
    return 0;
  }
  
  public ImportantMsgItem a(long paramLong)
  {
    ImportantMsgItem localImportantMsgItem = new ImportantMsgItem();
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ImportantMsgItem.class, false, "troopUin=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (ImportantMsgItem)((List)localObject).get(0);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ImportantMsgManager", 1, "readEntity exception + " + localException.getMessage(), localException);
      localImportantMsgItem.troopUin = paramLong;
    }
    return localImportantMsgItem;
  }
  
  public void a(long paramLong, bfli parambfli)
  {
    if (parambfli == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      parambfli.a(paramLong, (ImportantMsgItem)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)));
      return;
    }
    ThreadManager.post(new ImportantMsgManager.6(this, paramLong, parambfli), 5, null, false);
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList, int paramInt)
  {
    ((bfle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(375)).a(paramLong, new bflg(this, paramArrayList, paramInt));
  }
  
  public void a(long paramLong, List<oidb_0xea3.BackMsg> paramList, List<Long> paramList1)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_0xea3.BackMsg localBackMsg = (oidb_0xea3.BackMsg)paramList.next();
        ArrayList localArrayList2 = new ArrayList();
        bflj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBackMsg, localArrayList2);
        if (!localArrayList2.isEmpty()) {
          localArrayList1.add(localArrayList2.get(0));
        }
      }
    }
    a(paramLong, bflj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, localArrayList1, true), paramList1);
  }
  
  protected void a(Entity paramEntity)
  {
    ThreadManager.post(new ImportantMsgManager.8(this, paramEntity), 5, null, false);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bfkt != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bfkt);
      this.jdField_a_of_type_Bfkt = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfle
 * JD-Core Version:    0.7.0.1
 */