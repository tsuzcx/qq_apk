import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqgx
  extends aqgc<aqgw>
{
  @NonNull
  public aqgw a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new aqgw();
  }
  
  @NonNull
  public aqgw a(@NonNull aptx[] paramArrayOfaptx)
  {
    aqgw localaqgw = new aqgw();
    try
    {
      localaqgw.a = new JSONObject(paramArrayOfaptx[0].a).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localaqgw.a);
      }
      return localaqgw;
    }
    catch (JSONException paramArrayOfaptx)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfaptx);
    }
    return localaqgw;
  }
  
  @NonNull
  public aqgw b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new aqgw();
  }
  
  public Class<aqgw> clazz()
  {
    return aqgw.class;
  }
  
  public int type()
  {
    return 465;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqgx
 * JD-Core Version:    0.7.0.1
 */