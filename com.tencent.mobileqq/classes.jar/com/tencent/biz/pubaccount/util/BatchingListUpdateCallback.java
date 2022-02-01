package com.tencent.biz.pubaccount.util;

public class BatchingListUpdateCallback
  implements ListUpdateCallback
{
  int jdField_a_of_type_Int = 0;
  final ListUpdateCallback jdField_a_of_type_ComTencentBizPubaccountUtilListUpdateCallback;
  Object jdField_a_of_type_JavaLangObject = null;
  int b = -1;
  int c = -1;
  
  public BatchingListUpdateCallback(ListUpdateCallback paramListUpdateCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilListUpdateCallback = paramListUpdateCallback;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 0) {
      return;
    }
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          this.jdField_a_of_type_ComTencentBizPubaccountUtilListUpdateCallback.a(this.b, this.c, this.jdField_a_of_type_JavaLangObject);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilListUpdateCallback.b(this.b, this.c);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilListUpdateCallback.a(this.b, this.c);
    }
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      int i = this.b;
      if (paramInt1 >= i)
      {
        int j = this.c;
        if (paramInt1 <= i + j)
        {
          this.c = (j + paramInt2);
          this.b = Math.min(paramInt1, i);
          return;
        }
      }
    }
    a();
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_Int == 3)
    {
      int i = this.b;
      int j = this.c;
      if (paramInt1 <= i + j)
      {
        int k = paramInt1 + paramInt2;
        if ((k >= i) && (this.jdField_a_of_type_JavaLangObject == paramObject))
        {
          this.b = Math.min(paramInt1, i);
          this.c = (Math.max(j + i, k) - this.b);
          return;
        }
      }
    }
    a();
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = 3;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      int i = this.b;
      if ((i >= paramInt1) && (i <= paramInt1 + paramInt2))
      {
        this.c += paramInt2;
        this.b = paramInt1;
        return;
      }
    }
    a();
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Int = 2;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountUtilListUpdateCallback.c(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.BatchingListUpdateCallback
 * JD-Core Version:    0.7.0.1
 */