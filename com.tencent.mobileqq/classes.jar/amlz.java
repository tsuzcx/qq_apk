import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amlz
  extends alzl<amlv>
{
  public static amlv a()
  {
    return (amlv)alzw.a().a(525);
  }
  
  public int a()
  {
    return 525;
  }
  
  @NonNull
  public amlv a(int paramInt)
  {
    return new amlv();
  }
  
  @Nullable
  public amlv a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return amlv.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amlv> a()
  {
    return amlv.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocLocalCooperationProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public void a(amlv paramamlv) {}
  
  public int b()
  {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amlz
 * JD-Core Version:    0.7.0.1
 */