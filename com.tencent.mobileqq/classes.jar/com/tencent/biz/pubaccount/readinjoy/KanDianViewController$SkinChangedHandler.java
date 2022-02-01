package com.tencent.biz.pubaccount.readinjoy;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class KanDianViewController$SkinChangedHandler
  extends Handler
{
  private WeakReference<KanDianViewController> a;
  
  public KanDianViewController$SkinChangedHandler(KanDianViewController paramKanDianViewController)
  {
    this.a = new WeakReference(paramKanDianViewController);
  }
  
  public void handleMessage(Message paramMessage)
  {
    KanDianViewController localKanDianViewController = (KanDianViewController)this.a.get();
    if (localKanDianViewController == null) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          KanDianViewController.a(localKanDianViewController);
          return;
        }
      } while (KanDianViewController.a(localKanDianViewController) == null);
      KanDianViewController.a(localKanDianViewController).a(KanDianViewController.a(localKanDianViewController));
      return;
    } while (KanDianViewController.a(localKanDianViewController) == null);
    KanDianViewController.a(localKanDianViewController).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.SkinChangedHandler
 * JD-Core Version:    0.7.0.1
 */