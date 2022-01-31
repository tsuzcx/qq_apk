import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class bjdi
  implements xgx<CLIENT.StBatchGetMusicInfoRsp>
{
  public bjdi(QIMMusicConfigManager paramQIMMusicConfigManager, bjbd parambjbd) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    if ((!paramBoolean) || (paramStBatchGetMusicInfoRsp.vecMusic.size() == 0)) {
      this.jdField_a_of_type_Bjbd.a(false, new FlowMusic());
    }
    while (this.jdField_a_of_type_Bjbd == null) {
      return;
    }
    paramString = new FlowMusic((META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(0));
    QLog.i("QIMMusicConfigManager", 1, "getSingleFullMusicInfo from story success flow info:" + paramString.toString());
    this.jdField_a_of_type_Bjbd.a(true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjdi
 * JD-Core Version:    0.7.0.1
 */