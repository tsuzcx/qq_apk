package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleTagListAdapter;
import com.tencent.biz.qqcircle.beans.QCircleTagItemInfo;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.manager.QCircleRankListManager.UserMedalBean;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StExternalMedalWallInfo;
import feedcloud.FeedCloudMeta.StMedalInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QFSRankTagListView
  extends QCircleBaseWidgetView<QFSPersonalInfo>
  implements View.OnClickListener
{
  private RecyclerView a;
  private QCircleTagListAdapter b;
  private ImageView c;
  private TextView d;
  private View e;
  private View f;
  private String g;
  private QFSRankTagListView.OnQFSRankTagListActionListener h;
  
  public QFSRankTagListView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QFSRankTagListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QFSRankTagListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    a(this.c, false);
    a(this.g);
  }
  
  private void a(Context paramContext)
  {
    if (this.a == null)
    {
      QLog.d("RANK-QCircleRankTagListView", 1, "[initializeRecyclerParam] rank tag recycler view should not be null.");
      return;
    }
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.a.setLayoutManager(paramContext);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null)
    {
      QLog.d("RANK-QCircleRankTagListView", 1, "[setViewVisible] view should not be null.");
      return;
    }
    int i = 0;
    QLog.d("RANK-QCircleRankTagListView", 1, new Object[] { "[setViewVisible] view: ", paramView.toString(), " | isVisible: ", Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      i = 8;
    }
    if (paramView.getVisibility() != i) {
      paramView.setVisibility(i);
    }
  }
  
  private void a(String paramString)
  {
    QFSRankTagListView.OnQFSRankTagListActionListener localOnQFSRankTagListActionListener = this.h;
    if (localOnQFSRankTagListActionListener == null)
    {
      QLog.w("RANK-QCircleRankTagListView", 1, "[handlerRankTagSwitchClick] rank tag list action listener should not be null.");
      return;
    }
    localOnQFSRankTagListActionListener.a(paramString);
  }
  
  private void a(List<FeedCloudMeta.StMedalInfo> paramList, boolean paramBoolean)
  {
    if (this.b == null)
    {
      QLog.d("RANK-QCircleRankTagListView", 1, "[updateRecyclerSource] recycler adapter should not be null.");
      return;
    }
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    QLog.d("RANK-QCircleRankTagListView", 1, new Object[] { "[updateRecyclerSource] medal source size: ", Integer.valueOf(i) });
    if (i == 0)
    {
      a(paramBoolean);
      return;
    }
    if (paramBoolean) {
      b(true);
    } else {
      c(true);
    }
    paramList = b(paramList);
    this.b.a(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(false);
      b();
      return;
    }
    c(false);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, List<FeedCloudMeta.StMedalInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramBoolean1) {
        a(this.c, paramBoolean2);
      }
      a(paramList, paramBoolean1);
      return;
    }
    QLog.w("RANK-QCircleRankTagListView", 1, "[updateRankListDisplay] medal source not is empty.");
  }
  
  private List<QCircleTagItemInfo> b(List<FeedCloudMeta.StMedalInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      QLog.d("RANK-QCircleRankTagListView", 1, "[convertTagItemInfoList] medal source should not be null.");
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new QCircleTagItemInfo(3, (FeedCloudMeta.StMedalInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  private void b()
  {
    if (this.d == null)
    {
      QLog.d("RANK-QCircleRankTagListView", 1, "[updateRankPromptText] prompt view should not be null.");
      return;
    }
    String str = QCircleConfigHelper.a("qqcircle", "qcircle_person_rank_list_empty_text", "晒出你的榜单成就");
    this.d.setText(str);
  }
  
  private void b(boolean paramBoolean)
  {
    a(this, true);
    a(this.f, true);
    a(this.a, paramBoolean);
    a(this.e, paramBoolean);
    a(this.d, paramBoolean ^ true);
  }
  
  private List<FeedCloudMeta.StMedalInfo> c(List<QCircleRankListManager.UserMedalBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QCircleRankListManager.UserMedalBean localUserMedalBean = (QCircleRankListManager.UserMedalBean)paramList.next();
        FeedCloudMeta.StMedalInfo localStMedalInfo = new FeedCloudMeta.StMedalInfo();
        localStMedalInfo.type.set(localUserMedalBean.type);
        localStMedalInfo.jumpUrl.set(localUserMedalBean.jumpUrl);
        localStMedalInfo.iconUrl.set(localUserMedalBean.iconUrl);
        localStMedalInfo.medalName.set(localUserMedalBean.medalName);
        localStMedalInfo.backgroundUrl.set(localUserMedalBean.backgroundUrl);
        localStMedalInfo.describe.set(localUserMedalBean.describe);
        localStMedalInfo.isHighLight.set(localUserMedalBean.isHighLight);
        localStMedalInfo.isNew.set(localUserMedalBean.isNew);
        localStMedalInfo.medalID.set(localUserMedalBean.medalID);
        localStMedalInfo.rank.set(localUserMedalBean.rank);
        localArrayList.add(localStMedalInfo);
      }
      return localArrayList;
    }
    QLog.d("RANK-QCircleRankTagListView", 1, "[convertMedalInfoList] list not is empty.");
    return null;
  }
  
  private void c()
  {
    if (this.a == null)
    {
      QLog.w("RANK-QCircleRankTagListView", 1, "[initializeRecyclerAdapter] rank tag recycler view should not be null.");
      return;
    }
    this.b = new QCircleTagListAdapter();
    this.a.setAdapter(this.b);
  }
  
  private void c(boolean paramBoolean)
  {
    a(this, paramBoolean);
    a(this.a, paramBoolean);
    a(this.f, paramBoolean);
    a(this.e, false);
    a(this.d, false);
  }
  
  private void d()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = this.d;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(this);
    }
    localObject = this.e;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
  }
  
  protected void a(QFSPersonalInfo paramQFSPersonalInfo, int paramInt)
  {
    if ((paramQFSPersonalInfo != null) && (paramQFSPersonalInfo.F != null))
    {
      this.g = paramQFSPersonalInfo.F.medalWallJumpUrl.get();
      boolean bool = QCirclePluginUtil.d(paramQFSPersonalInfo.c);
      List localList = paramQFSPersonalInfo.F.medalInfos.get();
      if ((localList != null) && (!localList.isEmpty()))
      {
        a(bool, paramQFSPersonalInfo.F.needRedPoint.get(), localList);
        return;
      }
      a(bool);
      return;
    }
    QLog.d("RANK-QCircleRankTagListView", 1, "[bindData] medal wall should not be null.");
  }
  
  public void a(List<QCircleRankListManager.UserMedalBean> paramList)
  {
    if (paramList == null)
    {
      QLog.d("RANK-QCircleRankTagListView", 1, "[updateRankListSource] rank bean list should not be empty.");
      return;
    }
    a(c(paramList), true);
  }
  
  public int getLayoutId()
  {
    return 2131626948;
  }
  
  protected String getLogTag()
  {
    return "RANK-QCircleRankTagListView";
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == null) {
      i = 0;
    } else {
      i = paramView.getId();
    }
    if ((i != 0) && ((i == 2131441847) || (i == 2131441892) || (i == 2131441846))) {
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (paramView == null)
    {
      QLog.d("RANK-QCircleRankTagListView", 1, "[onInitView] root view should not be null.");
      return;
    }
    this.a = ((RecyclerView)paramView.findViewById(2131441897));
    this.c = ((ImageView)paramView.findViewById(2131441845));
    this.f = paramView.findViewById(2131441847);
    this.e = paramView.findViewById(2131441846);
    this.d = ((TextView)paramView.findViewById(2131441892));
    d();
    a(paramContext);
    c();
  }
  
  public void setOnQFSRankTagListActionListener(QFSRankTagListView.OnQFSRankTagListActionListener paramOnQFSRankTagListActionListener)
  {
    this.h = paramOnQFSRankTagListActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSRankTagListView
 * JD-Core Version:    0.7.0.1
 */