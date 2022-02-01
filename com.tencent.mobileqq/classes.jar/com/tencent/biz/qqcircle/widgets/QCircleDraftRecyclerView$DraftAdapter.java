package com.tencent.biz.qqcircle.widgets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.TimeUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qcircle.api.event.QCircleClosePageEvent;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class QCircleDraftRecyclerView$DraftAdapter
  extends RecyclerView.Adapter<QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder>
{
  public static final int a = ImmersiveUtils.b() / 3;
  public List<DraftBean> b = new ArrayList();
  private int c = 0;
  private QCircleDraftRecyclerView.OnItemSelectedListener d;
  private View.OnClickListener e;
  private boolean f = true;
  
  private void b(List<String> paramList)
  {
    RFThreadManager.execute(new QCircleDraftRecyclerView.DraftAdapter.3(this, paramList));
  }
  
  public QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626794, paramViewGroup, false));
  }
  
  public void a()
  {
    Iterator localIterator = this.b.iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
    {
      DraftBean localDraftBean = (DraftBean)localIterator.next();
      if (localDraftBean.isSelected())
      {
        localIterator.remove();
        localArrayList.add(localDraftBean.getMissionId());
      }
    }
    int i;
    if (this.c < localArrayList.size()) {
      i = 0;
    } else {
      i = this.c - localArrayList.size();
    }
    this.c = i;
    notifyDataSetChanged();
    if (this.b.size() == 0) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleClosePageEvent());
    }
    b(localArrayList);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.e = paramOnClickListener;
  }
  
  public void a(View paramView)
  {
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    Object localObject2 = this.b.iterator();
    Object localObject1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    String str = localSimpleDateFormat.format(new Date());
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (DraftBean)((Iterator)localObject2).next();
      if (((DraftBean)localObject3).isSelected())
      {
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append(localSimpleDateFormat.format(Long.valueOf(((DraftBean)localObject3).getCreateTime())));
        localStringBuilder3.append(",");
        ((StringBuilder)localObject1).append(localStringBuilder3.toString());
        localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append(((DraftBean)localObject3).getMissionId());
        localStringBuilder3.append(",");
        localStringBuilder2.append(localStringBuilder3.toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(",");
        localStringBuilder1.append(((StringBuilder)localObject3).toString());
      }
    }
    int i = ((StringBuilder)localObject1).length();
    localObject2 = "";
    if (i > 0) {
      localObject1 = ((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1);
    } else {
      localObject1 = "";
    }
    localMap.put("xsj_drafts_create_time", localObject1);
    if (localStringBuilder2.length() > 0) {
      localObject1 = localStringBuilder2.substring(0, localStringBuilder2.length() - 1);
    } else {
      localObject1 = "";
    }
    localMap.put("xsj_drafts_id", localObject1);
    localObject1 = localObject2;
    if (localStringBuilder1.length() > 0) {
      localObject1 = localStringBuilder1.substring(0, localStringBuilder1.length() - 1);
    }
    localMap.put("xsj_drafts_delete_time", localObject1);
    localMap.put("xsj_eid", "em_xsj_delete_button");
    VideoReport.setElementId(paramView, "em_xsj_delete_button");
    VideoReport.reportEvent("ev_xsj_camera_action", paramView, localMap);
  }
  
  public void a(@NonNull QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder paramDraftViewHolder, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onBindViewHolder draftViewHolder: ");
      ((StringBuilder)localObject1).append(paramDraftViewHolder);
      QLog.d("QCircleDraftRecyclerView", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (DraftBean)this.b.get(paramInt);
    QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.a(paramDraftViewHolder, QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.a(paramDraftViewHolder), ((DraftBean)localObject1).getCoverUrl());
    QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.a(paramDraftViewHolder).setTag(localObject1);
    Object localObject2 = QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.b(paramDraftViewHolder);
    int i = ((DraftBean)localObject1).getMediaType();
    int j = 0;
    if (i == 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject2).setVisibility(i);
    if (this.f)
    {
      QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.a(paramDraftViewHolder).setOnClickListener(this.e);
      a(QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.a(paramDraftViewHolder), (DraftBean)localObject1, paramInt);
    }
    else
    {
      QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.a(paramDraftViewHolder).setOnClickListener(new QCircleDraftRecyclerView.DraftAdapter.1(this, paramDraftViewHolder, (DraftBean)localObject1));
    }
    QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.d(paramDraftViewHolder).setText(TimeUtils.a(((DraftBean)localObject1).getCreateTime(), "·"));
    QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.c(paramDraftViewHolder).setTag(Integer.valueOf(paramInt));
    localObject2 = QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.c(paramDraftViewHolder);
    if (((DraftBean)localObject1).isCanSelect()) {
      paramInt = j;
    } else {
      paramInt = 8;
    }
    ((CheckBox)localObject2).setVisibility(paramInt);
    QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.c(paramDraftViewHolder).setChecked(((DraftBean)localObject1).isSelected());
    QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.c(paramDraftViewHolder).setOnCheckedChangeListener(new QCircleDraftRecyclerView.DraftAdapter.2(this, (DraftBean)localObject1));
  }
  
  public void a(QCircleDraftRecyclerView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.d = paramOnItemSelectedListener;
  }
  
  public void a(URLImageView paramURLImageView, DraftBean paramDraftBean, int paramInt)
  {
    VideoReport.setElementId(paramURLImageView, "em_xsj_drafts");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.put("xsj_drafts_create_time", new SimpleDateFormat("yyyy/MM/dd").format(Long.valueOf(paramDraftBean.getCreateTime())));
    localMap.put("xsj_drafts_id", paramDraftBean.getMissionId());
    localMap.put("xsj_drafts_delete_time", "");
    localMap.put("dt_pgstp", Integer.valueOf(paramInt));
    localMap.put("dt_ref_pgid", "pg_xsj_publish_draftbox_page");
    VideoReport.setElementParams(paramURLImageView, localMap);
    VideoReport.setElementClickPolicy(paramURLImageView, ClickPolicy.REPORT_ALL);
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
    {
      DraftBean localDraftBean = (DraftBean)localIterator.next();
      if (localDraftBean.getMissionId().equals(paramString))
      {
        localIterator.remove();
        localArrayList.add(localDraftBean.getMissionId());
      }
    }
    notifyDataSetChanged();
    b(localArrayList);
  }
  
  public void a(List<DraftBean> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((DraftBean)localIterator.next()).setCanSelect(paramBoolean);
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      DraftBean localDraftBean = (DraftBean)localIterator.next();
      if (!localDraftBean.isSelected())
      {
        localDraftBean.setSelected(true);
        i = 1;
      }
    }
    if (i != 0) {
      notifyDataSetChanged();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      DraftBean localDraftBean = (DraftBean)localIterator.next();
      if (localDraftBean.isSelected())
      {
        i = 1;
        localDraftBean.setSelected(false);
      }
    }
    if (i != 0) {
      notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    List localList = this.b;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView.DraftAdapter
 * JD-Core Version:    0.7.0.1
 */