package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.KandianNegativeWindow;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ReadInJoyHeaderPresenter
  implements View.OnClickListener, IReadInJoyPresenter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private ReadInJoyView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private KandianNegativeWindow jdField_a_of_type_ComTencentWidgetKandianNegativeWindow;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  
  public ReadInJoyHeaderPresenter(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, ListView paramListView, KandianNegativeWindow paramKandianNegativeWindow)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow = paramKandianNegativeWindow;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  private String a(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic title empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private URL a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo.mHeaderIconUrl == null) {
      try
      {
        String str = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_icon_url.get();
        if (TextUtils.isEmpty(str)) {
          QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic icon url empty");
        }
        if (TextUtils.isEmpty(str)) {
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject = null;
        }
        Object localObject = RIJPreParseData.a((String)localObject);
        paramArticleInfo.mHeaderIconUrl = ((URL)localObject);
        return localObject;
      }
    }
    return paramArticleInfo.mHeaderIconUrl;
  }
  
  private List<Long> a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend uin list empty");
      }
      return localArrayList;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  private void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131381651);
      ReadInJoyView localReadInJoyView = (ReadInJoyView)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131381656);
      if ((localIReadInJoyModel != null) && (localReadInJoyView != null) && (paramIReadInJoyModel.a().mGroupId == localIReadInJoyModel.a().mGroupId))
      {
        localArrayList1.add(localReadInJoyView);
        localArrayList2.add(localIReadInJoyModel);
      }
      i += 1;
    }
    paramReadInJoyView = new ReadInJoyHeaderPresenter.3(this, paramReadInJoyView, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    if (paramInt < localArrayList1.size())
    {
      paramIReadInJoyModel = (Animation)((ReadInJoyView)localArrayList1.get(paramInt)).a().getTag(2131369928);
      if (paramInt != 0) {
        paramIReadInJoyModel.setAnimationListener(null);
      }
      for (;;)
      {
        ((ReadInJoyView)localArrayList1.get(paramInt)).a().startAnimation(paramIReadInJoyModel);
        paramInt += 1;
        break;
        paramIReadInJoyModel.setAnimationListener(paramReadInJoyView);
      }
    }
  }
  
  private void a(String paramString)
  {
    label102:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", RIJAppSetting.a());
        paramString = "0X800744D";
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel != null)
        {
          if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.e()))
          {
            paramString = "0X8009357";
            break label102;
          }
        }
        else
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
          return;
        }
        paramString = "0X800744D";
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  private void a(boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    int k = 8;
    int i;
    label90:
    label123:
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = a(paramArticleInfo);
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.c.setVisibility(0);
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (!paramBoolean) {
          break label205;
        }
        i = 8;
        ((KandianUrlImageView)localObject1).setVisibility(i);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView;
        int m = localObject1.length;
        i = 0;
        if (i >= m) {
          break label217;
        }
        localObject2 = localObject1[i];
        if (!paramBoolean) {
          break label210;
        }
      }
    }
    label205:
    label210:
    for (int j = 0;; j = 8)
    {
      localObject2.setVisibility(j);
      i += 1;
      break label123;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 0);
      break;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      break;
      i = 0;
      break label90;
    }
    label217:
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {
      if (a(paramArticleInfo).size() == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_b_of_type_AndroidWidgetTextView;
      i = k;
      if (paramBoolean) {
        i = 0;
      }
      paramArticleInfo.setVisibility(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d.setVisibility(0);
      return;
      i = 8;
      continue;
      i = 0;
    }
  }
  
  private String b(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_jump_url.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic url empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private String c(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend description empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel)
  {
    paramReadInJoyView = paramIReadInJoyModel.a();
    paramIReadInJoyModel = a(paramReadInJoyView);
    int i = 0;
    if (i < Math.min(4, paramIReadInJoyModel.size()))
    {
      if (RIJQQAppInterfaceUtil.a()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, String.valueOf(paramIReadInJoyModel.get(i)), 1));
      }
      for (;;)
      {
        String str = String.valueOf(paramIReadInJoyModel.get(i));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setOnClickListener(new ReadInJoyHeaderPresenter.2(this, str, paramReadInJoyView));
        i += 1;
        break;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(((Long)paramIReadInJoyModel.get(i)).longValue()));
      }
    }
    i = Math.min(4, paramIReadInJoyModel.size());
    while (i < 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setVisibility(8);
      i += 1;
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView = paramReadInJoyView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = paramIReadInJoyModel;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a()) {
        break label179;
      }
    }
    label179:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.a();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.c() != 3) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.f.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.g != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.g.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setLogic(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramIReadInJoyModel);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidViewView.setVisibility(0);
    switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.c())
    {
    default: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d.setOnClickListener(new ReadInJoyHeaderPresenter.1(this, paramIReadInJoyModel, paramReadInJoyView));
      return;
    case 1: 
      this.jdField_a_of_type_Boolean = false;
      a(false, localArticleInfo);
      localObject = a(localArticleInfo);
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.c.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.setText(a(localArticleInfo));
        break;
        ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (URL)localObject, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(true, localArticleInfo);
    a(paramReadInJoyView, paramIReadInJoyModel);
    Object localObject = a(localArticleInfo);
    if (((List)localObject).size() == 1) {
      if (!RIJQQAppInterfaceUtil.a()) {
        break label447;
      }
    }
    label447:
    for (localObject = ContactUtils.j((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(((List)localObject).get(0)));; localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(((Long)((List)localObject).get(0)).longValue()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.setText(RIJStringUtils.a((String)localObject));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_b_of_type_AndroidWidgetTextView.setText(c(localArticleInfo));
      break;
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.c() == 3) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramLong, paramBitmap);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.c() != 2) || (!RIJQQAppInterfaceUtil.a()));
      paramReadInJoyView = a(paramIReadInJoyModel.a());
    } while ((paramReadInJoyView.size() <= 0) || (!paramReadInJoyView.contains(Long.valueOf(paramLong))));
    int i = paramReadInJoyView.indexOf(Long.valueOf(paramLong));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(RIJFeedsType.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a()));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a());
        if ((localObject != null) && (((List)localObject).size() == 1))
        {
          localObject = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(((List)localObject).get(0)).getBytes(), 2);
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
        }
      }
      else
      {
        localObject = b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
          continue;
          if (!this.jdField_a_of_type_Boolean)
          {
            localObject = b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a());
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
            }
          }
          else
          {
            localObject = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a());
            if (!((List)localObject).isEmpty())
            {
              localObject = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(((List)localObject).get(0)).getBytes(), 2);
              ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyHeaderPresenter
 * JD-Core Version:    0.7.0.1
 */