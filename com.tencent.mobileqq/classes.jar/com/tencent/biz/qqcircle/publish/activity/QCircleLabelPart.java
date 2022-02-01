package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QQStoryMainActivity;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.publish.adapter.QCircleAssociateLabelAdapter;
import com.tencent.biz.qqcircle.publish.event.QCirclePublishAssociateTagEvent;
import com.tencent.biz.qqcircle.publish.event.QCirclePublishKeyboardEvent;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.biz.qqcircle.publish.viewmodel.QCircleLabelViewModel;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

public class QCircleLabelPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  TextWatcher a = new QCircleLabelPart.4(this);
  private QCirclePublishViewModel c;
  private QCircleLabelViewModel d;
  private LinearLayout e;
  private FrameLayout f;
  private RecyclerView g;
  private QCircleLabelPart.LabelAdapter h;
  private ExtendEditText i;
  private RelativeLayout j;
  private QCircleBlockContainer k;
  private ImageView l;
  private QCircleAssociateLabelAdapter m;
  private String n;
  private String o;
  private String p;
  private int q;
  private int r = -1;
  private String s = "^#[，a-z0-9A-Z一-龥]+$";
  private boolean t = false;
  
  private void a(UIStateData<List<FeedCloudMeta.StTagInfo>> paramUIStateData)
  {
    if (paramUIStateData.e() != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i1 = 0;
      while (i1 < ((List)paramUIStateData.e()).size())
      {
        if (!this.i.getText().toString().contains(((FeedCloudMeta.StTagInfo)((List)paramUIStateData.e()).get(i1)).tagName.get())) {
          localArrayList.add(((List)paramUIStateData.e()).get(i1));
        }
        i1 += 1;
      }
      if (!paramUIStateData.i()) {
        this.m.a(localArrayList);
      } else {
        this.m.b(localArrayList);
      }
      a(true, paramUIStateData.i(), paramUIStateData.h());
      p();
    }
  }
  
  private void b(View paramView)
  {
    this.j = ((RelativeLayout)paramView.findViewById(2131441891));
    this.l = ((ImageView)paramView.findViewById(2131441896));
    this.l.setOnClickListener(this);
    this.k = ((QCircleBlockContainer)paramView.findViewById(2131441716));
    this.k.setLayoutManagerType(1, 1);
    this.k.getBlockMerger().b(2);
    this.k.setEnableLoadMore(true);
    this.k.setEnableRefresh(false);
    this.k.setParentFragment(j());
    this.k.getRecyclerView().setNestedScrollingEnabled(true);
    paramView = new ArrayList();
    this.m = new QCircleAssociateLabelAdapter(null);
    paramView.add(this.m);
    this.m.setOnLoadDataDelegate(new QCircleLabelPart.1(this));
    this.k.a(paramView);
    this.m.a(this.k.getRecyclerView());
    this.k.getRecyclerView().addOnScrollListener(new QCircleLabelPart.2(this));
    this.k.g();
  }
  
  private void b(String paramString)
  {
    try
    {
      String str = this.i.getText().toString();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str, 0, this.q);
      localStringBuffer.append(paramString);
      localStringBuffer.append(" ");
      localStringBuffer.append(str.substring(this.i.getSelectionStart()));
      this.i.setText(localStringBuffer);
      this.i.setSelection(this.q + paramString.length() + 1);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[QcirclePublish]QCircleLabelPart", 1, paramString, new Object[0]);
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      Object localObject1 = this.i.getText().toString();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (bool)
      {
        localObject1 = this.i;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" ");
        ((ExtendEditText)localObject1).setText(((StringBuilder)localObject2).toString());
        this.i.setSelection(paramString.length() + 1);
        return;
      }
      if (((String)localObject1).contains(paramString)) {
        return;
      }
      int i1 = this.i.getSelectionStart();
      int i2 = this.i.getSelectionEnd();
      Object localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append((CharSequence)localObject1, 0, i1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      ((StringBuffer)localObject2).append(localStringBuilder.toString());
      ((StringBuffer)localObject2).append(((String)localObject1).substring(i2));
      this.i.setText((CharSequence)localObject2);
      this.i.setSelection(i1 + paramString.length() + 1);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[QcirclePublish]QCircleLabelPart", 1, paramString, new Object[0]);
    }
  }
  
  private void d(View paramView)
  {
    this.e = ((LinearLayout)paramView.findViewById(2131441715));
    this.e.setOnClickListener(this);
    this.f = ((FrameLayout)paramView.findViewById(2131441859));
    this.g = ((RecyclerView)paramView.findViewById(2131441860));
    paramView = new LinearLayoutManager(g());
    paramView.setOrientation(0);
    this.g.setLayoutManager(paramView);
    this.h = new QCircleLabelPart.LabelAdapter(this);
    this.g.setAdapter(this.h);
    this.h.a(new QCircleLabelPart.3(this));
  }
  
  private void d(String paramString)
  {
    try
    {
      String str = this.i.getText().toString();
      if (!TextUtils.isEmpty(str))
      {
        paramString = str.replaceAll(paramString, "");
        this.i.setText(paramString);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("[QcirclePublish]QCircleLabelPart", 1, paramString, new Object[0]);
    }
  }
  
  private void l()
  {
    if (!TextUtils.isEmpty(this.p))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestAssociateLable, mInputTag:");
        localStringBuilder.append(this.p);
        QLog.e("[QcirclePublish]QCircleLabelPart", 1, localStringBuilder.toString());
      }
      this.d.a(this.p, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("[QcirclePublish]QCircleLabelPart", 1, "requestAssociateLable, mInputTag is null");
    }
    this.d.a("");
  }
  
  private void m()
  {
    this.d.b().observe(j(), new QCircleLabelPart.5(this));
  }
  
  private void n()
  {
    this.d.d.observe(j(), new QCircleLabelPart.6(this));
    this.d.e.observe(j(), new QCircleLabelPart.7(this));
    this.d.b.observe(j(), new QCircleLabelPart.8(this));
    this.d.c.observe(j(), new QCircleLabelPart.9(this));
    if (this.c == null) {
      this.c = ((QCirclePublishViewModel)a(QCirclePublishViewModel.class));
    }
    this.c.b.observe(j(), new QCircleLabelPart.10(this));
    m();
  }
  
  private void o()
  {
    try
    {
      String str = this.i.getText().toString();
      boolean bool = TextUtils.isEmpty(str);
      if (bool)
      {
        this.q = 0;
        this.i.setText("#");
        this.i.setSelection(1);
      }
      else
      {
        int i1 = this.i.getSelectionStart();
        int i2 = this.i.getSelectionEnd();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str, 0, i1);
        localStringBuffer.append("#");
        localStringBuffer.append(str.substring(i2));
        this.q = i1;
        this.i.setText(localStringBuffer);
        this.i.setSelection(i1 + 1);
      }
      if (QCirclePublishViewModel.m()) {
        this.d.d();
      }
      SimpleEventBus.getInstance().dispatchEvent(new QCirclePublishKeyboardEvent(true));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[QcirclePublish]QCircleLabelPart", 1, localException, new Object[0]);
    }
  }
  
  private void p()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      if (((RelativeLayout)localObject).getVisibility() == 0) {
        return;
      }
      if (c().isFinishing()) {
        return;
      }
      this.j.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(g(), 2130772337);
      ((Animation)localObject).setDuration(200L);
      this.j.clearAnimation();
      this.j.startAnimation((Animation)localObject);
      this.c.b(true);
      QCirclePublishReport.a(15, 25, 0, "", "");
    }
  }
  
  private void q()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      if (((RelativeLayout)localObject).getVisibility() == 8) {
        return;
      }
      localObject = AnimationUtils.loadAnimation(g(), 2130772338);
      ((Animation)localObject).setDuration(200L);
      ((Animation)localObject).setAnimationListener(new QCircleLabelPart.11(this));
      this.j.clearAnimation();
      this.j.startAnimation((Animation)localObject);
      this.c.b(false);
    }
  }
  
  public int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramInt1 = this.i.getSelectionStart();
      if ((paramInt1 != 0) && (paramCharSequence != null))
      {
        if (paramCharSequence.length() == 0) {
          return -1;
        }
        if (paramCharSequence.toString().substring(0, paramInt1).contains("#"))
        {
          paramInt1 = paramCharSequence.toString().substring(0, paramInt1).lastIndexOf("#", paramInt1);
          return paramInt1;
        }
      }
      return -1;
    }
    catch (Exception paramCharSequence)
    {
      QLog.e("[QcirclePublish]QCircleLabelPart", 1, paramCharSequence, new Object[0]);
    }
    return -1;
  }
  
  public String a()
  {
    return "[QcirclePublish]QCircleLabelPart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    QLog.d("[QcirclePublish]QCircleLabelPart", 1, new Object[] { "onActivityResult... requestCode:", Integer.valueOf(paramInt1), " resultCode:", Integer.valueOf(paramInt2) });
    if (paramInt2 != -1) {
      return;
    }
    if ((QCircleHostConstants._QQStoryMainActivity.REQUEST_CODE_TAKE_VIDEO() == paramInt1) && (paramInt2 == -1) && (!paramIntent.getBooleanExtra("key_qcircle_pulish_use_draft", false))) {
      this.d.a(c(), paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    QLog.d("[QcirclePublish]QCircleLabelPart", 1, "onInitView...");
    if (this.d == null) {
      this.d = ((QCircleLabelViewModel)a(QCircleLabelViewModel.class));
    }
    this.i = ((ExtendEditText)paramView.findViewById(2131431344));
    if (QCirclePublishViewModel.m()) {
      this.i.addTextChangedListener(this.a);
    }
    b(paramView);
    d(paramView);
    n();
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.k != null) && (this.m.getBlockMerger() != null))
    {
      this.m.getLoadInfo().a(4);
      this.m.getLoadInfo().a(paramBoolean3);
      this.k.setRefreshing(false);
      this.m.getBlockMerger().a(false);
      this.m.getBlockMerger().b("");
      this.m.getBlockMerger().a(paramBoolean1, paramBoolean3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("iscuccess:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isfinish:");
      localStringBuilder.append(paramBoolean3);
      QLog.d("[QcirclePublish]QCircleLabelPart", 4, localStringBuilder.toString());
    }
  }
  
  public boolean a(String paramString)
  {
    return paramString.matches(this.s);
  }
  
  public boolean ah_()
  {
    RelativeLayout localRelativeLayout = this.j;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      q();
      return true;
    }
    return false;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePublishAssociateTagEvent.class);
    return localArrayList;
  }
  
  public void i()
  {
    this.c.c();
    this.d.e();
    this.t = true;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if ((this.f != null) && (this.t))
    {
      this.h.notifyDataSetChanged();
      this.f.setVisibility(8);
      this.t = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131441715)
    {
      o();
      QCirclePublishReport.a(15, 21, 0, "", "");
    }
    else if (i1 == 2131441896)
    {
      q();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePublishAssociateTagEvent))
    {
      b(((QCirclePublishAssociateTagEvent)paramSimpleBaseEvent).tag);
      q();
      QCirclePublishReport.a(15, 26, 0, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart
 * JD-Core Version:    0.7.0.1
 */