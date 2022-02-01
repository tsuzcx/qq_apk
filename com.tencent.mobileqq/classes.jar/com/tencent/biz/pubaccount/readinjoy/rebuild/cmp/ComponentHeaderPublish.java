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
import anzj;
import bcni;
import bhkv;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import ocd;
import oyu;
import ozr;
import ozs;
import ppu;
import qno;
import qns;
import qpw;
import qrc;
import qxt;
import qyg;
import sel;
import ubg;

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
      long l = Long.parseLong(this.jdField_a_of_type_Qno.a.a().mSubscribeID);
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
      if (!ozs.a()) {
        break label45;
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(bcni.a(this.jdField_a_of_type_Aoof, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(this);
      return;
      label45:
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_Sel.a(l));
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Qno.a != null) && (this.jdField_a_of_type_Qno.a.a() != null))
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Qno.a.a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ozs.e(localArticleInfo.mSubscribeName));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((localArticleInfo.mSocialFeedInfo != null) && (sel.a(localArticleInfo)) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.a == 1)) {
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
    if ((this.jdField_a_of_type_Qno.a != null) && (this.jdField_a_of_type_Qno.a.a() != null))
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Qno.a.a();
      if (ComponentPolymericView.a(this.jdField_a_of_type_Qno.a))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
        if (localArticleInfo.mTime <= 0L) {
          break label464;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ozr.a(localArticleInfo.mTime, true));
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        return;
        if ((!TextUtils.isEmpty(localArticleInfo.mSummary)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anzj.a(2131701246));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new qpw(this));
          Object localObject1;
          Object localObject2;
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = new SpannableStringBuilder();
            if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.a != null))
            {
              ((SpannableStringBuilder)localObject1).append(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.a);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.ui", 2, "Comment String: " + localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.a);
              }
            }
            for (;;)
            {
              localObject2 = anzj.a(2131701230);
              ((SpannableStringBuilder)localObject1).append(" ");
              ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
              qns localqns = new qns(localArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_Qno);
              localqns.a = 17;
              ((SpannableStringBuilder)localObject1).setSpan(localqns, ((SpannableStringBuilder)localObject1).length() - ((String)localObject2).length(), ((SpannableStringBuilder)localObject1).length(), 33);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131701209));
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
  }
  
  private void g()
  {
    ArticleInfo localArticleInfo;
    String str2;
    String str3;
    if ((this.jdField_a_of_type_Qno.a != null) && (this.jdField_a_of_type_Qno.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_Qno.a.a();
      ozs.a = localArticleInfo;
      str2 = "" + a();
      str1 = oyu.k + bhkv.encodeToString(str2.getBytes(), 2);
      ozs.a(getContext(), str1);
      str3 = ozs.a("4", localArticleInfo, a());
      if (!ubg.a(this.jdField_a_of_type_Qno.a.e())) {
        break label188;
      }
    }
    label188:
    for (String str1 = "0X800935C";; str1 = "0X8007BA3")
    {
      ocd.a(null, str2, str1, str1, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "" + localArticleInfo.mStrategyId, str3, false);
      return;
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560127, this, true);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if ((ozs.a()) && (a() == paramLong)) {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131363109));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371827));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378847));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365413));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376127);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)findViewById(2131376085));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369390));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof ppu)) {
      a((ppu)paramObject);
    }
  }
  
  public void a(ppu paramppu)
  {
    d();
    qrc.a(this.jdField_a_of_type_Qno.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView, this.jdField_a_of_type_AndroidWidgetImageView);
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