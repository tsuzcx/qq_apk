import android.os.Handler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import java.util.Collections;
import java.util.List;

public class anmw
  implements DoodleEmojiManager.POIPostersRequestCallback
{
  public anmw(PasterDataManager paramPasterDataManager) {}
  
  public void a(int paramInt, List paramList)
  {
    SLog.b("PasterDataManager", "onPOIPostersRequestResult callback");
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    List localList = paramList;
    if (paramList == null) {
      localList = Collections.EMPTY_LIST;
    }
    Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent(paramInt, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anmw
 * JD-Core Version:    0.7.0.1
 */