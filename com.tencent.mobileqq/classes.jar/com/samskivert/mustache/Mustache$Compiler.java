package com.samskivert.mustache;

import java.io.Reader;
import java.io.StringReader;

public class Mustache$Compiler
{
  public final Mustache.Collector collector;
  public final Mustache.Delims delims;
  public final boolean emptyStringIsFalse;
  public final Mustache.Escaper escaper;
  public final Mustache.Formatter formatter;
  public final Mustache.TemplateLoader loader;
  public final boolean missingIsNull;
  public final String nullValue;
  public final boolean standardsMode;
  public final boolean strictSections;
  public final boolean zeroIsFalse;
  
  protected Mustache$Compiler(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, Mustache.Formatter paramFormatter, Mustache.Escaper paramEscaper, Mustache.TemplateLoader paramTemplateLoader, Mustache.Collector paramCollector, Mustache.Delims paramDelims)
  {
    this.standardsMode = paramBoolean1;
    this.strictSections = paramBoolean2;
    this.nullValue = paramString;
    this.missingIsNull = paramBoolean3;
    this.emptyStringIsFalse = paramBoolean4;
    this.zeroIsFalse = paramBoolean5;
    this.formatter = paramFormatter;
    this.escaper = paramEscaper;
    this.loader = paramTemplateLoader;
    this.collector = paramCollector;
    this.delims = paramDelims;
  }
  
  public Template compile(Reader paramReader)
  {
    return Mustache.compile(paramReader, this);
  }
  
  public Template compile(String paramString)
  {
    return compile(new StringReader(paramString));
  }
  
  public String computeNullValue(String paramString)
  {
    if (this.nullValue == null) {
      return null;
    }
    return this.nullValue.replace("{{name}}", paramString);
  }
  
  public Compiler defaultValue(String paramString)
  {
    return new Compiler(this.standardsMode, this.strictSections, paramString, true, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, this.delims);
  }
  
  public Compiler emptyStringIsFalse(boolean paramBoolean)
  {
    return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, paramBoolean, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, this.delims);
  }
  
  public Compiler escapeHTML(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Mustache.Escaper localEscaper = Escapers.HTML;; localEscaper = Escapers.NONE) {
      return withEscaper(localEscaper);
    }
  }
  
  public boolean isFalsey(Object paramObject)
  {
    return ((this.emptyStringIsFalse) && ("".equals(this.formatter.format(paramObject)))) || ((this.zeroIsFalse) && ((paramObject instanceof Number)) && (((Number)paramObject).longValue() == 0L));
  }
  
  /* Error */
  public Template loadTemplate(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 45	com/samskivert/mustache/Mustache$Compiler:loader	Lcom/samskivert/mustache/Mustache$TemplateLoader;
    //   8: aload_1
    //   9: invokeinterface 123 2 0
    //   14: astore 4
    //   16: aload 4
    //   18: astore_2
    //   19: aload 4
    //   21: astore_3
    //   22: aload_0
    //   23: aload 4
    //   25: invokevirtual 65	com/samskivert/mustache/Mustache$Compiler:compile	(Ljava/io/Reader;)Lcom/samskivert/mustache/Template;
    //   28: astore 5
    //   30: aload 4
    //   32: ifnull +8 -> 40
    //   35: aload 4
    //   37: invokevirtual 128	java/io/Reader:close	()V
    //   40: aload 5
    //   42: areturn
    //   43: astore_1
    //   44: new 130	java/lang/RuntimeException
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 133	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   52: athrow
    //   53: astore 4
    //   55: aload_2
    //   56: astore_3
    //   57: aload 4
    //   59: instanceof 130
    //   62: ifeq +22 -> 84
    //   65: aload_2
    //   66: astore_3
    //   67: aload 4
    //   69: checkcast 130	java/lang/RuntimeException
    //   72: athrow
    //   73: astore_1
    //   74: aload_3
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: invokevirtual 128	java/io/Reader:close	()V
    //   82: aload_1
    //   83: athrow
    //   84: aload_2
    //   85: astore_3
    //   86: new 135	com/samskivert/mustache/MustacheException
    //   89: dup
    //   90: new 137	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   97: ldc 140
    //   99: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: aload 4
    //   111: invokespecial 151	com/samskivert/mustache/MustacheException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   114: athrow
    //   115: astore_1
    //   116: new 130	java/lang/RuntimeException
    //   119: dup
    //   120: aload_1
    //   121: invokespecial 133	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	Compiler
    //   0	125	1	paramString	String
    //   3	82	2	localObject1	Object
    //   1	85	3	localObject2	Object
    //   14	22	4	localReader	Reader
    //   53	57	4	localException	java.lang.Exception
    //   28	13	5	localTemplate	Template
    // Exception table:
    //   from	to	target	type
    //   35	40	43	java/io/IOException
    //   4	16	53	java/lang/Exception
    //   22	30	53	java/lang/Exception
    //   4	16	73	finally
    //   22	30	73	finally
    //   57	65	73	finally
    //   67	73	73	finally
    //   86	115	73	finally
    //   78	82	115	java/io/IOException
  }
  
  public Compiler nullValue(String paramString)
  {
    return new Compiler(this.standardsMode, this.strictSections, paramString, false, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, this.delims);
  }
  
  public Compiler standardsMode(boolean paramBoolean)
  {
    return new Compiler(paramBoolean, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, this.delims);
  }
  
  public Compiler strictSections(boolean paramBoolean)
  {
    return new Compiler(this.standardsMode, paramBoolean, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, this.delims);
  }
  
  public Compiler withCollector(Mustache.Collector paramCollector)
  {
    return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, paramCollector, this.delims);
  }
  
  public Compiler withDelims(String paramString)
  {
    return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, new Mustache.Delims().updateDelims(paramString));
  }
  
  public Compiler withEscaper(Mustache.Escaper paramEscaper)
  {
    return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, paramEscaper, this.loader, this.collector, this.delims);
  }
  
  public Compiler withFormatter(Mustache.Formatter paramFormatter)
  {
    return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, paramFormatter, this.escaper, this.loader, this.collector, this.delims);
  }
  
  public Compiler withLoader(Mustache.TemplateLoader paramTemplateLoader)
  {
    return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, paramTemplateLoader, this.collector, this.delims);
  }
  
  public Compiler zeroIsFalse(boolean paramBoolean)
  {
    return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, paramBoolean, this.formatter, this.escaper, this.loader, this.collector, this.delims);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.Compiler
 * JD-Core Version:    0.7.0.1
 */