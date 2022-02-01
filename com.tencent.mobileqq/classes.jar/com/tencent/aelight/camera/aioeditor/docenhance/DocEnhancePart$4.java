package com.tencent.aelight.camera.aioeditor.docenhance;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.aelight.camera.ae.AEPath.Editor.CACHE;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;
import java.io.IOException;

class DocEnhancePart$4
  implements Runnable
{
  DocEnhancePart$4(DocEnhancePart paramDocEnhancePart, Bitmap paramBitmap) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AEPath.Editor.CACHE.b);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".jpg");
    localObject = ((StringBuilder)localObject).toString();
    FileUtils.createFileIfNotExits((String)localObject);
    File localFile = new File((String)localObject);
    try
    {
      ImageUtil.b(this.a, localFile);
      DocEnhancePart.a(this.this$0, (String)localObject);
      DocEnhanceFragment.a((Activity)this.this$0.u(), 7532, (String)localObject, null, null, DocEnhancePart.c(this.this$0));
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart.4
 * JD-Core Version:    0.7.0.1
 */