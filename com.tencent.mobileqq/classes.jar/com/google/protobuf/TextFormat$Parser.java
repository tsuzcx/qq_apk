package com.google.protobuf;

public class TextFormat$Parser
{
  private final boolean a;
  private final boolean b;
  private final boolean c;
  private final TextFormat.Parser.SingularOverwritePolicy d;
  private TextFormatParseInfoTree.Builder e;
  
  private TextFormat$Parser(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TextFormat.Parser.SingularOverwritePolicy paramSingularOverwritePolicy, TextFormatParseInfoTree.Builder paramBuilder)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramSingularOverwritePolicy;
    this.e = paramBuilder;
  }
  
  public static TextFormat.Parser.Builder a()
  {
    return new TextFormat.Parser.Builder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.TextFormat.Parser
 * JD-Core Version:    0.7.0.1
 */