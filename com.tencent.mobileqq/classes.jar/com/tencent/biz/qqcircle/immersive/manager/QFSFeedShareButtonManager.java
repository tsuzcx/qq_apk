package com.tencent.biz.qqcircle.immersive.manager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;

public class QFSFeedShareButtonManager
{
  private ImageView a;
  private TextView b;
  private AnimationSet c;
  private String d;
  
  public QFSFeedShareButtonManager(ImageView paramImageView, TextView paramTextView)
  {
    this.a = paramImageView;
    this.b = paramTextView;
  }
  
  private void c()
  {
    if (this.a == null) {
      return;
    }
    QLog.d("QFSFeedShareButtonManager", 1, "[changeShareButton]");
    Drawable localDrawable = this.a.getContext().getResources().getDrawable(2130848861);
    String str = SharePreferenceUtils.a(this.a.getContext(), "share_lately_type_key");
    switch (str.hashCode())
    {
    default: 
      break;
    case 1360627941: 
      if (str.equals("share_type_qq")) {
        i = 0;
      }
      break;
    case -1351410837: 
      if (str.equals("share_type_wechat")) {
        i = 2;
      }
      break;
    case -1433971016: 
      if (str.equals("share_type_qzone")) {
        i = 1;
      }
      break;
    case -1810754954: 
      if (str.equals("share_type_temp_circle")) {
        i = 3;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            localDrawable = this.a.getContext().getResources().getDrawable(2130848864);
          }
        }
        else {
          localDrawable = this.a.getContext().getResources().getDrawable(2130848863);
        }
      }
      else {
        localDrawable = this.a.getContext().getResources().getDrawable(2130848862);
      }
    }
    else {
      localDrawable = this.a.getContext().getResources().getDrawable(2130848861);
    }
    this.a.setImageDrawable(localDrawable);
    this.d = this.b.getText().toString();
    this.b.setText(2131895910);
    this.b.setTextSize(12.0F);
  }
  
  private void d()
  {
    this.c = ((AnimationSet)AnimationUtils.loadAnimation(this.a.getContext(), 2130772348));
    this.a.startAnimation(this.c);
  }
  
  public void a()
  {
    QLog.d("QFSFeedShareButtonManager", 1, "[clearAnim] clear share button status...");
    if (this.a != null)
    {
      TextView localTextView = this.b;
      if (localTextView != null)
      {
        if (this.c == null) {
          return;
        }
        localTextView.setText(this.d);
        this.a.setImageResource(2130845104);
        this.a.clearAnimation();
      }
    }
  }
  
  public void b()
  {
    c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.manager.QFSFeedShareButtonManager
 * JD-Core Version:    0.7.0.1
 */