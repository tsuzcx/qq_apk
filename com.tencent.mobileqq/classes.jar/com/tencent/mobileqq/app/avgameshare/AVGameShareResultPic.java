package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.sharehelper.ImageShareInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

@KeepClassConstructor
public class AVGameShareResultPic
  extends AVGameShareBase
{
  private String a;
  
  public AVGameShareResultPic(Activity paramActivity, String paramString, int paramInt)
  {
    super(paramActivity, null, null, null, paramInt);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Intent a()
  {
    QLog.d("AVGameShareResultPic", 1, "getImageIntent");
    Intent localIntent = new Intent(a(), ForwardRecentActivity.class);
    localIntent.putExtra("key_help_forward_pic", true);
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("key_allow_multiple_forward_from_limit", false);
    localIntent.putExtra("selection_mode", 2);
    localIntent.putExtra("avgame_share_callback_key", true);
    localIntent.setData(Uri.parse(this.jdField_a_of_type_JavaLangString));
    return localIntent;
  }
  
  protected void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shareToWeChat shareType: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("AVGameShareResultPic", 1, ((StringBuilder)localObject).toString());
    int i = a();
    if (paramInt == 9) {
      localObject = "3";
    } else {
      localObject = "4";
    }
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", i, 0, (String)localObject, "", "", "");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doSharePicToWX("avShareResultPic", a(), String.valueOf(System.currentTimeMillis()), this.jdField_a_of_type_JavaLangString, paramInt);
  }
  
  public void b()
  {
    QLog.d("AVGameShareResultPic", 1, "showActionSheet");
    if ((a() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
      {
        QLog.e("AVGameShareResultPic", 1, "mShareActionSheet is null");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
        return;
      }
      a().getIntent().putExtra("big_brother_source_key", "biz_src_jc_av_game");
      List localList1 = a();
      List localList2 = b();
      Intent localIntent = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localList1, localList2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new AVGameShareResultPic.1(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
    }
    QLog.e("AVGameShareResultPic", 1, "showActionSheet error: params wrong");
    QQToast.a(a(), 2131690527, 0).a();
  }
  
  protected void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    QLog.d("AVGameShareResultPic", 1, "shareToSpecifiedFriend");
    g();
    ImageShareInfo localImageShareInfo = new ImageShareInfo(this.jdField_a_of_type_JavaLangString, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareImageToQQDirectly("avShareResultPic", a(), localImageShareInfo, paramActionSheetItem.uinType, paramActionSheetItem.uin);
    h();
    QLog.d("AVGameShareResultPic", 1, "shareToSpecifiedFriend success");
  }
  
  protected void c()
  {
    QLog.d("AVGameShareResultPic", 1, "shareToQQ");
    e();
    ImageShareInfo localImageShareInfo = new ImageShareInfo(this.jdField_a_of_type_JavaLangString, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareImageToQQBySelect("avShareResultPic", a(), localImageShareInfo);
    f();
    QLog.d("AVGameShareResultPic", 1, "shareToQQ success");
  }
  
  protected void d()
  {
    QLog.d("AVGameShareResultPic", 1, "shareToQzone");
    i();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareToQZoneWithPics("avShareResultPic", a(), localArrayList, 10000);
    j();
  }
  
  public void e()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "1", "", "", "");
  }
  
  public void f()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "1", "", "", "");
    if (GameEngine.a().f())
    {
      int i;
      if (GameEngine.a().a().a.gameSur) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, "1", "", "", "");
    }
  }
  
  public void g()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "0", "", "", "");
  }
  
  public void g(int paramInt)
  {
    AVGameShareUtil.a().a(a(), 2, true);
  }
  
  public void h()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "0", "", "", "");
    if (GameEngine.a().f())
    {
      int i;
      if (GameEngine.a().a().a.gameSur) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, "0", "", "", "");
    }
  }
  
  public void h(int paramInt)
  {
    QQToast.a(a(), 1, 2131690526, 0).a();
  }
  
  public void i()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "2", "", "", "");
  }
  
  public void i(int paramInt)
  {
    QQToast.a(a(), 1, 2131690526, 0).a();
  }
  
  public void j()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "2", "", "", "");
    if (GameEngine.a().f())
    {
      int i;
      if (GameEngine.a().a().a.gameSur) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, "2", "", "", "");
    }
  }
  
  public void k(int paramInt)
  {
    String str;
    if (paramInt == 9) {
      str = "3";
    } else {
      str = "4";
    }
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", 0, 0, str, "", "", "");
    if (GameEngine.a().f())
    {
      int i;
      if (GameEngine.a().a().a.gameSur) {
        i = 1;
      } else {
        i = 2;
      }
      if (paramInt == 9) {
        str = "3";
      } else {
        str = "4";
      }
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, str, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareResultPic
 * JD-Core Version:    0.7.0.1
 */