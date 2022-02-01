import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class atky
{
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new atld(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new atlm(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(atmk paramatmk, FileManagerEntity paramFileManagerEntity)
  {
    return new atlh(paramFileManagerEntity, paramatmk);
  }
  
  public static View.OnClickListener a(atmk paramatmk, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new atli(paramFileManagerEntity, paramActivity, paramatmk);
  }
  
  public static View.OnClickListener a(atmk paramatmk, String paramString)
  {
    return new atkz(paramString, paramatmk);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean)
  {
    return new atlc(paramFileManagerEntity, paramActivity, paramBoolean);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new atle(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(Activity paramActivity, String paramString)
  {
    return new atlf(paramActivity, paramString);
  }
  
  public static View.OnClickListener b(atmk paramatmk, FileManagerEntity paramFileManagerEntity)
  {
    return new atlj(paramFileManagerEntity, paramatmk);
  }
  
  public static View.OnClickListener b(atmk paramatmk, String paramString)
  {
    return new atll(paramString, paramatmk);
  }
  
  public static View.OnClickListener c(atmk paramatmk, FileManagerEntity paramFileManagerEntity)
  {
    return new atlk(paramFileManagerEntity, paramatmk);
  }
  
  public static View.OnClickListener d(atmk paramatmk, FileManagerEntity paramFileManagerEntity)
  {
    return new atln(paramatmk, paramFileManagerEntity);
  }
  
  public static View.OnClickListener e(atmk paramatmk, FileManagerEntity paramFileManagerEntity)
  {
    return new atlo(paramatmk, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atky
 * JD-Core Version:    0.7.0.1
 */