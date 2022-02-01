package com.dataline.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.WaitTextView;
import com.dataline.util.widget.WaitTextView.RefreshListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiteMutiPicViewerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, WaitTextView.RefreshListener
{
  private DataLineMsgSet a;
  private GridView b;
  private LiteMutiPicViewerActivity.GridAdapter c;
  private WaitTextView d;
  private RelativeLayout e;
  private TextView f;
  private TextView g;
  private ProgressBar h;
  private Button i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private DataLineObserver o = new LiteMutiPicViewerActivity.2(this);
  
  private int a(Activity paramActivity)
  {
    return paramActivity.getWindowManager().getDefaultDisplay().getWidth();
  }
  
  private void b()
  {
    this.b = ((GridView)findViewById(2131440243));
    this.e = ((RelativeLayout)findViewById(2131435385));
    this.f = ((TextView)findViewById(2131435386));
    this.g = ((TextView)findViewById(2131435387));
    this.g.setTextColor(getResources().getColor(2131167993));
    this.h = ((ProgressBar)findViewById(2131435380));
    this.i = ((Button)findViewById(2131435369));
    this.f.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.d = new WaitTextView(this);
    this.d.setRefreshListener(this);
    this.d.setGravity(17);
    this.d.setTextColor(getResources().getColor(2131168125));
    this.d.setTextSize(1, 16.0F);
    this.d.setPadding(0, 0, 0, AIOUtils.b(50.0F, getResources()));
    Object localObject = new AbsListView.LayoutParams(a(this), -2);
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setNumColumns(3);
    this.b.setColumnWidth(this.j);
    this.b.setVerticalSpacing(this.m * 2);
    this.b.setHorizontalSpacing(this.l * 2);
    localObject = this.b;
    ((GridView)localObject).setPadding(this.n, ((GridView)localObject).getPaddingTop(), this.n, this.b.getPaddingBottom());
    this.b.setSelector(new ColorDrawable(0));
    this.c = new LiteMutiPicViewerActivity.GridAdapter(this, null);
    this.b.setAdapter(this.c);
    c();
  }
  
  private void c()
  {
    if ((this.a.isCanReciveOrResend()) && (!this.a.hasSendingOrRecving()))
    {
      this.e.setVisibility(0);
      this.f.setVisibility(0);
      this.g.setVisibility(4);
      this.h.setVisibility(4);
      this.i.setVisibility(4);
      if (this.a.isSendFromLocal()) {
        this.f.setText(2131889805);
      } else {
        this.f.setText(2131889804);
      }
    }
    else if (this.a.hasSendingOrRecving())
    {
      this.e.setVisibility(0);
      this.f.setVisibility(4);
      this.g.setVisibility(0);
      this.h.setVisibility(0);
      this.i.setVisibility(0);
      d();
    }
    else
    {
      this.e.setVisibility(8);
    }
    this.c.notifyDataSetChanged();
  }
  
  private void d()
  {
    this.h.setProgress((int)(this.a.getTotalProcess() * 100.0F));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(this.a.getCompletedCount());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(this.a.getTotalCount());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    int i1;
    if (this.a.isSendFromLocal()) {
      i1 = 2131889819;
    } else {
      i1 = 2131889778;
    }
    localStringBuilder.append(getString(i1));
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    this.g.setText((CharSequence)localObject);
  }
  
  private void e()
  {
    setTitle(2131891298);
    this.rightViewImg.setVisibility(4);
    this.rightViewText.setVisibility(4);
  }
  
  private void f()
  {
    Display localDisplay = ((WindowManager)getSystemService("window")).getDefaultDisplay();
    this.n = getResources().getDimensionPixelSize(2131298138);
    this.l = getResources().getDimensionPixelSize(2131298140);
    this.m = getResources().getDimensionPixelSize(2131298141);
    this.j = ((localDisplay.getWidth() - this.n * 2 - this.l * 2) / 3);
    this.k = this.j;
  }
  
  private void g()
  {
    this.d.setText(String.format(getString(2131891317), new Object[] { Integer.valueOf(this.a.getTotalCount()) }));
  }
  
  public void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((DataLineMsgSet)localObject).isTimeOut()))
    {
      localObject = this.c;
      if (localObject != null) {
        ((LiteMutiPicViewerActivity.GridAdapter)localObject).notifyDataSetChanged();
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131627030);
    int i1 = getIntent().getIntExtra("dataline_group_id", -1);
    this.a = this.app.getDataLineMsgProxy(0).a(i1);
    if (this.a == null) {
      this.a = this.app.getDataLineMsgProxy(1).a(i1);
    }
    if (this.a == null)
    {
      QLog.e("IphoneTitleBarActivity", 1, "LiteMutiPicViewerActivity mSet is null, so finish");
      finish();
    }
    addObserver(this.o);
    f();
    b();
    e();
    g();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.o;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    if (this.app.getFileManagerProxy() != null) {
      this.app.getFileManagerProxy().e();
    }
    localObject = this.d;
    if (localObject != null) {
      ((WaitTextView)localObject).b();
    }
  }
  
  public void onClick(View paramView)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    int i1 = paramView.getId();
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (i1 != 2131435369)
    {
      if (i1 == 2131435386) {
        if (NetworkUtil.isNetSupport(this))
        {
          FileManagerUtil.a(this.a.isSendFromLocal(), this, new LiteMutiPicViewerActivity.1(this, localDataLineHandler));
          this.a.setPaused(false);
          if ((this.a.getGroupType() == -2000) && (!this.a.isSingle())) {
            DataLineReportUtil.p(this.app);
          }
          Iterator localIterator = this.a.values().iterator();
          localObject2 = null;
          localObject1 = null;
          while (localIterator.hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
            localObject3 = DatalineFilesAdapter.a(localDataLineMsgRecord);
            if (((DLFileInfo)localObject3).b == 1)
            {
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject3 = new ArrayList();
              }
              ((ArrayList)localObject3).add(localDataLineMsgRecord);
              localObject2 = localObject3;
            }
            else if ((((DLFileInfo)localObject3).b == 4) || (((DLFileInfo)localObject3).b == 2))
            {
              if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
                if (DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
                  DataLineReportUtil.d(this.app);
                } else {
                  DataLineReportUtil.e(this.app);
                }
              }
              localObject3 = localObject1;
              if (localObject1 == null) {
                localObject3 = new ArrayList();
              }
              ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
              i1 = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
              localDataLineMsgRecord.fileMsgStatus = 0L;
              this.app.getMessageFacade().d(i1).f(localDataLineMsgRecord.msgId);
              localObject1 = localObject3;
            }
          }
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
            localDataLineHandler.a((ArrayList)localObject2, true);
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
            localDataLineHandler.b((List)localObject1);
          }
          c();
        }
        else
        {
          FMToastUtil.a(2131892157);
        }
      }
    }
    else
    {
      this.a.setPaused(true);
      if ((this.a.getGroupType() == -2000) && (!this.a.isSingle())) {
        DataLineReportUtil.o(this.app);
      }
      if ((this.a.getGroupType() == -2335) && (!this.a.isReportPause))
      {
        localObject1 = this.a;
        ((DataLineMsgSet)localObject1).isReportPause = true;
        if (!((DataLineMsgSet)localObject1).isSingle()) {
          DataLineReportUtil.m(this.app);
        } else {
          DataLineReportUtil.k(this.app);
        }
      }
      if ((!this.a.isSingle()) && (this.a.getGroupType() != -2335))
      {
        localDataLineHandler.a(this.a.getGroupId(), 0L, false);
      }
      else
      {
        localObject1 = this.a.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DataLineMsgRecord)((Iterator)localObject1).next();
          localObject3 = DatalineFilesAdapter.a((DataLineMsgRecord)localObject2);
          if ((((DLFileInfo)localObject3).b == 0) || (((DLFileInfo)localObject3).b == 3)) {
            localDataLineHandler.a(((DataLineMsgRecord)localObject2).groupId, ((DataLineMsgRecord)localObject2).sessionid, false);
          }
        }
      }
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteMutiPicViewerActivity
 * JD-Core Version:    0.7.0.1
 */