package com.tencent.image;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.image.api.ITool;
import com.tencent.image.api.URLDrawableDepWrap;

public class AudioUtils
{
  public static void abandonAudioFoucus()
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      Context localContext = URLDrawable.depImp.mTool.getContext();
      if (localContext != null) {
        ((AudioManager)localContext.getSystemService("audio")).abandonAudioFocus(null);
      }
    }
  }
  
  public static void requesetAudioFoucus()
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      Context localContext = URLDrawable.depImp.mTool.getContext();
      if (localContext != null) {
        ((AudioManager)localContext.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.AudioUtils
 * JD-Core Version:    0.7.0.1
 */