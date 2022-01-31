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

public abstract class awih
  implements awiq, awiv, awja, awkh
{
  protected static int c;
  protected Handler a;
  public awjl a;
  protected awke a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public ArrayList<awjm> a;
  protected int b;
  public String b;
  protected ArrayList<awjf> b;
  
  static
  {
    jdField_c_of_type_Int = 20;
  }
  
  public awih() {}
  
  public awih(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new awii(this, Looper.getMainLooper());
    }
  }
  
  private bayk a(awjd paramawjd, String paramString)
  {
    paramawjd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    bayk localbayk = new bayk();
    localbayk.jdField_a_of_type_Boolean = false;
    localbayk.jdField_a_of_type_Int = paramawjd.jdField_b_of_type_Int;
    boolean bool;
    if (paramawjd.jdField_e_of_type_Int == 1)
    {
      bool = true;
      localbayk.jdField_b_of_type_Int = bayu.a(paramString, bool);
      localbayk.jdField_a_of_type_Long = paramawjd.jdField_a_of_type_Long;
      localbayk.jdField_b_of_type_Long = paramawjd.jdField_g_of_type_Int;
      localbayk.jdField_b_of_type_JavaLangString = paramawjd.jdField_b_of_type_JavaLangString;
      localbayk.jdField_c_of_type_JavaLangString = paramawjd.jdField_c_of_type_JavaLangString;
      localbayk.jdField_e_of_type_JavaLangString = paramawjd.jdField_g_of_type_JavaLangString;
      localbayk.jdField_i_of_type_JavaLangString = null;
      localbayk.jdField_a_of_type_Awiq = this;
      localbayk.jdField_c_of_type_Boolean = false;
      localbayk.jdField_m_of_type_Boolean = paramawjd.jdField_d_of_type_Boolean;
      localbayk.jdField_h_of_type_JavaLangString = paramawjd.c();
      if ((this.jdField_a_of_type_Awjl != null) && (this.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localbayk.jdField_h_of_type_JavaLangString + "info.protocol:" + paramawjd.jdField_e_of_type_JavaLangString);
      paramString = new bayn();
      localbayk.jdField_a_of_type_JavaLangObject = paramString;
      if (localbayk.jdField_b_of_type_Int != 65537) {
        break label385;
      }
      if (paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_d_of_type_Int = paramawjd.jdField_h_of_type_Int;
        paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Int = awji.a();
        paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 1;
      }
      if (!azqb.a()) {
        break label374;
      }
      paramString.jdField_a_of_type_JavaLangString = paramawjd.k;
    }
    for (;;)
    {
      localbayk.jdField_f_of_type_JavaLangString = paramawjd.jdField_f_of_type_JavaLangString;
      localbayk.jdField_c_of_type_Long = paramawjd.jdField_b_of_type_Long;
      localbayk.jdField_d_of_type_Int = paramawjd.jdField_d_of_type_Int;
      localbayk.jdField_e_of_type_Int = paramawjd.jdField_a_of_type_Int;
      localbayk.jdField_f_of_type_Boolean = true;
      localbayk.jdField_g_of_type_Int = paramawjd.jdField_h_of_type_Int;
      localbayk.jdField_d_of_type_Long = paramawjd.jdField_c_of_type_Long;
      return localbayk;
      bool = false;
      break;
      label374:
      paramString.jdField_a_of_type_JavaLangString = paramawjd.jdField_h_of_type_JavaLangString;
      continue;
      label385:
      if (localbayk.jdField_b_of_type_Int == 1)
      {
        paramString.jdField_a_of_type_JavaLangString = paramawjd.jdField_i_of_type_JavaLangString;
        if (paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramawjd.jdField_h_of_type_Int;
          paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = awji.a();
          paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
      else if (localbayk.jdField_b_of_type_Int == 131075)
      {
        paramString.jdField_a_of_type_JavaLangString = paramawjd.j;
        if (paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramawjd.jdField_h_of_type_Int;
          paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = awji.a();
          paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramawjd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
    }
  }
  
  private void a(awjl paramawjl, long paramLong)
  {
    long l;
    Map localMap;
    if (paramawjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      l = paramawjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramawjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) {
        break label108;
      }
      localMap = paramawjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramawjl);; localInteger1 = Integer.valueOf(paramawjl.jdField_c_of_type_Int))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        afcu.a().a(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(awjd paramawjd)
  {
    if (paramawjd != null)
    {
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramawjd);
      return paramawjd.a();
    }
    awiw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(awjf paramawjf)
  {
    if (paramawjf != null)
    {
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramawjf);
      return paramawjf.a();
    }
    awiw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
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
      Object localObject = bayu.a(paramMessageForPic.md5, i);
      if (localObject != null) {}
      for (localObject = ((URL)localObject).toString(); !baqn.b((String)localObject); localObject = null)
      {
        localObject = baqn.d((String)localObject);
        bdhb.d(paramMessageForPic.path, (String)localObject);
        return;
      }
    }
  }
  
  private void e(awjl paramawjl)
  {
    int i = 0;
    awjd localawjd = paramawjl.jdField_a_of_type_Awjd;
    if (!a(localawjd))
    {
      paramawjl = new awir();
      paramawjl.jdField_a_of_type_Int = -1;
      paramawjl.jdField_a_of_type_Awjh = localawjd.jdField_a_of_type_Awjh;
      a(paramawjl);
    }
    String str;
    label457:
    do
    {
      MessageForPic localMessageForPic;
      int j;
      bayk localbayk;
      long l;
      do
      {
        return;
        localMessageForPic = paramawjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        j = paramawjl.jdField_d_of_type_Int;
        localbayk = a(localawjd, localawjd.jdField_e_of_type_JavaLangString);
        str = localbayk.jdField_h_of_type_JavaLangString;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramawjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
          break;
        }
        paramawjl = new awir();
        paramawjl.jdField_a_of_type_Int = 0;
        paramawjl.jdField_b_of_type_JavaLangString = localbayk.jdField_h_of_type_JavaLangString;
        paramawjl.jdField_c_of_type_JavaLangString = localbayk.jdField_f_of_type_JavaLangString;
        paramawjl.jdField_c_of_type_Int = localbayk.jdField_b_of_type_Int;
        paramawjl.jdField_d_of_type_Int = localawjd.jdField_h_of_type_Int;
        paramawjl.jdField_a_of_type_Boolean = true;
        a(paramawjl);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localbayk.jdField_i_of_type_Int = 0;
        if (localMessageForPic.mDownloadLength == paramawjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
        {
          localbayk.jdField_j_of_type_Int = 0;
          localStringBuilder.append("nofile:");
        }
      }
      for (;;)
      {
        localStringBuilder.append("mRequestOffset is " + localbayk.jdField_i_of_type_Int + ", mRequestLength is " + localbayk.jdField_j_of_type_Int + ", ");
        localStringBuilder.append("outPath is " + str);
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
        }
        localbayk.k = localMessageForPic.mShowLength;
        localbayk.jdField_m_of_type_JavaLangString = localawjd.d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localbayk);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localbayk.jdField_j_of_type_Int = i;
        break;
        if (l >= paramawjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
          break label457;
        }
        localbayk.jdField_i_of_type_Int = localMessageForPic.mDownloadLength;
        localbayk.jdField_j_of_type_Int = 0;
        localStringBuilder.append("part1:");
      }
      paramawjl = new awir();
      paramawjl.jdField_a_of_type_Int = 0;
      paramawjl.jdField_b_of_type_JavaLangString = localbayk.jdField_h_of_type_JavaLangString;
      paramawjl.jdField_c_of_type_JavaLangString = localbayk.jdField_f_of_type_JavaLangString;
      paramawjl.jdField_c_of_type_Int = localbayk.jdField_b_of_type_Int;
      paramawjl.jdField_d_of_type_Int = localawjd.jdField_h_of_type_Int;
      paramawjl.jdField_a_of_type_Boolean = false;
      a(paramawjl);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void f(awjl paramawjl)
  {
    ThreadManager.post(new BasePicOprerator.2(this, paramawjl.jdField_a_of_type_Awjf, paramawjl), 8, null, true);
  }
  
  private void g(awjl paramawjl)
  {
    ThreadManager.post(new BasePicOprerator.3(this, paramawjl), 8, null, true);
  }
  
  public bayr a(awjd paramawjd, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramawjd))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramawjd.jdField_a_of_type_Long);
      bayf localbayf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramawjd.jdField_e_of_type_JavaLangString = paramString;
      paramawjd = a(paramawjd, paramString);
      paramawjd.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramawjd.jdField_a_of_type_JavaLangObject != null) && ((paramawjd.jdField_a_of_type_JavaLangObject instanceof bayn))) {
        ((bayn)paramawjd.jdField_a_of_type_JavaLangObject).jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      }
      return localbayf.a(paramawjd);
    }
    paramURLDrawableHandler = new awir();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Awjh = paramawjd.jdField_a_of_type_Awjh;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new bayr();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Long = 9302L;
    if (paramawjd.jdField_a_of_type_Awjh != null)
    {
      paramURLDrawableHandler.jdField_a_of_type_JavaLangString = ("downloadPicSync," + paramawjd.jdField_a_of_type_Awjh.jdField_b_of_type_JavaLangString);
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
      new awij(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
  
  public void a(int paramInt, awjh paramawjh)
  {
    awjm localawjm = new awjm();
    localawjm.jdField_a_of_type_Awjl = this.jdField_a_of_type_Awjl;
    localawjm.jdField_a_of_type_Awjh = paramawjh;
    localawjm.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localawjm);
    if (paramawjh != null)
    {
      awiw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramawjh.jdField_a_of_type_JavaLangString, paramawjh.jdField_b_of_type_JavaLangString);
      return;
    }
    awiw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, awjm paramawjm)
  {
    awjm localawjm = paramawjm;
    if (paramawjm == null) {
      localawjm = new awjm();
    }
    localawjm.jdField_a_of_type_Int = 0;
    localawjm.jdField_a_of_type_Awjl = this.jdField_a_of_type_Awjl;
    a(paramInt, 0, localawjm);
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    awjm localawjm = new awjm();
    localawjm.jdField_a_of_type_Int = 0;
    localawjm.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localawjm.jdField_c_of_type_Boolean = paramBoolean;
    a(1, 0, localawjm);
  }
  
  public void a(awir paramawir)
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Awjl != null)
    {
      if ((paramawir != null) && (this.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramawir.jdField_b_of_type_JavaLangString != null))
      {
        localObject1 = this.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        localObject2 = new File(paramawir.jdField_b_of_type_JavaLangString);
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
            azwy localazwy = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
            if (localazwy != null)
            {
              awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
              localazwy.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
            }
          }
        }
      }
      ThreadManager.getFileThreadHandler().post(new BasePicOprerator.4(this, paramawir));
      if (paramawir != null) {
        break label381;
      }
      paramawir = new awjh();
      paramawir.jdField_b_of_type_JavaLangString = "result == null";
      paramawir.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramawir);
    }
    for (;;)
    {
      return;
      label249:
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
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
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, (byte[])localObject2);
      break;
      label381:
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramawir.jdField_a_of_type_Int);
      localObject1 = new awjm();
      ((awjm)localObject1).jdField_a_of_type_Int = paramawir.jdField_a_of_type_Int;
      ((awjm)localObject1).jdField_a_of_type_JavaLangObject = paramawir;
      ((awjm)localObject1).jdField_a_of_type_Boolean = paramawir.jdField_a_of_type_Boolean;
      if (paramawir.jdField_a_of_type_Int == 0) {
        a(0, (awjm)localObject1);
      }
      while (this.jdField_a_of_type_Awjl.jdField_a_of_type_Int == 3)
      {
        if (paramawir.jdField_a_of_type_Int != 0) {
          break label598;
        }
        this.jdField_a_of_type_Awjl.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString = paramawir.jdField_b_of_type_JavaLangString;
        awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "dowanload pic success,is to forward the pic");
        g(this.jdField_a_of_type_Awjl);
        return;
        if (paramawir.jdField_a_of_type_Awjh == null)
        {
          localObject1 = new awjh();
          ((awjh)localObject1).jdField_b_of_type_JavaLangString = (paramawir.jdField_b_of_type_Int + "_" + paramawir.jdField_a_of_type_JavaLangString);
          ((awjh)localObject1).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (awjh)localObject1);
        }
        else
        {
          a(0, paramawir.jdField_a_of_type_Awjh);
        }
      }
    }
    label598:
    a(4, this.jdField_a_of_type_Awjl.jdField_a_of_type_Awjf.jdField_a_of_type_Awjh);
  }
  
  public void a(awjl paramawjl)
  {
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramawjl.jdField_a_of_type_Awju))
    {
      b(paramawjl);
      return;
    }
    a(3, paramawjl.jdField_a_of_type_Awju.jdField_a_of_type_Awjh);
  }
  
  public void a(awjl paramawjl, awju paramawju)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    Object localObject = new CompressInfo(paramawju.jdField_g_of_type_JavaLangString, 0);
    awkj.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramawju.jdField_h_of_type_JavaLangString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramawju.jdField_e_of_type_Int = ((CompressInfo)localObject).jdField_d_of_type_Int;
      paramawju.jdField_f_of_type_Int = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    if ((paramawju.jdField_g_of_type_Boolean) && (paramawju.jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject = (MessageForPic)paramawju.jdField_b_of_type_JavaLangObject; localObject == null; localObject = a(paramawju))
    {
      awiw.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject).msgVia);
    }
    afcu.a().a(((MessageRecord)localObject).uniseq, 0L, paramawjl.jdField_c_of_type_Int);
    if (MessageForPic.class.isInstance(localObject))
    {
      a(paramawjl, (MessageRecord)localObject, paramawju);
      b((MessageForPic)localObject);
    }
    if ((((MessageRecord)localObject).istroop == 1) && (paramawju.jdField_a_of_type_Awjw == null)) {
      nav.a().a((MessageRecord)localObject);
    }
    if (paramawju.jdField_c_of_type_Boolean) {
      try
      {
        paramawju.jdField_a_of_type_JavaLangObject = localObject;
        paramawju.notifyAll();
        awiw.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramawju.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (paramawju.jdField_c_of_type_Int == 3)
        {
          awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          awiw.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + paramawju.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    bayk localbayk = new bayk();
    localbayk.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localbayk.jdField_c_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
    localbayk.jdField_d_of_type_JavaLangString = ((MessageRecord)localObject).senderuin;
    localbayk.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    localbayk.jdField_b_of_type_Int = 1;
    localbayk.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.jdField_e_of_type_Int = paramawju.jdField_a_of_type_Int;
    localbayk.jdField_i_of_type_JavaLangString = paramawju.jdField_g_of_type_JavaLangString;
    localbayk.jdField_f_of_type_JavaLangString = paramawju.jdField_f_of_type_JavaLangString;
    bayo localbayo = new bayo();
    if (paramawju.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localbayo.jdField_a_of_type_Boolean = bool;
      localbayk.jdField_a_of_type_JavaLangObject = localbayo;
      localbayk.jdField_a_of_type_Awkh = this;
      localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localbayk.jdField_i_of_type_Boolean = paramawju.jdField_c_of_type_Boolean;
      localbayk.jdField_j_of_type_Boolean = paramawju.jdField_e_of_type_Boolean;
      if ((paramawjl.jdField_b_of_type_Int == 1044) || (paramawjl.jdField_b_of_type_Int == 1049)) {
        apkh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localbayk, paramawjl.jdField_b_of_type_Int);
      }
      if (!paramawju.jdField_c_of_type_Boolean) {
        break label871;
      }
      try
      {
        if (!paramawju.jdField_d_of_type_Boolean) {
          break;
        }
        awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        awiw.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramawju.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
      finally {}
    }
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbayk);
    awiw.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramawju.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((paramawju.jdField_b_of_type_Boolean) && (!paramawju.jdField_c_of_type_Boolean))
      {
        awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        a((MessageRecord)localObject, paramawju.jdField_h_of_type_Long);
      }
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label871:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbayk);
    }
  }
  
  protected void a(awjl paramawjl, MessageRecord paramMessageRecord, awju paramawju)
  {
    if (paramawjl.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramawjl.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      paramawjl = paramawjl.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if (paramawjl.stickerInfo != null) {
        paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramawjl.stickerInfo.toJsonString());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sticker_info")))
      {
        EmojiStickerManager.a(paramMessageRecord, null);
        EmojiStickerManager.a().a(paramMessageRecord);
      }
    }
    if (((MessageForPic)paramMessageRecord).checkGif())
    {
      paramawjl = ((MessageForPic)paramMessageRecord).picExtraData;
      if (paramawjl != null) {
        break label257;
      }
      paramawjl = new PicMessageExtraData();
    }
    label257:
    for (;;)
    {
      if (TextUtils.isEmpty(paramawjl.textSummary)) {
        paramawjl.textSummary = BaseApplicationImpl.getApplication().getString(2131691343);
      }
      paramawjl.emojiPkgId = String.valueOf(paramawju.s);
      paramawjl.from = paramawju.r;
      paramawjl.source = paramawju.n;
      paramawjl.webUrl = paramawju.o;
      paramawjl.iconUrl = paramawju.p;
      paramawjl.packageName = paramawju.q;
      ((MessageForPic)paramMessageRecord).picExtraData = paramawjl;
      if ((paramawju.jdField_a_of_type_Awjt != null) && (!TextUtils.isEmpty(paramawju.jdField_a_of_type_Awjt.jdField_a_of_type_JavaLangString)))
      {
        PicMessageExtraData localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        paramawjl = localPicMessageExtraData;
        if (localPicMessageExtraData == null) {
          paramawjl = new PicMessageExtraData();
        }
        paramawjl.mTemplateId = paramawju.jdField_a_of_type_Awjt.jdField_a_of_type_JavaLangString;
        paramawjl.mTemplateName = paramawju.jdField_a_of_type_Awjt.jdField_b_of_type_JavaLangString;
        ((MessageForPic)paramMessageRecord).picExtraData = paramawjl;
      }
      return;
    }
  }
  
  public void a(awke paramawke)
  {
    this.jdField_a_of_type_Awke = paramawke;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    axwx localaxwx = (axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localaxwx.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localaxwx.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(ArrayList<awjf> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((awjf)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((awjf)paramArrayList.get(0));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    a();
  }
  
  protected boolean a(awju paramawju)
  {
    if (paramawju != null)
    {
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramawju);
      return paramawju.a();
    }
    awiw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  protected void b(awjl paramawjl)
  {
    awju localawju = paramawjl.jdField_a_of_type_Awju;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new BasePicOprerator.5(this, paramawjl, localawju), 8, null, false);
      return;
    }
    a(paramawjl, localawju);
  }
  
  public void b(awki paramawki)
  {
    if (paramawki == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Awjl == null);
      if ((this.jdField_a_of_type_Awjl.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Awjl.jdField_a_of_type_Int == 4))
      {
        if (paramawki.jdField_a_of_type_Int == 0)
        {
          a(paramawki);
          localObject = (awjr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
          if (localObject != null) {
            ((awjr)localObject).a(13057, paramawki.jdField_a_of_type_Long);
          }
          localObject = new awjm();
          ((awjm)localObject).jdField_a_of_type_Int = 0;
          ((awjm)localObject).jdField_a_of_type_JavaLangObject = paramawki;
          a(3, (awjm)localObject);
          return;
        }
        localObject = new awjh();
        ((awjh)localObject).jdField_b_of_type_JavaLangString = paramawki.jdField_a_of_type_JavaLangString;
        a(3, (awjh)localObject);
        return;
      }
    } while (this.jdField_a_of_type_Awjl.jdField_a_of_type_Int != 3);
    if (paramawki.jdField_a_of_type_Int == 0)
    {
      a(paramawki);
      localObject = (awjr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
      if (localObject != null) {
        ((awjr)localObject).a(13058, paramawki.jdField_a_of_type_Long);
      }
      localObject = new awjm();
      ((awjm)localObject).jdField_a_of_type_Int = 0;
      ((awjm)localObject).jdField_a_of_type_JavaLangObject = paramawki;
      a(4, (awjm)localObject);
      return;
    }
    if (paramawki.jdField_b_of_type_Int == 9333)
    {
      this.jdField_a_of_type_Awjl.jdField_a_of_type_Awjf.jdField_a_of_type_Awjd.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Awjl.jdField_a_of_type_Awjf.jdField_a_of_type_Awjd.jdField_e_of_type_JavaLangString = "chatimg";
      if (this.jdField_a_of_type_Awjl.jdField_a_of_type_Awjf.jdField_a_of_type_Awju.l == 1) {}
      for (int i = 7;; i = 6)
      {
        awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramawki = awjb.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_Awjl.jdField_a_of_type_Awjf);
        paramawki.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Awjl.jdField_a_of_type_Awjf.jdField_a_of_type_Awjd);
        d(paramawki);
        return;
      }
    }
    Object localObject = new awjh();
    ((awjh)localObject).jdField_b_of_type_JavaLangString = paramawki.jdField_a_of_type_JavaLangString;
    ((awjh)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramawki.jdField_b_of_type_Int);
    a(4, (awjh)localObject);
  }
  
  public void c(awjl paramawjl)
  {
    awjf localawjf = paramawjl.jdField_a_of_type_Awjf;
    if (!a(localawjf))
    {
      a(4, localawjf.jdField_a_of_type_Awjh);
      return;
    }
    if (bdhb.b(localawjf.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString))
    {
      localawjf.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localawjf);
      g(paramawjl);
      return;
    }
    if (localawjf.jdField_a_of_type_Awju.b())
    {
      File localFile = localawjf.jdField_a_of_type_Awju.a();
      if (localFile != null) {
        localawjf.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString = localFile.toString();
      }
      localawjf.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localawjf);
      g(paramawjl);
      return;
    }
    localawjf.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localawjf);
    if ((localawjf.jdField_a_of_type_Awju.jdField_f_of_type_JavaLangString == null) || (localawjf.jdField_a_of_type_Awju.jdField_c_of_type_Long == 0L) || (localawjf.jdField_a_of_type_Awju.jdField_j_of_type_Int == 0) || (localawjf.jdField_a_of_type_Awju.k == 0))
    {
      localawjf.jdField_a_of_type_Awjd.jdField_a_of_type_Int = 3;
      localawjf.jdField_a_of_type_Awjd.jdField_e_of_type_JavaLangString = "chatimg";
      if (localawjf.jdField_a_of_type_Awju.l == 1) {}
      for (int i = 7;; i = 6)
      {
        paramawjl = awjb.a(i, 3);
        paramawjl.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localawjf.jdField_a_of_type_Awjd);
        d(paramawjl);
        return;
      }
    }
    f(paramawjl);
  }
  
  public void d(awjl paramawjl)
  {
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    awjd localawjd = paramawjl.jdField_a_of_type_Awjd;
    if (a(localawjd))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localawjd.jdField_a_of_type_Long);
      if (!localawjd.jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramawjl = a(localawjd, localawjd.jdField_e_of_type_JavaLangString);
        if (!new File(paramawjl.jdField_h_of_type_JavaLangString).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramawjl);
          return;
        }
        awir localawir = new awir();
        localawir.jdField_a_of_type_Int = 0;
        localawir.jdField_b_of_type_JavaLangString = paramawjl.jdField_h_of_type_JavaLangString;
        localawir.jdField_c_of_type_JavaLangString = paramawjl.jdField_f_of_type_JavaLangString;
        localawir.jdField_c_of_type_Int = paramawjl.jdField_b_of_type_Int;
        localawir.jdField_d_of_type_Int = localawjd.jdField_h_of_type_Int;
        a(localawir);
        return;
      }
      e(paramawjl);
      return;
    }
    paramawjl = new awir();
    paramawjl.jdField_a_of_type_Int = -1;
    paramawjl.jdField_a_of_type_Awjh = localawjd.jdField_a_of_type_Awjh;
    a(paramawjl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awih
 * JD-Core Version:    0.7.0.1
 */