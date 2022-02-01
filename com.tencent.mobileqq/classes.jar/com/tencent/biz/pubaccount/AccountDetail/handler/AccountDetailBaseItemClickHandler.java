package com.tencent.biz.pubaccount.accountdetail.handler;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.bean.MsgAttr;
import com.tencent.biz.pubaccount.accountdetail.bean.VideoAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountDetailBaseItemClickHandler
{
  private Context jdField_a_of_type_AndroidContentContext;
  private PublicAccountDetailImpl jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = AccountDetailBaseItemClickHandler.class.getSimpleName();
  
  public AccountDetailBaseItemClickHandler(QQAppInterface paramQQAppInterface, Context paramContext, PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl = paramPublicAccountDetailImpl;
  }
  
  private Bundle a(DynamicInfo paramDynamicInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
    localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name);
    localBundle.putString("VIDEO_H5_URL", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_b_of_type_JavaLangString);
    Object localObject = (IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class);
    long l = paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.c;
    boolean bool = true;
    localBundle.putString("VIDEO_CREATE_TIME", ((IReadInJoyTimeUtils)localObject).getRelativeDisplayForTime(l, true));
    localBundle.putString("VIDEO_TIME", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_b_of_type_Int));
    localBundle.putString("VIDEO_WIDTH", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.d));
    localBundle.putString("VIDEO_HEIGHT", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_c_of_type_Int));
    localBundle.putString("VIDEO_VID", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    localBundle.putString("VIDEO_COVER", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_JavaLangString);
    localBundle.putString("VIDEO_ARTICLE_ID", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_b_of_type_JavaLangString));
    if ((paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_Int == 2) || (paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_Int == 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ShareActionSheet.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
      localBundle.putString("VIDEO_THIRD_ICON", ((StringBuilder)localObject).toString());
      localBundle.putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name);
      localBundle.putString("VIDEO_THIRD_ACTION", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_b_of_type_JavaLangString);
      bool = false;
    }
    localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_Int);
    localObject = new Bundle();
    ((Bundle)localObject).putString("VINFO", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putString("TINFO", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_TIME", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_b_of_type_Int);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_WIDTH", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.d);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_HEIGHT", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_c_of_type_Int);
    ((Bundle)localObject).putInt("FULL_VIDEO_TIME", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_b_of_type_Int);
    ((Bundle)localObject).putString("ACCOUNT_UIN", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
    ((Bundle)localObject).putString("source_puin", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
    ((Bundle)localObject).putString("ACCOUNT_NAME", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name);
    ((Bundle)localObject).putInt("TYPE", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_Int);
    ((Bundle)localObject).putString("ARTICLE_ID", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.a));
    ((Bundle)localObject).putInt("layout_item", 5);
    ((Bundle)localObject).putBoolean("video_url_load", false);
    ((Bundle)localObject).putString("image_url_remote", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putString("detail_url", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_b_of_type_JavaLangString);
    ((Bundle)localObject).putString("video_url", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putString("title", paramDynamicInfo.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putString("req_create_time", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getDateTimeString(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.c));
    ((Bundle)localObject).putString("brief_key", paramDynamicInfo.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putInt("req_type", 140);
    localBundle.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a((Bundle)localObject)).getBytes());
    localBundle.putString("VIDEO_TITLE", paramDynamicInfo.jdField_a_of_type_JavaLangString);
    return localBundle;
  }
  
  private ShareActionSheet.Detail a()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if (localPublicAccountDetailImpl != null) {
      return new ShareActionSheet.Detail(localPublicAccountDetailImpl.uin, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary);
    }
    return null;
  }
  
  private String a()
  {
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.accountFlag);
    if ((i != -2) && (i != -5))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://share.mp.qq.com/cgi/share.php?uin=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
    localStringBuilder.append("&account_flag=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.accountFlag);
    localStringBuilder.append("&jumptype=1&card_type=public_account");
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl == null) {
      return;
    }
    new ShareActionSheet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, a(), 1, a()).a();
  }
  
  private void b(String paramString)
  {
    Dialog localDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131756189);
    localDialog.setContentView(2131561033);
    ((TextView)localDialog.findViewById(2131365681)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365673);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690728);
    localTextView3.setText(2131691600);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new AccountDetailBaseItemClickHandler.1(this, localDialog));
    localTextView3.setOnClickListener(new AccountDetailBaseItemClickHandler.2(this, paramString));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(DynamicInfo paramDynamicInfo)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject1 != null) && (((QQAppInterface)localObject1).isVideoChatting()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695889, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("open full play activity, articleID : ");
      ((StringBuilder)localObject2).append(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.a);
      ((StringBuilder)localObject2).append(",vid : ");
      ((StringBuilder)localObject2).append(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    paramDynamicInfo = a(paramDynamicInfo);
    localObject1 = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Object localObject2 = ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).getVideoFeedsPlayActivityIntent((Context)localObject1);
    ((Intent)localObject2).addFlags(536870912);
    ((Intent)localObject2).putExtras(paramDynamicInfo);
    ((Activity)localObject1).overridePendingTransition(2130772065, 2130772067);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
  }
  
  public void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleItemClickEvent->type:");
      localStringBuilder.append(paramPaConfigInfo.jdField_a_of_type_Int);
      localStringBuilder.append(", event_id:");
      localStringBuilder.append(paramPaConfigInfo.jdField_c_of_type_Int);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramPaConfigInfo.jdField_a_of_type_Int == 1)
    {
      a(paramPaConfigInfo.jdField_c_of_type_JavaLangString);
      return;
    }
    if (paramPaConfigInfo.jdField_a_of_type_Int == 3)
    {
      if (paramPaConfigInfo.jdField_c_of_type_Int == 7)
      {
        if (!TextUtils.isEmpty(paramPaConfigInfo.g))
        {
          if (TextUtils.isEmpty(paramPaConfigInfo.f)) {
            return;
          }
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMapActivity.class);
          ((Intent)localObject).putExtra("lat", paramPaConfigInfo.g);
          ((Intent)localObject).putExtra("lon", paramPaConfigInfo.f);
          if (!TextUtils.isEmpty(paramPaConfigInfo.jdField_b_of_type_JavaLangString)) {
            ((Intent)localObject).putExtra("loc", paramPaConfigInfo.jdField_b_of_type_JavaLangString);
          }
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          return;
        }
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 8)
      {
        paramPaConfigInfo = paramPaConfigInfo.h;
        if (!TextUtils.isEmpty(paramPaConfigInfo))
        {
          paramPaConfigInfo = paramPaConfigInfo.trim();
          if (!Pattern.compile("[\\d-]+?").matcher(paramPaConfigInfo).matches()) {
            return;
          }
          b(paramPaConfigInfo);
          return;
        }
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 11)
      {
        paramPaConfigInfo = new Intent();
        paramPaConfigInfo.putExtra("from", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
        RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, paramPaConfigInfo, "/qrscan/scanner");
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 20)
      {
        a();
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 2)
      {
        ShareActionSheet.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary), 1, a());
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 17)
      {
        ShareActionSheet.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary), 1, a());
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 19)
      {
        ShareActionSheet.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary), 1, a(), 9);
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 18)
      {
        ShareActionSheet.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary), 1, a(), 10);
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 22)
      {
        a(paramPaConfigInfo.jdField_c_of_type_JavaLangString);
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 23)
      {
        if (!TextUtils.isEmpty(paramPaConfigInfo.jdField_b_of_type_JavaLangString))
        {
          localObject = new DynamicInfo();
          ((DynamicInfo)localObject).a(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
          a((DynamicInfo)localObject);
        }
      }
      else if ((paramPaConfigInfo.jdField_c_of_type_Int != 1) && (paramPaConfigInfo.jdField_c_of_type_Int != 3) && (paramPaConfigInfo.jdField_c_of_type_Int != 9) && (paramPaConfigInfo.jdField_c_of_type_Int != 10) && (paramPaConfigInfo.jdField_c_of_type_Int != 12) && (paramPaConfigInfo.jdField_c_of_type_Int != 13) && (paramPaConfigInfo.jdField_c_of_type_Int != 14) && (paramPaConfigInfo.jdField_c_of_type_Int != 15) && (paramPaConfigInfo.jdField_c_of_type_Int != 16) && (paramPaConfigInfo.jdField_c_of_type_Int != 21))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->event unhandled!");
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->event forbidden or not supported!");
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowserImpl.class);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl != null) && (!TextUtils.isEmpty(((QQAppInterface)localObject).getAccount())))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin)) {
        return;
      }
      paramString = paramString.replace("${puin}", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("url", paramString);
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jumpWebView->url:");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      localIntent.putExtra("puin", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
      localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin));
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name;
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("source_name", paramString);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler
 * JD-Core Version:    0.7.0.1
 */