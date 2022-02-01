package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

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
import anvx;
import bcnc;
import bhcu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import olh;
import pjj;
import pkg;
import pkh;
import pnn;
import ppe;
import pqf;
import prg;
import qfw;
import rfw;
import rga;
import rie;
import rjl;
import rqy;
import rrl;
import szd;
import uvs;

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
      long l = Long.parseLong(this.jdField_a_of_type_Rfw.a.a().mSubscribeID);
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
      if (!pnn.a()) {
        break label45;
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(bcnc.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(this);
      return;
      label45:
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_Szd.a(l));
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Rfw.a != null) && (this.jdField_a_of_type_Rfw.a.a() != null))
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Rfw.a.a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(prg.a(localArticleInfo.mSubscribeName));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((localArticleInfo.mSocialFeedInfo != null) && (ppe.a(localArticleInfo)) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.a == 1)) {
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
    if ((this.jdField_a_of_type_Rfw.a != null) && (this.jdField_a_of_type_Rfw.a.a() != null))
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Rfw.a.a();
      if (ComponentPolymericView.a(this.jdField_a_of_type_Rfw.a))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
        if (localArticleInfo.mTime <= 0L) {
          break label464;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(pkg.a(localArticleInfo.mTime, true));
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        return;
        if ((!TextUtils.isEmpty(localArticleInfo.mSummary)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anvx.a(2131701832));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new rie(this));
          Object localObject1;
          Object localObject2;
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = new SpannableStringBuilder();
            if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a != null))
            {
              ((SpannableStringBuilder)localObject1).append(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.ui", 2, "Comment String: " + localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a);
              }
            }
            for (;;)
            {
              localObject2 = anvx.a(2131701816);
              ((SpannableStringBuilder)localObject1).append(" ");
              ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
              rga localrga = new rga(localArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_Rfw);
              localrga.a = 17;
              ((SpannableStringBuilder)localObject1).setSpan(localrga, ((SpannableStringBuilder)localObject1).length() - ((String)localObject2).length(), ((SpannableStringBuilder)localObject1).length(), 33);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131701795));
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
  }
  
  private void g()
  {
    ArticleInfo localArticleInfo;
    String str2;
    String str3;
    if ((this.jdField_a_of_type_Rfw.a != null) && (this.jdField_a_of_type_Rfw.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_Rfw.a.a();
      pqx.a = localArticleInfo;
      str2 = "" + a();
      str1 = pjj.k + bhcu.encodeToString(str2.getBytes(), 2);
      pkh.a(getContext(), str1);
      str3 = pqf.a("4", localArticleInfo, a());
      if (!uvs.a(this.jdField_a_of_type_Rfw.a.e())) {
        break label189;
      }
    }
    label189:
    for (String str1 = "0X800935C";; str1 = "0X8007BA3")
    {
      olh.a(null, str2, str1, str1, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "" + localArticleInfo.mStrategyId, str3, false);
      return;
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560181, this, true);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if ((pnn.a()) && (a() == paramLong)) {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131363145));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371981));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378905));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365538));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376138);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)findViewById(2131376099));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369552));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof qfw)) {
      a((qfw)paramObject);
    }
  }
  
  public void a(qfw paramqfw)
  {
    d();
    rjl.a(this.jdField_a_of_type_Rfw.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView, this.jdField_a_of_type_AndroidWidgetImageView);
    e();
    f();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish
 * JD-Core Version:    0.7.0.1
 */