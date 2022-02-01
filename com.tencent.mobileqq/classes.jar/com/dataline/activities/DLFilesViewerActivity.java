package com.dataline.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;
import com.dataline.util.DatalineFilesAdapter;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.Observable;
import java.util.Observer;

public class DLFilesViewerActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static String a = "DLFilesViewerActivity";
  private XListView b;
  private DataLineMsgSet c = null;
  private DatalineFilesAdapter d = null;
  private DataLineObserver e = new DLFilesViewerActivity.2(this);
  
  private void a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void b()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.c.getFirstItem();
    if ((this.c.getGroupType() == -2335) && (localDataLineMsgRecord.bIsApkFile)) {
      setTitle(2131891271);
    } else {
      setTitle(2131891296);
    }
    this.leftView.setVisibility(0);
    this.leftView.setText(getString(2131891354));
    a();
    this.rightViewText.setOnClickListener(new DLFilesViewerActivity.1(this));
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
    int i = getIntent().getIntExtra("dl_files_groupid", 0);
    this.c = this.app.getProxyManager().a(0).a(i);
    if (this.c == null) {
      this.c = this.app.getProxyManager().a(1).a(i);
    }
    if (this.c == null)
    {
      finish();
      return false;
    }
    getWindow().setBackgroundDrawableResource(2131165716);
    setContentView(2131624642);
    getWindow().setBackgroundDrawable(null);
    b();
    findViewById(2131433144);
    this.b = ((XListView)findViewById(2131433143));
    this.b.setStackFromBottom(true);
    this.d = new DatalineFilesAdapter(this, this.c, this, this.app);
    this.b.setAdapter(this.d);
    paramBundle = LayoutInflater.from(getActivity()).inflate(2131624523, null);
    this.b.setOverscrollHeader(getActivity().getResources().getDrawable(2130846237));
    this.b.setOverScrollHeader(paramBundle);
    addObserver(this.e);
    paramBundle = this.app.getMessageFacade();
    if (paramBundle != null) {
      paramBundle.addObserver(this);
    }
    this.b.setSelection(this.c.getTotalCount() - 1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    DataLineObserver localDataLineObserver = this.e;
    if (localDataLineObserver != null) {
      removeObserver(localDataLineObserver);
    }
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.d.notifyDataSetChanged();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof DataLineMsgRecord))
    {
      this.d.notifyDataSetChanged();
      a();
      return;
    }
    if ((paramObject instanceof Message))
    {
      if (((Message)paramObject).frienduin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN)))
      {
        this.d.notifyDataSetChanged();
        a();
      }
    }
    else if (((paramObject instanceof RecentUser)) && (((RecentUser)paramObject).uin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))))
    {
      this.d.notifyDataSetChanged();
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.DLFilesViewerActivity
 * JD-Core Version:    0.7.0.1
 */