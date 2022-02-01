package com.tencent.mobileqq.apollo.api.impl;

import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;
import java.lang.ref.WeakReference;

class SettingMeApolloViewControllerImpl$3
  implements Runnable
{
  SettingMeApolloViewControllerImpl$3(SettingMeApolloViewControllerImpl paramSettingMeApolloViewControllerImpl, String paramString) {}
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewControllerImpl.access$100(this.this$0).get();
    if (localViewGroup == null) {
      return;
    }
    if (this.this$0.mExploreBox == null)
    {
      this.this$0.mExploreBox = new FrameGifView(localViewGroup.getContext());
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.mApolloBoxEnterView.getLayoutParams();
      localViewGroup.addView(this.this$0.mExploreBox, localLayoutParams);
    }
    this.this$0.mApolloBoxEnterView.setVisibility(8);
    if (this.this$0.mExploreBox.getVisibility() == 8) {
      this.this$0.mExploreBox.setVisibility(0);
    }
    if (this.this$0.mExploreBox.b() == 3)
    {
      this.this$0.mExploreBox.b();
      return;
    }
    this.this$0.mExploreBox.setGifData(30, null, this.a, QQFrameZipDecoder.a(this.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.SettingMeApolloViewControllerImpl.3
 * JD-Core Version:    0.7.0.1
 */