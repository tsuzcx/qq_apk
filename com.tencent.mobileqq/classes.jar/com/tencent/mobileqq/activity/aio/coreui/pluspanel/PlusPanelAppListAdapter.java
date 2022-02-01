package com.tencent.mobileqq.activity.aio.coreui.pluspanel;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class PlusPanelAppListAdapter
  extends RecyclerView.Adapter<PlusPanelAppListAdapter.ViewHolder>
{
  private QQAppInterface a;
  private View.OnClickListener b;
  private View.OnLongClickListener c;
  private List<PluginData> d = new ArrayList();
  private boolean e;
  private boolean f;
  
  public PlusPanelAppListAdapter(QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.a = paramQQAppInterface;
    this.b = paramOnClickListener;
    this.c = paramOnLongClickListener;
  }
  
  private BusinessInfoCheckUpdate.AppInfo a(PluginData paramPluginData)
  {
    return ((IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "")).getAppInfoFilterByID(10, String.valueOf(paramPluginData.f), paramPluginData.i);
  }
  
  private void a(TextView paramTextView)
  {
    Context localContext = paramTextView.getContext();
    if (this.e) {
      paramTextView.setTextColor(localContext.getResources().getColor(2131166240));
    }
  }
  
  private void a(@NonNull PlusPanelAppListAdapter.ViewHolder paramViewHolder, PluginData paramPluginData)
  {
    View localView = paramViewHolder.itemView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPluginData.d);
    localStringBuilder.append(HardCodeUtil.a(2131905689));
    localView.setContentDescription(localStringBuilder.toString());
    paramViewHolder.itemView.setOnClickListener(this.b);
    paramViewHolder.itemView.setOnLongClickListener(this.c);
    paramViewHolder.itemView.setEnabled(true);
    paramViewHolder.itemView.setTag(paramPluginData);
    AccessibilityUtil.a(paramViewHolder.itemView, true);
    if (!TextUtils.isEmpty(paramPluginData.j))
    {
      VideoReport.setElementId(paramViewHolder.itemView, paramPluginData.j);
      VideoReport.setElementReuseIdentifier(paramViewHolder.itemView, paramPluginData.j);
      VideoReport.setElementClickPolicy(paramViewHolder.itemView, ClickPolicy.REPORT_ALL);
      VideoReport.setElementExposePolicy(paramViewHolder.itemView, ExposurePolicy.REPORT_ALL);
      return;
    }
    VideoReport.setElementClickPolicy(paramViewHolder.itemView, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(paramViewHolder.itemView, ExposurePolicy.REPORT_NONE);
  }
  
  private void b(@NonNull PlusPanelAppListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    int i;
    if ((!QQTheme.isNowSimpleUI()) && (!this.f))
    {
      int j = XPanelContainer.a;
      int k = XPanelContainer.b;
      if (paramInt <= 3) {
        i = 3;
      } else {
        i = 6;
      }
      i = (j - k) / i;
    }
    else
    {
      i = (int)(XPanelContainer.getSpaceHeight() * 66.0F / 296.0F) - ViewUtils.dip2px(10.0F);
    }
    paramViewHolder.itemView.setPadding(0, i, 0, 0);
    QLog.d("PlusPanelAppListAdapter", 1, new Object[] { "handleItemPadding -> position : ", Integer.valueOf(paramInt), ", XPanelContainer.mExternalPanelheight : ", Integer.valueOf(XPanelContainer.a), ", XPanelContainer.mDefaultExternalPanelheight : ", Integer.valueOf(XPanelContainer.b), ", topPadding : ", Integer.valueOf(i), ", XPanelContainer.mAddedHeight -> ", Integer.valueOf(XPanelContainer.d) });
  }
  
  private void b(@NonNull PlusPanelAppListAdapter.ViewHolder paramViewHolder, PluginData paramPluginData)
  {
    PlusPanelAppListAdapter.ViewHolder.b(paramViewHolder).setVisibility(0);
    PlusPanelAppListAdapter.ViewHolder.b(paramViewHolder).setBackgroundDrawable(paramPluginData.k);
    if ((paramPluginData.k instanceof URLDrawable))
    {
      paramViewHolder = (URLDrawable)paramPluginData.k;
      if (paramViewHolder.getStatus() == 2) {
        paramViewHolder.restartDownload();
      }
    }
  }
  
  private void c(@NonNull PlusPanelAppListAdapter.ViewHolder paramViewHolder, PluginData paramPluginData)
  {
    RedTouch localRedTouch = PlusPanelAppListAdapter.ViewHolder.c(paramViewHolder);
    int i = 0;
    localRedTouch.setVisibility(0);
    PlusPanelAppListAdapter.ViewHolder.c(paramViewHolder).g();
    if (!TextUtils.isEmpty(paramPluginData.f))
    {
      PlusPanelAppListAdapter.ViewHolder.d(paramViewHolder).setVisibility(8);
      paramPluginData = a(paramPluginData);
      if (paramPluginData != null) {
        PlusPanelAppListAdapter.ViewHolder.c(paramViewHolder).a(paramPluginData);
      }
    }
    else
    {
      paramViewHolder = PlusPanelAppListAdapter.ViewHolder.d(paramViewHolder);
      if (!paramPluginData.c) {
        i = 8;
      }
      paramViewHolder.setVisibility(i);
    }
  }
  
  @NonNull
  public PlusPanelAppListAdapter.ViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624462, null);
    int i = ViewUtils.dpToPx(15.0F);
    int j = (XPanelContainer.b - i) / 2;
    int k = XPanelContainer.a - XPanelContainer.b;
    if ((!QQTheme.isNowSimpleUI()) && (!this.f)) {
      paramInt = k / 2 + j;
    } else {
      paramInt = ViewUtils.dip2px(46.5F) + (int)(XPanelContainer.getSpaceHeight() * 88.0F / 296.0F);
    }
    QLog.d("PlusPanelAppListAdapter", 1, new Object[] { "onCreateViewHolder -> radioBtnHeight: ", Integer.valueOf(i), ", perHeight : ", Integer.valueOf(j), ", addedHeight : ", Integer.valueOf(k), ", actualHeight: ", Integer.valueOf(paramInt), ", XPanelContainer.mDefaultExternalPanelheight: ", Integer.valueOf(XPanelContainer.b), ", XPanelContainer.mExternalPanelheight: ", Integer.valueOf(XPanelContainer.a), ", XPanelContainer.mAddedHeight -> ", Integer.valueOf(XPanelContainer.d) });
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, paramInt));
    return new PlusPanelAppListAdapter.ViewHolder(paramViewGroup);
  }
  
  public void a(@NonNull PlusPanelAppListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    PluginData localPluginData = (PluginData)this.d.get(paramInt);
    b(paramViewHolder, paramInt);
    b(paramViewHolder, localPluginData);
    c(paramViewHolder, localPluginData);
    PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder).setText(localPluginData.d);
    if (this.f) {
      PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder).setTextColor(-16777216);
    }
    a(PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder));
    if ((!SimpleModeHelper.b()) && (!this.f))
    {
      PlusPanelAppListAdapter.ViewHolder.b(paramViewHolder).setImageDrawable(BaseApplication.getContext().getResources().getDrawable(2130839233));
      SimpleModeHelper.c(paramViewHolder.itemView);
    }
    else
    {
      SimpleModeHelper.a(PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder), PlusPanelAppListAdapter.ViewHolder.b(paramViewHolder), PlusPanelAppListAdapter.ViewHolder.c(paramViewHolder), true);
      SimpleModeHelper.b(paramViewHolder.itemView);
    }
    AccessibilityUtil.a(PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder), false);
    a(paramViewHolder, localPluginData);
  }
  
  public void a(List<PluginData> paramList)
  {
    this.d = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public int getItemCount()
  {
    List localList = this.d;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanelAppListAdapter
 * JD-Core Version:    0.7.0.1
 */