package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stCommentJumpText;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.request.GetFeedCommentListV2Request;
import com.tencent.biz.pubaccount.weishi_new.request.PostCommentDingRequest;
import com.tencent.biz.pubaccount.weishi_new.request.PostCommentReplyRequest;
import com.tencent.biz.pubaccount.weishi_new.request.PostFeedCommentRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WsCommentBusiness
{
  private static final String jdField_a_of_type_JavaLangString = "WsCommentBusiness";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private WsCommentPresenter jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter;
  private Map<String, ArrayList<stSimpleMetaComment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, Integer> b = new HashMap();
  private Map<String, WsCommentBusiness.CommentResponse> c = new HashMap();
  
  public WsCommentBusiness(WsCommentPresenter paramWsCommentPresenter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter = paramWsCommentPresenter;
  }
  
  private static ArrayList<stSimpleMetaComment> a(stSimpleMetaComment[] paramArrayOfstSimpleMetaComment)
  {
    paramArrayOfstSimpleMetaComment = Arrays.asList(paramArrayOfstSimpleMetaComment);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfstSimpleMetaComment.size() > 0)
    {
      int i = 0;
      while (i < paramArrayOfstSimpleMetaComment.size())
      {
        if (paramArrayOfstSimpleMetaComment.get(i) != null)
        {
          localArrayList.add(paramArrayOfstSimpleMetaComment.get(i));
          if (i == 0)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("end, comment word:");
            localStringBuilder.append(((stSimpleMetaComment)paramArrayOfstSimpleMetaComment.get(i)).wording);
            localStringBuilder.append(", id:");
            localStringBuilder.append(((stSimpleMetaComment)paramArrayOfstSimpleMetaComment.get(i)).id);
            WSLog.c("weishi-comment", localStringBuilder.toString());
          }
        }
        else
        {
          WSLog.d("weishi-comment", "comment is null");
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c.get(paramString1) == null)
    {
      WsCommentBusiness.CommentResponse localCommentResponse = new WsCommentBusiness.CommentResponse();
      localCommentResponse.jdField_a_of_type_JavaLangString = paramString2;
      localCommentResponse.jdField_a_of_type_Boolean = (paramBoolean1 ^ true);
      this.c.put(paramString1, localCommentResponse);
      return;
    }
    paramString1 = (WsCommentBusiness.CommentResponse)this.c.get(paramString1);
    if (paramString1 != null)
    {
      paramString1.jdField_a_of_type_Boolean = (paramBoolean1 ^ true);
      paramString1.jdField_a_of_type_JavaLangString = paramString2;
      return;
    }
    WSLog.d(jdField_a_of_type_JavaLangString, "updateResponseState, commentResponse is null.");
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.c.get(paramString) == null)
    {
      WsCommentBusiness.CommentResponse localCommentResponse = new WsCommentBusiness.CommentResponse();
      localCommentResponse.b = paramBoolean;
      this.c.put(paramString, localCommentResponse);
      return;
    }
    paramString = (WsCommentBusiness.CommentResponse)this.c.get(paramString);
    if (paramString != null)
    {
      paramString.b = paramBoolean;
      return;
    }
    WSLog.d(jdField_a_of_type_JavaLangString, "updateResponseState, commentResponse is null.");
  }
  
  private static ArrayList<stSimpleMetaComment> b(ArrayList<stSimpleMetaComment> paramArrayList, ArrayList<stCommentJumpText> paramArrayList1, int paramInt)
  {
    if (paramArrayList.size() == 0) {
      return new ArrayList();
    }
    HashMap localHashMap = new HashMap();
    int i = paramArrayList1.size();
    int j = 0;
    Object localObject;
    if (i > 0)
    {
      i = 0;
      while (i < paramArrayList1.size())
      {
        localObject = (stCommentJumpText)paramArrayList1.get(i);
        stSimpleMetaComment localstSimpleMetaComment = new stSimpleMetaComment();
        localstSimpleMetaComment.isTempData = true;
        k = ((stCommentJumpText)localObject).index;
        localstSimpleMetaComment.wording = ((stCommentJumpText)localObject).text;
        StringBuilder localStringBuilder;
        if (k >= paramInt)
        {
          localHashMap.put(Integer.valueOf(k), localstSimpleMetaComment);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("oldsize:");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", index:");
          localStringBuilder.append(k);
          WSLog.a("comment", localStringBuilder.toString());
        }
        if (k == -1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((stCommentJumpText)localObject).index);
          localStringBuilder.append(",尾部拉量入口: ");
          localStringBuilder.append(localstSimpleMetaComment.wording);
          WSLog.a("comment", localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((stCommentJumpText)localObject).index);
          localStringBuilder.append(",拉量入口: ");
          localStringBuilder.append(localstSimpleMetaComment.wording);
          WSLog.a("comment", localStringBuilder.toString());
        }
        i += 1;
      }
    }
    if ((paramArrayList.size() <= 20) && (localHashMap.containsKey(Integer.valueOf(-1))))
    {
      localHashMap.remove(Integer.valueOf(-1));
      WSLog.d("weishi-comment", "评论小于等于20条，移除尾部拉量入口");
    }
    int k = paramArrayList.size() + localHashMap.size();
    paramArrayList1 = new StringBuilder();
    paramArrayList1.append("size1:");
    paramArrayList1.append(paramArrayList.size());
    paramArrayList1.append(",size2:");
    paramArrayList1.append(localHashMap.size());
    WSLog.d("weishi-comment", paramArrayList1.toString());
    paramArrayList1 = new stSimpleMetaComment[k];
    i = k;
    if (localHashMap.keySet().contains(Integer.valueOf(-1)))
    {
      i = k - 1;
      paramArrayList1[(paramArrayList1.length - 1)] = ((stSimpleMetaComment)localHashMap.get(Integer.valueOf(-1)));
    }
    k = 0;
    while (j < i)
    {
      localObject = localHashMap.keySet();
      int m = j + paramInt;
      if (((Set)localObject).contains(Integer.valueOf(m)))
      {
        paramArrayList1[j] = ((stSimpleMetaComment)localHashMap.get(Integer.valueOf(m)));
        k += 1;
      }
      else
      {
        m = j - k;
        if (m >= paramArrayList.size()) {
          break label524;
        }
        paramArrayList1[j] = ((stSimpleMetaComment)paramArrayList.get(m));
      }
      j += 1;
      continue;
      label524:
      WSLog.c("weishi-comment", "combineComment end!");
    }
    WSLog.d("weishi-comment", "combineComment success");
    return a(paramArrayList1);
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.b.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleComment paramstSimpleComment)
  {
    paramstSimpleMetaFeed = new PostCommentDingRequest(paramstSimpleMetaFeed.id, paramstSimpleComment.id, paramstSimpleComment.isDing);
    WeishiBusinessLooper.a().a(new WeishiTask(paramstSimpleMetaFeed, a(), new WsCommentBusiness.8(this, paramstSimpleComment), 9));
    return 0L;
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    paramstSimpleMetaFeed = new PostCommentDingRequest(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaComment.isDing);
    WeishiBusinessLooper.a().a(new WeishiTask(paramstSimpleMetaFeed, a(), new WsCommentBusiness.7(this, paramstSimpleMetaComment), 9));
    return 0L;
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reply.poster_id:");
    localStringBuilder.append(paramstSimpleMetaReply.poster.id);
    localStringBuilder.append(",reply.receiver_id:");
    localStringBuilder.append(paramstSimpleMetaReply.receiver.id);
    localStringBuilder.append(",reply.beReplyCommendId:");
    localStringBuilder.append(paramstSimpleMetaReply.beReplyReplyId);
    WSLog.d(str, localStringBuilder.toString());
    paramstSimpleMetaFeed = new PostCommentReplyRequest(paramstSimpleMetaFeed, paramstSimpleMetaComment, paramstSimpleMetaReply);
    WeishiBusinessLooper.a().a(new WeishiTask(paramstSimpleMetaFeed, a(), new WsCommentBusiness.5(this, paramstSimpleMetaReply), 6));
    return 0L;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new WsCommentBusiness.1(this, Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public WSCommentEvent a(Object... paramVarArgs)
  {
    return new WSCommentEvent(6, paramVarArgs);
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (WsCommentBusiness.CommentResponse)this.c.get(paramString);
    if ((paramString != null) && (paramString.b) && (paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_JavaLangString != null)) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public ArrayList<stSimpleMetaComment> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.c.clear();
    this.b.clear();
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("---添加评论，wording:");
    localStringBuilder.append(paramstSimpleMetaComment.wording);
    localStringBuilder.append("poster_id:");
    localStringBuilder.append(paramstSimpleMetaComment.poster_id);
    localStringBuilder.append(",receiver_id:");
    localStringBuilder.append(paramstSimpleMetaComment.receiver_id);
    WSLog.d(str, localStringBuilder.toString());
    paramstSimpleMetaFeed = new PostFeedCommentRequest(paramstSimpleMetaFeed, paramstSimpleMetaComment);
    WeishiBusinessLooper.a().a(new WeishiTask(paramstSimpleMetaFeed, a(), new WsCommentBusiness.3(this, paramstSimpleMetaComment), 5));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    paramstSimpleMetaFeed = new PostCommentDingRequest(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaComment.isDing);
    WeishiBusinessLooper.a().a(new WeishiTask(paramstSimpleMetaFeed, a(), new WsCommentBusiness.9(this), 9));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString, boolean paramBoolean)
  {
    WSLog.a(jdField_a_of_type_JavaLangString, "getComments(final stSimpleMetaFeed feed, String attachInfo, final boolean loadMore)");
    long l = System.currentTimeMillis();
    paramstSimpleMetaFeed = new WeishiTask(new GetFeedCommentListV2Request(paramString, paramstSimpleMetaFeed.id, 1), a(), new WsCommentBusiness.2(this, l, paramstSimpleMetaFeed, paramBoolean), 1000);
    WeishiBusinessLooper.a().a(paramstSimpleMetaFeed);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    if (paramstSimpleMetaFeed == null)
    {
      WSLog.d(jdField_a_of_type_JavaLangString, "getComments , feed is null ");
      return;
    }
    String str1 = a(paramstSimpleMetaFeed.id);
    String str2 = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getComments loadMore: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", attachInfo:");
    localStringBuilder.append(str1);
    WSLog.c(str2, localStringBuilder.toString());
    if ((paramBoolean) && (TextUtils.isEmpty(str1)))
    {
      WSLog.d(jdField_a_of_type_JavaLangString, "getComments and loadMore, attachInfo is empty ");
      return;
    }
    if (!paramBoolean)
    {
      WSLog.d(jdField_a_of_type_JavaLangString, "first getComments, set attachInfo empty ");
      str1 = "";
    }
    a(paramstSimpleMetaFeed.id, false);
    a(paramstSimpleMetaFeed, str1, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness
 * JD-Core Version:    0.7.0.1
 */