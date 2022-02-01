package com.android.dx.command;

import java.io.PrintStream;

public class Main
{
  private static String USAGE_MESSAGE = "usage:\n  dx --dex [--debug] [--verbose] [--positions=<style>] [--no-locals]\n  [--no-optimize] [--statistics] [--[no-]optimize-list=<file>] [--no-strict]\n  [--keep-classes] [--output=<file>] [--dump-to=<file>] [--dump-width=<n>]\n  [--dump-method=<name>[*]] [--verbose-dump] [--no-files] [--core-library]\n  [--num-threads=<n>] [--incremental] [--force-jumbo] [--no-warning]\n  [--multi-dex [--main-dex-list=<file> [--minimal-main-dex]]\n  [--input-list=<file>]\n  [<file>.class | <file>.{zip,jar,apk} | <directory>] ...\n    Convert a set of classfiles into a dex file, optionally embedded in a\n    jar/zip. Output name must end with one of: .dex .jar .zip .apk or be a directory.\n    Positions options: none, important, lines.\n    --multi-dex: allows to generate several dex files if needed. This option is \n    exclusive with --incremental, causes --num-threads to be ignored and only\n    supports folder or archive output.\n    --main-dex-list=<file>: <file> is a list of class file names, classes defined by\n    those class files are put in classes.dex.\n    --minimal-main-dex: only classes selected by --main-dex-list are to be put in\n    the main dex.\n    --input-list: <file> is a list of inputs.\n    Each line in <file> must end with one of: .class .jar .zip .apk or be a directory.\n  dx --annotool --annotation=<class> [--element=<element types>]\n  [--print=<print types>]\n  dx --dump [--debug] [--strict] [--bytes] [--optimize]\n  [--basic-blocks | --rop-blocks | --ssa-blocks | --dot] [--ssa-step=<step>]\n  [--width=<n>] [<file>.class | <file>.txt] ...\n    Dump classfiles, or transformations thereof, in a human-oriented format.\n  dx --find-usages <file.dex> <declaring type> <member>\n    Find references and declarations to a field or method.\n    declaring type: a class name in internal form, like Ljava/lang/Object;\n    member: a field or method name, like hashCode\n  dx -J<option> ... <arguments, in one of the above forms>\n    Pass VM-specific options to the virtual machine that runs dx.\n  dx --version\n    Print the version of this tool (1.12).\n  dx --help\n    Print this message.";
  
  public static void main(String[] paramArrayOfString)
  {
    int k = 0;
    int m = 0;
    int j = 0;
    int i = 0;
    try
    {
      if (i < paramArrayOfString.length)
      {
        str = paramArrayOfString[i];
        if (!str.equals("--"))
        {
          bool = str.startsWith("--");
          if (bool) {}
        }
        else
        {
          i = 0;
          j = 1;
          if (i == 0)
          {
            System.err.println("error: no command specified");
            j = 1;
          }
          if (j != 0)
          {
            usage();
            System.exit(1);
          }
          return;
        }
      }
    }
    catch (UsageException paramArrayOfString)
    {
      for (;;)
      {
        try
        {
          String str;
          if (str.equals("--dex"))
          {
            com.android.dx.command.dexer.Main.main(without(paramArrayOfString, i));
            i = 1;
            continue;
          }
          if (str.equals("--dump"))
          {
            com.android.dx.command.dump.Main.main(without(paramArrayOfString, i));
            i = 1;
            continue;
          }
          if (str.equals("--annotool"))
          {
            com.android.dx.command.annotool.Main.main(without(paramArrayOfString, i));
            i = 1;
            continue;
          }
          if (str.equals("--find-usages"))
          {
            com.android.dx.command.findusages.Main.main(without(paramArrayOfString, i));
            i = 1;
            continue;
          }
          if (str.equals("--version"))
          {
            version();
            i = 1;
            continue;
          }
          boolean bool = str.equals("--help");
          if (bool)
          {
            j = 1;
            i = 1;
            continue;
          }
          i += 1;
        }
        catch (Throwable paramArrayOfString)
        {
          i = 1;
          continue;
        }
        catch (RuntimeException paramArrayOfString)
        {
          i = 1;
          continue;
        }
        catch (UsageException paramArrayOfString)
        {
          i = 1;
          continue;
        }
        paramArrayOfString = paramArrayOfString;
        i = m;
        j = 1;
      }
    }
    catch (RuntimeException paramArrayOfString)
    {
      for (;;)
      {
        i = 0;
        System.err.println("\nUNEXPECTED TOP-LEVEL EXCEPTION:");
        paramArrayOfString.printStackTrace();
        System.exit(2);
        j = k;
      }
    }
    catch (Throwable paramArrayOfString)
    {
      for (;;)
      {
        i = 0;
        System.err.println("\nUNEXPECTED TOP-LEVEL ERROR:");
        paramArrayOfString.printStackTrace();
        if (((paramArrayOfString instanceof NoClassDefFoundError)) || ((paramArrayOfString instanceof NoSuchMethodError))) {
          System.err.println("Note: You may be using an incompatible virtual machine or class library.\n(This program is known to be incompatible with recent releases of GCJ.)");
        }
        System.exit(3);
        j = k;
        continue;
        i = 0;
      }
    }
  }
  
  private static void usage()
  {
    System.err.println(USAGE_MESSAGE);
  }
  
  private static void version()
  {
    System.err.println("dx version 1.12");
    System.exit(0);
  }
  
  private static String[] without(String[] paramArrayOfString, int paramInt)
  {
    int i = paramArrayOfString.length - 1;
    String[] arrayOfString = new String[i];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    System.arraycopy(paramArrayOfString, paramInt + 1, arrayOfString, paramInt, i - paramInt);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.Main
 * JD-Core Version:    0.7.0.1
 */