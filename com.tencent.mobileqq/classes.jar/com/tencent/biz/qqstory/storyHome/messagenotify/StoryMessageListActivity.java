package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelAllMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelOneMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqStoryMessageList;
import com.tencent.biz.qqstory.notification.StoryMsgNotification;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StoryMessageListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  protected ArrayList<MessageData> a = new ArrayList();
  protected SwipListView b;
  protected StoryMessageListActivity.StoryMessageListAdapter c;
  protected QQAppInterface d = null;
  protected int e = 0;
  protected View f;
  protected View g;
  protected TextView h;
  protected int i = 4;
  protected boolean j = false;
  protected long k = -1L;
  protected int l = 0;
  protected boolean m;
  protected QQCustomDialog n;
  protected BubblePopupWindow o;
  protected QQCustomMenu p;
  protected boolean q = true;
  protected String r;
  protected ProtoUtils.StoryProtocolObserver s = new StoryMessageListActivity.1(this);
  protected ProtoUtils.StoryProtocolObserver t = new StoryMessageListActivity.2(this);
  protected ProtoUtils.StoryProtocolObserver u = new StoryMessageListActivity.3(this);
  
  @NonNull
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, StoryMessageListActivity.class);
    paramContext.putExtra("qqstory_message_list_source", paramInt);
    paramContext.putExtra("qqstory_jump_source", paramString);
    return paramContext;
  }
  
  protected CharSequence a(MessageData paramMessageData)
  {
    if (paramMessageData.d == 2)
    {
      paramMessageData = paramMessageData.n;
    }
    else
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.a(2131911823));
      int i1 = localSpannableStringBuilder.length();
      localSpannableStringBuilder.append(PlayModeUtils.a(paramMessageData.l));
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131167993)), i1, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(':').append(paramMessageData.n);
      paramMessageData = localSpannableStringBuilder;
    }
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramMessageData.toString())) {
      return new QQText(EmotionCodecUtils.c(paramMessageData.toString()), 3, 14);
    }
    return paramMessageData;
  }
  
  protected void a()
  {
    if (this.i == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList", 2, "already loading");
      }
      return;
    }
    this.i = 1;
    qqstory_710_message.ReqStoryMessageList localReqStoryMessageList = new qqstory_710_message.ReqStoryMessageList();
    localReqStoryMessageList.num.set(20);
    localReqStoryMessageList.start_time.set(this.e);
    localReqStoryMessageList.source.set(this.l);
    localReqStoryMessageList.version_ctrl.set(775);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetch message list, start=");
      localStringBuilder.append(this.e);
      QLog.d("Q.qqstory.msgList", 2, localStringBuilder.toString());
    }
    ProtoUtils.a(this.d, this.u, localReqStoryMessageList.toByteArray(), StoryApi.a("StorySvc.get_710_message_list"));
  }
  
  protected void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.makeText(getApplicationContext(), 1, HardCodeUtil.a(2131911829), 0).show();
      return;
    }
    if (this.c.a(paramInt))
    {
      MessageData localMessageData = (MessageData)this.a.remove(paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doDeleteMessage pos=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" vid=");
        ((StringBuilder)localObject).append(localMessageData.f);
        ((StringBuilder)localObject).append(" type=");
        ((StringBuilder)localObject).append(localMessageData.d);
        ((StringBuilder)localObject).append(" cid=");
        ((StringBuilder)localObject).append(localMessageData.j);
        QLog.i("Q.qqstory.msgList", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new qqstory_710_del_message.ReqDelOneMessage();
      ((qqstory_710_del_message.ReqDelOneMessage)localObject).feed_id.set(ByteStringMicro.copyFromUtf8(localMessageData.o));
      ((qqstory_710_del_message.ReqDelOneMessage)localObject).message_id.set(localMessageData.p);
      ProtoUtils.a(this.d, this.t, ((qqstory_710_del_message.ReqDelOneMessage)localObject).toByteArray(), StoryApi.a("StorySvc.del_710_one_message"));
      this.c.notifyDataSetChanged();
      if (this.c.getCount() == 0)
      {
        this.g.setVisibility(8);
        this.h.setText(2131892146);
        this.h.setCompoundDrawablesWithIntrinsicBounds(0, 2130842288, 0, 0);
        this.h.setClickable(false);
        this.h.setVisibility(0);
        this.f.setVisibility(0);
        setRightViewTextDisable(0);
      }
    }
  }
  
  protected void a(MessageData paramMessageData, View paramView)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("click item type=");
      paramView.append(paramMessageData.d);
      QLog.d("Q.qqstory.msgList", 2, paramView.toString());
    }
    switch (paramMessageData.d)
    {
    default: 
    case 19: 
      StoryPlayerLauncher.b(this, paramMessageData.f, paramMessageData.L, 29);
      return;
    case 18: 
      StoryPlayerLauncher.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramMessageData.K, paramMessageData.f), 126).f(), null);
      return;
    case 16: 
      paramView = new StringBuilder("https://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
      paramView.append("&vid=");
      paramView.append(paramMessageData.f);
      SLog.a("Q.qqstory.msgList", "go to story grade detail web. url = %s.", paramView.toString());
      paramMessageData = new Intent(this, QQBrowserActivity.class);
      paramMessageData.putExtra("url", paramView.toString());
      paramMessageData.putExtra("startOpenPageTime", System.currentTimeMillis());
      startActivity(paramMessageData);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_GRADE open webview!");
        return;
      }
      break;
    case 13: 
      paramView = new StringBuilder("https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
      paramView.append("&vid=");
      paramView.append(paramMessageData.f);
      SLog.a("Q.qqstory.msgList", "go to story vote detail web. url = %s.", paramView.toString());
      paramMessageData = new Intent(this, QQBrowserActivity.class);
      paramMessageData.putExtra("url", paramView.toString());
      startActivity(paramMessageData);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_VOTE open webview!");
        return;
      }
      break;
    case 11: 
      QQToast.makeText(this, -1, HardCodeUtil.a(2131911834), 0).show();
      return;
    case 10: 
      paramMessageData = ((UserManager)SuperManager.a(2)).c();
      if (paramMessageData == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.msgList", 2, "self user item == null");
        }
        return;
      }
      paramMessageData = paramMessageData.getUserIconJumpURL();
      if (android.text.TextUtils.isEmpty(paramMessageData))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.msgList", 2, "jumpUrl is empty");
        }
        return;
      }
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", paramMessageData);
      startActivity(paramView);
      return;
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      QQStoryShareGroupProfileActivity.a(this, 2, paramMessageData.C, null, 7, 0);
      return;
    case 5: 
      if (paramMessageData.y == 0)
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", paramMessageData.x);
        startActivity(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open webview!");
        }
      }
      else if (paramMessageData.y == 1)
      {
        paramView = new Intent(this, JumpActivity.class);
        paramView.setData(Uri.parse(paramMessageData.x));
        startActivity(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open jumpActivity!");
        }
      }
      else if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("StoryMessageListActivity#onItemClick() unknow url_type = ");
        paramView.append(paramMessageData.y);
        QLog.e("Q.qqstory.msgList", 2, paramView.toString());
        return;
      }
      break;
    case 4: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
      if (paramMessageData.e)
      {
        QQToast.makeText(this, 1, HardCodeUtil.a(2131911858), 0).show();
        return;
      }
      StoryPlayerLauncher.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramMessageData.o, paramMessageData.f), 29).f(), null);
      return;
    case 2: 
    case 3: 
      StoryDetailActivity.a(this, paramMessageData.o, 23, paramMessageData.j, 0, paramMessageData.h);
      return;
    case 1: 
      StoryDetailActivity.a(this, paramMessageData.o, 23, 0, paramMessageData.h);
    }
  }
  
  public void a(List<MessageData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      ArrayList localArrayList = new ArrayList();
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageData localMessageData = (MessageData)paramList.next();
        String[] arrayOfString = new String[3];
        Object localObject = localMessageData.c;
        int i1 = 0;
        arrayOfString[0] = localObject;
        arrayOfString[1] = localMessageData.i;
        arrayOfString[2] = localMessageData.l;
        int i2 = arrayOfString.length;
        while (i1 < i2)
        {
          localMessageData = arrayOfString[i1];
          if (!android.text.TextUtils.isEmpty(localMessageData))
          {
            localObject = localUserManager.b(localMessageData);
            if (((localObject == null) || (!((QQUserUIItem)localObject).isAvailable())) && (!localHashSet.contains(localMessageData)))
            {
              localArrayList.add(new QQUserUIItem.UserID("", localMessageData));
              localHashSet.add(localMessageData);
            }
          }
          i1 += 1;
        }
      }
      localHashSet.clear();
      if (!localArrayList.isEmpty()) {
        new GetUserInfoHandler().a(1, localArrayList);
      }
    }
  }
  
  protected void a(List<MessageData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdate size=");
      ((StringBuilder)localObject).append(paramList.size());
      ((StringBuilder)localObject).append(", end=");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("Q.qqstory.msgList", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.size() == 0)
    {
      if (paramList.size() > 0)
      {
        this.k = ((MessageData)paramList.get(0)).g;
        this.f.setVisibility(8);
      }
      else
      {
        i1 = this.l;
        if (((i1 == 0) || (i1 == 2)) && (paramBoolean2))
        {
          this.f.setVisibility(8);
        }
        else
        {
          this.g.setVisibility(8);
          this.h.setText(2131892146);
          this.h.setCompoundDrawablesWithIntrinsicBounds(0, 2130842288, 0, 0);
          this.h.setClickable(false);
          this.h.setVisibility(0);
          this.f.setVisibility(0);
        }
      }
      localObject = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().i());
      if ((localObject != null) && (((QQUserUIItem)localObject).isVip)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2 = this.l;
      localObject = "1";
      if (i2 == 0)
      {
        if (i1 != 0) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        StoryReportor.a("play_video", "exp_notice", i1, 0, new String[] { "1", "", "", "" });
      }
      else if (i2 == 1)
      {
        if (paramList.size() > 0) {
          localObject = "2";
        }
        StoryReportor.a("memory", "exp_msg", 0, 0, new String[] { localObject, "", "", "" });
      }
    }
    a(paramList);
    this.a.addAll(paramList);
    int i1 = paramList.size();
    if ((!paramBoolean1) && (i1 != 0))
    {
      this.i = 4;
    }
    else
    {
      this.i = 2;
      c();
    }
    if (i1 > 0)
    {
      paramList = this.a;
      this.e = ((int)(((MessageData)paramList.get(paramList.size() - 1)).g / 1000L) - 1);
      setRightViewTextDisable(1);
    }
    this.q = paramBoolean2;
    this.c.notifyDataSetChanged();
  }
  
  protected CharSequence b(MessageData paramMessageData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131911827));
    localStringBuilder.append(paramMessageData.n);
    return localStringBuilder.toString();
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "onError");
    }
    this.i = 3;
    if (this.a.size() == 0)
    {
      this.g.setVisibility(8);
      this.h.setText(HardCodeUtil.a(2131911822));
      this.h.setCompoundDrawablesWithIntrinsicBounds(0, 2130848407, 0, 0);
      this.h.setOnClickListener(this);
      this.h.setVisibility(0);
      this.f.setVisibility(0);
      if (this.l == 0)
      {
        QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().i());
        int i1;
        if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        StoryReportor.a("play_video", "exp_notice", i1, 0, new String[] { "2", "", "", "" });
      }
    }
    b(this.a.size());
  }
  
  protected void b(int paramInt)
  {
    int i1 = this.b.getFirstVisiblePosition();
    int i2 = this.b.getLastVisiblePosition();
    if ((paramInt >= i1) && (paramInt <= i2))
    {
      View localView = this.b.getChildAt(paramInt - i1);
      this.c.getView(paramInt, localView, this.b);
    }
  }
  
  protected CharSequence c(MessageData paramMessageData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.a(2131911838));
    int i1 = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(paramMessageData.E);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131167993)), i1, localSpannableStringBuilder.length(), 33);
    SLog.b("Q.qqstory.msgList", "get vote publish string : %s, voteQuestion : %s.", localSpannableStringBuilder, paramMessageData.E);
    paramMessageData = localSpannableStringBuilder;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(localSpannableStringBuilder.toString())) {
      paramMessageData = new QQText(EmotionCodecUtils.c(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramMessageData;
  }
  
  protected void c()
  {
    if (this.j) {
      return;
    }
    this.j = true;
    long l1 = this.k;
    int i1;
    StringBuilder localStringBuilder;
    if (l1 != -1L)
    {
      i1 = (int)(l1 / 1000L);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearUnread by msg time, time=");
        localStringBuilder.append(i1);
        QLog.d("Q.qqstory.msgList", 2, localStringBuilder.toString());
      }
      ((TroopRedTouchHandler)this.d.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).a(i1, this.l);
      return;
    }
    if (this.i == 2)
    {
      i1 = (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearUnread by svr time, time=");
        localStringBuilder.append(i1);
        QLog.d("Q.qqstory.msgList", 2, localStringBuilder.toString());
      }
      ((TroopRedTouchHandler)this.d.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).a(i1, this.l);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "nothing to clear");
    }
  }
  
  protected CharSequence d(MessageData paramMessageData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramMessageData.F);
    localSpannableStringBuilder.append("\n");
    localSpannableStringBuilder.append("投票：");
    localSpannableStringBuilder.append(paramMessageData.E);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-4473925), 0, localSpannableStringBuilder.length(), 33);
    SLog.b("Q.qqstory.msgList", "get answer vote string : %s, voteQuestion : %s, voteAnswer : %s.", localSpannableStringBuilder, paramMessageData.E, paramMessageData.F);
    paramMessageData = localSpannableStringBuilder;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(localSpannableStringBuilder.toString())) {
      paramMessageData = new QQText(EmotionCodecUtils.c(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramMessageData;
  }
  
  protected void d()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.makeText(getApplicationContext(), 1, HardCodeUtil.a(2131911830), 0).show();
      return;
    }
    long l1 = this.k;
    if (l1 == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.msgList", 2, "doDeleteAllMessage but newest timestamp not set");
      }
      return;
    }
    int i1 = (int)(l1 / 1000L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doDeleteAllMessage time=");
      ((StringBuilder)localObject).append(i1);
      QLog.i("Q.qqstory.msgList", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new qqstory_710_del_message.ReqDelAllMessage();
    ((qqstory_710_del_message.ReqDelAllMessage)localObject).start_time.set(i1);
    ProtoUtils.a(this.d, this.s, ((qqstory_710_del_message.ReqDelAllMessage)localObject).toByteArray(), StoryApi.a("StorySvc.del_710_all_message"));
    this.a.clear();
    this.q = false;
    this.c.notifyDataSetChanged();
    this.g.setVisibility(8);
    this.h.setText(2131892146);
    this.h.setCompoundDrawablesWithIntrinsicBounds(0, 2130842288, 0, 0);
    this.h.setClickable(false);
    this.h.setVisibility(0);
    this.f.setVisibility(0);
    setRightViewTextDisable(0);
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
    super.setContentView(2131628088);
    super.findViewById(2131431280).setBackgroundColor(getResources().getColor(2131168094));
    this.f = super.findViewById(2131442633);
    this.g = super.findViewById(2131442718);
    this.h = ((TextView)super.findViewById(2131432497));
    this.b = ((SwipListView)super.findViewById(2131437317));
    this.c = new StoryMessageListActivity.StoryMessageListAdapter(this);
    this.b.setDragEnable(true);
    this.b.setAdapter(this.c);
    setRightButton(2131887800, this);
    int i1 = 0;
    setRightViewTextDisable(0);
    paramBundle = getAppInterface();
    if ((paramBundle instanceof QQAppInterface)) {
      this.d = ((QQAppInterface)paramBundle);
    } else {
      QLog.e("Q.qqstory.msgList", 1, "cannot get QQAppInterface");
    }
    paramBundle = getIntent();
    if (paramBundle != null) {
      i1 = paramBundle.getIntExtra("qqstory_message_list_source", 0);
    }
    this.l = i1;
    if (paramBundle == null) {
      paramBundle = "0";
    } else {
      paramBundle = paramBundle.getStringExtra("qqstory_jump_source");
    }
    this.r = paramBundle;
    if (this.l == 2) {
      super.setTitle(HardCodeUtil.a(2131911826));
    } else {
      super.setTitle(HardCodeUtil.a(2131911821));
    }
    a();
    paramBundle = StoryMsgNotification.a();
    paramBundle.a(this, 2);
    paramBundle.a(this, 4);
    return true;
  }
  
  protected void doOnDestroy()
  {
    QQCustomDialog localQQCustomDialog = this.n;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.n.dismiss();
    }
    super.doOnDestroy();
  }
  
  protected CharSequence e(MessageData paramMessageData)
  {
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramMessageData.H)) {
      return new QQText(EmotionCodecUtils.c(paramMessageData.H), 3, 14);
    }
    return paramMessageData.H;
  }
  
  protected String e()
  {
    int i1 = this.l;
    if (i1 == 0) {
      return "play_video";
    }
    if (i1 == 1) {
      return "memory";
    }
    return "";
  }
  
  protected CharSequence f(MessageData paramMessageData)
  {
    Object localObject = HardCodeUtil.a(2131911841);
    String str;
    StringBuilder localStringBuilder;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramMessageData.H))
    {
      str = EmotionCodecUtils.c(paramMessageData.H);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("A");
      localStringBuilder.append("\n");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str);
      localObject = new SpannableStringBuilder(localStringBuilder.toString());
    }
    else
    {
      str = paramMessageData.H;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("A");
      localStringBuilder.append("\n");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str);
      localObject = new QQTextBuilder(localStringBuilder.toString(), 3, 14);
    }
    int i1 = paramMessageData.I;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return localObject;
            }
            SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, 1, 2130845982, 50, 22, 1);
            return localObject;
          }
          SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, 1, 2130845983, 50, 22, 1);
          return localObject;
        }
        SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, 1, 2130845985, 50, 22, 1);
        return localObject;
      }
      SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, 1, 2130845986, 50, 22, 1);
      return localObject;
    }
    SpannableStringUtils.a((SpannableStringBuilder)localObject, 0, 1, 2130845984, 50, 22, 1);
    return localObject;
  }
  
  public void f()
  {
    runOnUiThread(new StoryMessageListActivity.8(this));
  }
  
  public void finish()
  {
    c();
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131432497)
    {
      if (i1 == 2131436211)
      {
        StoryReportor.a(e(), "clear_msg", 0, 0, new String[] { "", "", "", "" });
        QQCustomDialog localQQCustomDialog = this.n;
        if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
          this.n.dismiss();
        }
        this.n = DialogUtil.a(this, 230).setMessage(HardCodeUtil.a(2131911816)).setNegativeButton(2131887648, new StoryMessageListActivity.5(this)).setPositiveButton(2131887800, new StoryMessageListActivity.4(this));
        this.n.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.n.show();
        StoryReportor.a(e(), "exp_sure", 0, 0, new String[] { "", "", "", "" });
      }
    }
    else if (this.i == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList", 2, "click retry first page");
      }
      this.g.setVisibility(0);
      this.h.setVisibility(8);
      this.f.setVisibility(0);
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreateSubscribers(@NonNull Map<Subscriber, String> paramMap)
  {
    super.onCreateSubscribers(paramMap);
    paramMap.put(new StoryMessageListActivity.UpdateUserInfoEventReceiver(this), "");
    paramMap.put(new StoryMessageListActivity.TroopNickNameUpdateEventReceiver(this), "");
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.c.a(paramInt))
    {
      Object localObject = this.c.b(paramInt);
      if (localObject == null) {
        return;
      }
      a((MessageData)localObject, paramView);
      paramInt = ((MessageData)localObject).t;
      if (paramInt != 0)
      {
        if (paramInt != 4)
        {
          if (paramInt != 104) {
            switch (paramInt)
            {
            default: 
              paramInt = 0;
              break;
            case 101: 
              paramInt = 9;
              break;
            case 100: 
              paramInt = 7;
              break;
            case 99: 
              if (((MessageData)localObject).D == 0) {
                paramInt = 6;
              } else {
                paramInt = 5;
              }
              break;
            }
          } else {
            paramInt = 8;
          }
        }
        else {
          paramInt = 3;
        }
      }
      else
      {
        paramAdapterView = ((UserManager)SuperManager.a(2)).b(((MessageData)localObject).c);
        if ((paramAdapterView != null) && (paramAdapterView.isFriend())) {
          paramInt = 1;
        } else if ((paramAdapterView != null) && (paramAdapterView.isSubscribe())) {
          paramInt = 2;
        } else {
          paramInt = 4;
        }
      }
      int i1 = ((MessageData)localObject).d;
      paramView = "1";
      switch (i1)
      {
      default: 
        paramAdapterView = "";
        break;
      case 9: 
        paramAdapterView = "9";
        break;
      case 8: 
        paramAdapterView = "10";
        break;
      case 7: 
        paramAdapterView = "8";
        break;
      case 6: 
        paramAdapterView = "11";
        break;
      case 5: 
        paramAdapterView = "7";
        break;
      case 4: 
        paramAdapterView = "6";
        break;
      case 3: 
        if (QQStoryContext.a().b(((MessageData)localObject).l)) {
          paramAdapterView = "3";
        }
        break;
      }
      do
      {
        do
        {
          paramAdapterView = "4";
          break;
        } while (!QQStoryContext.a().b(((MessageData)localObject).i));
        paramAdapterView = "1";
        break;
      } while (!QQStoryContext.a().b(((MessageData)localObject).i));
      paramAdapterView = "2";
      if (((MessageData)localObject).e) {
        paramView = "4";
      }
      localObject = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().i());
      if ((localObject != null) && (((QQUserUIItem)localObject).isVip)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      StoryReportor.a("play_video", "clk_msg", i1, paramInt, new String[] { paramAdapterView, paramView, this.r, "" });
      return;
    }
    paramInt = this.i;
    if (paramInt == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList", 2, "click retry");
      }
    }
    else if (paramInt == 2)
    {
      if (this.l == 2) {
        this.l = 3;
      } else {
        this.l = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList", 2, "convert to list");
      }
      StoryReportor.a("play_video", "clk_more", 0, 0, new String[] { "", "", "", "" });
    }
    this.m = true;
    b(this.a.size());
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.c.a(paramInt))
    {
      paramAdapterView = this.o;
      if ((paramAdapterView != null) && (paramAdapterView.isShowing())) {
        this.o.dismiss();
      }
      paramView.setSelected(true);
      if (this.p == null)
      {
        this.p = new QQCustomMenu();
        this.p.a(2131442651, HardCodeUtil.a(2131911835));
      }
      this.o = BubbleContextMenu.a(paramView, this.p, new StoryMessageListActivity.6(this, paramInt), new StoryMessageListActivity.7(this, paramView));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity
 * JD-Core Version:    0.7.0.1
 */