package com.tencent.aelight.camera.education.api.impl;

import android.graphics.Bitmap;
import android.text.TextUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnswerSearchEditPictureActivity$goToSearchResult$1
  implements Runnable
{
  AnswerSearchEditPictureActivity$goToSearchResult$1(AnswerSearchEditPictureActivity paramAnswerSearchEditPictureActivity, Bitmap paramBitmap) {}
  
  public final void run()
  {
    String str = AnswerSearchEditPictureActivity.a(this.this$0, this.a);
    if (!TextUtils.isEmpty((CharSequence)str)) {
      AnswerSearchEditPictureActivity.a(this.this$0, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.education.api.impl.AnswerSearchEditPictureActivity.goToSearchResult.1
 * JD-Core Version:    0.7.0.1
 */