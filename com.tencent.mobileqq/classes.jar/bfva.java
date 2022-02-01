import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter.2;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class bfva
{
  static long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<UUID, TroopFileTransferManager.Item> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  
  @Deprecated
  private void a()
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.b).iterator();
        if (!localIterator.hasNext()) {
          break label180;
        }
        localObject2 = (TroopFileTansferItemEntity)localIterator.next();
        if ((((TroopFileTansferItemEntity)localObject2).Id == null) || ((!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).FilePath)) && (!((TroopFileTansferItemEntity)localObject2).FilePath.startsWith("/")) && (!((TroopFileTansferItemEntity)localObject2).isZipInnerFile))) {
          continue;
        }
        localObject2 = new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject2);
        switch (((TroopFileTransferManager.Item)localObject2).Status)
        {
        case 0: 
          this.jdField_a_of_type_JavaUtilMap.put(((TroopFileTransferManager.Item)localObject2).Id, localObject2);
          break;
        case 1: 
          ((TroopFileTransferManager.Item)localObject2).Status = 3;
        }
      }
      finally {}
      continue;
      ((TroopFileTransferManager.Item)localObject2).Status = 10;
      continue;
      label180:
      ThreadManager.post(new TroopFileDataCenter.2(this), 8, null, true);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    QQAppInterface localQQAppInterface = bfvp.a();
    if (localQQAppInterface == null) {
      return;
    }
    if (paramItem.troopuin == 0L)
    {
      bfvr.b("TroopFileDataCenter", bfvr.a, "saveStatus. item.troopuin=0, change to:" + paramLong);
      paramItem.troopuin = paramLong;
    }
    if (paramItem.troopuin == 0L)
    {
      bfvr.a("TroopFileDataCenter", bfvr.a, "saveStatus. item.troopuin=0 err");
      return;
    }
    localQQAppInterface.a().a().a(paramItem);
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    a(paramLong, paramItem, paramInt, 0);
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    if (paramItem.Status != paramInt1) {}
    for (boolean bool = true;; bool = false)
    {
      paramItem.IsNewStatus = bool;
      if (paramItem.IsNewStatus) {
        bfvb.a(paramLong, paramItem, paramInt1, paramInt2);
      }
      paramItem.Status = paramInt1;
      paramItem.ErrorCode = paramInt2;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == 1) {
        paramItem.W2MPause = 0;
      }
      a(paramLong, paramItem);
      paramItem.StatusUpdateTimeMs = 0L;
      b(paramLong, paramItem);
      paramItem.IsNewStatus = false;
      b(paramLong, paramItem, paramInt2);
      return;
    }
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, bgrk parambgrk)
  {
    if (paramItem.Status != paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      paramItem.IsNewStatus = bool;
      paramItem.Status = paramInt;
      paramItem.ErrorCode = parambgrk.a;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == 1) {
        paramItem.W2MPause = 0;
      }
      a(paramLong, paramItem);
      paramItem.StatusUpdateTimeMs = 0L;
      b(paramLong, paramItem);
      paramItem.IsNewStatus = false;
      bgri.a(bfvp.a(), parambgrk);
      return;
    }
  }
  
  @Deprecated
  private boolean a()
  {
    for (;;)
    {
      boolean bool;
      TroopFileTransferManager.Item localItem;
      try
      {
        Object localObject1 = this.jdField_a_of_type_JavaUtilMap.values();
        localObject1 = ((Collection)localObject1).iterator();
        bool = false;
        if (!((Iterator)localObject1).hasNext()) {
          break label232;
        }
        localItem = (TroopFileTransferManager.Item)((Iterator)localObject1).next();
        if ((localItem.ThumbnailDownloading_Small) || (localItem.ThumbnailDownloading_Large) || (localItem.ThumbnailDownloading_Middle)) {
          continue;
        }
        switch (localItem.Status)
        {
        default: 
          if ((!localItem.HasThumbnailFile_Small) || (bfxk.a(this.b, localItem, 128))) {
            break label180;
          }
          bool = true;
          break;
        case 6: 
        case 11: 
          if (TextUtils.isEmpty(localItem.LocalFile)) {
            break label165;
          }
        }
      }
      finally {}
      if (!new VFSFile(localItem.LocalFile).exists())
      {
        a(this.b, localItem, 7);
        bool = true;
        continue;
        label165:
        a(this.b, localItem, 7);
        bool = true;
        continue;
        label180:
        if ((localItem.HasThumbnailFile_Large) && (!bfxk.a(this.b, localItem, 640)))
        {
          bool = true;
        }
        else if ((localItem.HasThumbnailFile_Middle) && (!bfxk.a(this.b, localItem, 383)))
        {
          bool = true;
          continue;
          label232:
          return bool;
        }
      }
    }
  }
  
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    long l1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
    long l2 = SystemClock.uptimeMillis() - paramItem.StatusUpdateTimeMs;
    if ((jdField_a_of_type_Long == 0L) || (paramItem.StatusUpdateTimeMs == 0L) || (l2 > 5000L) || (l2 < 0L) || (l1 > 1000L) || (l1 < 0L))
    {
      jdField_a_of_type_Long = l1 + jdField_a_of_type_Long;
      paramItem.StatusUpdateTimeMs += l2;
      QQAppInterface localQQAppInterface = bfvp.a();
      if (localQQAppInterface != null) {
        ((antz)localQQAppInterface.a(22)).a(paramItem.getInfo(paramLong));
      }
    }
  }
  
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    bgri.a(bfvp.a(), paramLong, paramItem.FileName, paramItem.Status, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfva
 * JD-Core Version:    0.7.0.1
 */