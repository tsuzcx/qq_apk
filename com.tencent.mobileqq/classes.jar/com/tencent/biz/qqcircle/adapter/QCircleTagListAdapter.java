package com.tencent.biz.qqcircle.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCircleTagItemInfo;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StMedalInfo;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StTagMedalInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;

public class QCircleTagListAdapter
  extends RecyclerView.Adapter<QCircleTagListAdapter.TagViewHolder>
  implements ReportBean<QCircleReportBean>
{
  private List<QCircleTagItemInfo> a = new ArrayList();
  private QCircleReportBean b;
  private Context c;
  private FeedCloudMeta.StUser d;
  
  private void a(int paramInt, FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (b() != null)
    {
      if (b().getPageId() != 32) {
        return;
      }
      QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(13).setThrActionType(paramInt);
      if ((paramStTagInfo != null) && (paramStTagInfo.medal.rank.get() > 0L)) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      Object localObject = localDataBuilder.setExt2((String)localObject);
      if (paramStTagInfo != null) {
        paramStTagInfo = paramStTagInfo.tagName.get();
      } else {
        paramStTagInfo = "";
      }
      QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt3(paramStTagInfo).setPageId(c()));
    }
  }
  
  private void a(Context paramContext, FeedCloudMeta.StMedalInfo paramStMedalInfo)
  {
    if (paramStMedalInfo == null)
    {
      QLog.d("RANK-QCircleTagListAdapter", 1, "[handlerNewRankTagClick] info should not be null.");
      return;
    }
    if (paramStMedalInfo.type.get() == 5)
    {
      a(paramContext, paramStMedalInfo.medalID.get(), paramStMedalInfo.medalName.get());
      return;
    }
    a(paramStMedalInfo.jumpUrl.get());
  }
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      QLog.d("RANK-QCircleTagListAdapter", 1, "[handlerTagClickToSchema] context should not be null.");
      return;
    }
    QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
    FeedCloudMeta.StTagInfo localStTagInfo = new FeedCloudMeta.StTagInfo();
    localStTagInfo.tagId.set(paramString1);
    localStTagInfo.tagName.set(paramString2);
    localQCirclePolymerizationBean.setTagInfo(localStTagInfo);
    localQCirclePolymerizationBean.setPolymerizationType(7);
    QCircleLauncher.a(paramContext, localQCirclePolymerizationBean);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("RANK-QCircleTagListAdapter", 1, "[handlerTagClickToSchema] current jump url not is empty.");
      return;
    }
    QCircleLauncher.a(this.c, paramString, null, -1);
  }
  
  @NonNull
  public QCircleTagListAdapter.TagViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    this.c = paramViewGroup.getContext();
    if (paramInt == 2) {
      return new QCircleTagListAdapter.TagViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626967, paramViewGroup, false));
    }
    return new QCircleTagListAdapter.TagViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626968, paramViewGroup, false));
  }
  
  protected String a()
  {
    return "RANK-QCircleTagListAdapter";
  }
  
  public void a(@NonNull QCircleTagListAdapter.TagViewHolder paramTagViewHolder, int paramInt)
  {
    paramTagViewHolder.a((QCircleTagItemInfo)this.a.get(paramInt), paramInt);
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.b = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    this.d = paramStUser;
  }
  
  public void a(List<QCircleTagItemInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public QCircleReportBean b()
  {
    return QCircleReportBean.getReportBean(a(), this.b);
  }
  
  protected int c()
  {
    return QCircleReportBean.getPageId(a(), this.b);
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((List)localObject).size() <= paramInt) {
        return 1;
      }
      localObject = (QCircleTagItemInfo)this.a.get(paramInt);
      paramInt = ((QCircleTagItemInfo)localObject).a();
      int k = 0;
      if (paramInt == 2) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      int i;
      if (((QCircleTagItemInfo)localObject).a() == 3) {
        i = 1;
      } else {
        i = 0;
      }
      int j = k;
      if (((QCircleTagItemInfo)localObject).a() == 1)
      {
        j = k;
        if (((QCircleTagItemInfo)localObject).c().medal.rank.get() > 0L) {
          j = 1;
        }
      }
      if ((paramInt == 0) && (i == 0))
      {
        if (j != 0) {
          return 2;
        }
        return 1;
      }
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleTagListAdapter
 * JD-Core Version:    0.7.0.1
 */