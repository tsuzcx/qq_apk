import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.updatesystem.db.entity.LocalFileMd5Entity;
import com.tencent.mobileqq.vas.updatesystem.db.entity.LocalUpdateEntity;
import com.tencent.mobileqq.vas.updatesystem.db.entity.ShouldUpdateEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IDbManager.ItemInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class bgkj
  implements IDbManager
{
  private bgkg jdField_a_of_type_Bgkg = new bgkg(a());
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_Bgkg.createEntityManager();
  
  private String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  private ArrayList<IDbManager.ItemInfo> a(int paramInt)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_" + paramInt, 0);
    if (localObject1 == null) {}
    do
    {
      return null;
      localObject2 = ((SharedPreferences)localObject1).getAll();
    } while ((localObject2 == null) || (((Map)localObject2).size() <= 0));
    localObject1 = new ArrayList();
    Object localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      IDbManager.ItemInfo localItemInfo = new IDbManager.ItemInfo();
      localItemInfo.itemId = ((String)localEntry.getKey());
      localItemInfo.content = ((String)localEntry.getValue());
      ((ArrayList)localObject1).add(localItemInfo);
      if (QLog.isColorLevel()) {
        QLog.d("VasUpdate_DbImpl", 2, "DBselectAllItems table = " + paramInt + " itemId = " + localItemInfo.itemId + " content = " + localItemInfo.content);
      }
    }
    return localObject1;
  }
  
  private void a(int paramInt)
  {
    Object localObject = a(paramInt);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IDbManager.ItemInfo localItemInfo = (IDbManager.ItemInfo)((Iterator)localObject).next();
        if (localItemInfo != null) {
          updateItem(paramInt, localItemInfo.itemId, localItemInfo.content);
        }
      }
    }
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    EntityManager localEntityManager = a();
    if (localEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        localEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        localEntityManager.close();
      }
    }
    do
    {
      return bool1;
      if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
        break;
      }
      bool1 = localEntityManager.update(paramEntity);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("VasUpdate_DbImpl", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public EntityManager a()
  {
    if (this.jdField_a_of_type_Bgkg == null) {
      this.jdField_a_of_type_Bgkg = new bgkg(a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_Bgkg.createEntityManager();
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_common", 0);
    a(0);
    a(1);
    a(2);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("isFirstMove", 1);
    ((SharedPreferences.Editor)localObject).commit();
    QLog.e("VasUpdate_DbImpl", 1, "removeDbData current consume = " + (System.currentTimeMillis() - l));
  }
  
  public void deleteItem(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_DbImpl", 2, "DBdeleteItem: table = " + paramInt + " itemId = " + paramString);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a().delete(LocalUpdateEntity.TABLE_NAME, "mItemId=?", new String[] { paramString });
      return;
    case 1: 
      a().delete(ShouldUpdateEntity.TABLE_NAME, "mItemId=?", new String[] { paramString });
      return;
    }
    a().delete(LocalFileMd5Entity.TABLE_NAME, "mItemId=?", new String[] { paramString });
  }
  
  public List<IDbManager.ItemInfo> selectAllItem(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_DbImpl", 2, "DBselectAllItems: table = " + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    switch (paramInt)
    {
    }
    while (QLog.isColorLevel())
    {
      Object localObject1 = localArrayList.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IDbManager.ItemInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          QLog.d("VasUpdate_DbImpl", 2, "DBselectAllItems table = " + paramInt + " itemId = " + ((IDbManager.ItemInfo)localObject2).itemId + " content = " + ((IDbManager.ItemInfo)localObject2).content);
        }
      }
      localObject1 = a().query(LocalUpdateEntity.class);
      if (localObject1 == null) {}
      IDbManager.ItemInfo localItemInfo;
      do
      {
        do
        {
          return null;
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (LocalUpdateEntity)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localItemInfo = new IDbManager.ItemInfo();
              localItemInfo.itemId = ((LocalUpdateEntity)localObject2).mItemId;
              localItemInfo.content = ((LocalUpdateEntity)localObject2).mContent;
              localArrayList.add(localItemInfo);
            }
          }
          localObject1 = a().query(ShouldUpdateEntity.class);
        } while (localObject1 == null);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ShouldUpdateEntity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localItemInfo = new IDbManager.ItemInfo();
            localItemInfo.itemId = ((ShouldUpdateEntity)localObject2).mItemId;
            localItemInfo.content = ((ShouldUpdateEntity)localObject2).mContent;
            localArrayList.add(localItemInfo);
          }
        }
        localObject1 = a().query(LocalFileMd5Entity.class);
      } while (localObject1 == null);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LocalFileMd5Entity)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localItemInfo = new IDbManager.ItemInfo();
          localItemInfo.itemId = ((LocalFileMd5Entity)localObject2).mItemId;
          localItemInfo.content = ((LocalFileMd5Entity)localObject2).mContent;
          localArrayList.add(localItemInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public String selectItem(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      paramString = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasUpdate_DbImpl", 2, "DBselectItem table = " + paramInt + " , result = " + paramString);
      }
      return paramString;
      paramString = a().query(LocalUpdateEntity.class, false, "mItemId=?", new String[] { paramString }, null, null, null, "1");
      if ((paramString == null) || (paramString.size() < 1) || (paramString.get(0) == null)) {
        break;
      }
      paramString = ((LocalUpdateEntity)paramString.get(0)).mContent;
      continue;
      paramString = a().query(ShouldUpdateEntity.class, false, "mItemId=?", new String[] { paramString }, null, null, null, "1");
      if ((paramString == null) || (paramString.size() < 1) || (paramString.get(0) == null)) {
        break;
      }
      paramString = ((ShouldUpdateEntity)paramString.get(0)).mContent;
      continue;
      paramString = a().query(LocalFileMd5Entity.class, false, "mItemId=?", new String[] { paramString }, null, null, null, "1");
      if ((paramString == null) || (paramString.size() < 1) || (paramString.get(0) == null)) {
        break;
      }
      paramString = ((LocalFileMd5Entity)paramString.get(0)).mContent;
      continue;
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_common", 0).getString(paramString, "");
    }
  }
  
  public void updateItem(int paramInt, String paramString1, String paramString2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_DbImpl", 2, "DBupdateItem: table = " + paramInt + " itemId = " + paramString1 + " content = " + paramString2);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!bool) {
        QLog.e("VasUpdate_DbImpl", 1, "DBupdateItem table = " + paramInt + " itemId = " + paramString1 + " content = " + paramString2 + " fail");
      }
      return;
      Object localObject = new LocalUpdateEntity();
      ((LocalUpdateEntity)localObject).mItemId = paramString1;
      ((LocalUpdateEntity)localObject).mContent = paramString2;
      bool = a((Entity)localObject);
      continue;
      localObject = new ShouldUpdateEntity();
      ((ShouldUpdateEntity)localObject).mItemId = paramString1;
      ((ShouldUpdateEntity)localObject).mContent = paramString2;
      bool = a((Entity)localObject);
      continue;
      localObject = new LocalFileMd5Entity();
      ((LocalFileMd5Entity)localObject).mItemId = paramString1;
      ((LocalFileMd5Entity)localObject).mContent = paramString2;
      bool = a((Entity)localObject);
      continue;
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_common", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      bool = ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkj
 * JD-Core Version:    0.7.0.1
 */