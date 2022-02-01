package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stCardInfo;
import UserGrowth.stCollection;
import UserGrowth.stCollectionCardInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.collection.WSCollectionItemData;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedCollectionController;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;

public class WSGridCollectionItemView
  implements IWSItemView<stSimpleMetaFeed>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<WSGridFeedCollectionController> jdField_a_of_type_AndroidUtilSparseArray;
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
  private final WSGridCollectionHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCollectionHolder;
  
  public WSGridCollectionItemView(Context paramContext, View paramView, WSGridCollectionHolder paramWSGridCollectionHolder)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCollectionHolder = paramWSGridCollectionHolder;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    d();
  }
  
  private void a(int paramInt1, int paramInt2, ArrayList<stCollection> paramArrayList)
  {
    int j = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCollectionHolder.getLayoutPosition();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter != null) {}
    for (String str = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.a;; str = "")
    {
      int i = 0;
      while (i < paramInt2)
      {
        WSCollectionItemData localWSCollectionItemData = new WSCollectionItemData((stCollection)paramArrayList.get(i), paramInt1);
        WSGridFeedCollectionController localWSGridFeedCollectionController2 = (WSGridFeedCollectionController)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        WSGridFeedCollectionController localWSGridFeedCollectionController1 = localWSGridFeedCollectionController2;
        if (localWSGridFeedCollectionController2 == null)
        {
          localWSGridFeedCollectionController1 = new WSGridFeedCollectionController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
          this.jdField_a_of_type_AndroidUtilSparseArray.append(i, localWSGridFeedCollectionController1);
        }
        localWSGridFeedCollectionController1.b(j);
        localWSGridFeedCollectionController1.a(this.jdField_a_of_type_AndroidViewViewGroup);
        localWSGridFeedCollectionController1.c(i);
        localWSGridFeedCollectionController1.a(str);
        localWSGridFeedCollectionController1.a(localWSCollectionItemData);
        i += 1;
      }
      return;
    }
  }
  
  private void d(int paramInt)
  {
    int i = paramInt;
    if (paramInt + 1 >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
      return;
    }
    label16:
    WSGridFeedCollectionController localWSGridFeedCollectionController;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localWSGridFeedCollectionController = (WSGridFeedCollectionController)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localWSGridFeedCollectionController != null) {
        break label50;
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label50:
      localWSGridFeedCollectionController.e();
    }
  }
  
  private void e()
  {
    stCardInfo localstCardInfo = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.cardInfo;
    Object localObject = localstCardInfo.collectionCardInfo;
    WSLog.a("WSGridCollectionItemView", "setData :" + ((stCollectionCardInfo)localObject).toString());
    String str = ((stCollectionCardInfo)localObject).title;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    localObject = ((stCollectionCardInfo)localObject).collectionList;
    int i = Math.min(((ArrayList)localObject).size(), 5);
    a(localstCardInfo.cardType, i, (ArrayList)localObject);
    d(i);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    e();
  }
  
  public void a(WSRecommendAdapter paramWSRecommendAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter = paramWSRecommendAdapter;
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void d()
  {
    WSLog.a("WSGridCollectionItemView", "initUI:" + this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366768));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridCollectionItemView
 * JD-Core Version:    0.7.0.1
 */