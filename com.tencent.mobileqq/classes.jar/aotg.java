import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.CustomHeightFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aotg
  extends aouc
{
  public aotg(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void d()
  {
    Object localObject = Uri.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    try
    {
      i = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("customheight")).intValue();
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQTranslucentBrowserActivity.class);
      localIntent.putExtra("finish_animation_up_down", true);
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("fragmentClass", CustomHeightFragment.class);
      localIntent.putExtra("customheight", i);
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      if (Build.VERSION.SDK_INT > 16)
      {
        localObject = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_AndroidContentContext, 2130771979, 2130771980).toBundle();
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent, (Bundle)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("CustomHeightWebJumpAction", 1, "error parse custom height " + localException);
        int i = 0;
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localException);
    }
  }
  
  public boolean a()
  {
    try
    {
      if ("jump".equals(this.c)) {
        d();
      }
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("CustomHeightWebJumpAction", 1, "doAction error: " + localException.getMessage());
      a("CustomHeightWebJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotg
 * JD-Core Version:    0.7.0.1
 */