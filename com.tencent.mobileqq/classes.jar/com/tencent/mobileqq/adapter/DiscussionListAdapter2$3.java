package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DiscussionListAdapter2$3
  implements View.OnClickListener
{
  DiscussionListAdapter2$3(DiscussionListAdapter2 paramDiscussionListAdapter2) {}
  
  public void onClick(View paramView)
  {
    ((SlideDetectListView)DiscussionListAdapter2.a(this.a)).a();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).d();
    }
    localObject = paramView.getTag();
    if ((localObject instanceof DiscussionInfo))
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localObject;
      if (NetworkUtil.getSystemNetwork(DiscussionListAdapter2.a(this.a)) == 0)
      {
        localObject = (BaseActivity)DiscussionListAdapter2.a(this.a);
        QQToast.a((Context)localObject, 2131696114, 0).b(((BaseActivity)localObject).getTitleBarHeight());
      }
      else if ((!localDiscussionInfo.hasCollect) && (((DiscussionManager)this.a.a.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a() >= 80))
      {
        localObject = (BaseActivity)DiscussionListAdapter2.a(this.a);
        QQToast.a((Context)localObject, DiscussionListAdapter2.a(this.a).getString(2131696113, new Object[] { String.valueOf(80) }), 0).b(((BaseActivity)localObject).getTitleBarHeight());
      }
      else
      {
        DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        if (localDiscussionInfo.hasCollect) {
          localObject = "0X8006898";
        } else {
          localObject = "0X8006897";
        }
        ReportController.b(this.a.a, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
        if (localDiscussionInfo.hasCollect) {
          localDiscussionHandler.e(Long.valueOf(localDiscussionInfo.uin).longValue());
        } else {
          localDiscussionHandler.d(Long.valueOf(localDiscussionInfo.uin).longValue());
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.DiscussionListAdapter2.3
 * JD-Core Version:    0.7.0.1
 */