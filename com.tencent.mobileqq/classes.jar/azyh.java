import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class azyh
{
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      str1 = paramBundle.getString("action");
      localObject1 = paramBundle.getString("page");
      localObject2 = paramBundle.getString("module");
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)));
    String str1 = String.format("%s#%s#%s", new Object[] { str1, localObject1, localObject2 });
    Object localObject1 = new HashMap();
    Object localObject2 = paramBundle.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str2 = (String)((Iterator)localObject2).next();
      String str3 = paramBundle.getString(str2);
      if (!TextUtils.isEmpty(str3)) {
        ((HashMap)localObject1).put(str2, str3);
      }
    }
    switch (bdee.a(BaseApplicationImpl.getContext()))
    {
    }
    for (;;)
    {
      paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      UserAction.setUserID(paramBundle.c());
      ((HashMap)localObject1).put("qq", paramBundle.c());
      UserAction.onUserAction(str1, true, -1L, -1L, (Map)localObject1, true, true);
      return;
      ((HashMap)localObject1).put("network_type", "0");
      continue;
      ((HashMap)localObject1).put("network_type", "1");
      continue;
      ((HashMap)localObject1).put("network_type", "3");
      continue;
      ((HashMap)localObject1).put("network_type", "2");
      continue;
      ((HashMap)localObject1).put("network_type", "4");
      continue;
      ((HashMap)localObject1).put("network_type", "5");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyh
 * JD-Core Version:    0.7.0.1
 */