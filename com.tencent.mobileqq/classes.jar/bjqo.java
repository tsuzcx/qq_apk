import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class bjqo
  extends avvd
{
  private static bjqo jdField_a_of_type_Bjqo;
  private WeakReference<bjqk> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static bjqo a()
  {
    if (jdField_a_of_type_Bjqo == null) {}
    try
    {
      if (jdField_a_of_type_Bjqo == null) {
        jdField_a_of_type_Bjqo = new bjqo();
      }
      return jdField_a_of_type_Bjqo;
    }
    finally {}
  }
  
  public static Boolean a(String paramString)
  {
    return Boolean.valueOf(bhtl.a(BaseApplicationImpl.getContext(), paramString));
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Pattern.compile("\"download_app_package_name\":\"[^\"]*").matcher(paramString);
      localObject1 = localObject2;
      if (paramString.find())
      {
        paramString = paramString.group(0).split("\"");
        localObject1 = localObject2;
        if (paramString.length == 4)
        {
          localObject1 = localObject2;
          if (paramString[3].length() > 0) {
            localObject1 = paramString[3];
          }
        }
      }
    }
    return localObject1;
  }
  
  public static void a(MobileQbossAdvRsp paramMobileQbossAdvRsp)
  {
    if (paramMobileQbossAdvRsp == null) {}
    for (;;)
    {
      return;
      paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv.entrySet().iterator();
      while (paramMobileQbossAdvRsp.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMobileQbossAdvRsp.next();
        Iterator localIterator = ((ArrayList)localEntry.getValue()).iterator();
        while (localIterator.hasNext())
        {
          tAdvDesc localtAdvDesc = (tAdvDesc)localIterator.next();
          String str = a(localtAdvDesc.res_data);
          if ((str != null) && (a(str).booleanValue()))
          {
            localIterator.remove();
            bjqm.a().d(localtAdvDesc.res_traceinfo, null);
          }
        }
        if (((ArrayList)localEntry.getValue()).size() == 0) {
          paramMobileQbossAdvRsp.remove();
        }
      }
    }
  }
  
  public void a(ArrayList<Integer> paramArrayList, bjqk parambjqk, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjqk);
    parambjqk = BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), azce.class);
    localNewIntent.putExtra("selfuin", Long.parseLong(parambjqk.getAccount()));
    localNewIntent.putIntegerArrayListExtra("appid", paramArrayList);
    localNewIntent.putExtra("requestType", paramString);
    parambjqk.registObserver(this);
    parambjqk.startServlet(localNewIntent);
    QLog.i("QzoneQbossHelper", 1, "getQbossData req");
  }
  
  protected void h(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("requestType");
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (bjqk localbjqk = (bjqk)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localbjqk = null)
    {
      if (paramBoolean)
      {
        if (localbjqk != null) {
          localbjqk.a(paramBundle, str1, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        }
        QLog.i("QzoneQbossHelper", 1, "onGetQbossData rsp success");
      }
      for (;;)
      {
        BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this);
        return;
        int i = paramBundle.getInt("ret", 0);
        String str2 = paramBundle.getString("msg");
        paramBundle = paramBundle.getIntegerArrayList("appid");
        if (localbjqk != null) {
          localbjqk.a(i, str2, str1, paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjqo
 * JD-Core Version:    0.7.0.1
 */