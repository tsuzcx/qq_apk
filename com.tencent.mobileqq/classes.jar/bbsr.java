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

public class bbsr
  implements bbsp
{
  public int a;
  public long a;
  protected bbqq a;
  protected bbso a;
  protected bbst a;
  public TroopFileTransferManager.Item a;
  public String a;
  protected Timer a;
  ypt a;
  public boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected String c;
  public String d;
  public String e;
  
  protected bbsr(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, bbst parambbst)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Ypt = new bbss(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Bbst = parambbst;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = bbsq.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id, paramInt);
    if (arni.a(arof.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName)) == 2) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public static bbsr a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, bbst parambbst)
  {
    if (paramLong == 0L)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    if (paramInt == 0)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "getWoker. nThumbSize=0");
      return null;
    }
    return new bbsr(paramLong, paramItem, paramInt, parambbst);
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
      bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop fetch. mStatus:" + this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Bbso == null) {
        break label197;
      }
      this.jdField_a_of_type_Bbso.c();
      this.jdField_a_of_type_Bbso = null;
    }
    for (;;)
    {
      g();
      if (this.jdField_a_of_type_Bbqq != null)
      {
        ypf.a(bbra.a(), this.jdField_a_of_type_Bbqq);
        this.jdField_a_of_type_Bbqq = null;
      }
      e();
      if (!TextUtils.isEmpty(this.d)) {
        bdcs.d(this.d);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      bbqm.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      b(0);
      return;
      label197:
      bbrc.b("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop downloader=null");
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration == 0) && (paramInt != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration = paramInt;
      this.jdField_a_of_type_Bbso.b(true);
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startFetch app=null");
      c(bclj.w);
      return;
    }
    bdcs.d(this.d);
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
      if (bcjk.d(localQQAppInterface))
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
        if (aroo.b(localQQAppInterface))
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
        long l = bbra.a();
        bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startFetch. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + str1 + " mTmpFilePath:" + this.d + " bUseHttps:" + bool1 + " httpsDomain:" + paramString);
        if (this.jdField_a_of_type_Bbso != null)
        {
          this.jdField_a_of_type_Bbso.c();
          this.jdField_a_of_type_Bbso = null;
        }
        this.jdField_a_of_type_Bbso = bbso.a(localQQAppInterface, l, this.d, 0L, localArrayList, str1, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, this.jdField_b_of_type_Boolean, bool1, paramString);
        if (this.jdField_a_of_type_Bbso != null) {
          break label779;
        }
        c(bclj.w);
        return;
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + ":" + paramInt1);
        break;
        paramString = localObject;
        bool1 = bool3;
        if (bcjk.d(localQQAppInterface))
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
          if (aroo.a())
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
      this.jdField_a_of_type_Bbso.a(this);
      this.jdField_a_of_type_Bbso.i();
      this.jdField_a_of_type_Bbso.a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration != 0) {
        this.jdField_a_of_type_Bbso.b(true);
      }
      this.jdField_a_of_type_Bbso.b();
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
    this.jdField_a_of_type_Bbqq = null;
    g();
    if ((!paramBoolean) && (!arni.a(new VFSFile(this.d), new VFSFile(this.e))))
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.e);
      if (bdcs.b(this.e)) {
        c(bclj.o);
      }
    }
    do
    {
      return;
      b(3);
      f();
      bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFetchSuc  mFilePath:" + this.e);
      if (!paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      }
      if ((this.jdField_a_of_type_Int == 640) && (!arof.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_Long, 383)))) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      aroa.a(this.e, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = localOptions.outWidth;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = localOptions.outHeight;
      }
      bbqm.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      bbqm.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    } while (this.jdField_a_of_type_Bbst == null);
    this.jdField_a_of_type_Bbst.a(a(), true, 0, this);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. fetch fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    int i;
    if (paramInt == -5000) {
      i = bclj.h;
    }
    for (;;)
    {
      c(i);
      return;
      if (paramInt == -5001)
      {
        i = bclj.g;
      }
      else if (paramInt == 9039)
      {
        i = bclj.n;
      }
      else if (paramInt == 9004)
      {
        i = bclj.k;
      }
      else if (paramInt == 9301)
      {
        i = bclj.i;
      }
      else if (paramInt == -5001)
      {
        i = bclj.q;
      }
      else if (this.jdField_a_of_type_Bbso.b())
      {
        i = bclj.p;
      }
      else
      {
        i = paramInt;
        if (paramInt == -5003) {
          i = bclj.y;
        }
      }
    }
  }
  
  public boolean a()
  {
    bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start fetch thumb. filename:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.post(new TroopFileThumbnailFetchWorker.1(this), 8, null, false);
    return true;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqFetch app=null");
      c(bclj.w);
      return;
    }
    bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqFetch");
    this.jdField_a_of_type_Bbqq = ypf.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, false, false, this.jdField_a_of_type_Ypt);
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
    this.jdField_b_of_type_JavaLangString = bbsw.a();
    this.c = this.jdField_b_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bbqq = null;
    g();
    if (!TextUtils.isEmpty(this.d)) {
      bdcs.d(this.d);
    }
    b(4);
    e();
    bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFetchErr  errCode:" + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    if (paramInt == bclj.y) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 1;
    }
    for (;;)
    {
      bbqm.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      if (this.jdField_a_of_type_Bbst != null) {
        this.jdField_a_of_type_Bbst.a(a(), false, paramInt, this);
      }
      return;
      if (paramInt == bclj.p) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 2;
      } else {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 0;
      }
    }
  }
  
  public void d() {}
  
  protected void e()
  {
    bbsw.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 383) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ThumbnailDownloading_Middle_Fail = true;
    }
  }
  
  protected void f()
  {
    bbsw.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    boolean bool = bbsw.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, this.e);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsr
 * JD-Core Version:    0.7.0.1
 */