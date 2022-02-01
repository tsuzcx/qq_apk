package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.res.Configuration;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerModule.ChannelBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController.IInsertArticleCallback;
import com.tencent.biz.pubaccount.readinjoy.model.ColumnInfoForSelfPage;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule.UserCoinInfo;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule.CommentReportInfo;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FollowingMember;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KingMomentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.IEntranceButtonDataSource;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ModuleInfo;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.TextCardInfo;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeRspBody;

public class ReadInJoyObserver
  implements BusinessObserver
{
  public void a(float paramFloat, int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, ColumnInfoForSelfPage paramColumnInfoForSelfPage) {}
  
  public void a(int paramInt, long paramLong, String paramString) {}
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  
  public void a(int paramInt1, long paramLong, List<Long> paramList, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void a(int paramInt, SelectPositionModule.PositionData paramPositionData) {}
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2) {}
  
  public void a(int paramInt, KingMomentInfo paramKingMomentInfo) {}
  
  public void a(int paramInt, Object paramObject) {}
  
  public void a(int paramInt, List<Long> paramList) {}
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList) {}
  
  public void a(long paramLong, int paramInt, String paramString) {}
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(View paramView) {}
  
  public void a(@NonNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo) {}
  
  public void a(ArticleInfo paramArticleInfo, boolean paramBoolean) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo) {}
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo) {}
  
  public void a(TopBannerInfo paramTopBannerInfo) {}
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource) {}
  
  public void a(AbsListView paramAbsListView) {}
  
  public void a(Long paramLong) {}
  
  public void a(Object paramObject, int paramInt, boolean paramBoolean, String... paramVarArgs) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4) {}
  
  public void a(String paramString1, int paramInt, oidb_cmd0xbd6.RspBody paramRspBody, String paramString2) {}
  
  public void a(String paramString, List<ArticleInfo> paramList, RIJFeedsInsertController.IInsertArticleCallback paramIInsertArticleCallback) {}
  
  public void a(ArrayList<String> paramArrayList) {}
  
  public void a(List<String> paramList, List<TopicInfo> paramList1) {}
  
  public void a(oidb_cmd0xef9.PrivilegeRspBody paramPrivilegeRspBody, long paramLong, int paramInt) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1) {}
  
  public void a(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RIJCoinInfoModule.UserCoinInfo paramUserCoinInfo) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RIJCommentReportModule.CommentReportInfo paramCommentReportInfo) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2) {}
  
  public void a(boolean paramBoolean1, int paramInt, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void a(boolean paramBoolean, List<TabChannelCoverInfo> paramList) {}
  
  public void a(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, List<Long> paramList, List<ArticleInfo> paramList1) {}
  
  public void a_(List<SubscriptionFeed> paramList) {}
  
  public void aj_() {}
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(int paramInt, List<Long> paramList) {}
  
  public void b(long paramLong, boolean paramBoolean) {}
  
  public void b(String paramString) {}
  
  public void b(String paramString1, String paramString2, int paramInt) {}
  
  public void b(List<InterestLabelInfo> paramList) {}
  
  public void b(List<oidb_cmd0xe7e.ModuleInfo> paramList, List<oidb_cmd0xe7e.TextCardInfo> paramList1) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean, List<ChannelCoverInfo> paramList) {}
  
  public void b(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2) {}
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void c(int paramInt, List<Long> paramList) {}
  
  public void c(List<TagInfo> paramList) {}
  
  public void c(boolean paramBoolean, List<ChannelCoverInfo> paramList) {}
  
  public void c(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2) {}
  
  public void d(int paramInt) {}
  
  public void d(int paramInt, List<RIJChannelBannerModule.ChannelBannerInfo> paramList) {}
  
  public void d(boolean paramBoolean) {}
  
  public void d(boolean paramBoolean, List<DiandianTopConfig> paramList) {}
  
  public void e(String paramString) {}
  
  public void e(String paramString, int paramInt) {}
  
  public void e(boolean paramBoolean, List<ChannelInfo> paramList) {}
  
  public void f(int paramInt) {}
  
  public void f(String paramString) {}
  
  public void f(String paramString, int paramInt) {}
  
  public void f(boolean paramBoolean, List<ChannelInfo> paramList) {}
  
  public void f_(int paramInt) {}
  
  public void g(int paramInt) {}
  
  public void g(String paramString, int paramInt) {}
  
  public void g(boolean paramBoolean, List<Integer> paramList) {}
  
  public void h(int paramInt) {}
  
  public void h(boolean paramBoolean, List<ChannelCoverInfo> paramList) {}
  
  public void i() {}
  
  public void i(int paramInt) {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject) {}
  
  public void p() {}
  
  public void q() {}
  
  public void z_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver
 * JD-Core Version:    0.7.0.1
 */