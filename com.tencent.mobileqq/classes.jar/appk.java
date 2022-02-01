import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class appk
{
  public static int a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("UniformUtils", 0).getInt(paramString, 0);
  }
  
  public static void a(Context paramContext, View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i = ImmersiveUtils.getStatusBarHeight(paramContext);
      paramContext = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      paramContext.topMargin = i;
      paramView.setLayoutParams(paramContext);
    }
  }
  
  public static void a(Context paramContext, View paramView, boolean paramBoolean, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i;
    if (ScreenUtil.checkDeviceHasNavigationBar(paramContext))
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      i = paramInt;
      if (paramBoolean) {
        i = paramInt + ScreenUtil.getNavigationBarHeight(paramContext);
      }
      if (localMarginLayoutParams.bottomMargin != i) {}
    }
    else
    {
      return;
    }
    localMarginLayoutParams.bottomMargin = i;
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  public static void a(String paramString, int paramInt)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("UniformUtils", 0).edit().putInt(paramString, paramInt).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appk
 * JD-Core Version:    0.7.0.1
 */