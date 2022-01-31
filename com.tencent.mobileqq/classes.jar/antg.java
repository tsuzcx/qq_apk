import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiDownloadEvent;

public class antg
  extends QQUIEventReceiver
{
  public antg(@NonNull EditVideoDoodle paramEditVideoDoodle)
  {
    super(paramEditVideoDoodle);
  }
  
  public void a(@NonNull EditVideoDoodle paramEditVideoDoodle, @NonNull DoodleEmojiManager.DoodleEmojiDownloadEvent paramDoodleEmojiDownloadEvent) {}
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiDownloadEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     antg
 * JD-Core Version:    0.7.0.1
 */