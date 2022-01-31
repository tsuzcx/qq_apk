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

public class azui
  implements azug
{
  public int a;
  public long a;
  protected azsh a;
  protected azuf a;
  protected azuk a;
  public TroopFileTransferManager.Item a;
  public String a;
  protected Timer a;
  xba a;
  public boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected String c;
  public String d;
  public String e;
  
  protected azui(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, azuk paramazuk)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Xba = new azuj(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Azuk = paramazuk;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = azuh.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id, paramInt);
    if (apug.a(apvd.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName)) == 2) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public static azui a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, azuk paramazuk)
  {
    if (paramLong == 0L)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    if (paramInt == 0)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "getWoker. nThumbSize=0");
      return null;
    }
    return new azui(paramLong, paramItem, paramInt, paramazuk);
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
      azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop fetch. mStatus:" + this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Azuf == null) {
        break label197;
      }
      this.jdField_a_of_type_Azuf.c();
      this.jdField_a_of_type_Azuf = null;
    }
    for (;;)
    {
      g();
      if (this.jdField_a_of_type_Azsh != null)
      {
        xam.a(azsr.a(), this.jdField_a_of_type_Azsh);
        this.jdField_a_of_type_Azsh = null;
      }
      e();
      if (!TextUtils.isEmpty(this.d)) {
        bbdx.d(this.d);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      azsd.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      b(0);
      return;
      label197:
      azst.b("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop downloader=null");
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration == 0) && (paramInt != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration = paramInt;
      this.jdField_a_of_type_Azuf.b(true);
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startFetch app=null");
      c(bamw.w);
      return;
    }
    bbdx.d(this.d);
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
      if (bakx.d(localQQAppInterface))
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
        if (apvm.b(localQQAppInterface))
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
        long l = azsr.a();
        azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startFetch. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + str1 + " mTmpFilePath:" + this.d + " bUseHttps:" + bool1 + " httpsDomain:" + paramString);
        if (this.jdField_a_of_type_Azuf != null)
        {
          this.jdField_a_of_type_Azuf.c();
          this.jdField_a_of_type_Azuf = null;
        }
        this.jdField_a_of_type_Azuf = azuf.a(localQQAppInterface, l, this.d, 0L, localArrayList, str1, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, this.jdField_b_of_type_Boolean, bool1, paramString);
        if (this.jdField_a_of_type_Azuf != null) {
          break label779;
        }
        c(bamw.w);
        return;
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + ":" + paramInt1);
        break;
        paramString = localObject;
        bool1 = bool3;
        if (bakx.d(localQQAppInterface))
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
          if (apvm.a())
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
      this.jdField_a_of_type_Azuf.a(this);
      this.jdField_a_of_type_Azuf.i();
      this.jdField_a_of_type_Azuf.a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration != 0) {
        this.jdField_a_of_type_Azuf.b(true);
      }
      this.jdField_a_of_type_Azuf.b();
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
    this.jdField_a_of_type_Azsh = null;
    g();
    if ((!paramBoolean) && (!apug.a(new VFSFile(this.d), new VFSFile(this.e))))
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.e);
      if (bbdx.b(this.e)) {
        c(bamw.o);
      }
    }
    do
    {
      return;
      b(3);
      f();
      azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFetchSuc  mFilePath:" + this.e);
      if (!paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      }
      if ((this.jdField_a_of_type_Int == 640) && (!apvd.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_Long, 383)))) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      apuy.a(this.e, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = localOptions.outWidth;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = localOptions.outHeight;
      }
      azsd.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      azsd.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    } while (this.jdField_a_of_type_Azuk == null);
    this.jdField_a_of_type_Azuk.a(a(), true, 0, this);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. fetch fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    int i;
    if (paramInt == -5000) {
      i = bamw.h;
    }
    for (;;)
    {
      c(i);
      return;
      if (paramInt == -5001)
      {
        i = bamw.g;
      }
      else if (paramInt == 9039)
      {
        i = bamw.n;
      }
      else if (paramInt == 9004)
      {
        i = bamw.k;
      }
      else if (paramInt == 9301)
      {
        i = bamw.i;
      }
      else if (paramInt == -5001)
      {
        i = bamw.q;
      }
      else if (this.jdField_a_of_type_Azuf.b())
      {
        i = bamw.p;
      }
      else
      {
        i = paramInt;
        if (paramInt == -5003) {
          i = bamw.y;
        }
      }
    }
  }
  
  public boolean a()
  {
    azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start fetch thumb. filename:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.post(new TroopFileThumbnailFetchWorker.1(this), 8, null, false);
    return true;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqFetch app=null");
      c(bamw.w);
      return;
    }
    azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqFetch");
    this.jdField_a_of_type_Azsh = xam.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, false, false, this.jdField_a_of_type_Xba);
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
    this.jdField_b_of_type_JavaLangString = azun.a();
    this.c = this.jdField_b_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Azsh = null;
    g();
    if (!TextUtils.isEmpty(this.d)) {
      bbdx.d(this.d);
    }
    b(4);
    e();
    azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFetchErr  errCode:" + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    if (paramInt == bamw.y) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 1;
    }
    for (;;)
    {
      azsd.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      if (this.jdField_a_of_type_Azuk != null) {
        this.jdField_a_of_type_Azuk.a(a(), false, paramInt, this);
      }
      return;
      if (paramInt == bamw.p) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 2;
      } else {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 0;
      }
    }
  }
  
  public void d() {}
  
  protected void e()
  {
    azun.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 383) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ThumbnailDownloading_Middle_Fail = true;
    }
  }
  
  protected void f()
  {
    azun.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    boolean bool = azun.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, this.e);
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
 * Qualified Name:     azui
 * JD-Core Version:    0.7.0.1
 */