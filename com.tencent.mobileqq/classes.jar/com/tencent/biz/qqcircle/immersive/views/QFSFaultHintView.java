package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;
import java.io.File;

public abstract class QFSFaultHintView<T>
  extends QCircleBaseWidgetView<T>
{
  private static RFWMultiDownloadHelper f = new RFWMultiDownloadHelper();
  protected View a;
  protected View b;
  protected ImageView c;
  protected TextView d;
  protected TextView e;
  private RFWDownloader.RFWDownloadListener g;
  
  static
  {
    f.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleConfigHelper.bd(), QCircleDownloadConfig.a()));
    f.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleConfigHelper.be(), QCircleDownloadConfig.a()));
    f.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleConfigHelper.bf(), QCircleDownloadConfig.a()));
    f.start();
  }
  
  public QFSFaultHintView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QFSFaultHintView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
  
  protected String a(String paramString)
  {
    return RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).getDefaultSavePath(paramString);
  }
  
  protected void a() {}
  
  protected void a(ImageView paramImageView, String paramString)
  {
    String str = a(paramString);
    if (RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).isFileDownLoading(paramString)) {
      return;
    }
    if (new File(str).exists())
    {
      b(paramImageView, str);
      return;
    }
    this.g = new QFSFaultHintView.1(this, paramImageView);
    RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).download(paramString, this.g);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Drawable paramDrawable)
  {
    if (c()) {
      return;
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.d.setText(str);
    this.e.setText(paramString1);
    a(this.c, paramString3);
    this.c.setImageDrawable(paramDrawable);
    setVisible(true);
  }
  
  protected void b(ImageView paramImageView, String paramString)
  {
    if (paramImageView != null)
    {
      paramImageView.setVisibility(0);
      getMainHandler().post(new QFSFaultHintView.2(this, paramImageView, paramString));
    }
  }
  
  protected void bindData(T paramT, int paramInt) {}
  
  protected boolean c()
  {
    if (HostNetworkUtils.isNetworkAvailable()) {
      return false;
    }
    String str = a(getNoNetHintImgUrl());
    if (new File(str).exists()) {
      b(this.c, str);
    }
    this.d.setText(getNoNetHintTitle());
    this.e.setText(getNoNetHintMsg());
    return true;
  }
  
  public void d()
  {
    setVisible(false);
  }
  
  public int getLayoutId()
  {
    return 2131627119;
  }
  
  protected abstract String getNoNetHintImgUrl();
  
  protected abstract String getNoNetHintMsg();
  
  protected abstract String getNoNetHintTitle();
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = paramView.findViewById(2131433287);
    this.b = paramView.findViewById(2131437473);
    this.c = ((ImageView)paramView.findViewById(2131436413));
    this.e = ((TextView)paramView.findViewById(2131448526));
    this.d = ((TextView)paramView.findViewById(2131448527));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView
 * JD-Core Version:    0.7.0.1
 */