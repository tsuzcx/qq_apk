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
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class awdy
  implements aweh, awem, awer, awfy
{
  protected static int c;
  protected Handler a;
  public awfc a;
  protected awfv a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public ArrayList<awfd> a;
  protected int b;
  public String b;
  protected ArrayList<awew> b;
  
  static
  {
    jdField_c_of_type_Int = 20;
  }
  
  public awdy() {}
  
  public awdy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new awdz(this, Looper.getMainLooper());
    }
  }
  
  private baub a(aweu paramaweu, String paramString)
  {
    paramaweu.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Boolean = false;
    localbaub.jdField_a_of_type_Int = paramaweu.jdField_b_of_type_Int;
    boolean bool;
    if (paramaweu.jdField_e_of_type_Int == 1)
    {
      bool = true;
      localbaub.jdField_b_of_type_Int = baul.a(paramString, bool);
      localbaub.jdField_a_of_type_Long = paramaweu.jdField_a_of_type_Long;
      localbaub.jdField_b_of_type_Long = paramaweu.jdField_g_of_type_Int;
      localbaub.jdField_b_of_type_JavaLangString = paramaweu.jdField_b_of_type_JavaLangString;
      localbaub.jdField_c_of_type_JavaLangString = paramaweu.jdField_c_of_type_JavaLangString;
      localbaub.jdField_e_of_type_JavaLangString = paramaweu.jdField_g_of_type_JavaLangString;
      localbaub.jdField_i_of_type_JavaLangString = null;
      localbaub.jdField_a_of_type_Aweh = this;
      localbaub.jdField_c_of_type_Boolean = false;
      localbaub.jdField_m_of_type_Boolean = paramaweu.jdField_d_of_type_Boolean;
      localbaub.jdField_h_of_type_JavaLangString = paramaweu.c();
      if ((this.jdField_a_of_type_Awfc != null) && (this.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localbaub.jdField_h_of_type_JavaLangString + "info.protocol:" + paramaweu.jdField_e_of_type_JavaLangString);
      paramString = new baue();
      localbaub.jdField_a_of_type_JavaLangObject = paramString;
      if (localbaub.jdField_b_of_type_Int != 65537) {
        break label385;
      }
      if (paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_d_of_type_Int = paramaweu.jdField_h_of_type_Int;
        paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Int = awez.a();
        paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 1;
      }
      if (!azls.a()) {
        break label374;
      }
      paramString.jdField_a_of_type_JavaLangString = paramaweu.k;
    }
    for (;;)
    {
      localbaub.jdField_f_of_type_JavaLangString = paramaweu.jdField_f_of_type_JavaLangString;
      localbaub.jdField_c_of_type_Long = paramaweu.jdField_b_of_type_Long;
      localbaub.jdField_d_of_type_Int = paramaweu.jdField_d_of_type_Int;
      localbaub.jdField_e_of_type_Int = paramaweu.jdField_a_of_type_Int;
      localbaub.jdField_f_of_type_Boolean = true;
      localbaub.jdField_g_of_type_Int = paramaweu.jdField_h_of_type_Int;
      localbaub.jdField_d_of_type_Long = paramaweu.jdField_c_of_type_Long;
      return localbaub;
      bool = false;
      break;
      label374:
      paramString.jdField_a_of_type_JavaLangString = paramaweu.jdField_h_of_type_JavaLangString;
      continue;
      label385:
      if (localbaub.jdField_b_of_type_Int == 1)
      {
        paramString.jdField_a_of_type_JavaLangString = paramaweu.jdField_i_of_type_JavaLangString;
        if (paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramaweu.jdField_h_of_type_Int;
          paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = awez.a();
          paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
      else if (localbaub.jdField_b_of_type_Int == 131075)
      {
        paramString.jdField_a_of_type_JavaLangString = paramaweu.j;
        if (paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramaweu.jdField_h_of_type_Int;
          paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = awez.a();
          paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramaweu.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
    }
  }
  
  private void a(awfc paramawfc, long paramLong)
  {
    long l;
    Map localMap;
    if (paramawfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      l = paramawfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramawfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) {
        break label108;
      }
      localMap = paramawfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramawfc);; localInteger1 = Integer.valueOf(paramawfc.jdField_c_of_type_Int))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        aeyf.a().a(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(aweu paramaweu)
  {
    if (paramaweu != null)
    {
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramaweu);
      return paramaweu.a();
    }
    awen.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(awew paramawew)
  {
    if (paramawew != null)
    {
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramawew);
      return paramawew.a();
    }
    awen.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
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
      Object localObject = baul.a(paramMessageForPic.md5, i);
      if (localObject != null) {}
      for (localObject = ((URL)localObject).toString(); !bame.b((String)localObject); localObject = null)
      {
        localObject = bame.d((String)localObject);
        bdcs.d(paramMessageForPic.path, (String)localObject);
        return;
      }
    }
  }
  
  private void e(awfc paramawfc)
  {
    int i = 0;
    aweu localaweu = paramawfc.jdField_a_of_type_Aweu;
    if (!a(localaweu))
    {
      paramawfc = new awei();
      paramawfc.jdField_a_of_type_Int = -1;
      paramawfc.jdField_a_of_type_Awey = localaweu.jdField_a_of_type_Awey;
      a(paramawfc);
    }
    String str;
    label457:
    do
    {
      MessageForPic localMessageForPic;
      int j;
      baub localbaub;
      long l;
      do
      {
        return;
        localMessageForPic = paramawfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        j = paramawfc.jdField_d_of_type_Int;
        localbaub = a(localaweu, localaweu.jdField_e_of_type_JavaLangString);
        str = localbaub.jdField_h_of_type_JavaLangString;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramawfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
          break;
        }
        paramawfc = new awei();
        paramawfc.jdField_a_of_type_Int = 0;
        paramawfc.jdField_b_of_type_JavaLangString = localbaub.jdField_h_of_type_JavaLangString;
        paramawfc.jdField_c_of_type_JavaLangString = localbaub.jdField_f_of_type_JavaLangString;
        paramawfc.jdField_c_of_type_Int = localbaub.jdField_b_of_type_Int;
        paramawfc.jdField_d_of_type_Int = localaweu.jdField_h_of_type_Int;
        paramawfc.jdField_a_of_type_Boolean = true;
        a(paramawfc);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localbaub.jdField_i_of_type_Int = 0;
        if (localMessageForPic.mDownloadLength == paramawfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
        {
          localbaub.jdField_j_of_type_Int = 0;
          localStringBuilder.append("nofile:");
        }
      }
      for (;;)
      {
        localStringBuilder.append("mRequestOffset is " + localbaub.jdField_i_of_type_Int + ", mRequestLength is " + localbaub.jdField_j_of_type_Int + ", ");
        localStringBuilder.append("outPath is " + str);
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
        }
        localbaub.k = localMessageForPic.mShowLength;
        localbaub.jdField_m_of_type_JavaLangString = localaweu.d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localbaub);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localbaub.jdField_j_of_type_Int = i;
        break;
        if (l >= paramawfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
          break label457;
        }
        localbaub.jdField_i_of_type_Int = localMessageForPic.mDownloadLength;
        localbaub.jdField_j_of_type_Int = 0;
        localStringBuilder.append("part1:");
      }
      paramawfc = new awei();
      paramawfc.jdField_a_of_type_Int = 0;
      paramawfc.jdField_b_of_type_JavaLangString = localbaub.jdField_h_of_type_JavaLangString;
      paramawfc.jdField_c_of_type_JavaLangString = localbaub.jdField_f_of_type_JavaLangString;
      paramawfc.jdField_c_of_type_Int = localbaub.jdField_b_of_type_Int;
      paramawfc.jdField_d_of_type_Int = localaweu.jdField_h_of_type_Int;
      paramawfc.jdField_a_of_type_Boolean = false;
      a(paramawfc);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void f(awfc paramawfc)
  {
    ThreadManager.post(new BasePicOprerator.2(this, paramawfc.jdField_a_of_type_Awew, paramawfc), 8, null, true);
  }
  
  private void g(awfc paramawfc)
  {
    ThreadManager.post(new BasePicOprerator.3(this, paramawfc), 8, null, true);
  }
  
  public baui a(aweu paramaweu, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramaweu))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramaweu.jdField_a_of_type_Long);
      batw localbatw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramaweu.jdField_e_of_type_JavaLangString = paramString;
      paramaweu = a(paramaweu, paramString);
      paramaweu.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramaweu.jdField_a_of_type_JavaLangObject != null) && ((paramaweu.jdField_a_of_type_JavaLangObject instanceof baue))) {
        ((baue)paramaweu.jdField_a_of_type_JavaLangObject).jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      }
      return localbatw.a(paramaweu);
    }
    paramURLDrawableHandler = new awei();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Awey = paramaweu.jdField_a_of_type_Awey;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new baui();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Long = 9302L;
    if (paramaweu.jdField_a_of_type_Awey != null)
    {
      paramURLDrawableHandler.jdField_a_of_type_JavaLangString = ("downloadPicSync," + paramaweu.jdField_a_of_type_Awey.jdField_b_of_type_JavaLangString);
      return paramURLDrawableHandler;
    }
    paramURLDrawableHandler.jdField_a_of_type_JavaLangString = "downloadPicSync param check error";
    return paramURLDrawableHandler;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
      new awea(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
  
  public void a(int paramInt, awey paramawey)
  {
    awfd localawfd = new awfd();
    localawfd.jdField_a_of_type_Awfc = this.jdField_a_of_type_Awfc;
    localawfd.jdField_a_of_type_Awey = paramawey;
    localawfd.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localawfd);
    if (paramawey != null)
    {
      awen.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramawey.jdField_a_of_type_JavaLangString, paramawey.jdField_b_of_type_JavaLangString);
      return;
    }
    awen.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, awfd paramawfd)
  {
    awfd localawfd = paramawfd;
    if (paramawfd == null) {
      localawfd = new awfd();
    }
    localawfd.jdField_a_of_type_Int = 0;
    localawfd.jdField_a_of_type_Awfc = this.jdField_a_of_type_Awfc;
    a(paramInt, 0, localawfd);
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    awfd localawfd = new awfd();
    localawfd.jdField_a_of_type_Int = 0;
    localawfd.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localawfd.jdField_c_of_type_Boolean = paramBoolean;
    a(1, 0, localawfd);
  }
  
  public void a(awei paramawei)
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Awfc != null)
    {
      if ((paramawei != null) && (this.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramawei.jdField_b_of_type_JavaLangString != null))
      {
        localObject1 = this.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        localObject2 = new File(paramawei.jdField_b_of_type_JavaLangString);
        if ((((MessageForPic)localObject1).imageType != 2000) && (GifDrawable.isGifFile((File)localObject2)))
        {
          ((MessageForPic)localObject1).imageType = 2000;
          ((MessageForPic)localObject1).serial();
          if (((MessageForPic)localObject1).subMsgId != MessageForPic.defaultSuMsgId) {
            break label295;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq);
          if (!(localObject2 instanceof MessageForStructing)) {
            break label249;
          }
          localObject2 = (MessageForStructing)localObject2;
          if ((((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare))
          {
            azsp localazsp = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
            if (localazsp != null)
            {
              awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
              localazsp.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
            }
          }
        }
      }
      ThreadManager.getFileThreadHandler().post(new BasePicOprerator.4(this, paramawei));
      if (paramawei != null) {
        break label381;
      }
      paramawei = new awey();
      paramawei.jdField_b_of_type_JavaLangString = "result == null";
      paramawei.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramawei);
    }
    for (;;)
    {
      return;
      label249:
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForPic)localObject1).msgData);
      break;
      label295:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq);
      if (!(localObject2 instanceof MessageForMixedMsg)) {
        break;
      }
      localObject2 = ((MessageForMixedMsg)localObject2).upateMessageForPic((MessageForPic)localObject1);
      if (localObject2 == null) {
        break;
      }
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, (byte[])localObject2);
      break;
      label381:
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramawei.jdField_a_of_type_Int);
      localObject1 = new awfd();
      ((awfd)localObject1).jdField_a_of_type_Int = paramawei.jdField_a_of_type_Int;
      ((awfd)localObject1).jdField_a_of_type_JavaLangObject = paramawei;
      ((awfd)localObject1).jdField_a_of_type_Boolean = paramawei.jdField_a_of_type_Boolean;
      if (paramawei.jdField_a_of_type_Int == 0) {
        a(0, (awfd)localObject1);
      }
      while (this.jdField_a_of_type_Awfc.jdField_a_of_type_Int == 3)
      {
        if (paramawei.jdField_a_of_type_Int != 0) {
          break label598;
        }
        this.jdField_a_of_type_Awfc.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString = paramawei.jdField_b_of_type_JavaLangString;
        awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "dowanload pic success,is to forward the pic");
        g(this.jdField_a_of_type_Awfc);
        return;
        if (paramawei.jdField_a_of_type_Awey == null)
        {
          localObject1 = new awey();
          ((awey)localObject1).jdField_b_of_type_JavaLangString = (paramawei.jdField_b_of_type_Int + "_" + paramawei.jdField_a_of_type_JavaLangString);
          ((awey)localObject1).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (awey)localObject1);
        }
        else
        {
          a(0, paramawei.jdField_a_of_type_Awey);
        }
      }
    }
    label598:
    a(4, this.jdField_a_of_type_Awfc.jdField_a_of_type_Awew.jdField_a_of_type_Awey);
  }
  
  public void a(awfc paramawfc)
  {
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramawfc.jdField_a_of_type_Awfl))
    {
      b(paramawfc);
      return;
    }
    a(3, paramawfc.jdField_a_of_type_Awfl.jdField_a_of_type_Awey);
  }
  
  public void a(awfc paramawfc, awfl paramawfl)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    Object localObject = new CompressInfo(paramawfl.jdField_g_of_type_JavaLangString, 0);
    awga.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramawfl.jdField_h_of_type_JavaLangString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramawfl.jdField_e_of_type_Int = ((CompressInfo)localObject).jdField_d_of_type_Int;
      paramawfl.jdField_f_of_type_Int = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    if ((paramawfl.jdField_g_of_type_Boolean) && (paramawfl.jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject = (MessageForPic)paramawfl.jdField_b_of_type_JavaLangObject; localObject == null; localObject = a(paramawfl))
    {
      awen.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject).msgVia);
    }
    aeyf.a().a(((MessageRecord)localObject).uniseq, 0L, paramawfc.jdField_c_of_type_Int);
    if (MessageForPic.class.isInstance(localObject))
    {
      a(paramawfc, (MessageRecord)localObject, paramawfl);
      b((MessageForPic)localObject);
    }
    if ((((MessageRecord)localObject).istroop == 1) && (paramawfl.jdField_a_of_type_Awfn == null)) {
      nav.a().a((MessageRecord)localObject);
    }
    if (paramawfl.jdField_c_of_type_Boolean) {
      try
      {
        paramawfl.jdField_a_of_type_JavaLangObject = localObject;
        paramawfl.notifyAll();
        awen.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramawfl.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (paramawfl.jdField_c_of_type_Int == 3)
        {
          awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          awen.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + paramawfl.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    baub localbaub = new baub();
    localbaub.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localbaub.jdField_c_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
    localbaub.jdField_d_of_type_JavaLangString = ((MessageRecord)localObject).senderuin;
    localbaub.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    localbaub.jdField_b_of_type_Int = 1;
    localbaub.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.jdField_e_of_type_Int = paramawfl.jdField_a_of_type_Int;
    localbaub.jdField_i_of_type_JavaLangString = paramawfl.jdField_g_of_type_JavaLangString;
    localbaub.jdField_f_of_type_JavaLangString = paramawfl.jdField_f_of_type_JavaLangString;
    bauf localbauf = new bauf();
    if (paramawfl.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localbauf.jdField_a_of_type_Boolean = bool;
      localbaub.jdField_a_of_type_JavaLangObject = localbauf;
      localbaub.jdField_a_of_type_Awfy = this;
      localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localbaub.jdField_i_of_type_Boolean = paramawfl.jdField_c_of_type_Boolean;
      localbaub.jdField_j_of_type_Boolean = paramawfl.jdField_e_of_type_Boolean;
      if ((paramawfc.jdField_b_of_type_Int == 1044) || (paramawfc.jdField_b_of_type_Int == 1049)) {
        apfy.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localbaub, paramawfc.jdField_b_of_type_Int);
      }
      if (!paramawfl.jdField_c_of_type_Boolean) {
        break label871;
      }
      try
      {
        if (!paramawfl.jdField_d_of_type_Boolean) {
          break;
        }
        awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        awen.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramawfl.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
      finally {}
    }
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
    awen.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramawfl.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((paramawfl.jdField_b_of_type_Boolean) && (!paramawfl.jdField_c_of_type_Boolean))
      {
        awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        a((MessageRecord)localObject, paramawfl.jdField_h_of_type_Long);
      }
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label871:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
    }
  }
  
  protected void a(awfc paramawfc, MessageRecord paramMessageRecord, awfl paramawfl)
  {
    if (paramawfc.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramawfc.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      paramawfc = paramawfc.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if (paramawfc.stickerInfo != null) {
        paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramawfc.stickerInfo.toJsonString());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sticker_info")))
      {
        EmojiStickerManager.a(paramMessageRecord, null);
        EmojiStickerManager.a().a(paramMessageRecord);
      }
    }
    if (((MessageForPic)paramMessageRecord).checkGif())
    {
      paramawfc = ((MessageForPic)paramMessageRecord).picExtraData;
      if (paramawfc != null) {
        break label257;
      }
      paramawfc = new PicMessageExtraData();
    }
    label257:
    for (;;)
    {
      if (TextUtils.isEmpty(paramawfc.textSummary)) {
        paramawfc.textSummary = BaseApplicationImpl.getApplication().getString(2131691342);
      }
      paramawfc.emojiPkgId = String.valueOf(paramawfl.s);
      paramawfc.from = paramawfl.r;
      paramawfc.source = paramawfl.n;
      paramawfc.webUrl = paramawfl.o;
      paramawfc.iconUrl = paramawfl.p;
      paramawfc.packageName = paramawfl.q;
      ((MessageForPic)paramMessageRecord).picExtraData = paramawfc;
      if ((paramawfl.jdField_a_of_type_Awfk != null) && (!TextUtils.isEmpty(paramawfl.jdField_a_of_type_Awfk.jdField_a_of_type_JavaLangString)))
      {
        PicMessageExtraData localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        paramawfc = localPicMessageExtraData;
        if (localPicMessageExtraData == null) {
          paramawfc = new PicMessageExtraData();
        }
        paramawfc.mTemplateId = paramawfl.jdField_a_of_type_Awfk.jdField_a_of_type_JavaLangString;
        paramawfc.mTemplateName = paramawfl.jdField_a_of_type_Awfk.jdField_b_of_type_JavaLangString;
        ((MessageForPic)paramMessageRecord).picExtraData = paramawfc;
      }
      return;
    }
  }
  
  public void a(awfv paramawfv)
  {
    this.jdField_a_of_type_Awfv = paramawfv;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ((axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    axso localaxso = (axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localaxso.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localaxso.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(ArrayList<awew> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((awew)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((awew)paramArrayList.get(0));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    a();
  }
  
  protected boolean a(awfl paramawfl)
  {
    if (paramawfl != null)
    {
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramawfl);
      return paramawfl.a();
    }
    awen.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  protected void b(awfc paramawfc)
  {
    awfl localawfl = paramawfc.jdField_a_of_type_Awfl;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new BasePicOprerator.5(this, paramawfc, localawfl), 8, null, false);
      return;
    }
    a(paramawfc, localawfl);
  }
  
  public void b(awfz paramawfz)
  {
    if (paramawfz == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Awfc == null);
      if ((this.jdField_a_of_type_Awfc.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Awfc.jdField_a_of_type_Int == 4))
      {
        if (paramawfz.jdField_a_of_type_Int == 0)
        {
          a(paramawfz);
          localObject = (awfi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
          if (localObject != null) {
            ((awfi)localObject).a(13057, paramawfz.jdField_a_of_type_Long);
          }
          localObject = new awfd();
          ((awfd)localObject).jdField_a_of_type_Int = 0;
          ((awfd)localObject).jdField_a_of_type_JavaLangObject = paramawfz;
          a(3, (awfd)localObject);
          return;
        }
        localObject = new awey();
        ((awey)localObject).jdField_b_of_type_JavaLangString = paramawfz.jdField_a_of_type_JavaLangString;
        a(3, (awey)localObject);
        return;
      }
    } while (this.jdField_a_of_type_Awfc.jdField_a_of_type_Int != 3);
    if (paramawfz.jdField_a_of_type_Int == 0)
    {
      a(paramawfz);
      localObject = (awfi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
      if (localObject != null) {
        ((awfi)localObject).a(13058, paramawfz.jdField_a_of_type_Long);
      }
      localObject = new awfd();
      ((awfd)localObject).jdField_a_of_type_Int = 0;
      ((awfd)localObject).jdField_a_of_type_JavaLangObject = paramawfz;
      a(4, (awfd)localObject);
      return;
    }
    if (paramawfz.jdField_b_of_type_Int == 9333)
    {
      this.jdField_a_of_type_Awfc.jdField_a_of_type_Awew.jdField_a_of_type_Aweu.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Awfc.jdField_a_of_type_Awew.jdField_a_of_type_Aweu.jdField_e_of_type_JavaLangString = "chatimg";
      if (this.jdField_a_of_type_Awfc.jdField_a_of_type_Awew.jdField_a_of_type_Awfl.l == 1) {}
      for (int i = 7;; i = 6)
      {
        awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramawfz = awes.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_Awfc.jdField_a_of_type_Awew);
        paramawfz.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Awfc.jdField_a_of_type_Awew.jdField_a_of_type_Aweu);
        d(paramawfz);
        return;
      }
    }
    Object localObject = new awey();
    ((awey)localObject).jdField_b_of_type_JavaLangString = paramawfz.jdField_a_of_type_JavaLangString;
    ((awey)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramawfz.jdField_b_of_type_Int);
    a(4, (awey)localObject);
  }
  
  public void c(awfc paramawfc)
  {
    awew localawew = paramawfc.jdField_a_of_type_Awew;
    if (!a(localawew))
    {
      a(4, localawew.jdField_a_of_type_Awey);
      return;
    }
    if (bdcs.b(localawew.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString))
    {
      localawew.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localawew);
      g(paramawfc);
      return;
    }
    if (localawew.jdField_a_of_type_Awfl.b())
    {
      File localFile = localawew.jdField_a_of_type_Awfl.a();
      if (localFile != null) {
        localawew.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString = localFile.toString();
      }
      localawew.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localawew);
      g(paramawfc);
      return;
    }
    localawew.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localawew);
    if ((localawew.jdField_a_of_type_Awfl.jdField_f_of_type_JavaLangString == null) || (localawew.jdField_a_of_type_Awfl.jdField_c_of_type_Long == 0L) || (localawew.jdField_a_of_type_Awfl.jdField_j_of_type_Int == 0) || (localawew.jdField_a_of_type_Awfl.k == 0))
    {
      localawew.jdField_a_of_type_Aweu.jdField_a_of_type_Int = 3;
      localawew.jdField_a_of_type_Aweu.jdField_e_of_type_JavaLangString = "chatimg";
      if (localawew.jdField_a_of_type_Awfl.l == 1) {}
      for (int i = 7;; i = 6)
      {
        paramawfc = awes.a(i, 3);
        paramawfc.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localawew.jdField_a_of_type_Aweu);
        d(paramawfc);
        return;
      }
    }
    f(paramawfc);
  }
  
  public void d(awfc paramawfc)
  {
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    aweu localaweu = paramawfc.jdField_a_of_type_Aweu;
    if (a(localaweu))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localaweu.jdField_a_of_type_Long);
      if (!localaweu.jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramawfc = a(localaweu, localaweu.jdField_e_of_type_JavaLangString);
        if (!new File(paramawfc.jdField_h_of_type_JavaLangString).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramawfc);
          return;
        }
        awei localawei = new awei();
        localawei.jdField_a_of_type_Int = 0;
        localawei.jdField_b_of_type_JavaLangString = paramawfc.jdField_h_of_type_JavaLangString;
        localawei.jdField_c_of_type_JavaLangString = paramawfc.jdField_f_of_type_JavaLangString;
        localawei.jdField_c_of_type_Int = paramawfc.jdField_b_of_type_Int;
        localawei.jdField_d_of_type_Int = localaweu.jdField_h_of_type_Int;
        a(localawei);
        return;
      }
      e(paramawfc);
      return;
    }
    paramawfc = new awei();
    paramawfc.jdField_a_of_type_Int = -1;
    paramawfc.jdField_a_of_type_Awey = localaweu.jdField_a_of_type_Awey;
    a(paramawfc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdy
 * JD-Core Version:    0.7.0.1
 */