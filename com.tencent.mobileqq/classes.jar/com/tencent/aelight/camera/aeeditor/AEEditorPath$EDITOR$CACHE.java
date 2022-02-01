package com.tencent.aelight.camera.aeeditor;

import com.tencent.aelight.camera.ae.AEPathBase.BASE;
import java.io.File;

public class AEEditorPath$EDITOR$CACHE
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPathBase.BASE.c);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ae_editor");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("compress");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("bgm");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("comic");
    d = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.CACHE
 * JD-Core Version:    0.7.0.1
 */