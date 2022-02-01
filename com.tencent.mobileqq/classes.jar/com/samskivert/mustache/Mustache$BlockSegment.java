package com.samskivert.mustache;

import java.io.Writer;

public abstract class Mustache$BlockSegment
  extends Mustache.NamedSegment
{
  protected final Template.Segment[] _segs;
  
  protected Mustache$BlockSegment(String paramString, Template.Segment[] paramArrayOfSegment, int paramInt)
  {
    super(paramString, paramInt);
    this._segs = Mustache.trim(paramArrayOfSegment, false);
  }
  
  protected void executeSegs(Template paramTemplate, Template.Context paramContext, Writer paramWriter)
  {
    Template.Segment[] arrayOfSegment = this._segs;
    int j = arrayOfSegment.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSegment[i].execute(paramTemplate, paramContext, paramWriter);
      i += 1;
    }
  }
  
  public boolean firstLeadsBlank()
  {
    if ((this._segs.length == 0) || (!(this._segs[0] instanceof Mustache.StringSegment))) {
      return false;
    }
    return ((Mustache.StringSegment)this._segs[0]).leadsBlank();
  }
  
  public boolean lastTrailsBlank()
  {
    int i = this._segs.length - 1;
    if ((this._segs.length == 0) || (!(this._segs[i] instanceof Mustache.StringSegment))) {
      return false;
    }
    return ((Mustache.StringSegment)this._segs[i]).trailsBlank();
  }
  
  public void trimFirstBlank()
  {
    this._segs[0] = ((Mustache.StringSegment)this._segs[0]).trimLeadBlank();
  }
  
  public void trimLastBlank()
  {
    int i = this._segs.length - 1;
    this._segs[i] = ((Mustache.StringSegment)this._segs[i]).trimTrailBlank();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.BlockSegment
 * JD-Core Version:    0.7.0.1
 */