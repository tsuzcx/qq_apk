package com.tencent.biz.pubaccount.readinjoy.ad.view;

import aekt;
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
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import oee;
import oeh;
import ogn;
import ogo;
import orc;
import org.json.JSONException;
import org.json.JSONObject;
import qkh;
import rjk;

public class ReadInJoyPatchAdView
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdvertisementInfo a;
  private KanDianUrlRoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  public ogo a;
  private rjk jdField_a_of_type_Rjk;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  
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
    if (this.jdField_a_of_type_Rjk == null) {
      return 0;
    }
    return this.jdField_a_of_type_Rjk.a.patchStatus.a.get();
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_Rjk == null) {
      return 0;
    }
    return this.jdField_a_of_type_Rjk.a.patchStatus.b.get();
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_Ogo != null)) {}
      try
      {
        if (oeh.a(new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo)) == paramInt)
        {
          this.jdField_a_of_type_Ogo.a(this.jdField_a_of_type_Rjk, this.jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1203, 1000L);
        }
        if (this.jdField_b_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt + "秒");
          this.jdField_a_of_type_Int = paramInt;
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
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131559889, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367948));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371608));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376616));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362010));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362154));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362050));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371610));
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ogn(this, Looper.getMainLooper());
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("0秒");
    }
    if (this.jdField_a_of_type_Ogo != null)
    {
      a();
      this.jdField_a_of_type_Ogo.b(this.jdField_a_of_type_Rjk, this.jdField_b_of_type_Int, 0);
    }
  }
  
  public rjk a()
  {
    return this.jdField_a_of_type_Rjk;
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
    if (this.jdField_a_of_type_Ogo != null)
    {
      this.jdField_a_of_type_Ogo.a(this.jdField_a_of_type_Rjk, this.jdField_b_of_type_Int, paramInt);
      this.jdField_a_of_type_Ogo.b(this.jdField_a_of_type_Rjk, this.jdField_b_of_type_Int, 1);
    }
  }
  
  public void a(rjk paramrjk, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
      this.jdField_a_of_type_Rjk = paramrjk;
      this.d.setText(paramAdvertisementInfo.mTitle);
      this.c.setText(paramAdvertisementInfo.mAdTxt);
      this.e.setText(oee.a(getContext(), paramAdvertisementInfo));
      try
      {
        paramrjk = new URL(paramAdvertisementInfo.mAdImg);
        URL localURL = new URL(paramAdvertisementInfo.mAdCorporateLogo);
        orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramrjk, getContext(), false);
        orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, localURL, getContext(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(aekt.a(2.0F, getContext().getResources()));
        try
        {
          paramInt = oeh.a(new JSONObject(paramAdvertisementInfo.mAdExtInfo));
          if (paramInt < 0)
          {
            a();
            return;
          }
        }
        catch (JSONException paramrjk)
        {
          paramrjk.printStackTrace();
          return;
        }
      }
      catch (Exception paramrjk)
      {
        for (;;)
        {
          paramrjk.printStackTrace();
        }
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    paramrjk = new Message();
    paramrjk.what = 1201;
    paramrjk.obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramrjk);
  }
  
  public boolean a()
  {
    return (a() == 1) || (b() == 1);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ogo != null) {
      this.jdField_a_of_type_Ogo.c(this.jdField_a_of_type_Rjk, this.jdField_b_of_type_Int);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ogo != null) {
      this.jdField_a_of_type_Ogo.d(this.jdField_a_of_type_Rjk, this.jdField_b_of_type_Int);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ogo != null) {
      this.jdField_a_of_type_Ogo.b(this.jdField_a_of_type_Rjk, this.jdField_b_of_type_Int, 0);
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
      if (this.jdField_a_of_type_Ogo != null)
      {
        a();
        this.jdField_a_of_type_Ogo.a(this.jdField_a_of_type_Rjk, this.jdField_b_of_type_Int, i);
        this.jdField_a_of_type_Ogo.b(this.jdField_a_of_type_Rjk, this.jdField_b_of_type_Int, 1);
      }
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 8;
    }
  }
  
  public void setOnPatchAdListener(ogo paramogo)
  {
    this.jdField_a_of_type_Ogo = paramogo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView
 * JD-Core Version:    0.7.0.1
 */