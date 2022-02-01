import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class apjl
  implements apix
{
  apjl(apji paramapji, long paramLong, apkn paramapkn) {}
  
  public void a(int paramInt, String paramString, apki paramapki)
  {
    int j = 0;
    apji.c(this.jdField_a_of_type_Apji, false);
    if (apji.a(this.jdField_a_of_type_Apji)) {}
    label108:
    do
    {
      return;
      try
      {
        localObject = this.jdField_a_of_type_Apji;
        if ((paramapki == null) || (paramapki.jdField_a_of_type_Apjt == null)) {
          break;
        }
        i = paramapki.jdField_a_of_type_Apjt.c;
        ((apji)localObject).i = i;
        apji localapji = this.jdField_a_of_type_Apji;
        if ((paramapki == null) || (paramapki.jdField_a_of_type_Apjt == null) || (paramapki.jdField_a_of_type_Apjt.a == null) || (paramapki.jdField_a_of_type_Apjt.a.length <= 0)) {
          break label849;
        }
        localObject = paramapki.jdField_a_of_type_Apjt.a[0].jdField_a_of_type_JavaLangString;
        localapji.jdField_a_of_type_JavaLangString = ((String)localObject);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          int i;
          long l1;
          long l2;
          QLog.i("AREngine_ARCloudControl", 1, "  mCloudTime  mImageId " + localException.getMessage());
        }
        QLog.i("AREngine_ARCloudControl", 1, "MIGObjectClaasify not need  run requestToCheckLBSLocation.");
        apji.a(this.jdField_a_of_type_Apji).a(paramInt, paramapki);
        return;
      }
      if (this.jdField_a_of_type_Apji.c != 0L) {
        this.jdField_a_of_type_Apji.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Apji.c);
      }
      if (this.jdField_a_of_type_Apji.d != 0L)
      {
        localObject = this.jdField_a_of_type_Apji;
        ((apji)localObject).g += System.currentTimeMillis() - this.jdField_a_of_type_Apji.d;
      }
      if (apji.a(this.jdField_a_of_type_Apji) != null) {
        apji.a(this.jdField_a_of_type_Apji).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
    } while (apji.a(this.jdField_a_of_type_Apji) == null);
    if ((paramInt == 0) && (paramapki != null) && ((apjt.a(paramapki.jdField_a_of_type_Apjt)) || (apjy.a(paramapki.jdField_a_of_type_Apjy)) || (aplp.a(paramapki.jdField_a_of_type_Aplp)) || (apkk.a(paramapki.jdField_a_of_type_Apkk)) || (apkq.a(paramapki.jdField_a_of_type_Apkq))))
    {
      QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.jdField_a_of_type_Apji.jdField_j_of_type_Int);
      this.jdField_a_of_type_Apji.jdField_j_of_type_Int = 0;
    }
    if ((paramapki != null) && (apjt.a(paramapki.jdField_a_of_type_Apjt))) {
      paramapki.jdField_a_of_type_Apjt.b = this.jdField_a_of_type_Apkn.a.jdField_a_of_type_JavaLangString;
    }
    if ((paramapki != null) && (apjy.a(paramapki.jdField_a_of_type_Apjy))) {
      paramapki.jdField_a_of_type_Apjy.b = this.jdField_a_of_type_Apkn.a.jdField_a_of_type_JavaLangString;
    }
    if ((paramapki != null) && (apkq.a(paramapki.jdField_a_of_type_Apkq))) {
      paramapki.jdField_a_of_type_Apkq.b = this.jdField_a_of_type_Apkn.a.jdField_a_of_type_JavaLangString;
    }
    if (!apji.c(this.jdField_a_of_type_Apji)) {
      if ((paramInt != 0) || (paramapki == null) || ((!apjt.a(paramapki.jdField_a_of_type_Apjt)) && (!apjy.a(paramapki.jdField_a_of_type_Apjy)) && (!apkk.a(paramapki.jdField_a_of_type_Apkk)) && (!apka.a(paramapki.jdField_a_of_type_Apka)) && (!apkq.a(paramapki.jdField_a_of_type_Apkq)))) {
        break label957;
      }
    }
    label957:
    for (boolean bool = true;; bool = false)
    {
      l1 = apji.a(this.jdField_a_of_type_Apji).b();
      apho.a().a(bool, l1);
      apji.d(this.jdField_a_of_type_Apji, true);
      if ((!apji.d(this.jdField_a_of_type_Apji)) && (paramInt == 0) && (paramapki != null) && ((apjt.a(paramapki.jdField_a_of_type_Apjt)) || (apjy.a(paramapki.jdField_a_of_type_Apjy)) || (apkk.a(paramapki.jdField_a_of_type_Apkk)) || (apka.a(paramapki.jdField_a_of_type_Apka)) || (apkq.a(paramapki.jdField_a_of_type_Apkq))))
      {
        l1 = apji.a(this.jdField_a_of_type_Apji).b();
        apho.a().a(l1, this.jdField_a_of_type_Apji.jdField_a_of_type_Apjp.c);
        apji.e(this.jdField_a_of_type_Apji, true);
      }
      if (apji.a(this.jdField_a_of_type_Apji) != null) {
        apji.a(this.jdField_a_of_type_Apji).add(paramString);
      }
      if ((this.jdField_a_of_type_Apji.jdField_j_of_type_Int == 0) && (paramapki != null) && (apki.a(this.jdField_a_of_type_Apji.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramapki)))
      {
        if ((this.jdField_a_of_type_Apji.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.switchLBSLocation == 1) && (paramapki != null))
        {
          if (paramapki.jdField_a_of_type_Long == 128L)
          {
            i = j;
            if (paramapki.jdField_a_of_type_Long == 128L)
            {
              i = j;
              if (!apji.a(this.jdField_a_of_type_Apji).a(paramapki.jdField_a_of_type_Aplp)) {}
            }
          }
          else
          {
            i = 1;
          }
          if (i != 0)
          {
            QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
            apji.a(this.jdField_a_of_type_Apji, paramInt, paramapki);
            return;
            i = 0;
            break;
            label849:
            localObject = "";
            break label108;
          }
        }
        apji.a(this.jdField_a_of_type_Apji).a(2, null);
        return;
      }
      apjo localapjo = apji.a(this.jdField_a_of_type_Apji);
      paramString = paramapki;
      if (paramapki == null) {
        paramString = null;
      }
      localapjo.a(paramInt, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjl
 * JD-Core Version:    0.7.0.1
 */