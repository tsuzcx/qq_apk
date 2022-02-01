package androidx.activity;

import android.text.TextUtils;

class ComponentActivity$1
  implements Runnable
{
  ComponentActivity$1(ComponentActivity paramComponentActivity) {}
  
  public void run()
  {
    try
    {
      ComponentActivity.access$001(this.this$0);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (TextUtils.equals(localIllegalStateException.getMessage(), "Can not perform this action after onSaveInstanceState")) {
        return;
      }
      throw localIllegalStateException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.ComponentActivity.1
 * JD-Core Version:    0.7.0.1
 */