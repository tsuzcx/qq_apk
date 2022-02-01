package com.tencent.biz.pubaccount.readinjoy.mvp;

import android.support.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class ListModel<BEAN, COOKIE>
  implements ListContract.IListModel<BEAN>
{
  protected int a;
  @Nullable
  private COOKIE jdField_a_of_type_JavaLangObject = null;
  private String jdField_a_of_type_JavaLangString = "";
  protected CopyOnWriteArrayList<BEAN> a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  
  public ListModel()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, List<BEAN> paramList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString, ListContract.FirstPageCallback<BEAN> paramFirstPageCallback)
  {
    this.jdField_a_of_type_Boolean = true;
    if ((paramBoolean2) && (paramInt1 >= 0)) {
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (this.jdField_b_of_type_Boolean) {
      if (paramBoolean2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(paramList);
        a(paramList);
        this.jdField_a_of_type_JavaLangObject = paramCOOKIE;
        if (!paramBoolean3)
        {
          paramBoolean1 = true;
          this.d = paramBoolean1;
        }
      }
      else
      {
        paramFirstPageCallback.a(paramBoolean2, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
      }
    }
    do
    {
      return;
      paramBoolean1 = false;
      break;
      if (paramBoolean2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(paramList);
        this.jdField_a_of_type_JavaLangObject = paramCOOKIE;
        if (!paramBoolean3) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          this.d = paramBoolean1;
          paramFirstPageCallback.a(true, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
          return;
        }
      }
      this.c = true;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_JavaLangString = paramString;
    } while (paramBoolean1);
    paramFirstPageCallback.a(false, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
  }
  
  public void a(ListContract.NextPageCallback<BEAN> paramNextPageCallback)
  {
    a(this.jdField_a_of_type_JavaLangObject, new ListModel.3(this, paramNextPageCallback));
  }
  
  public abstract void a(ListModel.LoadDataFromDBCallback<BEAN> paramLoadDataFromDBCallback);
  
  public abstract void a(@Nullable COOKIE paramCOOKIE, ListModel.LoadDataFromNetworkCallback<BEAN, COOKIE> paramLoadDataFromNetworkCallback);
  
  public abstract void a(List<BEAN> paramList);
  
  public void a(boolean paramBoolean, ListContract.FirstPageCallback<BEAN> paramFirstPageCallback)
  {
    a();
    if (paramBoolean) {
      a(new ListModel.1(this, paramFirstPageCallback));
    }
    a(null, new ListModel.2(this, paramBoolean, paramFirstPageCallback));
  }
  
  public boolean a()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.mvp.ListModel
 * JD-Core Version:    0.7.0.1
 */