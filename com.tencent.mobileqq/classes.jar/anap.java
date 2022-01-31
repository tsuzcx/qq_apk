import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class anap
  implements anab
{
  anap(anam paramanam, long paramLong, anbr paramanbr) {}
  
  public void a(int paramInt, String paramString, anbm paramanbm)
  {
    anam.c(this.jdField_a_of_type_Anam, false);
    if (anam.a(this.jdField_a_of_type_Anam)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_Anam;
        if ((paramanbm == null) || (paramanbm.jdField_a_of_type_Anax == null)) {
          continue;
        }
        i = paramanbm.jdField_a_of_type_Anax.c;
        ((anam)localObject).i = i;
        anam localanam = this.jdField_a_of_type_Anam;
        if ((paramanbm == null) || (paramanbm.jdField_a_of_type_Anax == null) || (paramanbm.jdField_a_of_type_Anax.a == null) || (paramanbm.jdField_a_of_type_Anax.a.length <= 0)) {
          continue;
        }
        localObject = paramanbm.jdField_a_of_type_Anax.a[0].jdField_a_of_type_JavaLangString;
        localanam.jdField_a_of_type_JavaLangString = ((String)localObject);
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
        anam.a(this.jdField_a_of_type_Anam).a(paramInt, paramanbm);
        return;
      }
      if (this.jdField_a_of_type_Anam.c != 0L) {
        this.jdField_a_of_type_Anam.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Anam.c);
      }
      if (this.jdField_a_of_type_Anam.d != 0L)
      {
        localObject = this.jdField_a_of_type_Anam;
        ((anam)localObject).g += System.currentTimeMillis() - this.jdField_a_of_type_Anam.d;
      }
      if (anam.a(this.jdField_a_of_type_Anam) != null) {
        anam.a(this.jdField_a_of_type_Anam).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (anam.a(this.jdField_a_of_type_Anam) == null) {
        break;
      }
      if ((paramInt == 0) && (paramanbm != null) && ((anax.a(paramanbm.jdField_a_of_type_Anax)) || (anbc.a(paramanbm.jdField_a_of_type_Anbc)) || (anct.a(paramanbm.jdField_a_of_type_Anct)) || (anbo.a(paramanbm.jdField_a_of_type_Anbo)) || (anbu.a(paramanbm.jdField_a_of_type_Anbu))))
      {
        QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.jdField_a_of_type_Anam.jdField_j_of_type_Int);
        this.jdField_a_of_type_Anam.jdField_j_of_type_Int = 0;
      }
      if ((paramanbm != null) && (anax.a(paramanbm.jdField_a_of_type_Anax))) {
        paramanbm.jdField_a_of_type_Anax.b = this.jdField_a_of_type_Anbr.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramanbm != null) && (anbc.a(paramanbm.jdField_a_of_type_Anbc))) {
        paramanbm.jdField_a_of_type_Anbc.b = this.jdField_a_of_type_Anbr.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramanbm != null) && (anbu.a(paramanbm.jdField_a_of_type_Anbu))) {
        paramanbm.jdField_a_of_type_Anbu.b = this.jdField_a_of_type_Anbr.a.jdField_a_of_type_JavaLangString;
      }
      if (!anam.c(this.jdField_a_of_type_Anam))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramInt == 0)
        {
          bool1 = bool2;
          if (paramanbm != null) {
            if ((!anax.a(paramanbm.jdField_a_of_type_Anax)) && (!anbc.a(paramanbm.jdField_a_of_type_Anbc)) && (!anbo.a(paramanbm.jdField_a_of_type_Anbo)) && (!anbe.a(paramanbm.jdField_a_of_type_Anbe)))
            {
              bool1 = bool2;
              if (!anbu.a(paramanbm.jdField_a_of_type_Anbu)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        l1 = anam.a(this.jdField_a_of_type_Anam).b();
        amys.a().a(bool1, l1);
        anam.d(this.jdField_a_of_type_Anam, true);
      }
      if ((!anam.d(this.jdField_a_of_type_Anam)) && (paramInt == 0) && (paramanbm != null) && ((anax.a(paramanbm.jdField_a_of_type_Anax)) || (anbc.a(paramanbm.jdField_a_of_type_Anbc)) || (anbo.a(paramanbm.jdField_a_of_type_Anbo)) || (anbe.a(paramanbm.jdField_a_of_type_Anbe)) || (anbu.a(paramanbm.jdField_a_of_type_Anbu))))
      {
        l1 = anam.a(this.jdField_a_of_type_Anam).b();
        amys.a().a(l1, this.jdField_a_of_type_Anam.jdField_a_of_type_Anat.c);
        anam.e(this.jdField_a_of_type_Anam, true);
      }
      if (anam.a(this.jdField_a_of_type_Anam) != null) {
        anam.a(this.jdField_a_of_type_Anam).add(paramString);
      }
      if ((this.jdField_a_of_type_Anam.jdField_j_of_type_Int != 0) || (!anbm.a(this.jdField_a_of_type_Anam.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramanbm))) {
        break label932;
      }
      if (this.jdField_a_of_type_Anam.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.switchLBSLocation != 1) {
        break label917;
      }
      if ((paramanbm.jdField_a_of_type_Long == 128L) && ((paramanbm.jdField_a_of_type_Long != 128L) || (!anam.a(this.jdField_a_of_type_Anam).a(paramanbm.jdField_a_of_type_Anct)))) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
      anam.a(this.jdField_a_of_type_Anam, paramInt, paramanbm);
      return;
      i = 0;
      continue;
      localObject = "";
    }
    label917:
    anam.a(this.jdField_a_of_type_Anam).a(2, null);
    return;
    label932:
    anam.a(this.jdField_a_of_type_Anam).a(paramInt, paramanbm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anap
 * JD-Core Version:    0.7.0.1
 */