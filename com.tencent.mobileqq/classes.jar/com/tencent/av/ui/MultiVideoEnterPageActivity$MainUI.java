package com.tencent.av.ui;

import android.app.Activity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

class MultiVideoEnterPageActivity$MainUI
{
  Button a = null;
  Button b = null;
  RelativeLayout c = null;
  TextView d = null;
  LinearLayout e = null;
  
  void a()
  {
    this.c = null;
    this.d = null;
    this.a = null;
    this.b = null;
    this.e = null;
  }
  
  void a(int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(paramInt);
    }
    localObject = this.d;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(paramInt);
    }
    localObject = this.e;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(paramInt);
    }
    localObject = this.a;
    if (localObject != null) {
      ((Button)localObject).setVisibility(paramInt);
    }
    localObject = this.b;
    if ((localObject != null) && (paramInt != 0)) {
      ((Button)localObject).setVisibility(paramInt);
    }
  }
  
  void a(Activity paramActivity)
  {
    this.c = ((RelativeLayout)paramActivity.findViewById(2131441215));
    this.d = ((TextView)paramActivity.findViewById(2131441049));
    this.a = ((Button)paramActivity.findViewById(2131441080));
    this.b = ((Button)paramActivity.findViewById(2131441073));
    this.e = ((LinearLayout)paramActivity.findViewById(2131441078));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.MainUI
 * JD-Core Version:    0.7.0.1
 */