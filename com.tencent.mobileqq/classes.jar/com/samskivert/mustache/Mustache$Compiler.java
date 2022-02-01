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
    String str = this.nullValue;
    if (str == null) {
      return null;
    }
    return str.replace("{{name}}", paramString);
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
    Mustache.Escaper localEscaper;
    if (paramBoolean) {
      localEscaper = Escapers.HTML;
    } else {
      localEscaper = Escapers.NONE;
    }
    return withEscaper(localEscaper);
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
    //   32: ifnull +21 -> 53
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
    //   53: aload 5
    //   55: areturn
    //   56: astore_1
    //   57: goto +70 -> 127
    //   60: astore 4
    //   62: aload_3
    //   63: astore_2
    //   64: aload 4
    //   66: instanceof 130
    //   69: ifeq +11 -> 80
    //   72: aload_3
    //   73: astore_2
    //   74: aload 4
    //   76: checkcast 130	java/lang/RuntimeException
    //   79: athrow
    //   80: aload_3
    //   81: astore_2
    //   82: new 135	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   89: astore 5
    //   91: aload_3
    //   92: astore_2
    //   93: aload 5
    //   95: ldc 138
    //   97: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_3
    //   102: astore_2
    //   103: aload 5
    //   105: aload_1
    //   106: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_3
    //   111: astore_2
    //   112: new 144	com/samskivert/mustache/MustacheException
    //   115: dup
    //   116: aload 5
    //   118: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aload 4
    //   123: invokespecial 151	com/samskivert/mustache/MustacheException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: athrow
    //   127: aload_2
    //   128: ifnull +20 -> 148
    //   131: aload_2
    //   132: invokevirtual 128	java/io/Reader:close	()V
    //   135: goto +13 -> 148
    //   138: astore_1
    //   139: new 130	java/lang/RuntimeException
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 133	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   147: athrow
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	Compiler
    //   0	150	1	paramString	String
    //   3	129	2	localObject1	Object
    //   1	110	3	localObject2	Object
    //   14	22	4	localReader	Reader
    //   60	62	4	localException	java.lang.Exception
    //   28	89	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	40	43	java/io/IOException
    //   4	16	56	finally
    //   22	30	56	finally
    //   64	72	56	finally
    //   74	80	56	finally
    //   82	91	56	finally
    //   93	101	56	finally
    //   103	110	56	finally
    //   112	127	56	finally
    //   4	16	60	java/lang/Exception
    //   22	30	60	java/lang/Exception
    //   131	135	138	java/io/IOException
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