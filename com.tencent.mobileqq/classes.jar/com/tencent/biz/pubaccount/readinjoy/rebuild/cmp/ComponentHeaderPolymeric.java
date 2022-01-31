package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aciy;
import ajjy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import avwf;
import azue;
import azvv;
import baaw;
import bbmy;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import ndn;
import obb;
import oby;
import obz;
import ogy;
import ohb;
import ohe;
import opw;
import oqh;
import oqv;
import org.json.JSONObject;
import pfh;
import pjg;
import plj;
import plk;
import pll;
import plm;
import pln;
import ppz;
import pqo;
import qoe;
import rvf;

public class ComponentHeaderPolymeric
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  protected ohe a;
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public ComponentHeaderPolymeric(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Ohe = new pln(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Ohe = new pln(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Ohe = new pln(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      a(false);
      bbmy.a(getContext(), ajjy.a(2131636526), 0).a();
    }
    while (paramInt != 2) {
      return;
    }
    a(true);
    bbmy.a(getContext(), ajjy.a(2131636531), 0).a();
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    paramArticleInfo.mPolymericInfo.e = paramInt;
    Object localObject = ((BaseArticleInfo)paramArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).h = paramInt;
    }
    localObject = ohb.a();
    long l = paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
    if (paramArticleInfo.mPolymericInfo.e == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((ohb)localObject).b(l, bool);
      ThreadManager.post(new ComponentHeaderPolymeric.5(this, paramArticleInfo, paramInt), 5, null, true);
      return;
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    ndn.a(null, "CliOper", "", "", "0X8008F55", "0X8008F55", 0, 0, "", "", "", obz.a(paramBaseArticleInfo.mPolymericInfo).toString(), false);
    if (obz.j(paramBaseArticleInfo))
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
      String str1 = rvf.a(getContext(), localBaseArticleInfo.mArticleID, localBaseArticleInfo.mAlgorithmID, 54, this.jdField_a_of_type_Qoe.a(), localBaseArticleInfo.getInnerUniqueID(), localBaseArticleInfo.getVideoVid(), rvf.a(localBaseArticleInfo), localBaseArticleInfo.videoReportInfo);
      String str2 = rvf.b(paramBaseArticleInfo.mChannelID);
      ndn.a(null, "CliOper", "", String.valueOf(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long), str2, str2, 0, 0, Long.toString(localBaseArticleInfo.mFeedId), String.valueOf(localBaseArticleInfo.mArticleID), Integer.toString(localBaseArticleInfo.mStrategyId), str1, false);
      return;
    }
    qoe.a((ArticleInfo)paramBaseArticleInfo, this.jdField_a_of_type_Qoe.a());
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString, ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followUGCAccount followUin = " + paramString + ", followStatus = " + paramArticleInfo.mPolymericInfo.e + ", articleInfoID = " + paramArticleInfo.mArticleID);
    }
    oqv localoqv = ogy.a().a();
    paramAppRuntime = paramAppRuntime.getAccount();
    if (paramArticleInfo.mPolymericInfo.e != 2) {}
    for (boolean bool = true;; bool = false)
    {
      localoqv.a(paramAppRuntime, paramString, bool, new plj(this, paramArticleInfo), 2);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setBackgroundResource(2130848120);
      this.c.setText(ajjy.a(2131636465));
      this.c.setTextColor(-2147483648);
      this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    this.c.setBackgroundResource(2130848119);
    this.c.setText(ajjy.a(2131636502));
    this.c.setTextColor(-1);
    this.c.setCompoundDrawablePadding(aciy.a(3.0F, getResources()));
    this.c.setCompoundDrawablesWithIntrinsicBounds(2130848117, 0, 0, 0);
  }
  
  private void b(AppRuntime paramAppRuntime, String paramString, ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPGCAccount followUin = " + paramString + ", followStatus = " + paramArticleInfo.mPolymericInfo.e + ", articleInfoID = " + paramArticleInfo.mArticleID);
    }
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (paramArticleInfo.mPolymericInfo.e != 1) {
        break label124;
      }
      ogy.a().a().a(paramAppRuntime.getAccount(), paramString, true, new plk(this, paramArticleInfo), 1);
    }
    label124:
    while (paramArticleInfo.mPolymericInfo.e != 2)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ComponentHeaderPolymeric", 2, "followPGCAccount fail, appInterface is null!");
      return;
    }
    ogy.a().a().a(paramAppRuntime.getAccount(), paramString, false, new pll(this, paramArticleInfo), 1);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131494302, this, true);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Long != paramLong) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageBitmap(paramBitmap);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131311749);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131309004));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131308996));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131308999));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131309007));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309008));
    this.c = ((TextView)paramView.findViewById(2131308998));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309000));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131309736);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a(Object paramObject)
  {
    int j = 1;
    int i = 1;
    super.a(paramObject);
    ArticleInfo localArticleInfo = ((opw)paramObject).a();
    Object localObject1;
    Object localObject2;
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null))
    {
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Long <= 0L) {
        break label417;
      }
      localObject1 = oby.a(localArticleInfo.mPolymericInfo.jdField_a_of_type_Long, true);
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString)) {
        localObject2 = (String)localObject1 + " " + localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString;
      }
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 10) {
        break label428;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
      label161:
      switch (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int)
      {
      case 7: 
      case 8: 
      default: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        this.jdField_a_of_type_Long = 0L;
        if (!TextUtils.isEmpty(localArticleInfo.mPolymericInfo.c))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(obz.a(localArticleInfo.mPolymericInfo.c));
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
          if (localArticleInfo.mPolymericInfo.jdField_b_of_type_Int != 0) {
            break label957;
          }
        }
        break;
      }
    }
    label417:
    label428:
    label957:
    for (boolean bool = true;; bool = false)
    {
      ((ReadInJoyHeadImageView)localObject1).setRound(bool);
      for (;;)
      {
        if ((localArticleInfo != null) && (localArticleInfo.mGroupSubArticleList != null) && (!localArticleInfo.mGroupSubArticleList.isEmpty()) && (localArticleInfo.mPolymericInfo != null) && ((localArticleInfo.mPolymericInfo.e == 2) || (localArticleInfo.mPolymericInfo.e == 1))) {
          break label963;
        }
        this.c.setVisibility(8);
        if ((QLog.isColorLevel()) && (localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null)) {
          QLog.d("ComponentHeaderPolymeric", 2, "articleInfo.mPolymericInfo = " + localArticleInfo.mPolymericInfo.toString());
        }
        return;
        localObject1 = ajjy.a(2131636484);
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(0);
        break label161;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        this.jdField_a_of_type_Long = localArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(avwf.a(this.jdField_a_of_type_Azwg, String.valueOf(this.jdField_a_of_type_Long), 1));
        continue;
        localObject2 = localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString;
        if (((String)localObject2).startsWith("#"))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("# ")) {
            localObject1 = "# " + ((String)localObject2).substring(1);
          }
          localObject1 = new SpannableString((CharSequence)localObject1);
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(getResources().getColor(2131101136)), 0, 1, 33);
          ((SpannableString)localObject1).setSpan(new ImageSpan(getContext(), 2130842274), 1, 2, 33);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject1);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Long = 0L;
          if (TextUtils.isEmpty(localArticleInfo.mPolymericInfo.c)) {
            break;
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject2 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
          localObject1 = URLDrawable.getDrawable(obz.a(localArticleInfo.mPolymericInfo.c), (URLDrawable.URLDrawableOptions)localObject1);
          ((URLDrawable)localObject1).setTag(azue.b(72, 72, azvv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getContext(), 2.0F)));
          ((URLDrawable)localObject1).setDecodeHandler(azue.i);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject1);
          break;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Long = localArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
        if ((localArticleInfo.mGroupSubArticleList != null) && (localArticleInfo.mGroupSubArticleList.size() > 0))
        {
          localObject1 = (BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0);
          if (((localObject1 instanceof ArticleInfo)) && (qoe.o((ArticleInfo)localObject1)))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(avwf.a(this.jdField_a_of_type_Azwg, String.valueOf(this.jdField_a_of_type_Long), 1));
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_Long);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(this.jdField_a_of_type_Long);
          }
        }
      }
    }
    label963:
    this.jdField_a_of_type_Boolean = true;
    if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11)
    {
      if (localArticleInfo.mPolymericInfo.e == 2) {}
      for (i = 1;; i = 0)
      {
        this.c.setTag(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long));
        localObject1 = ((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
        if ((localObject1 != null) && (((SocializeFeedsInfo)localObject1).a != null)) {
          break;
        }
        this.c.setVisibility(8);
        return;
      }
      if (((SocializeFeedsInfo)localObject1).a != null) {
        if (((SocializeFeedsInfo)localObject1).a.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (i != 0) {
            break label1263;
          }
          this.c.setVisibility(0);
          a(false);
          label1105:
          localObject1 = (LinearLayout.LayoutParams)this.c.getLayoutParams();
          if (!a()) {
            break label1275;
          }
        }
      }
    }
    label1263:
    label1275:
    for (((LinearLayout.LayoutParams)localObject1).rightMargin = azvv.a(getContext(), 12.0F);; ((LinearLayout.LayoutParams)localObject1).rightMargin = azvv.a(getContext(), 0.0F))
    {
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!(paramObject instanceof oqh)) {
        break label1301;
      }
      if ((((oqh)paramObject).e() != 56) || (((oqh)paramObject).jdField_b_of_type_Int == 0)) {
        break label1291;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 9) {
        break;
      }
      if (localArticleInfo.mPolymericInfo.e == 2) {}
      for (i = j;; i = 0)
      {
        this.c.setTag(String.valueOf(localArticleInfo.mPolymericInfo.f));
        break;
      }
      this.c.setVisibility(8);
      break label1105;
    }
    label1291:
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return;
    label1301:
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(pfh parampfh)
  {
    super.a(parampfh);
  }
  
  public boolean a()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pjg.a.a();
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null) && ((this.jdField_a_of_type_Pjg.a instanceof oqh)))
    {
      oqh localoqh = (oqh)this.jdField_a_of_type_Pjg.a;
      int i = localArticleInfo.mPolymericInfo.jdField_a_of_type_Int;
      if (((i == 9) || (i == 10) || (i == 11)) && (localoqh.jdField_a_of_type_Int == 56)) {
        return true;
      }
      if (i == 10) {
        return true;
      }
    }
    return super.a();
  }
  
  protected void d()
  {
    AppRuntime localAppRuntime = obz.a();
    ArticleInfo localArticleInfo;
    String str;
    if (localAppRuntime != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localArticleInfo = this.jdField_a_of_type_Pjg.a.a();
      if (!rvf.a(this.jdField_a_of_type_Pjg.a.e())) {
        break label157;
      }
      str = "0X800941D";
      qoe.a(localArticleInfo, str, str, this.jdField_a_of_type_Pjg.a.e());
      ogy.b(localArticleInfo);
      str = String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
      if ((localArticleInfo.mGroupSubArticleList == null) || (localArticleInfo.mGroupSubArticleList.size() <= 0)) {
        break label173;
      }
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0);
      if ((!(localBaseArticleInfo instanceof ArticleInfo)) || (!qoe.o((ArticleInfo)localBaseArticleInfo))) {
        break label173;
      }
    }
    label157:
    label173:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        a(localAppRuntime, str, localArticleInfo);
        return;
        str = "0X80080EC";
        break;
      }
      b(localAppRuntime, str, localArticleInfo);
      return;
    }
  }
  
  protected void e()
  {
    boolean bool = false;
    Object localObject = obz.a();
    ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Pjg.a.a().mGroupSubArticleList.get(0);
    localObject = ((AppRuntime)localObject).getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPGCAccount topicID = " + localArticleInfo.mPolymericInfo.f + ", followStatus = " + localArticleInfo.mPolymericInfo.e + ", articleInfoID = " + localArticleInfo.mArticleID);
    }
    oqv localoqv = ogy.a().a();
    String str = Long.toString(localArticleInfo.mPolymericInfo.f);
    if (localArticleInfo.mPolymericInfo.e != 2) {
      bool = true;
    }
    localoqv.a((String)localObject, str, bool, new plm(this, localArticleInfo), 3);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ohb.a().a(this.jdField_a_of_type_Ohe);
  }
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pjg.a.a();
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          switch (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            a(localArticleInfo);
            return;
            paramView = obb.g + baaw.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2);
            obz.a(getContext(), paramView);
            continue;
            paramView = obb.k + baaw.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2);
            obz.a(getContext(), paramView);
            continue;
            obz.a(getContext(), localArticleInfo.mPolymericInfo.d);
          }
        } while ((localArticleInfo.mPolymericInfo.e != 2) && (localArticleInfo.mPolymericInfo.e != 1));
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        bbmy.a(getContext(), ajjy.a(2131636485), 0).a();
      } while (!QLog.isColorLevel());
      QLog.d("ComponentHeaderPolymeric", 2, "click when the button is disabled");
      return;
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11)
      {
        d();
        return;
      }
    } while (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 9);
    e();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ohb.a().b(this.jdField_a_of_type_Ohe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric
 * JD-Core Version:    0.7.0.1
 */