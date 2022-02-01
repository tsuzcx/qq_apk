package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnLastReadRefreshListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ReadInJoyFooterPresenter
  implements IReadInJoyPresenter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private OnLastReadRefreshListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokOnLastReadRefreshListener;
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private ReadInJoyView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView;
  
  public ReadInJoyFooterPresenter(Context paramContext, OnLastReadRefreshListener paramOnLastReadRefreshListener, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokOnLastReadRefreshListener = paramOnLastReadRefreshListener;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public static List<articlesummary.PackJumpInfo> a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyFooterPresenter", 1, "ReadInJoyFooter special topic link list empty");
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
  
  private void a(int paramInt, ArticleInfo paramArticleInfo)
  {
    int i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(null);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.h.setOnClickListener(null);
    switch (paramInt)
    {
    }
    List localList;
    int j;
    for (;;)
    {
      localList = null;
      for (;;)
      {
        if ((localList != null) && (localList.size() == 1)) {
          a(paramInt, paramArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
        }
        if ((localList == null) || (localList.size() <= 1)) {
          break label213;
        }
        j = 1;
        i = 0;
        while (i < localList.size())
        {
          if (((articlesummary.PackJumpInfo)localList.get(i)).enum_style.get() != 2) {
            j = 0;
          }
          i += 1;
        }
        localList = a(paramArticleInfo);
        continue;
        localList = b(paramArticleInfo);
      }
      a(paramInt, paramArticleInfo, null);
    }
    if (j != 0)
    {
      a(paramInt, paramArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
      label213:
      return;
    }
    a(paramInt, paramArticleInfo, localList);
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, List<articlesummary.PackJumpInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.h.setOnClickListener(null);
    paramInt = 0;
    while (paramInt < 3)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(8);
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(8);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
    paramArticleInfo = paramList.iterator();
    Object localObject1;
    int i;
    for (paramInt = 0; paramArticleInfo.hasNext(); paramInt = i)
    {
      localObject1 = (articlesummary.PackJumpInfo)paramArticleInfo.next();
      i = paramInt;
      if (((articlesummary.PackJumpInfo)localObject1).enum_style.get() == 2)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(new ReadInJoyFooterPresenter.6(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramArticleInfo.remove();
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setOnClickListener(new ReadInJoyFooterPresenter.7(this, (String)localObject1, paramArticleInfo));
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      if ((i - 1 >= 0) && (i - 1 <= 1)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidViewView[(i - 1)].setVisibility(8);
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
    case 3: 
      paramArticleInfo = new ReadInJoyFooterPresenter.4(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramPackJumpInfo.str_wording.get());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramArticleInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.h.setOnClickListener(paramArticleInfo);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setText(paramPackJumpInfo.str_wording.get());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setOnClickListener(paramArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.h.setOnClickListener(paramArticleInfo);
      return;
    }
    paramPackJumpInfo = new ReadInJoyFooterPresenter.5(this, paramArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramArticleInfo.mChannelInfoDisplayName);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramPackJumpInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.h.setOnClickListener(paramPackJumpInfo);
  }
  
  public static void a(int paramInt, String paramString) {}
  
  private void a(ArticleInfo paramArticleInfo)
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.h != null)
    {
      localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.h;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.b()) {
        break label71;
      }
    }
    label71:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.b())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.b();
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.d(), paramArticleInfo);
      }
      return;
    }
  }
  
  public static List<articlesummary.PackJumpInfo> b(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyFooterPresenter", 1, "ReadInJoyFooter friend recommend link list empty");
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
  
  private void b(ArticleInfo paramArticleInfo)
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.i != null)
    {
      localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.i;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.c()) {
        break label107;
      }
    }
    label107:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.c())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.c.setText(paramArticleInfo.mArticleFriendLikeText);
      }
      switch (paramArticleInfo.mCommentIconType)
      {
      default: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.c.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
    }
    paramArticleInfo = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841959);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.c.setCompoundDrawablesWithIntrinsicBounds(paramArticleInfo, null, null, null);
  }
  
  private void c(ArticleInfo paramArticleInfo)
  {
    Object localObject;
    int i;
    long l;
    String str2;
    String str1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.j != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.d())
      {
        i = 0;
        ((View)localObject).setVisibility(i);
      }
    }
    else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.d())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.j.setOnClickListener(null);
      localObject = (articlesummary.CommentInfo)paramArticleInfo.mCommentsObj.get(0);
      l = ((articlesummary.CommentInfo)localObject).uint64_uin.get();
      str2 = ((articlesummary.CommentInfo)localObject).str_content.get();
      str1 = ((articlesummary.CommentInfo)localObject).str_jump_url.get();
      if (!RIJQQAppInterfaceUtil.a()) {
        break label339;
      }
      localObject = ContactUtils.j((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(l));
      label134:
      String str3 = RIJStringUtils.a((String)localObject);
      if (str3 == null) {
        break label352;
      }
      localObject = new SpannableString(str3 + ":  " + str2);
      ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167305)), 0, str3.length(), 33);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d.setText(str3 + ":  ");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.e.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.e.setOnClickListener(new ReadInJoyFooterPresenter.1(this, str1, paramArticleInfo));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d.setOnClickListener(new ReadInJoyFooterPresenter.2(this, l, paramArticleInfo));
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.f()) {
        break label378;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.k.setVisibility(0);
      return;
      i = 8;
      break;
      label339:
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(l);
      break label134;
      label352:
      localObject = new SpannableString(str2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d.setVisibility(8);
    }
    label378:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.k.setVisibility(8);
  }
  
  private void d(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.l != null)
    {
      paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.l;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.e()) {
        break label94;
      }
    }
    label94:
    for (int i = 0;; i = 8)
    {
      paramArticleInfo.setVisibility(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.e())
      {
        paramArticleInfo = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.l.getLayoutParams();
        UtilsForComponent.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.l);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.l.setLayoutParams(paramArticleInfo);
      }
      return;
    }
  }
  
  private void e(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.m != null)
    {
      paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.m;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.g()) {
        break label85;
      }
    }
    label85:
    for (int i = 0;; i = 8)
    {
      paramArticleInfo.setVisibility(i);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.g()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.a()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.m.setOnClickListener(new ReadInJoyFooterPresenter.3(this));
        ReadInJoyLogicEngineEventDispatcher.a().a(null);
      }
      return;
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView = paramReadInJoyView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = paramIReadInJoyModel;
    paramReadInJoyView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    if (paramReadInJoyView == null) {
      return;
    }
    a(paramReadInJoyView);
    b(paramReadInJoyView);
    c(paramReadInJoyView);
    d(paramReadInJoyView);
    e(paramReadInJoyView);
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter
 * JD-Core Version:    0.7.0.1
 */