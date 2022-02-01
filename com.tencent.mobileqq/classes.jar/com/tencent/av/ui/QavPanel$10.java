package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
import com.tencent.av.utils.AudioHelper;

class QavPanel$10
  implements QavMenuActionListener
{
  QavPanel$10(QavPanel paramQavPanel) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.a.k(paramInt);
    if ((paramView instanceof QavBeautyMenuPanel)) {
      ((QavBeautyMenuPanel)paramView).b();
    }
    long l = AudioHelper.c();
    this.a.a(l, paramInt, true);
  }
  
  public void a(View paramView1, View paramView2)
  {
    if (this.a.R != null) {
      this.a.R.onClick(paramView2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.10
 * JD-Core Version:    0.7.0.1
 */