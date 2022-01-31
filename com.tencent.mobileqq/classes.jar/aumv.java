import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class aumv
  extends AsyncTask<Void, Void, Void>
{
  aumv(aumu paramaumu) {}
  
  protected Void a(Void... paramVarArgs)
  {
    aung.a(this.a.a.jdField_a_of_type_Aumr.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        aunp localaunp = (aunp)this.a.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = (aunw)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        if (((aunw)localObject2).jdField_a_of_type_Int == -2)
        {
          String str = aumu.a(this.a, localaunp);
          if (str == null) {
            break label551;
          }
          aung.a(this.a.a.jdField_a_of_type_Aumr.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new aywc();
          ((aywc)localObject2).jdField_e_of_type_Boolean = false;
          ((aywc)localObject2).jdField_b_of_type_JavaLangString = ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((aywc)localObject2).c = this.a.a.jdField_a_of_type_Aumr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((aywc)localObject2).d = this.a.a.jdField_a_of_type_Aumr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((aywc)localObject2).jdField_a_of_type_Int = this.a.a.jdField_a_of_type_Aumr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((aywc)localObject2).jdField_b_of_type_Int = 1;
          ((aywc)localObject2).jdField_a_of_type_Long = (this.a.a.jdField_a_of_type_Aumr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (localObject1 = ((aywc)localObject2).c + ((aywc)localObject2).jdField_a_of_type_Long; ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a.containsKey(localObject1); localObject1 = ((aywc)localObject2).c + ((aywc)localObject2).jdField_a_of_type_Long) {
            ((aywc)localObject2).jdField_a_of_type_Long += 100L;
          }
          ((aywc)localObject2).jdField_a_of_type_Boolean = true;
          ((aywc)localObject2).jdField_e_of_type_Int = localaunp.jdField_a_of_type_Auod.jdField_a_of_type_Int;
          ((aywc)localObject2).i = str;
          localObject1 = new aywg();
          if (localaunp.jdField_a_of_type_Int < 0)
          {
            ((aywg)localObject1).jdField_a_of_type_Boolean = false;
            ((aywc)localObject2).jdField_a_of_type_JavaLangObject = localObject1;
            ((aywc)localObject2).jdField_a_of_type_Auoq = new aumw(this, i, str);
            ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a((aywc)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localaunp.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((aywg)localObject1).jdField_a_of_type_Boolean = bool;
          break;
        }
        label551:
        ((aunw)localObject2).jdField_a_of_type_Int = -1;
        ((aunw)localObject2).jdField_a_of_type_Aunr = new aunr();
        ((aunw)localObject2).jdField_a_of_type_Aunr.jdField_b_of_type_JavaLangString = ("Get target pic filepath of [" + i + "] failed");
        if ((localaunp.jdField_a_of_type_Aunn.jdField_b_of_type_Int == 1) || (localaunp.jdField_a_of_type_Aunn.jdField_b_of_type_Int == 3000))
        {
          ((aunw)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
          label645:
          if (!QLog.isColorLevel()) {
            break label793;
          }
          if (paramVarArgs != null) {
            break label790;
          }
          paramVarArgs = new StringBuilder();
          label663:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((aunw)localObject2).jdField_a_of_type_Aunr.jdField_b_of_type_JavaLangString).append("\n");
        }
      }
    }
    label790:
    label793:
    for (;;)
    {
      aumu.a(this.a);
      if (aumu.a(this.a) == 0) {
        aumt.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((aunw)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
      break label645;
      if (paramVarArgs != null) {
        aung.b(this.a.a.jdField_a_of_type_Aumr.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label663;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumv
 * JD-Core Version:    0.7.0.1
 */