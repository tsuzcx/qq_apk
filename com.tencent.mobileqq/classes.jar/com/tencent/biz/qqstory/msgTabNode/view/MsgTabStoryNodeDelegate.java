package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.OnMsgTabNodeListLoadListener;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader;
import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgTabStoryNodeDelegate
  implements MsgTabNodeListLoader.OnMsgTabNodeListLoadListener, IEventReceiver
{
  protected MsgTabNodeListLoader a;
  protected MsgTabStoryNodeListManager b;
  protected MsgTabStoryNodeAdapter c;
  protected List<Subscriber> d;
  MsgTabStoryVideoPreloader e;
  boolean f = false;
  protected QQAppInterface g;
  protected boolean h = false;
  private final QQStoryObserver i = new MsgTabStoryNodeDelegate.1(this);
  
  public MsgTabStoryNodeDelegate(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager, MsgTabStoryNodeAdapter paramMsgTabStoryNodeAdapter, QQAppInterface paramQQAppInterface)
  {
    this.b = paramMsgTabStoryNodeListManager;
    this.c = paramMsgTabStoryNodeAdapter;
    this.g = paramQQAppInterface;
  }
  
  private StoryVideoItem a(MsgTabNodeInfo paramMsgTabNodeInfo, @NonNull String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramMsgTabNodeInfo.e.size());
    localArrayList.addAll(paramMsgTabNodeInfo.e);
    int j = 0;
    Object localObject1;
    for (;;)
    {
      int k = localArrayList.size();
      localObject1 = null;
      if (j >= k) {
        break;
      }
      if (TextUtils.equals(((MsgTabNodeVideoInfo)localArrayList.get(j)).c, paramString))
      {
        k = j + 1;
        if (k < localArrayList.size())
        {
          localObject3 = ((MsgTabNodeVideoInfo)localArrayList.get(k)).c;
          localObject2 = ((MsgTabNodeVideoInfo)localArrayList.get(k)).d;
          break label151;
        }
        localObject2 = null;
        localObject3 = localObject2;
        break label151;
      }
      j += 1;
    }
    Object localObject2 = null;
    Object localObject3 = localObject2;
    j = -1;
    label151:
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    if (localObject3 != null)
    {
      StoryVideoItem localStoryVideoItem = localStoryManager.a((String)localObject3);
      localObject1 = localStoryVideoItem;
      if (localStoryVideoItem != null)
      {
        SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramMsgTabNodeInfo.d, localObject3);
        localStoryVideoItem.mAttachedFeedId = ((String)localObject2);
        return localStoryVideoItem;
      }
    }
    localObject2 = localObject1;
    if (j != -1) {
      for (;;)
      {
        localObject2 = localObject1;
        if (j <= 0) {
          break;
        }
        localObject1 = localStoryManager.a(((MsgTabNodeVideoInfo)localArrayList.get(j)).c);
        if (localObject1 != null)
        {
          SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramMsgTabNodeInfo.d, paramString);
          return localObject1;
        }
        j -= 1;
      }
    }
    return localObject2;
  }
  
  private void a(IDataProvider.GroupId paramGroupId, String paramString)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s", paramGroupId, paramString);
    boolean bool = paramGroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId;
    if (!bool) {
      return;
    }
    MsgTabNodeInfo localMsgTabNodeInfo = ((MsgTabStoryManager)this.g.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).b(((MsgTabPlayPageLoader.MsgTabGroupId)paramGroupId).a());
    if (localMsgTabNodeInfo == null)
    {
      SLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s, nodeInfo is null! return!", new Object[] { paramGroupId, paramString });
      return;
    }
    if (localMsgTabNodeInfo.b != 12) {
      return;
    }
    if (bool) {
      Bosses.get().postJob(new MsgTabStoryNodeDelegate.4(this, "Q.qqstory.msgTab.MsgTabStoryNodeDelegate", localMsgTabNodeInfo, paramString));
    }
  }
  
  private void b(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    if ((this.c != null) && (paramMsgTabNodeInfo != null))
    {
      SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, changedData:%s, insertPosition:%s, AdapterList:%s, headerView:%s", paramMsgTabNodeInfo, Integer.valueOf(paramInt), this.c.b(), Integer.valueOf(this.c.d()));
      List localList = this.c.b();
      int j;
      if (localList != null) {
        j = localList.size();
      } else {
        j = 0;
      }
      if ((paramInt >= 0) && (paramInt < j))
      {
        this.c.a(paramMsgTabNodeInfo, paramInt);
        return;
      }
      SLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, insertPosition illegal, list size = %s", new Object[] { Integer.valueOf(j) });
    }
  }
  
  private void b(List<MsgTabNodeInfo> paramList)
  {
    MsgTabStoryNodeAdapter localMsgTabStoryNodeAdapter = this.c;
    if ((localMsgTabStoryNodeAdapter != null) && (paramList != null))
    {
      localMsgTabStoryNodeAdapter.a(paramList);
      a(paramList);
    }
  }
  
  private void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    MsgTabStoryNodeAdapter localMsgTabStoryNodeAdapter = this.c;
    if ((localMsgTabStoryNodeAdapter != null) && (paramMsgTabNodeInfo != null)) {
      localMsgTabStoryNodeAdapter.b(paramMsgTabNodeInfo);
    }
  }
  
  private void c(List<MsgTabNodeInfo> paramList)
  {
    if ((this.c != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.c.b(paramList);
      a(paramList);
    }
  }
  
  public void a()
  {
    this.b.i.notifyDataSetChanged();
  }
  
  protected void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = new ArrayList(((MsgTabNodeListLoader)localObject).c()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)localObject).next();
        if ((localMsgTabNodeInfo != null) && (localMsgTabNodeInfo.b == paramInt)) {
          a(localMsgTabNodeInfo);
        }
      }
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    MsgTabStoryNodeAdapter localMsgTabStoryNodeAdapter = this.c;
    if ((localMsgTabStoryNodeAdapter != null) && (paramMsgTabNodeInfo != null)) {
      localMsgTabStoryNodeAdapter.a(paramMsgTabNodeInfo);
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3) {
          c(paramMsgTabNodeInfo);
        }
      }
      else
      {
        a(paramMsgTabNodeInfo);
        a(Collections.singletonList(paramMsgTabNodeInfo));
        if ((paramBoolean1) && (paramBoolean2))
        {
          SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_UPDATE");
          this.b.g();
        }
      }
    }
    else
    {
      b(paramMsgTabNodeInfo, paramInt2);
      a(Collections.singletonList(paramMsgTabNodeInfo));
      if ((paramBoolean1) && (paramBoolean2))
      {
        SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_INSERT_OR_REPLACE");
        this.b.g();
      }
    }
    if ((paramBoolean1) && (paramMsgTabNodeInfo != null) && (paramMsgTabNodeInfo.b == 8) && (!TextUtils.isEmpty(paramMsgTabNodeInfo.d))) {
      new GetShareGroupInfoHandler(paramMsgTabNodeInfo.d, String.valueOf(System.currentTimeMillis())).a();
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("singleDataChange, data=");
      localStringBuilder.append(paramMsgTabNodeInfo);
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramInt1);
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, localStringBuilder.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = this.h;
    if (bool) {
      c();
    }
    this.g = paramQQAppInterface;
    if (bool) {
      b();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    int i15 = this.c.getItemCount();
    Object localObject1 = "";
    int i11 = 0;
    long l1 = 0L;
    int n = 0;
    int i9 = 0;
    int i8 = 0;
    int i7 = 0;
    int i6 = 0;
    int i14 = 0;
    int i5 = 1;
    int i4 = 0;
    int i3 = 0;
    int i2 = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i1 = 0;
    int i10 = 2;
    Object localObject3;
    label310:
    label326:
    Object localObject2;
    while (i14 < i15)
    {
      localObject3 = (MsgTabNodeInfo)this.c.b(i14);
      int i13;
      int i12;
      if (localObject3 == null)
      {
        i13 = n;
        i12 = j;
      }
      else
      {
        switch (((MsgTabNodeInfo)localObject3).b)
        {
        default: 
          i13 = m;
          i12 = k;
          m = j;
          k = i13;
          j = i12;
        }
        for (;;)
        {
          i12 = i9;
          i9 = i1;
          i1 = j;
          j = n;
          break label603;
          i13 = i9 + 1;
          i12 = i1;
          i9 = n;
          i1 = i13;
          n = i12;
          break label326;
          n += 1;
          long l2 = l1;
          i12 = n;
          i13 = i1;
          if (l1 == 0L)
          {
            localObject1 = ((MsgTabNodeInfo)localObject3).n;
            l2 = ((MsgTabNodeInfo)localObject3).a((String)localObject1);
            i12 = n;
            i13 = i1;
            break label310;
            i13 = i1 + 1;
            i12 = n;
            l2 = l1;
          }
          l1 = l2;
          n = i13;
          i1 = i9;
          i9 = i12;
          i12 = i1;
          i13 = j;
          i1 = k;
          k = m;
          j = i9;
          m = i13;
          i9 = n;
          break label603;
          j += 1;
          break;
          i12 = j;
          j = k + 1;
          k = m;
          m = i12;
          continue;
          i12 = j;
          m += 1;
          j = k;
          k = m;
          m = i12;
          continue;
          i12 = j;
          i6 += 1;
          j = k;
          k = m;
          m = i12;
          continue;
          i12 = j;
          i8 += 1;
          j = k;
          k = m;
          m = i12;
          continue;
          i12 = j;
          if (((MsgTabNodeInfo)localObject3).r > 0) {
            localObject2 = "2";
          } else {
            localObject2 = "1";
          }
          localStringBuilder.append("\"mystory\":");
          localStringBuilder.append((String)localObject2);
          i7 += 1;
          j = k;
          k = m;
          m = i12;
          continue;
          i12 = j;
          i2 += 1;
          j = k;
          k = m;
          m = i12;
          continue;
          i12 = j;
          i3 += 1;
          j = k;
          k = m;
          m = i12;
          continue;
          i12 = j;
          i4 += 1;
          j = k;
          k = m;
          m = i12;
          continue;
          i12 = j;
          i5 += 1;
          j = k;
          k = m;
          m = i12;
        }
        label603:
        if (((MsgTabNodeInfo)localObject3).i != 0) {
          i10 = 1;
        }
        n = i11;
        if (((MsgTabNodeInfo)localObject3).B) {
          n = i11 + 1;
        }
        i13 = i1;
        i11 = i12;
        i1 = i9;
        i9 = k;
        i12 = m;
        k = i13;
        m = i9;
        i9 = i11;
        i13 = j;
        i11 = n;
      }
      i14 += 1;
      n = i13;
      j = i12;
    }
    label1085:
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put(String.valueOf(6), i8);
        ((JSONObject)localObject2).put(String.valueOf(7), i6);
        ((JSONObject)localObject2).put(String.valueOf(8), m);
        ((JSONObject)localObject2).put(String.valueOf(9), k);
        ((JSONObject)localObject2).put(String.valueOf(11), i1);
        ((JSONObject)localObject2).put(String.valueOf(10), j);
        ((JSONObject)localObject2).put(String.valueOf(1), i5);
        ((JSONObject)localObject2).put(String.valueOf(2), i4);
        ((JSONObject)localObject2).put(String.valueOf(3), i3);
        ((JSONObject)localObject2).put(String.valueOf(4), i2);
        ((JSONObject)localObject2).put(String.valueOf(5), i7);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(n);
        ((StringBuilder)localObject3).append(":");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(":");
        ((StringBuilder)localObject3).append(l1);
        ((JSONObject)localObject2).put(String.valueOf(12), ((StringBuilder)localObject3).toString());
        ((JSONObject)localObject2).put(String.valueOf(13), i9);
        if (!TextUtils.equals("exp_story", paramString)) {
          break label1085;
        }
        localStringBuilder.append(",\"text\":");
        localStringBuilder.append("\"");
        try
        {
          localStringBuilder.append(this.b.F.getShotViewName());
          localStringBuilder.append("\"");
          localStringBuilder.append(",\"msg\":");
          localStringBuilder.append(i11);
          localStringBuilder.append("}");
          StoryReportor.a("msg_tab", paramString, 0, i10, new String[] { ((JSONObject)localObject2).toString(), String.valueOf(i15), localStringBuilder.toString(), String.valueOf(paramInt) });
          return;
        }
        catch (JSONException paramString) {}
        localObject1 = new StringBuilder();
      }
      catch (JSONException paramString) {}
      ((StringBuilder)localObject1).append("ReportError:");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      SLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", ((StringBuilder)localObject1).toString());
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    int j = this.c.a(paramString1);
    this.b.o.c.scrollToPosition(j);
    if (!MsgTabStoryUtil.a()) {
      return;
    }
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeDelegate.3(this, paramString1));
  }
  
  public void a(ArrayList<MsgTabNodeInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onDataSetChange() %s, %b, %b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3));
    if (paramBoolean1)
    {
      b(paramArrayList);
      if (this.b.l != 0L)
      {
        StoryReportor.b("msgtab", "data_time", (int)(System.currentTimeMillis() - this.b.l), 0, new String[] { "" });
        this.b.l = 0L;
      }
    }
    else
    {
      c(paramArrayList);
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
        if ((localMsgTabNodeInfo.b == 8) && (!TextUtils.isEmpty(localMsgTabNodeInfo.d))) {
          localArrayList.add(localMsgTabNodeInfo.d);
        }
      }
      if (!localArrayList.isEmpty()) {
        new GetShareGroupInfoHandler(localArrayList, String.valueOf(System.currentTimeMillis())).a();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "dataSetChange dataList = ", paramArrayList });
    }
  }
  
  public void a(List<MsgTabNodeInfo> paramList)
  {
    Context localContext = this.b.m;
    if (!paramList.isEmpty())
    {
      MsgTabStoryVideoPreloader localMsgTabStoryVideoPreloader = this.e;
      if (localMsgTabStoryVideoPreloader != null) {
        localMsgTabStoryVideoPreloader.a(localContext, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    Object localObject = (MsgTabStoryManager)this.g.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
    this.a = ((MsgTabStoryManager)localObject).a();
    this.e = ((MsgTabStoryManager)localObject).b();
    b(this.a.d());
    this.a.a(this);
    this.a.a(1);
    this.d = new ArrayList();
    this.d.add(new MsgTabStoryNodeDelegate.StoryVideoPublishStatusEventReceiver(this));
    this.d.add(new MsgTabStoryNodeDelegate.DeleteStoryVideoEventReceiver(this));
    this.d.add(new MsgTabStoryNodeDelegate.ReadStoryVideoEventReceiver(this));
    this.d.add(new MsgTabStoryNodeDelegate.UpdateUserInfoEventReceiver(this));
    this.d.add(new MsgTabStoryNodeDelegate.GetGroupInfoEventReceiver(this));
    this.d.add(new MsgTabStoryNodeDelegate.PlayModeSwitchNodeReceiver(this));
    this.d.add(new MsgTabStoryNodeDelegate.RequireUserItemEventReceiver(this));
    this.d.add(new MsgTabStoryNodeDelegate.UpdateMsgTabCoverEventReceiver(this));
    this.d.add(new MsgTabStoryNodeDelegate.UpdateMsgTabShotViewEventReceiver(this));
    this.g.addObserver(this.i);
    this.e.a(new MsgTabStoryNodeDelegate.2(this));
    localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Iterator)localObject).next();
      StoryDispatcher.a().registerSubscriber("", localSubscriber);
    }
    this.h = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onAttached");
    }
  }
  
  public void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    QQStoryHandler localQQStoryHandler = (QQStoryHandler)PlayModeUtils.b().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
    String str = paramMsgTabNodeInfo.d;
    if ((paramMsgTabNodeInfo.b == 10) || (paramMsgTabNodeInfo.b == 11)) {
      str = null;
    }
    localQQStoryHandler.a(str, paramMsgTabNodeInfo.b, 1, paramMsgTabNodeInfo.j);
    this.a.c(paramMsgTabNodeInfo);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onDetached");
      }
      this.h = false;
      if (this.a != null) {
        this.a.b(this);
      }
      if (this.d != null)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          Subscriber localSubscriber = (Subscriber)localIterator.next();
          StoryDispatcher.a().unRegisterSubscriber(localSubscriber);
        }
        this.d.clear();
      }
      this.g.removeObserver(this.i);
      if (this.e != null) {
        this.e.a();
      }
      this.c.a();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void d() {}
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate
 * JD-Core Version:    0.7.0.1
 */