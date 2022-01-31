import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvu
  extends ampa<amvv>
{
  public static amvv a()
  {
    return (amvv)ampl.a().a(564);
  }
  
  public int a()
  {
    return 564;
  }
  
  @NonNull
  public amvv a(int paramInt)
  {
    return new amvv();
  }
  
  @Nullable
  public amvv a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length == 0)) {
      return null;
    }
    paramArrayOfamph = paramArrayOfamph[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor onParsed, content:" + paramArrayOfamph);
    }
    return amvv.a(paramArrayOfamph);
  }
  
  public Class<amvv> a()
  {
    return amvv.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amvv paramamvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (paramamvv != null) {
      awbu.a = (int)(paramamvv.a * 60.0D * 60.0D);
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
 * Qualified Name:     amvu
 * JD-Core Version:    0.7.0.1
 */