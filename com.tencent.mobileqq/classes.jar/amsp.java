import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amsp
  extends ampa<amso>
{
  public static amso a()
  {
    amso localamso2 = (amso)ampl.a().a(492);
    amso localamso1 = localamso2;
    if (localamso2 == null) {
      localamso1 = new amso();
    }
    return localamso1;
  }
  
  public int a()
  {
    return 492;
  }
  
  @NonNull
  public amso a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GroupIntimateRelationshipConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amso();
  }
  
  @Nullable
  public amso a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amso localamso = amso.a(paramArrayOfamph[0]);
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamso;
    }
    return new amso();
  }
  
  public Class<amso> a()
  {
    return amso.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(amso paramamso)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramamso);
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
 * Qualified Name:     amsp
 * JD-Core Version:    0.7.0.1
 */