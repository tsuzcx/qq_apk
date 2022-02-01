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
  private String b;
  
  public AVGameShareResultPic(Activity paramActivity, String paramString, int paramInt)
  {
    super(paramActivity, null, null, null, paramInt);
    this.b = paramString;
  }
  
  private Intent y()
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
  
  protected void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    QLog.d("AVGameShareResultPic", 1, "shareToSpecifiedFriend");
    u();
    ImageShareInfo localImageShareInfo = new ImageShareInfo(this.b, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareImageToQQDirectly("avShareResultPic", a(), localImageShareInfo, paramActionSheetItem.uinType, paramActionSheetItem.uin);
    v();
    QLog.d("AVGameShareResultPic", 1, "shareToSpecifiedFriend success");
  }
  
  protected void c(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shareToWeChat shareType: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("AVGameShareResultPic", 1, ((StringBuilder)localObject).toString());
    int i = e();
    if (paramInt == 9) {
      localObject = "3";
    } else {
      localObject = "4";
    }
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", i, 0, (String)localObject, "", "", "");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doSharePicToWX("avShareResultPic", a(), String.valueOf(System.currentTimeMillis()), this.b, paramInt);
  }
  
  public void i(int paramInt)
  {
    AVGameShareUtil.a().a(a(), 2, true);
  }
  
  public void j(int paramInt)
  {
    QQToast.makeText(a(), 1, 2131887437, 0).show();
  }
  
  public void k(int paramInt)
  {
    QQToast.makeText(a(), 1, 2131887437, 0).show();
  }
  
  public void m(int paramInt)
  {
    String str;
    if (paramInt == 9) {
      str = "3";
    } else {
      str = "4";
    }
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", 0, 0, str, "", "", "");
    if (GameEngine.a().A())
    {
      int i;
      if (GameEngine.a().s().t.gameSur) {
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
  
  public void p()
  {
    QLog.d("AVGameShareResultPic", 1, "showActionSheet");
    if ((a() != null) && (!TextUtils.isEmpty(this.b)))
    {
      if (this.a == null)
      {
        QLog.e("AVGameShareResultPic", 1, "mShareActionSheet is null");
        return;
      }
      if (this.a.isShowing())
      {
        this.a.dismiss();
        return;
      }
      a().getIntent().putExtra("big_brother_source_key", "biz_src_jc_av_game");
      List localList1 = j();
      List localList2 = k();
      Intent localIntent = y();
      this.a.setIntentForStartForwardRecentActivity(localIntent);
      this.a.setRowVisibility(0, 0, 0);
      this.a.setActionSheetItems(localList1, localList2);
      this.a.setItemClickListenerV2(new AVGameShareResultPic.1(this));
      this.a.show();
      return;
    }
    QLog.e("AVGameShareResultPic", 1, "showActionSheet error: params wrong");
    QQToast.makeText(a(), 2131887438, 0).show();
  }
  
  protected void q()
  {
    QLog.d("AVGameShareResultPic", 1, "shareToQQ");
    s();
    ImageShareInfo localImageShareInfo = new ImageShareInfo(this.b, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareImageToQQBySelect("avShareResultPic", a(), localImageShareInfo);
    t();
    QLog.d("AVGameShareResultPic", 1, "shareToQQ success");
  }
  
  protected void r()
  {
    QLog.d("AVGameShareResultPic", 1, "shareToQzone");
    w();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareToQZoneWithPics("avShareResultPic", a(), localArrayList, 10000);
    x();
  }
  
  public void s()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", e(), 0, "1", "", "", "");
  }
  
  public void t()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", e(), 0, "1", "", "", "");
    if (GameEngine.a().A())
    {
      int i;
      if (GameEngine.a().s().t.gameSur) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, "1", "", "", "");
    }
  }
  
  public void u()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", e(), 0, "0", "", "", "");
  }
  
  public void v()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", e(), 0, "0", "", "", "");
    if (GameEngine.a().A())
    {
      int i;
      if (GameEngine.a().s().t.gameSur) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, "0", "", "", "");
    }
  }
  
  public void w()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", e(), 0, "2", "", "", "");
  }
  
  public void x()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", e(), 0, "2", "", "", "");
    if (GameEngine.a().A())
    {
      int i;
      if (GameEngine.a().s().t.gameSur) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, "2", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareResultPic
 * JD-Core Version:    0.7.0.1
 */