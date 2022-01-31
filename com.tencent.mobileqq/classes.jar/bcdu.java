import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bcdu
  extends aofy<bcdv>
{
  public static bcdv a()
  {
    bcdv localbcdv = (bcdv)aogj.a().a(547);
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, "getConfigBean configBean = " + localbcdv);
    }
    return localbcdv;
  }
  
  public int a()
  {
    return 547;
  }
  
  @NonNull
  public bcdv a(int paramInt)
  {
    return new bcdv();
  }
  
  @Nullable
  public bcdv a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length == 0)) {
      return null;
    }
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, " onParsed,configID:547, content:" + paramArrayOfaogf);
    }
    return bcdv.a(paramArrayOfaogf);
  }
  
  public Class<bcdv> a()
  {
    return bcdv.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(bcdv parambcdv) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdu
 * JD-Core Version:    0.7.0.1
 */