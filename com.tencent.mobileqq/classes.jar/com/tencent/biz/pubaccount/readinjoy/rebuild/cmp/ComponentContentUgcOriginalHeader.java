package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actn;
import ajyc;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import axas;
import ayki;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import onk;
import pax;
import pqs;
import prb;
import pvb;
import pwv;
import pww;
import pwx;
import pxd;
import qcj;
import qdd;
import qdf;
import rap;

public class ComponentContentUgcOriginalHeader
  extends LinearLayout
  implements pqs
{
  private SpannableStringBuilder a;
  public ReadInJoyYAFolderTextView a;
  public pvb a;
  
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
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(onk.d((String)localObject1));
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(new pwx(this, l, -3355444), 0, this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length(), 33);
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(": ");
      if ((!pvb.c(paramArticleInfo)) || (rap.q(paramArticleInfo))) {
        break label199;
      }
      localObject1 = ((qdf)paramArticleInfo.mSocialFeedInfo.a.b.get(0)).e;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
      }
    }
    label325:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pww(this, paramArticleInfo, -3355444));
      return;
      localObject1 = ReadInJoyUserInfoModule.a();
      break;
      label199:
      if (onk.a(paramArticleInfo.mSocialFeedInfo.a))
      {
        List localList = paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Qcj.a;
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
            break label545;
          }
          localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
          l = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
          localObject1 = ReadInJoyUserInfoModule.a(l, null);
          if (localObject1 == null) {
            break label527;
          }
          localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
          label372:
          localObject2 = "@" + (String)localObject1;
          localObject1 = localObject2;
          if (localBiuCommentInfo.c == 1) {
            localObject1 = (String)localObject2 + " ";
          }
          if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
            break label535;
          }
        }
        for (localObject2 = "";; localObject2 = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
        {
          localStringBuilder.append((String)localObject1).append((String)localObject2);
          localObject2 = new pxd();
          ((pxd)localObject2).jdField_a_of_type_Int = j;
          ((pxd)localObject2).b = (((String)localObject1).length() + j);
          ((pxd)localObject2).jdField_a_of_type_Long = l;
          ((List)localObject3).add(localObject2);
          j = localStringBuilder.length();
          i -= 1;
          break label325;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = "";
          break;
          localObject1 = ReadInJoyUserInfoModule.a();
          break label372;
        }
        localObject1 = new SpannableStringBuilder(new ayki(localStringBuilder, 7, 16));
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (pxd)((Iterator)localObject2).next();
          ((SpannableStringBuilder)localObject1).setSpan(new pwx(this, ((pxd)localObject3).jdField_a_of_type_Long, -3355444), ((pxd)localObject3).jdField_a_of_type_Int, ((pxd)localObject3).b, 17);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
        }
      }
      else if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new ayki(axas.b((String)localObject2), 7, 16);
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_Pvb = new pvb();
    setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(actn.a(12.0F, paramContext.getResources()), actn.a(12.0F, paramContext.getResources()), actn.a(20.0F, paramContext.getResources()), 0);
    setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = new ReadInJoyYAFolderTextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(Color.parseColor("#606060"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextSize(2, 16.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(ajyc.a(2131702329));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pwv(this));
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pax))
    {
      this.jdField_a_of_type_Pvb.a((pax)paramObject);
      paramObject = ((pax)paramObject).a();
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
    } while ((!rap.m(paramObject)) || (!TextUtils.isEmpty(paramObject.businessName)));
    paramObject = (LinearLayout.LayoutParams)getLayoutParams();
    paramObject.bottomMargin = actn.a(12.0F, getContext().getResources());
    setLayoutParams(paramObject);
  }
  
  public void a(prb paramprb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcOriginalHeader
 * JD-Core Version:    0.7.0.1
 */