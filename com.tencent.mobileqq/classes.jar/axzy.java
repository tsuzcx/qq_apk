import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.presenter.IProvider;
import java.io.File;
import mqq.os.MqqHandler;

class axzy
  implements ShareActionSheet.OnItemClickListener
{
  axzy(axzv paramaxzv, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_Axzv.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i;
    switch (paramActionSheetItem.action)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", i, 0, "", "", "", "");
      return;
      int j = 1;
      i = j;
      if (RichMediaBrowserManager.getInstance().getProvider() != null)
      {
        i = j;
        if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
        {
          paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
          for (boolean bool = true;; bool = false)
          {
            axzg.a(this.jdField_a_of_type_Axzv.mContext, paramActionSheetItem, bool);
            i = j;
            break;
          }
          if ((RichMediaBrowserManager.getInstance().getProvider() == null) || (!RichMediaBrowserManager.getInstance().getProvider().isPingBinder())) {
            break;
          }
          paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
          for (bool = true;; bool = false)
          {
            axzg.a(this.jdField_a_of_type_Axzv.mContext, paramActionSheetItem, bool);
            i = -1;
            break;
          }
          i = paramActionSheetItem.uinType;
          paramActionSheetItem = paramActionSheetItem.uin;
          if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
          {
            paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
            if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int != 1) {
              break label436;
            }
          }
          label436:
          for (bool = true;; bool = false)
          {
            axzg.a(this.jdField_a_of_type_Axzv.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
            i = -1;
            break;
          }
          if ((RichMediaBrowserManager.getInstance().getProvider() == null) || (!RichMediaBrowserManager.getInstance().getProvider().isPingBinder())) {
            break;
          }
          RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
          azqs.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
          QQToast.a(this.jdField_a_of_type_Axzv.mContext, 2, this.jdField_a_of_type_Axzv.mContext.getString(2131692840), 0).a();
          i = -1;
          continue;
          j = 5;
          i = j;
          if (RichMediaBrowserManager.getInstance().getProvider() != null)
          {
            i = j;
            if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
            {
              RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
              QQToast.a(this.jdField_a_of_type_Axzv.mContext, this.jdField_a_of_type_Axzv.mContext.getString(2131692914), 0).a();
              i = j;
              continue;
              if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_Axzv.mContext))
              {
                CheckPermission.requestStorePermission(this.jdField_a_of_type_Axzv.mContext, null);
                return;
              }
              i = 2;
              if (new axyk().a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData))
              {
                paramActionSheetItem = new File(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
                paramShareActionSheet = arrr.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
                ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramActionSheetItem.getAbsolutePath(), this.jdField_a_of_type_Axzv.jdField_a_of_type_Axyt.a, paramShareActionSheet, false));
              }
              else
              {
                paramActionSheetItem = new Bundle();
                float f = 0.0F;
                if (aiqk.class.isInstance(this.jdField_a_of_type_Axzv.jdField_a_of_type_Aiqi)) {
                  f = ((aiqk)this.jdField_a_of_type_Axzv.jdField_a_of_type_Aiqi).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
                }
                paramActionSheetItem.putFloat("progress", f);
                this.jdField_a_of_type_Axzv.jdField_a_of_type_Aiqi.h();
                if (RichMediaBrowserManager.getInstance().getProvider() != null) {
                  RichMediaBrowserManager.getInstance().getProvider().onFileVideoStatusChange(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, 13, paramActionSheetItem);
                }
                this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.n = true;
                this.jdField_a_of_type_Axzv.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int);
                this.jdField_a_of_type_Axzv.updateUI();
                continue;
                j = 3;
                i = j;
                if (RichMediaBrowserManager.getInstance().getProvider() != null)
                {
                  i = j;
                  if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
                  {
                    RichMediaBrowserManager.getInstance().getProvider().favorite(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
                    i = j;
                    continue;
                    paramShareActionSheet = axyd.a().a();
                    paramActionSheetItem = paramShareActionSheet;
                    if (TextUtils.isEmpty(paramShareActionSheet)) {
                      paramActionSheetItem = axyd.a().c();
                    }
                    axzh.a(this.jdField_a_of_type_Axzv.mContext, axyd.a().a(), axyd.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int, false);
                    i = 6;
                    continue;
                    paramActionSheetItem = paramActionSheetItem.argus;
                    paramShareActionSheet = new Intent();
                    paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
                    if (bdil.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
                    for (paramActionSheetItem = axyd.a().d();; paramActionSheetItem = axyd.a().c())
                    {
                      axzh.a(this.jdField_a_of_type_Axzv.mContext, this.jdField_a_of_type_Axzv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.j, 1, axyd.a().d(), axyd.a().c(), paramShareActionSheet);
                      azqs.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", axzv.a(this.jdField_a_of_type_Axzv, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
                      i = 8;
                      break;
                    }
                    paramActionSheetItem = paramActionSheetItem.argus;
                    paramShareActionSheet = new Intent();
                    paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
                    if (bdil.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
                    for (paramActionSheetItem = axyd.a().d();; paramActionSheetItem = axyd.a().c())
                    {
                      axzh.a(this.jdField_a_of_type_Axzv.mContext, this.jdField_a_of_type_Axzv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.j, 2, axyd.a().d(), axyd.a().c(), paramShareActionSheet);
                      azqs.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", axzv.a(this.jdField_a_of_type_Axzv, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
                      i = 9;
                      break;
                    }
                    i = 7;
                    arrr.a(this.jdField_a_of_type_Axzv.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzy
 * JD-Core Version:    0.7.0.1
 */