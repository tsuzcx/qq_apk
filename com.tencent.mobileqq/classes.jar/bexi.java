import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONObject;

class bexi
  implements bezd
{
  bexi(bexh parambexh) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (bexh.a(this.a).get() == null) {
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("ec")))
    {
      paramInt = paramJSONObject.optInt("ec");
      paramJSONObject = paramJSONObject.optString("em");
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopAppCgi", 2, new Object[] { "retCode:", Integer.valueOf(paramInt) });
      }
      if (paramInt == 0)
      {
        ((bexj)bexh.a(this.a).get()).a(bexh.a(this.a));
        return;
      }
      ((bexj)bexh.a(this.a).get()).a(paramInt, paramJSONObject, bexh.a(this.a));
      return;
    }
    QLog.e("AddTroopAppCgi", 1, "add appid get result err");
    ((bexj)bexh.a(this.a).get()).a(-1, "", bexh.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexi
 * JD-Core Version:    0.7.0.1
 */