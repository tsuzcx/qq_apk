package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bdaq;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import nrt;
import pgq;
import pxj;
import pxt;
import qdl;
import qmw;
import qyg;

public class ComponentContentUGCVoice
  extends LinearLayout
  implements pxj, qyg
{
  public static final String a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private SocializeFeedsInfo.UGCVoiceInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo;
  
  static
  {
    jdField_a_of_type_JavaLangString = ComponentContentUGCVoice.class.getSimpleName();
  }
  
  public ComponentContentUGCVoice(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559961, this, true);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131379247));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379248));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379246));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new qdl(this));
  }
  
  public void a(SocializeFeedsInfo.UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (paramUGCVoiceInfo == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849006);
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
    }
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((pgq)paramObject).a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.c == null)) {}
    do
    {
      return;
      paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.c;
    } while (paramObject.isEmpty());
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1)
    {
      i = 1;
      if (i == 0) {
        break label317;
      }
      if ((getParent() != null) && (getParent().getParent() != null)) {
        ((View)getParent().getParent()).setBackgroundColor(-460552);
      }
      label132:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo = ((SocializeFeedsInfo.UGCVoiceInfo)paramObject.get(0));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%02d″", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int) }));
      paramObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int <= 50) {
        break label355;
      }
      paramObject.width = bdaq.a(getContext(), 277.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramObject);
      nrt.a(null, "", "0X8009CA3", "0X8009CA3", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId + "", "", "", false);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Boolean) {
        break label483;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849006);
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
      return;
      i = 0;
      break;
      label317:
      if ((getParent() == null) || (getParent().getParent() == null)) {
        break label132;
      }
      ((View)getParent().getParent()).setBackgroundColor(-1);
      break label132;
      label355:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int > 40) {
        paramObject.width = bdaq.a(getContext(), 237.0F);
      } else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int > 30) {
        paramObject.width = bdaq.a(getContext(), 197.0F);
      } else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int > 20) {
        paramObject.width = bdaq.a(getContext(), 157.0F);
      } else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int > 10) {
        paramObject.width = bdaq.a(getContext(), 117.0F);
      } else {
        paramObject.width = bdaq.a(getContext(), 85.0F);
      }
    }
    label483:
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849005);
  }
  
  public void a(pxt parampxt) {}
  
  public void b(SocializeFeedsInfo.UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (paramUGCVoiceInfo == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUGCVoice
 * JD-Core Version:    0.7.0.1
 */