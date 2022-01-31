package com.tencent.mobileqq.activity.contact.newfriend;

import ahhj;
import akfo;
import altc;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendMoreSysMsgActivity
  extends BaseActivity
{
  private akfo a;
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, NewFriendMoreSysMsgActivity.class);
    localIntent.putExtra("first_visible_index", paramInt2);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("first_visible_index", 0);
    setContentView(2131561097);
    paramBundle = (LinearLayout)findViewById(2131375981);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    paramBundle = (SwipListView)findViewById(2131377290);
    View localView = findViewById(2131371160);
    TextView localTextView = (TextView)findViewById(2131368659);
    localTextView.setVisibility(0);
    localTextView.setText(2131694789);
    setTitle(getString(2131694789));
    localTextView = (TextView)findViewById(2131368613);
    localTextView.setVisibility(0);
    localTextView.setText("");
    localTextView.setOnClickListener(new ahhj(this));
    localTextView = (TextView)findViewById(2131368644);
    localTextView.setVisibility(0);
    localTextView.setText(2131699907);
    this.a = new akfo(this, this.app, paramBundle, localView, localTextView, this.mFlingHandler, i);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    altc localaltc = (altc)this.app.getManager(34);
    localaltc.g();
    localaltc.k();
    this.a.a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgActivity
 * JD-Core Version:    0.7.0.1
 */