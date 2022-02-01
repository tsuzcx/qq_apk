package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp;

class AEGIFTextEditFragment$10
  implements Runnable
{
  AEGIFTextEditFragment$10(AEGIFTextEditFragment paramAEGIFTextEditFragment, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    AEGIFTextEditFragment.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, this.b, this.c);
    AEGIFTextEditFragment.a(this.this$0).a(this.jdField_a_of_type_Int);
    if (this.b.equals("#ccffffff"))
    {
      AEGIFTextEditFragment.a(this.this$0).a(false, true);
      return;
    }
    AEGIFTextEditFragment.a(this.this$0).a(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.10
 * JD-Core Version:    0.7.0.1
 */