package com.google.android.material.snackbar;

class BaseTransientBottomBar$10
  implements Runnable
{
  BaseTransientBottomBar$10(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      return;
    }
    if (this.this$0.b.getParent() != null) {
      this.this$0.b.setVisibility(0);
    }
    if (this.this$0.b.getAnimationMode() == 1)
    {
      BaseTransientBottomBar.i(this.this$0);
      return;
    }
    BaseTransientBottomBar.j(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.10
 * JD-Core Version:    0.7.0.1
 */