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

public class aqpu
  implements aqpw
{
  private Cancellable a;
  
  private void a(Context paramContext, aqpk paramaqpk, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramaqpk.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof aqoe))
    {
      if (!paramBoolean) {
        a(paramaqpk);
      }
      return;
    }
    ThreadManagerV2.excute(new DefaultItemBuilder.1(this, paramString1, paramContext, paramString2, paramaqpk, paramBoolean), 16, null, true);
  }
  
  private void a(aqpk paramaqpk)
  {
    if ((paramaqpk == null) || (paramaqpk.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      QLog.e("DefaultItemBuilder", 1, "lottie loaded but still null");
      return;
    }
    QLog.d("DefaultItemBuilder", 4, "play animation");
    LottieDrawable localLottieDrawable = (LottieDrawable)paramaqpk.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localLottieDrawable.setRepeatCount(-1);
    localLottieDrawable.playAnimation();
    int i = AIOUtils.dp2px(24.0F, paramaqpk.jdField_a_of_type_AndroidWidgetTextView.getResources());
    localLottieDrawable.setBounds(new Rect(0, 0, i, i));
    paramaqpk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramaqpk.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
  }
  
  protected int a(ColorNote paramColorNote)
  {
    int i = 2130840348;
    switch (aqoq.a(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      i = 2130844341;
    case 17170432: 
    case 17235968: 
    case 17301504: 
      return i;
    case 16973824: 
      return 2130844283;
    case 17039360: 
      return 2130839279;
    case 16842752: 
      return 2130839280;
    case 16908288: 
      return 2130839281;
    }
    return 2130844080;
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
      if (aqoq.b(paramColorNote))
      {
        if (!paramBoolean) {
          break;
        }
        i = 2130839300;
      }
      return i;
      if (paramBoolean)
      {
        i = 2130839292;
      }
      else
      {
        i = 2130839293;
        continue;
        if (paramBoolean)
        {
          i = 2130839286;
        }
        else
        {
          i = 2130839287;
          continue;
          if (paramBoolean)
          {
            i = 2130839289;
          }
          else
          {
            i = 2130839290;
            continue;
            if (paramBoolean)
            {
              i = 2130839298;
            }
            else
            {
              i = 2130839299;
              continue;
              if (paramBoolean)
              {
                i = 2130839295;
              }
              else
              {
                i = 2130839296;
                continue;
                if (paramBoolean) {
                  i = 2130839302;
                } else {
                  i = 2130839303;
                }
              }
            }
          }
        }
      }
    }
    return 2130839301;
  }
  
  public void a(aqpk paramaqpk, int paramInt, boolean paramBoolean)
  {
    localColorNote = paramaqpk.a(paramInt);
    localResources = paramaqpk.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources();
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
        localObject = aqpz.a(((URL)localObject).getQuery());
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
        paramaqpk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramaqpk.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
        ((aqod)paramaqpk.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a(300);
        localObject = paramaqpk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839292;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqpk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839306);
        continue;
        paramInt = 2130839293;
        continue;
        paramaqpk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqpk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839286;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqpk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839304);
        continue;
        paramInt = 2130839287;
        continue;
        paramaqpk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqpk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839289;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqpk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839305);
        continue;
        paramInt = 2130839290;
        continue;
        paramaqpk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqpk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839298;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqpk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839308);
        continue;
        paramInt = 2130839299;
        continue;
        paramaqpk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqpk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839295;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqpk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839307);
        continue;
        paramInt = 2130839296;
        continue;
        localObject = paramaqpk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839302;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqpk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839310);
        if (!aqoq.c(localColorNote)) {
          continue;
        }
        a(paramaqpk.jdField_a_of_type_AndroidWidgetImageView.getContext(), paramaqpk, "colornote/data_black.json", "colornote/images", false);
        continue;
        paramInt = 2130839303;
        continue;
        paramaqpk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        continue;
        paramInt = 2130839301;
        continue;
      }
      try
      {
        localObject = localResources.getDrawable(Integer.parseInt(((URL)localObject).getHost()));
        paramaqpk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        bool = aqoq.b(localColorNote);
        switch (aqoq.a(localColorNote.getServiceType() & 0xFFFF0000))
        {
        default: 
          paramaqpk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          if (bool)
          {
            localObject = paramaqpk.jdField_a_of_type_AndroidViewView;
            if (paramBoolean)
            {
              paramInt = 2130839300;
              ((View)localObject).setBackgroundResource(paramInt);
            }
          }
          else
          {
            paramaqpk.jdField_a_of_type_AndroidWidgetTextView.setText(localColorNote.getMainTitle());
            paramaqpk.jdField_b_of_type_AndroidWidgetTextView.setText(localColorNote.getSubTitle());
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
        paramColorNote = aqpz.a(paramView.getQuery());
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
 * Qualified Name:     aqpu
 * JD-Core Version:    0.7.0.1
 */