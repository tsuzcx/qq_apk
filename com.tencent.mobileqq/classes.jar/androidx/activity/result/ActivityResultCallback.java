package androidx.activity.result;

import android.annotation.SuppressLint;

public abstract interface ActivityResultCallback<O>
{
  public abstract void onActivityResult(@SuppressLint({"UnknownNullness"}) O paramO);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.ActivityResultCallback
 * JD-Core Version:    0.7.0.1
 */