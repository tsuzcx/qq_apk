package com.tencent.aelight.camera.aioeditor.docenhance;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.gyailib.library.GYAIDocEnhance;
import com.tencent.aelight.camera.aioeditor.docenhance.widget.EdgeAdjustView.InteractionListener;
import com.tencent.mobileqq.widget.QQToast;

class DocEnhanceAdjustFragment$1
  implements EdgeAdjustView.InteractionListener
{
  DocEnhanceAdjustFragment$1(DocEnhanceAdjustFragment paramDocEnhanceAdjustFragment) {}
  
  public void a(boolean paramBoolean)
  {
    DocEnhanceAdjustFragment.c(this.a).setEnabled(paramBoolean);
  }
  
  public boolean a(float[] paramArrayOfFloat)
  {
    Object localObject = DocEnhanceAdjustFragment.a(this.a);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (paramArrayOfFloat != null)
      {
        bool1 = bool2;
        if (paramArrayOfFloat.length == 8)
        {
          int i = 0;
          while (i < 4)
          {
            localObject = this.a.a;
            int j = i * 2;
            localObject[j] = (DocEnhanceAdjustFragment.a(this.a).getWidth() * paramArrayOfFloat[j]);
            localObject = this.a.a;
            j += 1;
            localObject[j] = (DocEnhanceAdjustFragment.a(this.a).getHeight() * paramArrayOfFloat[j]);
            i += 1;
          }
          bool1 = bool2;
          if (DocEnhanceAdjustFragment.b(this.a).documentCornerValid(this.a.a) == 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      QQToast.makeText(this.a.getContext(), 2064187481, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhanceAdjustFragment.1
 * JD-Core Version:    0.7.0.1
 */