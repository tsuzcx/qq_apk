package com.tencent.biz.qqcircle.publish.outbox;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.publish.outbox.widget.PercentProgressBar;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.biz.qqcircle.publish.task.QCircleQueueTaskInfo;
import com.tencent.biz.qqcircle.publish.view.widget.MotionViewSetter;
import com.tencent.biz.qqcircle.publish.view.widget.ShaderAnimLayout;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.io.File;
import java.util.List;

class QCirclePublishQueuePart$UploadingListAdapter
  extends BaseAdapter
{
  private Context b;
  private LayoutInflater c;
  private String d = "";
  private MotionViewSetter e = null;
  private View.OnClickListener f = null;
  private View.OnClickListener g = null;
  private View.OnLongClickListener h = null;
  
  public QCirclePublishQueuePart$UploadingListAdapter(QCirclePublishQueuePart paramQCirclePublishQueuePart, Context paramContext)
  {
    this.b = paramContext;
    this.c = LayoutInflater.from(this.b);
  }
  
  private void a(QCirclePublishQueuePart.ViewHolder paramViewHolder, IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    Object localObject2 = "";
    paramViewHolder.f.setVisibility(4);
    paramViewHolder.d.setVisibility(8);
    QCircleQueueTaskInfo localQCircleQueueTaskInfo = paramIQueueTask.m();
    Object localObject1 = localObject2;
    if (localQCircleQueueTaskInfo != null)
    {
      paramViewHolder.e.setClickable(false);
      paramViewHolder.e.setClickable(false);
      paramViewHolder.e.setLongClickable(false);
      paramViewHolder.e.setText(localQCircleQueueTaskInfo.a);
      paramViewHolder.e.setMaxLines(1);
      if ((localQCircleQueueTaskInfo.c != 0) && (localQCircleQueueTaskInfo.c != 4) && (localQCircleQueueTaskInfo.c != 1) && (localQCircleQueueTaskInfo.c != 6))
      {
        if (localQCircleQueueTaskInfo.c == 3) {
          paramViewHolder.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
          paramViewHolder.g.setCompoundDrawablesWithIntrinsicBounds(2130845196, 0, 0, 0);
        }
        paramViewHolder.j.setVisibility(4);
      }
      else
      {
        if (localQCircleQueueTaskInfo.f > 0)
        {
          paramViewHolder.j.setProgress(localQCircleQueueTaskInfo.f);
          paramViewHolder.j.setVisibility(0);
        }
        else
        {
          paramViewHolder.j.setVisibility(4);
        }
        paramViewHolder.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      paramViewHolder.g.setText(localQCircleQueueTaskInfo.b);
      if (localQCircleQueueTaskInfo.g) {
        paramViewHolder.k.setVisibility(0);
      } else {
        paramViewHolder.k.setVisibility(8);
      }
      if (localQCircleQueueTaskInfo.i) {
        paramViewHolder.d.setVisibility(0);
      } else {
        paramViewHolder.d.setVisibility(8);
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(localQCircleQueueTaskInfo.h))
      {
        File localFile = new File(localQCircleQueueTaskInfo.h);
        localObject1 = localObject2;
        if (localFile.exists())
        {
          localObject1 = localObject2;
          if (!localFile.isDirectory()) {
            localObject1 = localQCircleQueueTaskInfo.h;
          }
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramIQueueTask.s();
      }
      if (localQCircleQueueTaskInfo.j > 0)
      {
        paramViewHolder.f.setText(String.valueOf(localQCircleQueueTaskInfo.j));
        paramViewHolder.f.setVisibility(0);
        localObject1 = localObject2;
      }
      else
      {
        paramViewHolder.f.setVisibility(8);
        localObject1 = localObject2;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramIQueueTask = paramViewHolder.c.getContext().getResources().getDrawable(2130842420);
      paramViewHolder = new Option().setLoadingDrawable(paramIQueueTask).setFailDrawable(paramIQueueTask).setRequestWidth(ViewUtils.a(50.0F)).setRequestHeight(ViewUtils.a(50.0F)).setTargetView(paramViewHolder.c).setUrl((String)localObject1);
      QCircleFeedPicLoader.g().loadImage(paramViewHolder, null);
      return;
    }
    paramViewHolder.c.setImageResource(2130845214);
  }
  
  public IQueueTask a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < QCirclePublishQueuePart.d(this.a).size())) {
      return (IQueueTask)QCirclePublishQueuePart.d(this.a).get(paramInt);
    }
    return null;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.f = paramOnClickListener;
  }
  
  public void a(MotionViewSetter paramMotionViewSetter)
  {
    this.e = paramMotionViewSetter;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
  }
  
  public int getCount()
  {
    return QCirclePublishQueuePart.d(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.c.inflate(2131626932, null);
      localObject1 = new QCirclePublishQueuePart.ViewHolder();
      ((QCirclePublishQueuePart.ViewHolder)localObject1).a = ((RelativeLayout)paramView.findViewById(2131436154));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).b = ((LinearLayout)paramView.findViewById(2131446332));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).e = ((QCircleAsyncTextView)paramView.findViewById(2131440850));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).e.setPadding(0, 0, ViewUtils.a(16.0F), 0);
      localObject2 = (LinearLayout.LayoutParams)((QCirclePublishQueuePart.ViewHolder)localObject1).e.getLayoutParams();
      if (localObject2 != null) {
        ((LinearLayout.LayoutParams)localObject2).rightMargin = 0;
      }
      ((QCirclePublishQueuePart.ViewHolder)localObject1).f = ((TextView)paramView.findViewById(2131437096));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).c = ((URLImageView)paramView.findViewById(2131449193));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).d = ((ImageView)paramView.findViewById(2131444113));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).j = ((PercentProgressBar)paramView.findViewById(2131449177));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).g = ((TextView)paramView.findViewById(2131444605));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).h = ((ShaderAnimLayout)paramView.findViewById(2131445741));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).i = ((Button)paramView.findViewById(2131431684));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).k = ((ProgressBar)paramView.findViewById(2131434802));
      paramView.setTag(2131446821, localObject1);
    }
    else
    {
      localObject1 = (QCirclePublishQueuePart.ViewHolder)paramView.getTag(2131446821);
    }
    Object localObject2 = a(paramInt);
    Object localObject3 = QCirclePublishQueuePart.a(this.a, (IQueueTask)localObject2, paramInt);
    a((QCirclePublishQueuePart.ViewHolder)localObject1, (IQueueTask)localObject2);
    String str = this.d;
    if ((str != null) && (str.equals(localObject3)))
    {
      ((QCirclePublishQueuePart.ViewHolder)localObject1).h.b();
      localObject3 = this.e;
      if (localObject3 != null) {
        ((MotionViewSetter)localObject3).setMotionView(paramView, paramInt);
      }
      ((QCirclePublishQueuePart.ViewHolder)localObject1).i.setOnClickListener(this.f);
      ((QCirclePublishQueuePart.ViewHolder)localObject1).i.setTag(Integer.valueOf(paramInt));
      ((QCirclePublishQueuePart.ViewHolder)localObject1).b.setVisibility(4);
    }
    else
    {
      ((QCirclePublishQueuePart.ViewHolder)localObject1).h.c();
      ((QCirclePublishQueuePart.ViewHolder)localObject1).i.setOnClickListener(null);
      ((QCirclePublishQueuePart.ViewHolder)localObject1).i.setTag(null);
      ((QCirclePublishQueuePart.ViewHolder)localObject1).b.setVisibility(0);
    }
    paramView.setTag(localObject2);
    paramView.setOnClickListener(this.g);
    Object localObject1 = this.h;
    if (localObject1 != null) {
      paramView.setOnLongClickListener((View.OnLongClickListener)localObject1);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueuePart.UploadingListAdapter
 * JD-Core Version:    0.7.0.1
 */