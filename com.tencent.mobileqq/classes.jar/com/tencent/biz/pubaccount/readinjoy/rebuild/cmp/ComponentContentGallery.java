package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

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
import anvx;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import pjr;
import pnl;
import pqa;
import qfw;
import rbn;
import rbx;
import rfw;
import rge;
import rjl;
import szd;

public class ComponentContentGallery
  extends FrameLayout
  implements rbn
{
  private float jdField_a_of_type_Float = 1.5F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private List<KandianUrlImageView> jdField_a_of_type_JavaUtilList;
  private rfw jdField_a_of_type_Rfw;
  private szd jdField_a_of_type_Szd;
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
      j = (j - AIOUtils.dp2px(this.jdField_a_of_type_Float * 2.0F, localResources) - AIOUtils.dp2px(22.0F, localResources)) / 3;
      k = j;
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(k), Integer.valueOf(j));
      k = (j - AIOUtils.dp2px(this.jdField_a_of_type_Float * 2.0F, localResources)) / 3;
      j = localResources.getDimensionPixelSize(2131298742);
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
        ((KandianUrlImageView)paramList.get(j)).setOnClickListener(new rge(this, paramArticleInfo, paramArrayOfInt[j], paramString, j));
        j += 1;
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Rfw = new rfw();
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
    if ((paramObject instanceof qfw))
    {
      paramObject = (qfw)paramObject;
      this.jdField_a_of_type_Rfw.a(paramObject);
      setContent(paramObject);
    }
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rfw.a(paramrbx);
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
  
  public void setAdapter(szd paramszd)
  {
    this.jdField_a_of_type_Szd = paramszd;
  }
  
  public void setContent(qfw paramqfw)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject2 = paramqfw.a();
    if (localObject2 == null) {}
    Object localObject3;
    Object localObject1;
    Object localObject4;
    int[] arrayOfInt;
    label544:
    label626:
    label639:
    do
    {
      do
      {
        return;
        localObject3 = ((ArticleInfo)localObject2).innerUniqueID;
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        localObject4 = pnl.a(((ArticleInfo)localObject2).mJsonPictureList, "pictures");
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
        paramqfw = new LinearLayout(getContext());
        paramqfw.setOrientation(0);
        paramqfw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = LayoutInflater.from(getContext()).inflate(2131560159, null);
        ((TextView)((View)localObject1).findViewById(2131380073)).setText(((ArticleInfo)localObject2).mGalleryPicNumber + anvx.a(2131701781));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)((View)localObject1).findViewById(2131368501));
        rjl.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        paramqfw.addView((View)localObject1);
        pjr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ((ArticleInfo)localObject2).mSinglePicture, getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramqfw);
        return;
      }
      if (j == 4)
      {
        localObject3 = new LinearLayout(getContext());
        ((LinearLayout)localObject3).setOrientation(0);
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramqfw = LayoutInflater.from(getContext()).inflate(2131560159, null);
        ((TextView)paramqfw.findViewById(2131380073)).setText(((ArticleInfo)localObject2).mGalleryPicNumber + anvx.a(2131701802));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
        this.b = new KandianUrlImageView(getContext());
        this.c = ((KandianUrlImageView)paramqfw.findViewById(2131368501));
        ((LinearLayout)localObject3).addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        ((LinearLayout)localObject3).addView(this.b);
        ((LinearLayout)localObject3).addView(paramqfw);
        a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b });
        b(new KandianUrlImageView[] { this.c });
        this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.c });
        if ((((ArticleInfo)localObject2).mPictures == null) || (((ArticleInfo)localObject2).mPictures.length <= 0))
        {
          paramqfw = ((JSONArray)localObject4).optJSONObject(0);
          if (paramqfw == null)
          {
            paramqfw = ((ArticleInfo)localObject2).mFirstPagePicUrl;
            localObject1 = ((JSONArray)localObject4).optJSONObject(1);
            if (localObject1 != null) {
              break label626;
            }
            localObject1 = ((ArticleInfo)localObject2).mFirstPagePicUrl;
            localObject4 = ((JSONArray)localObject4).optJSONObject(2);
            if (localObject4 != null) {
              break label639;
            }
          }
          for (localObject2 = ((ArticleInfo)localObject2).mFirstPagePicUrl;; localObject2 = ((JSONObject)localObject4).optString("picture"))
          {
            pjr.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { pqa.a(paramqfw), pqa.a((String)localObject1), pqa.a((String)localObject2) }), getContext());
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
            return;
            paramqfw = paramqfw.optString("picture");
            break;
            localObject1 = ((JSONObject)localObject1).optString("picture");
            break label544;
          }
        }
        if ((((ArticleInfo)localObject2).mPictures.length < 1) || (localObject2.mPictures[0] == null))
        {
          paramqfw = ((ArticleInfo)localObject2).mSinglePicture;
          if ((((ArticleInfo)localObject2).mPictures.length >= 2) && (localObject2.mPictures[1] != null)) {
            break label778;
          }
          localObject1 = ((ArticleInfo)localObject2).mSinglePicture;
          if ((((ArticleInfo)localObject2).mPictures.length >= 3) && (localObject2.mPictures[2] != null)) {
            break label790;
          }
        }
        for (localObject2 = ((ArticleInfo)localObject2).mSinglePicture;; localObject2 = localObject2.mPictures[2])
        {
          pjr.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { paramqfw, localObject1, localObject2 }), getContext());
          break;
          paramqfw = localObject2.mPictures[0];
          break label678;
          localObject1 = localObject2.mPictures[1];
          break label705;
        }
      }
    } while (j != 5);
    label678:
    label705:
    ArrayList localArrayList = new ArrayList();
    label778:
    label790:
    Object localObject5 = a();
    int j = 0;
    JSONObject localJSONObject;
    label849:
    int k;
    if (j < 9)
    {
      localJSONObject = ((JSONArray)localObject4).optJSONObject(j);
      if (localJSONObject == null)
      {
        paramqfw = ((ArticleInfo)localObject2).mFirstPagePicUrl;
        if (localJSONObject != null) {
          break label927;
        }
        k = 0;
        label856:
        arrayOfInt[j] = k;
        if (!pqa.a(paramqfw)) {
          break label1559;
        }
        paramqfw = pqa.a(paramqfw, ((Integer)((Pair)localObject5).second).intValue(), ((Integer)((Pair)localObject5).first).intValue(), 1);
      }
    }
    label1559:
    for (;;)
    {
      localArrayList.add(pqa.a(paramqfw));
      j += 1;
      break;
      paramqfw = localJSONObject.optString("picture");
      break label849;
      label927:
      k = localJSONObject.optInt("galleryIndex");
      break label856;
      paramqfw = new LinearLayout(getContext());
      localObject4 = new LinearLayout(getContext());
      localObject5 = new LinearLayout(getContext());
      ((LinearLayout.LayoutParams)localObject1).setMargins(DisplayUtil.dip2px(getContext(), 11.0F), 0, DisplayUtil.dip2px(getContext(), 11.0F), 0);
      paramqfw.setOrientation(0);
      paramqfw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)localObject4).setOrientation(0);
      ((LinearLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)localObject5).setOrientation(0);
      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)localObject4).setPadding(0, AIOUtils.dp2px(this.jdField_a_of_type_Float, getResources()), 0, 0);
      ((LinearLayout)localObject5).setPadding(0, AIOUtils.dp2px(this.jdField_a_of_type_Float, getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
      this.b = new KandianUrlImageView(getContext());
      this.c = new KandianUrlImageView(getContext());
      paramqfw.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
      paramqfw.addView(this.b);
      paramqfw.addView(this.c);
      this.d = new KandianUrlImageView(getContext());
      this.e = new KandianUrlImageView(getContext());
      this.f = new KandianUrlImageView(getContext());
      ((LinearLayout)localObject4).addView(this.d);
      ((LinearLayout)localObject4).addView(this.e);
      ((LinearLayout)localObject4).addView(this.f);
      localObject1 = LayoutInflater.from(getContext()).inflate(2131560159, null);
      ((TextView)((View)localObject1).findViewById(2131380073)).setText(((ArticleInfo)localObject2).mGalleryPicNumber + anvx.a(2131701827));
      this.g = new KandianUrlImageView(getContext());
      this.h = new KandianUrlImageView(getContext());
      this.i = ((KandianUrlImageView)((View)localObject1).findViewById(2131368501));
      ((LinearLayout)localObject5).addView(this.g);
      ((LinearLayout)localObject5).addView(this.h);
      ((LinearLayout)localObject5).addView((View)localObject1);
      a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.d, this.e, this.g, this.h });
      b(new KandianUrlImageView[] { this.c, this.f, this.i });
      this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i });
      pjr.a(this.jdField_a_of_type_JavaUtilList, localArrayList, getContext());
      a(this.jdField_a_of_type_JavaUtilList, (ArticleInfo)localObject2, arrayOfInt, (String)localObject3);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramqfw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGallery
 * JD-Core Version:    0.7.0.1
 */