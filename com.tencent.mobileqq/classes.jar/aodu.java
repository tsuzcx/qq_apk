import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class aodu
  implements aodv
{
  protected int a(ColorNote paramColorNote)
  {
    switch (aocr.a(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      return 2130843981;
    case 16973824: 
      return 2130843926;
    case 17039360: 
      return 2130839045;
    case 16842752: 
      return 2130839046;
    case 16908288: 
      return 2130839047;
    case 17104896: 
      return 2130843763;
    }
    return 2130840085;
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
      if (aocr.b(paramColorNote))
      {
        if (!paramBoolean) {
          break;
        }
        i = 2130839066;
      }
      return i;
      if (paramBoolean)
      {
        i = 2130839058;
      }
      else
      {
        i = 2130839059;
        continue;
        if (paramBoolean)
        {
          i = 2130839052;
        }
        else
        {
          i = 2130839053;
          continue;
          if (paramBoolean)
          {
            i = 2130839055;
          }
          else
          {
            i = 2130839056;
            continue;
            if (paramBoolean)
            {
              i = 2130839064;
            }
            else
            {
              i = 2130839065;
              continue;
              if (paramBoolean) {
                i = 2130839061;
              } else {
                i = 2130839062;
              }
            }
          }
        }
      }
    }
    return 2130839067;
  }
  
  public void a(aodk paramaodk, int paramInt, boolean paramBoolean)
  {
    ColorNote localColorNote = paramaodk.a(paramInt);
    localResources = paramaodk.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources();
    paramInt = a(localColorNote);
    for (;;)
    {
      try
      {
        localObject1 = new URL(localColorNote.getPicUrl());
        bool = "resdrawable".equals(((URL)localObject1).getProtocol());
        if (!bool) {
          continue;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject1;
        boolean bool;
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        localObject2 = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, localMalformedURLException, new Object[0]);
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        Object localObject2 = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, localNullPointerException, new Object[0]);
        continue;
        paramaodk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramaodk.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable, null);
        paramaodk.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(300);
        localObject2 = paramaodk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839058;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramaodk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839070);
        continue;
        paramInt = 2130839059;
        continue;
        paramaodk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramaodk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839052;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramaodk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839068);
        continue;
        paramInt = 2130839053;
        continue;
        paramaodk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramaodk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839055;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramaodk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839069);
        continue;
        paramInt = 2130839056;
        continue;
        paramaodk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramaodk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839064;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramaodk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839072);
        continue;
        paramInt = 2130839065;
        continue;
        paramaodk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramaodk.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839061;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramaodk.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839071);
        continue;
        paramInt = 2130839062;
        continue;
        paramInt = 2130839067;
        continue;
      }
      try
      {
        localObject1 = localResources.getDrawable(Integer.parseInt(((URL)localObject1).getHost()));
        paramaodk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        bool = aocr.b(localColorNote);
        switch (aocr.a(localColorNote.getServiceType() & 0xFFFF0000))
        {
        default: 
          paramaodk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          if (bool)
          {
            localObject1 = paramaodk.jdField_a_of_type_AndroidViewView;
            if (!paramBoolean) {
              continue;
            }
            paramInt = 2130839066;
            ((View)localObject1).setBackgroundResource(paramInt);
          }
          paramaodk.jdField_a_of_type_AndroidWidgetTextView.setText(localColorNote.getMainTitle());
          paramaodk.jdField_b_of_type_AndroidWidgetTextView.setText(localColorNote.getSubTitle());
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject2 = localResources.getDrawable(paramInt);
        continue;
      }
      if ("uindrawable".equals(((URL)localObject2).getProtocol()))
      {
        localObject2 = aody.a(((URL)localObject2).getQuery());
      }
      else
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = aepi.a(40.0F, localResources);
        localURLDrawableOptions.mRequestHeight = aepi.a(40.0F, localResources);
        localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(paramInt);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
      }
    }
  }
  
  public void a(ColorNote paramColorNote, View paramView, ImageView paramImageView, boolean paramBoolean)
  {
    i = a(paramColorNote, paramBoolean);
    if (i != 0) {
      paramView.setBackgroundResource(i);
    }
    paramView = paramView.getContext().getResources();
    i = a(paramColorNote);
    for (;;)
    {
      try
      {
        paramColorNote = new URL(paramColorNote.getPicUrl());
        paramBoolean = "resdrawable".equals(paramColorNote.getProtocol());
        if (!paramBoolean) {
          continue;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        paramColorNote = paramView.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, localMalformedURLException, new Object[0]);
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        paramColorNote = paramView.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, localNullPointerException, new Object[0]);
        continue;
      }
      try
      {
        paramColorNote = paramView.getDrawable(Integer.parseInt(paramColorNote.getHost()));
        paramImageView.setImageDrawable(paramColorNote);
        return;
      }
      catch (NumberFormatException paramColorNote)
      {
        paramColorNote = paramView.getDrawable(i);
        continue;
      }
      if ("uindrawable".equals(paramColorNote.getProtocol()))
      {
        paramColorNote = aody.a(paramColorNote.getQuery());
      }
      else
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = aepi.a(40.0F, paramView);
        localURLDrawableOptions.mRequestHeight = aepi.a(40.0F, paramView);
        localURLDrawableOptions.mLoadingDrawable = paramView.getDrawable(i);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        paramColorNote = URLDrawable.getDrawable(paramColorNote, localURLDrawableOptions);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodu
 * JD-Core Version:    0.7.0.1
 */