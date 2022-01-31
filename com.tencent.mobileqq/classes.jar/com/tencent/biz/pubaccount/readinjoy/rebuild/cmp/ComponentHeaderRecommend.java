package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import ajya;
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
import bbco;
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
import nol;
import omj;
import ong;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import osg;
import pau;
import pbu;
import puy;
import pxh;
import pxi;
import qci;
import qcv;
import ram;

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
      long l = Long.parseLong(this.jdField_a_of_type_Puy.a.a().mSubscribeID);
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
      boolean bool = osg.a().b(Long.valueOf(a()));
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
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131702252));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131702345));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#07D0B0"));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Puy.a != null) && (this.jdField_a_of_type_Puy.a.a() != null))
    {
      Object localObject = this.jdField_a_of_type_Puy.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(onh.d(((ArticleInfo)localObject).mSubscribeName));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
      if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (ram.h((ArticleInfo)localObject)) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qci.a == 1))
      {
        localObject = getResources().getDrawable(2130844200);
        ((Drawable)localObject).setBounds(0, 0, actj.a(16.0F, getResources()), actj.a(16.0F, getResources()));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setCompoundDrawablePadding(actj.a(4.0F, getResources()));
      }
    }
  }
  
  private void f()
  {
    ArticleInfo localArticleInfo;
    if ((this.jdField_a_of_type_Puy.a != null) && (this.jdField_a_of_type_Puy.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_Puy.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(ajya.a(2131702263));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pxh(this));
      if (!onh.r(localArticleInfo)) {
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
    Object localObject = this.jdField_a_of_type_Puy.a.a();
    if (onh.r((BaseArticleInfo)localObject)) {
      if (((ArticleInfo)localObject).mTime > 0L) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ong.a(((ArticleInfo)localObject).mSocialFeedInfo.e, true));
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131702283));
        return;
      } while (((ArticleInfo)localObject).mSocialFeedInfo == null);
      if (!TextUtils.isEmpty(((ArticleInfo)localObject).mSocialFeedInfo.d))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((ArticleInfo)localObject).mSocialFeedInfo.d);
        return;
      }
    } while (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcv == null);
    int i = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcv.a;
    if (i >= 10000) {
      localObject = new DecimalFormat("####.0");
    }
    for (localObject = ((DecimalFormat)localObject).format(i / 10000.0D) + ajya.a(2131702282);; localObject = "" + i)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject + ajya.a(2131702276));
      return;
    }
  }
  
  private void h()
  {
    ArticleInfo localArticleInfo;
    String str;
    Object localObject1;
    if ((this.jdField_a_of_type_Puy.a != null) && (this.jdField_a_of_type_Puy.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_Puy.a.a();
      str = "" + a();
      localObject1 = omj.k + bbco.encodeToString(String.valueOf(a()).getBytes(), 2);
      onh.a(getContext(), (String)localObject1);
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", onh.d);
      ((JSONObject)localObject2).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("kandian_mode", "" + onh.e());
      ((JSONObject)localObject2).put("tab_source", "" + onh.d());
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
    nol.a(null, str, "0X80080ED", "0X80080ED", 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "", (String)localObject1, false);
  }
  
  private void i()
  {
    QQAppInterface localQQAppInterface;
    if (!b())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131702253));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((this.jdField_a_of_type_Puy.a == null) || (this.jdField_a_of_type_Puy.a.a() == null)) {
        break label183;
      }
      Object localObject = this.jdField_a_of_type_Puy.a.a();
      if ((((ArticleInfo)localObject).mGroupSubArticleList == null) || (((ArticleInfo)localObject).mGroupSubArticleList.size() <= 0)) {
        break label183;
      }
      localObject = (BaseArticleInfo)((ArticleInfo)localObject).mGroupSubArticleList.get(0);
      if (((localObject instanceof ArticleInfo)) && (!ram.o((ArticleInfo)localObject))) {
        break label183;
      }
    }
    label183:
    for (int i = 2;; i = 1)
    {
      osg.a().a().a(localQQAppInterface.getAccount(), a(), true, new pxi(this), i);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)findViewById(2131362938));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131370832));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364789));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365042));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363544));
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof pau)) {
      a((pau)paramObject);
    }
  }
  
  public void a(pau parampau)
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
    case 2131362938: 
    case 2131370832: 
    case 2131377264: 
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