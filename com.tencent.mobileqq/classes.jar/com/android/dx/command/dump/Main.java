package com.android.dx.command.dump;

import com.android.dex.util.FileUtils;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.util.HexParser;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main
{
  static Args parsedArgs = new Args();
  
  public static void main(String[] paramArrayOfString)
  {
    int i = 0;
    Object localObject;
    int j;
    if (i < paramArrayOfString.length)
    {
      localObject = paramArrayOfString[i];
      if ((!((String)localObject).equals("--")) && (((String)localObject).startsWith("--"))) {}
    }
    else
    {
      j = i;
      if (i != paramArrayOfString.length) {
        break label369;
      }
      System.err.println("no input files specified");
      throw new RuntimeException("usage");
    }
    if (((String)localObject).equals("--bytes")) {
      parsedArgs.rawBytes = true;
    }
    for (;;)
    {
      i += 1;
      break;
      if (((String)localObject).equals("--basic-blocks"))
      {
        parsedArgs.basicBlocks = true;
      }
      else if (((String)localObject).equals("--rop-blocks"))
      {
        parsedArgs.ropBlocks = true;
      }
      else if (((String)localObject).equals("--optimize"))
      {
        parsedArgs.optimize = true;
      }
      else if (((String)localObject).equals("--ssa-blocks"))
      {
        parsedArgs.ssaBlocks = true;
      }
      else if (((String)localObject).startsWith("--ssa-step="))
      {
        parsedArgs.ssaStep = ((String)localObject).substring(((String)localObject).indexOf('=') + 1);
      }
      else if (((String)localObject).equals("--debug"))
      {
        parsedArgs.debug = true;
      }
      else if (((String)localObject).equals("--dot"))
      {
        parsedArgs.dotDump = true;
      }
      else if (((String)localObject).equals("--strict"))
      {
        parsedArgs.strictParse = true;
      }
      else if (((String)localObject).startsWith("--width="))
      {
        localObject = ((String)localObject).substring(((String)localObject).indexOf('=') + 1);
        parsedArgs.width = Integer.parseInt((String)localObject);
      }
      else
      {
        if (!((String)localObject).startsWith("--method=")) {
          break label333;
        }
        localObject = ((String)localObject).substring(((String)localObject).indexOf('=') + 1);
        parsedArgs.method = ((String)localObject);
      }
    }
    label333:
    System.err.println("unknown option: " + (String)localObject);
    throw new RuntimeException("usage");
    for (;;)
    {
      label369:
      if (j < paramArrayOfString.length)
      {
        String str = paramArrayOfString[j];
        try
        {
          System.out.println("reading " + str + "...");
          byte[] arrayOfByte = FileUtils.readFile(str);
          boolean bool = str.endsWith(".class");
          localObject = arrayOfByte;
          if (!bool) {}
          try
          {
            localObject = new String(arrayOfByte, "utf-8");
            localObject = HexParser.parse((String)localObject);
            processOne(str, (byte[])localObject);
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            throw new RuntimeException("shouldn't happen", localUnsupportedEncodingException);
          }
          return;
        }
        catch (ParseException localParseException)
        {
          System.err.println("\ntrouble parsing:");
          if (parsedArgs.debug) {
            localParseException.printStackTrace();
          } else {
            localParseException.printContext(System.err);
          }
        }
      }
      j += 1;
    }
  }
  
  private static void processOne(String paramString, byte[] paramArrayOfByte)
  {
    if (parsedArgs.dotDump)
    {
      DotDumper.dump(paramArrayOfByte, paramString, parsedArgs);
      return;
    }
    if (parsedArgs.basicBlocks)
    {
      BlockDumper.dump(paramArrayOfByte, System.out, paramString, false, parsedArgs);
      return;
    }
    if (parsedArgs.ropBlocks)
    {
      BlockDumper.dump(paramArrayOfByte, System.out, paramString, true, parsedArgs);
      return;
    }
    if (parsedArgs.ssaBlocks)
    {
      parsedArgs.optimize = false;
      SsaDumper.dump(paramArrayOfByte, System.out, paramString, parsedArgs);
      return;
    }
    ClassDumper.dump(paramArrayOfByte, System.out, paramString, parsedArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dump.Main
 * JD-Core Version:    0.7.0.1
 */