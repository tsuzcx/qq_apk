import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class arfu
{
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new arfz(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new argg(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(arhw paramarhw, FileManagerEntity paramFileManagerEntity)
  {
    return new argb(paramFileManagerEntity, paramarhw);
  }
  
  public static View.OnClickListener a(arhw paramarhw, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new argc(paramFileManagerEntity, paramActivity, paramarhw);
  }
  
  public static View.OnClickListener a(arhw paramarhw, String paramString)
  {
    return new arfv(paramString, paramarhw);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean)
  {
    return new arfy(paramFileManagerEntity, paramActivity, paramBoolean);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new arga(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(arhw paramarhw, FileManagerEntity paramFileManagerEntity)
  {
    return new argd(paramFileManagerEntity, paramarhw);
  }
  
  public static View.OnClickListener b(arhw paramarhw, String paramString)
  {
    return new argf(paramString, paramarhw);
  }
  
  public static View.OnClickListener c(arhw paramarhw, FileManagerEntity paramFileManagerEntity)
  {
    return new arge(paramFileManagerEntity, paramarhw);
  }
  
  public static View.OnClickListener d(arhw paramarhw, FileManagerEntity paramFileManagerEntity)
  {
    return new argh(paramarhw, paramFileManagerEntity);
  }
  
  public static View.OnClickListener e(arhw paramarhw, FileManagerEntity paramFileManagerEntity)
  {
    return new argi(paramarhw, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfu
 * JD-Core Version:    0.7.0.1
 */