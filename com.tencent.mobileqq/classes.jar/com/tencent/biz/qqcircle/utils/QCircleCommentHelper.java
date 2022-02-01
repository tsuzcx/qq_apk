package com.tencent.biz.qqcircle.utils;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.comment.QCircleCommentBusiness;
import com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleCommentHelper
  implements SimpleEventReceiver
{
  private static volatile QCircleCommentHelper a;
  private Map<String, String> b = new HashMap();
  private Map<String, List<QCircleFeedCommentInfo>> c = new HashMap();
  private WeakReference<QCircleCommentInputPopupWindow> d;
  private FeedCloudMeta.StFeed e;
  private FeedCloudMeta.StComment f;
  private FeedCloudMeta.StReply g;
  private WeakReference<QCircleCommentHelper.CommentInputListener> h;
  private Map<String, WeakReference<QCircleCommentHelper.QCircleCommentUpdateListener>> i = new ConcurrentHashMap();
  
  private QCircleCommentHelper()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public static QCircleCommentHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleCommentHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    } else {
      localStringBuilder.append("0");
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString2);
    }
    else
    {
      localStringBuilder.append("&&");
      localStringBuilder.append("0");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString3);
    }
    else
    {
      localStringBuilder.append("&&");
      localStringBuilder.append("0");
    }
    return localStringBuilder.toString();
  }
  
  private void a(QCircleCommentInputPopupWindow paramQCircleCommentInputPopupWindow, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, QCircleCommentHelper.CommentInputListener paramCommentInputListener, int paramInt)
  {
    if (paramQCircleCommentInputPopupWindow == null) {
      return;
    }
    paramQCircleCommentInputPopupWindow.setOnShowListener(new QCircleCommentHelper.3(this, paramStFeed, paramStComment, paramStReply, paramQCircleCommentInputPopupWindow));
    paramQCircleCommentInputPopupWindow.a(new QCircleCommentHelper.4(this, paramQCircleCommentInputPopupWindow, paramStFeed, paramStComment, paramStReply, paramCommentInputListener, paramInt));
  }
  
  private void a(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    String str = paramQCircleCommentUpdateEvent.comment.id.get();
    Iterator localIterator1 = this.c.keySet().iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        return;
      }
      Object localObject2 = (String)localIterator1.next();
      if (((String)localObject2).startsWith(str))
      {
        Object localObject1 = (List)this.c.get(localObject2);
        if (localObject1 != null)
        {
          Iterator localIterator2 = ((List)localObject1).iterator();
          if (localIterator2.hasNext())
          {
            QCircleFeedCommentInfo localQCircleFeedCommentInfo = (QCircleFeedCommentInfo)localIterator2.next();
            if (!localQCircleFeedCommentInfo.c.id.get().equals(paramQCircleCommentUpdateEvent.reply.id.get())) {
              break;
            }
            ((List)localObject1).remove(localQCircleFeedCommentInfo);
            localObject2 = (WeakReference)this.i.get(localObject2);
            if (localObject2 != null)
            {
              localObject2 = (QCircleCommentHelper.QCircleCommentUpdateListener)((WeakReference)localObject2).get();
              if (localObject2 != null) {
                ((QCircleCommentHelper.QCircleCommentUpdateListener)localObject2).a((List)localObject1);
              }
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("removeTargetReply");
            ((StringBuilder)localObject1).append(localQCircleFeedCommentInfo.c.id.get());
            QLog.d("QCircleCommentHelper", 1, ((StringBuilder)localObject1).toString());
          }
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("storeComment storeKey: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" comment: ");
    localStringBuilder.append(paramString2);
    QLog.d("QCircleCommentHelper", 1, localStringBuilder.toString());
    this.b.put(paramString1, paramString2);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  private void b(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    String str = paramQCircleCommentUpdateEvent.comment.id.get();
    Iterator localIterator = this.c.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Object localObject1 = (String)localIterator.next();
      if (((String)localObject1).startsWith(str))
      {
        localObject1 = (List)this.c.get(localObject1);
        if (localObject1 != null)
        {
          Object localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (QCircleFeedCommentInfo)((Iterator)localObject2).next();
            if (!((QCircleFeedCommentInfo)localObject1).c.id.get().equals(paramQCircleCommentUpdateEvent.fakeReplyId)) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("replaceFakeReply PreFakeReplyId:");
            ((StringBuilder)localObject2).append(paramQCircleCommentUpdateEvent.fakeReplyId);
            ((StringBuilder)localObject2).append(" replaceId:");
            ((StringBuilder)localObject2).append(paramQCircleCommentUpdateEvent.reply.id.get());
            QLog.d("QCircleCommentHelper", 1, ((StringBuilder)localObject2).toString());
            ((QCircleFeedCommentInfo)localObject1).c.set(paramQCircleCommentUpdateEvent.reply);
          }
        }
      }
    }
  }
  
  private String c(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    String str = "";
    if (paramStFeed != null) {
      paramStFeed = paramStFeed.id.get();
    } else {
      paramStFeed = "";
    }
    if (paramStComment != null) {
      paramStComment = paramStComment.id.get();
    } else {
      paramStComment = "";
    }
    if (paramStReply != null) {
      str = paramStReply.id.get();
    }
    return a(paramStFeed, paramStComment, str);
  }
  
  private QCircleCommentBusiness d()
  {
    return QCircleCommentBusiness.a();
  }
  
  public String a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser != null)
      {
        paramStReply = String.format(HardCodeUtil.a(2131889232), new Object[] { paramStReply.postUser.nick.get() });
        paramStComment = paramStReply;
        if (paramStReply.length() > 10)
        {
          paramStComment = paramStReply.substring(0, 10);
          paramStReply = new StringBuilder();
          paramStReply.append(paramStComment);
          paramStReply.append("...");
          paramStComment = paramStReply.toString();
        }
        return paramStComment;
      }
    }
    else if ((paramStComment != null) && (paramStComment.postUser != null))
    {
      paramStReply = String.format(HardCodeUtil.a(2131889232), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
      if (paramStReply.length() > 10)
      {
        paramStComment = paramStReply.substring(0, 10);
        paramStReply = new StringBuilder();
        paramStReply.append(paramStComment);
        paramStReply.append("...");
        paramStComment = paramStReply.toString();
      }
      return paramStComment;
    }
    return QCircleConfigHelper.a("qqcircle", "qcircle_comment_input_place_holder", QCircleApplication.APP.getResources().getString(2131895654));
  }
  
  public String a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    paramStFeed = c(paramStFeed, paramStComment, paramStReply);
    if (this.b.containsKey(paramStFeed))
    {
      paramStComment = new StringBuilder();
      paramStComment.append("getComment storeKey: ");
      paramStComment.append(paramStFeed);
      paramStComment.append(" preCommentText: ");
      paramStComment.append((String)this.b.get(paramStFeed));
      QLog.d("QCircleCommentHelper", 1, paramStComment.toString());
      return (String)this.b.get(paramStFeed);
    }
    paramStComment = new StringBuilder();
    paramStComment.append("getComment storeKey: ");
    paramStComment.append(paramStFeed);
    paramStComment.append(" preCommentText doesn't exit");
    QLog.d("QCircleCommentHelper", 1, paramStComment.toString());
    return "";
  }
  
  public List<QCircleFeedCommentInfo> a(String paramString)
  {
    return (List)this.c.get(paramString);
  }
  
  public List<QCircleFeedCommentInfo> a(String paramString, QCircleFeedCommentInfo paramQCircleFeedCommentInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQCircleFeedCommentInfo != null))
    {
      if (this.c == null) {
        this.c = new HashMap();
      }
      List localList = (List)this.c.get(paramString);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      ((List)localObject).add(paramQCircleFeedCommentInfo);
      this.c.put(paramString, localObject);
      return localObject;
    }
    QLog.d("QCircleCommentHelper", 1, "addFakeReply param error");
    return null;
  }
  
  public void a(Activity paramActivity, QCircleFeedCommentInfo paramQCircleFeedCommentInfo, QCircleCommentHelper.CommentInputListener paramCommentInputListener, boolean paramBoolean)
  {
    a(paramActivity, paramQCircleFeedCommentInfo, paramCommentInputListener, paramBoolean, 100);
  }
  
  public void a(Activity paramActivity, QCircleFeedCommentInfo paramQCircleFeedCommentInfo, QCircleCommentHelper.CommentInputListener paramCommentInputListener, boolean paramBoolean, int paramInt)
  {
    if ((paramActivity != null) && (paramQCircleFeedCommentInfo != null))
    {
      FeedCloudMeta.StFeed localStFeed = paramQCircleFeedCommentInfo.a;
      FeedCloudMeta.StComment localStComment = paramQCircleFeedCommentInfo.b;
      FeedCloudMeta.StReply localStReply = paramQCircleFeedCommentInfo.c;
      b(this.e, this.f, this.g);
      this.h = new WeakReference(paramCommentInputListener);
      QCircleCommentInputPopupWindow localQCircleCommentInputPopupWindow = new QCircleCommentInputPopupWindow(paramActivity);
      this.d = new WeakReference(localQCircleCommentInputPopupWindow);
      localQCircleCommentInputPopupWindow.b(a(localStComment, localStReply));
      localQCircleCommentInputPopupWindow.a(new QCircleCommentHelper.1(this, paramActivity, localQCircleCommentInputPopupWindow, localStFeed, localStComment, localStReply, paramBoolean, paramInt, paramQCircleFeedCommentInfo));
      if (paramInt > 100) {
        localQCircleCommentInputPopupWindow.a(new QCircleCommentHelper.2(this, paramQCircleFeedCommentInfo, paramInt));
      }
      a(localQCircleCommentInputPopupWindow, localStFeed, localStComment, localStReply, paramCommentInputListener, paramInt);
      localQCircleCommentInputPopupWindow.a(false);
      return;
    }
    QLog.e("QCircleCommentHelper", 1, "showInputPopupWindow param error");
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, String paramString)
  {
    a(c(paramStFeed, paramStComment, paramStReply), paramString);
  }
  
  public void a(String paramString, QCircleCommentHelper.QCircleCommentUpdateListener paramQCircleCommentUpdateListener)
  {
    if (paramQCircleCommentUpdateListener != null)
    {
      paramQCircleCommentUpdateListener = new WeakReference(paramQCircleCommentUpdateListener);
      this.i.put(paramString, paramQCircleCommentUpdateListener);
    }
  }
  
  public int b()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (QCircleCommentInputPopupWindow)((WeakReference)localObject).get();
      if (localObject != null) {
        return ((QCircleCommentInputPopupWindow)localObject).i();
      }
    }
    return 0;
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.e = paramStFeed;
    this.f = paramStComment;
    this.g = paramStReply;
  }
  
  public void c()
  {
    this.c.clear();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCircleAtUpdateEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent))
    {
      paramSimpleBaseEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      if ((paramSimpleBaseEvent.eventStatus != 6) && (paramSimpleBaseEvent.eventStatus != 10))
      {
        if (paramSimpleBaseEvent.eventStatus == 5) {
          b(paramSimpleBaseEvent);
        }
      }
      else {
        a(paramSimpleBaseEvent);
      }
    }
    else if ((paramSimpleBaseEvent instanceof QCircleAtUpdateEvent))
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        localObject = (QCircleCommentInputPopupWindow)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (paramSimpleBaseEvent.mHashCode != ((QCircleCommentInputPopupWindow)localObject).n()) {
            return;
          }
          ((QCircleCommentInputPopupWindow)localObject).a((QCircleAtUpdateEvent)paramSimpleBaseEvent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleCommentHelper
 * JD-Core Version:    0.7.0.1
 */