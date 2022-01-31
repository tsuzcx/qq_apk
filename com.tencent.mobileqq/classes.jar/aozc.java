import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aozc
  extends aokh<aozb>
{
  public static aozb a()
  {
    aozb localaozb2 = (aozb)aoks.a().a(573);
    aozb localaozb1 = localaozb2;
    if (localaozb2 == null) {
      localaozb1 = new aozb();
    }
    return localaozb1;
  }
  
  public int a()
  {
    return 573;
  }
  
  @NonNull
  public aozb a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aozb();
  }
  
  @Nullable
  public aozb a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfaoko.length);
      }
      return aozb.a(paramArrayOfaoko[0]);
    }
    return null;
  }
  
  public Class<aozb> a()
  {
    return aozb.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aozb paramaozb)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaozb == null) {
        break label43;
      }
    }
    label43:
    for (paramaozb = paramaozb.toString();; paramaozb = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramaozb);
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
 * Qualified Name:     aozc
 * JD-Core Version:    0.7.0.1
 */