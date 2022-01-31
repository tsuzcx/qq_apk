import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

public abstract interface beqv
{
  public abstract void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean onBackPressed(Activity paramActivity);
  
  public abstract void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup);
  
  public abstract void onDestroy(Activity paramActivity);
  
  public abstract void onNewIntent(Activity paramActivity, Intent paramIntent);
  
  public abstract void onPause(Activity paramActivity);
  
  public abstract void onRequestPermissionsResult(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onResume(Activity paramActivity);
  
  public abstract void onStart(Activity paramActivity);
  
  public abstract void onStop(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqv
 * JD-Core Version:    0.7.0.1
 */