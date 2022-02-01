import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class azje
  extends AsyncTask<Void, Void, Void>
{
  azje(azjd paramazjd) {}
  
  protected Void a(Void... paramVarArgs)
  {
    azjq.a(this.a.a.jdField_a_of_type_Azja.b, this.a.a.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        azjz localazjz = (azjz)this.a.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = (azkf)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        if (((azkf)localObject2).jdField_a_of_type_Int == -2)
        {
          String str = azjd.a(this.a, localazjz);
          if (str == null) {
            break label551;
          }
          azjq.a(this.a.a.jdField_a_of_type_Azja.b, this.a.a.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new TransferRequest();
          ((TransferRequest)localObject2).needSendMsg = false;
          ((TransferRequest)localObject2).mSelfUin = ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((TransferRequest)localObject2).mPeerUin = this.a.a.jdField_a_of_type_Azja.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((TransferRequest)localObject2).mSecondId = this.a.a.jdField_a_of_type_Azja.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((TransferRequest)localObject2).mUinType = this.a.a.jdField_a_of_type_Azja.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((TransferRequest)localObject2).mFileType = 1;
          ((TransferRequest)localObject2).mUniseq = (this.a.a.jdField_a_of_type_Azja.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (localObject1 = ((TransferRequest)localObject2).mPeerUin + ((TransferRequest)localObject2).mUniseq; ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getTransFileController().processorMap.containsKey(localObject1); localObject1 = ((TransferRequest)localObject2).mPeerUin + ((TransferRequest)localObject2).mUniseq) {
            ((TransferRequest)localObject2).mUniseq += 100L;
          }
          ((TransferRequest)localObject2).mIsUp = true;
          ((TransferRequest)localObject2).mBusiType = localazjz.jdField_a_of_type_Azkn.jdField_a_of_type_Int;
          ((TransferRequest)localObject2).mLocalPath = str;
          localObject1 = new TransferRequest.PicUpExtraInfo();
          if (localazjz.jdField_a_of_type_Int < 0)
          {
            ((TransferRequest.PicUpExtraInfo)localObject1).mIsRaw = false;
            ((TransferRequest)localObject2).mExtraObj = localObject1;
            ((TransferRequest)localObject2).mUpCallBack = new azjf(this, i, str);
            ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getTransFileController().transferAsync((TransferRequest)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localazjz.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((TransferRequest.PicUpExtraInfo)localObject1).mIsRaw = bool;
          break;
        }
        label551:
        ((azkf)localObject2).jdField_a_of_type_Int = -1;
        ((azkf)localObject2).jdField_a_of_type_Azkb = new azkb();
        ((azkf)localObject2).jdField_a_of_type_Azkb.b = ("Get target pic filepath of [" + i + "] failed");
        if ((localazjz.jdField_a_of_type_Azjx.b == 1) || (localazjz.jdField_a_of_type_Azjx.b == 3000))
        {
          ((azkf)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
          label645:
          if (!QLog.isColorLevel()) {
            break label793;
          }
          if (paramVarArgs != null) {
            break label790;
          }
          paramVarArgs = new StringBuilder();
          label663:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((azkf)localObject2).jdField_a_of_type_Azkb.b).append("\n");
        }
      }
    }
    label790:
    label793:
    for (;;)
    {
      azjd.a(this.a);
      if (azjd.a(this.a) == 0) {
        azjc.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((azkf)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
      break label645;
      if (paramVarArgs != null) {
        azjq.b(this.a.a.jdField_a_of_type_Azja.b, this.a.a.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label663;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azje
 * JD-Core Version:    0.7.0.1
 */