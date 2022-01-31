import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

public class aytq
  implements ayto
{
  public int a;
  public long a;
  protected ayrp a;
  protected aytn a;
  protected ayts a;
  public TroopFileTransferManager.Item a;
  public String a;
  protected Timer a;
  wma a;
  public boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected String c;
  public String d;
  public String e;
  
  protected aytq(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, ayts paramayts)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Wma = new aytr(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Ayts = paramayts;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = aytp.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id, paramInt);
    if (apck.a(apdh.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName)) == 2) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public static aytq a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, ayts paramayts)
  {
    if (paramLong == 0L)
    {
      aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    if (paramInt == 0)
    {
      aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "getWoker. nThumbSize=0");
      return null;
    }
    return new aytq(paramLong, paramItem, paramInt, paramayts);
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
      aysb.c("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    aysb.c("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop fetch. mStatus:" + this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Aytn == null) {
        break label197;
      }
      this.jdField_a_of_type_Aytn.c();
      this.jdField_a_of_type_Aytn = null;
    }
    for (;;)
    {
      g();
      if (this.jdField_a_of_type_Ayrp != null)
      {
        wln.a(ayrz.a(), this.jdField_a_of_type_Ayrp);
        this.jdField_a_of_type_Ayrp = null;
      }
      e();
      if (!TextUtils.isEmpty(this.d)) {
        bace.d(this.d);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      ayrl.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      b(0);
      return;
      label197:
      aysb.b("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop downloader=null");
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration == 0) && (paramInt != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration = paramInt;
      this.jdField_a_of_type_Aytn.b(true);
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startFetch app=null");
      c(azle.w);
      return;
    }
    bace.d(this.d);
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject = null;
    String str2 = null;
    String str1 = "/ftn_handler/" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "/?fname=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + "&pictype=cut&size=" + this.jdField_a_of_type_Int + "*" + this.jdField_a_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    int i;
    boolean bool1;
    if (this.jdField_b_of_type_Boolean)
    {
      i = paramInt1;
      if (paramInt1 <= 0) {
        i = 443;
      }
      str1 = str2;
      bool1 = bool2;
      if (azjg.d(localQQAppInterface))
      {
        str1 = str2;
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          bool1 = true;
          str1 = paramString;
        }
      }
      if (!bool1) {
        break label833;
      }
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {}
    }
    label779:
    label833:
    for (paramInt1 = 443;; paramInt1 = i)
    {
      str2 = "/ftn_video_pic/rkey=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "&filetype=17&size=" + this.jdField_a_of_type_Int + "*" + this.jdField_a_of_type_Int + "&";
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + ":" + paramInt1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
      {
        if (apdq.b(localQQAppInterface))
        {
          QLog.i("TroopFileDownloadWorker<FileAssistant>", 1, "[Troop Thumb Download] troop thumb download support IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
          localArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + ":" + paramInt1);
        }
      }
      else
      {
        paramString = str1;
        str1 = str2;
      }
      for (;;)
      {
        long l = ayrz.a();
        aysb.c("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startFetch. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + str1 + " mTmpFilePath:" + this.d + " bUseHttps:" + bool1 + " httpsDomain:" + paramString);
        if (this.jdField_a_of_type_Aytn != null)
        {
          this.jdField_a_of_type_Aytn.c();
          this.jdField_a_of_type_Aytn = null;
        }
        this.jdField_a_of_type_Aytn = aytn.a(localQQAppInterface, l, this.d, 0L, localArrayList, str1, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, this.jdField_b_of_type_Boolean, bool1, paramString);
        if (this.jdField_a_of_type_Aytn != null) {
          break label779;
        }
        c(azle.w);
        return;
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + ":" + paramInt1);
        break;
        paramString = localObject;
        bool1 = bool3;
        if (azjg.d(localQQAppInterface))
        {
          paramString = localObject;
          bool1 = bool3;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
          {
            bool1 = true;
            paramString = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
          }
        }
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS)) {
          if (apdq.a())
          {
            QLog.i("TroopFileDownloadWorker<FileAssistant>", 1, "[Troop Thumb Download] troop thumb download support IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
            localArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
          }
          else
          {
            localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
          }
        }
      }
      this.jdField_a_of_type_Aytn.a(this);
      this.jdField_a_of_type_Aytn.i();
      this.jdField_a_of_type_Aytn.a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration != 0) {
        this.jdField_a_of_type_Aytn.b(true);
      }
      this.jdField_a_of_type_Aytn.b();
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
    this.jdField_a_of_type_Ayrp = null;
    g();
    if ((!paramBoolean) && (!bace.b(new File(this.d), new File(this.e))))
    {
      aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.e);
      if (bace.b(this.e)) {
        c(azle.o);
      }
    }
    do
    {
      return;
      b(3);
      f();
      aysb.c("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFetchSuc  mFilePath:" + this.e);
      if (!paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      }
      if ((this.jdField_a_of_type_Int == 640) && (!apdh.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_Long, 383)))) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      apdc.a(this.e, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = localOptions.outWidth;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = localOptions.outHeight;
      }
      ayrl.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      ayrl.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    } while (this.jdField_a_of_type_Ayts == null);
    this.jdField_a_of_type_Ayts.a(a(), true, 0, this);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. fetch fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    if (paramInt == -5000) {
      paramInt = azle.h;
    }
    for (;;)
    {
      c(paramInt);
      return;
      if (paramInt == -5001) {
        paramInt = azle.g;
      } else if (paramInt == 9039) {
        paramInt = azle.n;
      } else if (paramInt == 9004) {
        paramInt = azle.k;
      } else if (paramInt == 9301) {
        paramInt = azle.i;
      } else if (paramInt == -5001) {
        paramInt = azle.q;
      } else if (this.jdField_a_of_type_Aytn.b()) {
        paramInt = azle.p;
      }
    }
  }
  
  public boolean a()
  {
    aysb.c("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start fetch thumb. filename:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.post(new TroopFileThumbnailFetchWorker.1(this), 8, null, false);
    return true;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqFetch app=null");
      c(azle.w);
      return;
    }
    aysb.c("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqFetch");
    this.jdField_a_of_type_Ayrp = wln.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, false, false, this.jdField_a_of_type_Wma);
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
    this.jdField_b_of_type_JavaLangString = aytv.a();
    this.c = this.jdField_b_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ayrp = null;
    g();
    if (!TextUtils.isEmpty(this.d)) {
      bace.d(this.d);
    }
    b(4);
    e();
    aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFetchErr  errCode:" + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    ayrl.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    if (this.jdField_a_of_type_Ayts != null) {
      this.jdField_a_of_type_Ayts.a(a(), false, paramInt, this);
    }
  }
  
  public void d() {}
  
  protected void e()
  {
    aytv.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 383) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ThumbnailDownloading_Middle_Fail = true;
    }
  }
  
  protected void f()
  {
    aytv.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    boolean bool = aytv.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, this.e);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aytq
 * JD-Core Version:    0.7.0.1
 */