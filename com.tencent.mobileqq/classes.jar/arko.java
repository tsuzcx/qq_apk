import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class arko
  extends arac<arkn>
{
  @NonNull
  public arkn a(int paramInt)
  {
    return new arkn();
  }
  
  @Nullable
  public arkn a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      arkn localarkn2 = arkn.a(paramArrayOfaraj[0].a);
      arkn localarkn1 = localarkn2;
      if (localarkn2 == null) {
        localarkn1 = new arkn();
      }
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogetherConfProcessor", 0, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarkn1;
    }
    return new arkn();
  }
  
  public void a(arkn paramarkn) {}
  
  public Class<arkn> clazz()
  {
    return arkn.class;
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
    return 653;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arko
 * JD-Core Version:    0.7.0.1
 */