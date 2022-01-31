import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class apio
{
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new apit(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new apja(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(apkq paramapkq, FileManagerEntity paramFileManagerEntity)
  {
    return new apiv(paramFileManagerEntity, paramapkq);
  }
  
  public static View.OnClickListener a(apkq paramapkq, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new apiw(paramFileManagerEntity, paramActivity, paramapkq);
  }
  
  public static View.OnClickListener a(apkq paramapkq, String paramString)
  {
    return new apip(paramString, paramapkq);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean)
  {
    return new apis(paramFileManagerEntity, paramActivity, paramBoolean);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new apiu(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(apkq paramapkq, FileManagerEntity paramFileManagerEntity)
  {
    return new apix(paramFileManagerEntity, paramapkq);
  }
  
  public static View.OnClickListener b(apkq paramapkq, String paramString)
  {
    return new apiz(paramString, paramapkq);
  }
  
  public static View.OnClickListener c(apkq paramapkq, FileManagerEntity paramFileManagerEntity)
  {
    return new apiy(paramFileManagerEntity, paramapkq);
  }
  
  public static View.OnClickListener d(apkq paramapkq, FileManagerEntity paramFileManagerEntity)
  {
    return new apjb(paramapkq, paramFileManagerEntity);
  }
  
  public static View.OnClickListener e(apkq paramapkq, FileManagerEntity paramFileManagerEntity)
  {
    return new apjc(paramapkq, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apio
 * JD-Core Version:    0.7.0.1
 */