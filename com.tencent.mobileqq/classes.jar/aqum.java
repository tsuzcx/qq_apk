import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CountDownProgressBar;
import java.io.File;

public class aqum
  implements Handler.Callback
{
  public aqum(HotChatFlashPicActivity paramHotChatFlashPicActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "handleMessage,msg:" + paramMessage.what);
    }
    Object localObject;
    switch (paramMessage.what)
    {
    case 6: 
    default: 
    case 1: 
    case 0: 
    case 2: 
    case 3: 
      do
      {
        int i;
        do
        {
          return false;
          HotChatFlashPicActivity.a(this.a).setVisibility(0);
          HotChatFlashPicActivity.a(this.a).setOnTouchListener(this.a);
          HotChatFlashPicActivity.b(this.a).setVisibility(0);
          HotChatFlashPicActivity.a(this.a).setImageResource(2130842566);
          if (HotChatFlashPicActivity.b(this.a)) {
            HotChatFlashPicActivity.a(this.a).setText(2131692989);
          }
          while (HotChatFlashPicActivity.a(this.a).a())
          {
            HotChatFlashPicActivity.a(this.a).b();
            return false;
            HotChatFlashPicActivity.a(this.a).setText(2131690905);
          }
          localObject = (String)paramMessage.obj;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramMessage = new File((String)localObject);
            if ((!((String)localObject).endsWith(HotChatFlashPicActivity.a(this.a).c)) && (HotChatFlashPicActivity.a(this.a).d))
            {
              if (!HotChatFlashPicActivity.a(this.a).b)
              {
                HotChatFlashPicActivity.a(this.a, true);
                HotChatFlashPicActivity.a(this.a).a(HotChatFlashPicActivity.a(this.a).jdField_f_of_type_Long, HotChatFlashPicActivity.a(this.a).jdField_f_of_type_Int, 2);
                return false;
              }
              HotChatFlashPicActivity.a(this.a).sendEmptyMessage(1);
              return false;
            }
            localObject = URLDrawable.URLDrawableOptions.obtain();
            DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
            ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = localDisplayMetrics.widthPixels;
            ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = localDisplayMetrics.heightPixels;
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
            ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = true;
            ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
            paramMessage = URLDrawable.getDrawable(paramMessage, (URLDrawable.URLDrawableOptions)localObject);
            HotChatFlashPicActivity.a(this.a).setTag(paramMessage);
            HotChatFlashPicActivity.a(this.a).setVisibility(0);
            HotChatFlashPicActivity.a(this.a).setOnTouchListener(this.a);
            if (HotChatFlashPicActivity.c(this.a)) {
              HotChatFlashPicActivity.b(this.a).setVisibility(0);
            }
            HotChatFlashPicActivity.c(this.a, true);
            HotChatFlashPicActivity.a(this.a).setImageResource(2130842568);
            if (HotChatFlashPicActivity.b(this.a)) {
              HotChatFlashPicActivity.a(this.a).setText(2131692993);
            }
            while (HotChatFlashPicActivity.a(this.a).a())
            {
              HotChatFlashPicActivity.a(this.a).b();
              return false;
              HotChatFlashPicActivity.a(this.a).setText(2131690913);
            }
          }
          HotChatFlashPicActivity.a(this.a).sendEmptyMessage(1);
          return false;
          i = paramMessage.arg1;
        } while ((!HotChatFlashPicActivity.a(this.a).a()) || (HotChatFlashPicActivity.a(this.a).d));
        HotChatFlashPicActivity.a(this.a).a(i);
        return false;
      } while (HotChatFlashPicActivity.d(this.a));
      HotChatFlashPicActivity.d(this.a, true);
      HotChatFlashPicActivity.b(this.a).setVisibility(8);
      if (HotChatFlashPicActivity.a(this.a).getTag() != null)
      {
        HotChatFlashPicActivity.a(this.a).setVisibility(0);
        HotChatFlashPicActivity.a(this.a).setImageDrawable((URLDrawable)HotChatFlashPicActivity.a(this.a).getTag());
      }
      HotChatFlashPicActivity.a(this.a).setVisibility(0);
      HotChatFlashPicActivity.a(this.a).a();
      HotChatFlashPicActivity.a(this.a).b(HotChatFlashPicActivity.a(this.a));
      return false;
    case 4: 
      if (HotChatFlashPicActivity.b(this.a)) {
        if (HotChatFlashPicActivity.a(this.a) >= 2) {
          paramMessage = this.a.getString(2131692992);
        }
      }
      break;
    }
    for (;;)
    {
      HotChatFlashPicActivity.a(this.a, bfur.a(this.a, paramMessage, 0, 2131718436, null, new aqun(this)));
      if (this.a.isFinishing()) {
        break;
      }
      HotChatFlashPicActivity.d(this.a, false);
      HotChatFlashPicActivity.a(this.a).setVisibility(8);
      HotChatFlashPicActivity.a(this.a).setVisibility(8);
      HotChatFlashPicActivity.a(this.a).setVisibility(8);
      HotChatFlashPicActivity.a(this.a).show();
      return false;
      paramMessage = this.a.getString(2131692991);
      continue;
      if (HotChatFlashPicActivity.a(this.a) == 2)
      {
        paramMessage = this.a.getString(2131690912);
        localObject = paramMessage;
        if (!HotChatFlashPicActivity.e(this.a))
        {
          if (HotChatFlashPicActivity.b(this.a) == 0)
          {
            bcef.b(this.a.app, "dc00898", "", "", "0X80069A3", "0X80069A3", 0, 0, "", "", "", "");
            continue;
          }
          if (HotChatFlashPicActivity.b(this.a) == 3000)
          {
            bcef.b(this.a.app, "dc00898", "", "", "0X80069A4", "0X80069A4", 0, 0, "", "", "", "");
            continue;
          }
          localObject = paramMessage;
          if (HotChatFlashPicActivity.b(this.a) == 1) {
            bcef.b(this.a.app, "dc00898", "", "", "0X80069A5", "0X80069A5", 0, 0, "", "", "", "");
          }
        }
      }
      else if (HotChatFlashPicActivity.a(this.a) < 2)
      {
        paramMessage = this.a.getString(2131690907);
        localObject = paramMessage;
        if (!HotChatFlashPicActivity.e(this.a))
        {
          if (HotChatFlashPicActivity.b(this.a) == 0)
          {
            bcef.b(this.a.app, "dc00898", "", "", "0X80069A0", "0X80069A0", 0, 0, "", "", "", "");
            continue;
          }
          if (HotChatFlashPicActivity.b(this.a) == 3000)
          {
            bcef.b(this.a.app, "dc00898", "", "", "0X80069A1", "0X80069A1", 0, 0, "", "", "", "");
            continue;
          }
          localObject = paramMessage;
          if (HotChatFlashPicActivity.b(this.a) == 1) {
            bcef.b(this.a.app, "dc00898", "", "", "0X80069A2", "0X80069A2", 0, 0, "", "", "", "");
          }
        }
      }
      else
      {
        paramMessage = HotChatFlashPicActivity.e(this.a);
        continue;
        HotChatFlashPicActivity.a(this.a, (Bitmap)paramMessage.obj);
        return false;
        if ((HotChatFlashPicActivity.a(this.a).a()) || (HotChatFlashPicActivity.c(this.a))) {
          break;
        }
        HotChatFlashPicActivity.a(this.a).a();
        HotChatFlashPicActivity.a(this.a).a(HotChatFlashPicActivity.c(this.a));
        return false;
        if ((HotChatFlashPicActivity.a(this.a) == null) || (HotChatFlashPicActivity.a(this.a).getBitmap() == null)) {
          break;
        }
        HotChatFlashPicActivity.a(this.a).getBitmap().recycle();
        HotChatFlashPicActivity.a(this.a, null);
        return false;
      }
      paramMessage = (Message)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqum
 * JD-Core Version:    0.7.0.1
 */