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

public abstract class aumr
  implements auna, aunf, aunk, auoq
{
  protected static int c;
  protected Handler a;
  public aunv a;
  protected auon a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public ArrayList<aunw> a;
  protected int b;
  public String b;
  protected ArrayList<aunp> b;
  
  static
  {
    jdField_c_of_type_Int = 20;
  }
  
  public aumr() {}
  
  public aumr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new aums(this, Looper.getMainLooper());
    }
  }
  
  private aywc a(aunn paramaunn, String paramString)
  {
    paramaunn.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Boolean = false;
    localaywc.jdField_a_of_type_Int = paramaunn.jdField_b_of_type_Int;
    boolean bool;
    if (paramaunn.jdField_e_of_type_Int == 1)
    {
      bool = true;
      localaywc.jdField_b_of_type_Int = aywm.a(paramString, bool);
      localaywc.jdField_a_of_type_Long = paramaunn.jdField_a_of_type_Long;
      localaywc.jdField_b_of_type_Long = paramaunn.jdField_g_of_type_Int;
      localaywc.jdField_b_of_type_JavaLangString = paramaunn.jdField_b_of_type_JavaLangString;
      localaywc.jdField_c_of_type_JavaLangString = paramaunn.jdField_c_of_type_JavaLangString;
      localaywc.jdField_e_of_type_JavaLangString = paramaunn.jdField_g_of_type_JavaLangString;
      localaywc.jdField_i_of_type_JavaLangString = null;
      localaywc.jdField_a_of_type_Auna = this;
      localaywc.jdField_c_of_type_Boolean = false;
      localaywc.jdField_m_of_type_Boolean = paramaunn.jdField_d_of_type_Boolean;
      localaywc.jdField_h_of_type_JavaLangString = paramaunn.c();
      if ((this.jdField_a_of_type_Aunv != null) && (this.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localaywc.jdField_h_of_type_JavaLangString + "info.protocol:" + paramaunn.jdField_e_of_type_JavaLangString);
      paramString = new aywf();
      localaywc.jdField_a_of_type_JavaLangObject = paramString;
      if (localaywc.jdField_b_of_type_Int != 65537) {
        break label385;
      }
      if (paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_d_of_type_Int = paramaunn.jdField_h_of_type_Int;
        paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Int = auns.a();
        paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 1;
      }
      if (!axqh.a()) {
        break label374;
      }
      paramString.jdField_a_of_type_JavaLangString = paramaunn.k;
    }
    for (;;)
    {
      localaywc.jdField_f_of_type_JavaLangString = paramaunn.jdField_f_of_type_JavaLangString;
      localaywc.jdField_c_of_type_Long = paramaunn.jdField_b_of_type_Long;
      localaywc.jdField_d_of_type_Int = paramaunn.jdField_d_of_type_Int;
      localaywc.jdField_e_of_type_Int = paramaunn.jdField_a_of_type_Int;
      localaywc.jdField_f_of_type_Boolean = true;
      localaywc.jdField_g_of_type_Int = paramaunn.jdField_h_of_type_Int;
      localaywc.jdField_d_of_type_Long = paramaunn.jdField_c_of_type_Long;
      return localaywc;
      bool = false;
      break;
      label374:
      paramString.jdField_a_of_type_JavaLangString = paramaunn.jdField_h_of_type_JavaLangString;
      continue;
      label385:
      if (localaywc.jdField_b_of_type_Int == 1)
      {
        paramString.jdField_a_of_type_JavaLangString = paramaunn.jdField_i_of_type_JavaLangString;
        if (paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramaunn.jdField_h_of_type_Int;
          paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = auns.a();
          paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
      else if (localaywc.jdField_b_of_type_Int == 131075)
      {
        paramString.jdField_a_of_type_JavaLangString = paramaunn.j;
        if (paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramaunn.jdField_h_of_type_Int;
          paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = auns.a();
          paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramaunn.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
    }
  }
  
  private void a(aunv paramaunv, long paramLong)
  {
    long l;
    Map localMap;
    if (paramaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      l = paramaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) {
        break label108;
      }
      localMap = paramaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramaunv);; localInteger1 = Integer.valueOf(paramaunv.jdField_c_of_type_Int))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        adgc.a().a(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(aunn paramaunn)
  {
    if (paramaunn != null)
    {
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramaunn);
      return paramaunn.a();
    }
    aung.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(aunp paramaunp)
  {
    if (paramaunp != null)
    {
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramaunp);
      return paramaunp.a();
    }
    aung.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
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
      Object localObject = aywm.a(paramMessageForPic.md5, i);
      if (localObject != null) {}
      for (localObject = ((URL)localObject).toString(); !ayoi.b((String)localObject); localObject = null)
      {
        localObject = ayoi.d((String)localObject);
        bbdx.d(paramMessageForPic.path, (String)localObject);
        return;
      }
    }
  }
  
  private void e(aunv paramaunv)
  {
    int i = 0;
    aunn localaunn = paramaunv.jdField_a_of_type_Aunn;
    if (!a(localaunn))
    {
      paramaunv = new aunb();
      paramaunv.jdField_a_of_type_Int = -1;
      paramaunv.jdField_a_of_type_Aunr = localaunn.jdField_a_of_type_Aunr;
      a(paramaunv);
    }
    String str;
    label457:
    do
    {
      MessageForPic localMessageForPic;
      int j;
      aywc localaywc;
      long l;
      do
      {
        return;
        localMessageForPic = paramaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        j = paramaunv.jdField_d_of_type_Int;
        localaywc = a(localaunn, localaunn.jdField_e_of_type_JavaLangString);
        str = localaywc.jdField_h_of_type_JavaLangString;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
          break;
        }
        paramaunv = new aunb();
        paramaunv.jdField_a_of_type_Int = 0;
        paramaunv.jdField_b_of_type_JavaLangString = localaywc.jdField_h_of_type_JavaLangString;
        paramaunv.jdField_c_of_type_JavaLangString = localaywc.jdField_f_of_type_JavaLangString;
        paramaunv.jdField_c_of_type_Int = localaywc.jdField_b_of_type_Int;
        paramaunv.jdField_d_of_type_Int = localaunn.jdField_h_of_type_Int;
        paramaunv.jdField_a_of_type_Boolean = true;
        a(paramaunv);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localaywc.jdField_i_of_type_Int = 0;
        if (localMessageForPic.mDownloadLength == paramaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
        {
          localaywc.jdField_j_of_type_Int = 0;
          localStringBuilder.append("nofile:");
        }
      }
      for (;;)
      {
        localStringBuilder.append("mRequestOffset is " + localaywc.jdField_i_of_type_Int + ", mRequestLength is " + localaywc.jdField_j_of_type_Int + ", ");
        localStringBuilder.append("outPath is " + str);
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
        }
        localaywc.k = localMessageForPic.mShowLength;
        localaywc.jdField_m_of_type_JavaLangString = localaunn.d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localaywc);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localaywc.jdField_j_of_type_Int = i;
        break;
        if (l >= paramaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
          break label457;
        }
        localaywc.jdField_i_of_type_Int = localMessageForPic.mDownloadLength;
        localaywc.jdField_j_of_type_Int = 0;
        localStringBuilder.append("part1:");
      }
      paramaunv = new aunb();
      paramaunv.jdField_a_of_type_Int = 0;
      paramaunv.jdField_b_of_type_JavaLangString = localaywc.jdField_h_of_type_JavaLangString;
      paramaunv.jdField_c_of_type_JavaLangString = localaywc.jdField_f_of_type_JavaLangString;
      paramaunv.jdField_c_of_type_Int = localaywc.jdField_b_of_type_Int;
      paramaunv.jdField_d_of_type_Int = localaunn.jdField_h_of_type_Int;
      paramaunv.jdField_a_of_type_Boolean = false;
      a(paramaunv);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void f(aunv paramaunv)
  {
    ThreadManager.post(new BasePicOprerator.2(this, paramaunv.jdField_a_of_type_Aunp, paramaunv), 8, null, true);
  }
  
  private void g(aunv paramaunv)
  {
    ThreadManager.post(new BasePicOprerator.3(this, paramaunv), 8, null, true);
  }
  
  public aywj a(aunn paramaunn, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramaunn))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramaunn.jdField_a_of_type_Long);
      ayvx localayvx = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramaunn.jdField_e_of_type_JavaLangString = paramString;
      paramaunn = a(paramaunn, paramString);
      paramaunn.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramaunn.jdField_a_of_type_JavaLangObject != null) && ((paramaunn.jdField_a_of_type_JavaLangObject instanceof aywf))) {
        ((aywf)paramaunn.jdField_a_of_type_JavaLangObject).jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      }
      return localayvx.a(paramaunn);
    }
    paramURLDrawableHandler = new aunb();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Aunr = paramaunn.jdField_a_of_type_Aunr;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new aywj();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Long = 9302L;
    if (paramaunn.jdField_a_of_type_Aunr != null)
    {
      paramURLDrawableHandler.jdField_a_of_type_JavaLangString = ("downloadPicSync," + paramaunn.jdField_a_of_type_Aunr.jdField_b_of_type_JavaLangString);
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
      new aumt(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
  
  public void a(int paramInt, aunr paramaunr)
  {
    aunw localaunw = new aunw();
    localaunw.jdField_a_of_type_Aunv = this.jdField_a_of_type_Aunv;
    localaunw.jdField_a_of_type_Aunr = paramaunr;
    localaunw.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localaunw);
    if (paramaunr != null)
    {
      aung.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramaunr.jdField_a_of_type_JavaLangString, paramaunr.jdField_b_of_type_JavaLangString);
      return;
    }
    aung.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, aunw paramaunw)
  {
    aunw localaunw = paramaunw;
    if (paramaunw == null) {
      localaunw = new aunw();
    }
    localaunw.jdField_a_of_type_Int = 0;
    localaunw.jdField_a_of_type_Aunv = this.jdField_a_of_type_Aunv;
    a(paramInt, 0, localaunw);
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    aunw localaunw = new aunw();
    localaunw.jdField_a_of_type_Int = 0;
    localaunw.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localaunw.jdField_c_of_type_Boolean = paramBoolean;
    a(1, 0, localaunw);
  }
  
  public void a(aunb paramaunb)
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Aunv != null)
    {
      if ((paramaunb != null) && (this.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramaunb.jdField_b_of_type_JavaLangString != null))
      {
        localObject1 = this.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        localObject2 = new File(paramaunb.jdField_b_of_type_JavaLangString);
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
            axwv localaxwv = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
            if (localaxwv != null)
            {
              aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
              localaxwv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
            }
          }
        }
      }
      ThreadManager.getFileThreadHandler().post(new BasePicOprerator.4(this, paramaunb));
      if (paramaunb != null) {
        break label381;
      }
      paramaunb = new aunr();
      paramaunb.jdField_b_of_type_JavaLangString = "result == null";
      paramaunb.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramaunb);
    }
    for (;;)
    {
      return;
      label249:
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
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
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, (byte[])localObject2);
      break;
      label381:
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramaunb.jdField_a_of_type_Int);
      localObject1 = new aunw();
      ((aunw)localObject1).jdField_a_of_type_Int = paramaunb.jdField_a_of_type_Int;
      ((aunw)localObject1).jdField_a_of_type_JavaLangObject = paramaunb;
      ((aunw)localObject1).jdField_a_of_type_Boolean = paramaunb.jdField_a_of_type_Boolean;
      if (paramaunb.jdField_a_of_type_Int == 0) {
        a(0, (aunw)localObject1);
      }
      while (this.jdField_a_of_type_Aunv.jdField_a_of_type_Int == 3)
      {
        if (paramaunb.jdField_a_of_type_Int != 0) {
          break label598;
        }
        this.jdField_a_of_type_Aunv.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString = paramaunb.jdField_b_of_type_JavaLangString;
        aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "dowanload pic success,is to forward the pic");
        g(this.jdField_a_of_type_Aunv);
        return;
        if (paramaunb.jdField_a_of_type_Aunr == null)
        {
          localObject1 = new aunr();
          ((aunr)localObject1).jdField_b_of_type_JavaLangString = (paramaunb.jdField_b_of_type_Int + "_" + paramaunb.jdField_a_of_type_JavaLangString);
          ((aunr)localObject1).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (aunr)localObject1);
        }
        else
        {
          a(0, paramaunb.jdField_a_of_type_Aunr);
        }
      }
    }
    label598:
    a(4, this.jdField_a_of_type_Aunv.jdField_a_of_type_Aunp.jdField_a_of_type_Aunr);
  }
  
  public void a(aunv paramaunv)
  {
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramaunv.jdField_a_of_type_Auod))
    {
      b(paramaunv);
      return;
    }
    a(3, paramaunv.jdField_a_of_type_Auod.jdField_a_of_type_Aunr);
  }
  
  public void a(aunv paramaunv, auod paramauod)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    Object localObject = new CompressInfo(paramauod.jdField_g_of_type_JavaLangString, 0);
    auos.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramauod.jdField_h_of_type_JavaLangString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramauod.jdField_e_of_type_Int = ((CompressInfo)localObject).jdField_d_of_type_Int;
      paramauod.jdField_f_of_type_Int = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    if ((paramauod.jdField_g_of_type_Boolean) && (paramauod.jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject = (MessageForPic)paramauod.jdField_b_of_type_JavaLangObject; localObject == null; localObject = a(paramauod))
    {
      aung.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject).msgVia);
    }
    adgc.a().a(((MessageRecord)localObject).uniseq, 0L, paramaunv.jdField_c_of_type_Int);
    if (MessageForPic.class.isInstance(localObject))
    {
      a(paramaunv, (MessageRecord)localObject, paramauod);
      b((MessageForPic)localObject);
    }
    if ((((MessageRecord)localObject).istroop == 1) && (paramauod.jdField_a_of_type_Auof == null)) {
      myb.a().a((MessageRecord)localObject);
    }
    if (paramauod.jdField_c_of_type_Boolean) {
      try
      {
        paramauod.jdField_a_of_type_JavaLangObject = localObject;
        paramauod.notifyAll();
        aung.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramauod.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (paramauod.jdField_c_of_type_Int == 3)
        {
          aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          aung.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + paramauod.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    aywc localaywc = new aywc();
    localaywc.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localaywc.jdField_c_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
    localaywc.jdField_d_of_type_JavaLangString = ((MessageRecord)localObject).senderuin;
    localaywc.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    localaywc.jdField_b_of_type_Int = 1;
    localaywc.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.jdField_e_of_type_Int = paramauod.jdField_a_of_type_Int;
    localaywc.jdField_i_of_type_JavaLangString = paramauod.jdField_g_of_type_JavaLangString;
    localaywc.jdField_f_of_type_JavaLangString = paramauod.jdField_f_of_type_JavaLangString;
    aywg localaywg = new aywg();
    if (paramauod.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localaywg.jdField_a_of_type_Boolean = bool;
      localaywc.jdField_a_of_type_JavaLangObject = localaywg;
      localaywc.jdField_a_of_type_Auoq = this;
      localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localaywc.jdField_i_of_type_Boolean = paramauod.jdField_c_of_type_Boolean;
      localaywc.jdField_j_of_type_Boolean = paramauod.jdField_e_of_type_Boolean;
      if ((paramaunv.jdField_b_of_type_Int == 1044) || (paramaunv.jdField_b_of_type_Int == 1049)) {
        anor.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localaywc, paramaunv.jdField_b_of_type_Int);
      }
      if (!paramauod.jdField_c_of_type_Boolean) {
        break label871;
      }
      try
      {
        if (!paramauod.jdField_d_of_type_Boolean) {
          break;
        }
        aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        aung.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramauod.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
      finally {}
    }
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
    aung.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramauod.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((paramauod.jdField_b_of_type_Boolean) && (!paramauod.jdField_c_of_type_Boolean))
      {
        aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        a((MessageRecord)localObject, paramauod.jdField_h_of_type_Long);
      }
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label871:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
    }
  }
  
  protected void a(aunv paramaunv, MessageRecord paramMessageRecord, auod paramauod)
  {
    if (paramaunv.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramaunv.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      paramaunv = paramaunv.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if (paramaunv.stickerInfo != null) {
        paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramaunv.stickerInfo.toJsonString());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sticker_info")))
      {
        EmojiStickerManager.a(paramMessageRecord, null);
        EmojiStickerManager.a().a(paramMessageRecord);
      }
    }
    if (((MessageForPic)paramMessageRecord).checkGif())
    {
      paramaunv = ((MessageForPic)paramMessageRecord).picExtraData;
      if (paramaunv != null) {
        break label233;
      }
      paramaunv = new PicMessageExtraData();
    }
    label233:
    for (;;)
    {
      if (TextUtils.isEmpty(paramaunv.textSummary)) {
        paramaunv.textSummary = BaseApplicationImpl.getApplication().getString(2131691289);
      }
      paramaunv.emojiPkgId = String.valueOf(paramauod.s);
      paramaunv.from = paramauod.jdField_r_of_type_Int;
      paramaunv.source = paramauod.n;
      paramaunv.webUrl = paramauod.o;
      paramaunv.iconUrl = paramauod.p;
      paramaunv.packageName = paramauod.q;
      ((MessageForPic)paramMessageRecord).picExtraData = paramaunv;
      if (!TextUtils.isEmpty(paramauod.jdField_r_of_type_JavaLangString))
      {
        PicMessageExtraData localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        paramaunv = localPicMessageExtraData;
        if (localPicMessageExtraData == null) {
          paramaunv = new PicMessageExtraData();
        }
        paramaunv.mTemplateId = paramauod.jdField_r_of_type_JavaLangString;
        ((MessageForPic)paramMessageRecord).picExtraData = paramaunv;
      }
      return;
    }
  }
  
  public void a(auon paramauon)
  {
    this.jdField_a_of_type_Auon = paramauon;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    awap localawap = (awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localawap.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localawap.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(ArrayList<aunp> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((aunp)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((aunp)paramArrayList.get(0));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    a();
  }
  
  protected boolean a(auod paramauod)
  {
    if (paramauod != null)
    {
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramauod);
      return paramauod.a();
    }
    aung.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  protected void b(aunv paramaunv)
  {
    auod localauod = paramaunv.jdField_a_of_type_Auod;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new BasePicOprerator.5(this, paramaunv, localauod), 8, null, false);
      return;
    }
    a(paramaunv, localauod);
  }
  
  public void b(auor paramauor)
  {
    if (paramauor == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aunv == null);
      if ((this.jdField_a_of_type_Aunv.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Aunv.jdField_a_of_type_Int == 4))
      {
        if (paramauor.jdField_a_of_type_Int == 0)
        {
          a(paramauor);
          localObject = (auob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
          if (localObject != null) {
            ((auob)localObject).a(13057, paramauor.jdField_a_of_type_Long);
          }
          localObject = new aunw();
          ((aunw)localObject).jdField_a_of_type_Int = 0;
          ((aunw)localObject).jdField_a_of_type_JavaLangObject = paramauor;
          a(3, (aunw)localObject);
          return;
        }
        localObject = new aunr();
        ((aunr)localObject).jdField_b_of_type_JavaLangString = paramauor.jdField_a_of_type_JavaLangString;
        a(3, (aunr)localObject);
        return;
      }
    } while (this.jdField_a_of_type_Aunv.jdField_a_of_type_Int != 3);
    if (paramauor.jdField_a_of_type_Int == 0)
    {
      a(paramauor);
      localObject = (auob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
      if (localObject != null) {
        ((auob)localObject).a(13058, paramauor.jdField_a_of_type_Long);
      }
      localObject = new aunw();
      ((aunw)localObject).jdField_a_of_type_Int = 0;
      ((aunw)localObject).jdField_a_of_type_JavaLangObject = paramauor;
      a(4, (aunw)localObject);
      return;
    }
    if (paramauor.jdField_b_of_type_Int == 9333)
    {
      this.jdField_a_of_type_Aunv.jdField_a_of_type_Aunp.jdField_a_of_type_Aunn.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Aunv.jdField_a_of_type_Aunp.jdField_a_of_type_Aunn.jdField_e_of_type_JavaLangString = "chatimg";
      if (this.jdField_a_of_type_Aunv.jdField_a_of_type_Aunp.jdField_a_of_type_Auod.l == 1) {}
      for (int i = 7;; i = 6)
      {
        aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramauor = aunl.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_Aunv.jdField_a_of_type_Aunp);
        paramauor.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Aunv.jdField_a_of_type_Aunp.jdField_a_of_type_Aunn);
        d(paramauor);
        return;
      }
    }
    Object localObject = new aunr();
    ((aunr)localObject).jdField_b_of_type_JavaLangString = paramauor.jdField_a_of_type_JavaLangString;
    ((aunr)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramauor.jdField_b_of_type_Int);
    a(4, (aunr)localObject);
  }
  
  public void c(aunv paramaunv)
  {
    aunp localaunp = paramaunv.jdField_a_of_type_Aunp;
    if (!a(localaunp))
    {
      a(4, localaunp.jdField_a_of_type_Aunr);
      return;
    }
    if (bbdx.b(localaunp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString))
    {
      localaunp.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localaunp);
      g(paramaunv);
      return;
    }
    if (localaunp.jdField_a_of_type_Auod.b())
    {
      File localFile = localaunp.jdField_a_of_type_Auod.a();
      if (localFile != null) {
        localaunp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString = localFile.toString();
      }
      localaunp.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localaunp);
      g(paramaunv);
      return;
    }
    localaunp.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localaunp);
    if ((localaunp.jdField_a_of_type_Auod.jdField_f_of_type_JavaLangString == null) || (localaunp.jdField_a_of_type_Auod.jdField_c_of_type_Long == 0L) || (localaunp.jdField_a_of_type_Auod.jdField_j_of_type_Int == 0) || (localaunp.jdField_a_of_type_Auod.k == 0))
    {
      localaunp.jdField_a_of_type_Aunn.jdField_a_of_type_Int = 3;
      localaunp.jdField_a_of_type_Aunn.jdField_e_of_type_JavaLangString = "chatimg";
      if (localaunp.jdField_a_of_type_Auod.l == 1) {}
      for (int i = 7;; i = 6)
      {
        paramaunv = aunl.a(i, 3);
        paramaunv.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localaunp.jdField_a_of_type_Aunn);
        d(paramaunv);
        return;
      }
    }
    f(paramaunv);
  }
  
  public void d(aunv paramaunv)
  {
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    aunn localaunn = paramaunv.jdField_a_of_type_Aunn;
    if (a(localaunn))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localaunn.jdField_a_of_type_Long);
      if (!localaunn.jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramaunv = a(localaunn, localaunn.jdField_e_of_type_JavaLangString);
        if (!new File(paramaunv.jdField_h_of_type_JavaLangString).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramaunv);
          return;
        }
        aunb localaunb = new aunb();
        localaunb.jdField_a_of_type_Int = 0;
        localaunb.jdField_b_of_type_JavaLangString = paramaunv.jdField_h_of_type_JavaLangString;
        localaunb.jdField_c_of_type_JavaLangString = paramaunv.jdField_f_of_type_JavaLangString;
        localaunb.jdField_c_of_type_Int = paramaunv.jdField_b_of_type_Int;
        localaunb.jdField_d_of_type_Int = localaunn.jdField_h_of_type_Int;
        a(localaunb);
        return;
      }
      e(paramaunv);
      return;
    }
    paramaunv = new aunb();
    paramaunv.jdField_a_of_type_Int = -1;
    paramaunv.jdField_a_of_type_Aunr = localaunn.jdField_a_of_type_Aunr;
    a(paramaunv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumr
 * JD-Core Version:    0.7.0.1
 */