package com.tencent.aelight.camera.aioeditor.capture.text;

import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.LengthInputFilter;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

class RandomSizeTextItem$2
  extends EditTextDialog.LengthInputFilter
{
  RandomSizeTextItem$2(RandomSizeTextItem paramRandomSizeTextItem, int paramInt)
  {
    super(paramInt);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramSpanned.subSequence(0, paramInt3).toString());
    ((StringBuilder)localObject1).append(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
    ((StringBuilder)localObject1).append(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString());
    localObject1 = ((StringBuilder)localObject1).toString();
    String str = TroopFileUtils.b((String)localObject1);
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextRandomSizeTextItem.a(str);
    localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextRandomSizeTextItem.a((String)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextRandomSizeTextItem.a((String[])localObject2);
    if (StaticLayoutWithMaxLines.a((CharSequence)localObject2, 0, ((CharSequence)localObject2).length(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextRandomSizeTextItem.a, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextRandomSizeTextItem.b, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4).getLineCount() > 3)
    {
      if (!TextUtils.equals("", paramCharSequence)) {
        a();
      }
      return "";
    }
    this.jdField_a_of_type_Int = (((String)localObject1).length() - str.length() + 20);
    return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.RandomSizeTextItem.2
 * JD-Core Version:    0.7.0.1
 */