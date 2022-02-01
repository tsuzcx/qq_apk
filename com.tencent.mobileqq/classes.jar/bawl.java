import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.util.Iterator;
import java.util.List;

public class bawl
  extends aqkz<bawk>
{
  public bawk a;
  
  public static bawl a()
  {
    return bawn.a();
  }
  
  public bawk a()
  {
    this.a = ((bawk)aqlk.a().a(654));
    return this.a;
  }
  
  @NonNull
  public bawk a(int paramInt)
  {
    return new bawk();
  }
  
  @Nullable
  public bawk a(aqlg[] paramArrayOfaqlg)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("LiuHaiWhiteListConfProcessor", 4, "onParsed confFiles = " + paramArrayOfaqlg);
    if (this.a == null) {
      this.a = new bawk();
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      paramArrayOfaqlg = paramArrayOfaqlg[0].a;
      BrowserLogHelper.getInstance().getGalleryLog().d("LiuHaiWhiteListConfProcessor", 4, "onParsed config = " + paramArrayOfaqlg);
      this.a.a = bawj.a(paramArrayOfaqlg);
    }
    return this.a;
  }
  
  public void a(bawk parambawk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiWhiteListConfProcessor", 2, "onUpdate newConf = " + parambawk);
    }
    if ((parambawk != null) && (parambawk.a != null)) {
      this.a = parambawk;
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
        bawo localbawo = (bawo)localIterator.next();
        if ((!TextUtils.isEmpty(localbawo.a)) && (!TextUtils.isEmpty(localbawo.b)) && (!TextUtils.isEmpty(localbawo.c)) && (paramString1.equals(localbawo.a)) && (paramString2.equals(localbawo.b)) && (paramString3.equals(localbawo.c))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Class<bawk> clazz()
  {
    return bawk.class;
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
 * Qualified Name:     bawl
 * JD-Core Version:    0.7.0.1
 */