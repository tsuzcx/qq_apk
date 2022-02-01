package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AVGameShareBase
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected QQProgressDialog a;
  protected ShareActionSheet a;
  protected WXShareHelper.WXShareListener a;
  protected String a;
  private String b;
  private String c;
  private String d;
  
  public AVGameShareBase(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    paramString1 = new ShareActionSheetV2.Param();
    paramString1.context = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(paramString1);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public String a()
  {
    return this.c;
  }
  
  protected String a(int paramInt)
  {
    return "";
  }
  
  public String a(long paramLong)
  {
    String str2 = String.valueOf(paramLong);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.length() < 9) {
        str1 = "000000000".substring(0, 9 - str2.length()) + str2;
      }
    }
    return str1;
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem> a()
  {
    QLog.d("AVGameShareBase", 1, "getPathsLines");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return localArrayList;
  }
  
  protected void a()
  {
    QLog.d("AVGameShareBase", 1, "shareLinkToQzone");
    QZoneShareData localQZoneShareData = new QZoneShareData();
    if (TextUtils.isEmpty(c())) {
      localQZoneShareData.mSummary = "邀请你加入派对";
    }
    for (localQZoneShareData.mDefaultForwardReason = "邀请你加入派对";; localQZoneShareData.mDefaultForwardReason = (c() + "邀请你加入派对"))
    {
      localQZoneShareData.mTitle = "QQ一起派对";
      localQZoneShareData.mImageUrls = new ArrayList();
      localQZoneShareData.mImageUrls.add(f());
      if (b())
      {
        localQZoneShareData.mSummary = e();
        localQZoneShareData.mDefaultForwardReason = e();
        localQZoneShareData.mTitle = d();
      }
      localQZoneShareData.targetUrl = a();
      localQZoneShareData.from = 0;
      QZoneShareManager.shareToQzone(a(), b(), localQZoneShareData, null, b());
      return;
      localQZoneShareData.mSummary = (c() + "邀请你加入派对");
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new AVGameShareBase.1(this, paramInt);
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  protected void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity);
    }
  }
  
  protected void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = paramActionSheetItem.action;
    QLog.d("AVGameShareBase", 1, "handleClickMenuItem action: " + i);
    switch (i)
    {
    default: 
      QLog.e("AVGameShareBase", 1, "handleClickMenuItem not support action: " + i);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      return;
      d();
      continue;
      b(paramActionSheetItem);
      continue;
      e();
      continue;
      f(i);
      continue;
      b();
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected int b()
  {
    return AVGameActivity.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.b;
  }
  
  protected String b(int paramInt)
  {
    return "";
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem> b()
  {
    QLog.d("AVGameShareBase", 1, "getOperationsLines");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(160));
    return localArrayList;
  }
  
  protected void b()
  {
    try
    {
      Object localObject = GameEngine.a().a();
      long l = ((EngineData)localObject).a();
      QLog.d("AVGameShareBase", 1, "copyRoomId: " + l);
      int i = ((EngineData)localObject).d();
      ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", i, 0, "5", String.valueOf(l), "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B067", "0X800B067", i, 0, "", String.valueOf(l), "", "");
      String str = GameEngine.a().a().getCurrentAccountUin();
      localObject = ((EngineData)localObject).a().getNick(str);
      ((ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("avgame_share_copy_room_id_label", String.format(a().getString(2131690381), new Object[] { localObject, a(), a(l) })));
      AVGameHandler.a().b().post(new AVGameShareBase.4(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AVGameShareBase", 1, "copyRoomId error: " + localException.getMessage());
    }
  }
  
  protected void b(int paramInt) {}
  
  protected abstract void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem);
  
  protected boolean b()
  {
    return false;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public abstract void c();
  
  protected void c(int paramInt)
  {
    QQToast.a(a(), 1, 2131690598, 0).a();
  }
  
  protected String d()
  {
    return "";
  }
  
  protected abstract void d();
  
  protected void d(int paramInt)
  {
    QQToast.a(a(), 1, 2131690598, 0).a();
  }
  
  protected String e()
  {
    return "";
  }
  
  protected abstract void e();
  
  protected void e(int paramInt)
  {
    Object localObject = a();
    HashMap localHashMap = new HashMap(1);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("AVGameShareBase", 1, "shareLinkToWeChat error: params wrong");
      QQToast.a(a(), 1, 2131690599, 0).a();
      return;
    }
    if (!WXShareHelper.a().a())
    {
      QLog.e("AVGameShareBase", 1, "shareLinkToWeChat error: wechat not install");
      QQToast.a(a(), 1, 2131720753, 0).a();
      return;
    }
    if (!WXShareHelper.a().b())
    {
      QLog.e("AVGameShareBase", 1, "shareLinkToWeChat error: wechat version not support");
      QQToast.a(a(), 1, 2131720754, 0).a();
      return;
    }
    a(paramInt);
    localObject = new AVGameShareBase.2(this, localHashMap, paramInt, (String)localObject);
    a(a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693940);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ThreadManager.post(new AVGameShareBase.3(this, localHashMap, (Runnable)localObject), 8, null, false);
  }
  
  protected String f()
  {
    return "https://qqvgame.qq.com/0e7d77945e6e86568d67a788d8c6874a.png";
  }
  
  protected abstract void f(int paramInt);
  
  protected String g()
  {
    return "https://qqvgame.qq.com/b4feec84dbadde0df6eb60ea0437aad1.png";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareBase
 * JD-Core Version:    0.7.0.1
 */