import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;

public class ayom
  extends ayod
{
  public aynz a;
  public boolean b;
  
  public ayom(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.f = false;
  }
  
  public void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      String str2 = localJSONObject.optString("appname");
      String str1 = localJSONObject.optString("desc");
      String str3 = localJSONObject.optString("appIcon");
      String str4 = localJSONObject.optString("appid");
      int i = localJSONObject.optInt("showMask", 0);
      Object localObject = null;
      paramString = (String)localObject;
      if (localJSONObject.has("friendExtra"))
      {
        localJSONObject = localJSONObject.optJSONObject("friendExtra");
        paramString = (String)localObject;
        if (localJSONObject != null)
        {
          paramString = (String)localObject;
          if (localJSONObject.has("displayText")) {
            paramString = localJSONObject.optString("displayText");
          }
        }
      }
      localObject = str1;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = paramString + " | " + str1;
      }
      paramString = new MiniAppLocalSearchEntity(str4, str2, str3, (String)localObject, i);
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      this.a = new aynz((QQAppInterface)localObject, this.c, paramString, this.g);
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(this.g)) && (str2.equalsIgnoreCase(this.g))) {}
      for (this.b = true; localObject != null; this.b = false)
      {
        localObject = (MiniAppLocalSearchManager)((QQAppInterface)localObject).getManager(310);
        if (localObject == null) {
          break;
        }
        ((MiniAppLocalSearchManager)localObject).updateDataDbFromNetResult(paramString);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("NetSearchTemplateMiniAppItem", 1, "parseLayoutExtensions, exception.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayom
 * JD-Core Version:    0.7.0.1
 */