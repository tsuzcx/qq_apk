import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;

public class ansx
  implements Runnable
{
  public ansx(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void run()
  {
    QQToast.a(this.a.a(), "表情个数已达上限", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansx
 * JD-Core Version:    0.7.0.1
 */