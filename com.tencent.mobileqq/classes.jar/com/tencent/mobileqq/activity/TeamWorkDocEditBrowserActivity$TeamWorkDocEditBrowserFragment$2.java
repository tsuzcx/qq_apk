package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$2
  implements Handler.Callback
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$2(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i != 3) {
        return true;
      }
      if ((this.a.getSwiftTitleUI().c != null) && (!this.a.getSwiftTitleUI().c.isEnabled())) {
        this.a.getSwiftTitleUI().c.setEnabled(true);
      }
      QQToast.a(this.a.getQBaseActivity(), HardCodeUtil.a(2131714552), 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
      return true;
    }
    if ((this.a.getSwiftTitleUI().c != null) && (!this.a.getSwiftTitleUI().c.isEnabled())) {
      this.a.getSwiftTitleUI().c.setEnabled(true);
    }
    Object localObject = (String)paramMessage.obj;
    if (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a))
    {
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, 1);
      this.a.getQBaseActivity().finish();
    }
    else
    {
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, 0);
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, (String)localObject);
    }
    paramMessage = new Bundle();
    paramMessage.putString("savedUrl", (String)localObject);
    localObject = (TeamWorkFileImportInfo)this.a.getIntent().getParcelableExtra("key_team_work_file_import_info");
    if (((TeamWorkFileImportInfo)localObject).e == 3) {
      paramMessage.putInt("editType", 1);
    } else if (((TeamWorkFileImportInfo)localObject).e == 6) {
      paramMessage.putInt("editType", 2);
    }
    if (this.a.getIntent().getParcelableExtra("key_team_work_file_import_info") != null) {
      paramMessage.putParcelable("key_team_work_file_import_info", this.a.getIntent().getParcelableExtra("key_team_work_file_import_info"));
    }
    paramMessage = DataFactory.a("ipc_save_team_work", "", -1, paramMessage);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.2
 * JD-Core Version:    0.7.0.1
 */