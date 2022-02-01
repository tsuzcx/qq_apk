package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import java.io.File;

public class QCircleStatusView
  extends QCircleBaseWidgetView
  implements View.OnClickListener, IStatusViewProvider
{
  private static RFWMultiDownloadHelper g = new RFWMultiDownloadHelper();
  protected LinearLayout a;
  protected ImageView b;
  protected TextView c;
  protected TextView d;
  protected LinearLayout e;
  protected LinearLayout f;
  private RFWDownloader.RFWDownloadListener h;
  private View.OnClickListener i;
  private boolean j = false;
  private QCircleReportBean k;
  
  static
  {
    g.addTask(new RFWMultiDownloadHelper.DownloadTask("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_fullscreen_disconnect.png", QCirclePluginConfig.e()));
    g.start();
  }
  
  public QCircleStatusView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  private void b()
  {
    if (this.b != null)
    {
      TextView localTextView = this.c;
      if (localTextView == null) {
        return;
      }
      localTextView.setText(QCircleConfigHelper.U());
      this.b.setImageDrawable(getContext().getResources().getDrawable(2130845168));
      this.c.setTextColor(-1);
    }
  }
  
  private void f()
  {
    setClickable(true);
    c();
  }
  
  private void setVisible(boolean paramBoolean)
  {
    if ((!paramBoolean) && (getVisibility() == 0)) {
      setVisibility(8);
    }
    if ((paramBoolean) && (getVisibility() == 8)) {
      setVisibility(0);
    }
  }
  
  public void a()
  {
    b(null);
    e();
  }
  
  protected void a(View paramView)
  {
    View.OnClickListener localOnClickListener = this.i;
    if (localOnClickListener == null) {
      return;
    }
    localOnClickListener.onClick(paramView);
  }
  
  protected void a(ImageView paramImageView, String paramString)
  {
    String str = d(paramString);
    if (RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).isFileDownLoading(paramString)) {
      return;
    }
    if (new File(str).exists())
    {
      b(paramImageView, str);
      return;
    }
    this.h = new QCircleStatusView.1(this, paramImageView);
    RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).download(paramString, this.h);
  }
  
  public void a(String paramString) {}
  
  protected void b(ImageView paramImageView, String paramString)
  {
    if (paramImageView != null)
    {
      paramImageView.setVisibility(0);
      getMainHandler().post(new QCircleStatusView.2(this, paramImageView, paramString));
    }
  }
  
  public void b(String paramString)
  {
    if ((HostNetworkUtils.isNetworkAvailable() ^ true))
    {
      paramString = d(QCircleSkinHelper.getInstance().getUrl("img_emptystate_disconnect"));
      if (new File(paramString).exists())
      {
        this.f.setVisibility(8);
        this.c.setVisibility(0);
        this.c.setText(QCircleConfigHelper.U());
        if (this.j) {
          b();
        } else {
          b(this.b, paramString);
        }
      }
      else if (this.j)
      {
        this.f.setVisibility(8);
        this.c.setVisibility(0);
        this.b.setVisibility(0);
        b();
      }
      else
      {
        this.c.setVisibility(8);
        this.b.setVisibility(8);
        this.f.setVisibility(0);
      }
    }
    else
    {
      this.f.setVisibility(8);
      a(this.b, QCircleSkinHelper.getInstance().getUrl("img_emptystate_disconnect"));
      this.c.setVisibility(0);
      if (!TextUtils.isEmpty(paramString)) {
        this.c.setText(paramString);
      } else {
        this.c.setText(QCircleConfigHelper.V());
      }
    }
    d();
    setVisible(true);
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public void c()
  {
    setVisible(false);
  }
  
  public void c(String paramString)
  {
    b(paramString);
    e();
  }
  
  protected String d(String paramString)
  {
    return RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).getDefaultSavePath(paramString);
  }
  
  protected void d()
  {
    this.d.setText(getContext().getString(2131895702));
    this.d.setVisibility(0);
    this.e.setVisibility(0);
  }
  
  protected void e()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    localMarginLayoutParams.topMargin = (-ImmersiveUtils.a(30.0F));
    setLayoutParams(localMarginLayoutParams);
  }
  
  public void e(String paramString) {}
  
  public int getLayoutId()
  {
    return 2131626801;
  }
  
  protected String getLogTag()
  {
    return "QCircleStatusView";
  }
  
  protected int getPageId()
  {
    return QCircleReportBean.getPageId(getLogTag(), this.k);
  }
  
  public QCircleReportBean getReportBean()
  {
    return QCircleReportBean.getReportBean(getLogTag(), this.k);
  }
  
  public View getStatusView()
  {
    return this;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437401) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((LinearLayout)paramView.findViewById(2131445015));
    this.b = ((ImageView)paramView.findViewById(2131436489));
    this.c = ((TextView)paramView.findViewById(2131436491));
    this.e = ((LinearLayout)paramView.findViewById(2131437401));
    this.d = ((TextView)paramView.findViewById(2131448252));
    this.f = ((LinearLayout)paramView.findViewById(2131437490));
    this.e.setOnClickListener(this);
  }
  
  public void setForceBlackStyle(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setOnRetryClickListener(View.OnClickListener paramOnClickListener)
  {
    this.i = paramOnClickListener;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleStatusView
 * JD-Core Version:    0.7.0.1
 */