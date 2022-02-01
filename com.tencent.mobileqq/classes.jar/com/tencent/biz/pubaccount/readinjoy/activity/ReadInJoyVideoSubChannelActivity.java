package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import aars;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import bdof;
import bhdz;
import bkzi;
import bmhv;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
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
import olh;
import org.json.JSONException;
import org.json.JSONObject;
import ovd;
import ove;
import ovf;
import ovg;
import pjr;
import pjt;
import pkh;
import pnr;
import pnv;
import ppe;
import pqe;
import pqf;
import pqu;
import pqw;
import ptj;
import pvj;
import pvm;
import pvq;
import qda;
import rkf;
import rot;
import rqf;
import rqg;
import rqy;
import rsh;
import rsj;
import ses;
import sga;
import sge;
import six;
import spd;
import spg;
import spi;
import spk;
import spn;
import sqd;
import sqk;
import sql;
import sqp;
import sut;
import suu;
import szc;
import szd;
import szj;
import tbh;
import uvs;

public class ReadInJoyVideoSubChannelActivity
  extends FragmentActivity
  implements View.OnClickListener, AbsListView.OnScrollListener, pnv, spd, spi, sqk, sql, szj
{
  public int a;
  protected long a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkzi jdField_a_of_type_Bkzi;
  public ReadInJoyXListView a;
  protected FaceDecoder a;
  private String jdField_a_of_type_JavaLangString;
  public Map<Integer, Boolean> a;
  public pjt a;
  protected pvq a;
  private rkf jdField_a_of_type_Rkf;
  private sga jdField_a_of_type_Sga;
  private sge jdField_a_of_type_Sge;
  private spg jdField_a_of_type_Spg;
  private sqd jdField_a_of_type_Sqd;
  private szd jdField_a_of_type_Szd;
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
  private Map<Integer, Map<Long, rot>> jdField_c_of_type_JavaUtilMap = new HashMap();
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
    this.jdField_a_of_type_Pvq = new ovg(this, null);
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
    localIntent.putExtra("struct_share_key_source_icon", "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
    localIntent.putExtra("struct_share_key_source_a_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_i_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("app_name", "QQ看点");
    localIntent.putExtra("detail_url", sga.a(paramChannelInfo, 0));
    localIntent.putExtra("title", "「" + paramChannelInfo.mChannelName + anvx.a(2131712496));
    localIntent.putExtra("desc", paramChannelInfo.mFollowNum + anvx.a(2131712554));
    localIntent.putExtra("image_url_remote", paramChannelInfo.mHeaderPicUrl);
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("struct_share_key_content_action", "web");
    paramChannelInfo = bdof.a(localIntent.getExtras());
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
  
  private Map<Long, rot> a(Integer paramInteger)
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
    if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bkzi = bkzi.a(this);
    this.jdField_a_of_type_Bkzi.a(anvx.a(2131712284), 3);
    this.jdField_a_of_type_Bkzi.d(anvx.a(2131712202));
    this.jdField_a_of_type_Bkzi.show();
    this.jdField_a_of_type_Bkzi.a(new ovf(this, paramChannelInfo));
  }
  
  private void a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doFollowUnFollow(): isFollow =" + paramBoolean);
    }
    paramChannelInfo.mIsFollowed = paramBoolean;
    d(paramChannelInfo.mIsFollowed);
    pvj.a().a(paramChannelInfo);
    pvj.a().a(paramBoolean, 56, paramChannelInfo.mChannelID);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.8(this, paramChannelInfo, paramBoolean));
  }
  
  private void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      View localView = LayoutInflater.from(a()).inflate(2131560418, paramListView, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131368154));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368151));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368145));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368152));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368144));
      this.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramListView.addHeaderView(localView);
    }
  }
  
  private void a(String paramString)
  {
    findViewById(2131373860).setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131371883)).inflate();
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376163));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376162));
    }
    this.g.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Pjt.jdField_a_of_type_Long = System.currentTimeMillis();
    bmhv.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Pjt.jdField_a_of_type_Long, (QQAppInterface)pkh.a());
    Object localObject2 = null;
    if (this.jdField_a_of_type_Szd != null) {
      this.jdField_a_of_type_Szd.d(paramBoolean);
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
    pvj.a().a(this.jdField_b_of_type_Int, (List)localObject1, i, true, false, this.jdField_d_of_type_Int, null, -1L, null, b(), 0L, 0L, null, paramInt, false, null, 0);
    this.jdField_d_of_type_Int += 1;
    uvs.a(paramInt, this.jdField_b_of_type_Int, this, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        if (!paramBoolean2) {
          break label31;
        }
        six.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 300);
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
      six.a(this.jdField_b_of_type_AndroidWidgetTextView, 4, 300);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Spg != null) && (this.jdField_a_of_type_Spg.b()) && (this.jdField_a_of_type_Sqd != null) && (!this.jdField_a_of_type_Sqd.a()))
    {
      this.jdField_a_of_type_Sqd.c(paramInt);
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
    if (this.jdField_a_of_type_Szd.getCount() == 0)
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
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.9(this, paramChannelInfo));
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramChannelInfo.mFollowNum + anvx.a(2131712256));
      break label103;
      label202:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void b(Map<Long, rot> paramMap, boolean paramBoolean)
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
          rot localrot = (rot)paramMap.next();
          if (localrot.jdField_a_of_type_Boolean) {
            continue;
          }
          localrot.jdField_a_of_type_Boolean = true;
          if (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
            continue;
          }
          olh.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrot.jdField_b_of_type_Int), pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localrot.jdField_d_of_type_Int), false);
          olh.a("0X80066FC", "", "", Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrot.jdField_b_of_type_Int), pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localrot.jdField_d_of_type_Int));
          if (ppe.i(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            int i = 0;
            while (i < localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
            {
              olh.a(null, localrot.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((rsj)localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(i)).jdField_a_of_type_Int + "", Integer.toString(localrot.jdField_b_of_type_Int), pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localrot.jdField_d_of_type_Int, localrot.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(a()), localrot.jdField_a_of_type_JavaLangString, localrot.jdField_c_of_type_JavaLangString, localrot.jdField_e_of_type_JavaLangString, pqw.d(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localrot.jdField_f_of_type_Int, localrot.g, localrot.h, localrot.jdField_f_of_type_Boolean, localrot.j, localrot.i, localrot.m), false);
              i += 1;
            }
          }
          Object localObject1 = new suu(pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localrot.jdField_d_of_type_Int, localrot.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(a()), localrot.jdField_a_of_type_JavaLangString, localrot.jdField_c_of_type_JavaLangString, localrot.jdField_e_of_type_JavaLangString, pqw.d(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localrot.jdField_f_of_type_Int, localrot.g, localrot.h, localrot.jdField_f_of_type_Boolean, localrot.j, localrot.i, localrot.m)).a(localrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).N(c()).b(localrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a();
          olh.a(null, "CliOper", "", localrot.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrot.jdField_b_of_type_Int), (String)localObject1, false);
          olh.a("0X8007626", localrot.jdField_d_of_type_JavaLangString, Long.toString(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrot.jdField_b_of_type_Int), pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localrot.jdField_d_of_type_Int, localrot.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(a()), localrot.jdField_a_of_type_JavaLangString, localrot.jdField_c_of_type_JavaLangString, localrot.jdField_e_of_type_JavaLangString, pqw.d(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localrot.jdField_f_of_type_Int, localrot.g, localrot.h, localrot.jdField_f_of_type_Boolean, localrot.j, localrot.i, localrot.m));
          localObject1 = new ReportInfo();
          ((ReportInfo)localObject1).mUin = pkh.a();
          ((ReportInfo)localObject1).mSource = 0;
          ((ReportInfo)localObject1).mSourceArticleId = localrot.jdField_a_of_type_JavaLangLong.longValue();
          ((ReportInfo)localObject1).mChannelId = this.jdField_b_of_type_Int;
          ((ReportInfo)localObject1).mAlgorithmId = ((int)localrot.jdField_a_of_type_Long);
          ((ReportInfo)localObject1).mStrategyId = localrot.jdField_b_of_type_Int;
          ((ReportInfo)localObject1).mOperation = 7;
          ((ReportInfo)localObject1).mServerContext = localrot.jdField_a_of_type_ArrayOfByte;
          ((ReportInfo)localObject1).mReadTimeLength = -1;
          ((ReportInfo)localObject1).mInnerId = localrot.jdField_e_of_type_JavaLangString;
          if (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
            ((ReportInfo)localObject1).mColumnID = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
          }
          Object localObject2;
          if (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null)
          {
            localObject2 = new rqf();
            ((rqf)localObject2).jdField_a_of_type_Long = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
            if (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
              ((rqf)localObject2).jdField_b_of_type_Long = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
            }
            ((rqf)localObject2).jdField_a_of_type_Int = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
            ((rqf)localObject2).jdField_b_of_type_Int = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
            Object localObject3 = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
            if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
            {
              ((rqf)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                rqy localrqy = (rqy)((Iterator)localObject3).next();
                if (localrqy != null) {
                  ((rqf)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrqy.jdField_a_of_type_Long));
                }
              }
            }
            ((ReportInfo)localObject1).mFeedsReportData = ((rqf)localObject2);
          }
          localArrayList.add(localObject1);
          if (localrot.jdField_c_of_type_Boolean) {}
          try
          {
            if (localrot.jdField_d_of_type_Boolean)
            {
              localObject2 = pqf.a();
              ((JSONObject)localObject2).put("feeds_source", localrot.jdField_a_of_type_JavaLangString);
              ((JSONObject)localObject2).put("kandian_mode", pqu.a());
              olh.a(null, "CliOper", "", "", "0X800744E", "0X800744E", 0, 0, pqw.c(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", ((JSONObject)localObject2).toString(), false);
            }
            if (this.jdField_b_of_type_Int == 56)
            {
              ((ReportInfo)localObject1).mOpSource = 11;
              localObject2 = new rqg();
              ((rqg)localObject2).jdField_c_of_type_Int = 1;
              localObject2 = ((rqg)localObject2).toString();
              ((ReportInfo)localObject1).mInnerId = localrot.jdField_e_of_type_JavaLangString;
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
    pvj.a().a(localArrayList);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.h();
    if ((paramBoolean) && (paramInt > 0)) {}
    for (String str = String.format(getResources().getString(2131717599), new Object[] { Integer.valueOf(paramInt) });; str = getResources().getString(2131717598))
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
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Spg != null) && (this.jdField_a_of_type_Szd != null) && (this.jdField_a_of_type_Szd.a() != null) && (this.jdField_a_of_type_Szd.a().size() > 0)) {
      pqe.a(a(), (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_Spg.a(), (BaseArticleInfo)this.jdField_a_of_type_Szd.a().get(0), paramBoolean);
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = a();
    this.jdField_c_of_type_Int = b();
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_a_of_type_Spg = new spg(this);
    this.jdField_a_of_type_Pjt = new pjt();
    this.jdField_a_of_type_Pjt.jdField_a_of_type_Long = bmhv.a(a(), (QQAppInterface)pkh.a());
    this.jdField_a_of_type_Sge = sge.a();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, this.app);
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
        this.jdField_e_of_type_AndroidWidgetTextView.setText(anvx.a(2131712419));
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-9211021);
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130843058);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
    }
    else {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(anvx.a(2131712503));
    this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130843040);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  private void e()
  {
    g();
    h();
    f();
    ChannelInfo localChannelInfo = pvj.a().a(a());
    if (localChannelInfo != null) {
      b(localChannelInfo, false);
    }
    this.jdField_a_of_type_Sqd = new sqd((FrameLayout)findViewById(2131381023), (ReadInJoyBaseListView)findViewById(2131370232), this);
    this.jdField_a_of_type_Sqd.a(this);
    this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_Sqd);
    this.jdField_a_of_type_Sqd.a(this);
    this.jdField_a_of_type_Szd.a(c());
    this.jdField_a_of_type_Rkf = new rkf();
    this.jdField_a_of_type_Rkf.a(this, this.jdField_a_of_type_Spg);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131373860);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131379110));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379039));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379095));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379084));
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131370232));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_Szd = new szc(this, getLayoutInflater(), a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, qda.a(null));
    this.jdField_a_of_type_Szd.b(b());
    this.jdField_a_of_type_Szd.a(this.jdField_a_of_type_Spg, this.jdField_a_of_type_Sge);
    this.jdField_a_of_type_Szd.c();
    pnr localpnr = new pnr().a(this);
    this.jdField_a_of_type_Szd.a(localpnr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Szd);
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
    if ((this.jdField_a_of_type_Spg != null) && (this.jdField_a_of_type_Spg.a() != null))
    {
      this.jdField_a_of_type_Spg.a(ReportConstants.VideoEndType.EXIT_SCENE);
      this.jdField_a_of_type_Spg.b(11);
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
      if ((!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.isFlyme())
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
      int j = this.jdField_a_of_type_Szd.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = this.jdField_a_of_type_Szd.a(j, l);
          if ((localObject != null) && (!pqw.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Szd.a(j, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (aars.a((String)localObject)) {
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
    this.jdField_a_of_type_Szd.a(pvj.a().a(Integer.valueOf(this.jdField_b_of_type_Int), paramList));
    this.jdField_a_of_type_Szd.notifyDataSetChanged();
  }
  
  public void a(Map<Long, rot> paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    pjr.a();
    bmhv.a((QQAppInterface)pkh.a(), System.currentTimeMillis(), this.jdField_b_of_type_Int);
    getIntent().putExtra("from_search", false);
  }
  
  public void a(Set<Long> paramSet, Map<Long, rot> paramMap)
  {
    if (this.jdField_a_of_type_Szd != null) {
      this.jdField_a_of_type_Szd.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Pjt.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Pjt.d = bmhv.a((QQAppInterface)pkh.a(), this.jdField_b_of_type_Int);
    pvj.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
    pvj.a().b(56, 3, a());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(true));
  }
  
  public void a(ses paramses1, ses paramses2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + paramses1 + "  nextVideoPlayParam:" + paramses2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    szd localszd;
    if ((paramses1 != null) && ((paramses1 instanceof spk)) && (paramses2 != null) && ((paramses2 instanceof spk)))
    {
      paramses1 = ((spk)paramses1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      paramses2 = ((spk)paramses2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramses1 != null) && (paramses2 != null))
      {
        localszd = this.jdField_a_of_type_Szd;
        if (paramBoolean) {
          break label134;
        }
      }
    }
    label134:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localszd.a(paramses1, paramses2, paramBoolean);
      return;
    }
  }
  
  public void a(spk paramspk, int paramInt1, int paramInt2) {}
  
  public void a(spk paramspk1, spk paramspk2)
  {
    b(false);
  }
  
  public void a(spk paramspk, spn paramspn, int paramInt1, int paramInt2, Object paramObject) {}
  
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
      pvj.a().a(this.jdField_b_of_type_Int, b(), paramInt, 0, 1);
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
        localQQToast.c(2131692127);
        localQQToast.b(getApplicationContext().getResources().getDimensionPixelSize(2131299080) - (int)bhdz.a(getApplicationContext(), 5.0F));
      }
      else
      {
        localQQToast.a(QQToast.a(1));
        localQQToast.c(2131692128);
        localQQToast.b(getApplicationContext().getResources().getDimensionPixelSize(2131299080) - (int)bhdz.a(getApplicationContext(), 5.0F));
        continue;
        if (paramInt1 == 9091) {
          this.jdField_a_of_type_Szd.a(0, paramIntent);
        } else if ((paramInt1 == 21) && (paramInt2 == -1)) {
          ForwardUtils.handleForwardData((QQAppInterface)pkh.a(), this, getApplicationContext(), paramIntent, null);
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ptj.a.a(getActivity());
    sqp.a().a(this);
    pvm.a().a(this.jdField_a_of_type_Pvq);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setBackgroundDrawable(null);
    setContentView(2131560417);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379112));
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
    pvm.a().b(this.jdField_a_of_type_Pvq);
    sqp.a().b(this);
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    if (this.jdField_a_of_type_Spg != null) {
      this.jdField_a_of_type_Spg.d();
    }
    if (this.jdField_a_of_type_Szd != null)
    {
      this.jdField_a_of_type_Szd.b();
      this.jdField_a_of_type_Szd.a();
    }
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    tbh.a(this).b();
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
    this.jdField_a_of_type_Spg.e();
    tbh.a(this).a();
    if (this.jdField_a_of_type_Szd != null) {
      this.jdField_a_of_type_Szd.e();
    }
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Spg.d(a());
    tbh.a(this).a(b(), a());
    if (this.jdField_a_of_type_Szd != null) {
      this.jdField_a_of_type_Szd.d();
    }
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.a();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_Szd.notifyDataSetChanged();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new ovd(this));
    }
  }
  
  public void doOnStop()
  {
    sqp.a().a(false, "videoSubChannel onStop");
    super.doOnStop();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Spg.a() != null) {
      this.jdField_a_of_type_Spg.a().j();
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Spg;
    if ((localObject != null) && (((spg)localObject).a() != null))
    {
      localObject = ((spg)localObject).a();
      if (((sqd)localObject).a())
      {
        ((sqd)localObject).j();
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      continue;
      f();
      a(true, 3);
      pvj.a().b(56, 3, a());
      continue;
      if (!HttpUtil.isConnect(this))
      {
        QQToast.a(this, anvx.a(2131712230), 0).a();
      }
      else
      {
        this.jdField_d_of_type_Boolean = true;
        ChannelInfo localChannelInfo = pvj.a().a(a());
        if (localChannelInfo != null) {
          if (localChannelInfo.mIsFollowed)
          {
            a(localChannelInfo);
          }
          else
          {
            a(localChannelInfo, true);
            continue;
            if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int == 0))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.f();
              ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.4(this));
              continue;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.f();
              ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.5(this));
              continue;
              if (this.jdField_a_of_type_Spg.b())
              {
                this.jdField_a_of_type_Spg.a();
                this.jdField_f_of_type_Boolean = true;
              }
              if (this.jdField_a_of_type_Sga == null) {
                this.jdField_a_of_type_Sga = new sga(this);
              }
              localChannelInfo = pvj.a().a(a());
              if (localChannelInfo != null)
              {
                localChannelInfo = localChannelInfo.clone();
                if (localChannelInfo != null)
                {
                  if (TextUtils.isEmpty(localChannelInfo.mChannelName)) {
                    localChannelInfo.mChannelName = a();
                  }
                  this.jdField_a_of_type_Sga.a(localChannelInfo, a(localChannelInfo), new ove(this));
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
  
  public void p()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity
 * JD-Core Version:    0.7.0.1
 */