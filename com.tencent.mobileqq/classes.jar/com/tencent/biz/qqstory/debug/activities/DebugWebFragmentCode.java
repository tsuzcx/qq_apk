package com.tencent.biz.qqstory.debug.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment;
import com.tencent.biz.qqstory.storyHome.proxy.BaseTransitionCode;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DebugWebFragmentCode
  extends BaseTransitionCode
  implements View.OnClickListener
{
  public StoryPlayerWebFragment a;
  public Button b;
  public EditText c;
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    super.a(paramBundle1, paramBundle2);
    a(2131624020);
    this.b = ((Button)b(2131429898));
    this.c = ((EditText)b(2131432359));
    paramBundle1 = ((FragmentActivity)this.d).getSupportFragmentManager().beginTransaction();
    paramBundle2 = new Intent();
    paramBundle2.putExtra("url", "https://h5.weishi.qq.com/weishi/wsplay/recommend?_proxy=1&from=discovery&qzUseTransparentNavBar=1&_wwv=12&_wv=16778243");
    paramBundle2.putExtra("isFullScreen", true);
    this.a = StoryPlayerWebFragment.a(paramBundle2);
    paramBundle1.replace(2131450076, this.a).commit();
    this.c.setText("https://h5.weishi.qq.com/weishi/wsplay/recommend?_proxy=1&from=discovery&qzUseTransparentNavBar=1&_wwv=12&_wv=16778243");
    this.b.setOnClickListener(this);
  }
  
  public void b()
  {
    super.b();
  }
  
  public void c()
  {
    super.c();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131429898)
    {
      String str = this.c.getText().toString();
      this.a.getWebView().loadUrl(str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.debug.activities.DebugWebFragmentCode
 * JD-Core Version:    0.7.0.1
 */