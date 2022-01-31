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

public class amik
  implements amil
{
  protected int a(ColorNote paramColorNote)
  {
    switch (amhh.a(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      return 2130843550;
    case 16973824: 
      return 2130843495;
    case 17039360: 
      return 2130838964;
    case 16842752: 
      return 2130838965;
    case 16908288: 
      return 2130838966;
    case 17104896: 
      return 2130843338;
    }
    return 2130839736;
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
      if (amhh.b(paramColorNote))
      {
        if (!paramBoolean) {
          break;
        }
        i = 2130838985;
      }
      return i;
      if (paramBoolean)
      {
        i = 2130838977;
      }
      else
      {
        i = 2130838978;
        continue;
        if (paramBoolean)
        {
          i = 2130838971;
        }
        else
        {
          i = 2130838972;
          continue;
          if (paramBoolean)
          {
            i = 2130838974;
          }
          else
          {
            i = 2130838975;
            continue;
            if (paramBoolean)
            {
              i = 2130838983;
            }
            else
            {
              i = 2130838984;
              continue;
              if (paramBoolean) {
                i = 2130838980;
              } else {
                i = 2130838981;
              }
            }
          }
        }
      }
    }
    return 2130838986;
  }
  
  public void a(amia paramamia, int paramInt, boolean paramBoolean)
  {
    ColorNote localColorNote = paramamia.a(paramInt);
    localResources = paramamia.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources();
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
        paramamia.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramamia.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable, null);
        paramamia.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(300);
        localObject2 = paramamia.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130838977;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramamia.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838989);
        continue;
        paramInt = 2130838978;
        continue;
        paramamia.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramamia.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130838971;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramamia.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838987);
        continue;
        paramInt = 2130838972;
        continue;
        paramamia.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramamia.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130838974;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramamia.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838988);
        continue;
        paramInt = 2130838975;
        continue;
        paramamia.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramamia.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130838983;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramamia.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838991);
        continue;
        paramInt = 2130838984;
        continue;
        paramamia.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject2 = paramamia.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130838980;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramamia.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838990);
        continue;
        paramInt = 2130838981;
        continue;
        paramInt = 2130838986;
        continue;
      }
      try
      {
        localObject1 = localResources.getDrawable(Integer.parseInt(((URL)localObject1).getHost()));
        paramamia.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        bool = amhh.b(localColorNote);
        switch (amhh.a(localColorNote.getServiceType() & 0xFFFF0000))
        {
        default: 
          paramamia.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          if (bool)
          {
            localObject1 = paramamia.jdField_a_of_type_AndroidViewView;
            if (!paramBoolean) {
              continue;
            }
            paramInt = 2130838985;
            ((View)localObject1).setBackgroundResource(paramInt);
          }
          paramamia.jdField_a_of_type_AndroidWidgetTextView.setText(localColorNote.getMainTitle());
          paramamia.jdField_b_of_type_AndroidWidgetTextView.setText(localColorNote.getSubTitle());
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
        localObject2 = amio.a(((URL)localObject2).getQuery());
      }
      else
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = actj.a(40.0F, localResources);
        localURLDrawableOptions.mRequestHeight = actj.a(40.0F, localResources);
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
        paramColorNote = amio.a(paramColorNote.getQuery());
      }
      else
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = actj.a(40.0F, paramView);
        localURLDrawableOptions.mRequestHeight = actj.a(40.0F, paramView);
        localURLDrawableOptions.mLoadingDrawable = paramView.getDrawable(i);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        paramColorNote = URLDrawable.getDrawable(paramColorNote, localURLDrawableOptions);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amik
 * JD-Core Version:    0.7.0.1
 */