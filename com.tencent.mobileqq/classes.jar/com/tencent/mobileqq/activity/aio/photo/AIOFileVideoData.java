package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;

public class AIOFileVideoData
  extends AIORichMediaData
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f;
  private boolean f;
  public String g;
  public String h;
  public String i;
  public String j;
  private String k = null;
  
  public AIOFileVideoData()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
  }
  
  public AIOFileVideoData(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private void a(Context paramContext, VideoPlayControllerForAIO paramVideoPlayControllerForAIO)
  {
    paramVideoPlayControllerForAIO = new AIOFileVideoData.1(this, paramContext, paramVideoPlayControllerForAIO);
    FMDialogUtil.a(paramContext, paramContext.getString(2131692561), paramContext.getString(2131692563), paramVideoPlayControllerForAIO);
  }
  
  private boolean c()
  {
    if (this.jdField_e_of_type_Boolean) {
      return false;
    }
    if (!FileManagerUtil.a()) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_h_of_type_Long > 0L) && (this.jdField_h_of_type_Long > this.jdField_a_of_type_Long)) {
      return true;
    }
    return this.jdField_h_of_type_Long > 1048576L;
  }
  
  public VideoPlayMedioInfo a(boolean paramBoolean)
  {
    VideoPlayMedioInfo localVideoPlayMedioInfo = new VideoPlayMedioInfo();
    localVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_d_of_type_JavaLangString };
    localVideoPlayMedioInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    localVideoPlayMedioInfo.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_JavaLangString);
    localVideoPlayMedioInfo.jdField_a_of_type_Boolean = (a() ^ true);
    String str;
    if (localVideoPlayMedioInfo.jdField_a_of_type_Boolean) {
      str = this.jdField_f_of_type_JavaLangString;
    } else {
      str = this.jdField_c_of_type_JavaLangString;
    }
    localVideoPlayMedioInfo.jdField_a_of_type_JavaLangString = str;
    localVideoPlayMedioInfo.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
    localVideoPlayMedioInfo.jdField_b_of_type_Boolean = true;
    localVideoPlayMedioInfo.jdField_b_of_type_Long = this.jdField_h_of_type_Long;
    localVideoPlayMedioInfo.jdField_a_of_type_Long = this.jdField_f_of_type_Long;
    localVideoPlayMedioInfo.jdField_b_of_type_Int = this.jdField_f_of_type_Int;
    localVideoPlayMedioInfo.jdField_e_of_type_Boolean = paramBoolean;
    return localVideoPlayMedioInfo;
  }
  
  public File a(int paramInt)
  {
    if (!FileUtil.a(this.jdField_b_of_type_JavaLangString)) {
      return null;
    }
    return new File(this.jdField_b_of_type_JavaLangString);
  }
  
  public String a()
  {
    return this.k;
  }
  
  public String a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return "";
    }
    if (!this.jdField_b_of_type_JavaLangString.startsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:/");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    if (this.jdField_b_of_type_JavaLangString.startsWith("//"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    int m = paramParcel.readInt();
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.j = paramParcel.readString();
  }
  
  public void a(View paramView, VideoPlayControllerForAIO paramVideoPlayControllerForAIO)
  {
    if (c())
    {
      if (QFileUtils.a(paramView.getContext(), false, new AIOFileVideoData.2(this, paramVideoPlayControllerForAIO, paramView))) {
        a(paramView.getContext(), paramVideoPlayControllerForAIO);
      }
    }
    else
    {
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = false;
        paramVideoPlayControllerForAIO.a(paramView, a(false));
      }
      paramVideoPlayControllerForAIO.b();
      paramVideoPlayControllerForAIO.f();
    }
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.jdField_h_of_type_JavaLangString = paramDataLineMsgRecord.frienduin;
    this.jdField_c_of_type_Int = paramDataLineMsgRecord.istroop;
    this.jdField_d_of_type_Int = paramDataLineMsgRecord.issend;
    this.jdField_f_of_type_Long = paramDataLineMsgRecord.uniseq;
    this.jdField_g_of_type_Long = paramDataLineMsgRecord.time;
    this.jdField_i_of_type_Long = paramDataLineMsgRecord.shmsgseq;
    this.jdField_h_of_type_Long = paramDataLineMsgRecord.filesize;
    this.jdField_a_of_type_JavaLangString = paramDataLineMsgRecord.filename;
    this.jdField_g_of_type_Int = 0;
    if (FileUtils.fileExistsAndNotEmpty(paramDataLineMsgRecord.path))
    {
      this.jdField_c_of_type_JavaLangString = paramDataLineMsgRecord.path;
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return true;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return FileUtil.a(this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean a(IAIOImageProvider paramIAIOImageProvider)
  {
    if (a()) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    paramIAIOImageProvider.a(this.jdField_f_of_type_Long, this.jdField_f_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(this.k) ^ true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */