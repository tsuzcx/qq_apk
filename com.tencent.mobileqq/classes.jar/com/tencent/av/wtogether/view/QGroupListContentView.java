package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter;
import com.tencent.av.wtogether.callback.GroupClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class QGroupListContentView
  extends QBaseContentView
{
  protected QGroupExpandableListAdapter d;
  protected SwipPinnedHeaderExpandableListView e;
  protected GroupClickListener f;
  private AutomatorObserver g = new QGroupListContentView.2(this);
  
  public QGroupListContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QGroupListContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QGroupListContentView(Context paramContext, GroupClickListener paramGroupClickListener)
  {
    super(paramContext);
    this.f = paramGroupClickListener;
  }
  
  private void e()
  {
    if (this.e != null)
    {
      QGroupExpandableListAdapter localQGroupExpandableListAdapter = this.d;
      if (localQGroupExpandableListAdapter != null) {
        localQGroupExpandableListAdapter.b();
      }
      this.d = new QGroupExpandableListAdapter(this.a, (QQAppInterface)this.b, this.e, this.f);
      this.e.setAdapter(this.d);
      this.e.setOnGroupClickListener(this.d);
    }
  }
  
  public void a()
  {
    this.e = new SwipPinnedHeaderExpandableListView(this.a);
    this.e.setId(2131441547);
    this.e.setSelector(2131168376);
    this.e.setNeedCheckSpringback(true);
    this.e.setGroupIndicator(null);
    this.e.setDivider(null);
    this.e.setPadding(0, 0, 0, AIOUtils.b(54.0F, getResources()));
    this.e.setClipToPadding(false);
    this.e.setScrollBarStyle(33554432);
    SwipPinnedHeaderExpandableListView localSwipPinnedHeaderExpandableListView = this.e;
    localSwipPinnedHeaderExpandableListView.mForContacts = true;
    localSwipPinnedHeaderExpandableListView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.e);
    ReportController.b(null, "dc00898", "", "", "0X800B623", "0X800B623", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    this.b.removeObserver(this.g);
    QGroupExpandableListAdapter localQGroupExpandableListAdapter = this.d;
    if (localQGroupExpandableListAdapter != null) {
      localQGroupExpandableListAdapter.b();
    }
  }
  
  public void c()
  {
    this.b.addObserver(this.g);
    if (this.d == null) {
      e();
    }
    this.e.postDelayed(new QGroupListContentView.1(this), 200L);
  }
  
  public void d()
  {
    this.b.removeObserver(this.g);
  }
  
  public ListView getScrollableView()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QGroupListContentView
 * JD-Core Version:    0.7.0.1
 */