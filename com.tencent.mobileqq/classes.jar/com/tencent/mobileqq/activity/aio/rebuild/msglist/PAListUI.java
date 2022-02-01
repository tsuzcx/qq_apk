package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.imcore.message.PublicAccountRefresher;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.rebuild.PAContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class PAListUI
  extends ListUI
{
  public boolean a = false;
  private View k;
  private TextView l;
  private TextView m;
  private ImageView n;
  private ProgressBar o;
  
  public PAListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a()
  {
    this.k = LayoutInflater.from(this.b.b()).inflate(2131625652, null);
    this.l = ((TextView)this.k.findViewById(2131444565));
    if (!((PAContext)this.b).Q()) {
      this.l.setVisibility(8);
    }
    this.m = ((TextView)this.k.findViewById(2131444559));
    this.n = ((ImageView)this.k.findViewById(2131444557));
    this.o = ((ProgressBar)this.k.findViewById(2131444560));
  }
  
  public void b(boolean paramBoolean)
  {
    if (((PAContext)this.b).P())
    {
      if (paramBoolean)
      {
        if (this.c.getOverScrollHeaderView() == null)
        {
          if (this.k == null) {
            a();
          }
          this.c.setOverScrollHeader(this.k);
        }
      }
      else
      {
        this.c.setOverscrollHeader((Drawable)null);
        this.c.setOverScrollHeader((View)null);
      }
    }
    else {
      super.b(paramBoolean);
    }
  }
  
  public void c()
  {
    super.c();
    this.h.y = new PublicAccountRefresher(this.b.a().getMessageFacade().r());
  }
  
  public void d(int paramInt)
  {
    try
    {
      this.m.setText(paramInt);
      this.m.setVisibility(0);
      this.n.setVisibility(8);
      this.o.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d(long paramLong)
  {
    try
    {
      this.m.setVisibility(8);
      this.n.setVisibility(8);
      this.o.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void e(int paramInt)
  {
    try
    {
      this.n.setVisibility(0);
      this.m.setVisibility(0);
      this.o.setVisibility(8);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            this.m.setText(2131892954);
          }
        }
        else {
          this.m.setText(2131916799);
        }
      }
      else {
        this.m.setText(2131916805);
      }
      this.b.b().runOnUiThread(new PAListUI.1(this));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 1) {
      return;
    }
    if (((PAContext)this.b).P()) {
      d(2131892959);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 1) {
      return;
    }
    if (((PAContext)this.b).P()) {
      d(2131892971);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAListUI", 2, "listView onViewCompleteVisableAndReleased");
    }
    if (paramInt == 1) {
      return true;
    }
    if (!((PAContext)this.b).P()) {
      return super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    }
    if ((this.f != null) && (this.f.getCount() > 0))
    {
      this.a = true;
      d(System.currentTimeMillis());
      this.i = SystemClock.uptimeMillis();
      ((ChatContext)this.h.a).a(this.i);
      this.h.g = false;
      this.h.h = true;
      this.b.a().getMessageFacade().a(this.b.O().b, this.b.O().a, 21, this.h);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI
 * JD-Core Version:    0.7.0.1
 */