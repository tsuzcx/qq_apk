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

public class amja
{
  private int a(ColorNote paramColorNote)
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
    }
    return 2130843338;
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
      localURLDrawableOptions.mRequestWidth = actj.a(40.0F, paramContext);
      localURLDrawableOptions.mRequestHeight = actj.a(40.0F, paramContext);
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
    localHistoryFormItem.setLeftIcon(a(paramContext, paramColorNote), paramContext.getResources().getDimensionPixelSize(2131298672), paramContext.getResources().getDimensionPixelSize(2131298671));
    return localHistoryFormItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amja
 * JD-Core Version:    0.7.0.1
 */