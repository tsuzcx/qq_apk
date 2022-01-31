package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actn;
import ajyc;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import bbca;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.text.DecimalFormat;
import java.util.List;
import noo;
import omm;
import onj;
import onk;
import org.json.JSONException;
import org.json.JSONObject;
import osj;
import pax;
import pbx;
import pvb;
import pxk;
import pxl;
import qcl;
import qcy;
import rap;

public class ComponentHeaderRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  public ReadInJoyNickNameTextView a;
  public ReadInJoyYAFolderTextView a;
  
  public ComponentHeaderRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderRecommend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private long a()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_Pvb.a.a().mSubscribeID);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return 0L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean b()
  {
    try
    {
      boolean bool = osj.a().b(Long.valueOf(a()));
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (b())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131702241));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131702334));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#07D0B0"));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Pvb.a != null) && (this.jdField_a_of_type_Pvb.a.a() != null))
    {
      Object localObject = this.jdField_a_of_type_Pvb.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(onk.d(((ArticleInfo)localObject).mSubscribeName));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
      if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (rap.h((ArticleInfo)localObject)) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcl.a == 1))
      {
        localObject = getResources().getDrawable(2130844199);
        ((Drawable)localObject).setBounds(0, 0, actn.a(16.0F, getResources()), actn.a(16.0F, getResources()));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setCompoundDrawablePadding(actn.a(4.0F, getResources()));
      }
    }
  }
  
  private void f()
  {
    ArticleInfo localArticleInfo;
    if ((this.jdField_a_of_type_Pvb.a != null) && (this.jdField_a_of_type_Pvb.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_Pvb.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(ajyc.a(2131702252));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pxk(this));
      if (!onk.r(localArticleInfo)) {
        break label103;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
    }
    for (;;)
    {
      g();
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
      label103:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localArticleInfo.mSummary);
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_Pvb.a.a();
    if (onk.r((BaseArticleInfo)localObject)) {
      if (((ArticleInfo)localObject).mTime > 0L) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(onj.a(((ArticleInfo)localObject).mSocialFeedInfo.e, true));
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131702272));
        return;
      } while (((ArticleInfo)localObject).mSocialFeedInfo == null);
      if (!TextUtils.isEmpty(((ArticleInfo)localObject).mSocialFeedInfo.d))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((ArticleInfo)localObject).mSocialFeedInfo.d);
        return;
      }
    } while (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcy == null);
    int i = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcy.a;
    if (i >= 10000) {
      localObject = new DecimalFormat("####.0");
    }
    for (localObject = ((DecimalFormat)localObject).format(i / 10000.0D) + ajyc.a(2131702271);; localObject = "" + i)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject + ajyc.a(2131702265));
      return;
    }
  }
  
  private void h()
  {
    ArticleInfo localArticleInfo;
    String str;
    Object localObject1;
    if ((this.jdField_a_of_type_Pvb.a != null) && (this.jdField_a_of_type_Pvb.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_Pvb.a.a();
      str = "" + a();
      localObject1 = omm.k + bbca.encodeToString(String.valueOf(a()).getBytes(), 2);
      onk.a(getContext(), (String)localObject1);
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", onk.d);
      ((JSONObject)localObject2).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("kandian_mode", "" + onk.e());
      ((JSONObject)localObject2).put("tab_source", "" + onk.d());
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    noo.a(null, str, "0X80080ED", "0X80080ED", 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "", (String)localObject1, false);
  }
  
  private void i()
  {
    QQAppInterface localQQAppInterface;
    if (!b())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131702242));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((this.jdField_a_of_type_Pvb.a == null) || (this.jdField_a_of_type_Pvb.a.a() == null)) {
        break label183;
      }
      Object localObject = this.jdField_a_of_type_Pvb.a.a();
      if ((((ArticleInfo)localObject).mGroupSubArticleList == null) || (((ArticleInfo)localObject).mGroupSubArticleList.size() <= 0)) {
        break label183;
      }
      localObject = (BaseArticleInfo)((ArticleInfo)localObject).mGroupSubArticleList.get(0);
      if (((localObject instanceof ArticleInfo)) && (!rap.o((ArticleInfo)localObject))) {
        break label183;
      }
    }
    label183:
    for (int i = 2;; i = 1)
    {
      osj.a().a().a(localQQAppInterface.getAccount(), a(), true, new pxl(this), i);
      c();
      return;
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559872, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)findViewById(2131362939));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131370832));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364790));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365043));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363545));
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof pax)) {
      a((pax)paramObject);
    }
  }
  
  public void a(pax parampax)
  {
    long l = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    e();
    f();
    d();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362939: 
    case 2131370832: 
    case 2131377263: 
      h();
      return;
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend
 * JD-Core Version:    0.7.0.1
 */