import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class bdcq
{
  public static float a(Context paramContext, float paramFloat)
  {
    return paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F * paramFloat;
  }
  
  @SuppressLint({"NewApi"})
  public static int a(Context paramContext)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      i = ((ActivityManager)paramContext.getSystemService("activity")).getLauncherLargeIconSize();
    }
    int j = (int)paramContext.getResources().getDimension(17104896);
    if (QLog.isColorLevel()) {
      QLog.d("DisplayUtils", 2, "launcher icon size = " + i + " , app icon size = " + j);
    }
    return Math.max(i, j);
  }
  
  public static int a(TextView paramTextView, int paramInt)
  {
    if ((paramTextView != null) && (paramTextView.getText() != null) && (paramInt > 0))
    {
      TextPaint localTextPaint = paramTextView.getPaint();
      return new StaticLayout(paramTextView.getText().toString(), localTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).getLineCount();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcq
 * JD-Core Version:    0.7.0.1
 */