import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.1;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.2;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.3;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bbxf
{
  private static bbxf jdField_a_of_type_Bbxf;
  private bbwz jdField_a_of_type_Bbwz = new bbwz();
  private bbxd jdField_a_of_type_Bbxd = new bbxd();
  
  public static bbxf a()
  {
    try
    {
      if (jdField_a_of_type_Bbxf == null) {
        jdField_a_of_type_Bbxf = new bbxf();
      }
      bbxf localbbxf = jdField_a_of_type_Bbxf;
      return localbbxf;
    }
    finally {}
  }
  
  public static final String a()
  {
    String str = alof.bp;
    VFSFile localVFSFile = new VFSFile(str);
    if (!localVFSFile.exists()) {
      localVFSFile.mkdirs();
    }
    return str;
  }
  
  public static final void a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (paramItem == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 128)
    {
      paramItem.ThumbnailDownloading_Small = true;
      paramItem.ThumbnailFileTimeMS_Small = SystemClock.uptimeMillis();
      localStringBuilder = new StringBuilder();
      if (paramItem.Id == null) {
        break label142;
      }
    }
    label142:
    for (paramItem = paramItem.Id.toString();; paramItem = "")
    {
      paramItem = paramItem + "_" + paramInt;
      bbvl.c("TroopFileThumbnailMgr", bbvl.a, "[" + paramItem + "] setGettingStatus. ");
      return;
      if (paramInt == 640)
      {
        paramItem.ThumbnailDownloading_Large = true;
        paramItem.ThumbnailFileTimeMS_Large = SystemClock.uptimeMillis();
        break;
      }
      if (paramInt != 383) {
        break;
      }
      paramItem.ThumbnailDownloading_Middle = true;
      paramItem.ThumbnailFileTimeMS_Middle = SystemClock.uptimeMillis();
      break;
    }
  }
  
  public static final boolean a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if ((paramLong == 0L) || (paramItem == null)) {}
    while (!a(paramLong, paramItem, paramInt, paramItem.getThumbnailFile(paramLong, paramInt))) {
      return false;
    }
    return true;
  }
  
  public static final boolean a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString)
  {
    int i = 0;
    int j = 0;
    boolean bool3 = false;
    int k = 0;
    int m = 0;
    boolean bool2 = false;
    boolean bool4 = true;
    boolean bool1 = true;
    if (TextUtils.isEmpty(paramString)) {
      return bool2;
    }
    if (paramInt == 128)
    {
      if (!bdhb.b(paramString)) {
        break label260;
      }
      paramInt = i;
      if (!paramItem.HasThumbnailFile_Small) {
        paramInt = 1;
      }
      paramItem.HasThumbnailFile_Small = true;
      if (!paramString.equalsIgnoreCase(paramItem.smallThumbFile)) {
        paramInt = 1;
      }
      paramItem.smallThumbFile = paramString;
      paramItem.ThumbnailFileTimeMS_Small = 0L;
    }
    for (;;)
    {
      bool2 = bool1;
      if (paramInt == 0) {
        break;
      }
      bbuv.a(paramLong, paramItem);
      return bool1;
      if (paramInt == 640)
      {
        if (!bdhb.b(paramString)) {
          break label251;
        }
        paramInt = k;
        if (!paramItem.HasThumbnailFile_Large) {
          paramInt = 1;
        }
        paramItem.HasThumbnailFile_Large = true;
        if (!paramString.equalsIgnoreCase(paramItem.largeThumbnailFile)) {
          paramInt = 1;
        }
        paramItem.largeThumbnailFile = paramString;
        paramItem.ThumbnailFileTimeMS_Large = 0L;
        bool1 = bool4;
      }
      for (;;)
      {
        break;
        if ((paramInt == 383) && (bdhb.b(paramString)))
        {
          if (!paramItem.HasThumbnailFile_Middle) {}
          for (paramInt = 1;; paramInt = 0)
          {
            paramItem.HasThumbnailFile_Middle = true;
            if (!paramString.equalsIgnoreCase(paramItem.middleThumbnailFile)) {
              paramInt = 1;
            }
            paramItem.middleThumbnailFile = paramString;
            paramItem.ThumbnailFileTimeMS_Middle = 0L;
            paramItem.ThumbnailDownloading_Middle_Fail = false;
            bool1 = true;
            break;
          }
        }
        paramInt = 0;
        bool1 = bool3;
        break;
        label251:
        bool1 = false;
        paramInt = m;
      }
      label260:
      bool1 = false;
      paramInt = j;
    }
  }
  
  private void b(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    String str = paramItem.getThumbnailFile(paramLong, 640);
    if (paramItem.LocalFile != null)
    {
      VFSFile localVFSFile = new VFSFile(paramItem.LocalFile);
      if (localVFSFile.exists())
      {
        int j = 0;
        int i = j;
        if (paramItem.origLastModifyTime != 0L)
        {
          long l = localVFSFile.lastModified();
          i = j;
          if (paramItem.origLastModifyTime != l)
          {
            i = j;
            if (TextUtils.isEmpty(paramItem.FilePath))
            {
              i = j;
              if (this.jdField_a_of_type_Bbwz.a(paramLong, paramItem, paramInt) == 0) {
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          this.jdField_a_of_type_Bbxd.a(paramLong, paramItem, paramInt, null);
        }
        return;
      }
    }
    if ((paramInt == 383) && (arso.b(str)))
    {
      this.jdField_a_of_type_Bbxd.a(paramLong, paramItem, paramInt, str);
      return;
    }
    this.jdField_a_of_type_Bbwz.a(paramLong, paramItem, paramInt);
  }
  
  public static final void b(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (paramItem == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 128)
    {
      paramItem.ThumbnailDownloading_Small = false;
      localStringBuilder = new StringBuilder();
      if (paramItem.Id == null) {
        break label121;
      }
    }
    label121:
    for (paramItem = paramItem.Id.toString();; paramItem = "")
    {
      paramItem = paramItem + "_" + paramInt;
      bbvl.c("TroopFileThumbnailMgr", bbvl.a, "[" + paramItem + "] setStopGetStatus. ");
      return;
      if (paramInt == 640)
      {
        paramItem.ThumbnailDownloading_Large = false;
        break;
      }
      if (paramInt != 383) {
        break;
      }
      paramItem.ThumbnailDownloading_Middle = false;
      break;
    }
  }
  
  public void a()
  {
    bbvl.c("TroopFileThumbnailMgr", bbvl.a, "init");
    this.jdField_a_of_type_Bbxd.a();
    this.jdField_a_of_type_Bbwz.a();
  }
  
  public void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if ((paramLong == 0L) || (paramItem == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramItem.Id == null) || (paramInt == 0));
      if (paramItem.canFetchThumbnailFile(paramInt)) {
        break;
      }
    } while ((paramInt != 383) || (!paramItem.genThumb_Middle_OnGettedLargeOrOrigPic));
    paramItem.genThumb_Middle_OnGettedLargeOrOrigPic = false;
    bbvc.a(new TroopFileThumbnailMgr.2(this, paramItem, paramLong, paramInt), false);
    return;
    if (a(paramLong, paramItem, paramInt))
    {
      paramItem.StatusUpdateTimeMs = 0L;
      bbuv.b(paramLong, paramItem);
      return;
    }
    bbvc.a(new TroopFileThumbnailMgr.3(this, paramLong, paramItem, paramInt), false);
  }
  
  public void b()
  {
    bbvl.c("TroopFileThumbnailMgr", bbvl.a, "release");
    if (Build.VERSION.SDK_INT == 19)
    {
      this.jdField_a_of_type_Bbxd.b();
      this.jdField_a_of_type_Bbwz.b();
      return;
    }
    bbvc.a(new TroopFileThumbnailMgr.1(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxf
 * JD-Core Version:    0.7.0.1
 */