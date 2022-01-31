package android.support.v7.widget;

class AdapterHelper$UpdateOp
{
  static final int ADD = 1;
  static final int MOVE = 8;
  static final int POOL_SIZE = 30;
  static final int REMOVE = 2;
  static final int UPDATE = 4;
  int cmd;
  int itemCount;
  Object payload;
  int positionStart;
  
  AdapterHelper$UpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    this.cmd = paramInt1;
    this.positionStart = paramInt2;
    this.itemCount = paramInt3;
    this.payload = paramObject;
  }
  
  String cmdToString()
  {
    switch (this.cmd)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return "??";
    case 1: 
      return "add";
    case 2: 
      return "rm";
    case 4: 
      return "up";
    }
    return "mv";
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        do
        {
          return true;
          if ((paramObject == null) || (getClass() != paramObject.getClass())) {
            return false;
          }
          paramObject = (UpdateOp)paramObject;
          if (this.cmd != paramObject.cmd) {
            return false;
          }
        } while ((this.cmd == 8) && (Math.abs(this.itemCount - this.positionStart) == 1) && (this.itemCount == paramObject.positionStart) && (this.positionStart == paramObject.itemCount));
        if (this.itemCount != paramObject.itemCount) {
          return false;
        }
        if (this.positionStart != paramObject.positionStart) {
          return false;
        }
        if (this.payload == null) {
          break;
        }
      } while (this.payload.equals(paramObject.payload));
      return false;
    } while (paramObject.payload == null);
    return false;
  }
  
  public int hashCode()
  {
    return (this.cmd * 31 + this.positionStart) * 31 + this.itemCount;
  }
  
  public String toString()
  {
    return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.AdapterHelper.UpdateOp
 * JD-Core Version:    0.7.0.1
 */