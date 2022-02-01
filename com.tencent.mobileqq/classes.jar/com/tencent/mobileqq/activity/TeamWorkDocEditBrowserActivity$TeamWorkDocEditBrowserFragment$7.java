package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportCover;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$7
  extends OnRemoteRespObserver
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$7(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onBindedToClient()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->onBindedToClient");
    }
    ThreadManager.getUIHandler().postDelayed(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.7.1(this), 30L);
  }
  
  public void onDisconnectWithService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->onDisconnectWithService");
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->onPushMsg");
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->onResponse");
    }
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getInt("respkey", 0) == this.a.a.key)
    {
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, false);
      String str = paramBundle.getString("cmd");
      paramBundle.getString("callbackid");
      Object localObject = paramBundle.getBundle("response");
      paramBundle = paramBundle.getBundle("request");
      long l = TenDocLogReportHelper.a("get_url_time");
      if (("ipc_cmd_get_team_work_url".equals(str)) && (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a) != null))
      {
        str = ((Bundle)localObject).getString("url");
        Bundle localBundle = new Bundle();
        localBundle.putString("url", str);
        QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", localBundle);
        if ((!TextUtils.isEmpty(str)) && (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a) != null) && (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).a()))
        {
          TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.b(this.a, ((Bundle)localObject).getBoolean("needRefresh"));
          if (this.a.getIntent().getStringExtra("tdsourcetag") != null)
          {
            localObject = this.a.getIntent().getStringExtra("tdsourcetag");
            str = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(str, (String)localObject);
            if (TeamWorkDocEditBrowserActivity.a(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).getContext(), str, (String)localObject, true))
            {
              ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(paramBundle, "0X8009ED7");
              this.a.getQBaseActivity().finish();
            }
            else
            {
              ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(paramBundle, "0X8009ED6");
              TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.b(this.a).loadUrl(str);
            }
            paramBundle = new StringBuilder();
            paramBundle.append(String.valueOf(l));
            paramBundle.append(" - url:");
            paramBundle.append(str);
            TenDocLogReportHelper.a("WebLog_WebViewFragment", "get_url_time", paramBundle.toString());
            return;
          }
          if (TeamWorkDocEditBrowserActivity.a(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.c(this.a).getContext(), str, "s_qq_file_edit", true))
          {
            ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(paramBundle, "0X8009ED7");
            this.a.getQBaseActivity().finish();
          }
          else
          {
            ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(paramBundle, "0X8009ED6");
            TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.d(this.a).loadUrl(str);
          }
          paramBundle = new StringBuilder();
          paramBundle.append(String.valueOf(l));
          paramBundle.append(" - url:");
          paramBundle.append(str);
          TenDocLogReportHelper.a("WebLog_WebViewFragment", "get_url_time", paramBundle.toString());
          return;
        }
        int i = ((Bundle)localObject).getInt("retCode");
        str = ((Bundle)localObject).getString("errorStr");
        localObject = ((Bundle)localObject).getString("redirectUrl");
        if ((Math.abs(i) == 115) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          str = this.a.getIntent().getStringExtra("tdsourcetag");
          if (TeamWorkDocEditBrowserActivity.a(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.e(this.a).getContext(), (String)localObject, str, true))
          {
            ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(paramBundle, "0X8009ED7");
            this.a.getQBaseActivity().finish();
          }
          else
          {
            ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(paramBundle, "0X8009ED6");
            TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.f(this.a).loadUrl((String)localObject);
          }
          paramBundle = new StringBuilder();
          paramBundle.append(String.valueOf(l));
          paramBundle.append(" - redirectUrl:");
          paramBundle.append((String)localObject);
          TenDocLogReportHelper.a("WebLog_WebViewFragment", "get_url_time", paramBundle.toString());
          return;
        }
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).a(i, str);
        if (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, null)) {
          TenDocLogReportHelper.a(null, "0X800A755");
        }
        paramBundle = new StringBuilder();
        paramBundle.append("retCode = ");
        paramBundle.append(i);
        paramBundle.append(" errorStr = ");
        paramBundle.append(str);
        TenDocLogReportHelper.a("WebLog_WebViewFragment", "get_url_time", paramBundle.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.7
 * JD-Core Version:    0.7.0.1
 */