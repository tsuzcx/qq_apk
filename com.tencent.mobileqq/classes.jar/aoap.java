import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.open.base.ToastUtil;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.tencent.biz.qqstory.takevideo.EditRecognitionPart;

public class aoap
  extends MusicDownloadListener
{
  public aoap(EditRecognitionPart paramEditRecognitionPart) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    ToastUtil.a().a("正在下载: " + EditRecognitionPart.a(this.a));
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (EditRecognitionPart.a(this.a).a().equals(paramString)))
    {
      EditRecognitionPart.a(this.a).sendEmptyMessage(2);
      EditRecognitionPart.a(this.a, EditRecognitionPart.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoap
 * JD-Core Version:    0.7.0.1
 */