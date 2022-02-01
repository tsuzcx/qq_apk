package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.util.Util;

class ResourceRecycler
{
  private boolean a;
  private final Handler b = new Handler(Looper.getMainLooper(), new ResourceRecycler.ResourceRecyclerCallback());
  
  void a(Resource<?> paramResource)
  {
    
    if (this.a)
    {
      this.b.obtainMessage(1, paramResource).sendToTarget();
      return;
    }
    this.a = true;
    paramResource.f();
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.ResourceRecycler
 * JD-Core Version:    0.7.0.1
 */