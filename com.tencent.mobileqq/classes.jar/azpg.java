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

public abstract class azpg
  implements azpp, azpv, azqa, azrg
{
  protected static int c;
  protected Handler a;
  public azqk a;
  protected azrd a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public ArrayList<azql> a;
  protected int b;
  public String b;
  protected ArrayList<azqf> b;
  
  static
  {
    jdField_c_of_type_Int = 20;
  }
  
  public azpg() {}
  
  public azpg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new azph(this, Looper.getMainLooper());
    }
  }
  
  private beyg a(azqd paramazqd, String paramString)
  {
    paramazqd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_Boolean = false;
    localbeyg.jdField_a_of_type_Int = paramazqd.jdField_b_of_type_Int;
    boolean bool;
    if (paramazqd.jdField_e_of_type_Int == 1)
    {
      bool = true;
      localbeyg.jdField_b_of_type_Int = beyq.a(paramString, bool);
      localbeyg.jdField_a_of_type_Long = paramazqd.jdField_a_of_type_Long;
      localbeyg.jdField_b_of_type_Long = paramazqd.jdField_g_of_type_Int;
      localbeyg.jdField_b_of_type_JavaLangString = paramazqd.jdField_b_of_type_JavaLangString;
      localbeyg.jdField_c_of_type_JavaLangString = paramazqd.jdField_c_of_type_JavaLangString;
      localbeyg.jdField_e_of_type_JavaLangString = paramazqd.jdField_g_of_type_JavaLangString;
      localbeyg.jdField_i_of_type_JavaLangString = null;
      localbeyg.jdField_a_of_type_Azpp = this;
      localbeyg.jdField_d_of_type_Boolean = false;
      localbeyg.n = paramazqd.jdField_d_of_type_Boolean;
      localbeyg.jdField_h_of_type_JavaLangString = paramazqd.c();
      if ((this.jdField_a_of_type_Azqk != null) && (this.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localbeyg.jdField_h_of_type_JavaLangString + "info.protocol:" + paramazqd.jdField_e_of_type_JavaLangString);
      paramString = new beyj();
      localbeyg.jdField_a_of_type_JavaLangObject = paramString;
      if (localbeyg.jdField_b_of_type_Int != 65537) {
        break label385;
      }
      if (paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_d_of_type_Int = paramazqd.jdField_h_of_type_Int;
        paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Int = azqi.a();
        paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 1;
      }
      if (!bdku.a()) {
        break label374;
      }
      paramString.jdField_a_of_type_JavaLangString = paramazqd.jdField_k_of_type_JavaLangString;
    }
    for (;;)
    {
      localbeyg.jdField_f_of_type_JavaLangString = paramazqd.jdField_f_of_type_JavaLangString;
      localbeyg.jdField_c_of_type_Long = paramazqd.jdField_b_of_type_Long;
      localbeyg.jdField_d_of_type_Int = paramazqd.jdField_d_of_type_Int;
      localbeyg.jdField_e_of_type_Int = paramazqd.jdField_a_of_type_Int;
      localbeyg.jdField_g_of_type_Boolean = true;
      localbeyg.jdField_g_of_type_Int = paramazqd.jdField_h_of_type_Int;
      localbeyg.jdField_d_of_type_Long = paramazqd.jdField_c_of_type_Long;
      return localbeyg;
      bool = false;
      break;
      label374:
      paramString.jdField_a_of_type_JavaLangString = paramazqd.jdField_h_of_type_JavaLangString;
      continue;
      label385:
      if (localbeyg.jdField_b_of_type_Int == 1)
      {
        paramString.jdField_a_of_type_JavaLangString = paramazqd.jdField_i_of_type_JavaLangString;
        if (paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramazqd.jdField_h_of_type_Int;
          paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = azqi.a();
          paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
      else if (localbeyg.jdField_b_of_type_Int == 131075)
      {
        paramString.jdField_a_of_type_JavaLangString = paramazqd.j;
        if (paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramazqd.jdField_h_of_type_Int;
          paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = azqi.a();
          paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramazqd.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
    }
  }
  
  private void a(azqk paramazqk, long paramLong)
  {
    long l;
    Map localMap;
    if (paramazqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      l = paramazqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramazqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) {
        break label108;
      }
      localMap = paramazqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramazqk);; localInteger1 = Integer.valueOf(paramazqk.jdField_c_of_type_Int))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        agsg.a().a(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(azqd paramazqd)
  {
    if (paramazqd != null)
    {
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramazqd);
      return paramazqd.a();
    }
    azpw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(azqf paramazqf)
  {
    if (paramazqf != null)
    {
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramazqf);
      return paramazqf.a();
    }
    azpw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b(azpq paramazpq)
  {
    MessageForPic localMessageForPic;
    if ((paramazpq != null) && (this.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramazpq.jdField_b_of_type_JavaLangString != null))
    {
      localMessageForPic = this.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      paramazpq = new File(paramazpq.jdField_b_of_type_JavaLangString);
      if ((localMessageForPic.imageType != 2000) && (GifDrawable.isGifFile(paramazpq)))
      {
        localMessageForPic.imageType = 2000;
        localMessageForPic.serial();
        if (localMessageForPic.subMsgId != MessageForPic.defaultSuMsgId) {
          break label235;
        }
        paramazpq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
        if (!(paramazpq instanceof MessageForStructing)) {
          break label191;
        }
        paramazpq = (MessageForStructing)paramazpq;
        if ((paramazpq.structingMsg instanceof StructMsgForImageShare))
        {
          bdqr localbdqr = ((StructMsgForImageShare)paramazpq.structingMsg).getFirstImageElement();
          if (localbdqr != null)
          {
            azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
            localbdqr.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = localMessageForPic;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, paramazpq.structingMsg.getBytes());
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
        azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, localMessageForPic.msgData);
        return;
        paramazpq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
      } while (!(paramazpq instanceof MessageForMixedMsg));
      paramazpq = ((MessageForMixedMsg)paramazpq).upateMessageForPic(localMessageForPic);
    } while (paramazpq == null);
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, paramazpq);
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
      Object localObject = beyq.a(paramMessageForPic.md5, i);
      if (localObject != null) {}
      for (localObject = ((URL)localObject).toString(); !beqz.b((String)localObject); localObject = null)
      {
        localObject = beqz.d((String)localObject);
        bhmi.d(paramMessageForPic.path, (String)localObject);
        return;
      }
    }
  }
  
  private void c(azpq paramazpq)
  {
    ThreadManager.getFileThreadHandler().post(new BasePicOprerator.4(this, paramazpq));
  }
  
  private void e(azqk paramazqk)
  {
    int i = 0;
    azqd localazqd = paramazqk.jdField_a_of_type_Azqd;
    if (!a(localazqd))
    {
      paramazqk = new azpq();
      paramazqk.jdField_a_of_type_Int = -1;
      paramazqk.jdField_a_of_type_Azqh = localazqd.jdField_a_of_type_Azqh;
      a(paramazqk);
    }
    String str;
    label457:
    do
    {
      MessageForPic localMessageForPic;
      int j;
      beyg localbeyg;
      long l;
      do
      {
        return;
        localMessageForPic = paramazqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        j = paramazqk.jdField_d_of_type_Int;
        localbeyg = a(localazqd, localazqd.jdField_e_of_type_JavaLangString);
        str = localbeyg.jdField_h_of_type_JavaLangString;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramazqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
          break;
        }
        paramazqk = new azpq();
        paramazqk.jdField_a_of_type_Int = 0;
        paramazqk.jdField_b_of_type_JavaLangString = localbeyg.jdField_h_of_type_JavaLangString;
        paramazqk.jdField_c_of_type_JavaLangString = localbeyg.jdField_f_of_type_JavaLangString;
        paramazqk.jdField_c_of_type_Int = localbeyg.jdField_b_of_type_Int;
        paramazqk.jdField_d_of_type_Int = localazqd.jdField_h_of_type_Int;
        paramazqk.jdField_a_of_type_Boolean = true;
        a(paramazqk);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localbeyg.jdField_i_of_type_Int = 0;
        if (localMessageForPic.mDownloadLength == paramazqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
        {
          localbeyg.jdField_j_of_type_Int = 0;
          localStringBuilder.append("nofile:");
        }
      }
      for (;;)
      {
        localStringBuilder.append("mRequestOffset is " + localbeyg.jdField_i_of_type_Int + ", mRequestLength is " + localbeyg.jdField_j_of_type_Int + ", ");
        localStringBuilder.append("outPath is " + str);
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
        }
        localbeyg.jdField_k_of_type_Int = localMessageForPic.mShowLength;
        localbeyg.m = localazqd.d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localbeyg);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localbeyg.jdField_j_of_type_Int = i;
        break;
        if (l >= paramazqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
          break label457;
        }
        localbeyg.jdField_i_of_type_Int = localMessageForPic.mDownloadLength;
        localbeyg.jdField_j_of_type_Int = 0;
        localStringBuilder.append("part1:");
      }
      paramazqk = new azpq();
      paramazqk.jdField_a_of_type_Int = 0;
      paramazqk.jdField_b_of_type_JavaLangString = localbeyg.jdField_h_of_type_JavaLangString;
      paramazqk.jdField_c_of_type_JavaLangString = localbeyg.jdField_f_of_type_JavaLangString;
      paramazqk.jdField_c_of_type_Int = localbeyg.jdField_b_of_type_Int;
      paramazqk.jdField_d_of_type_Int = localazqd.jdField_h_of_type_Int;
      paramazqk.jdField_a_of_type_Boolean = false;
      a(paramazqk);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void f(azqk paramazqk)
  {
    ThreadManager.post(new BasePicOprerator.2(this, paramazqk.jdField_a_of_type_Azqf, paramazqk), 8, null, true);
  }
  
  private void g(azqk paramazqk)
  {
    ThreadManager.post(new BasePicOprerator.3(this, paramazqk), 8, null, true);
  }
  
  public beyn a(azqd paramazqd, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramazqd))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramazqd.jdField_a_of_type_Long);
      beyb localbeyb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramazqd.jdField_e_of_type_JavaLangString = paramString;
      paramazqd = a(paramazqd, paramString);
      paramazqd.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramazqd.jdField_a_of_type_JavaLangObject != null) && ((paramazqd.jdField_a_of_type_JavaLangObject instanceof beyj))) {
        ((beyj)paramazqd.jdField_a_of_type_JavaLangObject).jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      }
      return localbeyb.a(paramazqd);
    }
    paramURLDrawableHandler = new azpq();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Azqh = paramazqd.jdField_a_of_type_Azqh;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new beyn();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Long = 9302L;
    if (paramazqd.jdField_a_of_type_Azqh != null)
    {
      paramURLDrawableHandler.jdField_a_of_type_JavaLangString = ("downloadPicSync," + paramazqd.jdField_a_of_type_Azqh.jdField_b_of_type_JavaLangString);
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
      new azpi(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
  
  public void a(int paramInt, azqh paramazqh)
  {
    azql localazql = new azql();
    localazql.jdField_a_of_type_Azqk = this.jdField_a_of_type_Azqk;
    localazql.jdField_a_of_type_Azqh = paramazqh;
    localazql.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localazql);
    if (paramazqh != null)
    {
      azpw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramazqh.jdField_a_of_type_JavaLangString, paramazqh.jdField_b_of_type_JavaLangString);
      return;
    }
    azpw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, azql paramazql)
  {
    azql localazql = paramazql;
    if (paramazql == null) {
      localazql = new azql();
    }
    localazql.jdField_a_of_type_Int = 0;
    localazql.jdField_a_of_type_Azqk = this.jdField_a_of_type_Azqk;
    a(paramInt, 0, localazql);
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    azql localazql = new azql();
    localazql.jdField_a_of_type_Int = 0;
    localazql.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localazql.jdField_c_of_type_Boolean = paramBoolean;
    a(1, 0, localazql);
  }
  
  public void a(azpq paramazpq)
  {
    if (this.jdField_a_of_type_Azqk != null)
    {
      b(paramazpq);
      c(paramazpq);
      if (paramazpq != null) {
        break label50;
      }
      paramazpq = new azqh();
      paramazpq.jdField_b_of_type_JavaLangString = "result == null";
      paramazpq.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramazpq);
    }
    for (;;)
    {
      return;
      label50:
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramazpq.jdField_a_of_type_Int);
      Object localObject = new azql();
      ((azql)localObject).jdField_a_of_type_Int = paramazpq.jdField_a_of_type_Int;
      ((azql)localObject).jdField_a_of_type_JavaLangObject = paramazpq;
      ((azql)localObject).jdField_a_of_type_Boolean = paramazpq.jdField_a_of_type_Boolean;
      if (paramazpq.jdField_a_of_type_Int == 0) {
        a(0, (azql)localObject);
      }
      while (this.jdField_a_of_type_Azqk.jdField_a_of_type_Int == 3)
      {
        if (paramazpq.jdField_a_of_type_Int != 0) {
          break label267;
        }
        this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString = paramazpq.jdField_b_of_type_JavaLangString;
        azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "dowanload pic success,is to forward the pic");
        g(this.jdField_a_of_type_Azqk);
        return;
        if (paramazpq.jdField_a_of_type_Azqh == null)
        {
          localObject = new azqh();
          ((azqh)localObject).jdField_b_of_type_JavaLangString = (paramazpq.jdField_b_of_type_Int + "_" + paramazpq.jdField_a_of_type_JavaLangString);
          ((azqh)localObject).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (azqh)localObject);
        }
        else
        {
          a(0, paramazpq.jdField_a_of_type_Azqh);
        }
      }
    }
    label267:
    a(4, this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqf.jdField_a_of_type_Azqh);
  }
  
  public void a(azqk paramazqk)
  {
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramazqk.jdField_a_of_type_Azqt))
    {
      b(paramazqk);
      return;
    }
    a(3, paramazqk.jdField_a_of_type_Azqt.jdField_a_of_type_Azqh);
  }
  
  public void a(azqk paramazqk, azqt paramazqt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    Object localObject = new CompressInfo(paramazqt.jdField_g_of_type_JavaLangString, 0);
    azrm.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramazqt.jdField_h_of_type_JavaLangString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramazqt.jdField_e_of_type_Int = ((CompressInfo)localObject).jdField_d_of_type_Int;
      paramazqt.jdField_f_of_type_Int = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    if ((paramazqt.jdField_g_of_type_Boolean) && (paramazqt.jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject = (MessageForPic)paramazqt.jdField_b_of_type_JavaLangObject; localObject == null; localObject = a(paramazqt))
    {
      azpw.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject).msgVia);
    }
    agsg.a().a(((MessageRecord)localObject).uniseq, 0L, paramazqk.jdField_c_of_type_Int);
    if (MessageForPic.class.isInstance(localObject))
    {
      a(paramazqk, (MessageRecord)localObject, paramazqt);
      b((MessageForPic)localObject);
    }
    if ((((MessageRecord)localObject).istroop == 1) && (paramazqt.jdField_a_of_type_Azqv == null)) {
      nlj.a().a((MessageRecord)localObject);
    }
    if (paramazqt.jdField_c_of_type_Boolean) {
      try
      {
        paramazqt.jdField_a_of_type_JavaLangObject = localObject;
        paramazqt.notifyAll();
        azpw.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramazqt.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (paramazqt.jdField_c_of_type_Int == 3)
        {
          azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          azpw.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + paramazqt.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    paramazqk = new beyg();
    paramazqk.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    paramazqk.jdField_c_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
    paramazqk.jdField_d_of_type_JavaLangString = ((MessageRecord)localObject).senderuin;
    paramazqk.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    paramazqk.jdField_b_of_type_Int = 1;
    paramazqk.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
    paramazqk.jdField_a_of_type_Boolean = true;
    paramazqk.jdField_e_of_type_Int = paramazqt.jdField_a_of_type_Int;
    paramazqk.jdField_i_of_type_JavaLangString = paramazqt.jdField_g_of_type_JavaLangString;
    paramazqk.jdField_f_of_type_JavaLangString = paramazqt.jdField_f_of_type_JavaLangString;
    beyk localbeyk = new beyk();
    if (paramazqt.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localbeyk.jdField_a_of_type_Boolean = bool;
      paramazqk.jdField_a_of_type_JavaLangObject = localbeyk;
      paramazqk.jdField_a_of_type_Azrg = this;
      paramazqk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      paramazqk.jdField_j_of_type_Boolean = paramazqt.jdField_c_of_type_Boolean;
      paramazqk.jdField_k_of_type_Boolean = paramazqt.jdField_e_of_type_Boolean;
      if (!paramazqt.jdField_c_of_type_Boolean) {
        break label821;
      }
      try
      {
        if (!paramazqt.jdField_d_of_type_Boolean) {
          break;
        }
        azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        azpw.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramazqt.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
      finally {}
    }
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramazqk);
    azpw.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramazqt.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((paramazqt.jdField_b_of_type_Boolean) && (!paramazqt.jdField_c_of_type_Boolean))
      {
        azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        a((MessageRecord)localObject, paramazqt.jdField_g_of_type_Long);
      }
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label821:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramazqk);
    }
  }
  
  protected void a(azqk paramazqk, MessageRecord paramMessageRecord, azqt paramazqt)
  {
    if (paramazqk.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramazqk.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      paramazqk = paramazqk.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if (paramazqk.stickerInfo != null) {
        paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramazqk.stickerInfo.toJsonString());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sticker_info")))
      {
        EmojiStickerManager.a(paramMessageRecord, null);
        EmojiStickerManager.a().a(paramMessageRecord);
      }
    }
    if (((MessageForPic)paramMessageRecord).checkGif())
    {
      paramazqk = ((MessageForPic)paramMessageRecord).picExtraData;
      if (paramazqk != null) {
        break label257;
      }
      paramazqk = new PicMessageExtraData();
    }
    label257:
    for (;;)
    {
      if (TextUtils.isEmpty(paramazqk.textSummary)) {
        paramazqk.textSummary = BaseApplicationImpl.getApplication().getString(2131691126);
      }
      paramazqk.emojiPkgId = String.valueOf(paramazqt.s);
      paramazqk.from = paramazqt.r;
      paramazqk.source = paramazqt.jdField_k_of_type_JavaLangString;
      paramazqk.webUrl = paramazqt.jdField_l_of_type_JavaLangString;
      paramazqk.iconUrl = paramazqt.m;
      paramazqk.packageName = paramazqt.n;
      ((MessageForPic)paramMessageRecord).picExtraData = paramazqk;
      if ((paramazqt.jdField_a_of_type_Azqs != null) && (!TextUtils.isEmpty(paramazqt.jdField_a_of_type_Azqs.jdField_a_of_type_JavaLangString)))
      {
        PicMessageExtraData localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        paramazqk = localPicMessageExtraData;
        if (localPicMessageExtraData == null) {
          paramazqk = new PicMessageExtraData();
        }
        paramazqk.mTemplateId = paramazqt.jdField_a_of_type_Azqs.jdField_a_of_type_JavaLangString;
        paramazqk.mTemplateName = paramazqt.jdField_a_of_type_Azqs.jdField_b_of_type_JavaLangString;
        ((MessageForPic)paramMessageRecord).picExtraData = paramazqk;
      }
      return;
    }
  }
  
  public void a(azrd paramazrd)
  {
    this.jdField_a_of_type_Azrd = paramazrd;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    bbnr localbbnr = (bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localbbnr.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localbbnr.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(ArrayList<azqf> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((azqf)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((azqf)paramArrayList.get(0));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    a();
  }
  
  protected boolean a(azqt paramazqt)
  {
    if (paramazqt != null)
    {
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramazqt);
      return paramazqt.a();
    }
    azpw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  protected void b(azqk paramazqk)
  {
    azqt localazqt = paramazqk.jdField_a_of_type_Azqt;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new BasePicOprerator.5(this, paramazqk, localazqt), 8, null, false);
      return;
    }
    a(paramazqk, localazqt);
  }
  
  public void b(azrh paramazrh)
  {
    if (paramazrh == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Azqk == null);
      if ((this.jdField_a_of_type_Azqk.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Azqk.jdField_a_of_type_Int == 4))
      {
        if (paramazrh.jdField_a_of_type_Int == 0)
        {
          a(paramazrh);
          localObject = (azqq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
          if (localObject != null) {
            ((azqq)localObject).a(13057, paramazrh.jdField_a_of_type_Long);
          }
          localObject = new azql();
          ((azql)localObject).jdField_a_of_type_Int = 0;
          ((azql)localObject).jdField_a_of_type_JavaLangObject = paramazrh;
          a(3, (azql)localObject);
          return;
        }
        localObject = new azqh();
        ((azqh)localObject).jdField_b_of_type_JavaLangString = paramazrh.jdField_a_of_type_JavaLangString;
        a(3, (azqh)localObject);
        return;
      }
    } while (this.jdField_a_of_type_Azqk.jdField_a_of_type_Int != 3);
    if (paramazrh.jdField_a_of_type_Int == 0)
    {
      a(paramazrh);
      localObject = (azqq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
      if (localObject != null) {
        ((azqq)localObject).a(13058, paramazrh.jdField_a_of_type_Long);
      }
      localObject = new azql();
      ((azql)localObject).jdField_a_of_type_Int = 0;
      ((azql)localObject).jdField_a_of_type_JavaLangObject = paramazrh;
      a(4, (azql)localObject);
      return;
    }
    if (paramazrh.jdField_b_of_type_Int == 9333)
    {
      this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqf.jdField_a_of_type_Azqd.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqf.jdField_a_of_type_Azqd.jdField_e_of_type_JavaLangString = "chatimg";
      if (this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqf.jdField_a_of_type_Azqt.jdField_l_of_type_Int == 1) {}
      for (int i = 7;; i = 6)
      {
        azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramazrh = azqb.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqf);
        paramazrh.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqf.jdField_a_of_type_Azqd);
        d(paramazrh);
        return;
      }
    }
    Object localObject = new azqh();
    ((azqh)localObject).jdField_b_of_type_JavaLangString = paramazrh.jdField_a_of_type_JavaLangString;
    ((azqh)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramazrh.jdField_b_of_type_Int);
    a(4, (azqh)localObject);
  }
  
  public void c(azqk paramazqk)
  {
    azqf localazqf = paramazqk.jdField_a_of_type_Azqf;
    if (!a(localazqf))
    {
      a(4, localazqf.jdField_a_of_type_Azqh);
      return;
    }
    if (bhmi.b(localazqf.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString))
    {
      localazqf.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localazqf);
      g(paramazqk);
      return;
    }
    if (localazqf.jdField_a_of_type_Azqt.b())
    {
      File localFile = localazqf.jdField_a_of_type_Azqt.a();
      if (localFile != null) {
        localazqf.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString = localFile.toString();
      }
      localazqf.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localazqf);
      g(paramazqk);
      return;
    }
    localazqf.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localazqf);
    if ((localazqf.jdField_a_of_type_Azqt.jdField_f_of_type_JavaLangString == null) || (localazqf.jdField_a_of_type_Azqt.jdField_c_of_type_Long == 0L) || (localazqf.jdField_a_of_type_Azqt.jdField_j_of_type_Int == 0) || (localazqf.jdField_a_of_type_Azqt.jdField_k_of_type_Int == 0))
    {
      localazqf.jdField_a_of_type_Azqd.jdField_a_of_type_Int = 3;
      localazqf.jdField_a_of_type_Azqd.jdField_e_of_type_JavaLangString = "chatimg";
      if (localazqf.jdField_a_of_type_Azqt.jdField_l_of_type_Int == 1) {}
      for (int i = 7;; i = 6)
      {
        paramazqk = azqb.a(i, 3);
        paramazqk.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localazqf.jdField_a_of_type_Azqd);
        d(paramazqk);
        return;
      }
    }
    f(paramazqk);
  }
  
  public void d(azqk paramazqk)
  {
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    azqd localazqd = paramazqk.jdField_a_of_type_Azqd;
    if (a(localazqd))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localazqd.jdField_a_of_type_Long);
      if (!localazqd.jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramazqk = a(localazqd, localazqd.jdField_e_of_type_JavaLangString);
        if (!new File(paramazqk.jdField_h_of_type_JavaLangString).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramazqk);
          return;
        }
        azpq localazpq = new azpq();
        localazpq.jdField_a_of_type_Int = 0;
        localazpq.jdField_b_of_type_JavaLangString = paramazqk.jdField_h_of_type_JavaLangString;
        localazpq.jdField_c_of_type_JavaLangString = paramazqk.jdField_f_of_type_JavaLangString;
        localazpq.jdField_c_of_type_Int = paramazqk.jdField_b_of_type_Int;
        localazpq.jdField_d_of_type_Int = localazqd.jdField_h_of_type_Int;
        a(localazpq);
        return;
      }
      e(paramazqk);
      return;
    }
    paramazqk = new azpq();
    paramazqk.jdField_a_of_type_Int = -1;
    paramazqk.jdField_a_of_type_Azqh = localazqd.jdField_a_of_type_Azqh;
    a(paramazqk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpg
 * JD-Core Version:    0.7.0.1
 */