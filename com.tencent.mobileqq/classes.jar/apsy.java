import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class apsy
  implements apqy
{
  apsy(apsx paramapsx) {}
  
  public boolean a(View paramView, appw paramappw)
  {
    if ((paramappw == null) || (paramView == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramappw.i))
    {
      Object localObject1 = apsx.a(this.a, paramappw);
      int i = apsx.a(this.a, paramappw);
      if ((((String)localObject1).equals("needUpload")) || (((String)localObject1).equals("needDel"))) {
        return true;
      }
      Object localObject2;
      if (((String)localObject1).equals("failed"))
      {
        paramView = ((apke)this.a.a.getManager(149)).a().iterator();
        while (paramView.hasNext())
        {
          localObject1 = (CustomEmotionData)paramView.next();
          if (((CustomEmotionData)localObject1).emoId == i)
          {
            QLog.d("FavoriteEmotionAdapter", 1, new Object[] { "resend, emoId:", Integer.valueOf(((CustomEmotionData)localObject1).emoId) });
            localObject2 = (alnm)this.a.a.a(72);
            if ((((CustomEmotionData)localObject1).emoOriginalPath != null) && (!apkd.a(((CustomEmotionData)localObject1).emoOriginalPath)))
            {
              ((alnm)localObject2).notifyUI(2, true, Integer.valueOf(1));
            }
            else
            {
              ((CustomEmotionData)localObject1).RomaingType = "needUpload";
              apsx.a(this.a, paramappw, "needUpload");
              ((alnm)localObject2).notifyUI(2, true, null);
              com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
              ThreadManager.excute(new FavEmoSingleSend((CustomEmotionData)localObject1, true), 64, null, false);
            }
          }
        }
        return true;
      }
      localObject1 = (URLImageView)paramView.findViewById(2131365666);
      paramView = (URLImageView)paramView.findViewById(2131365667);
      if ((((URLImageView)localObject1).getDrawable() instanceof URLDrawable))
      {
        localObject2 = (URLDrawable)((URLImageView)localObject1).getDrawable();
        if ((((URLDrawable)localObject2).getStatus() == 3) || (((URLDrawable)localObject2).getStatus() == 2))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FavoriteEmotionAdapter", 2, "now  favorite EmoticonInfo loading failed, restart download " + paramappw.toString());
          }
          ((URLImageView)localObject1).setVisibility(8);
          paramView.setVisibility(0);
          ((URLDrawable)localObject2).restartDownload();
          if (!(paramView.getDrawable() instanceof Animatable))
          {
            paramappw = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839224);
            paramView.setImageDrawable((Drawable)paramappw);
            paramappw.start();
          }
          for (;;)
          {
            return true;
            ((Animatable)paramView.getDrawable()).start();
          }
        }
        if (((URLDrawable)localObject2).getStatus() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FavoriteEmotionAdapter", 2, "now  favorite EmoticonInfo loading " + paramappw.toString());
          }
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsy
 * JD-Core Version:    0.7.0.1
 */