import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bdvr
  extends arac<bdvq>
{
  public static bdvq a()
  {
    return (bdvq)aran.a().a(612);
  }
  
  public static void a()
  {
    aran.a().a(new int[] { 612 });
  }
  
  @NonNull
  public bdvq a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new bdvq();
  }
  
  @Nullable
  public bdvq a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onParsed]");
    }
    bdvq localbdvq = new bdvq();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      paramArrayOfaraj = paramArrayOfaraj[0];
      if ((paramArrayOfaraj == null) || (TextUtils.isEmpty(paramArrayOfaraj.a))) {}
    }
    try
    {
      localbdvq.a = new JSONObject(paramArrayOfaraj.a);
      return localbdvq;
    }
    catch (JSONException paramArrayOfaraj)
    {
      QLog.e("StudyRoomConfProcessor", 4, paramArrayOfaraj, new Object[0]);
    }
    return localbdvq;
  }
  
  public void a(bdvq parambdvq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onUpdate] newConf:" + parambdvq);
    }
  }
  
  public Class<bdvq> clazz()
  {
    return bdvq.class;
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
 * Qualified Name:     bdvr
 * JD-Core Version:    0.7.0.1
 */