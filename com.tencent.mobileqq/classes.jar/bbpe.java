import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.util.Iterator;
import java.util.List;

public class bbpe
  extends arac<bbpd>
{
  public bbpd a;
  
  public static bbpe a()
  {
    return bbpg.a();
  }
  
  public bbpd a()
  {
    this.a = ((bbpd)aran.a().a(654));
    return this.a;
  }
  
  @NonNull
  public bbpd a(int paramInt)
  {
    return new bbpd();
  }
  
  @Nullable
  public bbpd a(araj[] paramArrayOfaraj)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("LiuHaiWhiteListConfProcessor", 4, "onParsed confFiles = " + paramArrayOfaraj);
    if (this.a == null) {
      this.a = new bbpd();
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      paramArrayOfaraj = paramArrayOfaraj[0].a;
      BrowserLogHelper.getInstance().getGalleryLog().d("LiuHaiWhiteListConfProcessor", 4, "onParsed config = " + paramArrayOfaraj);
      this.a.a = bbpc.a(paramArrayOfaraj);
    }
    return this.a;
  }
  
  public void a(bbpd parambbpd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiWhiteListConfProcessor", 2, "onUpdate newConf = " + parambbpd);
    }
    if ((parambbpd != null) && (parambbpd.a != null)) {
      this.a = parambbpd;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (this.a == null) {
      this.a = a();
    }
    if ((this.a == null) || (this.a.a == null) || (this.a.a.isEmpty())) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext())
      {
        bbph localbbph = (bbph)localIterator.next();
        if ((!TextUtils.isEmpty(localbbph.a)) && (!TextUtils.isEmpty(localbbph.b)) && (!TextUtils.isEmpty(localbbph.c)) && (paramString1.equals(localbbph.a)) && (paramString2.equals(localbbph.b)) && (paramString3.equals(localbbph.c))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Class<bbpd> clazz()
  {
    return bbpd.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiWhiteListConfProcessor", 2, "onReqFailed failCode = " + paramInt);
    }
  }
  
  public int type()
  {
    return 654;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpe
 * JD-Core Version:    0.7.0.1
 */