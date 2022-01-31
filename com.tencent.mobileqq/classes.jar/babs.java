import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class babs
  extends aokh<babr>
{
  public static babr a()
  {
    return (babr)aoks.a().a(612);
  }
  
  public static void b()
  {
    aoks.a().a(new int[] { 612 });
  }
  
  public int a()
  {
    return 612;
  }
  
  @NonNull
  public babr a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new babr();
  }
  
  @Nullable
  public babr a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onParsed]");
    }
    babr localbabr = new babr();
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      paramArrayOfaoko = paramArrayOfaoko[0];
      if ((paramArrayOfaoko == null) || (TextUtils.isEmpty(paramArrayOfaoko.a))) {}
    }
    try
    {
      localbabr.a = new JSONObject(paramArrayOfaoko.a);
      return localbabr;
    }
    catch (JSONException paramArrayOfaoko)
    {
      QLog.e("StudyRoomConfProcessor", 4, paramArrayOfaoko, new Object[0]);
    }
    return localbabr;
  }
  
  public Class<babr> a()
  {
    return babr.class;
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
  
  public void a(babr parambabr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onUpdate] newConf:" + parambabr);
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
 * Qualified Name:     babs
 * JD-Core Version:    0.7.0.1
 */