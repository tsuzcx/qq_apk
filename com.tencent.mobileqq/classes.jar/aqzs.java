import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class aqzs
{
  private final SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(10);
  private final ConcurrentHashMap<String, CopyOnWriteArraySet<aqzu>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public aqzs()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(271, "batch_add_friend_for_troop_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(275, "confess_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(358, "contact_top_entry_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(372, "breaking_ice_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(326, "sosointerface_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(357, "register_invitation_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(330, "hiboom_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(296, "extend_friend_config_785");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(369, "account_logout_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(379, "qqsettingme_f2f_guide_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(378, "profile_btn_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(381, "profile_switch_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(401, "smart_devices_discovery_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(407, "hide_qq_xman");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(405, "add_contact_page_public_account_switch");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(408, "select_member_entry_switch");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(355, "troop_member_list_config");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      String str = (String)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new CopyOnWriteArraySet());
      i += 1;
    }
    a("qqsettingme_f2f_guide_config", new arag());
    a("smart_devices_discovery_config", new arah());
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return bhsi.a(BaseApplicationImpl.getApplication(), paramString1, paramString2);
  }
  
  private CopyOnWriteArraySet<aqzu> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfValue(paramString) < 0) {
      return null;
    }
    return (CopyOnWriteArraySet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
      QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "handleConfigFail [id: %s, tag: %s, isSuc: %s, result: %s]", new Object[] { Integer.valueOf(paramInt1), paramQQAppInterface, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    String str1 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (TextUtils.isEmpty(str1)) {
      if (QLog.isColorLevel()) {
        QLog.d("CfgProcess", 2, String.format(" handleConfig tag is null ! config: %s", new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    String str2;
    BaseApplication localBaseApplication;
    aqzt localaqzt;
    do
    {
      return;
      str2 = paramQQAppInterface.getCurrentAccountUin();
      localBaseApplication = paramQQAppInterface.getApp();
      localaqzt = new aqzt();
      localaqzt.jdField_b_of_type_Int = paramConfig.version.get();
      localaqzt.jdField_a_of_type_Int = bhsi.c(localBaseApplication, str2, str1);
      if (localaqzt.jdField_b_of_type_Int != localaqzt.jdField_a_of_type_Int) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CfgProcess", 2, new Object[] { " handleConfig config version is the same. [tag: %s, version: %s]", str1, Integer.valueOf(localaqzt.jdField_b_of_type_Int) });
    return;
    localaqzt.c = 0;
    if (paramConfig.msg_content_list.size() > 0)
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        break label367;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CfgProcess", 2, " handleConfig content is null !");
      }
      localaqzt.c = 1;
    }
    for (;;)
    {
      if (localaqzt.jdField_a_of_type_JavaLangString == null) {
        localaqzt.jdField_a_of_type_JavaLangString = "";
      }
      localaqzt.jdField_b_of_type_Boolean = true;
      localaqzt.jdField_a_of_type_Boolean = false;
      if (localaqzt.c == 0) {
        try
        {
          bhle.a(paramQQAppInterface, str1, localaqzt);
          if (!localaqzt.jdField_a_of_type_Boolean)
          {
            bhsi.a(localBaseApplication, str2, str1, localaqzt.jdField_a_of_type_JavaLangString);
            paramConfig = a(str1);
            if ((paramConfig == null) || (paramConfig.size() <= 0)) {
              break label579;
            }
            paramConfig = paramConfig.iterator();
            for (;;)
            {
              for (;;)
              {
                if (!paramConfig.hasNext()) {
                  break label579;
                }
                aqzu localaqzu = (aqzu)paramConfig.next();
                try
                {
                  localaqzu.a(paramQQAppInterface, paramInt, str1, localaqzt);
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                }
                if (QLog.isColorLevel())
                {
                  QLog.i("CfgProcess", 2, "handleConfig OnGetConfigListener fail:  " + str1);
                  continue;
                  label367:
                  if (paramConfig.compress.get() != 1) {
                    break label484;
                  }
                  paramConfig = azet.a(paramConfig.content.get().toByteArray());
                  if (paramConfig == null) {
                    break label460;
                  }
                  try
                  {
                    localaqzt.jdField_a_of_type_JavaLangString = new String(paramConfig, "UTF-8");
                  }
                  catch (Throwable paramConfig)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("CfgProcess", 2, " handleConfig Throwable:" + paramConfig.getMessage());
                    }
                    localaqzt.c = 2;
                  }
                }
              }
              break;
              label460:
              localaqzt.c = 3;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("CfgProcess", 2, " handleConfig inflateConfigString error!");
              break;
              label484:
              localaqzt.jdField_a_of_type_JavaLangString = paramConfig.content.get().toStringUtf8();
            }
          }
        }
        catch (Throwable paramConfig)
        {
          for (;;)
          {
            paramConfig.printStackTrace();
            if (QLog.isColorLevel())
            {
              QLog.i("CfgProcess", 2, "handleConfig call save individual fail:  " + str1);
              continue;
              if (QLog.isColorLevel()) {
                QLog.i("CfgProcess", 2, "handleConfig self save config tag: " + str1);
              }
            }
          }
        }
      }
    }
    label579:
    if (localaqzt.jdField_b_of_type_Boolean) {}
    for (int i = localaqzt.jdField_b_of_type_Int;; i = 0)
    {
      bhsi.c(localBaseApplication, str2, str1, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CfgProcess", 2, String.format(Locale.getDefault(), "handleConfigForTag  configId: %s, tag: %s, localVersion: %s, version: %s, result: %s, strContent: %s", new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(localaqzt.jdField_a_of_type_Int), Integer.valueOf(localaqzt.jdField_b_of_type_Int), Integer.valueOf(localaqzt.c), localaqzt.jdField_a_of_type_JavaLangString }));
      return;
    }
  }
  
  public void a(ConfigurationService.ConfigSeq paramConfigSeq, QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str1 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "initConfigVersion tag is null, configId: %s", new Object[] { Integer.valueOf(paramInt) }));
      }
      return;
    }
    String str2 = paramQQAppInterface.c();
    paramQQAppInterface = paramQQAppInterface.getApp();
    int i;
    if (bhsi.d(paramQQAppInterface, str2, str1) != AppSetting.a())
    {
      bhsi.d(paramQQAppInterface, str2, str1, AppSetting.a());
      bhsi.c(paramQQAppInterface, str2, str1, 0);
      paramConfigSeq.version.set(0);
      i = 0;
    }
    for (;;)
    {
      paramConfigSeq.compress.set(1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "initConfigVersion [id: %s, tag: %s, version: %s]", new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(i) }));
      return;
      i = bhsi.c(paramQQAppInterface, str2, str1);
      paramConfigSeq.version.set(i);
    }
  }
  
  public boolean a(aqzu paramaqzu)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((CopyOnWriteArraySet)localIterator.next()).remove(paramaqzu) | bool) {}
    return bool;
  }
  
  public boolean a(String paramString, aqzu paramaqzu)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = paramString.add(paramaqzu);
    }
    return bool;
  }
  
  public boolean b(String paramString, aqzu paramaqzu)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = paramString.remove(paramaqzu);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzs
 * JD-Core Version:    0.7.0.1
 */