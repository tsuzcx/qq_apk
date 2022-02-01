package com.tencent.mobileqq.activity.aio;

import android.view.View;
import java.lang.ref.WeakReference;

class FileTransferManager$CallbackPack
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<Callback> b;
  
  public FileTransferManager$CallbackPack(FileTransferManager paramFileTransferManager, View paramView, Callback paramCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public Callback a()
  {
    return (Callback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.FileTransferManager.CallbackPack
 * JD-Core Version:    0.7.0.1
 */