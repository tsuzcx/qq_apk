import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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

public abstract class aump
  implements aumy, aund, auni, auoo
{
  protected static int c;
  protected Handler a;
  public aunt a;
  protected auol a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public ArrayList<aunu> a;
  protected int b;
  public String b;
  protected ArrayList<aunn> b;
  
  static
  {
    jdField_c_of_type_Int = 20;
  }
  
  public aump() {}
  
  public aump(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new aumq(this, Looper.getMainLooper());
    }
  }
  
  private aywa a(aunl paramaunl, String paramString)
  {
    paramaunl.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    aywa localaywa = new aywa();
    localaywa.jdField_a_of_type_Boolean = false;
    localaywa.jdField_a_of_type_Int = paramaunl.jdField_b_of_type_Int;
    boolean bool;
    if (paramaunl.jdField_e_of_type_Int == 1)
    {
      bool = true;
      localaywa.jdField_b_of_type_Int = aywk.a(paramString, bool);
      localaywa.jdField_a_of_type_Long = paramaunl.jdField_a_of_type_Long;
      localaywa.jdField_b_of_type_Long = paramaunl.jdField_g_of_type_Int;
      localaywa.jdField_b_of_type_JavaLangString = paramaunl.jdField_b_of_type_JavaLangString;
      localaywa.jdField_c_of_type_JavaLangString = paramaunl.jdField_c_of_type_JavaLangString;
      localaywa.jdField_e_of_type_JavaLangString = paramaunl.jdField_g_of_type_JavaLangString;
      localaywa.jdField_i_of_type_JavaLangString = null;
      localaywa.jdField_a_of_type_Aumy = this;
      localaywa.jdField_c_of_type_Boolean = false;
      localaywa.jdField_m_of_type_Boolean = paramaunl.jdField_d_of_type_Boolean;
      localaywa.jdField_h_of_type_JavaLangString = paramaunl.c();
      if ((this.jdField_a_of_type_Aunt != null) && (this.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localaywa.jdField_h_of_type_JavaLangString + "info.protocol:" + paramaunl.jdField_e_of_type_JavaLangString);
      paramString = new aywd();
      localaywa.jdField_a_of_type_JavaLangObject = paramString;
      if (localaywa.jdField_b_of_type_Int != 65537) {
        break label385;
      }
      if (paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_d_of_type_Int = paramaunl.jdField_h_of_type_Int;
        paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Int = aunq.a();
        paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 1;
      }
      if (!axqf.a()) {
        break label374;
      }
      paramString.jdField_a_of_type_JavaLangString = paramaunl.k;
    }
    for (;;)
    {
      localaywa.jdField_f_of_type_JavaLangString = paramaunl.jdField_f_of_type_JavaLangString;
      localaywa.jdField_c_of_type_Long = paramaunl.jdField_b_of_type_Long;
      localaywa.jdField_d_of_type_Int = paramaunl.jdField_d_of_type_Int;
      localaywa.jdField_e_of_type_Int = paramaunl.jdField_a_of_type_Int;
      localaywa.jdField_f_of_type_Boolean = true;
      localaywa.jdField_g_of_type_Int = paramaunl.jdField_h_of_type_Int;
      localaywa.jdField_d_of_type_Long = paramaunl.jdField_c_of_type_Long;
      return localaywa;
      bool = false;
      break;
      label374:
      paramString.jdField_a_of_type_JavaLangString = paramaunl.jdField_h_of_type_JavaLangString;
      continue;
      label385:
      if (localaywa.jdField_b_of_type_Int == 1)
      {
        paramString.jdField_a_of_type_JavaLangString = paramaunl.jdField_i_of_type_JavaLangString;
        if (paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramaunl.jdField_h_of_type_Int;
          paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = aunq.a();
          paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
      else if (localaywa.jdField_b_of_type_Int == 131075)
      {
        paramString.jdField_a_of_type_JavaLangString = paramaunl.j;
        if (paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramaunl.jdField_h_of_type_Int;
          paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = aunq.a();
          paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramaunl.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
    }
  }
  
  private void a(aunt paramaunt, long paramLong)
  {
    long l;
    Map localMap;
    if (paramaunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      l = paramaunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramaunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) {
        break label108;
      }
      localMap = paramaunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramaunt);; localInteger1 = Integer.valueOf(paramaunt.jdField_c_of_type_Int))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        adgf.a().a(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(aunl paramaunl)
  {
    if (paramaunl != null)
    {
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramaunl);
      return paramaunl.a();
    }
    aune.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(aunn paramaunn)
  {
    if (paramaunn != null)
    {
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramaunn);
      return paramaunn.a();
    }
    aune.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
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
      Object localObject = aywk.a(paramMessageForPic.md5, i);
      if (localObject != null) {}
      for (localObject = ((URL)localObject).toString(); !ayog.b((String)localObject); localObject = null)
      {
        localObject = ayog.d((String)localObject);
        bbdj.d(paramMessageForPic.path, (String)localObject);
        return;
      }
    }
  }
  
  private void e(aunt paramaunt)
  {
    int i = 0;
    aunl localaunl = paramaunt.jdField_a_of_type_Aunl;
    if (!a(localaunl))
    {
      paramaunt = new aumz();
      paramaunt.jdField_a_of_type_Int = -1;
      paramaunt.jdField_a_of_type_Aunp = localaunl.jdField_a_of_type_Aunp;
      a(paramaunt);
    }
    String str;
    label457:
    do
    {
      MessageForPic localMessageForPic;
      int j;
      aywa localaywa;
      long l;
      do
      {
        return;
        localMessageForPic = paramaunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        j = paramaunt.jdField_d_of_type_Int;
        localaywa = a(localaunl, localaunl.jdField_e_of_type_JavaLangString);
        str = localaywa.jdField_h_of_type_JavaLangString;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramaunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
          break;
        }
        paramaunt = new aumz();
        paramaunt.jdField_a_of_type_Int = 0;
        paramaunt.jdField_b_of_type_JavaLangString = localaywa.jdField_h_of_type_JavaLangString;
        paramaunt.jdField_c_of_type_JavaLangString = localaywa.jdField_f_of_type_JavaLangString;
        paramaunt.jdField_c_of_type_Int = localaywa.jdField_b_of_type_Int;
        paramaunt.jdField_d_of_type_Int = localaunl.jdField_h_of_type_Int;
        paramaunt.jdField_a_of_type_Boolean = true;
        a(paramaunt);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localaywa.jdField_i_of_type_Int = 0;
        if (localMessageForPic.mDownloadLength == paramaunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
        {
          localaywa.jdField_j_of_type_Int = 0;
          localStringBuilder.append("nofile:");
        }
      }
      for (;;)
      {
        localStringBuilder.append("mRequestOffset is " + localaywa.jdField_i_of_type_Int + ", mRequestLength is " + localaywa.jdField_j_of_type_Int + ", ");
        localStringBuilder.append("outPath is " + str);
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
        }
        localaywa.k = localMessageForPic.mShowLength;
        localaywa.jdField_m_of_type_JavaLangString = localaunl.d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localaywa);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localaywa.jdField_j_of_type_Int = i;
        break;
        if (l >= paramaunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
          break label457;
        }
        localaywa.jdField_i_of_type_Int = localMessageForPic.mDownloadLength;
        localaywa.jdField_j_of_type_Int = 0;
        localStringBuilder.append("part1:");
      }
      paramaunt = new aumz();
      paramaunt.jdField_a_of_type_Int = 0;
      paramaunt.jdField_b_of_type_JavaLangString = localaywa.jdField_h_of_type_JavaLangString;
      paramaunt.jdField_c_of_type_JavaLangString = localaywa.jdField_f_of_type_JavaLangString;
      paramaunt.jdField_c_of_type_Int = localaywa.jdField_b_of_type_Int;
      paramaunt.jdField_d_of_type_Int = localaunl.jdField_h_of_type_Int;
      paramaunt.jdField_a_of_type_Boolean = false;
      a(paramaunt);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void f(aunt paramaunt)
  {
    ThreadManager.post(new BasePicOprerator.2(this, paramaunt.jdField_a_of_type_Aunn, paramaunt), 8, null, true);
  }
  
  private void g(aunt paramaunt)
  {
    ThreadManager.post(new BasePicOprerator.3(this, paramaunt), 8, null, true);
  }
  
  public aywh a(aunl paramaunl, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramaunl))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramaunl.jdField_a_of_type_Long);
      ayvv localayvv = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramaunl.jdField_e_of_type_JavaLangString = paramString;
      paramaunl = a(paramaunl, paramString);
      paramaunl.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramaunl.jdField_a_of_type_JavaLangObject != null) && ((paramaunl.jdField_a_of_type_JavaLangObject instanceof aywd))) {
        ((aywd)paramaunl.jdField_a_of_type_JavaLangObject).jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      }
      return localayvv.a(paramaunl);
    }
    paramURLDrawableHandler = new aumz();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Aunp = paramaunl.jdField_a_of_type_Aunp;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new aywh();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Long = 9302L;
    if (paramaunl.jdField_a_of_type_Aunp != null)
    {
      paramURLDrawableHandler.jdField_a_of_type_JavaLangString = ("downloadPicSync," + paramaunl.jdField_a_of_type_Aunp.jdField_b_of_type_JavaLangString);
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
      new aumr(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
  
  public void a(int paramInt, aunp paramaunp)
  {
    aunu localaunu = new aunu();
    localaunu.jdField_a_of_type_Aunt = this.jdField_a_of_type_Aunt;
    localaunu.jdField_a_of_type_Aunp = paramaunp;
    localaunu.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localaunu);
    if (paramaunp != null)
    {
      aune.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramaunp.jdField_a_of_type_JavaLangString, paramaunp.jdField_b_of_type_JavaLangString);
      return;
    }
    aune.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, aunu paramaunu)
  {
    aunu localaunu = paramaunu;
    if (paramaunu == null) {
      localaunu = new aunu();
    }
    localaunu.jdField_a_of_type_Int = 0;
    localaunu.jdField_a_of_type_Aunt = this.jdField_a_of_type_Aunt;
    a(paramInt, 0, localaunu);
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    aunu localaunu = new aunu();
    localaunu.jdField_a_of_type_Int = 0;
    localaunu.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localaunu.jdField_c_of_type_Boolean = paramBoolean;
    a(1, 0, localaunu);
  }
  
  public void a(aumz paramaumz)
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Aunt != null)
    {
      if ((paramaumz != null) && (this.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramaumz.jdField_b_of_type_JavaLangString != null))
      {
        localObject1 = this.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        localObject2 = new File(paramaumz.jdField_b_of_type_JavaLangString);
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
            axwt localaxwt = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
            if (localaxwt != null)
            {
              aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
              localaxwt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
            }
          }
        }
      }
      ThreadManager.getFileThreadHandler().post(new BasePicOprerator.4(this, paramaumz));
      if (paramaumz != null) {
        break label381;
      }
      paramaumz = new aunp();
      paramaumz.jdField_b_of_type_JavaLangString = "result == null";
      paramaumz.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramaumz);
    }
    for (;;)
    {
      return;
      label249:
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
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
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, (byte[])localObject2);
      break;
      label381:
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramaumz.jdField_a_of_type_Int);
      localObject1 = new aunu();
      ((aunu)localObject1).jdField_a_of_type_Int = paramaumz.jdField_a_of_type_Int;
      ((aunu)localObject1).jdField_a_of_type_JavaLangObject = paramaumz;
      ((aunu)localObject1).jdField_a_of_type_Boolean = paramaumz.jdField_a_of_type_Boolean;
      if (paramaumz.jdField_a_of_type_Int == 0) {
        a(0, (aunu)localObject1);
      }
      while (this.jdField_a_of_type_Aunt.jdField_a_of_type_Int == 3)
      {
        if (paramaumz.jdField_a_of_type_Int != 0) {
          break label598;
        }
        this.jdField_a_of_type_Aunt.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString = paramaumz.jdField_b_of_type_JavaLangString;
        aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "dowanload pic success,is to forward the pic");
        g(this.jdField_a_of_type_Aunt);
        return;
        if (paramaumz.jdField_a_of_type_Aunp == null)
        {
          localObject1 = new aunp();
          ((aunp)localObject1).jdField_b_of_type_JavaLangString = (paramaumz.jdField_b_of_type_Int + "_" + paramaumz.jdField_a_of_type_JavaLangString);
          ((aunp)localObject1).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (aunp)localObject1);
        }
        else
        {
          a(0, paramaumz.jdField_a_of_type_Aunp);
        }
      }
    }
    label598:
    a(4, this.jdField_a_of_type_Aunt.jdField_a_of_type_Aunn.jdField_a_of_type_Aunp);
  }
  
  public void a(aunt paramaunt)
  {
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramaunt.jdField_a_of_type_Auob))
    {
      b(paramaunt);
      return;
    }
    a(3, paramaunt.jdField_a_of_type_Auob.jdField_a_of_type_Aunp);
  }
  
  public void a(aunt paramaunt, auob paramauob)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    Object localObject = new CompressInfo(paramauob.jdField_g_of_type_JavaLangString, 0);
    auoq.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramauob.jdField_h_of_type_JavaLangString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramauob.jdField_e_of_type_Int = ((CompressInfo)localObject).jdField_d_of_type_Int;
      paramauob.jdField_f_of_type_Int = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    if ((paramauob.jdField_g_of_type_Boolean) && (paramauob.jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject = (MessageForPic)paramauob.jdField_b_of_type_JavaLangObject; localObject == null; localObject = a(paramauob))
    {
      aune.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject).msgVia);
    }
    adgf.a().a(((MessageRecord)localObject).uniseq, 0L, paramaunt.jdField_c_of_type_Int);
    if (MessageForPic.class.isInstance(localObject))
    {
      a(paramaunt, (MessageRecord)localObject, paramauob);
      b((MessageForPic)localObject);
    }
    if ((((MessageRecord)localObject).istroop == 1) && (paramauob.jdField_a_of_type_Auod == null)) {
      mye.a().a((MessageRecord)localObject);
    }
    if (paramauob.jdField_c_of_type_Boolean) {
      try
      {
        paramauob.jdField_a_of_type_JavaLangObject = localObject;
        paramauob.notifyAll();
        aune.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramauob.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (paramauob.jdField_c_of_type_Int == 3)
        {
          aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          aune.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + paramauob.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    aywa localaywa = new aywa();
    localaywa.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localaywa.jdField_c_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
    localaywa.jdField_d_of_type_JavaLangString = ((MessageRecord)localObject).senderuin;
    localaywa.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    localaywa.jdField_b_of_type_Int = 1;
    localaywa.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
    localaywa.jdField_a_of_type_Boolean = true;
    localaywa.jdField_e_of_type_Int = paramauob.jdField_a_of_type_Int;
    localaywa.jdField_i_of_type_JavaLangString = paramauob.jdField_g_of_type_JavaLangString;
    localaywa.jdField_f_of_type_JavaLangString = paramauob.jdField_f_of_type_JavaLangString;
    aywe localaywe = new aywe();
    if (paramauob.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localaywe.jdField_a_of_type_Boolean = bool;
      localaywa.jdField_a_of_type_JavaLangObject = localaywe;
      localaywa.jdField_a_of_type_Auoo = this;
      localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localaywa.jdField_i_of_type_Boolean = paramauob.jdField_c_of_type_Boolean;
      localaywa.jdField_j_of_type_Boolean = paramauob.jdField_e_of_type_Boolean;
      if ((paramaunt.jdField_b_of_type_Int == 1044) || (paramaunt.jdField_b_of_type_Int == 1049)) {
        anom.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localaywa, paramaunt.jdField_b_of_type_Int);
      }
      if (!paramauob.jdField_c_of_type_Boolean) {
        break label871;
      }
      try
      {
        if (!paramauob.jdField_d_of_type_Boolean) {
          break;
        }
        aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        aune.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramauob.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
      finally {}
    }
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywa);
    aune.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramauob.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((paramauob.jdField_b_of_type_Boolean) && (!paramauob.jdField_c_of_type_Boolean))
      {
        aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        a((MessageRecord)localObject, paramauob.jdField_h_of_type_Long);
      }
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label871:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywa);
    }
  }
  
  protected void a(aunt paramaunt, MessageRecord paramMessageRecord, auob paramauob)
  {
    if (paramaunt.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramaunt.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      paramaunt = paramaunt.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if (paramaunt.stickerInfo != null) {
        paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramaunt.stickerInfo.toJsonString());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sticker_info")))
      {
        EmojiStickerManager.a(paramMessageRecord, null);
        EmojiStickerManager.a().a(paramMessageRecord);
      }
    }
    if (((MessageForPic)paramMessageRecord).checkGif())
    {
      paramaunt = ((MessageForPic)paramMessageRecord).picExtraData;
      if (paramaunt != null) {
        break label233;
      }
      paramaunt = new PicMessageExtraData();
    }
    label233:
    for (;;)
    {
      if (TextUtils.isEmpty(paramaunt.textSummary)) {
        paramaunt.textSummary = BaseApplicationImpl.getApplication().getString(2131691289);
      }
      paramaunt.emojiPkgId = String.valueOf(paramauob.s);
      paramaunt.from = paramauob.jdField_r_of_type_Int;
      paramaunt.source = paramauob.n;
      paramaunt.webUrl = paramauob.o;
      paramaunt.iconUrl = paramauob.p;
      paramaunt.packageName = paramauob.q;
      ((MessageForPic)paramMessageRecord).picExtraData = paramaunt;
      if (!TextUtils.isEmpty(paramauob.jdField_r_of_type_JavaLangString))
      {
        PicMessageExtraData localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        paramaunt = localPicMessageExtraData;
        if (localPicMessageExtraData == null) {
          paramaunt = new PicMessageExtraData();
        }
        paramaunt.mTemplateId = paramauob.jdField_r_of_type_JavaLangString;
        ((MessageForPic)paramMessageRecord).picExtraData = paramaunt;
      }
      return;
    }
  }
  
  public void a(auol paramauol)
  {
    this.jdField_a_of_type_Auol = paramauol;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ((awan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    awan localawan = (awan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localawan.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localawan.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(ArrayList<aunn> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((aunn)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((aunn)paramArrayList.get(0));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    a();
  }
  
  protected boolean a(auob paramauob)
  {
    if (paramauob != null)
    {
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramauob);
      return paramauob.a();
    }
    aune.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  protected void b(aunt paramaunt)
  {
    auob localauob = paramaunt.jdField_a_of_type_Auob;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new BasePicOprerator.5(this, paramaunt, localauob), 8, null, false);
      return;
    }
    a(paramaunt, localauob);
  }
  
  public void b(auop paramauop)
  {
    if (paramauop == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aunt == null);
      if ((this.jdField_a_of_type_Aunt.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Aunt.jdField_a_of_type_Int == 4))
      {
        if (paramauop.jdField_a_of_type_Int == 0)
        {
          a(paramauop);
          localObject = (aunz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
          if (localObject != null) {
            ((aunz)localObject).a(13057, paramauop.jdField_a_of_type_Long);
          }
          localObject = new aunu();
          ((aunu)localObject).jdField_a_of_type_Int = 0;
          ((aunu)localObject).jdField_a_of_type_JavaLangObject = paramauop;
          a(3, (aunu)localObject);
          return;
        }
        localObject = new aunp();
        ((aunp)localObject).jdField_b_of_type_JavaLangString = paramauop.jdField_a_of_type_JavaLangString;
        a(3, (aunp)localObject);
        return;
      }
    } while (this.jdField_a_of_type_Aunt.jdField_a_of_type_Int != 3);
    if (paramauop.jdField_a_of_type_Int == 0)
    {
      a(paramauop);
      localObject = (aunz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
      if (localObject != null) {
        ((aunz)localObject).a(13058, paramauop.jdField_a_of_type_Long);
      }
      localObject = new aunu();
      ((aunu)localObject).jdField_a_of_type_Int = 0;
      ((aunu)localObject).jdField_a_of_type_JavaLangObject = paramauop;
      a(4, (aunu)localObject);
      return;
    }
    if (paramauop.jdField_b_of_type_Int == 9333)
    {
      this.jdField_a_of_type_Aunt.jdField_a_of_type_Aunn.jdField_a_of_type_Aunl.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Aunt.jdField_a_of_type_Aunn.jdField_a_of_type_Aunl.jdField_e_of_type_JavaLangString = "chatimg";
      if (this.jdField_a_of_type_Aunt.jdField_a_of_type_Aunn.jdField_a_of_type_Auob.l == 1) {}
      for (int i = 7;; i = 6)
      {
        aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramauop = aunj.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_Aunt.jdField_a_of_type_Aunn);
        paramauop.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Aunt.jdField_a_of_type_Aunn.jdField_a_of_type_Aunl);
        d(paramauop);
        return;
      }
    }
    Object localObject = new aunp();
    ((aunp)localObject).jdField_b_of_type_JavaLangString = paramauop.jdField_a_of_type_JavaLangString;
    ((aunp)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramauop.jdField_b_of_type_Int);
    a(4, (aunp)localObject);
  }
  
  public void c(aunt paramaunt)
  {
    aunn localaunn = paramaunt.jdField_a_of_type_Aunn;
    if (!a(localaunn))
    {
      a(4, localaunn.jdField_a_of_type_Aunp);
      return;
    }
    if (bbdj.b(localaunn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString))
    {
      localaunn.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localaunn);
      g(paramaunt);
      return;
    }
    if (localaunn.jdField_a_of_type_Auob.b())
    {
      File localFile = localaunn.jdField_a_of_type_Auob.a();
      if (localFile != null) {
        localaunn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString = localFile.toString();
      }
      localaunn.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localaunn);
      g(paramaunt);
      return;
    }
    localaunn.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localaunn);
    if ((localaunn.jdField_a_of_type_Auob.jdField_f_of_type_JavaLangString == null) || (localaunn.jdField_a_of_type_Auob.jdField_c_of_type_Long == 0L) || (localaunn.jdField_a_of_type_Auob.jdField_j_of_type_Int == 0) || (localaunn.jdField_a_of_type_Auob.k == 0))
    {
      localaunn.jdField_a_of_type_Aunl.jdField_a_of_type_Int = 3;
      localaunn.jdField_a_of_type_Aunl.jdField_e_of_type_JavaLangString = "chatimg";
      if (localaunn.jdField_a_of_type_Auob.l == 1) {}
      for (int i = 7;; i = 6)
      {
        paramaunt = aunj.a(i, 3);
        paramaunt.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localaunn.jdField_a_of_type_Aunl);
        d(paramaunt);
        return;
      }
    }
    f(paramaunt);
  }
  
  public void d(aunt paramaunt)
  {
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    aunl localaunl = paramaunt.jdField_a_of_type_Aunl;
    if (a(localaunl))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localaunl.jdField_a_of_type_Long);
      if (!localaunl.jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramaunt = a(localaunl, localaunl.jdField_e_of_type_JavaLangString);
        if (!new File(paramaunt.jdField_h_of_type_JavaLangString).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramaunt);
          return;
        }
        aumz localaumz = new aumz();
        localaumz.jdField_a_of_type_Int = 0;
        localaumz.jdField_b_of_type_JavaLangString = paramaunt.jdField_h_of_type_JavaLangString;
        localaumz.jdField_c_of_type_JavaLangString = paramaunt.jdField_f_of_type_JavaLangString;
        localaumz.jdField_c_of_type_Int = paramaunt.jdField_b_of_type_Int;
        localaumz.jdField_d_of_type_Int = localaunl.jdField_h_of_type_Int;
        a(localaumz);
        return;
      }
      e(paramaunt);
      return;
    }
    paramaunt = new aumz();
    paramaunt.jdField_a_of_type_Int = -1;
    paramaunt.jdField_a_of_type_Aunp = localaunl.jdField_a_of_type_Aunp;
    a(paramaunt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aump
 * JD-Core Version:    0.7.0.1
 */