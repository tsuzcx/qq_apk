package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.util.Utils;
import java.util.List;
import java.util.Set;

public class AvatarInfo
{
  public static int a;
  public static String a;
  public long a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "-5";
    jdField_a_of_type_Int = -5;
  }
  
  public AvatarInfo()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  public static final AvatarInfo a(TroopClipPic paramTroopClipPic, Set<String> paramSet)
  {
    AvatarInfo localAvatarInfo = new AvatarInfo();
    localAvatarInfo.jdField_c_of_type_JavaLangString = paramTroopClipPic.id;
    localAvatarInfo.jdField_d_of_type_JavaLangString = paramTroopClipPic.clipInfo;
    localAvatarInfo.jdField_d_of_type_Int = paramTroopClipPic.type;
    localAvatarInfo.jdField_b_of_type_Int = 1;
    if (paramSet != null) {
      localAvatarInfo.jdField_c_of_type_Boolean = paramSet.contains(paramTroopClipPic.id);
    }
    return localAvatarInfo;
  }
  
  public static final boolean a(List<AvatarInfo> paramList1, List<AvatarInfo> paramList2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramList1 == paramList2) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramList1 == null);
        bool1 = bool2;
      } while (paramList2 == null);
      bool1 = bool2;
    } while (paramList1.size() != paramList2.size());
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label89;
      }
      bool1 = bool2;
      if (!((AvatarInfo)paramList1.get(i)).equals(paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label89:
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof AvatarInfo))) {}
    do
    {
      return false;
      paramObject = (AvatarInfo)paramObject;
    } while ((!Utils.a(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString)) || (!Utils.a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) || (this.jdField_a_of_type_Boolean != paramObject.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean != paramObject.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean != paramObject.jdField_d_of_type_Boolean) || (!Utils.a(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)) || (this.jdField_d_of_type_Int != paramObject.jdField_d_of_type_Int) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AvatarInfo=[").append("seq").append("=").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" ").append("fromType").append("=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" ").append("type").append("=").append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" ").append("isUploading").append("=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" ").append("isVerifying").append("=").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(" ").append("clipInfo").append("=").append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" ").append("ts").append("=").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ").append("localFile").append("=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AvatarInfo
 * JD-Core Version:    0.7.0.1
 */