package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Face2FaceAddContactFragment$4
  implements View.OnClickListener
{
  Face2FaceAddContactFragment$4(Face2FaceAddContactFragment paramFace2FaceAddContactFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment.4
 * JD-Core Version:    0.7.0.1
 */