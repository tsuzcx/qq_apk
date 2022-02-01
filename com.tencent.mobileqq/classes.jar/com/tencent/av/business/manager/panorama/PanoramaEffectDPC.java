package com.tencent.av.business.manager.panorama;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.hotpic.HotVideoDPC;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PanoramaEffectDPC
{
  public static PanoramaEffectDPC a;
  public int a;
  public List<PanoramaEffectDPC.DeviceCPUinfo> a;
  public boolean a;
  public int b = 0;
  
  static
  {
    jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaEffectDPC = null;
  }
  
  public PanoramaEffectDPC()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static int a()
  {
    PanoramaEffectDPC localPanoramaEffectDPC = a();
    if (localPanoramaEffectDPC != null) {
      return localPanoramaEffectDPC.b;
    }
    return 3;
  }
  
  public static PanoramaEffectDPC a()
  {
    if ((jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaEffectDPC == null) || (jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaEffectDPC.jdField_a_of_type_Boolean)) {
      jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaEffectDPC = b();
    }
    return jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaEffectDPC;
  }
  
  public static List<PanoramaEffectDPC.DeviceCPUinfo> a()
  {
    PanoramaEffectDPC localPanoramaEffectDPC = a();
    if (localPanoramaEffectDPC != null) {
      return localPanoramaEffectDPC.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public static boolean a()
  {
    PanoramaEffectDPC localPanoramaEffectDPC = a();
    return (localPanoramaEffectDPC != null) && (localPanoramaEffectDPC.jdField_a_of_type_Int == 1);
  }
  
  private static PanoramaEffectDPC b()
  {
    int i1 = 3;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC!");
    }
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.AVPanCfg.name());
    QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC dpcValue: " + str);
    ArrayList localArrayList = new ArrayList();
    int i;
    int j;
    int k;
    int m;
    if (!TextUtils.isEmpty(str))
    {
      try
      {
        localObject1 = str.split("\\|");
        if ((localObject1 != null) && (localObject1.length >= 3))
        {
          i = HotVideoDPC.a(localObject1[0], 0);
          localObject2 = localObject1[1];
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2;
          Object localObject3;
          label194:
          label222:
          label235:
          label237:
          i = 0;
          j = i;
          k = i1;
          if (QLog.isColorLevel())
          {
            QLog.e("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC exception:", localException1);
            j = i;
            k = i1;
          }
        }
      }
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label222;
        }
        localObject2 = ((String)localObject2).split("-");
        j = 0;
        if (j >= localObject2.length) {
          break label222;
        }
        localObject3 = localObject2[j];
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label620;
        }
        localObject3 = ((String)localObject3).split("_");
        if (localObject3.length < 2) {
          break label605;
        }
        k = HotVideoDPC.a(localObject3[0], 0);
        m = HotVideoDPC.a(localObject3[1], 0);
      }
      catch (Exception localException2)
      {
        break label549;
        break label235;
        k = 0;
        m = 0;
        break label194;
      }
      if ((k <= 0) || (m <= 0)) {
        break label620;
      }
      localArrayList.add(new PanoramaEffectDPC.DeviceCPUinfo(m, k));
      break label620;
      k = HotVideoDPC.a(localObject1[2], 3);
      j = i;
      i = k;
      for (;;)
      {
        k = i;
        if (localArrayList.size() == 0)
        {
          localArrayList.add(new PanoramaEffectDPC.DeviceCPUinfo(215, 4));
          localArrayList.add(new PanoramaEffectDPC.DeviceCPUinfo(150, 8));
        }
        localObject1 = new PanoramaEffectDPC();
        ((PanoramaEffectDPC)localObject1).jdField_a_of_type_Int = j;
        ((PanoramaEffectDPC)localObject1).b = k;
        ((PanoramaEffectDPC)localObject1).jdField_a_of_type_JavaUtilList = localArrayList;
        if ((str == null) || (str.isEmpty())) {
          bool = true;
        }
        ((PanoramaEffectDPC)localObject1).jdField_a_of_type_Boolean = bool;
        return localObject1;
        if ((localObject1 != null) && (localObject1.length == 1))
        {
          i = HotVideoDPC.a(localObject1[0], 0);
          j = i;
        }
        try
        {
          QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC configs.length == 1");
          j = i;
          i = 3;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            i = j;
            continue;
            m = 0;
            n = 0;
          }
          i = 3;
          j = 0;
        }
      }
      if ((localObject1 != null) && (localObject1.length == 2))
      {
        i = HotVideoDPC.a(localObject1[0], 0);
        localObject1 = localObject1[1];
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          j = i;
          localObject1 = ((String)localObject1).split("-");
          k = 0;
        }
      }
    }
    for (;;)
    {
      j = i;
      int n;
      if (k < localObject1.length)
      {
        localObject2 = localObject1[k];
        j = i;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label627;
        }
        j = i;
        localObject2 = ((String)localObject2).split("_");
        j = i;
        if (localObject2.length >= 2)
        {
          j = i;
          m = HotVideoDPC.a(localObject2[0], 0);
          j = i;
          n = HotVideoDPC.a(localObject2[1], 0);
          if ((m <= 0) || (n <= 0)) {
            break label627;
          }
          j = i;
          localArrayList.add(new PanoramaEffectDPC.DeviceCPUinfo(n, m));
          break label627;
        }
      }
      else
      {
        j = i;
        QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC configs.length == 2");
        j = i;
        i = 3;
        break label235;
      }
      label549:
      label605:
      j = 0;
      k = i1;
      break label237;
      label620:
      j += 1;
      break;
      label627:
      k += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hotVideoSwitch: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" mPanoramaEffectMemory: ").append(this.b);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    String str = "";
    while (localIterator.hasNext())
    {
      PanoramaEffectDPC.DeviceCPUinfo localDeviceCPUinfo = (PanoramaEffectDPC.DeviceCPUinfo)localIterator.next();
      if (localDeviceCPUinfo != null) {
        str = str + localDeviceCPUinfo.b + "_" + localDeviceCPUinfo.jdField_a_of_type_Int + "-";
      }
    }
    localStringBuilder.append(" hotVideoBlurMemory: ").append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.panorama.PanoramaEffectDPC
 * JD-Core Version:    0.7.0.1
 */