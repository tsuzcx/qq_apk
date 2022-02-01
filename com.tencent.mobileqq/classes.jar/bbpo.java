import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.util.Iterator;
import java.util.List;

public class bbpo
  extends aqwt<bbpn>
{
  public bbpn a;
  
  public static bbpo a()
  {
    return bbpq.a();
  }
  
  public bbpn a()
  {
    this.a = ((bbpn)aqxe.a().a(654));
    return this.a;
  }
  
  @NonNull
  public bbpn a(int paramInt)
  {
    return new bbpn();
  }
  
  @Nullable
  public bbpn a(aqxa[] paramArrayOfaqxa)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("LiuHaiWhiteListConfProcessor", 4, "onParsed confFiles = " + paramArrayOfaqxa);
    if (this.a == null) {
      this.a = new bbpn();
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0].a;
      BrowserLogHelper.getInstance().getGalleryLog().d("LiuHaiWhiteListConfProcessor", 4, "onParsed config = " + paramArrayOfaqxa);
      this.a.a = bbpm.a(paramArrayOfaqxa);
    }
    return this.a;
  }
  
  public void a(bbpn parambbpn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiWhiteListConfProcessor", 2, "onUpdate newConf = " + parambbpn);
    }
    if ((parambbpn != null) && (parambbpn.a != null)) {
      this.a = parambbpn;
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
        bbpr localbbpr = (bbpr)localIterator.next();
        if ((!TextUtils.isEmpty(localbbpr.a)) && (!TextUtils.isEmpty(localbbpr.b)) && (!TextUtils.isEmpty(localbbpr.c)) && (paramString1.equals(localbbpr.a)) && (paramString2.equals(localbbpr.b)) && (paramString3.equals(localbbpr.c))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Class<bbpn> clazz()
  {
    return bbpn.class;
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
 * Qualified Name:     bbpo
 * JD-Core Version:    0.7.0.1
 */