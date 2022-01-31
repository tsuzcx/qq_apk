package com.tencent.biz.pubaccount.readinjoy.activity;

import ajya;
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
import axva;
import baxy;
import bbbm;
import bbdv;
import bbfj;
import bcql;
import bfos;
import bfpc;
import bhvy;
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
import naj;
import nol;
import nxi;
import nxj;
import nxk;
import nxl;
import omr;
import omt;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import osg;
import osj;
import osm;
import oyc;
import qao;
import qbz;
import qca;
import qci;
import qdq;
import qds;
import qji;
import qkl;
import qkr;
import qoi;
import qto;
import qtr;
import qtu;
import qtv;
import qty;
import qva;
import qvf;
import qvg;
import qvk;
import qza;
import qzb;
import ral;
import ram;
import rbq;
import rbx;
import rez;
import shu;
import xlr;

public class ReadInJoyVideoSubChannelActivity
  extends FragmentActivity
  implements View.OnClickListener, bfos, qto, qtu, qvf, qvg, rbq, rbx
{
  public int a;
  protected long a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected baxy a;
  private bfpc jdField_a_of_type_Bfpc;
  public ReadInJoyXListView a;
  private String jdField_a_of_type_JavaLangString;
  public Map<Integer, Boolean> a;
  public omt a;
  protected osm a;
  private qkl jdField_a_of_type_Qkl;
  private qkr jdField_a_of_type_Qkr;
  private qtr jdField_a_of_type_Qtr;
  private qva jdField_a_of_type_Qva;
  private ram jdField_a_of_type_Ram;
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
  private Map<Integer, Map<Long, qao>> jdField_c_of_type_JavaUtilMap = new HashMap();
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
    this.jdField_a_of_type_Osm = new nxl(this);
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
    localIntent.putExtra("detail_url", qkl.a(paramChannelInfo, 0));
    localIntent.putExtra("title", "「" + paramChannelInfo.mChannelName + ajya.a(2131713045));
    localIntent.putExtra("desc", paramChannelInfo.mFollowNum + ajya.a(2131713103));
    localIntent.putExtra("image_url_remote", paramChannelInfo.mHeaderPicUrl);
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("struct_share_key_content_action", "web");
    paramChannelInfo = axva.a(localIntent.getExtras());
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
  
  private Map<Long, qao> a(Integer paramInteger)
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
    if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bfpc = bfpc.a(this);
    this.jdField_a_of_type_Bfpc.a(ajya.a(2131712833), 3);
    this.jdField_a_of_type_Bfpc.d(ajya.a(2131712751));
    this.jdField_a_of_type_Bfpc.show();
    this.jdField_a_of_type_Bfpc.a(new nxk(this, paramChannelInfo));
  }
  
  private void a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doFollowUnFollow(): isFollow =" + paramBoolean);
    }
    paramChannelInfo.mIsFollowed = paramBoolean;
    d(paramChannelInfo.mIsFollowed);
    osg.a().a(paramChannelInfo);
    osg.a().a(paramBoolean, 56, paramChannelInfo.mChannelID);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.8(this, paramChannelInfo, paramBoolean));
  }
  
  private void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      View localView = LayoutInflater.from(a()).inflate(2131560094, paramListView, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131367470));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367467));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367461));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367468));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367460));
      this.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramListView.addHeaderView(localView);
    }
  }
  
  private void a(String paramString)
  {
    findViewById(2131372594).setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131370728)).inflate();
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374768));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374767));
    }
    this.g.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Omt.jdField_a_of_type_Long = System.currentTimeMillis();
    bhvy.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Omt.jdField_a_of_type_Long, (QQAppInterface)onh.a());
    Object localObject2 = null;
    if (this.jdField_a_of_type_Ram != null) {
      this.jdField_a_of_type_Ram.a(paramBoolean);
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
    osg.a().a(this.jdField_b_of_type_Int, (List)localObject1, i, true, false, this.jdField_d_of_type_Int, null, -1L, null, b(), 0L, 0L, null, paramInt, false, null, 0);
    this.jdField_d_of_type_Int += 1;
    shu.a(paramInt, this.jdField_b_of_type_Int, this, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        if (!paramBoolean2) {
          break label31;
        }
        qoi.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 300);
      }
    }
    label31:
    while (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    if (paramBoolean2)
    {
      qoi.a(this.jdField_b_of_type_AndroidWidgetTextView, 4, 300);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Qtr != null) && (this.jdField_a_of_type_Qtr.b()) && (this.jdField_a_of_type_Qva != null) && (!this.jdField_a_of_type_Qva.a()))
    {
      this.jdField_a_of_type_Qva.d(paramInt);
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
    if (this.jdField_a_of_type_Ram.getCount() == 0)
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
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramChannelInfo.mFollowNum + ajya.a(2131712805));
      break label103;
      label202:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void b(Map<Long, qao> paramMap, boolean paramBoolean)
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
          qao localqao = (qao)paramMap.next();
          if (localqao.jdField_a_of_type_Boolean) {
            continue;
          }
          localqao.jdField_a_of_type_Boolean = true;
          if (localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
            continue;
          }
          nol.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localqao.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqao.jdField_b_of_type_Int), onh.a(localqao.jdField_a_of_type_Long, localqao.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localqao.jdField_d_of_type_Int), false);
          nol.a("0X80066FC", "", "", Long.toString(localqao.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqao.jdField_b_of_type_Int), onh.a(localqao.jdField_a_of_type_Long, localqao.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localqao.jdField_d_of_type_Int));
          if (ram.c(localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            int i = 0;
            while (i < localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
            {
              nol.a(null, localqao.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((qds)localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(i)).jdField_a_of_type_Int + "", Integer.toString(localqao.jdField_b_of_type_Int), onh.a(localqao.jdField_a_of_type_Long, localqao.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localqao.jdField_d_of_type_Int, localqao.jdField_e_of_type_Int, bbfj.h(a()), localqao.jdField_a_of_type_JavaLangString, localqao.jdField_c_of_type_JavaLangString, localqao.jdField_e_of_type_JavaLangString, onh.e(localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localqao.jdField_f_of_type_Int, localqao.g, localqao.h, localqao.jdField_f_of_type_Boolean, localqao.j, localqao.i, localqao.m), false);
              i += 1;
            }
          }
          Object localObject1 = new qzb(onh.a(localqao.jdField_a_of_type_Long, localqao.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localqao.jdField_d_of_type_Int, localqao.jdField_e_of_type_Int, bbfj.h(a()), localqao.jdField_a_of_type_JavaLangString, localqao.jdField_c_of_type_JavaLangString, localqao.jdField_e_of_type_JavaLangString, onh.e(localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localqao.jdField_f_of_type_Int, localqao.g, localqao.h, localqao.jdField_f_of_type_Boolean, localqao.j, localqao.i, localqao.m)).a(localqao.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).P(c()).b(localqao.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localqao.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a();
          nol.a(null, "CliOper", "", localqao.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqao.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqao.jdField_b_of_type_Int), (String)localObject1, false);
          nol.a("0X8007626", localqao.jdField_d_of_type_JavaLangString, Long.toString(localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqao.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqao.jdField_b_of_type_Int), onh.a(localqao.jdField_a_of_type_Long, localqao.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localqao.jdField_d_of_type_Int, localqao.jdField_e_of_type_Int, bbfj.h(a()), localqao.jdField_a_of_type_JavaLangString, localqao.jdField_c_of_type_JavaLangString, localqao.jdField_e_of_type_JavaLangString, onh.e(localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localqao.jdField_f_of_type_Int, localqao.g, localqao.h, localqao.jdField_f_of_type_Boolean, localqao.j, localqao.i, localqao.m));
          localObject1 = new ReportInfo();
          ((ReportInfo)localObject1).mUin = onh.a();
          ((ReportInfo)localObject1).mSource = 0;
          ((ReportInfo)localObject1).mSourceArticleId = localqao.jdField_a_of_type_JavaLangLong.longValue();
          ((ReportInfo)localObject1).mChannelId = this.jdField_b_of_type_Int;
          ((ReportInfo)localObject1).mAlgorithmId = ((int)localqao.jdField_a_of_type_Long);
          ((ReportInfo)localObject1).mStrategyId = localqao.jdField_b_of_type_Int;
          ((ReportInfo)localObject1).mOperation = 7;
          ((ReportInfo)localObject1).mServerContext = localqao.jdField_a_of_type_ArrayOfByte;
          ((ReportInfo)localObject1).mReadTimeLength = -1;
          ((ReportInfo)localObject1).mInnerId = localqao.jdField_e_of_type_JavaLangString;
          if (localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
            ((ReportInfo)localObject1).mColumnID = localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
          }
          Object localObject2;
          if (localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null)
          {
            localObject2 = new qbz();
            ((qbz)localObject2).jdField_a_of_type_Long = localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
            if (localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
              ((qbz)localObject2).jdField_b_of_type_Long = localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
            }
            ((qbz)localObject2).jdField_a_of_type_Int = localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
            ((qbz)localObject2).jdField_b_of_type_Int = localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
            Object localObject3 = localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
            if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
            {
              ((qbz)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                qci localqci = (qci)((Iterator)localObject3).next();
                if (localqci != null) {
                  ((qbz)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqci.jdField_a_of_type_Long));
                }
              }
            }
            ((ReportInfo)localObject1).mFeedsReportData = ((qbz)localObject2);
          }
          localArrayList.add(localObject1);
          if (localqao.jdField_c_of_type_Boolean) {}
          try
          {
            if (localqao.jdField_d_of_type_Boolean)
            {
              localObject2 = onh.a();
              ((JSONObject)localObject2).put("feeds_source", localqao.jdField_a_of_type_JavaLangString);
              ((JSONObject)localObject2).put("kandian_mode", onh.e());
              nol.a(null, "CliOper", "", "", "0X800744E", "0X800744E", 0, 0, onh.d(localqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", ((JSONObject)localObject2).toString(), false);
            }
            if (this.jdField_b_of_type_Int == 56)
            {
              ((ReportInfo)localObject1).mOpSource = 11;
              localObject2 = new qca();
              ((qca)localObject2).jdField_c_of_type_Int = 1;
              localObject2 = ((qca)localObject2).toString();
              ((ReportInfo)localObject1).mInnerId = localqao.jdField_e_of_type_JavaLangString;
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
    osg.a().a(localArrayList);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.h();
    if ((paramBoolean) && (paramInt > 0)) {}
    for (String str = String.format(getResources().getString(2131718338), new Object[] { Integer.valueOf(paramInt) });; str = getResources().getString(2131718337))
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
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Qtr != null) && (this.jdField_a_of_type_Ram != null) && (this.jdField_a_of_type_Ram.a() != null) && (this.jdField_a_of_type_Ram.a().size() > 0)) {
      onh.a(a(), (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_Qtr.a(), (BaseArticleInfo)this.jdField_a_of_type_Ram.a().get(0), paramBoolean);
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = a();
    this.jdField_c_of_type_Int = b();
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_a_of_type_Qtr = new qtr(this);
    this.jdField_a_of_type_Omt = new omt();
    this.jdField_a_of_type_Omt.jdField_a_of_type_Long = bhvy.a(a(), (QQAppInterface)onh.a());
    this.jdField_a_of_type_Qkr = qkr.a();
    this.jdField_a_of_type_Baxy = new baxy(this, this.app);
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
        this.jdField_e_of_type_AndroidWidgetTextView.setText(ajya.a(2131712968));
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-9211021);
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130842437);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
    }
    else {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(ajya.a(2131713052));
    this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130842419);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  private void e()
  {
    g();
    h();
    f();
    ChannelInfo localChannelInfo = osg.a().a(a());
    if (localChannelInfo != null) {
      b(localChannelInfo, false);
    }
    this.jdField_a_of_type_Qva = new qva((FrameLayout)findViewById(2131379077), (ReadInJoyBaseListView)findViewById(2131369318), this);
    this.jdField_a_of_type_Qva.a(this);
    this.jdField_a_of_type_Qtr.a(this.jdField_a_of_type_Qva);
    this.jdField_a_of_type_Qva.a(this);
    this.jdField_a_of_type_Ram.f();
    this.jdField_a_of_type_Ram.a(c());
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131372594);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377450));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377385));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377436));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377426));
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131369318));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_Ram = new ral(this, getLayoutInflater(), a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Baxy, oyc.a(null));
    this.jdField_a_of_type_Ram.b(b());
    this.jdField_a_of_type_Ram.a(this.jdField_a_of_type_Qtr, this.jdField_a_of_type_Qkr);
    this.jdField_a_of_type_Ram.e();
    this.jdField_a_of_type_Ram.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Ram);
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
    if ((this.jdField_a_of_type_Qtr != null) && (this.jdField_a_of_type_Qtr.a() != null)) {
      this.jdField_a_of_type_Qtr.b(11);
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
      if ((!bbbm.b()) && (!bbbm.d())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!bbbm.b()) && (!bbbm.d()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!bbbm.d())
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
      int j = this.jdField_a_of_type_Ram.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = this.jdField_a_of_type_Ram.a(j, l);
          if ((localObject != null) && (!onh.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Ram.a(j, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (xlr.a((String)localObject)) {
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
    this.jdField_a_of_type_Ram.a(osg.a().a(Integer.valueOf(this.jdField_b_of_type_Int), paramList));
    this.jdField_a_of_type_Ram.notifyDataSetChanged();
  }
  
  public void a(Map<Long, qao> paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    omr.a();
    bhvy.a((QQAppInterface)onh.a(), System.currentTimeMillis(), this.jdField_b_of_type_Int);
    getIntent().putExtra("from_search", false);
  }
  
  public void a(Set<Long> paramSet, Map<Long, qao> paramMap)
  {
    if (this.jdField_a_of_type_Ram != null) {
      this.jdField_a_of_type_Ram.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Omt.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Omt.d = bhvy.a((QQAppInterface)onh.a(), this.jdField_b_of_type_Int);
    osg.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
    osg.a().b(56, 3, a());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(true));
  }
  
  public void a(qji paramqji1, qji paramqji2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + paramqji1 + "  nextVideoPlayParam:" + paramqji2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    ram localram;
    if ((paramqji1 != null) && ((paramqji1 instanceof qtv)) && (paramqji2 != null) && ((paramqji2 instanceof qtv)))
    {
      paramqji1 = ((qtv)paramqji1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      paramqji2 = ((qtv)paramqji2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramqji1 != null) && (paramqji2 != null))
      {
        localram = this.jdField_a_of_type_Ram;
        if (paramBoolean) {
          break label135;
        }
      }
    }
    label135:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localram.a(paramqji1, paramqji2, paramBoolean);
      return;
    }
  }
  
  public void a(qtv paramqtv, int paramInt1, int paramInt2) {}
  
  public void a(qtv paramqtv1, qtv paramqtv2)
  {
    this.jdField_a_of_type_Ram.a(paramqtv1, paramqtv2);
    b(false);
  }
  
  public void a(qtv paramqtv, qty paramqty, int paramInt1, int paramInt2, Object paramObject) {}
  
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
      osg.a().a(this.jdField_b_of_type_Int, b(), paramInt, 0, 1);
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
      bcql localbcql = new bcql(this);
      localbcql.d(2000);
      if (i != 0)
      {
        localbcql.a(bcql.a(2));
        localbcql.c(2131692325);
        localbcql.b(getApplicationContext().getResources().getDimensionPixelSize(2131298865) - (int)bbdv.a(getApplicationContext(), 5.0F));
      }
      else
      {
        localbcql.a(bcql.a(1));
        localbcql.c(2131692326);
        localbcql.b(getApplicationContext().getResources().getDimensionPixelSize(2131298865) - (int)bbdv.a(getApplicationContext(), 5.0F));
        continue;
        if (paramInt1 == 9091) {
          this.jdField_a_of_type_Ram.a(0, paramIntent);
        } else if ((paramInt1 == 21) && (paramInt2 == -1)) {
          ForwardUtils.a((QQAppInterface)onh.a(), this, getApplicationContext(), paramIntent, null);
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    qvk.a().a(this);
    osj.a().a(this.jdField_a_of_type_Osm);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setBackgroundDrawable(null);
    setContentView(2131560093);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377452));
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
    osj.a().b(this.jdField_a_of_type_Osm);
    qvk.a().b(this);
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    if (this.jdField_a_of_type_Qtr != null) {
      this.jdField_a_of_type_Qtr.d();
    }
    if (this.jdField_a_of_type_Ram != null)
    {
      this.jdField_a_of_type_Ram.d();
      this.jdField_a_of_type_Ram.a();
    }
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    rez.a(this).b();
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
    this.jdField_a_of_type_Qtr.e();
    rez.a(this).a();
    if (this.jdField_a_of_type_Ram != null) {
      this.jdField_a_of_type_Ram.k();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Qtr.f();
    rez.a(this).a(b(), a());
    if (this.jdField_a_of_type_Ram != null) {
      this.jdField_a_of_type_Ram.j();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_Ram.notifyDataSetChanged();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new nxi(this));
    }
  }
  
  public void doOnStop()
  {
    qvk.a().a(false, "videoSubChannel onStop");
    super.doOnStop();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Qtr.a() != null) {
      this.jdField_a_of_type_Qtr.a().g();
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_Ram.l();
    b(true);
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Qtr;
    if ((localObject != null) && (((qtr)localObject).a() != null))
    {
      localObject = ((qtr)localObject).a();
      if (((qva)localObject).a())
      {
        ((qva)localObject).g();
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
            osg.a().b(56, 3, a());
            return;
            if (!naj.a(this))
            {
              bcql.a(this, ajya.a(2131712779), 0).a();
              return;
            }
            this.jdField_d_of_type_Boolean = true;
            paramView = osg.a().a(a());
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
        if (this.jdField_a_of_type_Qtr.b())
        {
          this.jdField_a_of_type_Qtr.a();
          this.jdField_f_of_type_Boolean = true;
        }
        if (this.jdField_a_of_type_Qkl == null) {
          this.jdField_a_of_type_Qkl = new qkl(this);
        }
        paramView = osg.a().a(a());
      } while (paramView == null);
      paramView = paramView.clone();
    } while (paramView == null);
    if (TextUtils.isEmpty(paramView.mChannelName)) {
      paramView.mChannelName = a();
    }
    this.jdField_a_of_type_Qkl.a(paramView, a(paramView), new nxj(this));
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