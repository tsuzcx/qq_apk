import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class arbl
{
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new arbq(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new arbx(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(ardn paramardn, FileManagerEntity paramFileManagerEntity)
  {
    return new arbs(paramFileManagerEntity, paramardn);
  }
  
  public static View.OnClickListener a(ardn paramardn, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new arbt(paramFileManagerEntity, paramActivity, paramardn);
  }
  
  public static View.OnClickListener a(ardn paramardn, String paramString)
  {
    return new arbm(paramString, paramardn);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean)
  {
    return new arbp(paramFileManagerEntity, paramActivity, paramBoolean);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new arbr(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(ardn paramardn, FileManagerEntity paramFileManagerEntity)
  {
    return new arbu(paramFileManagerEntity, paramardn);
  }
  
  public static View.OnClickListener b(ardn paramardn, String paramString)
  {
    return new arbw(paramString, paramardn);
  }
  
  public static View.OnClickListener c(ardn paramardn, FileManagerEntity paramFileManagerEntity)
  {
    return new arbv(paramFileManagerEntity, paramardn);
  }
  
  public static View.OnClickListener d(ardn paramardn, FileManagerEntity paramFileManagerEntity)
  {
    return new arby(paramardn, paramFileManagerEntity);
  }
  
  public static View.OnClickListener e(ardn paramardn, FileManagerEntity paramFileManagerEntity)
  {
    return new arbz(paramardn, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbl
 * JD-Core Version:    0.7.0.1
 */