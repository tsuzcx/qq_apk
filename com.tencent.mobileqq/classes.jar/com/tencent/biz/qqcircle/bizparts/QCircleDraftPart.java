package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView;
import com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView.OnItemSelectedListener;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.event.QCircleClosePageEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.api.IDataManager;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.mobileqq.winkpublish.event.DraftDataChangeEvent;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QCircleDraftPart
  extends QCircleBasePart
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, QCircleDraftRecyclerView.OnItemSelectedListener, SimpleEventReceiver
{
  boolean a = true;
  View.OnClickListener c = new QCircleDraftPart.1(this);
  private QCircleDraftRecyclerView d;
  private ImageView e;
  private TextView f;
  private Group g;
  private TextView h;
  private CheckBox i;
  private Button j;
  private TextView k;
  private boolean l = false;
  
  private void b(View paramView)
  {
    this.e = ((ImageView)paramView.findViewById(2131436355));
    this.e.setOnClickListener(this);
    this.f = ((TextView)paramView.findViewById(2131429870));
    this.g = ((Group)paramView.findViewById(2131441616));
    this.l = false;
    this.f.setText("选择");
    this.f.setOnClickListener(this);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.h;
    int n = 0;
    int m;
    if (localObject != null)
    {
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      ((TextView)localObject).setVisibility(m);
    }
    localObject = this.i;
    if (localObject != null)
    {
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      ((CheckBox)localObject).setVisibility(m);
    }
    localObject = this.j;
    if (localObject != null)
    {
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      ((Button)localObject).setVisibility(m);
    }
    localObject = this.k;
    if (localObject != null)
    {
      if (paramBoolean) {
        m = n;
      } else {
        m = 8;
      }
      ((TextView)localObject).setVisibility(m);
    }
  }
  
  private void d(View paramView)
  {
    this.h = ((TextView)paramView.findViewById(2131448405));
    this.i = ((CheckBox)paramView.findViewById(2131430408));
    this.j = ((Button)paramView.findViewById(2131429869));
    this.k = ((TextView)paramView.findViewById(2131448401));
    this.i.setOnCheckedChangeListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  private void l()
  {
    this.d.a(m());
  }
  
  private List<DraftBean> m()
  {
    Object localObject1 = ((IDataManager)QRoute.api(IDataManager.class)).getDatas(HostDataTransUtils.getLongAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QCircleDraftPart", 1, new Object[] { "getValidData draftBeans.size: ", Integer.valueOf(((List)localObject1).size()) });
    }
    Object localObject2 = ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).getTaskList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        IQueueTask localIQueueTask = (IQueueTask)((Iterator)localObject2).next();
        if (QLog.isColorLevel()) {
          QLog.d("QCircleDraftPart", 1, new Object[] { "getDraftData taskList task.missionId: ", localIQueueTask.getMissionId(), ", task.state: ", Integer.valueOf(localIQueueTask.getState()) });
        }
        if ((localIQueueTask.getState() == 1) || (localIQueueTask.getState() == 0) || (localIQueueTask.getState() == 6)) {
          localArrayList2.add(localIQueueTask.getMissionId());
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DraftBean)((Iterator)localObject1).next();
      if (!localArrayList2.contains(((DraftBean)localObject2).getMissionId())) {
        localArrayList1.add(localObject2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleDraftPart", 1, new Object[] { "getValidData validDataList.size: ", Integer.valueOf(localArrayList1.size()) });
    }
    Collections.sort(localArrayList1);
    return localArrayList1;
  }
  
  private void n()
  {
    CheckBox localCheckBox = this.i;
    if (localCheckBox != null) {
      localCheckBox.setChecked(localCheckBox.isChecked() ^ true);
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleDraftPart", 1, new Object[] { "handleSelectBtn isSelected: ", Boolean.valueOf(this.l) });
    }
    this.l ^= true;
    TextView localTextView = this.f;
    if (this.l) {
      localObject = "取消";
    } else {
      localObject = "选择";
    }
    localTextView.setText((CharSequence)localObject);
    this.d.a(this.l);
    Object localObject = this.g;
    int m;
    if (this.l) {
      m = 0;
    } else {
      m = 8;
    }
    ((Group)localObject).setVisibility(m);
    b(this.l);
    if (!this.l)
    {
      this.d.c();
      this.i.setChecked(false);
    }
  }
  
  public Context a(Context paramContext)
  {
    Context localContext = paramContext;
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      localContext = paramContext;
      if ((localActivity.getBaseContext() instanceof ContextWrapper)) {
        localContext = localActivity.getBaseContext();
      }
    }
    return localContext;
  }
  
  public String a()
  {
    return "QCircleDraftPart";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleDraftPart", 1, new Object[] { "itemSelected selectCount: ", Integer.valueOf(paramInt1), " totalCount:", Integer.valueOf(paramInt2) });
    }
    this.a = false;
    Object localObject = this.i;
    boolean bool;
    if (localObject != null)
    {
      if (paramInt1 == paramInt2) {
        bool = true;
      } else {
        bool = false;
      }
      ((CheckBox)localObject).setChecked(bool);
    }
    localObject = this.j;
    if (localObject != null)
    {
      if (paramInt1 > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((Button)localObject).setEnabled(bool);
      if (paramInt1 > 0)
      {
        localObject = this.j;
        ((Button)localObject).setText(((Button)localObject).getResources().getString(2131895691, new Object[] { Integer.valueOf(paramInt1) }));
      }
      else
      {
        localObject = this.j;
        ((Button)localObject).setText(((Button)localObject).getResources().getString(2131895785));
      }
    }
    this.a = true;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.d = new QCircleDraftRecyclerView();
    this.d.a(paramView);
    this.d.a(this);
    this.d.a(this.c);
    b(paramView);
    d(paramView);
    l();
  }
  
  public void a(String paramString)
  {
    paramString = new QCircleDraftPart.2(this, paramString);
    paramString = QCircleCustomDialog.a(g(), null, HardCodeUtil.a(2131895693), 2131887648, 2131895785, paramString, paramString);
    if ((c() != null) && (!c().isFinishing())) {
      paramString.show();
    }
  }
  
  public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(DraftDataChangeEvent.class);
    localArrayList.add(QCircleClosePageEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    super.h();
    c().overridePendingTransition(2130772504, 2130772505);
    QCircleDraftRecyclerView localQCircleDraftRecyclerView = this.d;
    if (localQCircleDraftRecyclerView != null) {
      localQCircleDraftRecyclerView.d();
    }
  }
  
  public void i()
  {
    Object localObject = new QCircleDraftPart.3(this);
    localObject = QCircleCustomDialog.a(g(), null, HardCodeUtil.a(2131895692), 2131887648, 2131895785, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((c() != null) && (!c().isFinishing())) {
      ((QCircleCustomDialog)localObject).show();
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.getId() == 2131430408) && (this.a)) {
      if (paramBoolean) {
        this.d.b();
      } else {
        this.d.c();
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436355) {
      c().finish();
    } else if (paramView.getId() == 2131429870) {
      o();
    } else if (paramView.getId() == 2131429869) {
      i();
    } else if (paramView.getId() == 2131448401) {
      n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (paramSimpleBaseEvent == null) {
      return;
    }
    if ((paramSimpleBaseEvent instanceof DraftDataChangeEvent)) {
      return;
    }
    if (((paramSimpleBaseEvent instanceof QCircleClosePageEvent)) && (c() != null)) {
      c().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleDraftPart
 * JD-Core Version:    0.7.0.1
 */