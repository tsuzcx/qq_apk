import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class appk
  implements apqy
{
  appk(appj paramappj) {}
  
  public boolean a(View paramView, appw paramappw)
  {
    if ((paramappw == null) || (paramView == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramappw.i))
    {
      Object localObject = (appi)paramappw;
      if ((((appi)localObject).h.equals("needUpload")) || (((appi)localObject).h.equals("needDel"))) {
        return true;
      }
      if (((appi)localObject).h.equals("failed"))
      {
        paramView = ((apjm)this.a.a.getManager(333)).a();
        if (paramView != null)
        {
          paramView = paramView.iterator();
          while (paramView.hasNext())
          {
            paramappw = (CameraEmotionData)paramView.next();
            if (paramappw.emoId == ((appi)localObject).g)
            {
              QLog.d("CameraEmotionAdapter", 1, new Object[] { "resend, emoId:", Integer.valueOf(paramappw.emoId) });
              paramappw.RomaingType = "needUpload";
              ((appi)localObject).h = "needUpload";
              ((alks)this.a.a.a(160)).notifyUI(4, true, null);
              com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.a = false;
              ThreadManager.excute(new CameraEmoSingleSend(paramappw, true), 64, null, false);
            }
          }
        }
        return true;
      }
      localObject = (URLImageView)paramView.findViewById(2131365666);
      paramView = (ImageView)paramView.findViewById(2131365667);
      if (!(((URLImageView)localObject).getBackground() instanceof URLDrawable)) {
        return false;
      }
      URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getBackground();
      if ((localURLDrawable.getStatus() == 3) || (localURLDrawable.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraEmotionAdapter", 2, "now  cameraemo EmoticonInfo loading failed, restart download " + paramappw.toString());
        }
        ((URLImageView)localObject).setVisibility(8);
        paramView.setVisibility(0);
        localURLDrawable.restartDownload();
        if (!(paramView.getDrawable() instanceof Animatable)) {
          paramView.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839224));
        }
        ((Animatable)paramView.getDrawable()).start();
        return true;
      }
      if (localURLDrawable.getStatus() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraEmotionAdapter", 2, "now  cameraemo EmoticonInfo loading " + paramappw.toString());
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appk
 * JD-Core Version:    0.7.0.1
 */