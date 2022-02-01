import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class aqza
  extends aqwr<aqyz>
{
  @NonNull
  public aqyz a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    gc.a();
    bgsg.a(localQQAppInterface.getApp(), localQQAppInterface.c(), "vas_font_switch_config", "reset");
    return new aqyz();
  }
  
  @NonNull
  public aqyz a(aqlg[] paramArrayOfaqlg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    gc.a(paramArrayOfaqlg[0].a);
    bgsg.a(localQQAppInterface.getApp(), localQQAppInterface.c(), "vas_font_switch_config", paramArrayOfaqlg[0].a);
    return new aqyz();
  }
  
  @NonNull
  public aqyz b()
  {
    return new aqyz();
  }
  
  public Class<aqyz> clazz()
  {
    return aqyz.class;
  }
  
  public int type()
  {
    return 359;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqza
 * JD-Core Version:    0.7.0.1
 */