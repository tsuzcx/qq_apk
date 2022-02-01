import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arby
  extends aqwt<arbx>
{
  public static arbx a()
  {
    return (arbx)aqxe.a().a(489);
  }
  
  @NonNull
  public arbx a(int paramInt)
  {
    return new arbx();
  }
  
  @Nullable
  public arbx a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arbx.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arbx paramarbx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onUpdate " + paramarbx.toString());
    }
  }
  
  public Class<arbx> clazz()
  {
    return arbx.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqNoReceive ");
    }
  }
  
  public int type()
  {
    return 489;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arby
 * JD-Core Version:    0.7.0.1
 */