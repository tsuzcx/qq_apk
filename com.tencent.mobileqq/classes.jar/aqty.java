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

public class aqty
{
  private int a(ColorNote paramColorNote)
  {
    switch (aqsd.a(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      return 2130844389;
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
  
  private Drawable a(Context paramContext, ColorNote paramColorNote)
  {
    paramContext = paramContext.getResources();
    int i = a(paramColorNote);
    try
    {
      Object localObject = new URL(paramColorNote.getPicUrl());
      boolean bool = "resdrawable".equals(((URL)localObject).getProtocol());
      if (bool) {
        try
        {
          localObject = paramContext.getDrawable(Integer.parseInt(((URL)localObject).getHost()));
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          Drawable localDrawable = paramContext.getDrawable(i);
          QLog.e("DefaultFormItemBuilder", 1, "service type: " + paramColorNote.getServiceType() + " url error.", localThrowable);
          return localDrawable;
        }
      }
      return paramContext;
    }
    catch (MalformedURLException paramColorNote)
    {
      paramContext = paramContext.getDrawable(i);
      QLog.e("DefaultFormItemBuilder", 1, paramColorNote, new Object[0]);
      return paramContext;
      paramColorNote = URLDrawable.URLDrawableOptions.obtain();
      paramColorNote.mRequestWidth = agej.a(40.0F, paramContext);
      paramColorNote.mRequestHeight = agej.a(40.0F, paramContext);
      paramColorNote.mLoadingDrawable = paramContext.getDrawable(i);
      paramColorNote.mFailedDrawable = paramColorNote.mLoadingDrawable;
      paramColorNote = URLDrawable.getDrawable(localThrowable, paramColorNote);
      return paramColorNote;
    }
    catch (NullPointerException paramColorNote)
    {
      paramContext = paramContext.getDrawable(i);
      QLog.e("DefaultFormItemBuilder", 1, paramColorNote, new Object[0]);
    }
  }
  
  public HistoryFormItem a(Context paramContext, ColorNote paramColorNote)
  {
    HistoryFormItem localHistoryFormItem = new HistoryFormItem(paramContext);
    localHistoryFormItem.setLeftText(paramColorNote.getMainTitle());
    localHistoryFormItem.setLeftIcon(a(paramContext, paramColorNote), paramContext.getResources().getDimensionPixelSize(2131298796), paramContext.getResources().getDimensionPixelSize(2131298795));
    return localHistoryFormItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqty
 * JD-Core Version:    0.7.0.1
 */