package com.tencent.aelight.camera.aioeditor.capture.text;

import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.LengthInputFilter;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

class JourneyTextItem$3
  extends EditTextDialog.LengthInputFilter
{
  JourneyTextItem$3(JourneyTextItem paramJourneyTextItem, int paramInt)
  {
    super(paramInt);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextJourneyTextItem.b() == 0)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramSpanned.subSequence(0, paramInt3).toString());
      ((StringBuilder)localObject).append(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
      ((StringBuilder)localObject).append(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString());
      localObject = ((StringBuilder)localObject).toString();
      String str = TroopFileUtils.b((String)localObject);
      String[] arrayOfString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextJourneyTextItem.a(str).split("\n");
      int m = arrayOfString.length;
      int j = 0;
      int i = 0;
      while (j < m)
      {
        int k = arrayOfString[j].length();
        int n = k / 5;
        if (k % 5 > 0) {
          k = 1;
        } else {
          k = 0;
        }
        i += n + k;
        j += 1;
      }
      j = i;
      if (TextUtils.equals(paramCharSequence, "\n")) {
        j = i + 1;
      }
      if (j > 4)
      {
        if (!TextUtils.equals("", paramCharSequence)) {
          a();
        }
        return "";
      }
      this.jdField_a_of_type_Int = (((String)localObject).length() - str.length() + 20);
      return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_Int = 20;
    return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.JourneyTextItem.3
 * JD-Core Version:    0.7.0.1
 */