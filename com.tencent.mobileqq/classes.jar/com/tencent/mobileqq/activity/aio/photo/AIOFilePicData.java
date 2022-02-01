package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
  }
  
  public int a(String paramString)
  {
    return 0;
  }
  
  public File a(int paramInt)
  {
    Object localObject;
    if (paramInt != 16)
    {
      if (paramInt != 18)
      {
        if (paramInt != 20) {
          localObject = null;
        } else {
          localObject = this.jdField_d_of_type_JavaLangString;
        }
      }
      else {
        localObject = this.jdField_c_of_type_JavaLangString;
      }
    }
    else {
      localObject = this.jdField_b_of_type_JavaLangString;
    }
    if ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    String str;
    if (paramInt != 16)
    {
      if (paramInt != 18)
      {
        if (paramInt != 20) {
          str = null;
        } else {
          str = this.jdField_d_of_type_JavaLangString;
        }
      }
      else {
        str = this.jdField_c_of_type_JavaLangString;
      }
    }
    else {
      str = this.jdField_b_of_type_JavaLangString;
    }
    if ((str != null) && (!str.equals("I:N")))
    {
      if (!str.startsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:/");
        localStringBuilder.append(str);
        return localStringBuilder.toString();
      }
      if (str.startsWith("//"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:");
        localStringBuilder.append(str);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public void a(Parcel paramParcel)
  {
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
    int j = paramParcel.readInt();
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    this.jdField_f_of_type_Boolean = bool;
    this.i = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(this.jdField_f_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.strMiddleThumPath;
      String str = "I:N";
      if (paramQQAppInterface != null) {
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath;
      } else {
        paramQQAppInterface = "I:N";
      }
      this.jdField_b_of_type_JavaLangString = paramQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath != null) {
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath;
      } else {
        paramQQAppInterface = "I:N";
      }
      this.jdField_c_of_type_JavaLangString = paramQQAppInterface;
      paramQQAppInterface = str;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() != null) {
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
      }
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface;
      this.g = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_d_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_h_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime;
      this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.sendCloudUnsuccessful();
    }
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null) {
      return;
    }
    Object localObject = paramDataLineMsgRecord.thumbPath;
    String str = "I:N";
    if (localObject != null) {
      localObject = paramDataLineMsgRecord.thumbPath;
    } else {
      localObject = "I:N";
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject);
    if (paramDataLineMsgRecord.thumbPath != null) {
      localObject = paramDataLineMsgRecord.thumbPath;
    } else {
      localObject = "I:N";
    }
    this.jdField_c_of_type_JavaLangString = ((String)localObject);
    localObject = str;
    if (paramDataLineMsgRecord.path != null) {
      localObject = paramDataLineMsgRecord.path;
    }
    this.jdField_d_of_type_JavaLangString = ((String)localObject);
    this.g = paramDataLineMsgRecord.filename;
    this.jdField_a_of_type_Long = paramDataLineMsgRecord.filesize;
    this.jdField_h_of_type_Long = paramDataLineMsgRecord.filesize;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    if (paramTroopFileStatusInfo == null) {
      return;
    }
    Object localObject = paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
    String str = "I:N";
    if (localObject != null) {
      localObject = paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
    } else {
      localObject = "I:N";
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject);
    if (paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString != null) {
      localObject = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    } else {
      localObject = "I:N";
    }
    this.jdField_c_of_type_JavaLangString = ((String)localObject);
    localObject = str;
    if (paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString != null) {
      localObject = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
    }
    this.jdField_d_of_type_JavaLangString = ((String)localObject);
    this.g = paramTroopFileStatusInfo.g;
    boolean bool;
    if (paramTroopFileStatusInfo.jdField_b_of_type_Int == 12) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_d_of_type_Boolean = bool;
    this.jdField_a_of_type_Long = paramTroopFileStatusInfo.jdField_c_of_type_Long;
    this.jdField_h_of_type_Long = paramTroopFileStatusInfo.jdField_c_of_type_Long;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt != 16)
    {
      if (paramInt != 18) {
        return paramInt == 20;
      }
      return this.jdField_c_of_type_JavaLangString.equals("I:N") ^ true;
    }
    return this.jdField_b_of_type_JavaLangString.equals("I:N") ^ true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
 * JD-Core Version:    0.7.0.1
 */