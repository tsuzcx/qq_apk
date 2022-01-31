package com.tencent.biz.pubaccount.AccountDetail.handler;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.MsgAttr;
import com.tencent.biz.pubaccount.AccountDetail.bean.VideoAttr;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ksi;
import ksj;

public class AccountDetailBaseItemClickHandler
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private final String jdField_a_of_type_JavaLangString = AccountDetailBaseItemClickHandler.class.getSimpleName();
  
  public AccountDetailBaseItemClickHandler(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
  }
  
  private Bundle a(DynamicInfo paramDynamicInfo)
  {
    boolean bool = true;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle1.putString("VIDEO_H5_URL", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_JavaLangString);
    localBundle1.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.c, true));
    localBundle1.putString("VIDEO_TIME", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_Int));
    localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.d));
    localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_Int));
    localBundle1.putString("VIDEO_VID", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    localBundle1.putString("VIDEO_COVER", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_JavaLangString);
    localBundle1.putString("VIDEO_ARTICLE_ID", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_b_of_type_JavaLangString));
    if ((paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_Int == 2) || (paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_Int == 3))
    {
      localBundle1.putString("VIDEO_THIRD_ICON", ShareActionSheet.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle1.putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_JavaLangString);
      bool = false;
    }
    localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_Int);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("VINFO", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    localBundle2.putString("TINFO", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    localBundle2.putInt("PREVIEW_VIDEO_TIME", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_Int);
    localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.d);
    localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_Int);
    localBundle2.putInt("FULL_VIDEO_TIME", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_Int);
    localBundle2.putString("ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    localBundle2.putString("ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localBundle2.putInt("TYPE", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_Int);
    localBundle2.putString("ARTICLE_ID", String.valueOf(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.a));
    localBundle2.putInt("layout_item", 5);
    localBundle2.putBoolean("video_url_load", false);
    localBundle2.putString("image_url_remote", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_JavaLangString);
    localBundle2.putString("detail_url", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_JavaLangString);
    localBundle2.putString("video_url", paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    localBundle2.putString("title", paramDynamicInfo.jdField_a_of_type_JavaLangString);
    localBundle2.putString("req_create_time", ReadInJoyTimeUtils.b(paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.c));
    localBundle2.putString("brief_key", paramDynamicInfo.jdField_a_of_type_JavaLangString);
    localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a(localBundle2)).getBytes());
    localBundle1.putString("VIDEO_TITLE", paramDynamicInfo.jdField_a_of_type_JavaLangString);
    return localBundle1;
  }
  
  private ShareActionSheet.Detail a()
  {
    ShareActionSheet.Detail localDetail = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localDetail = new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localDetail;
  }
  
  private String a()
  {
    int i = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "http://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new ShareActionSheet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, a(), 1, a()).a();
  }
  
  private void b(String paramString)
  {
    Dialog localDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131624516);
    localDialog.setContentView(2130970317);
    ((TextView)localDialog.findViewById(2131369996)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131369997);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131369998);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131369999);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131433029);
    localTextView3.setText(2131435108);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new ksi(this, localDialog));
    localTextView3.setOnClickListener(new ksj(this, paramString));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(DynamicInfo paramDynamicInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131428992, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open full play activity, articleID : " + paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.a + ",vid : " + paramDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString);
    }
    paramDynamicInfo = a(paramDynamicInfo);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent(localActivity, VideoFeedsPlayActivity.class);
    localIntent.putExtras(paramDynamicInfo);
    localActivity.overridePendingTransition(2131034165, 2131034167);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->type:" + paramPaConfigInfo.jdField_a_of_type_Int + ", event_id:" + paramPaConfigInfo.jdField_c_of_type_Int);
    }
    if (paramPaConfigInfo.jdField_a_of_type_Int == 1) {
      a(paramPaConfigInfo.jdField_c_of_type_JavaLangString);
    }
    label66:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label66;
                break label66;
                break label66;
                break label66;
                do
                {
                  return;
                } while (paramPaConfigInfo.jdField_a_of_type_Int != 3);
                if (paramPaConfigInfo.jdField_c_of_type_Int != 7) {
                  break;
                }
              } while ((TextUtils.isEmpty(paramPaConfigInfo.g)) || (TextUtils.isEmpty(paramPaConfigInfo.f)));
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMapActivity.class);
              ((Intent)localObject).putExtra("lat", paramPaConfigInfo.g);
              ((Intent)localObject).putExtra("lon", paramPaConfigInfo.f);
              if (!TextUtils.isEmpty(paramPaConfigInfo.jdField_b_of_type_JavaLangString)) {
                ((Intent)localObject).putExtra("loc", paramPaConfigInfo.jdField_b_of_type_JavaLangString);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return;
              if (paramPaConfigInfo.jdField_c_of_type_Int != 8) {
                break;
              }
              paramPaConfigInfo = paramPaConfigInfo.h;
            } while (TextUtils.isEmpty(paramPaConfigInfo));
            paramPaConfigInfo = paramPaConfigInfo.trim();
          } while (!Pattern.compile("[\\d-]+?").matcher(paramPaConfigInfo).matches());
          b(paramPaConfigInfo);
          return;
          if (paramPaConfigInfo.jdField_c_of_type_Int == 11)
          {
            paramPaConfigInfo = new Intent(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            paramPaConfigInfo.putExtra("from", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
            paramPaConfigInfo.putExtra("finishAfterSucc", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramPaConfigInfo);
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 20)
          {
            a();
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 2)
          {
            ShareActionSheet.b((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 17)
          {
            ShareActionSheet.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a());
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 19)
          {
            ShareActionSheet.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 9);
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 18)
          {
            ShareActionSheet.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, a(), 10);
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 22)
          {
            a(paramPaConfigInfo.jdField_c_of_type_JavaLangString);
            return;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int != 23) {
            break;
          }
        } while (TextUtils.isEmpty(paramPaConfigInfo.jdField_b_of_type_JavaLangString));
        Object localObject = new DynamicInfo();
        ((DynamicInfo)localObject).a(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
        a((DynamicInfo)localObject);
        return;
        if ((paramPaConfigInfo.jdField_c_of_type_Int != 1) && (paramPaConfigInfo.jdField_c_of_type_Int != 3) && (paramPaConfigInfo.jdField_c_of_type_Int != 9) && (paramPaConfigInfo.jdField_c_of_type_Int != 10) && (paramPaConfigInfo.jdField_c_of_type_Int != 12) && (paramPaConfigInfo.jdField_c_of_type_Int != 13) && (paramPaConfigInfo.jdField_c_of_type_Int != 14) && (paramPaConfigInfo.jdField_c_of_type_Int != 15) && (paramPaConfigInfo.jdField_c_of_type_Int != 16) && (paramPaConfigInfo.jdField_c_of_type_Int != 21)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->event forbidden or not supported!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleItemClickEvent->event unhandled!");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin)));
    paramString = paramString.replace("${puin}", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "jumpWebView->url:" + paramString);
    }
    localIntent.putExtra("puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.handler.AccountDetailBaseItemClickHandler
 * JD-Core Version:    0.7.0.1
 */