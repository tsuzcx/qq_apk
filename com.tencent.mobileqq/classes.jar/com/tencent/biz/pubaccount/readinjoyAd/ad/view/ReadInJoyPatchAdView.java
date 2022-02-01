package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import pjr;
import rop;
import spk;
import uks;
import ukv;
import unw;
import unx;

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
  private spk jdField_a_of_type_Spk;
  public unx a;
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
    if (this.jdField_a_of_type_Spk == null) {
      return 0;
    }
    return this.jdField_a_of_type_Spk.a.patchStatus.a.get();
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_Spk == null) {
      return 0;
    }
    return this.jdField_a_of_type_Spk.a.patchStatus.b.get();
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_Unx != null)) {}
      try
      {
        if (ukv.a(new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo)) == paramInt)
        {
          this.jdField_a_of_type_Unx.a(this.jdField_a_of_type_Spk, this.jdField_a_of_type_Int);
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
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131560099, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)localView.findViewById(2131368539));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377671));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)localView.findViewById(2131362075));
    this.b = ((TextView)localView.findViewById(2131362238));
    this.c = ((TextView)localView.findViewById(2131362119));
    this.d = ((TextView)localView.findViewById(2131372474));
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler = new unw(this, Looper.getMainLooper());
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("0秒");
    }
    if (this.jdField_a_of_type_Unx != null)
    {
      a();
      this.jdField_a_of_type_Unx.b(this.jdField_a_of_type_Spk, this.jdField_a_of_type_Int, 0);
    }
  }
  
  public spk a()
  {
    return this.jdField_a_of_type_Spk;
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
    if (this.jdField_a_of_type_Unx != null)
    {
      this.jdField_a_of_type_Unx.a(this.jdField_a_of_type_Spk, this.jdField_a_of_type_Int, paramInt);
      this.jdField_a_of_type_Unx.b(this.jdField_a_of_type_Spk, this.jdField_a_of_type_Int, 1);
    }
  }
  
  public void a(spk paramspk, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
      this.jdField_a_of_type_Spk = paramspk;
      this.c.setText(paramAdvertisementInfo.mTitle);
      this.b.setText(paramAdvertisementInfo.mAdTxt);
      this.d.setText(uks.a(getContext(), paramAdvertisementInfo));
      try
      {
        paramspk = new URL(paramAdvertisementInfo.mAdImg);
        URL localURL = new URL(paramAdvertisementInfo.mAdCorporateLogo);
        pjr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramspk, getContext(), false);
        pjr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, localURL, getContext(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(AIOUtils.dp2px(2.0F, getContext().getResources()));
        try
        {
          paramInt = ukv.a(new JSONObject(paramAdvertisementInfo.mAdExtInfo));
          if (paramInt < 0)
          {
            a();
            return;
          }
        }
        catch (JSONException paramspk)
        {
          paramspk.printStackTrace();
          return;
        }
      }
      catch (Exception paramspk)
      {
        for (;;)
        {
          paramspk.printStackTrace();
        }
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    paramspk = new Message();
    paramspk.what = 1201;
    paramspk.obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramspk);
  }
  
  public boolean a()
  {
    return (a() == 1) || (b() == 1);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Unx != null) {
      this.jdField_a_of_type_Unx.c(this.jdField_a_of_type_Spk, this.jdField_a_of_type_Int);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Unx != null) {
      this.jdField_a_of_type_Unx.d(this.jdField_a_of_type_Spk, this.jdField_a_of_type_Int);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Unx != null) {
      this.jdField_a_of_type_Unx.b(this.jdField_a_of_type_Spk, this.jdField_a_of_type_Int, 0);
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
      if (this.jdField_a_of_type_Unx != null)
      {
        a();
        this.jdField_a_of_type_Unx.a(this.jdField_a_of_type_Spk, this.jdField_a_of_type_Int, i);
        this.jdField_a_of_type_Unx.b(this.jdField_a_of_type_Spk, this.jdField_a_of_type_Int, 1);
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
  
  public void setOnPatchAdListener(unx paramunx)
  {
    this.jdField_a_of_type_Unx = paramunx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView
 * JD-Core Version:    0.7.0.1
 */