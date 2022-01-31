import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aori
  extends aokh<aorj>
{
  public static aorj a()
  {
    return (aorj)aoks.a().a(564);
  }
  
  public int a()
  {
    return 564;
  }
  
  @NonNull
  public aorj a(int paramInt)
  {
    return new aorj();
  }
  
  @Nullable
  public aorj a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length == 0)) {
      return null;
    }
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor onParsed, content:" + paramArrayOfaoko);
    }
    return aorj.a(paramArrayOfaoko);
  }
  
  public Class<aorj> a()
  {
    return aorj.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aorj paramaorj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (paramaorj != null) {
      aybg.a = (int)(paramaorj.a * 60.0D * 60.0D);
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
 * Qualified Name:     aori
 * JD-Core Version:    0.7.0.1
 */