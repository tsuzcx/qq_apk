import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bcpr
{
  public static final void a()
  {
    a("gfile", "gfile_upload", "", "", "", "");
  }
  
  public static final void a(int paramInt1, int paramInt2)
  {
    int i = bdin.b(BaseApplicationImpl.getContext());
    a("gfile", "gfile_upload_result", "" + paramInt1, "" + paramInt2, "" + i, "");
  }
  
  public static final void a(int paramInt1, int paramInt2, String paramString)
  {
    int i = bdin.b(BaseApplicationImpl.getContext());
    a("gfile", "gfile_upload_result", "" + paramInt1, "" + paramInt2, "" + i, paramString);
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      azqs.b((QQAppInterface)localObject, "dc00899", "Grp_tech_report", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
      if (QLog.isColorLevel()) {
        QLog.d("ReportTech", 2, "opType=" + paramString1 + ", opName=" + paramString2 + ", r1=" + paramString3 + ", r2=" + paramString4 + ",r3=" + paramString5 + ", r4" + paramString6);
      }
      return;
    }
  }
  
  public static final void a(String paramString, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if ((paramVarArgs != null) && (paramVarArgs.length <= 4))
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i];
        i += 1;
      }
    }
    a("page_exp", paramString, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
  }
  
  public static final void b()
  {
    a("gfile", "gfile_download", "", "", "", "");
  }
  
  public static final void b(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2, "");
  }
  
  public static final void b(int paramInt1, int paramInt2, String paramString)
  {
    int i = bdin.b(BaseApplicationImpl.getContext());
    a("gfile", "gfile_download_result", "" + paramInt1, "" + paramInt2, "" + i, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpr
 * JD-Core Version:    0.7.0.1
 */