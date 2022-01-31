import android.app.Activity;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;

public class ayga
  implements ajtg
{
  public WeakReference<Activity> a;
  
  public ayga(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (paramObject == null);
              paramObject = (Object[])paramObject;
            } while (paramObject.length != 2);
            a((String)paramObject[0], (String)paramObject[1]);
            return;
            a();
            return;
          } while (paramObject == null);
          paramObject = (Object[])paramObject;
        } while (paramObject.length != 1);
        try
        {
          paramObject = (JSONObject)paramObject[0];
          String str = paramObject.optString("url");
          paramInt = paramObject.optInt("ret");
          paramObject = URLDecoder.decode(str, "UTF-8");
          if ((paramInt == 0) && (paramObject.length() > 0))
          {
            a(paramBoolean, paramObject);
            return;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          a(paramObject.toString(), "");
          return;
        }
        a(paramInt + "", "");
        return;
      } while (paramObject == null);
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 1);
    a(((Integer)paramObject[0]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayga
 * JD-Core Version:    0.7.0.1
 */