package com.tencent.av.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class VoiceChangeChooseDialog
  extends ReportDialog
  implements View.OnClickListener
{
  VideoController a;
  VoiceChangeAdapter b;
  View c;
  View d;
  View e;
  TextView f;
  boolean g;
  Button h;
  boolean i;
  boolean j;
  Handler k;
  Runnable l;
  BroadcastReceiver m;
  Animation.AnimationListener n;
  private Context o;
  private int p;
  
  private void c()
  {
    int i1;
    if (this.a.k().bX) {
      i1 = 2130843329;
    } else {
      i1 = 2130843328;
    }
    this.h.setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
  }
  
  void a()
  {
    if (this.b.getCount() == 0)
    {
      this.f.setText(2131893741);
      return;
    }
    if (this.a.k().cr == 0)
    {
      this.f.setText(2131893740);
      return;
    }
    this.f.setText(2131893739);
  }
  
  public void b()
  {
    VideoController localVideoController = this.a;
    if (localVideoController == null)
    {
      AVLog.printErrorLog("VoiceChangeChooseDialog", "updateDialogStyle mVideoController is null!!");
      return;
    }
    boolean bool;
    if ((localVideoController.k().g != 2) && (this.a.k().g != 4)) {
      bool = false;
    } else {
      bool = true;
    }
    this.i = bool;
    if (this.i)
    {
      this.b.a(-1);
      this.d.setBackgroundColor(16777216);
      this.c.setBackgroundColor(-534962398);
      this.e.setBackgroundColor(-16777216);
      this.f.setTextColor(-1);
      this.h.setTextColor(-1);
    }
    else
    {
      this.b.a(-16777216);
      this.d.setBackgroundColor(-2147483648);
      this.c.setBackgroundColor(-1);
      this.e.setBackgroundColor(-2170912);
      this.f.setTextColor(-8947849);
      this.h.setTextColor(-16777216);
    }
    c();
  }
  
  public void dismiss()
  {
    super.dismiss();
    Context localContext = this.o;
    if (localContext != null)
    {
      localContext.unregisterReceiver(this.m);
      this.o = null;
    }
    this.k.removeCallbacks(this.l);
    this.b = null;
    this.a = null;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    if (i1 != 2131430486)
    {
      if ((i1 != 2131437906) && (!this.j))
      {
        this.j = true;
        localObject = AnimationUtils.loadAnimation(this.o, 2130772246);
        ((Animation)localObject).setAnimationListener(this.n);
        this.c.startAnimation((Animation)localObject);
      }
    }
    else
    {
      this.a.k().bX ^= true;
      if (this.a.k().cr != 0)
      {
        localObject = this.a;
        ((VideoController)localObject).k(((VideoController)localObject).k().bX);
        if (this.a.k().bX)
        {
          this.f.setText(2131893739);
        }
        else
        {
          this.f.setText(2131893738);
          this.k.removeCallbacks(this.l);
          this.p = 0;
        }
      }
      c();
      if (!this.a.k().bX)
      {
        TipsUtil.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 1017);
        VoiceChangeDataReport.a("0X8007EF4", "");
      }
      else
      {
        VoiceChangeDataReport.a("0X8007EF3", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    super.show();
    int i2 = 0;
    this.j = false;
    this.c.startAnimation(AnimationUtils.loadAnimation(this.o, 2130772247));
    int i1 = i2;
    if (this.b.getCount() == 0)
    {
      this.b.a(VoiceChangeData.a().b());
      i1 = i2;
      if (this.b.getCount() != 0) {
        i1 = 1;
      }
    }
    if (this.a.k().cr == 0) {
      i1 = 1;
    }
    if (i1 != 0) {
      this.b.notifyDataSetChanged();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog
 * JD-Core Version:    0.7.0.1
 */