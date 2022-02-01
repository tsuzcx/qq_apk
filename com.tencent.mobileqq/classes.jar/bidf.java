import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import java.util.ArrayList;

public abstract interface bidf
{
  public abstract void onException(String paramString);
  
  public abstract void onResult(ArrayList<ApkUpdateDetail> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidf
 * JD-Core Version:    0.7.0.1
 */