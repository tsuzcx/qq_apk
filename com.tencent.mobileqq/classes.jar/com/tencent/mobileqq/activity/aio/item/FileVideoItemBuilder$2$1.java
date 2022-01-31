package com.tencent.mobileqq.activity.aio.item;

import adeq;
import android.graphics.drawable.ColorDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.io.File;

class FileVideoItemBuilder$2$1
  implements Runnable
{
  FileVideoItemBuilder$2$1(FileVideoItemBuilder.2 param2) {}
  
  public void run()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(-16777216);
    URLDrawable.getDrawable(new File(this.a.a.strLargeThumPath), localURLDrawableOptions);
    this.a.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileVideoItemBuilder.2.1
 * JD-Core Version:    0.7.0.1
 */