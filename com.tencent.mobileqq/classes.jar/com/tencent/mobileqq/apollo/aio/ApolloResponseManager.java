package com.tencent.mobileqq.apollo.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteTaskStatusCallback;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ApolloResponseManager
  implements ISpriteTaskStatusCallback, Manager
{
  View.OnClickListener a = new ApolloResponseManager.1(this);
  Comparator<ApolloActionData> b = new ApolloResponseManager.2(this);
  private QQAppInterface c;
  private ListView d;
  private ApolloResponseManager.ResponseAdapter e;
  private WeakReference<BaseChatPie> f;
  private FrameLayout g;
  private int h = 0;
  private TextView i;
  private String j;
  
  public ApolloResponseManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
  }
  
  int a(ApolloActionData paramApolloActionData)
  {
    int k = paramApolloActionData.feeType;
    if (k != 6)
    {
      if (k != 7)
      {
        if (k != 9) {
          return 1;
        }
        return 2;
      }
      return 3;
    }
    return 4;
  }
  
  public void a()
  {
    this.f = null;
    ListView localListView = this.d;
    if (localListView != null)
    {
      if (localListView.getParent() != null) {
        ((ViewGroup)this.d.getParent()).removeView(this.d);
      }
      this.d.setAdapter(null);
      this.d = null;
      this.e = null;
    }
    this.g = null;
    this.i = null;
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong)
  {
    if (this.c == null) {
      return;
    }
    int k = paramSpriteTaskParam.f;
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)this.c.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionInCache(k);
    if ((localApolloActionData != null) && ((localApolloActionData.pkIds != null) || (localApolloActionData.pk3DIds != null)) && (!paramSpriteTaskParam.l) && (paramSpriteTaskParam.g == 1))
    {
      MqqHandler localMqqHandler = this.c.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        localMqqHandler.removeMessages(82);
        localMqqHandler.removeMessages(83);
        Message localMessage = localMqqHandler.obtainMessage();
        localMessage.what = 82;
        localMessage.obj = localApolloActionData;
        localMessage.arg1 = k;
        localMessage.getData().putString("senderUin", paramSpriteTaskParam.j);
        localMqqHandler.sendMessageDelayed(localMessage, 500L);
        localMqqHandler.sendEmptyMessageDelayed(83, 4000L);
      }
    }
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong, int paramInt) {}
  
  public void a(Object paramObject, ApolloActionData paramApolloActionData, int paramInt, String paramString)
  {
    if (!(paramObject instanceof BaseChatPie)) {
      return;
    }
    Object localObject1 = (BaseChatPie)paramObject;
    int k;
    int m;
    if (((BaseChatPie)localObject1).aX() != null)
    {
      if (paramApolloActionData == null) {
        return;
      }
      paramObject = (IApolloManagerService)this.c.getRuntimeService(IApolloManagerService.class, "all");
      if (paramObject.is3dAvailable())
      {
        if (paramObject.getCmShowStatus(this.c.getCurrentUin()) == 1) {
          paramObject = paramApolloActionData.pkIds;
        } else {
          paramObject = paramApolloActionData.pk3DIds;
        }
      }
      else if (ApolloActionData.isAction3DModel(paramApolloActionData.actionId)) {
        paramObject = "";
      } else {
        paramObject = paramApolloActionData.pkIds;
      }
      if (QLog.isColorLevel())
      {
        paramApolloActionData = new StringBuilder();
        paramApolloActionData.append("[showQuickResponseView] Ids:");
        paramApolloActionData.append(paramObject);
        QLog.d("[cmshow]ApolloResponseManager", 2, paramApolloActionData.toString());
      }
      if (TextUtils.isEmpty(paramObject)) {
        return;
      }
      this.f = new WeakReference(localObject1);
      this.j = paramString;
      if ((this.f != null) && (((BaseChatPie)localObject1).ah != null)) {
        this.h = ((BaseChatPie)localObject1).ah.a;
      }
      paramApolloActionData = ((BaseChatPie)localObject1).aX();
      localObject1 = (RelativeLayout)((BaseChatPie)localObject1).aX().findViewById(2131430542);
      Object localObject2 = this.d;
      k = 0;
      if (localObject2 == null)
      {
        this.d = new ListView(paramApolloActionData);
        this.d.setDivider(null);
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setSelector(paramApolloActionData.getResources().getDrawable(2130853309));
        this.d.setCacheColorHint(2131165795);
        this.g = new FrameLayout(paramApolloActionData);
        this.i = new TextView(paramApolloActionData);
        this.i.setTextSize(11.0F);
        this.i.setMaxLines(1);
        this.i.setIncludeFontPadding(false);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        m = ViewUtils.dip2px(9.0F);
        this.i.setPadding(0, 0, 0, m);
        this.i.setTextColor(paramApolloActionData.getResources().getColor(2131168001));
        localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 1;
        this.g.addView(this.i, (ViewGroup.LayoutParams)localObject2);
        this.d.addHeaderView(this.g);
        this.e = new ApolloResponseManager.ResponseAdapter(this, paramApolloActionData);
        this.d.setAdapter(this.e);
        paramApolloActionData = new RelativeLayout.LayoutParams(ViewUtils.dip2px(99.0F), -2);
        paramApolloActionData.addRule(11);
        paramApolloActionData.addRule(2, 2131435809);
        paramApolloActionData.rightMargin = ViewUtils.dip2px(10.0F);
        ((RelativeLayout)localObject1).addView(this.d, paramApolloActionData);
      }
      paramApolloActionData = this.c.getApplication().getSharedPreferences("apollo_sp", 0);
      m = this.h;
      if (m != 0)
      {
        if ((m == 1) || (m == 3000))
        {
          paramApolloActionData = ContactUtils.a(this.c, paramString, true);
          paramApolloActionData = String.format(HardCodeUtil.a(2131898763), new Object[] { paramApolloActionData });
          this.i.setText(paramApolloActionData);
          this.i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
      }
      else if (paramApolloActionData.getBoolean("first_show_resp", true))
      {
        paramApolloActionData.edit().putBoolean("first_show_resp", false).commit();
        this.i.setText(HardCodeUtil.a(2131898761));
        this.i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838461, 0);
      }
      else
      {
        this.i.setVisibility(8);
      }
    }
    for (;;)
    {
      try
      {
        paramApolloActionData = new ArrayList();
        paramObject = paramObject.split(",");
        m = paramObject.length;
        if (k < m)
        {
          paramString = paramObject[k];
          if (TextUtils.isEmpty(paramString)) {
            break label750;
          }
          paramApolloActionData.add(Integer.valueOf(Integer.parseInt(paramString.trim())));
          break label750;
        }
        this.e.a(paramApolloActionData, paramInt);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("[cmshow]ApolloResponseManager", 1, "update Quick Response View error:", paramObject);
      }
      return;
      label750:
      k += 1;
    }
  }
  
  public void onDestroy()
  {
    this.f = null;
    this.e = null;
    this.d = null;
    this.g = null;
    this.i = null;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloResponseManager
 * JD-Core Version:    0.7.0.1
 */