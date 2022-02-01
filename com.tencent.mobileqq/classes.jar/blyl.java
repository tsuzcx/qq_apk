import NS_USER_ACTION_REPORT.ItemInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class blyl
{
  private final blyr jdField_a_of_type_Blyr = new blyr(null);
  private final blys jdField_a_of_type_Blys = new blys(null);
  
  public static blyl a()
  {
    return blyt.a();
  }
  
  @Nullable
  public static String a(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null)
    {
      paramAppInfo = blyq.a(paramAppInfo);
      return String.format("&traceId=%s&traceNum=%s&traceDetail=%s", new Object[] { paramAppInfo.jdField_a_of_type_JavaLangString, String.valueOf(paramAppInfo.jdField_a_of_type_Int), URLEncoder.encode(paramAppInfo.a()) });
    }
    return null;
  }
  
  public static String a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    String str1 = paramString;
    String str2;
    if (!TextUtils.isEmpty(paramString))
    {
      str2 = "";
      str1 = "";
      if (paramAppInfo != null)
      {
        paramAppInfo = blyq.a(paramAppInfo);
        str2 = String.format("trace_id=%s&trace_num=%s&trace_detail=%s", new Object[] { paramAppInfo.jdField_a_of_type_JavaLangString, String.valueOf(paramAppInfo.jdField_a_of_type_Int), URLEncoder.encode(paramAppInfo.a()) });
        if (!paramString.contains("?")) {
          break label98;
        }
      }
    }
    label98:
    for (str1 = "&";; str1 = "?")
    {
      str1 = paramString + str1 + str2;
      return str1;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("page_id", paramString2);
      paramString1 = "&trace_detail=base64-" + awzl.a(localJSONObject.toString());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("MobileReport.Manager", 1, "json exception" + paramString1);
    }
    return "&trace_detail=base64-";
  }
  
  @NonNull
  public static String a(@Nullable String paramString1, @Nullable String paramString2, @NonNull String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      Object localObject = paramString2.split("_");
      if (localObject.length > 2)
      {
        paramString2 = localObject[0];
        String str = localObject[1];
        localObject = localObject[2];
        return paramString3 + "trace_num=1&trace_id=" + paramString1 + "_" + str + "_" + System.currentTimeMillis() + "&trace_detail_adv_pos_id=" + paramString2 + "&trace_detail_adv_id=" + str + "&trace_detail_pattern=" + (String)localObject;
      }
    }
    return "";
  }
  
  public static String b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null) {
      return String.format("&trace_detail=base64-%s", new Object[] { awzl.a(blyp.a(paramAppInfo).a()) });
    }
    return null;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (paramString1.contains("?")) {}
    for (paramString1 = "&";; paramString1 = "?") {
      return a(str, paramString2, paramString1);
    }
  }
  
  public void a(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if (paramAppInfo == null) {
      return;
    }
    blyq localblyq = blyq.a(paramAppInfo);
    ItemInfo localItemInfo = new blyo().a(localblyq.b).c(paramAppInfo.buffer.get()).a(new blyn(System.currentTimeMillis(), paramInt).a()).a();
    if (QLog.isColorLevel())
    {
      if (102 != paramInt) {
        break label119;
      }
      paramAppInfo = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + localblyq.toString() + " actionId = " + paramAppInfo);
      this.jdField_a_of_type_Blys.a(localblyq, localItemInfo);
      return;
      label119:
      if (101 == paramInt) {
        paramAppInfo = "ITEM_EXPORT";
      } else {
        paramAppInfo = "UNKONW";
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3)
  {
    blyq localblyq;
    JSONObject localJSONObject;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))
    {
      localblyq = new blyq("", 0, "", 0, "H5CostReport", paramString1);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("coreType", paramInt2);
      localJSONObject.put("coreVersion", paramString3);
      localJSONObject.put("errorcode", paramString2);
      paramString3 = new blyo().a("").c(localJSONObject.toString()).a(new blyn(System.currentTimeMillis(), paramInt1, paramLong).a()).a();
      if (QLog.isColorLevel()) {
        QLog.d("MobileReport.Manager", 2, "report " + localblyq.toString() + " opType = " + paramInt1 + " url = " + paramString1 + " timecost " + paramLong + " errorcode " + paramString2);
      }
      this.jdField_a_of_type_Blys.a(localblyq, paramString3);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        QLog.e("MobileReport.Manager", 2, " report exception " + paramString3);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    blyq localblyq;
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))
    {
      localblyq = new blyq("", 0, "", 0, "JumpUrlReport", paramString1);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("jump_url", paramString2);
      String str = bmvl.a(paramString1).getString("adId");
      localObject = new blyo().a(String.valueOf(str)).c(((JSONObject)localObject).toString()).a(new blyn(System.currentTimeMillis(), 152, 1L).a()).a();
      if (QLog.isColorLevel()) {
        QLog.d("MobileReport.Manager", 2, "report " + localblyq.toString() + " opType = " + 152 + " url = " + paramString1 + " jumpUrl = " + paramString2);
      }
      this.jdField_a_of_type_Blys.a(localblyq, (ItemInfo)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MobileReport.Manager", 2, " report exception " + localException);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, ItemInfo paramItemInfo)
  {
    paramString1 = new blyq("", 1, "", -1, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("MobileReport.Manager", 2, "report " + paramString1.toString() + " actionId = " + paramItemInfo.toString());
    }
    this.jdField_a_of_type_Blyr.a(paramString1, paramItemInfo);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong)
  {
    a("", null, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2)
  {
    paramString2 = new blyq("", 1, "", -1, paramString1, paramString2);
    paramString3 = new blyo().a(paramString4).b(paramString5).d(paramString3).a(new blyn(System.currentTimeMillis(), paramInt1, paramInt2).a()).a();
    if (QLog.isColorLevel())
    {
      if (102 != paramInt1) {
        break label137;
      }
      paramString1 = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report of notice:    itemId=" + paramString4 + ";" + paramString2.toString() + " actionId = " + paramString1);
      this.jdField_a_of_type_Blys.a(paramString2, paramString3);
      return;
      label137:
      if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else if (100 == paramInt1) {
        paramString1 = "PAGE_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong)
  {
    paramString4 = new blyq("", 1, "", -1, paramString3, paramString4);
    blyo localblyo = new blyo();
    paramString3 = paramString1;
    if (paramString1 == null) {
      paramString3 = "";
    }
    paramString3 = localblyo.a(paramString3).d(paramString5).a(new blyn(paramLong, paramInt1, paramInt2).a()).a();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString3.item_type = paramString1;
    if (QLog.isColorLevel())
    {
      if (102 != paramInt1) {
        break label150;
      }
      paramString1 = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + paramString4.toString() + " actionId = " + paramString1);
      this.jdField_a_of_type_Blys.a(paramString4, paramString3);
      return;
      label150:
      if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong, String paramString6)
  {
    paramString4 = new blyq("", 1, "", -1, paramString3, paramString4);
    blyo localblyo = new blyo();
    paramString3 = paramString1;
    if (paramString1 == null) {
      paramString3 = "";
    }
    paramString3 = localblyo.a(paramString3).d(paramString5).c("{\"roomid\":\"" + paramString6 + "\"}").a(new blyn(paramLong, paramInt1, paramInt2).a()).a();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString3.item_type = paramString1;
    if (QLog.isColorLevel())
    {
      if (102 != paramInt1) {
        break label180;
      }
      paramString1 = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + paramString4.toString() + " actionId = " + paramString1);
      this.jdField_a_of_type_Blyr.a(paramString4, paramString3);
      return;
      label180:
      if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    paramString2 = new blyq("", 1, "", -1, paramString1, paramString2);
    blyo localblyo = new blyo();
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = "";
    }
    paramString3 = localblyo.a(paramString1).d(paramString3).a(new blyn(System.currentTimeMillis(), paramInt1, paramInt2).a()).a();
    paramString1 = paramString6;
    if (paramString6 == null) {
      paramString1 = "";
    }
    paramString3.item_type = paramString1;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    paramString3.sub_module_id = paramString1;
    if (QLog.isColorLevel())
    {
      if (102 != paramInt1) {
        break label166;
      }
      paramString1 = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + paramString2.toString() + " actionId = " + paramString1);
      this.jdField_a_of_type_Blys.a(paramString2, paramString3);
      return;
      label166:
      if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyl
 * JD-Core Version:    0.7.0.1
 */