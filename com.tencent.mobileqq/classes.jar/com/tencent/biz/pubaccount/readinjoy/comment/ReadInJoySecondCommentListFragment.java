package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bkur;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import noo;
import nty;
import nua;
import odr;
import ofv;
import ogr;
import ohf;
import ohi;
import ohk;
import ohp;
import ohs;
import oht;
import ohu;
import oio;
import onk;
import ooc;
import qdd;
import qol;

public class ReadInJoySecondCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, View.OnLongClickListener, nua
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private LayoutInflateProcessor jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  private String jdField_a_of_type_JavaLangString;
  private ogr jdField_a_of_type_Ogr;
  private ohk jdField_a_of_type_Ohk;
  private ohp jdField_a_of_type_Ohp;
  private ohs jdField_a_of_type_Ohs;
  private ooc jdField_a_of_type_Ooc = new ooc();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  private int a()
  {
    int i = 0;
    if (bkur.b()) {
      i = ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    i = qol.a(getActivity()) - i;
    QLog.d("ReadInJoySecondCommentListFragment", 2, "onCreateView | marginTop is " + i);
    return i;
  }
  
  private void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      QLog.d("ReadInJoySecondCommentListFragment", 2, "read to BiuActivity second   commonCommentData :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.toString());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setVisibility(0);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    do
    {
      return;
      localObject1 = oio.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    } while (localObject1 == null);
    Object localObject1 = (CommentData)((oio)localObject1).a(this.jdField_a_of_type_JavaLangString);
    int k = 4;
    int m = 19;
    int i;
    int j;
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (onk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      i = 2;
      j = 20;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag() == -1)) {
        break label359;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
    }
    label359:
    for (;;)
    {
      Object localObject2 = ((CommentData)localObject1).commentContent;
      String str = ((CommentData)localObject1).uin;
      localObject2 = onk.a(new Intent(getActivity(), ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, (String)localObject2, Long.valueOf(str).longValue(), ((CommentData)localObject1).nickName, 0, j);
      ((Intent)localObject2).putExtra("fast_biu_type", paramBoolean);
      a((Intent)localObject2);
      getActivity().startActivity((Intent)localObject2);
      getActivity().overridePendingTransition(0, 0);
      localObject1 = new ofv(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (BaseCommentData)localObject1).a().a(this.jdField_a_of_type_JavaLangString).a();
      noo.a(null, ohi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800901A", "0X800901A", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
      return;
      j = m;
      i = k;
      if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      j = m;
      i = k;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd == null) {
        break;
      }
      j = m;
      i = k;
      if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Int)) {
        break;
      }
      i = 9;
      j = 20;
      break;
    }
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if ((this.jdField_c_of_type_Int == 0) && (this.jdField_c_of_type_Boolean)) {
        this.jdField_c_of_type_Int = a();
      }
    } while (!(this.jdField_b_of_type_AndroidViewView.getLayoutParams() instanceof FrameLayout.LayoutParams));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.setMargins(0, this.jdField_c_of_type_Int, 0, 0);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void h()
  {
    oio localoio = oio.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localoio == null) {}
    while ((localoio.a() != 1) || (localoio.a() != null)) {
      return;
    }
    ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364259)).setImageResource(2130842235);
  }
  
  private void i()
  {
    this.jdField_a_of_type_Ohs = new ohs(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Ohs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Ohs);
    if (this.jdField_a_of_type_Ohk != null) {
      this.jdField_a_of_type_Ohs.a(this.jdField_a_of_type_Ogr);
    }
    this.jdField_a_of_type_Ohs.a(new ohu(this));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Ooc.b();
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  }
  
  public ohp a()
  {
    return this.jdField_a_of_type_Ohp;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Ooc.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Ohs != null)
    {
      this.jdField_a_of_type_Ohs.a(paramString1, paramString2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
      paramString2 = this.jdField_a_of_type_Ohs.a();
      if (paramString2 != null) {
        paramString1 = paramString2.a(paramString1);
      }
    }
    for (;;)
    {
      b(false);
      h();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.e();
      paramString1 = new ofv(paramArticleInfo, paramString1).a().a();
      noo.a(null, ohi.a(paramArticleInfo), "0X800901F", "0X800901F", 0, 0, String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), paramArticleInfo.innerUniqueID, paramString1, false);
      return;
      paramString1 = null;
      continue;
      paramString1 = null;
    }
  }
  
  public void a(LayoutInflateProcessor paramLayoutInflateProcessor)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor = paramLayoutInflateProcessor;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(ogr paramogr)
  {
    this.jdField_a_of_type_Ogr = paramogr;
  }
  
  public void a(ohk paramohk, Bundle paramBundle, ohp paramohp)
  {
    this.jdField_a_of_type_Ohk = paramohk;
    this.jdField_a_of_type_Ohp = paramohp;
    setArguments(paramBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Ooc.b();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ohk != null) {
      this.jdField_a_of_type_Ohk.a(false, null, null);
    }
  }
  
  public void d()
  {
    oio localoio = oio.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localoio != null) {
      localoio.b();
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.findViewById(2131371846) != null))
    {
      QLog.d("ReadInJoySecondCommentListFragment", 2, "setMaskView");
      this.jdField_b_of_type_AndroidViewView.findViewById(2131371846).setVisibility(0);
    }
  }
  
  public void f()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.findViewById(2131371846) != null))
    {
      QLog.d("ReadInJoySecondCommentListFragment", 2, "hideMaskView");
      this.jdField_b_of_type_AndroidViewView.findViewById(2131371846).setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (this.d)
    {
      c();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    }
    label125:
    do
    {
      int j;
      do
      {
        do
        {
          return;
          j = 4;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
        paramView = oio.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      } while (paramView == null);
      int i;
      CommentData localCommentData;
      FragmentActivity localFragmentActivity;
      ArticleInfo localArticleInfo;
      StringBuilder localStringBuilder;
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (onk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
        localCommentData = (CommentData)paramView.a(this.jdField_a_of_type_JavaLangString);
        localFragmentActivity = getActivity();
        localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        localStringBuilder = new StringBuilder().append(getActivity().getString(2131718359));
        if (localCommentData == null) {
          break label346;
        }
      }
      for (paramView = localCommentData.nickName;; paramView = "")
      {
        ohi.a(localFragmentActivity, localArticleInfo, localCommentData, i, paramView, "", false, this.jdField_a_of_type_Ohp, -1);
        if (localCommentData == null) {
          break;
        }
        paramView = new ofv(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localCommentData).a().a(this.jdField_a_of_type_JavaLangString).a();
        noo.a(null, ohi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009019", "0X8009019", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramView, false);
        return;
        i = j;
        if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          break label125;
        }
        i = j;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd == null) {
          break label125;
        }
        i = j;
        if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Int)) {
          break label125;
        }
        i = 9;
        break label125;
      }
      if (odr.a() == 1) {
        bool = true;
      }
      c(bool);
      return;
      j();
      return;
      f();
    } while (this.jdField_a_of_type_Ohk == null);
    label346:
    this.jdField_a_of_type_Ohk.a(false, null, null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {}
    for (paramLayoutInflater = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(2131560004, true, new ViewGroup.LayoutParams(-1, -1));; paramLayoutInflater = paramLayoutInflater.inflate(2131560004, paramViewGroup, false))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131377400));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramLayoutInflater.findViewById(2131364268).setOnClickListener(this);
      paramLayoutInflater.findViewById(2131368186).setOnClickListener(this);
      paramLayoutInflater.findViewById(2131377350).setOnClickListener(this);
      if (ThemeUtil.isInNightMode(onk.a())) {
        ((ViewStub)paramLayoutInflater.findViewById(2131374820)).inflate();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)paramLayoutInflater.findViewById(2131364498));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(new oht(this));
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131364477);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366189));
      i();
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater;
      g();
      nty.a().a(6666, this);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    if (getActivity() != null) {
      super.onDestroy();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    if (this.jdField_a_of_type_Ohs != null)
    {
      this.jdField_a_of_type_Ohs.a();
      this.jdField_a_of_type_Ohs = null;
    }
    this.jdField_a_of_type_Ohk = null;
    nty.a().b(6666, this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    try
    {
      Field localField = Fragment.class.getDeclaredField("mChildFragmentManager");
      localField.setAccessible(true);
      localField.set(this, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Ooc.b();
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_Ohs != null) && (this.jdField_a_of_type_Ohs.a() != null))
        {
          this.jdField_a_of_type_Ohs.a().a(a());
          this.jdField_a_of_type_Ooc.c();
        }
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    this.jdField_a_of_type_Ooc.a();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (odr.b() == 1) {}
    for (;;)
    {
      c(bool);
      return false;
      bool = false;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.d = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment
 * JD-Core Version:    0.7.0.1
 */