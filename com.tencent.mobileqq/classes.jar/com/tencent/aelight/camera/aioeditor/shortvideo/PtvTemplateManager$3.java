package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.text.TextUtils;
import com.tencent.aelight.camera.struct.editor.DoodleInfo;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class PtvTemplateManager$3
  implements Runnable
{
  PtvTemplateManager$3(PtvTemplateManager paramPtvTemplateManager) {}
  
  public void run()
  {
    if (PtvTemplateManager.f() == null) {
      return;
    }
    File[] arrayOfFile = PtvTemplateManager.f().listFiles();
    if (arrayOfFile != null)
    {
      if (arrayOfFile.length == 0) {
        return;
      }
      int k = arrayOfFile.length;
      int i = 0;
      while (i < k)
      {
        File localFile = arrayOfFile[i];
        if ((localFile != null) && (localFile.isFile()))
        {
          Object localObject = localFile.getName();
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).contains(".")))
          {
            localObject = PtvTemplateManager.a(this.this$0).k.iterator();
            while (((Iterator)localObject).hasNext())
            {
              DoodleInfo localDoodleInfo = (DoodleInfo)((Iterator)localObject).next();
              if ((localDoodleInfo != null) && (!TextUtils.isEmpty(localDoodleInfo.b)) && (localFile.getName().equalsIgnoreCase(localDoodleInfo.b)))
              {
                j = 1;
                break label167;
              }
            }
            int j = 0;
            label167:
            if (j == 0)
            {
              localFile.deleteOnExit();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(PtvTemplateManager.g());
              ((StringBuilder)localObject).append(localFile.getName());
              new File(((StringBuilder)localObject).toString()).deleteOnExit();
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.3
 * JD-Core Version:    0.7.0.1
 */