import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amfo
  extends alzl<amfn>
{
  public int a()
  {
    return 490;
  }
  
  @NonNull
  public amfn a(int paramInt)
  {
    return new amfn();
  }
  
  @Nullable
  public amfn a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amfn localamfn = amfn.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("RelationVipGrayProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamfn;
    }
    return new amfn();
  }
  
  public Class<amfn> a()
  {
    return amfn.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amfn paramamfn) {}
  
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
 * Qualified Name:     amfo
 * JD-Core Version:    0.7.0.1
 */