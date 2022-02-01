import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class aywx
  extends AsyncTask<Void, Void, Void>
{
  aywx(ayww paramayww) {}
  
  protected Void a(Void... paramVarArgs)
  {
    ayxi.a(this.a.a.jdField_a_of_type_Aywt.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ayxr localayxr = (ayxr)this.a.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = (ayxy)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        if (((ayxy)localObject2).jdField_a_of_type_Int == -2)
        {
          String str = ayww.a(this.a, localayxr);
          if (str == null) {
            break label551;
          }
          ayxi.a(this.a.a.jdField_a_of_type_Aywt.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new bdzn();
          ((bdzn)localObject2).jdField_e_of_type_Boolean = false;
          ((bdzn)localObject2).jdField_b_of_type_JavaLangString = ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((bdzn)localObject2).c = this.a.a.jdField_a_of_type_Aywt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((bdzn)localObject2).d = this.a.a.jdField_a_of_type_Aywt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((bdzn)localObject2).jdField_a_of_type_Int = this.a.a.jdField_a_of_type_Aywt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((bdzn)localObject2).jdField_b_of_type_Int = 1;
          ((bdzn)localObject2).jdField_a_of_type_Long = (this.a.a.jdField_a_of_type_Aywt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (localObject1 = ((bdzn)localObject2).c + ((bdzn)localObject2).jdField_a_of_type_Long; ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a.containsKey(localObject1); localObject1 = ((bdzn)localObject2).c + ((bdzn)localObject2).jdField_a_of_type_Long) {
            ((bdzn)localObject2).jdField_a_of_type_Long += 100L;
          }
          ((bdzn)localObject2).jdField_a_of_type_Boolean = true;
          ((bdzn)localObject2).jdField_e_of_type_Int = localayxr.jdField_a_of_type_Ayyg.jdField_a_of_type_Int;
          ((bdzn)localObject2).i = str;
          localObject1 = new bdzr();
          if (localayxr.jdField_a_of_type_Int < 0)
          {
            ((bdzr)localObject1).jdField_a_of_type_Boolean = false;
            ((bdzn)localObject2).jdField_a_of_type_JavaLangObject = localObject1;
            ((bdzn)localObject2).jdField_a_of_type_Ayyt = new aywy(this, i, str);
            ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a((bdzn)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localayxr.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((bdzr)localObject1).jdField_a_of_type_Boolean = bool;
          break;
        }
        label551:
        ((ayxy)localObject2).jdField_a_of_type_Int = -1;
        ((ayxy)localObject2).jdField_a_of_type_Ayxt = new ayxt();
        ((ayxy)localObject2).jdField_a_of_type_Ayxt.jdField_b_of_type_JavaLangString = ("Get target pic filepath of [" + i + "] failed");
        if ((localayxr.jdField_a_of_type_Ayxp.jdField_b_of_type_Int == 1) || (localayxr.jdField_a_of_type_Ayxp.jdField_b_of_type_Int == 3000))
        {
          ((ayxy)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
          label645:
          if (!QLog.isColorLevel()) {
            break label793;
          }
          if (paramVarArgs != null) {
            break label790;
          }
          paramVarArgs = new StringBuilder();
          label663:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((ayxy)localObject2).jdField_a_of_type_Ayxt.jdField_b_of_type_JavaLangString).append("\n");
        }
      }
    }
    label790:
    label793:
    for (;;)
    {
      ayww.a(this.a);
      if (ayww.a(this.a) == 0) {
        aywv.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((ayxy)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
      break label645;
      if (paramVarArgs != null) {
        ayxi.b(this.a.a.jdField_a_of_type_Aywt.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label663;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywx
 * JD-Core Version:    0.7.0.1
 */