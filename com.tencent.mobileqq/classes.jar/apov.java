import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class apov
  implements apgw, apgx, apgy, SDKInitListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private aphg jdField_a_of_type_Aphg;
  private apow jdField_a_of_type_Apow;
  private apox jdField_a_of_type_Apox;
  private apoy jdField_a_of_type_Apoy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public apov(Activity paramActivity, aphg paramaphg)
  {
    this.jdField_a_of_type_Aphg = paramaphg;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(long paramLong)
  {
    if (((paramLong & 0x2) != 0L) && (!this.jdField_b_of_type_Boolean)) {
      g();
    }
    if (((0x8 & paramLong) != 0L) && (!this.jdField_d_of_type_Boolean)) {
      h();
    }
    if (((paramLong & 0x2) != 0L) && ((!this.g) || (!this.jdField_d_of_type_Boolean))) {
      i();
    }
  }
  
  private boolean a(long paramLong)
  {
    return (this.jdField_a_of_type_Long & 0x2) != 0L;
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      if (this.jdField_a_of_type_Apow != null) {
        this.jdField_a_of_type_Apow.a();
      }
    }
    while ((this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Apow == null)) {
      return;
    }
    QLog.d("ScanEntryResourceDelegate", 1, "ARBaseSo res download fail");
    this.jdField_a_of_type_Apow.b();
  }
  
  private void k()
  {
    int j = 0;
    if (a(2L)) {
      j = 0 + this.jdField_a_of_type_Int;
    }
    int k = j;
    if (a(8L)) {
      k = j + this.jdField_b_of_type_Int;
    }
    if (this.jdField_a_of_type_Apow != null) {
      this.jdField_a_of_type_Apow.a(k / 2);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Apox != null) {
        this.jdField_a_of_type_Apox.a((this.jdField_c_of_type_Int + this.jdField_d_of_type_Int) / 2);
      }
      return;
      this.jdField_c_of_type_Int = paramInt2;
      continue;
      this.jdField_d_of_type_Int = paramInt2;
    }
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(long paramLong, apow paramapow, apox paramapox)
  {
    if (paramLong == 0L) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Apow = paramapow;
    this.jdField_a_of_type_Apox = paramapox;
    a(paramLong);
  }
  
  public void a(apoy paramapoy)
  {
    this.jdField_a_of_type_Apoy = paramapoy;
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (this.i) {
      return;
    }
    if (this.jdField_a_of_type_Apoy != null) {
      this.jdField_a_of_type_Apoy.a(paramARCommonConfigInfo);
    }
    this.i = true;
  }
  
  public void a(ArConfigInfo paramArConfigInfo) {}
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    apbb.a().a(paramArEffectConfig);
  }
  
  public boolean a()
  {
    boolean bool1;
    if (a(2L)) {
      if (a(2)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (a(8L))
      {
        if ((!bool1) || (!a(8))) {
          break label76;
        }
        bool2 = true;
      }
      for (;;)
      {
        if (a(4L))
        {
          if ((bool2) && (a(4)))
          {
            return true;
            bool1 = false;
            break;
            label76:
            bool2 = false;
            continue;
          }
          return false;
        }
      }
      return bool2;
      bool1 = true;
    }
  }
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 2: 
    case 4: 
      do
      {
        return false;
        return this.jdField_a_of_type_Boolean;
      } while ((!this.e) || (!this.f));
      return true;
    }
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    QLog.d("ScanEntryResourceDelegate", 1, "onArSoDownloadProcess process." + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    k();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Apox != null)
      {
        QLog.d("ScanEntryResourceDelegate", 1, "face so download not ready download fail");
        this.jdField_a_of_type_Apox.b();
      }
      return;
      this.e = false;
      this.g = false;
      continue;
      this.f = false;
      this.h = false;
    }
  }
  
  public boolean b()
  {
    boolean bool3 = false;
    if (a(2L)) {}
    for (boolean bool1 = this.jdField_b_of_type_Boolean;; bool1 = false)
    {
      if (a(8L)) {}
      for (boolean bool2 = this.jdField_d_of_type_Boolean;; bool2 = false)
      {
        int j;
        if (a(4L)) {
          if ((this.g) || (this.h)) {
            j = 1;
          }
        }
        for (;;)
        {
          if ((!bool1) && (!bool2))
          {
            bool1 = bool3;
            if (j == 0) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
          j = 0;
          continue;
          j = 0;
        }
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 100;
    j();
  }
  
  public void c(int paramInt)
  {
    QLog.d("ScanEntryResourceDelegate", 2, new Object[] { "notifyVoiceScanStatusChange state.", Integer.valueOf(paramInt) });
    if (this.jdField_a_of_type_Aphg != null) {}
    try
    {
      this.jdField_a_of_type_Aphg.b(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ScanEntryResourceDelegate", 1, "notifyVoiceScanStatusChange fail.", localException);
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Boolean);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    j();
  }
  
  public boolean d()
  {
    return (this.e) && (this.f);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Apow, this.jdField_a_of_type_Apox);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Apow = null;
    this.jdField_a_of_type_Apox = null;
  }
  
  public void g()
  {
    try
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Aphg.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Aphg.c();
      }
      for (;;)
      {
        QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARResource mIsArSoReady=%s mArSoDownloading=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
        return;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Int = 100;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ScanEntryResourceDelegate", 1, "downloadARResource fail");
    }
  }
  
  public void h()
  {
    this.jdField_c_of_type_Boolean = bapt.a();
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      if (!bapt.a()) {
        bapt.a(BaseApplicationImpl.getContext(), this);
      }
    }
    for (;;)
    {
      QLog.d("ScanEntryResourceDelegate", 1, String.format("installVideoPlugin mIsVideoPluginReady=%s mVideoPluginDownloading=%s", new Object[] { Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_d_of_type_Boolean) }));
      return;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 100;
    }
  }
  
  public void i()
  {
    this.f = apgp.a();
    if (!this.f)
    {
      this.h = true;
      this.jdField_a_of_type_Aphg.a(1);
      this.e = apgo.a();
      if (this.e) {
        break label154;
      }
      this.g = true;
      this.jdField_a_of_type_Aphg.a(0);
      new HashMap().put("res_type", "model");
    }
    for (;;)
    {
      QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARFaceResources mIsFaceSoReady=%s mFaceSoDownloading=%s", new Object[] { Boolean.valueOf(this.f), Boolean.valueOf(this.h) }));
      QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARFaceResources mIsFaceModelReady=%s mFaceModelDownloading=%s", new Object[] { Boolean.valueOf(this.e), Boolean.valueOf(this.g) }));
      return;
      this.h = false;
      this.jdField_d_of_type_Int = 100;
      break;
      label154:
      this.g = false;
      this.jdField_c_of_type_Int = 100;
    }
  }
  
  public void l_(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.e) && (this.f) && (this.jdField_a_of_type_Apox != null)) {
        this.jdField_a_of_type_Apox.a();
      }
      return;
      this.e = true;
      this.g = false;
      this.jdField_c_of_type_Int = 100;
      continue;
      this.f = true;
      this.h = false;
      this.jdField_d_of_type_Int = 100;
    }
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.d("ScanEntryResourceDelegate", 1, "onSDKInited result." + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 100;
      j();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apov
 * JD-Core Version:    0.7.0.1
 */