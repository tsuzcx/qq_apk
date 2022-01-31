package com.tencent.mobileqq.activity.aio.item;

import adeg;
import android.os.Handler;
import apdc;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class FilePicItemBuilder$1
  implements Runnable
{
  public FilePicItemBuilder$1(adeg paramadeg, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    apdc.a(this.a);
    this.this$0.b.post(new FilePicItemBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */