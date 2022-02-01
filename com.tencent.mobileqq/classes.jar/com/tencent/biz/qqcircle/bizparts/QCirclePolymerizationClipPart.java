package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleCommonClick;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.io.File;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StFashionCopyPageData;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StGpsPageData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class QCirclePolymerizationClipPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private static RFWMultiDownloadHelper m;
  private QCirclePolymerizationBean a;
  private TextView c;
  private ImageView d;
  private ImageView e;
  private QCirclePolymerizationViewModel f;
  private FeedCloudMeta.StShare g;
  private QQCircleFeedBase.StFeedListBusiRspData h;
  private LinearLayout i;
  private URLImageView j;
  private int k;
  private View l;
  
  static
  {
    n();
    m = new RFWMultiDownloadHelper();
    m.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleSkinHelper.getInstance().getUrl("topic_cover_default"), QCirclePluginConfig.e()));
    m.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleSkinHelper.getInstance().getUrl("topic_cover_location"), QCirclePluginConfig.e()));
    m.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleSkinHelper.getInstance().getUrl("topic_cover_filter"), QCirclePluginConfig.e()));
    m.start();
  }
  
  public QCirclePolymerizationClipPart(QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    this.a = paramQCirclePolymerizationBean;
  }
  
  private void a(URLImageView paramURLImageView, String paramString, boolean paramBoolean)
  {
    if (paramURLImageView != null)
    {
      paramURLImageView.setVisibility(0);
      Object localObject = paramURLImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ImmersiveUtils.b();
      double d1 = ((ViewGroup.LayoutParams)localObject).width;
      Double.isNaN(d1);
      ((ViewGroup.LayoutParams)localObject).height = ((int)(d1 * 0.608D));
      paramURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new ColorDrawable(g().getResources().getColor(2131168376));
      paramURLImageView = new Option().setUrl(paramString).setTargetView(paramURLImageView).setLoadingDrawable((Drawable)localObject).setFailDrawable((Drawable)localObject).setRequestHeight(paramURLImageView.getMeasuredHeight()).setRequestWidth(paramURLImageView.getMeasuredWidth());
      paramString = new StringBuilder();
      paramString.append("options.mRequestWidth =");
      paramString.append(paramURLImageView.getRequestWidth());
      paramString.append("options.mRequestHeight =");
      paramString.append(paramURLImageView.getRequestHeight());
      QLog.d("QCirclePolymerizationClipPart", 1, paramString.toString());
      QCircleFeedPicLoader.g().loadImage(paramURLImageView, null);
    }
  }
  
  private void a(QQCircleFeedBase.StFeedListBusiRspData paramStFeedListBusiRspData)
  {
    if (paramStFeedListBusiRspData == null) {
      return;
    }
    this.h = paramStFeedListBusiRspData;
    paramStFeedListBusiRspData = this.a;
    if ((paramStFeedListBusiRspData != null) && (this.c != null) && (this.e != null))
    {
      if (this.j == null) {
        return;
      }
      int i1 = paramStFeedListBusiRspData.getPolymerizationType();
      if (i1 != 7)
      {
        if (i1 != 16)
        {
          if (i1 != 20)
          {
            paramStFeedListBusiRspData = "";
          }
          else
          {
            this.g = ((FeedCloudMeta.StShare)this.h.fashionCopyPageData.shareInfo.get());
            paramStFeedListBusiRspData = this.h.fashionCopyPageData.pageDesc.get();
          }
        }
        else
        {
          this.g = ((FeedCloudMeta.StShare)this.h.gpsPageData.shareInfo.get());
          paramStFeedListBusiRspData = this.h.gpsPageData.poiName.get();
        }
      }
      else
      {
        this.g = ((FeedCloudMeta.StShare)this.h.tagPageData.tagInfo.shareInfo.get());
        paramStFeedListBusiRspData = this.h.tagPageData.tagInfo.tagName.get();
        l();
      }
      this.c.setText(paramStFeedListBusiRspData);
      this.a.setPolymerizationName(paramStFeedListBusiRspData);
      paramStFeedListBusiRspData = this.e;
      if (QCirclePluginGlobalInfo.k()) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      paramStFeedListBusiRspData.setVisibility(i1);
      this.j.setVisibility(0);
    }
  }
  
  private String b(String paramString)
  {
    return RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).getDefaultSavePath(paramString);
  }
  
  private void i()
  {
    QCirclePolymerizationBean localQCirclePolymerizationBean = this.a;
    if (localQCirclePolymerizationBean == null) {
      return;
    }
    int i1 = localQCirclePolymerizationBean.getPolymerizationType();
    if (i1 != 7)
    {
      if (i1 != 16)
      {
        if (i1 != 20) {
          return;
        }
        this.k = 6;
        a(QCircleSkinHelper.getInstance().getUrl("topic_cover_filter"));
        return;
      }
      this.k = 5;
      a(QCircleSkinHelper.getInstance().getUrl("topic_cover_location"));
      return;
    }
    this.k = 4;
    a(QCircleSkinHelper.getInstance().getUrl("topic_cover_default"));
  }
  
  private void l()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return;
    }
    if (this.j == null) {
      return;
    }
    localObject = ((QQCircleFeedBase.StFeedListBusiRspData)localObject).tagPageData.headBackgroundPic.get();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("QCirclePolymerizationClipPart", 1, "updateTagPageHeadImageBg  bgUrl == null");
      return;
    }
    a(this.j, (String)localObject, false);
  }
  
  @QCircleCommonClick
  private void m()
  {
    JoinPoint localJoinPoint = Factory.makeJP(n, this, this);
    a(this, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
  
  public String a()
  {
    return "QCirclePolymerizationClipPart";
  }
  
  public void a(View paramView)
  {
    this.c = ((TextView)paramView.findViewById(2131448814));
    this.d = ((ImageView)paramView.findViewById(2131436275));
    this.e = ((ImageView)paramView.findViewById(2131436571));
    this.j = ((URLImageView)paramView.findViewById(2131436406));
    this.l = paramView.findViewById(2131449803);
    this.e.setOnClickListener(this);
    this.d.setOnClickListener(this);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.d);
    }
    this.i = ((LinearLayout)paramView.findViewById(2131445047));
    int i1 = ImmersiveUtils.a(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = this.i.getLayoutParams();
    int i2 = ViewUtils.a(52.0F) + i1;
    paramView = localLayoutParams;
    if (localLayoutParams == null) {
      paramView = new ViewGroup.LayoutParams(-1, i2);
    }
    paramView.height = i2;
    this.i.setLayoutParams(paramView);
    this.i.setPadding(0, i1, 0, 0);
    this.f = ((QCirclePolymerizationViewModel)a(QCirclePolymerizationViewModel.class));
    this.f.c.observe(j(), new QCirclePolymerizationClipPart.1(this));
    i();
  }
  
  protected void a(String paramString)
  {
    if (this.j != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      String str = b(paramString);
      if (RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).isFileDownLoading(paramString)) {
        return;
      }
      if (new File(str).exists())
      {
        a(this.j, str, true);
        return;
      }
      RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).download(paramString, new QCirclePolymerizationClipPart.2(this));
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (TextUtils.equals(paramString, "polymerization_page_action_title_bar_animation"))
    {
      if ((paramObject instanceof Message))
      {
        int i1 = ((Message)paramObject).what;
        int i2 = QCircleSkinHelper.getInstance().getColor(2131167059);
        int i3 = QCircleSkinHelper.getInstance().getColor(2131167084);
        this.i.setBackgroundColor(Color.argb(i1, Color.red(i2), Color.green(i2), Color.blue(i2)));
        this.l.setBackgroundColor(Color.argb(i1, Color.red(i2), Color.green(i2), Color.blue(i2)));
        this.c.setTextColor(Color.argb(i1, Color.red(i3), Color.green(i3), Color.blue(i3)));
        this.c.setVisibility(0);
        if (i1 == 0)
        {
          this.i.setBackgroundColor(0);
          this.l.setBackgroundColor(0);
          this.c.setVisibility(8);
          return;
        }
        if (i1 == 255)
        {
          this.i.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
          this.l.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
          this.c.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167084));
        }
      }
    }
    else if (TextUtils.equals(paramString, "polymerization_header_hide_background"))
    {
      paramString = this.j;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.e;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131436275)
    {
      if ((!j().onBackEvent()) && (c() != null)) {
        c().finish();
      }
    }
    else if (i1 == 2131436571) {
      m();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationClipPart
 * JD-Core Version:    0.7.0.1
 */