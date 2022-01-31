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

class anxs
  implements anzd
{
  anxs(anxr paramanxr) {}
  
  public boolean a(View paramView, anyc paramanyc)
  {
    if ((paramanyc == null) || (paramView == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramanyc.h))
    {
      Object localObject = (anxq)paramanyc;
      if ((((anxq)localObject).jdField_g_of_type_JavaLangString.equals("needUpload")) || (((anxq)localObject).jdField_g_of_type_JavaLangString.equals("needDel"))) {
        return true;
      }
      if (((anxq)localObject).jdField_g_of_type_JavaLangString.equals("failed"))
      {
        paramView = ((anrz)this.a.a.getManager(333)).a();
        if (paramView != null)
        {
          paramView = paramView.iterator();
          while (paramView.hasNext())
          {
            paramanyc = (CameraEmotionData)paramView.next();
            if (paramanyc.emoId == ((anxq)localObject).jdField_g_of_type_Int)
            {
              QLog.d("CameraEmotionAdapter", 1, new Object[] { "resend, emoId:", Integer.valueOf(paramanyc.emoId) });
              paramanyc.RomaingType = "needUpload";
              ((anxq)localObject).jdField_g_of_type_JavaLangString = "needUpload";
              ((ajth)this.a.a.a(160)).notifyUI(4, true, null);
              com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.a = false;
              ThreadManager.excute(new CameraEmoSingleSend(paramanyc, true), 64, null, false);
            }
          }
        }
        return true;
      }
      localObject = (URLImageView)paramView.findViewById(2131365584);
      paramView = (ImageView)paramView.findViewById(2131365585);
      if (!(((URLImageView)localObject).getBackground() instanceof URLDrawable)) {
        return false;
      }
      URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getBackground();
      if ((localURLDrawable.getStatus() == 3) || (localURLDrawable.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraEmotionAdapter", 2, "now  cameraemo EmoticonInfo loading failed, restart download " + paramanyc.toString());
        }
        ((URLImageView)localObject).setVisibility(8);
        paramView.setVisibility(0);
        localURLDrawable.restartDownload();
        if (!(paramView.getDrawable() instanceof Animatable)) {
          paramView.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839140));
        }
        ((Animatable)paramView.getDrawable()).start();
        return true;
      }
      if (localURLDrawable.getStatus() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraEmotionAdapter", 2, "now  cameraemo EmoticonInfo loading " + paramanyc.toString());
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxs
 * JD-Core Version:    0.7.0.1
 */