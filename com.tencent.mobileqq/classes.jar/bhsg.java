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

public class bhsg
{
  public static String a;
  private static boolean a;
  
  public static VasQuickUpdateManager.CallBacker a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, String paramString, alth paramalth, boolean paramBoolean)
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
        if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L) || (awra.a(paramCard.lCurrentStyleId)))
        {
          c(paramQQAppInterface, paramCard);
          a(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramalth, paramBoolean);
        }
        else
        {
          ((bduj)paramQQAppInterface.getManager(235)).a.a(paramQQAppInterface, "card." + paramCard.lCurrentBgId);
          paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(184);
          paramBaseActivity = new bhsh(paramBaseActivity, paramCard, paramRandomCoverView, paramalth, paramBoolean);
          paramQQAppInterface.addWeakCallback(paramBaseActivity);
          return paramBaseActivity;
        }
      }
      else {
        a(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramalth, paramBoolean);
      }
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaLangString = null;
  }
  
  public static void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, alth paramalth, boolean paramBoolean)
  {
    long l = paramCard.lCurrentBgId;
    Object localObject = (Boolean)awqu.a.get(Long.valueOf(l));
    int i;
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      i = 1;
      awqu.a.remove(Long.valueOf(l));
    }
    for (;;)
    {
      localObject = paramalth.a(paramCard.strDrawerCardUrl);
      a(paramCard.strDrawerCardUrl);
      if ((localObject == null) || (i != 0))
      {
        if ((l == 160L) || (l == 1600L) || (awra.a(paramCard.lCurrentStyleId))) {}
        for (paramQQAppInterface = bddf.a(paramBaseActivity, paramCard.strDrawerCardUrl);; paramQQAppInterface = awqu.b(paramQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId))
        {
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = bdal.a(paramQQAppInterface, (BitmapFactory.Options)localObject);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "[personal card] fileName:" + paramQQAppInterface + " bitmap:" + localObject);
            }
            ThreadManager.getUIHandler().post(new DrawerCoverUtil.3(paramBaseActivity, (Bitmap)localObject, paramRandomCoverView, paramBoolean, paramalth, paramCard));
          }
          return;
        }
      }
      ThreadManager.getUIHandler().post(new DrawerCoverUtil.4(paramRandomCoverView, (bicb)localObject, paramBoolean));
      return;
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    alpk localalpk = (alpk)paramQQAppInterface.a(2);
    if (localalpk == null) {}
    do
    {
      return;
      byte b = (byte)bdne.W(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
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
      localalpk.a(paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.c(), 0, l, (byte)1, 0L, 0L, arrayOfByte1, "", 0L | 1L | 0x4 | 0x8 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800 | 0x2000, 10004, arrayOfByte2, b);
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
    paramQQAppInterface = bddf.a(paramQQAppInterface, paramCard.lCurrentStyleId, true);
    boolean bool = azmk.b();
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[check cardTemplate]lCurrentStyleId:" + paramCard.lCurrentStyleId + " backgroundUrl:" + paramCard.strDrawerCardUrl + " templateRet:" + paramCard.templateRet + " isSimpleUI:" + bool);
    }
    if (bool) {}
    do
    {
      return false;
      if (awra.a(paramCard.lCurrentStyleId)) {
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
    if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L) || (awra.a(paramCard.lCurrentStyleId))) {
      return bddf.a(paramQQAppInterface.getApp(), paramCard.strDrawerCardUrl);
    }
    return new File(awqu.b(paramQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId)).exists();
  }
  
  public static void c()
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    Object localObject = new File(bddf.a(paramQQAppInterface.getApplication(), paramCard.strDrawerCardUrl));
    localObject = new beae(paramCard.strDrawerCardUrl, (File)localObject);
    ((beae)localObject).f = "profileCardDownload";
    ((beae)localObject).e = "VIP_profilecard";
    int i = beag.a((beae)localObject, paramQQAppInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhsg
 * JD-Core Version:    0.7.0.1
 */