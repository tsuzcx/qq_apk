import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class aoek
{
  private int a(ColorNote paramColorNote)
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
    }
    return 2130843763;
  }
  
  private Drawable a(Context paramContext, ColorNote paramColorNote)
  {
    paramContext = paramContext.getResources();
    int i = a(paramColorNote);
    try
    {
      paramColorNote = new URL(paramColorNote.getPicUrl());
      boolean bool = "resdrawable".equals(paramColorNote.getProtocol());
      if (bool) {
        try
        {
          paramColorNote = paramContext.getDrawable(Integer.parseInt(paramColorNote.getHost()));
          return paramColorNote;
        }
        catch (NumberFormatException paramColorNote)
        {
          return paramContext.getDrawable(i);
        }
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = aepi.a(40.0F, paramContext);
      localURLDrawableOptions.mRequestHeight = aepi.a(40.0F, paramContext);
      localURLDrawableOptions.mLoadingDrawable = paramContext.getDrawable(i);
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      paramColorNote = URLDrawable.getDrawable(paramColorNote, localURLDrawableOptions);
      return paramColorNote;
    }
    catch (MalformedURLException paramColorNote)
    {
      paramContext = paramContext.getDrawable(i);
      QLog.e("DefaultFormItemBuilder", 1, paramColorNote, new Object[0]);
      return paramContext;
    }
    catch (NullPointerException paramColorNote)
    {
      paramContext = paramContext.getDrawable(i);
      QLog.e("DefaultFormItemBuilder", 1, paramColorNote, new Object[0]);
    }
    return paramContext;
  }
  
  public HistoryFormItem a(Context paramContext, ColorNote paramColorNote)
  {
    HistoryFormItem localHistoryFormItem = new HistoryFormItem(paramContext);
    localHistoryFormItem.setLeftText(paramColorNote.getMainTitle());
    localHistoryFormItem.setLeftIcon(a(paramContext, paramColorNote), paramContext.getResources().getDimensionPixelSize(2131298700), paramContext.getResources().getDimensionPixelSize(2131298699));
    return localHistoryFormItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoek
 * JD-Core Version:    0.7.0.1
 */