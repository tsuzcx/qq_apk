package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ScanEntranceDPC
{
  private static ScanEntranceDPC l;
  public boolean a;
  public int b;
  public float c;
  public boolean d;
  public int e;
  public boolean f;
  public boolean g;
  public int h;
  public boolean i;
  public boolean j;
  public boolean k;
  
  public static ScanEntranceDPC a()
  {
    if (l == null)
    {
      l = new ScanEntranceDPC();
      l.b();
    }
    return l;
  }
  
  private void b()
  {
    long l1 = System.currentTimeMillis();
    c();
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.ARCfg.name());
    QLog.d("ScanEntranceDPC", 1, String.format("loadDPC dpcValue=%s", new Object[] { localObject }));
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    int i1 = -1;
    int i2 = i1;
    int n;
    if (!bool) {
      n = i1;
    }
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        n = i1;
        if (localObject.length >= 9)
        {
          n = i1;
          if (Integer.valueOf(localObject[1]).intValue() != 1) {
            break label713;
          }
          bool = true;
          n = i1;
          this.a = bool;
          n = i1;
          int m = Integer.valueOf(localObject[2]).intValue();
          if (m >= 0)
          {
            n = i1;
            this.b = m;
          }
          n = i1;
          float f1 = Float.valueOf(localObject[3]).floatValue();
          if ((f1 >= 0.05F) && (f1 <= 0.95F))
          {
            n = i1;
            this.c = f1;
          }
          n = i1;
          if (Integer.valueOf(localObject[4]).intValue() != 1) {
            break label719;
          }
          bool = true;
          n = i1;
          this.d = bool;
          n = i1;
          m = Integer.valueOf(localObject[5]).intValue();
          if (m >= 0)
          {
            n = i1;
            this.e = m;
          }
          n = i1;
          if (Integer.valueOf(localObject[6]).intValue() != 1) {
            break label725;
          }
          bool = true;
          n = i1;
          this.f = bool;
          n = i1;
          if (Integer.valueOf(localObject[7]).intValue() != 1) {
            break label731;
          }
          bool = true;
          n = i1;
          this.g = bool;
          n = i1;
          m = Integer.valueOf(localObject[8]).intValue();
          if ((m >= 0) && (m <= 255))
          {
            n = i1;
            this.h = m;
          }
          n = i1;
          if (localObject.length >= 12)
          {
            n = i1;
            if (Integer.valueOf(localObject[11]).intValue() != 1) {
              break label737;
            }
            bool = true;
            n = i1;
            this.i = bool;
          }
          m = i1;
          n = i1;
          if (localObject.length > 12)
          {
            n = i1;
            m = Integer.valueOf(localObject[12]).intValue();
          }
          n = m;
          if (localObject.length >= 18)
          {
            n = m;
            if (Integer.valueOf(localObject[17]).intValue() != 1) {
              break label743;
            }
            bool = true;
            n = m;
            this.j = bool;
          }
          n = m;
          i2 = m;
          if (localObject.length >= 19)
          {
            n = m;
            if (Integer.valueOf(localObject[18]).intValue() != 1) {
              break label749;
            }
            bool = true;
            n = m;
            this.k = bool;
            i2 = m;
          }
        }
        else
        {
          n = i1;
          QLog.e("ScanEntranceDPC", 1, "loadDPC dpc length invalid, use default value.");
          i2 = i1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ScanEntranceDPC", 1, "loadDPC fail, use default value.", localException);
        c();
        i2 = n;
      }
      QLog.d("ScanEntranceDPC", 1, String.format("loadDPC mHighPerfDevice=%s mCameraZoom=%s mScanRectRadio=%s mContinuousFocus=%s mARRecogInterval=%s mRecycleFaceResource=%s mRecordEnable=%s mDarkThreshold=%s mNeonCfgSwitch=%s, disableWorldCup=%s mMiniDecodeSwitch=%s mMiniDetectSwitch=%s", new Object[] { Boolean.valueOf(this.a), Integer.valueOf(this.b), Float.valueOf(this.c), Boolean.valueOf(this.d), Integer.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g), Integer.valueOf(this.h), Boolean.valueOf(this.i), Integer.valueOf(i2), Boolean.valueOf(this.j), Boolean.valueOf(this.k) }));
      QLog.d("ScanEntranceDPC", 1, String.format("loadDPC time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
      return;
      label713:
      bool = false;
      continue;
      label719:
      bool = false;
      continue;
      label725:
      bool = false;
      continue;
      label731:
      bool = false;
      continue;
      label737:
      bool = false;
      continue;
      label743:
      bool = false;
      continue;
      label749:
      bool = false;
    }
  }
  
  private void c()
  {
    this.a = false;
    this.b = 2;
    this.c = 0.7F;
    this.d = false;
    this.e = 500;
    this.f = true;
    this.g = true;
    this.h = 28;
    this.i = false;
    this.j = false;
    this.k = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceDPC
 * JD-Core Version:    0.7.0.1
 */