import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqsh
  extends aqkz<aqsf>
{
  @NonNull
  public aqsf a(int paramInt)
  {
    return new aqsf();
  }
  
  @Nullable
  public aqsf a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      aqsf localaqsf = aqsf.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfProcessor", 2, "onParsed  " + paramArrayOfaqlg[0].a);
      }
      return localaqsf;
    }
    return null;
  }
  
  public void a(aqsf paramaqsf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onUpdate " + paramaqsf.toString());
    }
  }
  
  public Class<aqsf> clazz()
  {
    return aqsf.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 534;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsh
 * JD-Core Version:    0.7.0.1
 */