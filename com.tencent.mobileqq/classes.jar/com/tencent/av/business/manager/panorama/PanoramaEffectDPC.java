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
    PanoramaEffectDPC localPanoramaEffectDPC = jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaEffectDPC;
    if ((localPanoramaEffectDPC == null) || (localPanoramaEffectDPC.jdField_a_of_type_Boolean)) {
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
    if (QLog.isColorLevel()) {
      QLog.d("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC!");
    }
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.AVPanCfg.name());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("loadPanoramaEffectDPC dpcValue: ");
    ((StringBuilder)localObject1).append(str);
    QLog.i("PanoramaEffectDPC", 2, ((StringBuilder)localObject1).toString());
    ArrayList localArrayList = new ArrayList();
    boolean bool1 = TextUtils.isEmpty(str);
    int i1 = 3;
    boolean bool2 = true;
    if (!bool1) {}
    for (;;)
    {
      int j;
      try
      {
        localObject1 = str.split("\\|");
        Object localObject3;
        if ((localObject1 != null) && (localObject1.length >= 3))
        {
          i = HotVideoDPC.a(localObject1[0], 0);
          localObject3 = localObject1[1];
          j = i;
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              j = i;
              localObject3 = ((String)localObject3).split("-");
              k = 0;
              j = i;
              if (k < localObject3.length)
              {
                Object localObject4 = localObject3[k];
                j = i;
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  break label650;
                }
                j = i;
                localObject4 = ((String)localObject4).split("_");
                j = i;
                if (localObject4.length < 2) {
                  break label642;
                }
                j = i;
                n = HotVideoDPC.a(localObject4[0], 0);
                j = i;
                m = HotVideoDPC.a(localObject4[1], 0);
                if ((n <= 0) || (m <= 0)) {
                  break label650;
                }
                j = i;
                localArrayList.add(new PanoramaEffectDPC.DeviceCPUinfo(m, n));
                break label650;
              }
            }
            j = i;
            k = HotVideoDPC.a(localObject1[2], 3);
          }
          catch (Exception localException1)
          {
            continue;
          }
        }
        else if ((localException1 != null) && (localException1.length == 1))
        {
          i = HotVideoDPC.a(localException1[0], 0);
          try
          {
            QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC configs.length == 1");
            k = i1;
          }
          catch (Exception localException2)
          {
            j = i;
            continue;
          }
        }
        else
        {
          if ((localException2 == null) || (localException2.length != 2)) {
            break label523;
          }
          i = HotVideoDPC.a(localException2[0], 0);
          Object localObject2 = localException2[1];
          j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            j = i;
            localObject2 = ((String)localObject2).split("-");
            k = 0;
            j = i;
            if (k < localObject2.length)
            {
              localObject3 = localObject2[k];
              j = i;
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label665;
              }
              j = i;
              localObject3 = ((String)localObject3).split("_");
              j = i;
              if (localObject3.length < 2) {
                break label657;
              }
              j = i;
              n = HotVideoDPC.a(localObject3[0], 0);
              j = i;
              m = HotVideoDPC.a(localObject3[1], 0);
              if ((n <= 0) || (m <= 0)) {
                break label665;
              }
              j = i;
              localArrayList.add(new PanoramaEffectDPC.DeviceCPUinfo(m, n));
              break label665;
            }
          }
          j = i;
          QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC configs.length == 2");
          k = i1;
        }
      }
      catch (Exception localException3)
      {
        j = 0;
        k = i1;
        i = j;
        if (!QLog.isColorLevel()) {
          break label528;
        }
      }
      QLog.e("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC exception:", localException3);
      int k = i1;
      int i = j;
      break label528;
      label523:
      i = 0;
      k = i1;
      label528:
      if (localArrayList.size() == 0)
      {
        localArrayList.add(new PanoramaEffectDPC.DeviceCPUinfo(215, 4));
        localArrayList.add(new PanoramaEffectDPC.DeviceCPUinfo(150, 8));
      }
      PanoramaEffectDPC localPanoramaEffectDPC = new PanoramaEffectDPC();
      localPanoramaEffectDPC.jdField_a_of_type_Int = i;
      localPanoramaEffectDPC.b = k;
      localPanoramaEffectDPC.jdField_a_of_type_JavaUtilList = localArrayList;
      bool1 = bool2;
      if (str != null) {
        if (str.isEmpty()) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      localPanoramaEffectDPC.jdField_a_of_type_Boolean = bool1;
      return localPanoramaEffectDPC;
      label642:
      int m = 0;
      int n = 0;
      continue;
      label650:
      k += 1;
      continue;
      label657:
      m = 0;
      n = 0;
      continue;
      label665:
      k += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("hotVideoSwitch: ");
    localStringBuilder1.append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(" mPanoramaEffectMemory: ");
    localStringBuilder1.append(this.b);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    String str = "";
    while (localIterator.hasNext())
    {
      PanoramaEffectDPC.DeviceCPUinfo localDeviceCPUinfo = (PanoramaEffectDPC.DeviceCPUinfo)localIterator.next();
      if (localDeviceCPUinfo != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append(localDeviceCPUinfo.b);
        localStringBuilder2.append("_");
        localStringBuilder2.append(localDeviceCPUinfo.jdField_a_of_type_Int);
        localStringBuilder2.append("-");
        str = localStringBuilder2.toString();
      }
    }
    localStringBuilder1.append(" hotVideoBlurMemory: ");
    localStringBuilder1.append(str);
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.panorama.PanoramaEffectDPC
 * JD-Core Version:    0.7.0.1
 */