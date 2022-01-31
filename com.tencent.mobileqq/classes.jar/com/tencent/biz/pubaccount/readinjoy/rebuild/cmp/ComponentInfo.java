package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
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
import com.tencent.biz.pubaccount.readinjoy.common.ApiCompatibilityUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentInfo
  extends LinearLayout
  implements ComponentView
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  public ComponentNotIntrest a;
  TextView b;
  TextView c;
  TextView d;
  
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
    float f9 = AIOUtils.a(1.0F, paramResources);
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
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a((IReadInJoyModel)paramObject);
      b();
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void c()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    if (localArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localArticleInfo.mArticleSubscriptText))
    {
      String str;
      if (AdvertisementInfo.isAdvertisementInfo(localArticleInfo)) {
        str = "#BBBBBB";
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mArticleSubscriptText);
        try
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(str));
          ApiCompatibilityUtils.a(this.jdField_a_of_type_AndroidWidgetTextView, a(Color.parseColor(str), getResources()));
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          return;
          if (TextUtils.isEmpty(localArticleInfo.mArticleSubscriptColor)) {
            str = "#00a5e0";
          } else {
            str = localArticleInfo.mArticleSubscriptColor;
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
            ApiCompatibilityUtils.a(this.jdField_a_of_type_AndroidWidgetTextView, a(Color.parseColor("#00a5e0"), getResources()));
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void d()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    String str = localArticleInfo.mSubscribeName;
    if (localArticleInfo.mSubscribeName.length() > 18) {
      str = localArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    this.c.setVisibility(0);
    this.c.setText(str);
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.m())
    {
      localObject = (AdvertisementInfo)localObject;
      try
      {
        localObject = new JSONObject(((AdvertisementInfo)localObject).mAdExt);
        if (PackageUtil.a(getContext(), ((JSONObject)localObject).optString("pkg_name"))) {
          this.b.setText(getContext().getString(2131438668));
        }
        for (;;)
        {
          label72:
          this.b.setVisibility(0);
          return;
          this.b.setText(getContext().getString(2131438667));
        }
      }
      catch (JSONException localJSONException)
      {
        break label72;
      }
    }
    this.b.setVisibility(8);
  }
  
  private void f()
  {
    this.d.setVisibility(8);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130969578, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131366835));
    this.c = ((TextView)paramContext.findViewById(2131362736));
    this.b = ((TextView)paramContext.findViewById(2131367005));
    this.d = ((TextView)paramContext.findViewById(2131366838));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramContext.findViewById(2131366978));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a((IReadInJoyModel)paramObject);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.h()) {
        break label64;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(8);
    }
    while (((IReadInJoyModel)paramObject).a() == null)
    {
      QLog.e("ComponentInfo", 1, "bindData getArticleInfo null");
      return;
      label64:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(paramObject);
    }
    c();
    d();
    e();
    f();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.j())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.c.setVisibility(8);
        this.b.setVisibility(8);
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.a(7.0F, getResources());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(18.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.a(0.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(18.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(11.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.a(0.0F, getResources());
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.b.setVisibility(8);
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.a(2.25F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.b()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.c()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.c.setVisibility(0);
      this.b.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(0.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(13.0F, getResources());
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.d())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.c.setVisibility(0);
      this.b.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(0.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(13.0F, getResources());
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.c.setVisibility(8);
      this.b.setVisibility(8);
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.a(7.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(26.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(26.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(11.0F, getResources());
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.a(1.25F, getResources());
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.a(2.25F, getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentInfo
 * JD-Core Version:    0.7.0.1
 */