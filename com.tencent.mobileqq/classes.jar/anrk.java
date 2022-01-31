import android.os.Message;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

public final class anrk
  extends MqqHandler
{
  final String a;
  final String b;
  
  public anrk(String paramString1, String paramString2)
  {
    super(ThreadManager.getSubThreadLooper());
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1001: 
      FileUtils.a(QQStoryContext.a().a(), this.a, this.b);
      return;
    }
    FileUtils.b(QQStoryContext.a().a(), new File(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrk
 * JD-Core Version:    0.7.0.1
 */