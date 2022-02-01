package com.tencent.biz.pubaccount.readinjoy.comment.guide;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.CommentGuideConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class GuideHelper
  implements ReadInJoyCommentDataManager.OnDataChangeListener
{
  private int jdField_a_of_type_Int = 10;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  
  private void a(String paramString, ArticleInfo paramArticleInfo)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.i().b("wording", "" + CommentGuideConfigHandler.a());
    ReadInJoyCommentUtils.a(paramString, paramArticleInfo, localReportR5Builder);
  }
  
  public View a(ViewGroup paramViewGroup, View paramView, Context paramContext, CommentViewItem paramCommentViewItem)
  {
    if (!a(paramCommentViewItem)) {
      return paramView;
    }
    if ((!TextUtils.isEmpty(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      a("0X8009FE9", paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_JavaUtilSet.add(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    this.jdField_a_of_type_Boolean = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (localLayoutParams.bottomMargin >= 0) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131298873));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
    if (paramView != null) {}
    for (;;)
    {
      paramView.setOnClickListener(new GuideHelper.1(this, paramCommentViewItem, paramContext));
      return paramView;
      paramView = LayoutInflater.from(paramContext).inflate(2131560428, null);
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("GuideHelper", 1, "showGuidePagerNum : " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void a(String paramString)
  {
    QLog.d("GuideHelper", 1, "extraInfo : " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).getString("app_schema");
      QLog.d("GuideHelper", 1, "scheme : " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("GuideHelper", 1, "setGuideExtraInfo : ", paramString);
    }
  }
  
  public void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = 0;
    if (paramViewGroup == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (!paramBoolean) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131298871));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(CommentViewItem paramCommentViewItem)
  {
    return (paramCommentViewItem != null) && (paramCommentViewItem.jdField_a_of_type_Int == 6);
  }
  
  public boolean a(List<CommentViewItem> paramList)
  {
    int i = this.b;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (i > this.jdField_a_of_type_Int) && (paramList != null))
    {
      CommentViewItem localCommentViewItem = new CommentViewItem(6, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((CommentViewItem)localIterator.next()).jdField_a_of_type_Int == 6) {
          localIterator.remove();
        }
      }
      paramList.add(localCommentViewItem);
      QLog.d("GuideHelper", 1, "addGuidePager : " + i + "  articleInfo :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return true;
    }
    return false;
  }
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair) {}
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2) {}
  
  public void onCommentLikeOrDislike(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    this.b = 1;
    a(paramList);
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2)
  {
    this.b += 1;
    a(paramList);
  }
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem) {}
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onCommentStateError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.guide.GuideHelper
 * JD-Core Version:    0.7.0.1
 */