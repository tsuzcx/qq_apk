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

class asmi
  implements asob
{
  asmi(asmh paramasmh) {}
  
  public boolean a(View paramView, asmu paramasmu)
  {
    if ((paramasmu == null) || (paramView == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramasmu.i))
    {
      Object localObject = (asmg)paramasmu;
      if ((((asmg)localObject).h.equals("needUpload")) || (((asmg)localObject).h.equals("needDel"))) {
        return true;
      }
      if (((asmg)localObject).h.equals("failed"))
      {
        paramView = ((asgf)this.a.a.getManager(333)).a();
        if (paramView != null)
        {
          paramView = paramView.iterator();
          while (paramView.hasNext())
          {
            paramasmu = (CameraEmotionData)paramView.next();
            if (paramasmu.emoId == ((asmg)localObject).g)
            {
              QLog.d("CameraEmotionAdapter", 1, new Object[] { "resend, emoId:", Integer.valueOf(paramasmu.emoId) });
              paramasmu.RomaingType = "needUpload";
              ((asmg)localObject).h = "needUpload";
              ((anuj)this.a.a.a(160)).notifyUI(4, true, null);
              com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.a = false;
              ThreadManager.excute(new CameraEmoSingleSend(paramasmu, true), 64, null, false);
            }
          }
        }
        return true;
      }
      localObject = (URLImageView)paramView.findViewById(2131365947);
      paramView = (ImageView)paramView.findViewById(2131365948);
      if (!(((URLImageView)localObject).getBackground() instanceof URLDrawable)) {
        return false;
      }
      URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getBackground();
      if ((localURLDrawable.getStatus() == 3) || (localURLDrawable.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraEmotionAdapter", 2, "now  cameraemo EmoticonInfo loading failed, restart download " + paramasmu.toString());
        }
        ((URLImageView)localObject).setVisibility(8);
        paramView.setVisibility(0);
        localURLDrawable.restartDownload();
        if (!(paramView.getDrawable() instanceof Animatable)) {
          paramView.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839410));
        }
        ((Animatable)paramView.getDrawable()).start();
        return true;
      }
      if (localURLDrawable.getStatus() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraEmotionAdapter", 2, "now  cameraemo EmoticonInfo loading " + paramasmu.toString());
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmi
 * JD-Core Version:    0.7.0.1
 */