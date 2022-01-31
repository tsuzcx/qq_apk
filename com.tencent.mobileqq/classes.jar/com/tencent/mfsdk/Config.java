package com.tencent.mfsdk;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mfsdk.persist.DBHandler;
import com.tencent.mfsdk.reporter.ReporterMachine;
import java.util.Iterator;
import org.json.JSONObject;

public class Config
{
  public static int a;
  public static SparseArray a;
  public static boolean a;
  public static final int[] a;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  public static boolean g;
  public static boolean h;
  public static boolean i;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 101, 102, 103, 104, 105, 106, 107, 108, 109, 119, 121, 123, 124, 126, 129 };
    jdField_a_of_type_Boolean = true;
    b = true;
    c = true;
    d = true;
    e = true;
    f = true;
    g = true;
    h = true;
    i = true;
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new Config.SamplingConfig(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new Config.SamplingConfig(0.001F, 100, 10, 0.01F, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, new Config.SamplingConfig(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, new Config.SamplingConfig(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(14, new Config.SamplingConfig(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(9, new Config.SamplingConfig(0.001F, 85, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new Config.SamplingConfig(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_Int = 100;
  }
  
  public static void a()
  {
    boolean bool2 = true;
    ReportedStatus.a();
    if (MagnifierSDK.jdField_a_of_type_ComTencentMfsdkPersistDBHandler != null)
    {
      SparseArray localSparseArray = MagnifierSDK.jdField_a_of_type_ComTencentMfsdkPersistDBHandler.a();
      if ((localSparseArray != null) && (localSparseArray.size() > 0)) {
        jdField_a_of_type_AndroidUtilSparseArray = localSparseArray;
      }
    }
    if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      int j = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("config_reporter_type", 0);
      if (j > 0) {
        ReporterMachine.jdField_a_of_type_Int = j;
      }
      j = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("config_switch", 0);
      if (j > 0)
      {
        if ((j & 0x1) <= 0) {
          break label151;
        }
        bool1 = true;
        jdField_a_of_type_Boolean = bool1;
        if ((j & 0x2) <= 0) {
          break label156;
        }
        bool1 = true;
        label95:
        b = bool1;
        if ((j & 0x4) <= 0) {
          break label161;
        }
        bool1 = true;
        label107:
        c = bool1;
        if ((j & 0x8) <= 0) {
          break label166;
        }
        bool1 = true;
        label120:
        g = bool1;
        if ((j & 0x10) <= 0) {
          break label171;
        }
        bool1 = true;
        label133:
        h = bool1;
        if ((j & 0x20) <= 0) {
          break label176;
        }
      }
    }
    label151:
    label156:
    label161:
    label166:
    label171:
    label176:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      i = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label95;
      bool1 = false;
      break label107;
      bool1 = false;
      break label120;
      bool1 = false;
      break label133;
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.getInt("pid") != MagnifierSDK.jdField_a_of_type_Int) {
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    label19:
    Object localObject;
    int j;
    label109:
    label123:
    int n;
    label137:
    label152:
    label167:
    label214:
    label220:
    label226:
    label232:
    label238:
    float f1;
    int k;
    float f2;
    int m;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      if ("host".equals(localObject))
      {
        ReporterMachine.jdField_a_of_type_Int = paramJSONObject.getInt((String)localObject);
        if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null) {
          MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("config_reporter_type", ReporterMachine.jdField_a_of_type_Int);
        }
      }
      else
      {
        if ("switch".equals(localObject))
        {
          j = paramJSONObject.getInt((String)localObject);
          if ((j & 0x1) > 0)
          {
            bool = true;
            jdField_a_of_type_Boolean = bool;
            if ((j & 0x2) <= 0) {
              break label214;
            }
            bool = true;
            b = bool;
            if ((j & 0x4) <= 0) {
              break label220;
            }
            bool = true;
            c = bool;
            if ((j & 0x8) <= 0) {
              break label226;
            }
            bool = true;
            g = bool;
            if ((j & 0x10) <= 0) {
              break label232;
            }
            bool = true;
            h = bool;
            if ((j & 0x20) <= 0) {
              break label238;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            i = bool;
            if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor == null) {
              break;
            }
            MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("config_switch", j);
            break;
            bool = false;
            break label109;
            bool = false;
            break label123;
            bool = false;
            break label137;
            bool = false;
            break label152;
            bool = false;
            break label167;
          }
        }
        if (((String)localObject).startsWith("p_"))
        {
          n = Integer.parseInt(((String)localObject).replace("p_", ""));
          Config.SamplingConfig localSamplingConfig = (Config.SamplingConfig)jdField_a_of_type_AndroidUtilSparseArray.get(n);
          f1 = localSamplingConfig.jdField_a_of_type_Float;
          j = localSamplingConfig.jdField_a_of_type_Int;
          k = localSamplingConfig.jdField_b_of_type_Int;
          f2 = localSamplingConfig.jdField_b_of_type_Float;
          m = localSamplingConfig.c;
          localObject = paramJSONObject.getString((String)localObject).split(",");
          if (localObject.length >= 5)
          {
            if (TextUtils.isEmpty(localObject[0])) {
              break label489;
            }
            f1 = Float.parseFloat(localObject[0]);
          }
        }
      }
    }
    label489:
    for (;;)
    {
      if (!TextUtils.isEmpty(localObject[1])) {
        j = Integer.parseInt(localObject[1]);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localObject[2])) {
          k = Integer.parseInt(localObject[2]);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(localObject[3])) {
            f2 = Float.parseFloat(localObject[3]);
          }
          for (;;)
          {
            if (!TextUtils.isEmpty(localObject[4])) {
              m = Integer.parseInt(localObject[4]);
            }
            for (;;)
            {
              localObject = new Config.SamplingConfig(f1, j, k, f2, m);
              jdField_a_of_type_AndroidUtilSparseArray.setValueAt(jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(n), localObject);
              break label19;
              if (MagnifierSDK.jdField_a_of_type_ComTencentMfsdkPersistDBHandler == null) {
                break;
              }
              MagnifierSDK.jdField_a_of_type_ComTencentMfsdkPersistDBHandler.a(jdField_a_of_type_AndroidUtilSparseArray);
              return;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.Config
 * JD-Core Version:    0.7.0.1
 */