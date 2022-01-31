package com.tencent.biz.pubaccount.readinjoy.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bbfj;
import bfos;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import mqq.os.MqqHandler;
import nol;
import ntv;
import ntx;
import oez;
import ogj;
import ogm;
import ogn;
import ogp;
import ogq;
import ogr;
import ogs;
import ogt;
import ogu;
import ogv;
import ogw;
import ogz;
import ohc;
import ohe;
import ohf;
import ohh;
import ohi;
import ohj;
import ohk;
import oil;
import ojz;
import okb;
import okf;
import onh;
import onz;
import oos;
import org.json.JSONException;
import org.json.JSONObject;
import osj;
import qda;

public class ReadInJoyCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, ntx, ohe, ohh
{
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfos jdField_a_of_type_Bfos = new ogp(this);
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private LayoutInflateProcessor jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  private String jdField_a_of_type_JavaLangString = "";
  private ogj jdField_a_of_type_Ogj;
  private ogn jdField_a_of_type_Ogn;
  private ogv jdField_a_of_type_Ogv;
  private ogw jdField_a_of_type_Ogw;
  private ogz jdField_a_of_type_Ogz;
  private ohj jdField_a_of_type_Ohj;
  private ohk jdField_a_of_type_Ohk;
  private okb jdField_a_of_type_Okb;
  private onz jdField_a_of_type_Onz = new onz();
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "huawei_vog-al00", "huawei_vog-al10", "huawei_ele-al00", "samsung_sm-g9750" };
  private int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 5;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean;
  private View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean;
  private View jdField_h_of_type_AndroidViewView;
  private boolean jdField_h_of_type_Boolean;
  private View jdField_i_of_type_AndroidViewView;
  private boolean jdField_i_of_type_Boolean = true;
  private View j;
  
  public ReadInJoyCommentListFragment()
  {
    this.jdField_a_of_type_Int = 2131375746;
  }
  
  private int a()
  {
    oil localoil = oil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localoil != null) {
      return (int)localoil.a();
    }
    return -1;
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131370856);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370872);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131372594);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
  }
  
  private void a(AnchorData paramAnchorData)
  {
    if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "initAnchor " + paramAnchorData.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(paramAnchorData.jdField_b_of_type_JavaLangString)) && (!paramAnchorData.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
        FragmentTransaction localFragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.setCustomAnimations(2130772314, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramAnchorData.jdField_a_of_type_JavaLangString, paramAnchorData.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int);
        localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
        localFragmentTransaction.commitAllowingStateLoss();
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_c_of_type_AndroidViewView, false);
        ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentListFragment.2(this), 1000L);
      }
      this.jdField_a_of_type_Ogn.a(new ogq(this));
    }
  }
  
  private boolean a(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    int m = paramArrayOfString.length;
    int k = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (k < m)
      {
        if (paramArrayOfString[k].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      k += 1;
    }
  }
  
  private boolean a(boolean paramBoolean, okf paramokf)
  {
    if (this.jdField_a_of_type_Okb == null) {
      this.jdField_a_of_type_Okb = new okb(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    if ((!paramBoolean) || ((!this.jdField_a_of_type_Okb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (oos.b())))
    {
      this.jdField_a_of_type_Okb.a(new ogu(this, paramokf));
      this.jdField_a_of_type_Ogn.b();
      this.jdField_a_of_type_Okb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_Okb.a(getActivity().getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_Ogz = new ogz();
    this.jdField_a_of_type_Ogz.a(this.jdField_a_of_type_Bfos);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Ogz);
    paramView.findViewById(2131364267).setOnClickListener(this);
    paramView.findViewById(2131368186).setOnClickListener(this);
    paramView.findViewById(2131377350).setOnClickListener(this);
    paramView.findViewById(2131370857).setOnClickListener(this);
    if (this.jdField_a_of_type_Ohk != null) {
      this.jdField_a_of_type_Ohk.a(paramView);
    }
    ntv.a().a(6666, this);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ogj != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean) {}
        for (String str = "1";; str = "2")
        {
          localJSONObject.put("replyViewStatus", str);
          this.jdField_a_of_type_Ogj.onViewState(paramBoolean, localJSONObject.toString());
          QLog.d("ReadInJoyCommentListFragment", 0, "notifySecondCommentViewStateChanged | visible " + paramBoolean + "; jsonStr " + localJSONObject.toString());
          return;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ReadInJoyCommentListFragment", 0, "notifySecondCommentViewStateChanged " + localJSONException.getMessage());
      }
    }
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, this.jdField_i_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    if (this.jdField_i_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setBackgroundResource(2130841255);
    }
  }
  
  private void d(View paramView)
  {
    View localView;
    if (this.jdField_e_of_type_Boolean)
    {
      localView = paramView.findViewById(2131364466);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.jdField_g_of_type_Boolean)
    {
      localView = paramView.findViewById(2131376014);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.jdField_f_of_type_Boolean)
    {
      paramView = paramView.findViewById(2131363273);
      paramView.setVisibility(0);
      paramView.setOnClickListener(this);
    }
  }
  
  private void g()
  {
    this.jdField_g_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131562303, null, false);
    this.jdField_h_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131370856);
    this.j = this.jdField_g_of_type_AndroidViewView.findViewById(2131370872);
    this.jdField_i_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131369500);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) && (this.jdField_h_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.addHeaderView(this.jdField_g_of_type_AndroidViewView);
    }
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Ogw != null) && (this.jdField_a_of_type_Ogw.jdField_a_of_type_Int > 0))
    {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, this.jdField_a_of_type_Ogw.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Ogw.jdField_b_of_type_Int);
      QLog.d("ReadInJoyCommentListFragment", 0, "setPaddingTop : " + this.jdField_a_of_type_Ogw.jdField_a_of_type_Int);
    }
  }
  
  private void i()
  {
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  private void j()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_h_of_type_Boolean);
    if (this.jdField_a_of_type_Ogw != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b(this.jdField_a_of_type_Ogw.jdField_c_of_type_Int);
      QLog.d("ReadInJoyCommentListFragment", 0, "initSubCommentFragment | setMarginTop " + this.jdField_a_of_type_Ogw.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new ogr(this));
    localObject = getActivity().getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).add(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
    ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.d();
    this.jdField_a_of_type_Ogn = new ogn(getActivity(), this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Ogn);
  }
  
  private void l()
  {
    boolean bool2 = true;
    Bundle localBundle = getArguments();
    if (localBundle == null) {}
    do
    {
      return;
      this.jdField_e_of_type_Boolean = localBundle.getBoolean("arg_comment_list_comment_btn", false);
      this.jdField_f_of_type_Boolean = localBundle.getBoolean("arg_comment_list_biu_btn", false);
      this.jdField_g_of_type_Boolean = localBundle.getBoolean("arg_comment_list_share_btn", false);
      this.jdField_d_of_type_Boolean = localBundle.getBoolean("readinjoy_open_comment_with_edit_panel", false);
      this.jdField_i_of_type_Boolean = getActivity().getIntent().getBooleanExtra(oez.READINJOY_IS_INDEPENDENT_COMPONENTS, true);
      this.jdField_h_of_type_Boolean = localBundle.getBoolean("fromViola");
    } while (!this.jdField_h_of_type_Boolean);
    if (this.jdField_a_of_type_Ogw == null) {
      this.jdField_a_of_type_Ogw = new ogw();
    }
    this.jdField_i_of_type_Boolean = false;
    this.jdField_d_of_type_Int = localBundle.getInt("serviceType");
    ogw localogw = this.jdField_a_of_type_Ogw;
    if (!localBundle.getBoolean("isHiddenFirstPageEditorBar", false))
    {
      bool1 = true;
      localogw.jdField_a_of_type_Boolean = bool1;
      localogw = this.jdField_a_of_type_Ogw;
      if (localBundle.getBoolean("isHiddenHeaderRow", false)) {
        break label332;
      }
      bool1 = true;
      label174:
      localogw.jdField_b_of_type_Boolean = bool1;
      localogw = this.jdField_a_of_type_Ogw;
      if (localBundle.getBoolean("isHiddenSecPageEditorBar", false)) {
        break label337;
      }
      bool1 = true;
      label199:
      localogw.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_Ogw.jdField_a_of_type_Int = localBundle.getInt("padding_top");
      this.jdField_a_of_type_Ogw.jdField_b_of_type_Int = localBundle.getInt("margin_bottom");
      this.jdField_a_of_type_Ogw.jdField_c_of_type_Int = localBundle.getInt("secPageOffsetY");
      this.jdField_a_of_type_Ogw.jdField_d_of_type_Int = localBundle.getInt("secPageShowDirection", 2);
      localogw = this.jdField_a_of_type_Ogw;
      if (localBundle.getInt("isHiddenSecPageMaskView", 0) != 0) {
        break label342;
      }
    }
    label332:
    label337:
    label342:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localogw.jdField_d_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.getParcelable("articleInfo"));
      this.jdField_c_of_type_Int = localBundle.getInt("source");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = ((CommonCommentData)localBundle.getSerializable("commonCommentData"));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label174;
      bool1 = false;
      break label199;
    }
  }
  
  private void m()
  {
    LinearLayout localLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if ((this.jdField_a_of_type_Ogw == null) || (!this.jdField_a_of_type_Ogw.jdField_a_of_type_Boolean)) {
        break label37;
      }
    }
    label37:
    for (int k = 0;; k = 8)
    {
      localLinearLayout.setVisibility(k);
      return;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      String str = new ohi(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(this.jdField_e_of_type_Int).d(1).a();
      nol.a(null, ohf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, str, false);
    }
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Onz != null)
    {
      l = this.jdField_a_of_type_Onz.b();
      this.jdField_a_of_type_Onz.c();
    }
    return l;
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  }
  
  public ohj a()
  {
    return this.jdField_a_of_type_Ohj;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      if (this.jdField_d_of_type_Int == 0) {
        break label74;
      }
    }
    label74:
    for (int k = this.jdField_d_of_type_Int;; k = 5)
    {
      QLog.d("ReadInJoyCommentListFragment", 0, "fetchCommentDataByViola by viola feedstype " + k + "contentSrc " + this.jdField_c_of_type_Int);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, true, k, this.jdField_c_of_type_Int);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    if (paramInt1 == 2)
    {
      a(false, null, null);
      localQQAppInterface = (QQAppInterface)getActivity().getAppInterface();
      str2 = ohf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (this.jdField_c_of_type_Int != 2) {
        break label100;
      }
    }
    label100:
    for (String str1 = "1";; str1 = "2")
    {
      nol.a(localQQAppInterface, str2, "0X800920E", "0X800920E", 0, 0, str1, String.valueOf(paramInt1), "", "", false);
      return;
      if (paramInt1 != 1) {
        break;
      }
      e();
      if (this.jdField_a_of_type_Ohj == null) {
        break;
      }
      this.jdField_a_of_type_Ohj.a(false);
      break;
    }
  }
  
  public void a(Bundle paramBundle, ohj paramohj, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Ohj = paramohj;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    setArguments(paramBundle);
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    a(paramArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt)
  {
    a(paramArticleInfo, paramAnchorData, paramBoolean, 5, paramInt);
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      oil localoil = oil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (localoil != null) {
        localoil.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      }
      oil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt1);
    }
    this.jdField_a_of_type_Onz.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = paramAnchorData;
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (!bbfj.g(getActivity())) {
      b(3);
    }
    for (;;)
    {
      a(paramAnchorData);
      this.jdField_a_of_type_Ogn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      this.jdField_a_of_type_Ogn.a(paramArticleInfo, paramAnchorData, paramBoolean, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.e();
      o();
      return;
      b(1);
    }
  }
  
  public void a(LayoutInflateProcessor paramLayoutInflateProcessor)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor = paramLayoutInflateProcessor;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(ogj paramogj)
  {
    this.jdField_a_of_type_Ogj = paramogj;
  }
  
  public void a(ogm paramogm)
  {
    if (this.jdField_a_of_type_Ogn != null) {
      this.jdField_a_of_type_Ogn.a(paramogm);
    }
  }
  
  public void a(ogv paramogv)
  {
    if (paramogv != null) {
      this.jdField_a_of_type_Ogv = paramogv;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str;
    long l;
    Object localObject1;
    if ((this.jdField_c_of_type_Int == 2) && (getView() != null))
    {
      str = (Build.MANUFACTURER + "_" + Build.MODEL).toLowerCase();
      l = Aladdin.getConfig(259).getIntegerFromString("comment_setFitsSystemWindows_switch", 1);
      localObject1 = Aladdin.getConfig(259).getString("comment_setFitsSystemWindows_phone_list", "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label156;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).split("\\|");
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = this.jdField_a_of_type_ArrayOfJavaLangString;
        }
        if ((l == 1L) && (!a(str, (String[])localObject3))) {
          getView().setFitsSystemWindows(paramBoolean);
        }
        getView().setPadding(0, 0, 0, 0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label156:
      Object localObject2 = null;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyCommentListFragment", 0, "setSubCommentFragmentVisible | visible " + paramBoolean);
    b(paramBoolean);
    if (!paramBoolean)
    {
      paramString1 = getActivity().getSupportFragmentManager().beginTransaction();
      if ((this.jdField_a_of_type_Ogw != null) && (this.jdField_a_of_type_Ogw.jdField_d_of_type_Int == 2))
      {
        paramString1.setCustomAnimations(2130772313, 0);
        paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.d();
        paramString1.commitAllowingStateLoss();
        this.jdField_b_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
        this.jdField_a_of_type_Ogn.notifyDataSetChanged();
        this.jdField_a_of_type_Onz.a();
        if (this.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        }
      }
    }
    do
    {
      return;
      paramString1.setCustomAnimations(2130771981, 2130772011);
      break;
      this.jdField_a_of_type_Onz.b();
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
    FragmentTransaction localFragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
    if ((this.jdField_a_of_type_Ogw != null) && (this.jdField_a_of_type_Ogw.jdField_d_of_type_Int == 2)) {
      localFragmentTransaction.setCustomAnimations(2130772313, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramString1, paramString2, this.jdField_c_of_type_Int);
      localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_c_of_type_AndroidViewView, false);
      if (!this.jdField_h_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
      localFragmentTransaction.setCustomAnimations(2130771981, 2130772011);
    }
  }
  
  public boolean a()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    while ((this.jdField_a_of_type_Ogn == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null)) {
      return;
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_f_of_type_AndroidViewView != null) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      if (this.j != null) {
        this.j.setVisibility(8);
      }
      if (this.jdField_h_of_type_AndroidViewView != null) {
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_i_of_type_AndroidViewView != null) {
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeaderViewsCount() > 0)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        if (this.jdField_i_of_type_AndroidViewView != null) {
          this.jdField_i_of_type_AndroidViewView.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.g();
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader loadingView");
        return;
      case 3: 
        if (this.j != null) {
          this.j.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.g();
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader noNetworkView");
        return;
      case 2: 
        if (this.jdField_h_of_type_AndroidViewView != null) {
          this.jdField_h_of_type_AndroidViewView.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(false);
        }
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader noCommentView");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.g();
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.g();
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jdField_f_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.g();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader loadingView");
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.g();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noNetworkView");
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jdField_e_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.g();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noContentView");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jdField_e_of_type_AndroidViewView);
    QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noContentView");
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Ogw != null) {
      return this.jdField_a_of_type_Ogw.jdField_b_of_type_Boolean;
    }
    return true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.findViewById(2131371846).setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_b_of_type_Int == 2)
    {
      a(false, null, null);
      bool1 = true;
    }
    Bundle localBundle;
    do
    {
      do
      {
        return bool1;
        if (this.jdField_a_of_type_Ohj != null)
        {
          this.jdField_a_of_type_Ohj.a(a());
          this.jdField_a_of_type_Ogn.jdField_b_of_type_Int = 0;
        }
        localBundle = getActivity().getIntent().getBundleExtra("bundle");
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
      bool1 = bool2;
    } while (localBundle == null);
    osj.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "onPanelClose", localBundle.getInt("seq"));
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    while (a(true, new ogs(this))) {
      return;
    }
    int k = 4;
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
      k = 2;
    }
    for (;;)
    {
      ohf.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, k, "", this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Ohj, -1, this.jdField_c_of_type_Boolean);
      return;
      if ((ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda != null))
      {
        if (ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int)) {
          k = 9;
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGallery != 0) {
        k = 17;
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Ogn != null) && (this.jdField_a_of_type_Ogn.a() != null))
    {
      this.jdField_a_of_type_Ogn.a().b(a(), 2);
      this.jdField_a_of_type_Ogn.a().a();
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) && (this.jdField_a_of_type_Ogn != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Ogn.f();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ogn.e();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str;
    if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra("arg_result_json");
      paramInt1 = paramIntent.getIntExtra("click_comment_edit_src", -1);
      paramInt2 = paramIntent.getIntExtra("comment_cmd", 0);
      paramIntent = oil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (paramIntent != null) {
        break label62;
      }
    }
    label62:
    do
    {
      do
      {
        return;
        if (paramInt2 == 1)
        {
          a(false, new ogt(this));
          return;
        }
      } while (this.jdField_a_of_type_Ogn == null);
      if (paramInt1 == 2)
      {
        paramIntent.d(str, this.jdField_a_of_type_Ogn.b());
        return;
      }
    } while (paramInt1 != 3);
    paramIntent.c(str, this.jdField_a_of_type_Ogn.b());
  }
  
  public boolean onBackEvent()
  {
    return c();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363273: 
    case 2131364267: 
    case 2131364466: 
    case 2131376014: 
    case 2131368186: 
    case 2131370857: 
    case 2131370856: 
    case 2131370872: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (this.jdField_a_of_type_Ohj == null);
            this.jdField_a_of_type_Ohj.onClick(paramView);
            this.jdField_a_of_type_Ohj.a(a());
            this.jdField_a_of_type_Ogn.jdField_b_of_type_Int = 0;
            this.jdField_a_of_type_Onz.b();
            return;
          } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
          d();
        } while (paramView.getId() != 2131368186);
        paramView = new ohi(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(this.jdField_e_of_type_Int).a();
        nol.a((QQAppInterface)getActivity().getAppInterface(), ohf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramView, false);
        return;
      } while (this.jdField_a_of_type_Ogn == null);
      b(1);
      this.jdField_a_of_type_Ogn.a();
      return;
    case 2131377350: 
      n();
      return;
    }
    a(false, null, null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {}
    for (paramLayoutInflater = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(2131559843, true, new ViewGroup.LayoutParams(-1, -1));; paramLayoutInflater = paramLayoutInflater.inflate(2131559843, paramViewGroup, false))
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater;
      this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378104));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131363339));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)paramLayoutInflater.findViewById(2131364497));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366189));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371846));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369461));
      l();
      if (this.jdField_i_of_type_Boolean)
      {
        paramLayoutInflater.setFitsSystemWindows(false);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup;
      }
      b(1);
      if (this.jdField_a_of_type_Ogw != null)
      {
        i();
        m();
        h();
      }
      d(paramLayoutInflater);
      k();
      j();
      c(paramLayoutInflater);
      b(paramLayoutInflater);
      if (this.jdField_d_of_type_Boolean) {
        d();
      }
      if (ThemeUtil.isInNightMode(getActivity().app))
      {
        paramViewGroup = new View(getActivity());
        paramViewGroup.setBackgroundColor(1996488704);
        getActivity().addContentView(paramViewGroup, new ViewGroup.LayoutParams(-1, -1));
      }
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Ogv != null) {
        this.jdField_a_of_type_Ogv.onViewCreated(this.jdField_a_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!this.jdField_h_of_type_Boolean))
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, this.jdField_c_of_type_Boolean, 5, this.jdField_c_of_type_Int);
        QLog.d("ReadInJoyCommentListFragment", 0, "onCreateView | fetchCommentDataByViola");
      }
      a(paramLayoutInflater);
      g();
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ogn != null)
    {
      this.jdField_a_of_type_Ogn.d();
      this.jdField_a_of_type_Ogn = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.onDestroy();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = null;
    }
    this.jdField_a_of_type_Ohj = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = null;
    this.jdField_a_of_type_Ogv = null;
    Bundle localBundle = getActivity().getIntent().getBundleExtra("bundle");
    if (localBundle != null) {
      osj.a().d(localBundle.getInt("seq"));
    }
    ntv.a().b(6666, this);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Onz.b();
      return;
    }
    this.jdField_a_of_type_Onz.a();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Onz.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_a_of_type_Onz.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b();
    }
    if ((getActivity() != null) && (getActivity().isFinishing()) && (this.jdField_a_of_type_Ogn != null))
    {
      oil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Ogn.b());
      QLog.d("ReadInJoyCommentListFragment", 1, "onStop | removeCommentDataManager feedsType " + this.jdField_a_of_type_Ogn.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment
 * JD-Core Version:    0.7.0.1
 */