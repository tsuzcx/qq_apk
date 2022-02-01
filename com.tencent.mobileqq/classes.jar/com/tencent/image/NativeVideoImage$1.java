package com.tencent.image;

import android.widget.Toast;
import com.tencent.image.api.ITool;
import com.tencent.image.api.URLDrawableDepWrap;

class NativeVideoImage$1
  implements Runnable
{
  NativeVideoImage$1(NativeVideoImage paramNativeVideoImage, String paramString) {}
  
  public void run()
  {
    Toast.makeText(URLDrawable.depImp.mTool.getContext(), "[NativeVideoImage]OOM:" + this.val$tips, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.1
 * JD-Core Version:    0.7.0.1
 */