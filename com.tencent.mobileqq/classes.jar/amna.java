import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amna
  extends alzl<ammz>
{
  public static ammz a()
  {
    ammz localammz2 = (ammz)alzw.a().a(573);
    ammz localammz1 = localammz2;
    if (localammz2 == null) {
      localammz1 = new ammz();
    }
    return localammz1;
  }
  
  public int a()
  {
    return 573;
  }
  
  @NonNull
  public ammz a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new ammz();
  }
  
  @Nullable
  public ammz a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfalzs.length);
      }
      return ammz.a(paramArrayOfalzs[0]);
    }
    return null;
  }
  
  public Class<ammz> a()
  {
    return ammz.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(ammz paramammz)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramammz == null) {
        break label43;
      }
    }
    label43:
    for (paramammz = paramammz.toString();; paramammz = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramammz);
      return;
    }
  }
  
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
 * Qualified Name:     amna
 * JD-Core Version:    0.7.0.1
 */