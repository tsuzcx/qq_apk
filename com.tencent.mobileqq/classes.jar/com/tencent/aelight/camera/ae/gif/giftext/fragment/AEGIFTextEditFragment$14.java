package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

class AEGIFTextEditFragment$14
  implements TextWatcher
{
  boolean jdField_a_of_type_Boolean = false;
  
  AEGIFTextEditFragment$14(AEGIFTextEditFragment paramAEGIFTextEditFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0) {
      AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment).setVisibility(0);
    } else {
      AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment).setVisibility(4);
    }
    int i = 0;
    int k = 0;
    int m = 1;
    int j = 0;
    while (i < paramEditable.length())
    {
      char c = paramEditable.charAt(i);
      if (c == '\n') {
        return;
      }
      int n = m;
      if (c == ' ') {
        if (m != 0)
        {
          j = i;
          n = 0;
        }
        else
        {
          j = i;
          n = m;
        }
      }
      k += AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment, c);
      if ((k > 16) && (!this.jdField_a_of_type_Boolean))
      {
        AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment).removeTextChangedListener(this);
        if (n == 0) {
          AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment).setText(paramEditable.insert(j, "\r\n"));
        } else {
          AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment).setText(paramEditable.insert(i, "\r\n"));
        }
        AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment).setSelection(paramEditable.length());
        this.jdField_a_of_type_Boolean = true;
        AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment).addTextChangedListener(this);
        return;
      }
      i += 1;
      m = n;
    }
    if (k <= 16) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.14
 * JD-Core Version:    0.7.0.1
 */