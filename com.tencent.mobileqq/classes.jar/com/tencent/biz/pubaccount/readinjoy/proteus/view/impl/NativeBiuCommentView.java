package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeBiuCommentView
  extends ReadInJoyYAFolderTextView
  implements IView
{
  private final int jdField_a_of_type_Int = -16777216;
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
  
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    setSpannableFactory(QQText.a);
    setTextColor(-16777216);
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel)
  {
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    if ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null)) {}
    label260:
    label451:
    label461:
    do
    {
      return;
      paramIReadInJoyModel = localArticleInfo.mSocialFeedInfo;
      if ((paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a != null) && (paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.size() > 0) && ((paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.get(0)).jdField_a_of_type_JavaLangString, "：")))))
      {
        List localList = paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a;
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2 = new ArrayList();
        int i = localList.size();
        Object localObject1 = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).jdField_a_of_type_JavaLangString;
        int j;
        SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
        long l;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith(":")) || (((String)localObject1).startsWith("："))))
        {
          paramIReadInJoyModel = ((String)localObject1).substring(1);
          localStringBuilder.append(paramIReadInJoyModel);
          j = localStringBuilder.length();
          i -= 2;
          if (i < 0) {
            break label461;
          }
          localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
          l = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
          paramIReadInJoyModel = ContactUtils.b((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(l), true);
          localObject1 = "@" + paramIReadInJoyModel;
          paramIReadInJoyModel = (IReadInJoyModel)localObject1;
          if (localBiuCommentInfo.c == 1) {
            paramIReadInJoyModel = (String)localObject1 + " ";
          }
          if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
            break label451;
          }
        }
        for (localObject1 = "";; localObject1 = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
        {
          localStringBuilder.append(paramIReadInJoyModel).append((String)localObject1);
          localObject1 = new NativeBiuCommentView.BiuUserStruct();
          ((NativeBiuCommentView.BiuUserStruct)localObject1).jdField_a_of_type_Int = j;
          ((NativeBiuCommentView.BiuUserStruct)localObject1).b = (paramIReadInJoyModel.length() + j);
          ((NativeBiuCommentView.BiuUserStruct)localObject1).jdField_a_of_type_Long = l;
          ((List)localObject2).add(localObject1);
          j = localStringBuilder.length();
          i -= 1;
          break label260;
          paramIReadInJoyModel = (IReadInJoyModel)localObject1;
          if (localObject1 != null) {
            break;
          }
          paramIReadInJoyModel = "";
          break;
        }
        paramIReadInJoyModel = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (NativeBiuCommentView.BiuUserStruct)((Iterator)localObject1).next();
          paramIReadInJoyModel.setSpan(new NativeBiuCommentView.UserSpan(this, ((NativeBiuCommentView.BiuUserStruct)localObject2).jdField_a_of_type_Long, -3355444), ((NativeBiuCommentView.BiuUserStruct)localObject2).jdField_a_of_type_Int, ((NativeBiuCommentView.BiuUserStruct)localObject2).b, 17);
        }
        setMaxLines(7);
        setSpanText("更多");
        setMoreSpan(new NativeBiuCommentView.MoreSpan(this, localArticleInfo, -3355444));
        setText(paramIReadInJoyModel);
        return;
      }
    } while (TextUtils.isEmpty(paramIReadInJoyModel.jdField_a_of_type_JavaLangString));
    if (paramIReadInJoyModel.jdField_a_of_type_JavaLangString.length() >= 100) {
      paramIReadInJoyModel.jdField_a_of_type_JavaLangString = (paramIReadInJoyModel.jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
    }
    setText(paramIReadInJoyModel.jdField_a_of_type_JavaLangString);
  }
  
  public int a()
  {
    return getMeasuredWidth();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = ReadInJoyConstants.f + Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    ReadInJoyUtils.a(getContext(), (String)localObject1);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    ReadInJoyUtils.a = localArticleInfo;
    localObject1 = "";
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", ReadInJoyUtils.d);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i())
        {
          CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
          if (!CmpCtxt.a(localArticleInfo)) {
            continue;
          }
        }
        ((JSONObject)localObject2).put("feeds_source", String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long));
        ((JSONObject)localObject2).put("rowkey", localArticleInfo.innerUniqueID);
        ((JSONObject)localObject2).put("feeds_type", "" + ReadInJoyUtils.a(localArticleInfo));
        ((JSONObject)localObject2).put("kandian_mode", "" + ReadInJoyUtils.e());
        ((JSONObject)localObject2).put("tab_source", "" + ReadInJoyUtils.d());
        ((JSONObject)localObject2).put("entry_mode", "1");
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        localJSONException.printStackTrace();
        continue;
        PublicAccountReportUtils.a(null, localArticleInfo.mSubscribeID, "0X8007BA3", "0X8007BA3", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mArticleID), "", (String)localObject1, false);
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
      if (!CmpCtxt.a(localArticleInfo)) {
        continue;
      }
      PublicAccountReportUtils.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007BA3", "0X8007BA3", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mFeedId), "0", "", (String)localObject1, false);
      ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      return;
      ((JSONObject)localObject2).put("feeds_source", "");
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int b()
  {
    return getMeasuredHeight();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramIReadInJoyModel);
    a(paramIReadInJoyModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */