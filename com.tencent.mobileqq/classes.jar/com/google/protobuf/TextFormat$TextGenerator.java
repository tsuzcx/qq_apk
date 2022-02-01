package com.google.protobuf;

final class TextFormat$TextGenerator
{
  private final Appendable a;
  private final StringBuilder b = new StringBuilder();
  private final boolean c;
  private boolean d = false;
  
  private TextFormat$TextGenerator(Appendable paramAppendable, boolean paramBoolean)
  {
    this.a = paramAppendable;
    this.c = paramBoolean;
  }
  
  public void a()
  {
    this.b.append("  ");
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.d)
    {
      this.d = false;
      Appendable localAppendable = this.a;
      Object localObject;
      if (this.c) {
        localObject = " ";
      } else {
        localObject = this.b;
      }
      localAppendable.append((CharSequence)localObject);
    }
    this.a.append(paramCharSequence);
  }
  
  public void b()
  {
    int i = this.b.length();
    if (i != 0)
    {
      this.b.setLength(i - 2);
      return;
    }
    throw new IllegalArgumentException(" Outdent() without matching Indent().");
  }
  
  public void c()
  {
    if (!this.c) {
      this.a.append("\n");
    }
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.TextFormat.TextGenerator
 * JD-Core Version:    0.7.0.1
 */