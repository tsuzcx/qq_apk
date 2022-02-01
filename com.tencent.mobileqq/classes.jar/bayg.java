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

class bayg
  implements ShareActionSheet.OnItemClickListener
{
  bayg(bayd parambayd, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_Bayd.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i;
    switch (paramActionSheetItem.action)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", i, 0, "", "", "", "");
      return;
      int j = 1;
      i = j;
      if (bayd.a(this.jdField_a_of_type_Bayd))
      {
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          baxo.a(this.jdField_a_of_type_Bayd.mContext, paramActionSheetItem, bool);
          i = j;
          break;
        }
        if (!bayd.a(this.jdField_a_of_type_Bayd)) {
          break;
        }
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (bool = true;; bool = false)
        {
          baxo.a(this.jdField_a_of_type_Bayd.mContext, paramActionSheetItem, bool);
          i = -1;
          break;
        }
        i = paramActionSheetItem.uinType;
        paramActionSheetItem = paramActionSheetItem.uin;
        if (bayd.a(this.jdField_a_of_type_Bayd))
        {
          paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int != 1) {
            break label385;
          }
        }
        label385:
        for (bool = true;; bool = false)
        {
          baxo.a(this.jdField_a_of_type_Bayd.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
          i = -1;
          break;
        }
        if (!bayd.a(this.jdField_a_of_type_Bayd)) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
        bcst.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        QQToast.a(this.jdField_a_of_type_Bayd.mContext, 2, this.jdField_a_of_type_Bayd.mContext.getString(2131692396), 0).a();
        i = -1;
        continue;
        j = 5;
        i = j;
        if (bayd.a(this.jdField_a_of_type_Bayd))
        {
          RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
          QQToast.a(this.jdField_a_of_type_Bayd.mContext, this.jdField_a_of_type_Bayd.mContext.getString(2131692439), 0).a();
          i = j;
          continue;
          i = 2;
          bayd.a(this.jdField_a_of_type_Bayd, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData);
          continue;
          j = 3;
          i = j;
          if (bayd.a(this.jdField_a_of_type_Bayd))
          {
            RichMediaBrowserManager.getInstance().getProvider().favorite(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
            i = j;
            continue;
            paramShareActionSheet = bawe.a().a();
            paramActionSheetItem = paramShareActionSheet;
            if (TextUtils.isEmpty(paramShareActionSheet)) {
              paramActionSheetItem = bawe.a().c();
            }
            baxp.a(this.jdField_a_of_type_Bayd.mContext, bawe.a().a(), bawe.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int, false);
            i = 6;
            continue;
            paramActionSheetItem = paramActionSheetItem.argus;
            paramShareActionSheet = new Intent();
            paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
            if (bgnr.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
            for (paramActionSheetItem = bawe.a().d();; paramActionSheetItem = bawe.a().c())
            {
              baxp.a(this.jdField_a_of_type_Bayd.mContext, this.jdField_a_of_type_Bayd.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.h, 1, bawe.a().d(), bawe.a().c(), paramShareActionSheet);
              bcst.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", bayd.a(this.jdField_a_of_type_Bayd, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
              i = 8;
              break;
            }
            paramActionSheetItem = paramActionSheetItem.argus;
            paramShareActionSheet = new Intent();
            paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
            if (bgnr.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
            for (paramActionSheetItem = bawe.a().d();; paramActionSheetItem = bawe.a().c())
            {
              baxp.a(this.jdField_a_of_type_Bayd.mContext, this.jdField_a_of_type_Bayd.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.h, 2, bawe.a().d(), bawe.a().c(), paramShareActionSheet);
              bcst.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", bayd.a(this.jdField_a_of_type_Bayd, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
              i = 9;
              break;
            }
            i = 7;
            atvo.a(this.jdField_a_of_type_Bayd.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayg
 * JD-Core Version:    0.7.0.1
 */