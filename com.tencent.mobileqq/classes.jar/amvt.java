import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvt
  extends ampa<amvs>
{
  public int a()
  {
    return 490;
  }
  
  @NonNull
  public amvs a(int paramInt)
  {
    return new amvs();
  }
  
  @Nullable
  public amvs a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amvs localamvs = amvs.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("RelationVipGrayProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamvs;
    }
    return new amvs();
  }
  
  public Class<amvs> a()
  {
    return amvs.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amvs paramamvs) {}
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     amvt
 * JD-Core Version:    0.7.0.1
 */