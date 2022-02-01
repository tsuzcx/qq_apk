import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aouk
{
  public static aoui a(aoul paramaoul, ArrayList<aouj> paramArrayList)
  {
    if ((paramaoul != null) && (paramArrayList != null)) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramaoul.d() != null) {
          break label134;
        }
        QLog.e("JumpParserFactory", 1, "createJumpParser error: param is null");
        return null;
      }
      catch (Exception paramaoul)
      {
        aouj localaouj;
        QLog.e("JumpParserFactory", 1, "createJumpParser error: " + paramaoul.getMessage());
        return null;
      }
      if (i < paramArrayList.size())
      {
        localaouj = (aouj)paramArrayList.get(i);
        if (!paramaoul.d().startsWith(localaouj.a())) {
          break label141;
        }
        paramaoul = localaouj.a();
        if (paramaoul != null)
        {
          paramaoul = paramaoul.newInstance();
          if ((paramaoul instanceof aoui)) {
            paramaoul = (aoui)paramaoul;
          } else {
            QLog.e("JumpParserFactory", 1, "createJumpParser error: not extends JumpParserBase");
          }
        }
        else
        {
          paramaoul = null;
        }
      }
      else
      {
        paramaoul = null;
        continue;
        label134:
        i = 0;
        continue;
      }
      return paramaoul;
      label141:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aouk
 * JD-Core Version:    0.7.0.1
 */