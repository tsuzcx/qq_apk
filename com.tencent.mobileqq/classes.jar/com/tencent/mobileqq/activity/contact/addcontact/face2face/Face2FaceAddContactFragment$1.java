package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;

class Face2FaceAddContactFragment$1
  extends Handler
{
  Face2FaceAddContactFragment$1(Face2FaceAddContactFragment paramFace2FaceAddContactFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 5)
    {
      Face2FaceAddContactFragment.a(this.a).setText(2131889148);
      Face2FaceAddContactFragment.b(this.a).setVisibility(8);
      Face2FaceAddContactFragment.c(this.a).setVisibility(0);
      return;
    }
    if (paramMessage.what == 301)
    {
      Face2FaceAddContactFragment.d(this.a);
      return;
    }
    if (paramMessage.what == 500)
    {
      Face2FaceAddContactFragment.e(this.a);
      return;
    }
    if (paramMessage.what == 401)
    {
      removeMessages(301);
      this.a.d();
      return;
    }
    if (paramMessage.what == 6)
    {
      Face2FaceAddContactFragment.f(this.a);
      QQToast.makeText(this.a.getBaseActivity(), this.a.getString(2131887994), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment.1
 * JD-Core Version:    0.7.0.1
 */