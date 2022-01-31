package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import ajya;
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
import awwa;
import bavw;
import baxn;
import bbco;
import bcql;
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
import nol;
import omj;
import ong;
import onh;
import org.json.JSONObject;
import osg;
import osj;
import osm;
import pau;
import pbf;
import pbu;
import pqy;
import puy;
import pxb;
import pxc;
import pxd;
import pxe;
import pxf;
import qbs;
import qci;
import ram;
import shu;

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
  protected osm a;
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public ComponentHeaderPolymeric(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Osm = new pxf(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Osm = new pxf(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Osm = new pxf(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      a(false);
      bcql.a(getContext(), ajya.a(2131702321), 0).a();
    }
    while (paramInt != 2) {
      return;
    }
    a(true);
    bcql.a(getContext(), ajya.a(2131702326), 0).a();
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    paramArticleInfo.mPolymericInfo.e = paramInt;
    Object localObject = ((BaseArticleInfo)paramArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).h = paramInt;
    }
    localObject = osj.a();
    long l = paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
    if (paramArticleInfo.mPolymericInfo.e == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((osj)localObject).b(l, bool);
      ThreadManager.post(new ComponentHeaderPolymeric.5(this, paramArticleInfo, paramInt), 5, null, true);
      return;
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    nol.a(null, "CliOper", "", "", "0X8008F55", "0X8008F55", 0, 0, "", "", "", onh.a(paramBaseArticleInfo.mPolymericInfo).toString(), false);
    if (onh.j(paramBaseArticleInfo))
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
      String str1 = shu.a(getContext(), localBaseArticleInfo.mArticleID, localBaseArticleInfo.mAlgorithmID, 54, this.jdField_a_of_type_Ram.a(), localBaseArticleInfo.getInnerUniqueID(), localBaseArticleInfo.getVideoVid(), shu.a(localBaseArticleInfo), localBaseArticleInfo.videoReportInfo);
      String str2 = shu.b(paramBaseArticleInfo.mChannelID);
      nol.a(null, "CliOper", "", String.valueOf(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long), str2, str2, 0, 0, Long.toString(localBaseArticleInfo.mFeedId), String.valueOf(localBaseArticleInfo.mArticleID), Integer.toString(localBaseArticleInfo.mStrategyId), str1, false);
      return;
    }
    ram.a((ArticleInfo)paramBaseArticleInfo, this.jdField_a_of_type_Ram.a());
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString, ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followUGCAccount followUin = " + paramString + ", followStatus = " + paramArticleInfo.mPolymericInfo.e + ", articleInfoID = " + paramArticleInfo.mArticleID);
    }
    pbu localpbu = osg.a().a();
    paramAppRuntime = paramAppRuntime.getAccount();
    if (paramArticleInfo.mPolymericInfo.e != 2) {}
    for (boolean bool = true;; bool = false)
    {
      localpbu.a(paramAppRuntime, paramString, bool, new pxb(this, paramArticleInfo), 2);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setBackgroundResource(2130848357);
      this.c.setText(ajya.a(2131702260));
      this.c.setTextColor(-2147483648);
      this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    this.c.setBackgroundResource(2130848356);
    this.c.setText(ajya.a(2131702297));
    this.c.setTextColor(-1);
    this.c.setCompoundDrawablePadding(actj.a(3.0F, getResources()));
    this.c.setCompoundDrawablesWithIntrinsicBounds(2130848354, 0, 0, 0);
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
      osg.a().a().a(paramAppRuntime.getAccount(), paramString, true, new pxc(this, paramArticleInfo), 1);
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
    osg.a().a().a(paramAppRuntime.getAccount(), paramString, false, new pxd(this, paramArticleInfo), 1);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559873, this, true);
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
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377562);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131374747));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374739));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131374742));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131374750));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374751));
    this.c = ((TextView)paramView.findViewById(2131374741));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374743));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375493);
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
    ArticleInfo localArticleInfo = ((pau)paramObject).a();
    Object localObject1;
    Object localObject2;
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null))
    {
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Long <= 0L) {
        break label417;
      }
      localObject1 = ong.a(localArticleInfo.mPolymericInfo.jdField_a_of_type_Long, true);
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
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(onh.a(localArticleInfo.mPolymericInfo.c));
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
        localObject1 = ajya.a(2131702279);
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(0);
        break label161;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        this.jdField_a_of_type_Long = localArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(awwa.a(this.jdField_a_of_type_Baxy, String.valueOf(this.jdField_a_of_type_Long), 1));
        continue;
        localObject2 = localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString;
        if (((String)localObject2).startsWith("#"))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("# ")) {
            localObject1 = "# " + ((String)localObject2).substring(1);
          }
          localObject1 = new SpannableString((CharSequence)localObject1);
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(getResources().getColor(2131166730)), 0, 1, 33);
          ((SpannableString)localObject1).setSpan(new ImageSpan(getContext(), 2130842358), 1, 2, 33);
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
          localObject1 = URLDrawable.getDrawable(onh.a(localArticleInfo.mPolymericInfo.c), (URLDrawable.URLDrawableOptions)localObject1);
          ((URLDrawable)localObject1).setTag(bavw.b(72, 72, baxn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getContext(), 2.0F)));
          ((URLDrawable)localObject1).setDecodeHandler(bavw.i);
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
          if (((localObject1 instanceof ArticleInfo)) && (ram.o((ArticleInfo)localObject1)))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(awwa.a(this.jdField_a_of_type_Baxy, String.valueOf(this.jdField_a_of_type_Long), 1));
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
    for (((LinearLayout.LayoutParams)localObject1).rightMargin = baxn.a(getContext(), 12.0F);; ((LinearLayout.LayoutParams)localObject1).rightMargin = baxn.a(getContext(), 0.0F))
    {
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!(paramObject instanceof pbf)) {
        break label1301;
      }
      if ((((pbf)paramObject).e() != 56) || (((pbf)paramObject).jdField_b_of_type_Int == 0)) {
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
  
  public void a(pqy parampqy)
  {
    super.a(parampqy);
  }
  
  public boolean a()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Puy.a.a();
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null) && ((this.jdField_a_of_type_Puy.a instanceof pbf)))
    {
      pbf localpbf = (pbf)this.jdField_a_of_type_Puy.a;
      int i = localArticleInfo.mPolymericInfo.jdField_a_of_type_Int;
      if (((i == 9) || (i == 10) || (i == 11)) && (localpbf.jdField_a_of_type_Int == 56)) {
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
    AppRuntime localAppRuntime = onh.a();
    ArticleInfo localArticleInfo;
    String str;
    if (localAppRuntime != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localArticleInfo = this.jdField_a_of_type_Puy.a.a();
      if (!shu.a(this.jdField_a_of_type_Puy.a.e())) {
        break label157;
      }
      str = "0X800941D";
      ram.a(localArticleInfo, str, str, this.jdField_a_of_type_Puy.a.e());
      osg.b(localArticleInfo);
      str = String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
      if ((localArticleInfo.mGroupSubArticleList == null) || (localArticleInfo.mGroupSubArticleList.size() <= 0)) {
        break label173;
      }
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0);
      if ((!(localBaseArticleInfo instanceof ArticleInfo)) || (!ram.o((ArticleInfo)localBaseArticleInfo))) {
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
    Object localObject = onh.a();
    ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Puy.a.a().mGroupSubArticleList.get(0);
    localObject = ((AppRuntime)localObject).getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPGCAccount topicID = " + localArticleInfo.mPolymericInfo.f + ", followStatus = " + localArticleInfo.mPolymericInfo.e + ", articleInfoID = " + localArticleInfo.mArticleID);
    }
    pbu localpbu = osg.a().a();
    String str = Long.toString(localArticleInfo.mPolymericInfo.f);
    if (localArticleInfo.mPolymericInfo.e != 2) {
      bool = true;
    }
    localpbu.a((String)localObject, str, bool, new pxe(this, localArticleInfo), 3);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    osj.a().a(this.jdField_a_of_type_Osm);
  }
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Puy.a.a();
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
            paramView = omj.g + bbco.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2);
            onh.a(getContext(), paramView);
            continue;
            paramView = omj.k + bbco.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2);
            onh.a(getContext(), paramView);
            continue;
            onh.a(getContext(), localArticleInfo.mPolymericInfo.d);
          }
        } while ((localArticleInfo.mPolymericInfo.e != 2) && (localArticleInfo.mPolymericInfo.e != 1));
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        bcql.a(getContext(), ajya.a(2131702280), 0).a();
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
    osj.a().b(this.jdField_a_of_type_Osm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric
 * JD-Core Version:    0.7.0.1
 */