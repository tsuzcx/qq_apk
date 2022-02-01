package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopInviteStatusFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  int A = 0;
  ArrayList<String> B = null;
  int C = 0;
  Runnable D = new TroopInviteStatusFragment.1(this);
  Runnable E = new TroopInviteStatusFragment.2(this);
  Runnable F = new TroopInviteStatusFragment.3(this);
  TroopNotificationUtils.TroopPrivilegeCallback G = new TroopInviteStatusFragment.4(this);
  MessageObserver H = new TroopInviteStatusFragment.5(this);
  private TroopMngObserver I = new TroopInviteStatusFragment.6(this);
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm J = new TroopInviteStatusFragment.7(this);
  View a;
  View b;
  View c;
  View d;
  View e;
  Button f;
  TextView g;
  ImageView h;
  SingleLineTextView i;
  SingleLineTextView j;
  TextView k;
  BaseActivity l;
  QQAppInterface m;
  String n;
  String o;
  String p;
  String q;
  String r;
  long s;
  boolean t = false;
  Handler u;
  TroopInfo v;
  boolean w = false;
  QQProgressDialog x;
  boolean y = true;
  int z = 0;
  
  private String a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return ContactUtils.a(paramString1, paramInt);
  }
  
  private void a(int paramInt)
  {
    long l1 = this.s;
    long l2 = Long.valueOf(this.p).longValue();
    structmsg.SystemMsgActionInfo localSystemMsgActionInfo = new structmsg.SystemMsgActionInfo();
    localSystemMsgActionInfo.group_code.set(Long.valueOf(this.n).longValue());
    localSystemMsgActionInfo.type.set(11);
    this.m.getMsgHandler().B().a(1, l1, l2, 1, 3, 10016, paramInt, localSystemMsgActionInfo, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    if ((paramQQAppInterface != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("troopCode:");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" invitedUin:");
        ((StringBuilder)localObject).append(paramString3);
        ((StringBuilder)localObject).append(" msgSeq:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" senderUin:");
        ((StringBuilder)localObject).append(paramString4);
        ((StringBuilder)localObject).append(" currentUin:");
        ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentUin());
        QLog.d("TroopInviteStatusFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramString5;
      if (TextUtils.equals(paramString5, paramString4)) {
        localObject = ContactUtils.f(paramQQAppInterface, paramString4);
      }
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("public_fragment_window_feature", 1);
      paramQQAppInterface.putExtra("troopCode", paramString1);
      paramQQAppInterface.putExtra("troopName", paramString2);
      paramQQAppInterface.putExtra("invitedUin", paramString3);
      paramQQAppInterface.putExtra("senderUin", paramString4);
      paramQQAppInterface.putExtra("senderNick", (String)localObject);
      paramQQAppInterface.putExtra("msgSeq", paramLong);
      PublicFragmentActivity.Launcher.a(paramContext, paramQQAppInterface, PublicTransFragmentActivity.class, TroopInviteStatusFragment.class);
    }
  }
  
  private boolean a()
  {
    Object localObject = this.l.getIntent();
    this.n = ((Intent)localObject).getStringExtra("troopCode");
    String str = this.n;
    if (str != null) {
      this.n = str.trim();
    }
    this.o = ((Intent)localObject).getStringExtra("troopName");
    this.p = ((Intent)localObject).getStringExtra("invitedUin");
    this.q = ((Intent)localObject).getStringExtra("senderUin");
    this.r = ((Intent)localObject).getStringExtra("senderNick");
    this.s = ((Intent)localObject).getLongExtra("msgSeq", 0L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData troopCode:");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append(" invitedUin:");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(" msgSeq:");
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append(" sendUin:");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(" currentUin:");
      ((StringBuilder)localObject).append(this.m.getCurrentUin());
      ((StringBuilder)localObject).append(" troopName:");
      ((StringBuilder)localObject).append(this.o);
      QLog.d("TroopInviteStatusFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.equals(this.q, this.m.getCurrentUin()))
    {
      this.t = true;
    }
    else
    {
      if (!TextUtils.equals(this.p, this.m.getCurrentUin())) {
        break label418;
      }
      this.t = false;
    }
    this.m.addObserver(this.I);
    this.m.addObserver(this.H);
    this.u = new Handler();
    localObject = this.l;
    this.x = new QQProgressDialog((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
    if (!NetworkUtil.isNetSupport(getBaseActivity()))
    {
      QQToast.makeText(this.l, getBaseActivity().getString(2131892102), 0).show(this.l.getTitleBarHeight()).show();
      return true;
    }
    localObject = (TroopManager)this.m.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null) {
      this.v = ((TroopManager)localObject).f(this.n);
    }
    this.u.postDelayed(this.D, 1000L);
    this.u.post(this.E);
    return true;
    label418:
    this.l.finish();
    return false;
  }
  
  private void b()
  {
    this.a = this.mContentView.findViewById(2131445137);
    this.b = this.mContentView.findViewById(2131447985);
    this.c = this.mContentView.findViewById(2131438062);
    this.d = this.mContentView.findViewById(2131446335);
    this.e = this.mContentView.findViewById(2131432673);
    this.f = ((Button)this.mContentView.findViewById(2131427911));
    this.g = ((TextView)this.mContentView.findViewById(2131446326));
    this.h = ((ImageView)this.mContentView.findViewById(2131447981));
    this.i = ((SingleLineTextView)this.mContentView.findViewById(2131448053));
    this.j = ((SingleLineTextView)this.mContentView.findViewById(2131435900));
    this.k = ((TextView)this.mContentView.findViewById(2131438066));
    this.h.setOnClickListener(this);
    this.h.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    this.i.setOnClickListener(this);
    this.i.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    this.f.setOnClickListener(this);
    c();
  }
  
  private void c()
  {
    if (this.b == null) {
      return;
    }
    if (this.C != 6)
    {
      Object localObject1 = this.v;
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isExited()))
      {
        this.a.setBackgroundResource(2130838958);
        if (this.t)
        {
          this.b.setVisibility(0);
          this.c.setVisibility(8);
          this.d.setVisibility(0);
          this.e.setVisibility(8);
          this.j.setVisibility(8);
          this.f.setVisibility(8);
          this.g.setVisibility(8);
        }
        Object localObject3;
        switch (this.C)
        {
        default: 
          break;
        case 7: 
          this.g.setVisibility(0);
          this.g.setText(HardCodeUtil.a(2131912729));
          break;
        case 5: 
          this.g.setVisibility(0);
          this.g.setText(HardCodeUtil.a(2131912726));
          break;
        case 4: 
          this.g.setVisibility(0);
          this.g.setText(HardCodeUtil.a(2131912734));
          break;
        case 3: 
          this.g.setVisibility(0);
          this.g.setText(HardCodeUtil.a(2131912727));
          break;
        case 2: 
          this.g.setVisibility(0);
          this.g.setText(HardCodeUtil.a(2131912728));
          break;
        case 1: 
          this.g.setVisibility(0);
          this.g.setText(HardCodeUtil.a(2131912735));
          break;
          this.b.setVisibility(0);
          this.d.setVisibility(0);
          this.e.setVisibility(8);
          this.j.setVisibility(0);
          localObject1 = HardCodeUtil.a(2131912731);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(a(this.r, this.q, 8));
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject3).toString();
          this.j.setText((CharSequence)localObject1);
          if ((TextUtils.isEmpty(this.q)) || ("0".equals(this.q))) {
            this.j.setVisibility(8);
          }
        }
        try
        {
          if ((this.B != null) && (this.B.contains(this.q)))
          {
            this.B.remove(this.q);
            this.A -= 1;
          }
          if ((this.A > 0) && (this.B != null) && (!this.B.isEmpty()))
          {
            localObject1 = new StringBuilder();
            float f1 = 0.0F;
            localObject3 = this.B.iterator();
            int i1 = 0;
            String str1;
            String str2;
            for (;;)
            {
              i2 = i1;
              if (!((Iterator)localObject3).hasNext()) {
                break label638;
              }
              str1 = (String)((Iterator)localObject3).next();
              str2 = ContactUtils.a(this.m, str1, 0);
              f1 += ContactUtils.d(str2);
              if (f1 >= 20) {
                break;
              }
              if (i1 > 0) {
                ((StringBuilder)localObject1).append("、");
              }
              ((StringBuilder)localObject1).append(str2);
              i1 += 1;
            }
            int i2 = i1;
            if (i1 == 0)
            {
              ((StringBuilder)localObject1).append(a(str2, str1, 20));
              i2 = i1 + 1;
            }
            label638:
            if (this.A > 99)
            {
              ((StringBuilder)localObject1).append("等99+人也在群聊中");
            }
            else if (i2 < this.A)
            {
              ((StringBuilder)localObject1).append("等");
              ((StringBuilder)localObject1).append(this.A);
              ((StringBuilder)localObject1).append("人也在群聊中");
            }
            else
            {
              ((StringBuilder)localObject1).append("也在群聊中");
            }
            this.c.setVisibility(0);
            this.k.setText(((StringBuilder)localObject1).toString());
          }
          else
          {
            this.c.setVisibility(8);
          }
          this.f.setVisibility(8);
          this.g.setVisibility(8);
          switch (this.C)
          {
          default: 
            break;
          case 7: 
            this.g.setVisibility(0);
            this.g.setText(HardCodeUtil.a(2131912730));
            break;
          case 5: 
            this.g.setVisibility(0);
            this.g.setText(HardCodeUtil.a(2131912733));
            break;
          case 4: 
            this.g.setVisibility(0);
            this.g.setText(HardCodeUtil.a(2131912722));
            break;
          case 3: 
            this.g.setVisibility(0);
            this.g.setText(HardCodeUtil.a(2131912725));
            break;
          case 2: 
            this.g.setVisibility(0);
            this.g.setText(HardCodeUtil.a(2131912723));
            break;
          case 1: 
            this.f.setVisibility(0);
            break;
          case -1: 
            this.g.setVisibility(0);
            this.g.setText("");
          }
          localObject1 = FaceDrawable.getFaceDrawable(this.m, 4, this.n);
          this.h.setImageDrawable((Drawable)localObject1);
          localObject1 = this.v;
          if (localObject1 != null) {
            localObject3 = ((TroopInfo)localObject1).getTroopDisplayName();
          } else {
            localObject3 = "";
          }
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = this.o;
          }
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = localObject1;
            if (this.z > 0)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append("(");
              ((StringBuilder)localObject3).append(this.z);
              ((StringBuilder)localObject3).append(")");
              localObject3 = ((StringBuilder)localObject3).toString();
            }
          }
          this.i.setText((CharSequence)localObject3);
          return;
        }
        finally {}
      }
    }
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.a.setBackgroundResource(2130852616);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.l = getBaseActivity();
    paramLayoutInflater = this.l;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.app != null) && (this.mContentView != null))
    {
      this.m = this.l.app;
      if (a()) {
        b();
      }
      return;
    }
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("doOnCreateView error mActivity:");
    paramLayoutInflater.append(this.l);
    paramLayoutInflater.append(" mContentView:");
    paramLayoutInflater.append(this.mContentView);
    QLog.e("TroopInviteStatusFragment", 1, paramLayoutInflater.toString());
  }
  
  protected int getContentLayoutId()
  {
    return 2131626724;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    if (i1 != 2131427911)
    {
      if ((i1 == 2131447981) || (i1 == 2131448053))
      {
        TroopReportor.a("Grp_AIO", "invite", "in_clk", 0, 0, new String[0]);
        localObject = TroopInfoUIUtil.a(this.n, 4);
        ((Bundle)localObject).putInt("t_s_f", 1001);
        TroopUtils.a(this.l, (Bundle)localObject, 2);
      }
    }
    else
    {
      TroopReportor.a("Grp_AIO", "invite", "in_agree", 0, 0, new String[0]);
      if (!NetworkUtil.isNetSupport(getBaseActivity()))
      {
        QQToast.makeText(this.l, getBaseActivity().getString(2131892102), 0).show(this.l.getTitleBarHeight()).show();
      }
      else
      {
        localObject = (ITroopMngHandler)this.m.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
        try
        {
          ((ITroopMngHandler)localObject).a(Long.valueOf(this.n).longValue(), Long.valueOf(this.m.getCurrentUin()).longValue(), null);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          QLog.d("TroopInviteStatusFragment", 2, "troopCode is null");
        }
        QQProgressDialog localQQProgressDialog = this.x;
        if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
          this.x.dismiss();
        }
        localQQProgressDialog = this.x;
        if (localQQProgressDialog != null)
        {
          localQQProgressDialog.c(2131916272);
          this.x.show();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(HardCodeUtil.a(2131912724));
    return localView;
  }
  
  public void onDestroy()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.I);
      this.m.removeObserver(this.H);
    }
    localObject = this.x;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.x.dismiss();
    }
    localObject = this.u;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    Handler localHandler = this.u;
    if (localHandler != null) {
      localHandler.removeCallbacks(this.D);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.y) {
      c();
    }
    this.y = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment
 * JD-Core Version:    0.7.0.1
 */