package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lyv;

public class ComponentContentUgcOriginalHeader
  extends LinearLayout
  implements ComponentView
{
  private SpannableStringBuilder jdField_a_of_type_AndroidTextSpannableStringBuilder;
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  private ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView;
  
  public ComponentContentUgcOriginalHeader(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ComponentContentUgcOriginalHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    long l = paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Long;
    Object localObject2 = paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaLangString;
    Object localObject1 = ReadInJoyUserInfoModule.a(l, null);
    if (localObject1 != null)
    {
      localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(ReadInJoyUtils.e((String)localObject1));
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(new ComponentContentUgcOriginalHeader.UserSpan(this, l, -3355444), 0, this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length(), 33);
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(": ");
      if ((!CmpCtxt.c(paramArticleInfo)) || (ReadInJoyBaseAdapter.o(paramArticleInfo))) {
        break label201;
      }
      localObject1 = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.a.b.get(0)).e;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
      }
    }
    label327:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new ComponentContentUgcOriginalHeader.MoreSpan(this, paramArticleInfo, -3355444));
      return;
      localObject1 = String.valueOf(l);
      break;
      label201:
      if (ReadInJoyUtils.a(paramArticleInfo.mSocialFeedInfo.a))
      {
        List localList = paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a;
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject3 = new ArrayList();
        int i = localList.size();
        localObject2 = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).jdField_a_of_type_JavaLangString;
        int j;
        SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).startsWith(":")) || (((String)localObject2).startsWith("："))))
        {
          localObject1 = ((String)localObject2).substring(1);
          localStringBuilder.append((String)localObject1);
          j = localStringBuilder.length();
          i -= 2;
          if (i < 0) {
            break label549;
          }
          localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
          l = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
          localObject1 = ReadInJoyUserInfoModule.a(l, null);
          if (localObject1 == null) {
            break label529;
          }
          localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
          label374:
          localObject2 = "@" + (String)localObject1;
          localObject1 = localObject2;
          if (localBiuCommentInfo.c == 1) {
            localObject1 = (String)localObject2 + " ";
          }
          if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
            break label539;
          }
        }
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
          break label327;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = "";
          break;
          localObject1 = String.valueOf(l);
          break label374;
        }
        localObject1 = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ComponentHeaderNewSocial.biuUserStruct)((Iterator)localObject2).next();
          ((SpannableStringBuilder)localObject1).setSpan(new ComponentContentUgcOriginalHeader.UserSpan(this, ((ComponentHeaderNewSocial.biuUserStruct)localObject3).jdField_a_of_type_Long, -3355444), ((ComponentHeaderNewSocial.biuUserStruct)localObject3).jdField_a_of_type_Int, ((ComponentHeaderNewSocial.biuUserStruct)localObject3).b, 17);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
        }
      }
      else if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new QQText(MessageUtils.b((String)localObject2), 7, 16);
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(AIOUtils.a(12.0F, paramContext.getResources()), AIOUtils.a(12.0F, paramContext.getResources()), AIOUtils.a(20.0F, paramContext.getResources()), 0);
    setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = new ReadInJoyYAFolderTextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(Color.parseColor("#606060"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextSize(2, 16.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText("更多");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new lyv(this));
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a((IReadInJoyModel)paramObject);
      paramObject = ((IReadInJoyModel)paramObject).a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.a != null)) {
        break label66;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcOriginalHeader", 2, "article info is null");
      }
    }
    label66:
    do
    {
      return;
      a(paramObject);
    } while ((!ReadInJoyBaseAdapter.k(paramObject)) || (!TextUtils.isEmpty(paramObject.businessName)));
    paramObject = (LinearLayout.LayoutParams)getLayoutParams();
    paramObject.bottomMargin = AIOUtils.a(12.0F, getContext().getResources());
    setLayoutParams(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcOriginalHeader
 * JD-Core Version:    0.7.0.1
 */