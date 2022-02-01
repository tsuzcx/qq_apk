package com.google.android.material.snackbar;

class BaseTransientBottomBar$10
  implements Runnable
{
  BaseTransientBottomBar$10(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    if (this.this$0.a.getParent() != null) {
      this.this$0.a.setVisibility(0);
    }
    if (this.this$0.a.a() == 1)
    {
      BaseTransientBottomBar.c(this.this$0);
      return;
    }
    BaseTransientBottomBar.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.10
 * JD-Core Version:    0.7.0.1
 */