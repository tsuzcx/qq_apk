package com.tencent.mobileqq.activity.aio.item;

import adpg;
import apvd;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class FilePicItemBuilder$1$1
  implements Runnable
{
  FilePicItemBuilder$1$1(FilePicItemBuilder.1 param1) {}
  
  public void run()
  {
    if ((apvd.b(this.a.a.strLargeThumPath)) || (apvd.b(this.a.a.strMiddleThumPath))) {
      this.a.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder.1.1
 * JD-Core Version:    0.7.0.1
 */