package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb$SetIndicatorInfo
{
  public Method setHomeActionContentDescription;
  public Method setHomeAsUpIndicator;
  public ImageView upIndicatorView;
  
  ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(Activity paramActivity)
  {
    try
    {
      this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[] { Drawable.class });
      this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[] { Integer.TYPE });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label46:
      Object localObject;
      break label46;
    }
    paramActivity = paramActivity.findViewById(16908332);
    if (paramActivity == null) {
      return;
    }
    localObject = (ViewGroup)paramActivity.getParent();
    if (((ViewGroup)localObject).getChildCount() != 2) {
      return;
    }
    paramActivity = ((ViewGroup)localObject).getChildAt(0);
    localObject = ((ViewGroup)localObject).getChildAt(1);
    if (paramActivity.getId() == 16908332) {
      paramActivity = (Activity)localObject;
    }
    if ((paramActivity instanceof ImageView)) {
      this.upIndicatorView = ((ImageView)paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo
 * JD-Core Version:    0.7.0.1
 */