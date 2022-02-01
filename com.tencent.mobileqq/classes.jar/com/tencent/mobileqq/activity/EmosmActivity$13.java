package com.tencent.mobileqq.activity;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class EmosmActivity$13
  implements DragSortListView.RemoveListener
{
  EmosmActivity$13(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt)
  {
    paramInt -= this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount();
    if (paramInt < 0) {
      return;
    }
    Object localObject = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!NetworkUtil.d(this.a))
    {
      localObject = new QQToast(this.a);
      ((QQToast)localObject).a(2130839690);
      ((QQToast)localObject).d(1500);
      ((QQToast)localObject).a(HardCodeUtil.a(2131704060));
      ((QQToast)localObject).b(0);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131692007));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ((EmoticonHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(Integer.parseInt(((EmoticonPackage)localObject).epId));
    URLDrawable.clearMemoryCache();
    if (this.a.b == 1)
    {
      ReportController.b(this.a.app, "dc00898", "", "", "0X800AB12", "0X800AB12", 1, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.a.app, "dc00898", "", "", "0X800AB15", "0X800AB15", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.13
 * JD-Core Version:    0.7.0.1
 */