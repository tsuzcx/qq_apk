package com.tencent.biz.pubaccount.readinjoy.ad.soft_ad;

import aepi;
import alud;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.mobileqq.widget.QQToast;
import odo;
import odp;
import org.json.JSONObject;
import qyj;

public class ReadInJoyCommonSoftAdBar
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ProteusInnerData a;
  private ReadInjoyHeaderAdDownloadView.SimpleRoundProgress jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress;
  private odo jdField_a_of_type_Odo;
  public qyj a;
  private FrameLayout b;
  private FrameLayout c;
  
  public ReadInJoyCommonSoftAdBar(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoyCommonSoftAdBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ReadInJoyCommonSoftAdBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(paramString);
    localTextView.setTextSize(paramInt1);
    localTextView.setTextColor(paramInt2);
    localTextView.setMaxLines(paramInt3);
    if (paramInt3 == 1) {
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
    return localTextView;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131559942, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367819));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364780));
    this.b = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363503));
    this.c = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366265));
    b();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.b.removeAllViews();
  }
  
  private void c() {}
  
  private void d() {}
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.b == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.b.optString("adImg", "");
    Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.b.optString("goodsName", "");
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.b.optString("buttonTxt", "");
    odp.a(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, (String)localObject1, 8, 30, -1);
    localObject1 = new LinearLayout(getContext());
    Object localObject4 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject4).gravity = 16;
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((LinearLayout)localObject1).setOrientation(0);
    localObject3 = a((String)localObject3, 14, Color.parseColor("#000000"), 1);
    localObject4 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject4).gravity = 16;
    ((TextView)localObject3).setTag("soft_title");
    ((TextView)localObject3).setOnClickListener(this);
    ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject2 = a((String)localObject2, 11, Color.parseColor("#99000000"), 1);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).gravity = 16;
    ((LinearLayout.LayoutParams)localObject3).leftMargin = aepi.a(6.0F, getResources());
    ((TextView)localObject2).setTag("soft_desc");
    ((TextView)localObject2).setOnClickListener(this);
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
    odp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress);
    localObject1 = new FrameLayout.LayoutParams(aepi.a(25.0F, getResources()), aepi.a(25.0F, getResources()));
    ((FrameLayout.LayoutParams)localObject1).gravity = 21;
    ((FrameLayout.LayoutParams)localObject1).rightMargin = aepi.a(6.0F, getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setTag("soft_progress");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setOnClickListener(this);
    this.b.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    localObject1 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject1).gravity = 17;
    this.jdField_a_of_type_AndroidWidgetTextView.setText("立即下载");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00CAFC"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTag("soft_btn");
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
    this.b.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  private void f() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setPaused(true);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt2);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (this.jdField_a_of_type_Odo == null) {
      return;
    }
    if ((localObject instanceof String))
    {
      this.jdField_a_of_type_Odo.a(this.jdField_a_of_type_Int, (String)localObject, paramView.getId());
      return;
    }
    this.jdField_a_of_type_Odo.a(this.jdField_a_of_type_Int, null, paramView.getId());
  }
  
  public void setDownloadState(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    default: 
    case 3: 
    case 5: 
    case 1: 
      do
      {
        do
        {
          do
          {
            return;
            a(paramInt1, paramInt2);
            if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            }
          } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress == null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(0);
          return;
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          a(paramInt1, paramInt2);
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress == null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(8);
        return;
        if (this.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131713266));
        }
        a(paramInt1, paramInt2);
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(8);
      return;
    case 4: 
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(0);
      }
      a(paramInt1, paramInt2);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setVisibility(8);
    }
    QQToast.a(getContext(), alud.a(2131713372), 0).a();
  }
  
  public void setSoftAdClickListener(odo paramodo)
  {
    this.jdField_a_of_type_Odo = paramodo;
  }
  
  public void setUI(ProteusInnerData paramProteusInnerData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData = paramProteusInnerData;
    this.jdField_a_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData == null) {
      return;
    }
    b();
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      c();
      return;
    case 2: 
      d();
      return;
    case 3: 
      e();
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.soft_ad.ReadInJoyCommonSoftAdBar
 * JD-Core Version:    0.7.0.1
 */