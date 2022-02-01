package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_COMM.COMM.StCommonExt;
import aanb;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import mqq.app.AppRuntime;
import zqg;
import zqm;
import zqr;
import zqt;
import zqu;
import zqv;
import zqw;
import zqx;
import zqy;
import zqz;
import zrb;
import zrh;
import zrp;
import zse;

public class FollowedRecommendBannerView
  extends LinearLayout
  implements zqt
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private zqr jdField_a_of_type_Zqr;
  private zrb jdField_a_of_type_Zrb;
  
  public FollowedRecommendBannerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public FollowedRecommendBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private COMM.StCommonExt a()
  {
    if (this.jdField_a_of_type_Zqr != null) {
      return this.jdField_a_of_type_Zqr.a();
    }
    return null;
  }
  
  private void b()
  {
    StringBuilder localStringBuilder = new StringBuilder(zqg.b(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    if (a() != null) {}
    for (;;)
    {
      try
      {
        localStringBuilder.append(URLEncoder.encode(a().attachInfo.get(), "UTF-8"));
        aanb.b(this.jdField_a_of_type_JavaLangString, "auth_person", "reco_more", 0, 0, new String[0]);
        zqm.a(localStringBuilder.toString());
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      QLog.d("FollowedRecommendBanner", 0, "jump more recommend H5 page with no attach info!");
    }
  }
  
  private void c()
  {
    setVisibility(0);
    Object localObject = (View)getParent();
    if (localObject != null) {
      measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    localObject = ValueAnimator.ofInt(new int[] { 0, getMeasuredHeight() });
    ((ValueAnimator)localObject).addUpdateListener(new zqz(this, this, null));
    ((ValueAnimator)localObject).addListener(new zqx(this));
    ((ValueAnimator)localObject).start();
    aanb.a(this.jdField_a_of_type_JavaLangString, "auth_person", "reco_exp", 0, 0, new String[0]);
  }
  
  public void a()
  {
    if (getVisibility() == 8)
    {
      clearAnimation();
      return;
    }
    Object localObject = (View)getParent();
    if (localObject != null) {
      measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    localObject = ValueAnimator.ofInt(new int[] { getMeasuredHeight(), 0 });
    ((ValueAnimator)localObject).addUpdateListener(new zqz(this, this, null));
    ((ValueAnimator)localObject).addListener(new zqy(this));
    ((ValueAnimator)localObject).start();
    aanb.a(this.jdField_a_of_type_JavaLangString, "auth_person", "reco_pack_up", 0, 0, new String[0]);
  }
  
  protected void a(Context paramContext)
  {
    setOrientation(1);
    inflate(paramContext, 2131558807, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131363379));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371576));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369568));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.jdField_a_of_type_Zqr = new zqr();
    this.jdField_a_of_type_Zqr.a(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new zrh());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(new DefaultItemAnimator());
    this.jdField_a_of_type_Zrb = new zrp(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Zrb.a(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Zrb);
    this.jdField_a_of_type_Zrb.a(new zqu(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new zqv(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new zqw(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Zqr != null) {
      this.jdField_a_of_type_Zqr.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(List<zse> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (this.jdField_a_of_type_Zrb != null) {
      this.jdField_a_of_type_Zrb.a(null, paramList);
    }
    c();
  }
  
  public boolean a()
  {
    return getVisibility() == 0;
  }
  
  protected void onDetachedFromWindow()
  {
    clearAnimation();
    super.onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView
 * JD-Core Version:    0.7.0.1
 */