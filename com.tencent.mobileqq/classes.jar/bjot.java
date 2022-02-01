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

public class bjot
  extends Handler
{
  protected Notification a;
  protected NoticeParam a;
  
  public bjot()
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  public bjot(Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  protected String a(int paramInt)
  {
    return bizw.a().a().getString(paramInt);
  }
  
  protected String a(int paramInt, Object... paramVarArgs)
  {
    return bizw.a().a().getString(paramInt, paramVarArgs);
  }
  
  protected void a(Notification paramNotification, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT > 10)
      {
        paramNotification.contentView.setOnClickPendingIntent(2131372117, paramPendingIntent);
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
    Object localObject2 = ((Bundle)localObject1).getString(bjmy.jdField_b_of_type_JavaLangString);
    bjko.a("NoticeUpdateHandler", "+++++what:" + paramMessage.what + "+++++" + localObject1);
    localObject2 = bjna.a().a((String)localObject2);
    if (localObject2 != null)
    {
      if (((DownloadInfo)localObject2).i == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
        bjko.c("NoticeUpdateHandler", "notification isShowNotification=" + ((DownloadInfo)localObject2).i);
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
          this.jdField_a_of_type_AndroidAppNotification = bjom.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
          if (this.jdField_a_of_type_AndroidAppNotification == null) {
            break;
          }
        }
        switch (paramMessage.what)
        {
        default: 
          int i = bjom.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          long l = bjom.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidAppNotification.when = l;
          bjom.a().a(i, this.jdField_a_of_type_AndroidAppNotification);
          bjko.c("NoticeUpdateHandler", "notify key=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString + " type=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int + "appid=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          return;
          localObject1 = new RemoteViews(bizw.a().a().getPackageName(), 2131559696);
          bjom.a().a((RemoteViews)localObject1);
          ((RemoteViews)localObject1).setInt(2131372117, "setBackgroundColor", -1);
          ((RemoteViews)localObject1).setInt(2131372119, "setTextColor", -16777216);
          ((RemoteViews)localObject1).setInt(2131372113, "setTextColor", -12303292);
          ((RemoteViews)localObject1).setInt(2131372107, "setTextColor", -12303292);
          this.jdField_a_of_type_AndroidAppNotification.contentView = ((RemoteViews)localObject1);
          continue;
        }
      }
      catch (Exception localException)
      {
        bjko.c("NoticeUpdateHandler", "init Notification>>>", localException);
        continue;
        bjko.b("NoticeUpdateHandler", ">>downloading:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        bjko.c("NoticeUpdateHandler", "size = " + ((DownloadInfo)localObject2).jdField_f_of_type_Int + " content = ");
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694349, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372107, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372102, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372113, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setProgressBar(2131372101, 100, ((DownloadInfo)localObject2).jdField_f_of_type_Int, false);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372113, ((DownloadInfo)localObject2).jdField_f_of_type_Int * 100 / 100 + "%");
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131372108, 2130844336);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372119, bjkr.a(a(2131694352, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString }), 18, true));
        a(this.jdField_a_of_type_AndroidAppNotification, bjoq.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        if (!TextUtils.isEmpty(""))
        {
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372107, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372107, Html.fromHtml(""));
          this.jdField_a_of_type_AndroidAppNotification.flags = 32;
          paramMessage = this.jdField_a_of_type_AndroidAppNotification;
          paramMessage.flags |= 0x2;
          continue;
        }
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372107, 8);
        continue;
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694349, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372107, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372102, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372113, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372119, bjkr.a(a(2131694352, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString }), 18, true));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372107, a(2131691796));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131372108, 2130844336);
        a(this.jdField_a_of_type_AndroidAppNotification, bjoq.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        this.jdField_a_of_type_AndroidAppNotification.flags = 32;
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags |= 0x2;
        bjom.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
        continue;
        bjko.b("NoticeUpdateHandler", ">>complete:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int = 3;
        this.jdField_a_of_type_AndroidAppNotification = bjom.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
      }
      if (this.jdField_a_of_type_AndroidAppNotification == null) {
        break;
      }
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694347);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372107, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372102, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372113, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372107, a(2131694331));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372119, bjkr.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      a(this.jdField_a_of_type_AndroidAppNotification, bjoq.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), false);
      paramMessage = bjkm.a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      if (paramMessage != null) {
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewBitmap(2131372108, paramMessage);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppNotification.flags = 16;
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags &= 0xFFFFFFFD;
        bjom.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
        break;
        bjko.b("NoticeUpdateHandler", ">>download icon fail,so we use default notification icon");
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131372108, 2130844336);
      }
      bjko.b("NoticeUpdateHandler", ">>pause:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694333);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372107, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372102, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372113, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131372108, 2130844339);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372119, bjkr.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372107, a(2131694333));
      a(this.jdField_a_of_type_AndroidAppNotification, bjoq.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
      this.jdField_a_of_type_AndroidAppNotification.flags = 16;
      paramMessage = this.jdField_a_of_type_AndroidAppNotification;
      paramMessage.flags &= 0xFFFFFFFD;
      bjom.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
      continue;
      bjko.b("NoticeUpdateHandler", ">>error:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372107, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372102, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131372113, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131372108, 2130844337);
      String str = (String)paramMessage.obj;
      paramMessage = str;
      if (TextUtils.isEmpty(str)) {
        paramMessage = a(2131691788);
      }
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694348, new Object[] { paramMessage });
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372107, a(2131694332, new Object[] { paramMessage }));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372119, bjkr.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      a(this.jdField_a_of_type_AndroidAppNotification, bjoq.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
      this.jdField_a_of_type_AndroidAppNotification.flags = 16;
      paramMessage = this.jdField_a_of_type_AndroidAppNotification;
      paramMessage.flags &= 0xFFFFFFFD;
      bjom.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
    }
    bjom.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjot
 * JD-Core Version:    0.7.0.1
 */