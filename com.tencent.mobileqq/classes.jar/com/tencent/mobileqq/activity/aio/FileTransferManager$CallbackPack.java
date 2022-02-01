package com.tencent.mobileqq.activity.aio;

import android.view.View;
import java.lang.ref.WeakReference;

class FileTransferManager$CallbackPack
{
  WeakReference<View> a;
  WeakReference<Callback> b;
  
  public FileTransferManager$CallbackPack(FileTransferManager paramFileTransferManager, View paramView, Callback paramCallback)
  {
    this.a = new WeakReference(paramView);
    this.b = new WeakReference(paramCallback);
  }
  
  public View a()
  {
    return (View)this.a.get();
  }
  
  public Callback b()
  {
    return (Callback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.FileTransferManager.CallbackPack
 * JD-Core Version:    0.7.0.1
 */