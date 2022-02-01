package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.io.File;

public class QCircleNearbyTabStatusView
  extends QCircleStatusView
{
  private View.OnClickListener g;
  private MutableLiveData<Integer> h = null;
  
  public QCircleNearbyTabStatusView(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public QCircleNearbyTabStatusView(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  private void f()
  {
    d();
    this.e.setOnClickListener(new QCircleNearbyTabStatusView.1(this));
  }
  
  private void g()
  {
    this.h = new MutableLiveData();
  }
  
  public void a()
  {
    b();
    e();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.f.setVisibility(8);
    a(this.b, QCircleSkinHelper.getInstance().getUrl("img_emptystate_privacy"));
    this.c.setVisibility(0);
    this.c.setText(QCircleConfigHelper.Y());
    this.e.setVisibility(0);
    this.d.setText(QCircleConfigHelper.Z());
    this.e.setOnClickListener(paramOnClickListener);
    setVisibility(0);
    paramOnClickListener = this.h;
    if (paramOnClickListener != null) {
      paramOnClickListener.postValue(Integer.valueOf(1));
    }
  }
  
  public void b()
  {
    this.f.setVisibility(8);
    a(this.b, QCircleSkinHelper.getInstance().getUrl("img_emptystate_feed"));
    this.c.setVisibility(0);
    this.c.setText(QCircleConfigHelper.W());
    this.e.setVisibility(0);
    this.d.setText(QCircleConfigHelper.X());
    this.e.setOnClickListener(new QCircleNearbyTabStatusView.2(this));
    setVisibility(0);
    MutableLiveData localMutableLiveData = this.h;
    if (localMutableLiveData != null) {
      localMutableLiveData.postValue(Integer.valueOf(2));
    }
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.f.setVisibility(8);
    a(this.b, QCircleSkinHelper.getInstance().getUrl("img_emptystate_privacy"));
    this.c.setVisibility(0);
    this.c.setText(QCircleConfigHelper.aa());
    this.e.setVisibility(0);
    this.d.setText(QCircleConfigHelper.ab());
    this.e.setOnClickListener(paramOnClickListener);
    setVisibility(0);
    paramOnClickListener = this.h;
    if (paramOnClickListener != null) {
      paramOnClickListener.postValue(Integer.valueOf(1));
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
        b(this.b, paramString);
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
    setVisibility(0);
    f();
    paramString = this.h;
    if (paramString != null) {
      paramString.postValue(Integer.valueOf(3));
    }
  }
  
  protected String getLogTag()
  {
    return "QCircleNearbyTabStatusView";
  }
  
  public MutableLiveData<Integer> getTabStatusObserver()
  {
    return this.h;
  }
  
  public void setEmptyClickListener(View.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleNearbyTabStatusView
 * JD-Core Version:    0.7.0.1
 */