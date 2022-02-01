package com.tencent.mobileqq.activity.aio.item;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ScribbleItemBuilder$2
  implements ActionSheet.OnButtonClickListener
{
  ScribbleItemBuilder$2(ScribbleItemBuilder paramScribbleItemBuilder, View paramView, MessageForScribble paramMessageForScribble, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      long l = SystemClock.uptimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.c < 500L) {
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder;
      paramView.c = l;
      paramView = FileTransferManager.a(paramView.a);
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder);
      }
      ((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).ReSendScribbleMsgRecord(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */