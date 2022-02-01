package com.tencent.mobileqq.apollo.drawer.impl;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
    Object localObject1 = (ViewGroup)SettingMeApolloViewControllerImpl.access$500(this.this$0).get();
    if (localObject1 == null) {
      return;
    }
    if (this.this$0.mExploreBox == null)
    {
      this.this$0.mExploreBox = new FrameGifView(((ViewGroup)localObject1).getContext());
      localObject2 = (RelativeLayout.LayoutParams)this.this$0.mApolloBoxEnterView.getLayoutParams();
      ((ViewGroup)localObject1).addView(this.this$0.mExploreBox, (ViewGroup.LayoutParams)localObject2);
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
    localObject1 = this.this$0.mExploreBox;
    Object localObject2 = this.a;
    ((FrameGifView)localObject1).setGifData(30, null, (String)localObject2, QQFrameZipDecoder.a((String)localObject2), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl.3
 * JD-Core Version:    0.7.0.1
 */