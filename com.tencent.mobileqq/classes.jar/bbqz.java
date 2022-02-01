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

class bbqz
  implements ShareActionSheet.OnItemClickListener
{
  bbqz(bbqw parambbqw, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_Bbqw.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i;
    switch (paramActionSheetItem.action)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", i, 0, "", "", "", "");
      return;
      int j = 1;
      i = j;
      if (bbqw.a(this.jdField_a_of_type_Bbqw))
      {
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          bbqh.a(this.jdField_a_of_type_Bbqw.mContext, paramActionSheetItem, bool);
          i = j;
          break;
        }
        if (!bbqw.a(this.jdField_a_of_type_Bbqw)) {
          break;
        }
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (bool = true;; bool = false)
        {
          bbqh.a(this.jdField_a_of_type_Bbqw.mContext, paramActionSheetItem, bool);
          i = -1;
          break;
        }
        i = paramActionSheetItem.uinType;
        paramActionSheetItem = paramActionSheetItem.uin;
        if (bbqw.a(this.jdField_a_of_type_Bbqw))
        {
          paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int != 1) {
            break label385;
          }
        }
        label385:
        for (bool = true;; bool = false)
        {
          bbqh.a(this.jdField_a_of_type_Bbqw.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
          i = -1;
          break;
        }
        if (!bbqw.a(this.jdField_a_of_type_Bbqw)) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
        bdll.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        QQToast.a(this.jdField_a_of_type_Bbqw.mContext, 2, this.jdField_a_of_type_Bbqw.mContext.getString(2131692401), 0).a();
        i = -1;
        continue;
        j = 5;
        i = j;
        if (bbqw.a(this.jdField_a_of_type_Bbqw))
        {
          RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
          QQToast.a(this.jdField_a_of_type_Bbqw.mContext, this.jdField_a_of_type_Bbqw.mContext.getString(2131692445), 0).a();
          i = j;
          continue;
          i = 2;
          bbqw.a(this.jdField_a_of_type_Bbqw, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData);
          continue;
          j = 3;
          i = j;
          if (bbqw.a(this.jdField_a_of_type_Bbqw))
          {
            RichMediaBrowserManager.getInstance().getProvider().favorite(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
            i = j;
            continue;
            paramShareActionSheet = bbox.a().a();
            paramActionSheetItem = paramShareActionSheet;
            if (TextUtils.isEmpty(paramShareActionSheet)) {
              paramActionSheetItem = bbox.a().c();
            }
            bbqi.a(this.jdField_a_of_type_Bbqw.mContext, bbox.a().a(), bbox.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int, false);
            i = 6;
            continue;
            paramActionSheetItem = paramActionSheetItem.argus;
            paramShareActionSheet = new Intent();
            paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
            if (bhnt.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
            for (paramActionSheetItem = bbox.a().d();; paramActionSheetItem = bbox.a().c())
            {
              bbqi.a(this.jdField_a_of_type_Bbqw.mContext, this.jdField_a_of_type_Bbqw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.h, 1, bbox.a().d(), bbox.a().c(), paramShareActionSheet);
              bdll.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", bbqw.a(this.jdField_a_of_type_Bbqw, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
              i = 8;
              break;
            }
            paramActionSheetItem = paramActionSheetItem.argus;
            paramShareActionSheet = new Intent();
            paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
            if (bhnt.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
            for (paramActionSheetItem = bbox.a().d();; paramActionSheetItem = bbox.a().c())
            {
              bbqi.a(this.jdField_a_of_type_Bbqw.mContext, this.jdField_a_of_type_Bbqw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.h, 2, bbox.a().d(), bbox.a().c(), paramShareActionSheet);
              bdll.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", bbqw.a(this.jdField_a_of_type_Bbqw, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
              i = 9;
              break;
            }
            i = 7;
            aunj.a(this.jdField_a_of_type_Bbqw.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqz
 * JD-Core Version:    0.7.0.1
 */