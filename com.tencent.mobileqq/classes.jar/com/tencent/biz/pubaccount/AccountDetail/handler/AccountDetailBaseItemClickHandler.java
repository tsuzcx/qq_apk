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
  private final String a = AccountDetailBaseItemClickHandler.class.getSimpleName();
  private QQAppInterface b;
  private Context c;
  private PublicAccountDetailImpl d;
  
  public AccountDetailBaseItemClickHandler(QQAppInterface paramQQAppInterface, Context paramContext, PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.d = paramPublicAccountDetailImpl;
  }
  
  private void a()
  {
    if (this.d == null) {
      return;
    }
    new ShareActionSheet(this.b, (BaseActivity)this.c, b(), 1, c()).a();
  }
  
  private Bundle b(DynamicInfo paramDynamicInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.d.uin);
    localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.d.name);
    localBundle.putString("VIDEO_H5_URL", paramDynamicInfo.f.c);
    Object localObject = (IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class);
    long l = paramDynamicInfo.d.f;
    boolean bool = true;
    localBundle.putString("VIDEO_CREATE_TIME", ((IReadInJoyTimeUtils)localObject).getRelativeDisplayForTime(l, true));
    localBundle.putString("VIDEO_TIME", String.valueOf(paramDynamicInfo.f.d));
    localBundle.putString("VIDEO_WIDTH", String.valueOf(paramDynamicInfo.f.f));
    localBundle.putString("VIDEO_HEIGHT", String.valueOf(paramDynamicInfo.f.e));
    localBundle.putString("VIDEO_VID", paramDynamicInfo.f.g);
    localBundle.putString("VIDEO_COVER", paramDynamicInfo.f.b);
    localBundle.putString("VIDEO_ARTICLE_ID", String.valueOf(paramDynamicInfo.d.h));
    if ((paramDynamicInfo.f.a == 2) || (paramDynamicInfo.f.a == 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ShareActionSheet.b);
      ((StringBuilder)localObject).append(this.d.uin);
      localBundle.putString("VIDEO_THIRD_ICON", ((StringBuilder)localObject).toString());
      localBundle.putString("VIDEO_THIRD_NAME", this.d.name);
      localBundle.putString("VIDEO_THIRD_ACTION", paramDynamicInfo.f.c);
      bool = false;
    }
    localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramDynamicInfo.f.a);
    localObject = new Bundle();
    ((Bundle)localObject).putString("VINFO", paramDynamicInfo.f.g);
    ((Bundle)localObject).putString("TINFO", paramDynamicInfo.f.g);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_TIME", paramDynamicInfo.f.d);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_WIDTH", paramDynamicInfo.f.f);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_HEIGHT", paramDynamicInfo.f.e);
    ((Bundle)localObject).putInt("FULL_VIDEO_TIME", paramDynamicInfo.f.d);
    ((Bundle)localObject).putString("ACCOUNT_UIN", this.d.uin);
    ((Bundle)localObject).putString("source_puin", this.d.uin);
    ((Bundle)localObject).putString("ACCOUNT_NAME", this.d.name);
    ((Bundle)localObject).putInt("TYPE", paramDynamicInfo.f.a);
    ((Bundle)localObject).putString("ARTICLE_ID", String.valueOf(paramDynamicInfo.d.a));
    ((Bundle)localObject).putInt("layout_item", 5);
    ((Bundle)localObject).putBoolean("video_url_load", false);
    ((Bundle)localObject).putString("image_url_remote", paramDynamicInfo.f.b);
    ((Bundle)localObject).putString("detail_url", paramDynamicInfo.f.c);
    ((Bundle)localObject).putString("video_url", paramDynamicInfo.f.g);
    ((Bundle)localObject).putString("title", paramDynamicInfo.a);
    ((Bundle)localObject).putString("req_create_time", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getDateTimeString(paramDynamicInfo.d.f));
    ((Bundle)localObject).putString("brief_key", paramDynamicInfo.a);
    ((Bundle)localObject).putInt("req_type", 140);
    localBundle.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a((Bundle)localObject)).getBytes());
    localBundle.putString("VIDEO_TITLE", paramDynamicInfo.a);
    return localBundle;
  }
  
  private ShareActionSheet.Detail b()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.d;
    if (localPublicAccountDetailImpl != null) {
      return new ShareActionSheet.Detail(localPublicAccountDetailImpl.uin, this.d.name, this.d.summary);
    }
    return null;
  }
  
  private void b(String paramString)
  {
    Dialog localDialog = new Dialog(this.c, 2131953338);
    localDialog.setContentView(2131627374);
    ((TextView)localDialog.findViewById(2131431915)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131431902);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131431900);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131431907);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131887648);
    localTextView3.setText(2131888562);
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
  
  private String c()
  {
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.d.accountFlag);
    if ((i != -2) && (i != -5))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=");
      localStringBuilder.append(this.d.uin);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://share.mp.qq.com/cgi/share.php?uin=");
    localStringBuilder.append(this.d.uin);
    localStringBuilder.append("&account_flag=");
    localStringBuilder.append(this.d.accountFlag);
    localStringBuilder.append("&jumptype=1&card_type=public_account");
    return localStringBuilder.toString();
  }
  
  public void a(DynamicInfo paramDynamicInfo)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((QQAppInterface)localObject1).isVideoChatting()))
    {
      QQToast.makeText(this.c, 2131893650, 1).show(this.c.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("open full play activity, articleID : ");
      ((StringBuilder)localObject2).append(paramDynamicInfo.d.a);
      ((StringBuilder)localObject2).append(",vid : ");
      ((StringBuilder)localObject2).append(paramDynamicInfo.f.g);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    paramDynamicInfo = b(paramDynamicInfo);
    localObject1 = (Activity)this.c;
    Object localObject2 = ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).getVideoFeedsPlayActivityIntent((Context)localObject1);
    ((Intent)localObject2).addFlags(536870912);
    ((Intent)localObject2).putExtras(paramDynamicInfo);
    ((Activity)localObject1).overridePendingTransition(2130772090, 2130772092);
    this.c.startActivity((Intent)localObject2);
  }
  
  public void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleItemClickEvent->type:");
      localStringBuilder.append(paramPaConfigInfo.a);
      localStringBuilder.append(", event_id:");
      localStringBuilder.append(paramPaConfigInfo.e);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramPaConfigInfo.a == 1)
    {
      a(paramPaConfigInfo.h);
      return;
    }
    if (paramPaConfigInfo.a == 3)
    {
      if (paramPaConfigInfo.e == 7)
      {
        if (!TextUtils.isEmpty(paramPaConfigInfo.m))
        {
          if (TextUtils.isEmpty(paramPaConfigInfo.l)) {
            return;
          }
          localObject = new Intent(this.c, QQMapActivity.class);
          ((Intent)localObject).putExtra("lat", paramPaConfigInfo.m);
          ((Intent)localObject).putExtra("lon", paramPaConfigInfo.l);
          if (!TextUtils.isEmpty(paramPaConfigInfo.c)) {
            ((Intent)localObject).putExtra("loc", paramPaConfigInfo.c);
          }
          this.c.startActivity((Intent)localObject);
          return;
        }
        return;
      }
      if (paramPaConfigInfo.e == 8)
      {
        paramPaConfigInfo = paramPaConfigInfo.n;
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
      if (paramPaConfigInfo.e == 11)
      {
        paramPaConfigInfo = new Intent();
        paramPaConfigInfo.putExtra("from", this.c.getClass().getName());
        RouteUtils.a(this.c, paramPaConfigInfo, "/qrscan/scanner");
        return;
      }
      if (paramPaConfigInfo.e == 20)
      {
        a();
        return;
      }
      if (paramPaConfigInfo.e == 2)
      {
        ShareActionSheet.b((BaseActivity)this.c, new ShareActionSheet.Detail(this.d.uin, this.d.name, this.d.summary), 1, c());
        return;
      }
      if (paramPaConfigInfo.e == 17)
      {
        ShareActionSheet.a((BaseActivity)this.c, new ShareActionSheet.Detail(this.d.uin, this.d.name, this.d.summary), 1, c());
        return;
      }
      if (paramPaConfigInfo.e == 19)
      {
        ShareActionSheet.a((BaseActivity)this.c, new ShareActionSheet.Detail(this.d.uin, this.d.name, this.d.summary), 1, c(), 9);
        return;
      }
      if (paramPaConfigInfo.e == 18)
      {
        ShareActionSheet.a((BaseActivity)this.c, new ShareActionSheet.Detail(this.d.uin, this.d.name, this.d.summary), 1, c(), 10);
        return;
      }
      if (paramPaConfigInfo.e == 22)
      {
        a(paramPaConfigInfo.h);
        return;
      }
      if (paramPaConfigInfo.e == 23)
      {
        if (!TextUtils.isEmpty(paramPaConfigInfo.c))
        {
          localObject = new DynamicInfo();
          ((DynamicInfo)localObject).a(paramPaConfigInfo.c);
          a((DynamicInfo)localObject);
        }
      }
      else if ((paramPaConfigInfo.e != 1) && (paramPaConfigInfo.e != 3) && (paramPaConfigInfo.e != 9) && (paramPaConfigInfo.e != 10) && (paramPaConfigInfo.e != 12) && (paramPaConfigInfo.e != 13) && (paramPaConfigInfo.e != 14) && (paramPaConfigInfo.e != 15) && (paramPaConfigInfo.e != 16) && (paramPaConfigInfo.e != 21))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "handleItemClickEvent->event unhandled!");
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "handleItemClickEvent->event forbidden or not supported!");
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(this.c, PublicAccountBrowserImpl.class);
    Object localObject = this.b;
    if ((localObject != null) && (this.d != null) && (!TextUtils.isEmpty(((QQAppInterface)localObject).getAccount())))
    {
      if (TextUtils.isEmpty(this.d.uin)) {
        return;
      }
      paramString = paramString.replace("${puin}", this.d.uin).replace("${uin}", this.b.getAccount());
      localIntent.putExtra("uin", this.b.getCurrentAccountUin());
      localIntent.putExtra("url", paramString);
      if (QLog.isColorLevel())
      {
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jumpWebView->url:");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      localIntent.putExtra("puin", this.d.uin);
      localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.d.uin));
      paramString = this.d.name;
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("source_name", paramString);
      }
      this.c.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler
 * JD-Core Version:    0.7.0.1
 */