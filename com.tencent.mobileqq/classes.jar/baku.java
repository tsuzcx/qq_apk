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

class baku
  implements ShareActionSheet.OnItemClickListener
{
  baku(bakr parambakr, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_Bakr.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i;
    switch (paramActionSheetItem.action)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", i, 0, "", "", "", "");
      return;
      int j = 1;
      i = j;
      if (bakr.a(this.jdField_a_of_type_Bakr))
      {
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          bakc.a(this.jdField_a_of_type_Bakr.mContext, paramActionSheetItem, bool);
          i = j;
          break;
        }
        if (!bakr.a(this.jdField_a_of_type_Bakr)) {
          break;
        }
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (bool = true;; bool = false)
        {
          bakc.a(this.jdField_a_of_type_Bakr.mContext, paramActionSheetItem, bool);
          i = -1;
          break;
        }
        i = paramActionSheetItem.uinType;
        paramActionSheetItem = paramActionSheetItem.uin;
        if (bakr.a(this.jdField_a_of_type_Bakr))
        {
          paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int != 1) {
            break label385;
          }
        }
        label385:
        for (bool = true;; bool = false)
        {
          bakc.a(this.jdField_a_of_type_Bakr.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
          i = -1;
          break;
        }
        if (!bakr.a(this.jdField_a_of_type_Bakr)) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
        bcef.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        QQToast.a(this.jdField_a_of_type_Bakr.mContext, 2, this.jdField_a_of_type_Bakr.mContext.getString(2131692449), 0).a();
        i = -1;
        continue;
        j = 5;
        i = j;
        if (bakr.a(this.jdField_a_of_type_Bakr))
        {
          RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
          QQToast.a(this.jdField_a_of_type_Bakr.mContext, this.jdField_a_of_type_Bakr.mContext.getString(2131692493), 0).a();
          i = j;
          continue;
          i = 2;
          bakr.a(this.jdField_a_of_type_Bakr, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData);
          continue;
          j = 3;
          i = j;
          if (bakr.a(this.jdField_a_of_type_Bakr))
          {
            RichMediaBrowserManager.getInstance().getProvider().favorite(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
            i = j;
            continue;
            paramShareActionSheet = bais.a().a();
            paramActionSheetItem = paramShareActionSheet;
            if (TextUtils.isEmpty(paramShareActionSheet)) {
              paramActionSheetItem = bais.a().c();
            }
            bakd.a(this.jdField_a_of_type_Bakr.mContext, bais.a().a(), bais.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int, false);
            i = 6;
            continue;
            paramActionSheetItem = paramActionSheetItem.argus;
            paramShareActionSheet = new Intent();
            paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
            if (bfwr.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
            for (paramActionSheetItem = bais.a().d();; paramActionSheetItem = bais.a().c())
            {
              bakd.a(this.jdField_a_of_type_Bakr.mContext, this.jdField_a_of_type_Bakr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.h, 1, bais.a().d(), bais.a().c(), paramShareActionSheet);
              bcef.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", bakr.a(this.jdField_a_of_type_Bakr, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
              i = 8;
              break;
            }
            paramActionSheetItem = paramActionSheetItem.argus;
            paramShareActionSheet = new Intent();
            paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
            if (bfwr.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
            for (paramActionSheetItem = bais.a().d();; paramActionSheetItem = bais.a().c())
            {
              bakd.a(this.jdField_a_of_type_Bakr.mContext, this.jdField_a_of_type_Bakr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.h, 2, bais.a().d(), bais.a().c(), paramShareActionSheet);
              bcef.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", bakr.a(this.jdField_a_of_type_Bakr, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
              i = 9;
              break;
            }
            i = 7;
            aszt.a(this.jdField_a_of_type_Bakr.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baku
 * JD-Core Version:    0.7.0.1
 */