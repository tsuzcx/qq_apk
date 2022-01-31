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

public class bdhx
  extends Handler
{
  protected Notification a;
  protected NoticeParam a;
  
  public bdhx()
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  public bdhx(Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  protected String a(int paramInt)
  {
    return bcyb.a().a().getString(paramInt);
  }
  
  protected String a(int paramInt, Object... paramVarArgs)
  {
    return bcyb.a().a().getString(paramInt, paramVarArgs);
  }
  
  protected void a(Notification paramNotification, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT > 10)
      {
        paramNotification.contentView.setOnClickPendingIntent(2131370956, paramPendingIntent);
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
    Object localObject2 = ((Bundle)localObject1).getString(bdlb.jdField_a_of_type_JavaLangString);
    bdii.a("NoticeHintHandler", "+++++what:" + paramMessage.what + "+++++" + localObject1);
    localObject2 = bdhk.a().a((String)localObject2);
    if (localObject2 != null)
    {
      if (((DownloadInfo)localObject2).i == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
        bdii.c("NoticeHintHandler", "notification isShowNotification=" + ((DownloadInfo)localObject2).i);
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
          this.jdField_a_of_type_AndroidAppNotification = bdmq.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
          if (this.jdField_a_of_type_AndroidAppNotification == null) {
            break;
          }
        }
        switch (paramMessage.what)
        {
        default: 
          int i = bdmq.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          long l = bdmq.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidAppNotification.when = l;
          bdmq.a().a(i, this.jdField_a_of_type_AndroidAppNotification);
          bdii.c("NoticeHintHandler", "notify key=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString + " type=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int + "appid=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          return;
          localObject1 = new RemoteViews(bcyb.a().a().getPackageName(), 2131559466);
          bdmq.a().a((RemoteViews)localObject1);
          ((RemoteViews)localObject1).setInt(2131370956, "setBackgroundColor", -1);
          ((RemoteViews)localObject1).setInt(2131370958, "setTextColor", -16777216);
          ((RemoteViews)localObject1).setInt(2131370952, "setTextColor", -12303292);
          ((RemoteViews)localObject1).setInt(2131370948, "setTextColor", -12303292);
          this.jdField_a_of_type_AndroidAppNotification.contentView = ((RemoteViews)localObject1);
          continue;
        }
      }
      catch (Exception localException)
      {
        bdii.c("NoticeHintHandler", "init Notification>>>", localException);
        continue;
        bdii.b("NoticeHintHandler", ">>downloading:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        bdii.c("NoticeHintHandler", "size = " + ((DownloadInfo)localObject2).jdField_f_of_type_Int + " content = ");
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694732, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370948, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370944, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370952, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setProgressBar(2131370943, 100, ((DownloadInfo)localObject2).jdField_f_of_type_Int, false);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370952, ((DownloadInfo)localObject2).jdField_f_of_type_Int * 100 / 100 + "%");
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131370949, 2130843545);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370958, bdio.a(a(2131694734, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString }), 18, true));
        a(this.jdField_a_of_type_AndroidAppNotification, bdmu.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        if (!TextUtils.isEmpty(""))
        {
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370948, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370948, Html.fromHtml(""));
          this.jdField_a_of_type_AndroidAppNotification.flags = 32;
          paramMessage = this.jdField_a_of_type_AndroidAppNotification;
          paramMessage.flags |= 0x2;
          continue;
        }
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370948, 8);
        continue;
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694732, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370948, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370944, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370952, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370958, bdio.a(a(2131694734, new Object[] { ((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString }), 18, true));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370948, a(2131691936));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131370949, 2130843545);
        a(this.jdField_a_of_type_AndroidAppNotification, bdmu.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        this.jdField_a_of_type_AndroidAppNotification.flags = 32;
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags |= 0x2;
        bdmq.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
        continue;
        bdii.b("NoticeHintHandler", ">>complete:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int = 3;
        this.jdField_a_of_type_AndroidAppNotification = bdmq.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
      }
      if (this.jdField_a_of_type_AndroidAppNotification == null) {
        break;
      }
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694730);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370948, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370944, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370952, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370948, a(2131694714));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370958, bdio.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      a(this.jdField_a_of_type_AndroidAppNotification, bdmu.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), false);
      paramMessage = bdig.a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      if (paramMessage != null) {
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewBitmap(2131370949, paramMessage);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppNotification.flags = 16;
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags &= 0xFFFFFFFD;
        bdmq.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
        break;
        bdii.b("NoticeHintHandler", ">>download icon fail,so we use default notification icon");
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131370949, 2130843545);
      }
      bdii.b("NoticeHintHandler", ">>pause:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694716);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370948, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370944, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370952, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131370949, 2130843548);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370958, bdio.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370948, a(2131694716));
      a(this.jdField_a_of_type_AndroidAppNotification, bdmu.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
      this.jdField_a_of_type_AndroidAppNotification.flags = 16;
      paramMessage = this.jdField_a_of_type_AndroidAppNotification;
      paramMessage.flags &= 0xFFFFFFFD;
      bdmq.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
      continue;
      bdii.b("NoticeHintHandler", ">>error:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370948, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370944, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131370952, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131370949, 2130843546);
      String str = (String)paramMessage.obj;
      paramMessage = str;
      if (TextUtils.isEmpty(str)) {
        paramMessage = a(2131691928);
      }
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694731, new Object[] { paramMessage });
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370948, a(2131694715, new Object[] { paramMessage }));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131370958, bdio.a(((DownloadInfo)localObject2).jdField_f_of_type_JavaLangString, 18, true));
      a(this.jdField_a_of_type_AndroidAppNotification, bdmu.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
      this.jdField_a_of_type_AndroidAppNotification.flags = 16;
      paramMessage = this.jdField_a_of_type_AndroidAppNotification;
      paramMessage.flags &= 0xFFFFFFFD;
      bdmq.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
    }
    bdmq.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdhx
 * JD-Core Version:    0.7.0.1
 */