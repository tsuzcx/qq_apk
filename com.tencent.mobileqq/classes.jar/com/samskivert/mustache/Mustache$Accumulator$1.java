package com.samskivert.mustache;

import java.util.List;

class Mustache$Accumulator$1
  extends Mustache.Accumulator
{
  Mustache$Accumulator$1(Mustache.Accumulator paramAccumulator1, Mustache.Compiler paramCompiler, boolean paramBoolean, String paramString, int paramInt, Mustache.Accumulator paramAccumulator2)
  {
    super(paramCompiler, paramBoolean);
  }
  
  protected Mustache.Accumulator addCloseSectionSegment(String paramString, int paramInt)
  {
    requireSameName(this.val$tag1, paramString, paramInt);
    this.val$outer._segs.add(new Mustache.SectionSegment(this._comp, paramString, super.finish(), this.val$tagLine));
    return this.val$outer;
  }
  
  public Template.Segment[] finish()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Section missing close tag '");
    localStringBuilder.append(this.val$tag1);
    localStringBuilder.append("'");
    throw new MustacheParseException(localStringBuilder.toString(), this.val$tagLine);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.Accumulator.1
 * JD-Core Version:    0.7.0.1
 */