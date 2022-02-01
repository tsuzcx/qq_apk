package com.tencent.aelight.camera.aeeditor.module.text;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.aebase.AEReportUtils;

class AEEditorTextControlPanel$4
  implements Observer<String>
{
  AEEditorTextControlPanel$4(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void a(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1778477271)
    {
      if (i != 162245921)
      {
        if ((i == 700715906) && (paramString.equals("CATEGORY_FONT_STYLE")))
        {
          i = 2;
          break label70;
        }
      }
      else if (paramString.equals("CATEGORY_FONT_PATTERN"))
      {
        i = 1;
        break label70;
      }
    }
    else if (paramString.equals("CATEGORY_FONT_TYPE"))
    {
      i = 0;
      break label70;
    }
    i = -1;
    label70:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramString = this.a;
        AEEditorTextControlPanel.a(paramString, AEEditorTextControlPanel.a(paramString), false);
        paramString = this.a;
        AEEditorTextControlPanel.a(paramString, AEEditorTextControlPanel.b(paramString), false);
        paramString = this.a;
        AEEditorTextControlPanel.a(paramString, AEEditorTextControlPanel.c(paramString), true);
        AEReportUtils.a(AEEditorTextControlPanel.a(this.a), 14);
        return;
      }
      paramString = this.a;
      AEEditorTextControlPanel.a(paramString, AEEditorTextControlPanel.a(paramString), false);
      paramString = this.a;
      AEEditorTextControlPanel.a(paramString, AEEditorTextControlPanel.b(paramString), true);
      paramString = this.a;
      AEEditorTextControlPanel.a(paramString, AEEditorTextControlPanel.c(paramString), false);
      AEReportUtils.a(AEEditorTextControlPanel.a(this.a), 13);
      return;
    }
    paramString = this.a;
    AEEditorTextControlPanel.a(paramString, AEEditorTextControlPanel.a(paramString), true);
    paramString = this.a;
    AEEditorTextControlPanel.a(paramString, AEEditorTextControlPanel.b(paramString), false);
    paramString = this.a;
    AEEditorTextControlPanel.a(paramString, AEEditorTextControlPanel.c(paramString), false);
    AEReportUtils.a(AEEditorTextControlPanel.a(this.a), 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel.4
 * JD-Core Version:    0.7.0.1
 */