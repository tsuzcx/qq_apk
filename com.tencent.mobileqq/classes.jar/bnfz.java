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

public class bnfz
  extends ayxo
{
  private static bnfz jdField_a_of_type_Bnfz;
  private WeakReference<bnfv> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static bnfz a()
  {
    if (jdField_a_of_type_Bnfz == null) {}
    try
    {
      if (jdField_a_of_type_Bnfz == null) {
        jdField_a_of_type_Bnfz = new bnfz();
      }
      return jdField_a_of_type_Bnfz;
    }
    finally {}
  }
  
  public static Boolean a(String paramString)
  {
    return Boolean.valueOf(blhx.a(BaseApplicationImpl.getContext(), paramString));
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
            bnfx.a().d(localtAdvDesc.res_traceinfo, null);
          }
        }
        if (((ArrayList)localEntry.getValue()).size() == 0) {
          paramMobileQbossAdvRsp.remove();
        }
      }
    }
  }
  
  public void a(ArrayList<Integer> paramArrayList, bnfv parambnfv, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambnfv);
    parambnfv = BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), bcvv.class);
    localNewIntent.putExtra("selfuin", Long.parseLong(parambnfv.getAccount()));
    localNewIntent.putIntegerArrayListExtra("appid", paramArrayList);
    localNewIntent.putExtra("requestType", paramString);
    parambnfv.registObserver(this);
    parambnfv.startServlet(localNewIntent);
    QLog.i("QzoneQbossHelper", 1, "getQbossData req");
  }
  
  protected void h(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("requestType");
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (bnfv localbnfv = (bnfv)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localbnfv = null)
    {
      if (paramBoolean)
      {
        if (localbnfv != null) {
          localbnfv.a(paramBundle, str1, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
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
        if (localbnfv != null) {
          localbnfv.a(i, str2, str1, paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfz
 * JD-Core Version:    0.7.0.1
 */