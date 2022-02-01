package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class QPayReminderActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  private boolean a()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = getIntent();
        if (((Intent)localObject1).getIntExtra("URGENCY", 1) == 1) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847488);
        } else {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847487);
        }
        this.jdField_a_of_type_Int = ((Intent)localObject1).getIntExtra("TEMPLATE", 1);
        localObject1 = new JSONObject(((Intent)localObject1).getStringExtra("CONTENT"));
        setTitle(((JSONObject)localObject1).getJSONObject("title").getString("text"));
        Object localObject2 = ((JSONObject)localObject1).getJSONObject("footnote").getString("text");
        this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject2);
        localObject1 = ((JSONObject)localObject1).getJSONArray("para");
        localObject2 = new SpannableStringBuilder();
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          if ((((JSONArray)localObject1).get(i) instanceof JSONObject))
          {
            JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i).getJSONObject("span");
            int j = ((SpannableStringBuilder)localObject2).length();
            ((SpannableStringBuilder)localObject2).append(localJSONObject.getString("text"));
            int k = ((SpannableStringBuilder)localObject2).length();
            ((SpannableStringBuilder)localObject2).setSpan(new AbsoluteSizeSpan(localJSONObject.getInt("fontsize"), true), j, k, 33);
            ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor(localJSONObject.getString("color"))), j, k, 33);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((SpannableStringBuilder)localObject2).toString());
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      i += 1;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131561965);
    setLeftButton(2131690874, this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131372379));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372373));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372372));
    if (!a()) {
      finish();
    }
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772004, 2130772344);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://imgcache.qq.com/club/mqq/wallet/webank/qf/index.html?_wv=1027&pvsrc=1");
      startActivity((Intent)localObject);
    }
    else
    {
      finish();
    }
    Object localObject = this.app;
    int i;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8004B3F", "0X8004B3F", 0, i, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QPayReminderActivity
 * JD-Core Version:    0.7.0.1
 */