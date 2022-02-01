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

public class aqee
  implements aqeg
{
  private Cancellable a;
  
  private void a(Context paramContext, aqdu paramaqdu, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramaqdu.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof aqco))
    {
      if (!paramBoolean) {
        a(paramaqdu);
      }
      return;
    }
    ThreadManagerV2.excute(new DefaultItemBuilder.1(this, paramString1, paramContext, paramString2, paramaqdu, paramBoolean), 16, null, true);
  }
  
  private void a(aqdu paramaqdu)
  {
    if ((paramaqdu == null) || (paramaqdu.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      QLog.e("DefaultItemBuilder", 1, "lottie loaded but still null");
      return;
    }
    QLog.d("DefaultItemBuilder", 4, "play animation");
    LottieDrawable localLottieDrawable = (LottieDrawable)paramaqdu.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localLottieDrawable.setRepeatCount(-1);
    localLottieDrawable.playAnimation();
    int i = afur.a(24.0F, paramaqdu.jdField_a_of_type_AndroidWidgetTextView.getResources());
    localLottieDrawable.setBounds(new Rect(0, 0, i, i));
    paramaqdu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramaqdu.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
  }
  
  protected int a(ColorNote paramColorNote)
  {
    int i = 2130840264;
    switch (aqda.a(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      i = 2130844375;
    case 17170432: 
    case 17235968: 
      return i;
    case 16973824: 
      return 2130844317;
    case 17039360: 
      return 2130839215;
    case 16842752: 
      return 2130839216;
    case 16908288: 
      return 2130839217;
    }
    return 2130844128;
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
      if (aqda.b(paramColorNote))
      {
        if (!paramBoolean) {
          break;
        }
        i = 2130839236;
      }
      return i;
      if (paramBoolean)
      {
        i = 2130839228;
      }
      else
      {
        i = 2130839229;
        continue;
        if (paramBoolean)
        {
          i = 2130839222;
        }
        else
        {
          i = 2130839223;
          continue;
          if (paramBoolean)
          {
            i = 2130839225;
          }
          else
          {
            i = 2130839226;
            continue;
            if (paramBoolean)
            {
              i = 2130839234;
            }
            else
            {
              i = 2130839235;
              continue;
              if (paramBoolean)
              {
                i = 2130839231;
              }
              else
              {
                i = 2130839232;
                continue;
                if (paramBoolean) {
                  i = 2130839238;
                } else {
                  i = 2130839239;
                }
              }
            }
          }
        }
      }
    }
    return 2130839237;
  }
  
  public void a(aqdu paramaqdu, int paramInt, boolean paramBoolean)
  {
    localColorNote = paramaqdu.a(paramInt);
    localResources = paramaqdu.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources();
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
        localObject = aqej.a(((URL)localObject).getQuery());
        continue;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = afur.a(40.0F, localResources);
        localURLDrawableOptions.mRequestHeight = afur.a(40.0F, localResources);
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
        paramaqdu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramaqdu.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
        ((aqcn)paramaqdu.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a(300);
        localObject = paramaqdu.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839228;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqdu.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839242);
        continue;
        paramInt = 2130839229;
        continue;
        paramaqdu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqdu.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839222;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqdu.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839240);
        continue;
        paramInt = 2130839223;
        continue;
        paramaqdu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqdu.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839225;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqdu.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839241);
        continue;
        paramInt = 2130839226;
        continue;
        paramaqdu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqdu.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839234;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqdu.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839244);
        continue;
        paramInt = 2130839235;
        continue;
        paramaqdu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramaqdu.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839231;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqdu.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839243);
        continue;
        paramInt = 2130839232;
        continue;
        localObject = paramaqdu.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839238;
        ((View)localObject).setBackgroundResource(paramInt);
        paramaqdu.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839246);
        if (!aqda.c(localColorNote)) {
          continue;
        }
        a(paramaqdu.jdField_a_of_type_AndroidWidgetImageView.getContext(), paramaqdu, "colornote/data_black.json", "colornote/images", false);
        continue;
        paramInt = 2130839239;
        continue;
        paramaqdu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        continue;
        paramInt = 2130839237;
        continue;
      }
      try
      {
        localObject = localResources.getDrawable(Integer.parseInt(((URL)localObject).getHost()));
        paramaqdu.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        bool = aqda.b(localColorNote);
        switch (aqda.a(localColorNote.getServiceType() & 0xFFFF0000))
        {
        default: 
          paramaqdu.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          if (bool)
          {
            localObject = paramaqdu.jdField_a_of_type_AndroidViewView;
            if (paramBoolean)
            {
              paramInt = 2130839236;
              ((View)localObject).setBackgroundResource(paramInt);
            }
          }
          else
          {
            paramaqdu.jdField_a_of_type_AndroidWidgetTextView.setText(localColorNote.getMainTitle());
            paramaqdu.jdField_b_of_type_AndroidWidgetTextView.setText(localColorNote.getSubTitle());
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
        paramColorNote = aqej.a(paramView.getQuery());
        continue;
        paramColorNote = URLDrawable.URLDrawableOptions.obtain();
        paramColorNote.mRequestWidth = afur.a(40.0F, localResources);
        paramColorNote.mRequestHeight = afur.a(40.0F, localResources);
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
 * Qualified Name:     aqee
 * JD-Core Version:    0.7.0.1
 */