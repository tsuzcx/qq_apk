package com.tencent.av.wtogether.view;

import android.widget.EditText;

class GroupFileSearchDialog$5$1
  implements Runnable
{
  GroupFileSearchDialog$5$1(GroupFileSearchDialog.5 param5) {}
  
  public void run()
  {
    if (this.a.a.u)
    {
      this.a.a.o = null;
      return;
    }
    if (this.a.a.x > 0)
    {
      this.a.a.o = null;
      return;
    }
    this.a.a.w = this.a.a.i.getText().toString().trim().toLowerCase();
    this.a.a.y = null;
    this.a.a.A = 0;
    this.a.a.t = true;
    this.a.a.a(this.a.a.w);
    this.a.a.o = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.5.1
 * JD-Core Version:    0.7.0.1
 */