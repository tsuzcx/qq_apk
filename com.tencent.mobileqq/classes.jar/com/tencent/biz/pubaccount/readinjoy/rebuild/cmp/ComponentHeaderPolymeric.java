package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import bcnc;
import bgxc;
import bhcu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import olh;
import org.json.JSONObject;
import pjj;
import pkg;
import pkh;
import ppe;
import pqa;
import pqb;
import pqw;
import prp;
import pvj;
import pvm;
import pvq;
import qfw;
import qhk;
import qia;
import rbx;
import rfw;
import rhz;
import ria;
import rib;
import ric;
import rid;
import rpx;
import rqy;
import szd;
import uvs;

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
  protected pvq a;
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public ComponentHeaderPolymeric(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Pvq = new rid(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Pvq = new rid(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Pvq = new rid(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      a(false);
      QQToast.a(getContext(), anvx.a(2131701818), 0).a();
    }
    while (paramInt != 2) {
      return;
    }
    a(true);
    QQToast.a(getContext(), anvx.a(2131701823), 0).a();
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    paramArticleInfo.mPolymericInfo.e = paramInt;
    Object localObject = ((BaseArticleInfo)paramArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).h = paramInt;
    }
    localObject = pvm.a();
    long l = paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
    if (paramArticleInfo.mPolymericInfo.e == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((pvm)localObject).b(l, bool);
      ThreadManager.post(new ComponentHeaderPolymeric.5(this, paramArticleInfo, paramInt), 5, null, true);
      return;
    }
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString, ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followUGCAccount followUin = " + paramString + ", followStatus = " + paramArticleInfo.mPolymericInfo.e + ", articleInfoID = " + paramArticleInfo.mArticleID);
    }
    qia localqia = pvj.a().a();
    paramAppRuntime = paramAppRuntime.getAccount();
    if (paramArticleInfo.mPolymericInfo.e != 2) {}
    for (boolean bool = true;; bool = false)
    {
      localqia.a(paramAppRuntime, paramString, bool, paramArticleInfo.mPolymericInfo.c, new rhz(this, paramArticleInfo), 2);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setBackgroundResource(2130849341);
      this.c.setText(anvx.a(2131701757));
      this.c.setTextColor(-2147483648);
      this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    this.c.setBackgroundResource(2130849340);
    this.c.setText(anvx.a(2131701794));
    this.c.setTextColor(-1);
    this.c.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, getResources()));
    this.c.setCompoundDrawablesWithIntrinsicBounds(2130849338, 0, 0, 0);
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo)
  {
    olh.a(null, "CliOper", "", "", "0X8008F55", "0X8008F55", 0, 0, "", "", "", prp.a(paramBaseArticleInfo.mPolymericInfo).toString(), false);
    if (pqw.j(paramBaseArticleInfo))
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
      String str1 = uvs.a(getContext(), localBaseArticleInfo.mArticleID, localBaseArticleInfo.mAlgorithmID, 54, this.jdField_a_of_type_Szd.a(), localBaseArticleInfo.getInnerUniqueID(), localBaseArticleInfo.getVideoVid(), uvs.a(localBaseArticleInfo), localBaseArticleInfo.videoReportInfo);
      String str2 = uvs.b(paramBaseArticleInfo.mChannelID);
      olh.a(null, "CliOper", "", String.valueOf(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long), str2, str2, 0, 0, Long.toString(localBaseArticleInfo.mFeedId), String.valueOf(localBaseArticleInfo.mArticleID), Integer.toString(localBaseArticleInfo.mStrategyId), str1, false);
      return;
    }
    pqb.b((ArticleInfo)paramBaseArticleInfo, this.jdField_a_of_type_Szd.a());
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
        break label131;
      }
      pvj.a().a().a(paramAppRuntime.getAccount(), paramString, true, paramArticleInfo.mPolymericInfo.c, new ria(this, paramArticleInfo), 1);
    }
    label131:
    while (paramArticleInfo.mPolymericInfo.e != 2)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ComponentHeaderPolymeric", 2, "followPGCAccount fail, appInterface is null!");
      return;
    }
    pvj.a().a().a(paramAppRuntime.getAccount(), paramString, false, paramArticleInfo.mPolymericInfo.c, new rib(this, paramArticleInfo), 1);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560180, this, true);
  }
  
  String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Long > 0L) {}
    for (String str1 = pkg.a(paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Long, true);; str1 = anvx.a(2131701776))
    {
      String str2 = str1;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString)) {
        str2 = str1 + " " + paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString;
      }
      return str2;
    }
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
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131379227);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131376142));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376134));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131376137));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376145));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376146));
    this.c = ((TextView)paramView.findViewById(2131376136));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376138));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376947);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 10)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(0);
  }
  
  void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    switch (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int)
    {
    case 7: 
    case 8: 
    default: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_Long = 0L;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mPolymericInfo.c))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImage(pqa.a(paramBaseArticleInfo.mPolymericInfo.c));
        paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
        if (paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Int != 0) {
          break label583;
        }
      }
      break;
    }
    label583:
    for (boolean bool = true;; bool = false)
    {
      paramString.setRound(bool);
      do
      {
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_a_of_type_Long = paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(bcnc.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, String.valueOf(this.jdField_a_of_type_Long), 1));
        return;
        Object localObject = paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString;
        if (((String)localObject).startsWith("#"))
        {
          paramString = (String)localObject;
          if (!((String)localObject).startsWith("# ")) {
            paramString = "# " + ((String)localObject).substring(1);
          }
          paramString = new SpannableString(paramString);
          paramString.setSpan(new ForegroundColorSpan(getResources().getColor(2131166896)), 0, 1, 33);
          paramString.setSpan(new ImageSpan(getContext(), 2130842966), 1, 2, 33);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramString);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Long = 0L;
          if (TextUtils.isEmpty(paramBaseArticleInfo.mPolymericInfo.c)) {
            break;
          }
          paramString = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(0);
          paramString.mFailedDrawable = ((Drawable)localObject);
          paramString.mLoadingDrawable = ((Drawable)localObject);
          paramBaseArticleInfo = URLDrawable.getDrawable(pqa.a(paramBaseArticleInfo.mPolymericInfo.c), paramString);
          paramBaseArticleInfo.setTag(bgxc.b(72, 72, DisplayUtil.dip2px(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getContext(), 2.0F)));
          paramBaseArticleInfo.setDecodeHandler(bgxc.j);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(paramBaseArticleInfo);
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Long = paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
      } while ((paramBaseArticleInfo.mGroupSubArticleList == null) || (paramBaseArticleInfo.mGroupSubArticleList.size() <= 0));
      paramString = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
      if (((paramString instanceof ArticleInfo)) && (ppe.o((ArticleInfo)paramString)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(bcnc.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, String.valueOf(this.jdField_a_of_type_Long), 1));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(this.jdField_a_of_type_Long);
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    ArticleInfo localArticleInfo = ((qfw)paramObject).a();
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null))
    {
      String str = a(localArticleInfo);
      a(localArticleInfo);
      a(localArticleInfo, str);
    }
    a(paramObject, localArticleInfo);
  }
  
  void a(Object paramObject, BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = 1;
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mGroupSubArticleList == null) || (paramBaseArticleInfo.mGroupSubArticleList.isEmpty()) || (paramBaseArticleInfo.mPolymericInfo == null) || ((paramBaseArticleInfo.mPolymericInfo.e != 2) && (paramBaseArticleInfo.mPolymericInfo.e != 1)))
    {
      this.c.setVisibility(8);
      if ((QLog.isColorLevel()) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mPolymericInfo != null)) {
        QLog.d("ComponentHeaderPolymeric", 2, "articleInfo.mPolymericInfo = " + paramBaseArticleInfo.mPolymericInfo.toString());
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11)
    {
      if (paramBaseArticleInfo.mPolymericInfo.e == 2) {}
      for (i = 1;; i = 0)
      {
        this.c.setTag(String.valueOf(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long));
        paramBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
        if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.a != null)) {
          break;
        }
        this.c.setVisibility(8);
        return;
      }
      if (paramBaseArticleInfo.a != null) {
        if (paramBaseArticleInfo.a.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (i != 0) {
            break label402;
          }
          this.c.setVisibility(0);
          a(false);
          label249:
          paramBaseArticleInfo = (LinearLayout.LayoutParams)this.c.getLayoutParams();
          if (!a()) {
            break label414;
          }
        }
      }
    }
    label402:
    label414:
    for (paramBaseArticleInfo.rightMargin = DisplayUtil.dip2px(getContext(), 12.0F);; paramBaseArticleInfo.rightMargin = DisplayUtil.dip2px(getContext(), 0.0F))
    {
      this.c.setLayoutParams(paramBaseArticleInfo);
      if (!(paramObject instanceof qhk)) {
        break label439;
      }
      if ((((qhk)paramObject).e() != 56) || (((qhk)paramObject).jdField_b_of_type_Int == 0)) {
        break label429;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      if (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 9) {
        break;
      }
      if (paramBaseArticleInfo.mPolymericInfo.e == 2) {}
      for (i = j;; i = 0)
      {
        this.c.setTag(String.valueOf(paramBaseArticleInfo.mPolymericInfo.f));
        break;
      }
      this.c.setVisibility(8);
      break label249;
    }
    label429:
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return;
    label439:
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(rbx paramrbx)
  {
    super.a(paramrbx);
  }
  
  public boolean a()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Rfw.a.a();
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null) && ((this.jdField_a_of_type_Rfw.a instanceof qhk)))
    {
      qhk localqhk = (qhk)this.jdField_a_of_type_Rfw.a;
      int i = localArticleInfo.mPolymericInfo.jdField_a_of_type_Int;
      if (((i == 9) || (i == 10) || (i == 11)) && (localqhk.jdField_a_of_type_Int == 56)) {
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
    AppRuntime localAppRuntime = pkh.a();
    ArticleInfo localArticleInfo;
    String str;
    if (localAppRuntime != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localArticleInfo = this.jdField_a_of_type_Rfw.a.a();
      if (!uvs.a(this.jdField_a_of_type_Rfw.a.e())) {
        break label157;
      }
      str = "0X800941D";
      pqb.a(localArticleInfo, str, str, this.jdField_a_of_type_Rfw.a.e());
      pvj.c(localArticleInfo);
      str = String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
      if ((localArticleInfo.mGroupSubArticleList == null) || (localArticleInfo.mGroupSubArticleList.size() <= 0)) {
        break label173;
      }
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0);
      if ((!(localBaseArticleInfo instanceof ArticleInfo)) || (!ppe.o((ArticleInfo)localBaseArticleInfo))) {
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
    Object localObject = pkh.a();
    ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Rfw.a.a().mGroupSubArticleList.get(0);
    localObject = ((AppRuntime)localObject).getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPGCAccount topicID = " + localArticleInfo.mPolymericInfo.f + ", followStatus = " + localArticleInfo.mPolymericInfo.e + ", articleInfoID = " + localArticleInfo.mArticleID);
    }
    qia localqia = pvj.a().a();
    String str = Long.toString(localArticleInfo.mPolymericInfo.f);
    if (localArticleInfo.mPolymericInfo.e != 2) {
      bool = true;
    }
    localqia.a((String)localObject, str, bool, localArticleInfo.mPolymericInfo.c, new ric(this, localArticleInfo), 3);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    pvm.a().a(this.jdField_a_of_type_Pvq);
  }
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Rfw.a.a();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        b(localArticleInfo);
        break;
        String str = pjj.g + bhcu.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2);
        pkh.a(getContext(), str);
        continue;
        str = pjj.k + bhcu.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2);
        pkh.a(getContext(), str);
        continue;
        pkh.a(getContext(), localArticleInfo.mPolymericInfo.d);
      }
      if ((localArticleInfo.mPolymericInfo.e == 2) || (localArticleInfo.mPolymericInfo.e == 1)) {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(getContext(), anvx.a(2131701777), 0).a();
          if (QLog.isColorLevel()) {
            QLog.d("ComponentHeaderPolymeric", 2, "click when the button is disabled");
          }
        }
        else if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11)
        {
          d();
        }
        else if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9)
        {
          e();
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    pvm.a().b(this.jdField_a_of_type_Pvq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric
 * JD-Core Version:    0.7.0.1
 */