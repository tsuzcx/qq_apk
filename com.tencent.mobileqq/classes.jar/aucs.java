import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aucs
{
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new aucx(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new audg(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(auef paramauef, FileManagerEntity paramFileManagerEntity)
  {
    return new audb(paramFileManagerEntity, paramauef);
  }
  
  public static View.OnClickListener a(auef paramauef, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new audc(paramFileManagerEntity, paramActivity, paramauef);
  }
  
  public static View.OnClickListener a(auef paramauef, String paramString)
  {
    return new auct(paramString, paramauef);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean)
  {
    return new aucw(paramFileManagerEntity, paramActivity, paramBoolean);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new aucy(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(Activity paramActivity, String paramString)
  {
    return new aucz(paramActivity, paramString);
  }
  
  public static View.OnClickListener b(auef paramauef, FileManagerEntity paramFileManagerEntity)
  {
    return new audd(paramFileManagerEntity, paramauef);
  }
  
  public static View.OnClickListener b(auef paramauef, String paramString)
  {
    return new audf(paramString, paramauef);
  }
  
  public static View.OnClickListener c(auef paramauef, FileManagerEntity paramFileManagerEntity)
  {
    return new aude(paramFileManagerEntity, paramauef);
  }
  
  public static View.OnClickListener d(auef paramauef, FileManagerEntity paramFileManagerEntity)
  {
    return new audh(paramauef, paramFileManagerEntity);
  }
  
  public static View.OnClickListener e(auef paramauef, FileManagerEntity paramFileManagerEntity)
  {
    return new audi(paramauef, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucs
 * JD-Core Version:    0.7.0.1
 */