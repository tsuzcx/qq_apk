package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
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
  public String c = "I:N";
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g;
  
  public AIOFilePicData()
  {
    this.jdField_b_of_type_JavaLangString = "I:N";
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
      localObject = this.c;
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
      str = this.c;
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
    super.a(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.f = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Boolean = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.jdField_a_of_type_Long = Long.valueOf(paramParcel.readString()).longValue();
    this.jdField_b_of_type_Long = Long.valueOf(paramParcel.readString()).longValue();
    this.jdField_e_of_type_Boolean = Boolean.valueOf(paramParcel.readString()).booleanValue();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramQQAppInterface.a().a(this.jdField_g_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
      this.c = paramQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath == null) {
        break label193;
      }
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
      label101:
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface;
      this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
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
      this.i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
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
    } while (!this.c.equals("I:N"));
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(String.valueOf(this.jdField_d_of_type_Boolean));
    paramParcel.writeString(String.valueOf(this.jdField_a_of_type_Long));
    paramParcel.writeString(String.valueOf(this.jdField_b_of_type_Long));
    paramParcel.writeString(String.valueOf(this.jdField_e_of_type_Boolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
 * JD-Core Version:    0.7.0.1
 */