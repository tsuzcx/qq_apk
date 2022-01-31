import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class apik
{
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new apip(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new apiw(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(apkm paramapkm, FileManagerEntity paramFileManagerEntity)
  {
    return new apir(paramFileManagerEntity, paramapkm);
  }
  
  public static View.OnClickListener a(apkm paramapkm, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new apis(paramFileManagerEntity, paramActivity, paramapkm);
  }
  
  public static View.OnClickListener a(apkm paramapkm, String paramString)
  {
    return new apil(paramString, paramapkm);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean)
  {
    return new apio(paramFileManagerEntity, paramActivity, paramBoolean);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new apiq(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(apkm paramapkm, FileManagerEntity paramFileManagerEntity)
  {
    return new apit(paramFileManagerEntity, paramapkm);
  }
  
  public static View.OnClickListener b(apkm paramapkm, String paramString)
  {
    return new apiv(paramString, paramapkm);
  }
  
  public static View.OnClickListener c(apkm paramapkm, FileManagerEntity paramFileManagerEntity)
  {
    return new apiu(paramFileManagerEntity, paramapkm);
  }
  
  public static View.OnClickListener d(apkm paramapkm, FileManagerEntity paramFileManagerEntity)
  {
    return new apix(paramapkm, paramFileManagerEntity);
  }
  
  public static View.OnClickListener e(apkm paramapkm, FileManagerEntity paramFileManagerEntity)
  {
    return new apiy(paramapkm, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apik
 * JD-Core Version:    0.7.0.1
 */