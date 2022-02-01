import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder.1;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class aqth
  implements aqtj
{
  private Cancellable a;
  
  private void a(Context paramContext, aqsx paramaqsx, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramaqsx.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof aqrr))
    {
      if (!paramBoolean) {
        a(paramaqsx);
      }
      return;
    }
    ThreadManagerV2.excute(new DefaultItemBuilder.1(this, paramString1, paramContext, paramString2, paramaqsx, paramBoolean), 16, null, true);
  }
  
  private void a(aqsx paramaqsx)
  {
    if ((paramaqsx == null) || (paramaqsx.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      QLog.e("DefaultItemBuilder", 1, "lottie loaded but still null");
      return;
    }
    QLog.d("DefaultItemBuilder", 4, "play animation");
    LottieDrawable localLottieDrawable = (LottieDrawable)paramaqsx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localLottieDrawable.setRepeatCount(-1);
    localLottieDrawable.playAnimation();
    int i = agej.a(24.0F, paramaqsx.jdField_a_of_type_AndroidWidgetTextView.getResources());
    localLottieDrawable.setBounds(new Rect(0, 0, i, i));
    paramaqsx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramaqsx.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
  }
  
  protected int a(ColorNote paramColorNote)
  {
    int i = 2130840274;
    switch (aqsd.a(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      i = 2130844389;
    case 17170432: 
    case 17235968: 
    case 17301504: 
      return i;
    case 16973824: 
      return 2130844331;
    case 17039360: 
      return 2130839223;
    case 16842752: 
      return 2130839224;
    case 16908288: 
      return 2130839225;
    }
    return 2130844142;
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
      if (aqsd.b(paramColorNote))
      {
        if (!paramBoolean) {
          break;
        }
        i = 2130839244;
      }
      return i;
      if (paramBoolean)
      {
        i = 2130839236;
      }
      else
      {
        i = 2130839237;
        continue;
        if (paramBoolean)
        {
          i = 2130839230;
        }
        else
        {
          i = 2130839231;
          continue;
          if (paramBoolean)
          {
            i = 2130839233;
          }
          else
          {
            i = 2130839234;
            continue;
            if (paramBoolean)
            {
              i = 2130839242;
            }
            else
            {
              i = 2130839243;
              continue;
              if (paramBoolean)
              {
                i = 2130839239;
              }
              else
              {
                i = 2130839240;
                continue;
                if (paramBoolean) {
                  i = 2130839246;
                } else {
                  i = 2130839247;
                }
              }
            }
          }
        }
      }
    }
    return 2130839245;
  }
  
  public void a(aqsx paramaqsx, int paramInt, boolean paramBoolean)
  {
    localColorNote = paramaqsx.a(paramInt);
    localResources = paramaqsx.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources();
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
        localObject = aqtm.a(((URL)localObject).getQuery());
        continue;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = agej.a(40.0F, localResources);
        localURLDrawableOptions.mRequestHeight = agej.a(40.0F, localResources);
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
        paramaqsx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramaqsx.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
        ((aqrq)paramaqsx.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a(300);
        localObject = paramaqsx.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839236;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqsx.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839250);
        continue;
        paramInt = 2130839237;
        continue;
        paramaqsx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqsx.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839230;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqsx.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839248);
        continue;
        paramInt = 2130839231;
        continue;
        paramaqsx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqsx.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839233;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqsx.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839249);
        continue;
        paramInt = 2130839234;
        continue;
        paramaqsx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqsx.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839242;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqsx.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839252);
        continue;
        paramInt = 2130839243;
        continue;
        paramaqsx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqsx.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839239;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqsx.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839251);
        continue;
        paramInt = 2130839240;
        continue;
        localObject = paramaqsx.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839246;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqsx.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839254);
        if (!aqsd.c(localColorNote)) {
          continue;
        }
        a(paramaqsx.jdField_a_of_type_AndroidWidgetImageView.getContext(), paramaqsx, "colornote/data_black.json", "colornote/images", false);
        continue;
        paramInt = 2130839247;
        continue;
        paramaqsx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        continue;
        paramInt = 2130839245;
        continue;
      }
      try
      {
        localObject = localResources.getDrawable(Integer.parseInt(((URL)localObject).getHost()));
        paramaqsx.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        bool = aqsd.b(localColorNote);
        switch (aqsd.a(localColorNote.getServiceType() & 0xFFFF0000))
        {
        default: 
          paramaqsx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          if (bool)
          {
            localObject = paramaqsx.jdField_a_of_type_AndroidViewView;
            if (paramBoolean)
            {
              paramInt = 2130839244;
              ((View)localObject).setBackgroundResource(paramInt);
            }
          }
          else
          {
            paramaqsx.jdField_a_of_type_AndroidWidgetTextView.setText(localColorNote.getMainTitle());
            paramaqsx.jdField_b_of_type_AndroidWidgetTextView.setText(localColorNote.getSubTitle());
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
        paramColorNote = aqtm.a(paramView.getQuery());
        continue;
        paramColorNote = URLDrawable.URLDrawableOptions.obtain();
        paramColorNote.mRequestWidth = agej.a(40.0F, localResources);
        paramColorNote.mRequestHeight = agej.a(40.0F, localResources);
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
 * Qualified Name:     aqth
 * JD-Core Version:    0.7.0.1
 */