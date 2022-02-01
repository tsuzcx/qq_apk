package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.DoCommentRequest;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.subscribe.network.DoReplyReq;
import com.tencent.biz.subscribe.network.GetCommentListRequest;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentBusiness
{
  private static final String a = "CommentBusiness";
  private Handler b;
  private Map<String, ArrayList<CertifiedAccountMeta.StComment>> c = new HashMap();
  private Map<String, Integer> d = new HashMap();
  private Map<String, CommentBusiness.CommentResponse> e = new HashMap();
  
  private String a(COMM.StCommonExt paramStCommonExt)
  {
    if ((paramStCommonExt != null) && (paramStCommonExt.mapInfo.size() > 0)) {
      return ((COMM.Entry)paramStCommonExt.mapInfo.get(0)).value.get();
    }
    return "";
  }
  
  private void a(String paramString, COMM.StCommonExt paramStCommonExt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e.get(paramString) == null)
    {
      Object localObject = new CommentBusiness.CommentResponse();
      ((CommentBusiness.CommentResponse)localObject).b = paramStCommonExt;
      ((CommentBusiness.CommentResponse)localObject).a = paramBoolean1;
      ((CommentBusiness.CommentResponse)localObject).c = paramBoolean2;
      this.e.put(paramString, localObject);
      paramString = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDetailCommentSize: attachInfo:");
      ((StringBuilder)localObject).append(paramStCommonExt.attachInfo.get());
      QLog.d(paramString, 1, ((StringBuilder)localObject).toString());
      return;
    }
    ((CommentBusiness.CommentResponse)this.e.get(paramString)).a = paramBoolean1;
    ((CommentBusiness.CommentResponse)this.e.get(paramString)).b = paramStCommonExt;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Map localMap = this.e;
    if ((localMap != null) && (localMap.get(paramString) != null)) {
      ((CommentBusiness.CommentResponse)this.e.get(paramString)).c = paramBoolean;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, COMM.StCommonExt paramStCommonExt)
  {
    if (paramStGetFeedDetailRsp != null)
    {
      Object localObject = paramStGetFeedDetailRsp.feed;
      String str = ((CertifiedAccountMeta.StFeed)localObject).id.get();
      a(str, paramStGetFeedDetailRsp.extInfo, true, true);
      ArrayList localArrayList = null;
      if (((CertifiedAccountMeta.StFeed)localObject).vecComment.size() > 0)
      {
        localArrayList = (ArrayList)a((ArrayList)((CertifiedAccountMeta.StFeed)localObject).vecComment.get(), a(paramStCommonExt), 1);
        this.d.put(str, Integer.valueOf(((CertifiedAccountMeta.StFeed)localObject).commentCount.get()));
      }
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList(0);
        this.d.put(str, Integer.valueOf(0));
      }
      this.c.put(str, localObject);
      paramStGetFeedDetailRsp.feed.vecComment.set((List)localObject);
      if (b(str) == 0) {
        QZLog.e(a, 1, new Object[] { "后台返回评论数为0" });
      }
      StoryDispatcher.a().dispatch(new CommentEvent(5, new Object[] { str, Integer.valueOf(b(str)) }));
    }
    StoryDispatcher.a().dispatch(a(new Object[] { Integer.valueOf(2), Long.valueOf(paramLong), paramString, paramStGetFeedDetailRsp, Integer.valueOf(hashCode()), paramStCommonExt }));
  }
  
  public long a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    paramStFeed = new DoReplyReq(paramStFeed, paramStComment, paramStReply, 1);
    VSNetworkHelper.getInstance().sendRequest(paramStFeed, new CommentBusiness.5(this, paramStComment, paramStReply));
    return 0L;
  }
  
  public COMM.StCommonExt a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (CommentBusiness.CommentResponse)this.e.get(paramString);
    if (paramString != null)
    {
      if ((paramString.c) && (paramString.a) && (paramString.b != null)) {
        return paramString.b;
      }
      QLog.i(a, 1, paramString.toString());
    }
    return null;
  }
  
  public Handler a()
  {
    if (this.b == null) {
      this.b = new Handler(Looper.getMainLooper());
    }
    return this.b;
  }
  
  public CommentEvent a(Object... paramVarArgs)
  {
    return new CommentEvent(6, paramVarArgs);
  }
  
  public List<CertifiedAccountMeta.StComment> a(List<CertifiedAccountMeta.StComment> paramList, String paramString)
  {
    return a(paramList, paramString, 0);
  }
  
  public List<CertifiedAccountMeta.StComment> a(List<CertifiedAccountMeta.StComment> paramList, String paramString, int paramInt)
  {
    int j = paramList.size();
    if ((!TextUtils.isEmpty(paramString)) && (paramInt >= 0))
    {
      if (paramInt > j) {
        return paramList;
      }
      ArrayList localArrayList = new ArrayList();
      int i = paramInt;
      if (paramInt > 0)
      {
        localArrayList.addAll(paramList.subList(0, paramInt));
        i = paramInt;
      }
      while (i < j)
      {
        CertifiedAccountMeta.StComment localStComment = (CertifiedAccountMeta.StComment)paramList.get(i);
        if (!localStComment.id.get().equals(paramString)) {
          localArrayList.add(localStComment);
        }
        i += 1;
      }
      return localArrayList;
    }
    return paramList;
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment)
  {
    paramStFeed = new DoCommentRequest(paramStFeed, paramStComment, 1);
    VSNetworkHelper.getInstance().sendRequest(paramStFeed, new CommentBusiness.3(this, paramStComment));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, COMM.StCommonExt paramStCommonExt)
  {
    CommentBusiness.1 local1 = new CommentBusiness.1(this, paramStCommonExt);
    if (paramStCommonExt == null)
    {
      String str = paramStFeed.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("1002");
      localStringBuilder.append(str);
      if (PreLoader.exists(localStringBuilder.toString()))
      {
        paramStFeed = new StringBuilder();
        paramStFeed.append("1002");
        paramStFeed.append(str);
        PreLoader.addListener(paramStFeed.toString(), new CommentBusiness.2(this, local1));
        paramStFeed = new StringBuilder();
        paramStFeed.append("1002");
        paramStFeed.append(str);
        PreLoader.remove(paramStFeed.toString());
        return;
      }
    }
    paramStFeed = new GetSubscribeFeedDetailRequest(paramStFeed, paramStCommonExt);
    paramStFeed.setEnableCache(false);
    VSNetworkHelper.getInstance().sendRequest(paramStFeed, local1);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, COMM.StCommonExt paramStCommonExt, String paramString)
  {
    paramStCommonExt = new GetCommentListRequest(paramStFeed, paramStCommonExt, 20);
    VSNetworkHelper.getInstance().sendRequest(paramStCommonExt, new CommentBusiness.9(this, paramStFeed, paramString));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    a(paramStFeed, paramBoolean, "");
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, boolean paramBoolean, String paramString)
  {
    COMM.StCommonExt localStCommonExt;
    Object localObject;
    if (paramBoolean)
    {
      localStCommonExt = a(paramStFeed.id.get());
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getComments loadMore: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", attachInfo:");
      localStringBuilder.append(localStCommonExt);
      QZLog.i((String)localObject, 1, localStringBuilder.toString());
      if (localStCommonExt == null)
      {
        paramStFeed = a;
        paramString = new StringBuilder();
        paramString.append("getComments loadMore: ");
        paramString.append(paramBoolean);
        paramString.append(", attachInfo is null ");
        QZLog.e(paramStFeed, 1, new Object[] { paramString.toString() });
        return;
      }
      a(paramStFeed.id.get(), false);
      a(paramStFeed, localStCommonExt, paramString);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localStCommonExt = new COMM.StCommonExt();
      localObject = new COMM.Entry();
      ((COMM.Entry)localObject).key.set("commentID");
      ((COMM.Entry)localObject).value.set(paramString);
      localStCommonExt.mapInfo.add((MessageMicro)localObject);
      a(paramStFeed, localStCommonExt);
      return;
    }
    a(paramStFeed, null);
  }
  
  public int b(String paramString)
  {
    paramString = (Integer)this.d.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public String b(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (!paramStComment.id.get().startsWith("fake_id")))
    {
      paramStFeed = new DoCommentRequest(paramStFeed, paramStComment, 0);
      VSNetworkHelper.getInstance().sendRequest(paramStFeed, new CommentBusiness.4(this, paramStComment));
      return paramStComment.id.get();
    }
    StoryDispatcher.a().dispatch(a(new Object[] { Integer.valueOf(5), Long.valueOf(-1L), HardCodeUtil.a(2131900365), null }));
    return "";
  }
  
  public String b(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if ((paramStReply != null) && (!paramStReply.id.get().startsWith("fake_id")))
    {
      paramStFeed = new DoReplyReq(paramStFeed, paramStComment, paramStReply, 0);
      VSNetworkHelper.getInstance().sendRequest(paramStFeed, new CommentBusiness.6(this, paramStReply, paramStComment));
      return paramStReply.id.get();
    }
    StoryDispatcher.a().dispatch(a(new Object[] { Integer.valueOf(5), Long.valueOf(-1L), HardCodeUtil.a(2131900363), null }));
    return "";
  }
  
  public void b()
  {
    this.c.clear();
    this.e.clear();
    this.d.clear();
  }
  
  public long c(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment)
  {
    paramStFeed = new DoLikeRequest(paramStFeed);
    VSNetworkHelper.getInstance().sendRequest(paramStFeed, new CommentBusiness.7(this));
    return Long.parseLong(paramStComment.id.get());
  }
  
  public ArrayList<CertifiedAccountMeta.StComment> c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.c.get(paramString);
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    paramStFeed = new DoLikeRequest(paramStFeed);
    VSNetworkHelper.getInstance().sendRequest(paramStFeed, new CommentBusiness.8(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness
 * JD-Core Version:    0.7.0.1
 */