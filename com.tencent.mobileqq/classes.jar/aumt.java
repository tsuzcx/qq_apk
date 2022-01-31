import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class aumt
  extends AsyncTask<Void, Void, Void>
{
  aumt(aums paramaums) {}
  
  protected Void a(Void... paramVarArgs)
  {
    aune.a(this.a.a.jdField_a_of_type_Aump.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        aunn localaunn = (aunn)this.a.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = (aunu)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        if (((aunu)localObject2).jdField_a_of_type_Int == -2)
        {
          String str = aums.a(this.a, localaunn);
          if (str == null) {
            break label551;
          }
          aune.a(this.a.a.jdField_a_of_type_Aump.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new aywa();
          ((aywa)localObject2).jdField_e_of_type_Boolean = false;
          ((aywa)localObject2).jdField_b_of_type_JavaLangString = ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((aywa)localObject2).c = this.a.a.jdField_a_of_type_Aump.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((aywa)localObject2).d = this.a.a.jdField_a_of_type_Aump.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((aywa)localObject2).jdField_a_of_type_Int = this.a.a.jdField_a_of_type_Aump.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((aywa)localObject2).jdField_b_of_type_Int = 1;
          ((aywa)localObject2).jdField_a_of_type_Long = (this.a.a.jdField_a_of_type_Aump.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (localObject1 = ((aywa)localObject2).c + ((aywa)localObject2).jdField_a_of_type_Long; ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a.containsKey(localObject1); localObject1 = ((aywa)localObject2).c + ((aywa)localObject2).jdField_a_of_type_Long) {
            ((aywa)localObject2).jdField_a_of_type_Long += 100L;
          }
          ((aywa)localObject2).jdField_a_of_type_Boolean = true;
          ((aywa)localObject2).jdField_e_of_type_Int = localaunn.jdField_a_of_type_Auob.jdField_a_of_type_Int;
          ((aywa)localObject2).i = str;
          localObject1 = new aywe();
          if (localaunn.jdField_a_of_type_Int < 0)
          {
            ((aywe)localObject1).jdField_a_of_type_Boolean = false;
            ((aywa)localObject2).jdField_a_of_type_JavaLangObject = localObject1;
            ((aywa)localObject2).jdField_a_of_type_Auoo = new aumu(this, i, str);
            ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a((aywa)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localaunn.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((aywe)localObject1).jdField_a_of_type_Boolean = bool;
          break;
        }
        label551:
        ((aunu)localObject2).jdField_a_of_type_Int = -1;
        ((aunu)localObject2).jdField_a_of_type_Aunp = new aunp();
        ((aunu)localObject2).jdField_a_of_type_Aunp.jdField_b_of_type_JavaLangString = ("Get target pic filepath of [" + i + "] failed");
        if ((localaunn.jdField_a_of_type_Aunl.jdField_b_of_type_Int == 1) || (localaunn.jdField_a_of_type_Aunl.jdField_b_of_type_Int == 3000))
        {
          ((aunu)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
          label645:
          if (!QLog.isColorLevel()) {
            break label793;
          }
          if (paramVarArgs != null) {
            break label790;
          }
          paramVarArgs = new StringBuilder();
          label663:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((aunu)localObject2).jdField_a_of_type_Aunp.jdField_b_of_type_JavaLangString).append("\n");
        }
      }
    }
    label790:
    label793:
    for (;;)
    {
      aums.a(this.a);
      if (aums.a(this.a) == 0) {
        aumr.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((aunu)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
      break label645;
      if (paramVarArgs != null) {
        aune.b(this.a.a.jdField_a_of_type_Aump.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label663;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumt
 * JD-Core Version:    0.7.0.1
 */