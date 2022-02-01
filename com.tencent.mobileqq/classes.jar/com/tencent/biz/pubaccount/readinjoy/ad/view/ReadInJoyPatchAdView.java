package com.tencent.biz.pubaccount.readinjoy.ad.view;

import afur;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import oqj;
import oqm;
import org.json.JSONException;
import org.json.JSONObject;
import otj;
import otk;
import pgk;
import res;
import sey;

public class ReadInJoyPatchAdView
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdvertisementInfo a;
  private KanDianUrlRoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  public otk a;
  private sey jdField_a_of_type_Sey;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
    f();
    g();
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_Sey == null) {
      return 0;
    }
    return this.jdField_a_of_type_Sey.a.patchStatus.a.get();
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_Sey == null) {
      return 0;
    }
    return this.jdField_a_of_type_Sey.a.patchStatus.b.get();
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_Otk != null)) {}
      try
      {
        if (oqm.a(new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo)) == paramInt)
        {
          this.jdField_a_of_type_Otk.a(this.jdField_a_of_type_Sey, this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1203, 1000L);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + "秒");
        }
        if (paramInt >= 1)
        {
          Message localMessage = new Message();
          localMessage.what = 1201;
          localMessage.obj = Integer.valueOf(paramInt - 1);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
        }
        if (paramInt >= 1) {
          continue;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1202);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void e()
  {
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131560035, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)localView.findViewById(2131368284));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377476));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)localView.findViewById(2131362067));
    this.b = ((TextView)localView.findViewById(2131362224));
    this.c = ((TextView)localView.findViewById(2131362109));
    this.d = ((TextView)localView.findViewById(2131372202));
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler = new otj(this, Looper.getMainLooper());
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("0秒");
    }
    if (this.jdField_a_of_type_Otk != null)
    {
      a();
      this.jdField_a_of_type_Otk.b(this.jdField_a_of_type_Sey, this.jdField_a_of_type_Int, 0);
    }
  }
  
  public sey a()
  {
    return this.jdField_a_of_type_Sey;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1201);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1202);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Otk != null)
    {
      this.jdField_a_of_type_Otk.a(this.jdField_a_of_type_Sey, this.jdField_a_of_type_Int, paramInt);
      this.jdField_a_of_type_Otk.b(this.jdField_a_of_type_Sey, this.jdField_a_of_type_Int, 1);
    }
  }
  
  public void a(sey paramsey, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
      this.jdField_a_of_type_Sey = paramsey;
      this.c.setText(paramAdvertisementInfo.mTitle);
      this.b.setText(paramAdvertisementInfo.mAdTxt);
      this.d.setText(oqj.a(getContext(), paramAdvertisementInfo));
      try
      {
        paramsey = new URL(paramAdvertisementInfo.mAdImg);
        URL localURL = new URL(paramAdvertisementInfo.mAdCorporateLogo);
        pgk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramsey, getContext(), false);
        pgk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, localURL, getContext(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(afur.a(2.0F, getContext().getResources()));
        try
        {
          paramInt = oqm.a(new JSONObject(paramAdvertisementInfo.mAdExtInfo));
          if (paramInt < 0)
          {
            a();
            return;
          }
        }
        catch (JSONException paramsey)
        {
          paramsey.printStackTrace();
          return;
        }
      }
      catch (Exception paramsey)
      {
        for (;;)
        {
          paramsey.printStackTrace();
        }
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    paramsey = new Message();
    paramsey.what = 1201;
    paramsey.obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramsey);
  }
  
  public boolean a()
  {
    return (a() == 1) || (b() == 1);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Otk != null) {
      this.jdField_a_of_type_Otk.c(this.jdField_a_of_type_Sey, this.jdField_a_of_type_Int);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Otk != null) {
      this.jdField_a_of_type_Otk.d(this.jdField_a_of_type_Sey, this.jdField_a_of_type_Int);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Otk != null) {
      this.jdField_a_of_type_Otk.b(this.jdField_a_of_type_Sey, this.jdField_a_of_type_Int, 0);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = 5;
    int i = j;
    switch (paramView.getId())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Otk != null)
      {
        a();
        this.jdField_a_of_type_Otk.a(this.jdField_a_of_type_Sey, this.jdField_a_of_type_Int, i);
        this.jdField_a_of_type_Otk.b(this.jdField_a_of_type_Sey, this.jdField_a_of_type_Int, 1);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 8;
    }
  }
  
  public void setOnPatchAdListener(otk paramotk)
  {
    this.jdField_a_of_type_Otk = paramotk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView
 * JD-Core Version:    0.7.0.1
 */