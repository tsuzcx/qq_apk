package com.tencent.av.wtogether.api.impl;

import android.app.Activity;
import com.tencent.av.wtogether.api.IFileChooser;
import com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment;
import com.tencent.av.wtogether.fragment.AVRecentFileSelectFragment;

public class FileChooserImpl
  implements IFileChooser
{
  public void startAVGroupFileSelectFragment(Activity paramActivity, long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    AVGroupFileSelectFragment.a(paramActivity, paramLong, paramString1, paramInt1, paramInt2, paramString2, paramInt3);
  }
  
  public void startAVRecentFileSelectFragment(Activity paramActivity, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AVRecentFileSelectFragment.a(paramActivity, paramInt1, paramInt2, paramString, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.api.impl.FileChooserImpl
 * JD-Core Version:    0.7.0.1
 */