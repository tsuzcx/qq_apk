import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

final class bhkn
  implements axcc
{
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localAppRuntime instanceof QQAppInterface));
    MediaPlayerManager.a((QQAppInterface)localAppRuntime).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhkn
 * JD-Core Version:    0.7.0.1
 */