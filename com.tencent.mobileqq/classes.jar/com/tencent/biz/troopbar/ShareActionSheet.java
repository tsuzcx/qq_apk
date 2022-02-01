package com.tencent.biz.troopbar;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class ShareActionSheet
  implements AdapterView.OnItemClickListener
{
  static String a;
  public static String b;
  public static String c;
  public static String d = "https://spqq.mp.qq.com/pub/get_face_https?img_type=3&uin=";
  protected float a;
  protected int a;
  protected ShareActionSheet.Detail a;
  protected BaseActivity a;
  protected QQAppInterface a;
  protected ShareActionSheetBuilder a;
  protected String e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://imgplat.store.qq.com/bqq_qfpic/520520/%s_%s_face/0";
    jdField_b_of_type_JavaLangString = "https://s.p.qq.com/pub/get_face?img_type=3&uin=";
    jdField_c_of_type_JavaLangString = "https://spqq.mp.qq.com/pub/get_face?img_type=3&uin=";
  }
  
  public ShareActionSheet(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ShareActionSheet.Detail paramDetail, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Float = paramBaseActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail = paramDetail;
    this.jdField_a_of_type_Int = paramInt;
    this.e = paramString;
  }
  
  @NotNull
  private static Intent a(Activity paramActivity, ShareActionSheet.Detail paramDetail, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ShareActionSheet getShareToFriendIntent");
    }
    localIntent.setClass(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("category", paramActivity.getString(2131695263));
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("detail_url", paramString);
    localIntent.putExtra("title", paramDetail.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("desc", a(paramDetail.jdField_c_of_type_JavaLangString));
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("struct_share_key_content_action", "plugin");
    localIntent.putExtra("pubUin", paramDetail.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("pluginName", "public_account");
    paramString = "";
    paramActivity = "";
    if (paramInt == 1)
    {
      localIntent.putExtra("image_url_remote", jdField_b_of_type_JavaLangString + paramDetail.jdField_a_of_type_JavaLangString);
      paramString = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + paramDetail.jdField_a_of_type_JavaLangString;
      paramActivity = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + paramDetail.jdField_a_of_type_JavaLangString + "&version=1";
    }
    for (;;)
    {
      localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString);
      localIntent.putExtra("struct_share_key_content_i_action_DATA", paramActivity);
      return localIntent;
      if (paramInt == 2) {
        try
        {
          long l = Long.parseLong(paramDetail.jdField_a_of_type_JavaLangString);
          paramInt = (int)(l % 256L);
          localIntent.putExtra("image_url_remote", String.format(jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
          paramString = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + paramDetail.jdField_a_of_type_JavaLangString;
          paramActivity = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramDetail.jdField_a_of_type_JavaLangString + "&version=1";
        }
        catch (Exception paramActivity)
        {
          QLog.d("forward", 2, "ShareActionSheet getShareToFriendIntent Long.parseLong(accountDetail.uin) error");
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    String str = paramString;
    if (paramString.length() > 30) {
      str = paramString.substring(0, 30);
    }
    if ((str.length() <= 30) && (str.getBytes().length <= 100)) {
      return str;
    }
    paramString = new StringBuilder();
    for (;;)
    {
      if (i < str.length())
      {
        paramString.append(str.charAt(i));
        if (paramString.toString().getBytes().length <= 100) {}
      }
      else
      {
        paramString = paramString.toString();
        return paramString + "...";
      }
      i += 1;
    }
  }
  
  public static void a(Activity paramActivity, ShareActionSheet.Detail paramDetail, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("ShareActionSheet shareToQidian | account_uin=");
      if (paramDetail != null) {
        break label49;
      }
    }
    label49:
    for (String str = "null";; str = paramDetail.jdField_a_of_type_JavaLangString)
    {
      QLog.d("forward", 2, str);
      if (paramDetail != null) {
        break;
      }
      return;
    }
    QidianManager.a(paramActivity, 6, paramDetail.jdField_b_of_type_JavaLangString, paramDetail.jdField_c_of_type_JavaLangString, paramString, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramDetail.jdField_a_of_type_JavaLangString, paramDetail.jdField_a_of_type_JavaLangString, paramInt, true);
  }
  
  public static void a(Activity paramActivity, ShareActionSheet.Detail paramDetail, int paramInt, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("ShareActionSheet shareToSpecifiedFriend | account_uin=");
      if (paramDetail == null)
      {
        str = "null";
        localStringBuilder = localStringBuilder.append(str).append(" | friend_uin=");
        if (paramActionSheetItem != null) {
          break label86;
        }
        str = "null";
        label51:
        QLog.d("forward", 2, str);
      }
    }
    else
    {
      if ((paramDetail != null) && (paramActionSheetItem != null)) {
        break label96;
      }
    }
    label86:
    label96:
    do
    {
      do
      {
        return;
        str = paramDetail.jdField_a_of_type_JavaLangString;
        break;
        str = paramActionSheetItem.uin;
        break label51;
        paramDetail = a(paramActivity, paramDetail, paramInt, paramString);
      } while (paramDetail == null);
      paramString = new Bundle();
      paramString.putInt("key_req", ForwardRecentActivity.f);
      paramString.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
      paramString.putString("key_direct_show_uin", paramActionSheetItem.uin);
      paramDetail.putExtras(paramString);
      paramString = StructMsgFactory.a(paramDetail.getExtras());
    } while (paramString == null);
    paramDetail.putExtra("stuctmsg_bytes", paramString.getBytes());
    paramDetail.putExtra("from_card", true);
    ForwardBaseOption.a(paramActivity, paramDetail, ForwardRecentTranslucentActivity.class, 0, -1, "");
  }
  
  public static void a(BaseActivity paramBaseActivity, ShareActionSheet.Detail paramDetail, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("ShareActionSheet shareToQzone | account_uin=");
      if (paramDetail != null) {
        break label50;
      }
    }
    label50:
    for (Object localObject = "null";; localObject = paramDetail.jdField_a_of_type_JavaLangString)
    {
      QLog.d("forward", 2, (String)localObject);
      if (paramDetail != null) {
        break;
      }
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("title", paramDetail.jdField_b_of_type_JavaLangString);
    ((Bundle)localObject).putString("desc", paramDetail.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putString("detail_url", paramString);
    paramString = new ArrayList(1);
    if (paramInt == 1) {
      paramString.add(jdField_b_of_type_JavaLangString + paramDetail.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ((Bundle)localObject).putStringArrayList("image_url", paramString);
      ((Bundle)localObject).putLong("req_share_id", 0L);
      ((Bundle)localObject).putString("pubUin", paramDetail.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putBoolean("from_card", true);
      QZoneShareManager.jumpToQzoneShare(paramBaseActivity.app, paramBaseActivity, (Bundle)localObject, null);
      return;
      if (paramInt == 2) {
        try
        {
          long l = Long.parseLong(paramDetail.jdField_a_of_type_JavaLangString);
          paramInt = (int)(l % 256L);
          paramString.add(String.format(jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
        }
        catch (Exception paramBaseActivity)
        {
          QLog.d("forward", 2, "ShareActionSheet shareToQzone Long.parseLong(accountDetail.uin) error");
        }
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, ShareActionSheet.Detail paramDetail, int paramInt1, String paramString, int paramInt2)
  {
    paramInt1 = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("ShareActionSheet shareToWX | account_uin=");
      if (paramDetail == null)
      {
        str = "null";
        QLog.d("forward", 2, str);
      }
    }
    else
    {
      if (paramDetail != null) {
        break label61;
      }
    }
    label61:
    label93:
    do
    {
      do
      {
        return;
        str = paramDetail.jdField_a_of_type_JavaLangString;
        break;
        if (WXShareHelper.a().a()) {
          break label93;
        }
        QRUtils.a(0, 2131720753);
      } while (!QLog.isColorLevel());
      QLog.d("forward", 2, "ShareActionSheet shareToWXfail: WX is not installed");
      return;
      if (WXShareHelper.a().b()) {
        break label125;
      }
      QRUtils.a(0, 2131720754);
    } while (!QLog.isColorLevel());
    QLog.d("forward", 2, "ShareActionSheet shareToWX fail: WX version too low");
    return;
    label125:
    String str = String.valueOf(System.currentTimeMillis());
    WXShareHelper.a().a(new ShareActionSheet.1(str));
    paramBaseActivity = paramBaseActivity.app.getFaceBitmap(paramDetail.jdField_a_of_type_JavaLangString, (byte)1, true);
    if (paramInt2 == 9) {}
    for (;;)
    {
      WXShareHelper.a().b(str, paramDetail.jdField_b_of_type_JavaLangString, paramBaseActivity, paramDetail.jdField_c_of_type_JavaLangString, paramString, paramInt1);
      return;
      paramInt1 = 1;
    }
  }
  
  public static void b(Activity paramActivity, ShareActionSheet.Detail paramDetail, int paramInt, String paramString)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("ShareActionSheet shareToFriend | account_uin=");
      if (paramDetail == null)
      {
        str = "null";
        QLog.d("forward", 2, str);
      }
    }
    else
    {
      if (paramDetail != null) {
        break label59;
      }
    }
    label59:
    do
    {
      do
      {
        return;
        str = paramDetail.jdField_a_of_type_JavaLangString;
        break;
        paramDetail = a(paramActivity, paramDetail, paramInt, paramString);
      } while (paramDetail == null);
      paramString = StructMsgFactory.a(paramDetail.getExtras());
    } while (paramString == null);
    paramDetail.putExtra("stuctmsg_bytes", paramString.getBytes());
    paramDetail.putExtra("from_card", true);
    paramActivity.startActivity(paramDetail);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719311));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696380);
    localActionSheetItem.icon = 2130839214;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696394);
    localActionSheetItem.icon = 2130839215;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696401);
    localActionSheetItem.icon = 2130839218;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696383);
    localActionSheetItem.icon = 2130839212;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 == null)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a.action;
    Object localObject3;
    Object localObject2;
    switch (i)
    {
    default: 
      localObject1 = null;
    case 2: 
    case 3: 
      while ((this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_c_of_type_Int == ShareActionSheet.Detail.jdField_b_of_type_Int) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_JavaLangString;
        if (!this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_Boolean) {
          break label458;
        }
        localObject2 = "02";
        ReportController.b((AppRuntime)localObject3, "dc01160", "Pb_account_lifeservice", str, "0X8007CA6", "0X8007CA6", 0, 0, (String)localObject2, (String)localObject1, String.valueOf(this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.d), "");
        break;
        b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail, this.jdField_a_of_type_Int, this.e);
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "share_qq");
        localObject1 = "01";
        continue;
        a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail, this.jdField_a_of_type_Int, this.e);
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "share_qzone");
        localObject1 = "02";
      }
    case 9: 
    case 10: 
      label150:
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail, this.jdField_a_of_type_Int, this.e, i);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject3 = this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_JavaLangString;
      if (i == 9)
      {
        localObject1 = "share_wechat";
        label338:
        PublicAccountHandler.a((AppInterface)localObject2, (String)localObject3, "Grp_tribe", "interest_data", (String)localObject1);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_JavaLangString, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
        if (9 != i) {
          break label466;
        }
      }
      break;
    }
    label458:
    label466:
    for (localObject1 = "03"; 10 == i; localObject1 = null)
    {
      localObject1 = "04";
      break;
      localObject1 = "share_circle";
      break label338;
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail, this.jdField_a_of_type_Int, this.e);
      localObject1 = null;
      break;
      localObject2 = "01";
      break label150;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopbar.ShareActionSheet
 * JD-Core Version:    0.7.0.1
 */