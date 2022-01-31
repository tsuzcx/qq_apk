package com.tencent.biz.pubaccount.readinjoy.ad.fragment;

import abtq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bavw;
import bkvi;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import mqq.os.MqqHandler;
import nmc;
import nxz;
import nya;
import nyd;
import nye;
import obb;
import omr;
import org.json.JSONException;
import org.json.JSONObject;
import qoi;
import qro;
import shq;

public class ReadinjoyAdPKFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadinjoyAdPKFragment.1(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private TextView d;
  
  private void a()
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)getArguments().getParcelable("param_ad_info");
    if (localAdvertisementInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyAdPKFragment", 2, "PARAM_AD_INFO: null");
      }
      getActivity().finish();
      return;
    }
    localAdvertisementInfo.resetClickPos();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo;
  }
  
  private void a(int paramInt)
  {
    Object localObject = new nxz();
    ((nxz)localObject).b = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = paramInt;
    if ((!shq.a(shq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true, (nxz)localObject), getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.h != 32))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isClickFromPkFragment = true;
      shq.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true, false, (nxz)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isClickFromPkFragment = false;
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("comp_stat_src", "12");
      nmc.a(new nyd().a(getActivity()).a(nmc.a).b(nmc.aj).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e((JSONObject)localObject).d(paramInt).a(true).a());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void a(Activity paramActivity, Class<? extends ReadinjoyAdPKFragment> paramClass, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyAdPKFragment", 2, "error");
      }
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtras(paramBundle);
    abtq.a(paramActivity, localIntent, PublicFragmentActivity.class, paramClass);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, String paramString, boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
    localURLDrawableOptions.mRequestHeight = paramKandianUrlImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    try
    {
      paramString = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
      if (paramBoolean) {
        paramString.setDecodeHandler(bavw.a);
      }
      paramKandianUrlImageView.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramKandianUrlImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadinjoyAdPKFragment", 2, "loadImage ERROR e = " + paramKandianUrlImageView.getMessage());
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362051));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362016));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362018));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378383));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367865));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367879));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378238));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378331));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131369910));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369910).setOnClickListener(this);
    URL localURL = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.getVideoCoverUrlWithSmartCut(false);
    Object localObject;
    if (localURL != null) {
      localObject = localURL.getFile();
    }
    for (;;)
    {
      if (localURL != null)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (String)localObject, false);
        omr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL, this.jdField_a_of_type_AndroidContentContext, true);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName);
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo, true);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.a.size() >= 2))
        {
          localObject = (nya)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.a.get(0);
          if (localObject != null)
          {
            if (!TextUtils.isEmpty(((nya)localObject).c)) {
              this.jdField_c_of_type_AndroidWidgetTextView.setText(((nya)localObject).c);
            }
            if (!TextUtils.isEmpty(((nya)localObject).d)) {
              a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ((nya)localObject).d, false);
            }
          }
          localObject = (nya)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.a.get(1);
          if (localObject != null)
          {
            if (!TextUtils.isEmpty(((nya)localObject).c)) {
              this.d.setText(((nya)localObject).c);
            }
            if (!TextUtils.isEmpty(((nya)localObject).d)) {
              a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ((nya)localObject).d, false);
            }
          }
        }
        localObject = obb.a(1);
        if ((localObject != null) && ((localObject instanceof Bitmap))) {
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
        }
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("comp_stat_src", "12");
        nmc.a(new nyd().a(getActivity()).a(nmc.b).b(nmc.aj).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e((JSONObject)localObject).a(true).a());
        return;
        localObject = null;
        continue;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(4);
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
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131378238: 
      a(101);
      return;
    case 2131378331: 
      a(102);
      return;
    }
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)qro.a(2131559795, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    b();
    qoi.a(getActivity());
    getActivity().getWindow().setFlags(1024, 1024);
    bkvi.a(getActivity());
    if (bkvi.b()) {
      bkvi.c(getActivity());
    }
    if (bkvi.b())
    {
      int i = bkvi.b(getActivity());
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      paramLayoutInflater.topMargin += i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(paramLayoutInflater);
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
      paramLayoutInflater.topMargin = (i + paramLayoutInflater.topMargin);
      this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(paramLayoutInflater);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    obb.a(1);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    qoi.a(getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.fragment.ReadinjoyAdPKFragment
 * JD-Core Version:    0.7.0.1
 */