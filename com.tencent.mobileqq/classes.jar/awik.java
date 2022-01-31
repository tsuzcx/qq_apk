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

class awik
  implements bbce
{
  private volatile long jdField_a_of_type_Long;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  
  awik(awij paramawij) {}
  
  private int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Awij.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_Awij.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (((awjm)localIterator.next()).jdField_a_of_type_Int == -2) {
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
  
  private String a(awjf paramawjf)
  {
    Object localObject3 = null;
    if (paramawjf.jdField_a_of_type_Awju.l == 1) {}
    Object localObject1;
    for (int i = 1; paramawjf.jdField_a_of_type_Int >= 0; i = 0)
    {
      localObject1 = paramawjf.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString;
      return localObject1;
    }
    if (bdhb.b(paramawjf.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString))
    {
      localObject1 = new CompressInfo(paramawjf.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString, 0, 1009);
      awkj.a((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).e;
      awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = bayu.a(paramawjf, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = baqn.d(((URL)localObject2).toString()); bdhb.b((String)localObject2); localObject2 = null)
        {
          awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          return localObject2;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = bayu.a(paramawjf, 131075, null);
          if (localObject2 == null) {
            break label416;
          }
        }
        label416:
        for (String str = baqn.d(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (bdhb.b(str))
          {
            localObject1 = new CompressInfo(str, 0);
            ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
            awkj.a((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).e;
            awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = bayu.a(paramawjf, 65537, null);
          paramawjf = localObject3;
          if (localObject1 != null) {
            paramawjf = baqn.d(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!bdhb.b(paramawjf)) {
            break;
          }
          awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramawjf);
          return paramawjf;
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
      if (((QQAppInterface)this.jdField_a_of_type_Awij.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
        localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_Awij.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
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
        awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.convert2CustomFace", awij.a(this.jdField_a_of_type_Awij, localCustomFace));
        return localCustomFace;
        if (paramNotOnlineImage.download_path.has()) {
          localCustomFace.str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
        }
      }
      return null;
    }
    catch (Exception paramNotOnlineImage)
    {
      awiw.b(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + paramNotOnlineImage.toString());
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
      awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + awij.a(this.jdField_a_of_type_Awij, localNotOnlineImage));
      return localNotOnlineImage;
    }
    catch (Exception paramCustomFace)
    {
      awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + paramCustomFace.toString());
    }
    return null;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Awij.jdField_a_of_type_JavaUtilList.size();
    int j = a();
    awjm localawjm = new awjm();
    localawjm.jdField_a_of_type_Int = 0;
    localawjm.jdField_a_of_type_JavaLangObject = Integer.valueOf(i - j);
    this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a(6, 0, localawjm);
  }
  
  private boolean a(awjf paramawjf)
  {
    if (paramawjf != null)
    {
      awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "checkFowardPicInfo", "info:" + paramawjf);
      if (paramawjf.jdField_a_of_type_Awju == null)
      {
        paramawjf.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramawjf.jdField_a_of_type_Awju.b == 1000) || (paramawjf.jdField_a_of_type_Awju.b == 1020) || (paramawjf.jdField_a_of_type_Awju.b == 1004)) && (paramawjf.jdField_a_of_type_Awju.d == null))
      {
        paramawjf.a("PicFowardInfo.check", "secondId invalid,uinType:" + paramawjf.jdField_a_of_type_Awju.b + ",secondId:" + paramawjf.jdField_a_of_type_Awju.d);
        return false;
      }
      if (paramawjf.jdField_a_of_type_Awju.jdField_g_of_type_Int == -1)
      {
        paramawjf.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramawjf.jdField_a_of_type_Awju.jdField_g_of_type_Int);
        return false;
      }
      if (a(paramawjf) != null) {
        return true;
      }
      paramawjf.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    awiw.b(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b()
  {
    new awil(this).execute(new Void[0]);
  }
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "start");
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "onBusiProtoResp miao size =  [" + parambbbm.jdField_a_of_type_JavaUtilList.size());
    }
    if ((parambbax != null) && (parambbbm != null))
    {
      i = 0;
      if (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (awjf)this.jdField_a_of_type_Awij.jdField_a_of_type_JavaUtilList.get(i);
        awjm localawjm = (awjm)this.jdField_a_of_type_Awij.jdField_a_of_type_JavaUtilArrayList.get(i);
        Object localObject2 = (bbbz)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject2 instanceof bbbo))
        {
          localObject2 = (bbbo)localObject2;
          awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i + "]," + ((bbbo)localObject2).toString());
          if ((((bbbo)localObject2).c == 0) && (((bbbo)localObject2).jdField_a_of_type_Boolean))
          {
            localObject2 = this.jdField_a_of_type_Awij.a((bbbg)parambbax.jdField_a_of_type_JavaUtilList.get(i), (bbbo)localObject2, i);
            if ((((awjf)localObject1).jdField_a_of_type_Awjd.b != 1) && (((awjf)localObject1).jdField_a_of_type_Awjd.b != 3000)) {
              break label412;
            }
            awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i + "] ");
            localObject1 = a((im_msg_body.NotOnlineImage)localObject2);
            if (localObject1 != null)
            {
              localawjm.jdField_a_of_type_Int = 0;
              localawjm.jdField_a_of_type_JavaLangObject = localObject1;
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
            localawjm.jdField_a_of_type_Int = 0;
            localawjm.jdField_a_of_type_JavaLangObject = localObject2;
            a();
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              continue;
              if ((localObject2 instanceof bbbr))
              {
                localObject2 = (bbbr)localObject2;
                awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i + "]," + ((bbbr)localObject2).toString());
                if ((((bbbr)localObject2).c == 0) && (((bbbr)localObject2).jdField_a_of_type_Boolean))
                {
                  localObject2 = this.jdField_a_of_type_Awij.a((bbbg)parambbax.jdField_a_of_type_JavaUtilList.get(i), (bbbr)localObject2, i);
                  if ((((awjf)localObject1).jdField_a_of_type_Awjd.b == 1) || (((awjf)localObject1).jdField_a_of_type_Awjd.b == 3000))
                  {
                    if (localObject2 != null)
                    {
                      localawjm.jdField_a_of_type_Int = 0;
                      localawjm.jdField_a_of_type_JavaLangObject = localObject2;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                  else
                  {
                    awiw.a(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i + "] ");
                    localObject1 = a((im_msg_body.CustomFace)localObject2);
                    if (localObject1 != null)
                    {
                      localawjm.jdField_a_of_type_Int = 0;
                      localawjm.jdField_a_of_type_JavaLangObject = localObject1;
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
                awiw.b(this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awij.jdField_a_of_type_Awih.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i + "] " + localObject2.getClass().getSimpleName());
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
      for (int j = 0; k < this.jdField_a_of_type_Awij.jdField_a_of_type_JavaUtilArrayList.size(); j = i)
      {
        parambbax = (awjf)this.jdField_a_of_type_Awij.jdField_a_of_type_JavaUtilList.get(k);
        parambbbm = (awjm)this.jdField_a_of_type_Awij.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + parambbax.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString);
        }
        i = j;
        if (parambbbm.jdField_a_of_type_Int == -2)
        {
          i = j;
          if (!a(parambbax))
          {
            parambbax.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString = aupg.a((QQAppInterface)this.jdField_a_of_type_Awij.jdField_a_of_type_JavaLangRefWeakReference.get());
            parambbax.jdField_a_of_type_Awju.jdField_f_of_type_JavaLangString = bdhb.c(parambbax.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString);
            parambbax.jdField_a_of_type_Awju.l = 1;
            parambbax.jdField_a_of_type_Awju.j = 242;
            parambbax.jdField_a_of_type_Awju.k = 192;
            parambbax.jdField_a_of_type_Awju.c = aupg.a();
            parambbax.jdField_a_of_type_Awju.h = parambbax.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString;
            parambbax.jdField_a_of_type_Awju.jdField_f_of_type_Int = 192;
            parambbax.jdField_a_of_type_Awju.e = 242;
            parambbax.jdField_a_of_type_Awjd.jdField_f_of_type_JavaLangString = parambbax.jdField_a_of_type_Awju.jdField_f_of_type_JavaLangString;
            parambbbm.b = true;
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + parambbax.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString);
              i = j;
            }
          }
        }
        k += 1;
      }
      if ((j != 0) && (!this.jdField_a_of_type_Awij.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Awij.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Awij.a(new Void[0]);
        return;
      }
      this.jdField_a_of_type_Awij.jdField_a_of_type_Boolean = false;
      b();
      return;
    }
    awij.a(this.jdField_a_of_type_Awij);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awik
 * JD-Core Version:    0.7.0.1
 */