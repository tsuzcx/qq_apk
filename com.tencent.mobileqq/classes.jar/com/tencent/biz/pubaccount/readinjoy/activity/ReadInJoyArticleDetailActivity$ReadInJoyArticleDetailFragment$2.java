package com.tencent.biz.pubaccount.readinjoy.activity;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import beey;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import nya;

public class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$2
  implements Runnable
{
  ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$2(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment) {}
  
  public void run()
  {
    if ((IPluginAdapterProxy.getProxy().isNightMode()) && (this.this$0.jdField_a_of_type_Beey.c != null)) {
      this.this$0.jdField_a_of_type_Beey.c.setBackgroundColor(-1);
    }
    if (this.this$0.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.animate().alpha(0.0F).setDuration(200L).setListener(new nya(this));
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.animate().start();
      }
    }
    else {
      return;
    }
    this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */