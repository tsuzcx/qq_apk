import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class aopm
  implements Manager
{
  private long jdField_a_of_type_Long = -1L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, aopo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private long jdField_b_of_type_Long = -1L;
  private ConcurrentHashMap<String, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public aopm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(0);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(0);
    a();
  }
  
  private void c(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(5, paramString, 0);
    int j;
    int i;
    if ((localObject1 != null) && (((Pair)localObject1).second != null))
    {
      localObject1 = (Setting)((Pair)localObject1).second;
      j = ((Setting)localObject1).systemHeadID;
      i = ((Setting)localObject1).bHeadType;
    }
    for (;;)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle handleUpdateStrangerHeadReal uin=" + paramString + ",localHeadID=" + j + ",localType=" + i);
        localObject1 = new StringBuilder(1000);
        localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(" QQ 18 handle mHeadIdMap: uin=");
          ((StringBuilder)localObject1).append((String)localEntry.getKey());
          ((StringBuilder)localObject1).append(",headid=");
          ((StringBuilder)localObject1).append(((aopo)localEntry.getValue()).jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append(",type=");
          ((StringBuilder)localObject1).append(((aopo)localEntry.getValue()).b);
          ((StringBuilder)localObject1).append(",isRequest=");
          ((StringBuilder)localObject1).append(((aopo)localEntry.getValue()).jdField_a_of_type_Boolean);
          ((StringBuilder)localObject1).append(",saveTime=");
          ((StringBuilder)localObject1).append(((aopo)localEntry.getValue()).jdField_a_of_type_Long);
          ((StringBuilder)localObject1).append("\n");
          QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        localObject1 = (aopo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (localObject1 != null)
        {
          int k = ((aopo)localObject1).jdField_a_of_type_Int;
          int m = ((aopo)localObject1).b;
          if (((m == 0) && (k != j)) || ((m != i) && (!((aopo)localObject1).jdField_a_of_type_Boolean)))
          {
            ((aopo)localObject1).jdField_a_of_type_Boolean = true;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder(1000);
              ((StringBuilder)localObject2).append("QQ 18 get and update stranger update head uin = ");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(",receiveSysid = ");
              ((StringBuilder)localObject2).append(k);
              ((StringBuilder)localObject2).append(",receiveType = ");
              ((StringBuilder)localObject2).append(m);
              ((StringBuilder)localObject2).append(",localSysid = ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(",loaclType = ");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append("\n");
              QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject2).toString());
            }
            ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).c(paramString);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
          }
          if ((k == j) && (m == i) && (((aopo)localObject1).jdField_a_of_type_Boolean))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ClassicHeadActivityManager", 4, " QQ 18 remove update map uin = " + paramString + ",receiveSysid = " + k + ",localSysid = " + j);
            }
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
          }
        }
      }
      return;
      i = 0;
      j = 0;
    }
  }
  
  public long a()
  {
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong("classic_head_activity_switch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), -1L);
    if (QLog.isColorLevel()) {
      QLog.d("ClassicHeadActivityManager", 2, "getSwitch key=classic_head_activity_switch value= " + l);
    }
    return l;
  }
  
  public Setting a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, (String)localObject, 0);
    if ((localObject != null) && (((Pair)localObject).second != null)) {
      return (Setting)((Pair)localObject).second;
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = bgsg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length == 2))
      {
        this.jdField_a_of_type_Long = apsi.a(localObject[0]);
        this.jdField_b_of_type_Long = apsi.a(localObject[1]);
        if (QLog.isColorLevel()) {
          QLog.d("ClassicHeadActivityManager", 2, "parseClassicHeadActivityConfig success");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassicHeadActivityManager", 2, "parseClassicHeadActivityConfig beginTime=" + this.jdField_a_of_type_Long + " endTime=" + this.jdField_b_of_type_Long);
    }
  }
  
  public void a(long paramLong)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    long l = a();
    if (l != paramLong)
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
      localEditor.putLong("classic_head_activity_switch_" + str, paramLong);
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, "save Switch Success");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassicHeadActivityManager", 2, "qq18Switch=" + paramLong + " localSwitch=" + l);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() == null)) {}
    for (;;)
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder("handleInitValue");
      localStringBuilder.append(" sysId=").append(paramLong1);
      localStringBuilder.append(" headType=").append(paramLong2);
      localStringBuilder.append(" qq18Switch=").append(paramLong3);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      a(paramLong3);
      if (paramLong3 == 1L)
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, str, 0);
        if ((localObject != null) && (((Boolean)((Pair)localObject).first).booleanValue()))
        {
          localFriendListHandler.c(str);
          localFriendListHandler.notifyUI(3, true, str);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("ClassicHeadActivityManager", 2, localStringBuilder.toString());
          return;
          if ((localObject != null) && (((Pair)localObject).second != null))
          {
            localObject = (Setting)((Pair)localObject).second;
            paramLong3 = ((Setting)localObject).systemHeadID;
            long l = ((Setting)localObject).bHeadType;
            localStringBuilder.append(" localSysId=").append(paramLong3);
            localStringBuilder.append(" localheadType=").append(l);
            if ((paramLong2 != l) || ((paramLong2 == 0L) && (paramLong1 != paramLong3)))
            {
              localStringBuilder.append(" fetch userHead");
              localFriendListHandler.c(str);
              localFriendListHandler.notifyUI(3, true, str);
            }
          }
        }
      }
    }
  }
  
  public void a(aopn paramaopn)
  {
    StringBuilder localStringBuilder;
    FriendListHandler localFriendListHandler;
    Object localObject;
    if ((a()) && (paramaopn != null))
    {
      localStringBuilder = new StringBuilder("handleFriendHeadFlagItem");
      localStringBuilder.append(" uin=").append(bgsp.e(paramaopn.jdField_a_of_type_JavaLangString));
      localStringBuilder.append(" sysId=").append(paramaopn.jdField_b_of_type_Long);
      localStringBuilder.append(" headType=").append(paramaopn.c);
      localStringBuilder.append(" qq18Switch=").append(paramaopn.jdField_a_of_type_Long);
      if ((!TextUtils.isEmpty(paramaopn.jdField_a_of_type_JavaLangString)) && (paramaopn.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramaopn.jdField_a_of_type_Long != -1L)) {
        a(paramaopn.jdField_a_of_type_Long);
      }
      localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramaopn.jdField_a_of_type_JavaLangString, 0);
      if ((localObject == null) || (!((Boolean)((Pair)localObject).first).booleanValue())) {
        break label221;
      }
      localFriendListHandler.c(paramaopn.jdField_a_of_type_JavaLangString);
      localFriendListHandler.notifyUI(3, true, paramaopn.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, localStringBuilder.toString());
      }
      return;
      label221:
      if ((localObject != null) && (((Pair)localObject).second != null))
      {
        localObject = (Setting)((Pair)localObject).second;
        long l1 = ((Setting)localObject).systemHeadID;
        long l2 = ((Setting)localObject).bHeadType;
        localStringBuilder.append(" localsysId=").append(l1);
        localStringBuilder.append(" localheadType=").append(l2);
        if (((paramaopn.jdField_a_of_type_Long == 1L) && (paramaopn.c != -1L) && (paramaopn.c != l2)) || ((paramaopn.jdField_b_of_type_Long != -1L) && (paramaopn.jdField_b_of_type_Long != l1) && (l2 == 0L)))
        {
          localStringBuilder.append(" fetch userHead");
          localFriendListHandler.c(paramaopn.jdField_a_of_type_JavaLangString);
          localFriendListHandler.notifyUI(3, true, paramaopn.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)))
    {
      aopo localaopo = (aopo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localaopo != null) && (localaopo.jdField_a_of_type_Boolean))
      {
        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle handleGetHeadError uin=" + paramString + ",HeadID=" + localaopo.jdField_a_of_type_Int + ",Type=" + localaopo.b + ",IsRequest=" + localaopo.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject;
    int j;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(5, paramString, 0);
      if ((localObject == null) || (((Pair)localObject).second == null)) {
        break label350;
      }
      localObject = (Setting)((Pair)localObject).second;
      j = ((Setting)localObject).systemHeadID;
      i = ((Setting)localObject).bHeadType;
    }
    for (;;)
    {
      if ((paramInt1 == j) && (paramInt2 == i)) {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("ClassicHeadActivityManager", 2, " QQ 18 saveReceiveSysHeadId found same, remove uin=" + paramString + ", syid=" + paramInt1 + ",headType=" + paramInt2);
          }
        }
      }
      do
      {
        do
        {
          aopo localaopo;
          do
          {
            do
            {
              return;
              localObject = new aopo(paramString, paramInt1, paramInt2);
              if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
                break;
              }
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
            } while (!QLog.isColorLevel());
            QLog.d("ClassicHeadActivityManager", 2, " QQ 18 saveReceiveSysHeadId save uin=" + paramString + ", syid=" + paramInt1 + ",headType=" + paramInt2);
            return;
            localaopo = (aopo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          } while (localaopo == null);
          i = localaopo.jdField_a_of_type_Int;
          j = localaopo.b;
        } while (((paramInt2 != 0) || (paramInt1 == i)) && (j == paramInt2));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
      } while (!QLog.isColorLevel());
      QLog.d("ClassicHeadActivityManager", 2, " QQ 18 saveReceiveSysHeadId save uin=" + paramString + ", syid=" + paramInt1 + ",headType=" + paramInt2);
      return;
      label350:
      j = 0;
    }
  }
  
  public boolean a()
  {
    long l = bbyp.a() * 1000L;
    if ((this.jdField_a_of_type_Long != -1L) && (this.jdField_b_of_type_Long != -1L) && (l > this.jdField_a_of_type_Long) && (l < this.jdField_b_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, "ClassicHeadActivityActivate is activate");
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle actionB cached stranger head uin = " + (String)localEntry.getKey());
        }
        c((String)localEntry.getKey());
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle actionB cached stranger head update finished");
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handleUpdateStrangerHead strangerUin = " + paramString);
          }
          String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          if (!str.equals(paramString)) {
            break;
          }
          if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
          }
        } while (!QLog.isColorLevel());
        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handleUpdateStrangerHead remove current user ");
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b())) {
          break;
        }
      } while ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)));
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, "");
      return;
    } while ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 0));
    c(paramString);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopm
 * JD-Core Version:    0.7.0.1
 */