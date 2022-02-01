import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.getappinfo.GetAppInfoProto.Ads;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qconn.protofile.appType.AndroidInfo;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xd55.RspBody;
import tencent.im.oidb.qqconnect.AndroidAppInfo;
import tencent.im.oidb.qqconnect.Appinfo;
import tencent.im.oidb.qqconnect.MobileAppInfo;

public class aupn
{
  private int jdField_a_of_type_Int;
  public GetAppInfoProto.Ads a;
  private String jdField_a_of_type_JavaLangString;
  public List<aasw> a;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  private static int a(List<aasw> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      aasw localaasw = (aasw)paramList.next();
      if ("16".equals(localaasw.b.get()))
      {
        i |= 0x1;
      }
      else if ("64".equals(localaasw.b.get()))
      {
        i |= 0x2;
      }
      else
      {
        if (!"100".equals(localaasw.b.get())) {
          break label96;
        }
        i |= 0x4;
      }
    }
    label96:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static int a(qqconnect.Appinfo paramAppinfo)
  {
    int j = 0;
    if (paramAppinfo.icon_mini_url.has()) {
      j = 1;
    }
    int i;
    if (!paramAppinfo.icon_middle_url.has())
    {
      i = j;
      if (!paramAppinfo.icon_small_url.has()) {}
    }
    else
    {
      i = j | 0x2;
    }
    j = i;
    if (paramAppinfo.icon_url.has()) {
      j = i | 0x4;
    }
    return j;
  }
  
  public static aupn a(GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    aupn localaupn = new aupn();
    localaupn.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$Ads = paramGetAppinfoResponse.ads;
    localaupn.jdField_a_of_type_JavaUtilList = aasr.a(paramGetAppinfoResponse.iconsURL);
    if (!localaupn.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localaupn.jdField_a_of_type_JavaLangString = aasr.a(localaupn.jdField_a_of_type_JavaUtilList, 16);
      localaupn.b = aasr.a(localaupn.jdField_a_of_type_JavaUtilList, 100);
      localaupn.jdField_a_of_type_Int = a(localaupn.jdField_a_of_type_JavaUtilList);
    }
    GetAppInfoProto.AndroidInfo localAndroidInfo = paramGetAppinfoResponse.androidInfo;
    if (localAndroidInfo != null)
    {
      localaupn.jdField_a_of_type_Boolean = true;
      if (!localAndroidInfo.sourceUrl.has()) {
        break label183;
      }
      paramGetAppinfoResponse = localAndroidInfo.sourceUrl.get();
      localaupn.c = paramGetAppinfoResponse;
      if (!localAndroidInfo.messagetail.has()) {
        break label189;
      }
      paramGetAppinfoResponse = localAndroidInfo.messagetail.get();
      label131:
      localaupn.d = paramGetAppinfoResponse;
      if (!localAndroidInfo.packName.has()) {
        break label195;
      }
    }
    label183:
    label189:
    label195:
    for (paramGetAppinfoResponse = localAndroidInfo.packName.get();; paramGetAppinfoResponse = "")
    {
      localaupn.e = paramGetAppinfoResponse;
      QLog.d("SDK_LOGIN.AppInfo", 1, new Object[] { "convertToAppInfo AppInfo : ", localaupn.toString() });
      return localaupn;
      paramGetAppinfoResponse = "";
      break;
      paramGetAppinfoResponse = "";
      break label131;
    }
  }
  
  public static aupn a(preAuth.PreAuthResponse paramPreAuthResponse, appType.AndroidInfo paramAndroidInfo)
  {
    aupn localaupn = new aupn();
    String str;
    if (paramAndroidInfo.message_tail.has())
    {
      str = paramAndroidInfo.message_tail.get();
      localaupn.d = str;
      if (!paramAndroidInfo.pack_name.has()) {
        break label172;
      }
      str = paramAndroidInfo.pack_name.get();
      label49:
      localaupn.e = str;
      if (!paramAndroidInfo.source_url.has()) {
        break label178;
      }
    }
    label172:
    label178:
    for (paramAndroidInfo = paramAndroidInfo.source_url.get();; paramAndroidInfo = "")
    {
      localaupn.c = paramAndroidInfo;
      localaupn.jdField_a_of_type_Boolean = true;
      localaupn.jdField_a_of_type_JavaUtilList = aasr.b(paramPreAuthResponse.icons_url);
      if (!localaupn.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localaupn.jdField_a_of_type_JavaLangString = aasr.a(localaupn.jdField_a_of_type_JavaUtilList, 16);
        localaupn.b = aasr.a(localaupn.jdField_a_of_type_JavaUtilList, 100);
        localaupn.jdField_a_of_type_Int = a(localaupn.jdField_a_of_type_JavaUtilList);
      }
      QLog.d("SDK_LOGIN.AppInfo", 1, new Object[] { "convertToAppInfo AppInfo : ", localaupn.toString() });
      return localaupn;
      str = "";
      break;
      str = "";
      break label49;
    }
  }
  
  private static String a(qqconnect.Appinfo paramAppinfo, String paramString)
  {
    Iterator localIterator = null;
    Object localObject2 = null;
    Object localObject1 = localIterator;
    if (paramAppinfo.mobile_app_info.has())
    {
      localObject1 = localIterator;
      if (paramAppinfo.mobile_app_info.android_app_info.has())
      {
        localIterator = paramAppinfo.mobile_app_info.android_app_info.get().iterator();
        paramAppinfo = localObject2;
        localObject1 = paramAppinfo;
        if (localIterator.hasNext())
        {
          localObject1 = (qqconnect.AndroidAppInfo)localIterator.next();
          if (((qqconnect.AndroidAppInfo)localObject1).pack_name.has())
          {
            localObject1 = ((qqconnect.AndroidAppInfo)localObject1).pack_name.get();
            paramAppinfo = (qqconnect.Appinfo)localObject1;
            if (!((String)localObject1).equals(paramString)) {}
          }
        }
      }
    }
    while (TextUtils.isEmpty((CharSequence)localObject1))
    {
      return paramString;
      break;
    }
    return localObject1;
  }
  
  public static void a(oidb_0xd55.RspBody paramRspBody, String paramString, aupn paramaupn)
  {
    paramaupn.jdField_a_of_type_Boolean = true;
    qqconnect.Appinfo localAppinfo = paramRspBody.appinfo;
    paramaupn.jdField_a_of_type_JavaLangString = localAppinfo.icon_mini_url.get();
    paramaupn.b = localAppinfo.icon_url.get();
    paramaupn.jdField_a_of_type_Int = a(localAppinfo);
    paramaupn.c = localAppinfo.source_url.get();
    paramaupn.d = localAppinfo.app_name.get();
    paramaupn.e = a(localAppinfo, paramString);
    if (paramRspBody.wording.has()) {}
    for (paramRspBody = paramRspBody.wording.get();; paramRspBody = "")
    {
      paramaupn.f = paramRspBody;
      QLog.d("SDK_LOGIN.AppInfo", 1, new Object[] { "fillAppInfo AppInfo : ", paramaupn.toString() });
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String toString()
  {
    return "iconUrlMini=" + this.jdField_a_of_type_JavaLangString + ", iconUrlBig=" + this.b + ", appLackOfIcons=" + this.jdField_a_of_type_Int + ", isAndroidInfoExist=" + this.jdField_a_of_type_Boolean + ", sourceUrl=" + this.c + ", appName=" + this.d + ", pkgName=" + this.e + ", mErrorWording=" + this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupn
 * JD-Core Version:    0.7.0.1
 */