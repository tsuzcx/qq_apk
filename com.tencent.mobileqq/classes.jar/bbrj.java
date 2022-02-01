import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.presenter.IProvider;

class bbrj
  implements ShareActionSheet.OnItemClickListener
{
  bbrj(bbrg parambbrg, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_Bbrg.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i;
    switch (paramActionSheetItem.action)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", i, 0, "", "", "", "");
      return;
      int j = 1;
      i = j;
      if (bbrg.a(this.jdField_a_of_type_Bbrg))
      {
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          bbqr.a(this.jdField_a_of_type_Bbrg.mContext, paramActionSheetItem, bool);
          i = j;
          break;
        }
        if (!bbrg.a(this.jdField_a_of_type_Bbrg)) {
          break;
        }
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (bool = true;; bool = false)
        {
          bbqr.a(this.jdField_a_of_type_Bbrg.mContext, paramActionSheetItem, bool);
          i = -1;
          break;
        }
        i = paramActionSheetItem.uinType;
        paramActionSheetItem = paramActionSheetItem.uin;
        if (bbrg.a(this.jdField_a_of_type_Bbrg))
        {
          paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int != 1) {
            break label385;
          }
        }
        label385:
        for (bool = true;; bool = false)
        {
          bbqr.a(this.jdField_a_of_type_Bbrg.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
          i = -1;
          break;
        }
        if (!bbrg.a(this.jdField_a_of_type_Bbrg)) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
        bdla.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        QQToast.a(this.jdField_a_of_type_Bbrg.mContext, 2, this.jdField_a_of_type_Bbrg.mContext.getString(2131692551), 0).a();
        i = -1;
        continue;
        j = 5;
        i = j;
        if (bbrg.a(this.jdField_a_of_type_Bbrg))
        {
          RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
          QQToast.a(this.jdField_a_of_type_Bbrg.mContext, this.jdField_a_of_type_Bbrg.mContext.getString(2131692595), 0).a();
          i = j;
          continue;
          i = 2;
          bbrg.a(this.jdField_a_of_type_Bbrg, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData);
          continue;
          j = 3;
          i = j;
          if (bbrg.a(this.jdField_a_of_type_Bbrg))
          {
            RichMediaBrowserManager.getInstance().getProvider().favorite(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
            i = j;
            continue;
            paramShareActionSheet = bbph.a().a();
            paramActionSheetItem = paramShareActionSheet;
            if (TextUtils.isEmpty(paramShareActionSheet)) {
              paramActionSheetItem = bbph.a().c();
            }
            bbqs.a(this.jdField_a_of_type_Bbrg.mContext, bbph.a().a(), bbph.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int, false);
            i = 6;
            continue;
            paramShareActionSheet = new Intent();
            if (bhfj.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
            for (paramActionSheetItem = bbph.a().d();; paramActionSheetItem = bbph.a().c())
            {
              bbqs.a(this.jdField_a_of_type_Bbrg.mContext, this.jdField_a_of_type_Bbrg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.h, 1, bbph.a().d(), bbph.a().c(), paramShareActionSheet);
              bdla.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", bbrg.a(this.jdField_a_of_type_Bbrg, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
              i = 8;
              break;
            }
            paramShareActionSheet = new Intent();
            if (bhfj.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
            for (paramActionSheetItem = bbph.a().d();; paramActionSheetItem = bbph.a().c())
            {
              bbqs.a(this.jdField_a_of_type_Bbrg.mContext, this.jdField_a_of_type_Bbrg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.h, 2, bbph.a().d(), bbph.a().c(), paramShareActionSheet);
              bdla.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", bbrg.a(this.jdField_a_of_type_Bbrg, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
              i = 9;
              break;
            }
            i = 7;
            auea.a(this.jdField_a_of_type_Bbrg.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrj
 * JD-Core Version:    0.7.0.1
 */