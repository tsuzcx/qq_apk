package com.tencent.aelight.camera.aeeditor.module.edit;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorCommonEditFragment$5
  implements Observer<Pair<Integer, String>>
{
  AEEditorCommonEditFragment$5(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void a(Pair<Integer, String> paramPair)
  {
    ThreadManager.getUIHandler().postDelayed(new AEEditorCommonEditFragment.5.1(this, paramPair), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment.5
 * JD-Core Version:    0.7.0.1
 */