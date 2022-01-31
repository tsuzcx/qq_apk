import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo.2;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class axhu
{
  public int a;
  public long a;
  public BusinessInfoCheckUpdate.AppInfo a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public static List<axhu> a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = axht.a(paramAppInfo);
    ArrayList localArrayList;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localArrayList = new ArrayList();
      try
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (JSONObject)((Map.Entry)localObject2).getValue();
          if ((str != null) && (localObject2 != null) && (((JSONObject)localObject2).has("blue_bar_stat")))
          {
            axhu localaxhu = new axhu();
            localaxhu.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
            localaxhu.jdField_b_of_type_Int = ((JSONObject)localObject2).getInt("blue_bar_stat");
            localaxhu.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("blue_content");
            localaxhu.jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("blue_type");
            localaxhu.jdField_a_of_type_JavaLangString = str;
            localaxhu.jdField_a_of_type_Long = (((JSONObject)localObject2).getLong("duration") * 1000L);
            localaxhu.c = ((JSONObject)localObject2).getString("blue_aid");
            localaxhu.d = ((JSONObject)localObject2).getString("link");
            localaxhu.e = ((JSONObject)localObject2).getString("blue_icon_url");
            localaxhu.f = ((JSONObject)localObject2).getString("blue_button_text");
            localArrayList.add(localaxhu);
            continue;
            return null;
          }
        }
      }
      catch (Exception paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public static void a(Conversation paramConversation)
  {
    if ((paramConversation == null) || (paramConversation.jdField_a_of_type_Ajbm.a(23) != 0)) {}
    SharedPreferences localSharedPreferences;
    MqqHandler localMqqHandler;
    do
    {
      return;
      localSharedPreferences = paramConversation.a().getSharedPreferences("mobileQQ", 0);
      localMqqHandler = paramConversation.jdField_a_of_type_Ajbm.a();
    } while ((localMqqHandler == null) || ((axho)paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36) == null));
    paramConversation = new WeakReference(paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManager.getFileThreadHandler().post(new VipBannerInfo.2(paramConversation, localSharedPreferences, localMqqHandler));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, axhq paramaxhq)
  {
    if (paramaxhq == null) {
      label4:
      return;
    } else {
      do
      {
        do
        {
          paramQQAppInterface = (axho)paramQQAppInterface.getManager(36);
        } while (paramQQAppInterface == null);
        paramQQAppInterface = paramQQAppInterface.b(3);
      } while (paramQQAppInterface == null);
    }
    Object localObject;
    label78:
    do
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      break label78;
      if (!paramQQAppInterface.hasNext()) {
        break label4;
      }
      localObject = a((BusinessInfoCheckUpdate.AppInfo)paramQQAppInterface.next());
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      localObject = ((List)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (!paramaxhq.a((axhu)((Iterator)localObject).next()));
  }
  
  public static void b(Conversation paramConversation)
  {
    if ((paramConversation != null) && (paramConversation.jdField_a_of_type_Ajbm.a(23) != 0))
    {
      paramConversation = paramConversation.jdField_a_of_type_Ajbm.a();
      if (paramConversation != null)
      {
        paramConversation.removeMessages(9);
        paramConversation.sendEmptyMessage(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axhu
 * JD-Core Version:    0.7.0.1
 */