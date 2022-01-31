import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class bjga
{
  final String a;
  final String b;
  final String c;
  final String d;
  
  private bjga(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public static bjga a(@NonNull BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    String str1 = "0";
    str2 = "";
    String str3 = paramAppInfo.buffer.get();
    localObject = str2;
    paramAppInfo = str1;
    if (!TextUtils.isEmpty(str3)) {
      paramAppInfo = str1;
    }
    try
    {
      localObject = new JSONObject(str3);
      paramAppInfo = str1;
      str1 = ((JSONObject)localObject).getString("ad_id");
      paramAppInfo = str1;
      localObject = ((JSONObject)localObject).getString("pos_id");
      paramAppInfo = str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localObject = str2;
      }
    }
    return new bjga("vab_red", (String)localObject, paramAppInfo, "5");
  }
  
  public String a()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appid", this.a);
      ((JSONObject)localObject).put("page_id", this.b);
      ((JSONObject)localObject).put("item_id", this.c);
      ((JSONObject)localObject).put("item_type", this.d);
      localObject = "" + ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("MobileReport.Manager", 1, "parse json exception " + localException);
    }
    return "";
  }
  
  public String toString()
  {
    return "ReportKey{appid=" + this.a + ", pageId=" + this.b + ", mItemId=" + this.c + ", mItemType=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjga
 * JD-Core Version:    0.7.0.1
 */