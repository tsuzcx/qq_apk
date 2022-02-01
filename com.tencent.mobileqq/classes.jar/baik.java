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

public class baik
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
  
  public static List<baik> a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = baij.a(paramAppInfo);
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
            baik localbaik = new baik();
            localbaik.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
            localbaik.jdField_b_of_type_Int = ((JSONObject)localObject2).getInt("blue_bar_stat");
            localbaik.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("blue_content");
            localbaik.jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("blue_type");
            localbaik.jdField_a_of_type_JavaLangString = str;
            localbaik.jdField_a_of_type_Long = (((JSONObject)localObject2).getLong("duration") * 1000L);
            localbaik.c = ((JSONObject)localObject2).getString("blue_aid");
            localbaik.d = ((JSONObject)localObject2).getString("link");
            localbaik.e = ((JSONObject)localObject2).getString("blue_icon_url");
            localbaik.f = ((JSONObject)localObject2).getString("blue_button_text");
            localArrayList.add(localbaik);
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
    if ((paramConversation == null) || (paramConversation.jdField_a_of_type_Akyh.a(24) != 0)) {}
    SharedPreferences localSharedPreferences;
    MqqHandler localMqqHandler;
    do
    {
      return;
      localSharedPreferences = paramConversation.a().getSharedPreferences("mobileQQ", 0);
      localMqqHandler = paramConversation.jdField_a_of_type_Akyh.a();
    } while ((localMqqHandler == null) || ((baif)paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36) == null));
    paramConversation = new WeakReference(paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManager.getFileThreadHandler().post(new VipBannerInfo.2(paramConversation, localSharedPreferences, localMqqHandler));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, baih parambaih)
  {
    if (parambaih == null) {
      label4:
      return;
    } else {
      do
      {
        do
        {
          paramQQAppInterface = (baif)paramQQAppInterface.getManager(36);
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
    } while (!parambaih.a((baik)((Iterator)localObject).next()));
  }
  
  public static void b(Conversation paramConversation)
  {
    if ((paramConversation != null) && (paramConversation.jdField_a_of_type_Akyh.a(24) != 0))
    {
      paramConversation = paramConversation.jdField_a_of_type_Akyh.a();
      if (paramConversation != null)
      {
        paramConversation.removeMessages(9);
        paramConversation.sendEmptyMessage(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baik
 * JD-Core Version:    0.7.0.1
 */