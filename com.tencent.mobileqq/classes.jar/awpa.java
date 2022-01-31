import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;

public class awpa
  extends awor
{
  public awon a;
  public boolean b;
  
  public awpa(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.f = false;
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("appname");
      String str1 = ((JSONObject)localObject).optString("desc");
      String str2 = ((JSONObject)localObject).optString("appIcon");
      localObject = new MiniAppLocalSearchEntity(((JSONObject)localObject).optString("appid"), paramString, str2, str1, ((JSONObject)localObject).optInt("showMask", 0));
      this.a = new awon((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.c, (MiniAppLocalSearchEntity)localObject, this.g);
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.g)) && (paramString.equalsIgnoreCase(this.g)))
      {
        this.b = true;
        return;
      }
      this.b = false;
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("NetSearchTemplateMiniAppItem", 1, "parseLayoutExtensions, exception.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpa
 * JD-Core Version:    0.7.0.1
 */