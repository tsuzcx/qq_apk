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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lvu;
import lvv;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentHeaderUgc
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  public Button a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  public ReadInJoyYAFolderTextView a;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  private TextView b;
  
  public ComponentHeaderUgc(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderUgc(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private long a()
  {
    try
    {
      long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long;
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
  
  private void a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
      return;
    }
    Object localObject1 = ReadInJoyConstants.f + Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    ReadInJoyUtils.a(getContext(), (String)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderUgc", 2, "personal url =" + (String)localObject1);
    }
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    ReadInJoyUtils.a = localArticleInfo;
    localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", ReadInJoyUtils.d);
      ((JSONObject)localObject2).put("feeds_source", String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long));
      ((JSONObject)localObject2).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("feeds_type", "" + ReadInJoyUtils.a(localArticleInfo));
      ((JSONObject)localObject2).put("kandian_mode", "" + ReadInJoyUtils.e());
      ((JSONObject)localObject2).put("tab_source", "" + ReadInJoyUtils.d());
      ((JSONObject)localObject2).put("entry_mode", "3");
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
    PublicAccountReportUtils.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long), "0X8007BA3", "0X8007BA3", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mFeedId), "0", "", (String)localObject1, false);
    ReadInJoyBaseAdapter.a(localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
  }
  
  private void d()
  {
    long l = a();
    ArticleInfo localArticleInfo;
    if (l != 0L)
    {
      if (ReadInJoyUtils.a())
      {
        this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, String.valueOf(l), 1));
        this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(this);
      }
    }
    else
    {
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      if (localArticleInfo != null) {
        break label89;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label89:
    while ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser == null))
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(l));
      break;
    }
    if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null))
    {
      String str = ContactUtils.b((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long), true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyUtils.d(str));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void f()
  {
    ArticleInfo localArticleInfo;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new lvu(this, localArticleInfo));
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
        break label690;
      }
      localObject2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo;
      if ((!CmpCtxt.c(localArticleInfo)) || (ReadInJoyBaseAdapter.o(localArticleInfo))) {
        break label178;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(((SocializeFeedsInfo.UGCVideoInfo)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).e);
    }
    while (!TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.d))
    {
      this.b.setText(localArticleInfo.mSocialFeedInfo.d);
      return;
      label178:
      Object localObject1;
      if (ReadInJoyUtils.a((SocializeFeedsInfo.UGCFeedsInfo)localObject2))
      {
        List localList = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a;
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject3 = new ArrayList();
        int i = localList.size();
        localObject2 = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).jdField_a_of_type_JavaLangString;
        int j;
        label302:
        SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
        long l;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).startsWith(":")) || (((String)localObject2).startsWith("："))))
        {
          localObject1 = ((String)localObject2).substring(1);
          localStringBuilder.append((String)localObject1);
          j = localStringBuilder.length();
          i -= 2;
          if (i < 0) {
            break label510;
          }
          localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
          l = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
          localObject1 = ContactUtils.b((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(l), true);
          localObject2 = "@" + (String)localObject1;
          localObject1 = localObject2;
          if (localBiuCommentInfo.c == 1) {
            localObject1 = (String)localObject2 + " ";
          }
          if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
            break label500;
          }
        }
        label500:
        for (localObject2 = "";; localObject2 = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
        {
          localStringBuilder.append((String)localObject1).append((String)localObject2);
          localObject2 = new ComponentHeaderNewSocial.biuUserStruct();
          ((ComponentHeaderNewSocial.biuUserStruct)localObject2).jdField_a_of_type_Int = j;
          ((ComponentHeaderNewSocial.biuUserStruct)localObject2).b = (((String)localObject1).length() + j);
          ((ComponentHeaderNewSocial.biuUserStruct)localObject2).jdField_a_of_type_Long = l;
          ((List)localObject3).add(localObject2);
          j = localStringBuilder.length();
          i -= 1;
          break label302;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = "";
          break;
        }
        label510:
        localObject1 = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ComponentHeaderNewSocial.biuUserStruct)((Iterator)localObject2).next();
          ((SpannableStringBuilder)localObject1).setSpan(new ComponentHeaderUgc.UserSpan(this, ((ComponentHeaderNewSocial.biuUserStruct)localObject3).jdField_a_of_type_Long, -3355444), ((ComponentHeaderNewSocial.biuUserStruct)localObject3).jdField_a_of_type_Int, ((ComponentHeaderNewSocial.biuUserStruct)localObject3).b, 17);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText((CharSequence)localObject1);
      }
      else
      {
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCFeedsInfo)localObject2).jdField_a_of_type_JavaLangString))
        {
          localObject1 = null;
          try
          {
            localObject2 = MessageUtils.b(((SocializeFeedsInfo.UGCFeedsInfo)localObject2).jdField_a_of_type_JavaLangString);
            localObject1 = localObject2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("ComponentHeaderUgc", 1, "parse bytes_comments failed ", localException);
            }
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(new QQText((CharSequence)localObject1, 7, 16));
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
        continue;
        label690:
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
      }
    }
    if (localArticleInfo.mTime > 0L)
    {
      this.b.setText(ReadInJoyTimeUtils.a(localArticleInfo.mSocialFeedInfo.e, true));
      return;
    }
    this.b.setText("刚刚");
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969577, this, true);
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
    this.b = ((TextView)findViewById(2131366837));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365632));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366984));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366982));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    d();
    e();
    f();
    setFollowButton();
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
    case 2131366993: 
      a(a());
      return;
    }
    paramView = ReadInJoyUtils.a();
    if (paramView != null)
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      ReadInJoyBaseAdapter.a(localArticleInfo, "0X80080EC", "0X80080EC", 70);
      ReadInJoyLogicEngine.b(localArticleInfo);
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null))
      {
        long l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        ReadInJoyLogicEngine.a().a().a(paramView.getAccount(), String.valueOf(l), true, new lvv(this, localArticleInfo));
      }
    }
    c();
  }
  
  public void setFollowButton()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    if (localArticleInfo == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
    if (localSocializeFeedsInfo == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    if (localSocializeFeedsInfo.h == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
      this.jdField_a_of_type_AndroidWidgetButton.setText("关注");
      return;
    }
    if ((localArticleInfo.isNeedShowBtnWhenFollowed) && (localSocializeFeedsInfo.h == 2))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText("已关注");
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderUgc
 * JD-Core Version:    0.7.0.1
 */