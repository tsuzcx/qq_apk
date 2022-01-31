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

class awim
  implements awkh
{
  final int jdField_a_of_type_Int;
  final Rect jdField_a_of_type_AndroidGraphicsRect;
  final awjf jdField_a_of_type_Awjf;
  final awjm jdField_a_of_type_Awjm;
  
  awim(awil paramawil, int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Awjm = ((awjm)paramawil.a.a.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Awjf = ((awjf)paramawil.a.a.jdField_a_of_type_JavaUtilList.get(paramInt));
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
  
  public MessageRecord a(im_msg_body.RichText arg1)
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
          if ((this.jdField_a_of_type_Awjf.a.b == 1) || (this.jdField_a_of_type_Awjf.a.b == 3000))
          {
            awiw.a(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "convert2CustomFace for [" + this.jdField_a_of_type_Int + "] ");
            localObject1 = awik.a(this.jdField_a_of_type_Awil.a, (im_msg_body.NotOnlineImage)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_Awjm.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Awjm.jdField_a_of_type_JavaLangObject = localObject1;
        awiw.a(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + awij.a(this.jdField_a_of_type_Awil.a.a, (im_msg_body.CustomFace)localObject1));
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
        }
        i = 1;
        if (i != 0) {}
      }
      synchronized (this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_Awjm.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_Awjm.jdField_a_of_type_Awjh = new awjh();
        this.jdField_a_of_type_Awjm.jdField_a_of_type_Awjh.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_Awjm.jdField_a_of_type_Awjh.b = ("Get target pic filepath of [" + this.jdField_a_of_type_Int + "] failed");
        if ((this.jdField_a_of_type_Awjf.a.b == 1) || (this.jdField_a_of_type_Awjf.a.b == 3000))
        {
          this.jdField_a_of_type_Awjm.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Awil.a.a.a(null, null, this.jdField_a_of_type_Int);
          awiw.b(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, errDec ＝ " + this.jdField_a_of_type_Awjm.jdField_a_of_type_Awjh.b);
          if (QLog.isColorLevel()) {
            QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] failed, errDec ＝ " + this.jdField_a_of_type_Awjm.jdField_a_of_type_Awjh.b);
          }
          awik.a(this.jdField_a_of_type_Awil.a);
          if (awik.a(this.jdField_a_of_type_Awil.a) == 0) {
            awij.a(this.jdField_a_of_type_Awil.a.a);
          }
          return null;
          localNotOnlineImage1 = finally;
          throw localNotOnlineImage1;
          synchronized (this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_JavaUtilArrayList)
          {
            this.jdField_a_of_type_Awjm.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_Awjm.jdField_a_of_type_JavaLangObject = localNotOnlineImage1;
            awiw.a(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + awij.a(this.jdField_a_of_type_Awil.a.a, localNotOnlineImage1));
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
            if ((this.jdField_a_of_type_Awjf.a.b == 1) || (this.jdField_a_of_type_Awjf.a.b == 3000)) {}
            for (;;)
            {
              synchronized (this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_JavaUtilArrayList)
              {
                this.jdField_a_of_type_Awjm.jdField_a_of_type_Int = 0;
                this.jdField_a_of_type_Awjm.jdField_a_of_type_JavaLangObject = localCustomFace1;
                awiw.a(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + awij.a(this.jdField_a_of_type_Awil.a.a, localCustomFace1));
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
                }
                i = 1;
              }
              awiw.a(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "convert2NotOnlineImage for [" + this.jdField_a_of_type_Int + "] ");
              im_msg_body.NotOnlineImage localNotOnlineImage2 = awik.a(this.jdField_a_of_type_Awil.a, localCustomFace2);
              synchronized (this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_JavaUtilArrayList)
              {
                this.jdField_a_of_type_Awjm.jdField_a_of_type_Int = 0;
                this.jdField_a_of_type_Awjm.jdField_a_of_type_JavaLangObject = localNotOnlineImage2;
                awiw.a(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + awij.a(this.jdField_a_of_type_Awil.a.a, localNotOnlineImage2));
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
                }
              }
            }
          }
          awiw.b(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, elem.not_online_image and elem.custom_face are null");
          i = 0;
          continue;
          awiw.b(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, richText.elems is null");
          for (;;)
          {
            i = 0;
            break;
            awiw.b(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, richText is null or richText.elems is null");
          }
        }
        this.jdField_a_of_type_Awjm.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Awil.a.a.a(null, null, this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
  {
    synchronized (this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_JavaUtilArrayList)
    {
      if (paramawki.jdField_a_of_type_Int != 0)
      {
        this.jdField_a_of_type_Awjm.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_Awjm.jdField_a_of_type_Awjh = new awjh();
        this.jdField_a_of_type_Awjm.jdField_a_of_type_Awjh.b = paramawki.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Awjm.jdField_a_of_type_Awjh.jdField_a_of_type_Int = paramawki.b;
        if ((this.jdField_a_of_type_Awjf.a.b != 1) && (this.jdField_a_of_type_Awjf.a.b != 3000)) {
          break label299;
        }
        this.jdField_a_of_type_Awjm.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Awil.a.a.a(null, null, this.jdField_a_of_type_Int);
        awiw.a(this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awil.a.a.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onSend", "[" + this.jdField_a_of_type_Int + "] failed, errDec = " + this.jdField_a_of_type_Awjm.jdField_a_of_type_Awjh.b);
        if (QLog.isColorLevel()) {
          QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] failed, errDec ＝ " + this.jdField_a_of_type_Awjm.jdField_a_of_type_Awjh.b);
        }
        awik.a(this.jdField_a_of_type_Awil.a);
        if (awik.a(this.jdField_a_of_type_Awil.a) == 0) {
          awij.a(this.jdField_a_of_type_Awil.a.a);
        }
      }
      return;
      label299:
      this.jdField_a_of_type_Awjm.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Awil.a.a.a(null, null, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awim
 * JD-Core Version:    0.7.0.1
 */