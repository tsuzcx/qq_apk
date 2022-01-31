package com.tencent.biz.pubaccount.readinjoy.magic.models;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ooa;
import oob;

public class AndroidAPs
  extends AndroidPs
{
  public static final Parcelable.Creator<AndroidAPs> CREATOR = new oob();
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^([A-Za-z]{1}[A-Za-z0-9_]*[\\.|:])*[A-Za-z][A-Za-z0-9_]*$");
  public final int a;
  public final boolean a;
  
  public AndroidAPs(int paramInt)
  {
    super(paramInt);
    if ((this.jdField_a_of_type_JavaLangString == null) || (!jdField_a_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString).matches()) || (!new File("/data/data", a()).exists())) {
      throw new AndroidAPs.NotAAPsException(paramInt);
    }
    if (jdField_a_of_type_JavaLangBoolean == null) {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(new File(ooa.b()).exists());
    }
    Object localObject;
    CG localCG;
    if (jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      localObject = a();
      localCG = ((CgF)localObject).getGroup("cpuacct");
      localObject = ((CgF)localObject).getGroup("cpu");
      if (Build.VERSION.SDK_INT >= 21)
      {
        if ((localObject == null) || (localCG == null) || (!localCG.b.contains("pid_"))) {
          throw new AndroidAPs.NotAAPsException(paramInt);
        }
        if (((CG)localObject).b.contains("bg_non_interactive")) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.parseInt(localCG.b.split("/")[1].replace("uid_", ""));
        this.jdField_a_of_type_Boolean = bool1;
        this.jdField_a_of_type_Int = paramInt;
        return;
        bool1 = false;
        continue;
      }
      catch (Exception localException1)
      {
        paramInt = a().getUid();
        continue;
      }
      if ((localObject == null) || (localException1 == null) || (!((CG)localObject).b.contains("apps"))) {
        throw new AndroidAPs.NotAAPsException(paramInt);
      }
      if (!((CG)localObject).b.contains("bg_non_interactive")) {}
      for (bool1 = bool3;; bool1 = false) {
        try
        {
          paramInt = Integer.parseInt(localException1.b.substring(localException1.b.lastIndexOf("/") + 1));
        }
        catch (Exception localException2)
        {
          paramInt = a().getUid();
        }
      }
      continue;
      paramInt = a().getUid();
      bool1 = bool2;
    }
  }
  
  public AndroidAPs(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      return;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString.split(":")[0];
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidAPs
 * JD-Core Version:    0.7.0.1
 */