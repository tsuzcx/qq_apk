package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.OnMsgTabNodeListLoadListener;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader;
import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import new;
import nex;
import ney;
import nez;
import nfa;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgTabStoryNodeDelegate
  implements MsgTabNodeListLoader.OnMsgTabNodeListLoadListener, IEventReceiver
{
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new new(this);
  protected MsgTabNodeListLoader a;
  MsgTabStoryVideoPreloader jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader;
  protected MsgTabStoryNodeAdapter a;
  public MsgTabStoryNodeListManager a;
  public QQAppInterface a;
  protected List a;
  boolean jdField_a_of_type_Boolean = false;
  protected boolean b;
  
  public MsgTabStoryNodeDelegate(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager, MsgTabStoryNodeAdapter paramMsgTabStoryNodeAdapter, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager = paramMsgTabStoryNodeListManager;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter = paramMsgTabStoryNodeAdapter;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null) && (paramMsgTabNodeInfo != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramMsgTabNodeInfo, paramInt);
    }
  }
  
  private void b(List paramList)
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
  
  private void c(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.b(paramList);
      a(paramList);
    }
  }
  
  public void a()
  {
    Object localObject = (MsgTabStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader = ((MsgTabStoryManager)localObject).a();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader = ((MsgTabStoryManager)localObject).a();
    b(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a());
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(1);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.StoryVideoPublishStatusEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.DeleteStoryVideoEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.ReadStoryVideoEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.UpdateUserInfoEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.GetGroupInfoEventReceiver(this));
    this.jdField_a_of_type_JavaUtilList.add(new MsgTabStoryNodeDelegate.PlayModeSwitchNodeReceiver(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader.a(new nex(this));
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Iterator)localObject).next();
      Dispatchers.get().registerSubscriber("", localSubscriber);
    }
    this.b = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onAttached");
    }
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
  
  protected void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader != null) {
      a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(paramInt, paramLong));
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
    paramMsgTabNodeInfo = (QQStoryHandler)PlayModeUtils.a().a(98);
    if (localQQUserUIItem.isVip()) {}
    for (int i = 1;; i = 0)
    {
      paramMsgTabNodeInfo.a(i, localQQUserUIItem.uid, paramInt, 14);
      return;
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((paramBoolean) && (paramMsgTabNodeInfo != null) && (paramMsgTabNodeInfo.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString))) {
        new GetShareGroupInfoHandler(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, String.valueOf(System.currentTimeMillis())).a();
      }
      if ((paramInt1 == 1) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a())) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a(false);
      }
      ThreadManager.getUIHandler().post(new nez(this, paramBoolean, paramInt1));
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "singleDataChange, data=" + paramMsgTabNodeInfo + ", type=" + paramInt1);
      }
      return;
      b(paramMsgTabNodeInfo, paramInt2);
      a(Collections.singletonList(paramMsgTabNodeInfo));
      continue;
      a(paramMsgTabNodeInfo);
      a(Collections.singletonList(paramMsgTabNodeInfo));
      continue;
      c(paramMsgTabNodeInfo);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = this.b;
    if (bool) {
      b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (bool) {
      a();
    }
  }
  
  public void a(String paramString)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.scrollToPosition(i);
    if (!MsgTabStoryUtil.a()) {
      return;
    }
    ThreadManager.getUIHandler().post(new nfa(this, paramString));
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i7 = 0;
    int i6 = 0;
    int i5 = 0;
    int i4 = 0;
    int i3 = 0;
    int i2 = 0;
    int i1 = 1;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    String str1 = "";
    int i = 2;
    int i9 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.getItemCount();
    int i8 = 0;
    Object localObject;
    while (i8 < i9)
    {
      localObject = (MsgTabNodeInfo)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(i8);
      if (localObject == null)
      {
        i8 += 1;
      }
      else
      {
        switch (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int)
        {
        }
        for (;;)
        {
          if (((MsgTabNodeInfo)localObject).b == 0) {
            break label528;
          }
          i = 1;
          break;
          i7 += 1;
          continue;
          i6 += 1;
          continue;
          i5 += 1;
          continue;
          i4 += 1;
          continue;
          i3 += 1;
          continue;
          i2 += 1;
          continue;
          i1 += 1;
          continue;
          n += 1;
          continue;
          m += 1;
          continue;
          k += 1;
          continue;
          j += 1;
          if (((MsgTabNodeInfo)localObject).c > 0) {
            str1 = "2";
          } else {
            str1 = "1";
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put(String.valueOf(6), i7);
        ((JSONObject)localObject).put(String.valueOf(7), i6);
        ((JSONObject)localObject).put(String.valueOf(8), i5);
        ((JSONObject)localObject).put(String.valueOf(9), i4);
        ((JSONObject)localObject).put(String.valueOf(11), i3);
        ((JSONObject)localObject).put(String.valueOf(10), i2);
        ((JSONObject)localObject).put(String.valueOf(1), i1);
        ((JSONObject)localObject).put(String.valueOf(2), n);
        ((JSONObject)localObject).put(String.valueOf(3), m);
        ((JSONObject)localObject).put(String.valueOf(4), k);
        ((JSONObject)localObject).put(String.valueOf(5), j);
        if (paramBoolean1)
        {
          String str2 = ((JSONObject)localObject).toString();
          if (paramBoolean2)
          {
            localObject = "push";
            StoryReportor.a("msg_tab", paramString, 0, i, new String[] { str2, String.valueOf(i9), str1, localObject });
            return;
          }
          localObject = "";
          continue;
        }
      }
      catch (JSONException paramString)
      {
        SLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "ReportError:" + paramString.getMessage());
        return;
      }
      label528:
      i = 0;
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
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
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a()) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a(true);
      }
    }
    ThreadManager.getUIHandler().post(new ney(this, paramBoolean1, paramBoolean3));
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "dataSetChange dataList = ", paramArrayList });
    }
  }
  
  public void a(List paramList)
  {
    Context localContext = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_a_of_type_AndroidContentContext;
    if ((!paramList.isEmpty()) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader.a(localContext, paramList);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
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
          Dispatchers.get().unRegisterSubscriber(localSubscriber);
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
  
  public void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    QQStoryHandler localQQStoryHandler = (QQStoryHandler)PlayModeUtils.a().a(98);
    String str = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    if ((paramMsgTabNodeInfo.jdField_a_of_type_Int == 10) || (paramMsgTabNodeInfo.jdField_a_of_type_Int == 11)) {
      str = null;
    }
    localQQStoryHandler.a(str, paramMsgTabNodeInfo.jdField_a_of_type_Int, 1, paramMsgTabNodeInfo.e);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(paramMsgTabNodeInfo);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    ((MsgTabStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250)).a().b();
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate
 * JD-Core Version:    0.7.0.1
 */