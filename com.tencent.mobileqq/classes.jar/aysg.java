import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.transfile.FileDownloadFailedException;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class aysg
  extends ayoj
  implements ProtocolDownloader
{
  public aysg(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("lbs", paramBaseApplicationImpl);
  }
  
  private String a(MessageForPic paramMessageForPic, String paramString)
  {
    if (bbdx.a(paramString)) {}
    while (!bbdx.a(paramMessageForPic.path)) {
      return paramString;
    }
    paramMessageForPic = new CompressInfo(paramMessageForPic.path, 0);
    auos.b(paramMessageForPic);
    return paramMessageForPic.e;
  }
  
  private void a(DownloadParams paramDownloadParams, OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler, boolean paramBoolean)
  {
    URL localURL = paramDownloadParams.url;
    localObject1 = paramDownloadParams.headers;
    localObject1 = paramDownloadParams.cookies;
    String str1 = localURL.toString();
    if (QLog.isColorLevel()) {
      QLog.d("lbs", 2, "LBS Image download start, url:" + str1);
    }
    Object localObject8 = null;
    String str2 = localURL.getFile();
    Object localObject5;
    Object localObject4;
    Object localObject2;
    Object localObject3;
    Object localObject7;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof MessageForPic)))
    {
      localObject5 = (MessageForPic)paramDownloadParams.tag;
      localObject4 = ((MessageForPic)localObject5).selfuin;
      localObject2 = ((MessageForPic)localObject5).frienduin;
      l1 = ((MessageForPic)localObject5).time;
      localObject1 = String.valueOf(((MessageForPic)localObject5).uniseq);
      localObject3 = ((MessageForPic)localObject5).uuid;
      i = aywm.a(paramDownloadParams.url.getProtocol(), false);
      if (((MessageForPic)localObject5).isSendFromLocal()) {
        if (i == 65537) {
          if ((((MessageForPic)localObject5).isShareAppActionMsg) || (((MessageForPic)localObject5).msgtype == -3001))
          {
            paramDownloadParams = ((MessageForPic)localObject5).path;
            localObject5 = localObject2;
            localObject7 = localObject4;
            localObject4 = localObject3;
            localObject3 = localObject1;
            localObject2 = paramDownloadParams;
            localObject1 = localObject7;
            paramDownloadParams = (DownloadParams)localObject5;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("lbs", 2, "[lbs_file][down][start]  ,localPath:" + (String)localObject2 + ",serverPath:" + (String)localObject4 + ",uniseq:" + (String)localObject3 + ",msgTime:" + l1);
      }
      localObject5 = (QQAppInterface)this.a.getAppRuntime((String)localObject1);
      if (localObject2 != null) {}
      try
      {
        paramDownloadParams = new File((String)localObject2);
        if (paramDownloadParams.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("lbs", 2, "file exist, copy file from:" + (String)localObject2 + ", url:" + str1);
          }
          aypv.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
        }
        return;
      }
      catch (Exception paramDownloadParams)
      {
        for (;;)
        {
          i = 1;
          paramOutputStream = null;
          paramURLDrawableHandler = null;
          localObject1 = null;
          int j = 1;
          continue;
          if ((paramDownloadParams != null) && (localObject1 != null)) {
            if (l1 == -1L)
            {
              continue;
              i = 1;
              continue;
              continue;
              continue;
              i += 1;
            }
          }
        }
      }
      if (((MessageForPic)localObject5).picExtraFlag == ayvw.f)
      {
        paramDownloadParams = ((aytg)((MessageForPic)localObject5).picExtraObject).c;
        if ((paramDownloadParams != null) && (!"".equals(paramDownloadParams))) {
          break label1978;
        }
        paramDownloadParams = a((MessageForPic)localObject5, paramDownloadParams);
        break;
      }
      paramDownloadParams = a((MessageForPic)localObject5, null);
      break;
      localObject5 = ((MessageForPic)localObject5).path;
      paramDownloadParams = (DownloadParams)localObject2;
      localObject2 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject5;
      continue;
      if (str2.startsWith("http/"))
      {
        paramDownloadParams = str2.substring(5);
        j = 1;
        localObject1 = null;
        i = 1;
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if ((QLog.isColorLevel()) && (localObject1 != null)) {
              QLog.i("lbs", 2, "CONVERT_URL success,@time:" + ((ayqp)localObject1).jdField_b_of_type_Long + ",uniseq=" + (String)localObject3);
            }
            localObject4 = new ayqq();
          }
          catch (Exception localException1)
          {
            long l2;
            paramURLDrawableHandler = null;
            k = i;
            paramOutputStream = paramDownloadParams;
            paramDownloadParams = localException1;
            i = j;
            j = k;
            continue;
          }
          try
          {
            ((ayqq)localObject4).jdField_a_of_type_Long = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.i("lbs", 2, "DOWNLOAD_FILE start,@time:" + ((ayqq)localObject4).jdField_a_of_type_Long + ",uniseq=" + (String)localObject3);
            }
            paramURLDrawableHandler = new ayol(paramOutputStream, paramURLDrawableHandler, (QQAppInterface)localObject5);
            paramURLDrawableHandler.jdField_a_of_type_JavaLangString = "lbs";
            localObject7 = new ayok(paramDownloadParams, null, paramURLDrawableHandler, true);
            paramOutputStream = "gprs";
            if (bbfj.b(BaseApplication.getContext()) == 1) {
              paramOutputStream = "wifi";
            }
            ((ayok)localObject7).a("Net-type", paramOutputStream);
            ((ayok)localObject7).b(5);
            ((ayok)localObject7).a(true);
            ((ayok)localObject7).a("Accept-Encoding", "identity");
            j = 0;
            if (i > 3) {
              continue;
            }
            try
            {
              ((ayok)localObject7).a("Range", "bytes=" + j + "-");
              paramURLDrawableHandler.jdField_a_of_type_Boolean = false;
              ((ayok)localObject7).jdField_a_of_type_Boolean = false;
              ((QQAppInterface)localObject5).getHttpCommunicatort().b((bbmu)localObject7);
              j = paramURLDrawableHandler.jdField_a_of_type_Int;
              if (!paramURLDrawableHandler.jdField_a_of_type_Boolean) {
                continue;
              }
              ((ayqq)localObject4).jdField_e_of_type_Int = ((ayok)localObject7).jdField_e_of_type_Int;
              throw new FileDownloadFailedException(9301, 0L, "write to Cache failed", false);
            }
            catch (Exception localException2)
            {
              k = 4;
              paramURLDrawableHandler = (URLDrawableHandler)localObject4;
              j = i;
              paramOutputStream = paramDownloadParams;
              i = k;
              paramDownloadParams = localException2;
            }
          }
          catch (Exception localException4)
          {
            k = 4;
            paramURLDrawableHandler = localException1;
            j = i;
            paramOutputStream = paramDownloadParams;
            paramDownloadParams = localException4;
            i = k;
            continue;
            j = 3;
            i = 1;
            paramDownloadParams = localObject8;
            localObject1 = localException1;
          }
          int k = 9001;
          l2 = 0L;
          if ((paramDownloadParams instanceof FileDownloadFailedException))
          {
            localObject4 = (FileDownloadFailedException)paramDownloadParams;
            k = ((FileDownloadFailedException)localObject4).errorCode;
            l2 = ((FileDownloadFailedException)localObject4).errorDetailCode;
            paramBoolean = ((FileDownloadFailedException)localObject4).needReport;
          }
          if (i == 3)
          {
            ((ayqp)localObject1).jdField_a_of_type_Boolean = false;
            ((ayqp)localObject1).jdField_b_of_type_Long = System.currentTimeMillis();
            ((ayqp)localObject1).jdField_b_of_type_Int = j;
            ((ayqp)localObject1).jdField_a_of_type_Int = k;
            ((ayqp)localObject1).c = l2;
            ((ayqp)localObject1).jdField_a_of_type_JavaLangString = paramDownloadParams.getMessage();
            paramURLDrawableHandler = new StringBuilder();
            paramURLDrawableHandler.append("msg.id=").append((String)localObject3).append(",actualUrl=").append(paramOutputStream).append(",errorCode=").append(k).append(",detailErrCode=").append(l2).append(",msg=").append(paramDownloadParams.getMessage());
            if (QLog.isColorLevel()) {
              QLog.e("lbs", 2, "[lbs_file][down][result] failed  ,localPath:" + (String)localObject2 + ",serverPath:" + str1 + ",msgTime:" + l1 + ",errStr:" + paramURLDrawableHandler.toString(), paramDownloadParams);
            }
            throw paramDownloadParams;
            if (str2.startsWith("file/"))
            {
              paramDownloadParams = new File(str2.substring(4));
              if (!paramDownloadParams.exists()) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("lbs", 2, "file exist, copy to catch, url:" + str1);
              }
              aypv.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
              paramDownloadParams.delete();
              return;
            }
            localObject7 = localURL.getPath();
            if (!QLog.isColorLevel()) {
              break label2053;
            }
            QLog.d("lbs", 2, "<--downloadLBSImage serverPath=" + (String)localObject7);
            break label2053;
            paramOutputStream = new StringBuffer("wrong argument(header) for LBS. ");
            if (paramDownloadParams == null) {
              paramOutputStream.append(" peerUin is not set. ");
            }
            if (localObject1 == null) {
              paramOutputStream.append(" myUin is not set. ");
            }
            if (l1 == -1L) {
              paramOutputStream.append(" msgTime is not set. ");
            }
            throw new FileDownloadFailedException(9302, 0L, paramOutputStream.toString(), false);
            if ((localException2 == null) || (!localException2.isLogin()))
            {
              paramDownloadParams = new FileDownloadFailedException(0, 0L, "Account is logout", false);
              paramDownloadParams.needReport = false;
              throw paramDownloadParams;
            }
            if (!bbfj.d(BaseApplication.getContext()))
            {
              paramDownloadParams = new FileDownloadFailedException(0, 0L, "No alive Network.", false);
              paramDownloadParams.needReport = false;
              throw paramDownloadParams;
            }
            localObject4 = new ayqp();
          }
          DownloadParams localDownloadParams;
          try
          {
            ((ayqp)localObject4).jdField_a_of_type_Long = System.currentTimeMillis();
            if (QLog.isColorLevel())
            {
              QLog.i("lbs", 2, "CONVERT_URL start @time:" + ((ayqp)localObject4).jdField_a_of_type_Long + ",uniseq=" + (String)localObject3);
              break label2074;
              if (i <= 3)
              {
                paramDownloadParams = new ayom();
                if (paramBoolean)
                {
                  j = 1;
                  byte b = (byte)j;
                  localException2.a().a((String)localObject1, (String)localObject7, b, paramDownloadParams);
                }
                try
                {
                  if (!paramDownloadParams.jdField_a_of_type_Boolean) {
                    paramDownloadParams.wait(60000L);
                  }
                  if (paramDownloadParams.jdField_b_of_type_Int == 0) {
                    continue;
                  }
                  if (paramDownloadParams.jdField_b_of_type_Int != 1002)
                  {
                    j = paramDownloadParams.jdField_b_of_type_Int;
                    if (j != 1013) {
                      continue;
                    }
                  }
                  i += 1;
                  continue;
                }
                finally {}
                j = 0;
                continue;
                ((ayqp)localObject4).jdField_b_of_type_Int = i;
                i = paramDownloadParams.jdField_a_of_type_Int;
              }
            }
          }
          catch (Exception paramDownloadParams)
          {
            Object localObject6;
            i = 3;
            paramOutputStream = null;
            paramURLDrawableHandler = null;
            localObject1 = localDownloadParams;
            j = 1;
          }
          try
          {
            if (!paramDownloadParams.jdField_a_of_type_Boolean) {
              throw new FileDownloadFailedException(9006, 0L, "onGetTempChatPic Time out.", false);
            }
            if (!paramDownloadParams.jdField_b_of_type_Boolean) {
              throw new FileDownloadFailedException(paramDownloadParams.jdField_b_of_type_Int, paramDownloadParams.jdField_a_of_type_Long, "onGetTempChatPic Time out.", false);
            }
            if (paramDownloadParams.jdField_a_of_type_JavaLangString == null) {
              throw new FileDownloadFailedException(9007, 0L, "onDownloadPicReqReturn downUrl is null", false);
            }
            paramDownloadParams = paramDownloadParams.jdField_a_of_type_JavaLangString;
            try
            {
              ((ayqp)localObject4).jdField_b_of_type_Long = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d("lbs", 2, "<--downloadLBSImage actualUrl=" + paramDownloadParams);
              }
              ((ayqp)localObject4).jdField_a_of_type_Boolean = true;
              j = 3;
              localObject1 = localObject4;
            }
            catch (Exception localException3)
            {
              paramOutputStream = paramDownloadParams;
              paramURLDrawableHandler = null;
              localObject1 = localObject4;
              k = 3;
              j = i;
              paramDownloadParams = localException3;
              i = k;
            }
            if ((paramURLDrawableHandler.jdField_a_of_type_Long > 0L) && (j >= paramURLDrawableHandler.jdField_a_of_type_Long)) {
              ((ayok)localObject7).jdField_a_of_type_Boolean = true;
            }
            if (!((ayok)localObject7).jdField_a_of_type_Boolean) {
              break label2121;
            }
            if (QLog.isColorLevel()) {
              QLog.d("lbs", 2, "[lbs_file][down][result] success  ,localPath:" + (String)localObject2 + ",serverPath:" + str1 + ",msgTime:" + l1 + ",uniseq:" + (String)localObject3);
            }
            if (!((ayok)localObject7).jdField_a_of_type_Boolean)
            {
              ((ayqq)localObject4).jdField_e_of_type_Int = ((ayok)localObject7).jdField_e_of_type_Int;
              ((ayqq)localObject4).jdField_a_of_type_Int = ((ayok)localObject7).f;
              ((ayqq)localObject4).jdField_a_of_type_JavaLangString = ((ayok)localObject7).b;
              throw new FileDownloadFailedException(((ayok)localObject7).f, ((ayok)localObject7).c, ((ayok)localObject7).b, false);
            }
            ((ayqq)localObject4).jdField_a_of_type_Boolean = ((ayok)localObject7).jdField_a_of_type_Boolean;
            ((ayqq)localObject4).jdField_b_of_type_Long = System.currentTimeMillis();
            ((ayqq)localObject4).jdField_e_of_type_Long = paramURLDrawableHandler.jdField_a_of_type_Int;
            ((ayqq)localObject4).f = paramURLDrawableHandler.jdField_a_of_type_Long;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("lbs", 2, "DOWNLOAD_FILE success,@time:" + ((ayqq)localObject4).jdField_b_of_type_Long + ",uniseq=" + (String)localObject3);
            return;
          }
          catch (Exception paramDownloadParams)
          {
            k = 3;
            paramOutputStream = null;
            paramURLDrawableHandler = null;
            localObject1 = localDownloadParams;
            j = i;
            i = k;
          }
        }
        if (i == 4)
        {
          paramURLDrawableHandler.jdField_a_of_type_Boolean = false;
          paramURLDrawableHandler.jdField_b_of_type_Long = System.currentTimeMillis();
          paramURLDrawableHandler.jdField_b_of_type_Int = j;
          paramURLDrawableHandler.jdField_a_of_type_Int = k;
          paramURLDrawableHandler.c = l2;
          paramURLDrawableHandler.jdField_a_of_type_JavaLangString = paramDownloadParams.getMessage();
          continue;
        }
      }
      label1978:
      break;
      paramDownloadParams = (DownloadParams)localObject3;
      localObject6 = localException1;
      localObject3 = localObject1;
      localObject7 = null;
      localDownloadParams = paramDownloadParams;
      paramDownloadParams = (DownloadParams)localObject2;
      localObject1 = localObject6;
      localObject2 = localObject7;
      continue;
      l1 = -1L;
      localObject3 = "0";
      localObject1 = null;
      localDownloadParams = null;
      localObject2 = null;
      paramDownloadParams = null;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    a(paramDownloadParams, paramOutputStream, paramURLDrawableHandler, paramDownloadParams.url.getProtocol().equals("lbsthumb"));
    return null;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aysg
 * JD-Core Version:    0.7.0.1
 */