import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
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

public class atag
  implements Manager
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  protected SharedPreferences a;
  private asvt jdField_a_of_type_Asvt = new atah(this);
  private aswv jdField_a_of_type_Aswv;
  atba jdField_a_of_type_Atba;
  atbk jdField_a_of_type_Atbk;
  public atbl a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  private WeakReference<atal> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  public atag(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Atbl = new atai(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asvt);
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSexTypeFromSp with null app");
      return 0;
    }
    Card localCard = ((anyw)paramQQAppInterface.getManager(51)).a(paramQQAppInterface.getCurrentAccountUin());
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
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList<asxk> paramArrayList)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ExtendFriendLimitChatManager", 2, "setTaglistToSp with null app");
    }
    do
    {
      return;
      paramArrayList = asxk.a(paramArrayList);
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    } while ((paramArrayList == null) || (paramQQAppInterface == null));
    paramQQAppInterface.putString("sp_tagList", paramArrayList).apply();
  }
  
  public static Boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSwitchFlagFromSp with null app");
      return Boolean.valueOf(false);
    }
    paramQQAppInterface = Boolean.valueOf(paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("sp_voice_match_switch_flag", false));
    QLog.d("ExtendFriendLimitChatManager", 2, "getVoiceMatch " + paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ExtendFriendLimitChatManager", 2, "setVoiceMatchSwitchFlagToSp with null app");
    }
    do
    {
      return;
      QLog.d("ExtendFriendLimitChatManager", 2, "setVoiceMatch " + paramBoolean);
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.putBoolean("sp_voice_match_switch_flag", paramBoolean.booleanValue()).apply();
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
        Object localObject3 = ((apaw)localObject1).getRecentList(false);
        localObject2 = new ArrayList();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
            if ((localRecentUser.getType() == 1044) && (!localRecentUser.uin.equals(antf.aT))) {
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
          localThrowable.delRecentUser((RecentUser)((Iterator)localObject2).next());
        }
      }
    } while (this.jdField_a_of_type_AndroidContentSharedPreferences == null);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("init_matchchat_folder", false).commit();
  }
  
  public int a()
  {
    return a().a();
  }
  
  public atba a()
  {
    if (this.jdField_a_of_type_Atba != null) {
      return this.jdField_a_of_type_Atba;
    }
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Atba != null)
      {
        atba localatba1 = this.jdField_a_of_type_Atba;
        return localatba1;
      }
    }
    this.jdField_a_of_type_Atba = new atba(this);
    atba localatba2 = this.jdField_a_of_type_Atba;
    return localatba2;
  }
  
  public atbk a()
  {
    if (this.jdField_a_of_type_Atbk != null) {
      return this.jdField_a_of_type_Atbk;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Atbk != null)
      {
        atbk localatbk1 = this.jdField_a_of_type_Atbk;
        return localatbk1;
      }
    }
    this.jdField_a_of_type_Atbk = new atbk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Atbk.a(this.jdField_a_of_type_Atbl);
    atbk localatbk2 = this.jdField_a_of_type_Atbk;
    return localatbk2;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Aswv != null) {
      return this.jdField_a_of_type_Aswv.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aswv = null;
  }
  
  public void a(int paramInt)
  {
    a().b(101, paramInt);
  }
  
  public void a(asxk paramasxk)
  {
    int i = 1;
    if (paramasxk != null) {
      i = paramasxk.a;
    }
    a().b(102, i);
  }
  
  public void a(atal paramatal)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramatal);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, aswu paramaswu)
  {
    QLog.i("ExtendFriendLimitChat", 2, "handleGetSquareStrangerList onGetMatchFeedInfo success = " + paramBoolean);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("init_matchchat_folder", true);
  }
  
  public boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendLimitChatManager", 2, "showRealNameAuthDialog");
    }
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131698311);
      }
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = paramContext.getString(2131698309);
      }
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        this.jdField_d_of_type_JavaLangString = "https://ti.qq.com/realname/index.html";
      }
      paramContext = bhlq.a(paramContext, 230, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramContext.getString(2131698310), paramContext.getString(2131698312), new ataj(this, paramContext), new atak(this));
      paramContext.setCancelable(false);
      paramContext.show();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    a().a(103);
  }
  
  public Boolean c(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface != null)
    {
      bool = b(paramQQAppInterface).booleanValue();
      if (!bool) {
        break label69;
      }
      paramQQAppInterface = (asvi)paramQQAppInterface.getManager(264);
      if (paramQQAppInterface == null) {
        break label81;
      }
      bool = paramQQAppInterface.h();
    }
    label69:
    label81:
    for (;;)
    {
      QLog.d("ExtendFriendLimitChatManager", 2, "is voiceMatch ShowToUser " + bool);
      return Boolean.valueOf(bool);
      QLog.d("ExtendFriendLimitChatManager", 2, "is voiceMatchShowToUser xinyong not enough  ");
    }
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
    if (this.jdField_a_of_type_Atbk != null)
    {
      this.jdField_a_of_type_Atbk.b();
      this.jdField_a_of_type_Atbk = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asvt);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    this.jdField_a_of_type_Aswv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atag
 * JD-Core Version:    0.7.0.1
 */