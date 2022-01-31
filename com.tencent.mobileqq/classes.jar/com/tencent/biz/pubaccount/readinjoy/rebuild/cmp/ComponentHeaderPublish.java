package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import lvk;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentHeaderPublish
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  public TextView a;
  public ReadInJoyYAFolderTextView a;
  private FixSizeImageView a;
  public boolean a;
  private TextView b;
  public boolean b;
  
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
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSubscribeID);
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
      if (!ReadInJoyUtils.a()) {
        break label45;
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(this);
      return;
      label45:
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(l));
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyUtils.d(((ArticleInfo)localObject).mSubscribeName));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (ReadInJoyBaseAdapter.a((ArticleInfo)localObject)) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a == 1))
      {
        localObject = getResources().getDrawable(2130839745);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.a(16.0F, getResources()), AIOUtils.a(16.0F, getResources()));
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(4.0F, getResources()));
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null))
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      SpannableStringBuilder localSpannableStringBuilder;
      if ((!TextUtils.isEmpty(localArticleInfo.mSummary)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText("更多");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new lvk(this));
        if (this.jdField_a_of_type_Boolean)
        {
          localSpannableStringBuilder = new SpannableStringBuilder();
          if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null))
          {
            localSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
            }
            localSpannableStringBuilder.append(" ");
            localSpannableStringBuilder.append("阅读原文");
            ComponentAccountSummary.ReadArticleSpan localReadArticleSpan = new ComponentAccountSummary.ReadArticleSpan(localArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt);
            localReadArticleSpan.a = 17;
            localSpannableStringBuilder.setSpan(localReadArticleSpan, localSpannableStringBuilder.length() - "阅读原文".length(), localSpannableStringBuilder.length(), 33);
            localSpannableStringBuilder.append(" ");
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
            label290:
            if (localArticleInfo.mTime <= 0L) {
              break label386;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyTimeUtils.a(localArticleInfo.mTime, true));
          }
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        return;
        if (localArticleInfo.mTitle == null) {
          break;
        }
        localSpannableStringBuilder.append(localArticleInfo.mTitle);
        break;
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setHeight(0);
          break label290;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localArticleInfo.mSummary);
        break label290;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
        break label290;
        label386:
        this.jdField_b_of_type_AndroidWidgetTextView.setText("刚刚");
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
  }
  
  private void g()
  {
    ArticleInfo localArticleInfo;
    String str;
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      ReadInJoyUtils.a = localArticleInfo;
      str = "" + a();
      localObject1 = ReadInJoyConstants.i + Base64Util.encodeToString(String.valueOf(str).getBytes(), 2);
      ReadInJoyUtils.a(getContext(), (String)localObject1);
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", ReadInJoyUtils.d);
      ((JSONObject)localObject2).put("feeds_source", str);
      ((JSONObject)localObject2).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("feeds_type", "" + ReadInJoyUtils.a(localArticleInfo));
      ((JSONObject)localObject2).put("kandian_mode", "" + ReadInJoyUtils.e());
      ((JSONObject)localObject2).put("tab_source", "" + ReadInJoyUtils.d());
      ((JSONObject)localObject2).put("entry_mode", "4");
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
    PublicAccountReportUtils.a(null, str, "0X8007BA3", "0X8007BA3", 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "", (String)localObject1, false);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969574, this, true);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if ((ReadInJoyUtils.a()) && (a() == paramLong)) {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131366993));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362876));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366837));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365632));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    d();
    e();
    f();
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
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