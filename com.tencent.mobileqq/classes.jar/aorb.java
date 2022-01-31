import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aorb
{
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new aorf(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new aorl(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(aotc paramaotc, FileManagerEntity paramFileManagerEntity)
  {
    return new aorh(paramFileManagerEntity, paramaotc);
  }
  
  public static View.OnClickListener a(aotc paramaotc, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new aori(paramFileManagerEntity, paramActivity, paramaotc);
  }
  
  public static View.OnClickListener a(aotc paramaotc, String paramString)
  {
    return new aorc(paramString, paramaotc);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean)
  {
    return new aoro(paramFileManagerEntity, paramActivity, paramBoolean);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new aorg(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(aotc paramaotc, FileManagerEntity paramFileManagerEntity)
  {
    return new aorj(paramFileManagerEntity, paramaotc);
  }
  
  public static View.OnClickListener b(aotc paramaotc, String paramString)
  {
    return new aork(paramString, paramaotc);
  }
  
  public static View.OnClickListener c(aotc paramaotc, FileManagerEntity paramFileManagerEntity)
  {
    return new aorm(paramaotc, paramFileManagerEntity);
  }
  
  public static View.OnClickListener d(aotc paramaotc, FileManagerEntity paramFileManagerEntity)
  {
    return new aorn(paramaotc, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aorb
 * JD-Core Version:    0.7.0.1
 */