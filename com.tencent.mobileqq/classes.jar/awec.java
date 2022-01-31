import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class awec
  extends AsyncTask<Void, Void, Void>
{
  awec(aweb paramaweb) {}
  
  protected Void a(Void... paramVarArgs)
  {
    awen.a(this.a.a.jdField_a_of_type_Awdy.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        awew localawew = (awew)this.a.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = (awfd)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        if (((awfd)localObject2).jdField_a_of_type_Int == -2)
        {
          String str = aweb.a(this.a, localawew);
          if (str == null) {
            break label551;
          }
          awen.a(this.a.a.jdField_a_of_type_Awdy.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new baub();
          ((baub)localObject2).jdField_e_of_type_Boolean = false;
          ((baub)localObject2).jdField_b_of_type_JavaLangString = ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((baub)localObject2).c = this.a.a.jdField_a_of_type_Awdy.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((baub)localObject2).d = this.a.a.jdField_a_of_type_Awdy.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((baub)localObject2).jdField_a_of_type_Int = this.a.a.jdField_a_of_type_Awdy.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((baub)localObject2).jdField_b_of_type_Int = 1;
          ((baub)localObject2).jdField_a_of_type_Long = (this.a.a.jdField_a_of_type_Awdy.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (localObject1 = ((baub)localObject2).c + ((baub)localObject2).jdField_a_of_type_Long; ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a.containsKey(localObject1); localObject1 = ((baub)localObject2).c + ((baub)localObject2).jdField_a_of_type_Long) {
            ((baub)localObject2).jdField_a_of_type_Long += 100L;
          }
          ((baub)localObject2).jdField_a_of_type_Boolean = true;
          ((baub)localObject2).jdField_e_of_type_Int = localawew.jdField_a_of_type_Awfl.jdField_a_of_type_Int;
          ((baub)localObject2).i = str;
          localObject1 = new bauf();
          if (localawew.jdField_a_of_type_Int < 0)
          {
            ((bauf)localObject1).jdField_a_of_type_Boolean = false;
            ((baub)localObject2).jdField_a_of_type_JavaLangObject = localObject1;
            ((baub)localObject2).jdField_a_of_type_Awfy = new awed(this, i, str);
            ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a((baub)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localawew.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((bauf)localObject1).jdField_a_of_type_Boolean = bool;
          break;
        }
        label551:
        ((awfd)localObject2).jdField_a_of_type_Int = -1;
        ((awfd)localObject2).jdField_a_of_type_Awey = new awey();
        ((awfd)localObject2).jdField_a_of_type_Awey.jdField_b_of_type_JavaLangString = ("Get target pic filepath of [" + i + "] failed");
        if ((localawew.jdField_a_of_type_Aweu.jdField_b_of_type_Int == 1) || (localawew.jdField_a_of_type_Aweu.jdField_b_of_type_Int == 3000))
        {
          ((awfd)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
          label645:
          if (!QLog.isColorLevel()) {
            break label793;
          }
          if (paramVarArgs != null) {
            break label790;
          }
          paramVarArgs = new StringBuilder();
          label663:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((awfd)localObject2).jdField_a_of_type_Awey.jdField_b_of_type_JavaLangString).append("\n");
        }
      }
    }
    label790:
    label793:
    for (;;)
    {
      aweb.a(this.a);
      if (aweb.a(this.a) == 0) {
        awea.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((awfd)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
      break label645;
      if (paramVarArgs != null) {
        awen.b(this.a.a.jdField_a_of_type_Awdy.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label663;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awec
 * JD-Core Version:    0.7.0.1
 */