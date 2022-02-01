import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableColorStateList;
import com.tencent.widget.SingleLineTextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class bbfk
  extends bbfj
{
  private void a(View paramView, List<bbfb> paramList)
  {
    try
    {
      Object localObject = paramView.getClass().getDeclaredField("mTextColor");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramView);
      if ((localObject instanceof SkinnableColorStateList))
      {
        paramView = (SkinnableColorStateList)localObject;
        localObject = new bbfb(3, ((SkinnableColorStateList)localObject).skinData);
        ((bbfb)localObject).jdField_a_of_type_Array2dOfInt = paramView.getStateSpecs();
        ((bbfb)localObject).jdField_a_of_type_ArrayOfInt = paramView.getColors();
        paramList.add(localObject);
      }
      return;
    }
    catch (Exception paramView)
    {
      QLog.d("GrabMainTabResourceName", 1, paramView, new Object[0]);
    }
  }
  
  private void b(View paramView, List<bbfb> paramList)
  {
    try
    {
      Object localObject = paramView.getClass().getDeclaredField("mDrawables");
      ((Field)localObject).setAccessible(true);
      paramView = ((Field)localObject).get(paramView);
      localObject = paramView.getClass().getDeclaredField("mDrawableLeft");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramView);
      if ((localObject instanceof Drawable)) {
        a((Drawable)localObject, paramList, 2);
      }
      localObject = paramView.getClass().getDeclaredField("mDrawableRight");
      ((Field)localObject).setAccessible(true);
      paramView = ((Field)localObject).get(paramView);
      if ((paramView instanceof Drawable)) {
        a((Drawable)paramView, paramList, 2);
      }
      return;
    }
    catch (Exception paramView)
    {
      QLog.d("GrabMainTabResourceName", 1, paramView, new Object[0]);
    }
  }
  
  private void c(View paramView, List<bbfb> paramList)
  {
    try
    {
      Object localObject = paramView.getClass().getDeclaredField("mIconDrawables");
      ((Field)localObject).setAccessible(true);
      paramView = ((Field)localObject).get(paramView);
      if ((paramView instanceof Object[]))
      {
        paramView = (Object[])paramView;
        int j = paramView.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramView[i];
          Field localField = localObject.getClass().getDeclaredField("mDrawable");
          localField.setAccessible(true);
          localObject = localField.get(localObject);
          if ((localObject instanceof Drawable)) {
            a((Drawable)localObject, paramList, 2);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramView)
    {
      QLog.d("GrabMainTabResourceName", 1, paramView, new Object[0]);
    }
  }
  
  public List<bbfb> a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof SingleLineTextView))
    {
      a(paramView, localArrayList);
      b(paramView, localArrayList);
      c(paramView, localArrayList);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfk
 * JD-Core Version:    0.7.0.1
 */