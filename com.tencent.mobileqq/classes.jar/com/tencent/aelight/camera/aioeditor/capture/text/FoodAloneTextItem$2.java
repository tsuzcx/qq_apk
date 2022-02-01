package com.tencent.aelight.camera.aioeditor.capture.text;

import android.text.Spanned;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.LengthInputFilter;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

class FoodAloneTextItem$2
  extends EditTextDialog.LengthInputFilter
{
  FoodAloneTextItem$2(FoodAloneTextItem paramFoodAloneTextItem, int paramInt)
  {
    super(paramInt);
  }
  
  public int a(CharSequence paramCharSequence)
  {
    return 0;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramSpanned.subSequence(0, paramInt3).toString());
    ((StringBuilder)localObject).append(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
    ((StringBuilder)localObject).append(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString());
    localObject = ((StringBuilder)localObject).toString();
    this.b = (((String)localObject).length() - TroopFileUtils.c((String)localObject).length() + 20);
    return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.FoodAloneTextItem.2
 * JD-Core Version:    0.7.0.1
 */