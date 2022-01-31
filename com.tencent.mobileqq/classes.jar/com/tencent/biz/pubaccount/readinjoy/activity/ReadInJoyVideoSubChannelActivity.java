package com.tencent.biz.pubaccount.readinjoy.activity;

import ajjy;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awuw;
import azwg;
import azzu;
import bacc;
import badq;
import bbmy;
import begh;
import begr;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mpl;
import ndn;
import nma;
import nmb;
import nmc;
import nmd;
import obj;
import obl;
import obz;
import ogy;
import ohb;
import ohe;
import omq;
import org.json.JSONException;
import org.json.JSONObject;
import pov;
import pqg;
import pqh;
import pqo;
import prv;
import prx;
import pxn;
import pyo;
import pyu;
import qcn;
import qhm;
import qhp;
import qhs;
import qht;
import qhw;
import qiy;
import qjd;
import qje;
import qji;
import qmu;
import qmv;
import qod;
import qoe;
import qpi;
import qpp;
import qsq;
import rvf;
import xcu;

public class ReadInJoyVideoSubChannelActivity
  extends FragmentActivity
  implements View.OnClickListener, begh, qhm, qhs, qjd, qje, qpi, qpp
{
  public int a;
  protected long a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected azwg a;
  private begr jdField_a_of_type_Begr;
  public ReadInJoyXListView a;
  private String jdField_a_of_type_JavaLangString;
  public Map<Integer, Boolean> a;
  public obl a;
  protected ohe a;
  private pyo jdField_a_of_type_Pyo;
  private pyu jdField_a_of_type_Pyu;
  private qhp jdField_a_of_type_Qhp;
  private qiy jdField_a_of_type_Qiy;
  private qoe jdField_a_of_type_Qoe;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Map<Integer, Set<Long>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private int jdField_c_of_type_Int = -1;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Map<Integer, Map<Long, pov>> jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private TextView g;
  
  public ReadInJoyVideoSubChannelActivity()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Ohe = new nmd(this);
  }
  
  private int a()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    return getIntent().getIntExtra("channel_id", 0);
  }
  
  private Context a()
  {
    return this;
  }
  
  private Intent a(ChannelInfo paramChannelInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("struct_share_key_source_icon", "http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
    localIntent.putExtra("struct_share_key_source_a_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_i_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("app_name", "QQ看点");
    localIntent.putExtra("detail_url", pyo.a(paramChannelInfo, 0));
    localIntent.putExtra("title", "「" + paramChannelInfo.mChannelName + ajjy.a(2131647246));
    localIntent.putExtra("desc", paramChannelInfo.mFollowNum + ajjy.a(2131647304));
    localIntent.putExtra("image_url_remote", paramChannelInfo.mHeaderPicUrl);
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("struct_share_key_content_action", "web");
    paramChannelInfo = awuw.a(localIntent.getExtras());
    paramChannelInfo.mMsgServiceID = 83;
    localIntent.putExtra("stuctmsg_bytes", paramChannelInfo.getBytes());
    return localIntent;
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return getIntent().getStringExtra("channel_name");
  }
  
  private Map<Long, pov> a(Integer paramInteger)
  {
    Map localMap = (Map)this.jdField_c_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.jdField_c_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  private void a(ChannelInfo paramChannelInfo)
  {
    if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Begr = begr.a(this);
    this.jdField_a_of_type_Begr.a(ajjy.a(2131647034), 3);
    this.jdField_a_of_type_Begr.d(ajjy.a(2131646952));
    this.jdField_a_of_type_Begr.show();
    this.jdField_a_of_type_Begr.a(new nmc(this, paramChannelInfo));
  }
  
  private void a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doFollowUnFollow(): isFollow =" + paramBoolean);
    }
    paramChannelInfo.mIsFollowed = paramBoolean;
    d(paramChannelInfo.mIsFollowed);
    ogy.a().a(paramChannelInfo);
    ogy.a().a(paramBoolean, 56, paramChannelInfo.mChannelID);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.8(this, paramChannelInfo, paramBoolean));
  }
  
  private void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      View localView = LayoutInflater.from(a()).inflate(2131494522, paramListView, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131301858));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301855));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301849));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301856));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301848));
      this.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramListView.addHeaderView(localView);
    }
  }
  
  private void a(String paramString)
  {
    findViewById(2131306882).setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131305061)).inflate();
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309025));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309024));
    }
    this.g.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Obl.jdField_a_of_type_Long = System.currentTimeMillis();
    bgmq.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Obl.jdField_a_of_type_Long, (QQAppInterface)obz.a());
    Object localObject2 = null;
    if (this.jdField_a_of_type_Qoe != null) {
      this.jdField_a_of_type_Qoe.a(paramBoolean);
    }
    int j = -1;
    Object localObject1 = localObject2;
    int i = j;
    if (c() == 5)
    {
      Object localObject3 = (ReadInJoyChannelActivity.SerializableMap)getIntent().getSerializableExtra("channel_map_data");
      localObject1 = localObject2;
      i = j;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        i = j;
        if (((ReadInJoyChannelActivity.SerializableMap)localObject3).getMap() != null)
        {
          localObject3 = ((ReadInJoyChannelActivity.SerializableMap)localObject3).getMap();
          Long localLong = (Long)((Map)localObject3).get("param_key_insert_article_id");
          localObject1 = localObject2;
          i = j;
          if (localLong != null)
          {
            localObject1 = new ArrayList();
            ((List)localObject1).add(localLong);
            i = 5;
            ((Map)localObject3).remove("param_key_insert_article_id");
          }
        }
      }
    }
    ogy.a().a(this.jdField_b_of_type_Int, (List)localObject1, i, true, false, this.jdField_d_of_type_Int, null, -1L, null, b(), 0L, 0L, null, paramInt, false, null, 0);
    this.jdField_d_of_type_Int += 1;
    rvf.a(paramInt, this.jdField_b_of_type_Int, this, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        if (!paramBoolean2) {
          break label30;
        }
        qcn.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 300);
      }
    }
    label30:
    while (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    if (paramBoolean2)
    {
      qcn.a(this.jdField_b_of_type_AndroidWidgetTextView, 4, 300);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Qhp != null) && (this.jdField_a_of_type_Qhp.a()) && (this.jdField_a_of_type_Qiy != null) && (!this.jdField_a_of_type_Qiy.a()))
    {
      this.jdField_a_of_type_Qiy.d(paramInt);
      return true;
    }
    return false;
  }
  
  private boolean a(Integer paramInteger)
  {
    paramInteger = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool1;
    if (this.jdField_a_of_type_Qoe.getCount() == 0)
    {
      bool1 = true;
      if ((!bool1) && (!paramBoolean)) {
        break label77;
      }
    }
    label77:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isFristLoadFromDB=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) }));
      if (bool2) {
        a(false, 1);
      }
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  private int b()
  {
    return 3;
  }
  
  private void b(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 0) {
      break label7;
    }
    label7:
    while (paramChannelInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "updateHeaderUI(): fromServer = " + paramBoolean + ", channelInfo = " + paramChannelInfo.toString());
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(a());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a());
    if (this.jdField_f_of_type_AndroidWidgetTextView != null)
    {
      if (paramChannelInfo.mFollowNum <= 0) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else {
      label103:
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        if (!paramChannelInfo.mIsTopic) {
          break label202;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      d(paramChannelInfo.mIsFollowed);
      if (this.jdField_e_of_type_Boolean) {
        break;
      }
      this.jdField_e_of_type_Boolean = true;
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.10(this, paramChannelInfo));
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramChannelInfo.mFollowNum + ajjy.a(2131647006));
      break label103;
      label202:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void b(Map<Long, pov> paramMap, boolean paramBoolean)
  {
    if ((paramMap == null) || (paramMap.values() == null) || (!paramBoolean)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramMap = paramMap.values().iterator();
      for (;;)
      {
        if (paramMap.hasNext())
        {
          pov localpov = (pov)paramMap.next();
          if (localpov.jdField_a_of_type_Boolean) {
            continue;
          }
          localpov.jdField_a_of_type_Boolean = true;
          if (localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
            continue;
          }
          ndn.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localpov.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localpov.jdField_b_of_type_Int), obz.a(localpov.jdField_a_of_type_Long, localpov.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localpov.jdField_d_of_type_Int), false);
          ndn.a("0X80066FC", "", "", Long.toString(localpov.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localpov.jdField_b_of_type_Int), obz.a(localpov.jdField_a_of_type_Long, localpov.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localpov.jdField_d_of_type_Int));
          if (qoe.c(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            int i = 0;
            while (i < localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
            {
              ndn.a(null, localpov.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((prx)localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(i)).jdField_a_of_type_Int + "", Integer.toString(localpov.jdField_b_of_type_Int), obz.a(localpov.jdField_a_of_type_Long, localpov.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localpov.jdField_d_of_type_Int, localpov.jdField_e_of_type_Int, badq.h(a()), localpov.jdField_a_of_type_JavaLangString, localpov.jdField_c_of_type_JavaLangString, localpov.jdField_e_of_type_JavaLangString, obz.e(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localpov.jdField_f_of_type_Int, localpov.g, localpov.h, localpov.jdField_f_of_type_Boolean, localpov.j, localpov.i, localpov.m), false);
              i += 1;
            }
          }
          Object localObject1 = new qmv(obz.a(localpov.jdField_a_of_type_Long, localpov.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localpov.jdField_d_of_type_Int, localpov.jdField_e_of_type_Int, badq.h(a()), localpov.jdField_a_of_type_JavaLangString, localpov.jdField_c_of_type_JavaLangString, localpov.jdField_e_of_type_JavaLangString, obz.e(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localpov.jdField_f_of_type_Int, localpov.g, localpov.h, localpov.jdField_f_of_type_Boolean, localpov.j, localpov.i, localpov.m)).a(localpov.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).O(c()).b(localpov.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localpov.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a();
          ndn.a(null, "CliOper", "", localpov.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localpov.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localpov.jdField_b_of_type_Int), (String)localObject1, false);
          ndn.a("0X8007626", localpov.jdField_d_of_type_JavaLangString, Long.toString(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localpov.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localpov.jdField_b_of_type_Int), obz.a(localpov.jdField_a_of_type_Long, localpov.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localpov.jdField_d_of_type_Int, localpov.jdField_e_of_type_Int, badq.h(a()), localpov.jdField_a_of_type_JavaLangString, localpov.jdField_c_of_type_JavaLangString, localpov.jdField_e_of_type_JavaLangString, obz.e(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localpov.jdField_f_of_type_Int, localpov.g, localpov.h, localpov.jdField_f_of_type_Boolean, localpov.j, localpov.i, localpov.m));
          localObject1 = new ReportInfo();
          ((ReportInfo)localObject1).mUin = obz.a();
          ((ReportInfo)localObject1).mSource = 0;
          ((ReportInfo)localObject1).mSourceArticleId = localpov.jdField_a_of_type_JavaLangLong.longValue();
          ((ReportInfo)localObject1).mChannelId = this.jdField_b_of_type_Int;
          ((ReportInfo)localObject1).mAlgorithmId = ((int)localpov.jdField_a_of_type_Long);
          ((ReportInfo)localObject1).mStrategyId = localpov.jdField_b_of_type_Int;
          ((ReportInfo)localObject1).mOperation = 7;
          ((ReportInfo)localObject1).mServerContext = localpov.jdField_a_of_type_ArrayOfByte;
          ((ReportInfo)localObject1).mReadTimeLength = -1;
          ((ReportInfo)localObject1).mInnerId = localpov.jdField_e_of_type_JavaLangString;
          if (localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
            ((ReportInfo)localObject1).mColumnID = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
          }
          Object localObject2;
          if (localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null)
          {
            localObject2 = new pqg();
            ((pqg)localObject2).jdField_a_of_type_Long = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
            if (localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
              ((pqg)localObject2).jdField_b_of_type_Long = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
            }
            ((pqg)localObject2).jdField_a_of_type_Int = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
            ((pqg)localObject2).jdField_b_of_type_Int = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
            Object localObject3 = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
            if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
            {
              ((pqg)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                pqo localpqo = (pqo)((Iterator)localObject3).next();
                if (localpqo != null) {
                  ((pqg)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localpqo.jdField_a_of_type_Long));
                }
              }
            }
            ((ReportInfo)localObject1).mFeedsReportData = ((pqg)localObject2);
          }
          localArrayList.add(localObject1);
          if (localpov.jdField_c_of_type_Boolean) {}
          try
          {
            if (localpov.jdField_d_of_type_Boolean)
            {
              localObject2 = obz.a();
              ((JSONObject)localObject2).put("feeds_source", localpov.jdField_a_of_type_JavaLangString);
              ((JSONObject)localObject2).put("kandian_mode", obz.e());
              ndn.a(null, "CliOper", "", "", "0X800744E", "0X800744E", 0, 0, obz.d(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", ((JSONObject)localObject2).toString(), false);
            }
            if (this.jdField_b_of_type_Int == 56)
            {
              ((ReportInfo)localObject1).mOpSource = 11;
              localObject2 = new pqh();
              ((pqh)localObject2).jdField_c_of_type_Int = 1;
              localObject2 = ((pqh)localObject2).toString();
              ((ReportInfo)localObject1).mInnerId = localpov.jdField_e_of_type_JavaLangString;
              if (QLog.isColorLevel()) {
                QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed subchannel--mUin:" + ((ReportInfo)localObject1).mUin + "; mSource:" + ((ReportInfo)localObject1).mSource + "; mOpSource:" + ((ReportInfo)localObject1).mOpSource + "; mInnerId:" + ((ReportInfo)localObject1).mInnerId + "; mChannelId:" + ((ReportInfo)localObject1).mChannelId + "; mAlgorithmId:" + ((ReportInfo)localObject1).mAlgorithmId + "; mStrategyId:" + ((ReportInfo)localObject1).mStrategyId + "; mOperation:" + ((ReportInfo)localObject1).mOperation + "; mPlayTimeLength:" + ((ReportInfo)localObject1).mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject2);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    } while (localArrayList.isEmpty());
    ogy.a().a(localArrayList);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.h();
    if ((paramBoolean) && (paramInt > 0)) {}
    for (String str = String.format(getResources().getString(2131652508), new Object[] { Integer.valueOf(paramInt) });; str = getResources().getString(2131652507))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(true, str);
      return;
    }
  }
  
  private int c()
  {
    return getIntent().getIntExtra("channel_from", -1);
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Qhp != null) && (this.jdField_a_of_type_Qoe != null) && (this.jdField_a_of_type_Qoe.a() != null) && (this.jdField_a_of_type_Qoe.a().size() > 0)) {
      obz.a(a(), (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_Qhp.a(), (BaseArticleInfo)this.jdField_a_of_type_Qoe.a().get(0), paramBoolean);
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = a();
    this.jdField_c_of_type_Int = b();
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_a_of_type_Qhp = new qhp(this);
    this.jdField_a_of_type_Obl = new obl();
    this.jdField_a_of_type_Obl.jdField_a_of_type_Long = bgmq.a(a(), (QQAppInterface)obz.a());
    this.jdField_a_of_type_Pyu = pyu.a();
    this.jdField_a_of_type_Azwg = new azwg(this, this.app);
    ReadInJoyChannelActivity.SerializableMap localSerializableMap = (ReadInJoyChannelActivity.SerializableMap)getIntent().getSerializableExtra("channel_map_data");
    if ((localSerializableMap != null) && (localSerializableMap.getMap() != null)) {
      this.jdField_a_of_type_Int = ((Integer)localSerializableMap.getMap().get("param_key_channel_column_type")).intValue();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(ajjy.a(2131647169));
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-9211021);
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130842362);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
    }
    else {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(ajjy.a(2131647253));
    this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130842343);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  private void e()
  {
    g();
    h();
    f();
    ChannelInfo localChannelInfo = ogy.a().a(a());
    if (localChannelInfo != null) {
      b(localChannelInfo, false);
    }
    this.jdField_a_of_type_Qiy = new qiy((FrameLayout)findViewById(2131313236), (ReadInJoyBaseListView)findViewById(2131303648), this);
    this.jdField_a_of_type_Qiy.a(this);
    this.jdField_a_of_type_Qhp.a(this.jdField_a_of_type_Qiy);
    this.jdField_a_of_type_Qiy.a(this);
    this.jdField_a_of_type_Qoe.f();
    this.jdField_a_of_type_Qoe.a(c());
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131306882);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131311636));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311571));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311623));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131311613));
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a());
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131303648));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_Qoe = new qod(this, getLayoutInflater(), a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Azwg, omq.a(null));
    this.jdField_a_of_type_Qoe.b(b());
    this.jdField_a_of_type_Qoe.a(this.jdField_a_of_type_Qhp, this.jdField_a_of_type_Pyu);
    this.jdField_a_of_type_Qoe.e();
    this.jdField_a_of_type_Qoe.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Qoe);
  }
  
  private void i()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_d_of_type_AndroidWidgetTextView == null)) {}
    label143:
    for (;;)
    {
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.getLocationOnScreen(this.jdField_b_of_type_ArrayOfInt);
      this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = this.jdField_b_of_type_ArrayOfInt[1] + this.jdField_d_of_type_AndroidWidgetTextView.getHeight();
      int j = this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
      if ((i != 0) && (j != 0))
      {
        if (i <= j) {}
        for (;;)
        {
          if (bool == this.jdField_a_of_type_Boolean) {
            break label143;
          }
          this.jdField_a_of_type_Boolean = bool;
          a(this.jdField_a_of_type_Boolean);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.readinjoy.video.SubChannelActivity", 2, "checkIsTopFixed(): mFixed=" + this.jdField_a_of_type_Boolean);
          return;
          bool = false;
        }
      }
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_Qhp != null) && (this.jdField_a_of_type_Qhp.a() != null)) {
      this.jdField_a_of_type_Qhp.b(11);
    }
  }
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_b_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label104;
      }
      if ((!azzu.b()) && (!azzu.d())) {
        this.mSystemBarComp.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label104:
    if ((Build.VERSION.SDK_INT >= 23) && (!azzu.b()) && (!azzu.d()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!azzu.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    if (paramInt != 0) {}
    a(true, 3);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.2(this));
  }
  
  public void a(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int j = this.jdField_a_of_type_Qoe.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = this.jdField_a_of_type_Qoe.a(j, l);
          if ((localObject != null) && (!obz.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Qoe.a(j, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (xcu.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(List<Long> paramList, int paramInt)
  {
    this.jdField_a_of_type_Qoe.a(ogy.a().a(Integer.valueOf(this.jdField_b_of_type_Int), paramList));
    this.jdField_a_of_type_Qoe.notifyDataSetChanged();
  }
  
  public void a(Map<Long, pov> paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    obj.a();
    bgmq.a((QQAppInterface)obz.a(), System.currentTimeMillis(), this.jdField_b_of_type_Int);
    getIntent().putExtra("from_search", false);
  }
  
  public void a(Set<Long> paramSet, Map<Long, pov> paramMap)
  {
    if (this.jdField_a_of_type_Qoe != null) {
      this.jdField_a_of_type_Qoe.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Obl.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Obl.d = bgmq.a((QQAppInterface)obz.a(), this.jdField_b_of_type_Int);
    ogy.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
    ogy.a().b(56, 3, a());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(true));
  }
  
  public void a(pxn parampxn1, pxn parampxn2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + parampxn1 + "  nextVideoPlayParam:" + parampxn2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    qoe localqoe;
    if ((parampxn1 != null) && ((parampxn1 instanceof qht)) && (parampxn2 != null) && ((parampxn2 instanceof qht)))
    {
      parampxn1 = ((qht)parampxn1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      parampxn2 = ((qht)parampxn2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((parampxn1 != null) && (parampxn2 != null))
      {
        localqoe = this.jdField_a_of_type_Qoe;
        if (paramBoolean) {
          break label135;
        }
      }
    }
    label135:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localqoe.a(parampxn1, parampxn2, paramBoolean);
      return;
    }
  }
  
  public void a(qht paramqht, int paramInt1, int paramInt2) {}
  
  public void a(qht paramqht1, qht paramqht2)
  {
    this.jdField_a_of_type_Qoe.a(paramqht1, paramqht2);
    b(false);
  }
  
  public void a(qht paramqht, qhw paramqhw, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramBoolean, true);
  }
  
  public void b() {}
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    if (paramInt == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      ogy.a().a(this.jdField_b_of_type_Int, b(), paramInt, 0, 1);
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.3(this));
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setVisibility(0);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.f();
    k();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doOnActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (paramInt1 == 101) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (!paramIntent.getBooleanExtra("bFailed", false)) {
        i = 1;
      }
      bbmy localbbmy = new bbmy(this);
      localbbmy.d(2000);
      if (i != 0)
      {
        localbbmy.a(bbmy.a(2));
        localbbmy.c(2131626723);
        localbbmy.b(getApplicationContext().getResources().getDimensionPixelSize(2131167766) - (int)bacc.a(getApplicationContext(), 5.0F));
      }
      else
      {
        localbbmy.a(bbmy.a(1));
        localbbmy.c(2131626724);
        localbbmy.b(getApplicationContext().getResources().getDimensionPixelSize(2131167766) - (int)bacc.a(getApplicationContext(), 5.0F));
        continue;
        if (paramInt1 == 9091) {
          this.jdField_a_of_type_Qoe.a(0, paramIntent);
        } else if ((paramInt1 == 21) && (paramInt2 == -1)) {
          ForwardUtils.a((QQAppInterface)obz.a(), this, getApplicationContext(), paramIntent, null);
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    qji.a().a(this);
    ohb.a().a(this.jdField_a_of_type_Ohe);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setBackgroundDrawable(null);
    setContentView(2131494521);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131311638));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    super.doOnCreate(paramBundle);
    d();
    e();
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Long = 0L;
    ohb.a().b(this.jdField_a_of_type_Ohe);
    qji.a().b(this);
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    if (this.jdField_a_of_type_Qhp != null) {
      this.jdField_a_of_type_Qhp.d();
    }
    if (this.jdField_a_of_type_Qoe != null)
    {
      this.jdField_a_of_type_Qoe.d();
      this.jdField_a_of_type_Qoe.a();
    }
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    qsq.a(this).b();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt == 25) {
      bool1 = a(-1);
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.doOnKeyDown(paramInt, paramKeyEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      if (paramInt == 24) {
        bool1 = a(1);
      } else {
        bool1 = false;
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Qhp.e();
    qsq.a(this).a();
    if (this.jdField_a_of_type_Qoe != null) {
      this.jdField_a_of_type_Qoe.k();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Qhp.f();
    qsq.a(this).a(b(), a());
    if (this.jdField_a_of_type_Qoe != null) {
      this.jdField_a_of_type_Qoe.j();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_Qoe.notifyDataSetChanged();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new nma(this));
    }
  }
  
  public void doOnStop()
  {
    qji.a().a(false, "videoSubChannel onStop");
    super.doOnStop();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Qhp.a() != null) {
      this.jdField_a_of_type_Qhp.a().g();
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_Qoe.l();
    b(true);
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Qhp;
    if ((localObject != null) && (((qhp)localObject).a() != null))
    {
      localObject = ((qhp)localObject).a();
      if (((qiy)localObject).a())
      {
        ((qiy)localObject).g();
        return true;
      }
    }
    c(false);
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            finish();
            return;
            f();
            a(true, 3);
            ogy.a().b(56, 3, a());
            return;
            if (!mpl.a(this))
            {
              bbmy.a(this, ajjy.a(2131646980), 0).a();
              return;
            }
            this.jdField_d_of_type_Boolean = true;
            paramView = ogy.a().a(a());
          } while (paramView == null);
          if (paramView.mIsFollowed)
          {
            a(paramView);
            return;
          }
          a(paramView, true);
          return;
        } while ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != 0));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.f();
        ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.4(this));
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.f();
        ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.5(this));
        return;
        if (this.jdField_a_of_type_Qhp.a())
        {
          this.jdField_a_of_type_Qhp.a();
          this.jdField_f_of_type_Boolean = true;
        }
        if (this.jdField_a_of_type_Pyo == null) {
          this.jdField_a_of_type_Pyo = new pyo(this);
        }
        paramView = ogy.a().a(a());
      } while (paramView == null);
      paramView = paramView.clone();
    } while (paramView == null);
    if (TextUtils.isEmpty(paramView.mChannelName)) {
      paramView.mChannelName = a();
    }
    this.jdField_a_of_type_Pyo.a(paramView, a(paramView), new nmb(this));
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Int != 0) {
      i();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != 0) {
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity
 * JD-Core Version:    0.7.0.1
 */