import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.common.NoticeParam;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;

public class bcdh
  extends Handler
{
  protected Notification a;
  protected NoticeParam a;
  
  public bcdh()
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  public bcdh(Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  protected String a(int paramInt)
  {
    return bbtm.a().a().getString(paramInt);
  }
  
  protected String a(int paramInt, Object... paramVarArgs)
  {
    return bbtm.a().a().getString(paramInt, paramVarArgs);
  }
  
  protected void a(Notification paramNotification, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT > 10)
      {
        paramNotification.contentView.setOnClickPendingIntent(2131305281, paramPendingIntent);
        return;
      }
      paramNotification.contentIntent = paramPendingIntent;
      return;
    }
    paramNotification.contentIntent = paramPendingIntent;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject1 = paramMessage.getData();
    Object localObject2 = ((Bundle)localObject1).getString(bcgl.jdField_a_of_type_JavaLangString);
    bcds.a("NoticeHintHandler", "+++++what:" + paramMessage.what + "+++++" + localObject1);
    localObject2 = bccu.a().a((String)localObject2);
    if (localObject2 != null)
    {
      if (((DownloadInfo)localObject2).i == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
        bcds.c("NoticeHintHandler", "notification isShowNotification=" + ((DownloadInfo)localObject2).i);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString = ((DownloadInfo)localObject2).c;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_JavaLangString = ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d = ((DownloadInfo)localObject2).e;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString = ((DownloadInfo)localObject2).g;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_AndroidContentIntent = ((DownloadInfo)localObject2).jdField_a_of_type_AndroidContentIntent;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_Long = ((DownloadInfo)localObject2).jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.g = ((DownloadInfo)localObject2).h;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.e = ((DownloadInfo)localObject2).d;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppNotification == null)
        {
          this.jdField_a_of_type_AndroidAppNotification = bcia.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
          if (this.jdField_a_of_type_AndroidAppNotification == null) {
            break;
          }
        }
        switch (paramMessage.what)
        {
        default: 
          int i = bcia.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          long l = bcia.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidAppNotification.when = l;
          bcia.a().a(i, this.jdField_a_of_type_AndroidAppNotification);
          bcds.c("NoticeHintHandler", "notify key=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString + " type=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int + "appid=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          return;
          localObject1 = new RemoteViews(bbtm.a().a().getPackageName(), 2131493898);
          bcia.a().a((RemoteViews)localObject1);
          ((RemoteViews)localObject1).setInt(2131305281, "setBackgroundColor", -1);
          ((RemoteViews)localObject1).setInt(2131305283, "setTextColor", -16777216);
          ((RemoteViews)localObject1).setInt(2131305277, "setTextColor", -12303292);
          ((RemoteViews)localObject1).setInt(2131305273, "setTextColor", -12303292);
          this.jdField_a_of_type_AndroidAppNotification.contentView = ((RemoteViews)localObject1);
          continue;
        }
      }
      catch (Exception localException)
      {
        bcds.c("NoticeHintHandler", "init Notification>>>", localException);
        continue;
        bcds.b("NoticeHintHandler", ">>downloading:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        bcds.c("NoticeHintHandler", "size = " + ((DownloadInfo)localObject2).jdField_f_of_type_Int + " content = ");
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131629066, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305273, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305269, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305277, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setProgressBar(2131305268, 100, ((DownloadInfo)localObject2).jdField_f_of_type_Int, false);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305277, ((DownloadInfo)localObject2).jdField_f_of_type_Int * 100 / 100 + "%");
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131305274, 2130843460);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305283, bcdy.a(a(2131629068, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString }), 18, true));
        a(this.jdField_a_of_type_AndroidAppNotification, bcie.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        if (!TextUtils.isEmpty(""))
        {
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305273, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305273, Html.fromHtml(""));
          this.jdField_a_of_type_AndroidAppNotification.flags = 32;
          paramMessage = this.jdField_a_of_type_AndroidAppNotification;
          paramMessage.flags |= 0x2;
          continue;
        }
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305273, 8);
        continue;
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131629066, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305273, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305269, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305277, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305283, bcdy.a(a(2131629068, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString }), 18, true));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305273, a(2131626353));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131305274, 2130843460);
        a(this.jdField_a_of_type_AndroidAppNotification, bcie.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        this.jdField_a_of_type_AndroidAppNotification.flags = 32;
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags |= 0x2;
        bcia.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
        continue;
        bcds.b("NoticeHintHandler", ">>complete:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int = 3;
        this.jdField_a_of_type_AndroidAppNotification = bcia.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
      }
      if (this.jdField_a_of_type_AndroidAppNotification == null) {
        break;
      }
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131629064);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305273, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305269, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305277, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305273, a(2131629049));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305283, bcdy.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      a(this.jdField_a_of_type_AndroidAppNotification, bcie.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), false);
      paramMessage = bcdq.a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      if (paramMessage != null) {
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewBitmap(2131305274, paramMessage);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppNotification.flags = 16;
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags &= 0xFFFFFFFD;
        bcia.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
        break;
        bcds.b("NoticeHintHandler", ">>download icon fail,so we use default notification icon");
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131305274, 2130843460);
      }
      bcds.b("NoticeHintHandler", ">>pause:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131629051);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305273, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305269, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305277, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131305274, 2130843463);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305283, bcdy.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305273, a(2131629051));
      a(this.jdField_a_of_type_AndroidAppNotification, bcie.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
      this.jdField_a_of_type_AndroidAppNotification.flags = 16;
      paramMessage = this.jdField_a_of_type_AndroidAppNotification;
      paramMessage.flags &= 0xFFFFFFFD;
      bcia.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
      continue;
      bcds.b("NoticeHintHandler", ">>error:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305273, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305269, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131305277, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131305274, 2130843461);
      String str = (String)paramMessage.obj;
      paramMessage = str;
      if (TextUtils.isEmpty(str)) {
        paramMessage = a(2131626345);
      }
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131629065, new Object[] { paramMessage });
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305273, a(2131629050, new Object[] { paramMessage }));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131305283, bcdy.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      a(this.jdField_a_of_type_AndroidAppNotification, bcie.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
      this.jdField_a_of_type_AndroidAppNotification.flags = 16;
      paramMessage = this.jdField_a_of_type_AndroidAppNotification;
      paramMessage.flags &= 0xFFFFFFFD;
      bcia.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
    }
    bcia.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcdh
 * JD-Core Version:    0.7.0.1
 */