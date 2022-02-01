import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mini.util.JSONUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bakq
{
  private static bale a;
  
  private long a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.getRecentUserProxy();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (RecentUser)paramQQAppInterface.findRecentUser(paramString, paramInt);
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.lastmsgtime;
        }
      }
    }
    return 0L;
  }
  
  private bale a()
  {
    if (a == null)
    {
      a = a(BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).getString("FriendSort", ""));
      if (a == null) {
        a = new bale();
      }
    }
    return a;
  }
  
  public static bale a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (JSONUtil.isJson(paramString))) {
      try
      {
        paramString = new JSONObject(paramString);
        bale localbale = new bale();
        localbale.jdField_a_of_type_Float = Float.valueOf(paramString.getString("recognitionWeight")).floatValue();
        localbale.b = Float.valueOf(paramString.getString("messageTime")).floatValue();
        localbale.c = Float.valueOf(paramString.getString("topFriend")).floatValue();
        localbale.d = Float.valueOf(paramString.getString("careFriend")).floatValue();
        a = localbale;
        return localbale;
      }
      catch (JSONException paramString)
      {
        bakl.a("FriendSortHelper", "parseContent exception :" + paramString.getMessage());
        return null;
      }
      catch (Exception paramString)
      {
        bakl.a("FriendSortHelper", "parseContent exception :" + paramString.getMessage());
        return null;
      }
    }
    return null;
  }
  
  private List<bald> a(List<bald> paramList)
  {
    int j = 0;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      bakl.a("FriendSortHelper", "computeRecentTimeWeight friendInfoList is null");
      localObject = null;
      return localObject;
    }
    Collections.sort(paramList, new bakp(2));
    Object localObject = paramList.iterator();
    int i = 0;
    label50:
    if (((Iterator)localObject).hasNext())
    {
      if (((bald)((Iterator)localObject).next()).jdField_a_of_type_Long <= 0L) {
        break label171;
      }
      i += 1;
    }
    label171:
    for (;;)
    {
      break label50;
      int k = i + 1;
      int m = paramList.size();
      i = j;
      localObject = paramList;
      if (i >= m) {
        break;
      }
      localObject = (bald)paramList.get(i);
      j = k - i - 1;
      if ((((bald)localObject).jdField_a_of_type_Long > 0L) && (j > 0)) {}
      for (((bald)localObject).b = (j * 1.0F / k);; ((bald)localObject).b = 0.0F)
      {
        i += 1;
        break;
      }
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString);
      return (paramQQAppInterface != null) && (paramQQAppInterface.globalSwitch == 1);
    }
    return false;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.getRecentUserProxy();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (RecentUser)paramQQAppInterface.findRecentUser(paramString, paramInt);
        return (paramQQAppInterface != null) && (paramQQAppInterface.showUpTime > 0L);
      }
    }
    return false;
  }
  
  private List<bald> b(QQAppInterface paramQQAppInterface, List<bald> paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramList.isEmpty()))
    {
      bakl.a("FriendSortHelper", "computeFriendScore friendInfoList is null");
      return null;
    }
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      bald localbald = (bald)localIterator.next();
      if ((localbald.jdField_a_of_type_Int == 0) && (a(paramQQAppInterface, localbald.jdField_a_of_type_JavaLangString)))
      {
        i = 1;
        label79:
        localbald.d = i;
        if (!a(paramQQAppInterface, localbald.jdField_a_of_type_JavaLangString, localbald.jdField_a_of_type_Int)) {
          break label141;
        }
      }
      label141:
      for (int i = 1;; i = 0)
      {
        localbald.c = i;
        localbald.jdField_a_of_type_Long = a(paramQQAppInterface, localbald.jdField_a_of_type_JavaLangString, localbald.jdField_a_of_type_Int);
        break;
        i = 0;
        break label79;
      }
    }
    a(paramList);
    return b(paramList);
  }
  
  private List<bald> b(List<bald> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      bakl.a("FriendSortHelper", "computeTotalScore friendInfoList is null");
      localObject = null;
      return localObject;
    }
    bale localbale = a();
    if (localbale == null)
    {
      bakl.a("FriendSortHelper", "computeTotalScore sortConfig is null");
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      localObject = paramList;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (bald)localIterator.next();
      ((bald)localObject).e = (localbale.jdField_a_of_type_Float * ((bald)localObject).jdField_a_of_type_Float + localbale.b * ((bald)localObject).b + localbale.c * ((bald)localObject).c + localbale.d * ((bald)localObject).d);
    }
  }
  
  public List<bald> a(QQAppInterface paramQQAppInterface, List<bald> paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramList.isEmpty()))
    {
      bakl.a("FriendSortHelper", "sortFriendList friendInfoList is null");
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      b(paramQQAppInterface, paramList);
      Collections.sort(paramList, new bakp(1));
      paramQQAppInterface = paramList;
    } while (paramList.size() <= 5);
    return paramList.subList(0, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakq
 * JD-Core Version:    0.7.0.1
 */