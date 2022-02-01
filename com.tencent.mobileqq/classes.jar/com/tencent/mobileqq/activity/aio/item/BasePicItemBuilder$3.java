package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class BasePicItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  BasePicItemBuilder$3(BasePicItemBuilder paramBasePicItemBuilder, MessageForPic paramMessageForPic, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    if (paramInt == 0)
    {
      paramView = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder.a.getRuntimeService(ITransFileController.class)).findProcessor(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
      if ((paramView != null) && ((paramView instanceof BaseTransProcessor)))
      {
        paramView = (BaseTransProcessor)paramView;
        if ((paramView.isRawPic()) && (paramView.isPause()))
        {
          ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder.a.getRuntimeService(ITransFileController.class)).getBusHelper().resumeRawSend(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq));
          paramInt = i;
          break label122;
        }
      }
      paramInt = 0;
      label122:
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */