import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import msf.msgsvc.msg_ctrl.MsgCtrl;

public class barc
  extends bark
  implements Handler.Callback, axwz
{
  Handler a;
  protected awif a;
  
  public barc(bard parambard, bayk parambayk)
  {
    super(parambard, parambayk);
    this.jdField_a_of_type_AndroidOsHandler = new bhtd(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Awif = awie.a(parambayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, parambayk);
  }
  
  private void r()
  {
    if (b())
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "handleQuickSendFailed:" + a());
      }
      bayu.a(a(), 65537, null, null).downloadImediatly();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Awif != null) {
      r();
    }
    return super.a();
  }
  
  protected int a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (afwu.a(paramMessageForPic)) {
      i = 5;
    }
    for (;;)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "getPicSourceReport:" + this.jdField_a_of_type_Bayk.e + " source:" + i);
      }
      return i;
      switch (this.jdField_a_of_type_Bayk.e)
      {
      default: 
        break;
      case 1009: 
      case 1031: 
      case 1048: 
        i = 4;
        break;
      case 1052: 
        i = 2;
        break;
      case 1050: 
        i = 1;
        break;
      case 1051: 
        i = 3;
        break;
      case 1053: 
        i = 7;
      }
    }
  }
  
  protected MessageForPic a()
  {
    Object localObject = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((localObject instanceof MessageForPic)) {
      localObject = (MessageForPic)localObject;
    }
    MessageForPic localMessageForPic;
    do
    {
      return localObject;
      if (!(localObject instanceof MessageForStructing)) {
        break;
      }
      localObject = (MessageForStructing)localObject;
      if ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break;
      }
      localObject = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
      if (localObject == null) {
        break;
      }
      localMessageForPic = ((azwy)localObject).a;
      localObject = localMessageForPic;
    } while (localMessageForPic != null);
    return null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, barh parambarh)
  {
    super.a(paramInt, paramString1, paramString2, parambarh);
    bazl.a(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramInt, paramString1, paramString2);
  }
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
  }
  
  protected void a(bbbg parambbbg)
  {
    if ((this.jdField_a_of_type_Awif != null) && (!this.jdField_a_of_type_Awif.jdField_a_of_type_Boolean))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "changeRequest,file Size:" + parambbbg.jdField_a_of_type_Long + " md5:" + parambbbg.jdField_a_of_type_ArrayOfByte + " busiType:" + this.jdField_a_of_type_Bayk.e + " quickSendObject:" + this.jdField_a_of_type_Awif);
      }
      parambbbg.jdField_a_of_type_Long = this.jdField_a_of_type_Awif.jdField_a_of_type_Long;
      parambbbg.jdField_a_of_type_ArrayOfByte = bdhe.a(this.jdField_a_of_type_Awif.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Bayk.e == 1042) {
        parambbbg.e = 1;
      }
    }
    apkh.a(this.jdField_a_of_type_Bayk, parambbbg);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    d(1003);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (!com.tencent.qphone.base.util.QLog.isColorLevel()) {}
    while (ConfigManager.mUseHardCodeIp != 1) {
      return;
    }
    azqy.a("BDH_UPLOAD_USE_HARDCORD_IP", (String)this.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
    ConfigManager.mUseHardCodeIp = 0;
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    String str2 = this.d;
    if (this.f == null) {}
    for (String str1 = this.l;; str1 = this.f)
    {
      a("actRichMediaNetMonitor_picUp", paramBoolean, paramInt, paramString1, paramString2, str2, str1, null);
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong) {}
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Bayk.h)
    {
      b(9333, "Server MD5 fast forward missed");
      d();
      return false;
    }
    if ((this.jdField_a_of_type_Awif != null) && (!this.jdField_a_of_type_Awif.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Awif.jdField_a_of_type_Boolean = true;
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "QuickSendFail");
      }
      f();
      return false;
    }
    if (this.jdField_a_of_type_Bayk.p)
    {
      this.jdField_a_of_type_Bayk.p = false;
      f();
      return false;
    }
    return true;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!h()))
    {
      b(9041, "No Local MD5");
      d();
      return false;
    }
    if ((paramBoolean) && ((this.jdField_q_of_type_Int == 0) || (this.p == 0)))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      localOptions.inSampleSize = 1;
      bdhj.a(this.jdField_a_of_type_Bayk.i, localOptions);
      this.jdField_q_of_type_Int = localOptions.outHeight;
      this.p = localOptions.outWidth;
      Object localObject = this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject;
      if ((localObject != null) && ((localObject instanceof bayo)) && (((bayo)localObject).jdField_a_of_type_Boolean) && (baws.a(this.jdField_a_of_type_Bayk.i)))
      {
        this.jdField_q_of_type_Int = localOptions.outWidth;
        this.p = localOptions.outHeight;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          b("doStart", "raw pic is Landscape,swap w,h; options.outWidth = " + localOptions.outWidth + ",options.outHeight = " + localOptions.outHeight + ",mWidth = " + this.p + ",mHeight = " + this.jdField_q_of_type_Int);
        }
      }
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Bayk.i, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read file error");
          d();
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    if (((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && ((this.jdField_q_of_type_Int > 30000) || (this.p > 30000) || (this.p * this.jdField_q_of_type_Int > 200000000)))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "checkFileStandard fail，mHeight:" + this.jdField_q_of_type_Int + " mWidth:" + this.p);
      }
      b(90632, "PicOverStandard");
      d();
      return false;
    }
    return true;
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = ((int)this.jdField_q_of_type_Long);
    arrayOfInt[1] = biqe.a(this.jdField_a_of_type_Bayk.i);
    arrayOfInt[2] = this.p;
    arrayOfInt[3] = this.jdField_q_of_type_Int;
    arrayOfInt[4] = 0;
    int i = bdhj.a(this.jdField_a_of_type_Bayk.i);
    if ((i == 90) || (270 == i))
    {
      arrayOfInt[2] = this.jdField_q_of_type_Int;
      arrayOfInt[3] = this.p;
    }
    com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 1, "rotateDegree : " + i + ", params[2] : " + arrayOfInt[2] + " params[3] : " + arrayOfInt[3]);
    return arrayOfInt;
  }
  
  public void aP_()
  {
    super.aP_();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-255, 2000L);
  }
  
  protected void b(boolean paramBoolean)
  {
    HashMap localHashMap;
    if ((this.jdField_a_of_type_Awif != null) && (!this.jdField_a_of_type_Awif.jdField_a_of_type_Boolean))
    {
      localHashMap = new HashMap();
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_succ_flag", str);
      if (this.jdField_a_of_type_Bayk.e == 1042) {
        azri.a(BaseApplication.getContext()).a(null, "HotPicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
      }
      azri.a(BaseApplication.getContext()).a(null, "PicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  protected boolean b()
  {
    MessageForPic localMessageForPic = a();
    return (localMessageForPic != null) && (localMessageForPic.imageType == 2000);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
  }
  
  void d()
  {
    super.d();
    if ((this.jdField_a_of_type_Awif != null) && (this.jdField_a_of_type_Awif.jdField_a_of_type_Boolean)) {
      r();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
    if (this.jdField_a_of_type_Bayk != null)
    {
      if (!aufn.b(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label67;
      }
      aufn.b(String.valueOf(this.j), 3);
    }
    label67:
    while (!aufn.a(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
      return;
    }
    aufn.b(String.valueOf(this.j), 2);
  }
  
  void e()
  {
    Object localObject2 = null;
    super.e();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
    if (this.jdField_a_of_type_Awif != null)
    {
      localObject1 = this.jdField_a_of_type_Awif.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Awif.jdField_a_of_type_Boolean) {
        break label236;
      }
      if (localObject1 != null)
      {
        localObject1 = bayu.a((String)localObject1, 65537);
        if (localObject1 == null) {
          break label264;
        }
      }
    }
    label264:
    for (Object localObject1 = ((URL)localObject1).toString();; localObject1 = null)
    {
      if (!baqn.b((String)localObject1))
      {
        String str = baqn.d((String)localObject1);
        if (!b()) {
          break label183;
        }
        localObject1 = this.jdField_a_of_type_Bayk.i;
        boolean bool = bdhb.d((String)localObject1, str);
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "quick send copy file:" + this.jdField_a_of_type_Bayk.i + " to:" + str + " ret:" + bool);
        }
      }
      label155:
      if (this.jdField_a_of_type_Bayk != null)
      {
        if (!aufn.b(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          break label243;
        }
        aufn.b("0", 3);
      }
      label183:
      label236:
      label243:
      while (!aufn.a(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
      {
        return;
        URL localURL = bayu.a(this.jdField_a_of_type_Awif.jdField_a_of_type_JavaLangString, 65537);
        localObject1 = localObject2;
        if (localURL != null) {
          localObject1 = localURL.toString();
        }
        if (baqn.b((String)localObject1))
        {
          localObject1 = baqn.d((String)localObject1);
          break;
        }
        localObject1 = this.jdField_a_of_type_Bayk.i;
        break;
        r();
        break label155;
      }
      aufn.b("0", 2);
      return;
    }
  }
  
  protected void f() {}
  
  protected void g()
  {
    if (this.jdField_a_of_type_Awif != null) {
      if (!this.jdField_a_of_type_Awif.jdField_a_of_type_Boolean)
      {
        this.jdField_q_of_type_Long = this.jdField_a_of_type_Awif.jdField_a_of_type_Long;
        this.c = this.jdField_a_of_type_Awif.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ArrayOfByte = bdhe.a(this.c);
        if (getClass().equals(batj.class)) {
          this.d = (this.c + "." + this.e);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Bayk.p);
      this.jdField_q_of_type_Long = this.jdField_a_of_type_Bayk.f;
      this.c = this.jdField_a_of_type_Bayk.n;
      this.jdField_a_of_type_ArrayOfByte = bdhe.a(this.jdField_a_of_type_Bayk.n);
    } while (!getClass().equals(batj.class));
    this.d = (this.c + "." + this.e);
  }
  
  protected void h()
  {
    try
    {
      if ((!asrc.a().f()) && (!asrc.a().h()) && (!asrc.a().g()))
      {
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d("BasePicUploadProcessor", 0, "a , s close !");
        }
      }
      else if ((this.jdField_a_of_type_Bayk != null) && (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)))
      {
        msg_ctrl.MsgCtrl localMsgCtrl = asqr.a(this.jdField_a_of_type_Bayk.i);
        if (localMsgCtrl != null)
        {
          ((MessageForPic)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgCtrl = localMsgCtrl;
          this.jdField_a_of_type_JavaUtilHashMap.put("param_amc", "1");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bass.d < 1002) {
      d(1002);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     barc
 * JD-Core Version:    0.7.0.1
 */