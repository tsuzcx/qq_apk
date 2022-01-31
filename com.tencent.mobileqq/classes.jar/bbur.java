import android.content.ContentValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

public class bbur
  extends amno
{
  public bbur(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private ContentValues a(awge paramawge)
  {
    ContentValues localContentValues = new ContentValues();
    List localList = awhf.a(paramawge.getClass());
    int j = localList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject1 = (Field)localList.get(i);
        String str = ((Field)localObject1).getName();
        if (!((Field)localObject1).isAccessible()) {
          ((Field)localObject1).setAccessible(true);
        }
        try
        {
          localObject1 = ((Field)localObject1).get(paramawge);
          if ((localObject1 instanceof Integer))
          {
            localContentValues.put(str, (Integer)localObject1);
            i += 1;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localIllegalArgumentException.printStackTrace();
            Object localObject2 = null;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
            Object localObject3 = null;
            continue;
            if ((localObject3 instanceof Long)) {
              localContentValues.put(str, (Long)localObject3);
            } else if ((localObject3 instanceof String)) {
              localContentValues.put(str, (String)localObject3);
            } else if ((localObject3 instanceof byte[])) {
              localContentValues.put(str, (byte[])localObject3);
            } else if ((localObject3 instanceof Short)) {
              localContentValues.put(str, (Short)localObject3);
            } else if ((localObject3 instanceof Boolean)) {
              localContentValues.put(str, (Boolean)localObject3);
            } else if ((localObject3 instanceof Double)) {
              localContentValues.put(str, (Double)localObject3);
            } else if ((localObject3 instanceof Float)) {
              localContentValues.put(str, (Float)localObject3);
            } else if ((localObject3 instanceof Byte)) {
              localContentValues.put(str, (Byte)localObject3);
            }
          }
        }
      }
    }
    return localContentValues;
  }
  
  public List<TroopFileTansferItemEntity> a(long paramLong)
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    TroopFileTansferItemEntity localTroopFileTansferItemEntity = new TroopFileTansferItemEntity();
    localTroopFileTansferItemEntity.troopuin = paramLong;
    return localawgf.a(TroopFileTansferItemEntity.class, "select * from " + localTroopFileTansferItemEntity.getTableName() + " where troopuin = ?", new String[] { "" + paramLong });
  }
  
  protected void a() {}
  
  public void a(long paramLong, UUID paramUUID)
  {
    if (paramUUID == null) {
      return;
    }
    bbvl.c("TroopFileDataBaseProxy", bbvl.a, "[" + paramUUID.toString() + "] deleteItem");
    Object localObject = new TroopFileTansferItemEntity();
    ((TroopFileTansferItemEntity)localObject).troopuin = paramLong;
    localObject = ((TroopFileTansferItemEntity)localObject).getTableName();
    String str = paramUUID.toString();
    paramUUID = new bbuu(this, paramUUID);
    a((String)localObject, "_sId=?", new String[] { str }, paramUUID);
  }
  
  public void a(TroopFileTansferItemEntity paramTroopFileTansferItemEntity)
  {
    if ((paramTroopFileTansferItemEntity == null) || (paramTroopFileTansferItemEntity.Id == null)) {
      return;
    }
    bbvl.c("TroopFileDataBaseProxy", bbvl.a, "[" + paramTroopFileTansferItemEntity.Id.toString() + "] updateItem transStatus[" + paramTroopFileTansferItemEntity.Status + "] FilePath[" + paramTroopFileTansferItemEntity.FilePath + "]");
    int i = paramTroopFileTansferItemEntity.Status;
    switch (paramTroopFileTansferItemEntity.Status)
    {
    }
    for (;;)
    {
      paramTroopFileTansferItemEntity.preupdate();
      ContentValues localContentValues = a(paramTroopFileTansferItemEntity);
      localContentValues.put("Status", Integer.valueOf(i));
      localContentValues.put("_sStatus", bbsb.a(i));
      String str1 = paramTroopFileTansferItemEntity.getTableName();
      String str2 = paramTroopFileTansferItemEntity.Id.toString();
      paramTroopFileTansferItemEntity = new bbut(this, paramTroopFileTansferItemEntity);
      a(str1, localContentValues, "_sId=?", new String[] { str2 }, paramTroopFileTansferItemEntity);
      return;
      i = 3;
      continue;
      i = 10;
    }
  }
  
  public void a(TroopFileTansferItemEntity paramTroopFileTansferItemEntity, amnx paramamnx)
  {
    bbvl.c("TroopFileDataBaseProxy", bbvl.a, "[" + paramTroopFileTansferItemEntity.Id.toString() + "] addItem status[" + paramTroopFileTansferItemEntity.getStatus() + "]");
    paramamnx = new bbus(this, paramTroopFileTansferItemEntity);
    if (paramTroopFileTansferItemEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramTroopFileTansferItemEntity.getTableName(), paramTroopFileTansferItemEntity, 0, paramamnx);
      return;
    }
    if (paramTroopFileTansferItemEntity.getStatus() == 1001)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramTroopFileTansferItemEntity.getTableName(), paramTroopFileTansferItemEntity, 1, paramamnx);
      return;
    }
    bbvl.a("TroopFileDataBaseProxy", bbvl.a, "Item status[" + String.valueOf(paramTroopFileTansferItemEntity.getStatus()) + "] is wrong");
  }
  
  protected void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, amnx paramamnx)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramamnx);
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, amnx paramamnx)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramamnx);
  }
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbur
 * JD-Core Version:    0.7.0.1
 */