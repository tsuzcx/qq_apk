package androidx.drawerlayout.widget;

import android.view.View;
import androidx.annotation.NonNull;

public abstract interface DrawerLayout$DrawerListener
{
  public abstract void onDrawerClosed(@NonNull View paramView);
  
  public abstract void onDrawerOpened(@NonNull View paramView);
  
  public abstract void onDrawerSlide(@NonNull View paramView, float paramFloat);
  
  public abstract void onDrawerStateChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.drawerlayout.widget.DrawerLayout.DrawerListener
 * JD-Core Version:    0.7.0.1
 */