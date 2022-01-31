package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aciy;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bady;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.qphone.base.util.QLog;
import nzq;
import obz;
import opw;
import org.json.JSONException;
import org.json.JSONObject;
import pey;
import pfh;
import pjg;

public class ComponentInfo
  extends LinearLayout
  implements pey
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ComponentNotIntrest a;
  ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  pjg jdField_a_of_type_Pjg;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  
  public ComponentInfo(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentInfo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  @TargetApi(11)
  public ComponentInfo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  public ComponentInfo(Context paramContext, Object paramObject)
  {
    super(paramContext);
    a(paramContext, paramObject);
  }
  
  public static ShapeDrawable a(int paramInt, Resources paramResources)
  {
    float f9 = aciy.a(1.0F, paramResources);
    float f1 = 6;
    float f2 = 6;
    float f3 = 6;
    float f4 = 6;
    float f5 = 6;
    float f6 = 6;
    float f7 = 6;
    float f8 = 6;
    paramResources = new RectF(f9, f9, f9, f9);
    f9 = 5;
    float f10 = 5;
    float f11 = 5;
    float f12 = 5;
    float f13 = 5;
    float f14 = 5;
    float f15 = 5;
    float f16 = 5;
    paramResources = new ShapeDrawable(new RoundRectShape(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, paramResources, new float[] { f9, f10, f11, f12, f13, f14, f15, f16 }));
    LinearGradient localLinearGradient = new LinearGradient(50.0F, 50.0F, 50.0F, 50.0F, paramInt, paramInt, Shader.TileMode.REPEAT);
    paramResources.getPaint().setShader(localLinearGradient);
    return paramResources;
  }
  
  private void a(Context paramContext, Object paramObject)
  {
    b(paramContext);
    if ((paramObject instanceof opw))
    {
      this.jdField_a_of_type_Pjg.a((opw)paramObject);
      b();
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Pjg = new pjg();
    a(paramContext);
    a();
  }
  
  private void c()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pjg.a.a();
    if (localArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localArticleInfo.mArticleSubscriptText))
    {
      String str;
      if (AdvertisementInfo.isAdvertisementInfo(localArticleInfo)) {
        switch (this.jdField_a_of_type_Pjg.a())
        {
        default: 
          str = "#BBBBBB";
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mArticleSubscriptText);
        try
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(str));
          nzq.a(this.jdField_a_of_type_AndroidWidgetTextView, a(Color.parseColor(str), getResources()));
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          return;
          str = "#12B7F5";
          continue;
          if (TextUtils.isEmpty(localArticleInfo.mArticleSubscriptColor)) {}
          for (str = "#00a5e0";; str = localArticleInfo.mArticleSubscriptColor)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 1);
            break;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("ComponentInfo", 2, "configDefaultItem: ", localException);
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
            nzq.a(this.jdField_a_of_type_AndroidWidgetTextView, a(Color.parseColor("#00a5e0"), getResources()));
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void d()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pjg.a.a();
    if ((AdvertisementInfo.isAdvertisementInfo(localArticleInfo)) && (this.jdField_a_of_type_Pjg.a() == 1)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
    }
    do
    {
      return;
      String str = localArticleInfo.getSubscribeName();
      if (localArticleInfo.mSubscribeName.length() > 18) {
        str = localArticleInfo.mSubscribeName.substring(0, 17) + "…";
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(str);
    } while (!obz.w(this.jdField_a_of_type_Pjg.a.a()));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(this.jdField_a_of_type_Pjg.a());
  }
  
  private void e()
  {
    Object localObject1 = this.jdField_a_of_type_Pjg.a.a();
    int i;
    if ((this.jdField_a_of_type_Pjg.m()) || (((localObject1 instanceof AdvertisementInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)localObject1).mAdBtnTxt))))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.jdField_a_of_type_AndroidViewView.setPadding(aciy.a(9.75F, getResources()), aciy.a(3.75F, getResources()), aciy.a(9.75F, getResources()), aciy.a(8.25F, getResources()));
      localObject1 = (AdvertisementInfo)localObject1;
      i = this.jdField_a_of_type_Pjg.a();
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt);
        if (TextUtils.isEmpty(((AdvertisementInfo)localObject1).mAdBtnTxt)) {
          continue;
        }
        localObject1 = ((AdvertisementInfo)localObject1).mAdBtnTxt;
        m = -15550475;
        int n = aciy.a(2.0F, getResources());
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        localLayoutParams.rightMargin = aciy.a(9.5F, getResources());
        localLayoutParams.leftMargin = aciy.a(5.0F, getResources());
        switch (i)
        {
        case 1: 
          nzq.a(this.jdField_b_of_type_AndroidWidgetTextView, null);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          j = 0;
          f = 14.0F;
          localObject2 = null;
          i = 0;
          k = 0;
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(n);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(m);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(f);
          this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(null, 0);
          this.jdField_b_of_type_AndroidWidgetTextView.setPadding(k, j, k, i);
          this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        int m;
        LinearLayout.LayoutParams localLayoutParams;
        int j;
        float f;
        int k;
        continue;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (bady.a(getContext(), ((JSONObject)localObject2).optString("pkg_name")))
      {
        localObject1 = getContext().getString(2131652634);
      }
      else
      {
        localObject1 = getContext().getString(2131652632);
        continue;
        if (bady.a(getContext(), ((JSONObject)localObject2).optString("pkg_name")))
        {
          localObject2 = getResources().getDrawable(2130842090);
          f = 11.0F;
          k = aciy.a(3.0F, getResources());
          j = aciy.a(1.7F, getResources());
          i = aciy.a(1.8F, getResources());
          nzq.a(this.jdField_b_of_type_AndroidWidgetTextView, a(-15550475, getResources()));
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          localLayoutParams.leftMargin = aciy.a(8.0F, getResources());
        }
        else
        {
          localObject2 = getResources().getDrawable(2130842089);
          continue;
          if (bady.a(getContext(), ((JSONObject)localObject2).optString("pkg_name")))
          {
            localObject2 = getResources().getDrawable(2130842090);
            f = 11.0F;
            k = aciy.a(3.0F, getResources());
            j = aciy.a(1.7F, getResources());
            i = aciy.a(1.8F, getResources());
            localLayoutParams.rightMargin = aciy.a(3.5F, getResources());
            nzq.a(this.jdField_b_of_type_AndroidWidgetTextView, a(-15550475, getResources()));
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
          else
          {
            localObject2 = getResources().getDrawable(2130842089);
            continue;
            localObject1 = "· " + (String)localObject1;
            nzq.a(this.jdField_b_of_type_AndroidWidgetTextView, null);
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            m = -6447715;
            localObject2 = null;
            f = 12.0F;
            j = 0;
            k = 0;
            i = 0;
            continue;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.jdField_a_of_type_AndroidViewView.setPadding(aciy.a(9.75F, getResources()), aciy.a(8.25F, getResources()), aciy.a(9.75F, getResources()), aciy.a(8.25F, getResources()));
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            return;
          }
        }
      }
    }
  }
  
  private void f()
  {
    this.c.setVisibility(8);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131494307, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131310889));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramContext.findViewById(2131304981));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297109));
    this.c = ((TextView)paramContext.findViewById(2131309395));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramContext.findViewById(2131305237));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131305519);
    this.jdField_b_of_type_AndroidViewView = paramContext.findViewById(2131305520);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof opw))
    {
      this.jdField_a_of_type_Pjg.a((opw)paramObject);
      if (this.jdField_a_of_type_Pjg.a.h())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(8);
        if (((opw)paramObject).a() != null) {
          break label126;
        }
        QLog.e("ComponentInfo", 1, "bindData getArticleInfo null");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(paramObject);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
    if (this.jdField_a_of_type_Pjg.m()) {}
    for (localLayoutParams.gravity = 0;; localLayoutParams.gravity = 80)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams(localLayoutParams);
      break;
    }
    label126:
    c();
    d();
    e();
    f();
  }
  
  public void a(pfh parampfh)
  {
    this.jdField_a_of_type_Pjg.a(parampfh);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(parampfh);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pjg.j())
    {
      if (this.jdField_a_of_type_Pjg.a())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = aciy.a(7.0F, getResources());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = aciy.a(18.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = aciy.a(0.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = aciy.a(18.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = aciy.a(11.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = aciy.a(0.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = aciy.a(2.25F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if ((this.jdField_a_of_type_Pjg.b()) || (this.jdField_a_of_type_Pjg.c()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = aciy.a(0.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = aciy.a(13.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if (this.jdField_a_of_type_Pjg.d())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = aciy.a(0.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = aciy.a(13.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if (this.jdField_a_of_type_Pjg.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = aciy.a(7.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = aciy.a(26.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = aciy.a(26.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).leftMargin = aciy.a(11.0F, getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).rightMargin = aciy.a(2.25F, getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentInfo
 * JD-Core Version:    0.7.0.1
 */