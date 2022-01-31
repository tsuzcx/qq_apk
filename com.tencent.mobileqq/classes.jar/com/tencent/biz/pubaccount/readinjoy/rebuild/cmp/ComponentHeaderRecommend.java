package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

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
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.widget.FixSizeImageView;
import java.text.DecimalFormat;
import lvl;
import lvm;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentHeaderRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  public TextView a;
  public ReadInJoyYAFolderTextView a;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  private TextView b;
  
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
  
  private boolean b()
  {
    try
    {
      boolean bool = ((PublicAccountDataManager)BaseApplicationImpl.getApplication().getRuntime().getManager(55)).a(Long.valueOf(a()));
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
      this.jdField_a_of_type_AndroidWidgetButton.setText("已关注");
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText("关注");
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#07D0B0"));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
  }
  
  private void e()
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
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyUtils.d(((ArticleInfo)localObject).mSubscribeName));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (ReadInJoyBaseAdapter.e((ArticleInfo)localObject)) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a == 1))
      {
        localObject = getResources().getDrawable(2130842359);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.a(16.0F, getResources()), AIOUtils.a(16.0F, getResources()));
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(4.0F, getResources()));
      }
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null))
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText("更多");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new lvl(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localArticleInfo.mSummary);
      h();
      this.b.setOnClickListener(this);
    }
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    if (((ArticleInfo)localObject).mSocialFeedInfo != null)
    {
      if (TextUtils.isEmpty(((ArticleInfo)localObject).mSocialFeedInfo.d)) {
        break label48;
      }
      this.b.setText(((ArticleInfo)localObject).mSocialFeedInfo.d);
    }
    label48:
    while (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo == null) {
      return;
    }
    int i = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a;
    if (i >= 10000) {
      localObject = new DecimalFormat("####.0");
    }
    for (localObject = ((DecimalFormat)localObject).format(i / 10000.0D) + "万";; localObject = "" + i)
    {
      this.b.setText((String)localObject + "人关注");
      return;
    }
  }
  
  private void i()
  {
    ArticleInfo localArticleInfo;
    String str;
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      str = "" + a();
      localObject1 = ReadInJoyConstants.i + Base64Util.encodeToString(String.valueOf(a()).getBytes(), 2);
      ReadInJoyUtils.a(getContext(), (String)localObject1);
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", ReadInJoyUtils.d);
      ((JSONObject)localObject2).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("kandian_mode", "" + ReadInJoyUtils.e());
      ((JSONObject)localObject2).put("tab_source", "" + ReadInJoyUtils.d());
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
    PublicAccountReportUtils.a(null, str, "0X80080ED", "0X80080ED", 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "", (String)localObject1, false);
  }
  
  private void j()
  {
    if (!b())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText("已关注");
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      PublicAccountUtil.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), getContext(), Long.toString(a()), new lvm(this));
      c();
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969572, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131366993));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362876));
    this.b = ((TextView)findViewById(2131364169));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365632));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366984));
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    e();
    f();
    g();
    d();
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
    case 2131362876: 
    case 2131366837: 
    case 2131366993: 
      i();
      return;
    }
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend
 * JD-Core Version:    0.7.0.1
 */