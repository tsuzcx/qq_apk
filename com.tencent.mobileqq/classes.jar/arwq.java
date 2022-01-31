import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arwq
  implements Manager
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = alud.a(2131713841);
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString = alud.a(2131713842);
  private boolean jdField_c_of_type_Boolean;
  
  public arwq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_Boolean = bdne.B(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
  }
  
  public static arwq a(QQAppInterface paramQQAppInterface)
  {
    return (arwq)paramQQAppInterface.getManager(286);
  }
  
  private static ArrayList a(ArrayList<Integer> paramArrayList)
  {
    Object localObject = new LinkedHashSet();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LinkedHashSet)localObject).add(Integer.valueOf(((Integer)localIterator.next()).intValue()));
    }
    paramArrayList.clear();
    localObject = ((LinkedHashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayList.add(((Iterator)localObject).next());
    }
    return paramArrayList;
  }
  
  private void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = paramSharedPreferences.getString(paramString + "_" + "rich_text_chat_config_content", "");
    if (QLog.isColorLevel()) {
      QLog.d("RichTextChatManager", 2, "get content from sp:" + paramSharedPreferences);
    }
    if (!TextUtils.isEmpty(paramSharedPreferences)) {
      a(paramSharedPreferences);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(2));
    QLog.d("RichTextChatManager", 2, "updateHiBoomSwith: enable=" + bool);
    paramQQAppInterface = (assg)paramQQAppInterface.getManager(219);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(bool);
    }
  }
  
  private boolean a(String paramString)
  {
    label239:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_Int = paramString.optInt("first_insatll_entry", 0);
        if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= 5)) {
          this.jdField_a_of_type_Int = 0;
        }
        Object localObject1 = new ArrayList();
        Object localObject2 = paramString.optJSONArray("enrty_orders");
        int i;
        if (localObject2 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            int j = ((JSONArray)localObject2).getInt(i);
            if ((j < 0) || (j >= 5)) {
              break label239;
            }
            ((ArrayList)localObject1).add(Integer.valueOf(j));
            break label239;
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
        a(this.jdField_a_of_type_JavaUtilArrayList);
        localObject1 = paramString.optString("zhitu_title");
        localObject2 = paramString.optString("zhitu_legal_wording");
        if (paramString.optInt("zhitu_legal_switch") == 1)
        {
          bool = true;
          this.jdField_c_of_type_Boolean = bool;
          this.jdField_b_of_type_Int = paramString.optInt("zhitu_style", 0);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            this.jdField_b_of_type_JavaLangString = ((String)localObject1);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.jdField_c_of_type_JavaLangString = ((String)localObject2);
          }
          this.jdField_a_of_type_Boolean = true;
          return true;
        }
        boolean bool = false;
        continue;
        i += 1;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RichTextChatManager", 2, paramString, new Object[0]);
        }
        this.jdField_a_of_type_Boolean = true;
        return false;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList)
  {
    int j = bdne.aK(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("RichTextChatManager", 2, "last Memoried Tab:" + j);
    }
    int i;
    if (j == -1) {
      if (!bdne.A(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()))
      {
        i = paramArrayList.indexOf(Integer.valueOf(a(paramQQAppInterface)));
        bdne.r(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), true);
        if (QLog.isColorLevel()) {
          QLog.d("RichTextChatManager", 2, "Accourding to : selectedTab:" + j);
        }
        if (i == -1) {}
      }
    }
    do
    {
      return i;
      return 0;
      return 0;
      j = paramArrayList.indexOf(Integer.valueOf(j));
      if (QLog.isColorLevel()) {
        QLog.d("RichTextChatManager", 2, "Accourding to orderlist, currentTabPosition:" + j);
      }
      i = j;
    } while (-1 != j);
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime);
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public ArrayList<Integer> a(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime);
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Integer paramInteger, ConfigurationService.Config paramConfig)
  {
    int i = 0;
    int k = paramConfig.version.get();
    int j = bdne.aI(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = bdne.aJ(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int n = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("RichTextChatManager", 1, String.format("received richTextChat remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(n) }));
    }
    if (m != n) {
      bdne.Z(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), n);
    }
    for (;;)
    {
      if (k != i)
      {
        paramInteger = aozj.b(paramConfig, i, paramInteger.intValue());
        if (QLog.isColorLevel()) {
          QLog.d("RichTextChatManager", 1, "content:" + paramInteger);
        }
        if (TextUtils.isEmpty(paramInteger)) {
          break label218;
        }
        if (!a(paramInteger)) {
          break label202;
        }
        bdne.f(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), k, paramInteger);
        a(paramQQAppInterface);
      }
      label202:
      label218:
      while (!QLog.isColorLevel())
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("RichTextChatManager", 1, "config content parse error , do nothing");
        return;
      }
      QLog.d("RichTextChatManager", 1, "config content is null , do nothing");
      return;
      i = j;
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      String str = paramAppRuntime.getAccount();
      if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_JavaLangString.equals(str)))
      {
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramAppRuntime.getApplication());
        if (localSharedPreferences.contains(str + "_" + "rich_text_chat_config_version"))
        {
          a(localSharedPreferences, str);
          if ((paramAppRuntime instanceof QQAppInterface)) {
            a((QQAppInterface)paramAppRuntime);
          }
        }
        this.jdField_a_of_type_JavaLangString = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RichTextChatManager", 2, "first install entry:" + this.jdField_a_of_type_Int + " mOder:" + this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    bdne.s(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a(paramQQAppInterface).a(paramQQAppInterface);
    if (((ArrayList)localObject).size() <= 0) {
      return false;
    }
    FlashChatManager localFlashChatManager = (FlashChatManager)paramQQAppInterface.getManager(217);
    localObject = ((ArrayList)localObject).iterator();
    int k = 0;
    if (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      if (i == 1) {
        if (localFlashChatManager.a().size() > 0)
        {
          i = 1;
          label83:
          k = i | k;
        }
      }
    }
    for (;;)
    {
      break;
      int j = 0;
      break label83;
      if (j == 2)
      {
        assg.a(paramQQAppInterface);
        k = assg.b() | k;
      }
      else if (j == 0)
      {
        k |= 0x1;
      }
      else if (j == 3)
      {
        k = 1;
      }
      else if (j == 4)
      {
        k = 1;
        continue;
        return k;
      }
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime);
    boolean bool2;
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.iterator();
      boolean bool1 = false;
      bool2 = bool1;
      if (!paramAppRuntime.hasNext()) {
        break label50;
      }
      if (((Integer)paramAppRuntime.next()).intValue() != 0) {
        break label52;
      }
      bool1 = true;
    }
    label50:
    label52:
    for (;;)
    {
      break;
      bool2 = false;
      return bool2;
    }
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface)) && (this.jdField_b_of_type_Boolean);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwq
 * JD-Core Version:    0.7.0.1
 */