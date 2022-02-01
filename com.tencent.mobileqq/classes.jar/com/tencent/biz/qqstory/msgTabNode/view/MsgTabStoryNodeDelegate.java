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
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new MsgTabStoryNodeDelegate.1(this);
  protected MsgTabNodeListLoader a;
  MsgTabStoryVideoPreloader jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader;
  protected MsgTabStoryNodeAdapter a;
  protected MsgTabStoryNodeListManager a;
  protected QQAppInterface a;
  protected List<Subscriber> a;
  boolean jdField_a_of_type_Boolean = false;
  protected boolean b = false;
  
  public MsgTabStoryNodeDelegate(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager, MsgTabStoryNodeAdapter paramMsgTabStoryNodeAdapter, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager = paramMsgTabStoryNodeListManager;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter = paramMsgTabStoryNodeAdapter;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private StoryVideoItem a(MsgTabNodeInfo paramMsgTabNodeInfo, @NonNull String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size());
    localArrayList.addAll(paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList);
    int i = 0;
    Object localObject1;
    for (;;)
    {
      int j = localArrayList.size();
      localObject1 = null;
      if (i >= j) {
        break;
      }
      if (TextUtils.equals(((MsgTabNodeVideoInfo)localArrayList.get(i)).jdField_a_of_type_JavaLangString, paramString))
      {
        j = i + 1;
        if (j < localArrayList.size())
        {
          localObject3 = ((MsgTabNodeVideoInfo)localArrayList.get(j)).jdField_a_of_type_JavaLangString;
          localObject2 = ((MsgTabNodeVideoInfo)localArrayList.get(j)).b;
          break label151;
        }
        localObject2 = null;
        localObject3 = localObject2;
        break label151;
      }
      i += 1;
    }
    Object localObject2 = null;
    Object localObject3 = localObject2;
    i = -1;
    label151:
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    if (localObject3 != null)
    {
      StoryVideoItem localStoryVideoItem = localStoryManager.a((String)localObject3);
      localObject1 = localStoryVideoItem;
      if (localStoryVideoItem != null)
      {
        SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, localObject3);
        localStoryVideoItem.mAttachedFeedId = ((String)localObject2);
        return localStoryVideoItem;
      }
    }
    localObject2 = localObject1;
    if (i != -1) {
      for (;;)
      {
        localObject2 = localObject1;
        if (i <= 0) {
          break;
        }
        localObject1 = localStoryManager.a(((MsgTabNodeVideoInfo)localArrayList.get(i)).jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, paramString);
          return localObject1;
        }
        i -= 1;
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
    MsgTabNodeInfo localMsgTabNodeInfo = ((MsgTabStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a(((MsgTabPlayPageLoader.MsgTabGroupId)paramGroupId).a());
    if (localMsgTabNodeInfo == null)
    {
      SLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s, nodeInfo is null! return!", new Object[] { paramGroupId, paramString });
      return;
    }
    if (localMsgTabNodeInfo.jdField_a_of_type_Int != 12) {
      return;
    }
    if (bool) {
      Bosses.get().postJob(new MsgTabStoryNodeDelegate.4(this, "Q.qqstory.msgTab.MsgTabStoryNodeDelegate", localMsgTabNodeInfo, paramString));
    }
  }
  
  private void b(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null) && (paramMsgTabNodeInfo != null))
    {
      SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, changedData:%s, insertPosition:%s, AdapterList:%s, headerView:%s", paramMsgTabNodeInfo, Integer.valueOf(paramInt), this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.b()));
      List localList = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a();
      int i;
      if (localList != null) {
        i = localList.size();
      } else {
        i = 0;
      }
      if ((paramInt >= 0) && (paramInt < i))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramMsgTabNodeInfo, paramInt);
        return;
      }
      SLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, insertPosition illegal, list size = %s", new Object[] { Integer.valueOf(i) });
    }
  }
  
  private void b(List<MsgTabNodeInfo> paramList)
  {
    MsgTabStoryNodeAdapter localMsgTabStoryNodeAdapter = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter;
    if ((localMsgTabStoryNodeAdapter != null) && (paramList != null))
    {
      localMsgTabStoryNodeAdapter.a(paramList);
      a(paramList);
    }
  }
  
  private void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    MsgTabStoryNodeAdapter localMsgTabStoryNodeAdapter = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter;
    if ((localMsgTabStoryNodeAdapter != null) && (paramMsgTabNodeInfo != null)) {
      localMsgTabStoryNodeAdapter.a(paramMsgTabNodeInfo);
    }
  }
  
  private void c(List<MsgTabNodeInfo> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.b(paramList);
      a(paramList);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.notifyDataSetChanged();
  }
  
  protected void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader;
    if (localObject != null)
    {
      localObject = new ArrayList(((MsgTabNodeListLoader)localObject).a()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)localObject).next();
        if ((localMsgTabNodeInfo != null) && (localMsgTabNodeInfo.jdField_a_of_type_Int == paramInt)) {
          a(localMsgTabNodeInfo);
        }
      }
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    MsgTabStoryNodeAdapter localMsgTabStoryNodeAdapter = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter;
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
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.g();
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
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.g();
      }
    }
    if ((paramBoolean1) && (paramMsgTabNodeInfo != null) && (paramMsgTabNodeInfo.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString))) {
      new GetShareGroupInfoHandler(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, String.valueOf(System.currentTimeMillis())).a();
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
    boolean bool = this.b;
    if (bool) {
      c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (bool) {
      b();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    int i14 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.getItemCount();
    Object localObject1 = "";
    int i10 = 0;
    long l1 = 0L;
    int m = 0;
    int i8 = 0;
    int i7 = 0;
    int i6 = 0;
    int i5 = 0;
    int i13 = 0;
    int i4 = 1;
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    int n = 0;
    int i9 = 2;
    Object localObject3;
    label310:
    label326:
    Object localObject2;
    while (i13 < i14)
    {
      localObject3 = (MsgTabNodeInfo)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(i13);
      int i12;
      int i11;
      if (localObject3 == null)
      {
        i12 = m;
        i11 = i;
      }
      else
      {
        switch (((MsgTabNodeInfo)localObject3).jdField_a_of_type_Int)
        {
        default: 
          i12 = k;
          i11 = j;
          k = i;
          j = i12;
          i = i11;
        }
        for (;;)
        {
          i11 = i8;
          i8 = n;
          n = i;
          i = m;
          break label603;
          i12 = i8 + 1;
          i11 = n;
          i8 = m;
          n = i12;
          m = i11;
          break label326;
          m += 1;
          long l2 = l1;
          i11 = m;
          i12 = n;
          if (l1 == 0L)
          {
            localObject1 = ((MsgTabNodeInfo)localObject3).jdField_e_of_type_JavaLangString;
            l2 = ((MsgTabNodeInfo)localObject3).a((String)localObject1);
            i11 = m;
            i12 = n;
            break label310;
            i12 = n + 1;
            i11 = m;
            l2 = l1;
          }
          l1 = l2;
          m = i12;
          n = i8;
          i8 = i11;
          i11 = n;
          i12 = i;
          n = j;
          j = k;
          i = i8;
          k = i12;
          i8 = m;
          break label603;
          i += 1;
          break;
          i11 = i;
          i = j + 1;
          j = k;
          k = i11;
          continue;
          i11 = i;
          k += 1;
          i = j;
          j = k;
          k = i11;
          continue;
          i11 = i;
          i5 += 1;
          i = j;
          j = k;
          k = i11;
          continue;
          i11 = i;
          i7 += 1;
          i = j;
          j = k;
          k = i11;
          continue;
          i11 = i;
          if (((MsgTabNodeInfo)localObject3).d > 0) {
            localObject2 = "2";
          } else {
            localObject2 = "1";
          }
          localStringBuilder.append("\"mystory\":");
          localStringBuilder.append((String)localObject2);
          i6 += 1;
          i = j;
          j = k;
          k = i11;
          continue;
          i11 = i;
          i1 += 1;
          i = j;
          j = k;
          k = i11;
          continue;
          i11 = i;
          i2 += 1;
          i = j;
          j = k;
          k = i11;
          continue;
          i11 = i;
          i3 += 1;
          i = j;
          j = k;
          k = i11;
          continue;
          i11 = i;
          i4 += 1;
          i = j;
          j = k;
          k = i11;
        }
        label603:
        if (((MsgTabNodeInfo)localObject3).b != 0) {
          i9 = 1;
        }
        m = i10;
        if (((MsgTabNodeInfo)localObject3).c) {
          m = i10 + 1;
        }
        i12 = n;
        i10 = i11;
        n = i8;
        i8 = j;
        i11 = k;
        j = i12;
        k = i8;
        i8 = i10;
        i12 = i;
        i10 = m;
      }
      i13 += 1;
      m = i12;
      i = i11;
    }
    label1085:
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put(String.valueOf(6), i7);
        ((JSONObject)localObject2).put(String.valueOf(7), i5);
        ((JSONObject)localObject2).put(String.valueOf(8), k);
        ((JSONObject)localObject2).put(String.valueOf(9), j);
        ((JSONObject)localObject2).put(String.valueOf(11), n);
        ((JSONObject)localObject2).put(String.valueOf(10), i);
        ((JSONObject)localObject2).put(String.valueOf(1), i4);
        ((JSONObject)localObject2).put(String.valueOf(2), i3);
        ((JSONObject)localObject2).put(String.valueOf(3), i2);
        ((JSONObject)localObject2).put(String.valueOf(4), i1);
        ((JSONObject)localObject2).put(String.valueOf(5), i6);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(m);
        ((StringBuilder)localObject3).append(":");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(":");
        ((StringBuilder)localObject3).append(l1);
        ((JSONObject)localObject2).put(String.valueOf(12), ((StringBuilder)localObject3).toString());
        ((JSONObject)localObject2).put(String.valueOf(13), i8);
        if (!TextUtils.equals("exp_story", paramString)) {
          break label1085;
        }
        localStringBuilder.append(",\"text\":");
        localStringBuilder.append("\"");
        try
        {
          localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a());
          localStringBuilder.append("\"");
          localStringBuilder.append(",\"msg\":");
          localStringBuilder.append(i10);
          localStringBuilder.append("}");
          StoryReportor.a("msg_tab", paramString, 0, i9, new String[] { ((JSONObject)localObject2).toString(), String.valueOf(i14), localStringBuilder.toString(), String.valueOf(paramInt) });
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
    int i = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramString1);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.scrollToPosition(i);
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
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_Long != 0L)
      {
        StoryReportor.b("msgtab", "data_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_Long), 0, new String[] { "" });
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_Long = 0L;
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
        if ((localMsgTabNodeInfo.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(localMsgTabNodeInfo.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
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
    Context localContext = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_AndroidContentContext;
    if (!paramList.isEmpty())
    {
      MsgTabStoryVideoPreloader localMsgTabStoryVideoPreloader = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader;
      if (localMsgTabStoryVideoPreloader != null) {
        localMsgTabStoryVideoPreloader.a(localContext, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    Object localObject = (MsgTabStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader = ((MsgTabStoryManager)localObject).a();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader = ((MsgTabStoryManager)localObject).a();
    b(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.b());
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(1);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.StoryVideoPublishStatusEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.DeleteStoryVideoEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.ReadStoryVideoEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.UpdateUserInfoEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.GetGroupInfoEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.PlayModeSwitchNodeReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.RequireUserItemEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.UpdateMsgTabCoverEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.UpdateMsgTabShotViewEventReceiver(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader.a(new MsgTabStoryNodeDelegate.2(this));
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Iterator)localObject).next();
      StoryDispatcher.a().registerSubscriber("", localSubscriber);
    }
    this.b = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onAttached");
    }
  }
  
  public void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    QQStoryHandler localQQStoryHandler = (QQStoryHandler)PlayModeUtils.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
    String str = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    if ((paramMsgTabNodeInfo.jdField_a_of_type_Int == 10) || (paramMsgTabNodeInfo.jdField_a_of_type_Int == 11)) {
      str = null;
    }
    localQQStoryHandler.a(str, paramMsgTabNodeInfo.jdField_a_of_type_Int, 1, paramMsgTabNodeInfo.jdField_e_of_type_Long);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.b(paramMsgTabNodeInfo);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onDetached");
      }
      this.b = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.b(this);
      }
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          Subscriber localSubscriber = (Subscriber)localIterator.next();
          StoryDispatcher.a().unRegisterSubscriber(localSubscriber);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader.a();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate
 * JD-Core Version:    0.7.0.1
 */