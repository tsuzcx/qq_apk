import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

public class bfxf
  implements bfxd
{
  public int a;
  public long a;
  aavn a;
  protected bfve a;
  protected bfxc a;
  protected bfxh a;
  public TroopFileTransferManager.Item a;
  public String a;
  protected Timer a;
  public boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected String c;
  public String d;
  public String e;
  
  protected bfxf(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, bfxh parambfxh)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Aavn = new bfxg(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Bfxh = parambfxh;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = bfxe.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id, paramInt);
    if (aunj.a(auog.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName)) == 2) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public static bfxf a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, bfxh parambfxh)
  {
    if (paramLong == 0L)
    {
      bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    if (paramInt == 0)
    {
      bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "getWoker. nThumbSize=0");
      return null;
    }
    return new bfxf(paramLong, paramItem, paramInt, parambfxh);
  }
  
  private void g()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bfvr.c("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    bfvr.c("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop fetch. mStatus:" + this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Bfxc == null) {
        break label197;
      }
      this.jdField_a_of_type_Bfxc.c();
      this.jdField_a_of_type_Bfxc = null;
    }
    for (;;)
    {
      g();
      if (this.jdField_a_of_type_Bfve != null)
      {
        aauw.a(bfvp.a(), this.jdField_a_of_type_Bfve);
        this.jdField_a_of_type_Bfve = null;
      }
      e();
      if (!TextUtils.isEmpty(this.d)) {
        bhmi.d(this.d);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      bfva.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      b(0);
      return;
      label197:
      bfvr.b("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop downloader=null");
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration == 0) && (paramInt != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration = paramInt;
      this.jdField_a_of_type_Bfxc.b(true);
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    QQAppInterface localQQAppInterface = bfvp.a();
    if (localQQAppInterface == null)
    {
      bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startFetch app=null");
      c(bguk.w);
      return;
    }
    bhmi.d(this.d);
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = "/ftn_handler/" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "/?fname=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + "&pictype=cut&size=" + this.jdField_a_of_type_Int + "*" + this.jdField_a_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    int i;
    boolean bool1;
    if (this.jdField_b_of_type_Boolean)
    {
      i = paramInt1;
      if (paramInt1 <= 0) {
        i = 443;
      }
      localObject1 = localObject2;
      bool1 = bool2;
      if (bgsk.d(localQQAppInterface))
      {
        localObject1 = localObject2;
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          bool1 = true;
          localObject1 = paramString;
        }
      }
      if (!bool1) {
        break label1225;
      }
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {}
    }
    label779:
    label1171:
    label1225:
    for (paramInt1 = 443;; paramInt1 = i)
    {
      localObject2 = "/ftn_video_pic/rkey=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "&filetype=17&size=" + this.jdField_a_of_type_Int + "*" + this.jdField_a_of_type_Int + "&";
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + ":" + paramInt1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
      {
        if (!atul.a().a(localQQAppInterface, 3)) {
          break label779;
        }
        QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopVideo thumb. is config enable IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
        paramString = new atum(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, paramInt1);
        paramString = atul.a().a(localQQAppInterface, paramString, 3);
        if ((paramString != null) && (!paramString.a()))
        {
          if (atul.a())
          {
            QLog.d("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopVideo thumb. debugIsDisableIPv4OnDoubleStack");
            localArrayList.clear();
          }
          atul.a(paramString.a, localArrayList, false, false);
          QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopVideo thumb. use IPv6. iplist:" + localArrayList.toString());
        }
      }
      else
      {
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
      for (;;)
      {
        long l = bfvp.a();
        bfvr.c("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startFetch. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + (String)localObject1 + " mTmpFilePath:" + this.d + " bUseHttps:" + bool1 + " httpsDomain:" + paramString);
        if (this.jdField_a_of_type_Bfxc != null)
        {
          this.jdField_a_of_type_Bfxc.c();
          this.jdField_a_of_type_Bfxc = null;
        }
        this.jdField_a_of_type_Bfxc = bfxc.a(localQQAppInterface, l, this.d, 0L, localArrayList, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, this.jdField_b_of_type_Boolean, bool1, paramString);
        if (this.jdField_a_of_type_Bfxc != null) {
          break label1171;
        }
        c(bguk.w);
        return;
        QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopVideo thumb. use IPv4:");
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + ":" + paramInt1);
        break;
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + ":" + paramInt1);
        break;
        paramString = localObject3;
        bool1 = bool3;
        if (bgsk.d(localQQAppInterface))
        {
          paramString = localObject3;
          bool1 = bool3;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
          {
            bool1 = true;
            paramString = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
          }
        }
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
        {
          if (atul.a().a(localQQAppInterface, 3))
          {
            QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopImage thumb. is config enable IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
            localObject2 = new atum(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, 0);
            localObject2 = atul.a().a(localQQAppInterface, (atum)localObject2, 3);
            if ((localObject2 != null) && (!((atuo)localObject2).a()))
            {
              if (atul.a())
              {
                QLog.d("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopImage thumb. debugIsDisableIPv4OnDoubleStack");
                localArrayList.clear();
              }
              atul.a(((atuo)localObject2).a, localArrayList, true, false);
              QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopImage thumb. use IPv6. iplist:" + localArrayList.toString());
            }
            for (;;)
            {
              break;
              QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopImage thumb. use IPv4");
              localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
            }
          }
          localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
        }
      }
      this.jdField_a_of_type_Bfxc.a(this);
      this.jdField_a_of_type_Bfxc.i();
      this.jdField_a_of_type_Bfxc.a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration != 0) {
        this.jdField_a_of_type_Bfxc.b(true);
      }
      this.jdField_a_of_type_Bfxc.b();
      b(2);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bfve = null;
    g();
    if ((!paramBoolean) && (!aunj.a(new VFSFile(this.d), new VFSFile(this.e))))
    {
      bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.e);
      if (bhmi.b(this.e)) {
        c(bguk.o);
      }
    }
    do
    {
      return;
      b(3);
      f();
      bfvr.c("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFetchSuc  mFilePath:" + this.e);
      if (!paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      }
      if ((this.jdField_a_of_type_Int == 640) && (!auog.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_Long, 383)))) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      auob.a(this.e, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = localOptions.outWidth;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = localOptions.outHeight;
      }
      bfva.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      bfva.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    } while (this.jdField_a_of_type_Bfxh == null);
    this.jdField_a_of_type_Bfxh.a(a(), true, 0, this);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. fetch fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    int i;
    if (paramInt == -5000) {
      i = bguk.h;
    }
    for (;;)
    {
      c(i);
      return;
      if (paramInt == -5001)
      {
        i = bguk.g;
      }
      else if (paramInt == 9039)
      {
        i = bguk.n;
      }
      else if (paramInt == 9004)
      {
        i = bguk.k;
      }
      else if (paramInt == 9301)
      {
        i = bguk.i;
      }
      else if (paramInt == -5001)
      {
        i = bguk.q;
      }
      else if (this.jdField_a_of_type_Bfxc.b())
      {
        i = bguk.p;
      }
      else
      {
        i = paramInt;
        if (paramInt == -5003) {
          i = bguk.y;
        }
      }
    }
  }
  
  public boolean a()
  {
    bfvr.c("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start fetch thumb. filename:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.post(new TroopFileThumbnailFetchWorker.1(this), 8, null, false);
    return true;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = bfvp.a();
    if (localQQAppInterface == null)
    {
      bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqFetch app=null");
      c(bguk.w);
      return;
    }
    bfvr.c("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqFetch");
    this.jdField_a_of_type_Bfve = aauw.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, false, false, this.jdField_a_of_type_Aavn);
    b(1);
  }
  
  protected void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString) {}
  
  public void c()
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.c))) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = bfxk.a();
    this.c = this.jdField_b_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bfve = null;
    g();
    if (!TextUtils.isEmpty(this.d)) {
      bhmi.d(this.d);
    }
    b(4);
    e();
    bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFetchErr  errCode:" + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    if (paramInt == bguk.y) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 1;
    }
    for (;;)
    {
      bfva.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      if (this.jdField_a_of_type_Bfxh != null) {
        this.jdField_a_of_type_Bfxh.a(a(), false, paramInt, this);
      }
      return;
      if (paramInt == bguk.p) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 2;
      } else {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 0;
      }
    }
  }
  
  public void d() {}
  
  protected void e()
  {
    bfxk.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 383) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ThumbnailDownloading_Middle_Fail = true;
    }
  }
  
  protected void f()
  {
    bfxk.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    boolean bool = bfxk.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, this.e);
    TroopFileTransferManager.Item localItem;
    if (this.jdField_a_of_type_Int == 383)
    {
      localItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
      if (bool) {
        break label58;
      }
    }
    label58:
    for (bool = true;; bool = false)
    {
      localItem.ThumbnailDownloading_Middle_Fail = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxf
 * JD-Core Version:    0.7.0.1
 */