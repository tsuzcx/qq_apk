import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONObject;

class bgeu
  implements bghi
{
  bgeu(bget parambget) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (bget.a(this.a).get() == null) {
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
        ((bgev)bget.a(this.a).get()).a(bget.a(this.a));
        return;
      }
      ((bgev)bget.a(this.a).get()).a(paramInt, paramJSONObject, bget.a(this.a));
      return;
    }
    QLog.e("AddTroopAppCgi", 1, "add appid get result err");
    ((bgev)bget.a(this.a).get()).a(-1, "", bget.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgeu
 * JD-Core Version:    0.7.0.1
 */