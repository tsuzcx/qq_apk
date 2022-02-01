package com.tencent.aelight.camera.aioeditor.capture.text;

import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.LengthInputFilter;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

class FoldOverTextItem$2
  extends EditTextDialog.LengthInputFilter
{
  FoldOverTextItem$2(FoldOverTextItem paramFoldOverTextItem, int paramInt)
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
    String str1 = TroopFileUtils.c((String)localObject);
    String str2 = this.a.a(str1);
    this.b = (((String)localObject).length() - str1.length() + 20);
    localObject = str2.split("\n");
    int m = localObject.length;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      int k = localObject[j].length();
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
    if (j > FoldOverTextItem.u().length)
    {
      if (!TextUtils.equals("", paramCharSequence)) {
        a();
      }
      return "";
    }
    return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.FoldOverTextItem.2
 * JD-Core Version:    0.7.0.1
 */