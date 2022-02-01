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
  public static int a = 1;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private Context jdField_a_of_type_AndroidContentContext;
  private OnCommentElementClickListener jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
  private String jdField_a_of_type_JavaLangString;
  HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<stSimpleMetaComment> jdField_a_of_type_JavaUtilList;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private String jdField_b_of_type_JavaLangString = "focus";
  HashSet<Integer> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private String c;
  
  public WsCommentAdapter(Context paramContext, OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      WSLog.a("comment", "create mComments ...");
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    else
    {
      WSLog.a("comment", "复用 mComments ...");
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener = paramOnCommentElementClickListener;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public int a(stSimpleMetaComment paramstSimpleMetaComment)
  {
    if ((paramstSimpleMetaComment != null) && (!TextUtils.isEmpty(paramstSimpleMetaComment.id)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramstSimpleMetaComment.id, Integer.valueOf(3));
      notifyDataSetChanged();
      return 3;
    }
    return -1;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(int paramInt, stSimpleMetaComment paramstSimpleMetaComment)
  {
    WSLog.d("comment", "addComment ...2");
    if ((paramstSimpleMetaComment != null) && (paramInt <= this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramstSimpleMetaComment);
    }
  }
  
  public void a(stSimpleMetaComment paramstSimpleMetaComment)
  {
    if ((paramstSimpleMetaComment != null) && (!TextUtils.isEmpty(paramstSimpleMetaComment.id)))
    {
      int i = 10;
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramstSimpleMetaComment.id);
      if (localInteger != null) {
        i = 10 + localInteger.intValue();
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramstSimpleMetaComment.id, Integer.valueOf(i));
      notifyDataSetChanged();
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
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
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
    WSLog.d("comment", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
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
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
  }
  
  public boolean a(String paramString)
  {
    WSLog.d("comment", "removeComment ...");
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (!bool2)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        if (paramString.equals(((stSimpleMetaComment)this.jdField_a_of_type_JavaUtilList.get(i)).id))
        {
          if (this.jdField_a_of_type_JavaUtilList.remove(i) != null) {
            bool1 = true;
          }
          this.jdField_a_of_type_JavaUtilMap.remove(paramString);
          return bool1;
        }
        i -= 1;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, stSimpleMetaComment paramstSimpleMetaComment)
  {
    WSLog.d("comment", "updateComment ...");
    if (!TextUtils.isEmpty(paramString))
    {
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        if (paramString.equals(((stSimpleMetaComment)this.jdField_a_of_type_JavaUtilList.get(i)).id))
        {
          if (this.jdField_a_of_type_JavaUtilList.set(i, paramstSimpleMetaComment) == null) {
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
    WSLog.d("comment", "removeCommentReply ...");
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)localIterator.next();
        if (paramString1.equals(localstSimpleMetaComment.id))
        {
          int i = localstSimpleMetaComment.replyList.size();
          boolean bool = true;
          i -= 1;
          while (i >= 0)
          {
            if (paramString2.equals(((stSimpleMetaReply)localstSimpleMetaComment.replyList.get(i)).id))
            {
              if (localstSimpleMetaComment.replyList.remove(i) == null) {
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
  
  public boolean a(String paramString1, String paramString2, stSimpleMetaReply paramstSimpleMetaReply)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCommentReply ............. mComments.size:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
    WSLog.d("comment", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramstSimpleMetaReply.id)))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)((Iterator)localObject).next();
        if (paramString1.equals(localstSimpleMetaComment.id))
        {
          int i = localstSimpleMetaComment.replyList.size();
          boolean bool = true;
          i -= 1;
          while (i >= 0)
          {
            if (paramString2.equals(((stSimpleMetaReply)localstSimpleMetaComment.replyList.get(i)).id))
            {
              if (localstSimpleMetaComment.replyList.set(i, paramstSimpleMetaReply) == null) {
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
  
  public boolean a(Collection<stSimpleMetaComment> paramCollection)
  {
    if (paramCollection != null) {
      return this.jdField_a_of_type_JavaUtilList.addAll(paramCollection);
    }
    return false;
  }
  
  public void b()
  {
    HashSet localHashSet = this.jdField_a_of_type_JavaUtilHashSet;
    if (localHashSet != null) {
      localHashSet.clear();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(localstSimpleMetaComment.hashCode())))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(localstSimpleMetaComment.hashCode()));
        paramViewGroup = WSCommentBeaconReport.c(this.jdField_b_of_type_JavaLangString);
        paramView = paramViewGroup;
        if (!paramViewGroup.equals("comment_tag"))
        {
          paramView = new StringBuilder();
          paramView.append(paramViewGroup);
          paramView.append(jdField_a_of_type_Int);
          paramView = paramView.toString();
        }
        WSCommentBeaconReport.a(this.jdField_b_of_type_JavaLangString, a(), paramView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
      }
      else
      {
        paramView = new StringBuilder();
        paramView.append("重复的position:");
        paramView.append(paramInt);
        paramView.append(",不上报");
        WSLog.b("beacon-comment", paramView.toString());
      }
      paramView = new MoreCommentPanel(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)paramView.findViewById(2131371485)).setTextColor(-7829368);
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
      paramViewGroup = new WsCommentView(this.jdField_a_of_type_AndroidContentContext);
      ((WsCommentView)paramViewGroup).setOnCommentElementClickListener(this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener);
      paramViewGroup.setTag(paramViewGroup);
    }
    paramView = (WsCommentView)paramViewGroup.getTag();
    paramView.setPosition(paramInt);
    paramInt = 3;
    paramView.setDisplayNum(3);
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localstSimpleMetaComment.id);
    if (localInteger != null) {
      paramInt = localInteger.intValue();
    }
    paramView.setData(localstSimpleMetaComment, paramInt, this.jdField_a_of_type_JavaLangString);
    return paramViewGroup;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentAdapter
 * JD-Core Version:    0.7.0.1
 */