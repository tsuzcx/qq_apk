package com.tencent.biz.qqstory.debug.activities;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.model.StoryPromoteTaskManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.proxy.BaseTransitionCode;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class DebugPromoteTaskCode
  extends BaseTransitionCode
  implements View.OnClickListener
{
  public EditText a;
  public StoryPromoteTaskManager a;
  public EditText b;
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    super.a(paramBundle1, paramBundle2);
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryPromoteTaskManager = ((StoryPromoteTaskManager)SuperManager.a(29));
    a(2131558448);
    a(2131364009).setOnClickListener(this);
    a(2131364060).setOnClickListener(this);
    a(2131363959).setOnClickListener(this);
    a(2131364095).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131366179));
    this.b = ((EditText)a(2131366144));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.1(this), true);
      continue;
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.2(this), true);
      continue;
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.3(this));
      continue;
      this.b.getText().toString();
      this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      this.b.getText().clear();
      this.jdField_a_of_type_AndroidWidgetEditText.getText().clear();
      new QQStoryEntityManagerFactory(BaseApplicationImpl.getApplication().getRuntime().getAccount()).a();
      continue;
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.4(this, this.b.getText().toString(), this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode
 * JD-Core Version:    0.7.0.1
 */