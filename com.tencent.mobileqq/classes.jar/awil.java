import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class awil
  extends AsyncTask<Void, Void, Void>
{
  awil(awik paramawik) {}
  
  protected Void a(Void... paramVarArgs)
  {
    awiw.a(this.a.a.jdField_a_of_type_Awih.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        awjf localawjf = (awjf)this.a.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = (awjm)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        if (((awjm)localObject2).jdField_a_of_type_Int == -2)
        {
          String str = awik.a(this.a, localawjf);
          if (str == null) {
            break label551;
          }
          awiw.a(this.a.a.jdField_a_of_type_Awih.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new bayk();
          ((bayk)localObject2).jdField_e_of_type_Boolean = false;
          ((bayk)localObject2).jdField_b_of_type_JavaLangString = ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((bayk)localObject2).c = this.a.a.jdField_a_of_type_Awih.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((bayk)localObject2).d = this.a.a.jdField_a_of_type_Awih.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((bayk)localObject2).jdField_a_of_type_Int = this.a.a.jdField_a_of_type_Awih.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((bayk)localObject2).jdField_b_of_type_Int = 1;
          ((bayk)localObject2).jdField_a_of_type_Long = (this.a.a.jdField_a_of_type_Awih.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (localObject1 = ((bayk)localObject2).c + ((bayk)localObject2).jdField_a_of_type_Long; ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a.containsKey(localObject1); localObject1 = ((bayk)localObject2).c + ((bayk)localObject2).jdField_a_of_type_Long) {
            ((bayk)localObject2).jdField_a_of_type_Long += 100L;
          }
          ((bayk)localObject2).jdField_a_of_type_Boolean = true;
          ((bayk)localObject2).jdField_e_of_type_Int = localawjf.jdField_a_of_type_Awju.jdField_a_of_type_Int;
          ((bayk)localObject2).i = str;
          localObject1 = new bayo();
          if (localawjf.jdField_a_of_type_Int < 0)
          {
            ((bayo)localObject1).jdField_a_of_type_Boolean = false;
            ((bayk)localObject2).jdField_a_of_type_JavaLangObject = localObject1;
            ((bayk)localObject2).jdField_a_of_type_Awkh = new awim(this, i, str);
            ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a((bayk)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localawjf.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((bayo)localObject1).jdField_a_of_type_Boolean = bool;
          break;
        }
        label551:
        ((awjm)localObject2).jdField_a_of_type_Int = -1;
        ((awjm)localObject2).jdField_a_of_type_Awjh = new awjh();
        ((awjm)localObject2).jdField_a_of_type_Awjh.jdField_b_of_type_JavaLangString = ("Get target pic filepath of [" + i + "] failed");
        if ((localawjf.jdField_a_of_type_Awjd.jdField_b_of_type_Int == 1) || (localawjf.jdField_a_of_type_Awjd.jdField_b_of_type_Int == 3000))
        {
          ((awjm)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
          label645:
          if (!QLog.isColorLevel()) {
            break label793;
          }
          if (paramVarArgs != null) {
            break label790;
          }
          paramVarArgs = new StringBuilder();
          label663:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((awjm)localObject2).jdField_a_of_type_Awjh.jdField_b_of_type_JavaLangString).append("\n");
        }
      }
    }
    label790:
    label793:
    for (;;)
    {
      awik.a(this.a);
      if (awik.a(this.a) == 0) {
        awij.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((awjm)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
      break label645;
      if (paramVarArgs != null) {
        awiw.b(this.a.a.jdField_a_of_type_Awih.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label663;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awil
 * JD-Core Version:    0.7.0.1
 */