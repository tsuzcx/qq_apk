import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import tencent.im.msg.im_msg_body.RichText;

class aula
  implements awfy
{
  int jdField_a_of_type_Int;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  String jdField_a_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  
  public aula(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt, ArrayList<MessageRecord> paramArrayList, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    return localBitmap;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awfz paramawfz) {}
  
  public void b(awfz paramawfz)
  {
    if (paramawfz.jdField_a_of_type_Int == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "send real struct msg for weixin done, cost : " + (System.currentTimeMillis() - aukx.b()));
      }
    }
    for (;;)
    {
      String str2;
      Object localObject2;
      long l;
      try
      {
        String str1;
        String str3;
        if (this.jdField_a_of_type_Int == 0)
        {
          str1 = String.format(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplication().getString(2131694570), new Object[] { bdbt.b((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c()), bdbt.b((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString) });
          str3 = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg;
          str2 = "https://mma.qq.com/jumpqq/forward2.html?rId=" + paramawfz.c + "&fName=" + paramawfz.d;
          if (this.jdField_a_of_type_Int == 1)
          {
            i = 4;
            localObject2 = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(i, this.jdField_a_of_type_JavaLangString, (byte)1, false, 0);
            if (localObject2 != null) {
              continue;
            }
          }
        }
        else
        {
          str1 = String.format(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplication().getString(2131694571), new Object[] { bdbt.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int) });
          continue;
        }
        if (this.jdField_a_of_type_Int != 3000) {
          break label581;
        }
        i = 101;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "send to weixin icon != null  ");
        }
        Object localObject1 = localObject2;
        if (this.jdField_a_of_type_Int == 3000) {
          localObject1 = a((Bitmap)localObject2);
        }
        localObject2 = String.valueOf(System.currentTimeMillis());
        WXShareHelper.a().d((String)localObject2, str1, (Bitmap)localObject1, str3, str2);
        l = paramawfz.c.hashCode();
        paramawfz = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (paramawfz.hasNext())
        {
          ((MessageRecord)paramawfz.next()).msgseq = l;
          continue;
        }
        ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a().a(this.jdField_a_of_type_JavaUtilArrayList, null);
      }
      catch (Exception paramawfz)
      {
        paramawfz.printStackTrace();
        return;
      }
      aukx.a().a(this.jdField_a_of_type_JavaUtilHashMap, l, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      ((MessageHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(0)).notifyUI(8031, false, Integer.valueOf(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("MultiMsg_TAG", 2, "shareToWXFriend.transaction: " + (String)localObject2 + ", shareLink:" + str2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "upload multi msg pack failed, result.errStr=" + paramawfz.b + ",result.errStr=" + paramawfz.jdField_a_of_type_JavaLangString);
      }
      ((MessageHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(0)).notifyUI(8031, false, Integer.valueOf(5));
      return;
      label581:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aula
 * JD-Core Version:    0.7.0.1
 */