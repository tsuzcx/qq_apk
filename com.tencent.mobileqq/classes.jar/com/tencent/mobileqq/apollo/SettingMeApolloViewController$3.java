package com.tencent.mobileqq.apollo;

import alnu;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import java.lang.ref.WeakReference;

class SettingMeApolloViewController$3
  implements Runnable
{
  SettingMeApolloViewController$3(SettingMeApolloViewController paramSettingMeApolloViewController, String paramString) {}
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewController.b(this.this$0).get();
    if (localViewGroup == null) {
      return;
    }
    if (this.this$0.b == null)
    {
      this.this$0.b = new FrameGifView(localViewGroup.getContext());
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.a.getLayoutParams();
      localViewGroup.addView(this.this$0.b, localLayoutParams);
    }
    this.this$0.a.setVisibility(8);
    if (this.this$0.b.getVisibility() == 8) {
      this.this$0.b.setVisibility(0);
    }
    if (this.this$0.b.b() == 3)
    {
      this.this$0.b.b();
      return;
    }
    this.this$0.b.setGifData(30, null, this.a, alnu.a(this.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.SettingMeApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */