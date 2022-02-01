package com.tencent.mobileqq.apollo.request;

import android.content.Intent;
import com.tencent.mobileqq.emosm.web.RequestRoute;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/KapuRequestReceiver;", "", "()V", "handleKapuReportDownload", "", "request", "Landroid/content/Intent;", "resp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class KapuRequestReceiver
{
  public static final KapuRequestReceiver.Companion a = new KapuRequestReceiver.Companion(null);
  
  @RequestRoute(a="cmshowar_activity_template.report_user_source")
  public final void handleKapuReportDownload(@Nullable Intent paramIntent, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          QLog.d("[cmshow]KapuRequestReceiver", 2, new Object[] { "[handleKapuReportDownload] ret=", Long.valueOf(paramIntent.ret.get()) });
          return;
        }
      }
      catch (Exception paramIntent)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("[handleKapuReportDownload] err:");
        paramFromServiceMsg.append(paramIntent.getMessage());
        QLog.e("[cmshow]KapuRequestReceiver", 1, paramFromServiceMsg.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.request.KapuRequestReceiver
 * JD-Core Version:    0.7.0.1
 */