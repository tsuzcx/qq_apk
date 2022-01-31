import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amfp
  extends alzl<amfq>
{
  public static amfq a()
  {
    return (amfq)alzw.a().a(564);
  }
  
  public int a()
  {
    return 564;
  }
  
  @NonNull
  public amfq a(int paramInt)
  {
    return new amfq();
  }
  
  @Nullable
  public amfq a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length == 0)) {
      return null;
    }
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor onParsed, content:" + paramArrayOfalzs);
    }
    return amfq.a(paramArrayOfalzs);
  }
  
  public Class<amfq> a()
  {
    return amfq.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amfq paramamfq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (paramamfq != null) {
      avbz.a = (int)(paramamfq.a * 60.0D * 60.0D);
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
 * Qualified Name:     amfp
 * JD-Core Version:    0.7.0.1
 */