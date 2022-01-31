package android.support.v4.view;

import android.view.ViewConfiguration;

class ViewConfigurationCompat$BaseViewConfigurationVersionImpl
  implements ViewConfigurationCompat.ViewConfigurationVersionImpl
{
  public int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.getScaledTouchSlop();
  }
  
  public boolean hasPermanentMenuKey(ViewConfiguration paramViewConfiguration)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewConfigurationCompat.BaseViewConfigurationVersionImpl
 * JD-Core Version:    0.7.0.1
 */