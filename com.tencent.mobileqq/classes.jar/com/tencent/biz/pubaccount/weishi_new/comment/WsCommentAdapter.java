package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.subscribe.comment.MoreCommentPanel;
import com.tencent.biz.subscribe.comment.OnCommentElementClickListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WsCommentAdapter
  extends BaseAdapter
{
  public static int c = 1;
  HashSet<Integer> a = new HashSet();
  HashSet<Integer> b = new HashSet();
  private Context d;
  private List<stSimpleMetaComment> e;
  private Map<String, Integer> f;
  private OnCommentElementClickListener g;
  private String h;
  private String i = "focus";
  private String j;
  private stSimpleMetaFeed k;
  private WSOnGetReportInfo l;
  
  public WsCommentAdapter(Context paramContext, OnCommentElementClickListener paramOnCommentElementClickListener, WSOnGetReportInfo paramWSOnGetReportInfo)
  {
    this.d = paramContext;
    if (this.e == null)
    {
      WSLog.a("comment", "create mComments ...");
      this.e = new ArrayList();
    }
    else
    {
      WSLog.a("comment", "复用 mComments ...");
    }
    this.g = paramOnCommentElementClickListener;
    this.f = new HashMap();
    this.l = paramWSOnGetReportInfo;
  }
  
  public String a()
  {
    return this.j;
  }
  
  public void a(int paramInt, stSimpleMetaComment paramstSimpleMetaComment)
  {
    WSLog.d("comment", "addComment ...2");
    if ((paramstSimpleMetaComment != null) && (paramInt <= this.e.size())) {
      this.e.add(paramInt, paramstSimpleMetaComment);
    }
  }
  
  public void a(stSimpleMetaComment paramstSimpleMetaComment)
  {
    if ((paramstSimpleMetaComment != null) && (!TextUtils.isEmpty(paramstSimpleMetaComment.id)))
    {
      int m = 10;
      Integer localInteger = (Integer)this.f.get(paramstSimpleMetaComment.id);
      if (localInteger != null) {
        m = 10 + localInteger.intValue();
      }
      this.f.put(paramstSimpleMetaComment.id, Integer.valueOf(m));
      notifyDataSetChanged();
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {
      this.k = paramstSimpleMetaFeed;
    }
  }
  
  public void a(String paramString, stSimpleMetaReply paramstSimpleMetaReply)
  {
    if (paramstSimpleMetaReply == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addCommentReply :");
    ((StringBuilder)localObject).append(paramstSimpleMetaReply.wording);
    ((StringBuilder)localObject).append(",mComments size:");
    ((StringBuilder)localObject).append(this.e.size());
    WSLog.d("comment", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)((Iterator)localObject).next();
        if (paramString.equals(localstSimpleMetaComment.id)) {
          localstSimpleMetaComment.replyList.add(0, paramstSimpleMetaReply);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.i = paramString1;
    this.j = paramString2;
  }
  
  public boolean a(String paramString)
  {
    WSLog.d("comment", "removeComment ...");
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (!bool2)
    {
      int m = this.e.size() - 1;
      while (m >= 0)
      {
        if (paramString.equals(((stSimpleMetaComment)this.e.get(m)).id))
        {
          if (this.e.remove(m) != null) {
            bool1 = true;
          }
          this.f.remove(paramString);
          return bool1;
        }
        m -= 1;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, stSimpleMetaComment paramstSimpleMetaComment)
  {
    WSLog.d("comment", "updateComment ...");
    if (!TextUtils.isEmpty(paramString))
    {
      int m = this.e.size() - 1;
      while (m >= 0)
      {
        if (paramString.equals(((stSimpleMetaComment)this.e.get(m)).id))
        {
          if (this.e.set(m, paramstSimpleMetaComment) == null) {
            break;
          }
          return true;
        }
        m -= 1;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, stSimpleMetaReply paramstSimpleMetaReply)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCommentReply ............. mComments.size:");
    ((StringBuilder)localObject).append(this.e.size());
    WSLog.d("comment", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramstSimpleMetaReply.id)))
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)((Iterator)localObject).next();
        if (paramString1.equals(localstSimpleMetaComment.id))
        {
          int m = localstSimpleMetaComment.replyList.size();
          boolean bool = true;
          m -= 1;
          while (m >= 0)
          {
            if (paramString2.equals(((stSimpleMetaReply)localstSimpleMetaComment.replyList.get(m)).id))
            {
              if (localstSimpleMetaComment.replyList.set(m, paramstSimpleMetaReply) == null) {
                bool = false;
              }
              return bool;
            }
            m -= 1;
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(Collection<stSimpleMetaComment> paramCollection)
  {
    if (paramCollection != null) {
      return this.e.addAll(paramCollection);
    }
    return false;
  }
  
  public int b(stSimpleMetaComment paramstSimpleMetaComment)
  {
    if ((paramstSimpleMetaComment != null) && (!TextUtils.isEmpty(paramstSimpleMetaComment.id)))
    {
      this.f.put(paramstSimpleMetaComment.id, Integer.valueOf(3));
      notifyDataSetChanged();
      return 3;
    }
    return -1;
  }
  
  public void b()
  {
    this.e.clear();
    this.f.clear();
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    WSLog.d("comment", "removeCommentReply ...");
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)localIterator.next();
        if (paramString1.equals(localstSimpleMetaComment.id))
        {
          int m = localstSimpleMetaComment.replyList.size();
          boolean bool = true;
          m -= 1;
          while (m >= 0)
          {
            if (paramString2.equals(((stSimpleMetaReply)localstSimpleMetaComment.replyList.get(m)).id))
            {
              if (localstSimpleMetaComment.replyList.remove(m) == null) {
                bool = false;
              }
              return bool;
            }
            m -= 1;
          }
        }
      }
    }
    return false;
  }
  
  public void c()
  {
    HashSet localHashSet = this.a;
    if (localHashSet != null) {
      localHashSet.clear();
    }
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)getItem(paramInt);
    if (localstSimpleMetaComment.isTempData)
    {
      if (!this.a.contains(Integer.valueOf(localstSimpleMetaComment.hashCode())))
      {
        this.a.add(Integer.valueOf(localstSimpleMetaComment.hashCode()));
        paramViewGroup = WSCommentBeaconReport.d(this.i);
        paramView = paramViewGroup;
        if (!paramViewGroup.equals("comment_tag"))
        {
          paramView = new StringBuilder();
          paramView.append(paramViewGroup);
          paramView.append(c);
          paramView = paramView.toString();
        }
        WSCommentBeaconReport.a(this.i, a(), paramView, this.k);
      }
      else
      {
        paramView = new StringBuilder();
        paramView.append("重复的position:");
        paramView.append(paramInt);
        paramView.append(",不上报");
        WSLog.b("beacon-comment", paramView.toString());
      }
      paramView = new MoreCommentPanel(this.d);
      ((TextView)paramView.findViewById(2131438860)).setTextColor(-7829368);
      paramView.setOnClickListener(new WsCommentAdapter.1(this, paramInt));
      paramView.setHintText(localstSimpleMetaComment.wording);
      return paramView;
    }
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if (!(paramView instanceof MoreCommentPanel)) {}
    }
    else
    {
      paramViewGroup = new WsCommentView(this.d);
      ((WsCommentView)paramViewGroup).setOnCommentElementClickListener(this.g);
      paramViewGroup.setTag(paramViewGroup);
    }
    paramView = (WsCommentView)paramViewGroup.getTag();
    paramView.setPosition(paramInt);
    paramInt = 3;
    paramView.setDisplayNum(3);
    Integer localInteger = (Integer)this.f.get(localstSimpleMetaComment.id);
    if (localInteger != null) {
      paramInt = localInteger.intValue();
    }
    paramView.setReportParams(this.l);
    paramView.setData(localstSimpleMetaComment, paramInt, this.h);
    return paramViewGroup;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentAdapter
 * JD-Core Version:    0.7.0.1
 */