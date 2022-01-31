import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.voicechange.IVoiceChangeListener;
import dov.com.tencent.biz.qqstory.takevideo.music.BlessVoiceChangeManager;
import dov.com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import java.io.File;

public class aolk
  implements IVoiceChangeListener
{
  private QQStoryMusicInfo jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public aolk(QQStoryMusicInfo paramQQStoryMusicInfo, String paramString)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = paramQQStoryMusicInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void b()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_JavaLangString.lastIndexOf(".af")).concat("_").concat(String.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.c)).concat(".pcm"));
    if (((File)localObject).exists())
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      FileUtils.a((File)localObject, new File(this.jdField_a_of_type_JavaLangString));
      if (BlessVoiceChangeManager.a() != null)
      {
        localObject = BlessVoiceChangeManager.a().obtainMessage(10);
        ((Message)localObject).obj = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
        BlessVoiceChangeManager.a().sendMessage((Message)localObject);
      }
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aolk
 * JD-Core Version:    0.7.0.1
 */