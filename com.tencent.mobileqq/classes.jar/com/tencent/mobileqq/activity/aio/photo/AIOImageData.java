package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.qphone.base.util.QLog;
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
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public String i;
  public boolean i;
  public String j;
  public boolean j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  
  public AIOImageData()
  {
    this.jdField_a_of_type_JavaLangString = "I:N";
    this.jdField_b_of_type_JavaLangString = "I:N";
    this.jdField_c_of_type_JavaLangString = "I:N";
    this.jdField_d_of_type_JavaLangString = "I:N";
    this.jdField_e_of_type_JavaLangString = "I:N";
    this.jdField_b_of_type_Int = 0;
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
          if (this.jdField_b_of_type_Int != 3) {
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
    boolean bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        label102:
        this.jdField_e_of_type_Boolean = bool1;
        if (paramParcel.readByte() == 0) {
          break label328;
        }
        bool1 = true;
        this.jdField_f_of_type_Boolean = bool1;
        this.jdField_a_of_type_Int = paramParcel.readInt();
        this.jdField_b_of_type_Int = paramParcel.readInt();
      }
      try
      {
        this.jdField_a_of_type_JavaLangObject = paramParcel.readValue(null);
        if (paramParcel.readByte() != 0)
        {
          bool1 = true;
          this.jdField_g_of_type_Boolean = bool1;
          this.jdField_e_of_type_Long = paramParcel.readLong();
          this.jdField_g_of_type_JavaLangString = paramParcel.readString();
          this.jdField_h_of_type_JavaLangString = paramParcel.readString();
          this.jdField_c_of_type_Int = paramParcel.readInt();
          this.jdField_d_of_type_Int = paramParcel.readInt();
          this.jdField_i_of_type_JavaLangString = paramParcel.readString();
          this.jdField_f_of_type_JavaLangString = paramParcel.readString();
          this.jdField_j_of_type_JavaLangString = paramParcel.readString();
          this.k = paramParcel.readString();
          if (paramParcel.readInt() != 1) {
            break label364;
          }
          bool1 = true;
          this.jdField_h_of_type_Boolean = bool1;
          this.jdField_e_of_type_Int = paramParcel.readInt();
          if (paramParcel.readInt() != 1) {
            break label369;
          }
          bool1 = true;
          this.jdField_i_of_type_Boolean = bool1;
          this.l = paramParcel.readString();
          if (paramParcel.readInt() != 1) {
            break label374;
          }
          bool1 = bool2;
          this.jdField_j_of_type_Boolean = bool1;
          this.m = paramParcel.readString();
          this.n = paramParcel.readString();
          this.o = paramParcel.readString();
          return;
          bool1 = false;
          continue;
          bool1 = false;
          break label102;
          label328:
          bool1 = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AIOImageData", 2, "readValue exception");
          }
          this.jdField_a_of_type_JavaLangObject = new byte[0];
          continue;
          bool1 = false;
          continue;
          label364:
          bool1 = false;
          continue;
          label369:
          bool1 = false;
          continue;
          label374:
          bool1 = false;
        }
      }
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
      } while (this.jdField_b_of_type_Int == 3);
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
    int i1 = 1;
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
        break label324;
      }
      paramInt = 1;
      label104:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_f_of_type_Boolean) {
        break label329;
      }
      paramInt = 1;
      label119:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeValue(this.jdField_a_of_type_JavaLangObject);
      if (!this.jdField_g_of_type_Boolean) {
        break label334;
      }
      paramInt = 1;
      label158:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
      paramParcel.writeString(this.k);
      if (!this.jdField_h_of_type_Boolean) {
        break label339;
      }
      paramInt = 1;
      label245:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      if (!this.jdField_i_of_type_Boolean) {
        break label344;
      }
      paramInt = 1;
      label267:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.l);
      if (!this.jdField_j_of_type_Boolean) {
        break label349;
      }
    }
    label324:
    label329:
    label334:
    label339:
    label344:
    label349:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.m);
      paramParcel.writeString(this.n);
      paramParcel.writeString(this.o);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label104;
      paramInt = 0;
      break label119;
      paramInt = 0;
      break label158;
      paramInt = 0;
      break label245;
      paramInt = 0;
      break label267;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageData
 * JD-Core Version:    0.7.0.1
 */