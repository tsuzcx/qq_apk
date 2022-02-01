package com.samskivert.mustache;

public abstract class Mustache$NamedSegment
  extends Template.Segment
{
  protected final int _line;
  protected final String _name;
  
  protected Mustache$NamedSegment(String paramString, int paramInt)
  {
    this._name = paramString;
    this._line = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.NamedSegment
 * JD-Core Version:    0.7.0.1
 */