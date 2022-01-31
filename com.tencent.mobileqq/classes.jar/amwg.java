import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class amwg
  implements amvm
{
  amwg(amwd paramamwd, long paramLong, amxi paramamxi) {}
  
  public void a(int paramInt, String paramString, amxd paramamxd)
  {
    amwd.c(this.jdField_a_of_type_Amwd, false);
    if (amwd.a(this.jdField_a_of_type_Amwd)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_Amwd;
        if ((paramamxd == null) || (paramamxd.jdField_a_of_type_Amwo == null)) {
          continue;
        }
        i = paramamxd.jdField_a_of_type_Amwo.c;
        ((amwd)localObject).i = i;
        amwd localamwd = this.jdField_a_of_type_Amwd;
        if ((paramamxd == null) || (paramamxd.jdField_a_of_type_Amwo == null) || (paramamxd.jdField_a_of_type_Amwo.a == null) || (paramamxd.jdField_a_of_type_Amwo.a.length <= 0)) {
          continue;
        }
        localObject = paramamxd.jdField_a_of_type_Amwo.a[0].jdField_a_of_type_JavaLangString;
        localamwd.jdField_a_of_type_JavaLangString = ((String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        long l1;
        long l2;
        boolean bool2;
        boolean bool1;
        QLog.i("AREngine_ARCloudControl", 1, "  mCloudTime  mImageId " + localException.getMessage());
        continue;
        int i = 0;
        continue;
        QLog.i("AREngine_ARCloudControl", 1, "MIGObjectClaasify not need  run requestToCheckLBSLocation.");
        amwd.a(this.jdField_a_of_type_Amwd).a(paramInt, paramamxd);
        return;
      }
      if (this.jdField_a_of_type_Amwd.c != 0L) {
        this.jdField_a_of_type_Amwd.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Amwd.c);
      }
      if (this.jdField_a_of_type_Amwd.d != 0L)
      {
        localObject = this.jdField_a_of_type_Amwd;
        ((amwd)localObject).g += System.currentTimeMillis() - this.jdField_a_of_type_Amwd.d;
      }
      if (amwd.a(this.jdField_a_of_type_Amwd) != null) {
        amwd.a(this.jdField_a_of_type_Amwd).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (amwd.a(this.jdField_a_of_type_Amwd) == null) {
        break;
      }
      if ((paramInt == 0) && (paramamxd != null) && ((amwo.a(paramamxd.jdField_a_of_type_Amwo)) || (amwt.a(paramamxd.jdField_a_of_type_Amwt)) || (amyk.a(paramamxd.jdField_a_of_type_Amyk)) || (amxf.a(paramamxd.jdField_a_of_type_Amxf)) || (amxl.a(paramamxd.jdField_a_of_type_Amxl))))
      {
        QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.jdField_a_of_type_Amwd.jdField_j_of_type_Int);
        this.jdField_a_of_type_Amwd.jdField_j_of_type_Int = 0;
      }
      if ((paramamxd != null) && (amwo.a(paramamxd.jdField_a_of_type_Amwo))) {
        paramamxd.jdField_a_of_type_Amwo.b = this.jdField_a_of_type_Amxi.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramamxd != null) && (amwt.a(paramamxd.jdField_a_of_type_Amwt))) {
        paramamxd.jdField_a_of_type_Amwt.b = this.jdField_a_of_type_Amxi.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramamxd != null) && (amxl.a(paramamxd.jdField_a_of_type_Amxl))) {
        paramamxd.jdField_a_of_type_Amxl.b = this.jdField_a_of_type_Amxi.a.jdField_a_of_type_JavaLangString;
      }
      if (!amwd.c(this.jdField_a_of_type_Amwd))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramInt == 0)
        {
          bool1 = bool2;
          if (paramamxd != null) {
            if ((!amwo.a(paramamxd.jdField_a_of_type_Amwo)) && (!amwt.a(paramamxd.jdField_a_of_type_Amwt)) && (!amxf.a(paramamxd.jdField_a_of_type_Amxf)) && (!amwv.a(paramamxd.jdField_a_of_type_Amwv)))
            {
              bool1 = bool2;
              if (!amxl.a(paramamxd.jdField_a_of_type_Amxl)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        l1 = amwd.a(this.jdField_a_of_type_Amwd).b();
        amud.a().a(bool1, l1);
        amwd.d(this.jdField_a_of_type_Amwd, true);
      }
      if ((!amwd.d(this.jdField_a_of_type_Amwd)) && (paramInt == 0) && (paramamxd != null) && ((amwo.a(paramamxd.jdField_a_of_type_Amwo)) || (amwt.a(paramamxd.jdField_a_of_type_Amwt)) || (amxf.a(paramamxd.jdField_a_of_type_Amxf)) || (amwv.a(paramamxd.jdField_a_of_type_Amwv)) || (amxl.a(paramamxd.jdField_a_of_type_Amxl))))
      {
        l1 = amwd.a(this.jdField_a_of_type_Amwd).b();
        amud.a().a(l1, this.jdField_a_of_type_Amwd.jdField_a_of_type_Amwk.c);
        amwd.e(this.jdField_a_of_type_Amwd, true);
      }
      if (amwd.a(this.jdField_a_of_type_Amwd) != null) {
        amwd.a(this.jdField_a_of_type_Amwd).add(paramString);
      }
      if ((this.jdField_a_of_type_Amwd.jdField_j_of_type_Int != 0) || (!amxd.a(this.jdField_a_of_type_Amwd.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramamxd))) {
        break label932;
      }
      if (this.jdField_a_of_type_Amwd.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.switchLBSLocation != 1) {
        break label917;
      }
      if ((paramamxd.jdField_a_of_type_Long == 128L) && ((paramamxd.jdField_a_of_type_Long != 128L) || (!amwd.a(this.jdField_a_of_type_Amwd).a(paramamxd.jdField_a_of_type_Amyk)))) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
      amwd.a(this.jdField_a_of_type_Amwd, paramInt, paramamxd);
      return;
      i = 0;
      continue;
      localObject = "";
    }
    label917:
    amwd.a(this.jdField_a_of_type_Amwd).a(2, null);
    return;
    label932:
    amwd.a(this.jdField_a_of_type_Amwd).a(paramInt, paramamxd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwg
 * JD-Core Version:    0.7.0.1
 */