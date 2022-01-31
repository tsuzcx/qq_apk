import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class bbwx
  extends bbwm
{
  protected boolean c;
  protected boolean d;
  protected long g = 2000L;
  
  protected bbwx(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    super(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean2, paramString4);
    this.c = paramBoolean1;
  }
  
  public static bbwx a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strSavePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      bbvl.a("TroopFileThumbDownloader", bbvl.a, "getFileDownloader " + str);
      return null;
      if (paramString1.length() == 0) {
        str = "strSavePath is empty";
      } else if (paramList == null) {
        str = "lstUrl is null";
      } else if (paramList.size() == 0) {
        str = "lstUrl is empty";
      } else if (paramString2 == null) {
        str = "urlParams is null";
      } else if (paramString2.length() == 0) {
        str = "urlParams is empty";
      }
    }
    return new bbwx(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean1, paramBoolean2, paramString4);
  }
  
  public void a(bdpx parambdpx)
  {
    int k = 0;
    if (!this.c) {
      break label10;
    }
    label10:
    while (this.d) {
      return;
    }
    parambdpx = parambdpx.a("Set-Cookie");
    i = k;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(parambdpx))
        {
          i = k;
          if (parambdpx.contains("duration"))
          {
            parambdpx = parambdpx.trim().split(";");
            i = k;
            if (parambdpx != null)
            {
              i = k;
              if (parambdpx.length > 0)
              {
                j = 0;
                i = k;
                if (j < parambdpx.length)
                {
                  String[] arrayOfString = parambdpx[j].split("=");
                  if ((arrayOfString == null) || (arrayOfString.length != 2) || (!"duration".equals(arrayOfString[0]))) {
                    continue;
                  }
                  i = Integer.parseInt(arrayOfString[1]);
                }
              }
            }
          }
        }
      }
      catch (Exception parambdpx)
      {
        int j;
        i = 0;
        continue;
      }
      if ((i == 0) || (this.jdField_a_of_type_Bbwe == null) || (!(this.jdField_a_of_type_Bbwe instanceof bbwy))) {
        break;
      }
      ((bbwy)this.jdField_a_of_type_Bbwe).a(i);
      return;
      j += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public long b()
  {
    if (this.g <= 6000L)
    {
      long l = this.g;
      this.g = (2000L + this.g);
      return l;
    }
    return 2000L;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void i()
  {
    this.jdField_a_of_type_Bbvg.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwx
 * JD-Core Version:    0.7.0.1
 */