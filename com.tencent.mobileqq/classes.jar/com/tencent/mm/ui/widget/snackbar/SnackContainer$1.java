package com.tencent.mm.ui.widget.snackbar;

class SnackContainer$1
  implements Runnable
{
  SnackContainer$1(SnackContainer paramSnackContainer) {}
  
  public void run()
  {
    if (this.a.getVisibility() == 0)
    {
      SnackContainer localSnackContainer = this.a;
      localSnackContainer.startAnimation(SnackContainer.a(localSnackContainer));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer.1
 * JD-Core Version:    0.7.0.1
 */