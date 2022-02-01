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
  public StoryPromoteTaskManager a;
  public EditText b;
  public EditText c;
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    super.a(paramBundle1, paramBundle2);
    this.a = ((StoryPromoteTaskManager)SuperManager.a(29));
    a(2131624019);
    b(2131429892).setOnClickListener(this);
    b(2131429942).setOnClickListener(this);
    b(2131429835).setOnClickListener(this);
    b(2131429973).setOnClickListener(this);
    this.b = ((EditText)b(2131432358));
    this.c = ((EditText)b(2131432324));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131429973: 
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.4(this, this.c.getText().toString(), this.b.getText().toString()));
      break;
    case 2131429942: 
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.2(this), true);
      break;
    case 2131429892: 
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.1(this), true);
      break;
    case 2131429839: 
      this.c.getText().toString();
      this.b.getText().toString();
      this.c.getText().clear();
      this.b.getText().clear();
      new QQStoryEntityManagerFactory(BaseApplicationImpl.getApplication().getRuntime().getAccount()).a();
      break;
    case 2131429835: 
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.3(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode
 * JD-Core Version:    0.7.0.1
 */