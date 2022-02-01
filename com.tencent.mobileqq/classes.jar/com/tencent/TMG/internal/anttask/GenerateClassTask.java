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
        localArrayList.add("    boolean " + str + ";");
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
    localObject1 = (String)localObject2 + File.separator + (String)localObject1;
    localObject2 = new File((String)localObject1);
    PrintWriter localPrintWriter;
    if ((((File)localObject2).exists()) || (((File)localObject2).mkdirs()))
    {
      localObject2 = new File((String)localObject1, "CompilationConfig" + ".java");
      try
      {
        Iterator localIterator;
        if ((((File)localObject2).exists()) || (((File)localObject2).createNewFile()))
        {
          localObject1 = getConditionVariables(getFileContent((File)localObject2));
          localPrintWriter = new PrintWriter((File)localObject2, "UTF-8");
          localPrintWriter.println("package " + "com.tencent.TMG.utils" + ";");
          localPrintWriter.println();
          localPrintWriter.println("public interface " + "CompilationConfig" + " {");
          localIterator = ((ArrayList)localObject1).iterator();
        }
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
              localObject1 = localObject1[0] + "=" + "true" + ";";
            }
          }
          localPrintWriter.println((String)localObject1);
          continue;
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    localPrintWriter.println("}");
    localPrintWriter.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.internal.anttask.GenerateClassTask
 * JD-Core Version:    0.7.0.1
 */