import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;

public class anmo
  implements View.OnClickListener
{
  anmo(anmn paramanmn) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(false);
    if (anmn.a(this.a).selectedPhotoList.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder(anmn.b(this.a).selectedPhotoList.size() * 128);
        int i = 0;
        while (i < anmn.c(this.a).selectedPhotoList.size())
        {
          paramView.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i), anmn.d(this.a).selectedPhotoList.get(i) }));
          i += 1;
        }
        QLog.d("PhotoPreviewLogicArk", 2, paramView.toString());
      }
      ThreadManagerV2.executeOnSubThread(new PhotoPreviewLogicArk.1.1(this));
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.a.mActivity).finish();
      return;
      anmg.a().a("callbackArk", null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmo
 * JD-Core Version:    0.7.0.1
 */