package com.tencent.TMG.internal.anttask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public class GenerateClassTask
{
  private static final String DEFAULT_DISABLED_CRASH_CATCHER = "true";
  
  private ArrayList<String> getConditionVariables(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str;
    if (!"".equals(paramString))
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        str = paramString[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("    boolean ");
        localStringBuilder.append(str);
        localStringBuilder.append(";");
        localArrayList.add(localStringBuilder.toString());
        i += 1;
      }
    }
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      str = (String)paramString.next();
      System.out.println(str);
    }
    return localArrayList;
  }
  
  private String getFileContent(File paramFile)
  {
    paramFile = new BufferedReader(new FileReader(paramFile));
    AtomicReference localAtomicReference = new AtomicReference(new StringBuilder());
    for (;;)
    {
      String str = paramFile.readLine();
      if (str == null) {
        break;
      }
      ((StringBuilder)localAtomicReference.get()).append(str);
    }
    paramFile.close();
    return localAtomicReference.toString().replaceAll("\\s*", "");
  }
  
  public void execute()
  {
    System.out.println("GenerateClassTask execute");
    Object localObject1 = "com.tencent.TMG.utils".replaceAll("\\.", File.separator);
    Object localObject2 = "hal Android qavsdkjar_temp src".replaceAll(" ", File.separator);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject2 = new File((String)localObject1);
    if ((((File)localObject2).exists()) || (((File)localObject2).mkdirs()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("CompilationConfig");
      ((StringBuilder)localObject2).append(".java");
      localObject2 = new File((String)localObject1, ((StringBuilder)localObject2).toString());
      try
      {
        if ((((File)localObject2).exists()) || (((File)localObject2).createNewFile()))
        {
          localObject1 = getConditionVariables(getFileContent((File)localObject2));
          localObject3 = new PrintWriter((File)localObject2, "UTF-8");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("package ");
          ((StringBuilder)localObject2).append("com.tencent.TMG.utils");
          ((StringBuilder)localObject2).append(";");
          ((PrintWriter)localObject3).println(((StringBuilder)localObject2).toString());
          ((PrintWriter)localObject3).println();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("public interface ");
          ((StringBuilder)localObject2).append("CompilationConfig");
          ((StringBuilder)localObject2).append(" {");
          ((PrintWriter)localObject3).println(((StringBuilder)localObject2).toString());
          Iterator localIterator = ((ArrayList)localObject1).iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (String)localIterator.next();
            localObject1 = localObject2;
            if (!((String)localObject2).contains("=true"))
            {
              localObject1 = localObject2;
              if (!((String)localObject2).contains("=false"))
              {
                localObject1 = ((String)localObject2).split("=");
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(localObject1[0]);
                ((StringBuilder)localObject2).append("=");
                ((StringBuilder)localObject2).append("true");
                ((StringBuilder)localObject2).append(";");
                localObject1 = ((StringBuilder)localObject2).toString();
              }
            }
            ((PrintWriter)localObject3).println((String)localObject1);
          }
          ((PrintWriter)localObject3).println("}");
          ((PrintWriter)localObject3).close();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.internal.anttask.GenerateClassTask
 * JD-Core Version:    0.7.0.1
 */