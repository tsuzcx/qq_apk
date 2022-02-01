package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import java.io.Serializable;

public class AEEditorAutoTemplateBean
  implements Serializable
{
  public String id = "";
  public String name = "";
  public String packageMd5 = "";
  public String packagePath = "";
  public String packageUrl = "";
  public String parentId = "";
  public int preDownload;
  public String thumbUrl = "";
  
  @NonNull
  public static AEEditorDownloadResBean convert2DownloadBean(@NonNull AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean)
  {
    AEEditorDownloadResBean localAEEditorDownloadResBean = new AEEditorDownloadResBean();
    localAEEditorDownloadResBean.setId(paramAEEditorAutoTemplateBean.id);
    localAEEditorDownloadResBean.setUrl(paramAEEditorAutoTemplateBean.packageUrl);
    localAEEditorDownloadResBean.setMd5(paramAEEditorAutoTemplateBean.packageMd5);
    localAEEditorDownloadResBean.setPreDownload(paramAEEditorAutoTemplateBean.preDownload);
    return localAEEditorDownloadResBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplateBean
 * JD-Core Version:    0.7.0.1
 */