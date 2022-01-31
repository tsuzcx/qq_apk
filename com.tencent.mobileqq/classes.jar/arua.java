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

public class arua
{
  private int jdField_a_of_type_Int;
  public GetAppInfoProto.Ads a;
  private String jdField_a_of_type_JavaLangString;
  public List<zbo> a;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  private static int a(List<zbo> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      zbo localzbo = (zbo)paramList.next();
      if ("16".equals(localzbo.b.get()))
      {
        i |= 0x1;
      }
      else if ("64".equals(localzbo.b.get()))
      {
        i |= 0x2;
      }
      else
      {
        if (!"100".equals(localzbo.b.get())) {
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
  
  public static arua a(GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    arua localarua = new arua();
    localarua.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$Ads = paramGetAppinfoResponse.ads;
    localarua.jdField_a_of_type_JavaUtilList = zbj.a(paramGetAppinfoResponse.iconsURL);
    if (!localarua.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localarua.jdField_a_of_type_JavaLangString = zbj.a(localarua.jdField_a_of_type_JavaUtilList, 16);
      localarua.b = zbj.a(localarua.jdField_a_of_type_JavaUtilList, 100);
      localarua.jdField_a_of_type_Int = a(localarua.jdField_a_of_type_JavaUtilList);
    }
    GetAppInfoProto.AndroidInfo localAndroidInfo = paramGetAppinfoResponse.androidInfo;
    if (localAndroidInfo != null)
    {
      localarua.jdField_a_of_type_Boolean = true;
      if (!localAndroidInfo.sourceUrl.has()) {
        break label183;
      }
      paramGetAppinfoResponse = localAndroidInfo.sourceUrl.get();
      localarua.c = paramGetAppinfoResponse;
      if (!localAndroidInfo.messagetail.has()) {
        break label189;
      }
      paramGetAppinfoResponse = localAndroidInfo.messagetail.get();
      label131:
      localarua.d = paramGetAppinfoResponse;
      if (!localAndroidInfo.packName.has()) {
        break label195;
      }
    }
    label183:
    label189:
    label195:
    for (paramGetAppinfoResponse = localAndroidInfo.packName.get();; paramGetAppinfoResponse = "")
    {
      localarua.e = paramGetAppinfoResponse;
      QLog.d("AppInfo", 1, new Object[] { "convertToAppInfo AppInfo : ", localarua.toString() });
      return localarua;
      paramGetAppinfoResponse = "";
      break;
      paramGetAppinfoResponse = "";
      break label131;
    }
  }
  
  public static arua a(preAuth.PreAuthResponse paramPreAuthResponse, appType.AndroidInfo paramAndroidInfo)
  {
    arua localarua = new arua();
    String str;
    if (paramAndroidInfo.message_tail.has())
    {
      str = paramAndroidInfo.message_tail.get();
      localarua.d = str;
      if (!paramAndroidInfo.pack_name.has()) {
        break label172;
      }
      str = paramAndroidInfo.pack_name.get();
      label49:
      localarua.e = str;
      if (!paramAndroidInfo.source_url.has()) {
        break label178;
      }
    }
    label172:
    label178:
    for (paramAndroidInfo = paramAndroidInfo.source_url.get();; paramAndroidInfo = "")
    {
      localarua.c = paramAndroidInfo;
      localarua.jdField_a_of_type_Boolean = true;
      localarua.jdField_a_of_type_JavaUtilList = zbj.b(paramPreAuthResponse.icons_url);
      if (!localarua.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localarua.jdField_a_of_type_JavaLangString = zbj.a(localarua.jdField_a_of_type_JavaUtilList, 16);
        localarua.b = zbj.a(localarua.jdField_a_of_type_JavaUtilList, 100);
        localarua.jdField_a_of_type_Int = a(localarua.jdField_a_of_type_JavaUtilList);
      }
      QLog.d("AppInfo", 1, new Object[] { "convertToAppInfo AppInfo : ", localarua.toString() });
      return localarua;
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
  
  public static void a(oidb_0xd55.RspBody paramRspBody, String paramString, arua paramarua)
  {
    paramarua.jdField_a_of_type_Boolean = true;
    qqconnect.Appinfo localAppinfo = paramRspBody.appinfo;
    paramarua.jdField_a_of_type_JavaLangString = localAppinfo.icon_mini_url.get();
    paramarua.b = localAppinfo.icon_url.get();
    paramarua.jdField_a_of_type_Int = a(localAppinfo);
    paramarua.c = localAppinfo.source_url.get();
    paramarua.d = localAppinfo.app_name.get();
    paramarua.e = a(localAppinfo, paramString);
    if (paramRspBody.wording.has()) {}
    for (paramRspBody = paramRspBody.wording.get();; paramRspBody = "")
    {
      paramarua.f = paramRspBody;
      QLog.d("AppInfo", 1, new Object[] { "fillAppInfo AppInfo : ", paramarua.toString() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arua
 * JD-Core Version:    0.7.0.1
 */