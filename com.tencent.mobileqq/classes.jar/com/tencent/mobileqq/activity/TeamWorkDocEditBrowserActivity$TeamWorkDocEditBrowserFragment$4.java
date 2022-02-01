package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportCover;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$4
  extends Client.OnRemoteRespObserver
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$4(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onBindedToClient()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->onBindedToClient");
    }
    ThreadManager.getUIHandler().postDelayed(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.4.1(this), 30L);
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
    if (paramBundle == null) {}
    long l;
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).key);
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, false);
      str = paramBundle.getString("cmd");
      paramBundle.getString("callbackid");
      localObject = paramBundle.getBundle("response");
      paramBundle = paramBundle.getBundle("request");
      l = TenDocLogReportHelper.a("get_url_time");
    } while ((!"ipc_cmd_get_team_work_url".equals(str)) || (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a) == null));
    String str = ((Bundle)localObject).getString("url");
    Bundle localBundle = new Bundle();
    localBundle.putString("url", str);
    QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", localBundle);
    if ((!TextUtils.isEmpty(str)) && (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a) != null) && (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).a()))
    {
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.b(this.a, ((Bundle)localObject).getBoolean("needRefresh"));
      if (this.a.getIntent().getStringExtra("tdsourcetag") != null)
      {
        localObject = this.a.getIntent().getStringExtra("tdsourcetag");
        str = TeamWorkUtils.b(str, (String)localObject);
        if (TeamWorkDocEditBrowserActivity.a(this.a.webView.getContext(), str, (String)localObject, true))
        {
          TeamWorkUtils.a(paramBundle, "0X8009ED7");
          this.a.getActivity().finish();
        }
        for (;;)
        {
          TenDocLogReportHelper.a("WebLog_WebViewFragment", "get_url_time", String.valueOf(l) + " - url:" + str);
          return;
          TeamWorkUtils.a(paramBundle, "0X8009ED6");
          this.a.webView.loadUrl(str);
        }
      }
      if (TeamWorkDocEditBrowserActivity.a(this.a.webView.getContext(), str, "s_qq_file_edit", true))
      {
        TeamWorkUtils.a(paramBundle, "0X8009ED7");
        this.a.getActivity().finish();
      }
      for (;;)
      {
        TenDocLogReportHelper.a("WebLog_WebViewFragment", "get_url_time", String.valueOf(l) + " - url:" + str);
        return;
        TeamWorkUtils.a(paramBundle, "0X8009ED6");
        this.a.webView.loadUrl(str);
      }
    }
    int i = ((Bundle)localObject).getInt("retCode");
    str = ((Bundle)localObject).getString("errorStr");
    Object localObject = ((Bundle)localObject).getString("redirectUrl");
    if ((Math.abs(i) == 115) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      str = this.a.getIntent().getStringExtra("tdsourcetag");
      if (TeamWorkDocEditBrowserActivity.a(this.a.webView.getContext(), (String)localObject, str, true))
      {
        TeamWorkUtils.a(paramBundle, "0X8009ED7");
        this.a.getActivity().finish();
      }
      for (;;)
      {
        TenDocLogReportHelper.a("WebLog_WebViewFragment", "get_url_time", String.valueOf(l) + " - redirectUrl:" + (String)localObject);
        return;
        TeamWorkUtils.a(paramBundle, "0X8009ED6");
        this.a.webView.loadUrl((String)localObject);
      }
    }
    TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).a(i, str);
    if (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, null)) {
      TenDocLogReportHelper.a(null, "0X800A755");
    }
    TenDocLogReportHelper.a("WebLog_WebViewFragment", "get_url_time", "retCode = " + i + " errorStr = " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.4
 * JD-Core Version:    0.7.0.1
 */