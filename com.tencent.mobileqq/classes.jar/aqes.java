import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Locale;

public class aqes
  implements View.OnClickListener
{
  aqes(aqer paramaqer) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(false);
    if (aqer.a(this.a).selectedPhotoList.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(aqer.b(this.a).selectedPhotoList.size() * 128);
        int i = 0;
        while (i < aqer.c(this.a).selectedPhotoList.size())
        {
          localStringBuilder.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i), aqer.d(this.a).selectedPhotoList.get(i) }));
          i += 1;
        }
        QLog.d("PhotoPreviewLogicArk", 2, localStringBuilder.toString());
      }
      ThreadManagerV2.executeOnSubThread(new PhotoPreviewLogicArk.1.1(this));
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.a.mActivity).finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aqel.a().a("callbackArk", null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqes
 * JD-Core Version:    0.7.0.1
 */