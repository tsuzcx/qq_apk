package com.tencent.mobileqq.activity.contact.newfriend;

import afkg;
import aiof;
import akbo;
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
  private aiof a;
  
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
    setContentView(2131560915);
    paramBundle = (LinearLayout)findViewById(2131375491);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    paramBundle = (SwipListView)findViewById(2131376776);
    View localView = findViewById(2131370850);
    TextView localTextView = (TextView)findViewById(2131368472);
    localTextView.setVisibility(0);
    localTextView.setText(2131694632);
    setTitle(getString(2131694632));
    localTextView = (TextView)findViewById(2131368429);
    localTextView.setVisibility(0);
    localTextView.setText("");
    localTextView.setOnClickListener(new afkg(this));
    localTextView = (TextView)findViewById(2131368457);
    localTextView.setVisibility(0);
    localTextView.setText(2131699541);
    this.a = new aiof(this, this.app, paramBundle, localView, localTextView, this.mFlingHandler, i);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    akbo localakbo = (akbo)this.app.getManager(34);
    localakbo.g();
    localakbo.k();
    this.a.a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgActivity
 * JD-Core Version:    0.7.0.1
 */