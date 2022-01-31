import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditRecognitionPart;

public class anrx
  implements View.OnClickListener
{
  public anrx(EditRecognitionPart paramEditRecognitionPart) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "mRecognitionBubble onClick: invoked. ");
    }
    paramView = ((QimMusicPlayer)QIMManager.a().c(8)).b();
    if ((MusicProviderView.a) && (paramView != null) && (paramView.a != EditRecognitionPart.a(this.a).a) && (paramView.d == 5))
    {
      this.a.c();
      return;
    }
    EditRecognitionPart.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrx
 * JD-Core Version:    0.7.0.1
 */