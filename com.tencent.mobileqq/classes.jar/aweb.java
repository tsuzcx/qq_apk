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

class aweb
  implements baxv
{
  private volatile long jdField_a_of_type_Long;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  
  aweb(awea paramawea) {}
  
  private int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Awea.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_Awea.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (((awfd)localIterator.next()).jdField_a_of_type_Int == -2) {
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
  
  private String a(awew paramawew)
  {
    Object localObject3 = null;
    if (paramawew.jdField_a_of_type_Awfl.l == 1) {}
    Object localObject1;
    for (int i = 1; paramawew.jdField_a_of_type_Int >= 0; i = 0)
    {
      localObject1 = paramawew.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString;
      return localObject1;
    }
    if (bdcs.b(paramawew.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString))
    {
      localObject1 = new CompressInfo(paramawew.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString, 0, 1009);
      awga.a((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).e;
      awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = baul.a(paramawew, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = bame.d(((URL)localObject2).toString()); bdcs.b((String)localObject2); localObject2 = null)
        {
          awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          return localObject2;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = baul.a(paramawew, 131075, null);
          if (localObject2 == null) {
            break label416;
          }
        }
        label416:
        for (String str = bame.d(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (bdcs.b(str))
          {
            localObject1 = new CompressInfo(str, 0);
            ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
            awga.a((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).e;
            awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = baul.a(paramawew, 65537, null);
          paramawew = localObject3;
          if (localObject1 != null) {
            paramawew = bame.d(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!bdcs.b(paramawew)) {
            break;
          }
          awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramawew);
          return paramawew;
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
      if (((QQAppInterface)this.jdField_a_of_type_Awea.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
        localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_Awea.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
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
        awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.convert2CustomFace", awea.a(this.jdField_a_of_type_Awea, localCustomFace));
        return localCustomFace;
        if (paramNotOnlineImage.download_path.has()) {
          localCustomFace.str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
        }
      }
      return null;
    }
    catch (Exception paramNotOnlineImage)
    {
      awen.b(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + paramNotOnlineImage.toString());
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
      awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + awea.a(this.jdField_a_of_type_Awea, localNotOnlineImage));
      return localNotOnlineImage;
    }
    catch (Exception paramCustomFace)
    {
      awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + paramCustomFace.toString());
    }
    return null;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Awea.jdField_a_of_type_JavaUtilList.size();
    int j = a();
    awfd localawfd = new awfd();
    localawfd.jdField_a_of_type_Int = 0;
    localawfd.jdField_a_of_type_JavaLangObject = Integer.valueOf(i - j);
    this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a(6, 0, localawfd);
  }
  
  private boolean a(awew paramawew)
  {
    if (paramawew != null)
    {
      awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "checkFowardPicInfo", "info:" + paramawew);
      if (paramawew.jdField_a_of_type_Awfl == null)
      {
        paramawew.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramawew.jdField_a_of_type_Awfl.b == 1000) || (paramawew.jdField_a_of_type_Awfl.b == 1020) || (paramawew.jdField_a_of_type_Awfl.b == 1004)) && (paramawew.jdField_a_of_type_Awfl.d == null))
      {
        paramawew.a("PicFowardInfo.check", "secondId invalid,uinType:" + paramawew.jdField_a_of_type_Awfl.b + ",secondId:" + paramawew.jdField_a_of_type_Awfl.d);
        return false;
      }
      if (paramawew.jdField_a_of_type_Awfl.jdField_g_of_type_Int == -1)
      {
        paramawew.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramawew.jdField_a_of_type_Awfl.jdField_g_of_type_Int);
        return false;
      }
      if (a(paramawew) != null) {
        return true;
      }
      paramawew.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    awen.b(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b()
  {
    new awec(this).execute(new Void[0]);
  }
  
  public void a(bawo parambawo, baxd parambaxd)
  {
    awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "start");
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "onBusiProtoResp miao size =  [" + parambaxd.jdField_a_of_type_JavaUtilList.size());
    }
    if ((parambawo != null) && (parambaxd != null))
    {
      i = 0;
      if (i < parambaxd.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (awew)this.jdField_a_of_type_Awea.jdField_a_of_type_JavaUtilList.get(i);
        awfd localawfd = (awfd)this.jdField_a_of_type_Awea.jdField_a_of_type_JavaUtilArrayList.get(i);
        Object localObject2 = (baxq)parambaxd.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject2 instanceof baxf))
        {
          localObject2 = (baxf)localObject2;
          awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i + "]," + ((baxf)localObject2).toString());
          if ((((baxf)localObject2).c == 0) && (((baxf)localObject2).jdField_a_of_type_Boolean))
          {
            localObject2 = this.jdField_a_of_type_Awea.a((bawx)parambawo.jdField_a_of_type_JavaUtilList.get(i), (baxf)localObject2, i);
            if ((((awew)localObject1).jdField_a_of_type_Aweu.b != 1) && (((awew)localObject1).jdField_a_of_type_Aweu.b != 3000)) {
              break label412;
            }
            awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i + "] ");
            localObject1 = a((im_msg_body.NotOnlineImage)localObject2);
            if (localObject1 != null)
            {
              localawfd.jdField_a_of_type_Int = 0;
              localawfd.jdField_a_of_type_JavaLangObject = localObject1;
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
            localawfd.jdField_a_of_type_Int = 0;
            localawfd.jdField_a_of_type_JavaLangObject = localObject2;
            a();
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              continue;
              if ((localObject2 instanceof baxi))
              {
                localObject2 = (baxi)localObject2;
                awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i + "]," + ((baxi)localObject2).toString());
                if ((((baxi)localObject2).c == 0) && (((baxi)localObject2).jdField_a_of_type_Boolean))
                {
                  localObject2 = this.jdField_a_of_type_Awea.a((bawx)parambawo.jdField_a_of_type_JavaUtilList.get(i), (baxi)localObject2, i);
                  if ((((awew)localObject1).jdField_a_of_type_Aweu.b == 1) || (((awew)localObject1).jdField_a_of_type_Aweu.b == 3000))
                  {
                    if (localObject2 != null)
                    {
                      localawfd.jdField_a_of_type_Int = 0;
                      localawfd.jdField_a_of_type_JavaLangObject = localObject2;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                  else
                  {
                    awen.a(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i + "] ");
                    localObject1 = a((im_msg_body.CustomFace)localObject2);
                    if (localObject1 != null)
                    {
                      localawfd.jdField_a_of_type_Int = 0;
                      localawfd.jdField_a_of_type_JavaLangObject = localObject1;
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
                awen.b(this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awea.jdField_a_of_type_Awdy.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i + "] " + localObject2.getClass().getSimpleName());
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
      for (int j = 0; k < this.jdField_a_of_type_Awea.jdField_a_of_type_JavaUtilArrayList.size(); j = i)
      {
        parambawo = (awew)this.jdField_a_of_type_Awea.jdField_a_of_type_JavaUtilList.get(k);
        parambaxd = (awfd)this.jdField_a_of_type_Awea.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + parambawo.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString);
        }
        i = j;
        if (parambaxd.jdField_a_of_type_Int == -2)
        {
          i = j;
          if (!a(parambawo))
          {
            parambawo.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString = aukx.a((QQAppInterface)this.jdField_a_of_type_Awea.jdField_a_of_type_JavaLangRefWeakReference.get());
            parambawo.jdField_a_of_type_Awfl.jdField_f_of_type_JavaLangString = bdcs.c(parambawo.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString);
            parambawo.jdField_a_of_type_Awfl.l = 1;
            parambawo.jdField_a_of_type_Awfl.j = 242;
            parambawo.jdField_a_of_type_Awfl.k = 192;
            parambawo.jdField_a_of_type_Awfl.c = aukx.a();
            parambawo.jdField_a_of_type_Awfl.h = parambawo.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString;
            parambawo.jdField_a_of_type_Awfl.jdField_f_of_type_Int = 192;
            parambawo.jdField_a_of_type_Awfl.e = 242;
            parambawo.jdField_a_of_type_Aweu.jdField_f_of_type_JavaLangString = parambawo.jdField_a_of_type_Awfl.jdField_f_of_type_JavaLangString;
            parambaxd.b = true;
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + parambawo.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString);
              i = j;
            }
          }
        }
        k += 1;
      }
      if ((j != 0) && (!this.jdField_a_of_type_Awea.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Awea.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Awea.a(new Void[0]);
        return;
      }
      this.jdField_a_of_type_Awea.jdField_a_of_type_Boolean = false;
      b();
      return;
    }
    awea.a(this.jdField_a_of_type_Awea);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aweb
 * JD-Core Version:    0.7.0.1
 */