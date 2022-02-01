package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;

public class FeedsPreloadDataModule$PreloadCache
{
  public int a;
  public ToServiceMsg a;
  public String a;
  public List<ArticleInfo> a;
  public boolean a;
  public byte[] a;
  public int b;
  public List<ArticleInfo> b;
  public boolean b;
  
  public PreloadCache a()
  {
    PreloadCache localPreloadCache = new PreloadCache();
    localPreloadCache.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg).a(this.jdField_a_of_type_Int).b(this.jdField_b_of_type_Int).a(this.jdField_a_of_type_JavaUtilList).b(this.jdField_b_of_type_JavaUtilList).a(this.jdField_a_of_type_Boolean).b(this.jdField_b_of_type_Boolean).a(this.jdField_a_of_type_ArrayOfByte).a(this.jdField_a_of_type_JavaLangString);
    return localPreloadCache;
  }
  
  public PreloadCache a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public PreloadCache a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
    return this;
  }
  
  public PreloadCache a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public PreloadCache a(List<ArticleInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public PreloadCache a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public PreloadCache a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    return this;
  }
  
  public PreloadCache b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public PreloadCache b(List<ArticleInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public PreloadCache b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadDataModule.PreloadCache
 * JD-Core Version:    0.7.0.1
 */