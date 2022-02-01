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
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
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
    String str;
    Object localObject;
    if (i < localArrayList.size()) {
      if (TextUtils.equals(((MsgTabNodeVideoInfo)localArrayList.get(i)).jdField_a_of_type_JavaLangString, paramString))
      {
        if (i + 1 >= localArrayList.size()) {
          break label244;
        }
        str = ((MsgTabNodeVideoInfo)localArrayList.get(i + 1)).jdField_a_of_type_JavaLangString;
        localObject = ((MsgTabNodeVideoInfo)localArrayList.get(i + 1)).b;
      }
    }
    for (;;)
    {
      StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
      StoryVideoItem localStoryVideoItem;
      if (str != null)
      {
        localStoryVideoItem = localStoryManager.a(str);
        if (localStoryVideoItem != null)
        {
          SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, str);
          localStoryVideoItem.mAttachedFeedId = ((String)localObject);
          return localStoryVideoItem;
          i += 1;
          break;
        }
      }
      for (localObject = localStoryVideoItem;; localObject = null)
      {
        if (i != -1)
        {
          while (i > 0)
          {
            localObject = localStoryManager.a(((MsgTabNodeVideoInfo)localArrayList.get(i)).jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, paramString);
              return localObject;
            }
            i -= 1;
          }
          return localObject;
        }
        return localObject;
      }
      label244:
      localObject = null;
      str = null;
      continue;
      i = -1;
      localObject = null;
      str = null;
    }
  }
  
  private void a(IDataProvider.GroupId paramGroupId, String paramString)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s", paramGroupId, paramString);
    if (!(paramGroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId)) {}
    MsgTabNodeInfo localMsgTabNodeInfo;
    do
    {
      return;
      localMsgTabNodeInfo = ((MsgTabStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a(((MsgTabPlayPageLoader.MsgTabGroupId)paramGroupId).a());
      if (localMsgTabNodeInfo == null)
      {
        SLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s, nodeInfo is null! return!", new Object[] { paramGroupId, paramString });
        return;
      }
    } while ((localMsgTabNodeInfo.jdField_a_of_type_Int != 12) || (!(paramGroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId)));
    Bosses.get().postJob(new MsgTabStoryNodeDelegate.4(this, "Q.qqstory.msgTab.MsgTabStoryNodeDelegate", localMsgTabNodeInfo, paramString));
  }
  
  private void b(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    List localList;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null) && (paramMsgTabNodeInfo != null))
    {
      SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, changedData:%s, insertPosition:%s, AdapterList:%s, headerView:%s", paramMsgTabNodeInfo, Integer.valueOf(paramInt), this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.b()));
      localList = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a();
      if (localList == null) {
        break label90;
      }
    }
    label90:
    for (int i = localList.size(); (paramInt < 0) || (paramInt >= i); i = 0)
    {
      SLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, insertPosition illegal, list size = %s", new Object[] { Integer.valueOf(i) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramMsgTabNodeInfo, paramInt);
  }
  
  private void b(List<MsgTabNodeInfo> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null) && (paramList != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramList);
      a(paramList);
    }
  }
  
  private void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null) && (paramMsgTabNodeInfo != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramMsgTabNodeInfo);
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader != null)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a()).iterator();
      while (localIterator.hasNext())
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
        if ((localMsgTabNodeInfo != null) && (localMsgTabNodeInfo.jdField_a_of_type_Int == paramInt)) {
          a(localMsgTabNodeInfo);
        }
      }
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null) && (paramMsgTabNodeInfo != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramMsgTabNodeInfo);
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    if (localQQUserUIItem == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "SUBSCRIBE failed: user is null, unionId = " + paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    paramMsgTabNodeInfo = (QQStoryHandler)PlayModeUtils.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
    if (localQQUserUIItem.isVip()) {}
    for (int i = 1;; i = 0)
    {
      paramMsgTabNodeInfo.a(i, localQQUserUIItem.uid, paramInt, 14);
      return;
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((paramBoolean1) && (paramMsgTabNodeInfo != null) && (paramMsgTabNodeInfo.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString))) {
        new GetShareGroupInfoHandler(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, String.valueOf(System.currentTimeMillis())).a();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "singleDataChange, data=" + paramMsgTabNodeInfo + ", type=" + paramInt1);
      }
      return;
      b(paramMsgTabNodeInfo, paramInt2);
      a(Collections.singletonList(paramMsgTabNodeInfo));
      if ((paramBoolean1) && (paramBoolean2))
      {
        SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_INSERT_OR_REPLACE");
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.g();
        continue;
        a(paramMsgTabNodeInfo);
        a(Collections.singletonList(paramMsgTabNodeInfo));
        if ((paramBoolean1) && (paramBoolean2))
        {
          SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_UPDATE");
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.g();
          continue;
          c(paramMsgTabNodeInfo);
        }
      }
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
    int i9 = 0;
    int i8 = 0;
    int i7 = 0;
    int i6 = 0;
    int i5 = 0;
    int i4 = 0;
    int i3 = 1;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    int i10 = 0;
    int k = 0;
    int i = 0;
    long l1 = 0L;
    String str = "";
    StringBuilder localStringBuilder = new StringBuilder("{");
    int j = 2;
    int i25 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.getItemCount();
    int i23 = 0;
    MsgTabNodeInfo localMsgTabNodeInfo;
    if (i23 < i25)
    {
      localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(i23);
      if (localMsgTabNodeInfo != null) {}
    }
    for (;;)
    {
      i23 += 1;
      break;
      int i21;
      int i20;
      int i19;
      int i18;
      int i17;
      int i16;
      int i15;
      int i14;
      int i13;
      int i12;
      int i11;
      int i22;
      long l2;
      switch (localMsgTabNodeInfo.jdField_a_of_type_Int)
      {
      default: 
        i21 = i9;
        i20 = i8;
        i19 = i7;
        i18 = i6;
        i17 = i5;
        i16 = i4;
        i15 = i3;
        i14 = i2;
        i13 = i1;
        i12 = n;
        i11 = m;
        i22 = k;
        l2 = l1;
      }
      Object localObject;
      for (;;)
      {
        if (localMsgTabNodeInfo.b != 0) {
          j = 1;
        }
        if (!localMsgTabNodeInfo.c) {
          break label1523;
        }
        i += 1;
        l1 = l2;
        k = i22;
        m = i11;
        n = i12;
        i1 = i13;
        i2 = i14;
        i3 = i15;
        i4 = i16;
        i5 = i17;
        i6 = i18;
        i7 = i19;
        i8 = i20;
        i9 = i21;
        break;
        i21 = i9 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        continue;
        i20 = i8 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i21 = i9;
        continue;
        i19 = i7 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i20 = i8;
        i21 = i9;
        continue;
        i18 = i6 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i17 = i5 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i16 = i4 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i15 = i3 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i14 = i2 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i13 = i1 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i12 = n + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i11 = m + 1;
        if (localMsgTabNodeInfo.d > 0) {}
        for (localObject = "2";; localObject = "1")
        {
          localStringBuilder.append("\"mystory\":").append((String)localObject);
          l2 = l1;
          i22 = k;
          i12 = n;
          i13 = i1;
          i14 = i2;
          i15 = i3;
          i16 = i4;
          i17 = i5;
          i18 = i6;
          i19 = i7;
          i20 = i8;
          i21 = i9;
          break;
        }
        int i24 = i10 + 1;
        l2 = l1;
        i22 = k;
        i10 = i24;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        if (l1 == 0L)
        {
          str = localMsgTabNodeInfo.jdField_e_of_type_JavaLangString;
          l2 = localMsgTabNodeInfo.a(str);
          i22 = k;
          i10 = i24;
          i11 = m;
          i12 = n;
          i13 = i1;
          i14 = i2;
          i15 = i3;
          i16 = i4;
          i17 = i5;
          i18 = i6;
          i19 = i7;
          i20 = i8;
          i21 = i9;
          continue;
          i22 = k + 1;
          l2 = l1;
          i11 = m;
          i12 = n;
          i13 = i1;
          i14 = i2;
          i15 = i3;
          i16 = i4;
          i17 = i5;
          i18 = i6;
          i19 = i7;
          i20 = i8;
          i21 = i9;
        }
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put(String.valueOf(6), i9);
        ((JSONObject)localObject).put(String.valueOf(7), i8);
        ((JSONObject)localObject).put(String.valueOf(8), i7);
        ((JSONObject)localObject).put(String.valueOf(9), i6);
        ((JSONObject)localObject).put(String.valueOf(11), i5);
        ((JSONObject)localObject).put(String.valueOf(10), i4);
        ((JSONObject)localObject).put(String.valueOf(1), i3);
        ((JSONObject)localObject).put(String.valueOf(2), i2);
        ((JSONObject)localObject).put(String.valueOf(3), i1);
        ((JSONObject)localObject).put(String.valueOf(4), n);
        ((JSONObject)localObject).put(String.valueOf(5), m);
        ((JSONObject)localObject).put(String.valueOf(12), i10 + ":" + str + ":" + l1);
        ((JSONObject)localObject).put(String.valueOf(13), k);
        if (TextUtils.equals("exp_story", paramString))
        {
          localStringBuilder.append(",\"text\":").append("\"").append(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a()).append("\"");
          localStringBuilder.append(",\"msg\":").append(i);
        }
        localStringBuilder.append("}");
        StoryReportor.a("msg_tab", paramString, 0, j, new String[] { ((JSONObject)localObject).toString(), String.valueOf(i25), localStringBuilder.toString(), String.valueOf(paramInt) });
        return;
      }
      catch (JSONException paramString)
      {
        SLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "ReportError:" + paramString.getMessage());
        return;
      }
      label1523:
      l1 = l2;
      k = i22;
      m = i11;
      n = i12;
      i1 = i13;
      i2 = i14;
      i3 = i15;
      i4 = i16;
      i5 = i17;
      i6 = i18;
      i7 = i19;
      i8 = i20;
      i9 = i21;
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
    while ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
          if ((localMsgTabNodeInfo.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(localMsgTabNodeInfo.jdField_a_of_type_JavaLangString)))
          {
            localArrayList.add(localMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
            continue;
            c(paramArrayList);
            break;
          }
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
    if ((!paramList.isEmpty()) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader.a(localContext, paramList);
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
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader.a();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a();
  }
  
  public void d() {}
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate
 * JD-Core Version:    0.7.0.1
 */