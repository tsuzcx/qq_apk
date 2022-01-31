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

public class aphd
{
  private int jdField_a_of_type_Int;
  public GetAppInfoProto.Ads a;
  private String jdField_a_of_type_JavaLangString;
  public List<xdy> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public aphd(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private static int a(List<xdy> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      xdy localxdy = (xdy)paramList.next();
      if ("16".equals(localxdy.b.get()))
      {
        i |= 0x1;
      }
      else if ("64".equals(localxdy.b.get()))
      {
        i |= 0x2;
      }
      else
      {
        if (!"100".equals(localxdy.b.get())) {
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
  
  public static aphd a(GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    aphd localaphd = new aphd(0);
    localaphd.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$Ads = paramGetAppinfoResponse.ads;
    localaphd.jdField_a_of_type_JavaUtilList = xdt.a(paramGetAppinfoResponse.iconsURL);
    if (!localaphd.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localaphd.jdField_a_of_type_JavaLangString = xdt.a(localaphd.jdField_a_of_type_JavaUtilList, 16);
      localaphd.jdField_b_of_type_JavaLangString = xdt.a(localaphd.jdField_a_of_type_JavaUtilList, 100);
      localaphd.jdField_a_of_type_Int = a(localaphd.jdField_a_of_type_JavaUtilList);
    }
    GetAppInfoProto.AndroidInfo localAndroidInfo = paramGetAppinfoResponse.androidInfo;
    if (localAndroidInfo != null)
    {
      localaphd.jdField_a_of_type_Boolean = true;
      if (!localAndroidInfo.sourceUrl.has()) {
        break label184;
      }
      paramGetAppinfoResponse = localAndroidInfo.sourceUrl.get();
      localaphd.c = paramGetAppinfoResponse;
      if (!localAndroidInfo.messagetail.has()) {
        break label190;
      }
      paramGetAppinfoResponse = localAndroidInfo.messagetail.get();
      label132:
      localaphd.d = paramGetAppinfoResponse;
      if (!localAndroidInfo.packName.has()) {
        break label196;
      }
    }
    label184:
    label190:
    label196:
    for (paramGetAppinfoResponse = localAndroidInfo.packName.get();; paramGetAppinfoResponse = "")
    {
      localaphd.e = paramGetAppinfoResponse;
      QLog.d("AppInfo", 1, new Object[] { "convertToAppInfo AppInfo : ", localaphd.toString() });
      return localaphd;
      paramGetAppinfoResponse = "";
      break;
      paramGetAppinfoResponse = "";
      break label132;
    }
  }
  
  public static aphd a(preAuth.PreAuthResponse paramPreAuthResponse, appType.AndroidInfo paramAndroidInfo)
  {
    aphd localaphd = new aphd(0);
    String str;
    if (paramAndroidInfo.message_tail.has())
    {
      str = paramAndroidInfo.message_tail.get();
      localaphd.d = str;
      if (!paramAndroidInfo.pack_name.has()) {
        break label173;
      }
      str = paramAndroidInfo.pack_name.get();
      label50:
      localaphd.e = str;
      if (!paramAndroidInfo.source_url.has()) {
        break label179;
      }
    }
    label173:
    label179:
    for (paramAndroidInfo = paramAndroidInfo.source_url.get();; paramAndroidInfo = "")
    {
      localaphd.c = paramAndroidInfo;
      localaphd.jdField_a_of_type_Boolean = true;
      localaphd.jdField_a_of_type_JavaUtilList = xdt.b(paramPreAuthResponse.icons_url);
      if (!localaphd.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localaphd.jdField_a_of_type_JavaLangString = xdt.a(localaphd.jdField_a_of_type_JavaUtilList, 16);
        localaphd.jdField_b_of_type_JavaLangString = xdt.a(localaphd.jdField_a_of_type_JavaUtilList, 100);
        localaphd.jdField_a_of_type_Int = a(localaphd.jdField_a_of_type_JavaUtilList);
      }
      QLog.d("AppInfo", 1, new Object[] { "convertToAppInfo AppInfo : ", localaphd.toString() });
      return localaphd;
      str = "";
      break;
      str = "";
      break label50;
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
  
  public static void a(oidb_0xd55.RspBody paramRspBody, String paramString, aphd paramaphd)
  {
    paramaphd.jdField_a_of_type_Boolean = true;
    qqconnect.Appinfo localAppinfo = paramRspBody.appinfo;
    paramaphd.jdField_a_of_type_JavaLangString = localAppinfo.icon_mini_url.get();
    paramaphd.jdField_b_of_type_JavaLangString = localAppinfo.icon_url.get();
    paramaphd.jdField_a_of_type_Int = a(localAppinfo);
    paramaphd.c = localAppinfo.source_url.get();
    paramaphd.d = localAppinfo.app_name.get();
    paramaphd.e = a(localAppinfo, paramString);
    if (paramRspBody.wording.has()) {}
    for (paramRspBody = paramRspBody.wording.get();; paramRspBody = "")
    {
      paramaphd.f = paramRspBody;
      QLog.d("AppInfo", 1, new Object[] { "fillAppInfo AppInfo : ", paramaphd.toString() });
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
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
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
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String toString()
  {
    return "iconUrlMini=" + this.jdField_a_of_type_JavaLangString + ", iconUrlBig=" + this.jdField_b_of_type_JavaLangString + ", appLackOfIcons=" + this.jdField_a_of_type_Int + ", isAndroidInfoExist=" + this.jdField_a_of_type_Boolean + ", sourceUrl=" + this.c + ", appName=" + this.d + ", pkgName=" + this.e + ", mErrorWording=" + this.f + ", mErrorCode=" + this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aphd
 * JD-Core Version:    0.7.0.1
 */