import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arcc
  extends aqkz<arcb>
{
  public static arcb a()
  {
    arcb localarcb2 = (arcb)aqlk.a().a(573);
    arcb localarcb1 = localarcb2;
    if (localarcb2 == null) {
      localarcb1 = new arcb();
    }
    return localarcb1;
  }
  
  @NonNull
  public arcb a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arcb();
  }
  
  @Nullable
  public arcb a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfaqlg.length);
      }
      return arcb.a(paramArrayOfaqlg[0]);
    }
    return null;
  }
  
  public void a(arcb paramarcb)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarcb == null) {
        break label43;
      }
    }
    label43:
    for (paramarcb = paramarcb.toString();; paramarcb = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramarcb);
      return;
    }
  }
  
  public Class<arcb> clazz()
  {
    return arcb.class;
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
 * Qualified Name:     arcc
 * JD-Core Version:    0.7.0.1
 */