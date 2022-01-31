import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bafi
  extends ampa<bafj>
{
  public static bafj a()
  {
    bafj localbafj = (bafj)ampl.a().a(547);
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, "getConfigBean configBean = " + localbafj);
    }
    return localbafj;
  }
  
  public int a()
  {
    return 547;
  }
  
  @NonNull
  public bafj a(int paramInt)
  {
    return new bafj();
  }
  
  @Nullable
  public bafj a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length == 0)) {
      return null;
    }
    paramArrayOfamph = paramArrayOfamph[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, " onParsed,configID:547, content:" + paramArrayOfamph);
    }
    return bafj.a(paramArrayOfamph);
  }
  
  public Class<bafj> a()
  {
    return bafj.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(bafj parambafj) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bafi
 * JD-Core Version:    0.7.0.1
 */