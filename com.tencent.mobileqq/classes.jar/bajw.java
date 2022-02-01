import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class bajw
{
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    a(paramActivity, paramFile, paramString, null);
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString, baka parambaka)
  {
    if (!CheckPermission.isHasStoragePermission(paramActivity))
    {
      CheckPermission.requestStorePermission(paramActivity, null);
      return;
    }
    new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
    String str = paramString;
    if (paramString.indexOf(".") == -1)
    {
      str = FileUtils.estimateFileType(paramFile.getAbsolutePath());
      str = paramString + "." + str;
    }
    paramString = new File(AppConstants.SDCARD_IMG_SAVE, str);
    if (!paramString.exists())
    {
      b(paramActivity, paramFile, paramString, parambaka);
      return;
    }
    bfur.a(paramActivity, 230).setTitle(paramActivity.getString(2131717789)).setMessage(paramActivity.getString(2131694479)).setPositiveButton(paramActivity.getString(2131717677), new bajy(paramActivity, paramFile, paramString, parambaka)).setNegativeButton(paramActivity.getString(2131694094), new bajx()).show();
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
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo, boolean paramBoolean, String paramString3)
  {
    if ((paramRichMediaBrowserInfo == null) || (!AIOPictureData.class.isInstance(paramRichMediaBrowserInfo.baseData))) {
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
    paramString1 = localAIOPictureData.a;
    if (!paramString1.endsWith("_hd"))
    {
      paramRichMediaBrowserInfo = paramString1 + "_hd";
      if (new File(paramRichMediaBrowserInfo).exists()) {
        paramString1 = paramRichMediaBrowserInfo;
      }
    }
    for (;;)
    {
      paramRichMediaBrowserInfo = localAIOPictureData.e;
      long l2 = localAIOPictureData.g;
      long l1 = 0L;
      if (paramBoolean) {
        l1 = localAIOPictureData.h;
      }
      QZoneHelper.forwardToQzoneAlbum(paramActivity, localUserInfo, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramRichMediaBrowserInfo, l2, l1, -1);
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
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
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
        break label351;
      }
      paramInt1 = 2;
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label401;
      }
      localMessageForPic = (MessageForPic)localIterator.next();
      if (!localMessageForPic.isMixed) {
        break label357;
      }
      i = 1;
      label145:
      paramString1 = URLDrawableHelper.getURL(localMessageForPic, i, "chatthumb");
      if (paramString1 == null) {
        break label383;
      }
      paramString1 = AbsDownloader.getFilePath(paramString1.toString());
      if (paramString1 == null) {
        break label365;
      }
      paramString1 = new File(paramString1).getAbsolutePath();
      if (paramString1.endsWith("_hd")) {
        break label424;
      }
      paramList = paramString1 + "_hd";
      if (!new File(paramList).exists()) {
        break label424;
      }
      paramString1 = paramList;
    }
    label401:
    label424:
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
      label351:
      paramInt1 = 1;
      break label103;
      label357:
      i = 65537;
      break label145;
      label365:
      if (!QLog.isColorLevel()) {
        break label112;
      }
      QLog.d("AIOGalleryUtils", 2, "forwardToQzoneAlbum exchange path = null");
      break label112;
      label383:
      if (!QLog.isColorLevel()) {
        break label112;
      }
      QLog.d("AIOGalleryUtils", 2, "forwardToQzoneAlbum exchange url = null");
      break label112;
      QZoneHelper.forwardToQzoneAlbum(paramActivity, localUserInfo, bool, paramString3, paramString2, paramInt1, localArrayList1, localArrayList2, localArrayList3, localArrayList4, paramInt2);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryUtils", 4, "fowardToGroupAlbum(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3 + " uuid:" + paramString5 + " time:" + paramLong + " path:" + paramInt);
    QZoneHelper.forwardToGroupAlbum(paramActivity, localUserInfo, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
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
    QZoneHelper.forwardToUploadPhoto(paramActivity, paramString, 0, 0, paramArrayList, paramActivity.getResources().getString(2131717131), paramInt);
  }
  
  private static void b(Activity paramActivity, File paramFile1, File paramFile2, baka parambaka)
  {
    new bajz(paramFile1, paramFile2, paramActivity, parambaka).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajw
 * JD-Core Version:    0.7.0.1
 */