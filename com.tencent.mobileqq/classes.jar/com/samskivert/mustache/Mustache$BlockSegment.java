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
    Template.Segment[] arrayOfSegment = this._segs;
    if (arrayOfSegment.length != 0)
    {
      if (!(arrayOfSegment[0] instanceof Mustache.StringSegment)) {
        return false;
      }
      return ((Mustache.StringSegment)arrayOfSegment[0]).leadsBlank();
    }
    return false;
  }
  
  public boolean lastTrailsBlank()
  {
    Template.Segment[] arrayOfSegment = this._segs;
    int i = arrayOfSegment.length - 1;
    if ((arrayOfSegment.length != 0) && ((arrayOfSegment[i] instanceof Mustache.StringSegment))) {
      return ((Mustache.StringSegment)arrayOfSegment[i]).trailsBlank();
    }
    return false;
  }
  
  public void trimFirstBlank()
  {
    Template.Segment[] arrayOfSegment = this._segs;
    arrayOfSegment[0] = ((Mustache.StringSegment)arrayOfSegment[0]).trimLeadBlank();
  }
  
  public void trimLastBlank()
  {
    Template.Segment[] arrayOfSegment = this._segs;
    int i = arrayOfSegment.length - 1;
    arrayOfSegment[i] = ((Mustache.StringSegment)arrayOfSegment[i]).trimTrailBlank();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.BlockSegment
 * JD-Core Version:    0.7.0.1
 */