package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class AIOImageData
  extends AIORichMediaData
{
  public int a;
  public long a;
  public Object a;
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
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public long f;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public AIOImageData()
  {
    this.jdField_a_of_type_JavaLangString = "I:N";
    this.jdField_b_of_type_JavaLangString = "I:N";
    this.jdField_c_of_type_JavaLangString = "I:N";
    this.jdField_d_of_type_JavaLangString = "I:N";
    this.jdField_e_of_type_JavaLangString = "I:N";
    this.jdField_c_of_type_Int = 0;
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      if (paramString.contains(this.jdField_a_of_type_JavaLangString)) {
        return 1;
      }
      if (paramString.contains(this.jdField_b_of_type_JavaLangString)) {
        return 2;
      }
    } while (!paramString.contains(this.jdField_c_of_type_JavaLangString));
    return 4;
  }
  
  public File a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
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
      localObject = this.jdField_a_of_type_JavaLangString;
      continue;
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
    Object localObject3 = null;
    Object localObject1;
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (!((String)localObject1).equals("I:N"))
        {
          if (this.jdField_c_of_type_Int != 3) {
            break;
          }
          localObject1 = new File((String)localObject1);
        }
      }
      try
      {
        localObject2 = ((File)localObject1).toURI().toURL().toString();
        return localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        return null;
      }
      localObject1 = this.jdField_a_of_type_JavaLangString;
      continue;
      localObject1 = this.jdField_b_of_type_JavaLangString;
      continue;
      localObject1 = this.jdField_c_of_type_JavaLangString;
      continue;
      localObject1 = this.jdField_d_of_type_JavaLangString;
    }
    if (!localMalformedURLException.startsWith("/")) {
      return "file:/" + localMalformedURLException;
    }
    if (localMalformedURLException.startsWith("//")) {
      return "file:" + localMalformedURLException;
    }
    return "file:" + localMalformedURLException;
  }
  
  public void a(Parcel paramParcel)
  {
    boolean bool2 = true;
    super.a(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label254;
      }
      bool1 = true;
      label102:
      this.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label259;
      }
      bool1 = true;
      label116:
      this.jdField_f_of_type_Boolean = bool1;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangObject = paramParcel.readValue(null);
      if (paramParcel.readByte() == 0) {
        break label264;
      }
    }
    label259:
    label264:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_g_of_type_Boolean = bool1;
      this.jdField_f_of_type_Long = paramParcel.readLong();
      this.i = paramParcel.readString();
      this.j = paramParcel.readString();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.k = paramParcel.readString();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_g_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_Long = paramParcel.readLong();
      this.jdField_f_of_type_JavaLangString = paramParcel.readString();
      this.h = paramParcel.readString();
      return;
      bool1 = false;
      break;
      label254:
      bool1 = false;
      break label102;
      bool1 = false;
      break label116;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    case 3: 
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!this.jdField_a_of_type_JavaLangString.equals("I:N"));
          return false;
          bool1 = bool2;
        } while (!this.jdField_b_of_type_JavaLangString.equals("I:N"));
        return false;
        bool1 = bool2;
      } while (this.jdField_c_of_type_Int == 3);
      bool1 = bool2;
    } while (!this.jdField_c_of_type_JavaLangString.equals("I:N"));
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    if (this.jdField_d_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label258;
      }
      paramInt = 1;
      label104:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_f_of_type_Boolean) {
        break label263;
      }
      paramInt = 1;
      label119:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeValue(this.jdField_a_of_type_JavaLangObject);
      if (!this.jdField_g_of_type_Boolean) {
        break label268;
      }
    }
    label258:
    label263:
    label268:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.jdField_f_of_type_Long);
      paramParcel.writeString(this.i);
      paramParcel.writeString(this.j);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeString(this.k);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.h);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label104;
      paramInt = 0;
      break label119;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageData
 * JD-Core Version:    0.7.0.1
 */