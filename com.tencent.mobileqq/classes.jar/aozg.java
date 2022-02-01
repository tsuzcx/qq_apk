import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aozg
  implements aoys
{
  aozg(aozd paramaozd, long paramLong, apai paramapai) {}
  
  public void a(int paramInt, String paramString, apad paramapad)
  {
    aozd.c(this.jdField_a_of_type_Aozd, false);
    if (aozd.a(this.jdField_a_of_type_Aozd)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_Aozd;
        if ((paramapad == null) || (paramapad.jdField_a_of_type_Aozo == null)) {
          continue;
        }
        i = paramapad.jdField_a_of_type_Aozo.c;
        ((aozd)localObject).i = i;
        aozd localaozd = this.jdField_a_of_type_Aozd;
        if ((paramapad == null) || (paramapad.jdField_a_of_type_Aozo == null) || (paramapad.jdField_a_of_type_Aozo.a == null) || (paramapad.jdField_a_of_type_Aozo.a.length <= 0)) {
          continue;
        }
        localObject = paramapad.jdField_a_of_type_Aozo.a[0].jdField_a_of_type_JavaLangString;
        localaozd.jdField_a_of_type_JavaLangString = ((String)localObject);
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
        aozd.a(this.jdField_a_of_type_Aozd).a(paramInt, paramapad);
        return;
      }
      if (this.jdField_a_of_type_Aozd.c != 0L) {
        this.jdField_a_of_type_Aozd.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Aozd.c);
      }
      if (this.jdField_a_of_type_Aozd.d != 0L)
      {
        localObject = this.jdField_a_of_type_Aozd;
        ((aozd)localObject).g += System.currentTimeMillis() - this.jdField_a_of_type_Aozd.d;
      }
      if (aozd.a(this.jdField_a_of_type_Aozd) != null) {
        aozd.a(this.jdField_a_of_type_Aozd).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (aozd.a(this.jdField_a_of_type_Aozd) == null) {
        break;
      }
      if ((paramInt == 0) && (paramapad != null) && ((aozo.a(paramapad.jdField_a_of_type_Aozo)) || (aozt.a(paramapad.jdField_a_of_type_Aozt)) || (apbk.a(paramapad.jdField_a_of_type_Apbk)) || (apaf.a(paramapad.jdField_a_of_type_Apaf)) || (apal.a(paramapad.jdField_a_of_type_Apal))))
      {
        QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.jdField_a_of_type_Aozd.jdField_j_of_type_Int);
        this.jdField_a_of_type_Aozd.jdField_j_of_type_Int = 0;
      }
      if ((paramapad != null) && (aozo.a(paramapad.jdField_a_of_type_Aozo))) {
        paramapad.jdField_a_of_type_Aozo.b = this.jdField_a_of_type_Apai.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramapad != null) && (aozt.a(paramapad.jdField_a_of_type_Aozt))) {
        paramapad.jdField_a_of_type_Aozt.b = this.jdField_a_of_type_Apai.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramapad != null) && (apal.a(paramapad.jdField_a_of_type_Apal))) {
        paramapad.jdField_a_of_type_Apal.b = this.jdField_a_of_type_Apai.a.jdField_a_of_type_JavaLangString;
      }
      if (!aozd.c(this.jdField_a_of_type_Aozd))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramInt == 0)
        {
          bool1 = bool2;
          if (paramapad != null) {
            if ((!aozo.a(paramapad.jdField_a_of_type_Aozo)) && (!aozt.a(paramapad.jdField_a_of_type_Aozt)) && (!apaf.a(paramapad.jdField_a_of_type_Apaf)) && (!aozv.a(paramapad.jdField_a_of_type_Aozv)))
            {
              bool1 = bool2;
              if (!apal.a(paramapad.jdField_a_of_type_Apal)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        l1 = aozd.a(this.jdField_a_of_type_Aozd).b();
        aoxj.a().a(bool1, l1);
        aozd.d(this.jdField_a_of_type_Aozd, true);
      }
      if ((!aozd.d(this.jdField_a_of_type_Aozd)) && (paramInt == 0) && (paramapad != null) && ((aozo.a(paramapad.jdField_a_of_type_Aozo)) || (aozt.a(paramapad.jdField_a_of_type_Aozt)) || (apaf.a(paramapad.jdField_a_of_type_Apaf)) || (aozv.a(paramapad.jdField_a_of_type_Aozv)) || (apal.a(paramapad.jdField_a_of_type_Apal))))
      {
        l1 = aozd.a(this.jdField_a_of_type_Aozd).b();
        aoxj.a().a(l1, this.jdField_a_of_type_Aozd.jdField_a_of_type_Aozk.c);
        aozd.e(this.jdField_a_of_type_Aozd, true);
      }
      if (aozd.a(this.jdField_a_of_type_Aozd) != null) {
        aozd.a(this.jdField_a_of_type_Aozd).add(paramString);
      }
      if ((this.jdField_a_of_type_Aozd.jdField_j_of_type_Int != 0) || (!apad.a(this.jdField_a_of_type_Aozd.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramapad))) {
        break label932;
      }
      if (this.jdField_a_of_type_Aozd.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.switchLBSLocation != 1) {
        break label917;
      }
      if ((paramapad.jdField_a_of_type_Long == 128L) && ((paramapad.jdField_a_of_type_Long != 128L) || (!aozd.a(this.jdField_a_of_type_Aozd).a(paramapad.jdField_a_of_type_Apbk)))) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
      aozd.a(this.jdField_a_of_type_Aozd, paramInt, paramapad);
      return;
      i = 0;
      continue;
      localObject = "";
    }
    label917:
    aozd.a(this.jdField_a_of_type_Aozd).a(2, null);
    return;
    label932:
    aozd.a(this.jdField_a_of_type_Aozd).a(paramInt, paramapad);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozg
 * JD-Core Version:    0.7.0.1
 */