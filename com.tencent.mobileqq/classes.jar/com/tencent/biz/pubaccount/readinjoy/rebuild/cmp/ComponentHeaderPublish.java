package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajya;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import awwa;
import bbco;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import nol;
import omj;
import ong;
import onh;
import pau;
import puy;
import pvc;
import pxg;
import pym;
import qci;
import qcv;
import ram;
import shu;

public class ComponentHeaderPublish
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  public ReadInJoyYAFolderTextView a;
  RingAvatarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  public boolean a;
  private TextView b;
  public boolean b;
  public boolean c;
  
  public ComponentHeaderPublish(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderPublish(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderPublish(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  private void d()
  {
    long l = a();
    if (l != 0L)
    {
      if (!onh.a()) {
        break label45;
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(awwa.a(this.jdField_a_of_type_Baxy, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(this);
      return;
      label45:
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_Ram.a(l));
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Puy.a != null) && (this.jdField_a_of_type_Puy.a.a() != null))
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Puy.a.a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(onh.d(localArticleInfo.mSubscribeName));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((localArticleInfo.mSocialFeedInfo != null) && (ram.a(localArticleInfo)) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.a == 1)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Puy.a != null) && (this.jdField_a_of_type_Puy.a.a() != null))
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Puy.a.a();
      if (ComponentPolymericView.a(this.jdField_a_of_type_Puy.a))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
        if (localArticleInfo.mTime <= 0L) {
          break label464;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ong.a(localArticleInfo.mTime, true));
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        return;
        if ((!TextUtils.isEmpty(localArticleInfo.mSummary)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(ajya.a(2131702335));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pxg(this));
          Object localObject1;
          Object localObject2;
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = new SpannableStringBuilder();
            if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.a != null))
            {
              ((SpannableStringBuilder)localObject1).append(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.a);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.ui", 2, "Comment String: " + localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.a);
              }
            }
            for (;;)
            {
              localObject2 = ajya.a(2131702319);
              ((SpannableStringBuilder)localObject1).append(" ");
              ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
              pvc localpvc = new pvc(localArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_Puy);
              localpvc.a = 17;
              ((SpannableStringBuilder)localObject1).setSpan(localpvc, ((SpannableStringBuilder)localObject1).length() - ((String)localObject2).length(), ((SpannableStringBuilder)localObject1).length(), 33);
              ((SpannableStringBuilder)localObject1).append(" ");
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText((CharSequence)localObject1);
              break;
              if (localArticleInfo.mTitle != null) {
                ((SpannableStringBuilder)localObject1).append(localArticleInfo.mTitle);
              }
            }
          }
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setHeight(0);
            break;
          }
          if (this.c)
          {
            localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView;
            if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {}
            for (localObject1 = localArticleInfo.mTitle;; localObject1 = localArticleInfo.mSummary)
            {
              ((ReadInJoyYAFolderTextView)localObject2).setText((CharSequence)localObject1);
              break;
            }
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localArticleInfo.mSummary);
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
        break;
        label464:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131702298));
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
  }
  
  private void g()
  {
    ArticleInfo localArticleInfo;
    String str2;
    String str3;
    if ((this.jdField_a_of_type_Puy.a != null) && (this.jdField_a_of_type_Puy.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_Puy.a.a();
      onh.a = localArticleInfo;
      str2 = "" + a();
      str1 = omj.k + bbco.encodeToString(String.valueOf(str2).getBytes(), 2);
      onh.a(getContext(), str1);
      str3 = onh.a("4", localArticleInfo, a());
      if (!shu.a(this.jdField_a_of_type_Puy.a.e())) {
        break label191;
      }
    }
    label191:
    for (String str1 = "0X800935C";; str1 = "0X8007BA3")
    {
      nol.a(null, str2, str1, str1, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "" + localArticleInfo.mStrategyId, str3, false);
      return;
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559874, this, true);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if ((onh.a()) && (a() == paramLong)) {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131362938));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370832));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377264));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365042));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374743);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)findViewById(2131374706));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368697));
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
    d();
    pym.a(this.jdField_a_of_type_Puy.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView, this.jdField_a_of_type_AndroidWidgetImageView);
    e();
    f();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish
 * JD-Core Version:    0.7.0.1
 */