import NS_USER_ACTION_REPORT.ItemInfo;
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

public class bfvl
{
  private final bfvq a = new bfvq(null);
  
  public static bfvl a()
  {
    return bfvr.a();
  }
  
  @Nullable
  public static String a(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null)
    {
      paramAppInfo = bfvp.a(paramAppInfo);
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
        paramAppInfo = bfvp.a(paramAppInfo);
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
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (paramString1.contains("?")) {}
    for (paramString1 = "&";; paramString1 = "?") {
      return a(str, paramString2, paramString1);
    }
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
  
  public void a(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if (paramAppInfo == null) {
      return;
    }
    bfvp localbfvp = bfvp.a(paramAppInfo);
    ItemInfo localItemInfo = new bfvo(null).a(localbfvp.b).b(paramAppInfo.buffer.get()).a(new bfvn(System.currentTimeMillis(), paramInt).a()).a();
    if (QLog.isColorLevel())
    {
      if (102 != paramInt) {
        break label120;
      }
      paramAppInfo = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + localbfvp.toString() + " actionId = " + paramAppInfo);
      bfvq.a(this.a, localbfvp, localItemInfo);
      return;
      label120:
      if (101 == paramInt) {
        paramAppInfo = "ITEM_EXPORT";
      } else {
        paramAppInfo = "UNKONW";
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3)
  {
    bfvp localbfvp;
    JSONObject localJSONObject;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))
    {
      localbfvp = new bfvp("", 0, "", 0, "H5CostReport", paramString1, null);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("coreType", paramInt2);
      localJSONObject.put("coreVersion", paramString3);
      localJSONObject.put("errorcode", paramString2);
      paramString3 = new bfvo(null).a("").b(localJSONObject.toString()).a(new bfvn(System.currentTimeMillis(), paramInt1, paramLong).a()).a();
      if (QLog.isColorLevel()) {
        QLog.d("MobileReport.Manager", 2, "report " + localbfvp.toString() + " opType = " + paramInt1 + " url = " + paramString1 + " timecost " + paramLong + " errorcode " + paramString2);
      }
      bfvq.a(this.a, localbfvp, paramString3);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfvl
 * JD-Core Version:    0.7.0.1
 */