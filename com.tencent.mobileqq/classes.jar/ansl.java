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

public class ansl
  implements Manager
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  protected SharedPreferences a;
  private anoj jdField_a_of_type_Anoj = new ansm(this);
  private anpe jdField_a_of_type_Anpe;
  ansx jdField_a_of_type_Ansx;
  antg jdField_a_of_type_Antg;
  public anth a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  private WeakReference<anso> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean jdField_b_of_type_Boolean;
  
  public ansl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Anth = new ansn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anoj);
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSexTypeFromSp with null app");
      return 0;
    }
    Card localCard = ((ajjj)paramQQAppInterface.getManager(51)).a(paramQQAppInterface.getCurrentAccountUin());
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
  
  private void e()
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
        Object localObject3 = ((akeu)localObject1).a(false);
        localObject2 = new ArrayList();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
            if ((localRecentUser.getType() == 1044) && (!localRecentUser.uin.equals(ajed.aS))) {
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
  
  public ansx a()
  {
    if (this.jdField_a_of_type_Ansx != null) {
      return this.jdField_a_of_type_Ansx;
    }
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Ansx != null)
      {
        ansx localansx1 = this.jdField_a_of_type_Ansx;
        return localansx1;
      }
    }
    this.jdField_a_of_type_Ansx = new ansx(this);
    ansx localansx2 = this.jdField_a_of_type_Ansx;
    return localansx2;
  }
  
  public antg a()
  {
    if (this.jdField_a_of_type_Antg != null) {
      return this.jdField_a_of_type_Antg;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Antg != null)
      {
        antg localantg1 = this.jdField_a_of_type_Antg;
        return localantg1;
      }
    }
    this.jdField_a_of_type_Antg = new antg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Antg.a(this.jdField_a_of_type_Anth);
    antg localantg2 = this.jdField_a_of_type_Antg;
    return localantg2;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Anpe != null) {
      return this.jdField_a_of_type_Anpe.b;
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Anpe = null;
  }
  
  public void a(int paramInt)
  {
    a().a(101, paramInt);
  }
  
  public void a(anpe paramanpe)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    if (localEditor != null)
    {
      String str = anpe.a(paramanpe);
      paramanpe = str;
      if (str == null) {
        paramanpe = "";
      }
      localEditor.putString("pref_extend_friend_limit_chat_last_match_info", paramanpe).apply();
    }
  }
  
  public void a(anso paramanso)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanso);
  }
  
  public void a(boolean paramBoolean, anpd paramanpd)
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
    a().b(102);
    if (this.jdField_a_of_type_Boolean)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
      if (localEditor != null) {
        localEditor.putBoolean("pref_extend_friend_limit_chat_is_first_enter", false).apply();
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void c()
  {
    a().b(103);
  }
  
  public void d()
  {
    QLog.i("ExtendFriendLimitChatManager", 1, "[initManager], threadId:" + Thread.currentThread().getId());
    if (a()) {
      e();
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Antg != null)
    {
      this.jdField_a_of_type_Antg.c();
      this.jdField_a_of_type_Antg = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anoj);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    this.jdField_a_of_type_Anpe = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ansl
 * JD-Core Version:    0.7.0.1
 */