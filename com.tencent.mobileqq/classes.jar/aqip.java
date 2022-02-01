import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class aqip
  extends aqgc<aqio>
{
  @NonNull
  public aqio a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    gb.a();
    bfyz.a(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin(), "vas_font_switch_config", "reset");
    return new aqio();
  }
  
  @NonNull
  public aqio a(aptx[] paramArrayOfaptx)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    gb.a(paramArrayOfaptx[0].a);
    bfyz.a(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin(), "vas_font_switch_config", paramArrayOfaptx[0].a);
    return new aqio();
  }
  
  @NonNull
  public aqio b()
  {
    return new aqio();
  }
  
  public Class<aqio> clazz()
  {
    return aqio.class;
  }
  
  public int type()
  {
    return 359;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqip
 * JD-Core Version:    0.7.0.1
 */