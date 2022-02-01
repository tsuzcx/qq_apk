package com.android.dx.command.annotool;

import java.lang.annotation.ElementType;
import java.util.EnumSet;
import java.util.Locale;

class Main$Arguments
{
  String aclass;
  EnumSet<ElementType> eTypes = EnumSet.noneOf(ElementType.class);
  String[] files;
  EnumSet<Main.PrintType> printTypes = EnumSet.noneOf(Main.PrintType.class);
  
  void parse(String[] paramArrayOfString)
  {
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      Object localObject1 = paramArrayOfString[i];
      if (((String)localObject1).startsWith("--annotation="))
      {
        localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf('=') + 1);
        if (this.aclass != null) {
          throw new Main.InvalidArgumentException("--annotation can only be specified once.");
        }
        this.aclass = ((String)localObject1).replace('.', '/');
      }
      for (;;)
      {
        i += 1;
        break;
        int k;
        int j;
        Object localObject2;
        if (((String)localObject1).startsWith("--element="))
        {
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf('=') + 1);
          try
          {
            localObject1 = ((String)localObject1).split(",");
            k = localObject1.length;
            j = 0;
            while (j < k)
            {
              localObject2 = localObject1[j];
              this.eTypes.add(ElementType.valueOf(localObject2.toUpperCase(Locale.ROOT)));
              j += 1;
            }
            if (!((String)localObject1).startsWith("--print=")) {
              break label258;
            }
          }
          catch (IllegalArgumentException paramArrayOfString)
          {
            throw new Main.InvalidArgumentException("invalid --element");
          }
        }
        else
        {
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf('=') + 1);
          try
          {
            localObject1 = ((String)localObject1).split(",");
            k = localObject1.length;
            j = 0;
            while (j < k)
            {
              localObject2 = localObject1[j];
              this.printTypes.add(Main.PrintType.valueOf(localObject2.toUpperCase(Locale.ROOT)));
              j += 1;
            }
            this.files = new String[paramArrayOfString.length - i];
          }
          catch (IllegalArgumentException paramArrayOfString)
          {
            throw new Main.InvalidArgumentException("invalid --print");
          }
        }
      }
      label258:
      System.arraycopy(paramArrayOfString, i, this.files, 0, this.files.length);
    }
    if (this.aclass == null) {
      throw new Main.InvalidArgumentException("--annotation must be specified");
    }
    if (this.printTypes.isEmpty()) {
      this.printTypes.add(Main.PrintType.CLASS);
    }
    if (this.eTypes.isEmpty()) {
      this.eTypes.add(ElementType.TYPE);
    }
    paramArrayOfString = this.eTypes.clone();
    paramArrayOfString.remove(ElementType.TYPE);
    paramArrayOfString.remove(ElementType.PACKAGE);
    if (!paramArrayOfString.isEmpty()) {
      throw new Main.InvalidArgumentException("only --element parameters 'type' and 'package' supported");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.annotool.Main.Arguments
 * JD-Core Version:    0.7.0.1
 */