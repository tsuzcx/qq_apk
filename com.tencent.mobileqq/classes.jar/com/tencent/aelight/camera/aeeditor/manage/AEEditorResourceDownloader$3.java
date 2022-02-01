package com.tencent.aelight.camera.aeeditor.manage;

import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.Map;

class AEEditorResourceDownloader$3
  implements Runnable
{
  AEEditorResourceDownloader$3(AEEditorResourceDownloader paramAEEditorResourceDownloader, String paramString, AEEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener) {}
  
  public void run()
  {
    Object localObject = this.this$0.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downLoadResource--by user--BEGIN id: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    this.this$0.a();
    localObject = (AEEditorDownloadResBean)this.this$0.a.get(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      this.this$0.a((AEEditorDownloadResBean)localObject, this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader$ResDownLoadListener);
      return;
    }
    localObject = this.this$0.c;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("downLoadResource--by user--FAIL, no download config for id: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    AEQLog.d((String)localObject, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader$ResDownLoadListener;
    if (localObject != null) {
      ((AEEditorResourceDownloader.ResDownLoadListener)localObject).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.3
 * JD-Core Version:    0.7.0.1
 */