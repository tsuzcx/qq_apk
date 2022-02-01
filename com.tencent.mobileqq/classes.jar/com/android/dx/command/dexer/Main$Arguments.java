package com.android.dx.command.dexer;

import com.android.dex.util.FileUtils;
import com.android.dx.command.DxConsole;
import com.android.dx.command.UsageException;
import com.android.dx.dex.DexOptions;
import com.android.dx.dex.cf.CfOptions;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main$Arguments
{
  private static final String INCREMENTAL_OPTION = "--incremental";
  private static final String INPUT_LIST_OPTION = "--input-list";
  private static final String MAIN_DEX_LIST_OPTION = "--main-dex-list";
  private static final String MINIMAL_MAIN_DEX_OPTION = "--minimal-main-dex";
  private static final String MULTI_DEX_OPTION = "--multi-dex";
  private static final String NUM_THREADS_OPTION = "--num-threads";
  public CfOptions cfOptions;
  public boolean coreLibrary = false;
  public boolean debug = false;
  public DexOptions dexOptions;
  public String dontOptimizeListFile = null;
  public int dumpWidth = 0;
  public boolean emptyOk = false;
  public String[] fileNames;
  public boolean forceJumbo = false;
  public String humanOutName = null;
  public boolean incremental = false;
  private List<String> inputList = null;
  public boolean jarOutput = false;
  public boolean keepClassesInJar = false;
  public boolean localInfo = true;
  public String mainDexListFile = null;
  private int maxNumberOfIdxPerDex = 65536;
  public String methodToDump = null;
  public boolean minimalMainDex = false;
  public boolean multiDex = false;
  public int numThreads = 1;
  public boolean optimize = true;
  public String optimizeListFile = null;
  public String outName = null;
  public int positionInfo = 2;
  public boolean statistics;
  public boolean strictNameCheck = true;
  public boolean verbose = false;
  public boolean verboseDump = false;
  public boolean warnings = true;
  
  private void makeOptionsObjects()
  {
    this.cfOptions = new CfOptions();
    this.cfOptions.positionInfo = this.positionInfo;
    this.cfOptions.localInfo = this.localInfo;
    this.cfOptions.strictNameCheck = this.strictNameCheck;
    this.cfOptions.optimize = this.optimize;
    this.cfOptions.optimizeListFile = this.optimizeListFile;
    this.cfOptions.dontOptimizeListFile = this.dontOptimizeListFile;
    this.cfOptions.statistics = this.statistics;
    if (this.warnings) {}
    for (this.cfOptions.warn = DxConsole.err;; this.cfOptions.warn = DxConsole.noop)
    {
      this.dexOptions = new DexOptions();
      this.dexOptions.forceJumbo = this.forceJumbo;
      return;
    }
  }
  
  public void parse(String[] paramArrayOfString)
  {
    paramArrayOfString = new Main.Arguments.ArgumentsParser(paramArrayOfString);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (!paramArrayOfString.getNext()) {
        break label872;
      }
      if (paramArrayOfString.isArg("--debug"))
      {
        this.debug = true;
      }
      else if (paramArrayOfString.isArg("--no-warning"))
      {
        this.warnings = false;
      }
      else if (paramArrayOfString.isArg("--verbose"))
      {
        this.verbose = true;
      }
      else if (paramArrayOfString.isArg("--verbose-dump"))
      {
        this.verboseDump = true;
      }
      else if (paramArrayOfString.isArg("--no-files"))
      {
        this.emptyOk = true;
      }
      else if (paramArrayOfString.isArg("--no-optimize"))
      {
        this.optimize = false;
      }
      else if (paramArrayOfString.isArg("--no-strict"))
      {
        this.strictNameCheck = false;
      }
      else if (paramArrayOfString.isArg("--core-library"))
      {
        this.coreLibrary = true;
      }
      else if (paramArrayOfString.isArg("--statistics"))
      {
        this.statistics = true;
      }
      else if (paramArrayOfString.isArg("--optimize-list="))
      {
        if (this.dontOptimizeListFile != null)
        {
          System.err.println("--optimize-list and --no-optimize-list are incompatible.");
          throw new UsageException();
        }
        this.optimize = true;
        this.optimizeListFile = paramArrayOfString.getLastValue();
      }
      else if (paramArrayOfString.isArg("--no-optimize-list="))
      {
        if (this.dontOptimizeListFile != null)
        {
          System.err.println("--optimize-list and --no-optimize-list are incompatible.");
          throw new UsageException();
        }
        this.optimize = true;
        this.dontOptimizeListFile = paramArrayOfString.getLastValue();
      }
      else if (paramArrayOfString.isArg("--keep-classes"))
      {
        this.keepClassesInJar = true;
      }
      else if (paramArrayOfString.isArg("--output="))
      {
        this.outName = paramArrayOfString.getLastValue();
        if (new File(this.outName).isDirectory())
        {
          this.jarOutput = false;
          i = 1;
        }
        else if (FileUtils.hasArchiveSuffix(this.outName))
        {
          this.jarOutput = true;
        }
        else if ((this.outName.endsWith(".dex")) || (this.outName.equals("-")))
        {
          this.jarOutput = false;
          j = 1;
        }
        else
        {
          System.err.println("unknown output extension: " + this.outName);
          throw new UsageException();
        }
      }
      else if (paramArrayOfString.isArg("--dump-to="))
      {
        this.humanOutName = paramArrayOfString.getLastValue();
      }
      else if (paramArrayOfString.isArg("--dump-width="))
      {
        this.dumpWidth = Integer.parseInt(paramArrayOfString.getLastValue());
      }
      else if (paramArrayOfString.isArg("--dump-method="))
      {
        this.methodToDump = paramArrayOfString.getLastValue();
        this.jarOutput = false;
      }
      else
      {
        Object localObject;
        if (paramArrayOfString.isArg("--positions="))
        {
          localObject = paramArrayOfString.getLastValue().intern();
          if (localObject == "none")
          {
            this.positionInfo = 1;
          }
          else if (localObject == "important")
          {
            this.positionInfo = 3;
          }
          else if (localObject == "lines")
          {
            this.positionInfo = 2;
          }
          else
          {
            System.err.println("unknown positions option: " + (String)localObject);
            throw new UsageException();
          }
        }
        else if (paramArrayOfString.isArg("--no-locals"))
        {
          this.localInfo = false;
        }
        else if (paramArrayOfString.isArg("--num-threads="))
        {
          this.numThreads = Integer.parseInt(paramArrayOfString.getLastValue());
        }
        else if (paramArrayOfString.isArg("--incremental"))
        {
          this.incremental = true;
        }
        else if (paramArrayOfString.isArg("--force-jumbo"))
        {
          this.forceJumbo = true;
        }
        else if (paramArrayOfString.isArg("--multi-dex"))
        {
          this.multiDex = true;
        }
        else if (paramArrayOfString.isArg("--main-dex-list="))
        {
          this.mainDexListFile = paramArrayOfString.getLastValue();
        }
        else if (paramArrayOfString.isArg("--minimal-main-dex"))
        {
          this.minimalMainDex = true;
        }
        else if (paramArrayOfString.isArg("--set-max-idx-number="))
        {
          this.maxNumberOfIdxPerDex = Integer.parseInt(paramArrayOfString.getLastValue());
        }
        else if (paramArrayOfString.isArg("--input-list="))
        {
          localObject = new File(paramArrayOfString.getLastValue());
          try
          {
            this.inputList = new ArrayList();
            Main.access$1100(((File)localObject).getAbsolutePath(), this.inputList);
          }
          catch (IOException paramArrayOfString)
          {
            System.err.println("Unable to read input list file: " + ((File)localObject).getName());
            throw new UsageException();
          }
        }
      }
    }
    System.err.println("unknown option: " + paramArrayOfString.getCurrent());
    throw new UsageException();
    label872:
    this.fileNames = paramArrayOfString.getRemaining();
    if ((this.inputList != null) && (!this.inputList.isEmpty()))
    {
      this.inputList.addAll(Arrays.asList(this.fileNames));
      this.fileNames = ((String[])this.inputList.toArray(new String[this.inputList.size()]));
    }
    if (this.fileNames.length == 0)
    {
      if (!this.emptyOk)
      {
        System.err.println("no input files specified");
        throw new UsageException();
      }
    }
    else if (this.emptyOk) {
      System.out.println("ignoring input files");
    }
    if ((this.humanOutName == null) && (this.methodToDump != null)) {
      this.humanOutName = "-";
    }
    if ((this.mainDexListFile != null) && (!this.multiDex))
    {
      System.err.println("--main-dex-list is only supported in combination with --multi-dex");
      throw new UsageException();
    }
    if ((this.minimalMainDex) && ((this.mainDexListFile == null) || (!this.multiDex)))
    {
      System.err.println("--minimal-main-dex is only supported in combination with --multi-dex and --main-dex-list");
      throw new UsageException();
    }
    if ((this.multiDex) && (this.incremental))
    {
      System.err.println("--incremental is not supported with --multi-dex");
      throw new UsageException();
    }
    if ((this.multiDex) && (j != 0))
    {
      System.err.println("Unsupported output \"" + this.outName + "\". " + "--multi-dex" + " supports only archive or directory output");
      throw new UsageException();
    }
    if ((i != 0) && (!this.multiDex)) {
      this.outName = new File(this.outName, "classes.dex").getPath();
    }
    makeOptionsObjects();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.Arguments
 * JD-Core Version:    0.7.0.1
 */