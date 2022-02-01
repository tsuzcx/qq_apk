package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Face2FaceAddContactFragment$2
  implements View.OnClickListener
{
  Face2FaceAddContactFragment$2(Face2FaceAddContactFragment paramFace2FaceAddContactFragment) {}
  
  public void onClick(View paramView)
  {
    int i = Face2FaceAddContactFragment.a(this.a).length();
    if (i < 4)
    {
      Face2FaceAddContactFragment.a(this.a, paramView, i);
      i = Face2FaceAddContactFragment.a(this.a).length();
      Face2FaceAddContactFragment.a(this.a, i);
      Face2FaceAddContactFragment.b(this.a, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment.2
 * JD-Core Version:    0.7.0.1
 */