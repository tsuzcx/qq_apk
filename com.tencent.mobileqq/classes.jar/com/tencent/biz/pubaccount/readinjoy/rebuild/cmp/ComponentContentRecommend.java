package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bdfr;
import bdin;
import bkbq;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.widgets.ListViewForListview;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import nrt;
import oqu;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import owy;
import oxb;
import oxe;
import pgd;
import phg;
import pxj;
import pxt;
import qbs;
import qcq;
import qcr;
import qcu;
import qcv;
import qcw;
import qcx;
import qlt;
import rqj;

public class ComponentContentRecommend
  extends FrameLayout
  implements pxj
{
  private static int jdField_a_of_type_Int = -1;
  public static final String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ListViewForListview jdField_a_of_type_ComTencentBizWidgetsListViewForListview;
  private ArrayList<RecommendFollowInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected oxe a;
  private qbs jdField_a_of_type_Qbs;
  
  static
  {
    jdField_a_of_type_JavaLangString = ComponentContentRecommend.class.getSimpleName();
  }
  
  public ComponentContentRecommend(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Oxe = new qcx(this);
    b(paramContext);
  }
  
  public ComponentContentRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Oxe = new qcx(this);
    b(paramContext);
  }
  
  public static String a(int paramInt1, long paramLong1, BaseArticleInfo paramBaseArticleInfo, long paramLong2, int paramInt2, int paramInt3, int paramInt4, List<RecommendFollowInfo> paramList)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("algorithm_id", paramLong2 + "");
        localJSONObject.put("folder_status", ors.d + "");
        localJSONObject.put("feeds_type", "70");
        localJSONObject.put("time", System.currentTimeMillis());
        localJSONObject.put("channel_id", paramInt1);
        if (!NetworkState.isWifiConn()) {
          break label425;
        }
        paramInt1 = 2;
        localJSONObject.put("network_type", paramInt1);
        localJSONObject.put("feeds_source", paramLong1 + "");
        localJSONObject.put("imei", ors.f());
        localJSONObject.put("imsi", ors.g());
        localJSONObject.put("idfa", "");
        localJSONObject.put("rowkey", paramBaseArticleInfo.innerUniqueID + "");
        localJSONObject.put("comment", 0);
        if (bkbq.I(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label430;
        }
        paramInt1 = 1;
        localJSONObject.put("reddot_style", paramInt1);
        localJSONObject.put("tab_source", paramInt4);
        localJSONObject.put("kandian_mode", ors.e());
        if (paramInt3 != 0) {
          localJSONObject.put("select_num", paramInt3);
        }
        localJSONObject.put("sub_type", paramInt2);
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          paramBaseArticleInfo = new StringBuilder();
          paramInt1 = 0;
          if (paramInt1 < paramList.size())
          {
            paramBaseArticleInfo.append(((RecommendFollowInfo)paramList.get(paramInt1)).uin);
            if (paramInt1 < paramList.size() - 1) {
              paramBaseArticleInfo.append("|");
            }
          }
          else
          {
            localJSONObject.put("feedssource_more", paramBaseArticleInfo.toString());
          }
        }
        else
        {
          paramBaseArticleInfo = localJSONObject.toString();
          return paramBaseArticleInfo;
        }
      }
      catch (JSONException paramBaseArticleInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "report" + QLog.getStackTraceString(paramBaseArticleInfo));
        }
        return "";
      }
      paramInt1 += 1;
      continue;
      label425:
      paramInt1 = 1;
      continue;
      label430:
      paramInt1 = 0;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mRecommendFollowInfos == null) || (paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap == null) || (paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {
      return;
    }
    Iterator localIterator = paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      a("0X80094DB", paramInt, localRecommendFollowInfo.uin, paramBaseArticleInfo, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId);
    }
    paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public static void a(String paramString, int paramInt1, long paramLong1, BaseArticleInfo paramBaseArticleInfo, long paramLong2, int paramInt2)
  {
    String str = a(paramInt1, paramLong1, paramBaseArticleInfo, paramLong2, 1, 0, jdField_a_of_type_Int, null);
    nrt.a(null, ors.a() + "", paramString, paramString, 0, 0, paramBaseArticleInfo.mRecommendFollowId + "", paramBaseArticleInfo.mArticleID + "", paramInt2 + "", str, false);
  }
  
  private void a(String paramString, RecommendFollowInfo paramRecommendFollowInfo)
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_Qbs != null)
    {
      i = j;
      if (this.jdField_a_of_type_Qbs.a() != null)
      {
        i = j;
        if (this.jdField_a_of_type_Qbs.a().a() != null) {
          i = this.jdField_a_of_type_Qbs.a().a().a();
        }
      }
    }
    a(paramString, i, paramRecommendFollowInfo.uin, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId);
  }
  
  private void a(pgd parampgd)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = parampgd.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    do
    {
      return;
      jdField_a_of_type_Int = ors.d();
      parampgd = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos;
      if ((parampgd != null) && (parampgd.jdField_a_of_type_JavaUtilList != null) && (parampgd.jdField_a_of_type_JavaUtilList.size() > 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "setContent(): data is empty");
    return;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      parampgd = new qcq(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(parampgd);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(parampgd);
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Qbs != null) && (this.jdField_a_of_type_Qbs.a() != null) && (this.jdField_a_of_type_Qbs.a().a() != null)) {}
    for (int i = this.jdField_a_of_type_Qbs.a().a().a();; i = 0)
    {
      a("0X8009494", i, 0L, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0L, 0);
      return;
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qbs = new qbs();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559952, this, true);
  }
  
  protected BaseAdapter a()
  {
    return new qcr(this);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369239));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368737));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378695));
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview = ((ListViewForListview)paramView.findViewById(2131369895));
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = a();
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    Animation localAnimation;
    do
    {
      return;
      localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772184);
    } while (localAnimation == null);
    localAnimation.setInterpolator(new LinearInterpolator());
    paramImageView.startAnimation(localAnimation);
  }
  
  public void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!bdin.g(getContext())) {
      QQToast.a(getContext(), 1, 2131718961, 0).a();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    paramRecommendFollowInfo = oqu.k + bdfr.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", paramRecommendFollowInfo);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    ((Activity)getContext()).startActivityForResult(localIntent, 1);
  }
  
  public void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (bdin.g(getContext()))
    {
      if (paramBoolean)
      {
        a("0X80094DC", paramRecommendFollowInfo);
        if (paramRecommendFollowInfo.type != 1) {
          break label55;
        }
        c(paramRecommendFollowInfo, paramBoolean);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        return;
        a("0X80094DD", paramRecommendFollowInfo);
        break;
        label55:
        if (paramRecommendFollowInfo.type == 2) {
          b(paramRecommendFollowInfo, paramBoolean);
        } else {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "followAccount, error type, info.type = " + paramRecommendFollowInfo.type + ", follow = " + paramBoolean);
        }
      }
    }
    QQToast.a(getContext(), 1, 2131718961, 0).a();
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pgd))
    {
      paramObject = (pgd)paramObject;
      this.jdField_a_of_type_Qbs.a(paramObject);
      a(paramObject);
    }
  }
  
  public void a(pxt parampxt) {}
  
  public void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    oxb.a().b(paramRecommendFollowInfo.uin, paramRecommendFollowInfo.isFollowed);
    owy.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ThreadManager.post(new ComponentContentRecommend.6(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    owy.a().a().a(localQQAppInterface.getCurrentAccountUin(), paramRecommendFollowInfo.uin + "", paramBoolean, new qcu(this, paramRecommendFollowInfo), 2);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      owy.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, new qcv(this, paramRecommendFollowInfo), 1);
      return;
    }
    owy.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, new qcw(this, paramRecommendFollowInfo), 1);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    oxb.a().a(this.jdField_a_of_type_Oxe);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    oxb.a().b(this.jdField_a_of_type_Oxe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend
 * JD-Core Version:    0.7.0.1
 */