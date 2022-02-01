package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import amtj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ozb;
import pai;
import pay;
import peo;
import peq;
import pvc;
import qpi;
import qps;
import qtr;
import qua;
import qub;
import qxf;
import res;
import rfe;
import rff;
import slt;

public class ComponentContentGalleryBiu
  extends FrameLayout
  implements qpi
{
  private float jdField_a_of_type_Float = 3.0F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private List<KandianUrlImageView> jdField_a_of_type_JavaUtilList;
  private qtr jdField_a_of_type_Qtr;
  private slt jdField_a_of_type_Slt;
  private boolean jdField_a_of_type_Boolean;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private boolean jdField_b_of_type_Boolean;
  private KandianUrlImageView c;
  private KandianUrlImageView d;
  private KandianUrlImageView e;
  private KandianUrlImageView f;
  private KandianUrlImageView g;
  private KandianUrlImageView h;
  private KandianUrlImageView i;
  
  public ComponentContentGalleryBiu(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentGalleryBiu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int k = 9;
    int j = paramInt2;
    if (paramInt2 == 9)
    {
      paramInt2 = k;
      if (paramInt1 < 9) {
        j = 3;
      }
    }
    else
    {
      if ((j != 3) || (paramInt1 < 3)) {
        break label37;
      }
      paramInt2 = 3;
    }
    return paramInt2;
    label37:
    return 1;
  }
  
  public static int a(ArticleInfo paramArticleInfo, slt paramslt)
  {
    return ozb.a(paramslt.a(), pay.a(paramArticleInfo));
  }
  
  private Pair<Integer, Integer> a()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int k = (localResources.getDisplayMetrics().widthPixels - AIOUtils.dp2px(this.jdField_a_of_type_Float * 2.0F, localResources) - AIOUtils.dp2px(22.0F, localResources)) / 3;
    int j = localResources.getDimensionPixelSize(2131298738);
    if (this.jdField_a_of_type_Boolean) {
      j = k;
    }
    return new Pair(Integer.valueOf(k), Integer.valueOf(j));
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if ((this.jdField_a_of_type_Slt == null) || (paramArticleInfo == null)) {}
    peq localpeq;
    do
    {
      return;
      localpeq = this.jdField_a_of_type_Slt.a().a();
    } while (localpeq == null);
    localpeq.a(getContext(), paramArticleInfo, 0, paramArticleInfo.innerUniqueID, 5, this.jdField_a_of_type_Int, 0);
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView)
  {
    Object localObject = a();
    int j = ((Integer)((Pair)localObject).first).intValue();
    int k = ((Integer)((Pair)localObject).second).intValue();
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new LinearLayout.LayoutParams(j, k);
    }
    ((ViewGroup.LayoutParams)localObject).width = j;
    ((ViewGroup.LayoutParams)localObject).height = k;
    paramKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  private void a(List<KandianUrlImageView> paramList, ArticleInfo paramArticleInfo, long[] paramArrayOfLong, String paramString)
  {
    if ((paramList == null) || (paramArrayOfLong == null) || (paramList.size() != paramArrayOfLong.length)) {}
    for (;;)
    {
      return;
      int j = 0;
      while (j < paramList.size())
      {
        ((KandianUrlImageView)paramList.get(j)).setOnClickListener(new qub(this, paramArticleInfo, paramArrayOfLong[j], paramString, j));
        j += 1;
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qtr = new qtr();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    addView(paramContext);
    return paramContext;
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pvc))
    {
      paramObject = (pvc)paramObject;
      this.jdField_a_of_type_Qtr.a(paramObject);
      setContent(paramObject);
    }
  }
  
  public void a(qps paramqps)
  {
    this.jdField_a_of_type_Qtr.a(paramqps);
  }
  
  public void a(KandianUrlImageView... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    while (j < k)
    {
      KandianUrlImageView localKandianUrlImageView = paramVarArgs[j];
      if (localKandianUrlImageView != null)
      {
        a(localKandianUrlImageView);
        ((LinearLayout.LayoutParams)localKandianUrlImageView.getLayoutParams()).setMargins(0, 0, AIOUtils.dp2px(this.jdField_a_of_type_Float, getResources()), 0);
      }
      j += 1;
    }
  }
  
  public void b(KandianUrlImageView... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    while (j < k)
    {
      a(paramVarArgs[j]);
      j += 1;
    }
  }
  
  public void setAdapter(slt paramslt)
  {
    this.jdField_a_of_type_Slt = paramslt;
  }
  
  public void setContent(pvc parampvc)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject1 = new LinearLayout.LayoutParams(-2, -2);
    ArticleInfo localArticleInfo = parampvc.a();
    if ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_Res == null)) {}
    String str;
    Object localObject2;
    Object localObject3;
    int j;
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_Boolean)
        {
          parampvc = new TextView(getContext());
          parampvc.setPadding(0, 0, 0, AIOUtils.dp2px(11.0F, getContext().getResources()));
          parampvc.setMaxLines(2);
          parampvc.setEllipsize(TextUtils.TruncateAt.END);
          parampvc.setTextColor(Color.parseColor("#000000"));
          parampvc.setTextSize(1, 17.0F);
          parampvc.setIncludeFontPadding(false);
          parampvc.setText(localArticleInfo.mTitle);
          parampvc.setOnClickListener(new qua(this, localArticleInfo));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parampvc);
        }
        str = localArticleInfo.innerUniqueID;
        parampvc = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe;
        localObject2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_Res;
        localObject3 = parampvc.jdField_a_of_type_JavaUtilArrayList;
      } while ((localObject3 == null) || (((ArrayList)localObject3).size() == 0));
      j = ((ArrayList)localObject3).size();
    } while (j <= 0);
    int k = a(j, localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);
    long[] arrayOfLong = new long[k];
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    if ((k == 9) || (k == 3))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      Pair localPair = a();
      j = 0;
      label286:
      if (j >= k) {
        break label374;
      }
      parampvc = (rff)((ArrayList)localObject3).get(j);
      arrayOfLong[j] = parampvc.a;
      parampvc = parampvc.b;
      if (!pay.b(parampvc)) {
        break label1289;
      }
      parampvc = pay.a(parampvc, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), 1);
    }
    label1289:
    for (;;)
    {
      localArrayList.add(pay.a(parampvc));
      j += 1;
      break label286;
      bool = false;
      break;
      label374:
      long l = ((res)localObject2).a;
      if ((k == 1) || (k == 3))
      {
        parampvc = new LinearLayout(getContext());
        parampvc.setOrientation(0);
        parampvc.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = LayoutInflater.from(getContext()).inflate(2131560112, null);
        ((TextView)((View)localObject1).findViewById(2131379753)).setText(l + amtj.a(2131701474));
        if (k == 1)
        {
          parampvc.addView((View)localObject1);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)((View)localObject1).findViewById(2131368344));
          this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView });
          qxf.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
          pai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localArticleInfo.mSinglePicture, getContext());
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parampvc);
        }
      }
      for (;;)
      {
        a(this.jdField_a_of_type_JavaUtilList, localArticleInfo, arrayOfLong, str);
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
        this.c = ((KandianUrlImageView)((View)localObject1).findViewById(2131368344));
        parampvc.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        parampvc.addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        parampvc.addView((View)localObject1);
        a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView });
        b(new KandianUrlImageView[] { this.c });
        this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.c });
        pai.a(this.jdField_a_of_type_JavaUtilList, localArrayList, getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parampvc);
        continue;
        if (k == 9)
        {
          parampvc = new LinearLayout(getContext());
          localObject2 = new LinearLayout(getContext());
          localObject3 = new LinearLayout(getContext());
          parampvc.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject2).setPadding(0, AIOUtils.dp2px(this.jdField_a_of_type_Float, getResources()), 0, 0);
          ((LinearLayout)localObject3).setPadding(0, AIOUtils.dp2px(this.jdField_a_of_type_Float, getResources()), 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
          this.c = new KandianUrlImageView(getContext());
          parampvc.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
          parampvc.addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
          parampvc.addView(this.c);
          this.d = new KandianUrlImageView(getContext());
          this.e = new KandianUrlImageView(getContext());
          this.f = new KandianUrlImageView(getContext());
          ((LinearLayout)localObject2).addView(this.d);
          ((LinearLayout)localObject2).addView(this.e);
          ((LinearLayout)localObject2).addView(this.f);
          localObject1 = LayoutInflater.from(getContext()).inflate(2131560112, null);
          ((TextView)((View)localObject1).findViewById(2131379753)).setText(l + amtj.a(2131701400));
          this.g = new KandianUrlImageView(getContext());
          this.h = new KandianUrlImageView(getContext());
          this.i = ((KandianUrlImageView)((View)localObject1).findViewById(2131368344));
          ((LinearLayout)localObject3).addView(this.g);
          ((LinearLayout)localObject3).addView(this.h);
          ((LinearLayout)localObject3).addView((View)localObject1);
          a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.d, this.e, this.g, this.h });
          b(new KandianUrlImageView[] { this.c, this.f, this.i });
          this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.c, this.d, this.e, this.f, this.g, this.h, this.i });
          pai.a(this.jdField_a_of_type_JavaUtilList, localArrayList, getContext());
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parampvc);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
        }
      }
    }
  }
  
  public void setIsNeedAddTitle(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu
 * JD-Core Version:    0.7.0.1
 */