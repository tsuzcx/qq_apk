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

class aums
  implements ayzu
{
  private volatile long jdField_a_of_type_Long;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  
  aums(aumr paramaumr) {}
  
  private int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (((aunu)localIterator.next()).jdField_a_of_type_Int == -2) {
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
  
  private String a(aunn paramaunn)
  {
    Object localObject3 = null;
    if (paramaunn.jdField_a_of_type_Auob.l == 1) {}
    Object localObject1;
    for (int i = 1; paramaunn.jdField_a_of_type_Int >= 0; i = 0)
    {
      localObject1 = paramaunn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString;
      return localObject1;
    }
    if (bbdj.b(paramaunn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString))
    {
      localObject1 = new CompressInfo(paramaunn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString, 0, 1009);
      auoq.a((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).e;
      aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = aywk.a(paramaunn, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = ayog.d(((URL)localObject2).toString()); bbdj.b((String)localObject2); localObject2 = null)
        {
          aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          return localObject2;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = aywk.a(paramaunn, 131075, null);
          if (localObject2 == null) {
            break label416;
          }
        }
        label416:
        for (String str = ayog.d(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (bbdj.b(str))
          {
            localObject1 = new CompressInfo(str, 0);
            ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
            auoq.a((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).e;
            aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = aywk.a(paramaunn, 65537, null);
          paramaunn = localObject3;
          if (localObject1 != null) {
            paramaunn = ayog.d(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!bbdj.b(paramaunn)) {
            break;
          }
          aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramaunn);
          return paramaunn;
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
      if (((QQAppInterface)this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
        localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
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
        aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.convert2CustomFace", aumr.a(this.jdField_a_of_type_Aumr, localCustomFace));
        return localCustomFace;
        if (paramNotOnlineImage.download_path.has()) {
          localCustomFace.str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
        }
      }
      return null;
    }
    catch (Exception paramNotOnlineImage)
    {
      aune.b(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + paramNotOnlineImage.toString());
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
      aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + aumr.a(this.jdField_a_of_type_Aumr, localNotOnlineImage));
      return localNotOnlineImage;
    }
    catch (Exception paramCustomFace)
    {
      aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + paramCustomFace.toString());
    }
    return null;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaUtilList.size();
    int j = a();
    aunu localaunu = new aunu();
    localaunu.jdField_a_of_type_Int = 0;
    localaunu.jdField_a_of_type_JavaLangObject = Integer.valueOf(i - j);
    this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a(6, 0, localaunu);
  }
  
  private boolean a(aunn paramaunn)
  {
    if (paramaunn != null)
    {
      aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "checkFowardPicInfo", "info:" + paramaunn);
      if (paramaunn.jdField_a_of_type_Auob == null)
      {
        paramaunn.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramaunn.jdField_a_of_type_Auob.b == 1000) || (paramaunn.jdField_a_of_type_Auob.b == 1020) || (paramaunn.jdField_a_of_type_Auob.b == 1004)) && (paramaunn.jdField_a_of_type_Auob.d == null))
      {
        paramaunn.a("PicFowardInfo.check", "secondId invalid,uinType:" + paramaunn.jdField_a_of_type_Auob.b + ",secondId:" + paramaunn.jdField_a_of_type_Auob.d);
        return false;
      }
      if (paramaunn.jdField_a_of_type_Auob.jdField_g_of_type_Int == -1)
      {
        paramaunn.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramaunn.jdField_a_of_type_Auob.jdField_g_of_type_Int);
        return false;
      }
      if (a(paramaunn) != null) {
        return true;
      }
      paramaunn.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    aune.b(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b()
  {
    new aumt(this).execute(new Void[0]);
  }
  
  public void a(ayyn paramayyn, ayzc paramayzc)
  {
    aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "start");
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "onBusiProtoResp miao size =  [" + paramayzc.jdField_a_of_type_JavaUtilList.size());
    }
    if ((paramayyn != null) && (paramayzc != null))
    {
      i = 0;
      if (i < paramayzc.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (aunn)this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaUtilList.get(i);
        aunu localaunu = (aunu)this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaUtilArrayList.get(i);
        Object localObject2 = (ayzp)paramayzc.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject2 instanceof ayze))
        {
          localObject2 = (ayze)localObject2;
          aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i + "]," + ((ayze)localObject2).toString());
          if ((((ayze)localObject2).c == 0) && (((ayze)localObject2).jdField_a_of_type_Boolean))
          {
            localObject2 = this.jdField_a_of_type_Aumr.a((ayyw)paramayyn.jdField_a_of_type_JavaUtilList.get(i), (ayze)localObject2, i);
            if ((((aunn)localObject1).jdField_a_of_type_Aunl.b != 1) && (((aunn)localObject1).jdField_a_of_type_Aunl.b != 3000)) {
              break label412;
            }
            aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i + "] ");
            localObject1 = a((im_msg_body.NotOnlineImage)localObject2);
            if (localObject1 != null)
            {
              localaunu.jdField_a_of_type_Int = 0;
              localaunu.jdField_a_of_type_JavaLangObject = localObject1;
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
            localaunu.jdField_a_of_type_Int = 0;
            localaunu.jdField_a_of_type_JavaLangObject = localObject2;
            a();
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              continue;
              if ((localObject2 instanceof ayzh))
              {
                localObject2 = (ayzh)localObject2;
                aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i + "]," + ((ayzh)localObject2).toString());
                if ((((ayzh)localObject2).c == 0) && (((ayzh)localObject2).jdField_a_of_type_Boolean))
                {
                  localObject2 = this.jdField_a_of_type_Aumr.a((ayyw)paramayyn.jdField_a_of_type_JavaUtilList.get(i), (ayzh)localObject2, i);
                  if ((((aunn)localObject1).jdField_a_of_type_Aunl.b == 1) || (((aunn)localObject1).jdField_a_of_type_Aunl.b == 3000))
                  {
                    if (localObject2 != null)
                    {
                      localaunu.jdField_a_of_type_Int = 0;
                      localaunu.jdField_a_of_type_JavaLangObject = localObject2;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                  else
                  {
                    aune.a(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i + "] ");
                    localObject1 = a((im_msg_body.CustomFace)localObject2);
                    if (localObject1 != null)
                    {
                      localaunu.jdField_a_of_type_Int = 0;
                      localaunu.jdField_a_of_type_JavaLangObject = localObject1;
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
                aune.b(this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_Aump.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i + "] " + localObject2.getClass().getSimpleName());
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
      for (int j = 0; k < this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaUtilArrayList.size(); j = i)
      {
        paramayyn = (aunn)this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaUtilList.get(k);
        paramayzc = (aunu)this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + paramayyn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString);
        }
        i = j;
        if (paramayzc.jdField_a_of_type_Int == -2)
        {
          i = j;
          if (!a(paramayyn))
          {
            paramayyn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString = asty.a((QQAppInterface)this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangRefWeakReference.get());
            paramayyn.jdField_a_of_type_Auob.jdField_f_of_type_JavaLangString = bbdj.c(paramayyn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString);
            paramayyn.jdField_a_of_type_Auob.l = 1;
            paramayyn.jdField_a_of_type_Auob.j = 242;
            paramayyn.jdField_a_of_type_Auob.k = 192;
            paramayyn.jdField_a_of_type_Auob.c = asty.a();
            paramayyn.jdField_a_of_type_Auob.h = paramayyn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString;
            paramayyn.jdField_a_of_type_Auob.jdField_f_of_type_Int = 192;
            paramayyn.jdField_a_of_type_Auob.e = 242;
            paramayyn.jdField_a_of_type_Aunl.jdField_f_of_type_JavaLangString = paramayyn.jdField_a_of_type_Auob.jdField_f_of_type_JavaLangString;
            paramayzc.b = true;
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + paramayyn.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString);
              i = j;
            }
          }
        }
        k += 1;
      }
      if ((j != 0) && (!this.jdField_a_of_type_Aumr.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Aumr.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Aumr.a(new Void[0]);
        return;
      }
      this.jdField_a_of_type_Aumr.jdField_a_of_type_Boolean = false;
      b();
      return;
    }
    aumr.a(this.jdField_a_of_type_Aumr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aums
 * JD-Core Version:    0.7.0.1
 */