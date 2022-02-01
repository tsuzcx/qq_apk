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
  public Button a;
  public EditText a;
  public StoryPlayerWebFragment a;
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    super.a(paramBundle1, paramBundle2);
    a(2131558477);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131363942));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131366081));
    paramBundle1 = ((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getSupportFragmentManager().beginTransaction();
    paramBundle2 = new Intent();
    paramBundle2.putExtra("url", "https://h5.weishi.qq.com/weishi/wsplay/recommend?_proxy=1&from=discovery&qzUseTransparentNavBar=1&_wwv=12&_wv=16778243");
    paramBundle2.putExtra("isFullScreen", true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetStoryPlayerWebFragment = StoryPlayerWebFragment.a(paramBundle2);
    paramBundle1.replace(2131381065, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetStoryPlayerWebFragment).commit();
    this.jdField_a_of_type_AndroidWidgetEditText.setText("https://h5.weishi.qq.com/weishi/wsplay/recommend?_proxy=1&from=discovery&qzUseTransparentNavBar=1&_wwv=12&_wv=16778243");
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
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
    if (paramView.getId() == 2131363942)
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetStoryPlayerWebFragment.getWebView().loadUrl(str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.debug.activities.DebugWebFragmentCode
 * JD-Core Version:    0.7.0.1
 */