package com.android.dx.rop.cst;

public final class CstArray
  extends Constant
{
  private final CstArray.List list;
  
  public CstArray(CstArray.List paramList)
  {
    if (paramList == null) {
      throw new NullPointerException("list == null");
    }
    paramList.throwIfMutable();
    this.list = paramList;
  }
  
  protected int compareTo0(Constant paramConstant)
  {
    return this.list.compareTo(((CstArray)paramConstant).list);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CstArray)) {
      return false;
    }
    return this.list.equals(((CstArray)paramObject).list);
  }
  
  public CstArray.List getList()
  {
    return this.list;
  }
  
  public int hashCode()
  {
    return this.list.hashCode();
  }
  
  public boolean isCategory2()
  {
    return false;
  }
  
  public String toHuman()
  {
    return this.list.toHuman("{", ", ", "}");
  }
  
  public String toString()
  {
    return this.list.toString("array{", ", ", "}");
  }
  
  public String typeName()
  {
    return "array";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstArray
 * JD-Core Version:    0.7.0.1
 */