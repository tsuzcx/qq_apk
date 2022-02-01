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
    Object localObject1 = (ViewGroup)SettingMeApolloViewControllerImpl.access$600(this.this$0).get();
    if (localObject1 == null) {
      return;
    }
    if (SettingMeApolloViewControllerImpl.access$1100(this.this$0) == null)
    {
      SettingMeApolloViewControllerImpl.access$1102(this.this$0, new FrameGifView(((ViewGroup)localObject1).getContext()));
      localObject2 = (RelativeLayout.LayoutParams)SettingMeApolloViewControllerImpl.access$1200(this.this$0).getLayoutParams();
      ((ViewGroup)localObject1).addView(SettingMeApolloViewControllerImpl.access$1100(this.this$0), (ViewGroup.LayoutParams)localObject2);
    }
    SettingMeApolloViewControllerImpl.access$1200(this.this$0).setVisibility(8);
    if (SettingMeApolloViewControllerImpl.access$1100(this.this$0).getVisibility() == 8) {
      SettingMeApolloViewControllerImpl.access$1100(this.this$0).setVisibility(0);
    }
    if (SettingMeApolloViewControllerImpl.access$1100(this.this$0).getState() == 3)
    {
      SettingMeApolloViewControllerImpl.access$1100(this.this$0).c();
      return;
    }
    localObject1 = SettingMeApolloViewControllerImpl.access$1100(this.this$0);
    Object localObject2 = this.a;
    ((FrameGifView)localObject1).setGifData(30, null, (String)localObject2, QQFrameZipDecoder.a((String)localObject2), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl.3
 * JD-Core Version:    0.7.0.1
 */