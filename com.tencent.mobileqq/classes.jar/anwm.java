import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class anwm
  implements AdapterView.OnItemClickListener
{
  anwm(ShareActionSheetBuilder paramShareActionSheetBuilder, int paramInt, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      int j = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).sheetItem.action;
      localObject = "";
      label59:
      label120:
      int i;
      if (1 == this.jdField_a_of_type_Int)
      {
        localObject = "0X8005D50";
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        switch (j)
        {
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          if ((j != 9) && (j != 10)) {
            break label358;
          }
          i = -1;
          if (!WXShareHelper.a().a()) {
            i = 2131720175;
          }
          break;
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label358;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131299080));
        break;
        if (2 == this.jdField_a_of_type_Int)
        {
          localObject = "0X8005D51";
          break label59;
        }
        if (3 != this.jdField_a_of_type_Int) {
          break label59;
        }
        localObject = "";
        break label59;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "1", "", "", "");
        break label120;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "2", "", "", "");
        break label120;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "3", "", "", "");
        break label120;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "4", "", "", "");
        break label120;
        if (!WXShareHelper.a().b()) {
          i = 2131720176;
        }
      }
      label358:
      localObject = "邀请加入QQ热聊：" + this.jdField_a_of_type_JavaLangString;
      switch (j)
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        break;
      case 2: 
        localObject = anvx.a(2131705030) + this.jdField_a_of_type_JavaLangString + anvx.a(2131705031);
        anwf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, (String)localObject, this.b, this.c, this.d, this.e, false);
        break;
      case 3: 
        anwf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, (String)localObject, this.b, this.c, this.e);
        break;
      case 9: 
        anwf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, (String)localObject, "立即加入，一起热聊！\nQQ热聊有上百个热门话题，与同兴趣的人一起群聊。", this.f, this.c, this.g);
        break;
      case 10: 
        anwf.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, (String)localObject, this.b, this.f, this.c, this.g);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwm
 * JD-Core Version:    0.7.0.1
 */