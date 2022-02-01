package com.tencent.aelight.camera.ae.album.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic.IcheckBoxCallback;

public class AEAbstractPhotoListFragment$PhotoItemClickListener
  implements View.OnClickListener
{
  int a;
  CheckBox b;
  
  public AEAbstractPhotoListFragment$PhotoItemClickListener(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment) {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.b = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.c.a.j != null) {
      this.c.a.j.a(paramView, this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoItemClickListener
 * JD-Core Version:    0.7.0.1
 */