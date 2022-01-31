import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class bbzu
  implements Manager
{
  public long a;
  private bbzt jdField_a_of_type_Bbzt = new bbzt();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = "VipGiftManager";
  private String b;
  
  public bbzu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 10000L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = a();
    a();
  }
  
  private String b()
  {
    if (this.jdField_a_of_type_Bbzt != null) {
      return this.jdField_a_of_type_Bbzt.jdField_a_of_type_JavaLangString + "|" + this.jdField_a_of_type_Bbzt.jdField_b_of_type_JavaLangString + "|" + this.jdField_a_of_type_Bbzt.jdField_b_of_type_Long + "|" + this.jdField_a_of_type_Bbzt.jdField_c_of_type_Long + "|" + this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long + "|" + this.jdField_a_of_type_Bbzt.jdField_a_of_type_Long + "|" + this.jdField_a_of_type_Bbzt.jdField_c_of_type_JavaLangString + "|" + this.jdField_a_of_type_Bbzt.jdField_d_of_type_JavaLangString + "|" + this.jdField_a_of_type_Bbzt.e + "|" + this.jdField_a_of_type_Bbzt.f;
    }
    return null;
  }
  
  public bbzt a()
  {
    return this.jdField_a_of_type_Bbzt;
  }
  
  public final String a()
  {
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.RELEASE;
    return "{\"model\":\"" + str1 + "\",\"systemName\":\"android\",\"systemVersion\":\"" + str2 + "\"}";
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("Gif_Download_info_key_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
    if ((localObject != null) && (this.jdField_a_of_type_Bbzt != null))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length == 10) && (this.jdField_a_of_type_Bbzt != null))
      {
        this.jdField_a_of_type_Bbzt.jdField_a_of_type_JavaLangString = localObject[0];
        this.jdField_a_of_type_Bbzt.jdField_b_of_type_JavaLangString = localObject[1];
        this.jdField_a_of_type_Bbzt.jdField_b_of_type_Long = Long.parseLong(localObject[2]);
        this.jdField_a_of_type_Bbzt.jdField_c_of_type_Long = Long.parseLong(localObject[3]);
        this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long = Long.parseLong(localObject[4]);
        this.jdField_a_of_type_Bbzt.jdField_a_of_type_Long = Long.parseLong(localObject[5]);
        this.jdField_a_of_type_Bbzt.jdField_c_of_type_JavaLangString = localObject[6];
        this.jdField_a_of_type_Bbzt.jdField_d_of_type_JavaLangString = localObject[7];
        this.jdField_a_of_type_Bbzt.e = Long.parseLong(localObject[8]);
        this.jdField_a_of_type_Bbzt.f = Long.parseLong(localObject[9]);
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bbzt.e = NetConnInfoCenter.getServerTimeMillis();
    a(1L, paramLong);
    Object localObject2 = null;
    int i;
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        try
        {
          Uri localUri = Uri.parse(this.jdField_a_of_type_Bbzt.jdField_d_of_type_JavaLangString);
          Object localObject1 = localObject2;
          if (localUri != null)
          {
            localObject1 = localObject2;
            if (localUri.isHierarchical()) {
              localObject1 = localUri.getQueryParameter("_bid");
            }
          }
          if ((localObject1 == null) || (((String)localObject1).length() == 0))
          {
            a(5L, paramLong);
            return;
          }
        }
        catch (Exception localException)
        {
          a(5L, paramLong);
          return;
        }
        i = bbfj.a(BaseApplicationImpl.getContext());
        long l = System.currentTimeMillis();
        bool1 = a(localException);
        if (QLog.isColorLevel()) {
          QLog.d("VipGiftManager", 2, "OfflineSecurity.verify bid:" + localException + ",cost:" + (System.currentTimeMillis() - l) + ",bigFlag:" + bool1);
        }
        l = System.currentTimeMillis();
        bool2 = a("280");
        if (QLog.isColorLevel()) {
          QLog.d("VipGiftManager", 2, "OfflineSecurity.verify smalbid:280,cost:" + (System.currentTimeMillis() - l) + ",smallFlag:" + bool2);
        }
        if (i != 0) {
          break label290;
        }
        if (!bool1) {
          break;
        }
      } while (!a(2L, paramLong));
      a(localException, paramLong);
      return;
    } while ((!bool2) || (!a(2L, paramLong)));
    a("http://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
    a("280", paramLong);
    return;
    label290:
    if (a(i, bool2, bool1))
    {
      if (bool2)
      {
        if (a(2L, paramLong))
        {
          a("http://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
          a("280", paramLong);
        }
        mzb.b("280", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new bbzv(this));
        return;
      }
      a("280", null, paramLong);
      return;
    }
    if (bool1)
    {
      if (a(2L, paramLong)) {
        a(localException, paramLong);
      }
      mzb.b(localException, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new bbzw(this));
      return;
    }
    a(localException, "280", paramLong);
  }
  
  public void a(bbzt parambbzt, BaseActivity paramBaseActivity)
  {
    a(3L, parambbzt.jdField_a_of_type_Long);
    String str = null;
    Object localObject;
    try
    {
      Uri localUri = Uri.parse(parambbzt.jdField_c_of_type_JavaLangString);
      localObject = str;
      if (localUri != null)
      {
        localObject = str;
        if (localUri.isHierarchical())
        {
          str = localUri.getQueryParameter("_bid");
          localObject = str;
          if (TextUtils.isEmpty(str))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VipGiftManager", 2, "TextUtils.isEmpty(bid) false");
            }
            a(5L, parambbzt.jdField_a_of_type_Long);
            return;
          }
        }
      }
    }
    catch (Exception paramBaseActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipGiftManager", 2, "exception bid");
      }
      a(5L, parambbzt.jdField_a_of_type_Long);
      return;
    }
    if (a((String)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipGiftManager", 2, "showGifAnnimate.veryfyBid(" + (String)localObject + ") true,url:" + parambbzt.jdField_c_of_type_JavaLangString);
      }
      if (((String)localObject).equalsIgnoreCase("280")) {
        a("http://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
      }
      a("0X8004B41", "2", "1", parambbzt.jdField_c_of_type_JavaLangString);
      localObject = new Intent(BaseApplication.getContext(), QQTranslucentBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parambbzt.jdField_c_of_type_JavaLangString);
      ((Intent)localObject).putExtra("Gif_msg_uniseq_key", parambbzt.jdField_a_of_type_Long);
      paramBaseActivity.startActivity((Intent)localObject);
      return;
    }
    if (a("280"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipGiftManager", 2, "showGifAnnimate.veryfyBid(" + (String)localObject + ") false,url:" + parambbzt.jdField_c_of_type_JavaLangString);
      }
      a("http://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
      a("0X8004B41", "2", "1", parambbzt.jdField_c_of_type_JavaLangString);
      localObject = new Intent(BaseApplication.getContext(), QQTranslucentBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parambbzt.jdField_c_of_type_JavaLangString);
      ((Intent)localObject).putExtra("Gif_msg_uniseq_key", parambbzt.jdField_a_of_type_Long);
      paramBaseActivity.startActivity((Intent)localObject);
      return;
    }
    a(5L, parambbzt.jdField_a_of_type_Long);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bbzt.jdField_c_of_type_JavaLangString = paramString;
    b();
  }
  
  public void a(String paramString, long paramLong)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), axcx.class);
    localNewIntent.setAction("gif_ui_show");
    localNewIntent.putExtra("gif_ui_show_bid", Integer.parseInt(paramString));
    localNewIntent.putExtra("gif_ui_show_seq", paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    long l = System.currentTimeMillis();
    mzb.b(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new bbzx(this, l, paramString1, paramLong, paramString2));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString4;
    if (paramString4 == null) {
      str = this.jdField_a_of_type_Bbzt.jdField_c_of_type_JavaLangString;
    }
    paramString4 = this.jdField_b_of_type_JavaLangString;
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Vip_Gift", paramString1, paramString1, 0, 0, new String[] { paramString2, paramString3, str, paramString4 });
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bbzt == null) {
      this.jdField_a_of_type_Bbzt = new bbzt();
    }
    if ((this.jdField_a_of_type_Bbzt != null) && (this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long == 1L))
    {
      long l = NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Bbzt.e;
      if ((l > this.jdField_a_of_type_Long) || (l <= 0L)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return true;
      if (paramBoolean2) {
        return false;
      }
    } while (paramInt == 2);
    return false;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Bbzt != null)
    {
      this.jdField_a_of_type_Bbzt.f = paramLong;
      return b();
    }
    return false;
  }
  
  /* Error */
  public boolean a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: iload 6
    //   7: istore 5
    //   9: lload_3
    //   10: aload_0
    //   11: getfield 26	bbzu:jdField_a_of_type_Bbzt	Lbbzt;
    //   14: getfield 63	bbzt:jdField_a_of_type_Long	J
    //   17: lcmp
    //   18: ifne +31 -> 49
    //   21: lload_1
    //   22: ldc2_w 201
    //   25: lcmp
    //   26: ifne +28 -> 54
    //   29: aload_0
    //   30: getfield 26	bbzu:jdField_a_of_type_Bbzt	Lbbzt;
    //   33: getfield 62	bbzt:jdField_d_of_type_Long	J
    //   36: lstore_3
    //   37: lload_3
    //   38: ldc2_w 340
    //   41: lcmp
    //   42: ifne +12 -> 54
    //   45: iload 6
    //   47: istore 5
    //   49: aload_0
    //   50: monitorexit
    //   51: iload 5
    //   53: ireturn
    //   54: aload_0
    //   55: getfield 26	bbzu:jdField_a_of_type_Bbzt	Lbbzt;
    //   58: lload_1
    //   59: putfield 62	bbzt:jdField_d_of_type_Long	J
    //   62: aload_0
    //   63: invokevirtual 289	bbzu:b	()Z
    //   66: istore 5
    //   68: goto -19 -> 49
    //   71: astore 7
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 7
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	bbzu
    //   0	78	1	paramLong1	long
    //   0	78	3	paramLong2	long
    //   7	60	5	bool1	boolean
    //   1	45	6	bool2	boolean
    //   71	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	71	finally
    //   29	37	71	finally
    //   54	68	71	finally
  }
  
  public boolean a(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {
      return false;
    }
    if (paramMessageForStructing.structingMsg == null) {
      return false;
    }
    a("0X8004B41", "1", "0", paramMessageForStructing.structingMsg.mResid);
    if (this.jdField_a_of_type_Bbzt == null) {
      this.jdField_a_of_type_Bbzt = new bbzt();
    }
    Uri localUri;
    boolean bool;
    try
    {
      localUri = Uri.parse(paramMessageForStructing.structingMsg.mResid);
      if ((localUri != null) && (localUri.isHierarchical()))
      {
        bool = TextUtils.isEmpty(localUri.getQueryParameter("_bid"));
        if (bool) {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    catch (Exception paramMessageForStructing)
    {
      return false;
    }
    long l;
    for (;;)
    {
      try
      {
        str = localUri.getQueryParameter("_gv");
        bool = TextUtils.isEmpty(str);
        if (!bool) {
          continue;
        }
        l = 0L;
      }
      catch (Exception localException)
      {
        String str;
        l = 0L;
        continue;
        if (this.jdField_a_of_type_Bbzt == null) {
          break label420;
        }
      }
      if (this.jdField_a_of_type_Bbzt.f > l)
      {
        a("0X8004B41", "2", "3", paramMessageForStructing.structingMsg.mResid);
        return false;
        l = Long.parseLong(str);
      }
      else if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
      {
        if (((this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long == 0L) && (paramMessageForStructing.time < this.jdField_a_of_type_Bbzt.jdField_b_of_type_Long)) || (this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long == 4L) || (this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long == 999L) || (this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long == 5L) || (this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long == 6L) || (a()))
        {
          this.jdField_a_of_type_Bbzt.jdField_a_of_type_JavaLangString = paramMessageForStructing.selfuin;
          this.jdField_a_of_type_Bbzt.jdField_b_of_type_JavaLangString = paramMessageForStructing.senderuin;
          this.jdField_a_of_type_Bbzt.jdField_b_of_type_Long = paramMessageForStructing.time;
          this.jdField_a_of_type_Bbzt.jdField_c_of_type_Long = 0L;
          this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long = 0L;
          this.jdField_a_of_type_Bbzt.jdField_a_of_type_Long = paramMessageForStructing.uniseq;
          this.jdField_a_of_type_Bbzt.jdField_d_of_type_JavaLangString = paramMessageForStructing.structingMsg.mResid;
          this.jdField_a_of_type_Bbzt.jdField_c_of_type_JavaLangString = paramMessageForStructing.structingMsg.mResid;
          this.jdField_a_of_type_Bbzt.e = 0L;
        }
      }
    }
    try
    {
      l = Long.parseLong(localUri.getQueryParameter("_to").trim());
      if (l > 0L) {
        this.jdField_a_of_type_Long = l;
      }
    }
    catch (Exception paramMessageForStructing)
    {
      label398:
      label420:
      break label398;
    }
    return b();
    a("0X8004B41", "2", "2", paramMessageForStructing.structingMsg.mResid);
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
      } while (mzb.a(paramString) == null);
      str = mzh.a(paramString) + paramString;
      bool2 = nap.a(str, paramString);
      bool1 = bool2;
    } while (bool2);
    mzb.a(str, paramString);
    return bool2;
  }
  
  public boolean b()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    localEditor.putString("Gif_Download_info_key_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), b());
    if (QLog.isColorLevel()) {
      QLog.d("VipGiftManager", 2, "writeToSp:" + b());
    }
    return localEditor.commit();
  }
  
  public boolean b(long paramLong)
  {
    if (this.jdField_a_of_type_Bbzt == null) {}
    while ((this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long == 999L) || (this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long == 5L) || (this.jdField_a_of_type_Bbzt.jdField_d_of_type_Long >= 2L) || (paramLong < this.jdField_a_of_type_Bbzt.jdField_b_of_type_Long)) {
      return false;
    }
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbzu
 * JD-Core Version:    0.7.0.1
 */