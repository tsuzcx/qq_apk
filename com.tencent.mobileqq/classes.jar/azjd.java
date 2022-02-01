import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

class azjd
  implements RichProtoProc.RichProtoCallback
{
  private volatile long jdField_a_of_type_Long;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  
  azjd(azjc paramazjc) {}
  
  private int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (((azkf)localIterator.next()).jdField_a_of_type_Int == -2) {
            i += 1;
          }
        }
        else {
          return i;
        }
      }
      finally {}
    }
  }
  
  private String a(azjz paramazjz)
  {
    Object localObject3 = null;
    if (paramazjz.jdField_a_of_type_Azkn.l == 1) {}
    Object localObject1;
    for (int i = 1; paramazjz.jdField_a_of_type_Int >= 0; i = 0)
    {
      localObject1 = paramazjz.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString;
      return localObject1;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramazjz.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString))
    {
      localObject1 = new CompressInfo(paramazjz.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString, 0, 1009);
      azlg.a((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).e;
      azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = URLDrawableHelper.getURL(paramazjz, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = AbsDownloader.getFilePath(((URL)localObject2).toString()); FileUtils.fileExistsAndNotEmpty((String)localObject2); localObject2 = null)
        {
          azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          return localObject2;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = URLDrawableHelper.getURL(paramazjz, 131075, null);
          if (localObject2 == null) {
            break label416;
          }
        }
        label416:
        for (String str = AbsDownloader.getFilePath(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (FileUtils.fileExistsAndNotEmpty(str))
          {
            localObject1 = new CompressInfo(str, 0);
            ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
            azlg.a((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).e;
            azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = URLDrawableHelper.getURL(paramazjz, 65537, null);
          paramazjz = localObject3;
          if (localObject1 != null) {
            paramazjz = AbsDownloader.getFilePath(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!FileUtils.fileExistsAndNotEmpty(paramazjz)) {
            break;
          }
          azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramazjz);
          return paramazjz;
        }
      }
      return localObject1;
      localObject1 = null;
    }
  }
  
  private im_msg_body.CustomFace a(im_msg_body.NotOnlineImage paramNotOnlineImage)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    try
    {
      localCustomFace.uint32_file_id.set(paramNotOnlineImage.uint32_file_id.get());
      localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
      localCustomFace.uint32_useful.set(1);
      if (((QQAppInterface)this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaLangRefWeakReference.get()).getSessionKey() != null) {
        localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaLangRefWeakReference.get()).getSessionKey()));
      }
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramNotOnlineImage.pic_md5.get().toByteArray()));
      if (paramNotOnlineImage.res_id.has()) {
        localCustomFace.str_file_path.set(paramNotOnlineImage.res_id.get().toStringUtf8());
      }
      for (;;)
      {
        localCustomFace.uint32_origin.set(paramNotOnlineImage.original.get());
        localCustomFace.biz_type.set(4);
        localCustomFace.uint32_source.set(104);
        localCustomFace.uint32_width.set(paramNotOnlineImage.pic_width.get());
        localCustomFace.uint32_height.set(paramNotOnlineImage.pic_height.get());
        localCustomFace.uint32_size.set(paramNotOnlineImage.file_len.get());
        localCustomFace.uint32_thumb_width.set(paramNotOnlineImage.uint32_thumb_width.get());
        localCustomFace.uint32_thumb_height.set(paramNotOnlineImage.uint32_thumb_height.get());
        localCustomFace.image_type.set(paramNotOnlineImage.img_type.get());
        azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.convert2CustomFace", azjc.a(this.jdField_a_of_type_Azjc, localCustomFace));
        return localCustomFace;
        if (paramNotOnlineImage.download_path.has()) {
          localCustomFace.str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
        }
      }
      return null;
    }
    catch (Exception paramNotOnlineImage)
    {
      azjq.b(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + paramNotOnlineImage.toString());
    }
  }
  
  private im_msg_body.NotOnlineImage a(im_msg_body.CustomFace paramCustomFace)
  {
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    try
    {
      localNotOnlineImage.uint32_file_id.set(paramCustomFace.uint32_file_id.get());
      localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("BADBADBAD"));
      Object localObject = new StringBuilder();
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = (1L + l);
      localObject = l + "BADBADBAD" + this.jdField_a_of_type_JavaUtilRandom.nextInt();
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramCustomFace.str_file_path.get()));
      localNotOnlineImage.file_len.set(paramCustomFace.uint32_size.get());
      localNotOnlineImage.pic_md5.set(paramCustomFace.bytes_md5.get());
      localNotOnlineImage.pic_height.set(paramCustomFace.uint32_height.get());
      localNotOnlineImage.pic_width.set(paramCustomFace.uint32_width.get());
      localNotOnlineImage.original.set(paramCustomFace.uint32_origin.get());
      localNotOnlineImage.img_type.set(paramCustomFace.image_type.get());
      localNotOnlineImage.biz_type.set(4);
      localNotOnlineImage.uint32_thumb_width.set(paramCustomFace.uint32_thumb_width.get());
      localNotOnlineImage.uint32_thumb_height.set(paramCustomFace.uint32_thumb_height.get());
      azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + azjc.a(this.jdField_a_of_type_Azjc, localNotOnlineImage));
      return localNotOnlineImage;
    }
    catch (Exception paramCustomFace)
    {
      azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + paramCustomFace.toString());
    }
    return null;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaUtilList.size();
    int j = a();
    azkf localazkf = new azkf();
    localazkf.jdField_a_of_type_Int = 0;
    localazkf.jdField_a_of_type_JavaLangObject = Integer.valueOf(i - j);
    this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a(6, 0, localazkf);
  }
  
  private boolean a(azjz paramazjz)
  {
    if (paramazjz != null)
    {
      azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "checkFowardPicInfo", "info:" + paramazjz);
      if (paramazjz.jdField_a_of_type_Azkn == null)
      {
        paramazjz.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramazjz.jdField_a_of_type_Azkn.b == 1000) || (paramazjz.jdField_a_of_type_Azkn.b == 1020) || (paramazjz.jdField_a_of_type_Azkn.b == 1004)) && (paramazjz.jdField_a_of_type_Azkn.d == null))
      {
        paramazjz.a("PicFowardInfo.check", "secondId invalid,uinType:" + paramazjz.jdField_a_of_type_Azkn.b + ",secondId:" + paramazjz.jdField_a_of_type_Azkn.d);
        return false;
      }
      if (paramazjz.jdField_a_of_type_Azkn.jdField_g_of_type_Int == -1)
      {
        paramazjz.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramazjz.jdField_a_of_type_Azkn.jdField_g_of_type_Int);
        return false;
      }
      if (a(paramazjz) != null) {
        return true;
      }
      paramazjz.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    azjq.b(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b()
  {
    new azje(this).execute(new Void[0]);
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "start");
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "onBusiProtoResp miao size =  [" + paramRichProtoResp.resps.size());
    }
    if ((paramRichProtoReq != null) && (paramRichProtoResp != null))
    {
      i = 0;
      if (i < paramRichProtoResp.resps.size())
      {
        Object localObject1 = (azjz)this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaUtilList.get(i);
        azkf localazkf = (azkf)this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaUtilArrayList.get(i);
        Object localObject2 = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.resps.get(i);
        if ((localObject2 instanceof RichProto.RichProtoResp.C2CPicUpResp))
        {
          localObject2 = (RichProto.RichProtoResp.C2CPicUpResp)localObject2;
          azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i + "]," + ((RichProto.RichProtoResp.C2CPicUpResp)localObject2).toString());
          if ((((RichProto.RichProtoResp.C2CPicUpResp)localObject2).result == 0) && (((RichProto.RichProtoResp.C2CPicUpResp)localObject2).isExist))
          {
            localObject2 = this.jdField_a_of_type_Azjc.a((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.reqs.get(i), (RichProto.RichProtoResp.C2CPicUpResp)localObject2, i);
            if ((((azjz)localObject1).jdField_a_of_type_Azjx.b != 1) && (((azjz)localObject1).jdField_a_of_type_Azjx.b != 3000)) {
              break label412;
            }
            azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i + "] ");
            localObject1 = a((im_msg_body.NotOnlineImage)localObject2);
            if (localObject1 != null)
            {
              localazkf.jdField_a_of_type_Int = 0;
              localazkf.jdField_a_of_type_JavaLangObject = localObject1;
              a();
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              }
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label412:
          if (localObject2 != null)
          {
            localazkf.jdField_a_of_type_Int = 0;
            localazkf.jdField_a_of_type_JavaLangObject = localObject2;
            a();
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              continue;
              if ((localObject2 instanceof RichProto.RichProtoResp.GroupPicUpResp))
              {
                localObject2 = (RichProto.RichProtoResp.GroupPicUpResp)localObject2;
                azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i + "]," + ((RichProto.RichProtoResp.GroupPicUpResp)localObject2).toString());
                if ((((RichProto.RichProtoResp.GroupPicUpResp)localObject2).result == 0) && (((RichProto.RichProtoResp.GroupPicUpResp)localObject2).isExist))
                {
                  localObject2 = this.jdField_a_of_type_Azjc.a((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.reqs.get(i), (RichProto.RichProtoResp.GroupPicUpResp)localObject2, i);
                  if ((((azjz)localObject1).jdField_a_of_type_Azjx.b == 1) || (((azjz)localObject1).jdField_a_of_type_Azjx.b == 3000))
                  {
                    if (localObject2 != null)
                    {
                      localazkf.jdField_a_of_type_Int = 0;
                      localazkf.jdField_a_of_type_JavaLangObject = localObject2;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                  else
                  {
                    azjq.a(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i + "] ");
                    localObject1 = a((im_msg_body.CustomFace)localObject2);
                    if (localObject1 != null)
                    {
                      localazkf.jdField_a_of_type_Int = 0;
                      localazkf.jdField_a_of_type_JavaLangObject = localObject1;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                }
              }
              else
              {
                azjq.b(this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azjc.jdField_a_of_type_Azja.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i + "] " + localObject2.getClass().getSimpleName());
              }
            }
          }
        }
      }
    }
    int i = a();
    if (i > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] need upload [" + i + "] pictures");
      }
      int k = 0;
      for (int j = 0; k < this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaUtilArrayList.size(); j = i)
      {
        paramRichProtoReq = (azjz)this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaUtilList.get(k);
        paramRichProtoResp = (azkf)this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + paramRichProtoReq.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString);
        }
        i = j;
        if (paramRichProtoResp.jdField_a_of_type_Int == -2)
        {
          i = j;
          if (!a(paramRichProtoReq))
          {
            paramRichProtoReq.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString = axio.a((QQAppInterface)this.jdField_a_of_type_Azjc.jdField_a_of_type_JavaLangRefWeakReference.get());
            paramRichProtoReq.jdField_a_of_type_Azkn.jdField_f_of_type_JavaLangString = FileUtils.calcMd5(paramRichProtoReq.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString);
            paramRichProtoReq.jdField_a_of_type_Azkn.l = 1;
            paramRichProtoReq.jdField_a_of_type_Azkn.j = 242;
            paramRichProtoReq.jdField_a_of_type_Azkn.k = 192;
            paramRichProtoReq.jdField_a_of_type_Azkn.c = axio.a();
            paramRichProtoReq.jdField_a_of_type_Azkn.h = paramRichProtoReq.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString;
            paramRichProtoReq.jdField_a_of_type_Azkn.jdField_f_of_type_Int = 192;
            paramRichProtoReq.jdField_a_of_type_Azkn.e = 242;
            paramRichProtoReq.jdField_a_of_type_Azjx.jdField_f_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_Azkn.jdField_f_of_type_JavaLangString;
            paramRichProtoResp.b = true;
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + paramRichProtoReq.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString);
              i = j;
            }
          }
        }
        k += 1;
      }
      if ((j != 0) && (!this.jdField_a_of_type_Azjc.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Azjc.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Azjc.a(new Void[0]);
        return;
      }
      this.jdField_a_of_type_Azjc.jdField_a_of_type_Boolean = false;
      b();
      return;
    }
    azjc.a(this.jdField_a_of_type_Azjc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjd
 * JD-Core Version:    0.7.0.1
 */