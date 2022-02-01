import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.BasePicOprerator.2;
import com.tencent.mobileqq.pic.BasePicOprerator.3;
import com.tencent.mobileqq.pic.BasePicOprerator.4;
import com.tencent.mobileqq.pic.BasePicOprerator.5;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.ReportInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicDownExtraInfo;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class ayco
  implements aycx, aydd, aydi, ayeo
{
  protected static int c;
  protected Handler a;
  public ayds a;
  protected ayel a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public ArrayList<aydt> a;
  protected int b;
  public String b;
  protected ArrayList<aydn> b;
  
  static
  {
    jdField_c_of_type_Int = 20;
  }
  
  public ayco() {}
  
  public ayco(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new aycp(this, Looper.getMainLooper());
    }
  }
  
  private TransferRequest a(aydl paramaydl, String paramString)
  {
    paramaydl.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = false;
    localTransferRequest.mUinType = paramaydl.jdField_b_of_type_Int;
    boolean bool;
    if (paramaydl.jdField_e_of_type_Int == 1)
    {
      bool = true;
      localTransferRequest.mFileType = URLDrawableHelper.getFileSizeType(paramString, bool);
      localTransferRequest.mUniseq = paramaydl.jdField_a_of_type_Long;
      localTransferRequest.mSubMsgId = paramaydl.jdField_g_of_type_Int;
      localTransferRequest.mSelfUin = paramaydl.jdField_b_of_type_JavaLangString;
      localTransferRequest.mPeerUin = paramaydl.jdField_c_of_type_JavaLangString;
      localTransferRequest.mServerPath = paramaydl.jdField_g_of_type_JavaLangString;
      localTransferRequest.mLocalPath = null;
      localTransferRequest.mDownCallBack = this;
      localTransferRequest.useOutputstream = false;
      localTransferRequest.bEnableEnc = paramaydl.jdField_d_of_type_Boolean;
      localTransferRequest.mOutFilePath = paramaydl.c();
      if ((this.jdField_a_of_type_Ayds != null) && (this.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localTransferRequest.mRec = this.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localTransferRequest.mOutFilePath + "info.protocol:" + paramaydl.jdField_e_of_type_JavaLangString);
      paramString = new TransferRequest.PicDownExtraInfo();
      localTransferRequest.mExtraObj = paramString;
      if (localTransferRequest.mFileType != 65537) {
        break label385;
      }
      if (paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_d_of_type_Int = paramaydl.jdField_h_of_type_Int;
        paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Int = aydq.a();
        paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 1;
      }
      if (!bcdo.a()) {
        break label374;
      }
      paramString.mUrlFromMsg = paramaydl.jdField_k_of_type_JavaLangString;
    }
    for (;;)
    {
      localTransferRequest.mMd5 = paramaydl.jdField_f_of_type_JavaLangString;
      localTransferRequest.mGroupFileID = paramaydl.jdField_b_of_type_Long;
      localTransferRequest.mDbRecVersion = paramaydl.jdField_d_of_type_Int;
      localTransferRequest.mBusiType = paramaydl.jdField_a_of_type_Int;
      localTransferRequest.mNeedReport = true;
      localTransferRequest.mDownMode = paramaydl.jdField_h_of_type_Int;
      localTransferRequest.mMsgTime = paramaydl.jdField_c_of_type_Long;
      return localTransferRequest;
      bool = false;
      break;
      label374:
      paramString.mUrlFromMsg = paramaydl.jdField_h_of_type_JavaLangString;
      continue;
      label385:
      if (localTransferRequest.mFileType == 1)
      {
        paramString.mUrlFromMsg = paramaydl.i;
        if (paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramaydl.jdField_h_of_type_Int;
          paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = aydq.a();
          paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
      else if (localTransferRequest.mFileType == 131075)
      {
        paramString.mUrlFromMsg = paramaydl.j;
        if (paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramaydl.jdField_h_of_type_Int;
          paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = aydq.a();
          paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
    }
  }
  
  private void a(ayds paramayds, long paramLong)
  {
    long l;
    Map localMap;
    if (paramayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      l = paramayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) {
        break label108;
      }
      localMap = paramayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramayds);; localInteger1 = Integer.valueOf(paramayds.jdField_c_of_type_Int))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        afoa.a().a(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(aydl paramaydl)
  {
    if (paramaydl != null)
    {
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramaydl);
      return paramaydl.a();
    }
    ayde.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(aydn paramaydn)
  {
    if (paramaydn != null)
    {
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramaydn);
      return paramaydn.a();
    }
    ayde.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b(aycy paramaycy)
  {
    MessageForPic localMessageForPic;
    if ((paramaycy != null) && (this.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramaycy.jdField_b_of_type_JavaLangString != null))
    {
      localMessageForPic = this.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      paramaycy = new File(paramaycy.jdField_b_of_type_JavaLangString);
      if ((localMessageForPic.imageType != 2000) && (GifDrawable.isGifFile(paramaycy)))
      {
        localMessageForPic.imageType = 2000;
        localMessageForPic.serial();
        if (localMessageForPic.subMsgId != MessageForPic.defaultSuMsgId) {
          break label235;
        }
        paramaycy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
        if (!(paramaycy instanceof MessageForStructing)) {
          break label191;
        }
        paramaycy = (MessageForStructing)paramaycy;
        if ((paramaycy.structingMsg instanceof StructMsgForImageShare))
        {
          bcjc localbcjc = ((StructMsgForImageShare)paramaycy.structingMsg).getFirstImageElement();
          if (localbcjc != null)
          {
            ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
            localbcjc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = localMessageForPic;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, paramaycy.structingMsg.getBytes());
          }
        }
      }
    }
    label191:
    label235:
    do
    {
      do
      {
        return;
        ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, localMessageForPic.msgData);
        return;
        paramaycy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
      } while (!(paramaycy instanceof MessageForMixedMsg));
      paramaycy = ((MessageForMixedMsg)paramaycy).upateMessageForPic(localMessageForPic);
    } while (paramaycy == null);
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, paramaycy);
  }
  
  public static void b(MessageForPic paramMessageForPic)
  {
    int i = 1;
    if (paramMessageForPic.md5 == null) {}
    for (;;)
    {
      return;
      if (paramMessageForPic.fileSizeFlag == 1) {
        i = 131075;
      }
      Object localObject = URLDrawableHelper.getURL(paramMessageForPic.md5, i);
      if (localObject != null) {}
      for (localObject = ((URL)localObject).toString(); !AbsDownloader.hasFile((String)localObject); localObject = null)
      {
        localObject = AbsDownloader.getFilePath((String)localObject);
        FileUtils.copyFile(paramMessageForPic.path, (String)localObject);
        return;
      }
    }
  }
  
  private void c(aycy paramaycy)
  {
    ThreadManager.getFileThreadHandler().post(new BasePicOprerator.4(this, paramaycy));
  }
  
  private void e(ayds paramayds)
  {
    int i = 0;
    aydl localaydl = paramayds.jdField_a_of_type_Aydl;
    if (!a(localaydl))
    {
      paramayds = new aycy();
      paramayds.jdField_a_of_type_Int = -1;
      paramayds.jdField_a_of_type_Aydp = localaydl.jdField_a_of_type_Aydp;
      a(paramayds);
    }
    String str;
    label457:
    do
    {
      MessageForPic localMessageForPic;
      int j;
      TransferRequest localTransferRequest;
      long l;
      do
      {
        return;
        localMessageForPic = paramayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        j = paramayds.jdField_d_of_type_Int;
        localTransferRequest = a(localaydl, localaydl.jdField_e_of_type_JavaLangString);
        str = localTransferRequest.mOutFilePath;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
          break;
        }
        paramayds = new aycy();
        paramayds.jdField_a_of_type_Int = 0;
        paramayds.jdField_b_of_type_JavaLangString = localTransferRequest.mOutFilePath;
        paramayds.jdField_c_of_type_JavaLangString = localTransferRequest.mMd5;
        paramayds.jdField_c_of_type_Int = localTransferRequest.mFileType;
        paramayds.jdField_d_of_type_Int = localaydl.jdField_h_of_type_Int;
        paramayds.jdField_a_of_type_Boolean = true;
        a(paramayds);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localTransferRequest.mRequestOffset = 0;
        if (localMessageForPic.mDownloadLength == paramayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
        {
          localTransferRequest.mRequestLength = 0;
          localStringBuilder.append("nofile:");
        }
      }
      for (;;)
      {
        localStringBuilder.append("mRequestOffset is " + localTransferRequest.mRequestOffset + ", mRequestLength is " + localTransferRequest.mRequestLength + ", ");
        localStringBuilder.append("outPath is " + str);
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
        }
        localTransferRequest.mRequestDisplayLength = localMessageForPic.mShowLength;
        localTransferRequest.mDisplayOutFilePath = localaydl.d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().downloadPic(localTransferRequest);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localTransferRequest.mRequestLength = i;
        break;
        if (l >= paramayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
          break label457;
        }
        localTransferRequest.mRequestOffset = localMessageForPic.mDownloadLength;
        localTransferRequest.mRequestLength = 0;
        localStringBuilder.append("part1:");
      }
      paramayds = new aycy();
      paramayds.jdField_a_of_type_Int = 0;
      paramayds.jdField_b_of_type_JavaLangString = localTransferRequest.mOutFilePath;
      paramayds.jdField_c_of_type_JavaLangString = localTransferRequest.mMd5;
      paramayds.jdField_c_of_type_Int = localTransferRequest.mFileType;
      paramayds.jdField_d_of_type_Int = localaydl.jdField_h_of_type_Int;
      paramayds.jdField_a_of_type_Boolean = false;
      a(paramayds);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void f(ayds paramayds)
  {
    ThreadManager.post(new BasePicOprerator.2(this, paramayds.jdField_a_of_type_Aydn, paramayds), 8, null, true);
  }
  
  private void g(ayds paramayds)
  {
    ThreadManager.post(new BasePicOprerator.3(this, paramayds), 8, null, true);
  }
  
  public TransferResult a(aydl paramaydl, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramaydl))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramaydl.jdField_a_of_type_Long);
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
      paramaydl.jdField_e_of_type_JavaLangString = paramString;
      paramaydl = a(paramaydl, paramString);
      paramaydl.mHandler = paramURLDrawableHandler;
      if ((paramaydl.mExtraObj != null) && ((paramaydl.mExtraObj instanceof TransferRequest.PicDownExtraInfo))) {
        ((TransferRequest.PicDownExtraInfo)paramaydl.mExtraObj).mHandler = paramURLDrawableHandler;
      }
      return localTransFileController.downloadPicSync(paramaydl);
    }
    paramURLDrawableHandler = new aycy();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Aydp = paramaydl.jdField_a_of_type_Aydp;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new TransferResult();
    paramURLDrawableHandler.mResult = -1;
    paramURLDrawableHandler.mErrCode = 9302L;
    if (paramaydl.jdField_a_of_type_Aydp != null)
    {
      paramURLDrawableHandler.mErrDesc = ("downloadPicSync," + paramaydl.jdField_a_of_type_Aydp.jdField_b_of_type_JavaLangString);
      return paramURLDrawableHandler;
    }
    paramURLDrawableHandler.mErrDesc = "downloadPicSync param check error";
    return paramURLDrawableHandler;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Int >= this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, String.format("createPicsUploadTask total:%d finished and notifyUI", new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) }));
      }
      a(5, 0, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    if (this.jdField_b_of_type_Int + jdField_c_of_type_Int < this.jdField_b_of_type_JavaUtilArrayList.size()) {}
    for (int i = this.jdField_b_of_type_Int + jdField_c_of_type_Int;; i = this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, String.format("createPicsUploadTask startIdx:%d, finishIdx:%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(i) }));
      }
      List localList = this.jdField_b_of_type_JavaUtilArrayList.subList(this.jdField_b_of_type_Int, i);
      this.jdField_b_of_type_Int = i;
      new aycq(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(int paramInt, aydp paramaydp)
  {
    aydt localaydt = new aydt();
    localaydt.jdField_a_of_type_Ayds = this.jdField_a_of_type_Ayds;
    localaydt.jdField_a_of_type_Aydp = paramaydp;
    localaydt.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localaydt);
    if (paramaydp != null)
    {
      ayde.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramaydp.jdField_a_of_type_JavaLangString, paramaydp.jdField_b_of_type_JavaLangString);
      return;
    }
    ayde.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, aydt paramaydt)
  {
    aydt localaydt = paramaydt;
    if (paramaydt == null) {
      localaydt = new aydt();
    }
    localaydt.jdField_a_of_type_Int = 0;
    localaydt.jdField_a_of_type_Ayds = this.jdField_a_of_type_Ayds;
    a(paramInt, 0, localaydt);
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    aydt localaydt = new aydt();
    localaydt.jdField_a_of_type_Int = 0;
    localaydt.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localaydt.jdField_c_of_type_Boolean = paramBoolean;
    a(1, 0, localaydt);
  }
  
  public void a(aycy paramaycy)
  {
    if (this.jdField_a_of_type_Ayds != null)
    {
      b(paramaycy);
      c(paramaycy);
      if (paramaycy != null) {
        break label50;
      }
      paramaycy = new aydp();
      paramaycy.jdField_b_of_type_JavaLangString = "result == null";
      paramaycy.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramaycy);
    }
    for (;;)
    {
      return;
      label50:
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramaycy.jdField_a_of_type_Int);
      Object localObject = new aydt();
      ((aydt)localObject).jdField_a_of_type_Int = paramaycy.jdField_a_of_type_Int;
      ((aydt)localObject).jdField_a_of_type_JavaLangObject = paramaycy;
      ((aydt)localObject).jdField_a_of_type_Boolean = paramaycy.jdField_a_of_type_Boolean;
      if (paramaycy.jdField_a_of_type_Int == 0) {
        a(0, (aydt)localObject);
      }
      while (this.jdField_a_of_type_Ayds.jdField_a_of_type_Int == 3)
      {
        if (paramaycy.jdField_a_of_type_Int != 0) {
          break label267;
        }
        this.jdField_a_of_type_Ayds.jdField_a_of_type_Aydn.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString = paramaycy.jdField_b_of_type_JavaLangString;
        ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "dowanload pic success,is to forward the pic");
        g(this.jdField_a_of_type_Ayds);
        return;
        if (paramaycy.jdField_a_of_type_Aydp == null)
        {
          localObject = new aydp();
          ((aydp)localObject).jdField_b_of_type_JavaLangString = (paramaycy.jdField_b_of_type_Int + "_" + paramaycy.jdField_a_of_type_JavaLangString);
          ((aydp)localObject).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (aydp)localObject);
        }
        else
        {
          a(0, paramaycy.jdField_a_of_type_Aydp);
        }
      }
    }
    label267:
    a(4, this.jdField_a_of_type_Ayds.jdField_a_of_type_Aydn.jdField_a_of_type_Aydp);
  }
  
  public void a(ayds paramayds)
  {
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramayds.jdField_a_of_type_Ayeb))
    {
      b(paramayds);
      return;
    }
    a(3, paramayds.jdField_a_of_type_Ayeb.jdField_a_of_type_Aydp);
  }
  
  public void a(ayds paramayds, ayeb paramayeb)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    Object localObject = new CompressInfo(paramayeb.jdField_g_of_type_JavaLangString, 0);
    ayeu.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramayeb.jdField_h_of_type_JavaLangString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramayeb.jdField_e_of_type_Int = ((CompressInfo)localObject).jdField_d_of_type_Int;
      paramayeb.jdField_f_of_type_Int = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    if ((paramayeb.jdField_g_of_type_Boolean) && (paramayeb.jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject = (MessageForPic)paramayeb.jdField_b_of_type_JavaLangObject; localObject == null; localObject = a(paramayeb))
    {
      ayde.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject).msgVia);
    }
    afoa.a().a(((MessageRecord)localObject).uniseq, 0L, paramayds.jdField_c_of_type_Int);
    if (MessageForPic.class.isInstance(localObject))
    {
      a(paramayds, (MessageRecord)localObject, paramayeb);
      b((MessageForPic)localObject);
    }
    if ((((MessageRecord)localObject).istroop == 1) && (paramayeb.jdField_a_of_type_Ayed == null)) {
      nmy.a().a((MessageRecord)localObject);
    }
    if (paramayeb.jdField_c_of_type_Boolean) {
      try
      {
        paramayeb.jdField_a_of_type_JavaLangObject = localObject;
        paramayeb.notifyAll();
        ayde.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramayeb.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (paramayeb.jdField_c_of_type_Int == 3)
        {
          ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          ayde.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + paramayeb.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    paramayds = new TransferRequest();
    paramayds.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    paramayds.mPeerUin = ((MessageRecord)localObject).frienduin;
    paramayds.mSecondId = ((MessageRecord)localObject).senderuin;
    paramayds.mUinType = ((MessageRecord)localObject).istroop;
    paramayds.mFileType = 1;
    paramayds.mUniseq = ((MessageRecord)localObject).uniseq;
    paramayds.mIsUp = true;
    paramayds.mBusiType = paramayeb.jdField_a_of_type_Int;
    paramayds.mLocalPath = paramayeb.jdField_g_of_type_JavaLangString;
    paramayds.mMd5 = paramayeb.jdField_f_of_type_JavaLangString;
    TransferRequest.PicUpExtraInfo localPicUpExtraInfo = new TransferRequest.PicUpExtraInfo();
    if (paramayeb.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localPicUpExtraInfo.mIsRaw = bool;
      paramayds.mExtraObj = localPicUpExtraInfo;
      paramayds.mUpCallBack = this;
      paramayds.mRec = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      paramayds.mIsPresend = paramayeb.jdField_c_of_type_Boolean;
      paramayds.myPresendInvalid = paramayeb.jdField_e_of_type_Boolean;
      if (paramayeb.jdField_a_of_type_Ayea != null) {
        paramayds.mPicSendSource = paramayeb.jdField_a_of_type_Ayea.jdField_a_of_type_Int;
      }
      if (!paramayeb.jdField_c_of_type_Boolean) {
        break label840;
      }
      try
      {
        if (!paramayeb.jdField_d_of_type_Boolean) {
          break;
        }
        ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        ayde.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramayeb.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
      finally {}
    }
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(paramayds);
    ayde.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramayeb.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((paramayeb.jdField_b_of_type_Boolean) && (!paramayeb.jdField_c_of_type_Boolean))
      {
        ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        a((MessageRecord)localObject, paramayeb.jdField_g_of_type_Long);
      }
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label840:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(paramayds);
    }
  }
  
  protected void a(ayds paramayds, MessageRecord paramMessageRecord, ayeb paramayeb)
  {
    PicMessageExtraData localPicMessageExtraData;
    if (paramayds.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramayds.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      localPicMessageExtraData = paramayds.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if (localPicMessageExtraData.stickerInfo != null) {
        paramMessageRecord.saveExtInfoToExtStr("sticker_info", localPicMessageExtraData.stickerInfo.toJsonString());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sticker_info")))
      {
        EmojiStickerManager.a(paramMessageRecord, null);
        EmojiStickerManager.a().a(paramMessageRecord);
      }
    }
    if (((MessageForPic)paramMessageRecord).checkGif())
    {
      localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
      if (localPicMessageExtraData != null) {
        break label367;
      }
      localPicMessageExtraData = new PicMessageExtraData();
    }
    label364:
    label367:
    for (;;)
    {
      if (TextUtils.isEmpty(localPicMessageExtraData.textSummary)) {
        localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131691165);
      }
      localPicMessageExtraData.emojiPkgId = String.valueOf(paramayeb.s);
      localPicMessageExtraData.from = paramayeb.r;
      localPicMessageExtraData.source = paramayeb.jdField_k_of_type_JavaLangString;
      localPicMessageExtraData.webUrl = paramayeb.jdField_l_of_type_JavaLangString;
      localPicMessageExtraData.iconUrl = paramayeb.m;
      localPicMessageExtraData.packageName = paramayeb.n;
      if ((localPicMessageExtraData.imageBizType <= 0) && ((paramayds.jdField_b_of_type_Int == 1050) || (paramayds.jdField_b_of_type_Int == 1051) || (paramayds.jdField_b_of_type_Int == 1052))) {
        localPicMessageExtraData.imageBizType = 11;
      }
      ((MessageForPic)paramMessageRecord).picExtraData = localPicMessageExtraData;
      if ((paramayeb.jdField_a_of_type_Ayea != null) && (!TextUtils.isEmpty(paramayeb.jdField_a_of_type_Ayea.jdField_a_of_type_JavaLangString)))
      {
        localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        if (localPicMessageExtraData != null) {
          break label364;
        }
        localPicMessageExtraData = new PicMessageExtraData();
      }
      for (;;)
      {
        localPicMessageExtraData.mTemplateId = paramayeb.jdField_a_of_type_Ayea.jdField_a_of_type_JavaLangString;
        localPicMessageExtraData.mTemplateName = paramayeb.jdField_a_of_type_Ayea.jdField_b_of_type_JavaLangString;
        ((MessageForPic)paramMessageRecord).picExtraData = localPicMessageExtraData;
        if (paramayds.jdField_b_of_type_Int == 1053)
        {
          paramayeb = ((MessageForPic)paramMessageRecord).picExtraData;
          paramayds = paramayeb;
          if (paramayeb == null) {
            paramayds = new PicMessageExtraData();
          }
          paramayds.imageBizType = 14;
          ((MessageForPic)paramMessageRecord).picExtraData = paramayds;
        }
        return;
      }
    }
  }
  
  public void a(ayel paramayel)
  {
    this.jdField_a_of_type_Ayel = paramayel;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ((bahm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    bahm localbahm = (bahm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localbahm.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localbahm.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(ArrayList<aydn> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((aydn)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((aydn)paramArrayList.get(0));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    a();
  }
  
  protected boolean a(ayeb paramayeb)
  {
    if (paramayeb != null)
    {
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramayeb);
      return paramayeb.a();
    }
    ayde.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  protected void b(ayds paramayds)
  {
    ayeb localayeb = paramayds.jdField_a_of_type_Ayeb;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new BasePicOprerator.5(this, paramayds, localayeb), 8, null, false);
      return;
    }
    a(paramayds, localayeb);
  }
  
  public void c(ayds paramayds)
  {
    aydn localaydn = paramayds.jdField_a_of_type_Aydn;
    if (!a(localaydn))
    {
      a(4, localaydn.jdField_a_of_type_Aydp);
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(localaydn.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString))
    {
      localaydn.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localaydn);
      g(paramayds);
      return;
    }
    if (localaydn.jdField_a_of_type_Ayeb.b())
    {
      File localFile = localaydn.jdField_a_of_type_Ayeb.a();
      if (localFile != null) {
        localaydn.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString = localFile.toString();
      }
      localaydn.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localaydn);
      g(paramayds);
      return;
    }
    localaydn.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localaydn);
    if ((localaydn.jdField_a_of_type_Ayeb.jdField_f_of_type_JavaLangString == null) || (localaydn.jdField_a_of_type_Ayeb.jdField_c_of_type_Long == 0L) || (localaydn.jdField_a_of_type_Ayeb.j == 0) || (localaydn.jdField_a_of_type_Ayeb.jdField_k_of_type_Int == 0))
    {
      localaydn.jdField_a_of_type_Aydl.jdField_a_of_type_Int = 3;
      localaydn.jdField_a_of_type_Aydl.jdField_e_of_type_JavaLangString = "chatimg";
      if (localaydn.jdField_a_of_type_Ayeb.jdField_l_of_type_Int == 1) {}
      for (int i = 7;; i = 6)
      {
        paramayds = aydj.a(i, 3);
        paramayds.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localaydn.jdField_a_of_type_Aydl);
        d(paramayds);
        return;
      }
    }
    f(paramayds);
  }
  
  public void d(ayds paramayds)
  {
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    aydl localaydl = paramayds.jdField_a_of_type_Aydl;
    if (a(localaydl))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localaydl.jdField_a_of_type_Long);
      if (!localaydl.jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramayds = a(localaydl, localaydl.jdField_e_of_type_JavaLangString);
        if (!new File(paramayds.mOutFilePath).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().downloadPic(paramayds);
          return;
        }
        aycy localaycy = new aycy();
        localaycy.jdField_a_of_type_Int = 0;
        localaycy.jdField_b_of_type_JavaLangString = paramayds.mOutFilePath;
        localaycy.jdField_c_of_type_JavaLangString = paramayds.mMd5;
        localaycy.jdField_c_of_type_Int = paramayds.mFileType;
        localaycy.jdField_d_of_type_Int = localaydl.jdField_h_of_type_Int;
        a(localaycy);
        return;
      }
      e(paramayds);
      return;
    }
    paramayds = new aycy();
    paramayds.jdField_a_of_type_Int = -1;
    paramayds.jdField_a_of_type_Aydp = localaydl.jdField_a_of_type_Aydp;
    a(paramayds);
  }
  
  public void onSend(ayep paramayep)
  {
    if (paramayep == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Ayds == null);
      if ((this.jdField_a_of_type_Ayds.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Ayds.jdField_a_of_type_Int == 4))
      {
        if (paramayep.jdField_a_of_type_Int == 0)
        {
          updateMsg(paramayep);
          localObject = (aydy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
          if (localObject != null) {
            ((aydy)localObject).a(13057, paramayep.jdField_a_of_type_Long);
          }
          localObject = new aydt();
          ((aydt)localObject).jdField_a_of_type_Int = 0;
          ((aydt)localObject).jdField_a_of_type_JavaLangObject = paramayep;
          a(3, (aydt)localObject);
          return;
        }
        localObject = new aydp();
        ((aydp)localObject).jdField_b_of_type_JavaLangString = paramayep.jdField_a_of_type_JavaLangString;
        a(3, (aydp)localObject);
        return;
      }
    } while (this.jdField_a_of_type_Ayds.jdField_a_of_type_Int != 3);
    if (paramayep.jdField_a_of_type_Int == 0)
    {
      updateMsg(paramayep);
      localObject = (aydy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
      if (localObject != null) {
        ((aydy)localObject).a(13058, paramayep.jdField_a_of_type_Long);
      }
      localObject = new aydt();
      ((aydt)localObject).jdField_a_of_type_Int = 0;
      ((aydt)localObject).jdField_a_of_type_JavaLangObject = paramayep;
      a(4, (aydt)localObject);
      return;
    }
    if (paramayep.jdField_b_of_type_Int == 9333)
    {
      this.jdField_a_of_type_Ayds.jdField_a_of_type_Aydn.jdField_a_of_type_Aydl.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Ayds.jdField_a_of_type_Aydn.jdField_a_of_type_Aydl.jdField_e_of_type_JavaLangString = "chatimg";
      if (this.jdField_a_of_type_Ayds.jdField_a_of_type_Aydn.jdField_a_of_type_Ayeb.jdField_l_of_type_Int == 1) {}
      for (int i = 7;; i = 6)
      {
        ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramayep = aydj.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_Ayds.jdField_a_of_type_Aydn);
        paramayep.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Ayds.jdField_a_of_type_Aydn.jdField_a_of_type_Aydl);
        d(paramayep);
        return;
      }
    }
    Object localObject = new aydp();
    ((aydp)localObject).jdField_b_of_type_JavaLangString = paramayep.jdField_a_of_type_JavaLangString;
    ((aydp)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramayep.jdField_b_of_type_Int);
    a(4, (aydp)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayco
 * JD-Core Version:    0.7.0.1
 */