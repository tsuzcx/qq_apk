package com.google.android.material.bottomappbar;

import androidx.annotation.NonNull;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener;

class BottomAppBar$5
  extends FloatingActionButton.OnVisibilityChangedListener
{
  BottomAppBar$5(BottomAppBar paramBottomAppBar, int paramInt) {}
  
  public void a(@NonNull FloatingActionButton paramFloatingActionButton)
  {
    paramFloatingActionButton.setTranslationX(BottomAppBar.d(this.b, this.a));
    paramFloatingActionButton.a(new BottomAppBar.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.5
 * JD-Core Version:    0.7.0.1
 */