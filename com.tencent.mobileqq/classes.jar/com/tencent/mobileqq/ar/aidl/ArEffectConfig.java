package com.tencent.mobileqq.ar.aidl;

import akpp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator<ArEffectConfig> CREATOR = new akpp();
  public int a;
  public ArrayList<String> a;
  public int b;
  public ArrayList<String> b;
  public int c;
  public ArrayList<String> c;
  public int d;
  public ArrayList<String> d;
  public int e;
  public ArrayList<ArDefaultSetting> e;
  public int f = 30;
  public int g = 30;
  public int h = 30;
  
  public ArEffectConfig()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 80;
    this.jdField_c_of_type_Int = 80;
    this.jdField_d_of_type_Int = 80;
    this.jdField_e_of_type_Int = 30;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ArEffectConfig(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 80;
    this.jdField_c_of_type_Int = 80;
    this.jdField_d_of_type_Int = 80;
    this.jdField_e_of_type_Int = 30;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, String.class.getClassLoader());
    paramParcel.readList(this.jdField_b_of_type_JavaUtilArrayList, String.class.getClassLoader());
    paramParcel.readList(this.jdField_c_of_type_JavaUtilArrayList, String.class.getClassLoader());
    paramParcel.readList(this.jdField_d_of_type_JavaUtilArrayList, String.class.getClassLoader());
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    paramParcel.readList(this.jdField_e_of_type_JavaUtilArrayList, ArDefaultSetting.class.getClassLoader());
  }
  
  public static ArEffectConfig a()
  {
    return null;
  }
  
  public static ArEffectConfig a(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    ArEffectConfig localArEffectConfig = new ArEffectConfig();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        if (localIterator.hasNext())
        {
          localObject1 = localIterator.next().toString();
          if ("levelTop".equalsIgnoreCase((String)localObject1))
          {
            localObject1 = paramString.getJSONObject((String)localObject1);
            if (((JSONObject)localObject1).has("model"))
            {
              localObject2 = ((JSONObject)localObject1).getJSONArray("model");
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                localArEffectConfig.jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject2).getString(i));
                i += 1;
                continue;
              }
            }
            if (!((JSONObject)localObject1).has("GPU")) {
              continue;
            }
            localObject1 = ((JSONObject)localObject1).getJSONArray("GPU");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localArEffectConfig.jdField_b_of_type_JavaUtilArrayList.add(((JSONArray)localObject1).getString(i));
              i += 1;
              continue;
            }
            continue;
          }
          if ("blacklist".equalsIgnoreCase((String)localObject1))
          {
            localObject1 = paramString.getJSONObject((String)localObject1);
            if (((JSONObject)localObject1).has("model"))
            {
              localObject2 = ((JSONObject)localObject1).getJSONArray("model");
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                localArEffectConfig.jdField_c_of_type_JavaUtilArrayList.add(((JSONArray)localObject2).getString(i));
                i += 1;
                continue;
              }
            }
            if (!((JSONObject)localObject1).has("GPU")) {
              continue;
            }
            localObject1 = ((JSONObject)localObject1).getJSONArray("GPU");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localArEffectConfig.jdField_d_of_type_JavaUtilArrayList.add(((JSONArray)localObject1).getString(i));
              i += 1;
              continue;
            }
            continue;
          }
          if (!"bestModel".equalsIgnoreCase((String)localObject1)) {
            break label353;
          }
          localArEffectConfig.jdField_b_of_type_Int = paramString.optInt((String)localObject1);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = localArEffectConfig;
      }
      QLog.d("ArConfig_ArEffectConfig", 2, "parseArEffectConfig|effect= " + localArEffectConfig);
      return localArEffectConfig;
      label353:
      if ("removeShadow".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.jdField_c_of_type_Int = paramString.optInt((String)localObject1);
      }
      else if ("boneAnimation".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.jdField_d_of_type_Int = paramString.optInt((String)localObject1);
      }
      else if ("quality2".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.jdField_e_of_type_Int = paramString.optInt((String)localObject1);
      }
      else if ("quality3".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.f = paramString.optInt((String)localObject1);
      }
      else if ("quality4".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.g = paramString.optInt((String)localObject1);
      }
      else if ("quality5".equalsIgnoreCase((String)localObject1))
      {
        localArEffectConfig.h = paramString.optInt((String)localObject1);
      }
      else if ("defaultSetting".equalsIgnoreCase((String)localObject1))
      {
        localObject1 = paramString.getJSONArray((String)localObject1);
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new ArDefaultSetting();
          JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          String str1 = localJSONObject.optString("model");
          String str2 = localJSONObject.optString("GPU");
          if (!TextUtils.isEmpty(str1)) {
            ((ArDefaultSetting)localObject2).jdField_a_of_type_JavaLangString = str1;
          }
          for (((ArDefaultSetting)localObject2).jdField_a_of_type_Int = 0;; ((ArDefaultSetting)localObject2).jdField_a_of_type_Int = 1)
          {
            ((ArDefaultSetting)localObject2).jdField_c_of_type_Int = localJSONObject.optInt("quality");
            ((ArDefaultSetting)localObject2).jdField_b_of_type_Int = localJSONObject.optInt("modelType");
            localArEffectConfig.jdField_e_of_type_JavaUtilArrayList.add(localObject2);
            break;
            if (TextUtils.isEmpty(str2)) {
              break;
            }
            ((ArDefaultSetting)localObject2).jdField_a_of_type_JavaLangString = str2;
          }
          i += 1;
        }
      }
    }
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArEffectConfig", 2, "deleteEffectConfigFile");
    }
    File localFile = new File(BaseApplicationImpl.sApplication.getFilesDir(), "ar_effect_config");
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  /* Error */
  public static boolean a(ArEffectConfig paramArEffectConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: ifnonnull +5 -> 10
    //   8: iload_1
    //   9: ireturn
    //   10: new 220	java/io/File
    //   13: dup
    //   14: getstatic 226	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   17: invokevirtual 230	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   20: ldc 232
    //   22: invokespecial 235	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   25: astore 5
    //   27: new 220	java/io/File
    //   30: dup
    //   31: getstatic 226	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   34: invokevirtual 230	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   37: ldc 246
    //   39: invokespecial 235	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: astore 7
    //   44: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +11 -> 58
    //   50: ldc 162
    //   52: iconst_2
    //   53: ldc 248
    //   55: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: invokestatic 252	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   61: astore 6
    //   63: aload 6
    //   65: iconst_0
    //   66: invokevirtual 256	android/os/Parcel:setDataPosition	(I)V
    //   69: aload_0
    //   70: aload 6
    //   72: iconst_0
    //   73: invokevirtual 260	com/tencent/mobileqq/ar/aidl/ArEffectConfig:writeToParcel	(Landroid/os/Parcel;I)V
    //   76: aload 6
    //   78: invokevirtual 264	android/os/Parcel:marshall	()[B
    //   81: astore_0
    //   82: aload 5
    //   84: invokevirtual 267	java/io/File:getParentFile	()Ljava/io/File;
    //   87: astore 4
    //   89: aload 4
    //   91: invokevirtual 238	java/io/File:exists	()Z
    //   94: ifne +9 -> 103
    //   97: aload 4
    //   99: invokevirtual 270	java/io/File:mkdir	()Z
    //   102: pop
    //   103: aload 7
    //   105: invokevirtual 238	java/io/File:exists	()Z
    //   108: ifeq +9 -> 117
    //   111: aload 7
    //   113: invokevirtual 241	java/io/File:delete	()Z
    //   116: pop
    //   117: new 272	java/io/FileOutputStream
    //   120: dup
    //   121: aload 7
    //   123: invokespecial 275	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   126: astore 4
    //   128: new 277	java/io/BufferedOutputStream
    //   131: dup
    //   132: aload 4
    //   134: invokespecial 280	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   137: astore_3
    //   138: aload_3
    //   139: aload_0
    //   140: invokevirtual 284	java/io/BufferedOutputStream:write	([B)V
    //   143: aload_3
    //   144: invokevirtual 287	java/io/BufferedOutputStream:flush	()V
    //   147: aload 7
    //   149: aload 5
    //   151: invokestatic 292	bace:b	(Ljava/io/File;Ljava/io/File;)Z
    //   154: istore_2
    //   155: aload 6
    //   157: invokevirtual 295	android/os/Parcel:recycle	()V
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 298	java/io/BufferedOutputStream:close	()V
    //   168: iload_2
    //   169: istore_1
    //   170: aload 4
    //   172: ifnull -164 -> 8
    //   175: aload 4
    //   177: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   180: iload_2
    //   181: ireturn
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   187: iload_2
    //   188: ireturn
    //   189: astore_0
    //   190: aload_0
    //   191: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   194: goto -26 -> 168
    //   197: astore 4
    //   199: aconst_null
    //   200: astore 5
    //   202: aload_3
    //   203: astore_0
    //   204: aload 5
    //   206: astore_3
    //   207: aload 4
    //   209: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   212: aload 6
    //   214: invokevirtual 295	android/os/Parcel:recycle	()V
    //   217: aload_3
    //   218: ifnull +7 -> 225
    //   221: aload_3
    //   222: invokevirtual 298	java/io/BufferedOutputStream:close	()V
    //   225: aload_0
    //   226: ifnull -218 -> 8
    //   229: aload_0
    //   230: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_3
    //   243: aload_3
    //   244: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   247: goto -22 -> 225
    //   250: astore_0
    //   251: aconst_null
    //   252: astore_3
    //   253: aconst_null
    //   254: astore 4
    //   256: aload 6
    //   258: invokevirtual 295	android/os/Parcel:recycle	()V
    //   261: aload_3
    //   262: ifnull +7 -> 269
    //   265: aload_3
    //   266: invokevirtual 298	java/io/BufferedOutputStream:close	()V
    //   269: aload 4
    //   271: ifnull +8 -> 279
    //   274: aload 4
    //   276: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   279: aload_0
    //   280: athrow
    //   281: astore_3
    //   282: aload_3
    //   283: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   286: goto -17 -> 269
    //   289: astore_3
    //   290: aload_3
    //   291: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   294: goto -15 -> 279
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_3
    //   300: goto -44 -> 256
    //   303: astore_0
    //   304: goto -48 -> 256
    //   307: astore 5
    //   309: aload_0
    //   310: astore 4
    //   312: aload 5
    //   314: astore_0
    //   315: goto -59 -> 256
    //   318: astore 5
    //   320: aconst_null
    //   321: astore_3
    //   322: aload 4
    //   324: astore_0
    //   325: aload 5
    //   327: astore 4
    //   329: goto -122 -> 207
    //   332: astore 5
    //   334: aload 4
    //   336: astore_0
    //   337: aload 5
    //   339: astore 4
    //   341: goto -134 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramArEffectConfig	ArEffectConfig
    //   3	167	1	bool1	boolean
    //   154	34	2	bool2	boolean
    //   1	221	3	localObject1	Object
    //   242	2	3	localIOException1	java.io.IOException
    //   252	14	3	localObject2	Object
    //   281	2	3	localIOException2	java.io.IOException
    //   289	2	3	localIOException3	java.io.IOException
    //   299	23	3	localObject3	Object
    //   87	89	4	localObject4	Object
    //   197	11	4	localIOException4	java.io.IOException
    //   254	86	4	localObject5	Object
    //   25	180	5	localFile1	File
    //   307	6	5	localObject6	Object
    //   318	8	5	localIOException5	java.io.IOException
    //   332	6	5	localIOException6	java.io.IOException
    //   61	196	6	localParcel	Parcel
    //   42	106	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   175	180	182	java/io/IOException
    //   164	168	189	java/io/IOException
    //   117	128	197	java/io/IOException
    //   229	233	235	java/io/IOException
    //   221	225	242	java/io/IOException
    //   117	128	250	finally
    //   265	269	281	java/io/IOException
    //   274	279	289	java/io/IOException
    //   128	138	297	finally
    //   138	155	303	finally
    //   207	212	307	finally
    //   128	138	318	java/io/IOException
    //   138	155	332	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArEffectConfig{");
    localStringBuffer.append("version=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", toplevelModel=").append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuffer.append(", toplevelGPU=").append(this.jdField_b_of_type_JavaUtilArrayList);
    localStringBuffer.append(", blacklistModel=").append(this.jdField_c_of_type_JavaUtilArrayList);
    localStringBuffer.append(", blacklistGPU=").append(this.jdField_d_of_type_JavaUtilArrayList);
    localStringBuffer.append(", topModelStandard=").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", removeShadowLevel=").append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", adjustBone=").append(this.jdField_d_of_type_Int);
    localStringBuffer.append(", traceQuality2=").append(this.jdField_e_of_type_Int);
    localStringBuffer.append(", traceQuality3=").append(this.f);
    localStringBuffer.append(", traceQuality4=").append(this.g);
    localStringBuffer.append(", traceQuality5=").append(this.h);
    localStringBuffer.append(", defaultSettings=").append(this.jdField_e_of_type_JavaUtilArrayList);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeList(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.writeList(this.jdField_c_of_type_JavaUtilArrayList);
    paramParcel.writeList(this.jdField_d_of_type_JavaUtilArrayList);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeList(this.jdField_e_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ArEffectConfig
 * JD-Core Version:    0.7.0.1
 */