import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aogj
  implements aofv
{
  aogj(aogg paramaogg, long paramLong, aohl paramaohl) {}
  
  public void a(int paramInt, String paramString, aohg paramaohg)
  {
    aogg.c(this.jdField_a_of_type_Aogg, false);
    if (aogg.a(this.jdField_a_of_type_Aogg)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_Aogg;
        if ((paramaohg == null) || (paramaohg.jdField_a_of_type_Aogr == null)) {
          continue;
        }
        i = paramaohg.jdField_a_of_type_Aogr.c;
        ((aogg)localObject).i = i;
        aogg localaogg = this.jdField_a_of_type_Aogg;
        if ((paramaohg == null) || (paramaohg.jdField_a_of_type_Aogr == null) || (paramaohg.jdField_a_of_type_Aogr.a == null) || (paramaohg.jdField_a_of_type_Aogr.a.length <= 0)) {
          continue;
        }
        localObject = paramaohg.jdField_a_of_type_Aogr.a[0].jdField_a_of_type_JavaLangString;
        localaogg.jdField_a_of_type_JavaLangString = ((String)localObject);
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
        aogg.a(this.jdField_a_of_type_Aogg).a(paramInt, paramaohg);
        return;
      }
      if (this.jdField_a_of_type_Aogg.c != 0L) {
        this.jdField_a_of_type_Aogg.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Aogg.c);
      }
      if (this.jdField_a_of_type_Aogg.d != 0L)
      {
        localObject = this.jdField_a_of_type_Aogg;
        ((aogg)localObject).g += System.currentTimeMillis() - this.jdField_a_of_type_Aogg.d;
      }
      if (aogg.a(this.jdField_a_of_type_Aogg) != null) {
        aogg.a(this.jdField_a_of_type_Aogg).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (aogg.a(this.jdField_a_of_type_Aogg) == null) {
        break;
      }
      if ((paramInt == 0) && (paramaohg != null) && ((aogr.a(paramaohg.jdField_a_of_type_Aogr)) || (aogw.a(paramaohg.jdField_a_of_type_Aogw)) || (aoin.a(paramaohg.jdField_a_of_type_Aoin)) || (aohi.a(paramaohg.jdField_a_of_type_Aohi)) || (aoho.a(paramaohg.jdField_a_of_type_Aoho))))
      {
        QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.jdField_a_of_type_Aogg.jdField_j_of_type_Int);
        this.jdField_a_of_type_Aogg.jdField_j_of_type_Int = 0;
      }
      if ((paramaohg != null) && (aogr.a(paramaohg.jdField_a_of_type_Aogr))) {
        paramaohg.jdField_a_of_type_Aogr.b = this.jdField_a_of_type_Aohl.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramaohg != null) && (aogw.a(paramaohg.jdField_a_of_type_Aogw))) {
        paramaohg.jdField_a_of_type_Aogw.b = this.jdField_a_of_type_Aohl.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramaohg != null) && (aoho.a(paramaohg.jdField_a_of_type_Aoho))) {
        paramaohg.jdField_a_of_type_Aoho.b = this.jdField_a_of_type_Aohl.a.jdField_a_of_type_JavaLangString;
      }
      if (!aogg.c(this.jdField_a_of_type_Aogg))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramInt == 0)
        {
          bool1 = bool2;
          if (paramaohg != null) {
            if ((!aogr.a(paramaohg.jdField_a_of_type_Aogr)) && (!aogw.a(paramaohg.jdField_a_of_type_Aogw)) && (!aohi.a(paramaohg.jdField_a_of_type_Aohi)) && (!aogy.a(paramaohg.jdField_a_of_type_Aogy)))
            {
              bool1 = bool2;
              if (!aoho.a(paramaohg.jdField_a_of_type_Aoho)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        l1 = aogg.a(this.jdField_a_of_type_Aogg).b();
        aoem.a().a(bool1, l1);
        aogg.d(this.jdField_a_of_type_Aogg, true);
      }
      if ((!aogg.d(this.jdField_a_of_type_Aogg)) && (paramInt == 0) && (paramaohg != null) && ((aogr.a(paramaohg.jdField_a_of_type_Aogr)) || (aogw.a(paramaohg.jdField_a_of_type_Aogw)) || (aohi.a(paramaohg.jdField_a_of_type_Aohi)) || (aogy.a(paramaohg.jdField_a_of_type_Aogy)) || (aoho.a(paramaohg.jdField_a_of_type_Aoho))))
      {
        l1 = aogg.a(this.jdField_a_of_type_Aogg).b();
        aoem.a().a(l1, this.jdField_a_of_type_Aogg.jdField_a_of_type_Aogn.c);
        aogg.e(this.jdField_a_of_type_Aogg, true);
      }
      if (aogg.a(this.jdField_a_of_type_Aogg) != null) {
        aogg.a(this.jdField_a_of_type_Aogg).add(paramString);
      }
      if ((this.jdField_a_of_type_Aogg.jdField_j_of_type_Int != 0) || (!aohg.a(this.jdField_a_of_type_Aogg.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramaohg))) {
        break label936;
      }
      if ((this.jdField_a_of_type_Aogg.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.switchLBSLocation != 1) || (paramaohg == null)) {
        break label921;
      }
      if ((paramaohg.jdField_a_of_type_Long == 128L) && ((paramaohg.jdField_a_of_type_Long != 128L) || (!aogg.a(this.jdField_a_of_type_Aogg).a(paramaohg.jdField_a_of_type_Aoin)))) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
      aogg.a(this.jdField_a_of_type_Aogg, paramInt, paramaohg);
      return;
      i = 0;
      continue;
      localObject = "";
    }
    label921:
    aogg.a(this.jdField_a_of_type_Aogg).a(2, null);
    return;
    label936:
    aogg.a(this.jdField_a_of_type_Aogg).a(paramInt, paramaohg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogj
 * JD-Core Version:    0.7.0.1
 */