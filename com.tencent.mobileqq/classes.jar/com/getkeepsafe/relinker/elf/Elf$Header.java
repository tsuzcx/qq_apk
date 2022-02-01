package com.getkeepsafe.relinker.elf;

public abstract class Elf$Header
{
  public boolean a;
  public int b;
  public long c;
  public long d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public abstract Elf.DynamicStructure a(long paramLong, int paramInt);
  
  public abstract Elf.ProgramHeader a(long paramLong);
  
  public abstract Elf.SectionHeader a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Elf.Header
 * JD-Core Version:    0.7.0.1
 */