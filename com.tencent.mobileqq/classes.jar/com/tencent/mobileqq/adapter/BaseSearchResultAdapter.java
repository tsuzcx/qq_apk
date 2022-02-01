package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.search.ISearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface.SearchResultCallBack;
import com.tencent.mobileqq.search.SearchTask;
import com.tencent.mobileqq.search.SearchTask.SearchTaskCallBack;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSearchResultAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener, SearchTask.SearchTaskCallBack, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  protected SearchAdapterInterface.SearchResultCallBack a;
  private SearchTask jdField_a_of_type_ComTencentMobileqqSearchSearchTask = null;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<? extends ISearchable> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  private List<ISearchable> b;
  
  public BaseSearchResultAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<? extends ISearchable> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface$SearchResultCallBack = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = new ArrayList();
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return ImageUtil.f();
    }
    if (paramInt == 101) {
      return ImageUtil.e();
    }
    if (paramInt == 4) {
      return ImageUtil.d();
    }
    if (paramInt == 11) {
      return ImageUtil.b();
    }
    if (paramInt == 110) {
      return ImageUtil.i();
    }
    if (paramInt == 111) {
      return ImageUtil.j();
    }
    return ImageUtil.f();
  }
  
  public void a()
  {
    List localList = this.b;
    if (localList != null)
    {
      localList.clear();
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, List<? extends ISearchable> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    paramList.clear();
    paramList = this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface$SearchResultCallBack;
    if (paramList != null) {
      paramList.a(paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void a(List<? extends ISearchable> paramList)
  {
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  protected boolean a(BaseSearchResultAdapter.ViewHolder paramViewHolder)
  {
    return (paramViewHolder != null) && (!TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_JavaLangString));
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask;
    if (localObject != null) {
      ((SearchTask)localObject).cancel(true);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      paramInt1 = this.jdField_a_of_type_Int;
      if ((paramInt1 == 0) || (paramInt1 == 1))
      {
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
          if ((localObject != null) && ((localObject instanceof BaseSearchResultAdapter.ViewHolder)))
          {
            localObject = (BaseSearchResultAdapter.ViewHolder)localObject;
            if ((localObject != null) && (!TextUtils.isEmpty(((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString)) && (((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (paramInt2 == ((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_Int))
            {
              ((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
              return;
            }
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt = 0;
    while (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView != null) && ((paramAbsListView instanceof BaseSearchResultAdapter.ViewHolder)))
      {
        paramAbsListView = (BaseSearchResultAdapter.ViewHolder)paramAbsListView;
        if (a(paramAbsListView)) {
          paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramAbsListView.jdField_a_of_type_JavaLangString, paramAbsListView.jdField_a_of_type_Int));
        }
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */