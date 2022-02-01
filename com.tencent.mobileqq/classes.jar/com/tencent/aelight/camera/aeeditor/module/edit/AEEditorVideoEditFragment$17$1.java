package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

class AEEditorVideoEditFragment$17$1
  implements Runnable
{
  AEEditorVideoEditFragment$17$1(AEEditorVideoEditFragment.17 param17, HashMap paramHashMap) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("AEEDITOR_UPDATE_AI_TEXT");
    localIntent.putExtra("update_ai_text_map", this.a);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.17.1
 * JD-Core Version:    0.7.0.1
 */