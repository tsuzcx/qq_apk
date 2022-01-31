import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import java.util.HashMap;

public class aoky
  implements Runnable
{
  public aoky(VideoSendTaskManager paramVideoSendTaskManager, HashMap paramHashMap) {}
  
  public void run()
  {
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPreUploadVideoCancel", true, 0L, -1L, this.jdField_a_of_type_JavaUtilHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoky
 * JD-Core Version:    0.7.0.1
 */