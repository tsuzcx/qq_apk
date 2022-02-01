package com.tencent.biz.qrcode.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

class QRDisplayActivity$MyViewAlphaOnTouchListener
  implements View.OnTouchListener
{
  private QRDisplayActivity$MyViewAlphaOnTouchListener(QRDisplayActivity paramQRDisplayActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if (this.a.t == 1)
    {
      i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i == 1) || (i == 3)) {
          if ((2131442870 == paramView.getId()) && (this.a.N != null) && (this.a.O != null))
          {
            this.a.N.setAlpha(1.0F);
            this.a.O.setAlpha(1.0F);
          }
          else if ((2131442887 == paramView.getId()) && (this.a.Q != null) && (this.a.R != null))
          {
            this.a.Q.setAlpha(1.0F);
            this.a.R.setAlpha(1.0F);
          }
          else if ((2131442894 == paramView.getId()) && (this.a.U != null) && (this.a.V != null))
          {
            this.a.U.setAlpha(1.0F);
            this.a.V.setAlpha(1.0F);
          }
        }
      }
      else if ((2131442870 == paramView.getId()) && (this.a.N != null) && (this.a.O != null))
      {
        this.a.N.setAlpha(0.5F);
        this.a.O.setAlpha(0.5F);
      }
      else if ((2131442887 == paramView.getId()) && (this.a.Q != null) && (this.a.R != null))
      {
        this.a.Q.setAlpha(0.5F);
        this.a.R.setAlpha(0.5F);
      }
      else if ((2131442894 == paramView.getId()) && (this.a.U != null) && (this.a.V != null))
      {
        this.a.U.setAlpha(0.5F);
        this.a.V.setAlpha(0.5F);
      }
    }
    else if (this.a.t == 2)
    {
      i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i == 1) || (i == 3)) {
          if ((2131442899 == paramView.getId()) && (this.a.Y != null) && (this.a.Z != null))
          {
            this.a.Y.setAlpha(1.0F);
            this.a.Z.setAlpha(1.0F);
          }
          else if ((2131442873 == paramView.getId()) && (this.a.N != null) && (this.a.O != null))
          {
            this.a.N.setAlpha(1.0F);
            this.a.O.setAlpha(1.0F);
          }
        }
      }
      else if ((2131442899 == paramView.getId()) && (this.a.Y != null) && (this.a.Z != null))
      {
        this.a.Y.setAlpha(0.5F);
        this.a.Z.setAlpha(0.5F);
      }
      else if ((2131442873 == paramView.getId()) && (this.a.N != null) && (this.a.O != null))
      {
        this.a.N.setAlpha(0.5F);
        this.a.O.setAlpha(0.5F);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.MyViewAlphaOnTouchListener
 * JD-Core Version:    0.7.0.1
 */