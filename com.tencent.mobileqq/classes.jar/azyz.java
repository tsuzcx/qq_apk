import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class azyz
  extends azza
{
  private Drawable a(View paramView, String paramString)
  {
    if ((paramView != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        paramString = paramView.getClass().getDeclaredField(paramString);
        paramString.setAccessible(true);
        paramView = paramString.get(paramView);
        if ((paramView instanceof Drawable))
        {
          paramView = (Drawable)paramView;
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        QLog.d("GrabMainTabResourceName", 1, paramView, new Object[0]);
      }
    }
    return null;
  }
  
  public List<azys> a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof TabDragAnimationView))
    {
      a(a(paramView, "mBgDrawable"), localArrayList, 0);
      a(a(paramView, "mBgPressedDrawable"), localArrayList, 0);
      a(a(paramView, "mEmotionDrawable"), localArrayList, 0);
      a(a(paramView, "mEmotionPressedDrawable"), localArrayList, 0);
      a(a(paramView, "mClickAnimationDrawable"), localArrayList, 0);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyz
 * JD-Core Version:    0.7.0.1
 */