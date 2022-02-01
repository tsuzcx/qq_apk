import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aojv
{
  public static aojt a(aojw paramaojw, ArrayList<aoju> paramArrayList)
  {
    if ((paramaojw != null) && (paramArrayList != null)) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramaojw.d() != null) {
          break label134;
        }
        QLog.e("JumpParserFactory", 1, "createJumpParser error: param is null");
        return null;
      }
      catch (Exception paramaojw)
      {
        aoju localaoju;
        QLog.e("JumpParserFactory", 1, "createJumpParser error: " + paramaojw.getMessage());
        return null;
      }
      if (i < paramArrayList.size())
      {
        localaoju = (aoju)paramArrayList.get(i);
        if (!paramaojw.d().startsWith(localaoju.a())) {
          break label141;
        }
        paramaojw = localaoju.a();
        if (paramaojw != null)
        {
          paramaojw = paramaojw.newInstance();
          if ((paramaojw instanceof aojt)) {
            paramaojw = (aojt)paramaojw;
          } else {
            QLog.e("JumpParserFactory", 1, "createJumpParser error: not extends JumpParserBase");
          }
        }
        else
        {
          paramaojw = null;
        }
      }
      else
      {
        paramaojw = null;
        continue;
        label134:
        i = 0;
        continue;
      }
      return paramaojw;
      label141:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojv
 * JD-Core Version:    0.7.0.1
 */