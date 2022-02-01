package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AVGameShareResultPic
  extends AVGameShareBase
{
  private String b;
  
  public AVGameShareResultPic(Activity paramActivity, String paramString, int paramInt)
  {
    super(paramActivity, null, null, null, paramInt);
    this.b = paramString;
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
    localIntent.setData(Uri.parse(this.b));
    return localIntent;
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    AVGameShareUtil.a().a(a(), 2, true);
  }
  
  protected void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    QLog.d("AVGameShareResultPic", 1, "shareToSpecifiedFriend");
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "0", "", "", "");
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_req", ForwardRecentActivity.f);
    localBundle.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
    localBundle.putString("key_direct_show_uin", paramActionSheetItem.uin);
    paramActionSheetItem = a();
    if (paramActionSheetItem == null)
    {
      QLog.e("AVGameShareResultPic", 1, "shareToSpecifiedFriend error: intent is null");
      QQToast.a(a(), 2131690599, 0).a();
    }
    do
    {
      return;
      paramActionSheetItem.putExtras(localBundle);
      ForwardBaseOption.a(a(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, -1);
      QLog.d("AVGameShareResultPic", 1, "shareToSpecifiedFriend success");
      ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "0", "", "", "");
    } while (!GameEngine.a().f());
    if (GameEngine.a().a().a.gameSur) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, "0", "", "", "");
      return;
    }
  }
  
  public void c()
  {
    QLog.d("AVGameShareResultPic", 1, "showActionSheet");
    if ((a() == null) || (TextUtils.isEmpty(this.b)))
    {
      QLog.e("AVGameShareResultPic", 1, "showActionSheet error: params wrong");
      QQToast.a(a(), 2131690599, 0).a();
      return;
    }
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
  }
  
  protected void c(int paramInt)
  {
    super.c(paramInt);
  }
  
  protected void d()
  {
    QLog.d("AVGameShareResultPic", 1, "shareToQQ");
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "1", "", "", "");
    Intent localIntent = a();
    if (localIntent == null)
    {
      QLog.e("AVGameShareResultPic", 1, "shareToQQ error: params wrong");
      QQToast.a(a(), 2131690599, 0).a();
    }
    do
    {
      return;
      a().startActivityForResult(localIntent, -1);
      QLog.d("AVGameShareResultPic", 1, "shareToQQ success");
      ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "1", "", "", "");
    } while (!GameEngine.a().f());
    if (GameEngine.a().a().a.gameSur) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, "1", "", "", "");
      return;
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
  }
  
  protected void e()
  {
    QLog.d("AVGameShareResultPic", 1, "shareToQzone");
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "2", "", "", "");
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    localBundle.putStringArrayList("images", localArrayList);
    QZoneShareManager.publishToQzone(localAppInterface, a(), localBundle, null, AVGameActivity.a);
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "2", "", "", "");
    if (GameEngine.a().f()) {
      if (!GameEngine.a().a().a.gameSur) {
        break label176;
      }
    }
    label176:
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, "2", "", "", "");
      return;
    }
  }
  
  protected void f(int paramInt)
  {
    QLog.d("AVGameShareResultPic", 1, "shareToWeChat shareType: " + paramInt);
    int i = a();
    if (paramInt == 9) {}
    for (Object localObject = "3";; localObject = "4")
    {
      ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", i, 0, (String)localObject, "", "", "");
      localObject = new HashMap(1);
      if (WXShareHelper.a().a()) {
        break;
      }
      QLog.e("AVGameShareResultPic", 1, "shareToWeChat error: wechat not install");
      QQToast.a(a(), 1, 2131720753, 0).a();
      return;
    }
    if (!WXShareHelper.a().b())
    {
      QLog.e("AVGameShareResultPic", 1, "shareToWeChat error: wechat version not support");
      QQToast.a(a(), 1, 2131720754, 0).a();
      return;
    }
    a(paramInt);
    AVGameShareResultPic.2 local2 = new AVGameShareResultPic.2(this, (Map)localObject, paramInt);
    a(a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693940);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ThreadManager.post(new AVGameShareResultPic.3(this, (Map)localObject, local2), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareResultPic
 * JD-Core Version:    0.7.0.1
 */