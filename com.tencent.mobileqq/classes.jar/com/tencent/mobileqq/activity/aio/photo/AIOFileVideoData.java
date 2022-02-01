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
    FMDialogUtil.a(paramContext, paramContext.getString(2131692609), paramContext.getString(2131692611), paramVideoPlayControllerForAIO);
  }
  
  private boolean c()
  {
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      do
      {
        return false;
      } while (!FileManagerUtil.a());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_h_of_type_Long > 0L) && (this.jdField_h_of_type_Long > this.jdField_a_of_type_Long)) {
        return true;
      }
    } while (this.jdField_h_of_type_Long <= 1048576L);
    return true;
  }
  
  public VideoPlayMedioInfo a(boolean paramBoolean)
  {
    boolean bool = false;
    VideoPlayMedioInfo localVideoPlayMedioInfo = new VideoPlayMedioInfo();
    localVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_d_of_type_JavaLangString };
    localVideoPlayMedioInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    localVideoPlayMedioInfo.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_JavaLangString);
    if (!a()) {
      bool = true;
    }
    localVideoPlayMedioInfo.jdField_a_of_type_Boolean = bool;
    if (localVideoPlayMedioInfo.jdField_a_of_type_Boolean) {}
    for (String str = this.jdField_f_of_type_JavaLangString;; str = this.jdField_c_of_type_JavaLangString)
    {
      localVideoPlayMedioInfo.jdField_a_of_type_JavaLangString = str;
      localVideoPlayMedioInfo.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
      localVideoPlayMedioInfo.jdField_b_of_type_Boolean = true;
      localVideoPlayMedioInfo.jdField_b_of_type_Long = this.jdField_h_of_type_Long;
      localVideoPlayMedioInfo.jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      localVideoPlayMedioInfo.jdField_b_of_type_Int = this.jdField_f_of_type_Int;
      localVideoPlayMedioInfo.jdField_e_of_type_Boolean = paramBoolean;
      return localVideoPlayMedioInfo;
    }
  }
  
  public File a(int paramInt)
  {
    if (!FileUtil.b(this.jdField_b_of_type_JavaLangString)) {
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
    if (!this.jdField_b_of_type_JavaLangString.startsWith("/")) {
      return "file:/" + this.jdField_b_of_type_JavaLangString;
    }
    if (this.jdField_b_of_type_JavaLangString.startsWith("//")) {
      return "file:" + this.jdField_b_of_type_JavaLangString;
    }
    return "file:" + this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void a(Parcel paramParcel)
  {
    boolean bool = true;
    super.a(paramParcel);
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_h_of_type_JavaLangString = paramParcel.readString();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_i_of_type_JavaLangString = paramParcel.readString();
      this.j = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public void a(View paramView, VideoPlayControllerForAIO paramVideoPlayControllerForAIO)
  {
    if (c())
    {
      if (QFileUtils.a(paramView.getContext(), false, new AIOFileVideoData.2(this, paramVideoPlayControllerForAIO, paramView))) {
        a(paramView.getContext(), paramVideoPlayControllerForAIO);
      }
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      paramVideoPlayControllerForAIO.a(paramView, a(false));
    }
    paramVideoPlayControllerForAIO.b();
    paramVideoPlayControllerForAIO.f();
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
    if (FileUtils.b(paramDataLineMsgRecord.path))
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
    return FileUtil.b(this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean a(IAIOImageProvider paramIAIOImageProvider)
  {
    if (a()) {}
    while ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    paramIAIOImageProvider.a(this.jdField_f_of_type_Long, this.jdField_f_of_type_Int, 16842753);
    return true;
  }
  
  public boolean b()
  {
    return !TextUtils.isEmpty(this.k);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    if (this.jdField_c_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
      paramParcel.writeString(this.j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */