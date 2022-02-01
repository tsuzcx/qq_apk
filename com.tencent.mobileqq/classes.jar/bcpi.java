import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bcpi
  extends aptq<bcph>
{
  public static bcph a()
  {
    return (bcph)apub.a().a(612);
  }
  
  public static void a()
  {
    apub.a().a(new int[] { 612 });
  }
  
  @NonNull
  public bcph a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new bcph();
  }
  
  @Nullable
  public bcph a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onParsed]");
    }
    bcph localbcph = new bcph();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      paramArrayOfaptx = paramArrayOfaptx[0];
      if ((paramArrayOfaptx == null) || (TextUtils.isEmpty(paramArrayOfaptx.a))) {}
    }
    try
    {
      localbcph.a = new JSONObject(paramArrayOfaptx.a);
      return localbcph;
    }
    catch (JSONException paramArrayOfaptx)
    {
      QLog.e("StudyRoomConfProcessor", 4, paramArrayOfaptx, new Object[0]);
    }
    return localbcph;
  }
  
  public void a(bcph parambcph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onUpdate] newConf:" + parambcph);
    }
  }
  
  public Class<bcph> clazz()
  {
    return bcph.class;
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
 * Qualified Name:     bcpi
 * JD-Core Version:    0.7.0.1
 */