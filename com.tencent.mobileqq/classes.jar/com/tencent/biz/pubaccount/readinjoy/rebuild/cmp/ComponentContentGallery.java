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
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lyq;
import org.json.JSONArray;
import org.json.JSONObject;

public class ComponentContentGallery
  extends FrameLayout
  implements ComponentInheritView
{
  private float jdField_a_of_type_Float = 1.5F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private List jdField_a_of_type_JavaUtilList;
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
  
  private Pair a()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int j = localResources.getDisplayMetrics().widthPixels;
    int k;
    if (this.jdField_a_of_type_Boolean)
    {
      j = (j - AIOUtils.a(this.jdField_a_of_type_Float * 2.0F, localResources) - AIOUtils.a(22.0F, localResources)) / 3;
      k = j;
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(k), Integer.valueOf(j));
      k = (j - AIOUtils.a(this.jdField_a_of_type_Float * 2.0F, localResources)) / 3;
      j = localResources.getDimensionPixelSize(2131559686);
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
  
  private void a(List paramList, ArticleInfo paramArticleInfo, int[] paramArrayOfInt, String paramString)
  {
    if ((paramList == null) || (paramArrayOfInt == null) || (paramList.size() != paramArrayOfInt.length)) {}
    for (;;)
    {
      return;
      int j = 0;
      while (j < paramList.size())
      {
        ((KandianUrlImageView)paramList.get(j)).setOnClickListener(new lyq(this, paramArticleInfo, paramArrayOfInt[j], paramString, j));
        j += 1;
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
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
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
      setContent(paramObject);
    }
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
        ((LinearLayout.LayoutParams)localKandianUrlImageView.getLayoutParams()).setMargins(0, 0, AIOUtils.a(this.jdField_a_of_type_Float, getResources()), 0);
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
  
  public void setAdapter(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public void setContent(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject2 = paramIReadInJoyModel.a();
    if (localObject2 == null) {}
    Object localObject3;
    Object localObject1;
    Object localObject4;
    int[] arrayOfInt;
    label537:
    label619:
    label632:
    do
    {
      do
      {
        return;
        localObject3 = ((ArticleInfo)localObject2).innerUniqueID;
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        localObject4 = ReadInJoyBaseAdapter.a(((ArticleInfo)localObject2).mJsonPictureList, "pictures");
      } while ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0));
      j = a((JSONArray)localObject4, ((ArticleInfo)localObject2).articleStyle);
      arrayOfInt = new int[((JSONArray)localObject4).length()];
      if (j == 5) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Float = 3.0F;
        }
        if (j != 3) {
          break;
        }
        paramIReadInJoyModel = new LinearLayout(getContext());
        paramIReadInJoyModel.setOrientation(0);
        paramIReadInJoyModel.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = LayoutInflater.from(getContext()).inflate(2130969564, null);
        ((TextView)((View)localObject1).findViewById(2131367013)).setText(String.valueOf(((ArticleInfo)localObject2).mGalleryPicNumber) + "图");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)((View)localObject1).findViewById(2131361846));
        UtilsForComponent.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        paramIReadInJoyModel.addView((View)localObject1);
        ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ((ArticleInfo)localObject2).mSinglePicture, getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIReadInJoyModel);
        return;
      }
      if (j == 4)
      {
        localObject3 = new LinearLayout(getContext());
        ((LinearLayout)localObject3).setOrientation(0);
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramIReadInJoyModel = LayoutInflater.from(getContext()).inflate(2130969564, null);
        ((TextView)paramIReadInJoyModel.findViewById(2131367013)).setText(String.valueOf(((ArticleInfo)localObject2).mGalleryPicNumber) + "图");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
        this.b = new KandianUrlImageView(getContext());
        this.c = ((KandianUrlImageView)paramIReadInJoyModel.findViewById(2131361846));
        ((LinearLayout)localObject3).addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        ((LinearLayout)localObject3).addView(this.b);
        ((LinearLayout)localObject3).addView(paramIReadInJoyModel);
        a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b });
        b(new KandianUrlImageView[] { this.c });
        this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.c });
        if ((((ArticleInfo)localObject2).mPictures == null) || (((ArticleInfo)localObject2).mPictures.length <= 0))
        {
          paramIReadInJoyModel = ((JSONArray)localObject4).optJSONObject(0);
          if (paramIReadInJoyModel == null)
          {
            paramIReadInJoyModel = ((ArticleInfo)localObject2).mFirstPagePicUrl;
            localObject1 = ((JSONArray)localObject4).optJSONObject(1);
            if (localObject1 != null) {
              break label619;
            }
            localObject1 = ((ArticleInfo)localObject2).mFirstPagePicUrl;
            localObject4 = ((JSONArray)localObject4).optJSONObject(2);
            if (localObject4 != null) {
              break label632;
            }
          }
          for (localObject2 = ((ArticleInfo)localObject2).mFirstPagePicUrl;; localObject2 = ((JSONObject)localObject4).optString("picture"))
          {
            ReadInJoyDisplayUtils.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { ReadInJoyUtils.a(paramIReadInJoyModel), ReadInJoyUtils.a((String)localObject1), ReadInJoyUtils.a((String)localObject2) }), getContext());
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
            return;
            paramIReadInJoyModel = paramIReadInJoyModel.optString("picture");
            break;
            localObject1 = ((JSONObject)localObject1).optString("picture");
            break label537;
          }
        }
        if ((((ArticleInfo)localObject2).mPictures.length < 1) || (localObject2.mPictures[0] == null))
        {
          paramIReadInJoyModel = ((ArticleInfo)localObject2).mSinglePicture;
          if ((((ArticleInfo)localObject2).mPictures.length >= 2) && (localObject2.mPictures[1] != null)) {
            break label771;
          }
          localObject1 = ((ArticleInfo)localObject2).mSinglePicture;
          if ((((ArticleInfo)localObject2).mPictures.length >= 3) && (localObject2.mPictures[2] != null)) {
            break label783;
          }
        }
        for (localObject2 = ((ArticleInfo)localObject2).mSinglePicture;; localObject2 = localObject2.mPictures[2])
        {
          ReadInJoyDisplayUtils.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { paramIReadInJoyModel, localObject1, localObject2 }), getContext());
          break;
          paramIReadInJoyModel = localObject2.mPictures[0];
          break label671;
          localObject1 = localObject2.mPictures[1];
          break label698;
        }
      }
    } while (j != 5);
    label671:
    label698:
    ArrayList localArrayList = new ArrayList();
    label771:
    label783:
    Object localObject5 = a();
    int j = 0;
    JSONObject localJSONObject;
    label842:
    int k;
    if (j < 9)
    {
      localJSONObject = ((JSONArray)localObject4).optJSONObject(j);
      if (localJSONObject == null)
      {
        paramIReadInJoyModel = ((ArticleInfo)localObject2).mFirstPagePicUrl;
        if (localJSONObject != null) {
          break label920;
        }
        k = 0;
        label849:
        arrayOfInt[j] = k;
        if (!ReadInJoyUtils.a(paramIReadInJoyModel)) {
          break label1551;
        }
        paramIReadInJoyModel = ReadInJoyUtils.a(paramIReadInJoyModel, ((Integer)((Pair)localObject5).second).intValue(), ((Integer)((Pair)localObject5).first).intValue(), 1);
      }
    }
    label1551:
    for (;;)
    {
      localArrayList.add(ReadInJoyUtils.a(paramIReadInJoyModel));
      j += 1;
      break;
      paramIReadInJoyModel = localJSONObject.optString("picture");
      break label842;
      label920:
      k = localJSONObject.optInt("galleryIndex");
      break label849;
      paramIReadInJoyModel = new LinearLayout(getContext());
      localObject4 = new LinearLayout(getContext());
      localObject5 = new LinearLayout(getContext());
      ((LinearLayout.LayoutParams)localObject1).setMargins(DisplayUtil.a(getContext(), 11.0F), 0, DisplayUtil.a(getContext(), 11.0F), 0);
      paramIReadInJoyModel.setOrientation(0);
      paramIReadInJoyModel.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)localObject4).setOrientation(0);
      ((LinearLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)localObject5).setOrientation(0);
      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)localObject4).setPadding(0, AIOUtils.a(this.jdField_a_of_type_Float, getResources()), 0, 0);
      ((LinearLayout)localObject5).setPadding(0, AIOUtils.a(this.jdField_a_of_type_Float, getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(getContext());
      this.b = new KandianUrlImageView(getContext());
      this.c = new KandianUrlImageView(getContext());
      paramIReadInJoyModel.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
      paramIReadInJoyModel.addView(this.b);
      paramIReadInJoyModel.addView(this.c);
      this.d = new KandianUrlImageView(getContext());
      this.e = new KandianUrlImageView(getContext());
      this.f = new KandianUrlImageView(getContext());
      ((LinearLayout)localObject4).addView(this.d);
      ((LinearLayout)localObject4).addView(this.e);
      ((LinearLayout)localObject4).addView(this.f);
      localObject1 = LayoutInflater.from(getContext()).inflate(2130969564, null);
      ((TextView)((View)localObject1).findViewById(2131367013)).setText(String.valueOf(((ArticleInfo)localObject2).mGalleryPicNumber) + "图");
      this.g = new KandianUrlImageView(getContext());
      this.h = new KandianUrlImageView(getContext());
      this.i = ((KandianUrlImageView)((View)localObject1).findViewById(2131361846));
      ((LinearLayout)localObject5).addView(this.g);
      ((LinearLayout)localObject5).addView(this.h);
      ((LinearLayout)localObject5).addView((View)localObject1);
      a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.d, this.e, this.g, this.h });
      b(new KandianUrlImageView[] { this.c, this.f, this.i });
      this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i });
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_JavaUtilList, localArrayList, getContext());
      a(this.jdField_a_of_type_JavaUtilList, (ArticleInfo)localObject2, arrayOfInt, (String)localObject3);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIReadInJoyModel);
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