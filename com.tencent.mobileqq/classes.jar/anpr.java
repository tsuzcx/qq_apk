import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.QIMCaptureController;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.HashMap;

public class anpr
  implements View.OnClickListener
{
  public anpr(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362497)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c())) {
        QQToast.a(BaseApplicationImpl.getContext(), "分段视频拍摄过程中不支持选择音乐", 0).a();
      }
    }
    do
    {
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      QIMProviderContainerView.a(this.a, i, 0, null, false);
    } while (QIMProviderContainerView.a(this.a) == null);
    QIMProviderContainerView.a(this.a).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpr
 * JD-Core Version:    0.7.0.1
 */