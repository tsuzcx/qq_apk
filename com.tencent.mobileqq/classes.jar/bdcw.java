import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bdcw
  extends aqkz<bdcv>
{
  public static bdcv a()
  {
    return (bdcv)aqlk.a().a(612);
  }
  
  public static void a()
  {
    aqlk.a().a(new int[] { 612 });
  }
  
  @NonNull
  public bdcv a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new bdcv();
  }
  
  @Nullable
  public bdcv a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onParsed]");
    }
    bdcv localbdcv = new bdcv();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      paramArrayOfaqlg = paramArrayOfaqlg[0];
      if ((paramArrayOfaqlg == null) || (TextUtils.isEmpty(paramArrayOfaqlg.a))) {}
    }
    try
    {
      localbdcv.a = new JSONObject(paramArrayOfaqlg.a);
      return localbdcv;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      QLog.e("StudyRoomConfProcessor", 4, paramArrayOfaqlg, new Object[0]);
    }
    return localbdcv;
  }
  
  public void a(bdcv parambdcv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onUpdate] newConf:" + parambdcv);
    }
  }
  
  public Class<bdcv> clazz()
  {
    return bdcv.class;
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
 * Qualified Name:     bdcw
 * JD-Core Version:    0.7.0.1
 */