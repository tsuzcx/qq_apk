package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NewCommentAdapter
  extends BaseAdapter
{
  private Context a;
  private List<CertifiedAccountMeta.StComment> b;
  private Map<String, Integer> c;
  private OnCommentElementClickListener d;
  private String e;
  
  public NewCommentAdapter(Context paramContext, OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.a = paramContext;
    this.b = new ArrayList();
    this.d = paramOnCommentElementClickListener;
    this.c = new HashMap();
  }
  
  public void a()
  {
    this.b.clear();
    this.c.clear();
  }
  
  public void a(int paramInt)
  {
    if (this.b.size() > paramInt + 1) {
      a((CertifiedAccountMeta.StComment)this.b.get(paramInt));
    }
  }
  
  public void a(int paramInt, CertifiedAccountMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (paramInt <= this.b.size())) {
      this.b.add(paramInt, paramStComment);
    }
  }
  
  public void a(CertifiedAccountMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      this.c.put(paramStComment.id.get(), Integer.valueOf(paramStComment.vecReply.size()));
      notifyDataSetChanged();
    }
  }
  
  public void a(String paramString, CertifiedAccountMeta.StReply paramStReply)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramStReply != null))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        CertifiedAccountMeta.StComment localStComment = (CertifiedAccountMeta.StComment)localIterator.next();
        if (paramString.equals(localStComment.id.get())) {
          localStComment.vecReply.get().add(0, paramStReply);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (!bool2)
    {
      int i = this.b.size() - 1;
      while (i >= 0)
      {
        if (paramString.equals(((CertifiedAccountMeta.StComment)this.b.get(i)).id.get()))
        {
          if (this.b.remove(i) != null) {
            bool1 = true;
          }
          this.c.remove(paramString);
          return bool1;
        }
        i -= 1;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, CertifiedAccountMeta.StComment paramStComment)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = this.b.size() - 1;
      while (i >= 0)
      {
        if (paramString.equals(((CertifiedAccountMeta.StComment)this.b.get(i)).id.get()))
        {
          if (this.b.set(i, paramStComment) == null) {
            break;
          }
          return true;
        }
        i -= 1;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        CertifiedAccountMeta.StComment localStComment = (CertifiedAccountMeta.StComment)localIterator.next();
        if (paramString1.equals(localStComment.id.get()))
        {
          int i = localStComment.vecReply.size();
          boolean bool = true;
          i -= 1;
          while (i >= 0)
          {
            if (paramString2.equals(((CertifiedAccountMeta.StReply)localStComment.vecReply.get(i)).id.get()))
            {
              if (localStComment.vecReply.get().remove(i) == null) {
                bool = false;
              }
              return bool;
            }
            i -= 1;
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, CertifiedAccountMeta.StReply paramStReply)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramStReply.id.get())))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        CertifiedAccountMeta.StComment localStComment = (CertifiedAccountMeta.StComment)localIterator.next();
        if (paramString1.equals(localStComment.id.get()))
        {
          int i = localStComment.vecReply.size();
          boolean bool = true;
          i -= 1;
          while (i >= 0)
          {
            if (paramString2.equals(((CertifiedAccountMeta.StReply)localStComment.vecReply.get(i)).id.get()))
            {
              if (localStComment.vecReply.get().set(i, paramStReply) == null) {
                bool = false;
              }
              return bool;
            }
            i -= 1;
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(Collection<CertifiedAccountMeta.StComment> paramCollection)
  {
    if (paramCollection != null) {
      return this.b.addAll(paramCollection);
    }
    return false;
  }
  
  public void b(CertifiedAccountMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      int i = 10;
      Integer localInteger = (Integer)this.c.get(paramStComment.id.get());
      if (localInteger != null) {
        i = 10 + localInteger.intValue();
      }
      this.c.put(paramStComment.id.get(), Integer.valueOf(i));
      notifyDataSetChanged();
    }
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public int c(CertifiedAccountMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (!TextUtils.isEmpty(paramStComment.id.get())))
    {
      this.c.put(paramStComment.id.get(), Integer.valueOf(3));
      notifyDataSetChanged();
      return 3;
    }
    return -1;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CertifiedAccountMeta.StComment localStComment = (CertifiedAccountMeta.StComment)getItem(paramInt);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (!(paramView instanceof MoreCommentPanel)) {}
    }
    else
    {
      localObject = new CommentView(this.a);
      ((CommentView)localObject).setOnCommentElementClickListener(this.d);
      ((View)localObject).setTag(localObject);
    }
    paramView = (CommentView)((View)localObject).getTag();
    paramView.setPosition(paramInt);
    int i = 3;
    paramView.setDisplayNum(3);
    Integer localInteger = (Integer)this.c.get(localStComment.id.get());
    if (localInteger != null) {
      i = localInteger.intValue();
    }
    paramView.setData(localStComment, i, this.e);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.NewCommentAdapter
 * JD-Core Version:    0.7.0.1
 */