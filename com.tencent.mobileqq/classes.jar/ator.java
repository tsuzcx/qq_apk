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

public abstract class ator
  implements atpa, atpf, atpk, atqq
{
  protected static int c;
  protected Handler a;
  public atpv a;
  protected atqn a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public ArrayList<atpw> a;
  protected int b;
  public String b;
  protected ArrayList<atpp> b;
  
  static
  {
    jdField_c_of_type_Int = 20;
  }
  
  public ator() {}
  
  public ator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new atos(this, Looper.getMainLooper());
    }
  }
  
  private axvt a(atpn paramatpn, String paramString)
  {
    paramatpn.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    axvt localaxvt = new axvt();
    localaxvt.jdField_a_of_type_Boolean = false;
    localaxvt.jdField_a_of_type_Int = paramatpn.jdField_b_of_type_Int;
    boolean bool;
    if (paramatpn.jdField_e_of_type_Int == 1)
    {
      bool = true;
      localaxvt.jdField_b_of_type_Int = axwd.a(paramString, bool);
      localaxvt.jdField_a_of_type_Long = paramatpn.jdField_a_of_type_Long;
      localaxvt.jdField_b_of_type_Long = paramatpn.jdField_g_of_type_Int;
      localaxvt.jdField_b_of_type_JavaLangString = paramatpn.jdField_b_of_type_JavaLangString;
      localaxvt.jdField_c_of_type_JavaLangString = paramatpn.jdField_c_of_type_JavaLangString;
      localaxvt.jdField_e_of_type_JavaLangString = paramatpn.jdField_g_of_type_JavaLangString;
      localaxvt.jdField_i_of_type_JavaLangString = null;
      localaxvt.jdField_a_of_type_Atpa = this;
      localaxvt.jdField_c_of_type_Boolean = false;
      localaxvt.jdField_m_of_type_Boolean = paramatpn.jdField_d_of_type_Boolean;
      localaxvt.jdField_h_of_type_JavaLangString = paramatpn.c();
      if ((this.jdField_a_of_type_Atpv != null) && (this.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localaxvt.jdField_h_of_type_JavaLangString + "info.protocol:" + paramatpn.jdField_e_of_type_JavaLangString);
      paramString = new axvw();
      localaxvt.jdField_a_of_type_JavaLangObject = paramString;
      if (localaxvt.jdField_b_of_type_Int != 65537) {
        break label385;
      }
      if (paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_d_of_type_Int = paramatpn.jdField_h_of_type_Int;
        paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Int = atps.a();
        paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 1;
      }
      if (!awqg.a()) {
        break label374;
      }
      paramString.jdField_a_of_type_JavaLangString = paramatpn.k;
    }
    for (;;)
    {
      localaxvt.jdField_f_of_type_JavaLangString = paramatpn.jdField_f_of_type_JavaLangString;
      localaxvt.jdField_c_of_type_Long = paramatpn.jdField_b_of_type_Long;
      localaxvt.jdField_d_of_type_Int = paramatpn.jdField_d_of_type_Int;
      localaxvt.jdField_e_of_type_Int = paramatpn.jdField_a_of_type_Int;
      localaxvt.jdField_f_of_type_Boolean = true;
      localaxvt.jdField_g_of_type_Int = paramatpn.jdField_h_of_type_Int;
      localaxvt.jdField_d_of_type_Long = paramatpn.jdField_c_of_type_Long;
      return localaxvt;
      bool = false;
      break;
      label374:
      paramString.jdField_a_of_type_JavaLangString = paramatpn.jdField_h_of_type_JavaLangString;
      continue;
      label385:
      if (localaxvt.jdField_b_of_type_Int == 1)
      {
        paramString.jdField_a_of_type_JavaLangString = paramatpn.jdField_i_of_type_JavaLangString;
        if (paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramatpn.jdField_h_of_type_Int;
          paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = atps.a();
          paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
      else if (localaxvt.jdField_b_of_type_Int == 131075)
      {
        paramString.jdField_a_of_type_JavaLangString = paramatpn.j;
        if (paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramatpn.jdField_h_of_type_Int;
          paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = atps.a();
          paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramatpn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
    }
  }
  
  private void a(atpv paramatpv, long paramLong)
  {
    long l;
    Map localMap;
    if (paramatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      l = paramatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) {
        break label108;
      }
      localMap = paramatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramatpv);; localInteger1 = Integer.valueOf(paramatpv.jdField_c_of_type_Int))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        acvh.a().a(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(atpn paramatpn)
  {
    if (paramatpn != null)
    {
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramatpn);
      return paramatpn.a();
    }
    atpg.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(atpp paramatpp)
  {
    if (paramatpp != null)
    {
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramatpp);
      return paramatpp.a();
    }
    atpg.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
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
      Object localObject = axwd.a(paramMessageForPic.md5, i);
      if (localObject != null) {}
      for (localObject = ((URL)localObject).toString(); !axoa.b((String)localObject); localObject = null)
      {
        localObject = axoa.d((String)localObject);
        bace.d(paramMessageForPic.path, (String)localObject);
        return;
      }
    }
  }
  
  private void e(atpv paramatpv)
  {
    int i = 0;
    atpn localatpn = paramatpv.jdField_a_of_type_Atpn;
    if (!a(localatpn))
    {
      paramatpv = new atpb();
      paramatpv.jdField_a_of_type_Int = -1;
      paramatpv.jdField_a_of_type_Atpr = localatpn.jdField_a_of_type_Atpr;
      a(paramatpv);
    }
    String str;
    label457:
    do
    {
      MessageForPic localMessageForPic;
      int j;
      axvt localaxvt;
      long l;
      do
      {
        return;
        localMessageForPic = paramatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        j = paramatpv.jdField_d_of_type_Int;
        localaxvt = a(localatpn, localatpn.jdField_e_of_type_JavaLangString);
        str = localaxvt.jdField_h_of_type_JavaLangString;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
          break;
        }
        paramatpv = new atpb();
        paramatpv.jdField_a_of_type_Int = 0;
        paramatpv.jdField_b_of_type_JavaLangString = localaxvt.jdField_h_of_type_JavaLangString;
        paramatpv.jdField_c_of_type_JavaLangString = localaxvt.jdField_f_of_type_JavaLangString;
        paramatpv.jdField_c_of_type_Int = localaxvt.jdField_b_of_type_Int;
        paramatpv.jdField_d_of_type_Int = localatpn.jdField_h_of_type_Int;
        paramatpv.jdField_a_of_type_Boolean = true;
        a(paramatpv);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localaxvt.jdField_i_of_type_Int = 0;
        if (localMessageForPic.mDownloadLength == paramatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
        {
          localaxvt.jdField_j_of_type_Int = 0;
          localStringBuilder.append("nofile:");
        }
      }
      for (;;)
      {
        localStringBuilder.append("mRequestOffset is " + localaxvt.jdField_i_of_type_Int + ", mRequestLength is " + localaxvt.jdField_j_of_type_Int + ", ");
        localStringBuilder.append("outPath is " + str);
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
        }
        localaxvt.k = localMessageForPic.mShowLength;
        localaxvt.jdField_m_of_type_JavaLangString = localatpn.d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localaxvt);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localaxvt.jdField_j_of_type_Int = i;
        break;
        if (l >= paramatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
          break label457;
        }
        localaxvt.jdField_i_of_type_Int = localMessageForPic.mDownloadLength;
        localaxvt.jdField_j_of_type_Int = 0;
        localStringBuilder.append("part1:");
      }
      paramatpv = new atpb();
      paramatpv.jdField_a_of_type_Int = 0;
      paramatpv.jdField_b_of_type_JavaLangString = localaxvt.jdField_h_of_type_JavaLangString;
      paramatpv.jdField_c_of_type_JavaLangString = localaxvt.jdField_f_of_type_JavaLangString;
      paramatpv.jdField_c_of_type_Int = localaxvt.jdField_b_of_type_Int;
      paramatpv.jdField_d_of_type_Int = localatpn.jdField_h_of_type_Int;
      paramatpv.jdField_a_of_type_Boolean = false;
      a(paramatpv);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void f(atpv paramatpv)
  {
    ThreadManager.post(new BasePicOprerator.2(this, paramatpv.jdField_a_of_type_Atpp, paramatpv), 8, null, true);
  }
  
  private void g(atpv paramatpv)
  {
    ThreadManager.post(new BasePicOprerator.3(this, paramatpv), 8, null, true);
  }
  
  public axwa a(atpn paramatpn, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramatpn))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramatpn.jdField_a_of_type_Long);
      axvo localaxvo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramatpn.jdField_e_of_type_JavaLangString = paramString;
      paramatpn = a(paramatpn, paramString);
      paramatpn.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramatpn.jdField_a_of_type_JavaLangObject != null) && ((paramatpn.jdField_a_of_type_JavaLangObject instanceof axvw))) {
        ((axvw)paramatpn.jdField_a_of_type_JavaLangObject).jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      }
      return localaxvo.a(paramatpn);
    }
    paramURLDrawableHandler = new atpb();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Atpr = paramatpn.jdField_a_of_type_Atpr;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new axwa();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Long = 9302L;
    if (paramatpn.jdField_a_of_type_Atpr != null)
    {
      paramURLDrawableHandler.jdField_a_of_type_JavaLangString = ("downloadPicSync," + paramatpn.jdField_a_of_type_Atpr.jdField_b_of_type_JavaLangString);
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
      new atot(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
  
  public void a(int paramInt, atpr paramatpr)
  {
    atpw localatpw = new atpw();
    localatpw.jdField_a_of_type_Atpv = this.jdField_a_of_type_Atpv;
    localatpw.jdField_a_of_type_Atpr = paramatpr;
    localatpw.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localatpw);
    if (paramatpr != null)
    {
      atpg.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramatpr.jdField_a_of_type_JavaLangString, paramatpr.jdField_b_of_type_JavaLangString);
      return;
    }
    atpg.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, atpw paramatpw)
  {
    atpw localatpw = paramatpw;
    if (paramatpw == null) {
      localatpw = new atpw();
    }
    localatpw.jdField_a_of_type_Int = 0;
    localatpw.jdField_a_of_type_Atpv = this.jdField_a_of_type_Atpv;
    a(paramInt, 0, localatpw);
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    atpw localatpw = new atpw();
    localatpw.jdField_a_of_type_Int = 0;
    localatpw.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localatpw.jdField_c_of_type_Boolean = paramBoolean;
    a(1, 0, localatpw);
  }
  
  public void a(atpb paramatpb)
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Atpv != null)
    {
      if ((paramatpb != null) && (this.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramatpb.jdField_b_of_type_JavaLangString != null))
      {
        localObject1 = this.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        localObject2 = new File(paramatpb.jdField_b_of_type_JavaLangString);
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
            awwr localawwr = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
            if (localawwr != null)
            {
              atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
              localawwr.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
            }
          }
        }
      }
      ThreadManager.getFileThreadHandler().post(new BasePicOprerator.4(this, paramatpb));
      if (paramatpb != null) {
        break label381;
      }
      paramatpb = new atpr();
      paramatpb.jdField_b_of_type_JavaLangString = "result == null";
      paramatpb.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramatpb);
    }
    for (;;)
    {
      return;
      label249:
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
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
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, (byte[])localObject2);
      break;
      label381:
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramatpb.jdField_a_of_type_Int);
      localObject1 = new atpw();
      ((atpw)localObject1).jdField_a_of_type_Int = paramatpb.jdField_a_of_type_Int;
      ((atpw)localObject1).jdField_a_of_type_JavaLangObject = paramatpb;
      ((atpw)localObject1).jdField_a_of_type_Boolean = paramatpb.jdField_a_of_type_Boolean;
      if (paramatpb.jdField_a_of_type_Int == 0) {
        a(0, (atpw)localObject1);
      }
      while (this.jdField_a_of_type_Atpv.jdField_a_of_type_Int == 3)
      {
        if (paramatpb.jdField_a_of_type_Int != 0) {
          break label598;
        }
        this.jdField_a_of_type_Atpv.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString = paramatpb.jdField_b_of_type_JavaLangString;
        atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "dowanload pic success,is to forward the pic");
        g(this.jdField_a_of_type_Atpv);
        return;
        if (paramatpb.jdField_a_of_type_Atpr == null)
        {
          localObject1 = new atpr();
          ((atpr)localObject1).jdField_b_of_type_JavaLangString = (paramatpb.jdField_b_of_type_Int + "_" + paramatpb.jdField_a_of_type_JavaLangString);
          ((atpr)localObject1).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (atpr)localObject1);
        }
        else
        {
          a(0, paramatpb.jdField_a_of_type_Atpr);
        }
      }
    }
    label598:
    a(4, this.jdField_a_of_type_Atpv.jdField_a_of_type_Atpp.jdField_a_of_type_Atpr);
  }
  
  public void a(atpv paramatpv)
  {
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramatpv.jdField_a_of_type_Atqd))
    {
      b(paramatpv);
      return;
    }
    a(3, paramatpv.jdField_a_of_type_Atqd.jdField_a_of_type_Atpr);
  }
  
  public void a(atpv paramatpv, atqd paramatqd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    Object localObject = new CompressInfo(paramatqd.jdField_g_of_type_JavaLangString, 0);
    atqs.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramatqd.jdField_h_of_type_JavaLangString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramatqd.jdField_e_of_type_Int = ((CompressInfo)localObject).jdField_d_of_type_Int;
      paramatqd.jdField_f_of_type_Int = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    if ((paramatqd.jdField_g_of_type_Boolean) && (paramatqd.jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject = (MessageForPic)paramatqd.jdField_b_of_type_JavaLangObject; localObject == null; localObject = a(paramatqd))
    {
      atpg.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject).msgVia);
    }
    acvh.a().a(((MessageRecord)localObject).uniseq, 0L, paramatpv.jdField_c_of_type_Int);
    if (MessageForPic.class.isInstance(localObject))
    {
      a(paramatpv, (MessageRecord)localObject, paramatqd);
      b((MessageForPic)localObject);
    }
    if ((((MessageRecord)localObject).istroop == 1) && (paramatqd.jdField_a_of_type_Atqf == null)) {
      mnf.a().a((MessageRecord)localObject);
    }
    if (paramatqd.jdField_c_of_type_Boolean) {
      try
      {
        paramatqd.jdField_a_of_type_JavaLangObject = localObject;
        paramatqd.notifyAll();
        atpg.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramatqd.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (paramatqd.jdField_c_of_type_Int == 3)
        {
          atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          atpg.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + paramatqd.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    axvt localaxvt = new axvt();
    localaxvt.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localaxvt.jdField_c_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
    localaxvt.jdField_d_of_type_JavaLangString = ((MessageRecord)localObject).senderuin;
    localaxvt.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    localaxvt.jdField_b_of_type_Int = 1;
    localaxvt.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
    localaxvt.jdField_a_of_type_Boolean = true;
    localaxvt.jdField_e_of_type_Int = paramatqd.jdField_a_of_type_Int;
    localaxvt.jdField_i_of_type_JavaLangString = paramatqd.jdField_g_of_type_JavaLangString;
    localaxvt.jdField_f_of_type_JavaLangString = paramatqd.jdField_f_of_type_JavaLangString;
    axvx localaxvx = new axvx();
    if (paramatqd.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localaxvx.jdField_a_of_type_Boolean = bool;
      localaxvt.jdField_a_of_type_JavaLangObject = localaxvx;
      localaxvt.jdField_a_of_type_Atqq = this;
      localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localaxvt.jdField_i_of_type_Boolean = paramatqd.jdField_c_of_type_Boolean;
      localaxvt.jdField_j_of_type_Boolean = paramatqd.jdField_e_of_type_Boolean;
      if ((paramatpv.jdField_b_of_type_Int == 1044) || (paramatpv.jdField_b_of_type_Int == 1049)) {
        amye.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localaxvt, paramatpv.jdField_b_of_type_Int);
      }
      if (!paramatqd.jdField_c_of_type_Boolean) {
        break label871;
      }
      try
      {
        if (!paramatqd.jdField_d_of_type_Boolean) {
          break;
        }
        atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        atpg.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramatqd.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
      finally {}
    }
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
    atpg.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramatqd.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((paramatqd.jdField_b_of_type_Boolean) && (!paramatqd.jdField_c_of_type_Boolean))
      {
        atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        a((MessageRecord)localObject, paramatqd.jdField_h_of_type_Long);
      }
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label871:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
    }
  }
  
  protected void a(atpv paramatpv, MessageRecord paramMessageRecord, atqd paramatqd)
  {
    if (paramatpv.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramatpv.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      paramatpv = paramatpv.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if (paramatpv.stickerInfo != null) {
        paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramatpv.stickerInfo.toJsonString());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sticker_info")))
      {
        EmojiStickerManager.a(paramMessageRecord, null);
        EmojiStickerManager.a().a(paramMessageRecord);
      }
    }
    if (((MessageForPic)paramMessageRecord).checkGif())
    {
      paramatpv = ((MessageForPic)paramMessageRecord).picExtraData;
      if (paramatpv != null) {
        break label233;
      }
      paramatpv = new PicMessageExtraData();
    }
    label233:
    for (;;)
    {
      if (TextUtils.isEmpty(paramatpv.textSummary)) {
        paramatpv.textSummary = BaseApplicationImpl.getApplication().getString(2131625713);
      }
      paramatpv.emojiPkgId = String.valueOf(paramatqd.s);
      paramatpv.from = paramatqd.jdField_r_of_type_Int;
      paramatpv.source = paramatqd.n;
      paramatpv.webUrl = paramatqd.o;
      paramatpv.iconUrl = paramatqd.p;
      paramatpv.packageName = paramatqd.q;
      ((MessageForPic)paramMessageRecord).picExtraData = paramatpv;
      if (!TextUtils.isEmpty(paramatqd.jdField_r_of_type_JavaLangString))
      {
        PicMessageExtraData localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        paramatpv = localPicMessageExtraData;
        if (localPicMessageExtraData == null) {
          paramatpv = new PicMessageExtraData();
        }
        paramatpv.mTemplateId = paramatqd.jdField_r_of_type_JavaLangString;
        ((MessageForPic)paramMessageRecord).picExtraData = paramatpv;
      }
      return;
    }
  }
  
  public void a(atqn paramatqn)
  {
    this.jdField_a_of_type_Atqn = paramatqn;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ((avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    avau localavau = (avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localavau.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localavau.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(ArrayList<atpp> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((atpp)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((atpp)paramArrayList.get(0));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    a();
  }
  
  protected boolean a(atqd paramatqd)
  {
    if (paramatqd != null)
    {
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramatqd);
      return paramatqd.a();
    }
    atpg.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  protected void b(atpv paramatpv)
  {
    atqd localatqd = paramatpv.jdField_a_of_type_Atqd;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new BasePicOprerator.5(this, paramatpv, localatqd), 8, null, false);
      return;
    }
    a(paramatpv, localatqd);
  }
  
  public void b(atqr paramatqr)
  {
    if (paramatqr == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Atpv == null);
      if ((this.jdField_a_of_type_Atpv.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Atpv.jdField_a_of_type_Int == 4))
      {
        if (paramatqr.jdField_a_of_type_Int == 0)
        {
          a(paramatqr);
          localObject = (atqb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
          if (localObject != null) {
            ((atqb)localObject).a(13057, paramatqr.jdField_a_of_type_Long);
          }
          localObject = new atpw();
          ((atpw)localObject).jdField_a_of_type_Int = 0;
          ((atpw)localObject).jdField_a_of_type_JavaLangObject = paramatqr;
          a(3, (atpw)localObject);
          return;
        }
        localObject = new atpr();
        ((atpr)localObject).jdField_b_of_type_JavaLangString = paramatqr.jdField_a_of_type_JavaLangString;
        a(3, (atpr)localObject);
        return;
      }
    } while (this.jdField_a_of_type_Atpv.jdField_a_of_type_Int != 3);
    if (paramatqr.jdField_a_of_type_Int == 0)
    {
      a(paramatqr);
      localObject = (atqb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
      if (localObject != null) {
        ((atqb)localObject).a(13058, paramatqr.jdField_a_of_type_Long);
      }
      localObject = new atpw();
      ((atpw)localObject).jdField_a_of_type_Int = 0;
      ((atpw)localObject).jdField_a_of_type_JavaLangObject = paramatqr;
      a(4, (atpw)localObject);
      return;
    }
    if (paramatqr.jdField_b_of_type_Int == 9333)
    {
      this.jdField_a_of_type_Atpv.jdField_a_of_type_Atpp.jdField_a_of_type_Atpn.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Atpv.jdField_a_of_type_Atpp.jdField_a_of_type_Atpn.jdField_e_of_type_JavaLangString = "chatimg";
      if (this.jdField_a_of_type_Atpv.jdField_a_of_type_Atpp.jdField_a_of_type_Atqd.l == 1) {}
      for (int i = 7;; i = 6)
      {
        atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramatqr = atpl.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_Atpv.jdField_a_of_type_Atpp);
        paramatqr.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Atpv.jdField_a_of_type_Atpp.jdField_a_of_type_Atpn);
        d(paramatqr);
        return;
      }
    }
    Object localObject = new atpr();
    ((atpr)localObject).jdField_b_of_type_JavaLangString = paramatqr.jdField_a_of_type_JavaLangString;
    ((atpr)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramatqr.jdField_b_of_type_Int);
    a(4, (atpr)localObject);
  }
  
  public void c(atpv paramatpv)
  {
    atpp localatpp = paramatpv.jdField_a_of_type_Atpp;
    if (!a(localatpp))
    {
      a(4, localatpp.jdField_a_of_type_Atpr);
      return;
    }
    if (bace.b(localatpp.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString))
    {
      localatpp.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localatpp);
      g(paramatpv);
      return;
    }
    if (localatpp.jdField_a_of_type_Atqd.b())
    {
      File localFile = localatpp.jdField_a_of_type_Atqd.a();
      if (localFile != null) {
        localatpp.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString = localFile.toString();
      }
      localatpp.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localatpp);
      g(paramatpv);
      return;
    }
    localatpp.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localatpp);
    if ((localatpp.jdField_a_of_type_Atqd.jdField_f_of_type_JavaLangString == null) || (localatpp.jdField_a_of_type_Atqd.jdField_c_of_type_Long == 0L) || (localatpp.jdField_a_of_type_Atqd.jdField_j_of_type_Int == 0) || (localatpp.jdField_a_of_type_Atqd.k == 0))
    {
      localatpp.jdField_a_of_type_Atpn.jdField_a_of_type_Int = 3;
      localatpp.jdField_a_of_type_Atpn.jdField_e_of_type_JavaLangString = "chatimg";
      if (localatpp.jdField_a_of_type_Atqd.l == 1) {}
      for (int i = 7;; i = 6)
      {
        paramatpv = atpl.a(i, 3);
        paramatpv.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localatpp.jdField_a_of_type_Atpn);
        d(paramatpv);
        return;
      }
    }
    f(paramatpv);
  }
  
  public void d(atpv paramatpv)
  {
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    atpn localatpn = paramatpv.jdField_a_of_type_Atpn;
    if (a(localatpn))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localatpn.jdField_a_of_type_Long);
      if (!localatpn.jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramatpv = a(localatpn, localatpn.jdField_e_of_type_JavaLangString);
        if (!new File(paramatpv.jdField_h_of_type_JavaLangString).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramatpv);
          return;
        }
        atpb localatpb = new atpb();
        localatpb.jdField_a_of_type_Int = 0;
        localatpb.jdField_b_of_type_JavaLangString = paramatpv.jdField_h_of_type_JavaLangString;
        localatpb.jdField_c_of_type_JavaLangString = paramatpv.jdField_f_of_type_JavaLangString;
        localatpb.jdField_c_of_type_Int = paramatpv.jdField_b_of_type_Int;
        localatpb.jdField_d_of_type_Int = localatpn.jdField_h_of_type_Int;
        a(localatpb);
        return;
      }
      e(paramatpv);
      return;
    }
    paramatpv = new atpb();
    paramatpv.jdField_a_of_type_Int = -1;
    paramatpv.jdField_a_of_type_Atpr = localatpn.jdField_a_of_type_Atpr;
    a(paramatpv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ator
 * JD-Core Version:    0.7.0.1
 */