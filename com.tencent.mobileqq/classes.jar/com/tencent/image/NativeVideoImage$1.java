package com.tencent.image;

import android.content.Context;
import android.widget.Toast;
import com.tencent.image.api.ITool;
import com.tencent.image.api.URLDrawableDepWrap;

class NativeVideoImage$1
  implements Runnable
{
  NativeVideoImage$1(NativeVideoImage paramNativeVideoImage, String paramString) {}
  
  public void run()
  {
    Context localContext = URLDrawable.depImp.mTool.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[NativeVideoImage]OOM:");
    localStringBuilder.append(this.val$tips);
    Toast.makeText(localContext, localStringBuilder.toString(), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.1
 * JD-Core Version:    0.7.0.1
 */