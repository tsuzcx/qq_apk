import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder.1;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class apmq
  implements apms
{
  private Cancellable a;
  
  private void a(Context paramContext, apmg paramapmg, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramapmg.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof apla))
    {
      if (!paramBoolean) {
        a(paramapmg);
      }
      return;
    }
    ThreadManagerV2.excute(new DefaultItemBuilder.1(this, paramString1, paramContext, paramString2, paramapmg, paramBoolean), 16, null, true);
  }
  
  private void a(apmg paramapmg)
  {
    if ((paramapmg == null) || (paramapmg.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      QLog.e("DefaultItemBuilder", 1, "lottie loaded but still null");
      return;
    }
    QLog.d("DefaultItemBuilder", 4, "play animation");
    LottieDrawable localLottieDrawable = (LottieDrawable)paramapmg.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localLottieDrawable.setRepeatCount(-1);
    localLottieDrawable.playAnimation();
    int i = AIOUtils.dp2px(24.0F, paramapmg.jdField_a_of_type_AndroidWidgetTextView.getResources());
    localLottieDrawable.setBounds(new Rect(0, 0, i, i));
    paramapmg.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramapmg.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
  }
  
  protected int a(ColorNote paramColorNote)
  {
    int i = 2130840312;
    switch (aplm.a(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      i = 2130844274;
    case 17170432: 
    case 17235968: 
    case 17301504: 
      return i;
    case 16973824: 
      return 2130844216;
    case 17039360: 
      return 2130839258;
    case 16842752: 
      return 2130839259;
    case 16908288: 
      return 2130839260;
    }
    return 2130844026;
  }
  
  public int a(ColorNote paramColorNote, boolean paramBoolean)
  {
    int i;
    switch (paramColorNote.getServiceType() & 0xFFFF0000)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (aplm.b(paramColorNote))
      {
        if (!paramBoolean) {
          break;
        }
        i = 2130839279;
      }
      return i;
      if (paramBoolean)
      {
        i = 2130839271;
      }
      else
      {
        i = 2130839272;
        continue;
        if (paramBoolean)
        {
          i = 2130839265;
        }
        else
        {
          i = 2130839266;
          continue;
          if (paramBoolean)
          {
            i = 2130839268;
          }
          else
          {
            i = 2130839269;
            continue;
            if (paramBoolean)
            {
              i = 2130839277;
            }
            else
            {
              i = 2130839278;
              continue;
              if (paramBoolean)
              {
                i = 2130839274;
              }
              else
              {
                i = 2130839275;
                continue;
                if (paramBoolean) {
                  i = 2130839281;
                } else {
                  i = 2130839282;
                }
              }
            }
          }
        }
      }
    }
    return 2130839280;
  }
  
  public void a(apmg paramapmg, int paramInt, boolean paramBoolean)
  {
    localColorNote = paramapmg.a(paramInt);
    localResources = paramapmg.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources();
    paramInt = a(localColorNote);
    for (;;)
    {
      try
      {
        localObject = new URL(localColorNote.getPicUrl());
        bool = "resdrawable".equals(((URL)localObject).getProtocol());
        if (!bool) {
          continue;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        boolean bool;
        localObject = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, localMalformedURLException, new Object[0]);
        continue;
        if (!"uindrawable".equals(((URL)localObject).getProtocol())) {
          continue;
        }
        localObject = apmv.a(((URL)localObject).getQuery());
        continue;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = AIOUtils.dp2px(40.0F, localResources);
        localURLDrawableOptions.mRequestHeight = AIOUtils.dp2px(40.0F, localResources);
        localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(paramInt);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        Object localObject = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, localNullPointerException, new Object[0]);
        continue;
        paramapmg.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramapmg.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
        ((apkz)paramapmg.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a(300);
        localObject = paramapmg.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839271;
        ((View)localObject).setBackgroundResource(paramInt);
        paramapmg.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839285);
        continue;
        paramInt = 2130839272;
        continue;
        paramapmg.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramapmg.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839265;
        ((View)localObject).setBackgroundResource(paramInt);
        paramapmg.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839283);
        continue;
        paramInt = 2130839266;
        continue;
        paramapmg.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramapmg.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839268;
        ((View)localObject).setBackgroundResource(paramInt);
        paramapmg.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839284);
        continue;
        paramInt = 2130839269;
        continue;
        paramapmg.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramapmg.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839277;
        ((View)localObject).setBackgroundResource(paramInt);
        paramapmg.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839287);
        continue;
        paramInt = 2130839278;
        continue;
        paramapmg.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramapmg.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839274;
        ((View)localObject).setBackgroundResource(paramInt);
        paramapmg.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839286);
        continue;
        paramInt = 2130839275;
        continue;
        localObject = paramapmg.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839281;
        ((View)localObject).setBackgroundResource(paramInt);
        paramapmg.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839289);
        if (!aplm.c(localColorNote)) {
          continue;
        }
        a(paramapmg.jdField_a_of_type_AndroidWidgetImageView.getContext(), paramapmg, "colornote/data_black.json", "colornote/images", false);
        continue;
        paramInt = 2130839282;
        continue;
        paramapmg.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        continue;
        paramInt = 2130839280;
        continue;
      }
      try
      {
        localObject = localResources.getDrawable(Integer.parseInt(((URL)localObject).getHost()));
        paramapmg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        bool = aplm.b(localColorNote);
        switch (aplm.a(localColorNote.getServiceType() & 0xFFFF0000))
        {
        default: 
          paramapmg.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          if (bool)
          {
            localObject = paramapmg.jdField_a_of_type_AndroidViewView;
            if (paramBoolean)
            {
              paramInt = 2130839279;
              ((View)localObject).setBackgroundResource(paramInt);
            }
          }
          else
          {
            paramapmg.jdField_a_of_type_AndroidWidgetTextView.setText(localColorNote.getMainTitle());
            paramapmg.jdField_b_of_type_AndroidWidgetTextView.setText(localColorNote.getSubTitle());
            return;
          }
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, "service type: " + localColorNote.getServiceType() + " url error.", localThrowable);
      }
    }
  }
  
  public void a(ColorNote paramColorNote, View paramView, ImageView paramImageView, boolean paramBoolean)
  {
    i = a(paramColorNote, paramBoolean);
    if (i != 0) {
      paramView.setBackgroundResource(i);
    }
    localResources = paramView.getContext().getResources();
    i = a(paramColorNote);
    for (;;)
    {
      try
      {
        paramView = new URL(paramColorNote.getPicUrl());
        paramBoolean = "resdrawable".equals(paramView.getProtocol());
        if (!paramBoolean) {
          continue;
        }
      }
      catch (MalformedURLException paramView)
      {
        paramColorNote = localResources.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, paramView, new Object[0]);
        continue;
        if (!"uindrawable".equals(paramView.getProtocol())) {
          continue;
        }
        paramColorNote = apmv.a(paramView.getQuery());
        continue;
        paramColorNote = URLDrawable.URLDrawableOptions.obtain();
        paramColorNote.mRequestWidth = AIOUtils.dp2px(40.0F, localResources);
        paramColorNote.mRequestHeight = AIOUtils.dp2px(40.0F, localResources);
        paramColorNote.mLoadingDrawable = localResources.getDrawable(i);
        paramColorNote.mFailedDrawable = paramColorNote.mLoadingDrawable;
        paramColorNote = URLDrawable.getDrawable(paramView, paramColorNote);
        continue;
      }
      catch (NullPointerException paramView)
      {
        paramColorNote = localResources.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, paramView, new Object[0]);
        continue;
      }
      try
      {
        paramView = localResources.getDrawable(Integer.parseInt(paramView.getHost()));
        paramColorNote = paramView;
      }
      catch (Throwable localThrowable)
      {
        paramView = localResources.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, "service type: " + paramColorNote.getServiceType() + " url error.", localThrowable);
        paramColorNote = paramView;
      }
    }
    paramImageView.setImageDrawable(paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmq
 * JD-Core Version:    0.7.0.1
 */