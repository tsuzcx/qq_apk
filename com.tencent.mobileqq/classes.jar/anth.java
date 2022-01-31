import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdateEvent;

public class anth
  extends QQUIEventReceiver
{
  public anth(@NonNull EditVideoDoodle paramEditVideoDoodle)
  {
    super(paramEditVideoDoodle);
  }
  
  public void a(@NonNull EditVideoDoodle paramEditVideoDoodle, @NonNull DoodleEmojiManager.DoodleEmojiUpdateEvent paramDoodleEmojiUpdateEvent) {}
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anth
 * JD-Core Version:    0.7.0.1
 */