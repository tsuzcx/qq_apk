package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.text.TextUtils;
import com.tencent.aelight.camera.struct.editor.DoodleInfo;
import com.tencent.aelight.camera.struct.editor.DoodleInfoLoadObserver;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class PtvTemplateManager$1
  implements Runnable
{
  PtvTemplateManager$1(PtvTemplateManager paramPtvTemplateManager, File paramFile, DoodleInfoLoadObserver paramDoodleInfoLoadObserver, AppInterface paramAppInterface) {}
  
  public void run()
  {
    Object localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_JavaIoFile);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    localObject1 = PtvTemplateManager.a((String)localObject1);
    if ((localObject1 != null) && (((PtvTemplateInfo)localObject1).a != null))
    {
      if (((PtvTemplateInfo)localObject1).a.isEmpty()) {
        return;
      }
      ??? = ((PtvTemplateInfo)localObject1).a.iterator();
      int j = 0;
      while (((Iterator)???).hasNext())
      {
        DoodleInfo localDoodleInfo = (DoodleInfo)((Iterator)???).next();
        if (localDoodleInfo != null)
        {
          PtvTemplateManager localPtvTemplateManager = this.this$0;
          int k = 1;
          localDoodleInfo.a = localPtvTemplateManager.a(localDoodleInfo, true);
          int i = k;
          if (j == 0) {
            if (localDoodleInfo.a) {
              i = k;
            } else {
              i = 0;
            }
          }
          j = i;
        }
      }
      synchronized (PtvTemplateManager.a())
      {
        PtvTemplateManager.a(this.this$0, (PtvTemplateInfo)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfoLoadObserver;
        if (localObject1 != null) {
          ((DoodleInfoLoadObserver)localObject1).a();
        }
        if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
        {
          if (PtvFilterSoLoad.a()) {
            PtvTemplateManager.a(this.this$0, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          }
        }
        else if (j != 0) {
          this.this$0.a(false);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.1
 * JD-Core Version:    0.7.0.1
 */