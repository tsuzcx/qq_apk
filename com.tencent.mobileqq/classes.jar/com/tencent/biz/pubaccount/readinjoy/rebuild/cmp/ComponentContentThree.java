package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ComponentContentThree
  extends FrameLayout
  implements ComponentInheritView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  List jdField_a_of_type_JavaUtilList;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969573, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366877));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131361794));
    this.b = ((KandianUrlImageView)paramView.findViewById(2131361800));
    this.c = ((KandianUrlImageView)paramView.findViewById(2131361795));
    this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b, this.c });
    b();
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
  
  public void b()
  {
    UtilsForComponent.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, true);
    UtilsForComponent.a(getContext(), this.b, true);
    UtilsForComponent.a(getContext(), this.c, true);
    ((LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams()).setMargins(0, 0, AIOUtils.a(1.5F, getResources()), 0);
    ((LinearLayout.LayoutParams)this.b.getLayoutParams()).setMargins(0, 0, AIOUtils.a(1.5F, getResources()), 0);
  }
  
  public void setContent(IReadInJoyModel paramIReadInJoyModel)
  {
    Object localObject2 = paramIReadInJoyModel.a();
    if (localObject2 == null) {}
    Object localObject3;
    do
    {
      return;
      if ((((ArticleInfo)localObject2).mPictures != null) && (((ArticleInfo)localObject2).mPictures.length > 0)) {
        break;
      }
      localObject3 = ReadInJoyBaseAdapter.a(((ArticleInfo)localObject2).mJsonPictureList, "pictures");
    } while ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0));
    paramIReadInJoyModel = ((JSONArray)localObject3).optJSONObject(0);
    Object localObject1;
    if (paramIReadInJoyModel == null)
    {
      paramIReadInJoyModel = ((ArticleInfo)localObject2).mFirstPagePicUrl;
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
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { ReadInJoyUtils.a(paramIReadInJoyModel), ReadInJoyUtils.a((String)localObject1), ReadInJoyUtils.a((String)localObject2) }), getContext());
      return;
      paramIReadInJoyModel = paramIReadInJoyModel.optString("picture");
      break;
      localObject1 = ((JSONObject)localObject1).optString("picture");
      break label83;
    }
    if ((((ArticleInfo)localObject2).mPictures.length < 1) || (localObject2.mPictures[0] == null))
    {
      paramIReadInJoyModel = ((ArticleInfo)localObject2).mSinglePicture;
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
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { paramIReadInJoyModel, localObject1, localObject2 }), getContext());
      return;
      paramIReadInJoyModel = localObject2.mPictures[0];
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