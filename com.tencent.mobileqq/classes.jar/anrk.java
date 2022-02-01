import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class anrk
{
  public static anri a(anrl paramanrl, ArrayList<anrj> paramArrayList)
  {
    if ((paramanrl != null) && (paramArrayList != null)) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramanrl.d() != null) {
          break label134;
        }
        QLog.e("JumpParserFactory", 1, "createJumpParser error: param is null");
        return null;
      }
      catch (Exception paramanrl)
      {
        anrj localanrj;
        QLog.e("JumpParserFactory", 1, "createJumpParser error: " + paramanrl.getMessage());
        return null;
      }
      if (i < paramArrayList.size())
      {
        localanrj = (anrj)paramArrayList.get(i);
        if (!paramanrl.d().startsWith(localanrj.a())) {
          break label141;
        }
        paramanrl = localanrj.a();
        if (paramanrl != null)
        {
          paramanrl = paramanrl.newInstance();
          if ((paramanrl instanceof anri)) {
            paramanrl = (anri)paramanrl;
          } else {
            QLog.e("JumpParserFactory", 1, "createJumpParser error: not extends JumpParserBase");
          }
        }
        else
        {
          paramanrl = null;
        }
      }
      else
      {
        paramanrl = null;
        continue;
        label134:
        i = 0;
        continue;
      }
      return paramanrl;
      label141:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrk
 * JD-Core Version:    0.7.0.1
 */