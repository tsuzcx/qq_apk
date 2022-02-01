package com.tencent.mobileqq.activity.aio.zhitu;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class ZhituPanelView$ZhituViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public RelativeLayout a;
  public BubbleImageView b;
  public ProgressBar c;
  public RadioButton d;
  public WeakReference<ZhituPicData> e;
  
  public ZhituPanelView$ZhituViewHolder(ZhituPanelView paramZhituPanelView, View paramView)
  {
    super(paramView);
    this.a = ((RelativeLayout)paramView);
    this.b = ((BubbleImageView)paramView.findViewById(2131444781));
    this.b.c(false);
    this.b.setRadius(5.0F);
    this.b.c = false;
    this.c = ((ProgressBar)paramView.findViewById(2131444782));
    paramView.setOnClickListener(this);
    this.d = ((RadioButton)paramView.findViewById(2131444783));
    this.d.setOnCheckedChangeListener(this);
    if (paramZhituPanelView.getZhituUIStyle() == 1)
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((this.f.getZhituUIStyle() != 1) && (paramBoolean)) {
      onClick(paramCompoundButton);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (ZhituPicData)this.e.get();
    if ((localObject != null) && (((ZhituPicData)localObject).a != null) && (((ZhituPicData)localObject).l != null) && (ZhituPanelView.a(this.f).a != null)) {
      if (this.f.getZhituUIStyle() == 1)
      {
        ZhituPanelView.a(this.f, (ZhituPicData)localObject);
        localObject = ZhituManager.a(this.f.b.d);
        if ((localObject != null) && (((ZhituManager)localObject).c != null))
        {
          ((ZhituManager)localObject).c.b();
          ReportController.b(this.f.b.d, "dc00898", "", "", "0X800ACA1", "0X800ACA1", this.f.b.ah.a, 0, "", "", "", "");
        }
      }
      else if (ZhituPanelView.b(this.f) != localObject)
      {
        Iterator localIterator = ZhituPanelView.a(this.f).a.iterator();
        while (localIterator.hasNext()) {
          ((ZhituPicData)localIterator.next()).p = false;
        }
        ((ZhituPicData)localObject).p = true;
        ZhituPanelView.c(this.f).setVisibility(0);
        ZhituPanelView.c(this.f).setEnabled(true);
        if (!((ZhituPicData)localObject).k)
        {
          ZhituPanelView.a(this.f, (ZhituPicData)localObject);
          ZhituPanelView.a(this.f).notifyDataSetChanged();
        }
        else
        {
          ZhituManager.a(this.f.b.d).e((ZhituPicData)localObject);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituViewHolder
 * JD-Core Version:    0.7.0.1
 */