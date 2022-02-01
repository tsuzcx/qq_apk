package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class GdtInterstitialFragmentForJS$1
  implements View.OnClickListener
{
  GdtInterstitialFragmentForJS$1(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (GdtInterstitialFragmentForJS.a(this.a) == null)
    {
      localObject = new GdtAdLoader.Session();
      ((GdtAdLoader.Session)localObject).a = GdtInterstitialFragmentForJS.a(this.a);
      GdtInterstitialFragmentForJS localGdtInterstitialFragmentForJS = this.a;
      GdtInterstitialFragmentForJS.a(localGdtInterstitialFragmentForJS, new GdtAdLoader((GdtAdLoader.Session)localObject, new WeakReference(GdtInterstitialFragmentForJS.a(localGdtInterstitialFragmentForJS))));
      GdtInterstitialFragmentForJS.a(this.a).a(new WeakReference(this.a.getBaseActivity()));
      localObject = "loading ad data";
    }
    else
    {
      localObject = "load ad data error";
    }
    Toast.makeText(this.a.getBaseActivity().getApplicationContext(), (CharSequence)localObject, 0).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.1
 * JD-Core Version:    0.7.0.1
 */