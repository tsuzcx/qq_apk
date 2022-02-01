import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.transfile.FileDownloadFailedException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class bevr
  extends beqz
{
  private BitmapFactory.Options a;
  protected BaseApplicationImpl a;
  
  public bevr(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inScreenDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
  }
  
  private int a(DownloadParams paramDownloadParams, Emoticon paramEmoticon, AppInterface paramAppInterface, Bundle paramBundle, String paramString)
  {
    boolean bool3 = false;
    Object localObject = paramDownloadParams.getHeader("emo_type");
    boolean bool2 = asos.a();
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (localObject != null) {
        bool2 = ((Header)localObject).getValue().equals(String.valueOf(2));
      }
      localObject = paramDownloadParams.getHeader("emo_big");
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (localObject != null) {
          bool1 = ((Header)localObject).getValue().equals("true");
        }
      }
    }
    if (paramEmoticon.jobType == 3) {}
    String str;
    for (int j = 2;; j = 1)
    {
      str = paramDownloadParams.url.getHost();
      if (str != null) {
        break;
      }
      QLog.d("PicEmotionDownloader", 2, "downloadImage| host is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
    }
    int i;
    if (str.equals("fromPanel"))
    {
      localObject = "panel_preview";
      i = 2;
    }
    label364:
    for (;;)
    {
      paramString = paramDownloadParams.getHeader("2g_use_gif");
      bool1 = bool3;
      if (paramString != null) {
        bool1 = paramString.getValue().equals("true");
      }
      if (bool1)
      {
        paramBundle.putString("display_type", "big_img");
        if (paramEmoticon.jobType == 3) {
          i = 6;
        }
      }
      for (;;)
      {
        if (!paramDownloadParams.useApngImage)
        {
          paramEmoticon = ((axfj)paramAppInterface.getManager(14)).a(paramEmoticon.epId);
          if ((paramEmoticon != null) && (paramEmoticon.isAPNG == 2)) {
            paramDownloadParams.useApngImage = true;
          }
        }
        return i;
        i = j;
        localObject = paramString;
        if (!str.equals("fromAIO")) {
          break;
        }
        i = j;
        localObject = paramString;
        if (!bool1) {
          break;
        }
        localObject = "big_img";
        if (paramEmoticon.jobType == 3) {
          j = 2;
        }
        if (paramDownloadParams.useApngImage) {}
        for (i = j | 0x20;; i = j | 0x4)
        {
          if (!paramEmoticon.isSound) {
            break label364;
          }
          localObject = "big_sound";
          i = 12;
          break;
        }
        i = 4;
        continue;
        paramBundle.putString("display_type", (String)localObject);
      }
    }
  }
  
  private Bitmap a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Bitmap localBitmap = null;
    String str;
    if (paramBoolean1) {
      str = asos.q.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
    while (!TextUtils.isEmpty(str))
    {
      Object localObject1;
      if (new File(str).exists())
      {
        paramString2 = localBitmap;
        localObject1 = localObject2;
        try
        {
          FileInputStream localFileInputStream = new FileInputStream(str);
          paramString2 = localBitmap;
          localObject1 = localObject2;
          localBitmap = SafeBitmapFactory.decodeStream(new BufferedInputStream(localFileInputStream), null, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          paramString1 = localBitmap;
          if (paramBoolean2)
          {
            paramString2 = localBitmap;
            localObject1 = localBitmap;
            paramString1 = bhmq.a(localBitmap);
          }
          paramString2 = paramString1;
          localObject1 = paramString1;
          localFileInputStream.close();
          return paramString1;
        }
        catch (OutOfMemoryError paramString1)
        {
          QLog.e("PicEmotionDownloader", 1, "decode oom11 :path = " + str);
          return paramString2;
        }
        catch (Exception paramString1)
        {
          QLog.e("PicEmotionDownloader", 1, "decode exception :path = " + str, paramString1);
          return localObject1;
        }
        str = asos.p.replace("[epId]", paramString1).replace("[eId]", paramString2);
        continue;
      }
      QLog.e("PicEmotionDownloader", 1, "getAIOPreviewBitmap path is not exits! " + str);
      return null;
    }
    return null;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null)
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| config is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| useGifAnimation=" + paramDownloadParams.useGifAnimation + " url.toString=" + paramDownloadParams.url.toString());
    }
    if (!(paramDownloadParams.tag instanceof Emoticon)) {
      throw new FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
    }
    paramURLDrawableHandler = (Emoticon)paramDownloadParams.tag;
    Object localObject = paramDownloadParams.getHeader("my_uin");
    paramOutputStream = null;
    if (localObject != null) {
      paramOutputStream = ((Header)localObject).getValue();
    }
    if (TextUtils.isEmpty(paramOutputStream))
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| uin is null");
      throw new FileDownloadFailedException(9302, 0L, "can't find myUin!", false, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| myUin:" + paramOutputStream);
    }
    try
    {
      paramOutputStream = (AppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramOutputStream);
      if (paramOutputStream == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "downloadImage app is null");
        }
        throw new FileDownloadFailedException(9301, 0L, "qqAppInterface is null", false, false);
      }
    }
    catch (Throwable paramOutputStream)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicEmotionDownloader", 2, "exception:" + paramOutputStream.getMessage());
      }
      paramOutputStream = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (int i = 4;; i = 0)
      {
        localObject = paramOutputStream.getSharedPreferences("Last_Login", i).getString("uin", "");
        paramOutputStream = (AppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "downloadImage| a second time: uin->" + (String)localObject);
        }
        break;
      }
      localObject = new Bundle();
      paramDownloadParams.tag = localObject;
      ((Bundle)localObject).putSerializable("emoticon_key", paramURLDrawableHandler);
      if ((paramOutputStream instanceof QQAppInterface)) {
        break label426;
      }
    }
    a(paramURLDrawableHandler, paramOutputStream);
    for (;;)
    {
      return new File(antf.ba);
      label426:
      a(paramURLDrawableHandler, paramOutputStream, a(paramDownloadParams, paramURLDrawableHandler, paramOutputStream, (Bundle)localObject, "aio_preview"));
    }
  }
  
  protected Object a(Bundle paramBundle, Emoticon paramEmoticon, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    paramBundle.putString("display_type", paramString);
    paramString = new File(asos.s.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
    if (!paramString.exists())
    {
      paramEmoticon = a(paramEmoticon.epId, paramEmoticon.eId, paramBoolean2, paramBoolean1);
      if ((paramEmoticon != null) && (paramBoolean2)) {
        paramBundle.putString("display_type", "aio_preview");
      }
      return paramEmoticon;
    }
    paramBundle = NativeGifFactory.getNativeGifObject(paramString, true, true, 0, 0, 0.0F);
    paramBundle.setDensity(320);
    return paramBundle;
  }
  
  protected Object a(Bundle paramBundle, Emoticon paramEmoticon, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    String str = paramEmoticon.epId;
    paramEmoticon = paramEmoticon.eId;
    if ((paramInt != 3) && (paramBoolean2)) {}
    for (boolean bool = true;; bool = false)
    {
      paramEmoticon = a(str, paramEmoticon, bool, paramBoolean1);
      if ((paramEmoticon != null) && (paramBoolean2)) {
        paramBundle.putString("display_type", "aio_preview");
      }
      return paramEmoticon;
    }
  }
  
  protected Object a(DownloadParams paramDownloadParams, Bundle paramBundle, Emoticon paramEmoticon, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = paramEmoticon.jobType;
    if (QLog.isColorLevel()) {
      QLog.d("PicEmotionDownloader", 2, "showType: " + paramString);
    }
    if (("big_img".equals(paramString)) || ("big_sound".equals(paramString)))
    {
      switch (i)
      {
      case 1: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "decodeFile jobType not supported: " + i);
        }
        return null;
      case 2: 
      case 4: 
        return a(paramBundle, paramEmoticon, paramBoolean1, paramString, paramBoolean2);
      }
      paramBundle.putString("display_type", paramString);
      String str = asos.s.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramDownloadParams.useApngImage) {
        str = asos.t.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      if (!new File(str).exists()) {
        return a(paramBundle, paramEmoticon, paramBoolean1, paramBoolean2, i);
      }
      try
      {
        if (asfa.b(str)) {
          return a(paramDownloadParams, paramString, str);
        }
        if (paramDownloadParams.useApngImage) {
          return a(paramDownloadParams, str);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "decodeFile getDecryptFileData,path=" + str);
        }
        paramDownloadParams = asfa.b(str);
        if (paramDownloadParams != null)
        {
          paramDownloadParams = a(str, paramDownloadParams);
          return paramDownloadParams;
        }
      }
      catch (FileNotFoundException paramDownloadParams)
      {
        QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramDownloadParams);
        return null;
      }
      catch (IOException paramDownloadParams)
      {
        for (;;)
        {
          QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramDownloadParams);
        }
      }
      catch (Exception paramDownloadParams)
      {
        for (;;)
        {
          QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramDownloadParams);
        }
      }
    }
    if (paramBoolean2)
    {
      paramDownloadParams = "aio_preview";
      paramBundle.putString("display_type", paramDownloadParams);
      if ((!paramBoolean2) || (i == 1) || (i == 3)) {
        break label419;
      }
    }
    label419:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      return a(paramEmoticon.epId, paramEmoticon.eId, paramBoolean2, paramBoolean1);
      paramDownloadParams = "panel_preview";
      break;
    }
  }
  
  protected Object a(DownloadParams paramDownloadParams, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicEmotionDownloader", 2, "decodeFile isAPNGFile, path = " + paramString);
    }
    paramString = new File(paramString);
    if ((paramDownloadParams != null) && ((paramDownloadParams.mExtraInfo instanceof Bundle))) {}
    for (paramDownloadParams = (Bundle)paramDownloadParams.mExtraInfo;; paramDownloadParams = new Bundle())
    {
      paramDownloadParams.putInt("key_decryptType", ApngImage.DECRYPTTYPE_DECRYPT);
      paramDownloadParams = new ApngImage(paramString, true, paramDownloadParams);
      if (paramDownloadParams != null) {
        paramDownloadParams.setDensity(320);
      }
      return paramDownloadParams;
    }
  }
  
  protected Object a(DownloadParams paramDownloadParams, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicEmotionDownloader", 2, "decodeFile isGifFile,path=" + paramString2);
    }
    paramString2 = new File(paramString2);
    if ("big_img".equals(paramString1)) {
      paramDownloadParams = NativeGifFactory.getNativeGifObject(paramString2, true, true, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, 0.0F);
    }
    for (;;)
    {
      if (paramDownloadParams != null) {
        paramDownloadParams.setDensity(320);
      }
      return paramDownloadParams;
      if ("big_sound".equals(paramString1)) {
        paramDownloadParams = asst.a(paramString2, 0, true);
      } else {
        paramDownloadParams = null;
      }
    }
  }
  
  protected Object a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      if (paramArrayOfByte == null)
      {
        QLog.e("PicEmotionDownloader", 2, "decode MARKET File:file error" + paramString);
        return null;
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e("emoticon", 1, "decode oom path = " + paramString);
        paramArrayOfByte = null;
      }
    }
    return paramArrayOfByte;
  }
  
  protected void a(Emoticon paramEmoticon, AppInterface paramAppInterface)
  {
    if (paramEmoticon.jobType == 3)
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = asos.d.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      arrayOfString[1] = asos.p.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      int i = bihw.a(new bihu(arrayOfString[0], new File(arrayOfString[1])), paramAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmotionDownloader", 2, "download small emoji, ret:" + i);
      }
    }
  }
  
  protected void a(Emoticon paramEmoticon, AppInterface paramAppInterface, int paramInt)
  {
    paramAppInterface = (askd)paramAppInterface.getManager(43);
    if (!paramAppInterface.b(paramEmoticon, paramInt)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicEmotionDownloader", 2, "need download:" + bool);
      }
      if (!bool) {
        break;
      }
      bool = paramAppInterface.a(paramEmoticon, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "downloadImage| downloadAIOEmoticon result=" + bool + " eId: " + paramEmoticon.eId);
      }
      a(paramEmoticon, bool);
      if (bool) {
        break;
      }
      QLog.e("PicEmotionDownloader", 1, "emotion down fail : epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
      throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
    }
  }
  
  protected void a(Emoticon paramEmoticon, boolean paramBoolean)
  {
    if (paramEmoticon.jobType == 3) {
      if (paramBoolean)
      {
        paramEmoticon = "0";
        axfj.a(paramEmoticon, 5);
      }
    }
    do
    {
      return;
      paramEmoticon = "5002";
      break;
      if ((paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4))
      {
        if (paramBoolean) {}
        for (paramEmoticon = "0";; paramEmoticon = "7001")
        {
          axfj.a(paramEmoticon, 7);
          return;
        }
      }
    } while (paramEmoticon.jobType != 0);
    if (paramBoolean) {}
    for (paramEmoticon = "0";; paramEmoticon = "66001")
    {
      axfj.a(paramEmoticon, 6);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(DownloadParams paramDownloadParams, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString.equals("fromPanel"))
    {
      paramDownloadParams = paramDownloadParams.url.getFile();
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramDownloadParams))
      {
        bool1 = bool2;
        if (paramDownloadParams.endsWith("_panel_magic_gray")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null)
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| config is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
    }
    if (!(paramDownloadParams.tag instanceof Bundle)) {
      throw new FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
    }
    Bundle localBundle = (Bundle)paramDownloadParams.tag;
    Emoticon localEmoticon = (Emoticon)localBundle.getSerializable("emoticon_key");
    paramFile = paramDownloadParams.url.getHost();
    if (paramFile == null)
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| host is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
    }
    boolean bool1 = a(paramDownloadParams, paramFile);
    paramURLDrawableHandler = localBundle.getString("display_type");
    boolean bool2 = paramFile.equals("fromAIO");
    paramFile = paramURLDrawableHandler;
    if (bool2)
    {
      paramFile = paramURLDrawableHandler;
      if (paramURLDrawableHandler.equals("aio_preview"))
      {
        paramFile = paramURLDrawableHandler;
        if (new File(asos.s.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId)).exists()) {
          if (!localEmoticon.isSound) {
            break label220;
          }
        }
      }
    }
    label220:
    for (paramFile = "big_sound";; paramFile = "big_img") {
      return a(paramDownloadParams, localBundle, localEmoticon, bool1, paramFile, bool2);
    }
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevr
 * JD-Core Version:    0.7.0.1
 */