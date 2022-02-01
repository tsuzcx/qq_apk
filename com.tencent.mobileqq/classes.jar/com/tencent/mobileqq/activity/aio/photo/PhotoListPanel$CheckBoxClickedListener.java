package com.tencent.mobileqq.activity.aio.photo;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class PhotoListPanel$CheckBoxClickedListener
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public PhotoListPanel$CheckBoxClickedListener(PhotoListPanel paramPhotoListPanel) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter == null) {}
    LocalMediaInfo localLocalMediaInfo;
    int j;
    int i;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      long l1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemCount() > 0)
      {
        localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(this.jdField_a_of_type_Int);
        j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(this.jdField_a_of_type_Int);
        if ((!localLocalMediaInfo.mChecked) && (AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, PhotoListPanel.jdField_a_of_type_Int)))
        {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.mChecked);
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) || (localLocalMediaInfo.mChecked)) {
            break label317;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.iterator();
          String str;
          for (i = 0; ((Iterator)localObject).hasNext(); i = (int)(i + FileUtils.a(str))) {
            str = (String)((Iterator)localObject).next();
          }
          if (i + FileUtils.a(localLocalMediaInfo.path) <= 52428800L) {
            break label317;
          }
          localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
          if ((localObject == null) || (!((SmartDeviceProxyMgr)localObject).a())) {
            break label317;
          }
          l1 = 0L;
        }
      }
      try
      {
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if (!((SmartDeviceProxyMgr)localObject).a(l1, 1)) {
        break label317;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, "选择图片总大小不能超过50M", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getDimensionPixelSize(2131299166));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.mChecked);
    }
    label317:
    boolean bool;
    if (!localLocalMediaInfo.mChecked)
    {
      bool = true;
      label328:
      localLocalMediaInfo.mChecked = bool;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.mChecked);
      if (!localLocalMediaInfo.mChecked) {
        break label570;
      }
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(localLocalMediaInfo.path, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.add(localLocalMediaInfo.path);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.add(localLocalMediaInfo.position);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a());
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size();
      ((NumberCheckBox)this.jdField_a_of_type_AndroidWidgetCheckBox).setCheckedNumber(i);
      ReportController.b(null, "CliOper", "", "", "0X8005E08", "0X8005E08", 0, 0, "", "", "", "");
      if (PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel) != null) {
        PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getContext(), localLocalMediaInfo.path, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilMap, null, true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k();
      break;
      bool = false;
      break label328;
      label570:
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(localLocalMediaInfo.path);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.remove(localLocalMediaInfo.path);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.remove(localLocalMediaInfo.position);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.CheckBoxClickedListener
 * JD-Core Version:    0.7.0.1
 */