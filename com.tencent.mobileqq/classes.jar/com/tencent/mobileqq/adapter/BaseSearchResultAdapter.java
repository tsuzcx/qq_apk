package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchAdapterInterface.SearchResultCallBack;
import com.tencent.mobileqq.search.SearchTask;
import com.tencent.mobileqq.search.SearchTask.SearchTaskCallBack;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSearchResultAdapter
  extends BaseAdapter
  implements SearchTask.SearchTaskCallBack, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  protected SearchAdapterInterface.SearchResultCallBack a;
  private SearchTask jdField_a_of_type_ComTencentMobileqqSearchSearchTask;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  private List b;
  
  public BaseSearchResultAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List paramList)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = new ArrayList();
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return ImageUtil.a();
    }
    if (paramInt == 101) {
      return ImageUtil.h();
    }
    if (paramInt == 4) {
      return ImageUtil.f();
    }
    if (paramInt == 11) {
      return ImageUtil.b();
    }
    if (paramInt == 110) {
      return ImageUtil.d();
    }
    if (paramInt == 111) {
      return ImageUtil.e();
    }
    return ImageUtil.a();
  }
  
  public void a()
  {
    if (this.b != null)
    {
      this.b.clear();
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    paramList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface$SearchResultCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface$SearchResultCallBack.a(paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
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
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(List paramList)
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
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.cancel(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.b != null) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    int i;
    if ((!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < i)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof BaseSearchResultAdapter.ViewHolder)))
        {
          localObject = (BaseSearchResultAdapter.ViewHolder)localObject;
          if ((localObject != null) && (!TextUtils.isEmpty(((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString)) && (((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (paramInt2 == ((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_Int)) {
            ((BaseSearchResultAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
      }
      else
      {
        return;
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */