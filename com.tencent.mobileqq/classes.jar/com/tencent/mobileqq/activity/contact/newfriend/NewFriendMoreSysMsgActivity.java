package com.tencent.mobileqq.activity.contact.newfriend;

import ahly;
import akkd;
import alxr;
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
  private akkd a;
  
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
    setContentView(2131561115);
    paramBundle = (LinearLayout)findViewById(2131376034);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    paramBundle = (SwipListView)findViewById(2131377344);
    View localView = findViewById(2131371179);
    TextView localTextView = (TextView)findViewById(2131368670);
    localTextView.setVisibility(0);
    localTextView.setText(2131694791);
    setTitle(getString(2131694791));
    localTextView = (TextView)findViewById(2131368624);
    localTextView.setVisibility(0);
    localTextView.setText("");
    localTextView.setOnClickListener(new ahly(this));
    localTextView = (TextView)findViewById(2131368655);
    localTextView.setVisibility(0);
    localTextView.setText(2131699919);
    this.a = new akkd(this, this.app, paramBundle, localView, localTextView, this.mFlingHandler, i);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    alxr localalxr = (alxr)this.app.getManager(34);
    localalxr.g();
    localalxr.k();
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