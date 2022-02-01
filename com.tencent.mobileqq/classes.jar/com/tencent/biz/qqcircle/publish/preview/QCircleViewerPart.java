package com.tencent.biz.qqcircle.publish.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePhotoPeviewerAdapter;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePhotoPeviewerAdapter.PhotoViewHolder;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper.PagerChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QCircleViewerPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver, QCirclePagerSnapHelper.PagerChangeListener
{
  private RecyclerView a;
  private RecyclerView.LayoutManager c;
  private QCirclePhotoPeviewerAdapter d;
  private QCirclePagerSnapHelper e;
  private TextView f;
  private TextView g;
  private ImageView h;
  private List<String> i;
  private int j = 0;
  
  private void i()
  {
    QCircleCustomDialog.a(g(), g().getResources().getString(2131895832), null, 2131887648, 2131888010, new QCircleViewerPart.1(this), new QCircleViewerPart.2(this)).show();
  }
  
  public String a()
  {
    return "[QcirclePublish]QCircleViewerPart";
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("[QcirclePublish]QCircleViewerPart", 1, "QCircleViewerPart... intent == null");
      c().finish();
      return;
    }
    this.i = paramIntent.getStringArrayListExtra("key_photo_previewer_list");
    this.j = paramIntent.getIntExtra("key_photo_previewer_cur_position", 0);
    paramIntent = this.i;
    if ((paramIntent != null) && (paramIntent.size() != 0))
    {
      QLog.d("[QcirclePublish]QCircleViewerPart", 1, new Object[] { "QCircleViewerPart... list:", this.i });
      return;
    }
    QLog.w("[QcirclePublish]QCircleViewerPart", 1, "QCircleViewerPart... mList == null || mList.size() == 0");
    c().finish();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.f = ((TextView)paramView.findViewById(2131441735));
    this.g = ((TextView)paramView.findViewById(2131441736));
    this.h = ((ImageView)paramView.findViewById(2131431689));
    this.f.setOnClickListener(this);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.f);
    }
    this.h.setOnClickListener(this);
    paramView.findViewById(2131441796).setVisibility(8);
    this.a = ((RecyclerView)paramView.findViewById(2131441818));
    this.a.setVisibility(0);
    this.c = new LinearLayoutManager(g(), 0, false);
    this.e = new QCirclePagerSnapHelper();
    this.d = new QCirclePhotoPeviewerAdapter((ArrayList)this.i, this.e);
    this.a.setLayoutManager(this.c);
    this.a.setAdapter(this.d);
    this.a.scrollToPosition(this.j);
    this.e.a(this);
    this.e.a(this.a);
    if (this.i != null)
    {
      paramView = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.j + 1);
      localStringBuilder.append("/");
      localStringBuilder.append(this.i.size());
      paramView.setText(localStringBuilder.toString());
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof QCirclePhotoPeviewerAdapter.PhotoViewHolder))
    {
      TextView localTextView = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      paramViewHolder = (QCirclePhotoPeviewerAdapter.PhotoViewHolder)paramViewHolder;
      localStringBuilder.append(paramViewHolder.b + 1);
      localStringBuilder.append("/");
      localStringBuilder.append(this.i.size());
      localTextView.setText(localStringBuilder.toString());
      this.j = paramViewHolder.b;
    }
  }
  
  public void b() {}
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441735) {
      c().finish();
    } else if (paramView.getId() == 2131431689) {
      i();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.QCircleViewerPart
 * JD-Core Version:    0.7.0.1
 */