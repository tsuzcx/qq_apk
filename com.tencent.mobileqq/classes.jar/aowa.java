import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class aowa
  extends aouf<aovz>
{
  public int a()
  {
    return 359;
  }
  
  @NonNull
  public aovz a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    fx.a();
    bdne.a(localQQAppInterface.getApp(), localQQAppInterface.c(), "vas_font_switch_config", "reset");
    return new aovz();
  }
  
  @NonNull
  public aovz a(aoko[] paramArrayOfaoko)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    fx.a(paramArrayOfaoko[0].a);
    bdne.a(localQQAppInterface.getApp(), localQQAppInterface.c(), "vas_font_switch_config", paramArrayOfaoko[0].a);
    return new aovz();
  }
  
  public Class<aovz> a()
  {
    return aovz.class;
  }
  
  @NonNull
  public aovz b()
  {
    return new aovz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aowa
 * JD-Core Version:    0.7.0.1
 */