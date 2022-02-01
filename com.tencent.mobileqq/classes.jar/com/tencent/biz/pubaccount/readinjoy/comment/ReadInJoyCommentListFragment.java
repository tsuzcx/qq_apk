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
import bhnv;
import blih;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRequestData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.os.MqqHandler;
import ocd;
import oid;
import oif;
import ono;
import opb;
import org.json.JSONException;
import org.json.JSONObject;
import orr;
import oru;
import orv;
import orx;
import ory;
import orz;
import osa;
import osb;
import osc;
import osd;
import ose;
import osf;
import osg;
import osj;
import osm;
import oso;
import osp;
import osr;
import oss;
import ost;
import osu;
import otv;
import ovq;
import ovs;
import ovw;
import ozs;
import pag;
import pbb;
import pfd;
import pfh;
import qyl;

public class ReadInJoyCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, oif, oso, osr
{
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blih jdField_a_of_type_Blih = new orx(this);
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private LayoutInflateProcessor jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  private String jdField_a_of_type_JavaLangString = "";
  private ono jdField_a_of_type_Ono;
  private orr jdField_a_of_type_Orr;
  private orv jdField_a_of_type_Orv;
  private osf jdField_a_of_type_Osf;
  private osg jdField_a_of_type_Osg;
  private osj jdField_a_of_type_Osj;
  private ost jdField_a_of_type_Ost;
  private osu jdField_a_of_type_Osu;
  private ovs jdField_a_of_type_Ovs;
  private pag jdField_a_of_type_Pag = new pag();
  private pfh jdField_a_of_type_Pfh = new orz(this);
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
  private boolean jdField_i_of_type_Boolean;
  private View jdField_j_of_type_AndroidViewView;
  private boolean jdField_j_of_type_Boolean = true;
  
  public ReadInJoyCommentListFragment()
  {
    this.jdField_a_of_type_Int = 2131377214;
  }
  
  private int a()
  {
    otv localotv = otv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localotv != null) {
      return (int)localotv.a();
    }
    return -1;
  }
  
  private FragmentTransaction a()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_i_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (getChildFragmentManager() != null) {
        localObject1 = getChildFragmentManager().beginTransaction();
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (getActivity() == null);
      localObject1 = localObject2;
    } while (getActivity().getSupportFragmentManager() == null);
    return getActivity().getSupportFragmentManager().beginTransaction();
  }
  
  public static void a(Intent paramIntent, ono paramono, int paramInt1, boolean paramBoolean, ArticleInfo paramArticleInfo, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    QLog.d("ReadInJoyCommentListFragment", 1, "contentSrc = " + paramInt1 + " isBiu = " + paramBoolean);
    String str = paramIntent.getStringExtra("arg_result_json");
    paramIntent = "";
    Object localObject4 = "";
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject5 = new JSONObject(str);
        str = ((JSONObject)localObject5).optString("comment");
        Object localObject1;
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          bool1 = ((JSONObject)localObject5).optBoolean("select_to_friend");
          bool2 = bool3;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            Object localObject2;
            bool1 = false;
          }
        }
        try
        {
          localObject1 = ((JSONObject)localObject5).optString("commentId");
          bool2 = bool3;
          paramIntent = (Intent)localObject1;
          bool3 = ((JSONObject)localObject5).optBoolean("isSecondReply");
          bool2 = bool3;
          paramIntent = (Intent)localObject1;
          localObject5 = ((JSONObject)localObject5).optString("replyUin");
          localObject4 = localObject5;
          paramIntent = (Intent)localObject1;
          bool2 = bool3;
          localObject1 = localObject4;
          if (!TextUtils.isEmpty(str))
          {
            localObject4 = new RIJBiuAndCommentRequestData();
            ((RIJBiuAndCommentRequestData)localObject4).setBiu(paramBoolean);
            ((RIJBiuAndCommentRequestData)localObject4).setContentSrc(paramInt1);
            ((RIJBiuAndCommentRequestData)localObject4).setContentString(str);
            ((RIJBiuAndCommentRequestData)localObject4).setDiffuseToFriends(bool1);
            if (paramArticleInfo != null) {
              break label278;
            }
            str = "";
            ((RIJBiuAndCommentRequestData)localObject4).setRowKey(str);
            ((RIJBiuAndCommentRequestData)localObject4).setListShowType(paramInt2);
            ((RIJBiuAndCommentRequestData)localObject4).setCommentType(paramInt3);
            ((RIJBiuAndCommentRequestData)localObject4).setReplyCommentId(paramIntent);
            ((RIJBiuAndCommentRequestData)localObject4).setIsSecondReply(bool2);
            ((RIJBiuAndCommentRequestData)localObject4).setReplyUin((String)localObject1);
            paramono.a(paramArticleInfo, (RIJBiuAndCommentRequestData)localObject4);
          }
          return;
        }
        catch (JSONException localJSONException3)
        {
          break label266;
        }
        localJSONException1 = localJSONException1;
        str = "";
        bool1 = false;
      }
      label266:
      localObject2 = localObject4;
      continue;
      label278:
      str = paramArticleInfo.innerUniqueID;
      continue;
      str = "";
      bool3 = false;
      Object localObject3 = localObject4;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131371852);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371868);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131373721);
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
        FragmentTransaction localFragmentTransaction = a();
        if (localFragmentTransaction != null)
        {
          localFragmentTransaction.setCustomAnimations(2130772342, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramAnchorData.jdField_a_of_type_JavaLangString, paramAnchorData.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int);
          localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
          localFragmentTransaction.commitAllowingStateLoss();
        }
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_c_of_type_AndroidViewView, false);
        ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentListFragment.2(this), 1000L);
      }
      this.jdField_a_of_type_Orv.a(new ory(this));
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
  
  private boolean a(boolean paramBoolean, ovw paramovw)
  {
    if (getActivity() == null) {
      QLog.d("ReadInJoyCommentListFragment", 0, "showGuidePopupWindow | activity is null");
    }
    do
    {
      return false;
      if (this.jdField_a_of_type_Ovs == null) {
        this.jdField_a_of_type_Ovs = new ovs(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      }
    } while ((paramBoolean) && ((this.jdField_a_of_type_Ovs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) || (!pbb.b())));
    this.jdField_a_of_type_Ovs.a(new osd(this, paramovw));
    this.jdField_a_of_type_Orv.b();
    this.jdField_a_of_type_Ovs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_a_of_type_Ovs.a(getActivity().getWindow().getDecorView());
    return true;
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_Osj = new osj();
    this.jdField_a_of_type_Osj.a(this.jdField_a_of_type_Blih);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Osj);
    paramView.findViewById(2131364592).setOnClickListener(this);
    paramView.findViewById(2131368725).setOnClickListener(this);
    paramView.findViewById(2131378936).setOnClickListener(this);
    paramView.findViewById(2131371853).setOnClickListener(this);
    if (this.jdField_a_of_type_Osu != null) {
      this.jdField_a_of_type_Osu.a(paramView);
    }
    oid.a().a(6666, this);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Orr != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean) {}
        for (String str = "1";; str = "2")
        {
          localJSONObject.put("replyViewStatus", str);
          this.jdField_a_of_type_Orr.onViewState(paramBoolean, localJSONObject.toString());
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, this.jdField_j_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    if (this.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setBackgroundResource(2130841685);
    }
  }
  
  private void d(View paramView)
  {
    View localView;
    if (this.jdField_e_of_type_Boolean)
    {
      localView = paramView.findViewById(2131364803);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.jdField_g_of_type_Boolean)
    {
      localView = paramView.findViewById(2131377500);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.jdField_f_of_type_Boolean)
    {
      paramView = paramView.findViewById(2131363531);
      paramView.setVisibility(0);
      paramView.setOnClickListener(this);
    }
  }
  
  private void g()
  {
    this.jdField_g_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131562791, null, false);
    this.jdField_h_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131371852);
    this.jdField_j_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131371868);
    this.jdField_i_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131370318);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) && (this.jdField_h_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.addHeaderView(this.jdField_g_of_type_AndroidViewView);
    }
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Osg != null) && (this.jdField_a_of_type_Osg.jdField_a_of_type_Int > 0))
    {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, this.jdField_a_of_type_Osg.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Osg.jdField_b_of_type_Int);
      QLog.d("ReadInJoyCommentListFragment", 0, "setPaddingTop : " + this.jdField_a_of_type_Osg.jdField_a_of_type_Int);
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
    if (this.jdField_a_of_type_Osg != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b(this.jdField_a_of_type_Osg.jdField_c_of_type_Int);
      QLog.d("ReadInJoyCommentListFragment", 0, "initSubCommentFragment | setMarginTop " + this.jdField_a_of_type_Osg.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new osa(this));
    localObject = a();
    if (localObject != null)
    {
      ((FragmentTransaction)localObject).add(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.d();
    this.jdField_a_of_type_Orv = new orv(getActivity(), this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Orv);
    pfd.a().a(this.jdField_a_of_type_Pfh);
  }
  
  private void l()
  {
    boolean bool2 = true;
    Bundle localBundle = getArguments();
    if (localBundle == null) {}
    do
    {
      return;
      this.jdField_i_of_type_Boolean = localBundle.getBoolean("arg_comment_is_fragment_container", false);
      this.jdField_e_of_type_Boolean = localBundle.getBoolean("arg_comment_list_comment_btn", false);
      this.jdField_f_of_type_Boolean = localBundle.getBoolean("arg_comment_list_biu_btn", false);
      this.jdField_g_of_type_Boolean = localBundle.getBoolean("arg_comment_list_share_btn", false);
      this.jdField_d_of_type_Boolean = localBundle.getBoolean("readinjoy_open_comment_with_edit_panel", false);
      this.jdField_j_of_type_Boolean = getActivity().getIntent().getBooleanExtra(opb.READINJOY_IS_INDEPENDENT_COMPONENTS, true);
      this.jdField_h_of_type_Boolean = localBundle.getBoolean("fromViola");
    } while (!this.jdField_h_of_type_Boolean);
    if (this.jdField_a_of_type_Osg == null) {
      this.jdField_a_of_type_Osg = new osg();
    }
    this.jdField_j_of_type_Boolean = false;
    this.jdField_d_of_type_Int = localBundle.getInt("serviceType");
    osg localosg = this.jdField_a_of_type_Osg;
    if (!localBundle.getBoolean("isHiddenFirstPageEditorBar", false))
    {
      bool1 = true;
      localosg.jdField_a_of_type_Boolean = bool1;
      localosg = this.jdField_a_of_type_Osg;
      if (localBundle.getBoolean("isHiddenHeaderRow", false)) {
        break label344;
      }
      bool1 = true;
      label186:
      localosg.jdField_b_of_type_Boolean = bool1;
      localosg = this.jdField_a_of_type_Osg;
      if (localBundle.getBoolean("isHiddenSecPageEditorBar", false)) {
        break label349;
      }
      bool1 = true;
      label211:
      localosg.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_Osg.jdField_a_of_type_Int = localBundle.getInt("padding_top");
      this.jdField_a_of_type_Osg.jdField_b_of_type_Int = localBundle.getInt("margin_bottom");
      this.jdField_a_of_type_Osg.jdField_c_of_type_Int = localBundle.getInt("secPageOffsetY");
      this.jdField_a_of_type_Osg.jdField_d_of_type_Int = localBundle.getInt("secPageShowDirection", 2);
      localosg = this.jdField_a_of_type_Osg;
      if (localBundle.getInt("isHiddenSecPageMaskView", 0) != 0) {
        break label354;
      }
    }
    label344:
    label349:
    label354:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localosg.jdField_d_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.getParcelable("articleInfo"));
      this.jdField_c_of_type_Int = localBundle.getInt("source");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = ((CommonCommentData)localBundle.getSerializable("commonCommentData"));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label186;
      bool1 = false;
      break label211;
    }
  }
  
  private void m()
  {
    LinearLayout localLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if ((this.jdField_a_of_type_Osg == null) || (!this.jdField_a_of_type_Osg.jdField_a_of_type_Boolean)) {
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
      String str = new oss(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(this.jdField_e_of_type_Int).d(1).a();
      ocd.a(null, osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, str, false);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Ono != null) {
      this.jdField_a_of_type_Ono.a();
    }
    this.jdField_a_of_type_Ono = new ono();
    this.jdField_a_of_type_Ono.a(new ose(this));
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Pag != null)
    {
      l = this.jdField_a_of_type_Pag.b();
      this.jdField_a_of_type_Pag.c();
    }
    return l;
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  }
  
  public ost a()
  {
    return this.jdField_a_of_type_Ost;
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
      str2 = osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (this.jdField_c_of_type_Int != 2) {
        break label100;
      }
    }
    label100:
    for (String str1 = "1";; str1 = "2")
    {
      ocd.a(localQQAppInterface, str2, "0X800920E", "0X800920E", 0, 0, str1, String.valueOf(paramInt1), "", "", false);
      return;
      if (paramInt1 != 1) {
        break;
      }
      e();
      if (this.jdField_a_of_type_Ost == null) {
        break;
      }
      this.jdField_a_of_type_Ost.a(false);
      break;
    }
  }
  
  public void a(Bundle paramBundle, ost paramost, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Ost = paramost;
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
      otv localotv = otv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (localotv != null) {
        localotv.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      }
      otv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt1);
    }
    this.jdField_a_of_type_Pag.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = paramAnchorData;
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (!bhnv.g(getActivity())) {
      b(3);
    }
    for (;;)
    {
      a(paramAnchorData);
      this.jdField_a_of_type_Orv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      this.jdField_a_of_type_Orv.a(paramArticleInfo, paramAnchorData, paramBoolean, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.e();
      o();
      p();
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
  
  public void a(orr paramorr)
  {
    this.jdField_a_of_type_Orr = paramorr;
  }
  
  public void a(oru paramoru)
  {
    if (this.jdField_a_of_type_Orv != null) {
      this.jdField_a_of_type_Orv.a(paramoru);
    }
  }
  
  public void a(osf paramosf)
  {
    if (paramosf != null) {
      this.jdField_a_of_type_Osf = paramosf;
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
      paramString1 = a();
      if (paramString1 != null)
      {
        if ((this.jdField_a_of_type_Osg != null) && (this.jdField_a_of_type_Osg.jdField_d_of_type_Int == 2))
        {
          paramString1.setCustomAnimations(2130772341, 0);
          paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.d();
          paramString1.commitAllowingStateLoss();
        }
      }
      else
      {
        this.jdField_b_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
        this.jdField_a_of_type_Orv.notifyDataSetChanged();
        this.jdField_a_of_type_Pag.a();
        if (this.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        }
      }
    }
    do
    {
      return;
      paramString1.setCustomAnimations(2130771981, 2130772012);
      break;
      this.jdField_a_of_type_Pag.b();
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
    FragmentTransaction localFragmentTransaction = a();
    if (localFragmentTransaction != null)
    {
      if ((this.jdField_a_of_type_Osg == null) || (this.jdField_a_of_type_Osg.jdField_d_of_type_Int != 2)) {
        break label298;
      }
      localFragmentTransaction.setCustomAnimations(2130772341, 0);
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
      label298:
      localFragmentTransaction.setCustomAnimations(2130771981, 2130772012);
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
    while ((this.jdField_a_of_type_Orv == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null)) {
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
      if (this.jdField_j_of_type_AndroidViewView != null) {
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
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
        if (this.jdField_j_of_type_AndroidViewView != null) {
          this.jdField_j_of_type_AndroidViewView.setVisibility(0);
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
    if (this.jdField_a_of_type_Osg != null) {
      return this.jdField_a_of_type_Osg.jdField_b_of_type_Boolean;
    }
    return true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.findViewById(2131372875).setVisibility(8);
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
    Object localObject;
    do
    {
      do
      {
        do
        {
          return bool1;
          if ((this.jdField_a_of_type_Ost != null) && (this.jdField_a_of_type_Orv != null))
          {
            this.jdField_a_of_type_Ost.a(a());
            this.jdField_a_of_type_Orv.jdField_b_of_type_Int = 0;
          }
          localObject = getActivity();
          bool1 = bool2;
        } while (localObject == null);
        localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
      bool1 = bool2;
    } while (localObject == null);
    pfd.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "onPanelClose", ((Bundle)localObject).getInt("seq"));
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    while (a(true, new osb(this))) {
      return;
    }
    int k = 4;
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
      k = 2;
    }
    for (;;)
    {
      osp.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, k, "", this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Ost, -1, this.jdField_c_of_type_Boolean);
      return;
      if ((ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl != null))
      {
        if (ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Int)) {
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
    if ((this.jdField_a_of_type_Orv != null) && (this.jdField_a_of_type_Orv.a() != null))
    {
      this.jdField_a_of_type_Orv.a().b(a(), 2);
      this.jdField_a_of_type_Orv.a().a();
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) && (this.jdField_a_of_type_Orv != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Orv.f();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Orv.e();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int k = 2;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra("arg_result_json");
      paramInt1 = paramIntent.getIntExtra("click_comment_edit_src", -1);
      paramInt2 = paramIntent.getIntExtra("comment_cmd", 0);
      paramIntent = otv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (paramIntent != null) {}
    }
    while ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != 1699))
    {
      String str;
      do
      {
        do
        {
          return;
          if (paramInt2 == 1)
          {
            a(false, new osc(this));
            return;
          }
        } while (this.jdField_a_of_type_Orv == null);
        if (paramInt1 == 2)
        {
          paramIntent.d(str, this.jdField_a_of_type_Orv.b());
          return;
        }
      } while (paramInt1 != 3);
      paramIntent.c(str, this.jdField_a_of_type_Orv.b());
      return;
    }
    paramInt1 = k;
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      paramInt1 = 1;
    }
    a(paramIntent, this.jdField_a_of_type_Ono, this.jdField_c_of_type_Int, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Orv.b(), paramInt1);
  }
  
  public boolean onBackEvent()
  {
    return c();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Ost != null)
      {
        this.jdField_a_of_type_Ost.onClick(paramView);
        this.jdField_a_of_type_Ost.a(a());
        this.jdField_a_of_type_Orv.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Pag.b();
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
        {
          d();
          if (paramView.getId() == 2131368725)
          {
            String str = new oss(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(this.jdField_e_of_type_Int).a();
            ocd.a((QQAppInterface)getActivity().getAppInterface(), osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, str, false);
            continue;
            if (this.jdField_a_of_type_Orv != null)
            {
              b(1);
              this.jdField_a_of_type_Orv.a();
              continue;
              n();
              continue;
              a(false, null, null);
            }
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {}
    for (paramLayoutInflater = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(2131560096, true, new ViewGroup.LayoutParams(-1, -1));; paramLayoutInflater = paramLayoutInflater.inflate(2131560096, paramViewGroup, false))
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater;
      this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379751));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131363594));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)paramLayoutInflater.findViewById(2131364833));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366582));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372875));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370266));
      l();
      if (this.jdField_j_of_type_Boolean)
      {
        paramLayoutInflater.setFitsSystemWindows(false);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup;
      }
      b(1);
      if (this.jdField_a_of_type_Osg != null)
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
      if (this.jdField_a_of_type_Osf != null) {
        this.jdField_a_of_type_Osf.onViewCreated(this.jdField_a_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!this.jdField_h_of_type_Boolean))
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, this.jdField_c_of_type_Boolean, 5, this.jdField_c_of_type_Int);
        QLog.d("ReadInJoyCommentListFragment", 0, "onCreateView | fetchCommentDataByViola");
      }
      a(paramLayoutInflater);
      g();
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Orv != null)
    {
      this.jdField_a_of_type_Orv.d();
      this.jdField_a_of_type_Orv = null;
      pfd.a().b(this.jdField_a_of_type_Pfh);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.onDestroy();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = null;
    }
    this.jdField_a_of_type_Ost = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = null;
    this.jdField_a_of_type_Osf = null;
    Bundle localBundle = getActivity().getIntent().getBundleExtra("bundle");
    if (localBundle != null) {
      pfd.a().d(localBundle.getInt("seq"));
    }
    if (this.jdField_a_of_type_Ono != null) {
      this.jdField_a_of_type_Ono.a();
    }
    oid.a().b(6666, this);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Pag.b();
      return;
    }
    this.jdField_a_of_type_Pag.a();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Pag.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a();
    }
    QLog.d("ReadInJoyCommentListFragment", 0, "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_a_of_type_Pag.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b();
    }
    if ((getActivity() != null) && (getActivity().isFinishing()) && (this.jdField_a_of_type_Orv != null))
    {
      otv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Orv.b());
      QLog.d("ReadInJoyCommentListFragment", 1, "onStop | removeCommentDataManager feedsType " + this.jdField_a_of_type_Orv.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment
 * JD-Core Version:    0.7.0.1
 */