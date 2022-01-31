import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class aytn
  extends aytc
{
  protected boolean c;
  protected boolean d;
  protected long g = 2000L;
  
  protected aytn(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    super(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean2, paramString4);
    this.c = paramBoolean1;
  }
  
  public static aytn a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strSavePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      aysb.a("TroopFileThumbDownloader", aysb.a, "getFileDownloader " + str);
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
    return new aytn(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean1, paramBoolean2, paramString4);
  }
  
  public void a(bakw parambakw)
  {
    int k = 0;
    if (!this.c) {
      break label10;
    }
    label10:
    while (this.d) {
      return;
    }
    parambakw = parambakw.a("Set-Cookie");
    i = k;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(parambakw))
        {
          i = k;
          if (parambakw.contains("duration"))
          {
            parambakw = parambakw.trim().split(";");
            i = k;
            if (parambakw != null)
            {
              i = k;
              if (parambakw.length > 0)
              {
                j = 0;
                i = k;
                if (j < parambakw.length)
                {
                  String[] arrayOfString = parambakw[j].split("=");
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
      catch (Exception parambakw)
      {
        int j;
        i = 0;
        continue;
      }
      if ((i == 0) || (this.jdField_a_of_type_Aysu == null) || (!(this.jdField_a_of_type_Aysu instanceof ayto))) {
        break;
      }
      ((ayto)this.jdField_a_of_type_Aysu).a(i);
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
    this.jdField_a_of_type_Ayrw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aytn
 * JD-Core Version:    0.7.0.1
 */