package com.tencent.av.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import kie;

public class InviteBaseData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new kie();
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d = "-1";
  
  public InviteBaseData()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  public InviteBaseData(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readString();
  }
  
  public InviteBaseData(AVPhoneUserInfo paramAVPhoneUserInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = 0;
    if (paramAVPhoneUserInfo == null) {}
    label181:
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangString = String.valueOf(paramAVPhoneUserInfo.account);
      if (paramAVPhoneUserInfo.accountType == 1) {}
      for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int = 1006) {
        do
        {
          if (paramAVPhoneUserInfo.telInfo == null) {
            break label181;
          }
          this.c = paramAVPhoneUserInfo.telInfo.mobile;
          paramQQAppInterface = ((PhoneContactManager)paramQQAppInterface.getManager(10)).b(this.c);
          if (paramQQAppInterface == null) {
            break label189;
          }
          this.jdField_b_of_type_JavaLangString = paramQQAppInterface.name;
          if (TextUtils.isEmpty(paramQQAppInterface.uin)) {
            break;
          }
          if (!paramQQAppInterface.uin.equals("0")) {
            break label183;
          }
          this.jdField_a_of_type_Int = 1006;
          this.c = (paramAVPhoneUserInfo.telInfo.nation + paramAVPhoneUserInfo.telInfo.mobile);
          return;
        } while ((paramAVPhoneUserInfo.accountType != 2) && (paramAVPhoneUserInfo.accountType != 3));
      }
    }
    label183:
    this.jdField_a_of_type_Int = 0;
    return;
    label189:
    this.jdField_b_of_type_JavaLangString = paramAVPhoneUserInfo.telInfo.mobile;
  }
  
  public InviteBaseData(DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    this.jdField_b_of_type_Int = 0;
    this.d = paramDiscussionMemberInfo.discussionUin;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[uin=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",type=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",phone=").append(this.c).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.InviteBaseData
 * JD-Core Version:    0.7.0.1
 */