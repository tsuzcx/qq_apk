import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class aqno
{
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    a(paramActivity, paramFile, paramString, null);
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString, aqns paramaqns)
  {
    if (!CheckPermission.isHasStoragePermission(paramActivity)) {
      CheckPermission.requestStorePermission(paramActivity, null);
    }
    for (;;)
    {
      return;
      new File(ajsf.bc).mkdirs();
      String str = paramString;
      if (paramString.indexOf(".") == -1)
      {
        str = bbdj.b(paramFile.getAbsolutePath());
        str = paramString + "." + str;
      }
      paramString = new File(ajsf.bc, str);
      if (!paramString.exists()) {
        try
        {
          if (paramString.createNewFile())
          {
            b(paramActivity, paramFile, paramString, paramaqns);
            return;
          }
        }
        catch (IOException paramFile)
        {
          bcpw.a(paramActivity, paramActivity.getString(2131695189), 0).a();
          aqmb.a().a().a("AIOGalleryUtils", 4, "savePic excption = " + paramFile.getMessage());
          return;
        }
      }
    }
    bbcv.a(paramActivity, 230).setTitle(paramActivity.getString(2131718837)).setMessage(paramActivity.getString(2131695182)).setPositiveButton(paramActivity.getString(2131718713), new aqnq(paramActivity, paramFile, paramString, paramaqns)).setNegativeButton(paramActivity.getString(2131694647), new aqnp()).show();
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "forwardLocalImgToQzoneAlbum, path is empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "forwardLocalImgToQzoneAlbum, path = " + paramString);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(paramActivity, BaseApplicationImpl.getApplication().getRuntime().getAccount(), localArrayList, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, aqmg paramaqmg, boolean paramBoolean, String paramString3)
  {
    if ((paramaqmg == null) || (!AIOPicData.class.isInstance(paramaqmg.a))) {
      return;
    }
    bgyf localbgyf = bgyf.a();
    localbgyf.a = paramString1;
    AIOPicData localAIOPicData = (AIOPicData)paramaqmg.a;
    paramString1 = localAIOPicData.a;
    if (!paramString1.endsWith("_hd"))
    {
      paramaqmg = paramString1 + "_hd";
      if (new File(paramaqmg).exists()) {
        paramString1 = paramaqmg;
      }
    }
    for (;;)
    {
      paramaqmg = localAIOPicData.e;
      long l2 = localAIOPicData.g;
      long l1 = 0L;
      if (paramBoolean) {
        l1 = localAIOPicData.h;
      }
      bgxy.a(paramActivity, localbgyf, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramaqmg, l2, l1, -1);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, List<MessageForPic> paramList, int paramInt2)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "forwardToQzoneAlbum, picMsgList is empty");
      }
      return;
    }
    bgyf localbgyf = bgyf.a();
    localbgyf.a = paramString1;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    boolean bool;
    label103:
    label112:
    MessageForPic localMessageForPic;
    int i;
    if (paramInt1 == 1)
    {
      bool = true;
      if ((paramInt1 != 1) && (paramInt1 != 3000)) {
        break label352;
      }
      paramInt1 = 2;
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label402;
      }
      localMessageForPic = (MessageForPic)localIterator.next();
      if (!localMessageForPic.isMixed) {
        break label358;
      }
      i = 1;
      label145:
      paramString1 = aywk.a(localMessageForPic, i, "chatthumb");
      if (paramString1 == null) {
        break label384;
      }
      paramString1 = ayog.d(paramString1.toString());
      if (paramString1 == null) {
        break label366;
      }
      paramString1 = new File(paramString1).getAbsolutePath();
      if (paramString1.endsWith("_hd")) {
        break label425;
      }
      paramList = paramString1 + "_hd";
      if (!new File(paramList).exists()) {
        break label425;
      }
      paramString1 = paramList;
    }
    label384:
    label402:
    label425:
    for (;;)
    {
      localArrayList1.add(paramString1);
      localArrayList2.add(localMessageForPic.uuid);
      localArrayList3.add(Long.valueOf(localMessageForPic.time));
      if (bool) {
        localArrayList4.add(Long.valueOf(localMessageForPic.groupFileID));
      }
      if (!QLog.isColorLevel()) {
        break label112;
      }
      QLog.d("AIOGalleryUtils", 2, "forwardToQzoneAlbum, uuid:" + localMessageForPic.uuid + " time:" + localMessageForPic.time + " path:" + paramString1);
      break label112;
      bool = false;
      break;
      label352:
      paramInt1 = 1;
      break label103;
      label358:
      i = 65537;
      break label145;
      label366:
      if (!QLog.isColorLevel()) {
        break label112;
      }
      QLog.d("AIOGalleryUtils", 2, "forwardToQzoneAlbum exchange path = null");
      break label112;
      if (!QLog.isColorLevel()) {
        break label112;
      }
      QLog.d("AIOGalleryUtils", 2, "forwardToQzoneAlbum exchange url = null");
      break label112;
      bgxy.a(paramActivity, localbgyf, bool, paramString3, paramString2, paramInt1, localArrayList1, localArrayList2, localArrayList3, localArrayList4, paramInt2);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    bgyf localbgyf = bgyf.a();
    localbgyf.a = paramString1;
    aqmb.a().a().a("AIOGalleryUtils", 4, "fowardToGroupAlbum(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3 + " uuid:" + paramString5 + " time:" + paramLong + " path:" + paramInt);
    bgxy.a(paramActivity, localbgyf, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString, ArrayList<String> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "forwardLocalImgToQzoneAlbum, picMsgList is empty");
      }
      return;
    }
    bgxy.a(paramActivity, paramString, 0, 0, paramArrayList, paramActivity.getResources().getString(2131718230), paramInt);
  }
  
  private static void b(Activity paramActivity, File paramFile1, File paramFile2, aqns paramaqns)
  {
    new aqnr(paramFile1, paramFile2, paramActivity, paramaqns).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqno
 * JD-Core Version:    0.7.0.1
 */