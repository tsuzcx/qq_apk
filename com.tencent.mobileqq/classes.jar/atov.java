import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class atov
  extends AsyncTask<Void, Void, Void>
{
  atov(atou paramatou) {}
  
  protected Void a(Void... paramVarArgs)
  {
    atpg.a(this.a.a.jdField_a_of_type_Ator.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        atpp localatpp = (atpp)this.a.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = (atpw)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        if (((atpw)localObject2).jdField_a_of_type_Int == -2)
        {
          String str = atou.a(this.a, localatpp);
          if (str == null) {
            break label551;
          }
          atpg.a(this.a.a.jdField_a_of_type_Ator.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new axvt();
          ((axvt)localObject2).jdField_e_of_type_Boolean = false;
          ((axvt)localObject2).jdField_b_of_type_JavaLangString = ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((axvt)localObject2).c = this.a.a.jdField_a_of_type_Ator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((axvt)localObject2).d = this.a.a.jdField_a_of_type_Ator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((axvt)localObject2).jdField_a_of_type_Int = this.a.a.jdField_a_of_type_Ator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((axvt)localObject2).jdField_b_of_type_Int = 1;
          ((axvt)localObject2).jdField_a_of_type_Long = (this.a.a.jdField_a_of_type_Ator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (localObject1 = ((axvt)localObject2).c + ((axvt)localObject2).jdField_a_of_type_Long; ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a.containsKey(localObject1); localObject1 = ((axvt)localObject2).c + ((axvt)localObject2).jdField_a_of_type_Long) {
            ((axvt)localObject2).jdField_a_of_type_Long += 100L;
          }
          ((axvt)localObject2).jdField_a_of_type_Boolean = true;
          ((axvt)localObject2).jdField_e_of_type_Int = localatpp.jdField_a_of_type_Atqd.jdField_a_of_type_Int;
          ((axvt)localObject2).i = str;
          localObject1 = new axvx();
          if (localatpp.jdField_a_of_type_Int < 0)
          {
            ((axvx)localObject1).jdField_a_of_type_Boolean = false;
            ((axvt)localObject2).jdField_a_of_type_JavaLangObject = localObject1;
            ((axvt)localObject2).jdField_a_of_type_Atqq = new atow(this, i, str);
            ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a((axvt)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localatpp.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((axvx)localObject1).jdField_a_of_type_Boolean = bool;
          break;
        }
        label551:
        ((atpw)localObject2).jdField_a_of_type_Int = -1;
        ((atpw)localObject2).jdField_a_of_type_Atpr = new atpr();
        ((atpw)localObject2).jdField_a_of_type_Atpr.jdField_b_of_type_JavaLangString = ("Get target pic filepath of [" + i + "] failed");
        if ((localatpp.jdField_a_of_type_Atpn.jdField_b_of_type_Int == 1) || (localatpp.jdField_a_of_type_Atpn.jdField_b_of_type_Int == 3000))
        {
          ((atpw)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
          label645:
          if (!QLog.isColorLevel()) {
            break label793;
          }
          if (paramVarArgs != null) {
            break label790;
          }
          paramVarArgs = new StringBuilder();
          label663:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((atpw)localObject2).jdField_a_of_type_Atpr.jdField_b_of_type_JavaLangString).append("\n");
        }
      }
    }
    label790:
    label793:
    for (;;)
    {
      atou.a(this.a);
      if (atou.a(this.a) == 0) {
        atot.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((atpw)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
      break label645;
      if (paramVarArgs != null) {
        atpg.b(this.a.a.jdField_a_of_type_Ator.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label663;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atov
 * JD-Core Version:    0.7.0.1
 */