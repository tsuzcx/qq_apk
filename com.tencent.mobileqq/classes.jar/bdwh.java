import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bdwh
  extends aqwt<bdwg>
{
  public static bdwg a()
  {
    return (bdwg)aqxe.a().a(612);
  }
  
  public static void a()
  {
    aqxe.a().a(new int[] { 612 });
  }
  
  @NonNull
  public bdwg a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new bdwg();
  }
  
  @Nullable
  public bdwg a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onParsed]");
    }
    bdwg localbdwg = new bdwg();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0];
      if ((paramArrayOfaqxa == null) || (TextUtils.isEmpty(paramArrayOfaqxa.a))) {}
    }
    try
    {
      localbdwg.a = new JSONObject(paramArrayOfaqxa.a);
      return localbdwg;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      QLog.e("StudyRoomConfProcessor", 4, paramArrayOfaqxa, new Object[0]);
    }
    return localbdwg;
  }
  
  public void a(bdwg parambdwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onUpdate] newConf:" + parambdwg);
    }
  }
  
  public Class<bdwg> clazz()
  {
    return bdwg.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + a());
    }
  }
  
  public int type()
  {
    return 612;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwh
 * JD-Core Version:    0.7.0.1
 */