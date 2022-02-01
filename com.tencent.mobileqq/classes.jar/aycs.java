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

class aycs
  extends AsyncTask<Void, Void, Void>
{
  aycs(aycr paramaycr) {}
  
  protected Void a(Void... paramVarArgs)
  {
    ayde.a(this.a.a.jdField_a_of_type_Ayco.b, this.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        aydn localaydn = (aydn)this.a.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = (aydt)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        if (((aydt)localObject2).jdField_a_of_type_Int == -2)
        {
          String str = aycr.a(this.a, localaydn);
          if (str == null) {
            break label551;
          }
          ayde.a(this.a.a.jdField_a_of_type_Ayco.b, this.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new TransferRequest();
          ((TransferRequest)localObject2).needSendMsg = false;
          ((TransferRequest)localObject2).mSelfUin = ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
          ((TransferRequest)localObject2).mPeerUin = this.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((TransferRequest)localObject2).mSecondId = this.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((TransferRequest)localObject2).mUinType = this.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((TransferRequest)localObject2).mFileType = 1;
          ((TransferRequest)localObject2).mUniseq = (this.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (localObject1 = ((TransferRequest)localObject2).mPeerUin + ((TransferRequest)localObject2).mUniseq; ((QQAppInterface)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getTransFileController().processorMap.containsKey(localObject1); localObject1 = ((TransferRequest)localObject2).mPeerUin + ((TransferRequest)localObject2).mUniseq) {
            ((TransferRequest)localObject2).mUniseq += 100L;
          }
          ((TransferRequest)localObject2).mIsUp = true;
          ((TransferRequest)localObject2).mBusiType = localaydn.jdField_a_of_type_Ayeb.jdField_a_of_type_Int;
          ((TransferRequest)localObject2).mLocalPath = str;
          localObject1 = new TransferRequest.PicUpExtraInfo();
          if (localaydn.jdField_a_of_type_Int < 0)
          {
            ((TransferRequest.PicUpExtraInfo)localObject1).mIsRaw = false;
            ((TransferRequest)localObject2).mExtraObj = localObject1;
            ((TransferRequest)localObject2).mUpCallBack = new ayct(this, i, str);
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
        if (localaydn.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((TransferRequest.PicUpExtraInfo)localObject1).mIsRaw = bool;
          break;
        }
        label551:
        ((aydt)localObject2).jdField_a_of_type_Int = -1;
        ((aydt)localObject2).jdField_a_of_type_Aydp = new aydp();
        ((aydt)localObject2).jdField_a_of_type_Aydp.b = ("Get target pic filepath of [" + i + "] failed");
        if ((localaydn.jdField_a_of_type_Aydl.b == 1) || (localaydn.jdField_a_of_type_Aydl.b == 3000))
        {
          ((aydt)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
          label645:
          if (!QLog.isColorLevel()) {
            break label793;
          }
          if (paramVarArgs != null) {
            break label790;
          }
          paramVarArgs = new StringBuilder();
          label663:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((aydt)localObject2).jdField_a_of_type_Aydp.b).append("\n");
        }
      }
    }
    label790:
    label793:
    for (;;)
    {
      aycr.a(this.a);
      if (aycr.a(this.a) == 0) {
        aycq.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((aydt)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
      break label645;
      if (paramVarArgs != null) {
        ayde.b(this.a.a.jdField_a_of_type_Ayco.b, this.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label663;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycs
 * JD-Core Version:    0.7.0.1
 */