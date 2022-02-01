import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class azpk
  extends AsyncTask<Void, Void, Void>
{
  azpk(azpj paramazpj) {}
  
  protected Void a(Void... paramVarArgs)
  {
    azpw.a(this.a.a.jdField_a_of_type_Azpg.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        azqf localazqf = (azqf)this.a.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = (azql)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        if (((azql)localObject2).jdField_a_of_type_Int == -2)
        {
          String str = azpj.a(this.a, localazqf);
          if (str == null) {
            break label551;
          }
          azpw.a(this.a.a.jdField_a_of_type_Azpg.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new beyg();
          ((beyg)localObject2).f = false;
          ((beyg)localObject2).jdField_b_of_type_JavaLangString = ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((beyg)localObject2).c = this.a.a.jdField_a_of_type_Azpg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((beyg)localObject2).d = this.a.a.jdField_a_of_type_Azpg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((beyg)localObject2).jdField_a_of_type_Int = this.a.a.jdField_a_of_type_Azpg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((beyg)localObject2).jdField_b_of_type_Int = 1;
          ((beyg)localObject2).jdField_a_of_type_Long = (this.a.a.jdField_a_of_type_Azpg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (localObject1 = ((beyg)localObject2).c + ((beyg)localObject2).jdField_a_of_type_Long; ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a.containsKey(localObject1); localObject1 = ((beyg)localObject2).c + ((beyg)localObject2).jdField_a_of_type_Long) {
            ((beyg)localObject2).jdField_a_of_type_Long += 100L;
          }
          ((beyg)localObject2).jdField_a_of_type_Boolean = true;
          ((beyg)localObject2).e = localazqf.jdField_a_of_type_Azqt.jdField_a_of_type_Int;
          ((beyg)localObject2).i = str;
          localObject1 = new beyk();
          if (localazqf.jdField_a_of_type_Int < 0)
          {
            ((beyk)localObject1).jdField_a_of_type_Boolean = false;
            ((beyg)localObject2).jdField_a_of_type_JavaLangObject = localObject1;
            ((beyg)localObject2).jdField_a_of_type_Azrg = new azpl(this, i, str);
            ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a((beyg)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localazqf.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((beyk)localObject1).jdField_a_of_type_Boolean = bool;
          break;
        }
        label551:
        ((azql)localObject2).jdField_a_of_type_Int = -1;
        ((azql)localObject2).jdField_a_of_type_Azqh = new azqh();
        ((azql)localObject2).jdField_a_of_type_Azqh.jdField_b_of_type_JavaLangString = ("Get target pic filepath of [" + i + "] failed");
        if ((localazqf.jdField_a_of_type_Azqd.jdField_b_of_type_Int == 1) || (localazqf.jdField_a_of_type_Azqd.jdField_b_of_type_Int == 3000))
        {
          ((azql)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
          label645:
          if (!QLog.isColorLevel()) {
            break label793;
          }
          if (paramVarArgs != null) {
            break label790;
          }
          paramVarArgs = new StringBuilder();
          label663:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((azql)localObject2).jdField_a_of_type_Azqh.jdField_b_of_type_JavaLangString).append("\n");
        }
      }
    }
    label790:
    label793:
    for (;;)
    {
      azpj.a(this.a);
      if (azpj.a(this.a) == 0) {
        azpi.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((azql)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
      break label645;
      if (paramVarArgs != null) {
        azpw.b(this.a.a.jdField_a_of_type_Azpg.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label663;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpk
 * JD-Core Version:    0.7.0.1
 */