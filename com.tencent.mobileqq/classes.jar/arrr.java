import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arrr
  extends arac<arrq>
{
  public static arrq a()
  {
    arrq localarrq2 = (arrq)aran.a().a(573);
    arrq localarrq1 = localarrq2;
    if (localarrq2 == null) {
      localarrq1 = new arrq();
    }
    return localarrq1;
  }
  
  @NonNull
  public arrq a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arrq();
  }
  
  @Nullable
  public arrq a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
      }
      return arrq.a(paramArrayOfaraj[0]);
    }
    return null;
  }
  
  public void a(arrq paramarrq)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarrq == null) {
        break label43;
      }
    }
    label43:
    for (paramarrq = paramarrq.toString();; paramarrq = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramarrq);
      return;
    }
  }
  
  public Class<arrq> clazz()
  {
    return arrq.class;
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
      QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arrr
 * JD-Core Version:    0.7.0.1
 */