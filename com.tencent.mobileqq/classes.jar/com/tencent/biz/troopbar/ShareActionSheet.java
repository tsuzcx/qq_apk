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
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
  static String a = "https://imgplat.store.qq.com/bqq_qfpic/520520/%s_%s_face/0";
  public static String b = "https://s.p.qq.com/pub/get_face?img_type=3&uin=";
  public static String c = "https://spqq.mp.qq.com/pub/get_face?img_type=3&uin=";
  public static String d = "https://spqq.mp.qq.com/pub/get_face_https?img_type=3&uin=";
  protected float a;
  protected int a;
  protected ShareActionSheet.Detail a;
  protected BaseActivity a;
  protected QQAppInterface a;
  protected ShareActionSheetBuilder a;
  protected String e;
  
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
    localIntent.putExtra("category", paramActivity.getString(2131695266));
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("detail_url", paramString);
    localIntent.putExtra("title", paramDetail.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("desc", a(paramDetail.jdField_c_of_type_JavaLangString));
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("struct_share_key_content_action", "plugin");
    localIntent.putExtra("pubUin", paramDetail.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("pluginName", "public_account");
    paramActivity = "";
    if (paramInt == 1)
    {
      paramActivity = new StringBuilder();
      paramActivity.append(jdField_b_of_type_JavaLangString);
      paramActivity.append(paramDetail.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("image_url_remote", paramActivity.toString());
      paramActivity = new StringBuilder();
      paramActivity.append("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=");
      paramActivity.append(paramDetail.jdField_a_of_type_JavaLangString);
      paramActivity = paramActivity.toString();
      paramString = new StringBuilder();
      paramString.append("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=");
      paramString.append(paramDetail.jdField_a_of_type_JavaLangString);
      paramString.append("&version=1");
      paramDetail = paramString.toString();
    }
    else if (paramInt != 2) {}
    try
    {
      long l = Long.parseLong(paramDetail.jdField_a_of_type_JavaLangString);
      paramInt = (int)(l % 256L);
      localIntent.putExtra("image_url_remote", String.format(jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
      paramActivity = new StringBuilder();
      paramActivity.append("mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=");
      paramActivity.append(paramDetail.jdField_a_of_type_JavaLangString);
      paramActivity = paramActivity.toString();
      paramString = new StringBuilder();
      paramString.append("mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=");
      paramString.append(paramDetail.jdField_a_of_type_JavaLangString);
      paramString.append("&version=1");
      paramDetail = paramString.toString();
    }
    catch (Exception paramActivity)
    {
      label388:
      break label388;
    }
    QLog.d("forward", 2, "ShareActionSheet getShareToFriendIntent Long.parseLong(accountDetail.uin) error");
    return null;
    paramDetail = "";
    localIntent.putExtra("struct_share_key_content_a_action_DATA", paramActivity);
    localIntent.putExtra("struct_share_key_content_i_action_DATA", paramDetail);
    return localIntent;
  }
  
  public static String a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    Object localObject = paramString;
    if (j > 30) {
      localObject = paramString.substring(0, 30);
    }
    if ((((String)localObject).length() <= 30) && (((String)localObject).getBytes().length <= 100)) {
      return localObject;
    }
    paramString = new StringBuilder();
    while (i < ((String)localObject).length())
    {
      paramString.append(((String)localObject).charAt(i));
      if (paramString.toString().getBytes().length > 100) {
        break;
      }
      i += 1;
    }
    paramString = paramString.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("...");
    return ((StringBuilder)localObject).toString();
  }
  
  public static void a(Activity paramActivity, ShareActionSheet.Detail paramDetail, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ShareActionSheet shareToQidian | account_uin=");
      if (paramDetail == null) {
        str = "null";
      } else {
        str = paramDetail.jdField_a_of_type_JavaLangString;
      }
      ((StringBuilder)localObject).append(str);
      QLog.d("forward", 2, ((StringBuilder)localObject).toString());
    }
    if (paramDetail == null) {
      return;
    }
    String str = paramDetail.jdField_b_of_type_JavaLangString;
    Object localObject = paramDetail.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=");
    localStringBuilder.append(paramDetail.jdField_a_of_type_JavaLangString);
    QidianManager.a(paramActivity, 6, str, (String)localObject, paramString, localStringBuilder.toString(), paramDetail.jdField_a_of_type_JavaLangString, paramInt, true);
  }
  
  public static void a(Activity paramActivity, ShareActionSheet.Detail paramDetail, int paramInt, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShareActionSheet shareToSpecifiedFriend | account_uin=");
      String str2 = "null";
      String str1;
      if (paramDetail == null) {
        str1 = "null";
      } else {
        str1 = paramDetail.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(" | friend_uin=");
      if (paramActionSheetItem == null) {
        str1 = str2;
      } else {
        str1 = paramActionSheetItem.uin;
      }
      localStringBuilder.append(str1);
      QLog.d("forward", 2, localStringBuilder.toString());
    }
    if (paramDetail != null)
    {
      if (paramActionSheetItem == null) {
        return;
      }
      paramDetail = a(paramActivity, paramDetail, paramInt, paramString);
      if (paramDetail == null) {
        return;
      }
      paramString = new Bundle();
      paramString.putInt("key_req", 1);
      paramString.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
      paramString.putString("key_direct_show_uin", paramActionSheetItem.uin);
      paramDetail.putExtras(paramString);
      paramString = StructMsgFactory.a(paramDetail.getExtras());
      if (paramString != null)
      {
        paramDetail.putExtra("stuctmsg_bytes", paramString.getBytes());
        paramDetail.putExtra("from_card", true);
        ForwardBaseOption.a(paramActivity, paramDetail, ForwardRecentTranslucentActivity.class, 0, -1, "");
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, ShareActionSheet.Detail paramDetail, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShareActionSheet shareToQzone | account_uin=");
      if (paramDetail == null) {
        localObject = "null";
      } else {
        localObject = paramDetail.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append((String)localObject);
      QLog.d("forward", 2, localStringBuilder.toString());
    }
    if (paramDetail == null) {
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("title", paramDetail.jdField_b_of_type_JavaLangString);
    ((Bundle)localObject).putString("desc", paramDetail.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putString("detail_url", paramString);
    paramString = new ArrayList(1);
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_b_of_type_JavaLangString);
      localStringBuilder.append(paramDetail.jdField_a_of_type_JavaLangString);
      paramString.add(localStringBuilder.toString());
    }
    else if (paramInt != 2) {}
    try
    {
      long l = Long.parseLong(paramDetail.jdField_a_of_type_JavaLangString);
      paramInt = (int)(l % 256L);
      paramString.add(String.format(jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
    }
    catch (Exception paramBaseActivity)
    {
      label214:
      break label214;
    }
    QLog.d("forward", 2, "ShareActionSheet shareToQzone Long.parseLong(accountDetail.uin) error");
    return;
    ((Bundle)localObject).putStringArrayList("image_url", paramString);
    ((Bundle)localObject).putLong("req_share_id", 0L);
    ((Bundle)localObject).putString("pubUin", paramDetail.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putBoolean("from_card", true);
    QZoneShareManager.jumpToQzoneShare(paramBaseActivity.app, paramBaseActivity, (Bundle)localObject, null);
  }
  
  public static void a(BaseActivity paramBaseActivity, ShareActionSheet.Detail paramDetail, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShareActionSheet shareToWX | account_uin=");
      if (paramDetail == null) {
        str = "null";
      } else {
        str = paramDetail.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append(str);
      QLog.d("forward", 2, localStringBuilder.toString());
    }
    if (paramDetail == null) {
      return;
    }
    if (!WXShareHelper.a().a())
    {
      QRUtils.a(0, 2131720478);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ShareActionSheet shareToWXfail: WX is not installed");
      }
      return;
    }
    if (!WXShareHelper.a().b())
    {
      QRUtils.a(0, 2131720479);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ShareActionSheet shareToWX fail: WX version too low");
      }
      return;
    }
    String str = String.valueOf(System.currentTimeMillis());
    WXShareHelper.a().a(new ShareActionSheet.1(str));
    paramBaseActivity = paramBaseActivity.app.getFaceBitmap(paramDetail.jdField_a_of_type_JavaLangString, (byte)1, true);
    if (paramInt2 == 9) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    WXShareHelper.a().a(str, paramDetail.jdField_b_of_type_JavaLangString, paramBaseActivity, paramDetail.jdField_c_of_type_JavaLangString, paramString, paramInt1);
  }
  
  public static void b(Activity paramActivity, ShareActionSheet.Detail paramDetail, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShareActionSheet shareToFriend | account_uin=");
      String str;
      if (paramDetail == null) {
        str = "null";
      } else {
        str = paramDetail.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append(str);
      QLog.d("forward", 2, localStringBuilder.toString());
    }
    if (paramDetail == null) {
      return;
    }
    paramDetail = a(paramActivity, paramDetail, paramInt, paramString);
    if (paramDetail == null) {
      return;
    }
    paramString = StructMsgFactory.a(paramDetail.getExtras());
    if (paramString != null)
    {
      paramDetail.putExtra("stuctmsg_bytes", paramString.getBytes());
      paramDetail.putExtra("from_card", true);
      paramActivity.startActivity(paramDetail);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719029));
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionSheet.show exception=");
        localStringBuilder.append(localException);
        QLog.d("ShareActionSheet", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696399);
    localActionSheetItem.icon = 2130839067;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696413);
    localActionSheetItem.icon = 2130839068;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696420);
    localActionSheetItem.icon = 2130839071;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696402);
    localActionSheetItem.icon = 2130839065;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a.action;
      String str1 = null;
      localObject1 = null;
      Object localObject2;
      Object localObject3;
      if (i != 2)
      {
        if (i != 3)
        {
          if ((i != 9) && (i != 10)) {
            if (i == 19) {
              a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail, this.jdField_a_of_type_Int, this.e);
            }
          }
          for (;;)
          {
            break;
            a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail, this.jdField_a_of_type_Int, this.e, i);
            localObject2 = (IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class);
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            String str2 = this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_JavaLangString;
            if (i == 9) {
              localObject1 = "share_wechat";
            } else {
              localObject1 = "share_circle";
            }
            ((IPublicAccountHandler)localObject2).reportClickPublicAccountEvent((AppInterface)localObject3, str2, "Grp_tribe", "interest_data", (String)localObject1);
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_JavaLangString, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
            localObject1 = str1;
            if (9 == i) {
              localObject1 = "03";
            }
            if (10 == i) {
              localObject1 = "04";
            }
          }
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail, this.jdField_a_of_type_Int, this.e);
        ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "share_qzone");
        localObject1 = "02";
      }
      else
      {
        b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail, this.jdField_a_of_type_Int, this.e);
        ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "share_qq");
        localObject1 = "01";
      }
      if ((this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_c_of_type_Int == ShareActionSheet.Detail.jdField_b_of_type_Int) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject3 = this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.jdField_a_of_type_Boolean) {
          str1 = "02";
        } else {
          str1 = "01";
        }
        ReportController.b((AppRuntime)localObject2, "dc01160", "Pb_account_lifeservice", (String)localObject3, "0X8007CA6", "0X8007CA6", 0, 0, str1, (String)localObject1, String.valueOf(this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet$Detail.d), "");
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopbar.ShareActionSheet
 * JD-Core Version:    0.7.0.1
 */