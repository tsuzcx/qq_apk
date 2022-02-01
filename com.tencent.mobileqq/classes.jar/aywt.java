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

public abstract class aywt
  implements ayxc, ayxh, ayxm, ayyt
{
  protected static int c;
  protected Handler a;
  public ayxx a;
  protected ayyq a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public ArrayList<ayxy> a;
  protected int b;
  public String b;
  protected ArrayList<ayxr> b;
  
  static
  {
    jdField_c_of_type_Int = 20;
  }
  
  public aywt() {}
  
  public aywt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new aywu(this, Looper.getMainLooper());
    }
  }
  
  private bdzn a(ayxp paramayxp, String paramString)
  {
    paramayxp.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_a_of_type_Boolean = false;
    localbdzn.jdField_a_of_type_Int = paramayxp.jdField_b_of_type_Int;
    boolean bool;
    if (paramayxp.jdField_e_of_type_Int == 1)
    {
      bool = true;
      localbdzn.jdField_b_of_type_Int = bdzx.a(paramString, bool);
      localbdzn.jdField_a_of_type_Long = paramayxp.jdField_a_of_type_Long;
      localbdzn.jdField_b_of_type_Long = paramayxp.jdField_g_of_type_Int;
      localbdzn.jdField_b_of_type_JavaLangString = paramayxp.jdField_b_of_type_JavaLangString;
      localbdzn.jdField_c_of_type_JavaLangString = paramayxp.jdField_c_of_type_JavaLangString;
      localbdzn.jdField_e_of_type_JavaLangString = paramayxp.jdField_g_of_type_JavaLangString;
      localbdzn.jdField_i_of_type_JavaLangString = null;
      localbdzn.jdField_a_of_type_Ayxc = this;
      localbdzn.jdField_c_of_type_Boolean = false;
      localbdzn.jdField_m_of_type_Boolean = paramayxp.jdField_d_of_type_Boolean;
      localbdzn.jdField_h_of_type_JavaLangString = paramayxp.c();
      if ((this.jdField_a_of_type_Ayxx != null) && (this.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localbdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localbdzn.jdField_h_of_type_JavaLangString + "info.protocol:" + paramayxp.jdField_e_of_type_JavaLangString);
      paramString = new bdzq();
      localbdzn.jdField_a_of_type_JavaLangObject = paramString;
      if (localbdzn.jdField_b_of_type_Int != 65537) {
        break label385;
      }
      if (paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_d_of_type_Int = paramayxp.jdField_h_of_type_Int;
        paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Int = ayxu.a();
        paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 1;
      }
      if (!bcsc.a()) {
        break label374;
      }
      paramString.jdField_a_of_type_JavaLangString = paramayxp.jdField_k_of_type_JavaLangString;
    }
    for (;;)
    {
      localbdzn.jdField_f_of_type_JavaLangString = paramayxp.jdField_f_of_type_JavaLangString;
      localbdzn.jdField_c_of_type_Long = paramayxp.jdField_b_of_type_Long;
      localbdzn.jdField_d_of_type_Int = paramayxp.jdField_d_of_type_Int;
      localbdzn.jdField_e_of_type_Int = paramayxp.jdField_a_of_type_Int;
      localbdzn.jdField_f_of_type_Boolean = true;
      localbdzn.jdField_g_of_type_Int = paramayxp.jdField_h_of_type_Int;
      localbdzn.jdField_d_of_type_Long = paramayxp.jdField_c_of_type_Long;
      return localbdzn;
      bool = false;
      break;
      label374:
      paramString.jdField_a_of_type_JavaLangString = paramayxp.jdField_h_of_type_JavaLangString;
      continue;
      label385:
      if (localbdzn.jdField_b_of_type_Int == 1)
      {
        paramString.jdField_a_of_type_JavaLangString = paramayxp.jdField_i_of_type_JavaLangString;
        if (paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramayxp.jdField_h_of_type_Int;
          paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = ayxu.a();
          paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
      else if (localbdzn.jdField_b_of_type_Int == 131075)
      {
        paramString.jdField_a_of_type_JavaLangString = paramayxp.j;
        if (paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = paramayxp.jdField_h_of_type_Int;
          paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_f_of_type_Int = ayxu.a();
          paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramayxp.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Int = 2;
        }
      }
    }
  }
  
  private void a(ayxx paramayxx, long paramLong)
  {
    long l;
    Map localMap;
    if (paramayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      l = paramayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) {
        break label108;
      }
      localMap = paramayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramayxx);; localInteger1 = Integer.valueOf(paramayxx.jdField_c_of_type_Int))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        agjf.a().a(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(ayxp paramayxp)
  {
    if (paramayxp != null)
    {
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramayxp);
      return paramayxp.a();
    }
    ayxi.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(ayxr paramayxr)
  {
    if (paramayxr != null)
    {
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramayxr);
      return paramayxr.a();
    }
    ayxi.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b(ayxd paramayxd)
  {
    MessageForPic localMessageForPic;
    if ((paramayxd != null) && (this.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramayxd.jdField_b_of_type_JavaLangString != null))
    {
      localMessageForPic = this.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      paramayxd = new File(paramayxd.jdField_b_of_type_JavaLangString);
      if ((localMessageForPic.imageType != 2000) && (GifDrawable.isGifFile(paramayxd)))
      {
        localMessageForPic.imageType = 2000;
        localMessageForPic.serial();
        if (localMessageForPic.subMsgId != MessageForPic.defaultSuMsgId) {
          break label235;
        }
        paramayxd = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
        if (!(paramayxd instanceof MessageForStructing)) {
          break label191;
        }
        paramayxd = (MessageForStructing)paramayxd;
        if ((paramayxd.structingMsg instanceof StructMsgForImageShare))
        {
          bcxy localbcxy = ((StructMsgForImageShare)paramayxd.structingMsg).getFirstImageElement();
          if (localbcxy != null)
          {
            ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
            localbcxy.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = localMessageForPic;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, paramayxd.structingMsg.getBytes());
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
        ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, localMessageForPic.msgData);
        return;
        paramayxd = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
      } while (!(paramayxd instanceof MessageForMixedMsg));
      paramayxd = ((MessageForMixedMsg)paramayxd).upateMessageForPic(localMessageForPic);
    } while (paramayxd == null);
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, paramayxd);
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
      Object localObject = bdzx.a(paramMessageForPic.md5, i);
      if (localObject != null) {}
      for (localObject = ((URL)localObject).toString(); !bdsh.b((String)localObject); localObject = null)
      {
        localObject = bdsh.d((String)localObject);
        bgmg.d(paramMessageForPic.path, (String)localObject);
        return;
      }
    }
  }
  
  private void c(ayxd paramayxd)
  {
    ThreadManager.getFileThreadHandler().post(new BasePicOprerator.4(this, paramayxd));
  }
  
  private void e(ayxx paramayxx)
  {
    int i = 0;
    ayxp localayxp = paramayxx.jdField_a_of_type_Ayxp;
    if (!a(localayxp))
    {
      paramayxx = new ayxd();
      paramayxx.jdField_a_of_type_Int = -1;
      paramayxx.jdField_a_of_type_Ayxt = localayxp.jdField_a_of_type_Ayxt;
      a(paramayxx);
    }
    String str;
    label457:
    do
    {
      MessageForPic localMessageForPic;
      int j;
      bdzn localbdzn;
      long l;
      do
      {
        return;
        localMessageForPic = paramayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        j = paramayxx.jdField_d_of_type_Int;
        localbdzn = a(localayxp, localayxp.jdField_e_of_type_JavaLangString);
        str = localbdzn.jdField_h_of_type_JavaLangString;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
          break;
        }
        paramayxx = new ayxd();
        paramayxx.jdField_a_of_type_Int = 0;
        paramayxx.jdField_b_of_type_JavaLangString = localbdzn.jdField_h_of_type_JavaLangString;
        paramayxx.jdField_c_of_type_JavaLangString = localbdzn.jdField_f_of_type_JavaLangString;
        paramayxx.jdField_c_of_type_Int = localbdzn.jdField_b_of_type_Int;
        paramayxx.jdField_d_of_type_Int = localayxp.jdField_h_of_type_Int;
        paramayxx.jdField_a_of_type_Boolean = true;
        a(paramayxx);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localbdzn.jdField_i_of_type_Int = 0;
        if (localMessageForPic.mDownloadLength == paramayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
        {
          localbdzn.jdField_j_of_type_Int = 0;
          localStringBuilder.append("nofile:");
        }
      }
      for (;;)
      {
        localStringBuilder.append("mRequestOffset is " + localbdzn.jdField_i_of_type_Int + ", mRequestLength is " + localbdzn.jdField_j_of_type_Int + ", ");
        localStringBuilder.append("outPath is " + str);
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
        }
        localbdzn.jdField_k_of_type_Int = localMessageForPic.mShowLength;
        localbdzn.jdField_m_of_type_JavaLangString = localayxp.d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localbdzn);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localbdzn.jdField_j_of_type_Int = i;
        break;
        if (l >= paramayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
          break label457;
        }
        localbdzn.jdField_i_of_type_Int = localMessageForPic.mDownloadLength;
        localbdzn.jdField_j_of_type_Int = 0;
        localStringBuilder.append("part1:");
      }
      paramayxx = new ayxd();
      paramayxx.jdField_a_of_type_Int = 0;
      paramayxx.jdField_b_of_type_JavaLangString = localbdzn.jdField_h_of_type_JavaLangString;
      paramayxx.jdField_c_of_type_JavaLangString = localbdzn.jdField_f_of_type_JavaLangString;
      paramayxx.jdField_c_of_type_Int = localbdzn.jdField_b_of_type_Int;
      paramayxx.jdField_d_of_type_Int = localayxp.jdField_h_of_type_Int;
      paramayxx.jdField_a_of_type_Boolean = false;
      a(paramayxx);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void f(ayxx paramayxx)
  {
    ThreadManager.post(new BasePicOprerator.2(this, paramayxx.jdField_a_of_type_Ayxr, paramayxx), 8, null, true);
  }
  
  private void g(ayxx paramayxx)
  {
    ThreadManager.post(new BasePicOprerator.3(this, paramayxx), 8, null, true);
  }
  
  public bdzu a(ayxp paramayxp, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramayxp))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramayxp.jdField_a_of_type_Long);
      bdzi localbdzi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramayxp.jdField_e_of_type_JavaLangString = paramString;
      paramayxp = a(paramayxp, paramString);
      paramayxp.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramayxp.jdField_a_of_type_JavaLangObject != null) && ((paramayxp.jdField_a_of_type_JavaLangObject instanceof bdzq))) {
        ((bdzq)paramayxp.jdField_a_of_type_JavaLangObject).jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      }
      return localbdzi.a(paramayxp);
    }
    paramURLDrawableHandler = new ayxd();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Ayxt = paramayxp.jdField_a_of_type_Ayxt;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new bdzu();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Long = 9302L;
    if (paramayxp.jdField_a_of_type_Ayxt != null)
    {
      paramURLDrawableHandler.jdField_a_of_type_JavaLangString = ("downloadPicSync," + paramayxp.jdField_a_of_type_Ayxt.jdField_b_of_type_JavaLangString);
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
      new aywv(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
  
  public void a(int paramInt, ayxt paramayxt)
  {
    ayxy localayxy = new ayxy();
    localayxy.jdField_a_of_type_Ayxx = this.jdField_a_of_type_Ayxx;
    localayxy.jdField_a_of_type_Ayxt = paramayxt;
    localayxy.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localayxy);
    if (paramayxt != null)
    {
      ayxi.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramayxt.jdField_a_of_type_JavaLangString, paramayxt.jdField_b_of_type_JavaLangString);
      return;
    }
    ayxi.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, ayxy paramayxy)
  {
    ayxy localayxy = paramayxy;
    if (paramayxy == null) {
      localayxy = new ayxy();
    }
    localayxy.jdField_a_of_type_Int = 0;
    localayxy.jdField_a_of_type_Ayxx = this.jdField_a_of_type_Ayxx;
    a(paramInt, 0, localayxy);
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ayxy localayxy = new ayxy();
    localayxy.jdField_a_of_type_Int = 0;
    localayxy.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localayxy.jdField_c_of_type_Boolean = paramBoolean;
    a(1, 0, localayxy);
  }
  
  public void a(ayxd paramayxd)
  {
    if (this.jdField_a_of_type_Ayxx != null)
    {
      b(paramayxd);
      c(paramayxd);
      if (paramayxd != null) {
        break label50;
      }
      paramayxd = new ayxt();
      paramayxd.jdField_b_of_type_JavaLangString = "result == null";
      paramayxd.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramayxd);
    }
    for (;;)
    {
      return;
      label50:
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramayxd.jdField_a_of_type_Int);
      Object localObject = new ayxy();
      ((ayxy)localObject).jdField_a_of_type_Int = paramayxd.jdField_a_of_type_Int;
      ((ayxy)localObject).jdField_a_of_type_JavaLangObject = paramayxd;
      ((ayxy)localObject).jdField_a_of_type_Boolean = paramayxd.jdField_a_of_type_Boolean;
      if (paramayxd.jdField_a_of_type_Int == 0) {
        a(0, (ayxy)localObject);
      }
      while (this.jdField_a_of_type_Ayxx.jdField_a_of_type_Int == 3)
      {
        if (paramayxd.jdField_a_of_type_Int != 0) {
          break label267;
        }
        this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString = paramayxd.jdField_b_of_type_JavaLangString;
        ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "dowanload pic success,is to forward the pic");
        g(this.jdField_a_of_type_Ayxx);
        return;
        if (paramayxd.jdField_a_of_type_Ayxt == null)
        {
          localObject = new ayxt();
          ((ayxt)localObject).jdField_b_of_type_JavaLangString = (paramayxd.jdField_b_of_type_Int + "_" + paramayxd.jdField_a_of_type_JavaLangString);
          ((ayxt)localObject).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (ayxt)localObject);
        }
        else
        {
          a(0, paramayxd.jdField_a_of_type_Ayxt);
        }
      }
    }
    label267:
    a(4, this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayxt);
  }
  
  public void a(ayxx paramayxx)
  {
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramayxx.jdField_a_of_type_Ayyg))
    {
      b(paramayxx);
      return;
    }
    a(3, paramayxx.jdField_a_of_type_Ayyg.jdField_a_of_type_Ayxt);
  }
  
  public void a(ayxx paramayxx, ayyg paramayyg)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    Object localObject = new CompressInfo(paramayyg.jdField_g_of_type_JavaLangString, 0);
    ayyz.b((CompressInfo)localObject);
    if (((CompressInfo)localObject).jdField_e_of_type_JavaLangString != null)
    {
      paramayyg.jdField_h_of_type_JavaLangString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
      paramayyg.jdField_e_of_type_Int = ((CompressInfo)localObject).jdField_d_of_type_Int;
      paramayyg.jdField_f_of_type_Int = ((CompressInfo)localObject).jdField_e_of_type_Int;
    }
    if ((paramayyg.jdField_g_of_type_Boolean) && (paramayyg.jdField_b_of_type_JavaLangObject != null)) {}
    for (localObject = (MessageForPic)paramayyg.jdField_b_of_type_JavaLangObject; localObject == null; localObject = a(paramayyg))
    {
      ayxi.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject).msgVia);
    }
    agjf.a().a(((MessageRecord)localObject).uniseq, 0L, paramayxx.jdField_c_of_type_Int);
    if (MessageForPic.class.isInstance(localObject))
    {
      a(paramayxx, (MessageRecord)localObject, paramayyg);
      b((MessageForPic)localObject);
    }
    if ((((MessageRecord)localObject).istroop == 1) && (paramayyg.jdField_a_of_type_Ayyi == null)) {
      njo.a().a((MessageRecord)localObject);
    }
    if (paramayyg.jdField_c_of_type_Boolean) {
      try
      {
        paramayyg.jdField_a_of_type_JavaLangObject = localObject;
        paramayyg.notifyAll();
        ayxi.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramayyg.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (paramayyg.jdField_c_of_type_Int == 3)
        {
          ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          ayxi.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "PresendStatus: destPath:" + paramayyg.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    paramayxx = new bdzn();
    paramayxx.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    paramayxx.jdField_c_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
    paramayxx.jdField_d_of_type_JavaLangString = ((MessageRecord)localObject).senderuin;
    paramayxx.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
    paramayxx.jdField_b_of_type_Int = 1;
    paramayxx.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
    paramayxx.jdField_a_of_type_Boolean = true;
    paramayxx.jdField_e_of_type_Int = paramayyg.jdField_a_of_type_Int;
    paramayxx.jdField_i_of_type_JavaLangString = paramayyg.jdField_g_of_type_JavaLangString;
    paramayxx.jdField_f_of_type_JavaLangString = paramayyg.jdField_f_of_type_JavaLangString;
    bdzr localbdzr = new bdzr();
    if (paramayyg.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localbdzr.jdField_a_of_type_Boolean = bool;
      paramayxx.jdField_a_of_type_JavaLangObject = localbdzr;
      paramayxx.jdField_a_of_type_Ayyt = this;
      paramayxx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      paramayxx.jdField_i_of_type_Boolean = paramayyg.jdField_c_of_type_Boolean;
      paramayxx.jdField_j_of_type_Boolean = paramayyg.jdField_e_of_type_Boolean;
      if (!paramayyg.jdField_c_of_type_Boolean) {
        break label821;
      }
      try
      {
        if (!paramayyg.jdField_d_of_type_Boolean) {
          break;
        }
        ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        ayxi.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramayyg.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
      finally {}
    }
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramayxx);
    ayxi.a(this.jdField_b_of_type_JavaLangString, "doSendPic ", "PresendStatus: destPath:" + paramayyg.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((paramayyg.jdField_b_of_type_Boolean) && (!paramayyg.jdField_c_of_type_Boolean))
      {
        ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
        a((MessageRecord)localObject, paramayyg.jdField_g_of_type_Long);
      }
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label821:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramayxx);
    }
  }
  
  protected void a(ayxx paramayxx, MessageRecord paramMessageRecord, ayyg paramayyg)
  {
    if (paramayxx.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramayxx.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      paramayxx = paramayxx.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if (paramayxx.stickerInfo != null) {
        paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramayxx.stickerInfo.toJsonString());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sticker_info")))
      {
        EmojiStickerManager.a(paramMessageRecord, null);
        EmojiStickerManager.a().a(paramMessageRecord);
      }
    }
    if (((MessageForPic)paramMessageRecord).checkGif())
    {
      paramayxx = ((MessageForPic)paramMessageRecord).picExtraData;
      if (paramayxx != null) {
        break label257;
      }
      paramayxx = new PicMessageExtraData();
    }
    label257:
    for (;;)
    {
      if (TextUtils.isEmpty(paramayxx.textSummary)) {
        paramayxx.textSummary = BaseApplicationImpl.getApplication().getString(2131691126);
      }
      paramayxx.emojiPkgId = String.valueOf(paramayyg.s);
      paramayxx.from = paramayyg.r;
      paramayxx.source = paramayyg.jdField_k_of_type_JavaLangString;
      paramayxx.webUrl = paramayyg.jdField_l_of_type_JavaLangString;
      paramayxx.iconUrl = paramayyg.jdField_m_of_type_JavaLangString;
      paramayxx.packageName = paramayyg.n;
      ((MessageForPic)paramMessageRecord).picExtraData = paramayxx;
      if ((paramayyg.jdField_a_of_type_Ayyf != null) && (!TextUtils.isEmpty(paramayyg.jdField_a_of_type_Ayyf.jdField_a_of_type_JavaLangString)))
      {
        PicMessageExtraData localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        paramayxx = localPicMessageExtraData;
        if (localPicMessageExtraData == null) {
          paramayxx = new PicMessageExtraData();
        }
        paramayxx.mTemplateId = paramayyg.jdField_a_of_type_Ayyf.jdField_a_of_type_JavaLangString;
        paramayxx.mTemplateName = paramayyg.jdField_a_of_type_Ayyf.jdField_b_of_type_JavaLangString;
        ((MessageForPic)paramMessageRecord).picExtraData = paramayxx;
      }
      return;
    }
  }
  
  public void a(ayyq paramayyq)
  {
    this.jdField_a_of_type_Ayyq = paramayyq;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ((bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    bauy localbauy = (bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localbauy.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localbauy.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  public void a(ArrayList<ayxr> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((ayxr)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((ayxr)paramArrayList.get(0));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    a();
  }
  
  protected boolean a(ayyg paramayyg)
  {
    if (paramayyg != null)
    {
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramayyg);
      return paramayyg.a();
    }
    ayxi.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  protected void b(ayxx paramayxx)
  {
    ayyg localayyg = paramayxx.jdField_a_of_type_Ayyg;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new BasePicOprerator.5(this, paramayxx, localayyg), 8, null, false);
      return;
    }
    a(paramayxx, localayyg);
  }
  
  public void b(ayyu paramayyu)
  {
    if (paramayyu == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Ayxx == null);
      if ((this.jdField_a_of_type_Ayxx.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Ayxx.jdField_a_of_type_Int == 4))
      {
        if (paramayyu.jdField_a_of_type_Int == 0)
        {
          a(paramayyu);
          localObject = (ayyd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
          if (localObject != null) {
            ((ayyd)localObject).a(13057, paramayyu.jdField_a_of_type_Long);
          }
          localObject = new ayxy();
          ((ayxy)localObject).jdField_a_of_type_Int = 0;
          ((ayxy)localObject).jdField_a_of_type_JavaLangObject = paramayyu;
          a(3, (ayxy)localObject);
          return;
        }
        localObject = new ayxt();
        ((ayxt)localObject).jdField_b_of_type_JavaLangString = paramayyu.jdField_a_of_type_JavaLangString;
        a(3, (ayxt)localObject);
        return;
      }
    } while (this.jdField_a_of_type_Ayxx.jdField_a_of_type_Int != 3);
    if (paramayyu.jdField_a_of_type_Int == 0)
    {
      a(paramayyu);
      localObject = (ayyd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73);
      if (localObject != null) {
        ((ayyd)localObject).a(13058, paramayyu.jdField_a_of_type_Long);
      }
      localObject = new ayxy();
      ((ayxy)localObject).jdField_a_of_type_Int = 0;
      ((ayxy)localObject).jdField_a_of_type_JavaLangObject = paramayyu;
      a(4, (ayxy)localObject);
      return;
    }
    if (paramayyu.jdField_b_of_type_Int == 9333)
    {
      this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayxp.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayxp.jdField_e_of_type_JavaLangString = "chatimg";
      if (this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayyg.jdField_l_of_type_Int == 1) {}
      for (int i = 7;; i = 6)
      {
        ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onSend", "fastForward md5 missed,is to Download the pic");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        paramayyu = ayxn.a(i, 3);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxr);
        paramayyu.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxr.jdField_a_of_type_Ayxp);
        d(paramayyu);
        return;
      }
    }
    Object localObject = new ayxt();
    ((ayxt)localObject).jdField_b_of_type_JavaLangString = paramayyu.jdField_a_of_type_JavaLangString;
    ((ayxt)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramayyu.jdField_b_of_type_Int);
    a(4, (ayxt)localObject);
  }
  
  public void c(ayxx paramayxx)
  {
    ayxr localayxr = paramayxx.jdField_a_of_type_Ayxr;
    if (!a(localayxr))
    {
      a(4, localayxr.jdField_a_of_type_Ayxt);
      return;
    }
    if (bgmg.b(localayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString))
    {
      localayxr.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localayxr);
      g(paramayxx);
      return;
    }
    if (localayxr.jdField_a_of_type_Ayyg.b())
    {
      File localFile = localayxr.jdField_a_of_type_Ayyg.a();
      if (localFile != null) {
        localayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString = localFile.toString();
      }
      localayxr.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localayxr);
      g(paramayxx);
      return;
    }
    localayxr.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localayxr);
    if ((localayxr.jdField_a_of_type_Ayyg.jdField_f_of_type_JavaLangString == null) || (localayxr.jdField_a_of_type_Ayyg.jdField_c_of_type_Long == 0L) || (localayxr.jdField_a_of_type_Ayyg.jdField_j_of_type_Int == 0) || (localayxr.jdField_a_of_type_Ayyg.jdField_k_of_type_Int == 0))
    {
      localayxr.jdField_a_of_type_Ayxp.jdField_a_of_type_Int = 3;
      localayxr.jdField_a_of_type_Ayxp.jdField_e_of_type_JavaLangString = "chatimg";
      if (localayxr.jdField_a_of_type_Ayyg.jdField_l_of_type_Int == 1) {}
      for (int i = 7;; i = 6)
      {
        paramayxx = ayxn.a(i, 3);
        paramayxx.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localayxr.jdField_a_of_type_Ayxp);
        d(paramayxx);
        return;
      }
    }
    f(paramayxx);
  }
  
  public void d(ayxx paramayxx)
  {
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    ayxp localayxp = paramayxx.jdField_a_of_type_Ayxp;
    if (a(localayxp))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localayxp.jdField_a_of_type_Long);
      if (!localayxp.jdField_e_of_type_JavaLangString.equals("chatimg"))
      {
        paramayxx = a(localayxp, localayxp.jdField_e_of_type_JavaLangString);
        if (!new File(paramayxx.jdField_h_of_type_JavaLangString).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramayxx);
          return;
        }
        ayxd localayxd = new ayxd();
        localayxd.jdField_a_of_type_Int = 0;
        localayxd.jdField_b_of_type_JavaLangString = paramayxx.jdField_h_of_type_JavaLangString;
        localayxd.jdField_c_of_type_JavaLangString = paramayxx.jdField_f_of_type_JavaLangString;
        localayxd.jdField_c_of_type_Int = paramayxx.jdField_b_of_type_Int;
        localayxd.jdField_d_of_type_Int = localayxp.jdField_h_of_type_Int;
        a(localayxd);
        return;
      }
      e(paramayxx);
      return;
    }
    paramayxx = new ayxd();
    paramayxx.jdField_a_of_type_Int = -1;
    paramayxx.jdField_a_of_type_Ayxt = localayxp.jdField_a_of_type_Ayxt;
    a(paramayxx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywt
 * JD-Core Version:    0.7.0.1
 */