package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData.SearchWord;
import java.util.ArrayList;
import java.util.List;

final class FastWebArticleInfo$1
  implements Parcelable.Creator<FastWebArticleInfo>
{
  public FastWebArticleInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    int j = 0;
    FastWebArticleInfo localFastWebArticleInfo = new FastWebArticleInfo();
    localFastWebArticleInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localFastWebArticleInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localFastWebArticleInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.e = paramParcel.readString();
    localFastWebArticleInfo.f = paramParcel.readString();
    localFastWebArticleInfo.h = paramParcel.readString();
    localFastWebArticleInfo.g = paramParcel.readString();
    localFastWebArticleInfo.j = paramParcel.readString();
    localFastWebArticleInfo.i = paramParcel.readString();
    localFastWebArticleInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localFastWebArticleInfo.l = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localFastWebArticleInfo.jdField_b_of_type_Boolean = bool1;
      localFastWebArticleInfo.o = paramParcel.readString();
      localFastWebArticleInfo.jdField_d_of_type_Long = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label290;
      }
    }
    int k;
    Object localObject;
    int i;
    ArticleTopicData.TopicInfo localTopicInfo;
    label290:
    for (boolean bool1 = true;; bool1 = false)
    {
      localFastWebArticleInfo.jdField_c_of_type_Boolean = bool1;
      localFastWebArticleInfo.q = paramParcel.readString();
      k = paramParcel.readInt();
      if (k < 0) {
        break label412;
      }
      localObject = new ArrayList();
      i = 0;
      while (i < k)
      {
        localTopicInfo = new ArticleTopicData.TopicInfo();
        localTopicInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
        localTopicInfo.jdField_a_of_type_Long = paramParcel.readLong();
        localTopicInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
        ((List)localObject).add(localTopicInfo);
        i += 1;
      }
      bool1 = false;
      break;
    }
    label412:
    for (localFastWebArticleInfo.jdField_a_of_type_JavaUtilList = ((List)localObject);; localFastWebArticleInfo.jdField_a_of_type_JavaUtilList = null)
    {
      k = paramParcel.readInt();
      if (k <= 0) {
        break label596;
      }
      localFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData = new RelatedSearchData(localFastWebArticleInfo);
      localFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData.jdField_a_of_type_JavaUtilList = new ArrayList();
      i = 0;
      while (i < k)
      {
        localObject = new RelatedSearchData.SearchWord();
        ((RelatedSearchData.SearchWord)localObject).jdField_a_of_type_JavaLangString = paramParcel.readString();
        ((RelatedSearchData.SearchWord)localObject).jdField_b_of_type_JavaLangString = paramParcel.readString();
        ((RelatedSearchData.SearchWord)localObject).jdField_a_of_type_Float = paramParcel.readFloat();
        ((RelatedSearchData.SearchWord)localObject).jdField_c_of_type_JavaLangString = paramParcel.readString();
        ((RelatedSearchData.SearchWord)localObject).jdField_a_of_type_Int = paramParcel.readInt();
        i += 1;
      }
    }
    localFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localFastWebArticleInfo.p = paramParcel.readString();
    localFastWebArticleInfo.q = paramParcel.readString();
    localFastWebArticleInfo.r = paramParcel.readString();
    localFastWebArticleInfo.s = paramParcel.readString();
    localFastWebArticleInfo.jdField_d_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localFastWebArticleInfo.jdField_d_of_type_Boolean = bool1;
      localFastWebArticleInfo.t = paramParcel.readString();
      k = paramParcel.readInt();
      if (k <= 0) {
        break label621;
      }
      localObject = new ArrayList();
      i = j;
      while (i < k)
      {
        localTopicInfo = new ArticleTopicData.TopicInfo();
        localTopicInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
        localTopicInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
        localTopicInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
        ((List)localObject).add(localTopicInfo);
        i += 1;
      }
      label596:
      localFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData = null;
      break;
    }
    localFastWebArticleInfo.jdField_b_of_type_JavaUtilList = ((List)localObject);
    return localFastWebArticleInfo;
    label621:
    localFastWebArticleInfo.jdField_b_of_type_JavaUtilList = null;
    return localFastWebArticleInfo;
  }
  
  public FastWebArticleInfo[] a(int paramInt)
  {
    return new FastWebArticleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo.1
 * JD-Core Version:    0.7.0.1
 */