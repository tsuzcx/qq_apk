import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoha
  extends aofy<aohb>
{
  public int a()
  {
    return 537;
  }
  
  @NonNull
  public aohb a(int paramInt)
  {
    return new aohb();
  }
  
  @Nullable
  public aohb a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      paramArrayOfaogf = paramArrayOfaogf[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed, content:" + paramArrayOfaogf);
      }
      return aohb.a(paramArrayOfaogf);
    }
    return new aohb();
  }
  
  public Class a()
  {
    return aohb.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(aohb paramaohb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onUpdate");
    }
    azqe.a().a(paramaohb);
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
 * Qualified Name:     aoha
 * JD-Core Version:    0.7.0.1
 */