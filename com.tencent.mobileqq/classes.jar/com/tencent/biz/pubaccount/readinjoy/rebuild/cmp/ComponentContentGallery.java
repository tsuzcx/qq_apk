package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import ajya;
import android.content.Context;
import android.content.res.Resources;
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
import baxn;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import omr;
import onh;
import org.json.JSONArray;
import org.json.JSONObject;
import pau;
import pqo;
import pqy;
import puy;
import pvg;
import pym;
import ram;

public class ComponentContentGallery
  extends FrameLayout
  implements pqo
{
  private float jdField_a_of_type_Float = 1.5F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private List<KandianUrlImageView> jdField_a_of_type_JavaUtilList;
  private puy jdField_a_of_type_Puy;
  private ram jdField_a_of_type_Ram;
  private boolean jdField_a_of_type_Boolean;
  private KandianUrlImageView b;
  private KandianUrlImageView c;
  private KandianUrlImageView d;
  private KandianUrlImageView e;
  private KandianUrlImageView f;
  private KandianUrlImageView g;
  private KandianUrlImageView h;
  private KandianUrlImageView i;
  
  public ComponentContentGallery(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  private Pair<Integer, Integer> a()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int j = localResources.getDisplayMetrics().widthPixels;
    int k;
    if (this.jdField_a_of_type_Boolean)
    {
      j = (j - actj.a(this.jdField_a_of_type_Float * 2.0F, localResources) - actj.a(22.0F, localResources)) / 3;
      k = j;
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(k), Integer.valueOf(j));
      k = (j - actj.a(this.jdField_a_of_type_Float * 2.0F, localResources)) / 3;
      j = localResources.getDimensionPixelSize(2131298552);
    }
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
  
  private void a(List<KandianUrlImageView> paramList, ArticleInfo paramArticleInfo, int[] paramArrayOfInt, String paramString)
  {
    if ((paramList == null) || (paramArrayOfInt == null) || (paramList.size() != paramArrayOfInt.length)) {}
    for (;;)
    {
      return;
      int j = 0;
      while (j < paramList.size())
      {
        ((KandianUrlImageView)paramList.get(j)).setOnClickListener(new pvg(this, paramArticleInfo, paramArrayOfInt[j], paramString, j));
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
  
  public int a(JSONArray paramJSONArray, int paramInt)
  {
    if ((paramInt == 5) && (paramJSONArray.length() < 9)) {
      paramInt = 4;
    }
    for (;;)
    {
      if ((paramInt == 4) && (paramJSONArray.length() < 3)) {
        return 3;
      }
      return paramInt;
    }
  }
  
  public View a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
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
    Object localObject2 = parampau.a();
    if (localObject2 == null) {}
    Object localObject3;
    Object localObject1;
    Object localObject4;
    int[] arrayOfInt;
    label550:
    label632:
    do
    {
      do
      {
        return;
        localObject3 = ((ArticleInfo)localObject2).innerUniqueID;
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        localObject4 = ram.a(((ArticleInfo)localObject2).mJsonPictureList, "pictures");
      } while ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0));
      j = a((JSONArray)localObject4, ((ArticleInfo)localObject2).articleStyle);
      arrayOfInt = new int[((JSONArray)localObject4).length()];
      if ((j == 5) || (j == 4)) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Float = 3.0F;
        }
        if (j != 3) {
          break;
        }
        parampau = new LinearLayout(getContext());
        parampau.setOrientation(0);
        parampau.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = LayoutInflater.from(getContext()).inflate(2131559852, null);
        ((TextView)((View)localObject1).findViewById(2131378283)).setText(String.valueOf(((ArticleInfo)localObject2).mGalleryPicNumber) + ajya.a(2131702284));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)((View)localObject1).findViewById(2131367776));
        pym.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        parampau.addView((View)localObject1);
        omr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ((ArticleInfo)localObject2).mSinglePicture, getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parampau);
        return;
      }
      if (j == 4)
      {
        localObject3 = new LinearLayout(getContext());
        ((LinearLayout)localObject3).setOrientation(0);
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        parampau = LayoutInflater.from(getContext()).inflate(2131559852, null);
        ((TextView)parampau.findViewById(2131378283)).setText(String.valueOf(((ArticleInfo)localObject2).mGalleryPicNumber) + ajya.a(2131702305));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
        this.b = new KandianUrlImageView(getContext());
        this.c = ((KandianUrlImageView)parampau.findViewById(2131367776));
        ((LinearLayout)localObject3).addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        ((LinearLayout)localObject3).addView(this.b);
        ((LinearLayout)localObject3).addView(parampau);
        a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b });
        b(new KandianUrlImageView[] { this.c });
        this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.c });
        if ((((ArticleInfo)localObject2).mPictures == null) || (((ArticleInfo)localObject2).mPictures.length <= 0))
        {
          parampau = ((JSONArray)localObject4).optJSONObject(0);
          if (parampau == null)
          {
            parampau = ((ArticleInfo)localObject2).mFirstPagePicUrl;
            localObject1 = ((JSONArray)localObject4).optJSONObject(1);
            if (localObject1 != null) {
              break label632;
            }
            localObject1 = ((ArticleInfo)localObject2).mFirstPagePicUrl;
            localObject4 = ((JSONArray)localObject4).optJSONObject(2);
            if (localObject4 != null) {
              break label645;
            }
          }
          for (localObject2 = ((ArticleInfo)localObject2).mFirstPagePicUrl;; localObject2 = ((JSONObject)localObject4).optString("picture"))
          {
            omr.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { onh.a(parampau), onh.a((String)localObject1), onh.a((String)localObject2) }), getContext());
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
            return;
            parampau = parampau.optString("picture");
            break;
            localObject1 = ((JSONObject)localObject1).optString("picture");
            break label550;
          }
        }
        if ((((ArticleInfo)localObject2).mPictures.length < 1) || (localObject2.mPictures[0] == null))
        {
          parampau = ((ArticleInfo)localObject2).mSinglePicture;
          if ((((ArticleInfo)localObject2).mPictures.length >= 2) && (localObject2.mPictures[1] != null)) {
            break label784;
          }
          localObject1 = ((ArticleInfo)localObject2).mSinglePicture;
          if ((((ArticleInfo)localObject2).mPictures.length >= 3) && (localObject2.mPictures[2] != null)) {
            break label796;
          }
        }
        for (localObject2 = ((ArticleInfo)localObject2).mSinglePicture;; localObject2 = localObject2.mPictures[2])
        {
          omr.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { parampau, localObject1, localObject2 }), getContext());
          break;
          parampau = localObject2.mPictures[0];
          break label684;
          localObject1 = localObject2.mPictures[1];
          break label711;
        }
      }
    } while (j != 5);
    label645:
    label684:
    label711:
    ArrayList localArrayList = new ArrayList();
    label784:
    label796:
    Object localObject5 = a();
    int j = 0;
    JSONObject localJSONObject;
    label855:
    int k;
    if (j < 9)
    {
      localJSONObject = ((JSONArray)localObject4).optJSONObject(j);
      if (localJSONObject == null)
      {
        parampau = ((ArticleInfo)localObject2).mFirstPagePicUrl;
        if (localJSONObject != null) {
          break label933;
        }
        k = 0;
        label862:
        arrayOfInt[j] = k;
        if (!onh.a(parampau)) {
          break label1568;
        }
        parampau = onh.a(parampau, ((Integer)((Pair)localObject5).second).intValue(), ((Integer)((Pair)localObject5).first).intValue(), 1);
      }
    }
    label1568:
    for (;;)
    {
      localArrayList.add(onh.a(parampau));
      j += 1;
      break;
      parampau = localJSONObject.optString("picture");
      break label855;
      label933:
      k = localJSONObject.optInt("galleryIndex");
      break label862;
      parampau = new LinearLayout(getContext());
      localObject4 = new LinearLayout(getContext());
      localObject5 = new LinearLayout(getContext());
      ((LinearLayout.LayoutParams)localObject1).setMargins(baxn.a(getContext(), 11.0F), 0, baxn.a(getContext(), 11.0F), 0);
      parampau.setOrientation(0);
      parampau.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)localObject4).setOrientation(0);
      ((LinearLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)localObject5).setOrientation(0);
      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)localObject4).setPadding(0, actj.a(this.jdField_a_of_type_Float, getResources()), 0, 0);
      ((LinearLayout)localObject5).setPadding(0, actj.a(this.jdField_a_of_type_Float, getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
      this.b = new KandianUrlImageView(getContext());
      this.c = new KandianUrlImageView(getContext());
      parampau.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
      parampau.addView(this.b);
      parampau.addView(this.c);
      this.d = new KandianUrlImageView(getContext());
      this.e = new KandianUrlImageView(getContext());
      this.f = new KandianUrlImageView(getContext());
      ((LinearLayout)localObject4).addView(this.d);
      ((LinearLayout)localObject4).addView(this.e);
      ((LinearLayout)localObject4).addView(this.f);
      localObject1 = LayoutInflater.from(getContext()).inflate(2131559852, null);
      ((TextView)((View)localObject1).findViewById(2131378283)).setText(String.valueOf(((ArticleInfo)localObject2).mGalleryPicNumber) + ajya.a(2131702330));
      this.g = new KandianUrlImageView(getContext());
      this.h = new KandianUrlImageView(getContext());
      this.i = ((KandianUrlImageView)((View)localObject1).findViewById(2131367776));
      ((LinearLayout)localObject5).addView(this.g);
      ((LinearLayout)localObject5).addView(this.h);
      ((LinearLayout)localObject5).addView((View)localObject1);
      a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.d, this.e, this.g, this.h });
      b(new KandianUrlImageView[] { this.c, this.f, this.i });
      this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i });
      omr.a(this.jdField_a_of_type_JavaUtilList, localArrayList, getContext());
      a(this.jdField_a_of_type_JavaUtilList, (ArticleInfo)localObject2, arrayOfInt, (String)localObject3);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parampau);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject5);
      return;
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGallery
 * JD-Core Version:    0.7.0.1
 */