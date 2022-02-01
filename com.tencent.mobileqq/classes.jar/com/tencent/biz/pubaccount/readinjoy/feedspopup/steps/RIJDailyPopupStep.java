package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.BasePopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.RIJPopupAutomator;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInjoyFloatingWindowHelper;
import org.jetbrains.annotations.NotNull;

public class RIJDailyPopupStep
  extends BasePopupStep
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean = false;
  
  public RIJDailyPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJDailyPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool3 = true;
    Intent localIntent;
    if (this.jdField_a_of_type_AndroidAppActivity == null)
    {
      localIntent = new Intent();
      bool1 = bool2;
      if (localIntent != null)
      {
        bool1 = bool2;
        if (localIntent.hasExtra("arg_channel_rowkey"))
        {
          bool1 = bool2;
          if (localIntent.hasExtra("arg_channel_article_url"))
          {
            String str1 = localIntent.getStringExtra("arg_channel_rowkey");
            String str2 = localIntent.getStringExtra("arg_channel_article_url");
            if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
              break label218;
            }
            Object localObject = new Bundle();
            ((Bundle)localObject).putString("floating_window_rowkey", str1);
            ((Bundle)localObject).putString("float_layer_article_url", str2);
            ReadInjoyFloatingWindowHelper.a(this.jdField_a_of_type_AndroidAppActivity, 5, 1, (Bundle)localObject, 0);
            if (this.jdField_a_of_type_AndroidAppActivity != null)
            {
              localObject = RIJJumpUtils.a(this.jdField_a_of_type_AndroidAppActivity);
              if (localObject != null) {
                ((RIJTabFrameBase)localObject).b(32);
              }
            }
            QLog.i("RIJDailyPopupStep", 1, "[handleDailyJumpToRecommendChannel], open floating window, rowKey = " + str1 + ", articleURL = " + str2);
          }
        }
      }
    }
    label218:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      localIntent.removeExtra("arg_channel_rowkey");
      localIntent.removeExtra("arg_channel_article_url");
      return bool1;
      localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      break;
    }
  }
  
  public void g()
  {
    a(this.jdField_a_of_type_Boolean);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Boolean = b();
    a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJDailyPopupStep
 * JD-Core Version:    0.7.0.1
 */