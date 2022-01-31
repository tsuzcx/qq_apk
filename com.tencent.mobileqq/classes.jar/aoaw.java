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

class aoaw
  implements anzd
{
  aoaw(aoav paramaoav) {}
  
  public boolean a(View paramView, anyc paramanyc)
  {
    if ((paramanyc == null) || (paramView == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramanyc.h))
    {
      Object localObject1 = aoav.a(this.a, paramanyc);
      int i = aoav.a(this.a, paramanyc);
      if ((((String)localObject1).equals("needUpload")) || (((String)localObject1).equals("needDel"))) {
        return true;
      }
      Object localObject2;
      if (((String)localObject1).equals("failed"))
      {
        paramView = ((ansr)this.a.a.getManager(149)).a().iterator();
        while (paramView.hasNext())
        {
          localObject1 = (CustomEmotionData)paramView.next();
          if (((CustomEmotionData)localObject1).emoId == i)
          {
            QLog.d("FavoriteEmotionAdapter", 1, new Object[] { "resend, emoId:", Integer.valueOf(((CustomEmotionData)localObject1).emoId) });
            localObject2 = (ajwa)this.a.a.a(72);
            if ((((CustomEmotionData)localObject1).emoOriginalPath != null) && (!ansq.a(((CustomEmotionData)localObject1).emoOriginalPath)))
            {
              ((ajwa)localObject2).notifyUI(2, true, Integer.valueOf(1));
            }
            else
            {
              ((CustomEmotionData)localObject1).RomaingType = "needUpload";
              aoav.a(this.a, paramanyc, "needUpload");
              ((ajwa)localObject2).notifyUI(2, true, null);
              com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
              ThreadManager.excute(new FavEmoSingleSend((CustomEmotionData)localObject1, true), 64, null, false);
            }
          }
        }
        return true;
      }
      localObject1 = (URLImageView)paramView.findViewById(2131365584);
      paramView = (URLImageView)paramView.findViewById(2131365585);
      if ((((URLImageView)localObject1).getDrawable() instanceof URLDrawable))
      {
        localObject2 = (URLDrawable)((URLImageView)localObject1).getDrawable();
        if ((((URLDrawable)localObject2).getStatus() == 3) || (((URLDrawable)localObject2).getStatus() == 2))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FavoriteEmotionAdapter", 2, "now  favorite EmoticonInfo loading failed, restart download " + paramanyc.toString());
          }
          ((URLImageView)localObject1).setVisibility(8);
          paramView.setVisibility(0);
          ((URLDrawable)localObject2).restartDownload();
          if (!(paramView.getDrawable() instanceof Animatable))
          {
            paramanyc = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839140);
            paramView.setImageDrawable((Drawable)paramanyc);
            paramanyc.start();
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
            QLog.i("FavoriteEmotionAdapter", 2, "now  favorite EmoticonInfo loading " + paramanyc.toString());
          }
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoaw
 * JD-Core Version:    0.7.0.1
 */