package com.tencent.mobileqq.activity.contact.newfriend;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import wjq;

public class NewFriendMoreSysMsgActivity
  extends BaseActivity
{
  private NewFriendMoreSysMsgAdapter a;
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, NewFriendMoreSysMsgActivity.class);
    localIntent.putExtra("first_visible_index", paramInt2);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("first_visible_index", 0);
    setContentView(2130970498);
    paramBundle = (LinearLayout)findViewById(2131362840);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    paramBundle = (SwipListView)findViewById(2131370881);
    View localView = findViewById(2131370882);
    TextView localTextView = (TextView)findViewById(2131363381);
    localTextView.setVisibility(0);
    localTextView.setText(2131433325);
    setTitle(getString(2131433325));
    localTextView = (TextView)findViewById(2131363245);
    localTextView.setVisibility(0);
    localTextView.setText(2131433698);
    localTextView.setOnClickListener(new wjq(this));
    this.a = new NewFriendMoreSysMsgAdapter(this, this.app, paramBundle, localView, this.mFlingHandler, i);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ((NewFriendManager)this.app.getManager(33)).e();
    this.a.a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgActivity
 * JD-Core Version:    0.7.0.1
 */