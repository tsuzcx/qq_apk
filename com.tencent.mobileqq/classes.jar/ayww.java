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

class ayww
  implements bedc
{
  private volatile long jdField_a_of_type_Long;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  
  ayww(aywv paramaywv) {}
  
  private int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (((ayxy)localIterator.next()).jdField_a_of_type_Int == -2) {
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
  
  private String a(ayxr paramayxr)
  {
    Object localObject3 = null;
    if (paramayxr.jdField_a_of_type_Ayyg.l == 1) {}
    Object localObject1;
    for (int i = 1; paramayxr.jdField_a_of_type_Int >= 0; i = 0)
    {
      localObject1 = paramayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString;
      return localObject1;
    }
    if (bgmg.b(paramayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString))
    {
      localObject1 = new CompressInfo(paramayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString, 0, 1009);
      ayyz.a((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).e;
      ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = bdzx.a(paramayxr, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = bdsh.d(((URL)localObject2).toString()); bgmg.b((String)localObject2); localObject2 = null)
        {
          ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          return localObject2;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = bdzx.a(paramayxr, 131075, null);
          if (localObject2 == null) {
            break label416;
          }
        }
        label416:
        for (String str = bdsh.d(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (bgmg.b(str))
          {
            localObject1 = new CompressInfo(str, 0);
            ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
            ayyz.a((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).e;
            ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = bdzx.a(paramayxr, 65537, null);
          paramayxr = localObject3;
          if (localObject1 != null) {
            paramayxr = bdsh.d(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!bgmg.b(paramayxr)) {
            break;
          }
          ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramayxr);
          return paramayxr;
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
      if (((QQAppInterface)this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
        localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
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
        ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.convert2CustomFace", aywv.a(this.jdField_a_of_type_Aywv, localCustomFace));
        return localCustomFace;
        if (paramNotOnlineImage.download_path.has()) {
          localCustomFace.str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
        }
      }
      return null;
    }
    catch (Exception paramNotOnlineImage)
    {
      ayxi.b(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + paramNotOnlineImage.toString());
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
      ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + aywv.a(this.jdField_a_of_type_Aywv, localNotOnlineImage));
      return localNotOnlineImage;
    }
    catch (Exception paramCustomFace)
    {
      ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + paramCustomFace.toString());
    }
    return null;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaUtilList.size();
    int j = a();
    ayxy localayxy = new ayxy();
    localayxy.jdField_a_of_type_Int = 0;
    localayxy.jdField_a_of_type_JavaLangObject = Integer.valueOf(i - j);
    this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a(6, 0, localayxy);
  }
  
  private boolean a(ayxr paramayxr)
  {
    if (paramayxr != null)
    {
      ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "checkFowardPicInfo", "info:" + paramayxr);
      if (paramayxr.jdField_a_of_type_Ayyg == null)
      {
        paramayxr.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramayxr.jdField_a_of_type_Ayyg.b == 1000) || (paramayxr.jdField_a_of_type_Ayyg.b == 1020) || (paramayxr.jdField_a_of_type_Ayyg.b == 1004)) && (paramayxr.jdField_a_of_type_Ayyg.d == null))
      {
        paramayxr.a("PicFowardInfo.check", "secondId invalid,uinType:" + paramayxr.jdField_a_of_type_Ayyg.b + ",secondId:" + paramayxr.jdField_a_of_type_Ayyg.d);
        return false;
      }
      if (paramayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_Int == -1)
      {
        paramayxr.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramayxr.jdField_a_of_type_Ayyg.jdField_g_of_type_Int);
        return false;
      }
      if (a(paramayxr) != null) {
        return true;
      }
      paramayxr.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    ayxi.b(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b()
  {
    new aywx(this).execute(new Void[0]);
  }
  
  public void a(bebv parambebv, beck parambeck)
  {
    ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "start");
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "onBusiProtoResp miao size =  [" + parambeck.jdField_a_of_type_JavaUtilList.size());
    }
    if ((parambebv != null) && (parambeck != null))
    {
      i = 0;
      if (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (ayxr)this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaUtilList.get(i);
        ayxy localayxy = (ayxy)this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaUtilArrayList.get(i);
        Object localObject2 = (becx)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject2 instanceof becm))
        {
          localObject2 = (becm)localObject2;
          ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i + "]," + ((becm)localObject2).toString());
          if ((((becm)localObject2).c == 0) && (((becm)localObject2).jdField_a_of_type_Boolean))
          {
            localObject2 = this.jdField_a_of_type_Aywv.a((bece)parambebv.jdField_a_of_type_JavaUtilList.get(i), (becm)localObject2, i);
            if ((((ayxr)localObject1).jdField_a_of_type_Ayxp.b != 1) && (((ayxr)localObject1).jdField_a_of_type_Ayxp.b != 3000)) {
              break label412;
            }
            ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i + "] ");
            localObject1 = a((im_msg_body.NotOnlineImage)localObject2);
            if (localObject1 != null)
            {
              localayxy.jdField_a_of_type_Int = 0;
              localayxy.jdField_a_of_type_JavaLangObject = localObject1;
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
            localayxy.jdField_a_of_type_Int = 0;
            localayxy.jdField_a_of_type_JavaLangObject = localObject2;
            a();
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              continue;
              if ((localObject2 instanceof becp))
              {
                localObject2 = (becp)localObject2;
                ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i + "]," + ((becp)localObject2).toString());
                if ((((becp)localObject2).c == 0) && (((becp)localObject2).jdField_a_of_type_Boolean))
                {
                  localObject2 = this.jdField_a_of_type_Aywv.a((bece)parambebv.jdField_a_of_type_JavaUtilList.get(i), (becp)localObject2, i);
                  if ((((ayxr)localObject1).jdField_a_of_type_Ayxp.b == 1) || (((ayxr)localObject1).jdField_a_of_type_Ayxp.b == 3000))
                  {
                    if (localObject2 != null)
                    {
                      localayxy.jdField_a_of_type_Int = 0;
                      localayxy.jdField_a_of_type_JavaLangObject = localObject2;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                  else
                  {
                    ayxi.a(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i + "] ");
                    localObject1 = a((im_msg_body.CustomFace)localObject2);
                    if (localObject1 != null)
                    {
                      localayxy.jdField_a_of_type_Int = 0;
                      localayxy.jdField_a_of_type_JavaLangObject = localObject1;
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
                ayxi.b(this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywv.jdField_a_of_type_Aywt.a, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i + "] " + localObject2.getClass().getSimpleName());
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
      for (int j = 0; k < this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaUtilArrayList.size(); j = i)
      {
        parambebv = (ayxr)this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaUtilList.get(k);
        parambeck = (ayxy)this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + parambebv.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString);
        }
        i = j;
        if (parambeck.jdField_a_of_type_Int == -2)
        {
          i = j;
          if (!a(parambebv))
          {
            parambebv.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString = awwm.a((QQAppInterface)this.jdField_a_of_type_Aywv.jdField_a_of_type_JavaLangRefWeakReference.get());
            parambebv.jdField_a_of_type_Ayyg.jdField_f_of_type_JavaLangString = bgmg.c(parambebv.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString);
            parambebv.jdField_a_of_type_Ayyg.l = 1;
            parambebv.jdField_a_of_type_Ayyg.j = 242;
            parambebv.jdField_a_of_type_Ayyg.k = 192;
            parambebv.jdField_a_of_type_Ayyg.c = awwm.a();
            parambebv.jdField_a_of_type_Ayyg.h = parambebv.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString;
            parambebv.jdField_a_of_type_Ayyg.jdField_f_of_type_Int = 192;
            parambebv.jdField_a_of_type_Ayyg.e = 242;
            parambebv.jdField_a_of_type_Ayxp.jdField_f_of_type_JavaLangString = parambebv.jdField_a_of_type_Ayyg.jdField_f_of_type_JavaLangString;
            parambeck.b = true;
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + parambebv.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString);
              i = j;
            }
          }
        }
        k += 1;
      }
      if ((j != 0) && (!this.jdField_a_of_type_Aywv.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Aywv.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Aywv.a(new Void[0]);
        return;
      }
      this.jdField_a_of_type_Aywv.jdField_a_of_type_Boolean = false;
      b();
      return;
    }
    aywv.a(this.jdField_a_of_type_Aywv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayww
 * JD-Core Version:    0.7.0.1
 */