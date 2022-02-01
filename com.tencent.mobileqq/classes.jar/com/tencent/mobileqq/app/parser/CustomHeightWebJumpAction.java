package com.tencent.mobileqq.app.parser;

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
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CustomHeightWebJumpAction
  extends JumpAction
{
  public CustomHeightWebJumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void c()
  {
    Object localObject = Uri.decode((String)this.f.get("url"));
    int i;
    try
    {
      i = Integer.valueOf((String)this.f.get("customheight")).intValue();
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error parse custom height ");
      localStringBuilder.append(localException);
      QLog.e("CustomHeightWebJumpAction", 1, localStringBuilder.toString());
      i = 0;
    }
    Intent localIntent = new Intent(this.b, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("finish_animation_up_down", true);
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("fragmentClass", CustomHeightFragment.class);
    localIntent.putExtra("customheight", i);
    if (!(this.b instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    if (Build.VERSION.SDK_INT > 16)
    {
      localObject = ActivityOptions.makeCustomAnimation(this.b, 2130771996, 2130771997).toBundle();
      this.b.startActivity(localIntent, (Bundle)localObject);
      return;
    }
    this.b.startActivity(localIntent);
  }
  
  public boolean a()
  {
    try
    {
      if ("jump".equals(this.e)) {
        c();
      }
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("CustomHeightWebJumpAction", 1, localStringBuilder.toString());
      h_("CustomHeightWebJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.CustomHeightWebJumpAction
 * JD-Core Version:    0.7.0.1
 */