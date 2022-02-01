package com.google.protobuf;

import java.util.regex.Pattern;

final class TextFormat$Tokenizer
{
  private static final Pattern a = Pattern.compile("(\\s|(#.*$))++", 8);
  private static final Pattern b = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
  private static final Pattern c = Pattern.compile("-?inf(inity)?", 2);
  private static final Pattern d = Pattern.compile("-?inf(inity)?f?", 2);
  private static final Pattern e = Pattern.compile("nanf?", 2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.TextFormat.Tokenizer
 * JD-Core Version:    0.7.0.1
 */