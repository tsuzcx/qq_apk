import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class aoix
  implements Manager
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  protected SharedPreferences a;
  private aoeu jdField_a_of_type_Aoeu = new aoiy(this);
  private aofp jdField_a_of_type_Aofp;
  aojj jdField_a_of_type_Aojj;
  aojs jdField_a_of_type_Aojs;
  public aojt a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  private WeakReference<aoja> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean jdField_b_of_type_Boolean;
  
  public aoix(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aojt = new aoiz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoeu);
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSexTypeFromSp with null app");
      return 0;
    }
    Card localCard = ((ajxn)paramQQAppInterface.getManager(51)).a(paramQQAppInterface.getCurrentAccountUin());
    int i;
    if (localCard == null)
    {
      QLog.i("ExtendFriendLimitChatManager", 2, "获取自己的资料卡性别，缓存中未获取到，使用默认值随机");
      i = 0;
      return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("sp_match_sex_type", i);
    }
    if (localCard.shGender == 0) {
      i = 2;
    }
    for (;;)
    {
      QLog.i("ExtendFriendLimitChatManager", 2, "获取自己的资料卡性别，defaultSex:" + i);
      break;
      if (localCard.shGender == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static Boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSwitchOpenFromSp with null app");
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("sp_match_switch_type", false));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    QLog.i("ExtendFriendLimitChatManager", 2, "getMatchSexTypeFromSp : " + paramInt);
    if (paramQQAppInterface == null) {
      QLog.e("ExtendFriendLimitChatManager", 2, "setMatchSexTypeToSp with null app");
    }
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.putInt("sp_match_sex_type", paramInt).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ExtendFriendLimitChatManager", 2, "setMatchSwitchToSp with null app");
    }
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.putBoolean("sp_match_switch_type", paramBoolean.booleanValue()).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList<aogi> paramArrayList)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ExtendFriendLimitChatManager", 2, "setTaglistToSp with null app");
    }
    do
    {
      return;
      paramArrayList = aogi.a(paramArrayList);
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    } while ((paramArrayList == null) || (paramQQAppInterface == null));
    paramQQAppInterface.putString("sp_tagList", paramArrayList).apply();
  }
  
  private void d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null) {}
    do
    {
      return;
      Object localObject2;
      try
      {
        localObject1 = ((QQAppInterface)localObject1).a().a();
        Object localObject3 = ((aktg)localObject1).a(false);
        localObject2 = new ArrayList();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
            if ((localRecentUser.getType() == 1044) && (!localRecentUser.uin.equals(ajsf.aT))) {
              ((List)localObject2).add(localRecentUser);
            }
          }
          QLog.i("ExtendFriendLimitChatManager", 1, "[initLimitChatBox] toBeRemoved.size:" + ((List)localObject2).size());
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ExtendFriendLimitChatManager", 1, localThrowable, new Object[0]);
        return;
      }
      if (((List)localObject2).size() > 0)
      {
        long l = ((RecentUser)((List)localObject2).get(0)).lastmsgtime;
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localThrowable.b((RecentUser)((Iterator)localObject2).next());
        }
      }
    } while (this.jdField_a_of_type_AndroidContentSharedPreferences == null);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("init_matchchat_folder", false).commit();
  }
  
  public int a()
  {
    return a().a();
  }
  
  public aojj a()
  {
    if (this.jdField_a_of_type_Aojj != null) {
      return this.jdField_a_of_type_Aojj;
    }
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Aojj != null)
      {
        aojj localaojj1 = this.jdField_a_of_type_Aojj;
        return localaojj1;
      }
    }
    this.jdField_a_of_type_Aojj = new aojj(this);
    aojj localaojj2 = this.jdField_a_of_type_Aojj;
    return localaojj2;
  }
  
  public aojs a()
  {
    if (this.jdField_a_of_type_Aojs != null) {
      return this.jdField_a_of_type_Aojs;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Aojs != null)
      {
        aojs localaojs1 = this.jdField_a_of_type_Aojs;
        return localaojs1;
      }
    }
    this.jdField_a_of_type_Aojs = new aojs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aojs.a(this.jdField_a_of_type_Aojt);
    aojs localaojs2 = this.jdField_a_of_type_Aojs;
    return localaojs2;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Aofp != null) {
      return this.jdField_a_of_type_Aofp.b;
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aofp = null;
  }
  
  public void a(int paramInt)
  {
    a().b(101, paramInt);
  }
  
  public void a(aogi paramaogi)
  {
    int i = 1;
    if (paramaogi != null) {
      i = paramaogi.a;
    }
    a().b(102, i);
  }
  
  public void a(aoja paramaoja)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaoja);
  }
  
  public void a(boolean paramBoolean, aofo paramaofo)
  {
    QLog.i("ExtendFriendLimitChat", 2, "handleGetSquareStrangerList onGetMatchFeedInfo success = " + paramBoolean);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("init_matchchat_folder", true);
  }
  
  public void b()
  {
    a().a(103);
  }
  
  public void c()
  {
    QLog.i("ExtendFriendLimitChatManager", 1, "[initManager], threadId:" + Thread.currentThread().getId());
    if (a()) {
      d();
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aojs != null)
    {
      this.jdField_a_of_type_Aojs.b();
      this.jdField_a_of_type_Aojs = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoeu);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    this.jdField_a_of_type_Aofp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoix
 * JD-Core Version:    0.7.0.1
 */