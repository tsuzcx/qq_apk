package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.widgets.AnimationView;
import com.tencent.biz.qqcircle.widgets.AnimationView.AnimationInfo;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.MultiDownloadResultListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePolyLikeAllDialog
  extends ReportDialog
{
  private RecyclerView a;
  private GridLayoutManager b;
  private QCirclePolyLikeAllDialog.GirdAdapter c;
  private View d;
  private View e;
  private List<QQCircleFeedBase.StPolyLike> f = new ArrayList();
  private FeedCloudMeta.StFeed g;
  private QCirclePolyRequestManager h;
  private QCircleReportBean i;
  private RFWMultiDownloadHelper j;
  private RFWMultiDownloadHelper.MultiDownloadResultListener k;
  private TextView l;
  private TextView m;
  
  public QCirclePolyLikeAllDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131953410);
    a();
    paramContext = getWindow();
    paramContext.setGravity(80);
    paramContext.setWindowAnimations(2131953021);
    WindowManager.LayoutParams localLayoutParams = paramContext.getAttributes();
    localLayoutParams.width = DisplayUtil.d();
    localLayoutParams.height = -2;
    paramContext.setAttributes(localLayoutParams);
    setCancelable(true);
    setCanceledOnTouchOutside(true);
  }
  
  private void a()
  {
    this.c = new QCirclePolyLikeAllDialog.GirdAdapter(this, null);
    this.d = LayoutInflater.from(getContext()).inflate(2131626912, null);
    this.e = this.d.findViewById(2131441775);
    this.b = new GridLayoutManager(getContext(), 4);
    this.a = ((RecyclerView)this.d.findViewById(2131441574));
    this.a.setAdapter(this.c);
    this.a.setLayoutManager(this.b);
    this.e.setLayoutParams(new FrameLayout.LayoutParams(DisplayUtil.d(), -2));
    this.m = ((TextView)this.d.findViewById(2131441774));
    this.l = ((TextView)this.d.findViewById(2131441772));
    this.l.setOnClickListener(new QCirclePolyLikeAllDialog.1(this));
    this.m.setText(String.valueOf(QCirclePolyLikeInfoManger.a().c()));
    setContentView(this.d);
  }
  
  private void a(List<QQCircleFeedBase.StPolyLike> paramList)
  {
    this.j = new RFWMultiDownloadHelper();
    paramList = paramList.iterator();
    int n = 0;
    while (paramList.hasNext())
    {
      QQCircleFeedBase.StPolyLike localStPolyLike = (QQCircleFeedBase.StPolyLike)paramList.next();
      this.j.addTask(new RFWMultiDownloadHelper.DownloadTask(localStPolyLike.polySource.get(), QCirclePluginConfig.e()));
      if (!QCirclePolyLikeInfoManger.a.containsKey(localStPolyLike.polySource.get())) {
        n = 1;
      }
    }
    if (n != 0)
    {
      this.k = new QCirclePolyLikeAllDialog.2(this);
      this.j.setListener(this.k);
      this.j.start();
      return;
    }
    b();
  }
  
  private void b()
  {
    this.a.post(new QCirclePolyLikeAllDialog.3(this));
  }
  
  public void a(QCirclePolyBaseLikeView paramQCirclePolyBaseLikeView)
  {
    if (QCirclePolyLikeInfoManger.a.containsKey(paramQCirclePolyBaseLikeView.getPolyLike().polySource.get()))
    {
      AnimationView.AnimationInfo localAnimationInfo = (AnimationView.AnimationInfo)QCirclePolyLikeInfoManger.a.get(paramQCirclePolyBaseLikeView.getPolyLike().polySource.get());
      paramQCirclePolyBaseLikeView.a.setImageDrawable(null);
      paramQCirclePolyBaseLikeView.a.setAnimationFromInfo(localAnimationInfo);
      paramQCirclePolyBaseLikeView.a.setVisibility(0);
      paramQCirclePolyBaseLikeView.b.setVisibility(8);
      paramQCirclePolyBaseLikeView.a.a();
      return;
    }
    paramQCirclePolyBaseLikeView.a.setImageDrawable(null);
    paramQCirclePolyBaseLikeView.b.setVisibility(0);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, List<QQCircleFeedBase.StPolyLike> paramList, QCirclePolyRequestManager paramQCirclePolyRequestManager, QCircleReportBean paramQCircleReportBean)
  {
    this.f.clear();
    this.f.addAll(paramList);
    this.c.notifyDataSetChanged();
    this.g = paramStFeed;
    this.i = paramQCircleReportBean;
    this.h = paramQCirclePolyRequestManager;
    a(paramList);
    show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAllDialog
 * JD-Core Version:    0.7.0.1
 */