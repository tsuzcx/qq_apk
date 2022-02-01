import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import mqq.util.WeakReference;
import org.json.JSONObject;

class aysx
  implements bfpo
{
  aysx(aysw paramaysw, double paramDouble1, double paramDouble2, long paramLong) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (aysw.a(this.jdField_a_of_type_Aysw).get() != null) {
      ((aysy)aysw.a(this.jdField_a_of_type_Aysw).get()).a(paramJSONObject, paramInt, this.jdField_a_of_type_Double, this.b, aysw.a(this.jdField_a_of_type_Aysw), aysw.a(this.jdField_a_of_type_Aysw));
    }
    long l = System.currentTimeMillis();
    paramBundle = new HashMap();
    paramBundle.put("cost", String.valueOf(l - this.jdField_a_of_type_Long));
    paramBundle.put("result", String.valueOf(paramJSONObject));
    paramBundle.put("type", String.valueOf(aysw.a(this.jdField_a_of_type_Aysw)));
    bctj.a(BaseApplicationImpl.getContext()).a(null, "actOnlineStatusCgi", true, 0L, 0L, paramBundle, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysx
 * JD-Core Version:    0.7.0.1
 */