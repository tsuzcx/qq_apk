package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
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
import omr;
import onh;
import org.json.JSONArray;
import org.json.JSONObject;
import pau;
import pqo;
import pqy;
import puy;
import pym;
import ram;

public class ComponentContentThree
  extends FrameLayout
  implements pqo
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  List<KandianUrlImageView> jdField_a_of_type_JavaUtilList;
  puy jdField_a_of_type_Puy;
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
    this.jdField_a_of_type_Puy = new puy();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559864, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131374791));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131369091));
    this.b = ((KandianUrlImageView)paramView.findViewById(2131363988));
    this.c = ((KandianUrlImageView)paramView.findViewById(2131375249));
    this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.c });
    b();
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
  
  public void b()
  {
    pym.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, true);
    pym.a(getContext(), this.b, true);
    pym.a(getContext(), this.c, true);
    ((LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams()).setMargins(0, 0, actj.a(1.5F, getResources()), 0);
    ((LinearLayout.LayoutParams)this.b.getLayoutParams()).setMargins(0, 0, actj.a(1.5F, getResources()), 0);
  }
  
  public void setContent(pau parampau)
  {
    Object localObject2 = parampau.a();
    if (localObject2 == null) {}
    Object localObject3;
    do
    {
      return;
      if ((((ArticleInfo)localObject2).mPictures != null) && (((ArticleInfo)localObject2).mPictures.length > 0)) {
        break;
      }
      localObject3 = ram.a(((ArticleInfo)localObject2).mJsonPictureList, "pictures");
    } while ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0));
    parampau = ((JSONArray)localObject3).optJSONObject(0);
    Object localObject1;
    if (parampau == null)
    {
      parampau = ((ArticleInfo)localObject2).mFirstPagePicUrl;
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
      omr.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { onh.a(parampau), onh.a((String)localObject1), onh.a((String)localObject2) }), getContext());
      return;
      parampau = parampau.optString("picture");
      break;
      localObject1 = ((JSONObject)localObject1).optString("picture");
      break label83;
    }
    if ((((ArticleInfo)localObject2).mPictures.length < 1) || (localObject2.mPictures[0] == null))
    {
      parampau = ((ArticleInfo)localObject2).mSinglePicture;
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
      omr.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { parampau, localObject1, localObject2 }), getContext());
      return;
      parampau = localObject2.mPictures[0];
      break;
      localObject1 = localObject2.mPictures[1];
      break label218;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentThree
 * JD-Core Version:    0.7.0.1
 */