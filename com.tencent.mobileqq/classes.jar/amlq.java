import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amlq
  extends alzl<amlp>
{
  public static amlp a()
  {
    return (amlp)alzw.a().a(338);
  }
  
  public int a()
  {
    return 338;
  }
  
  @NonNull
  public amlp a(int paramInt)
  {
    return new amlp();
  }
  
  @Nullable
  public amlp a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return amlp.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amlp> a()
  {
    return amlp.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocGrayTipsProcessor", 1, "TENCENT_DOC_GRAY_TIPS failed, resultCode:" + paramInt);
  }
  
  public void a(amlp paramamlp) {}
  
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
 * Qualified Name:     amlq
 * JD-Core Version:    0.7.0.1
 */