import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aspc
{
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new asph(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new aspq(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(asqp paramasqp, FileManagerEntity paramFileManagerEntity)
  {
    return new aspl(paramFileManagerEntity, paramasqp);
  }
  
  public static View.OnClickListener a(asqp paramasqp, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new aspm(paramFileManagerEntity, paramActivity, paramasqp);
  }
  
  public static View.OnClickListener a(asqp paramasqp, String paramString)
  {
    return new aspd(paramString, paramasqp);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean)
  {
    return new aspg(paramFileManagerEntity, paramActivity, paramBoolean);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new aspi(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(Activity paramActivity, String paramString)
  {
    return new aspj(paramActivity, paramString);
  }
  
  public static View.OnClickListener b(asqp paramasqp, FileManagerEntity paramFileManagerEntity)
  {
    return new aspn(paramFileManagerEntity, paramasqp);
  }
  
  public static View.OnClickListener b(asqp paramasqp, String paramString)
  {
    return new aspp(paramString, paramasqp);
  }
  
  public static View.OnClickListener c(asqp paramasqp, FileManagerEntity paramFileManagerEntity)
  {
    return new aspo(paramFileManagerEntity, paramasqp);
  }
  
  public static View.OnClickListener d(asqp paramasqp, FileManagerEntity paramFileManagerEntity)
  {
    return new aspr(paramasqp, paramFileManagerEntity);
  }
  
  public static View.OnClickListener e(asqp paramasqp, FileManagerEntity paramFileManagerEntity)
  {
    return new asps(paramasqp, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspc
 * JD-Core Version:    0.7.0.1
 */