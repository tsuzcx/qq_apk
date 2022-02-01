package com.tencent.mobileqq.activity.contacts.topentry;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MayKnowPersonEntryController
  extends CTEntryController
  implements Handler.Callback, View.OnClickListener, CTEntryListener
{
  protected MayknowRecommendsAdapter i;
  protected CTEntryMng j;
  protected boolean k = true;
  protected boolean l = false;
  protected final WeakReferenceHandler m = new WeakReferenceHandler(Looper.getMainLooper(), this);
  
  public MayKnowPersonEntryController(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void g()
  {
    if (this.b != null)
    {
      this.j = ((CTEntryMng)this.b.getManager(QQManagerFactory.CTENTRY_MNG));
      this.j.a(this);
      this.j.a(true);
    }
  }
  
  private void h()
  {
    CTEntryMng localCTEntryMng = this.j;
    if (localCTEntryMng != null) {
      localCTEntryMng.b(this);
    }
    this.j = null;
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, "onMayknowEntryClosed");
    }
    this.j.a();
    ContactReportUtils.a(this.b, "", "banner_recomlist_dlt");
  }
  
  public void a()
  {
    a(200L);
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshData  hasdata:");
      localStringBuilder.append(this.m.hasMessages(2));
      localStringBuilder.append(" mHasPaused:");
      localStringBuilder.append(this.l);
      QLog.i("CTEntryController", 2, localStringBuilder.toString());
    }
    if (this.l) {
      return;
    }
    if (this.m.hasMessages(2)) {
      return;
    }
    this.m.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.i = new MayknowRecommendsAdapter(b(), this.b, this.g, 1, true);
    this.g.setAdapter(this.i);
    this.f.setVisibility(0);
    this.e.setText(HardCodeUtil.a(2131904392));
    this.d.setOnClickListener(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.b != paramQQAppInterface)
    {
      this.b = paramQQAppInterface;
      MayknowRecommendsAdapter localMayknowRecommendsAdapter = this.i;
      if (localMayknowRecommendsAdapter != null) {
        localMayknowRecommendsAdapter.a(paramQQAppInterface);
      }
    }
    g();
    a(50L);
    paramQQAppInterface = this.j.a();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onResume");
    }
    this.k = false;
    if (this.l)
    {
      localObject = this.i;
      if (localObject != null) {
        ((MayknowRecommendsAdapter)localObject).notifyDataSetChanged();
      }
      a(500L);
      this.m.sendEmptyMessageDelayed(3, 500L);
    }
    else
    {
      a(0L);
      localObject = this.j.a();
      if (localObject != null) {
        ((CardViewController)localObject).b();
      }
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((MayknowRecommendsAdapter)localObject).d();
    }
    this.l = false;
  }
  
  public void c()
  {
    super.c();
    g();
  }
  
  public void c(boolean paramBoolean)
  {
    MayknowRecommendsAdapter localMayknowRecommendsAdapter = this.i;
    if (localMayknowRecommendsAdapter != null) {
      localMayknowRecommendsAdapter.a(paramBoolean);
    }
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onPause");
    }
    MayknowRecommendsAdapter localMayknowRecommendsAdapter = this.i;
    if (localMayknowRecommendsAdapter != null) {
      localMayknowRecommendsAdapter.b();
    }
    this.l = true;
  }
  
  public void d(boolean paramBoolean)
  {
    a(0L);
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onDestroy");
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
    }
    h();
    this.h = null;
    localObject = this.i;
    if (localObject != null) {
      ((MayknowRecommendsAdapter)localObject).a();
    }
  }
  
  public void f()
  {
    super.f();
    h();
    if (this.g != null) {
      this.g.setAdapter(null);
    }
    MayknowRecommendsAdapter localMayknowRecommendsAdapter = this.i;
    if (localMayknowRecommendsAdapter != null) {
      localMayknowRecommendsAdapter.a();
    }
    this.i = null;
    this.c.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int n = paramMessage.what;
    if (n != 1)
    {
      if (n != 2)
      {
        if (n != 3) {
          return false;
        }
        paramMessage = this.j;
        if (paramMessage != null)
        {
          paramMessage = paramMessage.a();
          if (paramMessage != null)
          {
            paramMessage.b();
            return false;
          }
        }
      }
      else
      {
        this.m.removeMessages(2);
        ThreadManager.excute(new MayKnowPersonEntryController.1(this), 16, null, true);
        return false;
      }
    }
    else
    {
      this.m.removeMessages(1);
      paramMessage = (List)paramMessage.obj;
      if (this.i == null)
      {
        this.i = new MayknowRecommendsAdapter(b(), this.b, this.g, 1, true);
        this.g.setAdapter(this.i);
      }
      int i1 = this.i.getCount();
      boolean bool3 = bV_();
      Object localObject1 = paramMessage.iterator();
      n = 0;
      boolean bool1 = false;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CTEntry)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((CTEntry)localObject2).a == 3) && (bool3))
        {
          boolean bool2 = ((CTEntry)localObject2).m;
          bool1 = bool2;
          if (!bool2)
          {
            bool1 = bool2;
            if ((((CTEntry)localObject2).n instanceof List))
            {
              localObject2 = (List)((CTEntry)localObject2).n;
              bool1 = bool2;
              if (((List)localObject2).size() > 0)
              {
                this.i.a((List)localObject2);
                n = ((List)localObject2).size();
                bool1 = bool2;
              }
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("MSG_UPDATE_ENTRY_LIST preCount:");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(" size:");
        ((StringBuilder)localObject1).append(n);
        ((StringBuilder)localObject1).append(" userClose:");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(" shouldShowRecommendEntry: ");
        ((StringBuilder)localObject1).append(bool3);
        QLog.d("CTEntryController", 2, ((StringBuilder)localObject1).toString());
      }
      if (n > 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.c.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = AIOUtils.b(n * 60 + 28 + 7.1F, this.c.getResources());
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.c.setVisibility(0);
        n = 1;
      }
      else
      {
        this.i.a(null);
        this.c.setVisibility(8);
        if ((i1 > 0) && (!bool1)) {
          i();
        }
        n = 0;
      }
      if (!this.k)
      {
        this.k = true;
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (CTEntry)paramMessage.next();
          ReportController.b(this.b, "dc00898", "", "", "0X800979E", "0X800979E", ((CTEntry)localObject1).a, 0, "", "", "", "");
        }
        if (n != 0) {
          ContactReportUtils.a(this.b, "", "banner_recomlist_exp");
        }
      }
      if (this.h != null) {
        this.h.a();
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131444461)
    {
      Intent localIntent = new Intent(this.a, RecommendFriendActivity.class);
      localIntent.putExtra("EntranceId", 8);
      Object localObject = this.j;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((CTEntryMng)localObject).a();
      }
      if (localObject != null)
      {
        localObject = ((CardViewController)localObject).c();
        if (!((ArrayList)localObject).isEmpty()) {
          localIntent.putExtra("may_know_recmmds", (Serializable)localObject);
        }
      }
      this.a.startActivity(localIntent);
      ContactReportUtils.a(this.b, "", "banner_recomlist_clk");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController
 * JD-Core Version:    0.7.0.1
 */