package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.res.Resources;
import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorVideoEditFragment$14
  implements Runnable
{
  AEEditorVideoEditFragment$14(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.X.b(2);
    int i = AEEditorVideoEditFragment.ak() / 60 / 1000;
    int j = AEEditorVideoEditFragment.ak() / 1000 % 60;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if ((i > 0) && (j == 0))
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(i);
      localStringBuilder2.append("分钟");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else if (i > 0)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(i);
      localStringBuilder2.append("分");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (j > 0)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(j);
      localStringBuilder2.append("秒");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    this.this$0.X.a(this.this$0.getResources().getString(2064187468, new Object[] { localStringBuilder1.toString() }));
    this.this$0.X.a(AEEditorVideoEditFragment.p(this.this$0), 1, 2);
    ThreadManager.getUIHandler().postDelayed(AEEditorVideoEditFragment.q(this.this$0), 3000L);
    this.this$0.X.setOnDismissListener(new AEEditorVideoEditFragment.14.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.14
 * JD-Core Version:    0.7.0.1
 */