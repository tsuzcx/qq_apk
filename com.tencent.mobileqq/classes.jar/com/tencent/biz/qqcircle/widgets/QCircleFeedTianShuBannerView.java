package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.events.QCircleCloseBannerEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StNegativeFbButton;
import qqcircle.QQCircleDitto.StSinglePicBanner;
import tianshu.QQCircleTianShu.AdItem;
import tianshu.QQCircleTianShu.MapEntry;

public class QCircleFeedTianShuBannerView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private ImageView a;
  private RelativeLayout b;
  private ImageView c;
  private byte[] d;
  private QQCircleDitto.StSinglePicBanner e;
  private QQCircleTianShu.AdItem f;
  private String g;
  private String h;
  
  public QCircleFeedTianShuBannerView(Context paramContext)
  {
    super(paramContext);
  }
  
  private String a(int paramInt)
  {
    if (this.f == null) {
      return "";
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("uin", QCirclePluginGlobalInfo.e());
      ((JSONObject)localObject).put("trace_num", 1);
      ((JSONObject)localObject).put("appid", "tianshu.242");
      ((JSONObject)localObject).put("page_id", "tianshu.242");
      ((JSONObject)localObject).put("item_id", this.f.iAdId.get());
      ((JSONObject)localObject).put("oper_time", System.currentTimeMillis() / 1000L);
      ((JSONObject)localObject).put("action_id", paramInt);
      ((JSONObject)localObject).put("action_value", 1);
      ((JSONObject)localObject).put("trigger_info", this.f.traceinfo.get());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ext6:");
      localStringBuilder.append(((JSONObject)localObject).toString());
      QLog.d("QCircleFeedTianShuBannerView", 1, localStringBuilder.toString());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error");
      localStringBuilder.append(localJSONException);
      QLog.d("QCircleFeedTianShuBannerView", 1, localStringBuilder.toString());
    }
    return "";
  }
  
  private void a()
  {
    if (this.f != null)
    {
      if (this.e == null) {
        return;
      }
      c();
      b();
      a(this.e.image);
    }
  }
  
  private void a(FeedCloudMeta.StImage paramStImage)
  {
    if (this.a != null)
    {
      if (this.e.image.get() == null) {
        return;
      }
      if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
      {
        float f1 = paramStImage.height.get() * 1.0F / paramStImage.width.get();
        int i = DisplayUtil.d();
        paramStImage = this.a.getLayoutParams();
        paramStImage.height = Math.round(f1 * i);
        paramStImage.width = -1;
        this.a.setLayoutParams(paramStImage);
      }
    }
  }
  
  private void b()
  {
    if ((this.c != null) && (this.e.buttons.get() != null))
    {
      if (this.e.buttons.get().size() <= 0) {
        return;
      }
      String str = ((QQCircleDitto.StNegativeFbButton)this.e.buttons.get().get(0)).color.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("close button color: ");
      localStringBuilder.append(str);
      QLog.d("QCircleFeedTianShuBannerView", 1, localStringBuilder.toString());
      if (str.trim().length() > 0) {
        try
        {
          this.c.setColorFilter(Color.parseColor(str));
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject1 = this.f.argList.get();
    if (((List)localObject1).size() <= 0) {
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (QQCircleTianShu.MapEntry)((Iterator)localObject1).next();
      Object localObject3 = ((QQCircleTianShu.MapEntry)localObject2).key.get();
      int i = -1;
      int j = ((String)localObject3).hashCode();
      if (j != 110986)
      {
        if (j != 116079)
        {
          if ((j == 3575610) && (((String)localObject3).equals("type"))) {
            i = 1;
          }
        }
        else if (((String)localObject3).equals("url")) {
          i = 0;
        }
      }
      else if (((String)localObject3).equals("pic")) {
        i = 2;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("banner url is:");
            ((StringBuilder)localObject3).append(((QQCircleTianShu.MapEntry)localObject2).value.get());
            QLog.d("QCircleFeedTianShuBannerView", 1, ((StringBuilder)localObject3).toString());
            localObject2 = new Option().setUrl(((QQCircleTianShu.MapEntry)localObject2).value.get()).setTargetView(this.a);
            QCircleFeedPicLoader.g().loadImage((Option)localObject2, null);
          }
        }
        else {
          this.h = ((QQCircleTianShu.MapEntry)localObject2).value.get();
        }
      }
      else {
        this.g = ((QQCircleTianShu.MapEntry)localObject2).value.get();
      }
    }
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof FeedBlockData))
    {
      Object localObject = (FeedBlockData)paramObject;
      FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)localObject).b();
      try
      {
        paramObject = new QQCircleDitto.StCircleDittoDataNew();
        if ((((FeedBlockData)localObject).a("DITTO_ALLPUSH_TIANSHU_BANNER") instanceof QQCircleDitto.StCircleDittoDataNew))
        {
          paramObject = (QQCircleDitto.StCircleDittoDataNew)((FeedBlockData)localObject).a("DITTO_ALLPUSH_TIANSHU_BANNER");
          QLog.d("QCircleFeedTianShuBannerView", 1, "get data form blockData");
        }
        else
        {
          paramObject.mergeFrom(localStFeed.dittoFeed.dittoDataNew.get().toByteArray());
          QLog.d("QCircleFeedTianShuBannerView", 1, "get data form mergerData");
        }
        this.e = ((QQCircleDitto.StSinglePicBanner)paramObject.singlePicBanner.get());
        this.f = ((QQCircleTianShu.AdItem)this.e.tianshuAdItem.get());
        a();
        return;
      }
      catch (Exception paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("show banner exception");
        ((StringBuilder)localObject).append(paramObject.getMessage());
        QLog.d("QCircleFeedTianShuBannerView", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131626859;
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedTianShuBannerView";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.d("QCircleFeedTianShuBannerView", 1, "onAttachedToWindow");
    if (this.f != null) {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePluginGlobalInfo.e()).setActionType(23).setSubActionType(4).setThrActionType(1).setExt5(String.valueOf(this.f.iAdId.get())).setExt6(a(101)).setFeedReportInfo(this.d).setPageId(getPageId()));
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.f != null)
    {
      int i = paramView.getId();
      if (i == 2131436284)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("clickBanner actionType   actionUrl");
        boolean bool = TextUtils.isEmpty(this.g);
        String str = "";
        if (!bool)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(this.g);
          localStringBuilder2.append("  jumpType:");
          if (!TextUtils.isEmpty(this.h)) {
            str = this.h;
          }
          localStringBuilder2.append(str);
          str = localStringBuilder2.toString();
        }
        localStringBuilder1.append(str);
        QLog.d("QCircleFeedTianShuBannerView", 1, localStringBuilder1.toString());
        if (!TextUtils.isEmpty(this.h)) {
          QCircleLauncher.a(getContext(), this.g);
        }
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePluginGlobalInfo.e()).setActionType(23).setSubActionType(4).setThrActionType(2).setExt5(String.valueOf(this.f.iAdId.get())).setExt6(a(102)).setFeedReportInfo(this.d).setPageId(getPageId()));
      }
      else if (i == 2131444915)
      {
        QCirclePluginConfig.a().m();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleCloseBannerEvent());
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(((FeedBlockData)getData()).b().id.get(), 3));
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePluginGlobalInfo.e()).setActionType(23).setSubActionType(4).setThrActionType(3).setExt5(String.valueOf(this.f.iAdId.get())).setExt6(a(122)).setFeedReportInfo(this.d).setPageId(getPageId()));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.a = ((ImageView)paramView.findViewById(2131436284));
      this.b = ((RelativeLayout)paramView.findViewById(2131444915));
      this.c = ((ImageView)paramView.findViewById(2131436282));
      this.a.setOnClickListener(this);
      this.b.setOnClickListener(this);
      this.a.setAdjustViewBounds(true);
    }
  }
  
  public void setReportInfo(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedTianShuBannerView
 * JD-Core Version:    0.7.0.1
 */