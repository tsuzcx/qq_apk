package com.tencent.aelight.camera.aeeditor.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGView;

class AEEditorLoadingView$3
  implements Function1<PAGView, Unit>
{
  AEEditorLoadingView$3(AEEditorLoadingView paramAEEditorLoadingView, int paramInt) {}
  
  public Unit a(PAGView paramPAGView)
  {
    int i = this.jdField_a_of_type_Int;
    String str;
    if (i != 1)
    {
      if (i != 2) {
        str = AEEditorLoadingView.d();
      } else {
        str = AEEditorLoadingView.c();
      }
    }
    else {
      str = AEEditorLoadingView.b();
    }
    AEEditorLoadingView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView, paramPAGView, str);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView.3
 * JD-Core Version:    0.7.0.1
 */