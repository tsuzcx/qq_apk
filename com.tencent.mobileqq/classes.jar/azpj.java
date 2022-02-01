import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

class azpj
  implements bfcb
{
  private volatile long jdField_a_of_type_Long;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  
  azpj(azpi paramazpi) {}
  
  private int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (((azql)localIterator.next()).jdField_a_of_type_Int == -2) {
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
  
  private String a(azqf paramazqf)
  {
    Object localObject3 = null;
    if (paramazqf.jdField_a_of_type_Azqt.l == 1) {}
    Object localObject1;
    for (int i = 1; paramazqf.jdField_a_of_type_Int >= 0; i = 0)
    {
      localObject1 = paramazqf.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString;
      return localObject1;
    }
    if (bhmi.b(paramazqf.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString))
    {
      localObject1 = new CompressInfo(paramazqf.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString, 0, 1009);
      azrm.a((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).e;
      azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = beyq.a(paramazqf, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = beqz.d(((URL)localObject2).toString()); bhmi.b((String)localObject2); localObject2 = null)
        {
          azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          return localObject2;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = beyq.a(paramazqf, 131075, null);
          if (localObject2 == null) {
            break label416;
          }
        }
        label416:
        for (String str = beqz.d(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (bhmi.b(str))
          {
            localObject1 = new CompressInfo(str, 0);
            ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
            azrm.a((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).e;
            azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = beyq.a(paramazqf, 65537, null);
          paramazqf = localObject3;
          if (localObject1 != null) {
            paramazqf = beqz.d(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!bhmi.b(paramazqf)) {
            break;
          }
          azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramazqf);
          return paramazqf;
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
      if (((QQAppInterface)this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
        localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
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
        azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.convert2CustomFace", azpi.a(this.jdField_a_of_type_Azpi, localCustomFace));
        return localCustomFace;
        if (paramNotOnlineImage.download_path.has()) {
          localCustomFace.str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
        }
      }
      return null;
    }
    catch (Exception paramNotOnlineImage)
    {
      azpw.b(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + paramNotOnlineImage.toString());
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
      azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + azpi.a(this.jdField_a_of_type_Azpi, localNotOnlineImage));
      return localNotOnlineImage;
    }
    catch (Exception paramCustomFace)
    {
      azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + paramCustomFace.toString());
    }
    return null;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaUtilList.size();
    int j = a();
    azql localazql = new azql();
    localazql.jdField_a_of_type_Int = 0;
    localazql.jdField_a_of_type_JavaLangObject = Integer.valueOf(i - j);
    this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a(6, 0, localazql);
  }
  
  private boolean a(azqf paramazqf)
  {
    if (paramazqf != null)
    {
      azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "checkFowardPicInfo", "info:" + paramazqf);
      if (paramazqf.jdField_a_of_type_Azqt == null)
      {
        paramazqf.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramazqf.jdField_a_of_type_Azqt.b == 1000) || (paramazqf.jdField_a_of_type_Azqt.b == 1020) || (paramazqf.jdField_a_of_type_Azqt.b == 1004)) && (paramazqf.jdField_a_of_type_Azqt.d == null))
      {
        paramazqf.a("PicFowardInfo.check", "secondId invalid,uinType:" + paramazqf.jdField_a_of_type_Azqt.b + ",secondId:" + paramazqf.jdField_a_of_type_Azqt.d);
        return false;
      }
      if (paramazqf.jdField_a_of_type_Azqt.jdField_g_of_type_Int == -1)
      {
        paramazqf.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramazqf.jdField_a_of_type_Azqt.jdField_g_of_type_Int);
        return false;
      }
      if (a(paramazqf) != null) {
        return true;
      }
      paramazqf.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    azpw.b(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b()
  {
    new azpk(this).execute(new Void[0]);
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "start");
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "onBusiProtoResp miao size =  [" + parambfbj.jdField_a_of_type_JavaUtilList.size());
    }
    if ((parambfau != null) && (parambfbj != null))
    {
      i = 0;
      if (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (azqf)this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaUtilList.get(i);
        azql localazql = (azql)this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaUtilArrayList.get(i);
        Object localObject2 = (bfbw)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject2 instanceof bfbl))
        {
          localObject2 = (bfbl)localObject2;
          azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i + "]," + ((bfbl)localObject2).toString());
          if ((((bfbl)localObject2).c == 0) && (((bfbl)localObject2).jdField_a_of_type_Boolean))
          {
            localObject2 = this.jdField_a_of_type_Azpi.a((bfbd)parambfau.jdField_a_of_type_JavaUtilList.get(i), (bfbl)localObject2, i);
            if ((((azqf)localObject1).jdField_a_of_type_Azqd.b != 1) && (((azqf)localObject1).jdField_a_of_type_Azqd.b != 3000)) {
              break label412;
            }
            azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i + "] ");
            localObject1 = a((im_msg_body.NotOnlineImage)localObject2);
            if (localObject1 != null)
            {
              localazql.jdField_a_of_type_Int = 0;
              localazql.jdField_a_of_type_JavaLangObject = localObject1;
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
            localazql.jdField_a_of_type_Int = 0;
            localazql.jdField_a_of_type_JavaLangObject = localObject2;
            a();
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              continue;
              if ((localObject2 instanceof bfbo))
              {
                localObject2 = (bfbo)localObject2;
                azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i + "]," + ((bfbo)localObject2).toString());
                if ((((bfbo)localObject2).c == 0) && (((bfbo)localObject2).jdField_a_of_type_Boolean))
                {
                  localObject2 = this.jdField_a_of_type_Azpi.a((bfbd)parambfau.jdField_a_of_type_JavaUtilList.get(i), (bfbo)localObject2, i);
                  if ((((azqf)localObject1).jdField_a_of_type_Azqd.b == 1) || (((azqf)localObject1).jdField_a_of_type_Azqd.b == 3000))
                  {
                    if (localObject2 != null)
                    {
                      localazql.jdField_a_of_type_Int = 0;
                      localazql.jdField_a_of_type_JavaLangObject = localObject2;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                  else
                  {
                    azpw.a(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i + "] ");
                    localObject1 = a((im_msg_body.CustomFace)localObject2);
                    if (localObject1 != null)
                    {
                      localazql.jdField_a_of_type_Int = 0;
                      localazql.jdField_a_of_type_JavaLangObject = localObject1;
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
                azpw.b(this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpi.jdField_a_of_type_Azpg.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i + "] " + localObject2.getClass().getSimpleName());
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
      for (int j = 0; k < this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaUtilArrayList.size(); j = i)
      {
        parambfau = (azqf)this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaUtilList.get(k);
        parambfbj = (azql)this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + parambfau.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString);
        }
        i = j;
        if (parambfbj.jdField_a_of_type_Int == -2)
        {
          i = j;
          if (!a(parambfau))
          {
            parambfau.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString = axpf.a((QQAppInterface)this.jdField_a_of_type_Azpi.jdField_a_of_type_JavaLangRefWeakReference.get());
            parambfau.jdField_a_of_type_Azqt.jdField_f_of_type_JavaLangString = bhmi.c(parambfau.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString);
            parambfau.jdField_a_of_type_Azqt.l = 1;
            parambfau.jdField_a_of_type_Azqt.j = 242;
            parambfau.jdField_a_of_type_Azqt.k = 192;
            parambfau.jdField_a_of_type_Azqt.c = axpf.a();
            parambfau.jdField_a_of_type_Azqt.h = parambfau.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString;
            parambfau.jdField_a_of_type_Azqt.jdField_f_of_type_Int = 192;
            parambfau.jdField_a_of_type_Azqt.e = 242;
            parambfau.jdField_a_of_type_Azqd.jdField_f_of_type_JavaLangString = parambfau.jdField_a_of_type_Azqt.jdField_f_of_type_JavaLangString;
            parambfbj.b = true;
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + parambfau.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString);
              i = j;
            }
          }
        }
        k += 1;
      }
      if ((j != 0) && (!this.jdField_a_of_type_Azpi.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Azpi.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Azpi.a(new Void[0]);
        return;
      }
      this.jdField_a_of_type_Azpi.jdField_a_of_type_Boolean = false;
      b();
      return;
    }
    azpi.a(this.jdField_a_of_type_Azpi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpj
 * JD-Core Version:    0.7.0.1
 */