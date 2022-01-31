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
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.OnLastReadRefreshListener;
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
import lry;
import lrz;
import lsa;
import lsb;
import lsc;
import lsd;
import lse;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.CommentInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.FriendRecommendInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackJumpInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SpecialTopicInfo;

public class ReadInJoyFooterPresenter
  implements IReadInJoyPresenter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private ReadInJoyBaseAdapter.OnLastReadRefreshListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnLastReadRefreshListener;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private ReadInJoyView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView;
  
  public ReadInJoyFooterPresenter(Context paramContext, ReadInJoyBaseAdapter.OnLastReadRefreshListener paramOnLastReadRefreshListener, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnLastReadRefreshListener = paramOnLastReadRefreshListener;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public static List a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((oidb_cmd0x68b.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.get());
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
          a(paramInt, paramArticleInfo, (oidb_cmd0x68b.PackJumpInfo)localList.get(0));
        }
        if ((localList == null) || (localList.size() <= 1)) {
          break label213;
        }
        j = 1;
        i = 0;
        while (i < localList.size())
        {
          if (((oidb_cmd0x68b.PackJumpInfo)localList.get(i)).enum_style.get() != 2) {
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
      a(paramInt, paramArticleInfo, (oidb_cmd0x68b.PackJumpInfo)localList.get(0));
      label213:
      return;
    }
    a(paramInt, paramArticleInfo, localList);
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, List paramList)
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
      localObject1 = (oidb_cmd0x68b.PackJumpInfo)paramArticleInfo.next();
      i = paramInt;
      if (((oidb_cmd0x68b.PackJumpInfo)localObject1).enum_style.get() == 2)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(((oidb_cmd0x68b.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((oidb_cmd0x68b.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((oidb_cmd0x68b.PackJumpInfo)localObject1).str_wording.get();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(new lsd(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramArticleInfo.remove();
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((oidb_cmd0x68b.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramArticleInfo = ((oidb_cmd0x68b.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((oidb_cmd0x68b.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setOnClickListener(new lse(this, (String)localObject1, paramArticleInfo));
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, oidb_cmd0x68b.PackJumpInfo paramPackJumpInfo)
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
      paramArticleInfo = new lsb(this, paramPackJumpInfo);
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
    paramPackJumpInfo = new lsc(this, paramArticleInfo);
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
  
  public static List b(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((oidb_cmd0x68b.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.get());
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
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView = paramReadInJoyView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = paramIReadInJoyModel;
    paramIReadInJoyModel = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    if (paramIReadInJoyModel == null) {
      return;
    }
    label60:
    label206:
    label238:
    long l;
    label130:
    String str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.h != null)
    {
      paramReadInJoyView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.h;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.b())
      {
        paramInt = 0;
        paramReadInJoyView.setVisibility(paramInt);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.b())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.b();
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.d(), paramIReadInJoyModel);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.i != null)
      {
        paramReadInJoyView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.i;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.c()) {
          break label708;
        }
        paramInt = 0;
        paramReadInJoyView.setVisibility(paramInt);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.c())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.c.setText(paramIReadInJoyModel.mArticleFriendLikeText);
      }
      switch (paramIReadInJoyModel.mCommentIconType)
      {
      default: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.c.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.j != null)
        {
          paramReadInJoyView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.j;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.d())
          {
            paramInt = 0;
            paramReadInJoyView.setVisibility(paramInt);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.d())
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d();
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.j.setOnClickListener(null);
            paramReadInJoyView = (oidb_cmd0x68b.CommentInfo)paramIReadInJoyModel.mCommentsObj.get(0);
            l = paramReadInJoyView.uint64_uin.get();
            str2 = paramReadInJoyView.str_content.get();
            String str1 = paramReadInJoyView.str_jump_url.get();
            if (!ReadInJoyUtils.a()) {
              break label751;
            }
            paramReadInJoyView = ContactUtils.l((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(l));
            label335:
            String str3 = ReadInJoyUtils.d(paramReadInJoyView);
            if (str3 == null) {
              break label764;
            }
            paramReadInJoyView = new SpannableString(str3 + ":  " + str2);
            paramReadInJoyView.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492923)), 0, str3.length(), 33);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d.setText(str3 + ":  ");
            label454:
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.e.setText(paramReadInJoyView);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.e.setOnClickListener(new lry(this, str1, paramIReadInJoyModel));
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d.setOnClickListener(new lrz(this, l, paramIReadInJoyModel));
            if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.f()) {
              break label789;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.k.setVisibility(0);
          }
          label530:
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.l != null)
          {
            paramReadInJoyView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.l;
            if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.e()) {
              break label804;
            }
            paramInt = 0;
            label562:
            paramReadInJoyView.setVisibility(paramInt);
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.e())
          {
            paramReadInJoyView = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.l.getLayoutParams();
            UtilsForComponent.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel, paramReadInJoyView);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.l.setLayoutParams(paramReadInJoyView);
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.m != null)
          {
            paramReadInJoyView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.m;
            if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.g()) {
              break label810;
            }
          }
        }
        break;
      }
    }
    label789:
    label804:
    label810:
    for (paramInt = i;; paramInt = 8)
    {
      paramReadInJoyView.setVisibility(paramInt);
      if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.g()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.a())) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.m.setOnClickListener(new lsa(this));
      ReadInJoyLogicEngineEventDispatcher.a().a(null);
      return;
      paramInt = 8;
      break label60;
      label708:
      paramInt = 8;
      break label130;
      paramReadInJoyView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839756);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.c.setCompoundDrawablesWithIntrinsicBounds(paramReadInJoyView, null, null, null);
      break label206;
      paramInt = 8;
      break label238;
      label751:
      paramReadInJoyView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(l);
      break label335;
      label764:
      paramReadInJoyView = new SpannableString(str2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.d.setVisibility(8);
      break label454;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.k.setVisibility(8);
      break label530;
      paramInt = 8;
      break label562;
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter
 * JD-Core Version:    0.7.0.1
 */