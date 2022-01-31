package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import aqwl;
import bbtn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.io.File;

public class AIOFilePicData
  extends AIORichMediaData
{
  public int a;
  public long a;
  public FileManagerEntity a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g;
  public String h;
  public String i;
  
  public AIOFilePicData()
  {
    this.jdField_b_of_type_JavaLangString = "I:N";
    this.jdField_c_of_type_JavaLangString = "I:N";
    this.jdField_d_of_type_JavaLangString = "I:N";
    this.jdField_e_of_type_JavaLangString = "I:N";
  }
  
  public int a(String paramString)
  {
    return 0;
  }
  
  public File a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      localObject = null;
    }
    while ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      return localObject;
      localObject = this.jdField_b_of_type_JavaLangString;
      continue;
      localObject = this.jdField_c_of_type_JavaLangString;
      continue;
      localObject = this.jdField_d_of_type_JavaLangString;
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    Object localObject2 = null;
    String str;
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      str = null;
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (!str.equals("I:N"))
        {
          if (str.startsWith("/")) {
            break;
          }
          localObject1 = "file:/" + str;
        }
      }
      return localObject1;
      str = this.jdField_b_of_type_JavaLangString;
      continue;
      str = this.jdField_c_of_type_JavaLangString;
      continue;
      str = this.jdField_d_of_type_JavaLangString;
    }
    if (str.startsWith("//")) {
      return "file:" + str;
    }
    return "file:" + str;
  }
  
  public void a(Parcel paramParcel)
  {
    boolean bool = true;
    super.a(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.jdField_d_of_type_Boolean = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.jdField_a_of_type_Long = Long.valueOf(paramParcel.readString()).longValue();
    this.jdField_b_of_type_Long = Long.valueOf(paramParcel.readString()).longValue();
    this.jdField_e_of_type_Boolean = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_f_of_type_Boolean = bool;
      this.i = paramParcel.readString();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public void a(bbtn parambbtn)
  {
    if (parambbtn == null) {
      return;
    }
    String str;
    if (parambbtn.jdField_d_of_type_JavaLangString != null)
    {
      str = parambbtn.jdField_d_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = str;
      if (parambbtn.jdField_c_of_type_JavaLangString == null) {
        break label108;
      }
      str = parambbtn.jdField_c_of_type_JavaLangString;
      label34:
      this.jdField_c_of_type_JavaLangString = str;
      if (parambbtn.jdField_a_of_type_JavaLangString == null) {
        break label114;
      }
      str = parambbtn.jdField_a_of_type_JavaLangString;
      label51:
      this.jdField_d_of_type_JavaLangString = str;
      this.g = parambbtn.g;
      if (parambbtn.jdField_b_of_type_Int != 12) {
        break label120;
      }
    }
    label108:
    label114:
    label120:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = parambbtn.jdField_c_of_type_Long;
      this.jdField_h_of_type_Long = parambbtn.jdField_c_of_type_Long;
      this.jdField_e_of_type_Boolean = false;
      return;
      str = "I:N";
      break;
      str = "I:N";
      break label34;
      str = "I:N";
      break label51;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramQQAppInterface.a().a(this.jdField_f_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath == null) {
        break label181;
      }
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath;
      this.jdField_b_of_type_JavaLangString = paramQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath == null) {
        break label187;
      }
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath;
      label78:
      this.jdField_c_of_type_JavaLangString = paramQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath == null) {
        break label193;
      }
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
      label101:
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface;
      this.g = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {
        break label199;
      }
    }
    label181:
    label187:
    label193:
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_h_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime;
      this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.sendCloudUnsuccessful();
      return;
      paramQQAppInterface = "I:N";
      break;
      paramQQAppInterface = "I:N";
      break label78;
      paramQQAppInterface = "I:N";
      break label101;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.jdField_b_of_type_JavaLangString.equals("I:N"));
      return false;
      bool1 = bool2;
    } while (!this.jdField_c_of_type_JavaLangString.equals("I:N"));
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.g);
    paramParcel.writeString(String.valueOf(this.jdField_d_of_type_Boolean));
    paramParcel.writeString(String.valueOf(this.jdField_a_of_type_Long));
    paramParcel.writeString(String.valueOf(this.jdField_b_of_type_Long));
    paramParcel.writeString(String.valueOf(this.jdField_e_of_type_Boolean));
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    if (this.jdField_f_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.i);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
 * JD-Core Version:    0.7.0.1
 */