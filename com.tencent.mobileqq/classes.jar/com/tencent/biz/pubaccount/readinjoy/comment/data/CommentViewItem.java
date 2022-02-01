package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class CommentViewItem
{
  public int a;
  public SpannableStringBuilder a;
  public BaseCommentData a;
  public ArticleInfo a;
  public CharSequence a;
  public List<SpannableStringBuilder> a;
  public boolean a;
  public int b;
  public List<CharSequence> b;
  public boolean b;
  public int c;
  public List<CharSequence> c;
  private int d = 18;
  
  public CommentViewItem(int paramInt1, int paramInt2, BaseCommentData paramBaseCommentData, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData = paramBaseCommentData;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_b_of_type_Int = paramInt1;
    if ((paramBaseCommentData != null) && (paramBaseCommentData.isAuthorSticky))
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if ((paramBaseCommentData == null) || (!paramBaseCommentData.isAuthorBottom)) {
        break label101;
      }
    }
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      a();
      return;
      bool1 = false;
      break;
    }
  }
  
  public CommentViewItem(int paramInt, BaseCommentData paramBaseCommentData, ArticleInfo paramArticleInfo)
  {
    this(0, paramInt, paramBaseCommentData, paramArticleInfo);
  }
  
  private CharSequence a(SubCommentData paramSubCommentData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramSubCommentData.hasTarget())
    {
      localSpannableStringBuilder.append("回复 ");
      int i = localSpannableStringBuilder.length();
      if (!TextUtils.isEmpty(paramSubCommentData.repliedUserNickname))
      {
        localSpannableStringBuilder.append(paramSubCommentData.repliedUserNickname);
        localSpannableStringBuilder.setSpan(new CommentViewItem.3(this, paramSubCommentData), i, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append("：");
      }
    }
    String str = EmotionCodecUtils.b(paramSubCommentData.getWholeStringContent());
    paramSubCommentData = str;
    if (localSpannableStringBuilder.length() > 0) {
      paramSubCommentData = localSpannableStringBuilder.append(str);
    }
    return paramSubCommentData;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return HardCodeUtil.a(2131702268);
    }
    return HardCodeUtil.a(2131702270);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (BaseActivity.sTopActivity == null)
    {
      QLog.d("CommentViewItem", 1, "setAuthorText | sTopActivity is null");
      return;
    }
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.setSpan(new CommentViewItem.CustomImageSpan(this, BaseActivity.sTopActivity, 2130849747, 2, ViewUtils.a(32.0F), ViewUtils.a(15.0F)), i, paramSpannableStringBuilder.length(), 17);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, SubCommentData paramSubCommentData)
  {
    if (!TextUtils.isEmpty(paramSubCommentData.nickName))
    {
      paramSpannableStringBuilder.append(paramSubCommentData.nickName);
      paramSpannableStringBuilder.setSpan(new CommentViewItem.1(this, paramSubCommentData), 0, paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, String paramString3, BaseCommentData paramBaseCommentData)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(paramString1);
    paramSpannableStringBuilder.setSpan(new CommentViewItem.4(this, paramBaseCommentData, paramString2, paramString3), i, paramSpannableStringBuilder.length(), 33);
  }
  
  private void a(SubCommentData paramSubCommentData)
  {
    if (!TextUtils.isEmpty(paramSubCommentData.getWholeStringContent()))
    {
      String str = a(paramSubCommentData.getCommentMediaType());
      paramSubCommentData = new QQText(EmotionCodecUtils.b(paramSubCommentData.getWholeStringContent()) + str, 7, this.d);
      this.jdField_b_of_type_JavaUtilList.add(paramSubCommentData);
    }
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.setSpan(new CommentViewItem.CustomImageSpan(this, BaseActivity.sTopActivity, 2130849752, 2, ViewUtils.a(51.0F), ViewUtils.a(15.0F)), i, paramSpannableStringBuilder.length(), 17);
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder, SubCommentData paramSubCommentData)
  {
    if ((paramSubCommentData.hasTarget()) && (!TextUtils.isEmpty(paramSubCommentData.repliedUserNickname)))
    {
      paramSpannableStringBuilder.append(" 回复 ");
      int i = paramSpannableStringBuilder.length();
      paramSpannableStringBuilder.append(paramSubCommentData.repliedUserNickname);
      paramSpannableStringBuilder.setSpan(new CommentViewItem.2(this, paramSubCommentData), i, paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (this.jdField_b_of_type_JavaUtilList != null) {
        break label67;
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      if (this.jdField_c_of_type_JavaUtilList != null) {
        break label79;
      }
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label67:
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    label79:
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  private void d()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.getWholeStringContent()))
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
        this.jdField_a_of_type_JavaLangCharSequence = new QQText(EmotionCodecUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.getWholeStringContent()), 3, this.d);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = new QQText(a((SubCommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData), 3, this.d);
  }
  
  private void e()
  {
    List localList;
    int i;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
    {
      localList = ((CommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList;
      if ((localList != null) && (localList.size() > 0))
      {
        int j = localList.size();
        i = 0;
        if ((i < j) && (i < 2)) {
          break label54;
        }
      }
    }
    return;
    label54:
    SubCommentData localSubCommentData = (SubCommentData)localList.get(i);
    if (localSubCommentData == null) {}
    for (;;)
    {
      i += 1;
      break;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      a(localSpannableStringBuilder, localSubCommentData);
      b(localSpannableStringBuilder, localSubCommentData);
      this.jdField_a_of_type_JavaUtilList.add(localSpannableStringBuilder);
      a(localSubCommentData);
    }
  }
  
  private void f()
  {
    List localList;
    int i;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
    {
      localList = ((CommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList;
      if ((localList != null) && (localList.size() > 0))
      {
        int j = localList.size();
        i = 0;
        if ((i < j) && ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() <= 2))) {
          break label69;
        }
      }
    }
    return;
    label69:
    SubCommentData localSubCommentData = (SubCommentData)localList.get(i);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(localSubCommentData.nickName)) {
      a(localSpannableStringBuilder, localSubCommentData.nickName, localSubCommentData.uin, new CommentReportR5Builder(this).a().a(), localSubCommentData);
    }
    if (localSubCommentData.isAuthorReply()) {
      a(localSpannableStringBuilder);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localSubCommentData.repliedUserNickname))
      {
        localSpannableStringBuilder.append(" 回复 ");
        a(localSpannableStringBuilder, localSubCommentData.repliedUserNickname, localSubCommentData.repliedUserUin, new CommentReportR5Builder(this).a().b(localSubCommentData.repliedUserUin).a(), localSubCommentData);
      }
      if (!TextUtils.isEmpty(localSubCommentData.getWholeStringContent()))
      {
        localSpannableStringBuilder.append(": ");
        String str = a(localSubCommentData.getCommentMediaType());
        localSpannableStringBuilder.append(new QQText(EmotionCodecUtils.b(localSubCommentData.getWholeStringContent()) + str, 7, this.d));
        this.jdField_c_of_type_JavaUtilList.add(localSpannableStringBuilder);
      }
      i += 1;
      break;
      if (localSubCommentData.isFollowing) {
        b(localSpannableStringBuilder);
      }
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAd) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo == null)) {}
    do
    {
      return;
      AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo;
      if (!TextUtils.isEmpty(localAdvertisementInfo.mAdTxt)) {
        this.jdField_a_of_type_JavaLangCharSequence = new QQText(EmotionCodecUtils.b(localAdvertisementInfo.mAdTxt), 3, this.d);
      }
      if (this.jdField_c_of_type_JavaUtilList != null) {
        this.jdField_c_of_type_JavaUtilList.clear();
      }
    } while (this.jdField_a_of_type_JavaUtilList == null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return;
    }
    c();
    d();
    e();
    f();
    g();
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) || ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0));
  }
  
  public void b()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    localObject = ((QQAppInterface)localObject).getAccount();
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.uin;
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.avatarPendantUrl;
    CommentViewItem.5 local5 = new CommentViewItem.5(this);
    if (RIJItemViewType.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {}
    for (int i = 2;; i = 1)
    {
      localUserOperationModule.a((String)localObject, str1, true, str2, local5, i);
      ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, ReadinjoyReportUtils.g, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem
 * JD-Core Version:    0.7.0.1
 */