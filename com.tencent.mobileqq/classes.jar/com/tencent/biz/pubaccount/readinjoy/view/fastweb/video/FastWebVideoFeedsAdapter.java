package com.tencent.biz.pubaccount.readinjoy.view.fastweb.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout.CustomClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.troop.utils.NonMainAppListViewFaceLoader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mog;
import moh;
import moi;
import moj;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebVideoFeedsAdapter
  extends BaseAdapter
  implements View.OnClickListener, VideoFeedsGestureLayout.CustomClickListener
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new mog(this, Looper.getMainLooper());
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private VideoFeedsIPCClient jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private FastWebVideoFeedsAdapter.AdapterEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$AdapterEventListener;
  private FastWebVideoFeedsAdapter.BaseItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$BaseItemHolder;
  private FastWebVideoFeedsAdapter.VideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder;
  public FastWebVideoFeedsListView.ListViewEventListener a;
  private FastWebVideoFeedsListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView;
  private FastWebVideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NonMainAppListViewFaceLoader jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private Set jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private boolean d = true;
  private boolean e = true;
  private boolean f;
  
  FastWebVideoFeedsAdapter(Context paramContext, Activity paramActivity, FastWebVideoFeedsListView paramFastWebVideoFeedsListView, VideoFeedsIPCClient paramVideoFeedsIPCClient, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView$ListViewEventListener = new moh(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView = paramFastWebVideoFeedsListView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient = paramVideoFeedsIPCClient;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView$ListViewEventListener);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.b();
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492971));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = VideoAutoPlayController.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader = new NonMainAppListViewFaceLoader(paramContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView, 1);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader.a(24, 24);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Drawable a(int paramInt)
  {
    Bitmap localBitmap;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localBitmap);
    }
    for (;;)
    {
      return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
  }
  
  @TargetApi(11)
  private void a(int paramInt, FastWebVideoFeedsAdapter.BaseItemHolder paramBaseItemHolder, FastWebVideoInfo paramFastWebVideoInfo1, FastWebVideoInfo paramFastWebVideoInfo2)
  {
    if ((paramFastWebVideoInfo1 != null) && (!paramFastWebVideoInfo1.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity)) && (paramFastWebVideoInfo1.jdField_a_of_type_Int != 0))
    {
      paramBaseItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if ((paramFastWebVideoInfo1.jdField_a_of_type_Int == 1) || (paramFastWebVideoInfo1.jdField_a_of_type_Int == 6))
      {
        if (!TextUtils.isEmpty(paramFastWebVideoInfo1.j)) {
          paramBaseItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramFastWebVideoInfo1.j);
        }
        if (!TextUtils.isEmpty(paramFastWebVideoInfo1.i)) {
          paramBaseItemHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader.a(paramFastWebVideoInfo1.i, true));
        }
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(16777215);
        VideoFeedsHelper.a(paramBaseItemHolder.jdField_a_of_type_ComTencentImageURLImageView, 0);
        if ((!TextUtils.isEmpty(paramFastWebVideoInfo1.i)) && (!"16888".equals(paramFastWebVideoInfo1.i)) && (!paramFastWebVideoInfo1.jdField_c_of_type_Boolean) && (!paramFastWebVideoInfo1.jdField_a_of_type_Boolean) && (paramFastWebVideoInfo1.jdField_a_of_type_Int != 6)) {
          break label627;
        }
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        label175:
        if (!paramFastWebVideoInfo1.jdField_a_of_type_Boolean) {
          break label685;
        }
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a(2130839651));
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetButton.setText("查看详情");
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#00FFFFFF"));
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetButton.getBackground().mutate().setAlpha(0);
        paramBaseItemHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        label284:
        VideoFeedsHelper.a(paramBaseItemHolder.jdField_a_of_type_AndroidWidgetImageView, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.b(paramBaseItemHolder.jdField_a_of_type_AndroidWidgetButton.getId());
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramBaseItemHolder);
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.b(paramBaseItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
        paramBaseItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setTag(paramBaseItemHolder);
        paramBaseItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.b(paramBaseItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getId());
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramBaseItemHolder);
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder.jdField_a_of_type_Int != paramBaseItemHolder.jdField_a_of_type_Int))
      {
        paramBaseItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(0);
        paramBaseItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(1.0F);
      }
      return;
      label447:
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      if ((paramFastWebVideoInfo1.jdField_a_of_type_Int == 5) && (paramFastWebVideoInfo1.jdField_f_of_type_Int == 2))
      {
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramFastWebVideoInfo1.jdField_c_of_type_JavaLangString);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramBaseItemHolder.jdField_a_of_type_ComTencentImageURLImageView.getWidth();
        localURLDrawableOptions.mRequestHeight = paramBaseItemHolder.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramFastWebVideoInfo1.m)) {
            break label611;
          }
          paramFastWebVideoInfo2 = new URL("https://q.url.cn/s/jBJuV");
          paramFastWebVideoInfo2 = URLDrawable.getDrawable(paramFastWebVideoInfo2, localURLDrawableOptions);
          paramFastWebVideoInfo2.setDecodeHandler(URLDrawableDecodeHandler.a);
          paramBaseItemHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramFastWebVideoInfo2);
        }
        catch (MalformedURLException paramFastWebVideoInfo2) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsAdapter", 2, "configVideoItemUI() ERROR e = " + paramFastWebVideoInfo2.getMessage());
        break;
        if (TextUtils.isEmpty(paramFastWebVideoInfo1.k)) {
          break label447;
        }
        paramBaseItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramFastWebVideoInfo1.k);
        break label447;
        label611:
        paramFastWebVideoInfo2 = new URL(paramFastWebVideoInfo1.m);
      }
      label627:
      paramBaseItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText("关注");
      paramBaseItemHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00ffffff"));
      paramBaseItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(2130840871));
      paramBaseItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramBaseItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label175;
      label685:
      paramBaseItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramBaseItemHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label284;
      paramBaseItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void a(int paramInt, FastWebVideoFeedsAdapter.VideoItemHolder paramVideoItemHolder, FastWebVideoInfo paramFastWebVideoInfo)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      paramVideoItemHolder.o.setVisibility(8);
      paramVideoItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramVideoItemHolder.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoItemHolder.jdField_m_of_type_AndroidWidgetTextView.setText("加载更多");
    }
    for (;;)
    {
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(8);
      paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      int i = this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getHeight();
      paramInt = ((FastWebVideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity);
      paramFastWebVideoInfo = paramVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramFastWebVideoInfo.height = (i / 2 - paramInt / 2);
      paramFastWebVideoInfo.width = -1;
      paramVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramFastWebVideoInfo);
      paramVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new moi(this));
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        paramVideoItemHolder.o.setVisibility(8);
        paramVideoItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramVideoItemHolder.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
        paramVideoItemHolder.jdField_m_of_type_AndroidWidgetTextView.setText("加载失败");
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        paramVideoItemHolder.o.setVisibility(8);
        paramVideoItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramVideoItemHolder.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(int paramInt, FastWebVideoFeedsAdapter.VideoItemHolder paramVideoItemHolder, FastWebVideoInfo paramFastWebVideoInfo1, FastWebVideoInfo paramFastWebVideoInfo2)
  {
    label146:
    label328:
    label467:
    label612:
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((paramFastWebVideoInfo1.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity)) && (paramFastWebVideoInfo1.jdField_a_of_type_Int != 0))
    {
      paramVideoItemHolder.jdField_n_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if ((paramFastWebVideoInfo1.jdField_a_of_type_Int == 1) || (paramFastWebVideoInfo1.jdField_a_of_type_Int == 6))
      {
        if (!TextUtils.isEmpty(paramFastWebVideoInfo1.j)) {
          paramVideoItemHolder.jdField_k_of_type_AndroidWidgetTextView.setText(paramFastWebVideoInfo1.j);
        }
        if (!TextUtils.isEmpty(paramFastWebVideoInfo1.i)) {
          paramVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader.a(paramFastWebVideoInfo1.i, true));
        }
        if ((!TextUtils.isEmpty(paramFastWebVideoInfo1.i)) && (!"16888".equals(paramFastWebVideoInfo1.i)) && (!paramFastWebVideoInfo1.jdField_c_of_type_Boolean) && (paramFastWebVideoInfo1.jdField_a_of_type_Int != 6)) {
          break label1141;
        }
        paramVideoItemHolder.jdField_j_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramVideoItemHolder.jdField_m_of_type_AndroidWidgetLinearLayout.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_m_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        paramVideoItemHolder.jdField_j_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_j_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      }
    }
    else
    {
      paramVideoItemHolder.jdField_n_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (paramFastWebVideoInfo1.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity))
      {
        paramVideoItemHolder.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        paramVideoItemHolder.jdField_k_of_type_AndroidWidgetLinearLayout.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_k_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        paramVideoItemHolder.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        paramVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!paramFastWebVideoInfo1.a()) {
          break label1190;
        }
        paramVideoItemHolder.jdField_k_of_type_AndroidWidgetImageView.setImageDrawable(a(2130840851));
        paramVideoItemHolder.jdField_j_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492889));
        paramVideoItemHolder.jdField_i_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_i_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        paramVideoItemHolder.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramVideoItemHolder.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        paramVideoItemHolder.jdField_j_of_type_AndroidWidgetImageView.setImageDrawable(a(2130840873));
        paramVideoItemHolder.jdField_j_of_type_AndroidWidgetLinearLayout.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_j_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      }
      paramVideoItemHolder.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!paramFastWebVideoInfo1.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity)) {
        break label1241;
      }
      paramVideoItemHolder.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
      paramVideoItemHolder.d.setVisibility(0);
      label398:
      if ((paramInt != 0) || (!(this.jdField_a_of_type_AndroidAppActivity instanceof VideoFeedsPlayActivity)) || (!this.jdField_c_of_type_Boolean)) {
        break label1262;
      }
      paramVideoItemHolder.jdField_e_of_type_AndroidWidgetTextView.setText("");
      label429:
      if ((paramFastWebVideoInfo1.jdField_a_of_type_Int == 0) || (paramFastWebVideoInfo1.jdField_a_of_type_Int == 5)) {
        break label1276;
      }
      paramVideoItemHolder.jdField_i_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.a(paramFastWebVideoInfo1.h));
      paramVideoItemHolder.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoItemHolder.p.setTag(paramVideoItemHolder);
      paramVideoItemHolder.p.setOnClickListener(this);
      paramFastWebVideoInfo2 = paramVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramFastWebVideoInfo2.height = paramFastWebVideoInfo1.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity);
      paramFastWebVideoInfo2.width = -1;
      paramVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramFastWebVideoInfo2);
      if (!paramFastWebVideoInfo1.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity)) {
        break label1288;
      }
      paramVideoItemHolder.jdField_g_of_type_AndroidWidgetLinearLayout.setPadding(0, AIOUtils.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramVideoItemHolder.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramFastWebVideoInfo2 = (RelativeLayout.LayoutParams)paramVideoItemHolder.jdField_h_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramFastWebVideoInfo2.setMargins(0, 0, 0, AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramVideoItemHolder.jdField_h_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramFastWebVideoInfo2);
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(paramVideoItemHolder);
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
      paramVideoItemHolder.jdField_f_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      paramVideoItemHolder.jdField_f_of_type_AndroidWidgetImageView.setTag(paramVideoItemHolder);
      paramVideoItemHolder.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramFastWebVideoInfo2 = paramFastWebVideoInfo1.a();
      if (paramFastWebVideoInfo2 == null) {
        break label1353;
      }
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.getHeight();
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramFastWebVideoInfo2 = URLDrawable.getDrawable(paramFastWebVideoInfo2, localURLDrawableOptions);
      paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramFastWebVideoInfo2);
      label734:
      paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      VideoFeedsHelper.a(paramVideoItemHolder.jdField_f_of_type_AndroidWidgetTextView, 0L);
      VideoFeedsHelper.a(paramVideoItemHolder.jdField_g_of_type_AndroidWidgetTextView, paramFastWebVideoInfo1.a() * 1000);
      if ((this.jdField_a_of_type_Boolean) || (paramInt != 0)) {
        break label1364;
      }
      paramVideoItemHolder.jdField_h_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramVideoItemHolder.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramVideoItemHolder.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramVideoItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (!paramFastWebVideoInfo1.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity)) {
        paramVideoItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      label842:
      paramVideoItemHolder.jdField_h_of_type_AndroidWidgetLinearLayout.setTag(paramVideoItemHolder);
      paramVideoItemHolder.jdField_h_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      if (!FastWebVideoVolumeControl.a().a()) {
        break label1425;
      }
      paramVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable(b(2130840887));
    }
    for (;;)
    {
      paramVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView.setTag(paramVideoItemHolder);
      paramVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
      FastWebVideoVolumeControl.a().a(paramVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder.jdField_a_of_type_Int == paramInt - 1) && (paramVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.a() == 0)) {
        paramVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setAlpha(255);
      }
      if (paramVideoItemHolder.o != null) {
        paramVideoItemHolder.o.setVisibility(8);
      }
      return;
      if (!TextUtils.isEmpty(paramFastWebVideoInfo1.k)) {
        paramVideoItemHolder.jdField_k_of_type_AndroidWidgetTextView.setText(paramFastWebVideoInfo1.k);
      }
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView.getHeight();
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramFastWebVideoInfo1.m)) {
            break label1125;
          }
          paramFastWebVideoInfo2 = new URL("https://q.url.cn/s/jBJuV");
          paramFastWebVideoInfo2 = URLDrawable.getDrawable(paramFastWebVideoInfo2, localURLDrawableOptions);
          paramFastWebVideoInfo2.setDecodeHandler(URLDrawableDecodeHandler.a);
          paramVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramFastWebVideoInfo2);
        }
        catch (MalformedURLException paramFastWebVideoInfo2) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsAdapter", 2, "configVideoItemUI() ERROR e = " + paramFastWebVideoInfo2.getMessage());
        break;
        label1125:
        paramFastWebVideoInfo2 = new URL(paramFastWebVideoInfo1.m);
      }
      label1141:
      paramVideoItemHolder.jdField_l_of_type_AndroidWidgetTextView.setText("关注");
      paramVideoItemHolder.jdField_l_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
      paramVideoItemHolder.jdField_m_of_type_AndroidWidgetImageView.setImageDrawable(a(2130840871));
      paramVideoItemHolder.jdField_j_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label146;
      label1190:
      paramVideoItemHolder.jdField_i_of_type_AndroidWidgetImageView.setImageDrawable(a(2130840879));
      paramVideoItemHolder.jdField_i_of_type_AndroidWidgetLinearLayout.setTag(paramVideoItemHolder);
      paramVideoItemHolder.jdField_i_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      paramVideoItemHolder.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramVideoItemHolder.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label328;
      label1241:
      paramVideoItemHolder.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(8);
      paramVideoItemHolder.d.setVisibility(8);
      break label398;
      label1262:
      paramVideoItemHolder.jdField_e_of_type_AndroidWidgetTextView.setText(paramFastWebVideoInfo1.jdField_c_of_type_JavaLangString);
      break label429;
      label1276:
      paramVideoItemHolder.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      break label467;
      label1288:
      paramVideoItemHolder.jdField_g_of_type_AndroidWidgetLinearLayout.setPadding(0, AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramVideoItemHolder.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramFastWebVideoInfo2 = (RelativeLayout.LayoutParams)paramVideoItemHolder.jdField_h_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramFastWebVideoInfo2.setMargins(0, 0, 0, 0);
      paramVideoItemHolder.jdField_h_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramFastWebVideoInfo2);
      break label612;
      label1353:
      paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      break label734;
      label1364:
      paramVideoItemHolder.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramVideoItemHolder.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramVideoItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramVideoItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (paramFastWebVideoInfo1.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity)) {
        break label842;
      }
      paramVideoItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      break label842;
      label1425:
      paramVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable(b(2130840888));
    }
  }
  
  private void a(View paramView, FastWebVideoInfo paramFastWebVideoInfo)
  {
    if ((paramView.getTag() instanceof FastWebVideoFeedsAdapter.ImageItemHolder))
    {
      paramView = (FastWebVideoFeedsAdapter.ImageItemHolder)paramView.getTag();
      if (paramView == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$BaseItemHolder) {
        break label93;
      }
      if ((paramView == null) || (paramView.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$BaseItemHolder.jdField_a_of_type_Int + 1) || (paramView.jdField_a_of_type_Int == getCount())) {
        break label65;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.a();
    }
    label65:
    label93:
    while (this.f)
    {
      do
      {
        return;
      } while ((paramView == null) || (paramView.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$BaseItemHolder.jdField_a_of_type_Int - 1));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.b();
      return;
    }
    a(paramFastWebVideoInfo);
  }
  
  private void a(FastWebVideoFeedsAdapter.ImageItemHolder paramImageItemHolder, FastWebVideoInfo paramFastWebVideoInfo)
  {
    Object localObject = paramImageItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = paramFastWebVideoInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity);
    ((ViewGroup.LayoutParams)localObject).width = -1;
    paramImageItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = paramFastWebVideoInfo.a();
    if (localObject != null)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramImageItemHolder.jdField_b_of_type_ComTencentImageURLImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramImageItemHolder.jdField_b_of_type_ComTencentImageURLImageView.getHeight();
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramImageItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((paramFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (!TextUtils.isEmpty(paramFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l)))
      {
        if (paramFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l.length() >= 3) {
          break label250;
        }
        paramImageItemHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a(2130840871));
      }
    }
    for (;;)
    {
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetButton.getBackground().mutate().setAlpha(0);
      paramImageItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l);
      paramImageItemHolder.jdField_b_of_type_AndroidWidgetButton.setTag(paramImageItemHolder);
      paramImageItemHolder.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramImageItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setTag(paramImageItemHolder);
      paramImageItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      return;
      paramImageItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      break;
      label250:
      if (paramFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l.length() < 5) {
        paramImageItemHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a(2130839651));
      } else {
        paramImageItemHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a(2130839652));
      }
    }
  }
  
  private void a(FastWebVideoFeedsAdapter.VideoItemHolder paramVideoItemHolder)
  {
    int i = 0;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, null);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder = paramVideoItemHolder;
    if (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null)
    {
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = new ReadinjoyVideoReportData();
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Int = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Int;
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_JavaLangString = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_JavaLangString;
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c = 2;
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.g = paramVideoItemHolder.jdField_a_of_type_Int;
    }
    if ((paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Boolean)) {
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData = new ReadinjoyAdVideoReportData();
    }
    Bundle localBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_IS_VIDEO_PLAY_NEED_ALERT_IN_XG", null);
    if (localBundle != null) {}
    for (boolean bool = localBundle.getBoolean("VALUE_VIDEO_NEED_ALERT", false);; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.a(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam);
        return;
      }
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l < 1000L) {
        i = 1000;
      }
      if ((paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)) {
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.n = l;
      }
      if ((paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData != null)) {
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, i);
      return;
    }
  }
  
  private void a(FastWebVideoFeedsAdapter.VideoItemHolder paramVideoItemHolder, FastWebVideoInfo paramFastWebVideoInfo)
  {
    FastWebVideoFeedsPlayManager.VideoPlayParam localVideoPlayParam2 = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam;
    FastWebVideoFeedsPlayManager.VideoPlayParam localVideoPlayParam1 = localVideoPlayParam2;
    if (localVideoPlayParam2 == null) {
      localVideoPlayParam1 = new FastWebVideoFeedsPlayManager.VideoPlayParam();
    }
    localVideoPlayParam1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo = paramFastWebVideoInfo;
    localVideoPlayParam1.jdField_a_of_type_ComTencentImageURLImageView = paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView;
    localVideoPlayParam1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
    localVideoPlayParam1.jdField_a_of_type_AndroidWidgetImageView = paramVideoItemHolder.jdField_f_of_type_AndroidWidgetImageView;
    localVideoPlayParam1.jdField_a_of_type_AndroidWidgetTextView = paramVideoItemHolder.jdField_f_of_type_AndroidWidgetTextView;
    localVideoPlayParam1.jdField_a_of_type_AndroidWidgetSeekBar = paramVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar;
    localVideoPlayParam1.jdField_b_of_type_AndroidWidgetTextView = paramVideoItemHolder.jdField_g_of_type_AndroidWidgetTextView;
    localVideoPlayParam1.jdField_a_of_type_AndroidWidgetRelativeLayout = paramVideoItemHolder.jdField_f_of_type_AndroidWidgetRelativeLayout;
    localVideoPlayParam1.jdField_c_of_type_AndroidWidgetTextView = paramVideoItemHolder.jdField_h_of_type_AndroidWidgetTextView;
    localVideoPlayParam1.jdField_a_of_type_Int = paramVideoItemHolder.jdField_a_of_type_Int;
    localVideoPlayParam1.jdField_b_of_type_AndroidWidgetRelativeLayout = paramVideoItemHolder.jdField_k_of_type_AndroidWidgetRelativeLayout;
    localVideoPlayParam1.jdField_c_of_type_AndroidWidgetRelativeLayout = paramVideoItemHolder.jdField_g_of_type_AndroidWidgetRelativeLayout;
    localVideoPlayParam1.jdField_a_of_type_AndroidWidgetLinearLayout = paramVideoItemHolder.jdField_n_of_type_AndroidWidgetLinearLayout;
    localVideoPlayParam1.jdField_d_of_type_AndroidWidgetRelativeLayout = paramVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout;
    paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam = localVideoPlayParam1;
  }
  
  private void a(FastWebVideoInfo paramFastWebVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsAdapter", 2, "gotoAdMore");
    }
    if ((paramFastWebVideoInfo == null) || (TextUtils.isEmpty(paramFastWebVideoInfo.jdField_f_of_type_JavaLangString))) {
      return;
    }
    Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramFastWebVideoInfo.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    localObject = NativeAdUtils.a(paramFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramFastWebVideoInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity))
    {
      NativeAdUtils.a(null, this.jdField_a_of_type_AndroidContentContext, NativeAdUtils.jdField_a_of_type_Int, NativeAdUtils.n, (AdvertisementInfo)localObject, paramFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, 0L);
      return;
    }
    NativeAdUtils.a(null, this.jdField_a_of_type_AndroidContentContext, NativeAdUtils.jdField_a_of_type_Int, NativeAdUtils.m, (AdvertisementInfo)localObject, paramFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, 0L);
  }
  
  private Drawable b(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (Drawable)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt);
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localDrawable);
    return localDrawable;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, null);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.e();
  }
  
  public int a()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder != null) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder.jdField_a_of_type_Int;
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new moj(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    paramView = (FastWebVideoFeedsAdapter.VideoItemHolder)paramView.getTag();
    if (paramView != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$BaseItemHolder) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$BaseItemHolder != null)
      {
        if ((paramView == null) || (paramView.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$BaseItemHolder.jdField_a_of_type_Int + 1) || (paramView.jdField_a_of_type_Int == getCount())) {
          break label62;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.a();
      }
    }
    label62:
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramView == null) || (paramView.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$BaseItemHolder.jdField_a_of_type_Int - 1));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.b();
        return;
        if (paramView.jdField_g_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
          break;
        }
        paramView.jdField_h_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.jdField_b_of_type_AndroidViewView.setVisibility(8);
        VideoFeedsHelper.a(paramView.jdField_g_of_type_AndroidWidgetRelativeLayout, 0);
      } while (paramView.jdField_f_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8);
      VideoFeedsHelper.a(paramView.jdField_f_of_type_AndroidWidgetRelativeLayout, 0);
      return;
      VideoFeedsHelper.a(paramView.jdField_g_of_type_AndroidWidgetRelativeLayout, 8);
    } while ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.c()) || (paramView.jdField_f_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0));
    VideoFeedsHelper.a(paramView.jdField_f_of_type_AndroidWidgetRelativeLayout, 8);
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager = paramFastWebVideoFeedsPlayManager;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  boolean a(int paramInt, View paramView)
  {
    boolean bool = true;
    if (paramView == null) {
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (paramInt == 4)
          {
            if ((paramView.getTag() != null) && ((paramView.getTag() instanceof FastWebVideoFeedsAdapter.ImageItemHolder))) {}
            for (bool = true;; bool = false) {
              return bool;
            }
          }
          if (paramInt != 3) {
            break;
          }
        } while ((paramView.getTag() != null) && ((paramView.getTag() instanceof FastWebVideoFeedsAdapter.VideoItemHolder)) && (((FastWebVideoFeedsAdapter.VideoItemHolder)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) && (((FastWebVideoFeedsAdapter.VideoItemHolder)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo != null) && (((FastWebVideoFeedsAdapter.VideoItemHolder)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Boolean));
        return false;
        if (paramInt != 1) {
          break;
        }
      } while ((paramView.getTag() != null) && ((paramView.getTag() instanceof FastWebVideoFeedsAdapter.VideoItemHolder)));
      return false;
      if (paramInt != 2) {
        break;
      }
    } while ((paramView.getTag() != null) && ((paramView.getTag() instanceof FastWebVideoFeedsAdapter.VideoItemHolder)));
    return false;
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
  }
  
  public void b(View paramView) {}
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$BaseItemHolder instanceof FastWebVideoFeedsAdapter.ImageItemHolder)) && (NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext))) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 5000L);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$AdapterEventListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$AdapterEventListener = null;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      FastWebVideoInfo localFastWebVideoInfo = (FastWebVideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!localFastWebVideoInfo.jdField_a_of_type_Boolean) {
        return 1;
      }
      if (localFastWebVideoInfo.jdField_f_of_type_Int == 1) {
        return 3;
      }
      if (localFastWebVideoInfo.jdField_f_of_type_Int == 2) {
        return 4;
      }
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FastWebVideoInfo localFastWebVideoInfo = null;
    int i = getItemViewType(paramInt);
    if (!a(i, paramView)) {
      switch (i)
      {
      default: 
        paramViewGroup = null;
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)paramView.findViewById(2131365568));
        paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367185));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367187));
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367186));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367189));
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367188));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367190));
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367184));
        paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367182));
        paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367208));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367209));
        paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367204));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367205));
        paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367206));
        paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367207));
        paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367197));
        paramViewGroup.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)paramView.findViewById(2131367198));
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367202));
        paramViewGroup.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367201));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367203));
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367193));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131367212));
      }
    }
    for (;;)
    {
      label362:
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
      for (Object localObject = (FastWebVideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);; localObject = null)
      {
        if (paramInt != 0) {
          localFastWebVideoInfo = (FastWebVideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
        }
        a(paramInt, paramViewGroup, (FastWebVideoInfo)localObject, localFastWebVideoInfo);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder != paramViewGroup) {
          break label1246;
        }
        return paramView;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969620, paramViewGroup, false);
        paramViewGroup = new FastWebVideoFeedsAdapter.VideoItemHolder();
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)paramView.findViewById(2131366707));
        paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367144));
        paramViewGroup.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365636));
        paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367180));
        paramViewGroup.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367148));
        paramViewGroup.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131367158));
        paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367157));
        paramViewGroup.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367159));
        paramViewGroup.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367151));
        paramViewGroup.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367153));
        paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367139));
        paramViewGroup.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367179));
        paramViewGroup.jdField_h_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367152));
        paramViewGroup.jdField_g_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363380));
        paramViewGroup.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367155));
        paramViewGroup.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367181));
        paramViewGroup.jdField_h_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367156));
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)paramView.findViewById(2131367183));
        paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367150);
        paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131367149);
        paramViewGroup.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367154));
        paramViewGroup.jdField_k_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367143));
        paramViewGroup.p = ((LinearLayout)paramView.findViewById(2131367160));
        paramViewGroup.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367161));
        paramViewGroup.jdField_m_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367163));
        paramViewGroup.jdField_k_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367165));
        paramViewGroup.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367164));
        paramViewGroup.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367167));
        paramViewGroup.jdField_j_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367166));
        paramViewGroup.jdField_l_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367168));
        paramViewGroup.jdField_n_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367162));
        paramViewGroup.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)paramView.findViewById(2131367146));
        paramViewGroup.jdField_j_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367177));
        paramViewGroup.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367178));
        paramViewGroup.jdField_i_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367175));
        paramViewGroup.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367176));
        paramViewGroup.jdField_k_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367173));
        paramViewGroup.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367174));
        paramViewGroup.jdField_l_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367169));
        paramViewGroup.d = ((VideoFeedsGradientMaskView)paramView.findViewById(2131367147));
        paramViewGroup.jdField_i_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367170));
        paramViewGroup.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367171));
        paramViewGroup.jdField_j_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367172));
        paramViewGroup.o = ((LinearLayout)paramView.findViewById(2131365225));
        paramViewGroup.jdField_m_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367145));
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363452));
        paramView.setTag(paramViewGroup);
        break;
        paramView = new FastWebVideoFeedsAdapter.ImageItemHolder();
        localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969673, paramViewGroup, false);
        paramView.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131365636));
        paramView.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)((View)localObject).findViewById(2131367399));
        paramView.jdField_b_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131367152));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        break;
        if (i == 4)
        {
          paramViewGroup = (FastWebVideoFeedsAdapter.ImageItemHolder)paramView.getTag();
          break label362;
        }
        if ((i != 1) && (i != 3) && (i != 2)) {
          break label1341;
        }
        paramViewGroup = (FastWebVideoFeedsAdapter.VideoItemHolder)paramView.getTag();
        break label362;
      }
      switch (i)
      {
      default: 
        return paramView;
      case 1: 
      case 3: 
        a((FastWebVideoFeedsAdapter.VideoItemHolder)paramViewGroup, (FastWebVideoInfo)localObject);
        a(paramInt, (FastWebVideoFeedsAdapter.VideoItemHolder)paramViewGroup, (FastWebVideoInfo)localObject, localFastWebVideoInfo);
        return paramView;
      case 4: 
        label1246:
        ((FastWebVideoFeedsAdapter.ImageItemHolder)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo = ((FastWebVideoInfo)localObject);
        a((FastWebVideoFeedsAdapter.ImageItemHolder)paramViewGroup, (FastWebVideoInfo)localObject);
        return paramView;
      }
      a(paramInt, (FastWebVideoFeedsAdapter.VideoItemHolder)paramViewGroup, localFastWebVideoInfo);
      return paramView;
      label1341:
      paramViewGroup = null;
    }
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    FastWebVideoFeedsAdapter.BaseItemHolder localBaseItemHolder = (FastWebVideoFeedsAdapter.BaseItemHolder)paramView.getTag();
    FastWebVideoInfo localFastWebVideoInfo = null;
    if (((localBaseItemHolder instanceof FastWebVideoFeedsAdapter.VideoItemHolder)) || ((localBaseItemHolder instanceof FastWebVideoFeedsAdapter.FooterItemHolder))) {}
    label42:
    do
    {
      localFastWebVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo;
      break label42;
      if (localFastWebVideoInfo == null) {}
      do
      {
        do
        {
          do
          {
            JSONObject localJSONObject;
            do
            {
              return;
              if (!(localBaseItemHolder instanceof FastWebVideoFeedsAdapter.ImageItemHolder)) {
                break;
              }
              localFastWebVideoInfo = ((FastWebVideoFeedsAdapter.ImageItemHolder)localBaseItemHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo;
              break;
              if ((localFastWebVideoInfo.jdField_a_of_type_Int == 0) && (localFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
                localFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
              }
              localJSONObject = new JSONObject();
              switch (paramView.getId())
              {
              default: 
                return;
              }
            } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView == null);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.c();
            return;
            paramView = FastWebVideoVolumeControl.a();
            if (!FastWebVideoVolumeControl.a().b()) {}
            for (boolean bool = true;; bool = false)
            {
              paramView.a(bool, "user_click", 2);
              try
              {
                localJSONObject.put("channel_id", -1);
                return;
              }
              catch (JSONException paramView)
              {
                paramView.printStackTrace();
                return;
              }
            }
          } while ((localBaseItemHolder != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager == null));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.a();
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView == null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.c();
        return;
      } while (!localFastWebVideoInfo.jdField_a_of_type_Boolean);
      a(localFastWebVideoInfo);
      return;
    } while (!localFastWebVideoInfo.jdField_a_of_type_Boolean);
    a(paramView, localFastWebVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */