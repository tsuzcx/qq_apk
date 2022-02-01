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
import com.tencent.mobileqq.app.QQManagerFactory;
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

public abstract class azja
  implements azjj, azjp, azju, azla
{
  protected static int c;
  protected Handler a;
  public azke a;
  protected azkx a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public ArrayList<azkf> a;
  protected int b;
  public String b;
  protected ArrayList<azjz> b;
  
  static
  {
    jdField_c_of_type_Int = 20;
  }
  
  public azja() {}
  
  public azja(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new azjb(this, Looper.getMainLooper());
    }
  }
  
  private TransferRequest a(azjx paramazjx, String paramString)
  {
    paramazjx.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = false;
    localTransferRequest.mUinType = paramazjx.jdField_b_of_type_Int;
    boolean bool;
    if (paramazjx.jdField_e_of_type_Int == 1)
    {
      bool = true;
      localTransferRequest.mFileType = URLDrawableHelper.getFileSizeType(paramString, bool);
      localTransferRequest.mUniseq = paramazjx.jdField_a_of_type_Long;
      localTransferRequest.mSubMsgId = paramazjx.jdField_g_of_type_Int;
      localTransferRequest.mSelfUin = paramazjx.jdField_b_of_type_JavaLangString;
      localTransferRequest.mPeerUin = paramazjx.jdField_c_of_type_JavaLangString;
      localTransferRequest.mServerPath = paramazjx.jdField_g_of_type_JavaLangString;
      localTransferRequest.mLocalPath = null;
      localTransferRequest.mDownCallBack = this;
      localTransferRequest.useOutputstream = false;
      localTransferRequest.bEnableEnc = paramazjx.jdField_d_of_type_Boolean;
      localTransferRequest.mOutFilePath = paramazjx.c();
      if ((this.jdField_a_of_type_Azke != null) && (this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localTransferRequest.mRec = this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localTransferRequest.mOutFilePath + "info.protocol:" + paramazjx.jdField_e_of_type_JavaLangString);
      paramString = new TransferRequest.PicDownExtraInfo();
      localTransferRequest.mExtraObj = paramString;
      if (localTransferRequest.mFileType != 65537) {
        break label385;
      }
      if (paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_d_of_type_Int = paramazjx.jdField_h_of_type_Int;
        paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Int = azkc.a();
        paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 1;
      }
      if (!bdkj.a()) {
        break label374;
      }
      paramString.mUrlFromMsg = paramazjx.jdField_k_of_type_JavaLangString;
    }
    for (;;)
    {
      localTransferRequest.mMd5 = paramazjx.jdField_f_of_type_JavaLangString;
      localTransferRequest.mGroupFileID = paramazjx.jdField_b_of_type_Long;
      localTransferRequest.mDbRecVersion = paramazjx.jdField_d_of_type_Int;
      localTransferRequest.mBusiType = paramazjx.jdField_a_of_type_Int;
      localTransferRequest.mNeedReport = true;
      localTransferRequest.mDownMode = paramazjx.jdField_h_of_type_Int;
      localTransferRequest.mMsgTime = paramazjx.jdField_c_of_type_Long;
      return localTransferRequest;
      bool = false;
      break;
      label374:
      paramString.mUrlFromMsg = paramazjx.jdField_h_of_type_JavaLangString;
      continue;
      label385:
      if (localTransferRequest.mFileType == 1)
      {
        paramString.mUrlFromMsg = paramazjx.i;
        if (paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramazjx.jdField_h_of_type_Int;
          paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = azkc.a();
          paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
      else if (localTransferRequest.mFileType == 131075)
      {
        paramString.mUrlFromMsg = paramazjx.j;
        if (paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramazjx.jdField_h_of_type_Int;
          paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = azkc.a();
          paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramazjx.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
    }
  }
  
  private void a(azke paramazke, long paramLong)
  {
    long l;
    Map localMap;
    if (paramazke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      l = paramazke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramazke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) {
        break label108;
      }
      localMap = paramazke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramazke);; localInteger1 = Integer.valueOf(paramazke.jdField_c_of_type_Int))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        agfe.a().a(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(azjx paramazjx)
  {
    if (paramazjx != null)
    {
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramazjx);
      return paramazjx.a();
    }
    azjq.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(azjz paramazjz)
  {
    if (paramazjz != null)
    {
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramazjz);
      return paramazjz.a();
    }
    azjq.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b(azjk paramazjk)
  {
    MessageForPic localMessageForPic;
    if ((paramazjk != null) && (this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramazjk.jdField_b_of_type_JavaLangString != null))
    {
      localMessageForPic = this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      paramazjk = new File(paramazjk.jdField_b_of_type_JavaLangString);
      if ((localMessageForPic.imageType != 2000) && (GifDrawable.isGifFile(paramazjk)))
      {
        localMessageForPic.imageType = 2000;
        localMessageForPic.serial();
        if (localMessageForPic.subMsgId != MessageForPic.defaultSuMsgId) {
          break label235;
        }
        paramazjk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
        if (!(paramazjk instanceof MessageForStructing)) {
          break label191;
        }
        paramazjk = (MessageForStructing)paramazjk;
        if ((paramazjk.structingMsg instanceof StructMsgForImageShare))
        {
          bdqa localbdqa = ((StructMsgForImageShare)paramazjk.structingMsg).getFirstImageElement();
          if (localbdqa != null)
          {
            azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
            localbdqa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = localMessageForPic;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, paramazjk.structingMsg.getBytes());
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
        azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, localMessageForPic.msgData);
        return;
        paramazjk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
      } while (!(paramazjk instanceof MessageForMixedMsg));
      paramazjk = ((MessageForMixedMsg)paramazjk).upateMessageForPic(localMessageForPic);
    } while (paramazjk == null);
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, paramazjk);
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
  
  private void c(azjk paramazjk)
  {
    ThreadManager.getFileThreadHandler().post(new BasePicOprerator.4(this, paramazjk));
  }
  
  private void e(azke paramazke)
  {
    int i = 0;
    azjx localazjx = paramazke.jdField_a_of_type_Azjx;
    if (!a(localazjx))
    {
      paramazke = new azjk();
      paramazke.jdField_a_of_type_Int = -1;
      paramazke.jdField_a_of_type_Azkb = localazjx.jdField_a_of_type_Azkb;
      a(paramazke);
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
        localMessageForPic = paramazke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        j = paramazke.jdField_d_of_type_Int;
        localTransferRequest = a(localazjx, localazjx.jdField_e_of_type_JavaLangString);
        str = localTransferRequest.mOutFilePath;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramazke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
          break;
        }
        paramazke = new azjk();
        paramazke.jdField_a_of_type_Int = 0;
        paramazke.jdField_b_of_type_JavaLangString = localTransferRequest.mOutFilePath;
        paramazke.jdField_c_of_type_JavaLangString = localTransferRequest.mMd5;
        paramazke.jdField_c_of_type_Int = localTransferRequest.mFileType;
        paramazke.jdField_d_of_type_Int = localazjx.jdField_h_of_type_Int;
        paramazke.jdField_a_of_type_Boolean = true;
        a(paramazke);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localTransferRequest.mRequestOffset = 0;
        if (localMessageForPic.mDownloadLength == paramazke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
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
        localTransferRequest.mDisplayOutFilePath = localazjx.d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().downloadPic(localTransferRequest);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localTransferRequest.mRequestLength = i;
        break;
        if (l >= paramazke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
          break label457;
        }
        localTransferRequest.mRequestOffset = localMessageForPic.mDownloadLength;
        localTransferRequest.mRequestLength = 0;
        localStringBuilder.append("part1:");
      }
      paramazke = new azjk();
      paramazke.jdField_a_of_type_Int = 0;
      paramazke.jdField_b_of_type_JavaLangString = localTransferRequest.mOutFilePath;
      paramazke.jdField_c_of_type_JavaLangString = localTransferRequest.mMd5;
      paramazke.jdField_c_of_type_Int = localTransferRequest.mFileType;
      paramazke.jdField_d_of_type_Int = localazjx.jdField_h_of_type_Int;
      paramazke.jdField_a_of_type_Boolean = false;
      a(paramazke);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void f(azke paramazke)
  {
    ThreadManager.post(new BasePicOprerator.2(this, paramazke.jdField_a_of_type_Azjz, paramazke), 8, null, true);
  }
  
  private void g(azke paramazke)
  {
    ThreadManager.post(new BasePicOprerator.3(this, paramazke), 8, null, true);
  }
  
  public TransferResult a(azjx paramazjx, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramazjx))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramazjx.jdField_a_of_type_Long);
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
      paramazjx.jdField_e_of_type_JavaLangString = paramString;
      paramazjx = a(paramazjx, paramString);
      paramazjx.mHandler = paramURLDrawableHandler;
      if ((paramazjx.mExtraObj != null) && ((paramazjx.mExtraObj instanceof TransferRequest.PicDownExtraInfo))) {
        ((TransferRequest.PicDownExtraInfo)paramazjx.mExtraObj).mHandler = paramURLDrawableHandler;
      }
      return localTransFileController.downloadPicSync(paramazjx);
    }
    paramURLDrawableHandler = new azjk();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Azkb = paramazjx.jdField_a_of_type_Azkb;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new TransferResult();
    paramURLDrawableHandler.mResult = -1;
    paramURLDrawableHandler.mErrCode = 9302L;
    if (paramazjx.jdField_a_of_type_Azkb != null)
    {
      paramURLDrawableHandler.mErrDesc = ("downloadPicSync," + paramazjx.jdField_a_of_type_Azkb.jdField_b_of_type_JavaLangString);
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
      new azjc(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
  
  public void a(int paramInt, azkb paramazkb)
  {
    azkf localazkf = new azkf();
    localazkf.jdField_a_of_type_Azke = this.jdField_a_of_type_Azke;
    localazkf.jdField_a_of_type_Azkb = paramazkb;
    localazkf.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localazkf);
    if (paramazkb != null)
    {
      azjq.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramazkb.jdField_a_of_type_JavaLangString, paramazkb.jdField_b_of_type_JavaLangString);
      return;
    }
    azjq.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, azkf paramazkf)
  {
    azkf localazkf = paramazkf;
    if (paramazkf == null) {
      localazkf = new azkf();
    }
    localazkf.jdField_a_of_type_Int = 0;
    localazkf.jdField_a_of_type_Azke = this.jdField_a_of_type_Azke;
    a(paramInt, 0, localazkf);
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    azkf localazkf = new azkf();
    localazkf.jdField_a_of_type_Int = 0;
    localazkf.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localazkf.jdField_c_of_type_Boolean = paramBoolean;
    a(1, 0, localazkf);
  }
  
  public void a(azjk paramazjk)
  {
    if (this.jdField_a_of_type_Azke != null)
    {
      b(paramazjk);
      c(paramazjk);
      if (paramazjk != null) {
        break label50;
      }
      paramazjk = new azkb();
      paramazjk.jdField_b_of_type_JavaLangString = "result == null";
      paramazjk.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramazjk);
    }
    for (;;)
    {
      return;
      label50:
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramazjk.jdField_a_of_type_Int);
      Object localObject = new azkf();
      ((azkf)localObject).jdField_a_of_type_Int = paramazjk.jdField_a_of_type_Int;
      ((azkf)localObject).jdField_a_of_type_JavaLangObject = paramazjk;
      ((azkf)localObject).jdField_a_of_type_Boolean = paramazjk.jdField_a_of_type_Boolean;
      if (paramazjk.jdField_a_of_type_Int == 0) {
        a(0, (azkf)localObject);
      }
      while (this.jdField_a_of_type_Azke.jdField_a_of_type_Int == 3)
      {
        if (paramazjk.jdField_a_of_type_Int != 0) {
          break label267;
        }
        this.jdField_a_of_type_Azke.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString = paramazjk.jdField_b_of_type_JavaLangString;
        azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "dowanload pic success,is to forward the pic");
        g(this.jdField_a_of_type_Azke);
        return;
        if (paramazjk.jdField_a_of_type_Azkb == null)
        {
          localObject = new azkb();
          ((azkb)localObject).jdField_b_of_type_JavaLangString = (paramazjk.jdField_b_of_type_Int + "_" + paramazjk.jdField_a_of_type_JavaLangString);
          ((azkb)localObject).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (azkb)localObject);
        }
        else
        {
          a(0, paramazjk.jdField_a_of_type_Azkb);
        }
      }
    }
    label267:
    a(4, this.jdField_a_of_type_Azke.jdField_a_of_type_Azjz.jdField_a_of_type_Azkb);
  }
  
  public void a(azke paramazke)
  {
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramazke.jdField_a_of_type_Azkn))
    {
      b(paramazke);
      return;
    }
    a(3, paramazke.jdField_a_of_type_Azkn.jdField_a_of_type_Azkb);
  }
  
  public void a(azke paramazke, azkn paramazkn)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    Object localObject = new CompressInfo(paramazkn.jdField_g_of_type_JavaLangString, 0);
    azlg.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramazkn.jdField_h_of_type_JavaLangString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramazkn.jdField_e_of_type_Int = ((CompressInfo)localObject).jdField_d_of_type_Int;
      paramazkn.jdField_f_of_type_Int = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    if ((paramazkn.jdField_g_of_type_Boolean) && (paramazkn.jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject = (MessageForPic)paramazkn.jdField_b_of_type_JavaLangObject; localObject == null; localObject = a(paramazkn))
    {
      azjq.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject).msgVia);
    }
    agfe.a().a(((MessageRecord)localObject).uniseq, 0L, paramazke.jdField_c_of_type_Int);
    if (MessageForPic.class.isInstance(localObject))
    {
      a(paramazke, (MessageRecord)localObject, paramazkn);
      b((MessageForPic)localObject);
    }
    if ((((MessageRecord)localObject).istroop == 1) && (paramazkn.jdField_a_of_type_Azkp == null)) {
      nty.a().a((MessageRecord)localObject);
    }
    if (paramazkn.jdField_c_of_type_Boolean) {
      try
      {
        paramazkn.jdField_a_of_type_JavaLangObject = localObject;
        paramazkn.notifyAll();
        azjq.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramazkn.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (paramazkn.jdField_c_of_type_Int == 3)
        {
          azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          azjq.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + paramazkn.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    paramazke = new TransferRequest();
    paramazke.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    paramazke.mPeerUin = ((MessageRecord)localObject).frienduin;
    paramazke.mSecondId = ((MessageRecord)localObject).senderuin;
    paramazke.mUinType = ((MessageRecord)localObject).istroop;
    paramazke.mFileType = 1;
    paramazke.mUniseq = ((MessageRecord)localObject).uniseq;
    paramazke.mIsUp = true;
    paramazke.mBusiType = paramazkn.jdField_a_of_type_Int;
    paramazke.mLocalPath = paramazkn.jdField_g_of_type_JavaLangString;
    paramazke.mMd5 = paramazkn.jdField_f_of_type_JavaLangString;
    TransferRequest.PicUpExtraInfo localPicUpExtraInfo = new TransferRequest.PicUpExtraInfo();
    if (paramazkn.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localPicUpExtraInfo.mIsRaw = bool;
      paramazke.mExtraObj = localPicUpExtraInfo;
      paramazke.mUpCallBack = this;
      paramazke.mRec = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      paramazke.mIsPresend = paramazkn.jdField_c_of_type_Boolean;
      paramazke.myPresendInvalid = paramazkn.jdField_e_of_type_Boolean;
      if (paramazkn.jdField_a_of_type_Azkm != null) {
        paramazke.mPicSendSource = paramazkn.jdField_a_of_type_Azkm.jdField_a_of_type_Int;
      }
      if (!paramazkn.jdField_c_of_type_Boolean) {
        break label840;
      }
      try
      {
        if (!paramazkn.jdField_d_of_type_Boolean) {
          break;
        }
        azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        azjq.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramazkn.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
      finally {}
    }
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(paramazke);
    azjq.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramazkn.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((paramazkn.jdField_b_of_type_Boolean) && (!paramazkn.jdField_c_of_type_Boolean))
      {
        azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        a((MessageRecord)localObject, paramazkn.jdField_g_of_type_Long);
      }
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label840:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(paramazke);
    }
  }
  
  protected void a(azke paramazke, MessageRecord paramMessageRecord, azkn paramazkn)
  {
    PicMessageExtraData localPicMessageExtraData;
    if (paramazke.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramazke.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      localPicMessageExtraData = paramazke.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
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
        localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131691250);
      }
      localPicMessageExtraData.emojiPkgId = String.valueOf(paramazkn.s);
      localPicMessageExtraData.from = paramazkn.r;
      localPicMessageExtraData.source = paramazkn.jdField_k_of_type_JavaLangString;
      localPicMessageExtraData.webUrl = paramazkn.jdField_l_of_type_JavaLangString;
      localPicMessageExtraData.iconUrl = paramazkn.m;
      localPicMessageExtraData.packageName = paramazkn.n;
      if ((localPicMessageExtraData.imageBizType <= 0) && ((paramazke.jdField_b_of_type_Int == 1050) || (paramazke.jdField_b_of_type_Int == 1051) || (paramazke.jdField_b_of_type_Int == 1052))) {
        localPicMessageExtraData.imageBizType = 11;
      }
      ((MessageForPic)paramMessageRecord).picExtraData = localPicMessageExtraData;
      if ((paramazkn.jdField_a_of_type_Azkm != null) && (!TextUtils.isEmpty(paramazkn.jdField_a_of_type_Azkm.jdField_a_of_type_JavaLangString)))
      {
        localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        if (localPicMessageExtraData != null) {
          break label364;
        }
        localPicMessageExtraData = new PicMessageExtraData();
      }
      for (;;)
      {
        localPicMessageExtraData.mTemplateId = paramazkn.jdField_a_of_type_Azkm.jdField_a_of_type_JavaLangString;
        localPicMessageExtraData.mTemplateName = paramazkn.jdField_a_of_type_Azkm.jdField_b_of_type_JavaLangString;
        ((MessageForPic)paramMessageRecord).picExtraData = localPicMessageExtraData;
        if (paramazke.jdField_b_of_type_Int == 1053)
        {
          paramazkn = ((MessageForPic)paramMessageRecord).picExtraData;
          paramazke = paramazkn;
          if (paramazkn == null) {
            paramazke = new PicMessageExtraData();
          }
          paramazke.imageBizType = 14;
          ((MessageForPic)paramMessageRecord).picExtraData = paramazke;
        }
        return;
      }
    }
  }
  
  public void a(azkx paramazkx)
  {
    this.jdField_a_of_type_Azkx = paramazkx;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ((bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    bbob localbbob = (bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER);
    localbbob.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localbbob.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(ArrayList<azjz> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((azjz)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((azjz)paramArrayList.get(0));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    a();
  }
  
  protected boolean a(azkn paramazkn)
  {
    if (paramazkn != null)
    {
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramazkn);
      return paramazkn.a();
    }
    azjq.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  protected void b(azke paramazke)
  {
    azkn localazkn = paramazke.jdField_a_of_type_Azkn;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new BasePicOprerator.5(this, paramazke, localazkn), 8, null, false);
      return;
    }
    a(paramazke, localazkn);
  }
  
  public void c(azke paramazke)
  {
    azjz localazjz = paramazke.jdField_a_of_type_Azjz;
    if (!a(localazjz))
    {
      a(4, localazjz.jdField_a_of_type_Azkb);
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(localazjz.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString))
    {
      localazjz.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localazjz);
      g(paramazke);
      return;
    }
    if (localazjz.jdField_a_of_type_Azkn.b())
    {
      File localFile = localazjz.jdField_a_of_type_Azkn.a();
      if (localFile != null) {
        localazjz.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString = localFile.toString();
      }
      localazjz.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localazjz);
      g(paramazke);
      return;
    }
    localazjz.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localazjz);
    if ((localazjz.jdField_a_of_type_Azkn.jdField_f_of_type_JavaLangString == null) || (localazjz.jdField_a_of_type_Azkn.jdField_c_of_type_Long == 0L) || (localazjz.jdField_a_of_type_Azkn.j == 0) || (localazjz.jdField_a_of_type_Azkn.jdField_k_of_type_Int == 0))
    {
      localazjz.jdField_a_of_type_Azjx.jdField_a_of_type_Int = 3;
      localazjz.jdField_a_of_type_Azjx.jdField_e_of_type_JavaLangString = "chatimg";
      if (localazjz.jdField_a_of_type_Azkn.jdField_l_of_type_Int == 1) {}
      for (int i = 7;; i = 6)
      {
        paramazke = azjv.a(i, 3);
        paramazke.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localazjz.jdField_a_of_type_Azjx);
        d(paramazke);
        return;
      }
    }
    f(paramazke);
  }
  
  public void d(azke paramazke)
  {
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    azjx localazjx = paramazke.jdField_a_of_type_Azjx;
    if (a(localazjx))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localazjx.jdField_a_of_type_Long);
      if (!localazjx.jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramazke = a(localazjx, localazjx.jdField_e_of_type_JavaLangString);
        if (!new File(paramazke.mOutFilePath).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().downloadPic(paramazke);
          return;
        }
        azjk localazjk = new azjk();
        localazjk.jdField_a_of_type_Int = 0;
        localazjk.jdField_b_of_type_JavaLangString = paramazke.mOutFilePath;
        localazjk.jdField_c_of_type_JavaLangString = paramazke.mMd5;
        localazjk.jdField_c_of_type_Int = paramazke.mFileType;
        localazjk.jdField_d_of_type_Int = localazjx.jdField_h_of_type_Int;
        a(localazjk);
        return;
      }
      e(paramazke);
      return;
    }
    paramazke = new azjk();
    paramazke.jdField_a_of_type_Int = -1;
    paramazke.jdField_a_of_type_Azkb = localazjx.jdField_a_of_type_Azkb;
    a(paramazke);
  }
  
  public void onSend(azlb paramazlb)
  {
    if (paramazlb == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Azke == null);
      if ((this.jdField_a_of_type_Azke.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Azke.jdField_a_of_type_Int == 4))
      {
        if (paramazlb.jdField_a_of_type_Int == 0)
        {
          updateMsg(paramazlb);
          localObject = (azkk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PICTURE_STATISTICS_MANAGER);
          if (localObject != null) {
            ((azkk)localObject).a(13057, paramazlb.jdField_a_of_type_Long);
          }
          localObject = new azkf();
          ((azkf)localObject).jdField_a_of_type_Int = 0;
          ((azkf)localObject).jdField_a_of_type_JavaLangObject = paramazlb;
          a(3, (azkf)localObject);
          return;
        }
        localObject = new azkb();
        ((azkb)localObject).jdField_b_of_type_JavaLangString = paramazlb.jdField_a_of_type_JavaLangString;
        a(3, (azkb)localObject);
        return;
      }
    } while (this.jdField_a_of_type_Azke.jdField_a_of_type_Int != 3);
    if (paramazlb.jdField_a_of_type_Int == 0)
    {
      updateMsg(paramazlb);
      localObject = (azkk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PICTURE_STATISTICS_MANAGER);
      if (localObject != null) {
        ((azkk)localObject).a(13058, paramazlb.jdField_a_of_type_Long);
      }
      localObject = new azkf();
      ((azkf)localObject).jdField_a_of_type_Int = 0;
      ((azkf)localObject).jdField_a_of_type_JavaLangObject = paramazlb;
      a(4, (azkf)localObject);
      return;
    }
    if (paramazlb.jdField_b_of_type_Int == 9333)
    {
      this.jdField_a_of_type_Azke.jdField_a_of_type_Azjz.jdField_a_of_type_Azjx.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Azke.jdField_a_of_type_Azjz.jdField_a_of_type_Azjx.jdField_e_of_type_JavaLangString = "chatimg";
      if (this.jdField_a_of_type_Azke.jdField_a_of_type_Azjz.jdField_a_of_type_Azkn.jdField_l_of_type_Int == 1) {}
      for (int i = 7;; i = 6)
      {
        azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramazlb = azjv.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_Azke.jdField_a_of_type_Azjz);
        paramazlb.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Azke.jdField_a_of_type_Azjz.jdField_a_of_type_Azjx);
        d(paramazlb);
        return;
      }
    }
    Object localObject = new azkb();
    ((azkb)localObject).jdField_b_of_type_JavaLangString = paramazlb.jdField_a_of_type_JavaLangString;
    ((azkb)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramazlb.jdField_b_of_type_Int);
    a(4, (azkb)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azja
 * JD-Core Version:    0.7.0.1
 */