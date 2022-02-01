package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click;

import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike.RIJDislikeManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.ViewHolder;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.plugin.PluginBaseActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class RIJFrameworkHandleClick$3
  implements ClickHandler
{
  RIJFrameworkHandleClick$3(RIJFrameworkHandleClick paramRIJFrameworkHandleClick) {}
  
  public void onClick(View paramView)
  {
    RIJFrameworkHandleClick.a(this.a).a().a().a(RIJFrameworkHandleClick.a(this.a).a().a());
    RIJFrameworkHandleClick.a(this.a).a().a().a(RIJFrameworkHandleClick.a(this.a).a().a());
    ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
    if (localViewHolder == null) {}
    for (;;)
    {
      return;
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)RIJFrameworkHandleClick.a(this.a).a().get(localViewHolder.a);
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", RIJFrameworkHandleClick.a(this.a).a().b());
        if ((RIJFrameworkHandleClick.a(this.a).a().a() instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.a);
          ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.a());
          ((JSONObject)localObject).put("feeds_type", "" + RIJFeedsType.a(localBaseArticleInfo));
          ((JSONObject)localObject).put("rowkey", ReadinjoyReportUtils.a(localBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", (String)localObject, false);
        }
        while (localBaseArticleInfo != null)
        {
          RIJFrameworkHandleClick.a(this.a).a().a().a(paramView, localViewHolder, localBaseArticleInfo, RIJFrameworkHandleClick.a(this.a));
          if ((RIJFrameworkHandleClick.a(this.a).a().a() != null) && (RIJFrameworkHandleClick.a(this.a).a().a().b()))
          {
            RIJFrameworkHandleClick.a(this.a).a().a().a();
            RIJFrameworkHandleClick.a(this.a).a().f(true);
          }
          VideoHandler.a(paramView);
          return;
          if ((RIJFrameworkHandleClick.a(this.a).a().a() instanceof PluginBaseActivity))
          {
            ((JSONObject)localObject).put("folder_status", 1);
            ReportController.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", ((JSONObject)localObject).toString());
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJFrameworkHandleClick.3
 * JD-Core Version:    0.7.0.1
 */