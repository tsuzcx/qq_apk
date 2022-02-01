package com.tencent.biz.pubaccount.weishi_new.follow.data;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import java.util.ArrayList;

public class WSFriendItemData
  extends WSAbsSubItem<ArrayList<stSimpleMetaFeed>>
  implements Foldable<stSimpleMetaFeed>
{
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public WSFriendItemData()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = new ArrayList();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  private boolean b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (a() == 0)) || (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramstSimpleMetaFeed.poster_id));
  }
  
  public int a()
  {
    return ((ArrayList)this.jdField_a_of_type_JavaLangObject).size();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {
      WeiShiCacheManager.a().a(a());
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (b(paramstSimpleMetaFeed)))
    {
      this.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.poster_id;
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramstSimpleMetaFeed.id);
      ((ArrayList)this.jdField_a_of_type_JavaLangObject).add(paramstSimpleMetaFeed);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData
 * JD-Core Version:    0.7.0.1
 */