import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

class ayct
  implements ayeo
{
  final int jdField_a_of_type_Int;
  final Rect jdField_a_of_type_AndroidGraphicsRect;
  final aydn jdField_a_of_type_Aydn;
  final aydt jdField_a_of_type_Aydt;
  
  ayct(aycs paramaycs, int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aydt = ((aydt)paramaycs.a.a.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Aydn = ((aydn)paramaycs.a.a.jdField_a_of_type_JavaUtilList.get(paramInt));
    this.jdField_a_of_type_AndroidGraphicsRect = a(paramString);
  }
  
  private Rect a(String paramString)
  {
    int j = 198;
    Rect localRect = new Rect(0, 0, 0, 0);
    int m;
    int n;
    int i;
    int k;
    float f;
    if (paramString != null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, localOptions);
      m = localOptions.outWidth;
      n = localOptions.outHeight;
      i = Math.min(m, n);
      k = Math.max(m, n);
      f = k / i;
      if (i <= 198) {
        break label136;
      }
      if (f <= 3.0F) {
        break label122;
      }
      i = 66;
    }
    for (;;)
    {
      if (m < n)
      {
        localRect.right = i;
        localRect.bottom = j;
        return localRect;
        label122:
        i = (int)(i * 198.0F / k);
        continue;
        label136:
        if ((i > 66) && (i <= 198))
        {
          if (f > 3.0F)
          {
            i = 66;
            continue;
          }
          if (k >= 198) {
            i = (int)(i * 198.0F / k);
          }
        }
        else if ((i > 66) || (f <= 3.0F) || (k < 198)) {}
      }
      else
      {
        localRect.right = j;
        localRect.bottom = i;
        return localRect;
      }
      j = k;
    }
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText arg1)
  {
    Object localObject1;
    if ((??? != null) && (???.elems.has()))
    {
      ??? = (im_msg_body.Elem)???.elems.get(0);
      if (??? != null) {
        if (???.not_online_image.has())
        {
          localObject1 = (im_msg_body.NotOnlineImage)???.not_online_image.get();
          ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_width.set(this.jdField_a_of_type_AndroidGraphicsRect.right);
          ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_height.set(this.jdField_a_of_type_AndroidGraphicsRect.bottom);
          if ((this.jdField_a_of_type_Aydn.a.b == 1) || (this.jdField_a_of_type_Aydn.a.b == 3000))
          {
            ayde.a(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "convert2CustomFace for [" + this.jdField_a_of_type_Int + "] ");
            localObject1 = aycr.a(this.jdField_a_of_type_Aycs.a, (im_msg_body.NotOnlineImage)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_Aydt.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Aydt.jdField_a_of_type_JavaLangObject = localObject1;
        ayde.a(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + aycq.a(this.jdField_a_of_type_Aycs.a.a, (im_msg_body.CustomFace)localObject1));
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
        }
        i = 1;
        if (i != 0) {}
      }
      synchronized (this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_Aydt.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_Aydt.jdField_a_of_type_Aydp = new aydp();
        this.jdField_a_of_type_Aydt.jdField_a_of_type_Aydp.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_Aydt.jdField_a_of_type_Aydp.b = ("Get target pic filepath of [" + this.jdField_a_of_type_Int + "] failed");
        if ((this.jdField_a_of_type_Aydn.a.b == 1) || (this.jdField_a_of_type_Aydn.a.b == 3000))
        {
          this.jdField_a_of_type_Aydt.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Aycs.a.a.a(null, null, this.jdField_a_of_type_Int);
          ayde.b(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, errDec ＝ " + this.jdField_a_of_type_Aydt.jdField_a_of_type_Aydp.b);
          if (QLog.isColorLevel()) {
            QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] failed, errDec ＝ " + this.jdField_a_of_type_Aydt.jdField_a_of_type_Aydp.b);
          }
          aycr.a(this.jdField_a_of_type_Aycs.a);
          if (aycr.a(this.jdField_a_of_type_Aycs.a) == 0) {
            aycq.a(this.jdField_a_of_type_Aycs.a.a);
          }
          return null;
          localNotOnlineImage1 = finally;
          throw localNotOnlineImage1;
          synchronized (this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_JavaUtilArrayList)
          {
            this.jdField_a_of_type_Aydt.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_Aydt.jdField_a_of_type_JavaLangObject = localNotOnlineImage1;
            ayde.a(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + aycq.a(this.jdField_a_of_type_Aycs.a.a, localNotOnlineImage1));
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
          }
          if (???.custom_face.has())
          {
            im_msg_body.CustomFace localCustomFace1 = (im_msg_body.CustomFace)???.custom_face.get();
            localCustomFace1.uint32_thumb_width.set(this.jdField_a_of_type_AndroidGraphicsRect.right);
            localCustomFace1.uint32_thumb_height.set(this.jdField_a_of_type_AndroidGraphicsRect.bottom);
            if ((this.jdField_a_of_type_Aydn.a.b == 1) || (this.jdField_a_of_type_Aydn.a.b == 3000)) {}
            for (;;)
            {
              synchronized (this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_JavaUtilArrayList)
              {
                this.jdField_a_of_type_Aydt.jdField_a_of_type_Int = 0;
                this.jdField_a_of_type_Aydt.jdField_a_of_type_JavaLangObject = localCustomFace1;
                ayde.a(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + aycq.a(this.jdField_a_of_type_Aycs.a.a, localCustomFace1));
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
                }
                i = 1;
              }
              ayde.a(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "convert2NotOnlineImage for [" + this.jdField_a_of_type_Int + "] ");
              im_msg_body.NotOnlineImage localNotOnlineImage2 = aycr.a(this.jdField_a_of_type_Aycs.a, localCustomFace2);
              synchronized (this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_JavaUtilArrayList)
              {
                this.jdField_a_of_type_Aydt.jdField_a_of_type_Int = 0;
                this.jdField_a_of_type_Aydt.jdField_a_of_type_JavaLangObject = localNotOnlineImage2;
                ayde.a(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + aycq.a(this.jdField_a_of_type_Aycs.a.a, localNotOnlineImage2));
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
                }
              }
            }
          }
          ayde.b(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, elem.not_online_image and elem.custom_face are null");
          i = 0;
          continue;
          ayde.b(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, richText.elems is null");
          for (;;)
          {
            i = 0;
            break;
            ayde.b(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, richText is null or richText.elems is null");
          }
        }
        this.jdField_a_of_type_Aydt.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Aycs.a.a.a(null, null, this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void onSend(ayep paramayep)
  {
    synchronized (this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_JavaUtilArrayList)
    {
      if (paramayep.jdField_a_of_type_Int != 0)
      {
        this.jdField_a_of_type_Aydt.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_Aydt.jdField_a_of_type_Aydp = new aydp();
        this.jdField_a_of_type_Aydt.jdField_a_of_type_Aydp.b = paramayep.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Aydt.jdField_a_of_type_Aydp.jdField_a_of_type_Int = paramayep.b;
        if ((this.jdField_a_of_type_Aydn.a.b != 1) && (this.jdField_a_of_type_Aydn.a.b != 3000)) {
          break label299;
        }
        this.jdField_a_of_type_Aydt.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Aycs.a.a.a(null, null, this.jdField_a_of_type_Int);
        ayde.a(this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.b, this.jdField_a_of_type_Aycs.a.a.jdField_a_of_type_Ayco.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onSend", "[" + this.jdField_a_of_type_Int + "] failed, errDec = " + this.jdField_a_of_type_Aydt.jdField_a_of_type_Aydp.b);
        if (QLog.isColorLevel()) {
          QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] failed, errDec ＝ " + this.jdField_a_of_type_Aydt.jdField_a_of_type_Aydp.b);
        }
        aycr.a(this.jdField_a_of_type_Aycs.a);
        if (aycr.a(this.jdField_a_of_type_Aycs.a) == 0) {
          aycq.a(this.jdField_a_of_type_Aycs.a.a);
        }
      }
      return;
      label299:
      this.jdField_a_of_type_Aydt.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Aycs.a.a.a(null, null, this.jdField_a_of_type_Int);
    }
  }
  
  public void updateMsg(ayep paramayep) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayct
 * JD-Core Version:    0.7.0.1
 */