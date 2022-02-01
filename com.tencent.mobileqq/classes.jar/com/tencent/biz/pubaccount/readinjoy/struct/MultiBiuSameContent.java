package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.MultiBiuSameContent;

public class MultiBiuSameContent
  implements Parcelable
{
  public static final Parcelable.Creator<MultiBiuSameContent> CREATOR = new MultiBiuSameContent.1();
  public int a;
  public long a;
  public String a;
  public ArrayList<SocializeFeedsInfo.BiuCommentInfo> a;
  public int b;
  public long b;
  public int c;
  public long c;
  public int d;
  
  public MultiBiuSameContent()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected MultiBiuSameContent(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(SocializeFeedsInfo.BiuCommentInfo.CREATOR);
  }
  
  public static ArrayList<MultiBiuSameContent> a(List<articlesummary.MultiBiuSameContent> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      MultiBiuSameContent localMultiBiuSameContent;
      try
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          Object localObject = (articlesummary.MultiBiuSameContent)paramList.next();
          localMultiBiuSameContent = new MultiBiuSameContent();
          localMultiBiuSameContent.jdField_a_of_type_JavaLangString = ((articlesummary.MultiBiuSameContent)localObject).bytes_biu_comments.get().toStringUtf8();
          localMultiBiuSameContent.jdField_a_of_type_Long = ((articlesummary.MultiBiuSameContent)localObject).uint64_uin.get();
          localMultiBiuSameContent.jdField_a_of_type_Int = ((articlesummary.MultiBiuSameContent)localObject).enum_uin_type.get();
          localMultiBiuSameContent.jdField_b_of_type_Int = ((articlesummary.MultiBiuSameContent)localObject).uint32_biu_time.get();
          localMultiBiuSameContent.jdField_b_of_type_Long = ((articlesummary.MultiBiuSameContent)localObject).uint64_feeds_id.get();
          localMultiBiuSameContent.jdField_c_of_type_Int = ((articlesummary.MultiBiuSameContent)localObject).uint32_feeds_type.get();
          localMultiBiuSameContent.d = ((articlesummary.MultiBiuSameContent)localObject).uint32_strategy_id.get();
          localMultiBiuSameContent.jdField_c_of_type_Long = ((articlesummary.MultiBiuSameContent)localObject).uint64_algorithm_id.get();
          if ((((articlesummary.MultiBiuSameContent)localObject).rpt_biu_mutli_level.has()) && (((articlesummary.MultiBiuSameContent)localObject).rpt_biu_mutli_level.get() != null))
          {
            localObject = ((articlesummary.MultiBiuSameContent)localObject).rpt_biu_mutli_level.get().iterator();
            if (((Iterator)localObject).hasNext())
            {
              articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)((Iterator)localObject).next();
              localMultiBiuSameContent.jdField_a_of_type_JavaUtilArrayList.add(SocializeFeedsInfo.a(localBiuOneLevelItem));
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiBiuSameContent", 2, "parseFromPBBytes error:" + paramList.toString());
        }
      }
      localArrayList.add(localMultiBiuSameContent);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent
 * JD-Core Version:    0.7.0.1
 */