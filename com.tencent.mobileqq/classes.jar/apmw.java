import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class apmw
  implements apmi
{
  apmw(apmt paramapmt, long paramLong, apny paramapny) {}
  
  public void a(int paramInt, String paramString, apnt paramapnt)
  {
    apmt.c(this.jdField_a_of_type_Apmt, false);
    if (apmt.a(this.jdField_a_of_type_Apmt)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_Apmt;
        if ((paramapnt == null) || (paramapnt.jdField_a_of_type_Apne == null)) {
          continue;
        }
        i = paramapnt.jdField_a_of_type_Apne.c;
        ((apmt)localObject).i = i;
        apmt localapmt = this.jdField_a_of_type_Apmt;
        if ((paramapnt == null) || (paramapnt.jdField_a_of_type_Apne == null) || (paramapnt.jdField_a_of_type_Apne.a == null) || (paramapnt.jdField_a_of_type_Apne.a.length <= 0)) {
          continue;
        }
        localObject = paramapnt.jdField_a_of_type_Apne.a[0].jdField_a_of_type_JavaLangString;
        localapmt.jdField_a_of_type_JavaLangString = ((String)localObject);
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
        apmt.a(this.jdField_a_of_type_Apmt).a(paramInt, paramapnt);
        return;
      }
      if (this.jdField_a_of_type_Apmt.c != 0L) {
        this.jdField_a_of_type_Apmt.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Apmt.c);
      }
      if (this.jdField_a_of_type_Apmt.d != 0L)
      {
        localObject = this.jdField_a_of_type_Apmt;
        ((apmt)localObject).g += System.currentTimeMillis() - this.jdField_a_of_type_Apmt.d;
      }
      if (apmt.a(this.jdField_a_of_type_Apmt) != null) {
        apmt.a(this.jdField_a_of_type_Apmt).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (apmt.a(this.jdField_a_of_type_Apmt) == null) {
        break;
      }
      if ((paramInt == 0) && (paramapnt != null) && ((apne.a(paramapnt.jdField_a_of_type_Apne)) || (apnj.a(paramapnt.jdField_a_of_type_Apnj)) || (appa.a(paramapnt.jdField_a_of_type_Appa)) || (apnv.a(paramapnt.jdField_a_of_type_Apnv)) || (apob.a(paramapnt.jdField_a_of_type_Apob))))
      {
        QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.jdField_a_of_type_Apmt.jdField_j_of_type_Int);
        this.jdField_a_of_type_Apmt.jdField_j_of_type_Int = 0;
      }
      if ((paramapnt != null) && (apne.a(paramapnt.jdField_a_of_type_Apne))) {
        paramapnt.jdField_a_of_type_Apne.b = this.jdField_a_of_type_Apny.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramapnt != null) && (apnj.a(paramapnt.jdField_a_of_type_Apnj))) {
        paramapnt.jdField_a_of_type_Apnj.b = this.jdField_a_of_type_Apny.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramapnt != null) && (apob.a(paramapnt.jdField_a_of_type_Apob))) {
        paramapnt.jdField_a_of_type_Apob.b = this.jdField_a_of_type_Apny.a.jdField_a_of_type_JavaLangString;
      }
      if (!apmt.c(this.jdField_a_of_type_Apmt))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramInt == 0)
        {
          bool1 = bool2;
          if (paramapnt != null) {
            if ((!apne.a(paramapnt.jdField_a_of_type_Apne)) && (!apnj.a(paramapnt.jdField_a_of_type_Apnj)) && (!apnv.a(paramapnt.jdField_a_of_type_Apnv)) && (!apnl.a(paramapnt.jdField_a_of_type_Apnl)))
            {
              bool1 = bool2;
              if (!apob.a(paramapnt.jdField_a_of_type_Apob)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        l1 = apmt.a(this.jdField_a_of_type_Apmt).b();
        apkz.a().a(bool1, l1);
        apmt.d(this.jdField_a_of_type_Apmt, true);
      }
      if ((!apmt.d(this.jdField_a_of_type_Apmt)) && (paramInt == 0) && (paramapnt != null) && ((apne.a(paramapnt.jdField_a_of_type_Apne)) || (apnj.a(paramapnt.jdField_a_of_type_Apnj)) || (apnv.a(paramapnt.jdField_a_of_type_Apnv)) || (apnl.a(paramapnt.jdField_a_of_type_Apnl)) || (apob.a(paramapnt.jdField_a_of_type_Apob))))
      {
        l1 = apmt.a(this.jdField_a_of_type_Apmt).b();
        apkz.a().a(l1, this.jdField_a_of_type_Apmt.jdField_a_of_type_Apna.c);
        apmt.e(this.jdField_a_of_type_Apmt, true);
      }
      if (apmt.a(this.jdField_a_of_type_Apmt) != null) {
        apmt.a(this.jdField_a_of_type_Apmt).add(paramString);
      }
      if ((this.jdField_a_of_type_Apmt.jdField_j_of_type_Int != 0) || (!apnt.a(this.jdField_a_of_type_Apmt.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramapnt))) {
        break label932;
      }
      if (this.jdField_a_of_type_Apmt.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.switchLBSLocation != 1) {
        break label917;
      }
      if ((paramapnt.jdField_a_of_type_Long == 128L) && ((paramapnt.jdField_a_of_type_Long != 128L) || (!apmt.a(this.jdField_a_of_type_Apmt).a(paramapnt.jdField_a_of_type_Appa)))) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
      apmt.a(this.jdField_a_of_type_Apmt, paramInt, paramapnt);
      return;
      i = 0;
      continue;
      localObject = "";
    }
    label917:
    apmt.a(this.jdField_a_of_type_Apmt).a(2, null);
    return;
    label932:
    apmt.a(this.jdField_a_of_type_Apmt).a(paramInt, paramapnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmw
 * JD-Core Version:    0.7.0.1
 */