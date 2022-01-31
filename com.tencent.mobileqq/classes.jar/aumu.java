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

class aumu
  implements ayzw
{
  private volatile long jdField_a_of_type_Long;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  
  aumu(aumt paramaumt) {}
  
  private int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (((aunw)localIterator.next()).jdField_a_of_type_Int == -2) {
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
  
  private String a(aunp paramaunp)
  {
    Object localObject3 = null;
    if (paramaunp.jdField_a_of_type_Auod.l == 1) {}
    Object localObject1;
    for (int i = 1; paramaunp.jdField_a_of_type_Int >= 0; i = 0)
    {
      localObject1 = paramaunp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString;
      return localObject1;
    }
    if (bbdx.b(paramaunp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString))
    {
      localObject1 = new CompressInfo(paramaunp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString, 0, 1009);
      auos.a((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).e;
      aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = aywm.a(paramaunp, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = ayoi.d(((URL)localObject2).toString()); bbdx.b((String)localObject2); localObject2 = null)
        {
          aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          return localObject2;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = aywm.a(paramaunp, 131075, null);
          if (localObject2 == null) {
            break label416;
          }
        }
        label416:
        for (String str = ayoi.d(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (bbdx.b(str))
          {
            localObject1 = new CompressInfo(str, 0);
            ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
            auos.a((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).e;
            aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = aywm.a(paramaunp, 65537, null);
          paramaunp = localObject3;
          if (localObject1 != null) {
            paramaunp = ayoi.d(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!bbdx.b(paramaunp)) {
            break;
          }
          aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramaunp);
          return paramaunp;
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
      if (((QQAppInterface)this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
        localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
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
        aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.convert2CustomFace", aumt.a(this.jdField_a_of_type_Aumt, localCustomFace));
        return localCustomFace;
        if (paramNotOnlineImage.download_path.has()) {
          localCustomFace.str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
        }
      }
      return null;
    }
    catch (Exception paramNotOnlineImage)
    {
      aung.b(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + paramNotOnlineImage.toString());
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
      aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + aumt.a(this.jdField_a_of_type_Aumt, localNotOnlineImage));
      return localNotOnlineImage;
    }
    catch (Exception paramCustomFace)
    {
      aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + paramCustomFace.toString());
    }
    return null;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaUtilList.size();
    int j = a();
    aunw localaunw = new aunw();
    localaunw.jdField_a_of_type_Int = 0;
    localaunw.jdField_a_of_type_JavaLangObject = Integer.valueOf(i - j);
    this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a(6, 0, localaunw);
  }
  
  private boolean a(aunp paramaunp)
  {
    if (paramaunp != null)
    {
      aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "checkFowardPicInfo", "info:" + paramaunp);
      if (paramaunp.jdField_a_of_type_Auod == null)
      {
        paramaunp.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramaunp.jdField_a_of_type_Auod.b == 1000) || (paramaunp.jdField_a_of_type_Auod.b == 1020) || (paramaunp.jdField_a_of_type_Auod.b == 1004)) && (paramaunp.jdField_a_of_type_Auod.d == null))
      {
        paramaunp.a("PicFowardInfo.check", "secondId invalid,uinType:" + paramaunp.jdField_a_of_type_Auod.b + ",secondId:" + paramaunp.jdField_a_of_type_Auod.d);
        return false;
      }
      if (paramaunp.jdField_a_of_type_Auod.jdField_g_of_type_Int == -1)
      {
        paramaunp.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramaunp.jdField_a_of_type_Auod.jdField_g_of_type_Int);
        return false;
      }
      if (a(paramaunp) != null) {
        return true;
      }
      paramaunp.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    aung.b(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b()
  {
    new aumv(this).execute(new Void[0]);
  }
  
  public void a(ayyp paramayyp, ayze paramayze)
  {
    aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "start");
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "onBusiProtoResp miao size =  [" + paramayze.jdField_a_of_type_JavaUtilList.size());
    }
    if ((paramayyp != null) && (paramayze != null))
    {
      i = 0;
      if (i < paramayze.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (aunp)this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaUtilList.get(i);
        aunw localaunw = (aunw)this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaUtilArrayList.get(i);
        Object localObject2 = (ayzr)paramayze.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject2 instanceof ayzg))
        {
          localObject2 = (ayzg)localObject2;
          aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i + "]," + ((ayzg)localObject2).toString());
          if ((((ayzg)localObject2).c == 0) && (((ayzg)localObject2).jdField_a_of_type_Boolean))
          {
            localObject2 = this.jdField_a_of_type_Aumt.a((ayyy)paramayyp.jdField_a_of_type_JavaUtilList.get(i), (ayzg)localObject2, i);
            if ((((aunp)localObject1).jdField_a_of_type_Aunn.b != 1) && (((aunp)localObject1).jdField_a_of_type_Aunn.b != 3000)) {
              break label412;
            }
            aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i + "] ");
            localObject1 = a((im_msg_body.NotOnlineImage)localObject2);
            if (localObject1 != null)
            {
              localaunw.jdField_a_of_type_Int = 0;
              localaunw.jdField_a_of_type_JavaLangObject = localObject1;
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
            localaunw.jdField_a_of_type_Int = 0;
            localaunw.jdField_a_of_type_JavaLangObject = localObject2;
            a();
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              continue;
              if ((localObject2 instanceof ayzj))
              {
                localObject2 = (ayzj)localObject2;
                aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i + "]," + ((ayzj)localObject2).toString());
                if ((((ayzj)localObject2).c == 0) && (((ayzj)localObject2).jdField_a_of_type_Boolean))
                {
                  localObject2 = this.jdField_a_of_type_Aumt.a((ayyy)paramayyp.jdField_a_of_type_JavaUtilList.get(i), (ayzj)localObject2, i);
                  if ((((aunp)localObject1).jdField_a_of_type_Aunn.b == 1) || (((aunp)localObject1).jdField_a_of_type_Aunn.b == 3000))
                  {
                    if (localObject2 != null)
                    {
                      localaunw.jdField_a_of_type_Int = 0;
                      localaunw.jdField_a_of_type_JavaLangObject = localObject2;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                  else
                  {
                    aung.a(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i + "] ");
                    localObject1 = a((im_msg_body.CustomFace)localObject2);
                    if (localObject1 != null)
                    {
                      localaunw.jdField_a_of_type_Int = 0;
                      localaunw.jdField_a_of_type_JavaLangObject = localObject1;
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
                aung.b(this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumt.jdField_a_of_type_Aumr.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i + "] " + localObject2.getClass().getSimpleName());
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
      for (int j = 0; k < this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaUtilArrayList.size(); j = i)
      {
        paramayyp = (aunp)this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaUtilList.get(k);
        paramayze = (aunw)this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + paramayyp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString);
        }
        i = j;
        if (paramayze.jdField_a_of_type_Int == -2)
        {
          i = j;
          if (!a(paramayyp))
          {
            paramayyp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString = asua.a((QQAppInterface)this.jdField_a_of_type_Aumt.jdField_a_of_type_JavaLangRefWeakReference.get());
            paramayyp.jdField_a_of_type_Auod.jdField_f_of_type_JavaLangString = bbdx.c(paramayyp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString);
            paramayyp.jdField_a_of_type_Auod.l = 1;
            paramayyp.jdField_a_of_type_Auod.j = 242;
            paramayyp.jdField_a_of_type_Auod.k = 192;
            paramayyp.jdField_a_of_type_Auod.c = asua.a();
            paramayyp.jdField_a_of_type_Auod.h = paramayyp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString;
            paramayyp.jdField_a_of_type_Auod.jdField_f_of_type_Int = 192;
            paramayyp.jdField_a_of_type_Auod.e = 242;
            paramayyp.jdField_a_of_type_Aunn.jdField_f_of_type_JavaLangString = paramayyp.jdField_a_of_type_Auod.jdField_f_of_type_JavaLangString;
            paramayze.b = true;
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + paramayyp.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString);
              i = j;
            }
          }
        }
        k += 1;
      }
      if ((j != 0) && (!this.jdField_a_of_type_Aumt.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Aumt.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Aumt.a(new Void[0]);
        return;
      }
      this.jdField_a_of_type_Aumt.jdField_a_of_type_Boolean = false;
      b();
      return;
    }
    aumt.a(this.jdField_a_of_type_Aumt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumu
 * JD-Core Version:    0.7.0.1
 */