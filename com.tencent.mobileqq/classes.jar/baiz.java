import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.util.Iterator;
import java.util.List;

public class baiz
  extends aptq<baiy>
{
  public baiy a;
  
  public static baiz a()
  {
    return bajb.a();
  }
  
  public baiy a()
  {
    this.a = ((baiy)apub.a().a(654));
    return this.a;
  }
  
  @NonNull
  public baiy a(int paramInt)
  {
    return new baiy();
  }
  
  @Nullable
  public baiy a(aptx[] paramArrayOfaptx)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("LiuHaiWhiteListConfProcessor", 4, "onParsed confFiles = " + paramArrayOfaptx);
    if (this.a == null) {
      this.a = new baiy();
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      paramArrayOfaptx = paramArrayOfaptx[0].a;
      BrowserLogHelper.getInstance().getGalleryLog().d("LiuHaiWhiteListConfProcessor", 4, "onParsed config = " + paramArrayOfaptx);
      this.a.a = baix.a(paramArrayOfaptx);
    }
    return this.a;
  }
  
  public void a(baiy parambaiy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiWhiteListConfProcessor", 2, "onUpdate newConf = " + parambaiy);
    }
    if ((parambaiy != null) && (parambaiy.a != null)) {
      this.a = parambaiy;
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
        bajc localbajc = (bajc)localIterator.next();
        if ((!TextUtils.isEmpty(localbajc.a)) && (!TextUtils.isEmpty(localbajc.b)) && (!TextUtils.isEmpty(localbajc.c)) && (paramString1.equals(localbajc.a)) && (paramString2.equals(localbajc.b)) && (paramString3.equals(localbajc.c))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Class<baiy> clazz()
  {
    return baiy.class;
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
 * Qualified Name:     baiz
 * JD-Core Version:    0.7.0.1
 */