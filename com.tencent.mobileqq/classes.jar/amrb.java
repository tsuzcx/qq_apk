import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.ISecurityFileHelper;

public class amrb
  extends amra
  implements ISecurityFileHelper
{
  public amrb()
  {
    super(null);
  }
  
  protected String a()
  {
    return "QQThemeMigration";
  }
  
  public String declareBusinessFileName()
  {
    return "QQ_Favorite";
  }
  
  public boolean doMigrate(File paramFile)
  {
    QLog.d("ISecurityFileHelper", 1, "Move Theme file start");
    paramFile = new File(ThemeDiyStyleLogic.getSdcardDIYDir());
    File[] arrayOfFile;
    int j;
    int i;
    Object localObject1;
    Object localObject2;
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      arrayOfFile = amqy.a(paramFile);
      j = arrayOfFile.length;
      i = 0;
      if (i < j)
      {
        localObject1 = arrayOfFile[i];
        if ((!((File)localObject1).isDirectory()) || (new File((File)localObject1, ".moveflag").exists())) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = ((File)localObject1).getName();
          if ((((String)localObject2).length() > 4) && (((String)localObject2).matches("[0-9]{5,}")))
          {
            localObject2 = paramFile.getAbsolutePath() + "/" + amqy.a((String)localObject2);
            bdhb.c((String)localObject2 + "/.moveflag");
            amqy.a(((File)localObject1).getAbsolutePath(), (String)localObject2);
          }
        }
      }
    }
    paramFile = new File(alof.aX);
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = amqy.a(paramFile);
      int n = paramFile.length;
      int k = 0;
      while (k < n)
      {
        arrayOfFile = paramFile[k];
        int m = 0;
        i = 0;
        localObject1 = arrayOfFile.getName();
        j = m;
        if (arrayOfFile.isDirectory())
        {
          j = m;
          if (((String)localObject1).length() > 4)
          {
            j = m;
            if (((String)localObject1).matches("[0-9]{5,}"))
            {
              if (amqy.a(arrayOfFile).length > 0)
              {
                localObject2 = amqy.a(arrayOfFile);
                int i1 = localObject2.length;
                m = 0;
                for (;;)
                {
                  j = i;
                  if (m >= i1) {
                    break;
                  }
                  Object localObject3 = localObject2[m];
                  j = i;
                  if (((File)localObject3).isDirectory())
                  {
                    j = i;
                    if (((File)localObject3).getName().equals("custom_background"))
                    {
                      localObject3 = amqy.a((File)localObject3);
                      j = localObject3.length;
                      i = 0;
                      while (i < j)
                      {
                        Object localObject4 = localObject3[i];
                        if (localObject4.isFile())
                        {
                          bdhb.c(ThemeDiyStyleLogic.getSdcardDIYDir() + amqy.a((String)localObject1) + "/.moveflag");
                          bdhb.a(localObject4.getAbsolutePath(), ThemeDiyStyleLogic.getSdcardDIYDir() + amqy.a((String)localObject1) + "/" + localObject4.getName());
                        }
                        i += 1;
                      }
                      j = 1;
                    }
                  }
                  m += 1;
                  i = j;
                }
              }
              j = 1;
            }
          }
        }
        if (j != 0) {
          bdhb.a(arrayOfFile.getAbsolutePath());
        }
        k += 1;
      }
    }
    a();
    return true;
  }
  
  public boolean needMigration()
  {
    return a();
  }
  
  public File oldBusinessDir(String paramString)
  {
    return null;
  }
  
  public boolean oldBusinessDirExist(String paramString)
  {
    return false;
  }
  
  public String[] reportHistoryFileInfo()
  {
    return new String[] { "0", "0" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amrb
 * JD-Core Version:    0.7.0.1
 */