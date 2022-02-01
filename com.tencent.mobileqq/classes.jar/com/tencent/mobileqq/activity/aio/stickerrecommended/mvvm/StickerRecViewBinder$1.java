package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerRecBarAdapter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.data.StickerRecLiveData;

class StickerRecViewBinder$1
  implements Observer<StickerRecLiveData>
{
  StickerRecViewBinder$1(StickerRecViewBinder paramStickerRecViewBinder) {}
  
  public void a(StickerRecLiveData paramStickerRecLiveData)
  {
    if (StickerRecViewBinder.a(this.a) != null)
    {
      StickerRecViewBinder.a(this.a).b();
      StickerRecViewBinder.a(this.a).a(paramStickerRecLiveData.jdField_a_of_type_Int);
      StickerRecViewBinder.a(this.a).b(paramStickerRecLiveData.c);
      StickerRecViewBinder.a(this.a).a(paramStickerRecLiveData.jdField_a_of_type_JavaLangString);
      StickerRecViewBinder.a(this.a).c(paramStickerRecLiveData.b);
      StickerRecViewBinder.a(this.a).a(paramStickerRecLiveData.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewBinder.1
 * JD-Core Version:    0.7.0.1
 */