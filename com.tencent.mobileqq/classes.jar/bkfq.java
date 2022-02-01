import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DrawerCoverUtil.1;
import com.tencent.util.DrawerCoverUtil.3;
import com.tencent.util.DrawerCoverUtil.4;
import java.io.File;
import java.util.Map;
import mqq.os.MqqHandler;

public class bkfq
{
  public static String a;
  private static boolean a;
  
  public static VasQuickUpdateManager.CallBacker a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, String paramString, anmp paramanmp, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "now is in drawer frame?" + paramBoolean);
    }
    if (!a(paramQQAppInterface, paramCard))
    {
      ThreadManager.getUIHandler().post(new DrawerCoverUtil.1(paramRandomCoverView, paramString));
      a();
    }
    for (;;)
    {
      return null;
      if (!b(paramQQAppInterface, paramCard))
      {
        if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L) || (azfl.a(paramCard.lCurrentStyleId)))
        {
          c(paramQQAppInterface, paramCard);
          a(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramanmp, paramBoolean);
        }
        else
        {
          ((bgzk)paramQQAppInterface.getManager(235)).a.a(paramQQAppInterface, "card." + paramCard.lCurrentBgId);
          paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(184);
          paramBaseActivity = new bkfr(paramBaseActivity, paramCard, paramRandomCoverView, paramanmp, paramBoolean);
          paramQQAppInterface.addWeakCallback(paramBaseActivity);
          return paramBaseActivity;
        }
      }
      else {
        a(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramanmp, paramBoolean);
      }
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaLangString = null;
  }
  
  public static void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, anmp paramanmp, boolean paramBoolean)
  {
    long l = paramCard.lCurrentBgId;
    Object localObject = (Boolean)azff.a.get(Long.valueOf(l));
    int i;
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      i = 1;
      azff.a.remove(Long.valueOf(l));
    }
    for (;;)
    {
      localObject = paramanmp.a(paramCard.strDrawerCardUrl);
      a(paramCard.strDrawerCardUrl);
      if ((localObject == null) || (i != 0))
      {
        if ((l == 160L) || (l == 1600L) || (azfl.a(paramCard.lCurrentStyleId))) {}
        for (paramQQAppInterface = bghy.a(paramBaseActivity, paramCard.strDrawerCardUrl);; paramQQAppInterface = azff.b(paramQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId))
        {
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = bggl.a(paramQQAppInterface, (BitmapFactory.Options)localObject);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "[personal card] fileName:" + paramQQAppInterface + " bitmap:" + localObject);
            }
            ThreadManager.getUIHandler().post(new DrawerCoverUtil.3(paramBaseActivity, (Bitmap)localObject, paramRandomCoverView, paramBoolean, paramanmp, paramCard));
          }
          return;
        }
      }
      ThreadManager.getUIHandler().post(new DrawerCoverUtil.4(paramRandomCoverView, (bkpm)localObject, paramBoolean));
      return;
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    anip localanip = (anip)paramQQAppInterface.a(2);
    if (localanip == null) {}
    do
    {
      return;
      byte b = (byte)bgsg.W(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
      byte[] arrayOfByte1 = null;
      byte[] arrayOfByte2 = null;
      if (0 == 0)
      {
        arrayOfByte1 = new byte[1];
        arrayOfByte1[0] = 0;
      }
      if (0 == 0)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      long l = paramCard.feedPreviewTime;
      localanip.a(paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.c(), 0, l, (byte)1, 0L, 0L, arrayOfByte1, "", 0L | 1L | 0x4 | 0x8 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800 | 0x2000, 10004, arrayOfByte2, b);
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.", 2, "fetch profilecard info failure from cache,restart to fetch from net");
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaLangString != null;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    paramQQAppInterface = bghy.a(paramQQAppInterface, paramCard.lCurrentStyleId, true);
    boolean bool = bcnj.b();
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[check cardTemplate]lCurrentStyleId:" + paramCard.lCurrentStyleId + " backgroundUrl:" + paramCard.strDrawerCardUrl + " templateRet:" + paramCard.templateRet + " isSimpleUI:" + bool);
    }
    if (bool) {}
    do
    {
      return false;
      if (azfl.a(paramCard.lCurrentStyleId)) {
        return true;
      }
    } while ((paramCard.lCurrentStyleId <= 0L) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramCard.strDrawerCardUrl)) || (paramCard.templateRet != 0));
    return true;
  }
  
  public static void b()
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L) || (azfl.a(paramCard.lCurrentStyleId))) {
      return bghy.a(paramQQAppInterface.getApp(), paramCard.strDrawerCardUrl);
    }
    return new File(azff.b(paramQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId)).exists();
  }
  
  public static void c()
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    Object localObject = new File(bghy.a(paramQQAppInterface.getApplication(), paramCard.strDrawerCardUrl));
    localObject = new bhhf(paramCard.strDrawerCardUrl, (File)localObject);
    ((bhhf)localObject).f = "profileCardDownload";
    ((bhhf)localObject).e = "VIP_profilecard";
    int i = bhhh.a((bhhf)localObject, paramQQAppInterface);
    if (i == 0) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("DIYProfileTemplate.DrawerCover", 1, "download error:" + i);
    }
    for (;;)
    {
      return false;
      QLog.e("DIYProfileTemplate.DrawerCover", 1, "download {" + paramCard.strDrawerCardUrl + "} error:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfq
 * JD-Core Version:    0.7.0.1
 */