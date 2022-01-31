package com.tencent.mobileqq.activity.aio.item;

import adeq;
import android.os.Handler;
import aoig;
import apck;
import apdh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class FileVideoItemBuilder$1
  implements Runnable
{
  public FileVideoItemBuilder$1(adeq paramadeq, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    apck.d(this.a);
    if (apdh.b(this.a.strLargeThumPath))
    {
      this.this$0.a.a().c(this.a);
      this.this$0.b.post(new FileVideoItemBuilder.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */