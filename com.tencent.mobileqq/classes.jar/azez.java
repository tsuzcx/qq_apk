import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mini.util.JSONUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class azez
{
  private static azfn a;
  
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
  
  private azfn a()
  {
    if (a == null)
    {
      a = a(BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).getString("FriendSort", ""));
      if (a == null) {
        a = new azfn();
      }
    }
    return a;
  }
  
  public static azfn a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (JSONUtil.isJson(paramString))) {
      try
      {
        paramString = new JSONObject(paramString);
        azfn localazfn = new azfn();
        localazfn.jdField_a_of_type_Float = Float.valueOf(paramString.getString("recognitionWeight")).floatValue();
        localazfn.b = Float.valueOf(paramString.getString("messageTime")).floatValue();
        localazfn.c = Float.valueOf(paramString.getString("topFriend")).floatValue();
        localazfn.d = Float.valueOf(paramString.getString("careFriend")).floatValue();
        a = localazfn;
        return localazfn;
      }
      catch (JSONException paramString)
      {
        azeu.a("FriendSortHelper", "parseContent exception :" + paramString.getMessage());
        return null;
      }
      catch (Exception paramString)
      {
        azeu.a("FriendSortHelper", "parseContent exception :" + paramString.getMessage());
        return null;
      }
    }
    return null;
  }
  
  private List<azfm> a(List<azfm> paramList)
  {
    int j = 0;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      azeu.a("FriendSortHelper", "computeRecentTimeWeight friendInfoList is null");
      localObject = null;
      return localObject;
    }
    Collections.sort(paramList, new azey(2));
    Object localObject = paramList.iterator();
    int i = 0;
    label50:
    if (((Iterator)localObject).hasNext())
    {
      if (((azfm)((Iterator)localObject).next()).jdField_a_of_type_Long <= 0L) {
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
      localObject = (azfm)paramList.get(i);
      j = k - i - 1;
      if ((((azfm)localObject).jdField_a_of_type_Long > 0L) && (j > 0)) {}
      for (((azfm)localObject).b = (j * 1.0F / k);; ((azfm)localObject).b = 0.0F)
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
      paramQQAppInterface = ((amsw)paramQQAppInterface.getManager(51)).a(paramString);
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
  
  private List<azfm> b(QQAppInterface paramQQAppInterface, List<azfm> paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramList.isEmpty()))
    {
      azeu.a("FriendSortHelper", "computeFriendScore friendInfoList is null");
      return null;
    }
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      azfm localazfm = (azfm)localIterator.next();
      if ((localazfm.jdField_a_of_type_Int == 0) && (a(paramQQAppInterface, localazfm.jdField_a_of_type_JavaLangString)))
      {
        i = 1;
        label79:
        localazfm.d = i;
        if (!a(paramQQAppInterface, localazfm.jdField_a_of_type_JavaLangString, localazfm.jdField_a_of_type_Int)) {
          break label141;
        }
      }
      label141:
      for (int i = 1;; i = 0)
      {
        localazfm.c = i;
        localazfm.jdField_a_of_type_Long = a(paramQQAppInterface, localazfm.jdField_a_of_type_JavaLangString, localazfm.jdField_a_of_type_Int);
        break;
        i = 0;
        break label79;
      }
    }
    a(paramList);
    return b(paramList);
  }
  
  private List<azfm> b(List<azfm> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      azeu.a("FriendSortHelper", "computeTotalScore friendInfoList is null");
      localObject = null;
      return localObject;
    }
    azfn localazfn = a();
    if (localazfn == null)
    {
      azeu.a("FriendSortHelper", "computeTotalScore sortConfig is null");
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      localObject = paramList;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (azfm)localIterator.next();
      ((azfm)localObject).e = (localazfn.jdField_a_of_type_Float * ((azfm)localObject).jdField_a_of_type_Float + localazfn.b * ((azfm)localObject).b + localazfn.c * ((azfm)localObject).c + localazfn.d * ((azfm)localObject).d);
    }
  }
  
  public List<azfm> a(QQAppInterface paramQQAppInterface, List<azfm> paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramList.isEmpty()))
    {
      azeu.a("FriendSortHelper", "sortFriendList friendInfoList is null");
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      b(paramQQAppInterface, paramList);
      Collections.sort(paramList, new azey(1));
      paramQQAppInterface = paramList;
    } while (paramList.size() <= 5);
    return paramList.subList(0, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azez
 * JD-Core Version:    0.7.0.1
 */