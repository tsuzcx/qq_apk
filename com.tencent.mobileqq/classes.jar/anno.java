import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;

public class anno
  implements Runnable
{
  public anno(TroopHomeworkHelper.UploadFileTask paramUploadFileTask) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getApplication(), "上传的语音、图片、视频数量达到了今日上限。", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anno
 * JD-Core Version:    0.7.0.1
 */