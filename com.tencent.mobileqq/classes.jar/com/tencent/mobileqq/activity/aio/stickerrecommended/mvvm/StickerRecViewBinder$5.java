package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView.HorizonListViewTouchListener;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

class StickerRecViewBinder$5
  implements EmotionKeywordHorizonListView.HorizonListViewTouchListener
{
  StickerRecViewBinder$5(StickerRecViewBinder paramStickerRecViewBinder, EditText paramEditText) {}
  
  public void touchEventActionChanged(int paramInt)
  {
    if (StickerRecViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewBinder) == null) {
      return;
    }
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 3)) {
        return;
      }
      StickerRecViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewBinder).a().sendEmptyMessageDelayed(67, 6000L);
      return;
    }
    StickerRecViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewBinder).a().removeMessages(67);
    ReportController.b(StickerRecViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmStickerRecViewBinder), "CliOper", "", "", "ep_mall", "slide", 0, 0, "", "", "", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewBinder.5
 * JD-Core Version:    0.7.0.1
 */