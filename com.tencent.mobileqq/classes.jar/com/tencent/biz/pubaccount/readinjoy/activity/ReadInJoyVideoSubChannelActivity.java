package com.tencent.biz.pubaccount.readinjoy.activity;

import alud;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azvd;
import bdbb;
import bdep;
import bdgz;
import bdin;
import bhtv;
import bhuf;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
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
import com.tencent.mobileqq.widget.QQToast;
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
import ndd;
import nrt;
import oao;
import oap;
import oaq;
import oar;
import oas;
import orc;
import ore;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import owy;
import oxb;
import oxe;
import pdh;
import qfw;
import qkk;
import qlv;
import qlw;
import qme;
import qnm;
import qno;
import qyp;
import qzs;
import qzy;
import rdm;
import rjd;
import rjg;
import rjj;
import rjk;
import rjn;
import rkp;
import rkw;
import rkx;
import rlb;
import rom;
import ron;
import rqi;
import rqj;
import rrn;
import rru;
import ruv;
import szp;
import zez;

public class ReadInJoyVideoSubChannelActivity
  extends FragmentActivity
  implements View.OnClickListener, bhtv, rjd, rjj, rkw, rkx, rrn, rru
{
  public int a;
  protected long a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bdbb a;
  private bhuf jdField_a_of_type_Bhuf;
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  public ReadInJoyXListView a;
  private String jdField_a_of_type_JavaLangString;
  public Map<Integer, Boolean> a;
  public ore a;
  protected oxe a;
  private qfw jdField_a_of_type_Qfw;
  private qzs jdField_a_of_type_Qzs;
  private qzy jdField_a_of_type_Qzy;
  private rjg jdField_a_of_type_Rjg;
  private rkp jdField_a_of_type_Rkp;
  private rqj jdField_a_of_type_Rqj;
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
  private Map<Integer, Map<Long, qkk>> jdField_c_of_type_JavaUtilMap = new HashMap();
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
    this.jdField_a_of_type_Oxe = new oap(this);
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
    localIntent.putExtra("struct_share_key_source_icon", "http://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
    localIntent.putExtra("struct_share_key_source_a_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_i_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("app_name", "QQ看点");
    localIntent.putExtra("detail_url", qzs.a(paramChannelInfo, 0));
    localIntent.putExtra("title", "「" + paramChannelInfo.mChannelName + alud.a(2131713429));
    localIntent.putExtra("desc", paramChannelInfo.mFollowNum + alud.a(2131713487));
    localIntent.putExtra("image_url_remote", paramChannelInfo.mHeaderPicUrl);
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("struct_share_key_content_action", "web");
    paramChannelInfo = azvd.a(localIntent.getExtras());
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
  
  private Map<Long, qkk> a(Integer paramInteger)
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
    if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bhuf = bhuf.a(this);
    this.jdField_a_of_type_Bhuf.a(alud.a(2131713217), 3);
    this.jdField_a_of_type_Bhuf.d(alud.a(2131713135));
    this.jdField_a_of_type_Bhuf.show();
    this.jdField_a_of_type_Bhuf.a(new oas(this, paramChannelInfo));
  }
  
  private void a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doFollowUnFollow(): isFollow =" + paramBoolean);
    }
    paramChannelInfo.mIsFollowed = paramBoolean;
    d(paramChannelInfo.mIsFollowed);
    owy.a().a(paramChannelInfo);
    owy.a().a(paramBoolean, 56, paramChannelInfo.mChannelID);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.9(this, paramChannelInfo, paramBoolean));
  }
  
  private void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      View localView = LayoutInflater.from(a()).inflate(2131560195, paramListView, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131367608));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367605));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367599));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367606));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367598));
      this.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramListView.addHeaderView(localView);
    }
  }
  
  private void a(String paramString)
  {
    findViewById(2131372977).setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131371058)).inflate();
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375282));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375281));
    }
    this.g.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Ore.jdField_a_of_type_Long = System.currentTimeMillis();
    bkbq.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Ore.jdField_a_of_type_Long, (QQAppInterface)ors.a());
    Object localObject2 = null;
    if (this.jdField_a_of_type_Rqj != null) {
      this.jdField_a_of_type_Rqj.a(paramBoolean);
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
    owy.a().a(this.jdField_b_of_type_Int, (List)localObject1, i, true, false, this.jdField_d_of_type_Int, null, -1L, null, b(), 0L, 0L, null, paramInt, false, null, 0);
    this.jdField_d_of_type_Int += 1;
    szp.a(paramInt, this.jdField_b_of_type_Int, this, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        if (!paramBoolean2) {
          break label31;
        }
        rdm.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 300);
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
      rdm.a(this.jdField_b_of_type_AndroidWidgetTextView, 4, 300);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Rjg != null) && (this.jdField_a_of_type_Rjg.b()) && (this.jdField_a_of_type_Rkp != null) && (!this.jdField_a_of_type_Rkp.a()))
    {
      this.jdField_a_of_type_Rkp.c(paramInt);
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
    if (this.jdField_a_of_type_Rqj.getCount() == 0)
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
          break label206;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      k();
      d(paramChannelInfo.mIsFollowed);
      if (this.jdField_e_of_type_Boolean) {
        break;
      }
      this.jdField_e_of_type_Boolean = true;
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.11(this, paramChannelInfo));
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramChannelInfo.mFollowNum + alud.a(2131713189));
      break label103;
      label206:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void b(Map<Long, qkk> paramMap, boolean paramBoolean)
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
          qkk localqkk = (qkk)paramMap.next();
          if (localqkk.jdField_a_of_type_Boolean) {
            continue;
          }
          localqkk.jdField_a_of_type_Boolean = true;
          if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
            continue;
          }
          nrt.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localqkk.jdField_d_of_type_Int), false);
          nrt.a("0X80066FC", "", "", Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localqkk.jdField_d_of_type_Int));
          if (rqj.d(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            int i = 0;
            while (i < localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
            {
              nrt.a(null, localqkk.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((qno)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(i)).jdField_a_of_type_Int + "", Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localqkk.jdField_d_of_type_Int, localqkk.jdField_e_of_type_Int, bdin.h(a()), localqkk.jdField_a_of_type_JavaLangString, localqkk.jdField_c_of_type_JavaLangString, localqkk.jdField_e_of_type_JavaLangString, ors.f(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localqkk.jdField_f_of_type_Int, localqkk.g, localqkk.h, localqkk.jdField_f_of_type_Boolean, localqkk.j, localqkk.i, localqkk.m), false);
              i += 1;
            }
          }
          Object localObject1 = new ron(ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localqkk.jdField_d_of_type_Int, localqkk.jdField_e_of_type_Int, bdin.h(a()), localqkk.jdField_a_of_type_JavaLangString, localqkk.jdField_c_of_type_JavaLangString, localqkk.jdField_e_of_type_JavaLangString, ors.f(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localqkk.jdField_f_of_type_Int, localqkk.g, localqkk.h, localqkk.jdField_f_of_type_Boolean, localqkk.j, localqkk.i, localqkk.m)).a(localqkk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).O(c()).b(localqkk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localqkk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a();
          nrt.a(null, "CliOper", "", localqkk.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), (String)localObject1, false);
          nrt.a("0X8007626", localqkk.jdField_d_of_type_JavaLangString, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localqkk.jdField_d_of_type_Int, localqkk.jdField_e_of_type_Int, bdin.h(a()), localqkk.jdField_a_of_type_JavaLangString, localqkk.jdField_c_of_type_JavaLangString, localqkk.jdField_e_of_type_JavaLangString, ors.f(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localqkk.jdField_f_of_type_Int, localqkk.g, localqkk.h, localqkk.jdField_f_of_type_Boolean, localqkk.j, localqkk.i, localqkk.m));
          localObject1 = new ReportInfo();
          ((ReportInfo)localObject1).mUin = ors.a();
          ((ReportInfo)localObject1).mSource = 0;
          ((ReportInfo)localObject1).mSourceArticleId = localqkk.jdField_a_of_type_JavaLangLong.longValue();
          ((ReportInfo)localObject1).mChannelId = this.jdField_b_of_type_Int;
          ((ReportInfo)localObject1).mAlgorithmId = ((int)localqkk.jdField_a_of_type_Long);
          ((ReportInfo)localObject1).mStrategyId = localqkk.jdField_b_of_type_Int;
          ((ReportInfo)localObject1).mOperation = 7;
          ((ReportInfo)localObject1).mServerContext = localqkk.jdField_a_of_type_ArrayOfByte;
          ((ReportInfo)localObject1).mReadTimeLength = -1;
          ((ReportInfo)localObject1).mInnerId = localqkk.jdField_e_of_type_JavaLangString;
          if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
            ((ReportInfo)localObject1).mColumnID = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
          }
          Object localObject2;
          if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null)
          {
            localObject2 = new qlv();
            ((qlv)localObject2).jdField_a_of_type_Long = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
            if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null) {
              ((qlv)localObject2).jdField_b_of_type_Long = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long;
            }
            ((qlv)localObject2).jdField_a_of_type_Int = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
            ((qlv)localObject2).jdField_b_of_type_Int = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
            Object localObject3 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
            if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
            {
              ((qlv)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                qme localqme = (qme)((Iterator)localObject3).next();
                if (localqme != null) {
                  ((qlv)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqme.jdField_a_of_type_Long));
                }
              }
            }
            ((ReportInfo)localObject1).mFeedsReportData = ((qlv)localObject2);
          }
          localArrayList.add(localObject1);
          if (localqkk.jdField_c_of_type_Boolean) {}
          try
          {
            if (localqkk.jdField_d_of_type_Boolean)
            {
              localObject2 = ors.a();
              ((JSONObject)localObject2).put("feeds_source", localqkk.jdField_a_of_type_JavaLangString);
              ((JSONObject)localObject2).put("kandian_mode", ors.e());
              nrt.a(null, "CliOper", "", "", "0X800744E", "0X800744E", 0, 0, ors.e(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", ((JSONObject)localObject2).toString(), false);
            }
            if (this.jdField_b_of_type_Int == 56)
            {
              ((ReportInfo)localObject1).mOpSource = 11;
              localObject2 = new qlw();
              ((qlw)localObject2).jdField_c_of_type_Int = 1;
              localObject2 = ((qlw)localObject2).toString();
              ((ReportInfo)localObject1).mInnerId = localqkk.jdField_e_of_type_JavaLangString;
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
    owy.a().a(localArrayList);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.h();
    if ((paramBoolean) && (paramInt > 0)) {}
    for (String str = String.format(getResources().getString(2131718733), new Object[] { Integer.valueOf(paramInt) });; str = getResources().getString(2131718732))
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
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Rjg != null) && (this.jdField_a_of_type_Rqj != null) && (this.jdField_a_of_type_Rqj.a() != null) && (this.jdField_a_of_type_Rqj.a().size() > 0)) {
      ors.a(a(), (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_Rjg.a(), (BaseArticleInfo)this.jdField_a_of_type_Rqj.a().get(0), paramBoolean);
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = a();
    this.jdField_c_of_type_Int = b();
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_a_of_type_Rjg = new rjg(this);
    this.jdField_a_of_type_Ore = new ore();
    this.jdField_a_of_type_Ore.jdField_a_of_type_Long = bkbq.a(a(), (QQAppInterface)ors.a());
    this.jdField_a_of_type_Qzy = qzy.a();
    this.jdField_a_of_type_Bdbb = new bdbb(this, this.app);
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
        this.jdField_e_of_type_AndroidWidgetTextView.setText(alud.a(2131713352));
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-9211021);
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130842621);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
    }
    else {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(alud.a(2131713436));
    this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130842603);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  private void e()
  {
    g();
    h();
    f();
    ChannelInfo localChannelInfo = owy.a().a(a());
    if (localChannelInfo != null) {
      b(localChannelInfo, false);
    }
    this.jdField_a_of_type_Rkp = new rkp((FrameLayout)findViewById(2131379813), (ReadInJoyBaseListView)findViewById(2131369570), this);
    this.jdField_a_of_type_Rkp.a(this);
    this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Rkp);
    this.jdField_a_of_type_Rkp.a(this);
    this.jdField_a_of_type_Rqj.f();
    this.jdField_a_of_type_Rqj.a(c());
    this.jdField_a_of_type_Qfw = new qfw(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView);
    this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Qfw);
    RIJRedPacketManager.a().a(new oao(this));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131372977);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131378041));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377974));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378027));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378017));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = ((RIJRedPacketProgressView)findViewById(2131377190));
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a());
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.setOnClickListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131369570));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_Rqj = new rqi(this, getLayoutInflater(), a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Bdbb, pdh.a(null));
    this.jdField_a_of_type_Rqj.b(b());
    this.jdField_a_of_type_Rqj.a(this.jdField_a_of_type_Rjg, this.jdField_a_of_type_Qzy);
    this.jdField_a_of_type_Rqj.e();
    this.jdField_a_of_type_Rqj.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Rqj);
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
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.getLayoutParams();
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        localLayoutParams.addRule(0, 2131378017);
        localLayoutParams.addRule(11, 0);
      }
    }
    else
    {
      return;
    }
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(0, 0);
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_Rjg != null) && (this.jdField_a_of_type_Rjg.a() != null)) {
      this.jdField_a_of_type_Rjg.b(11);
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
      if ((!bdep.b()) && (!bdep.d())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!bdep.b()) && (!bdep.d()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!bdep.d())
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
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.3(this));
  }
  
  public void a(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int j = this.jdField_a_of_type_Rqj.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = this.jdField_a_of_type_Rqj.a(j, l);
          if ((localObject != null) && (!ors.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Rqj.a(j, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (zez.a((String)localObject)) {
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
    this.jdField_a_of_type_Rqj.a(owy.a().a(Integer.valueOf(this.jdField_b_of_type_Int), paramList));
    this.jdField_a_of_type_Rqj.notifyDataSetChanged();
  }
  
  public void a(Map<Long, qkk> paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    orc.a();
    bkbq.a((QQAppInterface)ors.a(), System.currentTimeMillis(), this.jdField_b_of_type_Int);
    getIntent().putExtra("from_search", false);
  }
  
  public void a(Set<Long> paramSet, Map<Long, qkk> paramMap)
  {
    if (this.jdField_a_of_type_Rqj != null) {
      this.jdField_a_of_type_Rqj.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Ore.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Ore.d = bkbq.a((QQAppInterface)ors.a(), this.jdField_b_of_type_Int);
    owy.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
    owy.a().b(56, 3, a());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(true));
  }
  
  public void a(qyp paramqyp1, qyp paramqyp2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + paramqyp1 + "  nextVideoPlayParam:" + paramqyp2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    rqj localrqj;
    if ((paramqyp1 != null) && ((paramqyp1 instanceof rjk)) && (paramqyp2 != null) && ((paramqyp2 instanceof rjk)))
    {
      paramqyp1 = ((rjk)paramqyp1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      paramqyp2 = ((rjk)paramqyp2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramqyp1 != null) && (paramqyp2 != null))
      {
        localrqj = this.jdField_a_of_type_Rqj;
        if (paramBoolean) {
          break label135;
        }
      }
    }
    label135:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localrqj.a(paramqyp1, paramqyp2, paramBoolean);
      return;
    }
  }
  
  public void a(rjk paramrjk, int paramInt1, int paramInt2) {}
  
  public void a(rjk paramrjk1, rjk paramrjk2)
  {
    this.jdField_a_of_type_Rqj.a(paramrjk1, paramrjk2);
    b(false);
  }
  
  public void a(rjk paramrjk, rjn paramrjn, int paramInt1, int paramInt2, Object paramObject) {}
  
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
      owy.a().a(this.jdField_b_of_type_Int, b(), paramInt, 0, 1);
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.4(this));
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
    m();
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
      QQToast localQQToast = new QQToast(this);
      localQQToast.d(2000);
      if (i != 0)
      {
        localQQToast.a(QQToast.a(2));
        localQQToast.c(2131692402);
        localQQToast.b(getApplicationContext().getResources().getDimensionPixelSize(2131298914) - (int)bdgz.a(getApplicationContext(), 5.0F));
      }
      else
      {
        localQQToast.a(QQToast.a(1));
        localQQToast.c(2131692403);
        localQQToast.b(getApplicationContext().getResources().getDimensionPixelSize(2131298914) - (int)bdgz.a(getApplicationContext(), 5.0F));
        continue;
        if (paramInt1 == 9091) {
          this.jdField_a_of_type_Rqj.a(0, paramIntent);
        } else if ((paramInt1 == 21) && (paramInt2 == -1)) {
          ForwardUtils.a((QQAppInterface)ors.a(), this, getApplicationContext(), paramIntent, null);
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    rlb.a().a(this);
    oxb.a().a(this.jdField_a_of_type_Oxe);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setBackgroundDrawable(null);
    setContentView(2131560194);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378043));
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
    oxb.a().b(this.jdField_a_of_type_Oxe);
    rlb.a().b(this);
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    if (this.jdField_a_of_type_Rjg != null) {
      this.jdField_a_of_type_Rjg.d();
    }
    if (this.jdField_a_of_type_Rqj != null)
    {
      this.jdField_a_of_type_Rqj.d();
      this.jdField_a_of_type_Rqj.a();
    }
    if (this.jdField_a_of_type_Qfw != null) {
      this.jdField_a_of_type_Qfw.c();
    }
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    ruv.a(this).b();
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
    this.jdField_a_of_type_Rjg.e();
    ruv.a(this).a();
    if (this.jdField_a_of_type_Rqj != null) {
      this.jdField_a_of_type_Rqj.k();
    }
    if (this.jdField_a_of_type_Qfw != null) {
      this.jdField_a_of_type_Qfw.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Rjg.f();
    ruv.a(this).a(b(), a());
    if (this.jdField_a_of_type_Rqj != null) {
      this.jdField_a_of_type_Rqj.j();
    }
    if (this.jdField_a_of_type_Qfw != null) {
      this.jdField_a_of_type_Qfw.a();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_Rqj.notifyDataSetChanged();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new oaq(this));
    }
  }
  
  public void doOnStop()
  {
    rlb.a().a(false, "videoSubChannel onStop");
    super.doOnStop();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Rjg.a() != null) {
      this.jdField_a_of_type_Rjg.a().i();
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_Rqj.l();
    b(true);
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Rjg;
    if ((localObject != null) && (((rjg)localObject).a() != null))
    {
      localObject = ((rjg)localObject).a();
      if (((rkp)localObject).a())
      {
        ((rkp)localObject).i();
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
    default: 
    case 2131377974: 
    case 2131371057: 
    case 2131367599: 
    case 2131378027: 
    case 2131378041: 
    case 2131378017: 
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
              owy.a().b(56, 3, a());
              return;
              if (!ndd.a(this))
              {
                QQToast.a(this, alud.a(2131713163), 0).a();
                return;
              }
              this.jdField_d_of_type_Boolean = true;
              paramView = owy.a().a(a());
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
          ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.5(this));
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.f();
          ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.6(this));
          return;
          if (this.jdField_a_of_type_Rjg.b())
          {
            this.jdField_a_of_type_Rjg.a();
            this.jdField_f_of_type_Boolean = true;
          }
          if (this.jdField_a_of_type_Qzs == null) {
            this.jdField_a_of_type_Qzs = new qzs(this);
          }
          paramView = owy.a().a(a());
        } while (paramView == null);
        paramView = paramView.clone();
      } while (paramView == null);
      if (TextUtils.isEmpty(paramView.mChannelName)) {
        paramView.mChannelName = a();
      }
      this.jdField_a_of_type_Qzs.a(paramView, a(paramView), new oar(this));
      return;
    }
    RIJRedPacketManager.a().a(this, 2, 1, 1);
    if (this.jdField_a_of_type_Rjg.a() != null) {}
    for (paramView = this.jdField_a_of_type_Rjg.a().a();; paramView = null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.b(4, this.jdField_a_of_type_Qfw.a(), paramView);
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity
 * JD-Core Version:    0.7.0.1
 */