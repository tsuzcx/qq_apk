import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import mqq.manager.TicketManager;

public class bcdo
{
  public bcky a(QQAppInterface paramQQAppInterface, bckx parambckx, String paramString, int paramInt)
  {
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("bkn", "5381");
      localBundle.putString("gid", paramString);
      localBundle.putString("Cookie", String.format("uin=%s;skey=%s", new Object[] { str, localObject }));
      localBundle.putString("Referer", "http://qun.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", paramQQAppInterface.getApp().getApplicationContext());
      paramQQAppInterface = new bcky("http://qun.qq.com/cgi-bin/qun/web/kewen/get_search_keywords", "POST", parambckx, paramInt, localBundle);
      paramQQAppInterface.a(localHashMap);
      return paramQQAppInterface;
    }
  }
  
  public bcky a(QQAppInterface paramQQAppInterface, bckx parambckx, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("bkn", "5381");
      localBundle.putString("key", paramString);
      localBundle.putString("start", String.valueOf(paramInt1));
      localBundle.putString("num", String.valueOf(paramInt2));
      localBundle.putString("Cookie", String.format("uin=%s;skey=%s", new Object[] { str, localObject }));
      localBundle.putString("Referer", "http://qun.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", paramQQAppInterface.getApp().getApplicationContext());
      paramQQAppInterface = new bcky("http://qun.qq.com/cgi-bin/qun/web/kewen/search", "POST", parambckx, paramInt3, localBundle);
      paramQQAppInterface.a(localHashMap);
      return paramQQAppInterface;
    }
  }
  
  public bcky a(QQAppInterface paramQQAppInterface, bckx parambckx, String paramString, List<Integer> paramList, int paramInt)
  {
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("bkn", "5381");
      localBundle.putString("kid", paramString);
      if ((paramList != null) && (!paramList.isEmpty())) {
        localBundle.putString("pid_list", paramList.toString());
      }
      localBundle.putString("Cookie", String.format("uin=%s;skey=%s", new Object[] { str, localObject }));
      localBundle.putString("Referer", "http://qun.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", paramQQAppInterface.getApp().getApplicationContext());
      paramQQAppInterface = new bcky("http://qun.qq.com/cgi-bin/qun/web/kewen/get_kewen_info", "POST", parambckx, paramInt, localBundle);
      paramQQAppInterface.a(localHashMap);
      return paramQQAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdo
 * JD-Core Version:    0.7.0.1
 */