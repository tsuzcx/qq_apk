package com.tencent.gdtad.jsbridge;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class GdtInterstitialFragmentForJS$1
  implements View.OnClickListener
{
  GdtInterstitialFragmentForJS$1(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (GdtInterstitialFragmentForJS.a(this.a) == null)
    {
      str = "loading ad data";
      GdtAdLoader.Session localSession = new GdtAdLoader.Session();
      localSession.a = GdtInterstitialFragmentForJS.a(this.a);
      GdtInterstitialFragmentForJS.a(this.a, new GdtAdLoader(localSession, new WeakReference(GdtInterstitialFragmentForJS.a(this.a))));
      GdtInterstitialFragmentForJS.a(this.a).a(new WeakReference(this.a.getActivity()));
    }
    for (;;)
    {
      Toast.makeText(this.a.getActivity().getApplicationContext(), str, 0).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = "load ad data error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.1
 * JD-Core Version:    0.7.0.1
 */