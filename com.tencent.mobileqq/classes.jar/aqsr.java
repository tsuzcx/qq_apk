import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import mqq.app.AppRuntime;

public class aqsr
  implements aqsi
{
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      ((aixd)localQQAppInterface.getManager(365)).a(paramContext, paramColorNote);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsr
 * JD-Core Version:    0.7.0.1
 */