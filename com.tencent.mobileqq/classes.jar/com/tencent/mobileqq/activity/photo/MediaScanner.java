package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class MediaScanner
{
  static final String TAG = "QQAlbum";
  private static AtomicBoolean mIsScanning = new AtomicBoolean(false);
  public static AtomicBoolean misInitialized = new AtomicBoolean(false);
  private static MediaScanner sInstance = null;
  private String mExternalStorageDirectoryPath = null;
  private HashSet<String> mFileObserverPaths = new HashSet();
  private HashSet<FileObserver> mFileObservers = new HashSet();
  private HashSet<String> mMd5Set;
  private MediaDatabaseHelper mSqLiteOpenHelper;
  
  private MediaScanner() {}
  
  private MediaScanner(Context paramContext)
  {
    this.mSqLiteOpenHelper = MediaDatabaseHelper.getInstance(paramContext);
    paramContext = Environment.getExternalStorageDirectory();
    if (paramContext != null) {
      this.mExternalStorageDirectoryPath = paramContext.getAbsolutePath();
    }
    paramContext = this.mSqLiteOpenHelper;
    if (paramContext != null) {
      this.mMd5Set = paramContext.queryAllMediaScannerInfoMd5Set();
    }
  }
  
  private void addFileObserver(String paramString)
  {
    if (!new File(paramString).exists()) {
      return;
    }
    if (!this.mFileObserverPaths.contains(paramString))
    {
      this.mFileObserverPaths.add(paramString);
      paramString = new MediaScannerFileObserver(sInstance, paramString);
      paramString.startWatching();
      this.mFileObservers.add(paramString);
    }
  }
  
  public static void buildVideoMediaInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    getDuration(paramLocalMediaInfo, localMediaMetadataRetriever);
    getRotation(paramLocalMediaInfo, localMediaMetadataRetriever);
    getWidthAndHeight(paramLocalMediaInfo, localMediaMetadataRetriever);
    getLocation(paramLocalMediaInfo, localMediaMetadataRetriever);
    localMediaMetadataRetriever.release();
  }
  
  private boolean checkNoMedia(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!isNomediaFileExisit(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAlbum", 2, "doScanFolder() isNomediaFileExisit()=false, return");
      }
      return true;
    }
    return false;
  }
  
  public static int convertGpsToDegreeE6(String paramString)
  {
    paramString = paramString.split(",", 3);
    String[] arrayOfString = paramString[0].split("/", 2);
    double d1 = Double.valueOf(arrayOfString[0]).doubleValue() / Double.valueOf(arrayOfString[1]).doubleValue();
    arrayOfString = paramString[1].split("/", 2);
    double d2 = Double.valueOf(arrayOfString[0]).doubleValue() / Double.valueOf(arrayOfString[1]).doubleValue();
    paramString = paramString[2].split("/", 2);
    double d3 = Double.valueOf(paramString[0]).doubleValue() / Double.valueOf(paramString[1]).doubleValue();
    return (int)((d1 + d2 / 60.0D + d3 / 3600.0D) * 1000000.0D);
  }
  
  @TargetApi(10)
  private MediaScannerInfo createMediaScannerInfo(MediaMetadataRetriever paramMediaMetadataRetriever, String paramString1, String paramString2)
  {
    paramMediaMetadataRetriever = new File(paramString2);
    if (paramMediaMetadataRetriever.exists()) {
      try
      {
        MediaScannerInfo localMediaScannerInfo = new MediaScannerInfo();
        localMediaScannerInfo.duration = 0L;
        localMediaScannerInfo.modifiedDate = (paramMediaMetadataRetriever.lastModified() / 1000L);
        localMediaScannerInfo.fileSize = paramMediaMetadataRetriever.length();
        localMediaScannerInfo.name = paramString2.substring(paramString2.lastIndexOf("/") + 1);
        localMediaScannerInfo.path = paramString2;
        localMediaScannerInfo.folderPath = paramString1;
        localMediaScannerInfo.mimeType = "video/mp4";
        localMediaScannerInfo.md5 = String.valueOf(localMediaScannerInfo.fileSize);
        return localMediaScannerInfo;
      }
      catch (Exception paramMediaMetadataRetriever)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("createMediaScannerInfo() error=");
          paramString1.append(paramMediaMetadataRetriever.getMessage());
          QLog.d("QQAlbum", 2, paramString1.toString());
        }
      }
    }
    return null;
  }
  
  @TargetApi(10)
  private void doScanFolder(String paramString, boolean paramBoolean)
  {
    File localFile = new File(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doScanFolder() folderPath=");
      localStringBuilder.append(paramString);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    if (this.mSqLiteOpenHelper == null) {
      return;
    }
    if ((localFile.exists()) && (localFile.isDirectory()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAlbum", 2, "doScanFolder() videoFolder.exists()=true");
      }
      if (checkNoMedia(paramString, paramBoolean)) {
        return;
      }
      if (needScanFolder(paramString) == true) {
        scanFolder(paramString, localFile);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("QQAlbum", 2, "doScanFolder() videoFolder.exists() = false");
    }
  }
  
  private void doScanWechatVideos()
  {
    if (this.mExternalStorageDirectoryPath != null)
    {
      if (this.mSqLiteOpenHelper == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mExternalStorageDirectoryPath);
      ((StringBuilder)localObject1).append("/tencent/MicroMsg");
      localObject1 = ((StringBuilder)localObject1).toString();
      File[] arrayOfFile = new File((String)localObject1).listFiles();
      if (arrayOfFile == null) {
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = arrayOfFile[i];
        if ((((File)localObject2).isDirectory()) && (((File)localObject2).getName().length() == 32))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("/");
          localStringBuilder.append(((File)localObject2).getName());
          localStringBuilder.append("/video");
          localObject2 = localStringBuilder.toString();
          doScanFolder((String)localObject2, true);
          addFileObserver((String)localObject2);
        }
        i += 1;
      }
    }
  }
  
  private static void getDuration(LocalMediaInfo paramLocalMediaInfo, MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    paramMediaMetadataRetriever.setDataSource(paramLocalMediaInfo.path);
    paramMediaMetadataRetriever = paramMediaMetadataRetriever.extractMetadata(9);
    try
    {
      paramLocalMediaInfo.mDuration = Long.parseLong(paramMediaMetadataRetriever);
      return;
    }
    catch (NumberFormatException paramLocalMediaInfo)
    {
      QLog.e("QQAlbum", 2, "getDuration error. ", paramLocalMediaInfo);
    }
  }
  
  public static MediaScanner getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new MediaScanner(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  private static void getLocation(LocalMediaInfo paramLocalMediaInfo, MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    char[] arrayOfChar;
    int m;
    int k;
    int j;
    char c;
    int i;
    if (Build.VERSION.SDK_INT >= 15)
    {
      paramMediaMetadataRetriever = paramMediaMetadataRetriever.extractMetadata(23);
      if (paramMediaMetadataRetriever != null)
      {
        try
        {
          localArrayList = new ArrayList(3);
          localStringBuilder1 = new StringBuilder();
          arrayOfChar = paramMediaMetadataRetriever.toCharArray();
          m = arrayOfChar.length;
          k = 0;
          j = 0;
        }
        catch (NumberFormatException paramLocalMediaInfo)
        {
          ArrayList localArrayList;
          StringBuilder localStringBuilder1;
          StringBuilder localStringBuilder2;
          label138:
          QLog.e("QQAlbum", 2, "getLocation error. ", paramLocalMediaInfo);
        }
        if ((!Character.isDigit(c)) && (c != '.'))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("Can not under stand the location string: ");
          localStringBuilder2.append(paramMediaMetadataRetriever);
          localStringBuilder2.append(" !");
          QLog.e("QQAlbum", 2, localStringBuilder2.toString());
          i = j;
          break label320;
        }
        localStringBuilder1.append(c);
        i = j;
        break label320;
        i = j;
        if (localStringBuilder1.length() > 0)
        {
          localArrayList.add(Integer.valueOf((int)(Double.parseDouble(localStringBuilder1.toString()) * 1000000.0D)));
          localStringBuilder1.setLength(0);
          i = j + 1;
        }
        localStringBuilder1.append(c);
        break label320;
      }
    }
    label192:
    label330:
    for (;;)
    {
      if (localStringBuilder1.length() > 0) {
        localArrayList.add(Integer.valueOf((int)(Double.parseDouble(localStringBuilder1.toString()) * 1000000.0D)));
      }
      if (localArrayList.size() >= 2)
      {
        paramLocalMediaInfo.latitude = ((Integer)localArrayList.get(0)).intValue();
        paramLocalMediaInfo.longitude = ((Integer)localArrayList.get(1)).intValue();
        return;
      }
      return;
      for (;;)
      {
        if (k >= m) {
          break label330;
        }
        c = arrayOfChar[k];
        if (j >= 2) {
          break label192;
        }
        if ((c == '+') || (c == '-') || (c == '\n')) {
          break label138;
        }
        if (c != 0) {
          break;
        }
        break label138;
        k += 1;
        j = i;
      }
    }
  }
  
  private static void getRotation(LocalMediaInfo paramLocalMediaInfo, MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramMediaMetadataRetriever = paramMediaMetadataRetriever.extractMetadata(24);
      try
      {
        paramLocalMediaInfo.rotation = Integer.parseInt(paramMediaMetadataRetriever);
        return;
      }
      catch (NumberFormatException paramLocalMediaInfo)
      {
        QLog.e("QQAlbum", 2, "getRotation error. ", paramLocalMediaInfo);
      }
    }
  }
  
  private static void getWidthAndHeight(LocalMediaInfo paramLocalMediaInfo, MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      String str = paramMediaMetadataRetriever.extractMetadata(18);
      paramMediaMetadataRetriever = paramMediaMetadataRetriever.extractMetadata(19);
      try
      {
        paramLocalMediaInfo.mediaWidth = Integer.parseInt(str);
        paramLocalMediaInfo.mediaHeight = Integer.parseInt(paramMediaMetadataRetriever);
        return;
      }
      catch (NumberFormatException paramLocalMediaInfo)
      {
        QLog.e("QQAlbum", 2, "getWidthAndHeight error. ", paramLocalMediaInfo);
      }
    }
  }
  
  private void handleMoveToEvent(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString2);
    paramString2 = ((StringBuilder)localObject).toString();
    localObject = new File(paramString2);
    if (this.mMd5Set == null)
    {
      MediaDatabaseHelper localMediaDatabaseHelper = this.mSqLiteOpenHelper;
      if (localMediaDatabaseHelper != null) {
        this.mMd5Set = localMediaDatabaseHelper.queryAllMediaScannerInfoMd5Set();
      }
    }
    if (this.mMd5Set != null)
    {
      if (this.mSqLiteOpenHelper == null) {
        return;
      }
      if (((File)localObject).exists())
      {
        paramString1 = createMediaScannerInfo(null, paramString1, paramString2);
        if ((paramString1 != null) && (!this.mMd5Set.contains(paramString1.md5)))
        {
          this.mMd5Set.add(paramString1.md5);
          this.mSqLiteOpenHelper.insertMediaScannerInfo(paramString1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQAlbum", 2, "handleFileObserverEvent() info=null");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("QQAlbum", 2, "handleFileObserverEvent() mMd5Set.contains( md5 ) = true");
      }
    }
  }
  
  private boolean isNomediaFileExisit(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNomediaFileExisit() folderpath=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", mExternalStorageDirectoryPath=");
      ((StringBuilder)localObject).append(this.mExternalStorageDirectoryPath);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    if (new File(this.mExternalStorageDirectoryPath).equals(new File(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAlbum", 2, "isNomediaFileExisit() root folder, return false");
      }
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/.nomedia");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists() == true)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isNomediaFileExisit() nomediaFile=");
        paramString.append(localObject);
        paramString.append(" exist, return true");
        QLog.d("QQAlbum", 2, paramString.toString());
      }
      return true;
    }
    return isNomediaFileExisit(new File(paramString).getParent());
  }
  
  private boolean needScanFolder(String paramString)
  {
    long l = new File(paramString).lastModified();
    paramString = this.mSqLiteOpenHelper.queryMediaScannerFolderInfoByFolderpath(paramString);
    if (paramString != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needScanFolder() lastModified=");
        localStringBuilder.append(l);
        localStringBuilder.append(", info.modifiedDate=");
        localStringBuilder.append(paramString.modifiedDate);
        QLog.d("QQAlbum", 2, localStringBuilder.toString());
      }
      if (l == paramString.modifiedDate) {
        return false;
      }
    }
    return true;
  }
  
  private void preScan()
  {
    Object localObject = this.mSqLiteOpenHelper;
    if (localObject == null) {
      return;
    }
    localObject = ((MediaDatabaseHelper)localObject).queryAllMediaScannerFolderPathSet();
    Iterator localIterator = ((HashSet)localObject).iterator();
    if (localObject != null)
    {
      if (localIterator == null) {
        return;
      }
      while (localIterator.hasNext()) {
        if (new File((String)localIterator.next()).exists()) {
          localIterator.remove();
        }
      }
      this.mSqLiteOpenHelper.deleteMediaScannerInfoByFolderPathSet((HashSet)localObject);
    }
  }
  
  private void scanFolder(String paramString, File paramFile)
  {
    paramFile = paramFile.listFiles();
    HashSet localHashSet1 = this.mSqLiteOpenHelper.queryAllMediaScannerInfoPathSetByFolder(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        MediaScannerInfo localMediaScannerInfo = paramFile[i];
        if (localMediaScannerInfo.getName().endsWith(".mp4"))
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(localMediaScannerInfo.getName());
          localObject = ((StringBuilder)localObject).toString();
          if (!localHashSet1.contains(localObject))
          {
            HashSet localHashSet2 = this.mMd5Set;
            if ((localHashSet2 != null) && (!localHashSet2.contains(String.valueOf(localMediaScannerInfo.length()))))
            {
              localMediaScannerInfo = createMediaScannerInfo(null, paramString, (String)localObject);
              if (localMediaScannerInfo == null) {
                break label188;
              }
              localArrayList.add(localMediaScannerInfo);
              this.mMd5Set.add(String.valueOf(localMediaScannerInfo.fileSize));
              break label188;
            }
          }
          localHashSet1.remove(localObject);
        }
        label188:
        i += 1;
      }
    }
    this.mSqLiteOpenHelper.deleteMediaScannerInfoByPathSet(localHashSet1);
    this.mSqLiteOpenHelper.insertMediaScannerInfoByList(localArrayList);
    updateScanFolderInfo(paramString);
  }
  
  private void updateScanFolderInfo(String paramString)
  {
    long l = new File(paramString).lastModified();
    MediaScannerFolderInfo localMediaScannerFolderInfo = this.mSqLiteOpenHelper.queryMediaScannerFolderInfoByFolderpath(paramString);
    if (localMediaScannerFolderInfo != null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("needScanFolder() lastModified=");
        paramString.append(l);
        paramString.append(", info.modifiedDate=");
        paramString.append(localMediaScannerFolderInfo.modifiedDate);
        QLog.d("QQAlbum", 2, paramString.toString());
      }
      if (l > localMediaScannerFolderInfo.modifiedDate)
      {
        localMediaScannerFolderInfo.modifiedDate = l;
        this.mSqLiteOpenHelper.updateMediaScnnerFolderInfo(localMediaScannerFolderInfo);
        if (QLog.isColorLevel()) {
          QLog.d("QQAlbum", 2, "needScanFolder() lastModified > info.modifiedDate , run updateMediaScnnerFolderInfo()");
        }
      }
    }
    else
    {
      localMediaScannerFolderInfo = new MediaScannerFolderInfo();
      localMediaScannerFolderInfo.folderpath = paramString;
      localMediaScannerFolderInfo.modifiedDate = l;
      this.mSqLiteOpenHelper.insertMediaScnnerFolderInfo(localMediaScannerFolderInfo);
      if (QLog.isColorLevel()) {
        QLog.d("QQAlbum", 2, "updateScanFolderInfo() run insertMediaScnnerFolderInfo()");
      }
    }
  }
  
  public void buildAndUpdateVideo(LocalMediaInfo paramLocalMediaInfo)
  {
    buildVideoMediaInfo(paramLocalMediaInfo);
    this.mSqLiteOpenHelper.updateMediaScnnerInfoDuration(paramLocalMediaInfo.path, paramLocalMediaInfo.mDuration);
  }
  
  /* Error */
  public void doScan()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 508
    //   5: invokestatic 511	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   8: invokevirtual 512	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: getstatic 32	com/tencent/mobileqq/activity/photo/MediaScanner:misInitialized	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   22: invokevirtual 514	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: iconst_1
    //   28: if_icmpne +6 -> 34
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: getstatic 36	com/tencent/mobileqq/activity/photo/MediaScanner:mIsScanning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   37: invokevirtual 514	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   40: ifne +109 -> 149
    //   43: getstatic 36	com/tencent/mobileqq/activity/photo/MediaScanner:mIsScanning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   46: iconst_1
    //   47: invokevirtual 517	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   50: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +12 -> 65
    //   56: ldc 8
    //   58: iconst_2
    //   59: ldc_w 519
    //   62: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_0
    //   66: invokespecial 521	com/tencent/mobileqq/activity/photo/MediaScanner:preScan	()V
    //   69: aload_0
    //   70: invokespecial 523	com/tencent/mobileqq/activity/photo/MediaScanner:doScanWechatVideos	()V
    //   73: getstatic 36	com/tencent/mobileqq/activity/photo/MediaScanner:mIsScanning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   76: iconst_0
    //   77: invokevirtual 517	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   80: getstatic 32	com/tencent/mobileqq/activity/photo/MediaScanner:misInitialized	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   83: astore_2
    //   84: aload_2
    //   85: iconst_1
    //   86: invokevirtual 517	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   89: goto +26 -> 115
    //   92: astore_2
    //   93: goto +40 -> 133
    //   96: astore_2
    //   97: aload_2
    //   98: invokevirtual 526	java/io/IOException:printStackTrace	()V
    //   101: getstatic 36	com/tencent/mobileqq/activity/photo/MediaScanner:mIsScanning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   104: iconst_0
    //   105: invokevirtual 517	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   108: getstatic 32	com/tencent/mobileqq/activity/photo/MediaScanner:misInitialized	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   111: astore_2
    //   112: goto -28 -> 84
    //   115: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +12 -> 130
    //   121: ldc 8
    //   123: iconst_2
    //   124: ldc_w 528
    //   127: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: getstatic 36	com/tencent/mobileqq/activity/photo/MediaScanner:mIsScanning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   136: iconst_0
    //   137: invokevirtual 517	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   140: getstatic 32	com/tencent/mobileqq/activity/photo/MediaScanner:misInitialized	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   143: iconst_1
    //   144: invokevirtual 517	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   147: aload_2
    //   148: athrow
    //   149: aload_0
    //   150: monitorexit
    //   151: return
    //   152: astore_2
    //   153: aload_0
    //   154: monitorexit
    //   155: goto +5 -> 160
    //   158: aload_2
    //   159: athrow
    //   160: goto -2 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	MediaScanner
    //   11	18	1	bool	boolean
    //   83	2	2	localAtomicBoolean1	AtomicBoolean
    //   92	1	2	localObject1	Object
    //   96	2	2	localIOException	java.io.IOException
    //   111	37	2	localAtomicBoolean2	AtomicBoolean
    //   152	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   65	73	92	finally
    //   97	101	92	finally
    //   65	73	96	java/io/IOException
    //   2	12	152	finally
    //   19	26	152	finally
    //   34	65	152	finally
    //   73	84	152	finally
    //   84	89	152	finally
    //   101	112	152	finally
    //   115	130	152	finally
    //   133	149	152	finally
  }
  
  public ArrayList<MediaScannerInfo> getMediaScannerInfos(boolean paramBoolean, int paramInt)
  {
    try
    {
      MediaDatabaseHelper localMediaDatabaseHelper = this.mSqLiteOpenHelper;
      Object localObject1 = null;
      if (localMediaDatabaseHelper == null) {
        return null;
      }
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      if (!bool) {
        return null;
      }
      if (paramInt != -1) {
        localObject1 = String.valueOf(paramInt);
      }
      if (!paramBoolean) {
        localObject1 = this.mSqLiteOpenHelper.queryAllMediaScannerInfo((String)localObject1);
      } else {
        localObject1 = this.mSqLiteOpenHelper.queryAllLongVideoMediaScannerInfo((String)localObject1);
      }
      return localObject1;
    }
    finally {}
  }
  
  public int getMediaScannerInfosCount()
  {
    try
    {
      MediaDatabaseHelper localMediaDatabaseHelper = this.mSqLiteOpenHelper;
      if (localMediaDatabaseHelper == null) {
        return 0;
      }
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      if (!bool) {
        return 0;
      }
      int i = this.mSqLiteOpenHelper.queryAllMediaScannerInfoCnt();
      return i;
    }
    finally {}
  }
  
  @TargetApi(10)
  public void handleFileObserverEvent(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFileObserverEvent() is called event=");
      localStringBuilder.append(paramInt);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    if (!misInitialized.get()) {
      return;
    }
    if ((paramInt != 8) && (paramInt != 128))
    {
      if (paramInt != 512) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (new File(paramString1).exists() == true) {
        return;
      }
      if (this.mSqLiteOpenHelper == null) {
        return;
      }
      paramString2 = new HashSet();
      paramString2.add(paramString1);
      this.mSqLiteOpenHelper.deleteMediaScannerInfoByPathSet(paramString2);
      return;
    }
    handleMoveToEvent(paramString1, paramString2);
  }
  
  @TargetApi(10)
  public void queryMediaInfoAsync(MediaScanner.OnMediaInfoScannerListener paramOnMediaInfoScannerListener, LocalMediaInfo paramLocalMediaInfo)
  {
    paramOnMediaInfoScannerListener = new MediaScanner.QueryTaskRunnable(paramOnMediaInfoScannerListener, paramLocalMediaInfo);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManagerV2.excute(paramOnMediaInfoScannerListener, 64, null, true);
      return;
    }
    paramOnMediaInfoScannerListener.run();
  }
  
  @TargetApi(10)
  public void queryMediaInfoDuration(MediaScanner.OnMediaScannerListener paramOnMediaScannerListener, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    paramOnMediaScannerListener = new WeakReference(paramOnMediaScannerListener);
    ThreadManagerV2.excute(new MediaScanner.1(this, new WeakReference(paramLocalMediaInfo), paramOnMediaScannerListener, paramInt), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaScanner
 * JD-Core Version:    0.7.0.1
 */