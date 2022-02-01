import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aoxj
{
  public static aoxh a(aoxk paramaoxk, ArrayList<aoxi> paramArrayList)
  {
    if ((paramaoxk != null) && (paramArrayList != null)) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramaoxk.d() != null) {
          break label134;
        }
        QLog.e("JumpParserFactory", 1, "createJumpParser error: param is null");
        return null;
      }
      catch (Exception paramaoxk)
      {
        aoxi localaoxi;
        QLog.e("JumpParserFactory", 1, "createJumpParser error: " + paramaoxk.getMessage());
        return null;
      }
      if (i < paramArrayList.size())
      {
        localaoxi = (aoxi)paramArrayList.get(i);
        if (!paramaoxk.d().startsWith(localaoxi.a())) {
          break label141;
        }
        paramaoxk = localaoxi.a();
        if (paramaoxk != null)
        {
          paramaoxk = paramaoxk.newInstance();
          if ((paramaoxk instanceof aoxh)) {
            paramaoxk = (aoxh)paramaoxk;
          } else {
            QLog.e("JumpParserFactory", 1, "createJumpParser error: not extends JumpParserBase");
          }
        }
        else
        {
          paramaoxk = null;
        }
      }
      else
      {
        paramaoxk = null;
        continue;
        label134:
        i = 0;
        continue;
      }
      return paramaoxk;
      label141:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxj
 * JD-Core Version:    0.7.0.1
 */