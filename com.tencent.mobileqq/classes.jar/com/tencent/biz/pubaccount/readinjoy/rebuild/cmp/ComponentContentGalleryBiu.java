package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import ajya;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import old;
import omr;
import onh;
import pau;
import pqo;
import pqy;
import puy;
import pvh;
import pvi;
import pym;
import qcj;
import qcv;
import qcw;
import ram;
import rbo;

public class ComponentContentGalleryBiu
  extends FrameLayout
  implements pqo
{
  private float jdField_a_of_type_Float = 3.0F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private List<KandianUrlImageView> jdField_a_of_type_JavaUtilList;
  private puy jdField_a_of_type_Puy;
  private ram jdField_a_of_type_Ram;
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
  
  public static int a(ArticleInfo paramArticleInfo, ram paramram)
  {
    return old.a(paramram.a(), onh.a(paramArticleInfo));
  }
  
  private Pair<Integer, Integer> a()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int k = (localResources.getDisplayMetrics().widthPixels - actj.a(this.jdField_a_of_type_Float * 2.0F, localResources) - actj.a(22.0F, localResources)) / 3;
    int j = localResources.getDimensionPixelSize(2131298552);
    if (this.jdField_a_of_type_Boolean) {
      j = k;
    }
    return new Pair(Integer.valueOf(k), Integer.valueOf(j));
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if ((this.jdField_a_of_type_Ram == null) || (paramArticleInfo == null)) {}
    rbo localrbo;
    do
    {
      return;
      localrbo = this.jdField_a_of_type_Ram.a();
    } while (localrbo == null);
    localrbo.a(getContext(), paramArticleInfo, 0, paramArticleInfo.innerUniqueID, 5, this.jdField_a_of_type_Int, 0);
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
        ((KandianUrlImageView)paramList.get(j)).setOnClickListener(new pvi(this, paramArticleInfo, paramArrayOfLong[j], paramString, j));
        j += 1;
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Puy = new puy();
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
    if ((paramObject instanceof pau))
    {
      paramObject = (pau)paramObject;
      this.jdField_a_of_type_Puy.a(paramObject);
      setContent(paramObject);
    }
  }
  
  public void a(pqy parampqy)
  {
    this.jdField_a_of_type_Puy.a(parampqy);
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
        ((LinearLayout.LayoutParams)localKandianUrlImageView.getLayoutParams()).setMargins(0, 0, actj.a(this.jdField_a_of_type_Float, getResources()), 0);
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
  
  public void setAdapter(ram paramram)
  {
    this.jdField_a_of_type_Ram = paramram;
  }
  
  public void setContent(pau parampau)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject1 = new LinearLayout.LayoutParams(-2, -2);
    ArticleInfo localArticleInfo = parampau.a();
    if ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj == null)) {}
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
          parampau = new TextView(getContext());
          parampau.setPadding(0, 0, 0, actj.a(11.0F, getContext().getResources()));
          parampau.setMaxLines(2);
          parampau.setEllipsize(TextUtils.TruncateAt.END);
          parampau.setTextColor(Color.parseColor("#000000"));
          parampau.setTextSize(1, 17.0F);
          parampau.setIncludeFontPadding(false);
          parampau.setText(localArticleInfo.mTitle);
          parampau.setOnClickListener(new pvh(this, localArticleInfo));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parampau);
        }
        str = localArticleInfo.innerUniqueID;
        parampau = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv;
        localObject2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj;
        localObject3 = parampau.jdField_a_of_type_JavaUtilArrayList;
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
      parampau = (qcw)((ArrayList)localObject3).get(j);
      arrayOfLong[j] = parampau.a;
      parampau = parampau.b;
      if (!onh.a(parampau)) {
        break label1295;
      }
      parampau = onh.a(parampau, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), 1);
    }
    label1295:
    for (;;)
    {
      localArrayList.add(onh.a(parampau));
      j += 1;
      break label286;
      bool = false;
      break;
      label374:
      long l = ((qcj)localObject2).a;
      if ((k == 1) || (k == 3))
      {
        parampau = new LinearLayout(getContext());
        parampau.setOrientation(0);
        parampau.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = LayoutInflater.from(getContext()).inflate(2131559852, null);
        ((TextView)((View)localObject1).findViewById(2131378283)).setText(String.valueOf(l) + ajya.a(2131702328));
        if (k == 1)
        {
          parampau.addView((View)localObject1);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)((View)localObject1).findViewById(2131367776));
          this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView });
          pym.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
          omr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localArticleInfo.mSinglePicture, getContext());
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parampau);
        }
      }
      for (;;)
      {
        a(this.jdField_a_of_type_JavaUtilList, localArticleInfo, arrayOfLong, str);
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
        this.c = ((KandianUrlImageView)((View)localObject1).findViewById(2131367776));
        parampau.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        parampau.addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        parampau.addView((View)localObject1);
        a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView });
        b(new KandianUrlImageView[] { this.c });
        this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.c });
        omr.a(this.jdField_a_of_type_JavaUtilList, localArrayList, getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parampau);
        continue;
        if (k == 9)
        {
          parampau = new LinearLayout(getContext());
          localObject2 = new LinearLayout(getContext());
          localObject3 = new LinearLayout(getContext());
          parampau.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject2).setPadding(0, actj.a(this.jdField_a_of_type_Float, getResources()), 0, 0);
          ((LinearLayout)localObject3).setPadding(0, actj.a(this.jdField_a_of_type_Float, getResources()), 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
          this.c = new KandianUrlImageView(getContext());
          parampau.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
          parampau.addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
          parampau.addView(this.c);
          this.d = new KandianUrlImageView(getContext());
          this.e = new KandianUrlImageView(getContext());
          this.f = new KandianUrlImageView(getContext());
          ((LinearLayout)localObject2).addView(this.d);
          ((LinearLayout)localObject2).addView(this.e);
          ((LinearLayout)localObject2).addView(this.f);
          localObject1 = LayoutInflater.from(getContext()).inflate(2131559852, null);
          ((TextView)((View)localObject1).findViewById(2131378283)).setText(String.valueOf(l) + ajya.a(2131702254));
          this.g = new KandianUrlImageView(getContext());
          this.h = new KandianUrlImageView(getContext());
          this.i = ((KandianUrlImageView)((View)localObject1).findViewById(2131367776));
          ((LinearLayout)localObject3).addView(this.g);
          ((LinearLayout)localObject3).addView(this.h);
          ((LinearLayout)localObject3).addView((View)localObject1);
          a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.d, this.e, this.g, this.h });
          b(new KandianUrlImageView[] { this.c, this.f, this.i });
          this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.c, this.d, this.e, this.f, this.g, this.h, this.i });
          omr.a(this.jdField_a_of_type_JavaUtilList, localArrayList, getContext());
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parampau);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu
 * JD-Core Version:    0.7.0.1
 */