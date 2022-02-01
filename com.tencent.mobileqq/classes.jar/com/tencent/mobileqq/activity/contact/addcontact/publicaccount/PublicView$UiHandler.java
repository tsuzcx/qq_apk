package com.tencent.mobileqq.activity.contact.addcontact.publicaccount;

import android.os.Handler;
import android.os.Message;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

class PublicView$UiHandler
  extends Handler
{
  private WeakReference<PublicView> a;
  
  public PublicView$UiHandler(PublicView paramPublicView)
  {
    this.a = new WeakReference(paramPublicView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PublicView localPublicView = (PublicView)this.a.get();
    if (localPublicView == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          PublicView.b(localPublicView);
          return;
        }
        PublicView.a(localPublicView, true);
        return;
      }
      PublicView.a(localPublicView).springBackOverScrollHeaderView();
      PublicView.a(localPublicView, 1, 2131719247);
      return;
    }
    PublicView.a(localPublicView).springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView.UiHandler
 * JD-Core Version:    0.7.0.1
 */