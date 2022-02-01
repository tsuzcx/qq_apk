package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

class EditTextDialog$InitialLayoutListener$1
  implements Runnable
{
  EditTextDialog$InitialLayoutListener$1(EditTextDialog.InitialLayoutListener paramInitialLayoutListener) {}
  
  public void run()
  {
    EditTextDialog.EditTextDialogEventListener localEditTextDialogEventListener = this.a.a.a;
    boolean bool;
    if (this.a.a.g != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localEditTextDialogEventListener.b(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.InitialLayoutListener.1
 * JD-Core Version:    0.7.0.1
 */