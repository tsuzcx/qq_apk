import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aomy
  extends aofy<aomx>
{
  public int a()
  {
    return 490;
  }
  
  @NonNull
  public aomx a(int paramInt)
  {
    return new aomx();
  }
  
  @Nullable
  public aomx a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aomx localaomx = aomx.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("RelationVipGrayProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaomx;
    }
    return new aomx();
  }
  
  public Class<aomx> a()
  {
    return aomx.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aomx paramaomx) {}
  
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
 * Qualified Name:     aomy
 * JD-Core Version:    0.7.0.1
 */