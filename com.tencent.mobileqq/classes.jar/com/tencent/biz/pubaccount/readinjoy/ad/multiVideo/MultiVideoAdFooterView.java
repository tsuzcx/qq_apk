package com.tencent.biz.pubaccount.readinjoy.ad.multiVideo;

import actj;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bavw;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import nmc;
import nyd;
import nzp;
import nzq;
import oar;
import oav;
import qxc;
import qxr;
import shq;

public class MultiVideoAdFooterView
  extends FrameLayout
  implements View.OnClickListener
{
  public static final String a;
  private int jdField_a_of_type_Int = 1;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  public GdtHandler.Params a;
  private WeakReference<nzq> jdField_a_of_type_MqqUtilWeakReference;
  private qxr jdField_a_of_type_Qxr;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  
  static
  {
    jdField_a_of_type_JavaLangString = MultiVideoAdFooterView.class.getSimpleName();
  }
  
  public MultiVideoAdFooterView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Long = -2147483648L;
    c();
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = nmc.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      shq.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131559792, this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131364272));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365031));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)findViewById(2131362011));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361980));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362791));
    this.b = ((TextView)findViewById(2131377513));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  private void d()
  {
    int i = 1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.m == 1)
      {
        e();
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder().append("MultiAdFooter setStyle: mRevisionVideoType = ");
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null) {
            break label228;
          }
          label73:
          QLog.d((String)localObject1, 2, i);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.E)) {
          break label242;
        }
      }
    }
    label228:
    label242:
    for (Object localObject1 = "http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";; localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.E)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = actj.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = actj.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "ad_icon_footer";
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject1).setTag(bavw.b(((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight, actj.a(2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
      ((URLDrawable)localObject1).setDecodeHandler(bavw.i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject1);
      this.b.setText(oar.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, getResources()));
      return;
      f();
      break;
      e();
      break;
      i = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.m;
      break label73;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(oar.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, getResources()));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(oar.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, getResources()));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  private void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(0);
    this.b.setText(oar.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, getResources()));
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#FF12B7F6"));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      g();
      return;
    }
    h();
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (oar.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      i = nmc.at;
      if (this.jdField_a_of_type_Boolean) {
        i = nmc.aL;
      }
      nmc.a(new nyd().a(getContext()).d(i).a(nmc.P).b(nmc.N).a(paramAdvertisementInfo).a());
      return;
    }
    int i = 8;
    if (this.jdField_a_of_type_Boolean) {
      i = 38;
    }
    oar.a(paramAdvertisementInfo, i, this.jdField_a_of_type_Qxr.a());
    nzp.a(this.jdField_a_of_type_AndroidAppActivity, i, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager);
  }
  
  public void b()
  {
    d();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (nzq)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject == null) {}
    while (!this.jdField_a_of_type_Qxr.a((qxc)localObject)) {
      return;
    }
    localObject = oav.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
    this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = shq.a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject, null, 3, false, null);
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      this.jdField_a_of_type_Long = l;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131361980: 
        if ((this.jdField_a_of_type_Int != 1) || (!this.jdField_a_of_type_Boolean)) {
          break label354;
        }
        oar.a((AdvertisementInfo)localObject, 35, this.jdField_a_of_type_Qxr.a());
        shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject, null, 3, false, null);
        nzp.a(this.jdField_a_of_type_AndroidAppActivity, nmc.aH, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        return;
      }
    }
    e();
    nmc.a(new nyd().a(getContext()).a(nmc.jdField_a_of_type_Int).b(nmc.Y).a((AdvertisementInfo)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).d(nmc.aM).a());
    return;
    if (this.jdField_a_of_type_Boolean)
    {
      oar.a((AdvertisementInfo)localObject, 34, this.jdField_a_of_type_Qxr.a());
      shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject, null, 3, false, null);
      nzp.a(this.jdField_a_of_type_AndroidAppActivity, nmc.aI, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      return;
    }
    oar.a((AdvertisementInfo)localObject, 2, this.jdField_a_of_type_Qxr.a());
    shq.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject, null, 3, false, null);
    nzp.a(this.jdField_a_of_type_AndroidAppActivity, nmc.aq, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    return;
    label354:
    a((AdvertisementInfo)localObject);
  }
  
  public void setData(nzq paramnzq, VideoInfo paramVideoInfo, Activity paramActivity, qxr paramqxr)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramnzq);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qxr = paramqxr;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(this.jdField_a_of_type_AndroidAppActivity, false);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.multiVideo.MultiVideoAdFooterView
 * JD-Core Version:    0.7.0.1
 */