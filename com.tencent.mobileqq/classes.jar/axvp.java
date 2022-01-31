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

class axvp
  implements ShareActionSheet.OnItemClickListener
{
  axvp(axvm paramaxvm, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_Axvm.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i;
    switch (paramActionSheetItem.action)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      azmj.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", i, 0, "", "", "", "");
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
            axux.a(this.jdField_a_of_type_Axvm.mContext, paramActionSheetItem, bool);
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
            axux.a(this.jdField_a_of_type_Axvm.mContext, paramActionSheetItem, bool);
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
            axux.a(this.jdField_a_of_type_Axvm.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
            i = -1;
            break;
          }
          if ((RichMediaBrowserManager.getInstance().getProvider() == null) || (!RichMediaBrowserManager.getInstance().getProvider().isPingBinder())) {
            break;
          }
          RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
          azmj.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
          QQToast.a(this.jdField_a_of_type_Axvm.mContext, 2, this.jdField_a_of_type_Axvm.mContext.getString(2131692838), 0).a();
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
              QQToast.a(this.jdField_a_of_type_Axvm.mContext, this.jdField_a_of_type_Axvm.mContext.getString(2131692912), 0).a();
              i = j;
              continue;
              if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_Axvm.mContext))
              {
                CheckPermission.requestStorePermission(this.jdField_a_of_type_Axvm.mContext, null);
                return;
              }
              i = 2;
              if (new axub().a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData))
              {
                paramActionSheetItem = new File(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
                paramShareActionSheet = arni.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
                ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramActionSheetItem.getAbsolutePath(), this.jdField_a_of_type_Axvm.jdField_a_of_type_Axuk.a, paramShareActionSheet, false));
              }
              else
              {
                paramActionSheetItem = new Bundle();
                float f = 0.0F;
                if (ailv.class.isInstance(this.jdField_a_of_type_Axvm.jdField_a_of_type_Ailt)) {
                  f = ((ailv)this.jdField_a_of_type_Axvm.jdField_a_of_type_Ailt).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
                }
                paramActionSheetItem.putFloat("progress", f);
                this.jdField_a_of_type_Axvm.jdField_a_of_type_Ailt.h();
                if (RichMediaBrowserManager.getInstance().getProvider() != null) {
                  RichMediaBrowserManager.getInstance().getProvider().onFileVideoStatusChange(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, 13, paramActionSheetItem);
                }
                this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.n = true;
                this.jdField_a_of_type_Axvm.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int);
                this.jdField_a_of_type_Axvm.updateUI();
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
                    paramShareActionSheet = axtu.a().a();
                    paramActionSheetItem = paramShareActionSheet;
                    if (TextUtils.isEmpty(paramShareActionSheet)) {
                      paramActionSheetItem = axtu.a().c();
                    }
                    axuy.a(this.jdField_a_of_type_Axvm.mContext, axtu.a().a(), axtu.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int, false);
                    i = 6;
                    continue;
                    paramActionSheetItem = paramActionSheetItem.argus;
                    paramShareActionSheet = new Intent();
                    paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
                    if (bdec.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
                    for (paramActionSheetItem = axtu.a().d();; paramActionSheetItem = axtu.a().c())
                    {
                      axuy.a(this.jdField_a_of_type_Axvm.mContext, this.jdField_a_of_type_Axvm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.j, 1, axtu.a().d(), axtu.a().c(), paramShareActionSheet);
                      azmj.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", axvm.a(this.jdField_a_of_type_Axvm, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
                      i = 8;
                      break;
                    }
                    paramActionSheetItem = paramActionSheetItem.argus;
                    paramShareActionSheet = new Intent();
                    paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
                    if (bdec.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
                    for (paramActionSheetItem = axtu.a().d();; paramActionSheetItem = axtu.a().c())
                    {
                      axuy.a(this.jdField_a_of_type_Axvm.mContext, this.jdField_a_of_type_Axvm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.j, 2, axtu.a().d(), axtu.a().c(), paramShareActionSheet);
                      azmj.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", axvm.a(this.jdField_a_of_type_Axvm, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
                      i = 9;
                      break;
                    }
                    i = 7;
                    arni.a(this.jdField_a_of_type_Axvm.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
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
 * Qualified Name:     axvp
 * JD-Core Version:    0.7.0.1
 */