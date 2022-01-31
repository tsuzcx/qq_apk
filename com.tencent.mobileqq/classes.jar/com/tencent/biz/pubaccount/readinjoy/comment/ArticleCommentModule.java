package com.tencent.biz.pubaccount.readinjoy.comment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import liq;
import lir;
import lis;
import lit;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArticleCommentModule
  extends CommentInfo
{
  public boolean canComment;
  private ArticleCommentModule.FetchCommentObserver commentObserver;
  private ArticleCommentModule.CreateCommentObserver createCommentObserver;
  public String face_id = "";
  public int facecount;
  private List mCommentItemLists = new ArrayList();
  public boolean openEmotion;
  
  public ArticleCommentModule(ArticleInfo paramArticleInfo, int paramInt, String paramString1, String paramString2)
  {
    this.articleInfo = paramArticleInfo;
    this.commentId = paramString1;
    this.commentType = paramInt;
    this.uuid = paramString2;
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    label125:
    for (;;)
    {
      CommentInfo localCommentInfo1;
      if (paramList.hasNext())
      {
        localCommentInfo1 = (CommentInfo)paramList.next();
        Iterator localIterator = this.mCommentItemLists.iterator();
        CommentInfo localCommentInfo2;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localCommentInfo2 = (CommentInfo)localIterator.next();
        } while ((localCommentInfo1 == null) || (localCommentInfo2 == null) || (localCommentInfo1.commentId == null) || (!localCommentInfo1.commentId.equalsIgnoreCase(localCommentInfo2.commentId)));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label125;
        }
        localArrayList.add(localCommentInfo1);
        break;
        return localArrayList;
      }
    }
  }
  
  private void a(ArticleCommentModule paramArticleCommentModule)
  {
    this.commentCount = paramArticleCommentModule.commentCount;
    this.commentId = paramArticleCommentModule.commentId;
    this.openEmotion = paramArticleCommentModule.openEmotion;
    this.canComment = paramArticleCommentModule.canComment;
    this.liked = paramArticleCommentModule.liked;
    this.likeCount = paramArticleCommentModule.likeCount;
    this.face_id = paramArticleCommentModule.face_id;
    this.facecount = paramArticleCommentModule.facecount;
  }
  
  public CommentInfo buildComment(ArticleInfo paramArticleInfo, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    CommentInfo localCommentInfo = new CommentInfo();
    localCommentInfo.articleInfo = paramArticleInfo;
    localCommentInfo.commentTime = (System.currentTimeMillis() / 1000L);
    localCommentInfo.commentId = paramString1;
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localCommentInfo.anonymous = bool;
      localCommentInfo.liked = false;
      localCommentInfo.commentContent = paramString2;
      localCommentInfo.commentByMyself = true;
      localCommentInfo.rank = 1;
      localCommentInfo.authorNickName = "我的评论";
      paramArticleInfo = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArticleInfo instanceof QQAppInterface))
      {
        localCommentInfo.authorUin = ((QQAppInterface)paramArticleInfo).getCurrentAccountUin();
        localCommentInfo.commentByMyself = true;
        if (!TextUtils.isEmpty(paramString3))
        {
          localCommentInfo.hasTarget = true;
          localCommentInfo.toUin = paramString3;
          localCommentInfo.toNickName = getCommentUserNickName(paramString3);
        }
      }
      return localCommentInfo;
    }
  }
  
  public void commentLike(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, ArticleCommentModule.CommentLikeObserver paramCommentLikeObserver)
  {
    NativeCommentServlet.a(paramQQAppInterface, this.articleInfo, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramInt3, new lit(this, paramCommentLikeObserver, paramInt2));
  }
  
  public void createComment(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, int paramInt2, int paramInt3, String paramString4, String paramString5, ArticleCommentModule.CreateCommentObserver paramCreateCommentObserver)
  {
    NativeCommentServlet.a(paramQQAppInterface, this.articleInfo, this.uuid, paramInt1, paramString1, paramString2, paramString3, paramJSONArray, paramInt2, paramInt3, paramString4, paramString5, new lir(this, paramCreateCommentObserver, paramString3));
  }
  
  public boolean dealwithRawComment(JSONObject paramJSONObject)
  {
    CommentInfo localCommentInfo = parseArticleInfo(paramJSONObject);
    if ((localCommentInfo instanceof ArticleCommentModule)) {
      a((ArticleCommentModule)localCommentInfo);
    }
    if (this.commentType == 1) {}
    for (paramJSONObject = parseArticleCommentInfo(paramJSONObject); paramJSONObject != null; paramJSONObject = parseArticleSubCommentInfo(paramJSONObject))
    {
      this.mCommentItemLists.addAll(a(paramJSONObject));
      return true;
    }
    return false;
  }
  
  public void deleteComment(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, ArticleCommentModule.DeleteCommentObserver paramDeleteCommentObserver)
  {
    NativeCommentServlet.a(paramQQAppInterface, this.articleInfo, this.uuid, paramInt1, paramString1, paramString2, paramString3, paramInt2, new lis(this, paramString1, paramString3, paramDeleteCommentObserver));
  }
  
  public boolean fetchNextCommentInfo(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!this.hasNextPage) {
      return false;
    }
    NativeCommentServlet.a(paramQQAppInterface, this.articleInfo, this.uuid, this.commentType, this.commentId, this.page, 10, paramInt, new liq(this));
    this.page += 1;
    return true;
  }
  
  public List getCommentList()
  {
    return this.mCommentItemLists;
  }
  
  public String getCommentUserNickName(String paramString)
  {
    Object localObject;
    if ((this.mCommentItemLists == null) || (TextUtils.isEmpty(paramString)))
    {
      localObject = null;
      return localObject;
    }
    String str = "";
    int i = 0;
    label26:
    if (i < this.mCommentItemLists.size())
    {
      localObject = (CommentInfo)this.mCommentItemLists.get(i);
      if ((!TextUtils.isEmpty(((CommentInfo)localObject).authorUin)) && (((CommentInfo)localObject).authorUin.equalsIgnoreCase(paramString))) {
        return ((CommentInfo)localObject).authorNickName;
      }
      int j;
      if (((CommentInfo)localObject).mCommentItemLists != null)
      {
        j = 0;
        label93:
        if (j < ((CommentInfo)localObject).mCommentItemLists.size())
        {
          CommentInfo localCommentInfo = (CommentInfo)((CommentInfo)localObject).mCommentItemLists.get(j);
          if ((!TextUtils.isEmpty(localCommentInfo.authorUin)) && (localCommentInfo.authorUin.equalsIgnoreCase(paramString))) {
            str = localCommentInfo.authorNickName;
          }
        }
      }
      for (;;)
      {
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        i += 1;
        break label26;
        j += 1;
        break label93;
      }
    }
    return str;
  }
  
  public boolean hasNextPage()
  {
    return this.hasNextPage;
  }
  
  public List parseArticleCommentInfo(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    Object localObject2 = new ArrayList();
    for (;;)
    {
      Object localObject3;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("data").getJSONObject("commentList");
        localObject3 = paramJSONObject.optString("msg");
        int i = paramJSONObject.getInt("ret");
        if (i != 0)
        {
          paramJSONObject = localObject1;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("parseArticleCommentInfo error info:");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              break label644;
            }
            paramJSONObject = String.valueOf(i);
            QLog.d("ArticleCommentModule", 2, paramJSONObject);
            return null;
          }
        }
        else
        {
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (1 == this.commentType)
          {
            if (paramJSONObject.optInt("next") > 0)
            {
              bool = true;
              this.hasNextPage = bool;
            }
          }
          else
          {
            paramJSONObject = paramJSONObject.getJSONArray("comments");
            i = 0;
            if (i >= paramJSONObject.length()) {
              continue;
            }
            Object localObject4 = paramJSONObject.getJSONObject(i);
            localObject3 = new CommentInfo();
            ((CommentInfo)localObject3).articleInfo = this.articleInfo;
            ((CommentInfo)localObject3).uuid = this.uuid;
            ((CommentInfo)localObject3).commentId = ((JSONObject)localObject4).getString("comment_id");
            ((CommentInfo)localObject3).commentContent = ((JSONObject)localObject4).optString("comment_content");
            ((CommentInfo)localObject3).likeCount = ((JSONObject)localObject4).optInt("like_count");
            ((CommentInfo)localObject3).commentTime = ((JSONObject)localObject4).optLong("comment_time");
            if (((JSONObject)localObject4).optInt("like") <= 0) {
              continue;
            }
            bool = true;
            ((CommentInfo)localObject3).liked = bool;
            ((CommentInfo)localObject3).likeCount = ((JSONObject)localObject4).optInt("like_count");
            ((CommentInfo)localObject3).level = ((JSONObject)localObject4).optInt("level");
            if (((JSONObject)localObject4).optInt("anonymous") <= 0) {
              continue;
            }
            bool = true;
            ((CommentInfo)localObject3).anonymous = bool;
            ((CommentInfo)localObject3).author_selection = ((JSONObject)localObject4).optInt("author_selection");
            if (((JSONObject)localObject4).optInt("myself") <= 0) {
              continue;
            }
            bool = true;
            ((CommentInfo)localObject3).commentByMyself = bool;
            if (((JSONObject)localObject4).has("rank")) {
              ((CommentInfo)localObject3).rank = ((JSONObject)localObject4).getInt("rank");
            }
            ((CommentInfo)localObject3).gift_list = ((JSONObject)localObject4).optJSONArray("gif_list");
            ((CommentInfo)localObject3).authorNickName = ((JSONObject)localObject4).optString("nick_name");
            ((CommentInfo)localObject3).authorHomepage = ((JSONObject)localObject4).optString("homepage");
            ((CommentInfo)localObject3).authorUin = ((JSONObject)localObject4).optString("uin");
            ((CommentInfo)localObject3).authorAvater = ((JSONObject)localObject4).optString("avatar");
            ((CommentInfo)localObject3).authorComment = ((JSONObject)localObject4).optString("author_comment");
            ((CommentInfo)localObject3).authorCreateTime = ((JSONObject)localObject4).optLong("author_create_time");
            ((CommentInfo)localObject3).sub_comments_total = ((JSONObject)localObject4).optInt("sub_comments_total");
            if ((TextUtils.isEmpty(((CommentInfo)localObject3).commentContent)) && (((CommentInfo)localObject3).gift_list != null) && (((CommentInfo)localObject3).gift_list.length() > 0)) {
              ((CommentInfo)localObject3).commentContent = "发布了一张图片";
            }
            localObject4 = ((JSONObject)localObject4).optJSONArray("sub_comments");
            if ((localObject4 != null) && (((JSONArray)localObject4).length() > 0)) {
              ((CommentInfo)localObject3).mCommentItemLists = parseArticleSubCommentInfo((JSONArray)localObject4);
            }
            ((CommentInfo)localObject3).toLogString("parseArticleCommentInfo" + i);
            ((List)localObject2).add(localObject3);
            i += 1;
            continue;
          }
          boolean bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
        }
        return paramJSONObject;
      }
      catch (Exception localException)
      {
        paramJSONObject = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("ArticleCommentModule", 2, "parseArticleCommentInfo error info:" + localException.getLocalizedMessage());
          return null;
          paramJSONObject = localException;
        }
      }
      label644:
      paramJSONObject = (JSONObject)localObject3;
    }
  }
  
  public CommentInfo parseArticleInfo(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    ArticleCommentModule localArticleCommentModule = new ArticleCommentModule(this.articleInfo, this.commentType, this.commentId, this.uuid);
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("data");
      localArticleCommentModule.retMsg = paramJSONObject.optString("msg");
      paramJSONObject = paramJSONObject.getJSONObject("articleInfo");
      if (paramJSONObject.getInt("ret") != 0)
      {
        localArticleCommentModule.toLogString("parseArticleInfo error :");
        return null;
      }
      paramJSONObject = paramJSONObject.getJSONObject("data");
      localArticleCommentModule.articleInfo = this.articleInfo;
      localArticleCommentModule.uuid = this.uuid;
      localArticleCommentModule.commentCount = paramJSONObject.optInt("comment_count");
      localArticleCommentModule.openEmotion = paramJSONObject.optBoolean("open_emotion");
      if (paramJSONObject.optInt("can_comment") > 0)
      {
        bool1 = true;
        localArticleCommentModule.canComment = bool1;
        if (paramJSONObject.optInt("like") <= 0) {
          break label199;
        }
      }
      label199:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localArticleCommentModule.liked = bool1;
        localArticleCommentModule.likeCount = paramJSONObject.optInt("like_count");
        localArticleCommentModule.face_id = paramJSONObject.optString("face_id");
        localArticleCommentModule.toLogString("parseArticleInfo ");
        return localArticleCommentModule;
        bool1 = false;
        break;
      }
      return null;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArticleCommentModule", 2, "parseArticleComment error info:" + paramJSONObject.getLocalizedMessage());
      }
      localArticleCommentModule.toLogString("parseArticleInfo Exception :");
    }
  }
  
  public List parseArticleSubCommentInfo(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      try
      {
        if (i < paramJSONArray.length())
        {
          localObject = paramJSONArray.getJSONObject(i);
          CommentInfo localCommentInfo = new CommentInfo();
          localCommentInfo.articleInfo = this.articleInfo;
          localCommentInfo.uuid = this.uuid;
          localCommentInfo.commentId = ((JSONObject)localObject).getString("comment_id");
          localCommentInfo.commentContent = ((JSONObject)localObject).optString("comment_content");
          localCommentInfo.level = ((JSONObject)localObject).optInt("level");
          if (((JSONObject)localObject).optInt("anonymous") > 0)
          {
            bool = true;
            label109:
            localCommentInfo.anonymous = bool;
            localCommentInfo.authorNickName = ((JSONObject)localObject).optString("nick_name");
            localCommentInfo.authorUin = ((JSONObject)localObject).optString("uin");
            if (((JSONObject)localObject).optInt("has_target") <= 0) {
              break label476;
            }
            bool = true;
            label154:
            localCommentInfo.hasTarget = bool;
            localCommentInfo.toNickName = ((JSONObject)localObject).optString("to_nickname");
            localCommentInfo.toUin = ((JSONObject)localObject).optString("to");
            localCommentInfo.toLogString("parseArticleSubCommentInfo" + i);
            if (((JSONObject)localObject).optInt("like") <= 0) {
              break label481;
            }
            bool = true;
            label224:
            localCommentInfo.liked = bool;
            localCommentInfo.likeCount = ((JSONObject)localObject).optInt("like_count");
            localCommentInfo.gift_list = ((JSONObject)localObject).optJSONArray("gif_list");
            localCommentInfo.authorNickName = ((JSONObject)localObject).optString("nick_name");
            localCommentInfo.authorHomepage = ((JSONObject)localObject).optString("homepage");
            localCommentInfo.authorUin = ((JSONObject)localObject).optString("uin");
            localCommentInfo.authorAvater = ((JSONObject)localObject).optString("avatar");
            localCommentInfo.commentTime = ((JSONObject)localObject).optLong("comment_time");
            localCommentInfo.author_selection = ((JSONObject)localObject).optInt("author_selection");
            if (((JSONObject)localObject).optInt("myself") <= 0) {
              break label486;
            }
          }
          label476:
          label481:
          label486:
          for (boolean bool = true;; bool = false)
          {
            localCommentInfo.commentByMyself = bool;
            if (((JSONObject)localObject).has("rank")) {
              localCommentInfo.rank = ((JSONObject)localObject).optInt("rank");
            }
            localCommentInfo.authorComment = ((JSONObject)localObject).optString("author_comment");
            localCommentInfo.authorCreateTime = ((JSONObject)localObject).optLong("author_create_time");
            localCommentInfo.authorCreateTime = ((JSONObject)localObject).optLong("author_create_time");
            if ((TextUtils.isEmpty(localCommentInfo.commentContent)) && (localCommentInfo.gift_list != null) && (localCommentInfo.gift_list.length() > 0)) {
              localCommentInfo.commentContent = "发布了一张图片";
            }
            localArrayList.add(localCommentInfo);
            i += 1;
            break;
            bool = false;
            break label109;
            bool = false;
            break label154;
            bool = false;
            break label224;
          }
        }
        return localObject;
      }
      catch (Exception paramJSONArray)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArticleCommentModule", 2, "parseArticleSubCommentInfo error info:" + paramJSONArray.getLocalizedMessage());
        }
        localObject = new ArrayList();
      }
    }
  }
  
  public List parseArticleSubCommentInfo(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getInt("ret") != 0) {
        return new ArrayList();
      }
      paramJSONObject = paramJSONObject.getJSONObject("data").getJSONObject("subCommentList");
      if (paramJSONObject.getInt("ret") != 0)
      {
        paramJSONObject = new ArrayList();
        return paramJSONObject;
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArticleCommentModule", 2, "parseArticleSubCommentInfo error info:" + paramJSONObject.getLocalizedMessage());
      }
      return new ArrayList();
    }
    paramJSONObject = paramJSONObject.getJSONObject("data");
    if (2 == this.commentType) {
      if (paramJSONObject.optInt("next") <= 0) {
        break label142;
      }
    }
    label142:
    for (boolean bool = true;; bool = false)
    {
      this.hasNextPage = bool;
      paramJSONObject = parseArticleSubCommentInfo(paramJSONObject.getJSONArray("sub_comments"));
      return paramJSONObject;
    }
  }
  
  public void setCommentObsrver(ArticleCommentModule.FetchCommentObserver paramFetchCommentObserver)
  {
    this.commentObserver = paramFetchCommentObserver;
  }
  
  public void setPostCommentObserver(ArticleCommentModule.CreateCommentObserver paramCreateCommentObserver)
  {
    this.createCommentObserver = paramCreateCommentObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule
 * JD-Core Version:    0.7.0.1
 */