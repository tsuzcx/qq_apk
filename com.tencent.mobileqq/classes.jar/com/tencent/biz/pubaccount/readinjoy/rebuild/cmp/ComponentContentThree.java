package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aekt;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import orc;
import org.json.JSONArray;
import org.json.JSONObject;
import ors;
import pgd;
import pxj;
import pxt;
import qbs;
import qfg;
import rqj;

public class ComponentContentThree
  extends FrameLayout
  implements pxj
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  List<KandianUrlImageView> jdField_a_of_type_JavaUtilList;
  qbs jdField_a_of_type_Qbs;
  KandianUrlImageView b;
  KandianUrlImageView c;
  
  public ComponentContentThree(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentThree(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentContentThree(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qbs = new qbs();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559959, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131375254));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131369323));
    this.b = ((KandianUrlImageView)paramView.findViewById(2131364049));
    this.c = ((KandianUrlImageView)paramView.findViewById(2131375731));
    this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.c });
    b();
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pgd))
    {
      paramObject = (pgd)paramObject;
      this.jdField_a_of_type_Qbs.a(paramObject);
      setContent(paramObject);
    }
  }
  
  public void a(pxt parampxt)
  {
    this.jdField_a_of_type_Qbs.a(parampxt);
  }
  
  public void b()
  {
    qfg.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, true);
    qfg.a(getContext(), this.b, true);
    qfg.a(getContext(), this.c, true);
    ((LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams()).setMargins(0, 0, aekt.a(1.5F, getResources()), 0);
    ((LinearLayout.LayoutParams)this.b.getLayoutParams()).setMargins(0, 0, aekt.a(1.5F, getResources()), 0);
  }
  
  public void setContent(pgd parampgd)
  {
    Object localObject2 = parampgd.a();
    if (localObject2 == null) {}
    Object localObject3;
    do
    {
      return;
      if ((((ArticleInfo)localObject2).mPictures != null) && (((ArticleInfo)localObject2).mPictures.length > 0)) {
        break;
      }
      localObject3 = rqj.a(((ArticleInfo)localObject2).mJsonPictureList, "pictures");
    } while ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0));
    parampgd = ((JSONArray)localObject3).optJSONObject(0);
    Object localObject1;
    if (parampgd == null)
    {
      parampgd = ((ArticleInfo)localObject2).mFirstPagePicUrl;
      localObject1 = ((JSONArray)localObject3).optJSONObject(1);
      if (localObject1 != null) {
        break label151;
      }
      localObject1 = ((ArticleInfo)localObject2).mFirstPagePicUrl;
      label83:
      localObject3 = ((JSONArray)localObject3).optJSONObject(2);
      if (localObject3 != null) {
        break label161;
      }
    }
    label151:
    label161:
    for (localObject2 = ((ArticleInfo)localObject2).mFirstPagePicUrl;; localObject2 = ((JSONObject)localObject3).optString("picture"))
    {
      orc.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { ors.a(parampgd), ors.a((String)localObject1), ors.a((String)localObject2) }), getContext());
      return;
      parampgd = parampgd.optString("picture");
      break;
      localObject1 = ((JSONObject)localObject1).optString("picture");
      break label83;
    }
    if ((((ArticleInfo)localObject2).mPictures.length < 1) || (localObject2.mPictures[0] == null))
    {
      parampgd = ((ArticleInfo)localObject2).mSinglePicture;
      if ((((ArticleInfo)localObject2).mPictures.length >= 2) && (localObject2.mPictures[1] != null)) {
        break label282;
      }
      localObject1 = ((ArticleInfo)localObject2).mSinglePicture;
      label218:
      if ((((ArticleInfo)localObject2).mPictures.length >= 3) && (localObject2.mPictures[2] != null)) {
        break label292;
      }
    }
    label282:
    label292:
    for (localObject2 = ((ArticleInfo)localObject2).mSinglePicture;; localObject2 = localObject2.mPictures[2])
    {
      orc.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { parampgd, localObject1, localObject2 }), getContext());
      return;
      parampgd = localObject2.mPictures[0];
      break;
      localObject1 = localObject2.mPictures[1];
      break label218;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentThree
 * JD-Core Version:    0.7.0.1
 */