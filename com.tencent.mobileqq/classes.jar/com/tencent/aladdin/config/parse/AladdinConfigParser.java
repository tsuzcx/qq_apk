package com.tencent.aladdin.config.parse;

import java.io.Reader;
import java.util.Map;

public abstract interface AladdinConfigParser
{
  public abstract Map<String, ?> parse(Reader paramReader);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.parse.AladdinConfigParser
 * JD-Core Version:    0.7.0.1
 */