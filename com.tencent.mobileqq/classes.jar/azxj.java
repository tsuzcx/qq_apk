import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class azxj
  extends aofy<azxi>
{
  public static azxi a()
  {
    return (azxi)aogj.a().a(612);
  }
  
  public static void b()
  {
    aogj.a().a(new int[] { 612 });
  }
  
  public int a()
  {
    return 612;
  }
  
  @NonNull
  public azxi a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new azxi();
  }
  
  @Nullable
  public azxi a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onParsed]");
    }
    azxi localazxi = new azxi();
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      paramArrayOfaogf = paramArrayOfaogf[0];
      if ((paramArrayOfaogf == null) || (TextUtils.isEmpty(paramArrayOfaogf.a))) {}
    }
    try
    {
      localazxi.a = new JSONObject(paramArrayOfaogf.a);
      return localazxi;
    }
    catch (JSONException paramArrayOfaogf)
    {
      QLog.e("StudyRoomConfProcessor", 4, paramArrayOfaogf, new Object[0]);
    }
    return localazxi;
  }
  
  public Class<azxi> a()
  {
    return azxi.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "onReqNoReceive: type=" + a() + "curContent:" + a());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
  }
  
  public void a(azxi paramazxi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onUpdate] newConf:" + paramazxi);
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxj
 * JD-Core Version:    0.7.0.1
 */