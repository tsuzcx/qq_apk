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

public class bfqd
  extends Handler
{
  protected Notification a;
  protected NoticeParam a;
  
  public bfqd()
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  public bfqd(Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  protected String a(int paramInt)
  {
    return bfbm.a().a().getString(paramInt);
  }
  
  protected String a(int paramInt, Object... paramVarArgs)
  {
    return bfbm.a().a().getString(paramInt, paramVarArgs);
  }
  
  protected void a(Notification paramNotification, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT > 10)
      {
        paramNotification.contentView.setOnClickPendingIntent(2131371286, paramPendingIntent);
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
    Object localObject2 = ((Bundle)localObject1).getString(bfoh.jdField_b_of_type_JavaLangString);
    bflp.a("NoticeUpdateHandler", "+++++what:" + paramMessage.what + "+++++" + localObject1);
    localObject2 = bfok.a().a((String)localObject2);
    if (localObject2 != null)
    {
      if (((DownloadInfo)localObject2).i == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
        bflp.c("NoticeUpdateHandler", "notification isShowNotification=" + ((DownloadInfo)localObject2).i);
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
          this.jdField_a_of_type_AndroidAppNotification = bfpw.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
          if (this.jdField_a_of_type_AndroidAppNotification == null) {
            break;
          }
        }
        switch (paramMessage.what)
        {
        default: 
          int i = bfpw.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          long l = bfpw.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidAppNotification.when = l;
          bfpw.a().a(i, this.jdField_a_of_type_AndroidAppNotification);
          bflp.c("NoticeUpdateHandler", "notify key=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString + " type=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int + "appid=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          return;
          localObject1 = new RemoteViews(bfbm.a().a().getPackageName(), 2131559517);
          bfpw.a().a((RemoteViews)localObject1);
          ((RemoteViews)localObject1).setInt(2131371286, "setBackgroundColor", -1);
          ((RemoteViews)localObject1).setInt(2131371288, "setTextColor", -16777216);
          ((RemoteViews)localObject1).setInt(2131371282, "setTextColor", -12303292);
          ((RemoteViews)localObject1).setInt(2131371278, "setTextColor", -12303292);
          this.jdField_a_of_type_AndroidAppNotification.contentView = ((RemoteViews)localObject1);
          continue;
        }
      }
      catch (Exception localException)
      {
        bflp.c("NoticeUpdateHandler", "init Notification>>>", localException);
        continue;
        bflp.b("NoticeUpdateHandler", ">>downloading:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        bflp.c("NoticeUpdateHandler", "size = " + ((DownloadInfo)localObject2).jdField_f_of_type_Int + " content = ");
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694891, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371278, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371274, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371282, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setProgressBar(2131371273, 100, ((DownloadInfo)localObject2).jdField_f_of_type_Int, false);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371282, ((DownloadInfo)localObject2).jdField_f_of_type_Int * 100 / 100 + "%");
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131371279, 2130843976);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371288, bflv.a(a(2131694893, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString }), 18, true));
        a(this.jdField_a_of_type_AndroidAppNotification, bfqa.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        if (!TextUtils.isEmpty(""))
        {
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371278, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371278, Html.fromHtml(""));
          this.jdField_a_of_type_AndroidAppNotification.flags = 32;
          paramMessage = this.jdField_a_of_type_AndroidAppNotification;
          paramMessage.flags |= 0x2;
          continue;
        }
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371278, 8);
        continue;
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694891, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371278, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371274, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371282, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371288, bflv.a(a(2131694893, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString }), 18, true));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371278, a(2131691992));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131371279, 2130843976);
        a(this.jdField_a_of_type_AndroidAppNotification, bfqa.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        this.jdField_a_of_type_AndroidAppNotification.flags = 32;
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags |= 0x2;
        bfpw.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
        continue;
        bflp.b("NoticeUpdateHandler", ">>complete:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int = 3;
        this.jdField_a_of_type_AndroidAppNotification = bfpw.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
      }
      if (this.jdField_a_of_type_AndroidAppNotification == null) {
        break;
      }
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694889);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371278, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371274, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371282, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371278, a(2131694873));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371288, bflv.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      a(this.jdField_a_of_type_AndroidAppNotification, bfqa.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), false);
      paramMessage = bfln.a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      if (paramMessage != null) {
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewBitmap(2131371279, paramMessage);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppNotification.flags = 16;
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags &= 0xFFFFFFFD;
        bfpw.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
        break;
        bflp.b("NoticeUpdateHandler", ">>download icon fail,so we use default notification icon");
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131371279, 2130843976);
      }
      bflp.b("NoticeUpdateHandler", ">>pause:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694875);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371278, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371274, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371282, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131371279, 2130843979);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371288, bflv.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371278, a(2131694875));
      a(this.jdField_a_of_type_AndroidAppNotification, bfqa.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
      this.jdField_a_of_type_AndroidAppNotification.flags = 16;
      paramMessage = this.jdField_a_of_type_AndroidAppNotification;
      paramMessage.flags &= 0xFFFFFFFD;
      bfpw.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
      continue;
      bflp.b("NoticeUpdateHandler", ">>error:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371278, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371274, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371282, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131371279, 2130843977);
      String str = (String)paramMessage.obj;
      paramMessage = str;
      if (TextUtils.isEmpty(str)) {
        paramMessage = a(2131691984);
      }
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694890, new Object[] { paramMessage });
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371278, a(2131694874, new Object[] { paramMessage }));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371288, bflv.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      a(this.jdField_a_of_type_AndroidAppNotification, bfqa.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
      this.jdField_a_of_type_AndroidAppNotification.flags = 16;
      paramMessage = this.jdField_a_of_type_AndroidAppNotification;
      paramMessage.flags &= 0xFFFFFFFD;
      bfpw.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
    }
    bfpw.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfqd
 * JD-Core Version:    0.7.0.1
 */